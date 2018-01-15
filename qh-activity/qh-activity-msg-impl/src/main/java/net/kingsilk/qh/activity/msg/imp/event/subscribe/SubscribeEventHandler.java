package net.kingsilk.qh.activity.msg.imp.event.subscribe;


import io.swagger.annotations.ApiParam;
import net.kingsilk.qh.activity.domain.VoteActivity;
import net.kingsilk.qh.activity.msg.imp.AbstractJobImpl;
import net.kingsilk.qh.activity.repo.VoteActivityRepo;
import net.kingsilk.qh.activity.service.QhActivityProperties;
import net.kingsilk.qh.activity.service.service.VoteRecordService;
import net.kingsilk.wx4j.broker.Q;
import net.kingsilk.wx4j.broker.api.UniResp;
import net.kingsilk.wx4j.broker.api.wxCom.mp.at.WxComMpAtApi;
import net.kingsilk.wx4j.broker.api.wxCom.mp.scence.ScenceInfoResp;
import net.kingsilk.wx4j.broker.api.wxCom.mp.scence.WxScenceApi;
import net.kingsilk.wx4j.broker.api.wxCom.mp.user.GetResp;
import net.kingsilk.wx4j.broker.api.wxCom.mp.user.WxComMpUserApi;
import net.kingsilk.wx4j.broker.msg.api.wx4j.client.com.mp.push.msg.event.subscribe.SubscribeEventEx;
import net.kingsilk.wx4j.broker.msg.api.wx4j.client.com.mp.push.msg.event.subscribe.SubscribeEventExApi;
import net.kingsilk.wx4j.client.mp.api.kfMsg.KfMsgApi;
import net.kingsilk.wx4j.client.mp.api.kfMsg.TextMsgReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component("ActivitySubscribeEventExApi")
public class SubscribeEventHandler extends AbstractJobImpl implements SubscribeEventExApi {

    @Autowired
    private WxComMpAtApi wxComMpAtApi;

    @Autowired
    private KfMsgApi kfMsgApi;

    @Autowired
    private WxComMpUserApi wxComMpUserApi;

    @Autowired
    private QhActivityProperties qhActivityProperties;

    @Autowired
    private VoteRecordService voteRecordService;

    @Autowired
    private WxScenceApi wxScenceApi;

    @Autowired
    private VoteActivityRepo voteActivityRepo;


    public String getLockKey(SubscribeEventEx event) {
        StringBuffer buf = new StringBuffer();
        buf
                .append(Q.MQ_EXCHANGE_PREFIX)
                .append("/").append(SubscribeEventEx.class.getName())
                .append("/").append(event.getWxComAppId());
        return buf.toString();
    }


    @Override
    public void handle(SubscribeEventEx msgEx) {

        String lockKey = getLockKey(msgEx);
        long waitLockTime = qhActivityProperties.getMq().getDefaultConf().getLockWaitTime();
        lockAndExec(lockKey, waitLockTime, () -> {

            // TODO 要避免重复发送
            net.kingsilk.wx4j.broker.api.UniResp<net.kingsilk.wx4j.broker.api.wxCom.mp.at.GetResp> respUniResp =
                    wxComMpAtApi.get(msgEx.getWxComAppId(), msgEx.getWxMpAppId());

            TextMsgReq req = new TextMsgReq();
            req.setMsgType("text");
            req.setToUser(msgEx.getMsg().getFromUserName());

            net.kingsilk.wx4j.broker.api.UniResp<GetResp> wxResp
                    = wxComMpUserApi.get(respUniResp.getData().getWxComAppId(), respUniResp.getData().getWxMpAppId(), msgEx.getMsg().getFromUserName());

            //调取微信4j的场景得到值接口，应该需要作品url，直接调用投票接口
            if (!StringUtils.isEmpty(msgEx.getMsg().getEventKey())) {
                String scenceId = msgEx.getMsg().getEventKey().substring(8);
                UniResp<ScenceInfoResp> uniResp =
                        wxScenceApi.get(msgEx.getWxComAppId(), msgEx.getWxMpAppId(), Integer.valueOf(scenceId));
                if (uniResp.getData().getSenceData().get("workId") != "" && uniResp.getData().getSenceData().get("workId") != null) {
                    TextMsgReq.Text text = new TextMsgReq.Text();
                    text.setContent(wxResp.getData().getNickName() + "感谢你宝贵的一票，可以拉上好友一起为我投票，么么哒" + "<p>" +
                            "<a href='" + uniResp.getData().getSenceData().get("shareUrl") + "'>分享</a></p>");
                    req.setText(text);
                    kfMsgApi.send(respUniResp.getData().getAccessToken(), req);
                    String brandAppId = uniResp.getData().getSenceData().get("brandAppId").toString();
                    String workId = uniResp.getData().getSenceData().get("workId").toString();
                    String activityId = uniResp.getData().getSenceData().get("activityId").toString();
                    String curUserId = uniResp.getData().getSenceData().get("curUserId").toString();
                    voteRecordService.voteService(brandAppId, activityId, workId, msgEx.getWxComAppId(), msgEx.getWxMpAppId(), curUserId);
                } else {
                    String activityId = uniResp.getData().getSenceData().get("activityId").toString();
                    VoteActivity voteActivity = voteActivityRepo.findOne(activityId);
                    TextMsgReq.Text text = new TextMsgReq.Text();
                    text.setContent("耶，终于等到你！，" + voteActivity.getActivityName() + " 活动，正在火热进行中，赶快加入吧！请点击" +
                            "<a href='" + uniResp.getData().getSenceData().get("shareUrl") + "'>去报名</a>");
                    req.setText(text);
                    kfMsgApi.send(respUniResp.getData().getAccessToken(), req);
                }
            }
        });
    }
}

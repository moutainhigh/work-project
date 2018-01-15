package net.kingsilk.qh.vote.domain;


import net.kingsilk.qh.vote.core.vote.VoteStatusEnum;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 投票活动
 */
@Document
public class VoteActivity extends Base {

    /**
     * brandAppId，根据platform系统生成
     */
    private String voteAppId;

    /**
     * 活动名称
     */
    private String voteActivityName;

    /**
     * 报名开始时间
     */
    private Date signUpStartTime;

    /**
     * 报名结束时间
     */
    private Date signUpEndTime;

    /**
     * 投票开始时间
     */
    private Date voteStartTime;

    /**
     * 投票结束时间
     */
    private Date voteEndTime;

    /**
     * 投票人每天最大允许的投票次数
     */
    private Integer maxVotePerDay;

    /**
     * 投票人累计总共最多投票次数
     * <p>
     * 示例：totalVoteCount=10， voteCountPerDay=3
     * 则能投票 3+3+3+1
     */
    private Integer totalVoteCount;

    /**
     * 参赛者每天能从同一个投票人获取的最大票数
     */
    private Integer maxTicketPerDay;

//    /**
//     * 参赛者累计能从同一个投票人获取的最大票数。
//     */
//    private  Integer totalTickect;

//    /**
//     * 投票类型（只能给一人投票，给限定个数人投票，不限定），枚举类
//     */
//    private VoteTypeEnum voteTypeEnum;

    /**
     * 每天能给多少个选手投票（只能给一人投票，给限定个数人投票，不限定），-1 代表不限定
     */
    private Integer votePeoplePerDay;

    /**
     * 强制输入手机号
     */
    private Boolean forcePhone;

    /**
     * 强制关注公众号
     */

    private Boolean forceFollow;

    /**
     * 是否需要审核
     */
    private Boolean mustCheck;

    /**
     * 活动主图
     */
    private String primaryImgUrl;

    /**
     * 比赛规则(副文本)
     */
    private String rule;


    /**
     * 活动图文(副文本)
     */
    private String desp;

    /**
     * 默认参赛感言
     */
    private String wordsOfThanks;

    /**
     *
     */

    /**
     * 分享标题
     */
    private String shareTitle;

    /**
     * 分享内容
     */
    private String shareContent;

    /**
     * 状态
     */
    private VoteStatusEnum voteStatusEnum;


    /**
     * 累计票数
     */
    private Integer totalVote;

    /**
     * 累计访问
     */
    private Integer totalVisit;

    /**
     * 参与人数
     */
    private Integer totalJoinPeople;


    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getVoteAppId() {
        return voteAppId;
    }

    public void setVoteAppId(String voteAppId) {
        this.voteAppId = voteAppId;
    }

    public String getVoteActivityName() {
        return voteActivityName;
    }

    public void setVoteActivityName(String voteActivityName) {
        this.voteActivityName = voteActivityName;
    }

    public Date getSignUpStartTime() {
        return signUpStartTime;
    }

    public void setSignUpStartTime(Date signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public Date getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(Date signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }

    public Date getVoteStartTime() {
        return voteStartTime;
    }

    public void setVoteStartTime(Date voteStartTime) {
        this.voteStartTime = voteStartTime;
    }

    public Date getVoteEndTime() {
        return voteEndTime;
    }

    public void setVoteEndTime(Date voteEndTime) {
        this.voteEndTime = voteEndTime;
    }

    public Integer getMaxVotePerDay() {
        return maxVotePerDay;
    }

    public void setMaxVotePerDay(Integer maxVotePerDay) {
        this.maxVotePerDay = maxVotePerDay;
    }

    public Integer getTotalVoteCount() {
        return totalVoteCount;
    }

    public void setTotalVoteCount(Integer totalVoteCount) {
        this.totalVoteCount = totalVoteCount;
    }

    public Integer getMaxTicketPerDay() {
        return maxTicketPerDay;
    }

    public void setMaxTicketPerDay(Integer maxTicketPerDay) {
        this.maxTicketPerDay = maxTicketPerDay;
    }

    public Integer getVotePeoplePerDay() {
        return votePeoplePerDay;
    }

    public void setVotePeoplePerDay(Integer votePeoplePerDay) {
        this.votePeoplePerDay = votePeoplePerDay;
    }

    public Boolean isForcePhone() {
        return forcePhone;
    }

    public void setForcePhone(Boolean forcePhone) {
        this.forcePhone = forcePhone;
    }

    public Boolean isForceFollow() {
        return forceFollow;
    }

    public void setForceFollow(Boolean forceFollow) {
        this.forceFollow = forceFollow;
    }

    public String getPrimaryImgUrl() {
        return primaryImgUrl;
    }

    public void setPrimaryImgUrl(String primaryImgUrl) {
        this.primaryImgUrl = primaryImgUrl;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getWordsOfThanks() {
        return wordsOfThanks;
    }

    public void setWordsOfThanks(String wordsOfThanks) {
        this.wordsOfThanks = wordsOfThanks;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public VoteStatusEnum getVoteStatusEnum() {
        return voteStatusEnum;
    }

    public void setVoteStatusEnum(VoteStatusEnum voteStatusEnum) {
        this.voteStatusEnum = voteStatusEnum;
    }

    public Integer getTotalVote() {
        return totalVote;
    }

    public void setTotalVote(Integer totalVote) {
        this.totalVote = totalVote;
    }

    public Integer getTotalVisit() {
        return totalVisit;
    }

    public void setTotalVisit(Integer totalVisit) {
        this.totalVisit = totalVisit;
    }

    public Integer getTotalJoinPeople() {
        return totalJoinPeople;
    }

    public void setTotalJoinPeople(Integer totalJoinPeople) {
        this.totalJoinPeople = totalJoinPeople;
    }

    public Boolean getMustCheck() {
        return mustCheck;
    }

    public void setMustCheck(Boolean mustCheck) {
        this.mustCheck = mustCheck;
    }
}

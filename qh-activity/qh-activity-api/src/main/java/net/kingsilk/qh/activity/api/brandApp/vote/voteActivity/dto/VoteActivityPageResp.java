package net.kingsilk.qh.activity.api.brandApp.vote.voteActivity.dto;

import net.kingsilk.qh.activity.api.common.dto.Base;
import net.kingsilk.qh.activity.core.vote.VoteStatusEnum;

public class VoteActivityPageResp extends Base {

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 参与人数
     */
    private String totalJoinPeople;

    /**
     * 累计票数
     */
    private String totalVote;

    /**
     * 累计访问
     */
    private String totalVisit;

    /**
     *
     */
    private Integer maxTicketPerDay;

    /**
     * 创建时间
     */
    private String creatTime;

    /**
     * 活动状态
     */
    private String activityStatus;


    /**
     * 活动分享内容
     */
    private String shareContent;

    /**
     * 活动分享标题
     */
    private String shareTitle;

    /**
     * 报名开始时间
     */
    private String signUpStartTime;

    /**
     * 报名结束时间
     */
    private String signUpEndTime;


    /**
     * 投票开始时间
     */
    private String voteStartTime;

    /**
     * 投票结束时间
     */
    private String voteEndTime;

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
     * 状态
     */
    private VoteStatusEnum voteStatusEnum;

    /**
     * 活动规则
     */
    private String rule;

    /**
     * 活动图文
     */
    private String desp;

    /**
     * 默认参赛感言
     */
    private String wordsOfThanks;


    /**
     * 投票人每天最大允许的投票次数
     */
    private Integer maxVotePerDay;


    /**
     * 每天能给多少个选手投票（只能给一人投票，给限定个数人投票，不限定），-1 代表不限定
     */
    private Integer votePeoplePerDay;


    /**
     * 投票人累计总共最多投票次数
     * <p>
     * 示例：totalVoteCount=10， voteCountPerDay=3
     * 则能投票 3+3+3+1
     */
    private Integer totalVoteCount;


    /**
     * 名次
     */
    private String ranking;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTotalJoinPeople() {
        return totalJoinPeople;
    }

    public void setTotalJoinPeople(String totalJoinPeople) {
        this.totalJoinPeople = totalJoinPeople;
    }

    public String getTotalVote() {
        return totalVote;
    }

    public void setTotalVote(String totalVote) {
        this.totalVote = totalVote;
    }

    public String getTotalVisit() {
        return totalVisit;
    }

    public void setTotalVisit(String totalVisit) {
        this.totalVisit = totalVisit;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getShareContent() {
        return shareContent;
    }

    public void setShareContent(String shareContent) {
        this.shareContent = shareContent;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    public void setSignUpEndTime(String signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }

    public String getPrimaryImgUrl() {
        return primaryImgUrl;
    }

    public void setSignUpStartTime(String signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public String getVoteStartTime() {
        return voteStartTime;
    }

    public void setVoteStartTime(String voteStartTime) {
        this.voteStartTime = voteStartTime;
    }

    public String getVoteEndTime() {
        return voteEndTime;
    }

    public void setVoteEndTime(String voteEndTime) {
        this.voteEndTime = voteEndTime;
    }

    public void setPrimaryImgUrl(String primaryImgUrl) {
        this.primaryImgUrl = primaryImgUrl;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public VoteStatusEnum getVoteStatusEnum() {
        return voteStatusEnum;
    }

    public void setVoteStatusEnum(VoteStatusEnum voteStatusEnum) {
        this.voteStatusEnum = voteStatusEnum;
    }

    public String getWordsOfThanks() {
        return wordsOfThanks;
    }

    public void setWordsOfThanks(String wordsOfThanks) {
        this.wordsOfThanks = wordsOfThanks;
    }

    public String getSignUpStartTime() {
        return signUpStartTime;
    }

    public String getSignUpEndTime() {
        return signUpEndTime;
    }


    public Integer getMaxVotePerDay() {
        return maxVotePerDay;
    }

    public void setMaxVotePerDay(Integer maxVotePerDay) {
        this.maxVotePerDay = maxVotePerDay;
    }


    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public Integer getMaxTicketPerDay() {
        return maxTicketPerDay;
    }

    public void setMaxTicketPerDay(Integer maxTicketPerDay) {
        this.maxTicketPerDay = maxTicketPerDay;
    }

    public Integer getTotalVoteCount() {
        return totalVoteCount;
    }

    public void setTotalVoteCount(Integer totalVoteCount) {
        this.totalVoteCount = totalVoteCount;
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

    public Boolean getMustCheck() {
        return mustCheck;
    }

    public void setMustCheck(Boolean mustCheck) {
        this.mustCheck = mustCheck;
    }
}

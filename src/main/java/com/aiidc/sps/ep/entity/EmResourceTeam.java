package com.aiidc.sps.ep.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "SPSUSER.EM_RESOURCE_TEAM")
public class EmResourceTeam
{
    @Id
    @Column(name = "TEAM_ID")
    private Long teamId;

    @Column(name = "COMPANY_ID")
    private String companyId;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "TEAM_ADDR")
    private String teamAddr;

    @Column(name = "AREA_ID")
    private String areaId;

    @Column(name = "TEAM_TYPE_ID")
    private String teamTypeId;

    @Column(name = "TEAM_LEVEL_ID")
    private String teamLevelId;

    @Column(name = "EVENT_TYPE_ID")
    private Short eventTypeId;

    @Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @Column(name = "QUALIFICATIONS")
    private String qualifications;

    @Column(name = "QUALIFICATIONS_NUM")
    private String qualificationsNum;

    @Column(name = "PEOPLE_NUM")
    private Short peopleNum;

    @Column(name = "FUNDING_SOURCES")
    private String fundingSources;

    @Column(name = "SQUADRON_NUM")
    private Short squadronNum;

    @Column(name = "TEAM_NUM")
    private Short teamNum;

    @Column(name = "EXPERTISE")
    private String expertise;

    @Column(name = "MAIN_MATERIAL")
    private String mainMaterial;

    @Column(name = "TEAM_HEAD")
    private String teamHead;

    @Column(name = "LEADER")
    private String leader;

    @Column(name = "HEAD_TEL")
    private String headTel;

    @Column(name = "LEADER_TEL")
    private String leaderTel;

    @Column(name = "HEAD_MOBILE")
    private String headMobile;

    @Column(name = "LEADER_MOBILE")
    private String leaderMobile;

    @Column(name = "DUTY_TEL")
    private String dutyTel;

    @Column(name = "DUTY_FAX")
    private String dutyFax;

    /**
     * @return TEAM_ID
     */
    public Long getTeamId() {
        return teamId;
    }

    /**
     * @param teamId
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * @return COMPANY_ID
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * @return TEAM_NAME
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return TEAM_ADDR
     */
    public String getTeamAddr() {
        return teamAddr;
    }

    /**
     * @param teamAddr
     */
    public void setTeamAddr(String teamAddr) {
        this.teamAddr = teamAddr;
    }

    /**
     * @return AREA_ID
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     * @param areaId
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     * @return TEAM_TYPE_ID
     */
    public String getTeamTypeId() {
        return teamTypeId;
    }

    /**
     * @param teamTypeId
     */
    public void setTeamTypeId(String teamTypeId) {
        this.teamTypeId = teamTypeId;
    }

    /**
     * @return TEAM_LEVEL_ID
     */
    public String getTeamLevelId() {
        return teamLevelId;
    }

    /**
     * @param teamLevelId
     */
    public void setTeamLevelId(String teamLevelId) {
        this.teamLevelId = teamLevelId;
    }

    /**
     * @return EVENT_TYPE_ID
     */
    public Short getEventTypeId() {
        return eventTypeId;
    }

    /**
     * @param eventTypeId
     */
    public void setEventTypeId(Short eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return QUALIFICATIONS
     */
    public String getQualifications() {
        return qualifications;
    }

    /**
     * @param qualifications
     */
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    /**
     * @return QUALIFICATIONS_NUM
     */
    public String getQualificationsNum() {
        return qualificationsNum;
    }

    /**
     * @param qualificationsNum
     */
    public void setQualificationsNum(String qualificationsNum) {
        this.qualificationsNum = qualificationsNum;
    }

    /**
     * @return PEOPLE_NUM
     */
    public Short getPeopleNum() {
        return peopleNum;
    }

    /**
     * @param peopleNum
     */
    public void setPeopleNum(Short peopleNum) {
        this.peopleNum = peopleNum;
    }

    /**
     * @return FUNDING_SOURCES
     */
    public String getFundingSources() {
        return fundingSources;
    }

    /**
     * @param fundingSources
     */
    public void setFundingSources(String fundingSources) {
        this.fundingSources = fundingSources;
    }

    /**
     * @return SQUADRON_NUM
     */
    public Short getSquadronNum() {
        return squadronNum;
    }

    /**
     * @param squadronNum
     */
    public void setSquadronNum(Short squadronNum) {
        this.squadronNum = squadronNum;
    }

    /**
     * @return TEAM_NUM
     */
    public Short getTeamNum() {
        return teamNum;
    }

    /**
     * @param teamNum
     */
    public void setTeamNum(Short teamNum) {
        this.teamNum = teamNum;
    }

    /**
     * @return EXPERTISE
     */
    public String getExpertise() {
        return expertise;
    }

    /**
     * @param expertise
     */
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    /**
     * @return MAIN_MATERIAL
     */
    public String getMainMaterial() {
        return mainMaterial;
    }

    /**
     * @param mainMaterial
     */
    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    /**
     * @return TEAM_HEAD
     */
    public String getTeamHead() {
        return teamHead;
    }

    /**
     * @param teamHead
     */
    public void setTeamHead(String teamHead) {
        this.teamHead = teamHead;
    }

    /**
     * @return LEADER
     */
    public String getLeader() {
        return leader;
    }

    /**
     * @param leader
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * @return HEAD_TEL
     */
    public String getHeadTel() {
        return headTel;
    }

    /**
     * @param headTel
     */
    public void setHeadTel(String headTel) {
        this.headTel = headTel;
    }

    /**
     * @return LEADER_TEL
     */
    public String getLeaderTel() {
        return leaderTel;
    }

    /**
     * @param leaderTel
     */
    public void setLeaderTel(String leaderTel) {
        this.leaderTel = leaderTel;
    }

    /**
     * @return HEAD_MOBILE
     */
    public String getHeadMobile() {
        return headMobile;
    }

    /**
     * @param headMobile
     */
    public void setHeadMobile(String headMobile) {
        this.headMobile = headMobile;
    }

    /**
     * @return LEADER_MOBILE
     */
    public String getLeaderMobile() {
        return leaderMobile;
    }

    /**
     * @param leaderMobile
     */
    public void setLeaderMobile(String leaderMobile) {
        this.leaderMobile = leaderMobile;
    }

    /**
     * @return DUTY_TEL
     */
    public String getDutyTel() {
        return dutyTel;
    }

    /**
     * @param dutyTel
     */
    public void setDutyTel(String dutyTel) {
        this.dutyTel = dutyTel;
    }

    /**
     * @return DUTY_FAX
     */
    public String getDutyFax() {
        return dutyFax;
    }

    /**
     * @param dutyFax
     */
    public void setDutyFax(String dutyFax) {
        this.dutyFax = dutyFax;
    }
}
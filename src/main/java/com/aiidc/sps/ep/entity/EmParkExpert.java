package com.aiidc.sps.ep.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "SPSUSER.EM_PARK_EXPERT")
public class   EmParkExpert implements Serializable
{
    private static final long serialVersionUID = -6393482196678537890L;
    @Id
    @Column(name = "EXPERT_ID")
    private Long expertId;

    @Column(name = "EXPERT_TYPE")
    private Short expertType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "NATION_CODE")
    private String nationCode;

    @Column(name = "AREA_ID")
    private String areaId;

    @Column(name = "EVENT_TYPE_ID")
    private Short eventTypeId;

    @Column(name = "POLITICAL_OUTLOOK")
    private String politicalOutlook;

    @Column(name = "PLACE_OF_ORIGIN")
    private String placeOfOrigin;

    @Column(name = "DOMICILE")
    private String domicile;

    @Column(name = "MAJOR")
    private String major;

    @Column(name = "HIGHEST_EDUCATION")
    private String highestEducation;

    @Column(name = "WORK_UNIT")
    private String workUnit;

    @Column(name = "UNIT_ADDR")
    private String unitAddr;

    @Column(name = "UNIVERSITY")
    private String university;

    @Column(name = "WORKING_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date workingTime;

    @Column(name = "POST")
    private String post;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "SPECIALTY")
    private String specialty;

    @Column(name = "OFFICE_PHONE")
    private String officePhone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;

    @Column(name = "HOME_PHONE")
    private String homePhone;

    @Column(name = "HOME_ADDR")
    private String homeAddr;

    @Column(name = "CHANGE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date changeDate;

    @Column(name = "PART_IN_INCI_HANDLING")
    private String partInInciHandling;

    public EmParkExpert(){
    }

    /**
     * @return EXPERT_ID
     */
    public Long getExpertId() {
        return expertId;
    }

    /**
     * @param expertId
     */
    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }

    /**
     * @return EXPERT_TYPE
     */
    public Short getExpertType() {
        return expertType;
    }

    /**
     * @param expertType
     */
    public void setExpertType(Short expertType) {
        this.expertType = expertType;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return SEX
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return NATION_CODE
     */
    public String getNationCode() {
        return nationCode;
    }

    /**
     * @param nationCode
     */
    public void setNationCode(String nationCode) {
        this.nationCode = nationCode;
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
     * @return POLITICAL_OUTLOOK
     */
    public String getPoliticalOutlook() {
        return politicalOutlook;
    }

    /**
     * @param politicalOutlook
     */
    public void setPoliticalOutlook(String politicalOutlook) {
        this.politicalOutlook = politicalOutlook;
    }

    /**
     * @return PLACE_OF_ORIGIN
     */
    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    /**
     * @param placeOfOrigin
     */
    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    /**
     * @return DOMICILE
     */
    public String getDomicile() {
        return domicile;
    }

    /**
     * @param domicile
     */
    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    /**
     * @return MAJOR
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return HIGHEST_EDUCATION
     */
    public String getHighestEducation() {
        return highestEducation;
    }

    /**
     * @param highestEducation
     */
    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    /**
     * @return WORK_UNIT
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * @param workUnit
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    /**
     * @return UNIT_ADDR
     */
    public String getUnitAddr() {
        return unitAddr;
    }

    /**
     * @param unitAddr
     */
    public void setUnitAddr(String unitAddr) {
        this.unitAddr = unitAddr;
    }

    /**
     * @return UNIVERSITY
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return WORKING_TIME
     */
    public Date  getWorkingTime() {
        return workingTime;
    }

    /**
     * @param workingTime
     */
    public void setWorkingTime(Date workingTime) {
        this.workingTime = workingTime;
    }

    /**
     * @return POST
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return SPECIALTY
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * @param specialty
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * @return OFFICE_PHONE
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     * @param officePhone
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    /**
     * @return EMAIL
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return FAX
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return MOBILE_PHONE
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @return HOME_PHONE
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * @param homePhone
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * @return HOME_ADDR
     */
    public String getHomeAddr() {
        return homeAddr;
    }

    /**
     * @param homeAddr
     */
    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    /**
     * @return CHANGE_DATE
     */
    public Date getChangeDate() {
        return changeDate;
    }

    /**
     * @param changeDate
     */
    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    /**
     * @return PART_IN_INCI_HANDLING
     */
    public String getPartInInciHandling() {
        return partInInciHandling;
    }

    /**
     * @param partInInciHandling
     */
    public void setPartInInciHandling(String partInInciHandling) {
        this.partInInciHandling = partInInciHandling;
    }
}
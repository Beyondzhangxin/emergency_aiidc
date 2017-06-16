package com.aiidc.sps.ep.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "SPSUSER.EM_RESOURCE_CONTACTS")
public class EmResourceContacts implements Serializable
{
    private static final long serialVersionUID = 8470158143272063552L;
    @Column(name = "COMPANY_ID")
    private String companyId;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "DEPARTMENT_DUTY")
    private String departmentDuty;

    @Column(name = "HEADER")
    private String header;

    @Column(name = "POST")
    private String post;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "WECHAT")
    private String wechat;

    @Column(name = "QQ")
    private String qq;

    @Column(name = "EDIT_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date editTime;

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
     * @return COMPANY_NAME
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return DEPARTMENT
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return DEPARTMENT_DUTY
     */
    public String getDepartmentDuty() {
        return departmentDuty;
    }

    /**
     * @param departmentDuty
     */
    public void setDepartmentDuty(String departmentDuty) {
        this.departmentDuty = departmentDuty;
    }

    /**
     * @return HEADER
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header
     */
    public void setHeader(String header) {
        this.header = header;
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
     * @return TELEPHONE
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
     * @return WECHAT
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * @param wechat
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return EDIT_TIME
     */
    public String  getEditTime() {
        return new SimpleDateFormat("yyyy-MM-dd").format(editTime);
    }

    /**
     * @param editTime
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}
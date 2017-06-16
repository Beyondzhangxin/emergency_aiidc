package com.aiidc.sps.ep.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "SPSUSER.EM_PARK_ACCIDENT_CASE")
public class EmParkAccidentCase implements Serializable
{

    private static final long serialVersionUID = -836090956860935922L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ACCIDENT_NAME")
    private String accidentName;

    @Column(name = "ACCIDENT_TIME")
    private String accidentTime;

    @Column(name = "ACCIDENT_TYPE")
    private String accidentType;

    @Column(name = "CONTENT")
    private String content;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return ACCIDENT_NAME
     */
    public String getAccidentName() {
        return accidentName;
    }

    /**
     * @param accidentName
     */
    public void setAccidentName(String accidentName) {
        this.accidentName = accidentName;
    }

    /**
     * @return ACCIDENT_TIME
     */
    public String getAccidentTime() {
        return accidentTime;
    }

    /**
     * @param accidentTime
     */
    public void setAccidentTime(String accidentTime) {
        this.accidentTime = accidentTime;
    }

    /**
     * @return ACCIDENT_TYPE
     */
    public String getAccidentType() {
        return accidentType;
    }

    /**
     * @param accidentType
     */
    public void setAccidentType(String accidentType) {
        this.accidentType = accidentType;
    }

    /**
     * @return CONTENT
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}
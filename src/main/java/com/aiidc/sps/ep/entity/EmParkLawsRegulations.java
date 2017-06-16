package com.aiidc.sps.ep.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "SPSUSER.EM_PARK_LAWS_REGULATIONS")
public class EmParkLawsRegulations implements Serializable
{
    private static final long serialVersionUID = -3830102388341943531L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PUBLISH_DEPARTMENT")
    private String publishDepartment;

    @Column(name = "PUBLISH_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;

    @Column(name = "IMPLEMENT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date implementDate;

    @Column(name = "CONTENT")
    private String content;

    /**
     * @return ID
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return NAME
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return PUBLISH_DEPARTMENT
     */
    public String getPublishDepartment()
    {
        return publishDepartment;
    }

    /**
     * @param publishDepartment
     */
    public void setPublishDepartment(String publishDepartment)
    {
        this.publishDepartment = publishDepartment;
    }

    /**
     * @return PUBLISH_DATE
     */
    public Date getPublishDate()
    {
        return publishDate;
    }

    /**
     * @param publishDate
     */
    public void setPublishDate(Date publishDate)
    {
        this.publishDate = publishDate;
    }

    /**
     * @return IMPLEMENT_DATE
     */
    public Date getImplementDate()
    {
        return implementDate;
    }

    /**
     * @param implementDate
     */
    public void setImplementDate(Date implementDate)
    {
        this.implementDate = implementDate;
    }

    /**
     * @return CONTENT
     */
    public String getContent()
    {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content)
    {
        this.content = content;
    }
}
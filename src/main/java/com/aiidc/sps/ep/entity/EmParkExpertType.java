package com.aiidc.sps.ep.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "SPSUSER.EM_PARK_EXPERT_TYPE")
public class EmParkExpertType implements Serializable{
    private static final long serialVersionUID = -208843206958927388L;
    @Column(name = "EXPERT_ID")
    private Short expertId;

    @Column(name = "EXPERT_TYPE_NAME")
    private String expertTypeName;

    /**
     * @return EXPERT_ID
     */
    public Short getExpertId() {
        return expertId;
    }

    /**
     * @param expertId
     */
    public void setExpertId(Short expertId) {
        this.expertId = expertId;
    }

    /**
     * @return EXPERT_TYPE_NAME
     */
    public String getExpertTypeName() {
        return expertTypeName;
    }

    /**
     * @param expertTypeName
     */
    public void setExpertTypeName(String expertTypeName) {
        this.expertTypeName = expertTypeName;
    }
}
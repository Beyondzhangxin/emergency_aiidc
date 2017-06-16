package com.aiidc.sps.ep.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "SPSUSER.EM_RESOURCE_TEAM_EVENT_TYPE")
public class EmResourceTeamEventType implements Serializable
{
    private static final long serialVersionUID = 9082801099843668129L;
    @Column(name = "EVENT_TYPE_ID")
    private Short eventTypeId;

    @Column(name = "EVENT_TYPE_NAME")
    private String eventTypeName;

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
     * @return EVENT_TYPE_NAME
     */
    public String getEventTypeName() {
        return eventTypeName;
    }

    /**
     * @param eventTypeName
     */
    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }
}
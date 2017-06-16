package com.aiidc.sps.ep.services;

import com.aiidc.base.AiidcException;
import com.aiidc.sps.ep.entity.*;
import com.aiidc.sps.ep.mapper.EmResourceTeamMapper;
import com.aiidc.sps.ep.parameter.EmResourceTeamParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/24 at 15:06.
 */
@Service
public class EmResourceTeamService
{
    @Autowired
    private EmResourceTeamMapper emResourceTeamMapper;

    public List<EmResourceTeam> findAll(EmResourceTeamParam emResourceTeamParam)
    {
        return emResourceTeamMapper.findAll(emResourceTeamParam);
    }

    public void insert(EmResourceTeam emResourceTeam) throws AiidcException
    {
        long teamId = emResourceTeamMapper.getSequnceId();
        if (emResourceTeam.getTeamName() == null || emResourceTeam.getTeamAddr() == null ||
                emResourceTeam.getAreaId() == null || emResourceTeam.getTeamTypeId() == null ||
                emResourceTeam.getEventTypeId() == null || emResourceTeam.getHeadTel() == null ||
                emResourceTeam.getDutyTel() == null)
        {
            throw new AiidcException("DATA_NOT_NULL");
        } else
        {
            try
            {
                emResourceTeam.setTeamId(teamId);
                emResourceTeamMapper.insert(emResourceTeam);
            } catch (Exception e)
            {
                throw new AiidcException("保存失败！");
            }
        }
    }

    public void update(EmResourceTeam emResourceTeam) throws AiidcException
    {
        if (emResourceTeam.getTeamName() == null || emResourceTeam.getTeamAddr() == null ||
                emResourceTeam.getAreaId() == null || emResourceTeam.getTeamTypeId() == null ||
                emResourceTeam.getEventTypeId() == null || emResourceTeam.getHeadTel() == null ||
                emResourceTeam.getDutyTel() == null)
        {
            throw new AiidcException("DATA_NOT_NULL");
        } else
        {
            try
            {
                emResourceTeamMapper.update(emResourceTeam);
            } catch (Exception e)
            {
                throw new AiidcException("更新失败！");
            }
        }
    }

    public void delete(int[] ids) throws AiidcException
    {
        try
        {
            for (int id : ids)
            {
                emResourceTeamMapper.delete(id);
            }
        } catch (Exception e)
        {
            throw new AiidcException("删除失败！");
        }
    }

    public EmResourceTeam getByTeamId(String id)
    {
        return emResourceTeamMapper.getByTeamId(id);
    }


    public int searchCount(EmResourceTeamParam emResourceTeamParam)
    {
        return emResourceTeamMapper.searchCount(emResourceTeamParam);
    }

    public List<EmResourceTeamUnit> search(EmResourceTeamParam emResourceTeamParam)
    {
        return emResourceTeamMapper.search(emResourceTeamParam);
    }

    public EmResourceTeamLevel getByLevelId(String levelId)
    {
        return emResourceTeamMapper.getByLevelId(levelId);
    }

    public EmResourceTeamEventType getByEventTypeId(int eventTypeId)
    {
        return emResourceTeamMapper.getByEventTypeId(eventTypeId);
    }

    public EmResourceTeamType getByTypeId(String typeId)
    {
        return emResourceTeamMapper.getByTypeId(typeId);
    }

    public List<EmResourceTeamEventType> getAllEventTypes()
    {
        return emResourceTeamMapper.getAllEventTypes();
    }

    public List<EmResourceTeamType> getAllTeamTypes()
    {
        return emResourceTeamMapper.getAllTeamTypes();
    }

    public List<EmResourceTeamLevel> getAllTeamLevels()
    {
        return emResourceTeamMapper.getAllTeamLevels();
    }

    public EmEnterpriseInfo getEntInfoById(String companyId)
    {
        return emResourceTeamMapper.getEntInfoById(companyId);
    }
}

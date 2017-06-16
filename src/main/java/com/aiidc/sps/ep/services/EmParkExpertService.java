package com.aiidc.sps.ep.services;

import com.aiidc.base.AiidcException;
import com.aiidc.sps.ep.entity.EmParkExperUnit;
import com.aiidc.sps.ep.entity.EmParkExpert;
import com.aiidc.sps.ep.entity.EmParkExpertType;
import com.aiidc.sps.ep.mapper.EmParkExpertMapper;
import com.aiidc.sps.ep.parameter.EmParkExpertParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/23 at 16:09.
 */
@Service
public class EmParkExpertService
{
    @Autowired
    private EmParkExpertMapper emParkExpertMapper;

    public List<EmParkExperUnit> search(EmParkExpertParam emParkExpertParam)
    {
        return emParkExpertMapper.search(emParkExpertParam);
    }

    public EmParkExpert getById(String id)
    {
        return emParkExpertMapper.getById(id);
    }

    public void deleteByIds(int[] ids) throws AiidcException
    {
        try
        {
            for (int id : ids)
            {
                emParkExpertMapper.deleteById(id);
            }
        } catch (Exception e)
        {
            throw new AiidcException("删除失败！");
        }
    }

    public void update(EmParkExpert emParkExpert) throws AiidcException
    {
        if (emParkExpert.getExpertType() == null || emParkExpert.getName() == null
                || emParkExpert.getSex() == null || emParkExpert.getAreaId() == null
                || emParkExpert.getEventTypeId() == null || emParkExpert.getOfficePhone() == null)
        {
            throw new AiidcException("DATA_NOT_NULL!");
        } else
        {
            try
            {
                emParkExpertMapper.update(emParkExpert);
            } catch (Exception e)
            {
                throw new AiidcException("更新失败");
            }
        }
    }

    public void save(EmParkExpert emParkExpert) throws AiidcException
    {
        emParkExpert.setExpertId(emParkExpertMapper.getExpertId());
        if (emParkExpert.getExpertType() == null || emParkExpert.getName() == null
                || emParkExpert.getSex() == null || emParkExpert.getAreaId() == null
                || emParkExpert.getEventTypeId() == null || emParkExpert.getOfficePhone() == null)
        {
            throw new AiidcException("DATA_NOT_NULL!");
        } else
        {
            try
            {
                emParkExpertMapper.save(emParkExpert);
            } catch (Exception e)
            {
                throw new AiidcException("添加失败！");
            }
        }
    }

    public int doSearchCount(EmParkExpertParam emParkExpertParam)
    {
        return emParkExpertMapper.searchCount(emParkExpertParam);
    }

    public List<EmParkExpertType> getAllExpertTypes()
    {
        return emParkExpertMapper.getAllExpertTypes();
    }

    public EmParkExpertType getExpertTypeById(short expertId)
    {
        return emParkExpertMapper.getExpertTypeById(expertId);
    }
}



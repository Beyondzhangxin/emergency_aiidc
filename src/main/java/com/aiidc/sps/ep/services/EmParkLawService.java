package com.aiidc.sps.ep.services;

import com.aiidc.base.AiidcException;
import com.aiidc.sps.ep.entity.EmParkLawUnit;
import com.aiidc.sps.ep.entity.EmParkLawsRegulations;
import com.aiidc.sps.ep.mapper.EmParkLawsMapper;
import com.aiidc.sps.ep.parameter.EmParkLawParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/25 at 15:02.
 */
@Service
public class EmParkLawService
{
    @Autowired
    private EmParkLawsMapper emParkLawsMapper;

    public List<EmParkLawUnit> getData(EmParkLawParam emParkLawParam)
    {
        return emParkLawsMapper.search(emParkLawParam);
    }

    public int getCount(EmParkLawParam emParkLawParam)
    {
        return emParkLawsMapper.searchCount(emParkLawParam);
    }

    public List<EmParkLawsRegulations> findByName(EmParkLawParam emParkLawParam)
    {
        return emParkLawsMapper.findByName(emParkLawParam);
    }

    public EmParkLawsRegulations getById(int id)
    {
        return emParkLawsMapper.getById(id);
    }

    public void insert(EmParkLawsRegulations emParkLawsRegulations) throws AiidcException
    {
        if (emParkLawsRegulations.getName() == null ||
                emParkLawsRegulations.getPublishDepartment() == null)
        {
            throw new AiidcException("DATA_NOT_NULL!");
        } else
        {
            try
            {
                emParkLawsMapper.insert(emParkLawsRegulations);
            } catch (Exception e)
            {
                throw new AiidcException("添加失败！");
            }
        }
    }

    public void update(EmParkLawsRegulations emParkLawsRegulations) throws AiidcException
    {

        if (emParkLawsRegulations.getName() == null ||
                emParkLawsRegulations.getPublishDepartment() == null)
        {
            throw new AiidcException("DATA_NOT_NULL!");
        } else
        {
            try
            {
                emParkLawsMapper.update(emParkLawsRegulations);
            } catch (Exception e)
            {
                throw  new AiidcException("更新失败");
            }
        }
    }

    public void delete(long[] ids) throws AiidcException
    {
        try
        {
            for (long id : ids)
            {
                emParkLawsMapper.delete(id);
            }
        } catch (Exception e)
        {
            throw new AiidcException("删除失败！");
        }
    }

    public long getId(){
        return  emParkLawsMapper.getId();
    }
}

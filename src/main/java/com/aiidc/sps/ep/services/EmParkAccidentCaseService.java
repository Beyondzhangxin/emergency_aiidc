package com.aiidc.sps.ep.services;

import com.aiidc.base.AiidcException;
import com.aiidc.sps.ep.entity.EmParkAccidentCase;
import com.aiidc.sps.ep.mapper.EmParkAccidentCaseMapper;
import com.aiidc.sps.ep.parameter.EmParkAccidentCaseParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Zhangx on 2017/5/25 at 17:20.
 */
@Service
public class EmParkAccidentCaseService
{
    @Autowired
    private EmParkAccidentCaseMapper emParkAccidentCaseMapper;

    public List<EmParkAccidentCase> getData(EmParkAccidentCaseParam emParkAccidentCaseParam) throws ParseException
    {
        List<EmParkAccidentCase> list = emParkAccidentCaseMapper.search(emParkAccidentCaseParam);
        return list;
    }

    public int getCount(EmParkAccidentCaseParam emParkAccidentCaseParam)
    {
        return emParkAccidentCaseMapper.searchCount(emParkAccidentCaseParam);
    }

    public EmParkAccidentCase getById(long id)
    {
        return emParkAccidentCaseMapper.getById(id);
    }

    public void insert(EmParkAccidentCase emParkAccidentCase) throws AiidcException
    {
        emParkAccidentCase.setId(emParkAccidentCaseMapper.getId());
        if (emParkAccidentCase.getAccidentName() == null || emParkAccidentCase.getAccidentTime() == null
                || emParkAccidentCase.getAccidentType() == null)
        {
            throw new AiidcException("DATA_NOT_NULL");
        } else
        {
            try
            {
                emParkAccidentCaseMapper.insert(emParkAccidentCase);
            } catch (Exception e)
            {
                throw new AiidcException("添加失败！");
            }
        }
    }

    public void update(EmParkAccidentCase emParkAccidentCase) throws AiidcException
    {
        if (emParkAccidentCase.getAccidentName() == null || emParkAccidentCase.getAccidentTime() == null
                || emParkAccidentCase.getAccidentType() == null)
        {
            throw new AiidcException("DATA_NOT_NULL");
        } else
        {
            try
            {
                emParkAccidentCaseMapper.update(emParkAccidentCase);
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
                emParkAccidentCaseMapper.delete(id);
            }
        } catch (Exception e)
        {
            throw new AiidcException("删除失败！");
        }
    }

}

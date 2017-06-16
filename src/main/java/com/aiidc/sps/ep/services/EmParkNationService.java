package com.aiidc.sps.ep.services;

import com.aiidc.sps.ep.entity.EmParkNation;
import com.aiidc.sps.ep.mapper.EmParkNationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/26 at 16:18.
 */
@Service
public class EmParkNationService
{
    @Autowired
    EmParkNationMapper emParkNationMapper;

   public List<EmParkNation> findAll()
    {
        return emParkNationMapper.findAll();
    }

    public EmParkNation getById(String nationId)
    {
        return emParkNationMapper.getById(nationId);
    }
}

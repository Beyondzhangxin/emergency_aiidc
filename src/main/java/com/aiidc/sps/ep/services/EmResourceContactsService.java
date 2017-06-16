package com.aiidc.sps.ep.services;

import com.aiidc.sps.ep.entity.EmEnterpriseInfo;
import com.aiidc.sps.ep.entity.EmResourceContacts;
import com.aiidc.sps.ep.mapper.EmResourceContactsMapper;
import com.aiidc.sps.ep.parameter.EmResourceContactsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhangx on 2017/5/20 at 19:09.
 */
@Service
public class EmResourceContactsService
{
    @Autowired
    EmResourceContactsMapper emResourceContactsMapper;


    public EmResourceContacts getById(String id)
    {
        return emResourceContactsMapper.getById(id);
    }

    public List<EmResourceContacts> search(EmResourceContactsParam emResourceContactsParam)
    {
        return emResourceContactsMapper.search(emResourceContactsParam);
    }

    public int doSearchCount(EmResourceContactsParam emResourceContactsParam)
    {
        return emResourceContactsMapper.searchCount(emResourceContactsParam);
    }

    public List<EmEnterpriseInfo> getAllEpInfo(){
        return emResourceContactsMapper.getEpInfos();
    }
}

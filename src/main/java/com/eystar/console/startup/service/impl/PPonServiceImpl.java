package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.CPPon;
import com.eystar.console.startup.mapper.CPPonMapper;
import com.eystar.console.startup.service.PPonService;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pPonService")
public class PPonServiceImpl implements PPonService {

    @Autowired
    private CPPonMapper cpPonMapper;

    public int insert(CPPon cpPon){
        DataSourceType value = DataSourceType.bigdata;
        DataSourceContextHolder.setDataSource(value);
        int cph= cpPonMapper.insertSelective(cpPon);
        DataSourceContextHolder.clearDataSource();
        return cph;
    }
}

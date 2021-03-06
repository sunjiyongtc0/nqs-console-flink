package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.CPPon;
import com.eystar.console.startup.mapper.CPPonMapper;
import com.eystar.console.startup.service.PPonService;
import com.eystar.console.startup.source.DataSource;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pPonService")
public class PPonServiceImpl implements PPonService {

    @Autowired
    private CPPonMapper cpPonMapper;

    @DataSource(DataSourceType.bigdata)
    public int insert(CPPon cpPon){
        int cph= cpPonMapper.insertSelective(cpPon);
        return cph;
    }
}

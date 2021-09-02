package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.CPStatus;
import com.eystar.console.startup.mapper.CPStatusMapper;
import com.eystar.console.startup.service.PStatusService;
import com.eystar.console.startup.source.DataSource;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pStatusService")
public class PStatusServiceImpl implements PStatusService {

    @Autowired
    private CPStatusMapper cpStatusMapper;

    @DataSource(DataSourceType.bigdata)
    public int insert(CPStatus cpStatus){
//        DataSourceType value = DataSourceType.bigdata;
//        DataSourceContextHolder.setDataSource(value);
        int cph= cpStatusMapper.insertSelective(cpStatus);
//        DataSourceContextHolder.clearDataSource();
        return cph;
    }
}

package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.CPHeartbeat;
import com.eystar.console.startup.mapper.CPHeartbeatMapper;
import com.eystar.console.startup.service.HeartbeatService;
import com.eystar.console.startup.source.DataSource;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("heartbeatService")
public class HeartbeatServiceImpl implements HeartbeatService {

    @Autowired
    private CPHeartbeatMapper cpHeartbeatMapper;

    @DataSource(DataSourceType.bigdata)
    public int insert(CPHeartbeat cpHeartbeat){
//        DataSourceType value = DataSourceType.bigdata;
//        DataSourceContextHolder.setDataSource(value);
        int cph= cpHeartbeatMapper.insertSelective(cpHeartbeat);
//        DataSourceContextHolder.clearDataSource();
        return cph;
    }
}

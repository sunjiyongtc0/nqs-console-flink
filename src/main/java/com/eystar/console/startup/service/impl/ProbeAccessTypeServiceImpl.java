package com.eystar.console.startup.service.impl;


import com.eystar.console.startup.entity.TPProbeAccessType;
import com.eystar.console.startup.mapper.TPProbeAccessTypeMapper;
import com.eystar.console.startup.service.ProbeAccessTypeService;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("probeAccessTypeService")
public class ProbeAccessTypeServiceImpl implements ProbeAccessTypeService {

    @Autowired
    private TPProbeAccessTypeMapper tpProbeAccessTypeMapper;


    @Override
    public List<TPProbeAccessType> selectByProbeId(String peobeId) {
        DataSourceType value = DataSourceType.mysql;
        DataSourceContextHolder.setDataSource(value);
        List<TPProbeAccessType> lp=tpProbeAccessTypeMapper.selectByProbeId(peobeId);
        DataSourceContextHolder.clearDataSource();
        return lp;
    }
}

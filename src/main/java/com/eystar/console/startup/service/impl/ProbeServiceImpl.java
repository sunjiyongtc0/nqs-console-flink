package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.TPProbe;
import com.eystar.console.startup.mapper.TPProbeMapper;
import com.eystar.console.startup.service.ProbeService;

import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("probeService")
public class ProbeServiceImpl implements ProbeService {

    @Autowired
    private TPProbeMapper tPProbeMapper;

    @Override
    public TPProbe findById(String id) {
        DataSourceType value = DataSourceType.mysql;
        DataSourceContextHolder.setDataSource(value);
        TPProbe probe=tPProbeMapper.selectByPrimaryKey(id);
        DataSourceContextHolder.clearDataSource();
        return probe;
    }

    @Override
    public void updateProbe(TPProbe tpProbe) {
        DataSourceType value = DataSourceType.mysql;
        DataSourceContextHolder.setDataSource(value);
        tPProbeMapper.updateByPrimaryKeySelective(tpProbe);
        DataSourceContextHolder.clearDataSource();
    }

    @Override
    public int insertProbe(TPProbe tpProbe) {
        DataSourceType value = DataSourceType.mysql;
        DataSourceContextHolder.setDataSource(value);
        int count =0;
        if(tPProbeMapper.selectByPrimaryKey(tpProbe.getId())==null) {
            count = tPProbeMapper.insert(tpProbe);
        }
        DataSourceContextHolder.clearDataSource();
        return count;
    }

}

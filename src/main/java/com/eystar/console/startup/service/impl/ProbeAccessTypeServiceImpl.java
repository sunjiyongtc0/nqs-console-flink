package com.eystar.console.startup.service.impl;


import com.eystar.console.startup.entity.TPProbeAccessType;
import com.eystar.console.startup.mapper.TPProbeAccessTypeMapper;
import com.eystar.console.startup.service.ProbeAccessTypeService;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("probeAccessTypeService")
public class ProbeAccessTypeServiceImpl implements ProbeAccessTypeService {

    @Autowired
    private TPProbeAccessTypeMapper tpProbeAccessTypeMapper;


    @Override
    public List<TPProbeAccessType> selectByProbeId(String probeId) {
//        DataSourceType value = DataSourceType.mysql;
//        DataSourceContextHolder.setDataSource(value);
        List<TPProbeAccessType> lp=tpProbeAccessTypeMapper.selectByProbeId(probeId);
//        DataSourceContextHolder.clearDataSource();
        return lp;
    }

    @Override
    public TPProbeAccessType findByAccessType( String probeId,  String accessTypeName) {
//        DataSourceType value = DataSourceType.mysql;
//        DataSourceContextHolder.setDataSource(value);
        TPProbeAccessType p=tpProbeAccessTypeMapper.findByAccessType(probeId,accessTypeName);
//        DataSourceContextHolder.clearDataSource();
        return p;
    }

    @Override
    public int insert(TPProbeAccessType tpProbeAccessType) {
//        DataSourceType value = DataSourceType.mysql;
//        DataSourceContextHolder.setDataSource(value);
        int  p=tpProbeAccessTypeMapper.insertSelective(tpProbeAccessType);
//        DataSourceContextHolder.clearDataSource();

        return p;
    }

    @Override
    public int update(TPProbeAccessType tpProbeAccessType) {
//        DataSourceType value = DataSourceType.mysql;
//        DataSourceContextHolder.setDataSource(value);
        int  p=tpProbeAccessTypeMapper.updateByPrimaryKeySelective(tpProbeAccessType);
//        DataSourceContextHolder.clearDataSource();

        return p;
    }

    @Override
    public void deleteAccessTypeByName( String probeId, String accessTypeName) {
//        DataSourceType value = DataSourceType.mysql;
//        DataSourceContextHolder.setDataSource(value);
        tpProbeAccessTypeMapper.deleteAccessTypeByName(probeId,accessTypeName);
//        DataSourceContextHolder.clearDataSource();
    }
}

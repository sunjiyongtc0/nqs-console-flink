package com.eystar.console.startup.service.impl;


import com.eystar.console.startup.entity.TPProbeAccessType;
import com.eystar.console.startup.mapper.TPProbeAccessTypeMapper;
import com.eystar.console.startup.service.ProbeAccessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("probeAccessTypeService")
public class ProbeAccessTypeServiceImpl implements ProbeAccessTypeService {

    @Autowired
    private TPProbeAccessTypeMapper tpProbeAccessTypeMapper;


    @Override
    public List<TPProbeAccessType> selectByProbeId(String probeId) {
        List<TPProbeAccessType> lp=tpProbeAccessTypeMapper.selectByProbeId(probeId);
        return lp;
    }

    @Override
    public TPProbeAccessType findByAccessType( String probeId,  String accessTypeName) {
        TPProbeAccessType p=tpProbeAccessTypeMapper.findByAccessType(probeId,accessTypeName);
        return p;
    }

    @Override
    public int insert(TPProbeAccessType tpProbeAccessType) {
        int  p=tpProbeAccessTypeMapper.insertSelective(tpProbeAccessType);
        return p;
    }

    @Override
    public int update(TPProbeAccessType tpProbeAccessType) {
        int  p=tpProbeAccessTypeMapper.updateByPrimaryKeySelective(tpProbeAccessType);
        return p;
    }

    @Override
    public void deleteAccessTypeByName( String probeId, String accessTypeName) {
        tpProbeAccessTypeMapper.deleteAccessTypeByName(probeId,accessTypeName);
    }
}

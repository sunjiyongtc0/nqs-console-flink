package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.TPProbe;
import com.eystar.console.startup.mapper.TPProbeMapper;
import com.eystar.console.startup.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("probeService")
public class ProbeServiceImpl implements ProbeService {

    @Autowired
    private TPProbeMapper tPProbeMapper;

    @Override
    public TPProbe findById(String id) {
        TPProbe probe=tPProbeMapper.selectByPrimaryKey(id);
        return probe;
    }

    @Override
    public void updateProbe(TPProbe tpProbe) {
        tPProbeMapper.updateByPrimaryKeySelective(tpProbe);
    }

    @Override
    public int insertProbe(TPProbe tpProbe) {
        int count =0;
        if(tPProbeMapper.selectByPrimaryKey(tpProbe.getId())==null) {
            count = tPProbeMapper.insert(tpProbe);
        }
        return count;
    }

}

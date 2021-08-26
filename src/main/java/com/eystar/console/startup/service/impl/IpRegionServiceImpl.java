package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.TMIpRegion;
import com.eystar.console.startup.entity.TPProbe;
import com.eystar.console.startup.mapper.TMIpRegionMapper;
import com.eystar.console.startup.service.IpRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ipRegionService")
public class IpRegionServiceImpl implements IpRegionService {


    @Autowired
    private TMIpRegionMapper tmIpRegionMapper;


    @Override
    public TMIpRegion findByIP(String ip) {
        return tmIpRegionMapper.selectByIpFirst(ip);
    }
}
package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.gwdata.*;
import com.eystar.console.startup.mapper.GwDnsMapper;
import com.eystar.console.startup.mapper.GwFlashMapper;
import com.eystar.console.startup.mapper.GwHttpMapper;
import com.eystar.console.startup.mapper.GwPingMapper;
import com.eystar.console.startup.service.GwDataService;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gwDataService")
public class GwDataServiceImpl implements GwDataService {


    @Autowired
    private GwDnsMapper gwDnsMapper;

    @Autowired
    private GwFlashMapper gwFlashMapper;

    @Autowired
    private GwHttpMapper gwHttpMapper;

    @Autowired
    private GwPingMapper gwPingMapper;

    @Override
    public int insertData(GwData gwData) {
        int i=0;
        DataSourceType value = DataSourceType.bigdata;
        DataSourceContextHolder.setDataSource(value);
        if(gwData instanceof GwPingData){
            System.out.println("GwPingData入库");
            i=gwPingMapper.insertSelective((GwPingData)gwData);
        }
        if(gwData instanceof GwDnsData){
            System.out.println("GwDnsData入库");
            i=gwDnsMapper.insertSelective((GwDnsData)gwData);
        }
        if(gwData instanceof GwFlashData){
            System.out.println("Flash入库");
            i=gwFlashMapper.insertSelective((GwFlashData)gwData);
        }
        if(gwData instanceof GwHttpData){
            System.out.println("GwHttpData入库");
            i=gwHttpMapper.insertSelective((GwHttpData)gwData);
        }
        DataSourceContextHolder.clearDataSource();
        return i;
    }
}

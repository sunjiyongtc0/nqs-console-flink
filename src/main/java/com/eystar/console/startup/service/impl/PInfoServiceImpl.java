package com.eystar.console.startup.service.impl;


import com.eystar.console.startup.entity.CPPinfo;
import com.eystar.console.startup.mapper.CPPinfoMapper;
import com.eystar.console.startup.service.PInfoService;
import com.eystar.console.startup.source.DataSource;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pInfoService")
public class PInfoServiceImpl implements PInfoService {

    @Autowired
    private CPPinfoMapper cpPinfoMapper;


    @DataSource(DataSourceType.bigdata)
    public int insert(CPPinfo cpPinfo) {
//        DataSourceType value = DataSourceType.bigdata;
//        DataSourceContextHolder.setDataSource(value);
        int pi= cpPinfoMapper.insert(cpPinfo);
//        DataSourceContextHolder.clearDataSource();
        return pi;
    }
}

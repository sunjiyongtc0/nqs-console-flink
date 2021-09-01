package com.eystar.console.startup.mapper;

import com.eystar.console.startup.entity.gwdata.GwDnsData;


public interface GwDnsMapper {


    int insert(GwDnsData record);

    int insertSelective(GwDnsData record);

}
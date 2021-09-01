package com.eystar.console.startup.mapper;


import com.eystar.console.startup.entity.gwdata.GwPingData;

public interface GwPingMapper {

    int insert(GwPingData record);

    int insertSelective(GwPingData record);

}
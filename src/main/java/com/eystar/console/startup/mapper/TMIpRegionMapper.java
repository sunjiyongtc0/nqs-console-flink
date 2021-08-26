package com.eystar.console.startup.mapper;

import com.eystar.console.startup.entity.TMIpRegion;

public interface TMIpRegionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TMIpRegion record);

    int insertSelective(TMIpRegion record);

    TMIpRegion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMIpRegion record);

    int updateByPrimaryKey(TMIpRegion record);

    TMIpRegion selectByIpFirst(String ip);


}
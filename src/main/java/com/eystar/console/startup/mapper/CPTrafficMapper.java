package com.eystar.console.startup.mapper;

import com.eystar.console.startup.entity.CPTraffic;

import java.util.List;

public interface CPTrafficMapper {


    int insert(CPTraffic record);

    int insertSelective(CPTraffic record);

    void insertList(List<CPTraffic> cpTraffics);

}
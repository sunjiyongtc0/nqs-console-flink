package com.eystar.console.startup.mapper;


import com.eystar.console.startup.entity.gwdata.GwHttpData;

public interface GwHttpMapper {

    int insert(GwHttpData record);

    int insertSelective(GwHttpData record);

}
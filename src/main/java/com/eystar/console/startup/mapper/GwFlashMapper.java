package com.eystar.console.startup.mapper;

import com.eystar.console.startup.entity.gwdata.GwFlashData;

public interface GwFlashMapper {


    int insert(GwFlashData record);

    int insertSelective(GwFlashData record);


}
package com.eystar.console.startup.mapper;

import com.eystar.console.startup.entity.CPPinfo;


public interface CPPinfoMapper {


    int insert(CPPinfo record);

    int insertSelective(CPPinfo record);


}
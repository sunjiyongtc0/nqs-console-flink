package com.eystar.console.startup.mapper;

import com.eystar.console.startup.entity.TTTaskSrcDest;

public interface TTTaskSrcDestMapper {


    TTTaskSrcDest findById(String taskId);


    int insert(TTTaskSrcDest record);

    int insertSelective(TTTaskSrcDest record);



}
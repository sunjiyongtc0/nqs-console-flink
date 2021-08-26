package com.eystar.console.startup.mapper;


import com.eystar.console.startup.entity.TPProbe;


public interface TPProbeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPProbe record);

    int insertSelective(TPProbe record);

    TPProbe selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPProbe record);

    int updateByPrimaryKey(TPProbe record);

}
package com.eystar.console.startup.mapper;

import com.eystar.console.startup.entity.TPProbeAccessType;

import java.util.List;


public interface TPProbeAccessTypeMapper {



    int insert(TPProbeAccessType record);

    int insertSelective(TPProbeAccessType record);

    TPProbeAccessType selectByPrimaryKey(String id);


    List<TPProbeAccessType> selectByProbeId(String peobeId);

    int updateByPrimaryKeySelective(TPProbeAccessType record);

    int updateByPrimaryKey(TPProbeAccessType record);
}
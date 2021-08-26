package com.eystar.console.startup.mapper;


import com.eystar.console.startup.entity.CPHeartbeat;

public interface CPHeartbeatMapper {

    int insert(CPHeartbeat record);

    int insertSelective(CPHeartbeat record);
}
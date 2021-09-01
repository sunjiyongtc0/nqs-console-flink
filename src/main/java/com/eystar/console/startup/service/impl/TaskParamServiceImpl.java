package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.TTTaskParam;
import com.eystar.console.startup.mapper.TTTaskParamMapper;
import com.eystar.console.startup.service.TaskParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskParamService")
public class TaskParamServiceImpl implements TaskParamService {

    @Autowired
    private TTTaskParamMapper ttTaskParamMapper;

    @Override
    public TTTaskParam findById(String taskParamId) {
        return ttTaskParamMapper.selectByPrimaryKey(taskParamId);
    }
}

package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.TTTaskSrcDest;
import com.eystar.console.startup.mapper.TTTaskSrcDestMapper;
import com.eystar.console.startup.service.TaskSrcDesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskSrcDesService")
public class TaskSrcDesServiceImpl implements TaskSrcDesService {

    @Autowired
    private TTTaskSrcDestMapper ttTaskSrcDestMapper;

    @Override
    public TTTaskSrcDest findById(String taskId) {
        return ttTaskSrcDestMapper.findById(taskId);
    }
}

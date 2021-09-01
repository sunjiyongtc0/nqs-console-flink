package com.eystar.console.startup.service;

import com.eystar.console.startup.entity.TTTaskSrcDest;

public interface TaskSrcDesService {

    TTTaskSrcDest findById(String taskId);
}

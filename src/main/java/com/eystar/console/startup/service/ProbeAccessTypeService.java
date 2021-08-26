package com.eystar.console.startup.service;


import com.eystar.console.startup.entity.TPProbeAccessType;

import java.util.List;

public interface ProbeAccessTypeService {


    List<TPProbeAccessType> selectByProbeId(String peobeId);

}

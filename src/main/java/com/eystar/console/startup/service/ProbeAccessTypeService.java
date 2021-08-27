package com.eystar.console.startup.service;


import com.eystar.console.startup.entity.TPProbeAccessType;

import java.util.List;

public interface ProbeAccessTypeService {


    List<TPProbeAccessType> selectByProbeId(String probeId);

    TPProbeAccessType findByAccessType(String probeId, String accessTypeName);

    int insert(TPProbeAccessType tpProbeAccessType);

    int update(TPProbeAccessType tpProbeAccessType);

    void deleteAccessTypeByName(String probeId,String accessTypeName);
}

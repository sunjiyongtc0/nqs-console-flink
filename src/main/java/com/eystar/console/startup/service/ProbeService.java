package com.eystar.console.startup.service;




import com.eystar.console.startup.entity.TPProbe;


public interface ProbeService {



//    String getProbe(String probeId);


//    CPPinfo findProbeInfoById(String id);

    TPProbe findById(String id);

    void updateProbe(TPProbe tpProbe);

    int insertProbe(TPProbe tpProbe);

//    List<CPPon> getList();

//    JSONObject charts(String probeId, long startTime);
}

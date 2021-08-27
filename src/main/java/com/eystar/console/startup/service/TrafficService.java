package com.eystar.console.startup.service;


import com.eystar.console.startup.entity.CPTraffic;

import java.util.List;

public interface TrafficService {


    int insert(CPTraffic cpTraffic);

    void insertList(List<CPTraffic> cpTraffics);
}

package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.CPTraffic;
import com.eystar.console.startup.mapper.CPTrafficMapper;
import com.eystar.console.startup.service.TrafficService;
import com.eystar.console.startup.source.DataSource;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("trafficService")
public class TrafficServiceImpl implements TrafficService {

    @Autowired
    private CPTrafficMapper cpTrafficMapper;

    @DataSource(DataSourceType.bigdata)
    public int insert(CPTraffic cpTraffic){
        int cph= cpTrafficMapper.insertSelective(cpTraffic);
        return cph;
    }

    @DataSource(DataSourceType.bigdata)
    public void insertList(List<CPTraffic> cpTraffics) {
        cpTrafficMapper.insertList(cpTraffics);
    }
}

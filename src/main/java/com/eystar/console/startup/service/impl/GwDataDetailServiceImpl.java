package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.gwdata.*;
import com.eystar.console.startup.mapper.*;
import com.eystar.console.startup.service.GwDataDetailService;
import com.eystar.console.startup.service.GwDataService;
import com.eystar.console.startup.source.DataSourceContextHolder;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gwDataDetailService")
public class GwDataDetailServiceImpl implements GwDataDetailService {


    @Autowired
    private GwHttpDetailMapper gwHttpDetailMapper;


    @Override
    public int insertDataList(List<GwData> gwDataList) {
        int i=0;
        DataSourceType value = DataSourceType.bigdata;
        DataSourceContextHolder.setDataSource(value);
        if(gwDataList.get(0) instanceof GwHttpDetailData){
            gwHttpDetailMapper.insertList(gwDataList);
        }
        DataSourceContextHolder.clearDataSource();
        return i;
    }
}

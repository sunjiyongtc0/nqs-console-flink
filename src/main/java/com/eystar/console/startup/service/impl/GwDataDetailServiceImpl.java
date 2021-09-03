package com.eystar.console.startup.service.impl;

import com.eystar.console.startup.entity.gwdata.*;
import com.eystar.console.startup.mapper.*;
import com.eystar.console.startup.service.GwDataDetailService;
import com.eystar.console.startup.source.DataSource;
import com.eystar.console.startup.source.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gwDataDetailService")
public class GwDataDetailServiceImpl implements GwDataDetailService {


    @Autowired
    private GwHttpDetailMapper gwHttpDetailMapper;


    @DataSource(DataSourceType.bigdata)
    public int insertDataList(List<GwData> gwDataList) {
        int i=0;
        if(gwDataList.get(0) instanceof GwHttpDetailData){
            gwHttpDetailMapper.insertList(gwDataList);
        }
        return i;
    }
}

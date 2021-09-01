package com.eystar.console.startup.mapper;


import com.eystar.console.startup.entity.gwdata.GwData;
import com.eystar.console.startup.entity.gwdata.GwHttpDetailData;

import java.util.List;

public interface GwHttpDetailMapper {


    int insert(GwHttpDetailData record);

    int insertSelective(GwHttpDetailData record);

    int insertList(List<GwData> lgd);

}
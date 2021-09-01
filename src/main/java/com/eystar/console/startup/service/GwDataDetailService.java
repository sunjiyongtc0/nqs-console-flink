package com.eystar.console.startup.service;

import com.eystar.console.startup.entity.gwdata.GwData;

import java.util.List;

public interface GwDataDetailService {


    int insertDataList(List<GwData> gwDataList);
}

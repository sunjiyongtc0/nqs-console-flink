package com.eystar.console.startup.handler.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eystar.console.startup.entity.gwdata.GwData;
import com.eystar.console.startup.service.GwDataDetailService;
import com.eystar.console.startup.service.GwDataService;

import java.lang.reflect.Field;
import java.util.List;

public class DataParserHelper {

    private static GwDataService gwDataService;
    private static GwDataDetailService gwDataDetailService;

    public static  void  init(GwDataService gds,GwDataDetailService gdd){
        gwDataService=gds;
        gwDataDetailService=gdd;
    }


    public static int insertData(GwData gwData){
        return gwDataService.insertData(gwData);
    }


    public static void insertDataDetailList(List<GwData> lgd){
        gwDataDetailService.insertDataList(lgd);
    }

    public static  GwData setColumns( GwData gwA, GwData gwB){
        Field[] fields=GwData.class.getDeclaredFields();
        JSONObject gwAJson = (JSONObject) JSON.toJSON(gwA);
        JSONObject gwBJson = (JSONObject) JSON.toJSON(gwB);
        for(int i=0;i<fields.length;i++){
            gwAJson.put(fields[i].getName(),gwBJson.get(fields[i].getName()));
        }
        gwA=JSON.parseObject(gwAJson.toJSONString(),gwA.getClass());
        return gwA;
    }

}

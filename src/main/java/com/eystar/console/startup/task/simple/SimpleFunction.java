package com.eystar.console.startup.task.simple;

import com.eystar.console.startup.bean.FlowData;
import com.eystar.console.startup.transform.CommonFunction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;


public class SimpleFunction extends CommonFunction {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    /**
     * github地址: https://github.com/intsmaze
     * 博客地址：https://www.cnblogs.com/intsmaze/
     * 出版书籍《深入理解Flink核心设计与实践原理》
     *
     * @auther: intsmaze(刘洋)
     * @date: 2020/10/15 18:33
     */
    @Override
    public String execute(String message) throws Exception {

        FlowData flowData = gson.fromJson(message, new TypeToken<FlowData>() {
        }.getType());

        String flowUUID = dataService.findUUID(flowData);
        if (StringUtils.isBlank(flowUUID)) {
            flowUUID = UUID.randomUUID().toString();
            flowData.setUuid(flowUUID);
            dataService.insertFlow(flowData);
        }
        return gson.toJson(flowData);
    }
}

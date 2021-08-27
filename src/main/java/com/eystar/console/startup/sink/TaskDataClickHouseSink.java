package com.eystar.console.startup.sink;

import com.alibaba.fastjson.JSONObject;
import com.eystar.common.util.IPHelper;
import com.eystar.common.util.RedisModifyHelper;
import com.eystar.common.util.UUIDKit;
import com.eystar.console.startup.cache.redis.util.RedisUtils;
import com.eystar.console.startup.entity.gwdata.GwData;
import com.eystar.console.startup.env.BeanFactory;
import com.eystar.console.startup.handler.message.DataMessage;
import com.eystar.console.startup.handler.parser.AbstractDataParser;
import com.eystar.console.startup.handler.probe.ProbeAccessTypeHelper;
import com.eystar.console.startup.handler.thread.ProbeRegistThread;
import com.eystar.console.startup.service.*;
import com.eystar.console.startup.service.impl.*;
import com.eystar.console.startup.util.InfoLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;


public class TaskDataClickHouseSink extends RichSinkFunction<AbstractDataParser> {
    private final static Logger logger = LoggerFactory.getLogger(TaskDataClickHouseSink.class);
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private RedisUtils redisUtils;
    private ProbeService probeService;
    private IpRegionService ipRegionService;
    private PdcRegionService pdcRegionService;
    protected ApplicationContext beanFactory;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        ExecutionConfig.GlobalJobParameters globalJobParameters = getRuntimeContext()
                .getExecutionConfig().getGlobalJobParameters();
        beanFactory = BeanFactory.getBeanFactory((Configuration) globalJobParameters);

        redisUtils = beanFactory.getBean(RedisUtils.class);
        probeService = beanFactory.getBean(ProbeServiceImpl.class);
        ipRegionService = beanFactory.getBean(IpRegionServiceImpl.class);
        pdcRegionService = beanFactory.getBean(PdcRegionServiceImpl.class);

        //初始化工具类数据
        InfoLoader.init(redisUtils,probeService);
        IPHelper.init(redisUtils,ipRegionService,pdcRegionService);
        RedisModifyHelper.init(redisUtils);

    }

    @Override
    public void invoke(AbstractDataParser parser, Context context) throws Exception {
        DataMessage message = parser.getMessage();
		GwData record = new GwData();
        // 封装基础信息
		record.setId(UUIDKit.nextShortUUID());
		record.setProbeId( message.getProbeId());
		record.setTaskFrom( message.getTaskFrom());
		record.setTaskId( message.getTaskId());
		record.setTaskTypeName( message.getTaskTypeName());
		record.setTestTime( message.getTestTime());
		// 封装探针信息
		JSONObject probeJson = InfoLoader.loadProbe(message.getProbeId());
		record.setProbeAlias( probeJson.getString("probe_alias"));
		record.setProbeName(probeJson.getString("probe_name"));
		record.setPppoeUsername( probeJson.getString("pppoe_username"));
		record.setLoid( probeJson.getString("loid"));
		record.setSerialNum( probeJson.getString("sn"));
		record.setProbeIp(probeJson.getString("ip"));
		record.setPc(probeJson.getString("pc"));
		record.setVendor(probeJson.getString("vendor"));
		record.setProvinceName(probeJson.getString("province_name"));
		record.setProvinceCode(probeJson.getLong("province_code"));
		record.setCityName(probeJson.getString("city_name"));
		record.setCityCode(probeJson.getLong("city_code"));
		record.setDistrictName( probeJson.getString("district_name"));
		record.setDistrictCode(probeJson.getLong("district_code"));
		record.setTownName(probeJson.getString("town_name"));
		record.setTownCode( probeJson.getLong("town_code"));
        System.out.println("return ==>"+record.toString());
//        parser.process();
    }


    @Override
    public void close() throws Exception {
        super.close();
    }


}

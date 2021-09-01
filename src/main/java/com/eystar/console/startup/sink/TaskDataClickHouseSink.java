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
import com.eystar.console.startup.handler.parser.DataParserHelper;
import com.eystar.console.startup.handler.parser.ParserContext;
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


public class TaskDataClickHouseSink extends RichSinkFunction<DataMessage> {
    private final static Logger logger = LoggerFactory.getLogger(TaskDataClickHouseSink.class);
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private RedisUtils redisUtils;
    private ProbeService probeService;
    private IpRegionService ipRegionService;
    private PdcRegionService pdcRegionService;
    private TaskSrcDesService taskSrcDesService;
    private TaskParamService taskParamService;
    private GwDataService gwDataService;
    private GwDataDetailService gwDataDetailService;

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
        taskSrcDesService=beanFactory.getBean(TaskSrcDesServiceImpl.class);
        taskParamService=beanFactory.getBean(TaskParamServiceImpl.class);
        gwDataService=beanFactory.getBean(GwDataServiceImpl.class);
        gwDataDetailService=beanFactory.getBean(GwDataDetailServiceImpl.class);
        //初始化工具类数据
        InfoLoader.init(redisUtils,probeService);
        InfoLoader.taskInit(taskSrcDesService,taskParamService);
        IPHelper.init(redisUtils,ipRegionService,pdcRegionService);
        RedisModifyHelper.init(redisUtils);
        DataParserHelper.init(gwDataService,gwDataDetailService);
        ParserContext.init();
    }

    @Override
    public void invoke(DataMessage message, Context context) throws Exception {
        long start1 = System.currentTimeMillis();
        AbstractDataParser parser = ParserContext.getDataItemParser(message.getTaskTypeName());
        parser.process(message);
        System.out.println("其中处理一条数据的时间 = " + (System.currentTimeMillis() - start1) + " ms");
        super.invoke(message, context);
    }


    @Override
    public void close() throws Exception {
        super.close();
    }


}

package com.eystar.console.startup.transform;

import com.eystar.console.startup.env.BeanFactory;
import org.apache.flink.api.common.ExecutionConfig;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;
import org.springframework.context.ApplicationContext;


public abstract class CommonDataSource extends RichParallelSourceFunction<String> {


    protected ApplicationContext beanFactory;


    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        ExecutionConfig.GlobalJobParameters globalJobParameters = getRuntimeContext()
                .getExecutionConfig().getGlobalJobParameters();
        beanFactory = BeanFactory.getBeanFactory((Configuration) globalJobParameters);
    }


    public void run(SourceContext<String> sourceContext) throws Exception {
        while (true) {
            sourceContext.collect(sendMess());
        }
    }


    public abstract String sendMess() throws Exception;



    public void cancel() {

    }
}

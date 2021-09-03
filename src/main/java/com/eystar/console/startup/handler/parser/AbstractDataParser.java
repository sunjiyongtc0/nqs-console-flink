package com.eystar.console.startup.handler.parser;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eystar.common.util.IPHelper;
import com.eystar.common.util.UUIDKit;
import com.eystar.common.util.XxlConfBean;
import com.eystar.console.startup.entity.gwdata.*;
import com.eystar.console.startup.handler.message.DataMessage;
import com.eystar.console.startup.kafka.KafkaMessageProducer;
import com.eystar.console.startup.util.InfoLoader;
import com.eystar.console.startup.util.ScoreHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;


public abstract class AbstractDataParser {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractDataParser.class);

	private  GwData fillRecord(DataMessage message) {
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
//		record.setProbeAlias( probeJson.getString(ChangeChar.underlineToCamel("probe_alias")));
//		record.setProbeName(probeJson.getString(ChangeChar.underlineToCamel("probe_name")));
//		record.setPppoeUsername( probeJson.getString(ChangeChar.underlineToCamel("pppoe_username")));
//		record.setLoid( probeJson.getString(ChangeChar.underlineToCamel("loid")));
//		record.setSerialNum( probeJson.getString(ChangeChar.underlineToCamel("sn")));
//		record.setProbeIp(probeJson.getString(ChangeChar.underlineToCamel("ip")));
//		record.setPc(probeJson.getString(ChangeChar.underlineToCamel("pc")));
//		record.setVendor(probeJson.getString(ChangeChar.underlineToCamel("vendor")));
//		record.setProvinceName(probeJson.getString(ChangeChar.underlineToCamel("province_name")));
//		record.setProvinceCode(probeJson.getLong(ChangeChar.underlineToCamel("province_code")));
//		record.setCityName(probeJson.getString(ChangeChar.underlineToCamel("city_name")));
//		record.setCityCode(probeJson.getLong(ChangeChar.underlineToCamel("city_code")));
//		record.setDistrictName( probeJson.getString(ChangeChar.underlineToCamel("district_name")));
//		record.setDistrictCode(probeJson.getLong(ChangeChar.underlineToCamel("district_code")));
//		record.setTownName(probeJson.getString(ChangeChar.underlineToCamel("town_name")));
//		record.setTownCode( probeJson.getLong(ChangeChar.underlineToCamel("town_code")));
		// 封装更多时间标签
		Date date = new Date(message.getTestTime() * 1000);
		record.setTestTimeH( DateUtil.beginOfDay(date).getTime() / 1000 + DateUtil.hour(date, true) * 3600);
		record.setTestTimeD( DateUtil.beginOfDay(date).getTime() / 1000);
		record.setTestTimeW( DateUtil.beginOfWeek(date).getTime() / 1000);
		record.setTestTimeM( DateUtil.beginOfMonth(date).getTime() / 1000);
		// 封装任务信息
		JSONObject taskJson = InfoLoader.loadTaskSrcDest(message.getTaskId());
		// 系统中已删除的任务处理
		try {
			if (taskJson.isEmpty()) {
				String error = "taskId = [" + message.getTaskId() + "],系统中不存在";
//				System.out.println(error);
//				throw new IllegalArgumentException(error);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
				return  null;
		}

		//TODO 更改获取方式获取key值发生变化
		JSONObject taskParamJson = InfoLoader.loadTaskParam(taskJson.getString("taskParamId"));
		record.setTaskMd5( taskJson.getString("taskMd5"));
		record.setTaskParamId(taskJson.getString("taskParamId"));
		record.setTaskParamName( taskParamJson == null ? "" : taskParamJson.getString("taskParamName"));
		record.setAccessTypeName(taskJson.getString("accessTypeName"));
		record.setDestId(taskJson.getString("destId"));
		record.setDestName( taskJson.getString("destName"));
		record.setDestAddr(taskJson.getString("destAddr"));
		// 默认host_province、host_city、operator从任务中获取
		//TODO 入库task_src_dest 值少
//		record.setHostProvince( taskJson.getString("host_province"));
//		record.setHostCity(taskJson.getString("host_city"));
//		record.setOperator( taskJson.getString("operator"));
		// 解析host_ip
		if (StrUtil.isNotBlank(record.getHostIp())) {
			JSONObject ipInfo = IPHelper.getIpInfo(record.getHostIp());
			record.setHostProvince( ipInfo.getString("province_name"));// 省
			record.setHostCity( ipInfo.getString("city_name"));// 市
			record.setOperator( ipInfo.getString("operator"));// 运营商
		}
		return record;
	}

	public abstract void prepare(GwData record);


	public void process(DataMessage message) {
		try {
			System.out.println("任务类型："+message.getTaskTypeName());
			// 对数据进行预处理
			GwData record = fillRecord(message);
			if(record==null){
				return;
			}
			JSONObject MsgJson = message.getMsgJson();
			JSONObject jsonGwData = (JSONObject) JSON.toJSON(record);
			Field[] fields=getGwData(message.getTaskTypeName()).getDeclaredFields();
			for(int i=0;i<fields.length;i++){
				jsonGwData.put(fields[i].getName(),MsgJson.get(fields[i].getName()));
//				jsonGwData.put(fields[i].getName(),MsgJson.get(ChangeChar.camelToUnderline(fields[i].getName(),1)));
			}
			GwData gdTask=JSON.parseObject(jsonGwData.toJSONString(),getGwData(message.getTaskTypeName()));
			prepare(gdTask);
			JSONObject gdTaskJson = (JSONObject) JSON.toJSON(gdTask);
			ScoreHelper.fillScore(gdTaskJson);
			GwData saveRecord=JSON.parseObject(gdTaskJson.toJSONString(),getGwData(message.getTaskTypeName()));

			saveRecord.setCreateTime(saveRecord.getTestTime());
			saveRecord.setMonthTime((DateUtil.beginOfMonth(new Date(saveRecord.getTestTime() * 1000L)).toJdkDate()));
			JSONObject lastJson = (JSONObject) JSON.toJSON(saveRecord);
//			// 5、将数据保存到bigdata中
			DataParserHelper.insertData(saveRecord);
//			// 6、将保存后的数据消息发送到kafka中
			sendSavedToKafka(saveRecord);
			after(saveRecord);
			System.out.println("拼接入库操作理论上走"+saveRecord.toString());
		} catch (Exception e) {
			System.out.println("解析数据处理失败，本次数据的内容 = " + message.toString()+e.getMessage());
			e.printStackTrace();
		}
	}

	public static Class<? extends GwData> getGwData(String taskTypeName){

		if(StrUtil.equals("HTTP",taskTypeName)) {
			return  GwHttpData.class;
		}else	if(StrUtil.equals("PING",taskTypeName)){
			return GwPingData.class;
		}else	if(StrUtil.equals("DNS",taskTypeName)){
			return GwDnsData.class;
		}else if(StrUtil.equals("FLASH",taskTypeName)){
			return GwFlashData.class;
		}else{
			return GwData.class;
		}
	}

	private void sendSavedToKafka(GwData saveRecord) {
		JSONObject taskParam = InfoLoader.loadTaskParam(saveRecord.getTaskParamId());
		JSONObject saveRecordJson=(JSONObject) JSON.toJSON(saveRecord);
		if (taskParam != null && !taskParam.isEmpty()) {
			String alarmTemplateId = taskParam.getString("alarm_template_id");
			if (StrUtil.isNotBlank(alarmTemplateId)) {
				JSONObject alarmTemplate = InfoLoader.loadAlarmTemplate(alarmTemplateId);
				if (alarmTemplate != null && !alarmTemplate.isEmpty()) {
					saveRecordJson.put("alarm_template_id", alarmTemplateId);
					saveRecordJson.put("alarm_template_json", alarmTemplate);
				}
			}
		}
		KafkaMessageProducer.send(XxlConfBean.getXxlValueByString("gw-console.kafka.topic.data.saved"),saveRecordJson.toJSONString());
	}

	public abstract void after(GwData record);
}

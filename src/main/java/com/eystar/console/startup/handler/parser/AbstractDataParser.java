package com.eystar.console.startup.handler.parser;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.eystar.common.util.IPHelper;
import com.eystar.common.util.UUIDKit;
import com.eystar.console.startup.entity.gwdata.GwData;
import com.eystar.console.startup.handler.message.DataMessage;
import com.eystar.console.startup.util.InfoLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


public abstract class AbstractDataParser {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractDataParser.class);

	private  DataMessage message;

	public   void init(DataMessage msg){
		message=msg;
	}

	public  DataMessage getMessage(){
		return message;
	}


//	private  GwData fillRecord() {
//		GwData record = new GwData();
		// 封装基础信息
//		record.setId(UUIDKit.nextShortUUID());
		/*record.setProbeId( message.getProbeId());
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
		record.setTownCode( probeJson.getLong("town_code"));*/
		// 封装任务信息
//		JSONObject taskJson = InfoLoader.loadTaskSrcDest(message.getTaskId());
//		// 系统中已删除的任务处理
//		if (taskJson.isEmpty()) {
//			String error = "taskId = [" + message.getTaskId() + "],系统中不存在";
//			logger.error(error);
//			throw new IllegalArgumentException(error);
//		}
//		JSONObject taskParamJson = InfoLoader.loadTaskParam(taskJson.getString("task_param_id"));
//		record.set("task_md5", taskJson.get("task_md5"));
//		record.set("task_param_id", taskJson.get("task_param_id"));
//		record.set("task_param_name", taskParamJson == null ? "" : taskParamJson.get("task_param_name"));
//		record.set("access_type_name", taskJson.get("access_type_name"));
//		record.set("dest_id", taskJson.get("dest_id"));
//		record.set("dest_name", taskJson.get("dest_name"));
//		record.set("dest_addr", taskJson.get("dest_addr"));
//		// 默认host_province、host_city、operator从任务中获取
//		record.set("host_province", taskJson.get("host_province"));// 省
//		record.set("host_city", taskJson.get("host_city"));// 市
//		record.set("operator", taskJson.get("operator"));// 运营商
//		// 封装更多时间标签
		/*Date date = new Date(message.getTestTime() * 1000);
		record.setTestTimeH( DateUtil.beginOfDay(date).getTime() / 1000 + DateUtil.hour(date, true) * 3600);
		record.setTestTimeD( DateUtil.beginOfDay(date).getTime() / 1000);
		record.setTestTimeW( DateUtil.beginOfWeek(date).getTime() / 1000);
		record.setTestTimeM( DateUtil.beginOfMonth(date).getTime() / 1000);*/
//		Map<String, MetaDataField> map = ParserContext.getMetaDataField(message.getTaskTypeName());
//		JSONObject object = message.getMsgJson();
//		for (String key : object.keySet()) {
//			if (record.get(key) != null || !map.containsKey(key)) { // 说明上面给此record设置过值
//																	// 或者
//																	// 元数据里面没有这个key
//				continue;
//			}
//			setRecordValueByType(record, map.get(key), object, key);
//		}
		// 解析host_ip
		/*if (StrUtil.isNotBlank(record.getHostIp())) {
			JSONObject ipInfo = IPHelper.getIpInfo(record.getHostIp());
			record.setHostProvince( ipInfo.getString("province_name"));// 省
			record.setHostCity( ipInfo.getString("city_name"));// 市
			record.setOperator( ipInfo.getString("operator"));// 运营商
		}*/
//		return record;
//	}

	public abstract void prepare(GwData record);
//
//	// -----------------------------------------------------
	public void process() {
		try {
			System.out.println("任务类型："+message.getTaskTypeName());
//			GwData record = fillRecord();
//			System.out.println(record.toString());
			// 2、对数据进行预处理
//			prepare(record);
//			System.out.println("拼接入库操作理论上走"+record.toString());
			// 3、过滤掉非元数据表中的字段
//			Record saveRecord = new Record();
//			saveRecord.setColumns(record);
//			Map<String, MetaDataField> map = ParserContext.getMetaDataField(message.getTaskTypeName());
//			String[] names = saveRecord.getColumnNames();
//			for (String key : names) {
//				if (!map.containsKey(key)) { // 元数据里面没有这个key
//					saveRecord.remove(key);
//				}
//			}
//			ScoreHelper.fillScore(saveRecord);
//			// 4、对数据进行过滤
//			// TODO 对数据过滤
//
//			// 5、将数据保存到Crate中
//			MetaData metaData = ParserContext.getMetaData(message.getTaskTypeName());
//			saveRecord.set("create_time", saveRecord.getLong("test_time"));
//			saveRecord.set("month_time", DateUtil.formatDate((Date) DateUtil.beginOfMonth(new Date(saveRecord.getLong("test_time_m").longValue() * 1000L))));
//			BigDataDb.use().save(metaData.getStr("meta_table"), saveRecord);
//			// 6、将保存后的数据消息发送到kafka中
//			if (OperationConfig.isReplace) {
//				sendSavedToKafka(saveRecord);
//			}
//			// 7、异步调用善后处理方法
//			final Record record2 = record;
//			ThreadUtil.execute(() -> {
//				after(record2);
//			});
		} catch (Exception e) {
			System.out.println("解析数据处理失败，本次数据的内容 = " + message.toString()+e.getMessage());
			e.printStackTrace();
		}
	}
//
//	/**
//	 *
//	 * 根据数据类型不同，给record的属性设置不同的值<br>
//	 * 添加: 张俭 - 2020年9月25日 下午11:27:12<br>
//	 * 修改: 张俭 - 2020年9月25日 下午11:27:12<br>
//	 * --------------------------------------------------------------------
//	 *
//	 * @param record
//	 * @param field
//	 * @param srcObject
//	 * @param key
//	 */
//	protected void setRecordValueByType(Record record, MetaDataField field, JSONObject srcObject, String key) {
//		try {
//			switch (field.getInt("data_type")) {
//			case 1:
//				record.set(key, srcObject.getInteger(key));
//				break;
//			case 2:
//				record.set(key, srcObject.getDouble(key));
//				break;
//			case 3:
//				record.set(key, srcObject.getString(key));
//				break;
//			default:
//				record.set(key, srcObject.get(key));
//				break;
//			}
//		} catch (Exception e) {
//			logger.error("根据类型不同，设置类型 = " + record.getStr("task_type_name") + " 的指标 = " + key + " 出现异常", e);
//		}
//
//	}
//
//	/**
//	 *
//	 * 将保存后的数据，发送到kafka供其他程序解析<br>
//	 * 添加: 张俭 - 2020年10月25日 下午5:09:57<br>
//	 * 修改: 张俭 - 2020年10月25日 下午5:09:57<br>
//	 *
//	 * @param saveRecord
//	 */
//	private void sendSavedToKafka(Record saveRecord) {
//		JSONObject taskParam = InfoLoader.loadTaskParam(saveRecord.getStr("task_param_id"));
//		if (taskParam != null && !taskParam.isEmpty()) {
//			String alarmTemplateId = taskParam.getString("alarm_template_id");
//			if (StrUtil.isNotBlank(alarmTemplateId)) {
//				JSONObject alarmTemplate = InfoLoader.loadAlarmTemplate(alarmTemplateId);
//				if (alarmTemplate != null && !alarmTemplate.isEmpty()) {
//					saveRecord.set("alarm_template_id", alarmTemplateId);
//					saveRecord.set("alarm_template_json", alarmTemplate);
//				}
//			}
//		}
//		KafkaMessageProducer.send(XxlConfClient.get("gw-console.kafka.topic.data.saved"), saveRecord.toJson());
//	}
//
//	/**
//	 *
//	 * 对已经入库的数据进行处理，此record中已经存在id-此方法为异步方法<br>
//	 * 添加: 张俭 - 2020年9月6日 下午9:01:15<br>
//	 * 修改: 张俭 - 2020年9月6日 下午9:01:15<br>
//	 *
//	 * @param record
//	 */
//	public abstract void after(Record record);
//
//	public static void main(String[] args) {
//		Record record = new Record();
//		record.set("info", JSONObject.parseObject("{'name':'zj','age':19}"));
//		JSONObject object = JSONObject.parseObject(record.toJson());
//		JSONObject info = object.getJSONObject("info");
//		System.out.println(info);
//	}

}

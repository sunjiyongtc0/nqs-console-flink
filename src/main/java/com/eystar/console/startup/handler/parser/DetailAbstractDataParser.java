package com.eystar.console.startup.handler.parser;

import java.util.Date;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eystar.common.util.IPHelper;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

public abstract class DetailAbstractDataParser extends AbstractDataParser {

	private String taskTypeName;

	public DetailAbstractDataParser() {

	}

	public DetailAbstractDataParser(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

//	@Override
//	public void prepare(Record record) {
//
//	}
//
//	@Override
//	public void after(Record srcRecord) {
//		JSONArray array = null;
//		try {
//			array = JSONArray.parseArray(srcRecord.getStr("detail"));
//			if (array == null) {
//				return;
//			}
//		} catch (Exception e) {
//			logger.error("解析detai出错，不是JSON格式，类型 = " + taskTypeName + "，detai = " + srcRecord.getStr("detail"), e);
//			return;
//		}
//		List<Record> records = new ArrayList<Record>();
//		Map<String, MetaDataField> map = ParserContext.getMetaDataField(taskTypeName);
//		for (int i = 0; i < array.size(); i++) {
//			Record record = new Record();
//			record.setColumns(srcRecord);
//			record.set("id", UUIDKit.nextShortUUID()); // 重新生成任务ID
//			record.set("parent_id", srcRecord.getStr("id"));
//			JSONObject object = array.getJSONObject(i);
//			for (String key : object.keySet()) { // 循环指标
//				if (!map.containsKey(key)) { // 元数据里面没有这个key
//					continue;
//				}
//				MetaDataField field = map.get(key);
//				setRecordValueByType(record, field, object, key);
//			}
//			if (StrUtil.isNotBlank(record.getStr("host_ip"))) {
//				JSONObject ipInfo = IPHelper.getIpInfo(record.getStr("host_ip"));
//				record.set("host_province", ipInfo.get("province_name"));// 省
//				record.set("host_city", ipInfo.get("city_name"));// 市
//				record.set("operator", ipInfo.get("operator"));// 运营商
//			}
//			fillEachDetailRecord(record);
//			// 3、过滤掉非元数据表中的字段
//			Map<String, MetaDataField> map2 = ParserContext.getMetaDataField(taskTypeName);
//			String[] names = record.getColumnNames();
//			for (String key : names) {
//				if (!map2.containsKey(key)) { // 元数据里面没有这个key
//					record.remove(key);
//				}
//			}
//			record.set("create_time", record.getLong("test_time"));
//			record.set("month_time", DateUtil.formatDate((Date) DateUtil.beginOfMonth(new Date(record.getLong("test_time_m").longValue() * 1000L))));
//			records.add(record);
//		}
//		MetaData metaData = ParserContext.getMetaData(taskTypeName);
//		try {
//			BigDataDb.use().batchSave(metaData.getStr("meta_table"), records, 20);
//		} catch (Exception e) {
//			logger.error("批量保存" + taskTypeName + "的数据出现错误，父ID = " + srcRecord.getStr("parent_id") + "，待保存的JSON = " + srcRecord.getStr("detail"), e);
//		}
//	}
//
//	public abstract void fillEachDetailRecord(Record record);
}

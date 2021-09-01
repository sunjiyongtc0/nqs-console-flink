package com.eystar.console.startup.handler.parser;

import java.util.HashMap;
import java.util.Map;

import com.eystar.console.startup.util.InfoLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ParserContext {

	private static Logger logger = LoggerFactory.getLogger(ParserContext.class);

	private static Map<String, Class<? extends AbstractDataParser>> parserDepot = new HashMap<>();
//	private static Map<String, List<MetaDataField>> fieldsDepot = new HashMap<>();
//	private static Map<String, MetaData> metaDataDepot = new HashMap<>();
//	private static Map<String, Map<String, MetaDataField>> metaDataFieldDepot = new HashMap<>();

	public static void init() {
		registerParser("HTTP", HttpDataParser.class);
		registerParser("DNS", DnsDataParser.class);
		registerParser("TRACE", TraceDataParser.class);
		registerParser("GAME", GameDataParser.class);
//		InfoLoader.loadIpRegion(); // 将IP缓存到redis中
	}


	public static void registerParser(String typeName, Class<? extends AbstractDataParser> clazz) {
		parserDepot.put(typeName, clazz);
	}


//	public static void registerMetaDataFields(String typeName, List<MetaDataField> fields) {
//		fieldsDepot.put(typeName, fields);
//	}


//	public static void registerMetaData(String typeName, MetaData data) {
//		metaDataDepot.put(typeName, data);
//	}

	public synchronized static AbstractDataParser getDataItemParser(String typeName) {
		if (parserDepot.get(typeName.toUpperCase()) != null) {
			try {
				return parserDepot.get(typeName).newInstance();
			} catch (InstantiationException e) {
				logger.error("根据类型名称" + typeName + "创建解析对象出错", e);
			} catch (IllegalAccessException e) {
				logger.error("实例化" + typeName + "的解析对象时出现异常，可能不存在构造方法", e);
			}
		}
		return new DefaultDataParser();
	}


//	public synchronized static List<MetaDataField> getMetaDataFields(String typeName) {
//		if (fieldsDepot.containsKey(typeName)) {
//			return fieldsDepot.get(typeName);
//		}
//		List<MetaDataField> fields = MetaDataField.dao.findAllFieldsByMetaType(typeName);
//		fieldsDepot.put(typeName, fields);
//		return fields;
//	}


//	public synchronized static Map<String, MetaDataField> getMetaDataField(String typeName) {
//		if (metaDataFieldDepot.containsKey(typeName)) {
//			return metaDataFieldDepot.get(typeName);
//		}
//		Map<String, MetaDataField> map = new HashMap<>();
//		List<MetaDataField> fields = getMetaDataFields(typeName);
//		for (MetaDataField field : fields) {
//			map.put(field.getStr("field_name"), field);
//		}
//		metaDataFieldDepot.put(typeName, map);
//		return map;
//	}


//	public synchronized static MetaData getMetaData(String typeName) {
//		if (metaDataDepot.containsKey(typeName)) {
//			return metaDataDepot.get(typeName);
//		}
//		List<MetaData> fields = MetaData.dao.findAll();
//		for (MetaData metaData : fields) {
//			metaDataDepot.put(metaData.getStr("meta_type"), metaData);
//		}
//		return metaDataDepot.get(typeName);
//	}
}
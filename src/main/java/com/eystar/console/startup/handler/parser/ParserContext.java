package com.eystar.console.startup.handler.parser;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ParserContext {

	private static Logger logger = LoggerFactory.getLogger(ParserContext.class);

	private static Map<String, Class<? extends AbstractDataParser>> parserDepot = new HashMap<>();
//	private static Map<String, List<MetaDataField>> fieldsDepot = new HashMap<>();
//	private static Map<String, MetaData> metaDataDepot = new HashMap<>();
//	private static Map<String, Map<String, MetaDataField>> metaDataFieldDepot = new HashMap<>();

	public static void init() {
//		registerParser("HTTP", HttpDataParser.class);
//		registerParser("DNS", DnsDataParser.class);
////		registerParser("TRACE", TraceDataParser.class);
////		registerParser("GAME", GameDataParser.class);
//		InfoLoader.loadIpRegion(); // 将IP缓存到redis中
	}


	public static void registerParser(String typeName, Class<? extends AbstractDataParser> clazz) {
		parserDepot.put(typeName, clazz);
	}


	public synchronized static AbstractDataParser getDataItemParser(String typeName) {
//		if (parserDepot.get(typeName.toUpperCase()) != null) {
//			try {
//				return parserDepot.get(typeName).newInstance();
//			} catch (InstantiationException e) {
//				logger.error("根据类型名称" + typeName + "创建解析对象出错", e);
//			} catch (IllegalAccessException e) {
//				logger.error("实例化" + typeName + "的解析对象时出现异常，可能不存在构造方法", e);
//			}
//		}
		return new DefaultDataParser();
	}

//
//	/**
//	 *
//	 * 根据类型名称注册每种类型的字段<br>
//	 * 添加: 张俭 - 2020年8月29日 下午9:54:57<br>
//	 * 修改: 张俭 - 2020年8月29日 下午9:54:57<br>
//	 *
//	 * @param typeName
//	 * @param fields
//	 */
//	public static void registerMetaDataFields(String typeName, List<MetaDataField> fields) {
//		fieldsDepot.put(typeName, fields);
//	}
//
//	/**
//	 *
//	 * 根据类型名称注册每种类型<br>
//	 * 添加: 张俭 - 2020年8月29日 下午9:54:57<br>
//	 * 修改: 张俭 - 2020年8月29日 下午9:54:57<br>
//	 *
//	 * @param typeName
//	 * @param fields
//	 */
//	public static void registerMetaData(String typeName, MetaData data) {
//		metaDataDepot.put(typeName, data);
//	}
//

//
//	/**
//	 *
//	 * 根据不同类型获取该类型的所有字段<br>
//	 * 添加: 张俭 - 2020年9月5日 上午9:42:54<br>
//	 * 修改: 张俭 - 2020年9月5日 上午9:42:54<br>
//	 * ------------------------------------------------------------
//	 *
//	 * @param typeName
//	 * @return
//	 */
//	public synchronized static List<MetaDataField> getMetaDataFields(String typeName) {
//		if (fieldsDepot.containsKey(typeName)) {
//			return fieldsDepot.get(typeName);
//		}
//		List<MetaDataField> fields = MetaDataField.dao.findAllFieldsByMetaType(typeName);
//		fieldsDepot.put(typeName, fields);
//		return fields;
//	}
//
//	/**
//	 * 获取每种类型的字段<br>
//	 * 添加: 张俭 - 2020年9月24日 下午10:45:48<br>
//	 * 修改: 张俭 - 2020年9月24日 下午10:45:48<br>
//	 * ---------------------------------------------------------------------------
//	 *
//	 * @param typeName
//	 * @return
//	 */
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
//
//	/**
//	 *
//	 * 根据不同类型获取该类型的结构信息，主要是获取表结构<br>
//	 * 添加: 张俭 - 2020年9月5日 上午9:43:11<br>
//	 * 修改: 张俭 - 2020年9月5日 上午9:43:11<br>
//	 * ------------------------------------------------------
//	 *
//	 * @param typeName
//	 * @return
//	 */
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

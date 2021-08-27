package com.eystar.console.startup.handler.parser;

import com.eystar.console.startup.entity.gwdata.GwData;

//---------------------------------------------------------------------
public class HttpDataParser extends DetailAbstractDataParser {

	public HttpDataParser() {
		super("HTTP_DETAIL");
	}

	@Override
	public void prepare(GwData record) {
		System.out.println("HttpDataParser"+"====-----===>prepare");
	}

//	@Override
//	public void prepare(Record record) {
//		double first_screen_cost = 0d; // 首屏时延
//		double avg_speed = 0d; // 下载速度
//		double text_cost = 0d; // 文本传输时延
//		double page_total_cost = 0d; // 网页总时延
//		double conn_cost = 0d; // 连接时延
//		double page_avg_speed = 0d; // 首页下载速率
//
//		double page_size = NumberKit.valueOfDouble(record.getDouble("page_size"), 0d);
//		double element_total_size = NumberKit.valueOfDouble(record.getDouble("element_total_size"), 0d);
//		double trans_body_cost = NumberKit.valueOfDouble(record.getDouble("trans_body_cost"), 0d);
//		double dns_cost = NumberKit.valueOfDouble(record.getDouble("dns_cost"), 0d);
//		double tcp_cost = NumberKit.valueOfDouble(record.getDouble("tcp_cost"), 0d);
//		double ssl_cost = NumberKit.valueOfDouble(record.getDouble("ssl_cost"), 0d);
//		// 下载速率
//		avg_speed = trans_body_cost == 0 ? 0 : NumberUtil.div(page_size, trans_body_cost / 1000, 4);
//		// 连接时延
//		conn_cost = dns_cost + tcp_cost + ssl_cost;
//		// 文本打开时延
//		text_cost = conn_cost + trans_body_cost;
//
//		// 解析 detail
//		try {
//			JSONArray array = JSONArray.parseArray(record.getStr("detail"));
//			parseDetail(record, array);
//		} catch (Exception e) {
//			logger.error("解析detai出错，不是JSON格式，类型 = HTTP，detai = " + record.getStr("detail"), e);
//		}
//
//		Double element_load_cost = record.getDouble("element_load_cost");
//		if (element_load_cost == null) {
//			element_load_cost = 0d;
//		}
//		// 首屏时间
//		first_screen_cost = text_cost + element_load_cost * XxlConfClient.getDouble("gw-console.data.http.firstscreencost");
//		// 页面总时延（文本+元素）
//		page_total_cost = text_cost + element_load_cost;
//		// 首页下载速率（文本+元素/页面总时延）
//		page_avg_speed = page_total_cost == 0 ? 0 : NumberUtil.div(page_size + element_total_size, page_total_cost / 1000, 4);
//
//		record.set("conn_cost", conn_cost);
//		record.set("avg_speed", avg_speed);
//		record.set("text_cost", text_cost);
//		record.set("page_avg_speed", page_avg_speed);
//		record.set("first_screen_cost", first_screen_cost);
//		record.set("page_total_cost", page_total_cost);
//	}
//
//	/**
//	 *
//	 * 解析HTTP Detail的数据<br>
//	 * 添加: 张俭 - 2020年9月27日 上午11:22:31<br>
//	 * 修改: 张俭 - 2020年9月27日 上午11:22:31<br>
//	 *
//	 * @param record
//	 * @param array
//	 */
//	private void parseDetail(Record record, JSONArray array) {
//		if (array == null) {
//			return;
//		}
//		Map<Long, Double> rtt_map = new HashMap<>();
//		int elements_success_sum = 0;
//		int elements_fail_sum = 0;
//		double element_total_size = 0d;
//		for (int i = 0; i < array.size(); i++) {
//			JSONObject detail = array.getJSONObject(i);
//			long element_status = detail.getLongValue("element_status");
//			if (0 == element_status) {
//				elements_success_sum++;
//			} else {
//				elements_fail_sum++;
//			}
//			double dns_cost = detail.getDoubleValue("dns_cost");
//			double tcp_cost = detail.getDoubleValue("tcp_cost");
//			double ssl_cost = detail.getDoubleValue("ssl_cost");
//			double element_download_cost = detail.getDoubleValue("element_download_cost");
//			// 连接时延
//			double conn_cost = dns_cost + tcp_cost + ssl_cost;
//			detail.put("conn_cost", conn_cost);
//			// 单个元素总时延
//			double element_total_cost = conn_cost + element_download_cost;
//			detail.put("element_total_cost", element_total_cost);
//			// 下载速度
//			double avg_speed = element_download_cost == 0 ? 0 : NumberUtil.div(detail.getDoubleValue("element_size"), element_download_cost / 1000, 4);
//			detail.put("avg_speed", avg_speed);
//			// 每个线程下载元素的最大值
//			long thread_num = detail.getLongValue("thread_num");
//			if (null == rtt_map.get(thread_num)) {
//				rtt_map.put(thread_num, element_total_cost);
//			} else {
//				rtt_map.put(thread_num, rtt_map.get(thread_num) + element_total_cost);
//			}
//			// 所有元素大小
//			element_total_size += detail.getDoubleValue("element_size");
//		}
//		// 元素成功率
//		double elements_success_rate = 0d;
//		if (0 != array.size()) {
//			elements_success_rate = NumberUtil.round(NumberUtil.div(elements_success_sum, array.size()) * 100, 4).doubleValue();
//		}
//		// 元素加载时延
//		double element_load_cost = 0d;
//		for (Entry<Long, Double> a : rtt_map.entrySet()) {
//			if (a.getValue() > element_load_cost) {
//				element_load_cost = a.getValue();
//			}
//		}
//		record.set("elements_sum", array.size());
//		record.set("elements_success_sum", elements_success_sum);
//		record.set("elements_fail_sum", elements_fail_sum);
//		record.set("element_load_cost", element_load_cost);
//		record.set("element_total_size", element_total_size);
//		record.set("elements_success_rate", elements_success_rate);
//		record.set("detail_json", array);
//	}
//
//	@Override
//	public void fillEachDetailRecord(Record record) {
//
//	}
}

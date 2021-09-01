package com.eystar.console.startup.handler.parser;



import com.eystar.console.startup.entity.gwdata.GwData;

//------------------------------------------------------------------------
public class GameDataParser extends AbstractDataParser {
	@Override
	public void prepare(GwData record) {
//		double conn_cost = 0d; // 连接时延
//		double page_size = NumberKit.valueOfDouble(record.getDouble("page_size"), 0d);
//		double trans_body_cost = NumberKit.valueOfDouble(record.getDouble("trans_body_cost"), 0d);
//		double dns_cost = NumberKit.valueOfDouble(record.getDouble("dns_cost"), 0d);
//		double tcp_cost = NumberKit.valueOfDouble(record.getDouble("tcp_cost"), 0d);
//		double ssl_cost = NumberKit.valueOfDouble(record.getDouble("ssl_cost"), 0d);
//		// 下载速率
//		double avg_speed = NumberKit.valueOfDouble(record.getDouble("avg_speed"), 0d);
//		if (avg_speed == 0) {
//			avg_speed = trans_body_cost == 0 ? 0 : NumberUtil.div(page_size, trans_body_cost / 1000, 4);
//		}
//		conn_cost = dns_cost + tcp_cost + ssl_cost;
//		// 表示从探针端上传，否则为计算得出
//		if (dns_cost == 0 && tcp_cost == 0 && ssl_cost == 0) {
//			conn_cost = record.getDouble("conn_cost");
//		}
//		// 连接时延
//		record.set("conn_cost", conn_cost);
//		record.set("avg_speed", avg_speed);
	}

	@Override
	public void after(GwData record) {

	}


}

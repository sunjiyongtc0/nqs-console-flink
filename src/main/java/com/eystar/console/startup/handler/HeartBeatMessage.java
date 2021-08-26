package com.eystar.console.startup.handler;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.util.StrUtil;

//------------------------------------------------------------------------
public class HeartBeatMessage extends Message {

	private String internetIp;
	private JSONObject infoJson;

	public HeartBeatMessage(String msg) {
		try {
			// \xxx 八进制转义符
			/* \\uxxxx 十六进制转义符 */
			String[] msgArr = msg.split("\2");
			this.internetIp = msgArr[1];
			if (msgArr.length > 2) {
				setTestTime(Long.valueOf(msgArr[2])); // 这个时间是webs添加的时间
			}
			setMsgJson(JSONObject.parseObject(msgArr[0]));
			if (getTestTime() == 0) {
				Long time = getMsgJson().getLongValue("time"); // 这个时间是探针上报的时间
				// 如果时间是3天前的数据，可能就是探针上时间不准导致，这个时候将上报的时间改为当前时间
//				if (Math.abs(System.currentTimeMillis() / 1000 - time) > XxlConfClient.getLong("gw-console.probe.time.offset")) {
				if (Math.abs(System.currentTimeMillis() / 1000 - time) > 108000) {
					time = System.currentTimeMillis() / 1000;
				}
				setTestTime(time);
			}
			this.infoJson = getMsgJson().getJSONObject("info");
			if (StrUtil.isBlank(infoJson.getString("id"))) {
				logger.error("此次上报的网关心跳信息中没有探针id，此次上报的内容 = \r\n" + msg);
				setBadMsg(true);
			} else {
				setProbeId(infoJson.getString("id"));
			}
		} catch (Exception e) {
			logger.error("消息格式不正确 ，此次上报的内容 = \r\n" + msg, e);
			setBadMsg(true);
		}
	}

	/**
	 * internetIp 的get方法
	 * 
	 * @return String
	 */
	public String getInternetIp() {
		return internetIp;
	}

	/**
	 * internetIp 的set方法
	 * 
	 * @param internetIp
	 */
	public void setInternetIp(String internetIp) {
		this.internetIp = internetIp;
	}

	/**
	 * infoJson 的get方法
	 * 
	 * @return JSONObject
	 */
	public JSONObject getInfoJson() {
		return infoJson;
	}

	/**
	 * infoJson 的set方法
	 * 
	 * @param infoJson
	 */
	public void setInfoJson(JSONObject infoJson) {
		this.infoJson = infoJson;
	}
}

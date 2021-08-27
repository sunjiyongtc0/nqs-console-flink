package com.eystar.common.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

public class SmartGateWayUtil {

	/**
	 * 根据类型转换光功率：<br>
	 * 创维光功率转换
	 * 
	 * @Author: zhaoqj
	 * @Description:
	 * @return double 返回类型
	 * @throws Exception
	 */
	public static Double parsePower(String type, Double source) {
		if (StrUtil.isBlank(type)) {
			return source;
		}
		if ("DT741-csf".equalsIgnoreCase(type)) {
			return NumberUtil.div(source.doubleValue(), 10000d);
		}
		return source;
	}

}

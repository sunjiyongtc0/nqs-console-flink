package com.eystar.console.startup.handler.parser;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eystar.common.util.IPHelper;
import com.eystar.common.util.UUIDKit;
import com.eystar.console.startup.entity.gwdata.GwData;
import com.eystar.console.startup.entity.gwdata.GwHttpData;
import com.eystar.console.startup.entity.gwdata.GwHttpDetailData;
import com.eystar.console.startup.util.ChangeChar;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class DetailAbstractDataParser extends AbstractDataParser {

	private String taskTypeName;

	public DetailAbstractDataParser() {

	}

	public DetailAbstractDataParser(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

	@Override
	public void prepare(GwData record) {

	}

	@Override
	public void after(GwData Record) {
		JSONArray array = null;
		JSONObject srcRecord = (JSONObject) JSON.toJSON(Record);
		try {
			if(Record instanceof GwHttpData){
				array = JSONArray.parseArray(srcRecord.getString("detail"));
			}
			if (array == null) {
				return;
			}
		} catch (Exception e) {
			System.out.println("解析detai出错，不是JSON格式，类型 = " + taskTypeName + "，detail = " + srcRecord.getString("detail")+ e.getMessage());
			return;
		}
		List<GwData>  lgd=new ArrayList<GwData>();
		for (int i = 0; i < array.size(); i++) {
			GwHttpDetailData gwHttpDetailData=new GwHttpDetailData();
			gwHttpDetailData=(GwHttpDetailData) DataParserHelper.setColumns(gwHttpDetailData,Record);
			gwHttpDetailData.setId( UUIDKit.nextShortUUID()); // 重新生成任务ID
			gwHttpDetailData.setParentId(Record.getId());
			JSONObject DetailDataJson=(JSONObject)JSON.toJSON(gwHttpDetailData);
			JSONObject object = array.getJSONObject(i);
			Set<String> keys= object.keySet();
			for(String key:keys){
				DetailDataJson.put(ChangeChar.camelToUnderline(key,1),object.get(key));
			}
			gwHttpDetailData=JSON.parseObject(DetailDataJson.toJSONString(),GwHttpDetailData.class);

			if (StrUtil.isNotBlank(gwHttpDetailData.getHostIp())) {
				JSONObject ipInfo = IPHelper.getIpInfo(gwHttpDetailData.getHostIp());
				gwHttpDetailData.setHostProvince(ipInfo.getString("province_name"));// 省
				gwHttpDetailData.setHostCity( ipInfo.getString("city_name"));// 市
				gwHttpDetailData.setOperator( ipInfo.getString("operator"));// 运营商
			}
			fillEachDetailRecord(gwHttpDetailData);

			JSONObject gwHttpDetailDataJson = (JSONObject) JSON.toJSON(gwHttpDetailData);
			lgd.add(gwHttpDetailData);
		}
		try {
			DataParserHelper.insertDataDetailList(lgd);
		} catch (Exception e) {
			System.out.println("批量保存" + taskTypeName + "的数据出现错误，父ID = " + srcRecord.getString("id") + "，待保存的JSON = " + srcRecord.getString("detail")+"/n Error:"+e.getMessage());
		}
	}
	public abstract void fillEachDetailRecord(GwData record);
}

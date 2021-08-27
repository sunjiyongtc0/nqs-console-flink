package com.eystar.console.startup.util;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.eystar.common.util.RedisModifyHelper;
import com.eystar.console.startup.cache.redis.util.RedisUtils;
import com.eystar.console.startup.entity.TPProbe;
import com.eystar.console.startup.entity.TPProbeAccessType;
import com.eystar.console.startup.handler.probe.ProbeAccessTypeHelper;
import com.eystar.console.startup.service.ProbeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.eystar.common.util.Constants;

import java.util.List;
import java.util.Set;


//------------------------------------------------------------------------
public class InfoLoader {

	protected static final Logger logger = LoggerFactory.getLogger(InfoLoader.class);
	private static RedisUtils redisUtils;
	private static ProbeService probeService;

	public static void  init(RedisUtils ru, ProbeService ps){
		redisUtils=ru;
		probeService=ps;
	}


	public synchronized static JSONObject loadProbe(String probeId) {
		String key = Constants.REDIS_KEY_PROBE + probeId;
		String probeJson = redisUtils.get(key);
		if (StrUtil.isBlank(probeJson)) {
			TPProbe probe = probeService.findById(probeId);
			if (probe != null) {
				probeJson = JSON.toJSONString(probe);
				RedisModifyHelper.updateProbe(probeId,probeJson);
			} else {
				return new JSONObject();
			}
		}
		return JSONObject.parseObject(probeJson);
	}


	public synchronized static JSONObject loadProbeAccessType(String probeId) {
		String key = Constants.REDIS_KEY_ACCESS_TYPE + probeId;
		JSONObject object = new JSONObject();
		if (!redisUtils.exists(key)) {
			List<TPProbeAccessType> accessTypes = ProbeAccessTypeHelper.findByProbeId(probeId);
			for (TPProbeAccessType accessType : accessTypes) {
				object.put(accessType.getAccessTypeName(), JSONObject.parseObject(JSON.toJSONString(accessType)));
					RedisModifyHelper.updateProbeAccess(probeId, accessType.getAccessTypeName(), JSON.toJSONString(accessType));
					if (accessType.getIsDefault() == 1) {
						redisUtils.hset(key, "default_name", accessType.getAccessTypeName());
						RedisModifyHelper.updateProbeAccess(probeId, "default_name", accessType.getAccessTypeName());
					}
			}
			return object;
		} else {
			Set<String> fields = redisUtils.hkeys(key);
			for (String field : fields) {
				if (StrUtil.equals(field, "default_name")) {
					continue;
				}
				object.put(field, JSONObject.parseObject(redisUtils.hget(key, field)));
			}
			return object;
		}
	}

    public synchronized static JSONObject loadTaskSrcDest(String taskId) {
        String key = Constants.REDIS_KEY_TASK_SRC_DEST + taskId;
        String taskJson = redisUtils.get(key);
        if (StrUtil.isBlank(taskJson)) {
//            TaskSrcDest taskSrcDest = TaskSrcDest.dao.findById(taskId);
//            if (taskSrcDest != null) {
//                taskJson = taskSrcDest.toJson();
//                if (OperationConfig.isReplace) {
//                    RedisModifyHelper.updateTaskSrcDest(taskId, taskJson);
//                }
//            } else {
//                return new JSONObject();
//            }
        }
        return JSONObject.parseObject(taskJson);
    }
}

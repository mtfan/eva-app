package com.byron.eva.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: monitor检测
 * @Author: fanmingtao
 * @Date: 2019/1/25
 */
@RestController
@RequestMapping
public class MonitorApi {

    @RequestMapping("monitor")
    public String getMonitor() {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("errorCode", "0000000");
        jsonObject.put("errorMessage", "ok");
        jsonObject.put("data", "current service is ok");
        jsonObject.put("succeed", true);
        return jsonObject.toJSONString();
    }
}

package com.byron.eva.api;

import com.alibaba.fastjson.JSONObject;
import com.byron.eva.model.entity.TemplateEntity;
import com.byron.eva.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/28
 */
@RestController
@RequestMapping("/template")
public class TemplateApi {

    @Autowired
    private TemplateService templateService;

    @RequestMapping("/list")
    public String list(@RequestParam(name = "platform") String platform) {
        List<TemplateEntity> entityList = templateService.findAll(platform);
        return JSONObject.toJSONString(entityList);
    }

    @RequestMapping("/allList")
    public String allList(@RequestParam(name = "platform") String platform) {
        List<TemplateEntity> entityList = templateService.findAllAndPlatCode(platform);
        return JSONObject.toJSONString(entityList);
    }
}

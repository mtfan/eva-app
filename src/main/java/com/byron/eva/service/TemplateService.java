package com.byron.eva.service;

import com.byron.eva.model.entity.TemplateEntity;

import java.util.List;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/28
 */
public interface TemplateService {

    /**
     * 查找模板
     *
     * @param platform
     * @return
     */
    List<TemplateEntity> findAll(String platform);

    /**
     * 查找模板
     *
     * @param platCode
     * @return
     */
    List<TemplateEntity> findAllAndPlatCode(String platCode);
}

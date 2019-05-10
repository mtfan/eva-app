package com.byron.eva.service.Impl;

import com.byron.eva.dao.TemplateDao;
import com.byron.eva.dao.TemplateRepository;
import com.byron.eva.model.entity.TemplateEntity;
import com.byron.eva.service.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/28
 */
@Slf4j
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateDao templateDao;

    @Autowired
    private TemplateRepository templateRepository;

    /**
     * 查找模板
     *
     * @param platform
     * @return
     */
    @Override
    public List<TemplateEntity> findAll(String platform) {
        return templateDao.findAll(platform);
    }

    /**
     * 查找模板
     *
     * @param platCode
     * @return
     */
    @Override
    public List<TemplateEntity> findAllAndPlatCode(String platCode) {
        return templateRepository.findByPlatCode(platCode);
    }
}

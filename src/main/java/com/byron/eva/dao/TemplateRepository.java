package com.byron.eva.dao;

import com.byron.eva.model.entity.TemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/28
 */
public interface TemplateRepository extends JpaRepository<TemplateEntity, Long> {

    /**
     * 根据platCode查找
     *
     * @param platCode
     * @return
     */
    List<TemplateEntity> findByPlatCode(String platCode);
}

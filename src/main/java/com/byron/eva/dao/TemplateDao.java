package com.byron.eva.dao;

import com.byron.eva.model.entity.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/28
 */
@Component
public class TemplateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<TemplateEntity> findAll(String platform) {

        String sql = "select * from wechat_template where plat_code = ?";

        List<TemplateEntity> templateEntities = jdbcTemplate.query(sql, new Object[]{platform}, new RowMapper<TemplateEntity>() {

            @Override
            public TemplateEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return buildTemplateEntity(resultSet);
            }
        });

        return templateEntities;
    }

    /**
     * 根据ResultSet构建Template
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private TemplateEntity buildTemplateEntity(ResultSet resultSet) throws SQLException {
        TemplateEntity template = new TemplateEntity();
        template.setId(resultSet.getLong("id"));
        template.setTemplateIdShort(resultSet.getString("template_id_short"));
        template.setTemplateId(resultSet.getString("template_id"));
        template.setTitle(resultSet.getString("title"));
        template.setDescription(resultSet.getString("description"));
        template.setUrl(resultSet.getString("url"));
        template.setFirst(resultSet.getString("first"));
        template.setRemark(resultSet.getString("remark"));
        template.setPlatCode(resultSet.getString("plat_code"));
        template.setStatus(resultSet.getInt("status"));
        template.setSendWay(resultSet.getInt("send_way"));
        return template;
    }
}

package com.byron.eva.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/28
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "wechat_template")
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "template_id_short")
    private String templateIdShort;

    @NonNull
    @Column(name = "template_id")
    private String templateId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "first")
    private String first;

    @Column(name = "remark")
    private String remark;

    @Column(name = "plat_code")
    private String platCode;

    @Column(name = "status")
    private Integer status;

    @Column(name = "send_way")
    private Integer sendWay;
}

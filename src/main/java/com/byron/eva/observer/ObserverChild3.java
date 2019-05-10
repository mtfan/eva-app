package com.byron.eva.observer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 具体观察者，实现抽象观察者角色所要求的更新接口，已是本身状态与主题状态相协调
 * @Author: fanmingtao
 * @Date: 2019/1/31
 */
@Data
@Slf4j
public class ObserverChild3 extends Observer {

    private Integer observerState;

    private Subject subject;

    public ObserverChild3(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    /**
     * 更新观察者信息
     */
    @Override
    public void update() {
        System.out.println("Child3 String: " + subject.getState());
    }
}

package com.byron.eva.observer;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/31
 */
public class ObserverChild2 extends Observer {

    public ObserverChild2(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Child2 String: " + subject.getState());
    }
}
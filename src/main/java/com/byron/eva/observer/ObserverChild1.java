package com.byron.eva.observer;

/**
 * @Description:
 *
 * @Author: fanmingtao
 * @Date: 2019/1/31
 */
public class ObserverChild1 extends Observer {

    public ObserverChild1(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Child1 String: " + subject.getState());
    }
}

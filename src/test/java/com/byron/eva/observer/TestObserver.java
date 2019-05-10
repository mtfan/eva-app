package com.byron.eva.observer;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/31
 */
public class TestObserver {

    public static void main(String[] args) {
        Subject subject = new Subject();

        new ObserverChild1(subject);
        new ObserverChild2(subject);
        new ObserverChild3(subject);

        subject.setState(15);
        System.out.println("******************************");
        subject.setState(10);
    }
}

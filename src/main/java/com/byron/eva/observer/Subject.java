package com.byron.eva.observer;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Description:
 * @Author: fanmingtao
 * @Date: 2019/1/31
 */
public class Subject {

    private Integer state;

    private List<Observer> observers = Lists.newArrayList();

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * 增加观察者
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 向观察者（们）发出通知
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
package com.byron.eva.observer;

/**
 * @Description: 抽象观察者类，为所有具体观察者定义一个接口，在得到通知时更新自己
 *
 * @Author: fanmingtao
 * @Date: 2019/1/31
 */
public abstract class Observer {

    /**
     * 主题
     */
    protected Subject subject;

    /**
     * 更新观察者信息
     */
    public abstract void update();
}

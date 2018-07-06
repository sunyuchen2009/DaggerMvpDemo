package com.syc.scwj.daggermvpdemo.base;

/**
 * Created by sunYuChen on 2018/6/28.
 */
public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}

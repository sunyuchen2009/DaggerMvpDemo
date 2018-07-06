package com.syc.scwj.daggermvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.syc.scwj.daggermvpdemo.di.component.ActivityComponent;
import com.syc.scwj.daggermvpdemo.di.component.DaggerActivityComponent;
import com.syc.scwj.daggermvpdemo.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by sunYuChen on 2018/6/28.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{

    @Inject
    protected T mPresenter;

    //这个方法在每个activity中重写的initInject()方法中，
    //这里的.activityModule()方法可以不写
    //原因：公共注入的对象只有一个presenter，用@Inject注解的方式注入
    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();//获取每个presenter的对象
        if (mPresenter!=null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    public abstract void initInject();
}

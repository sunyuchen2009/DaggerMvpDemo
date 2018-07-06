package com.syc.scwj.daggermvpdemo.di.component;

import com.syc.scwj.daggermvpdemo.di.module.ActivityModule;
import com.syc.scwj.daggermvpdemo.di.scope.ActivityScope;
import com.syc.scwj.daggermvpdemo.ui.login.activity.LoginActivity;

import dagger.Component;

/**
 * Created by sunYuChen on 2018/6/29.
 */
@ActivityScope
@Component(
        modules = {ActivityModule.class}
)
public interface ActivityComponent {

    void inject(LoginActivity loginAcitivity);
}

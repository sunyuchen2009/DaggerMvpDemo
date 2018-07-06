package com.syc.scwj.daggermvpdemo.di.module;

import android.app.Activity;

import com.syc.scwj.daggermvpdemo.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunYuChen on 2018/6/29.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    //这里构造方法作用是为ActivityComponent中的inject()方法提供对象
    //也就是要注入的地方（Activity）
    public ActivityModule(Activity activity){
        this.mActivity=activity;
    }


//    提供对象时作用域scope要与component一致
//    @Provides
//    @ActivityScope
//    public Activity provideActivity(){
//        return mActivity;
//    }

}

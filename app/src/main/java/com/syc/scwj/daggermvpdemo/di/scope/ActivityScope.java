package com.syc.scwj.daggermvpdemo.di.scope;

import java.lang.annotation.Retention;


import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by sunYuChen on 2018/6/29.
 * scope是作用域，component与module中必须一致
 */
@Scope
//下面这个注释表示注解持续到APP运行阶段
@Retention(RUNTIME)
public @interface ActivityScope {
}

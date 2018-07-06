package com.syc.scwj.daggermvpdemo.ui.login.contract;

import com.syc.scwj.daggermvpdemo.base.BasePresenter;
import com.syc.scwj.daggermvpdemo.base.BaseView;

/**
 * Created by sunYuChen on 2018/6/28.
 */
public interface LoginContract {

    interface View extends BaseView {

        String getPassword(String password);

        String getUserName(String userName);

        //登录判断
        void login();

        //显示登录成功的信息
        void showSuccessMsg();

        //显示登录失败的信息
        void showFailedMsg();

        //跳转到欢迎界面
        void toWelComeActivity();
    }

    interface Presenter extends BasePresenter<View>{
        void loginSuccess();

        void loginFailed();
    }
}

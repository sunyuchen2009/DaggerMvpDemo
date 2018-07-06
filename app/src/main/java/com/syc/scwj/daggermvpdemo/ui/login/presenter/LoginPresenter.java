package com.syc.scwj.daggermvpdemo.ui.login.presenter;


import android.util.Log;

import com.syc.scwj.daggermvpdemo.ui.login.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by sunYuChen on 2018/6/29.
 */
public class LoginPresenter implements LoginContract.Presenter{


    private LoginContract.View mLoginView;

    @Inject
    public LoginPresenter(){

    }

    @Override
    public void attachView(LoginContract.View view) {
        this.mLoginView=view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void loginSuccess() {
        mLoginView.showSuccessMsg();
    }

    @Override
    public void loginFailed() {
        mLoginView.showFailedMsg();
    }
}

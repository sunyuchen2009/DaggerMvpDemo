package com.syc.scwj.daggermvpdemo.ui.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.syc.scwj.daggermvpdemo.R;
import com.syc.scwj.daggermvpdemo.base.BaseActivity;
import com.syc.scwj.daggermvpdemo.ui.login.contract.LoginContract;
import com.syc.scwj.daggermvpdemo.ui.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sunYuChen on 2018/6/28.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_go)
    Button btnGo;
    private String mUserName, mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public String getPassword(String password) {
        this.mPassword=password;
        return mPassword;
    }

    @Override
    public String getUserName(String userName) {
        this.mUserName=userName;
        return mUserName;
    }

    @Override
    public void login() {
        if (this.mUserName.equals("admin")&&this.mPassword.equals("123")){
            mPresenter.loginSuccess();
        }else{
            mPresenter.loginFailed();
        }
    }

    @Override
    public void showSuccessMsg() {
        toWelComeActivity();
        Toast.makeText(this, "Success！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMsg() {
        Toast.makeText(this, "Failed！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toWelComeActivity() {
        startActivity(newInstance(this));
        finish();
    }

    @OnClick(R.id.btn_go)
    public void onViewClicked() {
        getUserName(etUserName.getText().toString());
        getPassword(etPassword.getText().toString());
        login();
    }

    public Intent newInstance(Context context){
        Intent intent=new Intent(context,WelComeActivity.class);
        return intent;
    }
}

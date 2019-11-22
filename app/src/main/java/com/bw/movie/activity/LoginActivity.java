package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.UserContract;
import com.bw.movie.presenter.UserPresenter;
import com.bw.movie.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends BaseActivity<UserPresenter> implements UserContract.Iview {

    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.but_login)
    Button butLogin;
    private Unbinder bind;

    @Override
    protected UserPresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        // TODO: add setContentView(...) invocation
        bind = ButterKnife.bind(this);
    }

    @Override
    public void onUserSuccess(EmailBean emailBean) {

    }

    @Override
    public void onUserSuccess(RegisterBean registerBean) {

    }
    //登录
    @Override
    public void onUserSuccess(LoginBean loginBean) {
        Toast.makeText(this, ""+loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onUserFaiure(Throwable faiure) {

    }
//点击登录,注册
    @OnClick({R.id.text_view, R.id.but_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_view:
                //注册跳转
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.but_login:
                //huoqu 获取密码和邮箱
                String email = editEmail.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                //密码加密
                String encrypt = EncryptUtil.encrypt(pwd);
                //非空判断
                if (email.isEmpty()||encrypt.isEmpty()){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else{

                    mPresenter.getPresenterLogin("1257647673@qq.com",encrypt);
                }
                break;
        }
    }
//shifang释放内存,销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();

    }
}

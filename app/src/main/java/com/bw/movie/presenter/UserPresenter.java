package com.bw.movie.presenter;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:19:41
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.app.Constant;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.contract.UserContract;
import com.bw.movie.model.UserModel;

public class UserPresenter extends BasePresenter<UserContract.Iview> implements UserContract.Ipresenter {

    private UserModel userModel;
//初始化model
    @Override
    protected void initModel() {
        userModel = new UserModel();
    }

    @Override//发送邮箱
    public void getPresenterEmail(String email) {
        userModel.getModelEmail(email, new UserContract.Imodel.ImodelCallback() {
            @Override
            public void onUserSuccess(EmailBean emailBean) {
                //pan判断是否挂载
                if (isViewAttached()){
                    if (emailBean!=null&& Constant.SUCCESS_CODE.equals(emailBean.getStatus())){
                        getView().onUserSuccess(emailBean);
                    }else{
                        getView().onUserFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onUserSuccess(RegisterBean registerBean) {

            }

            @Override
            public void onUserSuccess(LoginBean loginBean) {

            }

            @Override
            public void onUserFaiure(Throwable faiure) {
                getView().onUserFaiure(faiure);
            }
        });
    }
//注册
    @Override
    public void getPresenterRegister(String nickName, String pwd, String email, String code) {
                userModel.getModelRegister(nickName, pwd, email, code, new UserContract.Imodel.ImodelCallback() {
                    @Override
                    public void onUserSuccess(EmailBean emailBean) {

                    }

                    @Override
                    public void onUserSuccess(RegisterBean registerBean) {
                        if (isViewAttached()){
                            if (registerBean!=null&&Constant.SUCCESS_CODE.equals(registerBean.getStatus())){
                                getView().onUserSuccess(registerBean);
                            }else{
                                getView().onUserFaiure(new Exception("服务器异常"));
                            }
                        }
                    }

                    @Override
                    public void onUserSuccess(LoginBean loginBean) {

                    }

                    @Override
                    public void onUserFaiure(Throwable faiure) {
                        getView().onUserFaiure(faiure);
                    }
                });
    }
//登录
    @Override
    public void getPresenterLogin(String email, String pwd) {
            userModel.getModelLogin(email, pwd, new UserContract.Imodel.ImodelCallback() {
                @Override
                public void onUserSuccess(EmailBean emailBean) {

                }

                @Override
                public void onUserSuccess(RegisterBean registerBean) {

                }

                @Override
                public void onUserSuccess(LoginBean loginBean) {
                    if (isViewAttached()){
                        if (loginBean!=null&&Constant.SUCCESS_CODE.equals(loginBean.getStatus())){
                            getView().onUserSuccess(loginBean);
                        }else{
                            getView().onUserFaiure(new Exception("服务器异常"));
                        }
                    }
                }

                @Override
                public void onUserFaiure(Throwable faiure) {
                        getView().onUserFaiure(faiure);
                }
            });
    }
}

package com.bw.movie.presenter;


/*
 *@auther:胡明明
 *@Date: 2019/11/13
 *@Time:20:21
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.app.Constant;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.QuBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.bw.movie.bean.YingYuanPingLun;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.bw.movie.contract.YingYuanContract;
import com.bw.movie.model.YingYuanModel;

public class YingYuanPresenter extends BasePresenter<YingYuanContract.Iview> implements YingYuanContract.Ipresenter {

    private YingYuanModel yingYuanModel;
//初始化model
    @Override
    protected void initModel() {
        yingYuanModel = new YingYuanModel();
    }

    @Override
    public void getModelQuLei() {
        yingYuanModel.getModelQuLei(new YingYuanContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (quLeiBean.getStatus().equals(Constant.SUCCESS_CODE)&&quLeiBean!=null){
                        getView().onHomesuccess(quLeiBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(QuBean quBean) {

            }

            @Override
            public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

            }

            @Override
            public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

            }

            @Override
            public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

            }

            @Override
            public void onHomesuccess(YYXQBean yyxqBean) {

            }

            @Override
            public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getModelQu(String regionId) {
            yingYuanModel.getModelQu(regionId, new YingYuanContract.Imodel.ImodelCallBack() {
                @Override
                public void onHomesuccess(QuLeiBean quLeiBean) {

                }

                @Override
                public void onHomesuccess(QuBean quBean) {
                    //pa判断是否挂载
                    if (isViewAttached()){
                        if (quBean.getStatus().equals(Constant.SUCCESS_CODE)&&quBean!=null){
                            getView().onHomesuccess(quBean);
                        }else{
                            getView().onHomeFaiure(new Exception("服务器异常"));
                        }
                    }
                }

                @Override
                public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

                }

                @Override
                public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

                }

                @Override
                public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

                }

                @Override
                public void onHomesuccess(YYXQBean yyxqBean) {

                }

                @Override
                public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

                }

                @Override
                public void onHomesuccess(ShiJianBean shiJianBean) {

                }

                @Override
                public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
                }
            });
    }
//影院推荐
    @Override
    public void getPresenterYingYuantuijian(Integer page, Integer count) {
        yingYuanModel.getModelYingYuantuijian(page, count, new YingYuanContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(QuBean quBean) {

            }

            @Override
            public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yingYuanTuiJianBean.getStatus().equals(Constant.SUCCESS_CODE)&&yingYuanTuiJianBean!=null){
                        getView().onHomesuccess(yingYuanTuiJianBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

            }

            @Override
            public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

            }

            @Override
            public void onHomesuccess(YYXQBean yyxqBean) {

            }

            @Override
            public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
//附近
    @Override
    public void getPresenterYingYuanfujin(String longitude, String latitude, Integer page, Integer count) {
            yingYuanModel.getModelYingYuanfujin(longitude, latitude, page, count, new YingYuanContract.Imodel.ImodelCallBack() {
                @Override
                public void onHomesuccess(QuLeiBean quLeiBean) {

                }

                @Override
                public void onHomesuccess(QuBean quBean) {

                }

                @Override
                public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

                }

                @Override
                public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {
                    //pa判断是否挂载
                    if (isViewAttached()){
                        if (yingYuanFuJinBean.getStatus().equals(Constant.SUCCESS_CODE)&&yingYuanFuJinBean!=null){
                            getView().onHomesuccess(yingYuanFuJinBean);
                        }else{
                            getView().onHomeFaiure(new Exception("服务器异常"));
                        }
                    }
                }

                @Override
                public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

                }

                @Override
                public void onHomesuccess(YYXQBean yyxqBean) {

                }

                @Override
                public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

                }

                @Override
                public void onHomesuccess(ShiJianBean shiJianBean) {

                }

                @Override
                public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
                }
            });
    }
//搜索
    @Override
    public void getPresentersousuo(String cinemaName, Integer page, Integer count) {
        yingYuanModel.getModelsousuo(cinemaName, page, count, new YingYuanContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(QuBean quBean) {

            }

            @Override
            public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

            }

            @Override
            public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

            }

            @Override
            public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yingYuanSouSuoBean.getStatus().equals(Constant.SUCCESS_CODE)&&yingYuanSouSuoBean!=null){
                        getView().onHomesuccess(yingYuanSouSuoBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(YYXQBean yyxqBean) {

            }

            @Override
            public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenteryyxq(Integer cinemaId) {
        yingYuanModel.getModelyyxq(cinemaId, new YingYuanContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(QuBean quBean) {

            }

            @Override
            public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

            }

            @Override
            public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

            }

            @Override
            public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

            }

            @Override
            public void onHomesuccess(YYXQBean yyxqBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yyxqBean.getStatus().equals(Constant.SUCCESS_CODE)&&yyxqBean!=null){
                        getView().onHomesuccess(yyxqBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterpinglun(Integer cinemaId, Integer page, Integer count) {
        yingYuanModel.getModelpinglun(cinemaId, page, count, new YingYuanContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(QuBean quBean) {

            }

            @Override
            public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

            }

            @Override
            public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

            }

            @Override
            public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

            }

            @Override
            public void onHomesuccess(YYXQBean yyxqBean) {

            }

            @Override
            public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yingYuanPingLun.getStatus().equals(Constant.SUCCESS_CODE)&&yingYuanPingLun!=null){
                        getView().onHomesuccess(yingYuanPingLun);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresentershijian() {
        yingYuanModel.getModelshijian(new YingYuanContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(QuBean quBean) {

            }

            @Override
            public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

            }

            @Override
            public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

            }

            @Override
            public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

            }

            @Override
            public void onHomesuccess(YYXQBean yyxqBean) {

            }

            @Override
            public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (shiJianBean.getStatus().equals(Constant.SUCCESS_CODE)&&shiJianBean!=null){
                        getView().onHomesuccess(shiJianBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
}

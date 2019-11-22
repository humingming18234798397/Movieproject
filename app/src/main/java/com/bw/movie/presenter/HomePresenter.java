package com.bw.movie.presenter;


/*
 *@auther:胡明明
 *@Date: 2019/11/12
 *@Time:18:56
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.app.Constant;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.HomeSouSuoBean;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.ZuoWeiHaoBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeContract.Iview> implements HomeContract.Ipresenter {

    private HomeModel homeModel;
//chu初始化HomeModle
    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }
//轮播图
    @Override
    public void getPresenterXbanner() {
            homeModel.getModelXbanner(new HomeContract.Imodel.ImodelCallBack() {
                @Override
                public void onHomesuccess(XBannerBean xBannerBean) {
                    //pa判断是否挂载
                    if (isViewAttached()){
                        if (xBannerBean.getStatus().equals(Constant.SUCCESS_CODE)&&xBannerBean!=null){
                            getView().onHomesuccess(xBannerBean);
                        }else{
                            getView().onHomeFaiure(new Exception("服务器异常"));
                        }
                    }
                }

                @Override
                public void onHomesuccess(ReYingBean reYingBean) {

                }

                @Override
                public void onHomesuccess(ShangYingBean shangYingBean) {

                }

                @Override
                public void onHomesuccess(HomeBean homeBean) {

                }

                @Override
                public void onHomesuccess(XiangQingBean xiangQingBean) {

                }

                @Override
                public void onHomesuccess(YingPingBean yingPingBean) {

                }

                @Override
                public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

                }

                @Override
                public void onHomesuccess(QuLeiBean quLeiBean) {

                }

                @Override
                public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

                }

                @Override
                public void onHomesuccess(ShiJianBean shiJianBean) {

                }

                @Override
                public void onHomesuccess(PriceBean priceBean) {

                }

                @Override
                public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

                }

                @Override
                public void onHomesuccess(YingTingBean yingTingBean) {

                }

                @Override
                public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

                }

                @Override
                public void onHomeFaiure(Throwable e) {
                        getView().onHomeFaiure(e);
                }
            });
    }
//热映
    @Override
    public void getPresenterReYing(Integer page, Integer count) {
        homeModel.getModelReYing(page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (reYingBean.getStatus().equals(Constant.SUCCESS_CODE)&&reYingBean!=null){
                        getView().onHomesuccess(reYingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
//即将上映
    @Override
    public void getPresenterShangYing(Integer page, Integer count) {
        homeModel.getModelShangYing(page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (shangYingBean.getStatus().equals(Constant.SUCCESS_CODE)&&shangYingBean!=null){
                        getView().onHomesuccess(shangYingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
//热门
    @Override
    public void getPresenterHome(Integer page, Integer count) {
       homeModel.getModelHome(page, count, new HomeContract.Imodel.ImodelCallBack() {
           @Override
           public void onHomesuccess(XBannerBean xBannerBean) {

           }

           @Override
           public void onHomesuccess(ReYingBean reYingBean) {

           }

           @Override
           public void onHomesuccess(ShangYingBean shangYingBean) {

           }

           @Override
           public void onHomesuccess(HomeBean homeBean) {
               //pa判断是否挂载
               if (isViewAttached()){
                   if (homeBean.getStatus().equals(Constant.SUCCESS_CODE)&&homeBean!=null){
                       getView().onHomesuccess(homeBean);
                   }else{
                       getView().onHomeFaiure(new Exception("服务器异常"));
                   }
               }
           }

           @Override
           public void onHomesuccess(XiangQingBean xiangQingBean) {

           }

           @Override
           public void onHomesuccess(YingPingBean yingPingBean) {

           }

           @Override
           public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

           }

           @Override
           public void onHomesuccess(QuLeiBean quLeiBean) {

           }

           @Override
           public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

           }

           @Override
           public void onHomesuccess(ShiJianBean shiJianBean) {

           }

           @Override
           public void onHomesuccess(PriceBean priceBean) {

           }

           @Override
           public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

           }

           @Override
           public void onHomesuccess(YingTingBean yingTingBean) {

           }

           @Override
           public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

           }

           @Override
           public void onHomeFaiure(Throwable e) {
               getView().onHomeFaiure(e);
           }
       });
    }
//详情
    @Override
    public void getModelXiangQing(Integer movieId) {
        homeModel.getModelXiangQing(movieId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (xiangQingBean.getStatus().equals(Constant.SUCCESS_CODE)&&xiangQingBean!=null){
                        getView().onHomesuccess(xiangQingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
//影评
    @Override
    public void getPresenterYingPing(Integer movieId, Integer page, Integer count) {
        homeModel.getModelYingPing(movieId, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yingPingBean.getStatus().equals(Constant.SUCCESS_CODE)&&yingPingBean!=null){
                        getView().onHomesuccess(yingPingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }
//搜索
    @Override
    public void getPresenterSouSuo(String keyword, Integer page, Integer count) {
        homeModel.getModelSouSuo(keyword, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (homeSouSuoBean.getStatus().equals(Constant.SUCCESS_CODE)&&homeSouSuoBean!=null){
                        getView().onHomesuccess(homeSouSuoBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getModelQuLei() {
        homeModel.getModelQuLei(new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
                    getView().onHomesuccess(quLeiBean);
            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterXinXi(Integer movieId, Integer regionId, Integer page, Integer count) {
                homeModel.getModelXinXi(movieId, regionId, page, count, new HomeContract.Imodel.ImodelCallBack() {
                    @Override
                    public void onHomesuccess(XBannerBean xBannerBean) {

                    }

                    @Override
                    public void onHomesuccess(ReYingBean reYingBean) {

                    }

                    @Override
                    public void onHomesuccess(ShangYingBean shangYingBean) {

                    }

                    @Override
                    public void onHomesuccess(HomeBean homeBean) {

                    }

                    @Override
                    public void onHomesuccess(XiangQingBean xiangQingBean) {

                    }

                    @Override
                    public void onHomesuccess(YingPingBean yingPingBean) {

                    }

                    @Override
                    public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

                    }

                    @Override
                    public void onHomesuccess(QuLeiBean quLeiBean) {

                    }

                    @Override
                    public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
                        //pa判断是否挂载
                        if (isViewAttached()){
                            if (xuanZuoXinXiBean.getStatus().equals(Constant.SUCCESS_CODE)&&xuanZuoXinXiBean!=null){
                                getView().onHomesuccess(xuanZuoXinXiBean);
                            }else{
                                getView().onHomeFaiure(new Exception("服务器异常"));
                            }
                        }
                    }

                    @Override
                    public void onHomesuccess(ShiJianBean shiJianBean) {

                    }

                    @Override
                    public void onHomesuccess(PriceBean priceBean) {

                    }

                    @Override
                    public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

                    }

                    @Override
                    public void onHomesuccess(YingTingBean yingTingBean) {

                    }

                    @Override
                    public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

                    }

                    @Override
                    public void onHomeFaiure(Throwable e) {
                        getView().onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getPresentershijian() {
        homeModel.getModelshijian(new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

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
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterPrice(Integer movieId, Integer page, Integer count) {
        homeModel.getModelPrice(movieId, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (priceBean.getStatus().equals(Constant.SUCCESS_CODE)&&priceBean!=null){
                        getView().onHomesuccess(priceBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresentershijianyingyuan(Integer movieId, String date, Integer page, Integer count) {
        homeModel.getModelshijianyingyuan(movieId, date, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (shiJianYingYuanBean.getStatus().equals(Constant.SUCCESS_CODE)&&shiJianYingYuanBean!=null){
                        getView().onHomesuccess(shiJianYingYuanBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenteryingting(Integer movieId, Integer cinemaId) {
        homeModel.getModelyingting(movieId, cinemaId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yingTingBean.getStatus().equals(Constant.SUCCESS_CODE)&&yingTingBean!=null){
                        getView().onHomesuccess(yingTingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterzuowei(Integer hallId) {
        homeModel.getModelzuowei(hallId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (zuoWeiHaoBean.getStatus().equals(Constant.SUCCESS_CODE)&&zuoWeiHaoBean!=null){
                        getView().onHomesuccess(zuoWeiHaoBean);
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

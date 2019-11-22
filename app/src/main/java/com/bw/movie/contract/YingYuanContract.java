package com.bw.movie.contract;


/**
 *@describe(描述)：YingYuanContract
 *@data（日期）: 2019/11/19
 *@time（时间）: 18:59
 *@author（作者）: 胡明明
 **/

import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.QuBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.bw.movie.bean.YingYuanPingLun;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;

import retrofit2.http.Query;
//影院契约类
public interface YingYuanContract {
    interface Iview extends IBaseView {
        //海淀区
        void onHomesuccess(QuLeiBean quLeiBean);
        //
        void onHomesuccess(QuBean quBean);
        //影院推荐
        void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean);
        //附近
        void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean);
        //搜索
        void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean);
        //ying影院详情
        void onHomesuccess(YYXQBean yyxqBean);
        //查询影院评论
        void onHomesuccess(YingYuanPingLun yingYuanPingLun);
        void onHomesuccess(ShiJianBean shiJianBean);
        //失败的方法
        void onHomeFaiure(Throwable e);
    }
    interface Imodel{
        //
        void getModelQuLei(ImodelCallBack imodelCallBack);
        void getModelQu(String regionId,ImodelCallBack imodelCallBack);
        //影院推荐
        void getModelYingYuantuijian(Integer page,Integer count,ImodelCallBack imodelCallBack);
        //附近
        void getModelYingYuanfujin(String longitude,String latitude,Integer page,Integer count, ImodelCallBack imodelCallBack);
        //搜索
        void getModelsousuo(String cinemaName,Integer page,Integer count, ImodelCallBack imodelCallBack);
        void getModelyyxq(Integer cinemaId, ImodelCallBack imodelCallBack);
        void getModelpinglun(Integer cinemaId,Integer page,Integer count, ImodelCallBack imodelCallBack);
        void getModelshijian(ImodelCallBack imodelCallBack);
        interface ImodelCallBack{
            void onHomesuccess(QuLeiBean quLeiBean);
            void onHomesuccess(QuBean quBean);
            void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean);
            void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean);
            void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean);
            //ying影院详情
            void onHomesuccess(YYXQBean yyxqBean);
            void onHomesuccess(YingYuanPingLun yingYuanPingLun);
            void onHomesuccess(ShiJianBean shiJianBean);
            void onHomeFaiure(Throwable e);
        }
    }
    interface Ipresenter{
        void getModelQuLei();
        void getModelQu(String regionId);
        //影院推荐
        void getPresenterYingYuantuijian(Integer page,Integer count);
        //附近
        void getPresenterYingYuanfujin(String longitude,String latitude,Integer page,Integer count);
        //搜索
        void getPresentersousuo(String cinemaName,Integer page,Integer count);
        void getPresenteryyxq(Integer cinemaId);
        void getPresenterpinglun(Integer cinemaId,Integer page,Integer count);
        void getPresentershijian();
    }
}

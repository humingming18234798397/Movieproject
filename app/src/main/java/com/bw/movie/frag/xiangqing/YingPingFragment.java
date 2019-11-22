package com.bw.movie.frag.xiangqing;


/*
 *@auther:胡明明
 *@Date: 2019/11/14
 *@Time:21:38
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.YingPingAdapter;
import com.bw.movie.base.BaseFragment;
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
import com.bw.movie.presenter.HomePresenter;

import java.util.List;

import butterknife.BindView;

public class YingPingFragment extends BaseFragment<HomePresenter> implements HomeContract.Iview {
/*    @BindView(R.id.yingping_xrlv)
    XRecyclerView yingpingXrlv;*/

    int page = 1;
    @BindView(R.id.yingping_xrlv)
    RecyclerView yingpingXrlv;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.xiangqing_yingping;
    }

    @Override
    protected void initData() {
        super.initData();
       /* //下拉刷新,上拉加载
        yingpingXrlv.setPullRefreshEnabled(true);
        yingpingXrlv.setLoadingMoreEnabled(true);
        yingpingXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getPresenterYingPing(key, page, 10);
                yingpingXrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterYingPing(key, page, 10);
                yingpingXrlv.loadMoreComplete();
            }
        });*/
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingpingXrlv.setLayoutManager(linearLayoutManager);
        //jieshou接受movedid
        Intent intent = getActivity().getIntent();
        int key = intent.getIntExtra("key", 0);
        //jiekou 接口
        mPresenter.getPresenterYingPing(key, 1, 5);

    }

    @Override
    public void onHomesuccess(XBannerBean xBannerBean) {

    }

    //正在上映
    @Override
    public void onHomesuccess(ReYingBean reYingBean) {

    }

    //即将上映
    @Override
    public void onHomesuccess(ShangYingBean shangYingBean) {

    }

    //热门电影
    @Override
    public void onHomesuccess(HomeBean homeBean) {

    }

    //详情
    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {

    }

    //影评
    @Override
    public void onHomesuccess(YingPingBean yingPingBean) {
           List<YingPingBean.ResultBean> result = yingPingBean.getResult();
           YingPingAdapter yingPingAdapter = new YingPingAdapter(getActivity());
           yingPingAdapter.setList(result);
           yingpingXrlv.setAdapter(yingPingAdapter);
           //布局管理器
           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
           yingpingXrlv.setLayoutManager(linearLayoutManager);
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

    }
}

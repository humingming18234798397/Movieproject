package com.bw.movie.frag.fragment;


/*
 *@auther:胡明明
 *@Date: 2019/11/13
 *@Time:19:21
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.activity.YingYuanXiangQing;
import com.bw.movie.adapter.YingYuanTuiJinAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.QuBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.bw.movie.bean.YingYuanPingLun;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.bw.movie.contract.YingYuanContract;
import com.bw.movie.presenter.YingYuanPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

public class YingYuan_TuiJian extends BaseFragment<YingYuanPresenter> implements YingYuanContract.Iview {
    @BindView(R.id.yingyuan_tuijian_xrlv)
    XRecyclerView yingyuanTuijianXrlv;
    int page = 1;
    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.yingyuan_tuijian;
    }

    @Override
    protected void initData() {
        super.initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingyuanTuijianXrlv.setLayoutManager(linearLayoutManager);
        //下拉刷新,上拉加载
        yingyuanTuijianXrlv.setPullRefreshEnabled(true);
        yingyuanTuijianXrlv.setLoadingMoreEnabled(true);
        yingyuanTuijianXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getPresenterYingYuantuijian(page,10);
                yingyuanTuijianXrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterYingYuantuijian(page,10);
                yingyuanTuijianXrlv.loadMoreComplete();
            }
        });

        mPresenter.getPresenterYingYuantuijian(1,10);
    }

    @Override
    public void onHomesuccess(QuLeiBean quLeiBean) {

    }

    @Override
    public void onHomesuccess(QuBean quBean) {

    }
//推荐
    @Override
    public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {
        List<YingYuanTuiJianBean.ResultBean> result = yingYuanTuiJianBean.getResult();
        YingYuanTuiJinAdapter yingYuanTuiJinAdapter = new YingYuanTuiJinAdapter(getActivity());
        yingYuanTuiJinAdapter.setList(result);
        yingyuanTuijianXrlv.setAdapter(yingYuanTuiJinAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingyuanTuijianXrlv.setLayoutManager(linearLayoutManager);
        yingYuanTuiJinAdapter.setOnItemClicks(new YingYuanTuiJinAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(getActivity(), YingYuanXiangQing.class);
                intent.putExtra("id",p);
                startActivity(intent);

            }
        });
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

    }
}

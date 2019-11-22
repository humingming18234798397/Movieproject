package com.bw.movie.frag.yingyuanxiangqing;


/*
 *@auther:胡明明
 *@Date: 2019/11/21
 *@Time:14:34
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.TextView;

import com.bw.movie.R;
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

import butterknife.BindView;

public class XiangQingFragment extends BaseFragment<YingYuanPresenter> implements YingYuanContract.Iview {
    @BindView(R.id.name_dizhi)
    TextView nameDizhi;
    @BindView(R.id.phone_cinemadetail)
    TextView phoneCinemadetail;
    @BindView(R.id.chengcheluxian)
    TextView chengcheluxian;

    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.yingyuanxiangqing;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id", 0);
        mPresenter.getPresenteryyxq(id);
    }

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
        YYXQBean.ResultBean result = yyxqBean.getResult();
        nameDizhi.setText(result.getAddress());
        phoneCinemadetail.setText(result.getPhone());
        chengcheluxian.setText(result.getVehicleRoute());
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

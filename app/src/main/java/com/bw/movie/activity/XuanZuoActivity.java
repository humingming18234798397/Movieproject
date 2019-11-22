package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.PriceAdapter;
import com.bw.movie.adapter.QuLieAdapter;
import com.bw.movie.adapter.ShiJianAdapter;
import com.bw.movie.adapter.ShiJianYingYuanAdapter;
import com.bw.movie.adapter.XuanZuoXinXiAdapter;
import com.bw.movie.base.BaseActivity;
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
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class XuanZuoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.xuanzuo_fanhui)
    SimpleDraweeView xuanzuoFanhui;
    @BindView(R.id.imgseactseat)
    JCVideoPlayer imgseactseat;
    @BindView(R.id.xuanzuo_name)
    TextView xuanzuoName;
    @BindView(R.id.xuanzuo_time)
    TextView xuanzuoTime;
    @BindView(R.id.xuanzuo_fen)
    TextView xuanzuoFen;
    @BindView(R.id.xuanzuo_daoyan)
    TextView xuanzuoDaoyan;
    @BindView(R.id.xuanzuo_quyu)
    TextView xuanzuoQuyu;
    @BindView(R.id.xuanzuo_shijian)
    TextView xuanzuoShijian;
    @BindView(R.id.xuanzuo_price)
    RadioButton xuanzuoPrice;
    @BindView(R.id.img_seatsesrach)
    SimpleDraweeView imgSeatsesrach;
    @BindView(R.id.xuanzuo_rlv)
    RecyclerView xuanzuoRlv;
    private int key;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xuan_zuo;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);
        mPresenter.getModelXiangQing(key);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);
    }

    @OnClick({R.id.xuanzuo_fanhui, R.id.xuanzuo_quyu, R.id.xuanzuo_shijian, R.id.xuanzuo_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xuanzuo_fanhui:
                finish();
                break;
            case R.id.xuanzuo_quyu:
                mPresenter.getModelQuLei();
                break;
            case R.id.xuanzuo_shijian:
                mPresenter.getPresentershijian();
                break;
            case R.id.xuanzuo_price:
                mPresenter.getPresenterPrice(key,1,5);
                break;
        }
    }
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
        XiangQingBean.ResultBean result = xiangQingBean.getResult();
        //shipin视频
        imgseactseat.setUp(result.getShortFilmList().get(0).getVideoUrl(), null);
        Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(imgseactseat.ivThumb);
        // imgseactseat.ivThumb.(result.getShortFilmList().get(0).getImageUrl());
        //电影名
        xuanzuoName.setText(result.getName());
        //时长
        xuanzuoTime.setText(result.getDuration());
        //评分
        xuanzuoFen.setText(result.getScore() + "分");
        //导演
        List<XiangQingBean.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
        xuanzuoDaoyan.setText(movieDirector.get(0).getName());
    }

    @Override
    public void onHomesuccess(YingPingBean yingPingBean) {

    }

    @Override
    public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

    }

    @Override
    public void onHomesuccess(QuLeiBean quLeiBean) {
        List<QuLeiBean.ResultBean> result = quLeiBean.getResult();
        if (result!=null){
        QuLieAdapter quLieAdapter = new QuLieAdapter(this);
        quLieAdapter.setList(result);
        xuanzuoRlv.setAdapter(quLieAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);
        quLieAdapter.setOnItemClicks(new QuLieAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                xuanzuoQuyu.setText(result.get(p - 1).getRegionName());
                mPresenter.getPresenterXinXi(key,p,1,5);
        }
        });
    }
    }

    @Override
    public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
        List<XuanZuoXinXiBean.ResultBean> result = xuanZuoXinXiBean.getResult();
        XuanZuoXinXiAdapter xuanZuoXinXiAdapter = new XuanZuoXinXiAdapter(this);
        xuanZuoXinXiAdapter.setList(result);
        xuanzuoRlv.setAdapter(xuanZuoXinXiAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);
        xuanZuoXinXiAdapter.setOnItemClicks(new XuanZuoXinXiAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(XuanZuoActivity.this, GouPiaoActivity.class);
                intent.putExtra("cinemaid",p);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
     //  EventBus.getDefault().postSticky(xuanZuoXinXiBean);


    }

    @Override
    public void onHomesuccess(ShiJianBean shiJianBean) {
        List<String> result = shiJianBean.getResult();
        ShiJianAdapter shiJianAdapter = new ShiJianAdapter(this,shiJianBean);
        xuanzuoRlv.setAdapter(shiJianAdapter);
        shiJianAdapter.setOnItemClicks(new ShiJianAdapter.onItemClicks() {
            @Override
            public void onChangeData(String p) {
                xuanzuoShijian.setText(p);
                mPresenter.getPresentershijianyingyuan(key,p,1,5);
            }
        });
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onHomesuccess(PriceBean priceBean) {
        List<PriceBean.ResultBean> result = priceBean.getResult();
        PriceAdapter priceAdapter = new PriceAdapter(this);
        priceAdapter.setList(result);
        xuanzuoRlv.setAdapter(priceAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);
        //j接口回调
        priceAdapter.setOnItemClicks(new PriceAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(XuanZuoActivity.this, GouPiaoActivity.class);
                intent.putExtra("cinemaid",p);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
        List<ShiJianYingYuanBean.ResultBean> result = shiJianYingYuanBean.getResult();
        ShiJianYingYuanAdapter shiJianYingYuanAdapter = new ShiJianYingYuanAdapter(this);
        shiJianYingYuanAdapter.setList(result);
        xuanzuoRlv.setAdapter(shiJianYingYuanAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);
        shiJianYingYuanAdapter.setOnItemClicks(new ShiJianYingYuanAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(XuanZuoActivity.this, GouPiaoActivity.class);
                intent.putExtra("cinemaid",p);
                intent.putExtra("key",key);
                startActivity(intent);
            }
        });
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }



}

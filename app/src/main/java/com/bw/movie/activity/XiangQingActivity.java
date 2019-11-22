package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
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
import com.bw.movie.frag.xiangqing.JieShaoFragment;
import com.bw.movie.frag.xiangqing.JuZhaoFragment;
import com.bw.movie.frag.xiangqing.YingPingFragment;
import com.bw.movie.frag.xiangqing.YuGaoFragment;
import com.bw.movie.presenter.HomePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangQingActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.movie_tab)
    TabLayout movieTab;
    @BindView(R.id.movie_pager)
    ViewPager moviePager;
    @BindView(R.id.back_filmdetail)
    SimpleDraweeView backFilmdetail;
    @BindView(R.id.img_filmdetail)
    SimpleDraweeView imgFilmdetail;
    @BindView(R.id.score_filmdetail)
    TextView scoreFilmdetail;
    @BindView(R.id.wether_filmdetail)
    TextView wetherFilmdetail;
    @BindView(R.id.name_filmdetail)
    TextView nameFilmdetail;
    @BindView(R.id.type_filmdetail)
    TextView typeFilmdetail;
    @BindView(R.id.time_filmdetail)
    TextView timeFilmdetail;
    @BindView(R.id.data_filmdetail)
    TextView dataFilmdetail;
    @BindView(R.id.location_filmdetail)
    TextView locationFilmdetail;
    @BindView(R.id.dt_xin)
    CheckBox dtXin;
    @BindView(R.id.dt_guanzhu)
    TextView dtGuanzhu;
    @BindView(R.id.filmdetail_write)
    Button filmdetailWrite;
    @BindView(R.id.xiangqing_xuanzuo)
    Button xiangqingXuanzuo;
    private int key;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiang_qing;
    }

    @Override
    protected void initData() {
        super.initData();
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);
        mPresenter.getModelXiangQing(key);
        final ArrayList<Fragment> list = new ArrayList<>();
        final ArrayList<String> listab = new ArrayList<>();
        list.add(new JieShaoFragment());
        list.add(new YuGaoFragment());
        list.add(new JuZhaoFragment());
        list.add(new YingPingFragment());
        listab.add("介绍");
        listab.add("预告");
        listab.add("剧照");
        listab.add("影评");

        moviePager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            // getPageTitle
            @Override
            public CharSequence getPageTitle(int position) {
                return listab.get(position);
            }
        });
        movieTab.setupWithViewPager(moviePager);


    }
    @OnClick({R.id.filmdetail_write, R.id.xiangqing_xuanzuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //写影评
            case R.id.filmdetail_write:

                break;
                //选座
            case R.id.xiangqing_xuanzuo:
                Intent intent = new Intent(XiangQingActivity.this,XuanZuoActivity.class);
                intent.putExtra("key",key);
                startActivity(intent);

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

    //详情
    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {
        XiangQingBean.ResultBean result = xiangQingBean.getResult();
        String duration = result.getDuration();
        String imageUrl = result.getImageUrl();
        scoreFilmdetail.setText("评分  " + result.getScore() + "分");
        wetherFilmdetail.setText("评论  " + result.getCommentNum() + "万条");
        nameFilmdetail.setText(result.getName());
        typeFilmdetail.setText(result.getMovieType());
        timeFilmdetail.setText(duration);
        Date date = new Date(result.getReleaseTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dataFilmdetail.setText(String.valueOf(simpleDateFormat.format(date) + "上映"));
        locationFilmdetail.setText(result.getPlaceOrigin());
        SimpleDraweeView simpleDraweeView = findViewById(R.id.img_filmdetail);
        simpleDraweeView.setImageURI(imageUrl);

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

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}

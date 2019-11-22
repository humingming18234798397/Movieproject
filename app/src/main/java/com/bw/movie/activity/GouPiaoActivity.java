package com.bw.movie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.YingTingAdapter;
import com.bw.movie.adapter.ZuoWeiAdapter;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class GouPiaoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.goupiao_fanhui)
    SimpleDraweeView goupiaoFanhui;
    @BindView(R.id.goupiao_name)
    TextView goupiaoName;
    @BindView(R.id.goupiao_jcvideo)
    JCVideoPlayer goupiaoJcvideo;
    @BindView(R.id.img_jcv)
    SimpleDraweeView imgJcv;
    @BindView(R.id.goupiao_rlv)
    RecyclerView goupiaoRlv;
    @BindView(R.id.cb_cinemaseatkexuan)
    CheckBox cbCinemaseatkexuan;
    @BindView(R.id.cb_cinemaseatyishou)
    CheckBox cbCinemaseatyishou;
    @BindView(R.id.cb_cinemaseat_xuanzhong)
    CheckBox cbCinemaseatXuanzhong;
    @BindView(R.id.liner)
    LinearLayout liner;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.recycle_yingting)
    RecyclerView recycleYingting;
    @BindView(R.id.btn_xiadan)
    Button btnXiadan;
    @BindView(R.id.btn_xuanzuo)
    Button btnXuanzuo;
    private int key;
    private int cinemaid;
    //  EventBus.getDefault().register(this);
    double money = 0;
    private double fare1;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gou_piao;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);
        cinemaid = intent.getIntExtra("cinemaid", 0);
        mPresenter.getModelXiangQing(key);
        mPresenter.getPresenteryingting(key,cinemaid);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleYingting.setLayoutManager(linearLayoutManager);
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
        goupiaoName.setText(result.getName());
        goupiaoJcvideo.setUp(result.getShortFilmList().get(0).getVideoUrl(),null);
        Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(goupiaoJcvideo.ivThumb);

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
        List<YingTingBean.ResultBean> result = yingTingBean.getResult();
        YingTingAdapter yingTingAdapter = new YingTingAdapter(GouPiaoActivity.this);
        yingTingAdapter.setList(result);
        recycleYingting.setAdapter(yingTingAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleYingting.setLayoutManager(linearLayoutManager);
        //接口回调
        yingTingAdapter.setOnItemClicks(new YingTingAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p,double fare) {
                mPresenter.getPresenterzuowei(p);
                fare1 = fare;
                money=0;
                btnXiadan.setVisibility(View.INVISIBLE);
                //chooseSeat.setText("￥ "+money);
                btnXuanzuo.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
        List<ZuoWeiHaoBean.ResultBean> result = zuoWeiHaoBean.getResult();
        int seat = Integer.parseInt(result.get(result.size() - 1).getSeat());
        ZuoWeiAdapter zuoWeiAdapter = new ZuoWeiAdapter(this,result);
        goupiaoRlv.setAdapter(zuoWeiAdapter);
        //布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,seat);
        goupiaoRlv.setLayoutManager(gridLayoutManager);
        zuoWeiAdapter.setOnclickListener(new ZuoWeiAdapter.OnclickListener() {
            @Override
            public void onclick(String row, String seat, boolean ischecked) {
                if (ischecked==true){
                    Toast.makeText(GouPiaoActivity.this, row + "排" + seat + "座", Toast.LENGTH_SHORT).show();
                    money =money+fare1;
                    btnXuanzuo.setVisibility(View.INVISIBLE);
                    btnXiadan.setVisibility(View.VISIBLE);
                    btnXiadan.setText("￥ "+money);
                }else{
                    money = money-fare1;
                    btnXuanzuo.setVisibility(View.INVISIBLE);
                    btnXiadan.setVisibility(View.VISIBLE);
                    btnXiadan.setText("￥ "+money);
                }
            }
        });
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



/*    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void setinit(XuanZuoXinXiBean xuanZuoXinXiBean){

    }*/

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }*/
}

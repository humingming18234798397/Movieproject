package com.bw.movie.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.YingYuanSouSuoAdapter;
import com.bw.movie.adapter.YingYuanTuiJinAdapter;
import com.bw.movie.base.BaseActivity;
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
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YingYuanSouSuo extends BaseActivity<YingYuanPresenter> implements YingYuanContract.Iview {

    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.sousuo_button)
    Button sousuoButton;
    @BindView(R.id.sousuo_xrlv)
    RecyclerView sousuoXrlv;
    @BindView(R.id.sousuo_simple)
    SimpleDraweeView sousuoSimple;
    private String text;

    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ying_yuan_sou_suo;
    }

    @Override
    protected void initData() {
        super.initData();
        //f返回
        sousuoSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mPresenter.getPresentersousuo("万", 1, 10);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        sousuoXrlv.setLayoutManager(linearLayoutManager);
    }

    @OnClick(R.id.sousuo_button)
    public void onViewClicked() {
        //获取输入框内容
        text = editText.getText().toString().trim();
        mPresenter.getPresentersousuo(text, 1, 10);
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
    //ying影院搜索
    @Override
    public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {
        List<YingYuanSouSuoBean.ResultBean> result = yingYuanSouSuoBean.getResult();
        YingYuanSouSuoAdapter yingYuanSouSuoAdapter = new YingYuanSouSuoAdapter(this);
        yingYuanSouSuoAdapter.setList(result);
        sousuoXrlv.setAdapter(yingYuanSouSuoAdapter);

        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        sousuoXrlv.setLayoutManager(linearLayoutManager);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}

package com.bw.movie.frag;


/*
 *@auther:胡明明
 *@Date: 2019/11/21
 *@Time:21:14
 *@Description:${DESCRIPTION}
 **/

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;

import butterknife.BindView;

public class ZhouQiFragment extends BaseFragment {
    @BindView(R.id.nnnnn)
    TextView nnnnn;
    @BindView(R.id.zhouqi_rlv)
    RecyclerView zhouqiRlv;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_zhouqi;
    }

    @Override
    protected void initData() {
        super.initData();
        //获取Activity传来的数据
        Bundle bundle = getArguments();
        String url = bundle.getString("url");
nnnnn.setText(url);

    }
}

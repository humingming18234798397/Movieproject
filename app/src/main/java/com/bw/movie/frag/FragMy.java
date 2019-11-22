package com.bw.movie.frag;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:21:03
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.LinearLayout;

import com.bw.movie.R;
import com.bw.movie.activity.BanBenActivity;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class FragMy extends BaseFragment {
    @BindView(R.id.my_shezhi)
    LinearLayout myShezhi;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_my;
    }

    @Override
    protected void initData() {
        super.initData();

    }
//点击设置跳转
    @OnClick(R.id.my_shezhi)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), BanBenActivity.class);
        startActivity(intent);
    }
}

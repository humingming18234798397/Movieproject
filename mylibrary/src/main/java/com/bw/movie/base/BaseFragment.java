package com.bw.movie.base;


/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:20:27
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bw.movie.utils.NetUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    protected P mPresenter;
    protected View inflate;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(provideLayoutId(), container, false);
        bind = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = providePresenter();
        if (mPresenter!=null){
            mPresenter.attachView(this);
        }
        initData();
    }

    protected abstract P providePresenter();

    protected void initData() {

    }

    protected abstract int provideLayoutId();

    //判断网络
    public boolean hasNetWork(){
        return NetUtil.hasNetWork(context());
    }
    //无网提示
    public void showNoNetTip(){
        Toast.makeText(context(), "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}

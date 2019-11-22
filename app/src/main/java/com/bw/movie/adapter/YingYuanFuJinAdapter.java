package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/14
 *@Time:10:21
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class YingYuanFuJinAdapter extends BaseRecyclerAdapter<YingYuanFuJinBean.ResultBean> {
    public YingYuanFuJinAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yingyuan_item1;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, YingYuanFuJinBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.yingyuan_item1_name,resultBean.getName());
        baseViewHolder.setText(R.id.yingyuan_item1_dizhi,resultBean.getAddress());
        baseViewHolder.setText(R.id.yingyuan_item1_juli,resultBean.getDistance()+"m");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView)baseViewHolder.get(R.id.yingyuan_item1_img);
        simpleDraweeView.setImageURI(resultBean.getLogo());
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, YingYuanFuJinBean.ResultBean resultBean) {

    }
}

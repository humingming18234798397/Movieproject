package com.bw.movie.adapter;

/**
 *@describe(描述)：HomeSouSuoAdaprer
 *@data（日期）: 2019/11/18
 *@time（时间）: 19:52
 *@author（作者）: 胡明明
 **/

import android.content.Context;

import com.bw.movie.R;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.HomeSouSuoBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class HomeSouSuoAdaprer extends BaseRecyclerAdapter<HomeSouSuoBean.ResultBean> {
    public HomeSouSuoAdaprer(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homelist_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, HomeSouSuoBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.item2_ren,"评分:"+resultBean.getScore()+"分");
        baseViewHolder.setText(R.id.item2_name,resultBean.getName());
        baseViewHolder.setText(R.id.item2_time,"导演:"+resultBean.getDirector());
        baseViewHolder.setText(R.id.item2_zhuyan,"主演:"+resultBean.getStarring());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.item2_img);
        simpleDraweeView.setImageURI(resultBean.getImageUrl());

    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, HomeSouSuoBean.ResultBean resultBean) {

    }
/*    //接口回调
    onItemClicks onItemClicks;
    public void setOnItemClicks( onItemClicks onItemClicks){
        this.onItemClicks = onItemClicks;
    }
    public interface onItemClicks{
        void onChangeData(int p);
    }*/
}

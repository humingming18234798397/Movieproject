package com.bw.movie.frag;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:21:03
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.activity.HomeSousuoActivity;
import com.bw.movie.activity.XiangQingActivity;
import com.bw.movie.adapter.MyAdapter;
import com.bw.movie.base.BaseFragment;
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
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FragHome extends BaseFragment<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.home_xrecyclerview)
    XRecyclerView homeXrecyclerview;
    @BindView(R.id.home_sousuo)
    SimpleDraweeView homeSousuo;
    private List<XBannerBean.ResultBean> result;
    private List<ReYingBean.ResultBean> remen;
    private List<ShangYingBean.ResultBean> shangying;
    private List<HomeBean.ResultBean> home;
    int page = 1;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_home;
    }

    @Override
    protected void initData() {
        super.initData();
        //下拉刷新,上拉加载
        homeXrecyclerview.setPullRefreshEnabled(true);
        homeXrecyclerview.setLoadingMoreEnabled(true);
        homeXrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.getPresenterReYing(page, 5);
                mPresenter.getPresenterShangYing(page, 3);
                mPresenter.getPresenterHome(page, 5);
                homeXrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterReYing(page, 5);
                mPresenter.getPresenterShangYing(page, 3);
                mPresenter.getPresenterHome(page, 5);
                homeXrecyclerview.loadMoreComplete();
            }
        });

        mPresenter.getPresenterXbanner();
        mPresenter.getPresenterReYing(1, 5);
        mPresenter.getPresenterShangYing(1, 3);
        mPresenter.getPresenterHome(1, 5);
    }
    //多条目
    @Override
    public void onHomesuccess(XBannerBean xBannerBean) {
        result = xBannerBean.getResult();
      /*  xbanner.setBannerData(R.layout.simpledraweeview, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int index) {
                return null;
            }

            @Override
            public int size() {
                return result.size();
            }
        });
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                SimpleDraweeView simpleDraweeView = view.findViewById(R.id.xbanner_simview);
                String imageUrl = result.get(position).getImageUrl();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(imageUrl)
                        .setAutoPlayAnimations(true)
                        .build();
                simpleDraweeView.setController(controller);
                TextView tvContent = (TextView) view.findViewById(R.id.tv);
                tvContent.setText(xBannerBean.getResult().get(position).getRank()+"/5");
            }
        });*/
       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        homeXrecyclerview.setAdapter(new MyAdapter(result,remen,shangying,home,getActivity()));
*/
    }

    @Override
    public void onHomesuccess(ReYingBean reYingBean) {
        remen = reYingBean.getResult();
      /*  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        homeXrecyclerview.setAdapter(new MyAdapter(result,remen,shangying,home,getActivity()));*/


    }

    @Override
    public void onHomesuccess(ShangYingBean shangYingBean) {
        shangying = shangYingBean.getResult();
      /*  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        homeXrecyclerview.setAdapter(new MyAdapter(result,remen,shangying,home,getActivity()));
*/
    }

    @Override
    public void onHomesuccess(HomeBean homeBean) {
        home = homeBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(result, remen, shangying, home, getActivity());
        homeXrecyclerview.setAdapter(myAdapter);
        myAdapter.setSetChangeAdapter(new MyAdapter.setChangeAdapter() {
            @Override
            public void getChang(int movie) {
                Intent intent = new Intent(getActivity(), XiangQingActivity.class);
                intent.putExtra("key", movie);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {

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
    //搜索点击
    @OnClick(R.id.home_sousuo)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), HomeSousuoActivity.class);
        startActivity(intent);
    }
}

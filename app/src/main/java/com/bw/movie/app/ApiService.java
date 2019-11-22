package com.bw.movie.app;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:16:17
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.HomeSouSuoBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.QuBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.bw.movie.bean.YingYuanPingLun;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.bw.movie.bean.ZuoWeiHaoBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {

    //fasong发生邮箱post
    //  http://172.17.8.100/movieApi/user/v2/sendOutEmailCode
    @FormUrlEncoded
        @POST("movieApi/user/v2/sendOutEmailCode")
        Observable<EmailBean> getemail(@Field("email") String email);
    //注册post
    //http://172.17.8.100/movieApi/user/v2/register
    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<RegisterBean> getRegister(@Field("nickName") String nickName, @Field("pwd") String pwd, @Field("email") String email, @Field("code") String code);
    //登录post
    //http://172.17.8.100/movieApi/user/v2/login
    @FormUrlEncoded
    @POST("movieApi/user/v2/login")
    Observable<LoginBean> getLogin(@Field("email") String email, @Field("pwd") String pwd);
    //断点续传
    public static final String BASE_URL = "http://172.17.8.100/";
    @Streaming
    @GET
    Observable<ResponseBody> executeDownload(@Header("Range") String range, @Url() String url);
    //轮播图
    //http://172.17.8.100/movieApi/tool/v2/banner
    @GET("movieApi/tool/v2/banner")
        Observable<XBannerBean> getXBanner();
    //正在上映
    //http://172.17.8.100/movieApi/movie/v2/findReleaseMovieList?page=1&count=5
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<ReYingBean> getReYing(@Query("page") Integer page, @Query("count") Integer count);
    //即将上映
    //http://172.17.8.100/movieApi/movie/v2/findComingSoonMovieList?page=1&count=3
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<ShangYingBean> getShangYing(@Query("page") Integer page, @Query("count") Integer count);
    //首页数据
    //http://172.17.8.100/movieApi/movie/v2/findHotMovieList?page=1&count=5
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<HomeBean> gethomedata(@Query("page") Integer page,@Query("count") Integer count);
    //区域查询
    //172.17.8.100/movieApi/cinema/v2/findCinemaByRegion
    @GET("movieApi/cinema/v2/findCinemaByRegion")
    Observable<QuBean> getqu(@Query("regionId") String regionId);
    //地区列表
    //172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("movieApi/tool/v2/findRegionList")
    Observable<QuLeiBean> getqulei();
    //推荐影院
    //http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<YingYuanTuiJianBean> getYingYuantuijian(@Query("page") Integer page, @Query("count") Integer count);
    //fujin附近影院
    //http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas?longitude=116.30551391385724&latitude=40.04571807462411&page=1&count=10
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<YingYuanFuJinBean> getYingYuanfujin(@Query("longitude") String longitude, @Query("latitude") String latitude, @Query("page") Integer page, @Query("count") Integer count);
    //详情
    //http://172.17.8.100/movieApi/movie/v2/findMoviesDetail?movieId=22
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<XiangQingBean> getXiangQing(@Query("movieId") Integer movieId);
    //影评
    //http://172.17.8.100/movieApi/movie/v2/findAllMovieComment?movieId=1&page=1&count=10
    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<YingPingBean> getYingPing(@Query("movieId") Integer movieId, @Query("page") Integer page, @Query("count") Integer count);
    //首页搜索
    //http://172.17.8.100/movieApi/movie/v2/findMovieByKeyword?keyword=我&page=1&count=5
    @GET("movieApi/movie/v2/findMovieByKeyword")
    Observable<HomeSouSuoBean> getSouSuo(@Query("keyword") String keyword, @Query("page") Integer page, @Query("count") Integer count);
    //影院搜索模糊查询
    //http://172.17.8.100/movieApi/cinema/v1/findAllCinemas?cinemaName=万&page=1&count=10
    @GET("movieApi/cinema/v1/findAllCinemas")
    Observable<YingYuanSouSuoBean> getchaxun(@Query("cinemaName") String cinemaName, @Query("page") Integer page, @Query("count") Integer count);
    //yi影院信息
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByRegion?movieId=22&regionId=1&page=1&count=10
    @GET("movieApi/movie/v2/findCinemasInfoByRegion")
    Observable<XuanZuoXinXiBean> getxinxi(@Query("movieId") Integer movieId, @Query("regionId") Integer regionId, @Query("page") Integer page, @Query("count") Integer count);
        //时间
    //http://172.17.8.100/movieApi/tool/v2/findDateList
    @GET("movieApi/tool/v2/findDateList")
    Observable<ShiJianBean> getshijian();
    //时间查询影院信息
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByDate?movieId=22&date=11-20&page=1&count=5
    @GET("movieApi/movie/v2/findCinemasInfoByDate")
    Observable<ShiJianYingYuanBean> getshijianyingyuan(@Query("movieId") Integer movieId,@Query("date") String date, @Query("page") Integer page, @Query("count") Integer count);
    //价格
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByPrice?movieId=22&page=1&count=5
    @GET("movieApi/movie/v2/findCinemasInfoByPrice")
    Observable<PriceBean> getprice(@Query("movieId") Integer movieId, @Query("page") Integer page, @Query("count") Integer count);
    //chaxun查询影厅
    //http://172.17.8.100/movieApi/movie/v2/findMovieSchedule?movieId=22&cinemaId=1
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<YingTingBean> getyingting(@Query("movieId") Integer movieId, @Query("cinemaId") Integer cinemaId);
    //选座
    //http://172.17.8.100/movieApi/movie/v2/findSeatInfo?hallId=3
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<ZuoWeiHaoBean> getzuowei(@Query("hallId") Integer hallId);
    //ying影院详情
    //http://172.17.8.100/movieApi/cinema/v1/findCinemaInfo?cinemaId=1
    @GET("movieApi/cinema/v1/findCinemaInfo")
    Observable<YYXQBean> getyyxq(@Query("cinemaId") Integer cinemaId);
    //影院评论
    //http://172.17.8.100/movieApi/cinema/v1/findAllCinemaComment?cinemaId=18&page=1&count=5
    @GET("movieApi/cinema/v1/findAllCinemaComment")
    Observable<YingYuanPingLun> getpinglun(@Query("cinemaId") Integer cinemaId,@Query("page") Integer page, @Query("count") Integer count);

}

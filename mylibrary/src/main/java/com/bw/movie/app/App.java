package com.bw.movie.app;


/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:19:29
 *@Description:${DESCRIPTION}
 **/

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    public static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sContext = this;
    }
    public static App getsAppContext(){
        return sContext;
    }
}

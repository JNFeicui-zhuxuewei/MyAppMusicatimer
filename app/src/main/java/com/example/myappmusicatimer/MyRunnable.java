package com.example.myappmusicatimer;

import android.os.Handler;

/**
 * 项目重点
 * Created by 似水流年 on 2016/6/15.
 */
public abstract class MyRunnable implements  Runnable {

    Handler mHandler;
    int time = 0;

    public MyRunnable (Handler handler,int time){
        mHandler = handler;
        this.time = time;

    }


    @Override
    public void run() {
        time = time -1;
        turnoverTime(time);
        if (time == 30){
            onPlayNotification();
        }
        if (time > 0){
            mHandler.postDelayed(this,1000);
        }else {
            overtime();
        }

    }

    public abstract void overtime() ;


    public abstract void onPlayNotification() ;

    public abstract void turnoverTime(int time) ;
}

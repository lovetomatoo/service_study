package com.ghx.app.service;

import android.support.annotation.Nullable;
import com.ghx.app.iview.IMyTestView;
import com.ghx.app.utils.Logger;
import android.content.Intent;
import android.widget.Toast;
import android.app.Service;
import android.os.IBinder;

/**
 * Created by guo_hx on 2016/10/31.14:50
 */

public class MyTestService extends Service implements IMyTestView {


    private static final java.lang.String LOG_TAG = MyTestService.class.getSimpleName();

    @Override
    public void onCreate() {

        super.onCreate();
        Logger.log_i(LOG_TAG, "onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Logger.log_i(LOG_TAG, "onBind");
        return new MyTestBinder(this);
    }

    @Override
    public void onStart(Intent intent, int startId) {

        Logger.log_i(LOG_TAG, "onStart");

        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Logger.log_i(LOG_TAG, "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Logger.log_i(LOG_TAG, "onUnbind");

        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {

        Logger.log_i(LOG_TAG, "onDestroy");

        super.onDestroy();
    }

    @Override
    public void binderTest() {
        Toast.makeText(this, "binderTest_方法被调用了", Toast.LENGTH_SHORT).show();
    }
}

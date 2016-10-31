package com.ghx.app.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ghx.app.R;
import com.ghx.app.service.MyTestService;
import com.ghx.app.utils.Logger;

public class MainActivity extends AppCompatActivity {

    public static final java.lang.String TAG_LOG = MainActivity.class.getSimpleName();

    private Intent intent;
    ServiceConnection mConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.log_i("MainActivity", "onCreate");
        intent = new Intent(this, MyTestService.class);
//        startService(intent);
        mConnection = new ServiceConnection() {


            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Logger.log_i(TAG_LOG, "bindService_onServiceConnected");
//                ((MyTestBinder)iBinder).binderTest();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Logger.log_i(TAG_LOG, "bindService_onServiceDisconnected");
            }
        };
        bindService(intent, mConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
//        stopService(intent);
        unbindService(mConnection);
        super.onDestroy();

    }
}

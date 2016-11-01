package com.ghx.app.activity;

import android.support.v7.app.AppCompatActivity;
import android.content.ServiceConnection;
import com.ghx.app.service.MyTestBinder;
import com.ghx.app.service.MyTestService;
import android.content.ComponentName;
import com.ghx.app.utils.Logger;
import android.content.Intent;
import android.widget.Button;
import android.os.IBinder;
import android.os.Bundle;
import android.view.View;
import com.ghx.app.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG_LOG = MainActivity.class.getSimpleName();

    private Intent intent;
    private ServiceConnection mConnection;
    private Button mBtnStartService;
    private Button mBtnBindService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Logger.log_i("MainActivity", "onCreate");

        initAllView();

    }

    private void initAllView() {

        mBtnStartService = (Button) findViewById(R.id.btn_start_service);
        mBtnBindService = (Button) findViewById(R.id.btn_bind_service);

        mBtnStartService.setOnClickListener(this);
        mBtnBindService.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        stopService(intent);
        unbindService(mConnection);
        super.onDestroy();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_service: {
                intent = new Intent(this, MyTestService.class);
                startService(intent);
            }
            break;

            case R.id.btn_bind_service: {
                intent = new Intent(this, MyTestService.class);
                mConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        Logger.log_i(TAG_LOG, "bindService_onServiceConnected");
                        ((MyTestBinder) iBinder).binderTest();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName componentName) {
                        Logger.log_i(TAG_LOG, "bindService_onServiceDisconnected");
                    }
                };
                bindService(intent, mConnection, BIND_AUTO_CREATE);
            }
            break;
        }
    }
}

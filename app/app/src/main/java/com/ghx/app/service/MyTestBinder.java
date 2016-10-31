package com.ghx.app.service;

import android.content.Context;
import android.os.Binder;
import android.widget.Toast;

import com.ghx.app.iview.IMyTestView;

/**
 * Created by guo_hx on 2016/10/31.15:40
 */

public class MyTestBinder extends Binder {

    private Context mContext;
    private IMyTestView mIView;

    public MyTestBinder(Context context, IMyTestView iView) {

        mContext = context;
        mIView = iView;
    }

    public void binderTest() {
        Toast.makeText(mContext, "binderTest_方法被调用了", Toast.LENGTH_SHORT).show();
    }
}

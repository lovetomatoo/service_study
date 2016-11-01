package com.ghx.app.service;

import com.ghx.app.iview.IMyTestView;
import android.os.Binder;

/**
 * Created by guo_hx on 2016/10/31.15:40
 */

public class MyTestBinder extends Binder {

    private IMyTestView mIView;

    public MyTestBinder(IMyTestView iView) {

        mIView = iView;
    }

    public void binderTest() {

        mIView.binderTest();
    }
}

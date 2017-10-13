package com.ciaoniaowoplay.cainiaowoplay.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ciaoniaowoplay.cainiaowoplay.AppApplication;
import com.ciaoniaowoplay.cainiaowoplay.di.AppComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: huang_yanhui
 * data:2017/10/13
 * time:10:04
 * emaill:huangyh@thinkive.com
 * description:
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    public abstract void init();

    public abstract int setLayout();
    private AppApplication mApplication;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        bind = ButterKnife.bind(this);
        this.mApplication = (AppApplication) getApplication();
        setupAcitivtyComponent(mApplication.getAppComponent());
        init();
    }

    public abstract  void setupAcitivtyComponent(AppComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
    }
}

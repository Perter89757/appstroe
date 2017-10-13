package com.ciaoniaowoplay.cainiaowoplay;

import android.app.Application;

import com.ciaoniaowoplay.cainiaowoplay.di.AppComponent;
import com.ciaoniaowoplay.cainiaowoplay.di.AppModule;
import com.ciaoniaowoplay.cainiaowoplay.di.DaggerAppComponent;
import com.ciaoniaowoplay.cainiaowoplay.di.HttpModule;

/**
 * author: huang_yanhui
 * data:2017/10/12
 * time:14:19
 * emaill:huangyh@thinkive.com
 * description:
 */

public class AppApplication extends Application {
    private AppComponent appComponent;

    public AppComponent getAppComponent() {

        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //继承依赖对象
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build();
    }
}

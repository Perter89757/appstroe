package com.ciaoniaowoplay.cainiaowoplay.di;

import com.ciaoniaowoplay.cainiaowoplay.http.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author: huang_yanhui
 * data:2017/10/12
 * time:14:32
 * emaill:huangyh@thinkive.com
 * description:
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiService getApiService();
}

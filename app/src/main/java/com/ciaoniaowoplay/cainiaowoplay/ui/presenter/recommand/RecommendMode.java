package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.recommand;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.BaseBean;
import com.ciaoniaowoplay.cainiaowoplay.bean.IndexBean;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;
import com.ciaoniaowoplay.cainiaowoplay.http.ApiService;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base.BaseMode;

import rx.Observable;

/**
 * author: huang_yanhui
 * data:2017/10/26
 * time:14:09
 * emaill:huangyh@thinkive.com
 * description:
 */

public class RecommendMode implements BaseMode {
    private ApiService mApiService;

    //有provides提供
    public RecommendMode(ApiService apiService) {
        this.mApiService = apiService;
    }
    //3.Rx的数据源
    public Observable<BaseBean<PageBean<AppInfo>>> getApps(){
        return  mApiService.getApps("{'page':0}");
    }

    public Observable<BaseBean<IndexBean>> getIndex() {
        return mApiService.index();
    }

    @Override
    public void request() {

    }
}

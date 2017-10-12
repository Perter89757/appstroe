package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.module;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;
import com.ciaoniaowoplay.cainiaowoplay.http.ApiService;
import com.ciaoniaowoplay.cainiaowoplay.http.HttpManager;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.contract.RecommendContract;

import retrofit2.Callback;

/**
 * author: huang_yanhui
 * data:2017/4/23
 * time:14:51
 * emaill:huangyh@thinkive.com
 * description:
 */

public class  RecommendModule implements RecommendContract.Moudle {
    @Override
    public void Moudlerequest(Callback<PageBean<AppInfo>> callback) {
        HttpManager manager = new HttpManager();
        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
        apiService.getApps("{'page':0}").enqueue(callback);
    }
}

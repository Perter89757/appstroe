package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.module;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.BaseBean;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;
import com.ciaoniaowoplay.cainiaowoplay.http.ApiService;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.contract.RecommendContract;

import retrofit2.Callback;
import rx.Observable;

/**
 * author: huang_yanhui
 * data:2017/4/23
 * time:14:51
 * emaill:huangyh@thinkive.com
 * description:
 * RxJava中,module只提供请求,具体的流程在presenter中执行
 */

public class RecommendModule implements RecommendContract.Moudle {
    private ApiService mApiService;

    //有provides提供
    public RecommendModule(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public void Moudlerequest(Callback<PageBean<AppInfo>> callback) {
        //1.
//        HttpManager manager = new HttpManager();
//        ApiService apiService = manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);

        //2.mApiService由Dagger提供
       // mApiService.getApps("{'page':0}").enqueue(callback);
    }

    //3.Rx的数据源
    public Observable<BaseBean<PageBean<AppInfo>>> getApps(){
        return  mApiService.getApps("{'page':0}");
    }
}

package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.BaseBean;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;
import com.ciaoniaowoplay.cainiaowoplay.http.ApiService;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base.BaseMode;

import rx.Observable;

/**
 * author: huang_yanhui
 * data:2017/10/26
 * time:9:55
 * emaill:huangyh@thinkive.com
 * description:
 */

public class RankingMode implements BaseMode {
    private ApiService apiService;

    public RankingMode(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void request() {

    }

    public Observable<BaseBean<PageBean<AppInfo>>> getTopList(int page) {
          return   apiService.topList(page);
    }
}

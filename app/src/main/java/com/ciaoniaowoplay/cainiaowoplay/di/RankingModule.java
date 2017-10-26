package com.ciaoniaowoplay.cainiaowoplay.di;

import com.ciaoniaowoplay.cainiaowoplay.http.ApiService;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage.RankingPresenter;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage.RankingView;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage.RankingMode;

import dagger.Module;
import dagger.Provides;

/**
 * author: huang_yanhui
 * data:2017/10/26
 * time:10:08
 * emaill:huangyh@thinkive.com
 * description:
 */
@Module
public class RankingModule {

private RankingView view;

    //提供Vew-->Fragment提供-->注入
    public RankingModule(RankingView view) {
        this.view = view;
    }

    //提供Presenter
    @Provides
    public RankingPresenter providesRankingPresenter(RankingMode module,RankingView view) {
        return new RankingPresenter(module,view);
    }

    //提供Moudule--->提供Apiservice-->依赖其他;
    @Provides
    public RankingMode ProvidesRadnkingModlue(ApiService apiService) {
        return new RankingMode(apiService);
    }
    //提供View
    @Provides
    public RankingView providesRankingView() {
        return this.view;
    }

}

package com.ciaoniaowoplay.cainiaowoplay.di;

import android.app.ProgressDialog;

import com.ciaoniaowoplay.cainiaowoplay.http.ApiService;
import com.ciaoniaowoplay.cainiaowoplay.ui.fragment.RecommendFragment;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RecommentPresenter;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.contract.RecommendContract;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.module.RecommendModule;

import dagger.Module;
import dagger.Provides;

/**
 * author: huang_yanhui
 * data:2017/10/10
 * time:14:51
 * emaill:huangyh@thinkive.com
 * description:
 */
@Module
public class UserModule {
    RecommendContract.View view;
    //在Fargment界面传入
    public UserModule(RecommendContract.View view) {
        this.view = view;
    }

    //提供给Presenter对象,两个参数来自provideRecommentView,provideRecommentModule
    @Provides
    public RecommendContract.Presenter provideRecomentPresenter(RecommendContract.View view, RecommendModule module) {
        return new RecommentPresenter(view ,module);
    }

    //提供给上边provideRecomentPresenter方法的形参使用
    //提供给progressDialog使用
    @Provides
    public RecommendContract.View provideRecommentView() {
        return  view;
    }

    //提供给上边provideRecomentPresenter方法的形参使用
    //apiservice源于httpModule,需要在UseComponent中引用dependencies = AppComponent.class
    @Provides
    public RecommendModule provideRecommentModule(ApiService apiService) {
        return new RecommendModule(apiService);
    }

    @Provides
    public ProgressDialog provideProgressDialog(RecommendContract.View view) {
        return  new ProgressDialog(((RecommendFragment)(view)).getActivity());
    }

}

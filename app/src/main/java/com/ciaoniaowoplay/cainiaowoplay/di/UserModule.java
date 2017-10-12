package com.ciaoniaowoplay.cainiaowoplay.di;

import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RecommentPresenter;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.contract.RecommendContract;

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
    String name;

    RecommendContract.View view;

    public UserModule(RecommendContract.View view) {
        this.view = view;
    }

    @Provides
    public User provideUser() {
        return new User("jack", new PassWord("123456"));
    }


//
    @Provides
    public RecommendContract.Presenter provideRecommentPresenter(RecommendContract.View view) {
        return new RecommentPresenter(view);
    }

    @Provides
    public RecommendContract.View provideRecommentView() {
        return  view;
    }

}

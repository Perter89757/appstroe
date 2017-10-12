package com.ciaoniaowoplay.cainiaowoplay.ui.presenter;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.contract.RecommendContract;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.module.RecommendModule;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author: huang_yanhui
 * data:2017/4/22
 * time:22:08
 * emaill:huangyh@thinkive.com
 * description:
 */

public class RecommentPresenter implements RecommendContract.Presenter {
    RecommendContract.View view;
    private RecommendModule module;


    public RecommentPresenter(RecommendContract.View view) {
        this.view = view;
        module = new RecommendModule();
    }

    @Override
    public void request() {
        view.showLoading();
        module.Moudlerequest(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                view.dimssLading();
                if (response != null){
                    view.showReult(response.body());
                }else {
                    view.showNodata();
                }
            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                view.dimssLading();
                view.showError(t.getMessage());
            }
        });
    }

}

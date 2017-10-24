package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.contract;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.BasePresenter;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.view.BaseView;

import java.util.List;

import retrofit2.Callback;

/**
 * author: huang_yanhui
 * data:2017/4/22
 * time:22:03
 * emaill:huangyh@thinkive.com
 * description:推荐页面的mvp关联
 */

public interface RecommendContract {

     interface View extends BaseView {
        void showReult(List<AppInfo> response);
    }

    interface Moudle {
        void Moudlerequest(Callback<PageBean<AppInfo>> callback);
    }

   abstract class Presenter extends BasePresenter {

        public Presenter(Object o, BaseView baseView) {
            super(o, baseView);
        }

        public abstract void request();
    }

}

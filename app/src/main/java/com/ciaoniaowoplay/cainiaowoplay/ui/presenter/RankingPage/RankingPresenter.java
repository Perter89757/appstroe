package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;
import com.ciaoniaowoplay.cainiaowoplay.http.RxHttpReponseCompat;
import com.ciaoniaowoplay.cainiaowoplay.rx.ErrorHandlerSubscriber;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base.BasePresenter;

/**
 * author: huang_yanhui
 * data:2017/10/26
 * time:9:55
 * emaill:huangyh@thinkive.com
 * description:
 */

public class RankingPresenter extends BasePresenter<RankingMode,RankingView>{//解决mModel的类型

    public RankingPresenter(RankingMode module, RankingView view) {
        super(module, view);
    }

    public void getTopList(int page) {
        mModel.getTopList(page).compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult())
        .subscribe(new ErrorHandlerSubscriber<PageBean<AppInfo>>(mContext,mView) {
            @Override
            public void onNext(PageBean<AppInfo> pageBean) {
                mView.dimssLading();
                if (pageBean != null) {
                    mView.showContent();
                    mView.showResult(pageBean.getDatas());
                } else {
                    mView.showNodata();
                }
            }
        });
    }

}

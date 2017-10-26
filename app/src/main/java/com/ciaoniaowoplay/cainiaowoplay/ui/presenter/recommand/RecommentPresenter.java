package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.recommand;

import com.ciaoniaowoplay.cainiaowoplay.bean.IndexBean;
import com.ciaoniaowoplay.cainiaowoplay.http.RxHttpReponseCompat;
import com.ciaoniaowoplay.cainiaowoplay.rx.ErrorHandlerSubscriber;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base.BasePresenter;

/**
 * author: huang_yanhui
 * data:2017/4/22
 * time:22:08
 * emaill:huangyh@thinkive.com
 * description:
 */

public class RecommentPresenter extends BasePresenter<RecommendMode,RecommendView> {
    RecommendView view;
    private RecommendMode module;

    //@Inject
    public RecommentPresenter(RecommendView view, RecommendMode module) {
        super(module, view);
        this.view = view;
        this.module = module;
        //  module = new RecommendMode();
    }

    public void request() {

        module.getIndex().compose(RxHttpReponseCompat.<IndexBean>compatResult()).subscribe(new ErrorHandlerSubscriber<IndexBean>(mContext,mView) {
            @Override
            public void onNext(IndexBean indexBean) {
                if (indexBean != null) {
                    view.showContent();
                    view.showReult(indexBean);
                } else {
                    view.showNodata();
                }
            }
        });

//        module.getApps()//得到的数据类型是 Observable<BaseBean<PageBean<AppInfo>>>
//                .compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult())//得到的数据类型 PageBean<AppInfo>
//                .subscribe(new ErrorHandlerSubscriber<PageBean<AppInfo>>(mContext,mView) {
//                    //把请求时的progressdialog进行统一处理
//                    @Override
//                    public void onNext(PageBean<AppInfo> PageBean) {
//                        //请求成功后的完成了json的转化为bean
//                     //   view.dimssLading();
//                        if (PageBean != null) {
//                            view.showReult(PageBean.getDatas());
//                        } else {
//                            view.showNodata();
//                        }
//                    }
//                });


        // getData3();
        //  getData2();
        // getData();
    }

    private void getData3() {
//        module.getApps()
//                .compose(RxHttpReponseCompat.<PageBean<AppInfo>>compatResult())//  <-->填写目标数据结构
//                .subscribe(new Subscriber<PageBean<AppInfo>>() {
//                    @Override
//                    public void onStart() {
//                        super.onStart();
//                        view.showLoading();
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        view.dimssLading();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.dimssLading();
//                        view.showError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(PageBean<AppInfo> PageBean) {
//                    //请求成功后的完成了json的转化为bean
//                        view.dimssLading();
//                        if (PageBean != null) {
//                            view.showReult(PageBean.getDatas());
//                        } else {
//                            view.showNodata();
//                        }
//                    }
//                });
    }

    private void getData2() {
//        module.getApps()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<PageBean<AppInfo>>() {
//                    @Override
//                    public void onStart() {
//                        view.showLoading();
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        view.dimssLading();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.dimssLading();
//                        view.showError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(PageBean<AppInfo> appInfoPageBean) {
//                        //请求成功后的完成了json的转化为bean
//                        view.dimssLading();
//                        if (appInfoPageBean != null) {
//                            view.showReult(appInfoPageBean);
//                        } else {
//                            view.showNodata();
//                        }
//                    }
//                });
    }

    private void getData() {
//        view.showLoading();
//        module.Moudlerequest(new Callback<PageBean<AppInfo>>() {
//            @Override
//            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
//                view.dimssLading();
//                if (response != null) {
//                    view.showReult(response.body());
//                } else {
//                    view.showNodata();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
//                view.dimssLading();
//                view.showError(t.getMessage());
//            }
//        });
    }

}

package com.ciaoniaowoplay.cainiaowoplay.rx;

import android.content.Context;

import com.ciaoniaowoplay.cainiaowoplay.http.BaseException;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base.BaseView;

/**
 * author: huang_yanhui
 * data:2017/10/20
 * time:16:18
 * emaill:huangyh@thinkive.com
 * description:订阅后发生错误的处理
 */

public abstract class ErrorHandlerSubscriber<T> extends DefualtSubscriber<T> {
    private Context context;
    private final BaseView mView;
    private final RxErrorHandler errorHandler;

    public ErrorHandlerSubscriber(Context context, BaseView baseView) {
        this.context = context;
        errorHandler = new RxErrorHandler(context);
        mView = baseView;
    }

    @Override
    public void onStart() {
        super.onStart();
            mView.showLoading();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();//把错误打印到logCat
        BaseException baseException = errorHandler.hnadlerError(e);//把错误分离,分类识别错误类型
        if (baseException == null) {
                mView.showError(e.getMessage());//mView的来源  于展示错误信息
        } else {
                mView.showError(baseException.getDisplayMessage());//展示错误信息
        }
    }

    @Override
    public void onCompleted() {
            mView.dimssLading();
    }
}

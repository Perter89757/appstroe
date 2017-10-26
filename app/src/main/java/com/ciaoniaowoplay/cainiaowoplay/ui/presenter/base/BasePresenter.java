package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * author: huang_yanhui
 * data:2017/4/22
 * time:22:11
 * emaill:huangyh@thinkive.com
 * description:
 */

public class BasePresenter<M,V extends BaseView> {

    protected M mModel;

    protected V mView;


    protected Context mContext;


    public BasePresenter(M m, V v) {

        this.mModel = m;
        this.mView = v;

        initContext();

    }

    private void initContext() {


        if (mView instanceof Fragment) {
            mContext = ((Fragment) mView).getActivity();
        } else {
            mContext = (Activity) mView;
        }
    }
}

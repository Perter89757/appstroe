package com.ciaoniaowoplay.cainiaowoplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciaoniaowoplay.cainiaowoplay.AppApplication;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: huang_yanhui
 * data:2017/10/13
 * time:10:08
 * emaill:huangyh@thinkive.com
 * description:
 */

public abstract class BaseFragment extends Fragment {

    private View mRootView;
    private Unbinder bind;
    private AppApplication application;

    public abstract int setLayout();

    public abstract void init();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(), container, false);
        bind = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        application = (AppApplication) getActivity().getApplication();
        DaggerComonpent(application);
        init();
    }

    protected abstract void DaggerComonpent(AppApplication application);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != Unbinder.EMPTY) {
            bind.unbind();
        }
    }
}

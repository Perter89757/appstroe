package com.ciaoniaowoplay.cainiaowoplay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ciaoniaowoplay.cainiaowoplay.AppApplication;
import com.ciaoniaowoplay.cainiaowoplay.R;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author: huang_yanhui
 * data:2017/10/24
 * time:10:49
 * emaill:huangyh@thinkive.com
 * description:
 */

public abstract class ProgressFragment extends Fragment implements BaseView {
    private FrameLayout mRootView;
    private Unbinder bind;
    private AppApplication application;
    private View mViewProgress;
    private FrameLayout mViewContent;
    private View mViewEmpty;
    private TextView mTextError;
    private Unbinder mUnbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (FrameLayout) inflater.inflate(R.layout.fragment_progress, container, false);
        mViewProgress = mRootView.findViewById(R.id.view_progress);
        mViewContent = (FrameLayout) mRootView.findViewById(R.id.view_content);
        mViewEmpty = mRootView.findViewById(R.id.view_empty);
        mTextError = (TextView) mRootView.findViewById(R.id.text_tip);
        mTextError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ErrorViewClick();
            }
        });
        return mRootView;
    }

    public void ErrorViewClick() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        application = (AppApplication) getActivity().getApplication();
        DaggerComonpent(application);

        //添加内容视图
        View realContentView = LayoutInflater.from(getActivity()).inflate(setLayout(), mViewContent, true);
        mUnbinder = ButterKnife.bind(this, realContentView);

        init();
    }

    protected abstract void init();

    protected abstract int setLayout();

    protected abstract void DaggerComonpent(AppApplication application);

    public void showLoadingData() {
        // mViewProgress.setVisibility(View.VISIBLE);
        showView(R.id.view_progress);
    }

    public void showErrorView(String msg) {
        // mTextError.setVisibility(View.VISIBLE);
        showView(R.id.view_empty);
        mTextError.setText("发生错误:" + msg);
        Log.d("show", "showErrorView");
    }

    public void showEmptyView() {
        // mViewEmpty.setVisibility(View.VISIBLE);
        showView(R.id.view_empty);
        Log.d("show", "emptyView");
    }

    public void showContentView() {
        //mViewContent.setVisibility(View.VISIBLE);
        showView(R.id.view_content);
    }

    public void showView(int viewID) {
        for (int i = 0; i < mRootView.getChildCount(); i++) {
            if (viewID == mRootView.getChildAt(i).getId()) {
                mRootView.getChildAt(i).setVisibility(View.VISIBLE);
            } else {
                mRootView.getChildAt(i).setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void showError(String errorInfo) {
        showErrorView(errorInfo);
    }

    @Override
    public void showNodata() {
        showEmptyView();
    }

    @Override
    public void showLoading() {
        showLoadingData();
    }

    @Override
    public void dimssLading() {
        mViewProgress.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }

}

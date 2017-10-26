package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base;

/**
 * author: huang_yanhui
 * data:2017/4/22
 * time:22:04
 * emaill:huangyh@thinkive.com
 * description:
 */

public interface BaseView {
    void showLoading();
    void dimssLading();
    void showNodata();
    void showError(String errorInfo);
    void showContent();
}

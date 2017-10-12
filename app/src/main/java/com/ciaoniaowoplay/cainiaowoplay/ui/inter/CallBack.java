package com.ciaoniaowoplay.cainiaowoplay.ui.inter;

/**
 * author: huang_yanhui
 * data:2017/4/23
 * time:14:26
 * emaill:huangyh@thinkive.com
 * description:
 */

public interface CallBack<T> {
    void onSuceess(T t);

    void onError(String errorInfo);
}

package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.recommand;

import com.ciaoniaowoplay.cainiaowoplay.bean.IndexBean;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base.BaseView;

/**
 * author: huang_yanhui
 * data:2017/10/26
 * time:14:10
 * emaill:huangyh@thinkive.com
 * description:
 */

public interface RecommendView extends BaseView {
    void showReult(IndexBean response);
}

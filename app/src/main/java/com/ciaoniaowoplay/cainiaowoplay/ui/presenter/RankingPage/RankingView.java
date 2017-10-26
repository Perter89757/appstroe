package com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.base.BaseView;

import java.util.List;

/**
 * author: huang_yanhui
 * data:2017/10/26
 * time:11:06
 * emaill:huangyh@thinkive.com
 * description:
 */

public interface RankingView extends BaseView {
    void showResult(List<AppInfo> appInfo);
}

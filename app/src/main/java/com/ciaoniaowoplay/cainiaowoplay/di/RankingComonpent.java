package com.ciaoniaowoplay.cainiaowoplay.di;

import com.ciaoniaowoplay.cainiaowoplay.ui.fragment.RankingFragment;

import dagger.Component;

/**
 * author: huang_yanhui
 * data:2017/10/26
 * time:10:19
 * emaill:huangyh@thinkive.com
 * description:
 */
@FragmentScope
@Component(modules = RankingModule.class, dependencies = AppComponent.class)
public interface RankingComonpent {

    void RankingFragmentInject(RankingFragment rankingFragment);
}




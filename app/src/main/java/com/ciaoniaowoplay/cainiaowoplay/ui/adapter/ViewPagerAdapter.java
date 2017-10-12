package com.ciaoniaowoplay.cainiaowoplay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ciaoniaowoplay.cainiaowoplay.ui.bean.FragmentInfo;
import com.ciaoniaowoplay.cainiaowoplay.ui.fragment.CategoryFragment;
import com.ciaoniaowoplay.cainiaowoplay.ui.fragment.GamesFragment;
import com.ciaoniaowoplay.cainiaowoplay.ui.fragment.RankingFragment;
import com.ciaoniaowoplay.cainiaowoplay.ui.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mFragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
        mFragments.add(new FragmentInfo("推荐",RecommendFragment.class));
        mFragments.add(new FragmentInfo ("排行", RankingFragment.class));

        mFragments.add(new FragmentInfo ("游戏", GamesFragment.class));
        mFragments.add(new FragmentInfo ("分类", CategoryFragment.class));
    }

    @Override
    public Fragment getItem(int position) {
        try {
            //使用class.创建一个对象
            return (Fragment) mFragments.get(position).getFragment().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}

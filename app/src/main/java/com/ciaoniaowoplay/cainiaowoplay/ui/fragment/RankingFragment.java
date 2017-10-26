package com.ciaoniaowoplay.cainiaowoplay.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ciaoniaowoplay.cainiaowoplay.AppApplication;
import com.ciaoniaowoplay.cainiaowoplay.R;
import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.di.DaggerRankingComonpent;
import com.ciaoniaowoplay.cainiaowoplay.di.RankingModule;
import com.ciaoniaowoplay.cainiaowoplay.ui.adapter.RecomendAppAdatper;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage.RankingPresenter;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.RankingPage.RankingView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by Ivan on 16/9/26.
 */

public class RankingFragment extends ProgressFragment implements RankingView {//用于传入到RankingModule中
    @BindView(R.id.rank_recycle_view)
    RecyclerView recyclerView;

    @BindView(R.id.rank_refreshData)
    SwipeRefreshLayout refreshLayout;

    @Inject
    RankingPresenter presenter;

    @Override
    protected void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        presenter.getTopList(0);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getTopList(0);
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_ranking;
    }

    @Override
    protected void DaggerComonpent(AppApplication application) {
        DaggerRankingComonpent.builder().appComponent(application.getAppComponent())
                .rankingModule(new RankingModule(this)).build().RankingFragmentInject(this);
    }

    @Override
    public void showResult(List<AppInfo> appInfo) {
        RecomendAppAdatper appAdatper = new RecomendAppAdatper(getActivity(), appInfo);
        recyclerView.setAdapter(appAdatper);
    }

}

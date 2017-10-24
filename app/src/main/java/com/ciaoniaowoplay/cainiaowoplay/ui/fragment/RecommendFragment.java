package com.ciaoniaowoplay.cainiaowoplay.ui.fragment;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ciaoniaowoplay.cainiaowoplay.AppApplication;
import com.ciaoniaowoplay.cainiaowoplay.R;
import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.di.DaggerUserComonpent;
import com.ciaoniaowoplay.cainiaowoplay.di.UserModule;
import com.ciaoniaowoplay.cainiaowoplay.ui.adapter.RecomendAppAdatper;
import com.ciaoniaowoplay.cainiaowoplay.ui.presenter.contract.RecommendContract;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by Ivan on 16/9/26.
 */

public class RecommendFragment extends ProgressFragment implements RecommendContract.View {

    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshData)
    SwipeRefreshLayout refreshLayout;

    private List<AppInfo> datas;
    private RecomendAppAdatper mAdatper;

    //  private RecommendContract.Presenter presenter;
    @Inject
    RecommendContract.Presenter presenter;

    //   private ProgressDialog mProgressDialog;
    @Inject
    ProgressDialog mProgressDialog;


    @Override
    public int setLayout() {
        return R.layout.fragment_recomend;
    }

    @Override
    protected void DaggerComonpent(AppApplication application) {
        DaggerUserComonpent.builder().appComponent(application.getAppComponent()).userModule(new UserModule(this)).build().inject(this);

    }

    @Override
    public void init() {
        presenter.request();
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.request();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void ErrorViewClick() {
        super.ErrorViewClick();
        presenter.request();
    }
    //
//    @Nullable
//    @Override
//    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        android.view.View view = inflater.inflate(R.layout.fragment_recomend, container, false);
//        ButterKnife.bind(this, view);
//        // mProgressDialog = new ProgressDialog(getActivity());
//        //presenter = new RecommentPresenter(this);
//        //用于依赖AppComponent,需要提供的对象
//        AppApplication application = (AppApplication) getActivity().getApplication();
//        DaggerUserComonpent.builder().appComponent(application.getAppComponent()).userModule(new UserModule(this)).build().inject(this);
//        initData();
//        return view;
//    }

//    private void initData() {
////        HttpManager manager = new HttpManager();
////        ApiService apiService =manager.getRetrofit(manager.getOkHttpClient()).create(ApiService.class);
//        presenter.request();
//    }

//    @Override
//    public void showLoading() {
//        mProgressDialog.show();
//    }
//
//    @Override
//    public void dimssLading() {
//        mProgressDialog.dismiss();
//    }
//
//    @Override
//    public void showError(String errorInfo) {
//        Toast.makeText(getActivity(), "服务器开小差了：" + errorInfo, Toast.LENGTH_LONG).show();
//    }

    @Override
    public void showReult(List<AppInfo> response) {
        showContentView();
        initRecycleView(response);
    }


    private void initRecycleView(List<AppInfo> datas) {
        //为RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdatper = new RecomendAppAdatper(getActivity(), datas);
        mRecyclerView.setAdapter(mAdatper);
    }
}

package com.ciaoniaowoplay.cainiaowoplay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ciaoniaowoplay.cainiaowoplay.R;
import com.ciaoniaowoplay.cainiaowoplay.bean.Banner;
import com.ciaoniaowoplay.cainiaowoplay.bean.IndexBean;
import com.ciaoniaowoplay.cainiaowoplay.utils.imageloader.ImageLoader;
import com.ciaoniaowoplay.cainiaowoplay.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: huang_yanhui
 * data:2017/10/25
 * time:13:59
 * emaill:huangyh@thinkive.com
 * description:
 */

public class IndexMultipleAdapter extends RecyclerView.Adapter {

    public static final int TYPE_BANNER = 1;
    private static final int TYPE_ICON = 2;
    private static final int TYPE_APPS = 3;
    private static final int TYPE_GAMES = 4;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    private IndexBean mIndexBean;

    public IndexMultipleAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(IndexBean indexBean) {
        mIndexBean = indexBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER) {
            View view = mLayoutInflater.inflate(R.layout.template_banner, parent, false);
            return new BannerViewHolder(view);
        } else if (viewType == TYPE_ICON) {
            View view = mLayoutInflater.inflate(R.layout.template_nav_icon, parent, false);
            return new NavIconViewHolder(view);
        } else if (viewType == TYPE_APPS) {
            View view = mLayoutInflater.inflate(R.layout.template_recyleview_with_title, null, false);
            return new AppViewHolder(view,TYPE_APPS);
        } else if (viewType == TYPE_GAMES) {
            View view = mLayoutInflater.inflate(R.layout.template_recyleview_with_title, null, false);
            return new AppViewHolder(view,TYPE_GAMES);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            //Banner轮播图
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            List<Banner> banners = mIndexBean.getBanners();
            List<String> urls = new ArrayList<>(banners.size());
            for (Banner banner : banners) {
                urls.add(banner.getThumbnail());
            }
            bannerViewHolder.mBanner.setViewUrls(urls);
            bannerViewHolder.mBanner.setOnBannerItemClickListener(new BannerLayout.OnBannerItemClickListener() {
                @Override
                public void onItemClick(int position) {
//                    banners.get(position)
                }
            });
        } else if (position == 1) {

        } else {
            AppViewHolder appViewHolder = (AppViewHolder) holder;
            if (appViewHolder.type == TYPE_APPS) {
                appViewHolder.mText.setText("差评应用");
                RecomendAppAdatper appAdatper = new RecomendAppAdatper(mContext, mIndexBean.getRecommendApps());
                appViewHolder.mRecyclerView.setAdapter(appAdatper);
            } else {
                appViewHolder.mText.setText("冷门游戏");
                RecomendAppAdatper appAdatper = new RecomendAppAdatper(mContext, mIndexBean.getRecommendGames());
                appViewHolder.mRecyclerView.setAdapter(appAdatper);
            }

        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        } else if (position == 1) {
            return TYPE_ICON;
        } else if (position == 2) {
            return TYPE_APPS;
        } else if (position == 3) {
            return TYPE_GAMES;
        }
        return 0;
    }

    class AppViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView mText;
        @BindView(R.id.recycler_view)
        RecyclerView mRecyclerView;
        int type;
        public AppViewHolder(View itemView, int typeApps) {
            super(itemView);
            type = typeApps;
            ButterKnife.bind(this, itemView);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext) {

                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
        }
    }

    class NavIconViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.layout_hot_app)
        LinearLayout layoutHotApp;
        @BindView(R.id.layout_hot_game)
        LinearLayout layoutHotGame;
        @BindView(R.id.layout_hot_subject)
        LinearLayout layoutHotSubject;
        public NavIconViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    class BannerViewHolder extends RecyclerView.ViewHolder {

        private final BannerLayout mBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            // ButterKnife.bind(mContext, itemView);
            mBanner = (BannerLayout) itemView.findViewById(R.id.banner);
            mBanner.setImageLoader(new ImgLoader());
        }
    }

    class ImgLoader implements BannerLayout.ImageLoader {
        @Override
        public void displayImage(Context context, String path, ImageView imageView) {
            ImageLoader.load(path, imageView);
        }
    }
}

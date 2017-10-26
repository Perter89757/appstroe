package com.ciaoniaowoplay.cainiaowoplay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ciaoniaowoplay.cainiaowoplay.R;
import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author: huang_yanhui
 * data:2017/4/22
 * time:23:30
 * emaill:huangyh@thinkive.com
 * description:推荐界面recycleView
 */

public class RecomendAppAdatper extends RecyclerView.Adapter<RecomendAppAdatper.ViewHolder> {
    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.text_size)
    TextView textSize;
    @BindView(R.id.btn_dl)
    Button btnDl;
    private Context mContext;
    private final LayoutInflater layoutInflater;
    private List<AppInfo> mDatas;

    public RecomendAppAdatper(Context context, List<AppInfo> datas) {
        this.mDatas = datas;
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.template_recomend_app, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppInfo appInfo = mDatas.get(position);
        holder.textSize.setText((appInfo.getApkSize() / 1024 /1024) +" MB");
        holder.textTitle.setText(appInfo.getDisplayName());
        String baseImgUrl ="http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";
        Picasso.with(mContext).load(baseImgUrl +appInfo.getIcon()).into(holder.imgIcon);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.text_title)
        TextView textTitle;
        @BindView(R.id.text_size)
        TextView textSize;
        @BindView(R.id.btn_dl)
        Button btnDl;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

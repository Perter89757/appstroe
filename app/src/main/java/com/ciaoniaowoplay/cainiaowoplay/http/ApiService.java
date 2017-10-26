package com.ciaoniaowoplay.cainiaowoplay.http;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.BaseBean;
import com.ciaoniaowoplay.cainiaowoplay.bean.IndexBean;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author: huang_yanhui
 * data:2017/4/22
 * time:23:40
 * emaill:huangyh@thinkive.com
 * description:
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";

    //这里的参数jsonParam会被填充至{featured}中，形成完整的Url请求地址，{featured}相当于一个占位符；
    //http://112.124.22.238:8081/course_api/cniaoplay/featured?p={"page":0}
    // @GET("featured")//返回的是单层bean
    // public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
    //
    @GET("featured2")//返回的是双层bean
    public  Observable<BaseBean<PageBean<AppInfo>>> getApps(@Query("p") String jsonParam);

    @GET("index")
    public  Observable<BaseBean<IndexBean>> index();//请求需要添加公共参数


    @GET("toplist")
    public  Observable<BaseBean<PageBean<AppInfo>>> topList(@Query("page") int page);
}

package com.ciaoniaowoplay.cainiaowoplay.http;

import com.ciaoniaowoplay.cainiaowoplay.bean.AppInfo;
import com.ciaoniaowoplay.cainiaowoplay.bean.PageBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

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
    @GET("featured")
    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
    //
}

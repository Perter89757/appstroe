package com.ciaoniaowoplay.cainiaowoplay.rx;

import android.content.Context;

import com.ciaoniaowoplay.cainiaowoplay.http.ApiException;
import com.ciaoniaowoplay.cainiaowoplay.http.BaseException;
import com.ciaoniaowoplay.cainiaowoplay.http.ErrorMessageFactory;

import org.json.JSONException;

import java.net.SocketException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * author: huang_yanhui
 * data:2017/10/20
 * time:16:19
 * emaill:huangyh@thinkive.com
 * description:
 */

public class RxErrorHandler {

    private Context context;

    public RxErrorHandler(Context context) {
        this.context = context;
    }

    public BaseException hnadlerError(Throwable e) {
        BaseException exception = new BaseException();

        if (e instanceof ApiException) {//自定义错误
            exception.setCode(((ApiException) e).getCode());
        } else if (e instanceof HttpException) {
            exception.setCode(((HttpException) e).code());
        } else if (e instanceof SocketException) {
            exception.setCode(BaseException.SOCKET_ERROR);
        } else if (e instanceof SocketTimeoutException) {
            exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);
        } else if (e instanceof JSONException) {
            exception.setCode(BaseException.JSON_ERROR);
        } else {
            exception.setCode(BaseException.UNKNOWN_ERROR);
        }
        //2.展示错误详细
        exception.setDisplayMessage(ErrorMessageFactory.create(context, exception.getCode()));

        return exception;

    }
}

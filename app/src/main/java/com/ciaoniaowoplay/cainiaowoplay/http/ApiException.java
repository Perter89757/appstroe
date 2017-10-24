package com.ciaoniaowoplay.cainiaowoplay.http;

/**
 * author: huang_yanhui
 * data:2017/10/19
 * time:22:10
 * emaill:huangyh@thinkive.com
 * description:
 */

public class ApiException extends BaseException {
    private int code;

    private String message;

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

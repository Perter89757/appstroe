package com.ciaoniaowoplay.cainiaowoplay.http;

import com.ciaoniaowoplay.cainiaowoplay.bean.BaseBean;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * author: huang_yanhui
 * data:2017/10/19
 * time:21:55
 * emaill:huangyh@thinkive.com
 * description:
 */

public class RxHttpReponseCompat {
    //返回值带泛型的写法
    //传入BaseBean<T>
    //发送出T型数据

    /**
     * 该方法的作用是
     *
     * @param <T>     发射出去的数据类型
     * @return         需要返回的数据类型是RX的数据源observable
     */
    public static <T>  Observable.Transformer<BaseBean<T>, T> compatResult() {

        return new Observable.Transformer<BaseBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseBean<T>> baseBeanObservable) {
              //Transformer-->flatMap-->create
                return baseBeanObservable.flatMap(new Func1<BaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final BaseBean<T> tBaseBean) {
                        //数据返回成功
                        if (tBaseBean.success()) {
                            //实现订阅
                            return Observable.create(new Observable.OnSubscribe<T>() {
                                @Override
                                public void call(Subscriber<? super T> subscriber) {
                                    try {
                                        subscriber.onNext(tBaseBean.getData());
                                        subscriber.onCompleted();
                                    } catch (Throwable throwable) {
                                        subscriber.onError(throwable);
                                    }
                                }
                            });
                        } else {
                            //返回自定义错误代码和信息,来自服务端
                            return  Observable.error(new ApiException(tBaseBean.getStatus(), tBaseBean.getMessage()));
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }
}

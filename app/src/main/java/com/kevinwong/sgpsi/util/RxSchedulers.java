package com.kevinwong.sgpsi.util;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JiawenHuang on 6/12/17.
 */


public class RxSchedulers {

    public static <T> Observable.Transformer<T, T> newThread_main_scheduler() {
        return new Observable.Transformer<T, T>() {
            @Override

            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> Observable.Transformer<T, T> io_main_scheduler() {
        return new Observable.Transformer<T, T>() {
            @Override

            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    public static <T> Observable.Transformer<T, T> io_io_scheduler() {
        return new Observable.Transformer<T, T>() {
            @Override

            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io());
            }
        };
    }

}

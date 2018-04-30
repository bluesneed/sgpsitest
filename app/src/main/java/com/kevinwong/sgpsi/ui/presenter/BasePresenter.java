package com.huang.huangtest.UI.Presenter;

import android.content.Context;

import com.huang.huangtest.UI.IView.IBaseView;

/**
 * Created by JiawenHuang on 6/12/17.
 */

public abstract class BasePresenter<T extends IBaseView> {


    private T view;

    private Context context;


    public BasePresenter(T view, Context context) {
        this.context = context;
        this.view = view;
        initApiServices();
    }

    public Context getContext() {
        return context;
    }

    public T getView() {
        return view;
    }

    public abstract void initApiServices();

    public abstract void start();

    public abstract void finish();


}


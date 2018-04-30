package com.kevinwong.sgpsi.ui.presenter;

import android.content.Context;

import com.kevinwong.sgpsi.ui.iview.IBaseView;

import java.lang.ref.WeakReference;

/**
 *
 */

public abstract class BasePresenter<T extends IBaseView> {


    private WeakReference<T> view;

    private Context context;


    public BasePresenter(T view, Context context) {
        this.context = context;
        this.view = new WeakReference<>(view);
    }

    public Context getContext() {
        return context;
    }

    public T getView() {
        return view != null ? view.get() : null;
    }

    public abstract void start();

    public abstract void finish();


}


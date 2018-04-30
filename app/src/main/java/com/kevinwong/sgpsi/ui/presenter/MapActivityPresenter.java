package com.kevinwong.sgpsi.ui.presenter;

import android.content.Context;

import com.kevinwong.sgpsi.R;
import com.kevinwong.sgpsi.data.network.PSIService;
import com.kevinwong.sgpsi.model.PSIResponse;
import com.kevinwong.sgpsi.ui.iview.MapActivityView;
import com.kevinwong.sgpsi.util.RxSchedulers;

import rx.Subscriber;
import rx.Subscription;


public class MapActivityPresenter extends BasePresenter<MapActivityView> {

    PSIService psiService;

    Subscription getPSIDatatask;

    public MapActivityPresenter(PSIService psiService, MapActivityView view, Context context) {
        super(view, context);
        this.psiService = psiService;
    }


    @Override
    public void start() {

    }

    @Override
    public void finish() {
        if (getPSIDatatask != null && !getPSIDatatask.isUnsubscribed()) {
            getPSIDatatask.unsubscribe();
        }
    }

    public void getPSIData() {
        if (getPSIDatatask != null && !getPSIDatatask.isUnsubscribed()) {
            getPSIDatatask.unsubscribe();
        }
        getPSIDatatask = psiService.getPSIInfo()
                .compose(RxSchedulers.<PSIResponse>io_main_scheduler())
                .subscribe(new Subscriber<PSIResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onPSIInfoLoadError(getContext().getString(R.string.error_connection));

                    }

                    @Override
                    public void onNext(PSIResponse psiResponse) {
                        if (psiResponse != null && psiResponse.getApiInfo() != null && psiResponse.getApiInfo().getStatus().equalsIgnoreCase("healthy")) {
                            getView().onPSIInfoLoadSuccess(psiResponse);
                        } else {
                            getView().onPSIInfoLoadError(getContext().getString(R.string.error_api_response));
                        }
                    }


                });

    }


}

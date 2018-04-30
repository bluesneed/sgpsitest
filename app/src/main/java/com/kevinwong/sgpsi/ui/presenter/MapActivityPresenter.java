package com.kevinwong.sgpsi.ui.presenter;

import android.content.Context;

import com.kevinwong.sgpsi.data.network.PSIService;
import com.kevinwong.sgpsi.ui.iview.IBaseView;

/**
 * Created by JiawenHuang on 16/4/18.
 */

public class SGPSIPresenter extends BasePresenter {

    PSIService psiService;

    public SGPSIPresenter(IBaseView view, Context context) {
        super(view, context);
    }

    public SGPSIPresenter(PSIService psiService, IBaseView view, Context context) {
        super(view, context);
        this.psiService = psiService;
    }

    @Override
    public void initApiServices() {

    }

    @Override
    public void start() {

    }

    @Override
    public void finish() {

    }

    public void getPSIData(){

//        environmentService = RetrofitClient.create(EnvironmentService.class);
//        environmentService
    }


}

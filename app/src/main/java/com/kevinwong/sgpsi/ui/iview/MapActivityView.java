package com.kevinwong.sgpsi.ui.iview;


import com.kevinwong.sgpsi.model.PSIResponse;

public interface MapActivityView extends IBaseView {
     void onPSIInfoLoadSuccess(PSIResponse psiResponse);
     void onPSIInfoLoadError(String resaon);
}

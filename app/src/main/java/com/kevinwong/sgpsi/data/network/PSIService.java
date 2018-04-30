package com.kevinwong.sgpsi.data.network;

import com.kevinwong.sgpsi.model.PSIResponse;

import retrofit2.http.GET;
import rx.Observable;


public interface PSIService {
    @GET("environment/psi")
    Observable<PSIResponse> getPSIInfo();
}

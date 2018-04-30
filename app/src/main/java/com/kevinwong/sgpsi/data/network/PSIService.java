package com.kevinwong.sgpsi.data.network;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by JiawenHuang on 16/4/18.
 */

public interface EnvironmentService {
    @GET("environment/psi")
    Observable<String> getPSIInfo();
}

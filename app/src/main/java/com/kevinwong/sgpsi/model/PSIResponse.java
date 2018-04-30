package com.kevinwong.sgpsi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by JiawenHuang on 17/4/18.
 */

public class PSIResponse {
    @SerializedName("region_metadata")
    @Expose
    private List<RegionMetadatum> regionMetadata = null;

    @SerializedName("api_info")
    @Expose
    private ApiInfo apiInfo;

    public List<RegionMetadatum> getRegionMetadata() {
        return regionMetadata;
    }

    public void setRegionMetadata(List<RegionMetadatum> regionMetadata) {
        this.regionMetadata = regionMetadata;
    }

    public ApiInfo getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }
}

package com.kevinwong.sgpsi.model;

/**
 * Created by JiawenHuang on 17/4/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionMetadatum {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("label_location")
    @Expose
    private LabelLocation labelLocation;

    private int o3_sub_index;

    private int pm10_twenty_four_hourly;

    private int pm10_sub_index;

    private int co_sub_index;

    private int pm25_twenty_four_hourly;

    private int so2_sub_index;

    private float co_eight_hour_max;

    private int no2_one_hour_max;

    private int so2_twenty_four_hourly;

    private int pm25_sub_index;

    private int psi_twenty_four_hourly;

    private int o3_eight_hour_max;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LabelLocation getLabelLocation() {
        return labelLocation;
    }

    public void setLabelLocation(LabelLocation labelLocation) {
        this.labelLocation = labelLocation;
    }


    public int getO3_sub_index() {
        return o3_sub_index;
    }

    public void setO3_sub_index(int o3_sub_index) {
        this.o3_sub_index = o3_sub_index;
    }

    public int getPm10_twenty_four_hourly() {
        return pm10_twenty_four_hourly;
    }

    public void setPm10_twenty_four_hourly(int pm10_twenty_four_hourly) {
        this.pm10_twenty_four_hourly = pm10_twenty_four_hourly;
    }

    public int getPm10_sub_index() {
        return pm10_sub_index;
    }

    public void setPm10_sub_index(int pm10_sub_index) {
        this.pm10_sub_index = pm10_sub_index;
    }

    public int getCo_sub_index() {
        return co_sub_index;
    }

    public void setCo_sub_index(int co_sub_index) {
        this.co_sub_index = co_sub_index;
    }

    public int getPm25_twenty_four_hourly() {
        return pm25_twenty_four_hourly;
    }

    public void setPm25_twenty_four_hourly(int pm25_twenty_four_hourly) {
        this.pm25_twenty_four_hourly = pm25_twenty_four_hourly;
    }

    public int getSo2_sub_index() {
        return so2_sub_index;
    }

    public void setSo2_sub_index(int so2_sub_index) {
        this.so2_sub_index = so2_sub_index;
    }

    public float getCo_eight_hour_max() {
        return co_eight_hour_max;
    }

    public void setCo_eight_hour_max(float co_eight_hour_max) {
        this.co_eight_hour_max = co_eight_hour_max;
    }

    public int getNo2_one_hour_max() {
        return no2_one_hour_max;
    }

    public void setNo2_one_hour_max(int no2_one_hour_max) {
        this.no2_one_hour_max = no2_one_hour_max;
    }

    public int getSo2_twenty_four_hourly() {
        return so2_twenty_four_hourly;
    }

    public void setSo2_twenty_four_hourly(int so2_twenty_four_hourly) {
        this.so2_twenty_four_hourly = so2_twenty_four_hourly;
    }

    public int getPm25_sub_index() {
        return pm25_sub_index;
    }

    public void setPm25_sub_index(int pm25_sub_index) {
        this.pm25_sub_index = pm25_sub_index;
    }

    public int getPsi_twenty_four_hourly() {
        return psi_twenty_four_hourly;
    }

    public void setPsi_twenty_four_hourly(int psi_twenty_four_hourly) {
        this.psi_twenty_four_hourly = psi_twenty_four_hourly;
    }

    public int getO3_eight_hour_max() {
        return o3_eight_hour_max;
    }

    public void setO3_eight_hour_max(int o3_eight_hour_max) {
        this.o3_eight_hour_max = o3_eight_hour_max;
    }

    @Override
    public String toString() {
        return
                "o3_sub_index = " + o3_sub_index +
                        ",\npm10_twenty_four_hourly = " + pm10_twenty_four_hourly +
                        ",\npm10_sub_index = " + pm10_sub_index +
                        ",\nco_sub_index = " + co_sub_index +
                        ",\npm25_twenty_four_hourly = " + pm25_twenty_four_hourly +
                        ",\nso2_sub_index = " + so2_sub_index +
                        ",\nco_eight_hour_max = " + co_eight_hour_max +
                        ",\nno2_one_hour_max = " + no2_one_hour_max +
                        ",\nso2_twenty_four_hourly = " + so2_twenty_four_hourly +
                        ",\npm25_sub_index = " + pm25_sub_index +
                        ",\npsi_twenty_four_hourly = " + psi_twenty_four_hourly +
                        ",\no3_eight_hour_max = " + o3_eight_hour_max;
    }
}
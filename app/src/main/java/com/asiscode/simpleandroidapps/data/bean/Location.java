package com.asiscode.simpleandroidapps.data.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammad.azis on 21/03/2018.
 */

public class Location {
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("latitude")
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}

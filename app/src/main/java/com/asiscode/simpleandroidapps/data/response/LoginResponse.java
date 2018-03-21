package com.asiscode.simpleandroidapps.data.response;

import com.asiscode.simpleandroidapps.data.bean.Profile;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammad.azis on 21/03/2018.
 */

public class LoginResponse {
    @SerializedName("abstractResponse")
    private AbstractResponse abstractResponse;
    @SerializedName("profile")
    private Profile profile;

    public AbstractResponse getAbstractResponse() {
        return abstractResponse;
    }

    public void setAbstractResponse(AbstractResponse abstractResponse) {
        this.abstractResponse = abstractResponse;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

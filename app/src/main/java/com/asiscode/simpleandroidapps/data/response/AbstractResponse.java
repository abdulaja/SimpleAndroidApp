package com.asiscode.simpleandroidapps.data.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammad.azis on 21/03/2018.
 */

public class AbstractResponse {
    @SerializedName("responseStatus")
    private String responseStatus;
    @SerializedName("responseMessage")
    private String responseMessage;

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}

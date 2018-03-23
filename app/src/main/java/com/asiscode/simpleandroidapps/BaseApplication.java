package com.asiscode.simpleandroidapps;

import android.app.Application;

import com.asiscode.simpleandroidapps.network.APIInstance;
import com.asiscode.simpleandroidapps.network.APIInterface;

/**
 * Created by muhammad.azis on 23/03/2018.
 */

public class BaseApplication extends Application {

    private static BaseApplication currentApplication;

    private APIInstance apiInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        currentApplication = this;

    }

    public BaseApplication() {
        currentApplication = this;
    }

    public static BaseApplication getInstance() {
        if (currentApplication == null) {
            currentApplication = new BaseApplication();
        }
        return currentApplication;
    }

    private APIInstance getApiInstance() {
        if (apiInstance == null) {
            apiInstance = new APIInstance();
        }
        return apiInstance;
    }

    public APIInterface getBaseApi() {
        return getApiInstance().getBaseAPI();
    }
}

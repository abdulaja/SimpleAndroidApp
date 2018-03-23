package com.asiscode.simpleandroidapps.ui;

import android.support.v7.app.AppCompatActivity;

import com.asiscode.simpleandroidapps.BaseApplication;
import com.asiscode.simpleandroidapps.network.APIInterface;

/**
 * Created by muhammad.azis on 23/03/2018.
 */

public class BaseActivity extends AppCompatActivity {

    public APIInterface getBaseApi() {
        return BaseApplication.getInstance().getBaseApi();
    }
}

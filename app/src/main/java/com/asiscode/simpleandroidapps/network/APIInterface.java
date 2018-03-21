package com.asiscode.simpleandroidapps.network;

import com.asiscode.simpleandroidapps.data.request.LoginRequest;
import com.asiscode.simpleandroidapps.data.request.ProductRequest;
import com.asiscode.simpleandroidapps.data.response.LoginResponse;
import com.asiscode.simpleandroidapps.data.response.ProductResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by muhammad.azis on 21/03/2018.
 */

public interface APIInterface {

    @POST("user/login")
    Call<LoginResponse> doLogin(@Body LoginRequest request);

    @POST("product/getByParam")
    Call<ProductResponse> getProducts(@Body ProductRequest request);

}

package com.asiscode.simpleandroidapps.data.response;

import com.asiscode.simpleandroidapps.data.bean.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by muhammad.azis on 21/03/2018.
 */

public class ProductResponse {
    @SerializedName("abstractResponse")
    private AbstractResponse abstractResponse;
    @SerializedName("products")
    private List<Product> products;

    public AbstractResponse getAbstractResponse() {
        return abstractResponse;
    }

    public void setAbstractResponse(AbstractResponse abstractResponse) {
        this.abstractResponse = abstractResponse;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

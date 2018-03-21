package com.asiscode.simpleandroidapps.data.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammad.azis on 21/03/2018.
 */

public class ProductRequest {
    @SerializedName("product_id")
    private Long id;
    @SerializedName("product_name")
    private String name;
    @SerializedName("product_category")
    private String category;
    @SerializedName("product_type")
    private String type;
    @SerializedName("stock")
    private Long stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}

package com.asiscode.simpleandroidapps.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by muhammad.azis on 02/10/2017.
 */

public class Food implements Parcelable {
    private String name;
    private String price;
    private String description;
    private String photo;

    public Food() {

    }

    protected Food(Parcel in) {
        name = in.readString();
        price = in.readString();
        description = in.readString();
        photo = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(price);
        parcel.writeString(description);
        parcel.writeString(photo);
    }
}

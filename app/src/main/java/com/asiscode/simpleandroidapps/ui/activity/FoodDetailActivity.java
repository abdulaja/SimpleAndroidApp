package com.asiscode.simpleandroidapps.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.asiscode.simpleandroidapps.R;
import com.asiscode.simpleandroidapps.data.bean.Food;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class FoodDetailActivity extends AppCompatActivity {
    private ImageView imgPhoto;
    private TextView tv_name;
    private TextView tv_price;
    private TextView tv_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        setTitle("Food Information");

        imgPhoto = findViewById(R.id.img_item_photo);
        tv_name = findViewById(R.id.tv_item_name);
        tv_price = findViewById(R.id.tv_item_price);
        tv_description = findViewById(R.id.tv_item_description);

        Bundle data = getIntent().getExtras();
        Food food = data.getParcelable("food");

        if (food != null) {
            Glide.with(this)
                    .load(food.getPhoto())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgPhoto);
            tv_name.setText(food.getName());
            tv_price.setText("Rp " + food.getPrice());
            tv_description.setText(food.getDescription());
        }
    }
}

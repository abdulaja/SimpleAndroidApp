package com.asiscode.simpleandroidapps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asiscode.simpleandroidapps.R;
import com.asiscode.simpleandroidapps.data.bean.Food;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by muhammad.azis on 02/10/2017.
 */

public class CardViewFoodAdapter extends RecyclerView.Adapter<CardViewFoodAdapter.CardViewHolder> {
    private ArrayList<Food> listFoods;
    private Context context;

    public CardViewFoodAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Food> getListFoods() {

        return listFoods;
    }

    public void setListFoods(ArrayList<Food> listFoods) {
        this.listFoods = listFoods;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_food, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewFoodAdapter.CardViewHolder holder, int position) {
        Food food = getListFoods().get(position);
        Glide.with(context)
                .load(food.getPhoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(550, 550)
                .into(holder.imgPhoto);
        holder.tvName.setText(food.getName());
        holder.tvPrice.setText("Rp " + food.getPrice());
    }

    @Override
    public int getItemCount() {
        return getListFoods().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvPrice;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
        }
    }
}

package com.asiscode.simpleandroidapps.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asiscode.simpleandroidapps.R;
import com.asiscode.simpleandroidapps.data.bean.Product;

import java.util.List;

/**
 * Created by muhammad.azis on 02/10/2017.
 */

public class CardViewProductAdapter extends RecyclerView.Adapter<CardViewProductAdapter.CardViewHolder> {
    private List<Product> products;
    private Context context;

    public CardViewProductAdapter(Context context) {
        this.context = context;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_product, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewProductAdapter.CardViewHolder holder, int position) {
        Product product = getProducts().get(position);
        holder.tvName.setText(product.getName());
        holder.tvCategory.setText(product.getCategory());
    }

    @Override
    public int getItemCount() {
        return getProducts().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCategory;

        public CardViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCategory = itemView.findViewById(R.id.tv_item_category);
        }
    }
}

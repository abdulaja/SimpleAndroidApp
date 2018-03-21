package com.asiscode.simpleandroidapps.ui.menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.asiscode.simpleandroidapps.R;
import com.asiscode.simpleandroidapps.adapter.CardViewFoodAdapter;
import com.asiscode.simpleandroidapps.custom.ItemClickSupport;
import com.asiscode.simpleandroidapps.data.FoodData;
import com.asiscode.simpleandroidapps.data.bean.Food;
import com.asiscode.simpleandroidapps.ui.activity.FoodDetailActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Menu2 extends Fragment {
    private ArrayList<Food> foods;
    private RecyclerView rvCategory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_menu_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Food List");

        rvCategory = getActivity().findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        foods = new ArrayList<>();
        foods.addAll(FoodData.getListData());

        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewFoodAdapter cardViewFoodAdapter = new CardViewFoodAdapter(getActivity());
        cardViewFoodAdapter.setListFoods(foods);
        rvCategory.setAdapter(cardViewFoodAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View view) {
                showSelectedFood(foods.get(position));
                Intent intent = new Intent(getActivity(), FoodDetailActivity.class);
                intent.putExtra("food", foods.get(position));
                startActivity(intent);
            }
        });
    }

    private void showSelectedFood(Food food) {
        Toast.makeText(getActivity(), "Kamu memilih " + food.getName(), Toast.LENGTH_SHORT).show();
    }

}

package com.asiscode.simpleandroidapps.ui.menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.asiscode.simpleandroidapps.R;
import com.asiscode.simpleandroidapps.adapter.CardViewProductAdapter;
import com.asiscode.simpleandroidapps.custom.ItemClickSupport;
import com.asiscode.simpleandroidapps.data.bean.Product;
import com.asiscode.simpleandroidapps.data.request.ProductRequest;
import com.asiscode.simpleandroidapps.data.response.ProductResponse;
import com.asiscode.simpleandroidapps.network.APIInstance;
import com.asiscode.simpleandroidapps.network.APIInterface;
import com.asiscode.simpleandroidapps.ui.activity.ProductFormActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1 extends Fragment {
    private RecyclerView rvCategory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_menu_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Product List");

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(getActivity(), ProductFormActivity.class);
                intent.putExtra("isEdit", false);
                startActivity(intent);
            }
        });

        rvCategory = getActivity().findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        APIInterface api = APIInstance.getRetrofitInstance().create(APIInterface.class);

        //Call<LoginResponse> responseCall = api.doLogin(new LoginRequest("abdul", "password"));
        /*responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.code()==200) {
                    LoginResponse res = response.body();
                    if(res.getAbstractResponse().getResponseStatus().equals("000")) {
                        Toast.makeText(getActivity(), "Data " + res.getProfile().toString(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Data " + res.getAbstractResponse().getResponseMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Server is down", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Please Check Your Connection", Toast.LENGTH_SHORT).show();
            }
        });*/
        Call<ProductResponse> responseCall = api.getProducts(new ProductRequest());
        responseCall.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.code()==200) {
                    ProductResponse res = response.body();
                    if(res.getAbstractResponse().getResponseStatus().equals("000")) {
                        showRecyclerCardView(res.getProducts());
                    } else {
                        Toast.makeText(getActivity(), "Data " + res.getAbstractResponse().getResponseMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Server is down", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Please Check Your Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showRecyclerCardView(final List<Product> products) {
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewProductAdapter cardViewProductAdapter = new CardViewProductAdapter(getActivity());
        cardViewProductAdapter.setProducts(products);
        rvCategory.setAdapter(cardViewProductAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View view) {
                Product product = products.get(position);
                showSelectedItem(product);
                Intent intent = new Intent(getActivity(), ProductFormActivity.class);
                intent.putExtra("isEdit", true);
                intent.putExtra("product", product);
                startActivity(intent);
            }
        });
    }

    private void showSelectedItem(Product product) {
        Toast.makeText(getActivity(), "Kamu memilih " + product.getName(), Toast.LENGTH_SHORT).show();
    }

}

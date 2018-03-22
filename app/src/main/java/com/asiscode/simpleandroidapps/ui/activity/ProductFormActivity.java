package com.asiscode.simpleandroidapps.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.asiscode.simpleandroidapps.R;
import com.asiscode.simpleandroidapps.data.bean.Product;
import com.asiscode.simpleandroidapps.data.response.ProductResponse;
import com.asiscode.simpleandroidapps.network.APIInstance;
import com.asiscode.simpleandroidapps.network.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFormActivity extends AppCompatActivity {
    private TextView tvId;
    private TextView tvName;
    private TextView tvCategory;
    private TextView tvType;
    private TextView tvStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);
        setTitle("Product Form");

        tvId = findViewById(R.id.productIdText);
        tvName = findViewById(R.id.productNameText);
        tvCategory = findViewById(R.id.productCategoryText);
        tvType = findViewById(R.id.productTypeText);
        tvStock = findViewById(R.id.productStockText);

        tvId.setFocusable(false);
        tvId.setClickable(false);

        boolean isEdit = getIntent().getBooleanExtra("isEdit", false);

        if (isEdit) {
            Bundle data = getIntent().getExtras();
            //Product product = data.getParcelable("product");
            Product product = getIntent().getParcelableExtra("product");

            if (product != null) {
                tvId.setText(product.getId().toString());
                tvName.setText(product.getName());
                tvCategory.setText(product.getCategory());
                tvType.setText(product.getType());
                tvStock.setText(product.getStock().toString());
            }
        }

        Button submit = (Button) findViewById(R.id.submit_product_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(view);
            }
        });

    }

    private void save(View view) {
        //reset error
        tvStock.setError(null);

        boolean cancel = false;
        View focusView = null;

        if (tvName.getText().toString().length() < 1) {
            tvName.setError("cannot be empty");
            focusView = tvName;
            cancel = true;
        } else if (tvCategory.getText().toString().length() < 1) {
            tvCategory.setError("cannot be empty");
            focusView = tvCategory;
            cancel = true;
        } else if (tvType.getText().toString().length() < 1) {
            tvType.setError("cannot be empty");
            focusView = tvType;
            cancel = true;
        } else if (tvStock.getText().toString().length() < 1) {
            tvStock.setError("cannot be empty");
            focusView = tvStock;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            APIInterface api = APIInstance.getRetrofitInstance().create(APIInterface.class);

            Product product = new Product();
            product.setId(tvId.getText().toString().length() > 0 ? Integer.parseInt(tvId.getText().toString()) : null);
            product.setName(tvName.getText().toString());
            product.setCategory(tvCategory.getText().toString());
            product.setType(tvType.getText().toString());
            product.setStock(Integer.parseInt(tvStock.getText().toString()));

            Call<ProductResponse> responseCall = null;
            if (product.getId() == null) {
                Snackbar.make(view, "Save " + product.getName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                responseCall = api.saveProduct(product);
            } else {
                Snackbar.make(view, "Update " + product.getName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                responseCall = api.updateProduct(product);
            }

            responseCall.enqueue(new Callback<ProductResponse>() {
                @Override
                public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                    if(response.code()==200) {
                        ProductResponse res = response.body();
                        if(res.getAbstractResponse().getResponseStatus().equals("000")) {
                            setResult(RESULT_OK);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Message : " + res.getAbstractResponse().getResponseMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Server is down", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ProductResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Please Check Your Connection", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}

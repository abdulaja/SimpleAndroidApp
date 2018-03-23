package com.asiscode.simpleandroidapps.ui.menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.asiscode.simpleandroidapps.R;
import com.asiscode.simpleandroidapps.data.bean.Location;
import com.asiscode.simpleandroidapps.data.bean.Profile;
import com.asiscode.simpleandroidapps.data.request.LoginRequest;
import com.asiscode.simpleandroidapps.data.response.LoginResponse;
import com.asiscode.simpleandroidapps.network.APIInstance;
import com.asiscode.simpleandroidapps.network.APIInterface;
import com.asiscode.simpleandroidapps.ui.MainActivity;
import com.asiscode.simpleandroidapps.ui.activity.MapsActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragmnet extends Fragment {
    private TextView tvId;
    private TextView tvName;
    private TextView tvUsername;
    private TextView tvLocation;
    private TextView tvEmail;
    private TextView tvPhone;
    private TextView tvTeam;
    //private TextView tvPhoto;
    private TextView tvLongitude;
    private TextView tvLatitude;

    private ImageView ivMaps;

    private Location location;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Profile");

        tvName = getActivity().findViewById(R.id.name);
        tvUsername = getActivity().findViewById(R.id.username);
        tvLocation = getActivity().findViewById(R.id.location);
        tvEmail = getActivity().findViewById(R.id.email);
        tvPhone = getActivity().findViewById(R.id.phone);
        tvTeam = getActivity().findViewById(R.id.team);

        ivMaps = getActivity().findViewById(R.id.maps);
        ivMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Maps click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });

        getProfile();


    }

    private void getProfile() {
        APIInterface api = APIInstance.getRetrofitInstance().create(APIInterface.class);

        Call<LoginResponse> responseCall = ((MainActivity)getActivity()).getBaseApi().doLogin(new LoginRequest("abdul", "password"));
        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.code()==200) {
                    LoginResponse res = response.body();
                    if(res.getAbstractResponse().getResponseStatus().equals("000")) {
                        //Toast.makeText(getActivity(), "Data " + res.getProfile().toString(), Toast.LENGTH_SHORT).show();
                        showProfile(res.getProfile());
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
        });
    }

    private void showProfile(Profile profile) {
        location = null;
        if (profile != null) {
            location = profile.getLocation();
            if (location != null) {
                tvLocation.setText(location.getLatitude() + "," + location.getLongitude());
            }
            tvName.setText(profile.getName());
            tvEmail.setText(profile.getEmail());
            tvPhone.setText(profile.getPhone());
            tvTeam.setText(profile.getTeam());
        }
    }

}

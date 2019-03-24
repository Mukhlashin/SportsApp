package com.example.sportsapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sportsapp.R;
import com.example.sportsapp.adapter.LaligaAdapter;
import com.example.sportsapp.adapter.PremierAdapter;
import com.example.sportsapp.api.ConfigRetrofit;
import com.example.sportsapp.modellaliga.ResponseLaliga;
import com.example.sportsapp.modellaliga.TeamsItemLaliga;
import com.example.sportsapp.modelpremier.TeamsItemPremier;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaligaFragment extends Fragment {

    RecyclerView rvLaliga;
    LaligaAdapter adapter;
    List<TeamsItemLaliga> data;


    public LaligaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_laliga, container, false);
        rvLaliga = layout.findViewById(R.id.rv_laliga);
        rvLaliga.setAdapter(adapter);
        getDataLaliga();
        return layout;
    }

    public void getDataLaliga() {
        ConfigRetrofit.getInstance2().getDataLaliga().enqueue(new Callback<ResponseLaliga>() {
            @Override
            public void onResponse(Call<ResponseLaliga> call, Response<ResponseLaliga> response) {
                if (response.isSuccessful()) {
                    data = response.body().getTeams();
                    adapter = new LaligaAdapter(getActivity(), data);
                    rvLaliga.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvLaliga.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseLaliga> call, Throwable t) {

            }
        });
    }

}

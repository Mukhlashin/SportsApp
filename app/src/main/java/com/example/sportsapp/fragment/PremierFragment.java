package com.example.sportsapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sportsapp.R;
import com.example.sportsapp.adapter.PremierAdapter;
import com.example.sportsapp.api.ConfigRetrofit;
import com.example.sportsapp.modelpremier.ResponsePremier;
import com.example.sportsapp.modelpremier.TeamsItemPremier;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PremierFragment extends Fragment {

    RecyclerView rvPremier;
    PremierAdapter adapter;
    List<TeamsItemPremier> data;

    public PremierFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_premier, container, false);
        rvPremier = layout.findViewById(R.id.rv_premier);
        rvPremier.setAdapter(adapter);
        getDataPremier();
        return layout;
    }

    private void getDataPremier() {
        ConfigRetrofit.getInstance1().getDataPremier().enqueue(new Callback<ResponsePremier>() {
            @Override
            public void onResponse(Call<ResponsePremier> call, Response<ResponsePremier> response) {
                if (response.isSuccessful()) {
                    data = response.body().getTeams();
                    adapter = new PremierAdapter(getActivity(), data);
                    rvPremier.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvPremier.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponsePremier> call, Throwable t) {

            }
        });
    }

}

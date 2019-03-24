package com.example.sportsapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sportsapp.R;
import com.example.sportsapp.adapter.BundesAdapter;
import com.example.sportsapp.adapter.LaligaAdapter;
import com.example.sportsapp.api.ConfigRetrofit;
import com.example.sportsapp.modelbundesliga.ResponseBundes;
import com.example.sportsapp.modelbundesliga.TeamsItemBundes;
import com.example.sportsapp.modellaliga.TeamsItemLaliga;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BundesFragment extends Fragment {

    RecyclerView rvBundes;
    BundesAdapter adapter;
    List<TeamsItemBundes> data;


    public BundesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_bundes, container, false);
        rvBundes = layout.findViewById(R.id.rv_laliga);
        rvBundes.setAdapter(adapter);
        getDataBundes();
        return layout;
    }

    public void getDataBundes(){
        ConfigRetrofit.getInstance3().getDataBundes().enqueue(new Callback<ResponseBundes>() {
            @Override
            public void onResponse(Call<ResponseBundes> call, Response<ResponseBundes> response) {
                if (response.isSuccessful()) {
                    data = response.body().getTeams();
                    adapter = new BundesAdapter(getActivity(), data);
                    rvBundes.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvBundes.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseBundes> call, Throwable t) {

            }
        });
    }
}

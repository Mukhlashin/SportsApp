package com.example.sportsapp.api;

import com.example.sportsapp.modelbundesliga.ResponseBundes;
import com.example.sportsapp.modellaliga.ResponseLaliga;
import com.example.sportsapp.modelpremier.ResponsePremier;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface APIService {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<ResponsePremier> getDataPremier();

    @GET("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=Spanish%20La%20Liga")
    Call<ResponseLaliga> getDataLaliga();

    @GET("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=German%20Bundesliga")
    Call<ResponseBundes> getDataBundes();
}

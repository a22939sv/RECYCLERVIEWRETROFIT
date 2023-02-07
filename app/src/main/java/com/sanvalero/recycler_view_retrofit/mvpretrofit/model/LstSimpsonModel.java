package com.sanvalero.recycler_view_retrofit.mvpretrofit.model;

import com.sanvalero.recycler_view_retrofit.mvpretrofit.LstSimpsonContract;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.entities.Simpson;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.utils.ApiClient;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.utils.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstSimpsonModel implements LstSimpsonContract.Model {
    @Override
    public void lstSimpsonWS(Simpson simpson, OnLstSimpsonListener onLstSimpsonListener) {
        // If it is success
        //onLstSimpsonListener.onSuccess(null);
        // If it is failure
        //onLstSimpsonListener.onFailure("Error!!!");
        getSimpsonService(onLstSimpsonListener);
    }

    public void getSimpsonService(final OnLstSimpsonListener onLstSimpsonListener) {
        /*Ejecuto Webservice con retrofit*/
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Simpson>> call = apiService.getPopularSimpson(5);
        call.enqueue(new Callback<ArrayList<Simpson>>() {
            @Override
            public void onResponse(Call<ArrayList<Simpson>> call, Response<ArrayList<Simpson>> response) {
                ArrayList<Simpson> lstSimpson = response.body();

                onLstSimpsonListener.onSuccess(lstSimpson);
            }

            @Override
            public void onFailure(Call<ArrayList<Simpson>> call, Throwable t) {
                onLstSimpsonListener.onFailure(t.getMessage());
            }
        });
    }
}

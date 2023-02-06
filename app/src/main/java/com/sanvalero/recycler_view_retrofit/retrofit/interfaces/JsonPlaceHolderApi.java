package com.sanvalero.recycler_view_retrofit.retrofit.interfaces;

import com.sanvalero.recycler_view_retrofit.retrofit.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Posts>> getPosts();
}

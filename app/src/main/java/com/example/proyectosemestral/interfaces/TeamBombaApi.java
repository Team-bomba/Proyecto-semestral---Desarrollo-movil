package com.example.proyectosemestral.interfaces;

import com.example.proyectosemestral.models.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeamBombaApi {

    @GET("animes/tendencias")
    Call<List<Anime>> getAnimesTendencias();

    @GET("animes/search/{query}")
    Call<List<Anime>> getAnimesSearch(@Path("query") String query);

    @GET("animes")
    Call<List<Anime>> getAnimes();
}

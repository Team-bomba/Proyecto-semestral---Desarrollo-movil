package com.example.proyectosemestral.presenters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.adapters.AnimeListAdapter;
import com.example.proyectosemestral.interfaces.TeamBombaApi;
import com.example.proyectosemestral.models.Anime;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public abstract class BasePresenter extends AppCompatActivity  {
    protected String Base_url = "https://team-bomba-api.herokuapp.com/api/v1/";
    protected List<Anime> animeLists;
    public AnimeListAdapter AnimeAdapter;
    public Context context = this;

    protected ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void getAnimeTendencias(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<List<Anime>> call = teamBombaApi.getAnimesTendencias();

        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                if(!response.isSuccessful()){

                }
                animeLists = response.body();
                AnimeAdapter = new AnimeListAdapter(context, animeLists);
                lvItems.setAdapter(AnimeAdapter);
            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {

            }
        });
    }
}

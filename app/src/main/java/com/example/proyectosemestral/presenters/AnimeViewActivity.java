package com.example.proyectosemestral.presenters;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.adapters.CommentListAdapter;
import com.example.proyectosemestral.interfaces.TeamBombaApi;
import com.example.proyectosemestral.models.Anime;
import com.example.proyectosemestral.models.Comment;
import com.example.proyectosemestral.models.Post;
import com.example.proyectosemestral.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeViewActivity extends BasePresenter {
    protected List<Comment> commentLists;
    protected CommentListAdapter commentListAdapter;
    protected Anime anime;
    protected User autor;

    protected TextView anime_description;

    protected ListView lvcomments;
    protected TextView anime_title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripcion);
        lvcomments = findViewById(R.id.lvComments);


        getAnime(set_anime());
        SetCurrentUserIfexist();
        footer();
    }

    private int set_anime(){
        return Integer.parseInt(getIntent().getStringExtra("anime_id"));
    }



    protected void getAnime(int anime_id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<Anime> call = teamBombaApi.getAnime(anime_id);

        call.enqueue(new Callback<Anime>() {
            @Override
            public void onResponse(Call<Anime> call, Response<Anime> response) {
                if(!response.isSuccessful()){
                    return;
                }
                Log.e("Errorr", response.toString());
                anime = response.body();
                anime_description = findViewById(R.id.Description);
                anime_description.setText(anime.getDescription());
                anime_title = findViewById(R.id.TituloDescription);
                anime_title.setText(anime.getName());

                getAnimeComment(anime.getId());
                Log.e("Errorr", response.toString());

            }

            @Override
            public void onFailure(Call<Anime> call, Throwable t) {
            }
        });
    }

    protected void getAnimeComment(int anime_id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<List<Comment>> call = teamBombaApi.getAnimeComments(anime_id);

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                Log.e("Errorr", response.toString());
                commentLists = response.body();
                commentListAdapter = new CommentListAdapter(context, commentLists);
                lvcomments.setAdapter(commentListAdapter);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }
}
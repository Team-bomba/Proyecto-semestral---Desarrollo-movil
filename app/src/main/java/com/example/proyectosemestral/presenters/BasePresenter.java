package com.example.proyectosemestral.presenters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.adapters.AnimeListAdapter;
import com.example.proyectosemestral.adapters.PostListAdapter;
import com.example.proyectosemestral.interfaces.TeamBombaApi;
import com.example.proyectosemestral.models.Anime;
import com.example.proyectosemestral.models.Comment;
import com.example.proyectosemestral.models.Post;
import com.example.proyectosemestral.models.User;

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
    protected List<Post> postLists;
    protected User current_user;

    public PostListAdapter PostAdapter;
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
    protected void getAnimes(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<List<Anime>> call = teamBombaApi.getAnimes();

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

    protected void getPosts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<List<Post>> call = teamBombaApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){

                }
                postLists = response.body();
                PostAdapter = new PostListAdapter(context, postLists);
                lvItems.setAdapter(PostAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    protected void getCurrentUser(int user_id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<User> call = teamBombaApi.getUser(user_id);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    return;
                }
                current_user = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    protected void SetCurrentUserIfexist(){
        if(user_signed_in() > 0){
            getCurrentUser(user_signed_in());
        }
    }

    protected int user_signed_in(){
        int current_user_id = User.current_user(context);
        if(current_user_id > 0){
            return current_user_id;
        }
        return 0;
    }

}

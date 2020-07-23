package com.example.proyectosemestral.presenters;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.adapters.CommentListAdapter;
import com.example.proyectosemestral.adapters.PostListAdapter;
import com.example.proyectosemestral.interfaces.TeamBombaApi;
import com.example.proyectosemestral.models.Comment;
import com.example.proyectosemestral.models.Post;
import com.example.proyectosemestral.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostViewActivity extends BasePresenter {
    protected List<Comment> commentLists;
    protected CommentListAdapter commentListAdapter;
    protected Post post;
    protected User autor;

    protected ListView lvcomments;
    protected TextView UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.community);

        lvcomments= findViewById(R.id.lvComments);
        getPost(1);
        getAutor(post.getUser_id());
        getPostComment();
    }

    protected void getAutor(int user_id){
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
                autor = response.body();
                UserName = findViewById(R.id.UserName);
                UserName.setText(autor.getName());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    protected void getPost(int post_id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<Post> call = teamBombaApi.getPost(post_id);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    return;
                }
                post = response.body();


                lvItems.setAdapter(PostAdapter);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    protected void getPostComment(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<List<Comment>> call = teamBombaApi.getPostComments(post.getId());

        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()){
                    return;
                }
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
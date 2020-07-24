package com.example.proyectosemestral.presenters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.adapters.CommentListAdapter;
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

public class PerfilViewActivity extends BasePresenter {

    protected TextView userName;
    protected TextView email;
    protected Button log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);
        current_user_set();

        log_out = findViewById(R.id.CerrarSesion);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, MainActivity.class);
                startActivity(i);
            }
        });

    }


    protected void getUser(int user_id){
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
                showCurrentUser();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    protected void current_user_set(){
        if(user_signed_in() > 0){
            getUser(user_signed_in());
        }
    }


    protected void showCurrentUser(){
        userName = findViewById(R.id.UserName);
        email = findViewById(R.id.Email);
        email.setText(current_user.getEmail());
        userName.setText(current_user.getName());
    }

}
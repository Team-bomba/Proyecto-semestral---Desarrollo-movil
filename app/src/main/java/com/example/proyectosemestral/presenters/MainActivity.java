package com.example.proyectosemestral.presenters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.adapters.AnimeListAdapter;
import com.example.proyectosemestral.interfaces.TeamBombaApi;
import com.example.proyectosemestral.models.Anime;
import com.example.proyectosemestral.models.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BasePresenter {
    EditText Form_user;
    EditText Form_pass;
    Button Form_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User.destroy_current_user(context);

        inicializar_controles();

        Form_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String USR = Form_user.getText().toString();
                String PASS = Form_pass.getText().toString();

                verifyUser(USR,PASS);

            }
        });
    }

    protected void verifyUser(String email, String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamBombaApi teamBombaApi = retrofit.create(TeamBombaApi.class);

        Call<User> call = teamBombaApi.verifyUser(email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    return;
                }
                current_user = response.body();
                current_user.save_current_user(context);
                Intent i = new Intent(context, PostsActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void inicializar_controles(){
        Form_user = (EditText) findViewById(R.id.Usuario);
        Form_pass = (EditText) findViewById(R.id.Contraseña);
        Form_submit = (Button) findViewById(R.id.FormLogin);
    }
}
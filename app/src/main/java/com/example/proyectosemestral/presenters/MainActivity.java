package com.example.proyectosemestral.presenters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.adapters.AnimeListAdapter;
import com.example.proyectosemestral.models.Anime;

import java.io.IOException;

public class MainActivity extends BasePresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
package com.example.proyectosemestral.presenters;


import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.proyectosemestral.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BasePresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        lvItems = findViewById(R.id.lvItems);

        SetCurrentUserIfexist();
        footer();
        Perfil();
        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.stone));
        slideModels.add(new SlideModel(R.drawable.kitmesu));
        slideModels.add(new SlideModel(R.drawable.naruto));
        slideModels.add(new SlideModel(R.drawable.neverland));
        slideModels.add(new SlideModel(R.drawable.japon));


        imageSlider.setImageList(slideModels, true);


    }
}
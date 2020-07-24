package com.example.proyectosemestral.adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectosemestral.R;
import com.example.proyectosemestral.models.Anime;
import com.example.proyectosemestral.presenters.AnimeViewActivity;
import com.example.proyectosemestral.presenters.PostViewActivity;

import java.util.List;
public class AnimeListAdapter extends BaseAdapter {
    private Context context;
    private List<Anime> listItems;


    public AnimeListAdapter(Context context, List<Anime> listItems){
        this.context = context;
        this.listItems= listItems;
    }
    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Anime anime = (Anime) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.lista_anime_template,null);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imagen);
        TextView  Titulo = (TextView) convertView.findViewById(R.id.name);
        TextView  Description = (TextView) convertView.findViewById(R.id.description);
        //Button BtnGoShow = (Button)  convertView.findViewById(R.id.btn_goShow);
        //TextView Favorito = (TextView) convertView.findViewById(R.id.tvFav);
        imgFoto.setImageResource(R.mipmap.ic_launcher);
        Titulo.setText(anime.getName());
        Description.setText(anime.getDescription());
        TextView View_more = (TextView) convertView.findViewById(R.id.view_more);
        View_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anime_id = Integer.toString(anime.getId());
                Intent i=new Intent(context, AnimeViewActivity.class);
                i.putExtra("anime_id", anime_id);
                context.startActivity(i);

            }
        });
        return convertView;
    }

}

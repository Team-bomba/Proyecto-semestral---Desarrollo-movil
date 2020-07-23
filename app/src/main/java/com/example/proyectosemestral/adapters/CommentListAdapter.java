package com.example.proyectosemestral.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectosemestral.R;
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

public class CommentListAdapter extends BaseAdapter {
    private Context context;
    private List<Comment> listItems;
    private User user;

    public CommentListAdapter(Context context, List<Comment> listItems){
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
        final Comment comment = (Comment) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.list_comment_template,null);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imagen);
        TextView  Titulo = (TextView) convertView.findViewById(R.id.name);
        TextView  Description = (TextView) convertView.findViewById(R.id.description);
        //Button BtnGoShow = (Button)  convertView.findViewById(R.id.btn_goShow);
        //TextView Favorito = (TextView) convertView.findViewById(R.id.tvFav);
        //imgFoto.setImageResource(receta.imgFoto);
        Titulo.setText(comment.getUsername());
        Description.setText(comment.getBody());

       /* BtnGoShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String receta_id = Integer.toString(receta.id);
                Intent i=new Intent(context, RecetaShowActivity.class);
                i.putExtra("receta_id", receta_id);
                context.startActivity(i);
            }
        });
        */
        return convertView;
    }
}

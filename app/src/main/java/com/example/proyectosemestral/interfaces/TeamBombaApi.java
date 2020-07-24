package com.example.proyectosemestral.interfaces;

import com.example.proyectosemestral.models.Anime;
import com.example.proyectosemestral.models.Comment;
import com.example.proyectosemestral.models.Post;
import com.example.proyectosemestral.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TeamBombaApi {

    @GET("animes/tendencias")
    Call<List<Anime>> getAnimesTendencias();

    @GET("animes/search/{query}")
    Call<List<Anime>> getAnimesSearch(@Path("query") String query);

    @GET("animes")
    Call<List<Anime>> getAnimes();

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int query);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getPostComments(@Path("id") int query);

    @GET("users/{id}")
    Call<User> getUser(@Path("id") int query);

    @GET("/users/verify?")
    Call<User> verifyUser(@Query("user[name]") String name,
                                     @Query("user[password]") String password);
}

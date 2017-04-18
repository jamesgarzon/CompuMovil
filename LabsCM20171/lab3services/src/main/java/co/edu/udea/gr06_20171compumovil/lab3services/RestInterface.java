package co.edu.udea.gr06_20171compumovil.lab3services;

import java.util.List;

import co.edu.udea.gr06_20171compumovil.lab3services.Pojos.Event;
import co.edu.udea.gr06_20171compumovil.lab3services.Pojos.User;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by james on 4/15/17.
 */

public interface RestInterface {

    @GET("/users")
    void getUser( Callback<User[]> cb);


    @FormUrlEncoded
    @POST("/")
    Callback<User> request(@Field("username") String username, @Field("email") String email, @Field("password") String password);

    @GET("/events")
    void getEvents( Callback<List<Event>> cb);
}



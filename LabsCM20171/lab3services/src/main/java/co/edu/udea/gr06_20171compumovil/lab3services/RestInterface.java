package co.edu.udea.gr06_20171compumovil.lab3services;

import co.edu.udea.gr06_20171compumovil.lab3services.Pojos.User;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by james on 4/15/17.
 */

public interface RestInterface {

    @GET("/users")
    void getUser( Callback<User[]> cb);
}


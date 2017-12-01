package com.example.admin.wsretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Admin on 30/11/2017.
 */

public class Server {

    private static final String url = "https://contatinho.herokuapp.com/";

    private static Retrofit retrofit;


    public static Retrofit getClient(){

        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;

    }

}

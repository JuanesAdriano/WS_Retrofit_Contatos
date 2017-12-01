package com.example.admin.wsretrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Admin on 30/11/2017.
 */

public interface IContatinho {

    @POST("contatinhos/")
    Call<Contatinho> inserir(@Field("nome")String nome, @Field("telefone")String telefone, @Field("info")String info);

    @GET("contatinhos/")
    Call<ArrayList<Contatinho>> listaTodos();

    @GET("contatinhos/{id}")
    Call<Contatinho> listaById(@Path("id")int id);

    @DELETE("contatinos/{id}")
    Call<Contatinho> delete(@Path("id")int id);

    @PUT("contatinhos/")
    Call<Contatinho> alterar(@Field("nome")String nome, @Field("telefone")String telefone, @Field("info")String info, @Field("id")String id);

}

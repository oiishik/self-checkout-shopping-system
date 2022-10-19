package com.example.shopeasy;

import androidx.annotation.NonNull;

import com.example.shopeasy.userpage.UserPageService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit getRetrofit() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.131.205:8080/")
                .client(okHttpClient)
                .build();
    }

    public static UserService getUserService() {

        return getRetrofit().create(UserService.class);

    }

    public static UserPageService getUserPageService(){
        return getRetrofit().create(UserPageService.class);
    }
}

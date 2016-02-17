package com.mlsdev.serhii.frescotestapp.data.net;

import com.mlsdev.serhii.frescotestapp.data.model.Data;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


/**
 * Created by serhii on 17.02.16.
 */
public class ApiServiceImpl implements ApiService {
    private OkHttpClient mOkHttpClient;
    private Api mApi;

    public ApiServiceImpl() {
        mOkHttpClient = new OkHttpClient();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient.interceptors().add(logging);

        mApi = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
    }

    @Override
    public Call<Data> searchImages() {
        return mApi.searchImages();
    }
}

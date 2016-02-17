package com.mlsdev.serhii.frescotestapp.data.net;

import android.database.Cursor;

import com.mlsdev.serhii.frescotestapp.data.model.Data;

import retrofit2.Call;


/**
 * Created by serhii on 17.02.16.
 */
public interface ApiService {
    Call<Data> searchImages();
}

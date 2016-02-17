package com.mlsdev.serhii.frescotestapp.data.net;

import com.mlsdev.serhii.frescotestapp.data.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by serhii on 17.02.16.
 */
public interface Api {
    String BASE_URL = "https://www.googleapis.com/";
    String SEARCH_URL = "customsearch/v1?key=AIzaSyCDn1njjgNF5AnqKPHORSQzd_gkqca42iI&" +
            "fields=items(pagemap/cse_image(src))&cx=013036536707430787589:_pqjad5hr1a&imgsize=huge&q=london";

    @GET(SEARCH_URL)
    Call<Data> searchImages();
}

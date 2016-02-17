package com.mlsdev.serhii.frescotestapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.mlsdev.serhii.frescotestapp.R;
import com.mlsdev.serhii.frescotestapp.data.model.Data;
import com.mlsdev.serhii.frescotestapp.data.net.ApiService;
import com.mlsdev.serhii.frescotestapp.data.net.ApiServiceImpl;
import com.mlsdev.serhii.frescotestapp.databinding.ActivityImagesBinding;
import com.mlsdev.serhii.frescotestapp.view.adapter.ImagesAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagesActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE_LOADER_TYPE = "image_loader_type";
    public static final int FRESCO_IMAGE_LOADER_TYPE = 0;
    public static final int GLIDE_IMAGE_LOADER_TYPE = 1;
    private ActivityImagesBinding mBinding;
    private ImagesAdapter mImagesAdapter;
    private ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = new ApiServiceImpl();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        int imageLoaderType = getIntent().getIntExtra(EXTRA_IMAGE_LOADER_TYPE, FRESCO_IMAGE_LOADER_TYPE);
        setTitle(getString(imageLoaderType == FRESCO_IMAGE_LOADER_TYPE
                ? R.string.images_activity_title_fresco
                : R.string.images_activity_title_glide));
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_images);
        mImagesAdapter = new ImagesAdapter(this, imageLoaderType);
        mBinding.rvImages.setAdapter(mImagesAdapter);
        mBinding.rvImages.setHasFixedSize(true);
        mBinding.rvImages.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mApiService.searchImages().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                mImagesAdapter.setData(response.body());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(ImagesActivity.this, "Error happened", Toast.LENGTH_SHORT);
            }
        });
    }
}
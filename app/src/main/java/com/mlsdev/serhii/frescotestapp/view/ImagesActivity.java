package com.mlsdev.serhii.frescotestapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.mlsdev.serhii.frescotestapp.R;
import com.mlsdev.serhii.frescotestapp.databinding.ActivityImagesBinding;
import com.mlsdev.serhii.frescotestapp.view.adapter.ImagesAdapter;

public class ImagesActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE_LOADER_TYPE = "image_loader_type";
    public static final int FRESCO_IMAGE_LOADER_TYPE = 0;
    public static final int GLIDE_IMAGE_LOADER_TYPE = 1;
    private ActivityImagesBinding mBinding;
    private ImagesAdapter mImagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        int imageLoaderType = getIntent().getIntExtra(EXTRA_IMAGE_LOADER_TYPE, FRESCO_IMAGE_LOADER_TYPE);
        setTitle(getString(imageLoaderType == FRESCO_IMAGE_LOADER_TYPE
                ? R.string.images_activity_title_fresco
                : R.string.images_activity_title_glide));
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_images);
        mImagesAdapter = new ImagesAdapter(this);
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
}
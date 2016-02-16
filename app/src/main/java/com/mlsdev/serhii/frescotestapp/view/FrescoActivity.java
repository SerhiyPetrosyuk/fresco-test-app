package com.mlsdev.serhii.frescotestapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mlsdev.serhii.frescotestapp.R;
import com.mlsdev.serhii.frescotestapp.databinding.ActivityImagesBinding;
import com.mlsdev.serhii.frescotestapp.view.adapter.ImagesAdapter;

public class FrescoActivity extends AppCompatActivity {
    private ActivityImagesBinding mBinding;
    private ImagesAdapter mImagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_images);
        mImagesAdapter = new ImagesAdapter(this);
        mBinding.rvImages.setAdapter(mImagesAdapter);
        mBinding.rvImages.setHasFixedSize(true);
        mBinding.rvImages.setLayoutManager(new LinearLayoutManager(this));
    }
}
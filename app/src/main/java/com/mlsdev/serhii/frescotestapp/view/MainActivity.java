package com.mlsdev.serhii.frescotestapp.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mlsdev.serhii.frescotestapp.R;
import com.mlsdev.serhii.frescotestapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(new ViewModel());
    }

    private void startImagesActivity(int imageLoaderType) {
        Intent startImagesActivityIntent = new Intent(this, ImagesActivity.class);
        startImagesActivityIntent.putExtra(ImagesActivity.EXTRA_IMAGE_LOADER_TYPE, imageLoaderType);
        startActivity(startImagesActivityIntent);
    }

    public class ViewModel {

        public void onFrescoBtnClicked(View view) {
            Log.i("FRESCO", "fresco btn was pressed");
            startImagesActivity(ImagesActivity.FRESCO_IMAGE_LOADER_TYPE);
        }

        public void onGlideBtnClicked(View view) {
            Log.i("FRESCO", "glide btn was pressed");
            startImagesActivity(ImagesActivity.GLIDE_IMAGE_LOADER_TYPE);
        }

        public void onPicassoBtnClicked(View view) {
            Log.i("FRESCO", "picasso btn was pressed");
            startImagesActivity(ImagesActivity.PICASSO_IMAGE_LOADER_TYPE);
        }
    }
}

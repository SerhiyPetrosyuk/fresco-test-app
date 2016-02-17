package com.mlsdev.serhii.frescotestapp.binding.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mlsdev.serhii.frescotestapp.view.ImagesActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by serhii on 16.02.16.
 */
public class ImageDataBindingAdapter {

    @BindingAdapter({"bind:loaderType", "bind:imageUrl", "bind:imageError"})
    public static void glideOrPicassoImageLoader(final ImageView imageView, int loaderType, String imageUrl, Drawable imageErrorDrawable) {
        if (loaderType == ImagesActivity.GLIDE_IMAGE_LOADER_TYPE) {
            Glide.with(imageView.getContext())
                    .load(imageUrl)
                    .error(imageErrorDrawable)
                    .centerCrop()
                    .crossFade()
                    .into(imageView);
        } else if (loaderType == ImagesActivity.PICASSO_IMAGE_LOADER_TYPE) {
            Picasso.with(imageView.getContext())
                    .load(imageUrl)
                    .error(imageErrorDrawable)
                    .resize(300, 150)
                    .centerCrop()
                    .into(imageView);
        }
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void frescoImageLoader(final SimpleDraweeView draweeView, String imageUrl) {
        Uri imageUri = Uri.parse(imageUrl);
        draweeView.setImageURI(imageUri);
    }


}

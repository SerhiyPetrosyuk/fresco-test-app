package com.mlsdev.serhii.frescotestapp.binding.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mlsdev.serhii.frescotestapp.view.ImagesActivity;

/**
 * Created by serhii on 16.02.16.
 */
public class ImageDataBindingAdapter {

    @BindingAdapter({"bind:imageUrl", "bind:imageError"})
    public static void glideImageLoader(final ImageView imageView, String imageUrl, Drawable imageErrorDrawable) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .error(imageErrorDrawable)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void frescoImageLoader(final SimpleDraweeView draweeView, String imageUrl) {
        Uri imageUri = Uri.parse(imageUrl);
        draweeView.setImageURI(imageUri);
    }


}

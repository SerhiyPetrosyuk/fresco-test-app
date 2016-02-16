package com.mlsdev.serhii.frescotestapp.binding.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by serhii on 16.02.16.
 */
public class ImageDataBindingAdapter {

    @BindingAdapter({"bind:imageUrl", "bind:imageError"})
    public static void loadImage(final ImageView imageView, String imageUrl, Drawable imageErrorDrawable) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .error(imageErrorDrawable)
                .centerCrop()
                .into(imageView);
    }

}

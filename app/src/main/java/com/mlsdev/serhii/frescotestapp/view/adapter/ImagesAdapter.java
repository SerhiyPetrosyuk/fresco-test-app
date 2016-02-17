package com.mlsdev.serhii.frescotestapp.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mlsdev.serhii.frescotestapp.R;
import com.mlsdev.serhii.frescotestapp.data.model.Data;
import com.mlsdev.serhii.frescotestapp.data.model.Image;
import com.mlsdev.serhii.frescotestapp.databinding.FrescoImageItemBinding;
import com.mlsdev.serhii.frescotestapp.databinding.GlideImageItemBinding;
import com.mlsdev.serhii.frescotestapp.view.ImagesActivity;

/**
 * Created by serhii on 16.02.16.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
    private Context mContext;
    private int mLayoutType;
    private Data mData;

    public ImagesAdapter(Context context, int layoutType) {
        mContext = context;
        mLayoutType = layoutType;
        mData = new Data();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutResId = mLayoutType == ImagesActivity.FRESCO_IMAGE_LOADER_TYPE
                ? R.layout.fresco_image_item
                : R.layout.glide_image_item;
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mData.getItems().get(position).getPagemap().getImage().size() == 0)
            return;

        Image image = mData.getItems().get(position).getPagemap().getImage().get(0);
        if (mLayoutType == ImagesActivity.FRESCO_IMAGE_LOADER_TYPE)
            holder.frescoImageItemBinding.setImage(image);
        else
            holder.glideImageItemBinding.setImage(image);
    }

    @Override
    public int getItemCount() {
        return mData.getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FrescoImageItemBinding frescoImageItemBinding;
        GlideImageItemBinding glideImageItemBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            initBinding(itemView);
        }

        private void initBinding(View view) {
            if (mLayoutType == ImagesActivity.FRESCO_IMAGE_LOADER_TYPE)
                frescoImageItemBinding = DataBindingUtil.bind(view);
            else
                glideImageItemBinding = DataBindingUtil.bind(view);
        }
    }

    public void setData(Data data) {
        mData = data;
        notifyDataSetChanged();
    }

}

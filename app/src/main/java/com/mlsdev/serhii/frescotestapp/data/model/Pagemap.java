package com.mlsdev.serhii.frescotestapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 17.02.16.
 */
public class Pagemap {

    @SerializedName("cse_image")
    @Expose
    private List<Image> image = new ArrayList<>();

    /**
     * @return The image
     */
    public List<Image> getImage() {
        return image;
    }

    /**
     * @param image The cse_image
     */
    public void setImage(List<Image> image) {
        this.image = image;
    }

}

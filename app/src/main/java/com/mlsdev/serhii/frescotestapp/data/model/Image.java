package com.mlsdev.serhii.frescotestapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by serhii on 17.02.16.
 */
public class Image {

    @SerializedName("src")
    @Expose
    private String src;

    /**
     * @return The src
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src The src
     */
    public void setSrc(String src) {
        this.src = src;
    }

}

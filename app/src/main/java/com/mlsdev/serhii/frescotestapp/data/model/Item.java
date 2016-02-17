package com.mlsdev.serhii.frescotestapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by serhii on 17.02.16.
 */
public class Item {

    @SerializedName("pagemap")
    @Expose
    private Pagemap pagemap;

    /**
     * @return The pagemap
     */
    public Pagemap getPagemap() {
        return pagemap;
    }

    /**
     * @param pagemap The pagemap
     */
    public void setPagemap(Pagemap pagemap) {
        this.pagemap = pagemap;
    }

}

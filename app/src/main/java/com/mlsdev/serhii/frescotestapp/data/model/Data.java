package com.mlsdev.serhii.frescotestapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 17.02.16.
 */
public class Data {

    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<>();

    public Data() {
        items = new ArrayList<>();
    }

    /**
     * @return The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

}

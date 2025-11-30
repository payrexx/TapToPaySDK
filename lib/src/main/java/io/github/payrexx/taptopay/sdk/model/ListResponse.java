package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse implements Response {
    public List<Transaction> items = null;

    @SerializedName("total_pages")
    public Integer totalPages = null;
    @SerializedName("total_items")
    public Integer totalItems = null;

    public static ListResponse getInstance(List<Transaction> items) {
        ListResponse listResponse = new ListResponse();
        listResponse.items = items;
        listResponse.totalPages = 1;
        listResponse.totalItems = items.size();
        return listResponse;
    }
}

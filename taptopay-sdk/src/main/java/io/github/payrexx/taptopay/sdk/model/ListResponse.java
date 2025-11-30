package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents a response that contains a list of items.
 */
public class ListResponse implements Response {
    /**
     * The list of transactions.
     */
    public List<Transaction> items = null;

    /**
     * The total number of pages.
     */
    @SerializedName("total_pages")
    public Integer totalPages = null;
    /**
     * The total number of items.
     */
    @SerializedName("total_items")
    public Integer totalItems = null;

    /**
     * Creates a new ListResponse instance.
     *
     * @param items The list of transactions.
     * @return A new ListResponse instance.
     */
    public static ListResponse getInstance(List<Transaction> items) {
        ListResponse listResponse = new ListResponse();
        listResponse.items = items;
        listResponse.totalPages = 1;
        listResponse.totalItems = items.size();
        return listResponse;
    }
}

package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a response that contains a single transaction.
 */
public class SingleResponse implements Response {
    /**
     * The transaction.
     */
    public Transaction transaction = null;

    /**
     * Extra data associated with the response.
     */
    public Extras extras = null;
    /**
     * A message associated with the response.
     */
    @SerializedName(value = "message", alternate = {"errorMsg"})
    public String message = null;

    /**
     * Creates a new SingleResponse instance.
     *
     * @param transaction The transaction.
     * @return A new SingleResponse instance.
     */
    public static SingleResponse getInstance(Transaction transaction) {
        Extras extras = new Extras();
        if (transaction.orderReference == null) {
            transaction.orderReference = "";
        }
        extras.orderReference = transaction.orderReference;
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.extras = extras;
        singleResponse.transaction = transaction;
        return singleResponse;
    }
}

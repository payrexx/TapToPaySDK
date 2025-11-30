package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;

public class SingleResponse implements Response {
    public Transaction transaction = null;

    public Extras extras = null;
    @SerializedName(value = "message", alternate = {"errorMsg"})
    public String message = null;

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

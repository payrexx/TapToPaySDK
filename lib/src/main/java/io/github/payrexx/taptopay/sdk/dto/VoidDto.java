package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

public class VoidDto implements Dto {
    @SerializedName("transaction_id")
    public String transactionId;
    public String extras = "";

    public VoidDto(String transactionId) {
        this.transactionId = transactionId;
    }

    public VoidDto(String transactionId, String extras) {
        this.transactionId = transactionId;
        this.extras = extras;
    }
}

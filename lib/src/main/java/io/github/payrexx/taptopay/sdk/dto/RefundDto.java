package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

public class RefundDto implements Dto {
    @SerializedName("transaction_id")
    public String transactionId;
    public String amount;
    public String extras = "";

    public RefundDto(String transactionId, float amount) {
        this.transactionId = transactionId;
        this.amount = String.valueOf(amount);
    }

    public RefundDto(String transactionId, float amount, String extras) {
        this.transactionId = transactionId;
        this.amount = String.valueOf(amount);
        this.extras = extras;
    }
}

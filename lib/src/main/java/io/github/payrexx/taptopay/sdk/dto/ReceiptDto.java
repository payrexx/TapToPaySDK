package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

public class ReceiptDto implements Dto {
    @SerializedName("transaction_id")
    public String transactionId;
    public String type;
    public String recipient;

    public ReceiptDto(String transactionId, String type, String recipient) {
        this.transactionId = transactionId;
        this.type = type;
        this.recipient = recipient;
    }
}

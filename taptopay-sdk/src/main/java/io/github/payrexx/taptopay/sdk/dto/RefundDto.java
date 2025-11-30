package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the data required to perform a refund transaction.
 */
public class RefundDto implements Dto {
    /**
     * The ID of the transaction to be refunded.
     */
    @SerializedName("transaction_id")
    public String transactionId;
    /**
     * The amount to be refunded.
     */
    public String amount;
    /**
     * Extra data to be associated with the refund.
     */
    public String extras = "";

    /**
     * Constructs a new RefundDto.
     *
     * @param transactionId The ID of the transaction to be refunded.
     * @param amount        The amount to be refunded.
     */
    public RefundDto(String transactionId, float amount) {
        this.transactionId = transactionId;
        this.amount = String.valueOf(amount);
    }

    /**
     * Constructs a new RefundDto.
     *
     * @param transactionId The ID of the transaction to be refunded.
     * @param amount        The amount to be refunded.
     * @param extras        Extra data to be associated with the refund.
     */
    public RefundDto(String transactionId, float amount, String extras) {
        this.transactionId = transactionId;
        this.amount = String.valueOf(amount);
        this.extras = extras;
    }
}

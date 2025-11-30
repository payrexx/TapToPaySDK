package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the data required to perform a void transaction.
 */
public class VoidDto implements Dto {
    /**
     * The ID of the transaction to be voided.
     */
    @SerializedName("transaction_id")
    public String transactionId;
    /**
     * Extra data to be associated with the void.
     */
    public String extras = "";

    /**
     * Constructs a new VoidDto.
     *
     * @param transactionId The ID of the transaction to be voided.
     */
    public VoidDto(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Constructs a new VoidDto.
     *
     * @param transactionId The ID of the transaction to be voided.
     * @param extras        Extra data to be associated with the void.
     */
    public VoidDto(String transactionId, String extras) {
        this.transactionId = transactionId;
        this.extras = extras;
    }
}

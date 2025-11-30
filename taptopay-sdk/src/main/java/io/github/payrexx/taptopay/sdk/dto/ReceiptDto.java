package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the data required to send a receipt.
 */
public class ReceiptDto implements Dto {
    /**
     * The ID of the transaction for which to send a receipt.
     */
    @SerializedName("transaction_id")
    public String transactionId;
    /**
     * The type of receipt to send (e.g., "email" or "sms").
     */
    public String type;
    /**
     * The recipient's contact information (e.g., email address or phone number).
     */
    public String recipient;

    /**
     * Constructs a new ReceiptDto.
     *
     * @param transactionId The ID of the transaction.
     * @param type          The type of receipt.
     * @param recipient     The recipient's contact information.
     */
    public ReceiptDto(String transactionId, String type, String recipient) {
        this.transactionId = transactionId;
        this.type = type;
        this.recipient = recipient;
    }
}

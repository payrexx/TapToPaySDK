package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the payment method used for a transaction.
 */
public enum PaymentMethod {
    /**
     * Payment by card.
     */
    @SerializedName("1")
    CARD,
    /**
     * Payment with Twint.
     */
    @SerializedName("11")
    TWINT
}

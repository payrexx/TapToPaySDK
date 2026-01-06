package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the payment method used for a transaction.
 */
public enum PaymentMethod {
    /**
     * Payment by card.
     */
    @SerializedName(value = "CONTACTLESS", alternate = {"1"})
    CARD,

    /**
     * Payment with Twint.
     */
    @SerializedName(value = "TWINT", alternate = {"11"})
    TWINT
}

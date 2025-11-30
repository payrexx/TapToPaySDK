package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the type of a transaction operation.
 */
public enum Operation {
    /**
     * A sale transaction.
     */
    @SerializedName(value = "sale", alternate = {"payrexx_sale"})
    SALE,
    /**
     * A void transaction.
     */
    @SerializedName("void")
    VOID,
    /**
     * A refund transaction.
     */
    @SerializedName(value = "refund", alternate = {"payrexx_refund"})
    REFUND
}

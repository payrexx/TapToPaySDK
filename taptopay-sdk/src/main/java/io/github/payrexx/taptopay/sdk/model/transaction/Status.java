package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the status of a transaction.
 */
public enum Status {
    /**
     * The transaction was successful.
     */
    @SerializedName(value = "successful", alternate = {"1"})
    SUCCESSFUL,
    /**
     * The transaction is pending.
     */
    @SerializedName(value = "pending", alternate = {"0"})
    PENDING,
    /**
     * The transaction failed.
     */
    @SerializedName(value = "failed", alternate = {"-1"})
    FAILED
}

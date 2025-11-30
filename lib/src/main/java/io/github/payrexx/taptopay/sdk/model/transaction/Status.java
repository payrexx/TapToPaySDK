package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

public enum Status {
    @SerializedName(value = "successful", alternate = {"1"})
    SUCCESSFUL,
    @SerializedName(value = "pending", alternate = {"0"})
    PENDING,
    @SerializedName(value = "failed", alternate = {"-1"})
    FAILED
}

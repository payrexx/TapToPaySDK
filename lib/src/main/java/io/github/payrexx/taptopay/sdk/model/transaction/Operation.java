package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

public enum Operation {
    @SerializedName(value = "sale", alternate = {"payrexx_sale"})
    SALE,
    @SerializedName("void")
    VOID,
    @SerializedName(value = "refund", alternate = {"payrexx_refund"})
    REFUND
}

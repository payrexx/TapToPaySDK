package io.github.payrexx.taptopay.sdk.model.transaction;

import com.google.gson.annotations.SerializedName;

public enum PaymentMethod {
    @SerializedName("1")
    CARD,
    @SerializedName("11")
    TWINT
}

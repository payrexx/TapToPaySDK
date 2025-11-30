package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Extras implements Serializable {
    @SerializedName("order_reference")
    public String orderReference = null;
}

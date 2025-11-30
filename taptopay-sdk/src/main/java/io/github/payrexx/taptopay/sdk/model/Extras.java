package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Represents extra data that can be associated with a response.
 */
public class Extras implements Serializable {
    /**
     * The order reference.
     */
    @SerializedName("order_reference")
    public String orderReference = null;
}

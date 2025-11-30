package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

public class SaleDto implements Dto {
    @SerializedName("order_reference")
    public String orderReference;
    @SerializedName("show_result")
    public boolean showResult = false;
    public String amount;
    public String tip;
    public String extras = "";

    public SaleDto (float amount, float tip, String orderReference) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.orderReference = orderReference;
    }

    public SaleDto (float amount, float tip, String orderReference, boolean showResult) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.orderReference = orderReference;
        this.showResult = showResult;
    }

    public SaleDto (float amount, float tip, String orderReference, boolean showResult, String extras) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.orderReference = orderReference;
        this.showResult = showResult;
        this.extras = extras;
    }
}

package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;

import io.github.payrexx.taptopay.sdk.model.transaction.PaymentMethod;

/**
 * Represents the data required to perform a sale transaction.
 */
public class SaleDto implements Dto {
    /**
     * The reference ID for the order.
     */
    @SerializedName("order_reference")
    public String orderReference;

    /**
     * Whether to show the result screen after the transaction. Defaults to false.
     */
    @SerializedName("show_result")
    public boolean showResult = false;

    /**
     * The transaction amount.
     */
    public String amount;

    /**
     * The tip amount.
     */
    public String tip;

    /**
     * Extra data to be associated with the sale.
     */
    public String extras = "";

    @SerializedName("payment_method_type")
    public PaymentMethod paymentMethod = null;

    /**
     * Constructs a new SaleDto.
     *
     * @param amount         The transaction amount.
     * @param tip            The tip amount.
     * @param orderReference The reference ID for the order.
     */
    public SaleDto (float amount, float tip, String orderReference) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.orderReference = orderReference;
    }

    /**
     * Constructs a new SaleDto.
     *
     * @param amount         The transaction amount.
     * @param tip            The tip amount.
     * @param paymentMethod  The payment method.
     * @param orderReference The reference ID for the order.
     */
    public SaleDto (float amount, float tip, PaymentMethod paymentMethod, String orderReference) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.paymentMethod = paymentMethod;
        this.orderReference = orderReference;
    }

    /**
     * Constructs a new SaleDto.
     *
     * @param amount         The transaction amount.
     * @param tip            The tip amount.
     * @param orderReference The reference ID for the order.
     * @param showResult     Whether to show the result screen.
     */
    public SaleDto (float amount, float tip, String orderReference, boolean showResult) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.orderReference = orderReference;
        this.showResult = showResult;
    }

    /**
     * Constructs a new SaleDto.
     *
     * @param amount         The transaction amount.
     * @param tip            The tip amount.
     * @param paymentMethod  The payment method.
     * @param orderReference The reference ID for the order.
     * @param showResult     Whether to show the result screen.
     */
    public SaleDto (float amount, float tip, PaymentMethod paymentMethod, String orderReference, boolean showResult) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.paymentMethod = paymentMethod;
        this.orderReference = orderReference;
        this.showResult = showResult;
    }

    /**
     * Constructs a new SaleDto.
     *
     * @param amount         The transaction amount.
     * @param tip            The tip amount.
     * @param orderReference The reference ID for the order.
     * @param showResult     Whether to show the result screen.
     * @param extras         Extra data to be associated with the sale.
     */
    public SaleDto (float amount, float tip, String orderReference, boolean showResult, String extras) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.orderReference = orderReference;
        this.showResult = showResult;
        this.extras = extras;
    }

    /**
     * Constructs a new SaleDto.
     *
     * @param amount         The transaction amount.
     * @param tip            The tip amount.
     * @param paymentMethod  The payment method.
     * @param orderReference The reference ID for the order.
     * @param showResult     Whether to show the result screen.
     * @param extras         Extra data to be associated with the sale.
     */
    public SaleDto (float amount, float tip, PaymentMethod paymentMethod, String orderReference, boolean showResult, String extras) {
        this.amount = String.valueOf(amount);
        this.tip = String.valueOf(tip);
        this.paymentMethod = paymentMethod;
        this.orderReference = orderReference;
        this.showResult = showResult;
        this.extras = extras;
    }
}

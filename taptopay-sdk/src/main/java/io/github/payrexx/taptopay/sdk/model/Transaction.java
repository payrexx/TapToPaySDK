package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;
import io.github.payrexx.taptopay.sdk.model.transaction.PaymentMethod;
import io.github.payrexx.taptopay.sdk.model.transaction.ResponseCode;
import io.github.payrexx.taptopay.sdk.model.transaction.Operation;
import io.github.payrexx.taptopay.sdk.model.transaction.Status;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * Represents a transaction.
 */
public class Transaction implements Serializable {
    /**
     * The date and time formatter for the transaction date.
     */
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:sszzz");
    /**
     * The unique ID of the transaction.
     */
    @SerializedName("transaction_key")
    public String id = null;
    /**
     * The status of the transaction.
     */
    public Status status = null;
    /**
     * The type of operation.
     */
    public Operation operation = null;
    /**
     * The payment method used.
     */
    @SerializedName("payment_method")
    public PaymentMethod paymentMethod = null;
    /**
     * The type of card used.
     */
    @SerializedName("card_type")
    public String cardType = null;
    /**
     * The date of the transaction.
     */
    @SerializedName("add_date")
    public String date = null;
    /**
     * The transaction amount.
     */
    public Float amount = null;
    /**
     * The tip amount.
     */
    @SerializedName("tip_amount")
    public Float tipAmount = null;
    /**
     * The currency of the transaction.
     */
    public String currency = null;
    /**
     * Whether the transaction is voidable.
     */
    public Boolean voidable = false;
    /**
     * The amount that can be refunded.
     */
    @SerializedName("refundable_amount")
    public Float refundableAmount = null;

    /**
     * The STAN (System Trace Audit Number) of the transaction.
     */
    public String stan = null;
    /**
     * The application ID.
     */
    @SerializedName("application_id")
    public String applicationId = null;
    /**
     * The order reference.
     */
    @SerializedName("order_reference")
    public String orderReference = null;
    /**
     * The response code of the transaction.
     */
    @SerializedName("action_code")
    public ResponseCode responseCode = null;
}

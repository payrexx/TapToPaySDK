package io.github.payrexx.taptopay.sdk.model;

import com.google.gson.annotations.SerializedName;
import io.github.payrexx.taptopay.sdk.model.transaction.PaymentMethod;
import io.github.payrexx.taptopay.sdk.model.transaction.ResponseCode;
import io.github.payrexx.taptopay.sdk.model.transaction.Operation;
import io.github.payrexx.taptopay.sdk.model.transaction.Status;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:sszzz");
    @SerializedName("transaction_key")
    public String id = null;
    public Status status = null;
    public Operation operation = null;
    @SerializedName("payment_method")
    public PaymentMethod paymentMethod = null;
    @SerializedName("card_type")
    public String cardType = null;
    @SerializedName("add_date")
    public String date = null;
    public Float amount = null;
    @SerializedName("tip_amount")
    public Float tipAmount = null;
    public String currency = null;
    public Boolean voidable = false;
    @SerializedName("refundable_amount")
    public Float refundableAmount = null;

    public String stan = null;
    @SerializedName("application_id")
    public String applicationId = null;
    @SerializedName("order_reference")
    public String orderReference = null;
    @SerializedName("action_code")
    public ResponseCode responseCode = null;
}

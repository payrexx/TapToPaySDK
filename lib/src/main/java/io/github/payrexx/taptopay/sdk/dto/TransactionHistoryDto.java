package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;
import io.github.payrexx.taptopay.sdk.model.transaction.Operation;
import io.github.payrexx.taptopay.sdk.model.transaction.Status;

public class TransactionHistoryDto implements Dto {

    public int page = 1;
    public int limit = 5;
    @SerializedName("transaction_type")
    public Operation operation = null;
    @SerializedName("transaction_state")
    public Status status = null;

    @SerializedName("order_reference")
    public String orderReference = null;

    public TransactionHistoryDto(String orderReference) {
        this.orderReference = orderReference;
    }
    public TransactionHistoryDto(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public TransactionHistoryDto(int page, int limit, Operation operation, Status status) {
        this.page = page;
        this.limit = limit;
        this.operation = operation;
        this.status = status;
    }
}


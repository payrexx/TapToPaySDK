package io.github.payrexx.taptopay.sdk.dto;

import com.google.gson.annotations.SerializedName;
import io.github.payrexx.taptopay.sdk.model.transaction.Operation;
import io.github.payrexx.taptopay.sdk.model.transaction.Status;

/**
 * Represents the data required to query for transaction history.
 */
public class TransactionHistoryDto implements Dto {

    /**
     * The page number of the transaction history to retrieve. Defaults to 1.
     */
    public int page = 1;
    /**
     * The maximum number of transactions to retrieve per page. Defaults to 5.
     */
    public int limit = 5;
    /**
     * The type of operation to filter by.
     */
    @SerializedName("transaction_type")
    public Operation operation = null;
    /**
     * The status of the transaction to filter by.
     */
    @SerializedName("transaction_state")
    public Status status = null;

    /**
     * The order reference to filter by.
     */
    @SerializedName("order_reference")
    public String orderReference = null;

    /**
     * Constructs a new TransactionHistoryDto to filter by order reference.
     *
     * @param orderReference The order reference to filter by.
     */
    public TransactionHistoryDto(String orderReference) {
        this.orderReference = orderReference;
    }
    /**
     * Constructs a new TransactionHistoryDto with pagination.
     *
     * @param page  The page number.
     * @param limit The number of items per page.
     */
    public TransactionHistoryDto(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    /**
     * Constructs a new TransactionHistoryDto with pagination and filters.
     *
     * @param page      The page number.
     * @param limit     The number of items per page.
     * @param operation The operation type to filter by.
     * @param status    The transaction status to filter by.
     */
    public TransactionHistoryDto(int page, int limit, Operation operation, Status status) {
        this.page = page;
        this.limit = limit;
        this.operation = operation;
        this.status = status;
    }
}


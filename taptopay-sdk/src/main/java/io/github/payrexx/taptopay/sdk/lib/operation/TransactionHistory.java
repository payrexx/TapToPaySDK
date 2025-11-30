package io.github.payrexx.taptopay.sdk.lib.operation;

import android.content.Intent;

import io.github.payrexx.taptopay.sdk.dto.TransactionHistoryDto;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayFragment;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayResultListener;
import io.github.payrexx.taptopay.sdk.model.EmptyResponse;
import io.github.payrexx.taptopay.sdk.model.Response;

/**
 * Represents a transaction history operation.
 */
public class TransactionHistory extends Operation {
    /**
     * Constructs a new TransactionHistory operation.
     *
     * @param transactionHistoryDto The data for the transaction history query.
     */
    public TransactionHistory(TransactionHistoryDto transactionHistoryDto) {
        super(transactionHistoryDto);
    }

    @Override
    public void startOperation(TapToPayFragment taptopayFragment, TapToPayResultListener resultListener) {
        Intent intent = new Intent("com.payrexx.taptopay.SOFTPOS");
        intent.putExtra(
            "com.payrexx.taptopay.CONFIGURATION",
            this.getRequestData("transaction_history").toString()
        );

        taptopayFragment.launch(intent, result -> {
            Response response;
            if (result == null) {
                response = new EmptyResponse();
            } else {
                response = this.parseResponseListData(result);
            }
            resultListener.onTapToPayResultCallback(response);
        });
    }
}

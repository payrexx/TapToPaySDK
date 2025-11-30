package io.github.payrexx.taptopay.sdk.lib.operation;

import android.content.Intent;

import io.github.payrexx.taptopay.sdk.dto.ReceiptDto;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayFragment;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayResultListener;
import io.github.payrexx.taptopay.sdk.model.EmptyResponse;
import io.github.payrexx.taptopay.sdk.model.Response;

/**
 * Represents a receipt operation.
 */
public class Receipt extends Operation {
    /**
     * Constructs a new Receipt operation.
     *
     * @param receiptDto The data for the receipt.
     */
    public Receipt(ReceiptDto receiptDto) {
        super(receiptDto);
    }

    @Override
    public void startOperation(TapToPayFragment taptopayFragment, TapToPayResultListener resultListener) {
        Intent intent = new Intent("com.payrexx.taptopay.SOFTPOS");
        intent.putExtra(
            "com.payrexx.taptopay.CONFIGURATION",
            this.getRequestData("send_receipt").toString()
        );

        taptopayFragment.launch(intent, result -> {
            Response response;
            if (result == null) {
                response = new EmptyResponse();
            } else {
                response = this.parseResponseData(result);
            }
            resultListener.onTapToPayResultCallback(response);
        });
    }
}

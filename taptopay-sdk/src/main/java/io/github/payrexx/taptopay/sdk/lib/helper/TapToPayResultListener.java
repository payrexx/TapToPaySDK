package io.github.payrexx.taptopay.sdk.lib.helper;

import io.github.payrexx.taptopay.sdk.model.Response;

/**
 * A listener interface for receiving the result of a Tap to Pay operation.
 */
public interface TapToPayResultListener {
    /**
     * Called when the Tap to Pay operation is complete.
     *
     * @param response The response from the Tap to Pay operation.
     */
    void onTapToPayResultCallback(Response response);
}

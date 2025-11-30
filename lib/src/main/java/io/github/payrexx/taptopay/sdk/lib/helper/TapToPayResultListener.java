package io.github.payrexx.taptopay.sdk.lib.helper;

import io.github.payrexx.taptopay.sdk.model.Response;

public interface TapToPayResultListener {
    void onTapToPayResultCallback(Response response);
}

package io.github.payrexx.taptopay.sdk.lib.helper;

import androidx.activity.result.ActivityResultCallback;
import androidx.lifecycle.ViewModel;

public class TapToPayViewModel extends ViewModel {
    private ActivityResultCallback<String> activityResultCallback;

    public ActivityResultCallback<String> getAndClearActivityResultCallback() {
        ActivityResultCallback<String> callback = activityResultCallback;
        this.activityResultCallback = null;
        return callback;
    }

    public void setActivityResultCallback(ActivityResultCallback<String> callback) {
        this.activityResultCallback = callback;
    }
}

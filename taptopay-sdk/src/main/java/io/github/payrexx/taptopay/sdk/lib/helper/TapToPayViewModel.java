package io.github.payrexx.taptopay.sdk.lib.helper;

import androidx.activity.result.ActivityResultCallback;
import androidx.lifecycle.ViewModel;

/**
 * A ViewModel that holds the ActivityResultCallback for the Tap to Pay operation.
 * This is used to persist the callback across configuration changes.
 * @hide
 */
public class TapToPayViewModel extends ViewModel {
    private ActivityResultCallback<String> activityResultCallback;

    /**
     * Returns the current ActivityResultCallback and clears it from the ViewModel.
     *
     * @return The ActivityResultCallback, or null if none is set.
     */
    public ActivityResultCallback<String> getAndClearActivityResultCallback() {
        ActivityResultCallback<String> callback = activityResultCallback;
        this.activityResultCallback = null;
        return callback;
    }

    /**
     * Sets the ActivityResultCallback.
     *
     * @param callback The callback to be stored.
     */
    public void setActivityResultCallback(ActivityResultCallback<String> callback) {
        this.activityResultCallback = callback;
    }
}

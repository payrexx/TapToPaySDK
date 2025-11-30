package io.github.payrexx.taptopay.sdk.lib.helper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

/**
 * A fragment that handles the Tap to Pay activity result.
 * This fragment is responsible for launching the Tap to Pay activity and receiving the result.
 * It is not intended to be used directly by developers.
 * @hide
 */
public class TapToPayFragment extends Fragment {

    public static final String TAG = "TapToPayFragment";
    private ActivityResultLauncher<Intent> tapToPayLauncher;
    private TapToPayViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TapToPayViewModel.class);

        tapToPayLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    ActivityResultCallback<String> callback = viewModel.getAndClearActivityResultCallback();
                    if (callback != null) {
                        callback.onActivityResult(this.parseResult(result));
                    } else {
                        Log.w(TAG, "ActivityResult received, but no external callback was active.");
                    }
                }
        );
    }

    /**
     * Parses the result from the Tap to Pay activity.
     *
     * @param result The result from the activity.
     * @return The result string, or null if the result is not valid.
     */
    public String parseResult(ActivityResult result) {
        if (result.getResultCode() != Activity.RESULT_OK) {
            return null;
        }

        Intent data = result.getData();
        if (data == null) {
            return null;
        }

        Bundle extras = data.getExtras();
        if (extras == null) {
            return null;
        }

        return extras.getString("com.payrexx.taptopay.RESULT");
    }

    /**
     * Launches the Tap to Pay activity.
     *
     * @param intent   The intent to launch the activity.
     * @param callback The callback to be invoked with the result.
     */
    public void launch(Intent intent, ActivityResultCallback<String> callback) {
        viewModel.setActivityResultCallback(callback);
        tapToPayLauncher.launch(intent);
    }

    /**
     * Returns the activity result launcher.
     *
     * @return The activity result launcher.
     */
    public ActivityResultLauncher<Intent> getLauncher() {
        return tapToPayLauncher;
    }
}

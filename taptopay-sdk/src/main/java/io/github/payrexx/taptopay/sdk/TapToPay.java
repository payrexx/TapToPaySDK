package io.github.payrexx.taptopay.sdk;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayFragment;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayResultListener;
import io.github.payrexx.taptopay.sdk.lib.operation.Operation;

/**
 * The main class for interacting with the Payrexx Tap to Pay SDK.
 * This class provides the entry point for performing Tap to Pay operations.
 */
public class TapToPay {

    private final FragmentActivity hostActivity;

    /**
     * Constructs a new TapToPay instance.
     *
     * @param hostActivity The activity that will host the Tap to Pay flow.
     */
    public TapToPay(FragmentActivity hostActivity) {
        this.hostActivity = hostActivity;
    }

    /**
     * Executes a Tap to Pay operation.
     *
     * @param operation The operation to be performed (e.g., a payment).
     * @param callback  The listener to be notified of the operation's result.
     */
    public void doOperation(Operation operation, TapToPayResultListener callback) {
        final FragmentManager fragmentManager = hostActivity.getSupportFragmentManager();

        TapToPayFragment taptopayFragment =
                (TapToPayFragment) fragmentManager.findFragmentByTag(TapToPayFragment.TAG);

        if (taptopayFragment == null) {
            taptopayFragment = new TapToPayFragment();

            fragmentManager.beginTransaction()
                    .add(taptopayFragment, TapToPayFragment.TAG)
                    .commitAllowingStateLoss();

            fragmentManager.executePendingTransactions();
        }

        operation.startOperation(taptopayFragment, callback);
    }
}

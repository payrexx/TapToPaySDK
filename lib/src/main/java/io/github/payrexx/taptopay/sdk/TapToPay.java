package io.github.payrexx.taptopay.sdk;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayFragment;
import io.github.payrexx.taptopay.sdk.lib.helper.TapToPayResultListener;
import io.github.payrexx.taptopay.sdk.lib.operation.Operation;

public class TapToPay {

    private final FragmentActivity hostActivity;

    public TapToPay(FragmentActivity hostActivity) {
        this.hostActivity = hostActivity;
    }

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
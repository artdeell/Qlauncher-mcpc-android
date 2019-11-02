package android.support.p000v4.app;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput.Factory;

/* renamed from: android.support.v4.app.RemoteInputCompatJellybean */
class RemoteInputCompatJellybean {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_LABEL = "label";
    private static final String KEY_RESULT_KEY = "resultKey";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";

    RemoteInputCompatJellybean() {
    }

    static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        Bundle bundle2;
        Intent intent2;
        RemoteInput[] remoteInputArr2 = remoteInputArr;
        Intent intent3 = intent;
        Bundle bundle3 = bundle;
        Bundle bundle4 = bundle2;
        Bundle bundle5 = new Bundle();
        Bundle bundle6 = bundle4;
        int length = remoteInputArr2.length;
        for (int i = 0; i < length; i++) {
            RemoteInput remoteInput = remoteInputArr2[i];
            Object obj = bundle3.get(remoteInput.getResultKey());
            if (obj instanceof CharSequence) {
                bundle6.putCharSequence(remoteInput.getResultKey(), (CharSequence) obj);
            }
        }
        Intent intent4 = intent2;
        Intent intent5 = new Intent();
        Intent intent6 = intent4;
        Intent putExtra = intent6.putExtra("android.remoteinput.resultsData", bundle6);
        intent3.setClipData(ClipData.newIntent("android.remoteinput.results", intent6));
    }

    static RemoteInput fromBundle(Bundle bundle, Factory factory) {
        Bundle bundle2 = bundle;
        return factory.build(bundle2.getString(KEY_RESULT_KEY), bundle2.getCharSequence(KEY_LABEL), bundle2.getCharSequenceArray(KEY_CHOICES), bundle2.getBoolean(KEY_ALLOW_FREE_FORM_INPUT), bundle2.getBundle(KEY_EXTRAS));
    }

    static RemoteInput[] fromBundleArray(Bundle[] bundleArr, Factory factory) {
        RemoteInput[] newArray;
        Bundle[] bundleArr2 = bundleArr;
        Factory factory2 = factory;
        if (bundleArr2 == null) {
            newArray = null;
        } else {
            newArray = factory2.newArray(bundleArr2.length);
            for (int i = 0; i < bundleArr2.length; i++) {
                newArray[i] = fromBundle(bundleArr2[i], factory2);
            }
        }
        return newArray;
    }

    static Bundle getResultsFromIntent(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData != null) {
            ClipDescription description = clipData.getDescription();
            if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals("android.remoteinput.results")) {
                return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
            }
        }
        return null;
    }

    static Bundle toBundle(RemoteInput remoteInput) {
        Bundle bundle;
        RemoteInput remoteInput2 = remoteInput;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        Bundle bundle4 = bundle2;
        bundle4.putString(KEY_RESULT_KEY, remoteInput2.getResultKey());
        bundle4.putCharSequence(KEY_LABEL, remoteInput2.getLabel());
        bundle4.putCharSequenceArray(KEY_CHOICES, remoteInput2.getChoices());
        bundle4.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, remoteInput2.getAllowFreeFormInput());
        bundle4.putBundle(KEY_EXTRAS, remoteInput2.getExtras());
        return bundle4;
    }

    static Bundle[] toBundleArray(RemoteInput[] remoteInputArr) {
        Bundle[] bundleArr;
        RemoteInput[] remoteInputArr2 = remoteInputArr;
        if (remoteInputArr2 == null) {
            bundleArr = null;
        } else {
            bundleArr = new Bundle[remoteInputArr2.length];
            for (int i = 0; i < remoteInputArr2.length; i++) {
                bundleArr[i] = toBundle(remoteInputArr2[i]);
            }
        }
        return bundleArr;
    }
}

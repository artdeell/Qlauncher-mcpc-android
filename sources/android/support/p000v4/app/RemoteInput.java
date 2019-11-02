package android.support.p000v4.app;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput.Factory;
import android.util.Log;

/* renamed from: android.support.v4.app.RemoteInput */
public class RemoteInput extends android.support.p000v4.app.RemoteInputCompatBase.RemoteInput {
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final Factory FACTORY;
    private static final Impl IMPL;
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormInput;
    private final CharSequence[] mChoices;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    /* renamed from: android.support.v4.app.RemoteInput$Builder */
    public static final class Builder {
        private boolean mAllowFreeFormInput = true;
        private CharSequence[] mChoices;
        private Bundle mExtras;
        private CharSequence mLabel;
        private final String mResultKey;

        public Builder(String str) {
            Bundle bundle;
            IllegalArgumentException illegalArgumentException;
            String str2 = str;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            this.mExtras = bundle2;
            if (str2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Result key can't be null");
                throw illegalArgumentException2;
            }
            this.mResultKey = str2;
        }

        public Builder addExtras(Bundle bundle) {
            Bundle bundle2 = bundle;
            if (bundle2 != null) {
                this.mExtras.putAll(bundle2);
            }
            return this;
        }

        public RemoteInput build() {
            RemoteInput remoteInput;
            RemoteInput remoteInput2 = remoteInput;
            RemoteInput remoteInput3 = new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
            return remoteInput2;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public Builder setAllowFreeFormInput(boolean z) {
            this.mAllowFreeFormInput = z;
            return this;
        }

        public Builder setChoices(CharSequence[] charSequenceArr) {
            this.mChoices = charSequenceArr;
            return this;
        }

        public Builder setLabel(CharSequence charSequence) {
            this.mLabel = charSequence;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$Impl */
    interface Impl {
        void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle);

        Bundle getResultsFromIntent(Intent intent);
    }

    /* renamed from: android.support.v4.app.RemoteInput$ImplApi20 */
    static class ImplApi20 implements Impl {
        ImplApi20() {
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatApi20.addResultsToIntent(remoteInputArr, intent, bundle);
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatApi20.getResultsFromIntent(intent);
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$ImplBase */
    static class ImplBase implements Impl {
        ImplBase() {
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInput[] remoteInputArr2 = remoteInputArr;
            Intent intent2 = intent;
            Bundle bundle2 = bundle;
            int w = Log.w(RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
        }

        public Bundle getResultsFromIntent(Intent intent) {
            Intent intent2 = intent;
            int w = Log.w(RemoteInput.TAG, "RemoteInput is only supported from API Level 16");
            return null;
        }
    }

    /* renamed from: android.support.v4.app.RemoteInput$ImplJellybean */
    static class ImplJellybean implements Impl {
        ImplJellybean() {
        }

        public void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
            RemoteInputCompatJellybean.addResultsToIntent(remoteInputArr, intent, bundle);
        }

        public Bundle getResultsFromIntent(Intent intent) {
            return RemoteInputCompatJellybean.getResultsFromIntent(intent);
        }
    }

    static {
        ImplBase implBase;
        ImplJellybean implJellybean;
        C00341 r2;
        ImplApi20 implApi20;
        if (VERSION.SDK_INT >= 20) {
            ImplApi20 implApi202 = implApi20;
            ImplApi20 implApi203 = new ImplApi20();
            IMPL = implApi202;
        } else if (VERSION.SDK_INT >= 16) {
            ImplJellybean implJellybean2 = implJellybean;
            ImplJellybean implJellybean3 = new ImplJellybean();
            IMPL = implJellybean2;
        } else {
            ImplBase implBase2 = implBase;
            ImplBase implBase3 = new ImplBase();
            IMPL = implBase2;
        }
        C00341 r0 = r2;
        C00341 r1 = new Factory() {
            public RemoteInput build(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
                RemoteInput remoteInput;
                RemoteInput remoteInput2 = remoteInput;
                RemoteInput remoteInput3 = new RemoteInput(str, charSequence, charSequenceArr, z, bundle);
                return remoteInput2;
            }

            public RemoteInput[] newArray(int i) {
                return new RemoteInput[i];
            }
        };
        FACTORY = r0;
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        CharSequence charSequence2 = charSequence;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        boolean z2 = z;
        Bundle bundle2 = bundle;
        this.mResultKey = str;
        this.mLabel = charSequence2;
        this.mChoices = charSequenceArr2;
        this.mAllowFreeFormInput = z2;
        this.mExtras = bundle2;
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        IMPL.addResultsToIntent(remoteInputArr, intent, bundle);
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return IMPL.getResultsFromIntent(intent);
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormInput;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }
}

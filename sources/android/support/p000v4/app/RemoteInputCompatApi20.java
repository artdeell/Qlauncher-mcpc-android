package android.support.p000v4.app;

import android.app.RemoteInput.Builder;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput.Factory;

/* renamed from: android.support.v4.app.RemoteInputCompatApi20 */
class RemoteInputCompatApi20 {
    RemoteInputCompatApi20() {
    }

    static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        android.app.RemoteInput.addResultsToIntent(fromCompat(remoteInputArr), intent, bundle);
    }

    static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArr) {
        android.app.RemoteInput[] remoteInputArr2;
        Builder builder;
        RemoteInput[] remoteInputArr3 = remoteInputArr;
        if (remoteInputArr3 == null) {
            remoteInputArr2 = null;
        } else {
            remoteInputArr2 = new android.app.RemoteInput[remoteInputArr3.length];
            for (int i = 0; i < remoteInputArr3.length; i++) {
                RemoteInput remoteInput = remoteInputArr3[i];
                android.app.RemoteInput[] remoteInputArr4 = remoteInputArr2;
                int i2 = i;
                Builder builder2 = builder;
                Builder builder3 = new Builder(remoteInput.getResultKey());
                remoteInputArr4[i2] = builder2.setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
            }
        }
        return remoteInputArr2;
    }

    static Bundle getResultsFromIntent(Intent intent) {
        return android.app.RemoteInput.getResultsFromIntent(intent);
    }

    static RemoteInput[] toCompat(android.app.RemoteInput[] remoteInputArr, Factory factory) {
        RemoteInput[] newArray;
        android.app.RemoteInput[] remoteInputArr2 = remoteInputArr;
        Factory factory2 = factory;
        if (remoteInputArr2 == null) {
            newArray = null;
        } else {
            newArray = factory2.newArray(remoteInputArr2.length);
            for (int i = 0; i < remoteInputArr2.length; i++) {
                android.app.RemoteInput remoteInput = remoteInputArr2[i];
                newArray[i] = factory2.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
            }
        }
        return newArray;
    }
}

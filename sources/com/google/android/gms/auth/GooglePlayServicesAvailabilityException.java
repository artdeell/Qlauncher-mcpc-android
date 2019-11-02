package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zzVn;

    GooglePlayServicesAvailabilityException(int i, String str, Intent intent) {
        int i2 = i;
        super(str, intent);
        this.zzVn = i2;
    }

    public int getConnectionStatusCode() {
        return this.zzVn;
    }
}

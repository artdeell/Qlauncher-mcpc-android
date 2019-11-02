package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {
    private final int zzVn;

    GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        int i2 = i;
        super(str, intent);
        this.zzVn = i2;
    }

    public int getConnectionStatusCode() {
        return this.zzVn;
    }
}

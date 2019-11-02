package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzr;

@zzhb
public class zzio extends Handler {
    public zzio(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            Exception exc = e;
            zzr.zzbF().zzb((Throwable) exc, false);
            throw exc;
        }
    }
}

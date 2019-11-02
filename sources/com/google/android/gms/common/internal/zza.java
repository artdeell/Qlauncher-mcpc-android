package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.zze;

public class zza extends com.google.android.gms.common.internal.zzp.zza {
    private Context mContext;
    private Account zzTI;
    int zzakz;

    public static Account zza(zzp zzp) {
        zzp zzp2 = zzp;
        Account account = null;
        if (zzp2 != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzp2.getAccount();
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } catch (RemoteException e) {
                RemoteException remoteException = e;
                int w = Log.w("AccountAccessor", "Remote account accessor probably died");
                Binder.restoreCallingIdentity(clearCallingIdentity);
                return null;
            } catch (Throwable th) {
                Throwable th2 = th;
                Binder.restoreCallingIdentity(clearCallingIdentity);
                throw th2;
            }
        }
        return account;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this == obj2) {
            return true;
        }
        if (!(obj2 instanceof zza)) {
            return false;
        }
        return this.zzTI.equals(((zza) obj2).zzTI);
    }

    public Account getAccount() {
        SecurityException securityException;
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzakz) {
            return this.zzTI;
        }
        if (zze.zzf(this.mContext, callingUid)) {
            this.zzakz = callingUid;
            return this.zzTI;
        }
        SecurityException securityException2 = securityException;
        SecurityException securityException3 = new SecurityException("Caller is not GooglePlayServices");
        throw securityException2;
    }
}

package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */
    public static final zzc zzbgP = zzc.zzoK();
    private static Method zzbgQ = null;
    private static final Object zzqy;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzqy = obj2;
    }

    public ProviderInstaller() {
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        StringBuilder sb;
        GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException;
        GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException2;
        Context context2 = context;
        Object zzb = zzx.zzb(context2, (Object) "Context must not be null");
        zzbgP.zzak(context2);
        Context remoteContext = zze.getRemoteContext(context2);
        if (remoteContext == null) {
            int e = Log.e("ProviderInstaller", "Failed to get remote context");
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException3 = googlePlayServicesNotAvailableException2;
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException4 = new GooglePlayServicesNotAvailableException(8);
            throw googlePlayServicesNotAvailableException3;
        }
        Object obj = zzqy;
        synchronized (obj) {
            try {
                if (zzbgQ == null) {
                    zzaV(remoteContext);
                }
                Method method = zzbgQ;
                Object[] objArr = new Object[1];
                Object[] objArr2 = objArr;
                objArr[0] = remoteContext;
                Object invoke = method.invoke(null, objArr2);
            } catch (Exception e2) {
                Exception exc = e2;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int e3 = Log.e("ProviderInstaller", sb2.append("Failed to install provider: ").append(exc.getMessage()).toString());
                GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException5 = googlePlayServicesNotAvailableException;
                GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException6 = new GooglePlayServicesNotAvailableException(8);
                throw googlePlayServicesNotAvailableException5;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        C04551 r6;
        Context context2 = context;
        ProviderInstallListener providerInstallListener2 = providerInstallListener;
        Object zzb = zzx.zzb(context2, (Object) "Context must not be null");
        Object zzb2 = zzx.zzb(providerInstallListener2, (Object) "Listener must not be null");
        zzx.zzcD("Must be called on the UI thread");
        C04551 r2 = r6;
        final Context context3 = context2;
        final ProviderInstallListener providerInstallListener3 = providerInstallListener2;
        C04551 r3 = new AsyncTask<Void, Void, Integer>() {
            {
                ProviderInstallListener providerInstallListener = r7;
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzc */
            public Integer doInBackground(Void... voidArr) {
                Void[] voidArr2 = voidArr;
                try {
                    ProviderInstaller.installIfNeeded(context3);
                    return Integer.valueOf(0);
                } catch (GooglePlayServicesRepairableException e) {
                    return Integer.valueOf(e.getConnectionStatusCode());
                } catch (GooglePlayServicesNotAvailableException e2) {
                    return Integer.valueOf(e2.errorCode);
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: zze */
            public void onPostExecute(Integer num) {
                Integer num2 = num;
                if (num2.intValue() == 0) {
                    providerInstallListener3.onProviderInstalled();
                    return;
                }
                providerInstallListener3.onProviderInstallFailed(num2.intValue(), ProviderInstaller.zzbgP.zza(context3, num2.intValue(), "pi"));
            }
        };
        AsyncTask execute = r2.execute(new Void[0]);
    }

    private static void zzaV(Context context) throws ClassNotFoundException, NoSuchMethodException {
        Class[] clsArr = new Class[1];
        Class[] clsArr2 = clsArr;
        clsArr[0] = Context.class;
        zzbgQ = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", clsArr2);
    }
}

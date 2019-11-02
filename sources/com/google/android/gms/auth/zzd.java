package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.RequiresPermission;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzas;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = (VERSION.SDK_INT >= 14 ? "androidPackageName" : "androidPackageName");
    public static final String KEY_CALLER_UID = (VERSION.SDK_INT >= 11 ? "callerUid" : "callerUid");
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    private static final ComponentName zzVe;
    private static final ComponentName zzVf;

    private interface zza<T> {
        T zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException;
    }

    static {
        ComponentName componentName;
        ComponentName componentName2;
        ComponentName componentName3 = componentName;
        ComponentName componentName4 = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        zzVe = componentName3;
        ComponentName componentName5 = componentName2;
        ComponentName componentName6 = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
        zzVf = componentName5;
    }

    zzd() {
    }

    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Bundle bundle;
        C02182 r9;
        Context context2 = context;
        String str2 = str;
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context2);
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        Bundle bundle4 = bundle2;
        String str3 = context2.getApplicationInfo().packageName;
        bundle4.putString("clientPackageName", str3);
        if (!bundle4.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle4.putString(KEY_ANDROID_PACKAGE_NAME, str3);
        }
        C02182 r5 = r9;
        final String str4 = str2;
        final Bundle bundle5 = bundle4;
        C02182 r6 = new zza<Void>() {
            {
                Bundle bundle = r7;
            }

            /* renamed from: zzao */
            public Void zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                GoogleAuthException googleAuthException;
                Bundle bundle = (Bundle) zzd.zzm(com.google.android.gms.internal.zzas.zza.zza(iBinder).zza(str4, bundle5));
                String string = bundle.getString("Error");
                if (bundle.getBoolean("booleanResult")) {
                    return null;
                }
                GoogleAuthException googleAuthException2 = googleAuthException;
                GoogleAuthException googleAuthException3 = new GoogleAuthException(string);
                throw googleAuthException2;
            }
        };
        Object zza2 = zza(context2, zzVe, r5);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        C02193 r9;
        Context context2 = context;
        int i2 = i;
        String str2 = str;
        String zzh = zzx.zzh(str2, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context2);
        C02193 r5 = r9;
        final String str3 = str2;
        final int i3 = i2;
        C02193 r6 = new zza<List<AccountChangeEvent>>() {
            {
                int i = r7;
            }

            /* renamed from: zzap */
            public List<AccountChangeEvent> zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                AccountChangeEventsRequest accountChangeEventsRequest;
                zzas zza = com.google.android.gms.internal.zzas.zza.zza(iBinder);
                AccountChangeEventsRequest accountChangeEventsRequest2 = accountChangeEventsRequest;
                AccountChangeEventsRequest accountChangeEventsRequest3 = new AccountChangeEventsRequest();
                return ((AccountChangeEventsResponse) zzd.zzm(zza.zza(accountChangeEventsRequest2.setAccountName(str3).setEventIndex(i3)))).getEvents();
            }
        };
        return (List) zza(context2, zzVe, r5);
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        Bundle bundle;
        Context context2 = context;
        String str2 = str;
        String zzh = zzx.zzh(str2, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context2);
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        return getToken(context2, str2, "^^_account_id_^^", bundle2);
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Bundle bundle;
        Context context2 = context;
        Account account2 = account;
        String str2 = str;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        return getToken(context2, account2, str2, bundle2);
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzc(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Account account;
        String str3 = str2;
        Context context2 = context;
        Account account2 = account;
        Account account3 = new Account(str, GOOGLE_ACCOUNT_TYPE);
        return getToken(context2, account2, str3);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Account account;
        String str3 = str2;
        Bundle bundle2 = bundle;
        Context context2 = context;
        Account account2 = account;
        Account account3 = new Account(str, GOOGLE_ACCOUNT_TYPE);
        return getToken(context2, account2, str3, bundle2);
    }

    @RequiresPermission("android.permission.MANAGE_ACCOUNTS")
    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken(GOOGLE_ACCOUNT_TYPE, str);
    }

    private static <T> T zza(Context context, ComponentName componentName, zza<T> zza2) throws IOException, GoogleAuthException {
        com.google.android.gms.common.zza zza3;
        IOException iOException;
        Throwable th;
        IOException iOException2;
        Context context2 = context;
        ComponentName componentName2 = componentName;
        zza<T> zza4 = zza2;
        com.google.android.gms.common.zza zza5 = zza3;
        com.google.android.gms.common.zza zza6 = new com.google.android.gms.common.zza();
        com.google.android.gms.common.zza zza7 = zza5;
        zzl zzau = zzl.zzau(context2);
        if (zzau.zza(componentName2, (ServiceConnection) zza7, "GoogleAuthUtil")) {
            try {
                Object zzan = zza4.zzan(zza7.zzoJ());
                zzau.zzb(componentName2, (ServiceConnection) zza7, "GoogleAuthUtil");
                return zzan;
            } catch (RemoteException e) {
                th = e;
                try {
                    int i = Log.i("GoogleAuthUtil", "Error on service connection.", th);
                    IOException iOException3 = iOException2;
                    IOException iOException4 = new IOException("Error on service connection.", th);
                    throw iOException3;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    zzau.zzb(componentName2, (ServiceConnection) zza7, "GoogleAuthUtil");
                    throw th3;
                }
            } catch (InterruptedException e2) {
                th = e2;
                int i2 = Log.i("GoogleAuthUtil", "Error on service connection.", th);
                IOException iOException32 = iOException2;
                IOException iOException42 = new IOException("Error on service connection.", th);
                throw iOException32;
            }
        } else {
            IOException iOException5 = iOException;
            IOException iOException6 = new IOException("Could not bind to service.");
            throw iOException5;
        }
    }

    private static void zzad(Context context) throws GoogleAuthException {
        GoogleAuthException googleAuthException;
        GooglePlayServicesAvailabilityException googlePlayServicesAvailabilityException;
        try {
            zze.zzad(context.getApplicationContext());
        } catch (GooglePlayServicesRepairableException e) {
            GooglePlayServicesRepairableException googlePlayServicesRepairableException = e;
            GooglePlayServicesAvailabilityException googlePlayServicesAvailabilityException2 = googlePlayServicesAvailabilityException;
            GooglePlayServicesAvailabilityException googlePlayServicesAvailabilityException3 = new GooglePlayServicesAvailabilityException(googlePlayServicesRepairableException.getConnectionStatusCode(), googlePlayServicesRepairableException.getMessage(), googlePlayServicesRepairableException.getIntent());
            throw googlePlayServicesAvailabilityException2;
        } catch (GooglePlayServicesNotAvailableException e2) {
            GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException = e2;
            GoogleAuthException googleAuthException2 = googleAuthException;
            GoogleAuthException googleAuthException3 = new GoogleAuthException(googlePlayServicesNotAvailableException.getMessage());
            throw googleAuthException2;
        }
    }

    public static TokenData zzc(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Bundle bundle2;
        Bundle bundle3;
        C02171 r12;
        Bundle bundle4;
        Context context2 = context;
        Account account2 = account;
        String str2 = str;
        Bundle bundle5 = bundle;
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context2);
        if (bundle5 == null) {
            Bundle bundle6 = bundle4;
            Bundle bundle7 = new Bundle();
            bundle3 = bundle6;
        } else {
            Bundle bundle8 = bundle2;
            Bundle bundle9 = new Bundle(bundle5);
            bundle3 = bundle8;
        }
        String str3 = context2.getApplicationInfo().packageName;
        bundle3.putString("clientPackageName", str3);
        if (TextUtils.isEmpty(bundle3.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle3.putString(KEY_ANDROID_PACKAGE_NAME, str3);
        }
        bundle3.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        C02171 r7 = r12;
        final Account account3 = account2;
        final String str4 = str2;
        final Bundle bundle10 = bundle3;
        C02171 r8 = new zza<TokenData>() {
            {
                String str = r8;
                Bundle bundle = r9;
            }

            /* renamed from: zzam */
            public TokenData zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                GoogleAuthException googleAuthException;
                IOException iOException;
                UserRecoverableAuthException userRecoverableAuthException;
                Bundle bundle = (Bundle) zzd.zzm(com.google.android.gms.internal.zzas.zza.zza(iBinder).zza(account3, str4, bundle10));
                TokenData zzc = TokenData.zzc(bundle, "tokenDetails");
                if (zzc != null) {
                    return zzc;
                }
                String string = bundle.getString("Error");
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                com.google.android.gms.auth.firstparty.shared.zzd zzbY = com.google.android.gms.auth.firstparty.shared.zzd.zzbY(string);
                if (com.google.android.gms.auth.firstparty.shared.zzd.zza(zzbY)) {
                    UserRecoverableAuthException userRecoverableAuthException2 = userRecoverableAuthException;
                    UserRecoverableAuthException userRecoverableAuthException3 = new UserRecoverableAuthException(string, intent);
                    throw userRecoverableAuthException2;
                } else if (com.google.android.gms.auth.firstparty.shared.zzd.zzc(zzbY)) {
                    IOException iOException2 = iOException;
                    IOException iOException3 = new IOException(string);
                    throw iOException2;
                } else {
                    GoogleAuthException googleAuthException2 = googleAuthException;
                    GoogleAuthException googleAuthException3 = new GoogleAuthException(string);
                    throw googleAuthException2;
                }
            }
        };
        return (TokenData) zza(context2, zzVe, r7);
    }

    static void zzi(Intent intent) {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        Intent intent2 = intent;
        if (intent2 == null) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Callback cannot be null.");
            throw illegalArgumentException3;
        }
        try {
            Intent parseUri = Intent.parseUri(intent2.toUri(1), 1);
        } catch (URISyntaxException e) {
            URISyntaxException uRISyntaxException = e;
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
            throw illegalArgumentException5;
        }
    }

    /* access modifiers changed from: private */
    public static <T> T zzm(T t) throws IOException {
        IOException iOException;
        T t2 = t;
        if (t2 != null) {
            return t2;
        }
        int w = Log.w("GoogleAuthUtil", "Binder call returned null.");
        IOException iOException2 = iOException;
        IOException iOException3 = new IOException("Service unavailable.");
        throw iOException2;
    }
}

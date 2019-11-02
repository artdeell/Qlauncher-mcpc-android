package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzw extends Fragment implements OnCancelListener {
    /* access modifiers changed from: private */
    public boolean mStarted;
    private int zzaiA = -1;
    private ConnectionResult zzaiB;
    /* access modifiers changed from: private */
    public final Handler zzaiC;
    protected zzn zzaiD;
    private final SparseArray<zza> zzaiE;
    /* access modifiers changed from: private */
    public boolean zzaiz;

    private class zza implements OnConnectionFailedListener {
        public final int zzaiF;
        public final GoogleApiClient zzaiG;
        public final OnConnectionFailedListener zzaiH;
        final /* synthetic */ zzw zzaiI;

        public zza(zzw zzw, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            int i2 = i;
            GoogleApiClient googleApiClient2 = googleApiClient;
            OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
            this.zzaiI = zzw;
            this.zzaiF = i2;
            this.zzaiG = googleApiClient2;
            this.zzaiH = onConnectionFailedListener2;
            googleApiClient2.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            StringBuilder sb;
            String str2 = str;
            FileDescriptor fileDescriptor2 = fileDescriptor;
            PrintWriter printWriter2 = printWriter;
            String[] strArr2 = strArr;
            printWriter2.append(str2).append("GoogleApiClient #").print(this.zzaiF);
            printWriter2.println(":");
            GoogleApiClient googleApiClient = this.zzaiG;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            googleApiClient.dump(sb2.append(str2).append("  ").toString(), fileDescriptor2, printWriter2, strArr2);
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzb zzb;
            ConnectionResult connectionResult2 = connectionResult;
            Handler zzc = this.zzaiI.zzaiC;
            zzb zzb2 = zzb;
            zzb zzb3 = new zzb(this.zzaiI, this.zzaiF, connectionResult2);
            boolean post = zzc.post(zzb2);
        }

        public void zzpR() {
            this.zzaiG.unregisterConnectionFailedListener(this);
            this.zzaiG.disconnect();
        }
    }

    private class zzb implements Runnable {
        final /* synthetic */ zzw zzaiI;
        private final int zzaiJ;
        private final ConnectionResult zzaiK;

        public zzb(zzw zzw, int i, ConnectionResult connectionResult) {
            int i2 = i;
            ConnectionResult connectionResult2 = connectionResult;
            this.zzaiI = zzw;
            this.zzaiJ = i2;
            this.zzaiK = connectionResult2;
        }

        @MainThread
        public void run() {
            if (this.zzaiI.mStarted && !this.zzaiI.zzaiz) {
                boolean zza = zzw.zza(this.zzaiI, true);
                int zza2 = zzw.zza(this.zzaiI, this.zzaiJ);
                ConnectionResult zza3 = zzw.zza(this.zzaiI, this.zzaiK);
                if (this.zzaiK.hasResolution()) {
                    try {
                        this.zzaiK.startResolutionForResult(this.zzaiI.getActivity(), 1 + ((1 + this.zzaiI.getActivity().getSupportFragmentManager().getFragments().indexOf(this.zzaiI)) << 16));
                    } catch (SendIntentException e) {
                        SendIntentException sendIntentException = e;
                        this.zzaiI.zzpP();
                    }
                } else if (this.zzaiI.zzpQ().isUserResolvableError(this.zzaiK.getErrorCode())) {
                    this.zzaiI.zzb(this.zzaiJ, this.zzaiK);
                } else if (this.zzaiK.getErrorCode() == 18) {
                    this.zzaiI.zzc(this.zzaiJ, this.zzaiK);
                } else {
                    this.zzaiI.zza(this.zzaiJ, this.zzaiK);
                }
            }
        }
    }

    public zzw() {
        Handler handler;
        SparseArray<zza> sparseArray;
        Handler handler2 = handler;
        Handler handler3 = new Handler(Looper.getMainLooper());
        this.zzaiC = handler2;
        SparseArray<zza> sparseArray2 = sparseArray;
        SparseArray<zza> sparseArray3 = new SparseArray<>();
        this.zzaiE = sparseArray2;
    }

    static /* synthetic */ int zza(zzw zzw, int i) {
        int i2 = i;
        zzw.zzaiA = i2;
        return i2;
    }

    static /* synthetic */ ConnectionResult zza(zzw zzw, ConnectionResult connectionResult) {
        ConnectionResult connectionResult2 = connectionResult;
        zzw.zzaiB = connectionResult2;
        return connectionResult2;
    }

    @Nullable
    public static zzw zza(FragmentActivity fragmentActivity) {
        IllegalStateException illegalStateException;
        FragmentActivity fragmentActivity2 = fragmentActivity;
        zzx.zzcD("Must be called from main thread of process");
        try {
            zzw zzw = (zzw) fragmentActivity2.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFrag");
            if (zzw == null || zzw.isRemoving()) {
                zzw = null;
            }
            return zzw;
        } catch (ClassCastException e) {
            ClassCastException classCastException = e;
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", classCastException);
            throw illegalStateException2;
        }
    }

    /* access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        int i2 = i;
        ConnectionResult connectionResult2 = connectionResult;
        int w = Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zza2 = (zza) this.zzaiE.get(i2);
        if (zza2 != null) {
            zzbD(i2);
            OnConnectionFailedListener onConnectionFailedListener = zza2.zzaiH;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult2);
            }
        }
        zzpP();
    }

    static /* synthetic */ boolean zza(zzw zzw, boolean z) {
        boolean z2 = z;
        zzw.zzaiz = z2;
        return z2;
    }

    public static zzw zzb(FragmentActivity fragmentActivity) {
        zzw zzw;
        FragmentActivity fragmentActivity2 = fragmentActivity;
        zzw zza2 = zza(fragmentActivity2);
        FragmentManager supportFragmentManager = fragmentActivity2.getSupportFragmentManager();
        if (zza2 == null) {
            zza2 = zzpO();
            if (zza2 == null) {
                int w = Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
                zzw zzw2 = zzw;
                zzw zzw3 = new zzw();
                zza2 = zzw2;
            }
            int commitAllowingStateLoss = supportFragmentManager.beginTransaction().add((Fragment) zza2, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
            boolean executePendingTransactions = supportFragmentManager.executePendingTransactions();
        }
        return zza2;
    }

    private static String zzi(ConnectionResult connectionResult) {
        StringBuilder sb;
        ConnectionResult connectionResult2 = connectionResult;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(connectionResult2.getErrorMessage()).append(" (").append(connectionResult2.getErrorCode()).append(": ").append(zze.getErrorString(connectionResult2.getErrorCode())).append(')').toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000c  */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.common.api.internal.zzw zzpO() {
        /*
            java.lang.String r7 = "com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0051, LinkageError -> 0x0017, SecurityException -> 0x004e }
            r6 = r7
            r7 = r6
            r1 = r7
        L_0x0009:
            r7 = r1
            if (r7 == 0) goto L_0x0042
            r7 = r1
            java.lang.Object r7 = r7.newInstance()     // Catch:{ IllegalAccessException -> 0x004b, InstantiationException -> 0x0045, ExceptionInInitializerError -> 0x0048, RuntimeException -> 0x002e }
            com.google.android.gms.common.api.internal.zzw r7 = (com.google.android.gms.common.api.internal.zzw) r7     // Catch:{ IllegalAccessException -> 0x004b, InstantiationException -> 0x0045, ExceptionInInitializerError -> 0x0048, RuntimeException -> 0x002e }
            r4 = r7
            r7 = r4
            r0 = r7
        L_0x0016:
            return r0
        L_0x0017:
            r7 = move-exception
            r0 = r7
        L_0x0019:
            java.lang.String r7 = "GmsSupportLifecycleFrag"
            r8 = 3
            boolean r7 = android.util.Log.isLoggable(r7, r8)
            if (r7 == 0) goto L_0x002b
            java.lang.String r7 = "GmsSupportLifecycleFrag"
            java.lang.String r8 = "Unable to find SupportLifecycleFragmentImpl class"
            r9 = r0
            int r7 = android.util.Log.d(r7, r8, r9)
        L_0x002b:
            r7 = 0
            r1 = r7
            goto L_0x0009
        L_0x002e:
            r7 = move-exception
            r2 = r7
        L_0x0030:
            java.lang.String r7 = "GmsSupportLifecycleFrag"
            r8 = 3
            boolean r7 = android.util.Log.isLoggable(r7, r8)
            if (r7 == 0) goto L_0x0042
            java.lang.String r7 = "GmsSupportLifecycleFrag"
            java.lang.String r8 = "Unable to instantiate SupportLifecycleFragmentImpl class"
            r9 = r2
            int r7 = android.util.Log.d(r7, r8, r9)
        L_0x0042:
            r7 = 0
            r0 = r7
            goto L_0x0016
        L_0x0045:
            r7 = move-exception
            r2 = r7
            goto L_0x0030
        L_0x0048:
            r7 = move-exception
            r2 = r7
            goto L_0x0030
        L_0x004b:
            r7 = move-exception
            r2 = r7
            goto L_0x0030
        L_0x004e:
            r7 = move-exception
            r0 = r7
            goto L_0x0019
        L_0x0051:
            r7 = move-exception
            r0 = r7
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzw.zzpO():com.google.android.gms.common.api.internal.zzw");
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        super.dump(str2, fileDescriptor2, printWriter2, strArr2);
        for (int i = 0; i < this.zzaiE.size(); i++) {
            ((zza) this.zzaiE.valueAt(i)).dump(str2, fileDescriptor2, printWriter2, strArr2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        if (zzpQ().isGooglePlayServicesAvailable(getActivity()) == 0) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r12, int r13, android.content.Intent r14) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r5 = 1
            r4 = r5
            r5 = r1
            switch(r5) {
                case 1: goto L_0x0025;
                case 2: goto L_0x0014;
                default: goto L_0x000a;
            }
        L_0x000a:
            r5 = 0
            r4 = r5
        L_0x000c:
            r5 = r4
            if (r5 == 0) goto L_0x003b
            r5 = r0
            r5.zzpP()
        L_0x0013:
            return
        L_0x0014:
            r5 = r0
            com.google.android.gms.common.zzc r5 = r5.zzpQ()
            r6 = r0
            android.support.v4.app.FragmentActivity r6 = r6.getActivity()
            int r5 = r5.isGooglePlayServicesAvailable(r6)
            if (r5 != 0) goto L_0x000a
            goto L_0x000c
        L_0x0025:
            r5 = r2
            r6 = -1
            if (r5 == r6) goto L_0x000c
            r5 = r2
            if (r5 != 0) goto L_0x000a
            r5 = r0
            com.google.android.gms.common.ConnectionResult r6 = new com.google.android.gms.common.ConnectionResult
            r10 = r6
            r6 = r10
            r7 = r10
            r8 = 13
            r9 = 0
            r7.<init>(r8, r9)
            r5.zzaiB = r6
            goto L_0x000a
        L_0x003b:
            r5 = r0
            r6 = r0
            int r6 = r6.zzaiA
            r7 = r0
            com.google.android.gms.common.ConnectionResult r7 = r7.zzaiB
            r5.zza(r6, r7)
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzw.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        ConnectionResult connectionResult;
        DialogInterface dialogInterface2 = dialogInterface;
        int i = this.zzaiA;
        ConnectionResult connectionResult2 = connectionResult;
        ConnectionResult connectionResult3 = new ConnectionResult(13, null);
        zza(i, connectionResult2);
    }

    public void onCreate(Bundle bundle) {
        ConnectionResult connectionResult;
        Bundle bundle2 = bundle;
        super.onCreate(bundle2);
        if (bundle2 != null) {
            this.zzaiz = bundle2.getBoolean("resolving_error", false);
            this.zzaiA = bundle2.getInt("failed_client_id", -1);
            if (this.zzaiA >= 0) {
                ConnectionResult connectionResult2 = connectionResult;
                ConnectionResult connectionResult3 = new ConnectionResult(bundle2.getInt("failed_status"), (PendingIntent) bundle2.getParcelable("failed_resolution"));
                this.zzaiB = connectionResult2;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle;
        super.onSaveInstanceState(bundle2);
        bundle2.putBoolean("resolving_error", this.zzaiz);
        if (this.zzaiA >= 0) {
            bundle2.putInt("failed_client_id", this.zzaiA);
            bundle2.putInt("failed_status", this.zzaiB.getErrorCode());
            bundle2.putParcelable("failed_resolution", this.zzaiB.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (!this.zzaiz) {
            for (int i = 0; i < this.zzaiE.size(); i++) {
                ((zza) this.zzaiE.valueAt(i)).zzaiG.connect();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
        for (int i = 0; i < this.zzaiE.size(); i++) {
            ((zza) this.zzaiE.valueAt(i)).zzaiG.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        StringBuilder sb;
        zza zza2;
        int i2 = i;
        GoogleApiClient googleApiClient2 = googleApiClient;
        OnConnectionFailedListener onConnectionFailedListener2 = onConnectionFailedListener;
        Object zzb2 = zzx.zzb(googleApiClient2, (Object) "GoogleApiClient instance cannot be null");
        boolean z = this.zzaiE.indexOfKey(i2) < 0;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        zzx.zza(z, (Object) sb2.append("Already managing a GoogleApiClient with id ").append(i2).toString());
        zza zza3 = zza2;
        zza zza4 = new zza(this, i2, googleApiClient2, onConnectionFailedListener2);
        this.zzaiE.put(i2, zza3);
        if (this.mStarted && !this.zzaiz) {
            googleApiClient2.connect();
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(int i, ConnectionResult connectionResult) {
        StringBuilder sb;
        int i2 = i;
        ConnectionResult connectionResult2 = connectionResult;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        int w = Log.w("GmsSupportLifecycleFrag", sb2.append("Failed to connect due to user resolvable error ").append(zzi(connectionResult2)).toString());
        zza(i2, connectionResult2);
    }

    public void zzbD(int i) {
        int i2 = i;
        zza zza2 = (zza) this.zzaiE.get(i2);
        this.zzaiE.remove(i2);
        if (zza2 != null) {
            zza2.zzpR();
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, ConnectionResult connectionResult) {
        int i2 = i;
        ConnectionResult connectionResult2 = connectionResult;
        int w = Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
        zza(i2, connectionResult2);
    }

    /* access modifiers changed from: protected */
    public void zzpP() {
        this.zzaiz = false;
        this.zzaiA = -1;
        this.zzaiB = null;
        if (this.zzaiD != null) {
            this.zzaiD.unregister();
            this.zzaiD = null;
        }
        for (int i = 0; i < this.zzaiE.size(); i++) {
            ((zza) this.zzaiE.valueAt(i)).zzaiG.connect();
        }
    }

    /* access modifiers changed from: protected */
    public zzc zzpQ() {
        return zzc.zzoK();
    }
}

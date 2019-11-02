package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.stats.zzc.zza;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zznf;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class zzb {
    private static final Object zzalX;
    private static zzb zzanp;
    private static Integer zzanv;
    private final List<String> zzanq;
    private final List<String> zzanr;
    private final List<String> zzans;
    private final List<String> zzant;
    private zze zzanu;
    private zze zzanw;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        zzalX = obj2;
    }

    private zzb() {
        zze zze;
        zze zze2;
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.zzanq = Collections.EMPTY_LIST;
            this.zzanr = Collections.EMPTY_LIST;
            this.zzans = Collections.EMPTY_LIST;
            this.zzant = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) zza.zzanA.get();
        this.zzanq = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = (String) zza.zzanB.get();
        this.zzanr = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = (String) zza.zzanC.get();
        this.zzans = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = (String) zza.zzanD.get();
        this.zzant = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        zze zze3 = zze;
        zze zze4 = new zze(1024, ((Long) zza.zzanE.get()).longValue());
        this.zzanu = zze3;
        zze zze5 = zze2;
        zze zze6 = new zze(1024, ((Long) zza.zzanE.get()).longValue());
        this.zzanw = zze5;
    }

    private static int getLogLevel() {
        if (zzanv == null) {
            try {
                zzanv = Integer.valueOf(zzmp.zzkr() ? ((Integer) zza.zzanz.get()).intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                SecurityException securityException = e;
                zzanv = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return zzanv.intValue();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        ConnectionEvent connectionEvent;
        Intent intent;
        ConnectionEvent connectionEvent2;
        ConnectionEvent connectionEvent3;
        Context context2 = context;
        String str6 = str;
        int i2 = i;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        long currentTimeMillis = System.currentTimeMillis();
        String str11 = null;
        if ((getLogLevel() & zzd.zzanJ) != 0) {
            str11 = null;
            if (i2 != 13) {
                str11 = zznf.zzn(3, 5);
            }
        }
        long j = 0;
        if ((getLogLevel() & zzd.zzanL) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i2 == 1 || i2 == 4 || i2 == 14) {
            ConnectionEvent connectionEvent4 = connectionEvent2;
            ConnectionEvent connectionEvent5 = new ConnectionEvent(currentTimeMillis, i2, null, null, null, null, str11, str6, SystemClock.elapsedRealtime(), j);
            connectionEvent = connectionEvent4;
        } else {
            ConnectionEvent connectionEvent6 = connectionEvent3;
            ConnectionEvent connectionEvent7 = new ConnectionEvent(currentTimeMillis, i2, str7, str8, str9, str10, str11, str6, SystemClock.elapsedRealtime(), j);
            connectionEvent = connectionEvent6;
        }
        Context context3 = context2;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        ComponentName startService = context3.startService(intent2.setComponent(zzd.zzanF).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        Intent intent2 = intent;
        int i2 = i;
        String str7 = null;
        if (zzrQ() && this.zzanu != null) {
            if (i2 != 4 && i2 != 1) {
                ServiceInfo zzd = zzd(context2, intent2);
                if (zzd == null) {
                    int w = Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str6, intent2.toUri(0)}));
                    return;
                }
                str3 = zzd.processName;
                str4 = zzd.name;
                str7 = zznf.zzaz(context2);
                if (zzb(str7, str6, str3, str4)) {
                    Long zzcS = this.zzanu.zzcS(str5);
                } else {
                    return;
                }
            } else if (this.zzanu.zzcT(str5)) {
                str4 = null;
                str3 = null;
            } else {
                return;
            }
            zza(context2, str5, i2, str7, str6, str3, str4);
        }
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        String str5 = str;
        String str6 = str3;
        return !this.zzanq.contains(str5) && !this.zzanr.contains(str2) && !this.zzans.contains(str6) && !this.zzant.contains(str4) && (!str6.equals(str5) || (getLogLevel() & zzd.zzanK) == 0);
    }

    private boolean zzc(Context context, Intent intent) {
        Context context2 = context;
        ComponentName component = intent.getComponent();
        if (component == null || (zzd.zzakE && "com.google.android.gms".equals(component.getPackageName()))) {
            return false;
        }
        return zzmp.zzk(context2, component.getPackageName());
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        Intent intent2 = intent;
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent2, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            int w = Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent2.toUri(0), zznf.zzn(3, 20)}));
            return null;
        }
        if (queryIntentServices.size() > 1) {
            int w2 = Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent2.toUri(0), zznf.zzn(3, 20)}));
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                int w3 = Log.w("ConnectionTracker", ((ResolveInfo) it.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    public static zzb zzrP() {
        zzb zzb;
        Object obj = zzalX;
        synchronized (obj) {
            try {
                if (zzanp == null) {
                    zzb zzb2 = zzb;
                    zzb zzb3 = new zzb();
                    zzanp = zzb2;
                }
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        return zzanp;
    }

    private boolean zzrQ() {
        return zzd.zzakE && getLogLevel() != zzd.LOG_LEVEL_OFF;
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        Context context2 = context;
        ServiceConnection serviceConnection2 = serviceConnection;
        context2.unbindService(serviceConnection2);
        zza(context2, zzb(serviceConnection2), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        Context context2 = context;
        return zza(context2, context2.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        Context context2 = context;
        String str2 = str;
        Intent intent2 = intent;
        ServiceConnection serviceConnection2 = serviceConnection;
        int i2 = i;
        if (zzc(context2, intent2)) {
            int w = Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context2.bindService(intent2, serviceConnection2, i2);
        if (bindService) {
            zza(context2, zzb(serviceConnection2), str2, intent2, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 4);
    }
}

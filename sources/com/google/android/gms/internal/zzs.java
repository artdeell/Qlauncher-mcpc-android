package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class zzs {
    public static boolean DEBUG = Log.isLoggable(TAG, 2);
    public static String TAG = "Volley";

    static class zza {
        public static final boolean zzak = zzs.DEBUG;
        private final List<C0924zza> zzal;
        private boolean zzam = false;

        /* renamed from: com.google.android.gms.internal.zzs$zza$zza reason: collision with other inner class name */
        private static class C0924zza {
            public final String name;
            public final long time;
            public final long zzan;

            public C0924zza(String str, long j, long j2) {
                long j3 = j;
                long j4 = j2;
                this.name = str;
                this.zzan = j3;
                this.time = j4;
            }
        }

        zza() {
            ArrayList arrayList;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.zzal = arrayList2;
        }

        private long zzx() {
            if (this.zzal.size() == 0) {
                return 0;
            }
            return ((C0924zza) this.zzal.get(-1 + this.zzal.size())).time - ((C0924zza) this.zzal.get(0)).time;
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.zzam) {
                zzd("Request on the loose");
                zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        /* JADX INFO: finally extract failed */
        public void zza(String str, long j) {
            C0924zza zza;
            IllegalStateException illegalStateException;
            String str2 = str;
            long j2 = j;
            synchronized (this) {
                try {
                    if (this.zzam) {
                        IllegalStateException illegalStateException2 = illegalStateException;
                        IllegalStateException illegalStateException3 = new IllegalStateException("Marker added to finished log");
                        throw illegalStateException2;
                    }
                    List<C0924zza> list = this.zzal;
                    C0924zza zza2 = zza;
                    C0924zza zza3 = new C0924zza(str2, j2, SystemClock.elapsedRealtime());
                    boolean add = list.add(zza2);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public void zzd(String str) {
            String str2 = str;
            synchronized (this) {
                try {
                    this.zzam = true;
                    long zzx = zzx();
                    if (zzx > 0) {
                        long j = ((C0924zza) this.zzal.get(0)).time;
                        zzs.zzb("(%-4d ms) %s", Long.valueOf(zzx), str2);
                        Iterator it = this.zzal.iterator();
                        long j2 = j;
                        while (true) {
                            long j3 = j2;
                            if (!it.hasNext()) {
                                break;
                            }
                            C0924zza zza = (C0924zza) it.next();
                            long j4 = zza.time;
                            zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(zza.zzan), zza.name);
                            j2 = j4;
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
    }

    public zzs() {
    }

    public static void zza(String str, Object... objArr) {
        String str2 = str;
        Object[] objArr2 = objArr;
        if (DEBUG) {
            int v = Log.v(TAG, zzd(str2, objArr2));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        int e = Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        int d = Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        int e = Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        Throwable th;
        String str2;
        StringBuilder sb;
        String str3 = str;
        Object[] objArr2 = objArr;
        if (objArr2 != null) {
            str3 = String.format(Locale.US, str3, objArr2);
        }
        Throwable th2 = th;
        Throwable th3 = new Throwable();
        StackTraceElement[] stackTrace = th2.fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(1 + className.lastIndexOf(46));
                String substring2 = substring.substring(1 + substring.lastIndexOf(36));
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                str2 = sb2.append(substring2).append(".").append(stackTrace[i].getMethodName()).toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str3});
    }
}

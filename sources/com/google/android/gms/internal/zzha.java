package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@zzhb
public class zzha implements UncaughtExceptionHandler {
    private Context mContext;
    private VersionInfoParcel zzEZ;
    private UncaughtExceptionHandler zzHe;
    private UncaughtExceptionHandler zzHf;

    public zzha(Context context, VersionInfoParcel versionInfoParcel, UncaughtExceptionHandler uncaughtExceptionHandler, UncaughtExceptionHandler uncaughtExceptionHandler2) {
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        UncaughtExceptionHandler uncaughtExceptionHandler3 = uncaughtExceptionHandler2;
        this.zzHe = uncaughtExceptionHandler;
        this.zzHf = uncaughtExceptionHandler3;
        this.mContext = context2;
        this.zzEZ = versionInfoParcel2;
    }

    private static boolean zzA(Context context) {
        Context context2 = context;
        return ((Boolean) zzbt.zzvG.get()).booleanValue();
    }

    public static zzha zza(Context context, Thread thread, VersionInfoParcel versionInfoParcel) {
        zzha zzha;
        Context context2 = context;
        Thread thread2 = thread;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        if (context2 == null || thread2 == null || versionInfoParcel2 == null) {
            return null;
        }
        if (!zzA(context2)) {
            return null;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = thread2.getUncaughtExceptionHandler();
        zzha zzha2 = zzha;
        zzha zzha3 = new zzha(context2, versionInfoParcel2, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        zzha zzha4 = zzha2;
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof zzha)) {
            return (zzha) uncaughtExceptionHandler;
        }
        try {
            thread2.setUncaughtExceptionHandler(zzha4);
            return zzha4;
        } catch (SecurityException e) {
            zzin.zzc("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private Throwable zzb(Throwable th) {
        LinkedList linkedList;
        ArrayList arrayList;
        StackTraceElement stackTraceElement;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        StackTraceElement stackTraceElement2;
        Throwable th5 = th;
        if (((Boolean) zzbt.zzvH.get()).booleanValue()) {
            return th5;
        }
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        while (th5 != null) {
            linkedList4.push(th5);
            th5 = th5.getCause();
        }
        Throwable th6 = null;
        while (true) {
            Throwable th7 = th6;
            if (linkedList4.isEmpty()) {
                return th7;
            }
            Throwable th8 = (Throwable) linkedList4.pop();
            StackTraceElement[] stackTrace = th8.getStackTrace();
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            ArrayList arrayList5 = arrayList4;
            StackTraceElement stackTraceElement3 = stackTraceElement;
            StackTraceElement stackTraceElement4 = new StackTraceElement(th8.getClass().getName(), "<filtered>", "<filtered>", 1);
            boolean add = arrayList5.add(stackTraceElement3);
            int length = stackTrace.length;
            boolean z = false;
            for (int i = 0; i < length; i++) {
                StackTraceElement stackTraceElement5 = stackTrace[i];
                if (zzat(stackTraceElement5.getClassName())) {
                    boolean add2 = arrayList4.add(stackTraceElement5);
                    z = true;
                } else if (zzau(stackTraceElement5.getClassName())) {
                    boolean add3 = arrayList4.add(stackTraceElement5);
                } else {
                    ArrayList arrayList6 = arrayList4;
                    StackTraceElement stackTraceElement6 = stackTraceElement2;
                    StackTraceElement stackTraceElement7 = new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1);
                    boolean add4 = arrayList6.add(stackTraceElement6);
                }
            }
            if (z) {
                if (th7 == null) {
                    Throwable th9 = th4;
                    Throwable th10 = new Throwable(th8.getMessage());
                    th2 = th9;
                } else {
                    Throwable th11 = th3;
                    Throwable th12 = new Throwable(th8.getMessage(), th7);
                    th2 = th11;
                }
                th2.setStackTrace((StackTraceElement[]) arrayList4.toArray(new StackTraceElement[0]));
            } else {
                th2 = th7;
            }
            th6 = th2;
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Thread thread2 = thread;
        Throwable th2 = th;
        if (zza(th2)) {
            if (Looper.getMainLooper().getThread() != thread2) {
                zza(th2, true);
                return;
            }
            zza(th2, false);
        }
        if (this.zzHe != null) {
            this.zzHe.uncaughtException(thread2, th2);
        } else if (this.zzHf != null) {
            this.zzHf.uncaughtException(thread2, th2);
        }
    }

    /* access modifiers changed from: 0000 */
    public String zza(Class cls, Throwable th, boolean z) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        Builder builder;
        Class cls2 = cls;
        Throwable th2 = th;
        boolean z2 = z;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter();
        StringWriter stringWriter4 = stringWriter2;
        Throwable th3 = th2;
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(stringWriter4);
        th3.printStackTrace(printWriter2);
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        return builder2.scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", zzr.zzbC().zzht()).appendQueryParameter("js", this.zzEZ.afmaVersion).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls2.getName()).appendQueryParameter("stacktrace", stringWriter4.toString()).appendQueryParameter("eids", TextUtils.join(",", zzbt.zzdr())).appendQueryParameter("trapped", String.valueOf(z2)).toString();
    }

    public void zza(Throwable th, boolean z) {
        ArrayList arrayList;
        Throwable th2 = th;
        boolean z2 = z;
        if (zzA(this.mContext)) {
            Throwable zzb = zzb(th2);
            if (zzb != null) {
                Class cls = th2.getClass();
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                boolean add = arrayList4.add(zza(cls, zzb, z2));
                zzr.zzbC().zza(this.mContext, this.zzEZ.afmaVersion, (List<String>) arrayList4, zzr.zzbF().zzhe());
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean zza(Throwable th) {
        Throwable th2 = th;
        boolean z = true;
        if (th2 == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th2 != null) {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (zzat(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th2 = th2.getCause();
        }
        if (!z3 || z2) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public boolean zzat(String str) {
        StringBuilder sb;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.startsWith("com.google.android.gms.ads")) {
            return true;
        }
        if (str2.startsWith("com.google.ads")) {
            return true;
        }
        try {
            return Class.forName(str2).isAnnotationPresent(zzhb.class);
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            zzin.zza(sb2.append("Fail to check class type for class ").append(str2).toString(), exc);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzau(String str) {
        String str2 = str;
        return !TextUtils.isEmpty(str2) && (str2.startsWith("android.") || str2.startsWith("java."));
    }
}

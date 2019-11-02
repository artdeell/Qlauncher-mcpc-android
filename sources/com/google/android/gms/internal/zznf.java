package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Binder;
import java.util.List;

public class zznf {
    private static String zza(StackTraceElement[] stackTraceElementArr, int i) {
        StringBuilder sb;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        int i2 = i;
        if (i2 + 4 >= stackTraceElementArr2.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr2[i2 + 4];
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    public static String zzaz(Context context) {
        return zzi(context, Binder.getCallingPid());
    }

    public static String zzi(Context context, int i) {
        int i2 = i;
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == i2) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static String zzn(int i, int i2) {
        StringBuffer stringBuffer;
        int i3 = i;
        int i4 = i2;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = stringBuffer2;
        int i5 = i4 + i3;
        while (i3 < i5) {
            StringBuffer append = stringBuffer4.append(zza(stackTrace, i3)).append(" ");
            i3++;
        }
        return stringBuffer4.toString();
    }
}

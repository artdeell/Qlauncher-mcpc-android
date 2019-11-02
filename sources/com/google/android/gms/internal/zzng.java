package com.google.android.gms.internal;

public final class zzng {
    private static int zza(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        StackTraceElement[] stackTraceElementArr3 = stackTraceElementArr;
        StackTraceElement[] stackTraceElementArr4 = stackTraceElementArr2;
        int i = 0;
        int length = stackTraceElementArr4.length;
        int length2 = stackTraceElementArr3.length;
        while (true) {
            length2--;
            if (length2 < 0) {
                break;
            }
            length--;
            if (length < 0 || !stackTraceElementArr4[length].equals(stackTraceElementArr3[length2])) {
                break;
            }
            i++;
        }
        return i;
    }

    public static String zzso() {
        StringBuilder sb;
        Throwable th;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = sb4;
        Throwable th2 = th;
        Throwable th3 = new Throwable();
        Throwable th4 = th2;
        StackTraceElement[] stackTrace = th4.getStackTrace();
        StringBuilder append = sb6.append("Async stack trace:");
        int length = stackTrace.length;
        for (int i = 0; i < length; i++) {
            StringBuilder append2 = sb6.append("\n\tat ").append(stackTrace[i]);
        }
        StackTraceElement[] stackTraceElementArr = stackTrace;
        Throwable cause = th4.getCause();
        while (cause != null) {
            StringBuilder append3 = sb6.append("\nCaused by: ");
            StringBuilder append4 = sb6.append(cause);
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            int zza = zza(stackTrace2, stackTraceElementArr);
            for (int i2 = 0; i2 < stackTrace2.length - zza; i2++) {
                StringBuilder sb7 = sb6;
                StringBuilder sb8 = sb3;
                StringBuilder sb9 = new StringBuilder();
                StringBuilder append5 = sb7.append(sb8.append("\n\tat ").append(stackTrace2[i2]).toString());
            }
            if (zza > 0) {
                StringBuilder sb10 = sb6;
                StringBuilder sb11 = sb2;
                StringBuilder sb12 = new StringBuilder();
                StringBuilder append6 = sb10.append(sb11.append("\n\t... ").append(zza).append(" more").toString());
            }
            cause = cause.getCause();
            stackTraceElementArr = stackTrace2;
        }
        return sb6.toString();
    }
}

package com.google.android.gms.common.stats;

public abstract class zzf {
    public zzf() {
    }

    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getTimeMillis()).append("\t").append(getEventType()).append("\t").append(zzrL()).append(zzrO()).toString();
    }

    public abstract long zzrL();

    public abstract String zzrO();
}

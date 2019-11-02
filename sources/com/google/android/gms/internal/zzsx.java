package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsx {
    public static final boolean[] zzbuA = new boolean[0];
    public static final String[] zzbuB = new String[0];
    public static final byte[][] zzbuC = new byte[0][];
    public static final byte[] zzbuD = new byte[0];
    public static final int[] zzbuw = new int[0];
    public static final long[] zzbux = new long[0];
    public static final float[] zzbuy = new float[0];
    public static final double[] zzbuz = new double[0];

    static int zzF(int i, int i2) {
        return i2 | (i << 3);
    }

    public static boolean zzb(zzsm zzsm, int i) throws IOException {
        return zzsm.zzmo(i);
    }

    public static final int zzc(zzsm zzsm, int i) throws IOException {
        zzsm zzsm2 = zzsm;
        int i2 = i;
        int i3 = 1;
        int position = zzsm2.getPosition();
        boolean zzmo = zzsm2.zzmo(i2);
        while (zzsm2.zzIX() == i2) {
            boolean zzmo2 = zzsm2.zzmo(i2);
            i3++;
        }
        zzsm2.zzms(position);
        return i3;
    }

    static int zzmI(int i) {
        return i & 7;
    }

    public static int zzmJ(int i) {
        return i >>> 3;
    }
}

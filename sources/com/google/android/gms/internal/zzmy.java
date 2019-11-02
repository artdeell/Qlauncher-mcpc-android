package com.google.android.gms.internal;

public final class zzmy {
    public static String zza(byte[] bArr, int i, int i2, boolean z) {
        StringBuilder sb;
        int i3;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        boolean z2 = z;
        if (bArr2 == null || bArr2.length == 0 || i4 < 0 || i5 <= 0 || i4 + i5 > bArr2.length) {
            return null;
        }
        int i6 = 57;
        if (z2) {
            i6 = 75;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(i6 * ((-1 + (i5 + 16)) / 16));
        StringBuilder sb4 = sb2;
        int i7 = i4;
        int i8 = i5;
        int i9 = 0;
        int i10 = 0;
        while (i8 > 0) {
            if (i10 == 0) {
                if (i5 < 65536) {
                    StringBuilder append = sb4.append(String.format("%04X:", new Object[]{Integer.valueOf(i7)}));
                    i9 = i7;
                } else {
                    StringBuilder append2 = sb4.append(String.format("%08X:", new Object[]{Integer.valueOf(i7)}));
                    i9 = i7;
                }
            } else if (i10 == 8) {
                StringBuilder append3 = sb4.append(" -");
            }
            StringBuilder append4 = sb4.append(String.format(" %02X", new Object[]{Integer.valueOf(255 & bArr2[i7])}));
            int i11 = i8 - 1;
            int i12 = i10 + 1;
            if (z2 && (i12 == 16 || i11 == 0)) {
                int i13 = 16 - i12;
                if (i13 > 0) {
                    for (int i14 = 0; i14 < i13; i14++) {
                        StringBuilder append5 = sb4.append("   ");
                    }
                }
                if (i13 >= 8) {
                    StringBuilder append6 = sb4.append("  ");
                }
                StringBuilder append7 = sb4.append("  ");
                for (int i15 = 0; i15 < i12; i15++) {
                    char c = (char) bArr2[i9 + i15];
                    if (c < ' ' || c > '~') {
                        c = '.';
                    }
                    StringBuilder append8 = sb4.append(c);
                }
            }
            if (i12 == 16 || i11 == 0) {
                StringBuilder append9 = sb4.append(10);
                i3 = 0;
            } else {
                i3 = i12;
            }
            i7++;
            i10 = i3;
            i8 = i11;
        }
        return sb4.toString();
    }
}

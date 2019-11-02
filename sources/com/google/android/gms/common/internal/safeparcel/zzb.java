package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class zzb {
    private static int zzG(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        parcel2.writeInt(-65536 | i);
        parcel2.writeInt(0);
        return parcel2.dataPosition();
    }

    private static void zzH(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int dataPosition = parcel2.dataPosition();
        int i3 = dataPosition - i2;
        parcel2.setDataPosition(i2 - 4);
        parcel2.writeInt(i3);
        parcel2.setDataPosition(dataPosition);
    }

    public static void zzI(Parcel parcel, int i) {
        zzH(parcel, i);
    }

    public static void zza(Parcel parcel, int i, byte b) {
        Parcel parcel2 = parcel;
        byte b2 = b;
        zzb(parcel2, i, 4);
        parcel2.writeInt(b2);
    }

    public static void zza(Parcel parcel, int i, double d) {
        Parcel parcel2 = parcel;
        double d2 = d;
        zzb(parcel2, i, 8);
        parcel2.writeDouble(d2);
    }

    public static void zza(Parcel parcel, int i, float f) {
        Parcel parcel2 = parcel;
        float f2 = f;
        zzb(parcel2, i, 4);
        parcel2.writeFloat(f2);
    }

    public static void zza(Parcel parcel, int i, long j) {
        Parcel parcel2 = parcel;
        long j2 = j;
        zzb(parcel2, i, 8);
        parcel2.writeLong(j2);
    }

    public static void zza(Parcel parcel, int i, Bundle bundle, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        Bundle bundle2 = bundle;
        boolean z2 = z;
        if (bundle2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeBundle(bundle2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, IBinder iBinder, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        IBinder iBinder2 = iBinder;
        boolean z2 = z;
        if (iBinder2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeStrongBinder(iBinder2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Parcel parcel2, boolean z) {
        Parcel parcel3 = parcel;
        int i2 = i;
        Parcel parcel4 = parcel2;
        boolean z2 = z;
        if (parcel4 != null) {
            int zzG = zzG(parcel3, i2);
            parcel3.appendFrom(parcel4, 0, parcel4.dataSize());
            zzH(parcel3, zzG);
        } else if (z2) {
            zzb(parcel3, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        Parcel parcel2 = parcel;
        int i3 = i;
        Parcelable parcelable2 = parcelable;
        int i4 = i2;
        boolean z2 = z;
        if (parcelable2 != null) {
            int zzG = zzG(parcel2, i3);
            parcelable2.writeToParcel(parcel2, i4);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i3, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Boolean bool, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        Boolean bool2 = bool;
        boolean z2 = z;
        if (bool2 != null) {
            zzb(parcel2, i2, 4);
            int i3 = 0;
            if (bool2.booleanValue()) {
                i3 = 1;
            }
            parcel2.writeInt(i3);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Float f, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        Float f2 = f;
        boolean z2 = z;
        if (f2 != null) {
            zzb(parcel2, i2, 4);
            parcel2.writeFloat(f2.floatValue());
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Integer num, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        Integer num2 = num;
        boolean z2 = z;
        if (num2 != null) {
            zzb(parcel2, i2, 4);
            parcel2.writeInt(num2.intValue());
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, Long l, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        Long l2 = l;
        boolean z2 = z;
        if (l2 != null) {
            zzb(parcel2, i2, 8);
            parcel2.writeLong(l2.longValue());
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, String str, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        String str2 = str;
        boolean z2 = z;
        if (str2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeString(str2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, List<Integer> list, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        List<Integer> list2 = list;
        boolean z2 = z;
        if (list2 != null) {
            int zzG = zzG(parcel2, i2);
            int size = list2.size();
            parcel2.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel2.writeInt(((Integer) list2.get(i3)).intValue());
            }
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, short s) {
        Parcel parcel2 = parcel;
        short s2 = s;
        zzb(parcel2, i, 4);
        parcel2.writeInt(s2);
    }

    public static void zza(Parcel parcel, int i, boolean z) {
        Parcel parcel2 = parcel;
        boolean z2 = z;
        zzb(parcel2, i, 4);
        parcel2.writeInt(z2 ? 1 : 0);
    }

    public static void zza(Parcel parcel, int i, byte[] bArr, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        byte[] bArr2 = bArr;
        boolean z2 = z;
        if (bArr2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeByteArray(bArr2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, float[] fArr, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        float[] fArr2 = fArr;
        boolean z2 = z;
        if (fArr2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeFloatArray(fArr2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, int[] iArr, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int[] iArr2 = iArr;
        boolean z2 = z;
        if (iArr2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeIntArray(iArr2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static <T extends Parcelable> void zza(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        Parcel parcel2 = parcel;
        int i3 = i;
        T[] tArr2 = tArr;
        int i4 = i2;
        boolean z2 = z;
        if (tArr2 != null) {
            int zzG = zzG(parcel2, i3);
            int length = tArr2.length;
            parcel2.writeInt(length);
            for (int i5 = 0; i5 < length; i5++) {
                T t = tArr2[i5];
                if (t == null) {
                    parcel2.writeInt(0);
                } else {
                    zza(parcel2, t, i4);
                }
            }
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i3, 0);
        }
    }

    public static void zza(Parcel parcel, int i, String[] strArr, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        String[] strArr2 = strArr;
        boolean z2 = z;
        if (strArr2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeStringArray(strArr2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, boolean[] zArr, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        boolean[] zArr2 = zArr;
        boolean z2 = z;
        if (zArr2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeBooleanArray(zArr2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zza(Parcel parcel, int i, byte[][] bArr, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        byte[][] bArr2 = bArr;
        boolean z2 = z;
        if (bArr2 != null) {
            int zzG = zzG(parcel2, i2);
            int length = bArr2.length;
            parcel2.writeInt(length);
            for (int i3 = 0; i3 < length; i3++) {
                parcel2.writeByteArray(bArr2[i3]);
            }
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    private static <T extends Parcelable> void zza(Parcel parcel, T t, int i) {
        Parcel parcel2 = parcel;
        T t2 = t;
        int i2 = i;
        int dataPosition = parcel2.dataPosition();
        parcel2.writeInt(1);
        int dataPosition2 = parcel2.dataPosition();
        t2.writeToParcel(parcel2, i2);
        int dataPosition3 = parcel2.dataPosition();
        parcel2.setDataPosition(dataPosition);
        parcel2.writeInt(dataPosition3 - dataPosition2);
        parcel2.setDataPosition(dataPosition3);
    }

    public static int zzav(Parcel parcel) {
        return zzG(parcel, 20293);
    }

    private static void zzb(Parcel parcel, int i, int i2) {
        Parcel parcel2 = parcel;
        int i3 = i;
        int i4 = i2;
        if (i4 >= 65535) {
            parcel2.writeInt(-65536 | i3);
            parcel2.writeInt(i4);
            return;
        }
        parcel2.writeInt(i3 | (i4 << 16));
    }

    public static void zzb(Parcel parcel, int i, List<String> list, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        List<String> list2 = list;
        boolean z2 = z;
        if (list2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeStringList(list2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        Parcel parcel2 = parcel;
        int i3 = i2;
        zzb(parcel2, i, 4);
        parcel2.writeInt(i3);
    }

    public static <T extends Parcelable> void zzc(Parcel parcel, int i, List<T> list, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        List<T> list2 = list;
        boolean z2 = z;
        if (list2 != null) {
            int zzG = zzG(parcel2, i2);
            int size = list2.size();
            parcel2.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcelable parcelable = (Parcelable) list2.get(i3);
                if (parcelable == null) {
                    parcel2.writeInt(0);
                } else {
                    zza(parcel2, (T) parcelable, 0);
                }
            }
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }

    public static void zzd(Parcel parcel, int i, List list, boolean z) {
        Parcel parcel2 = parcel;
        int i2 = i;
        List list2 = list;
        boolean z2 = z;
        if (list2 != null) {
            int zzG = zzG(parcel2, i2);
            parcel2.writeList(list2);
            zzH(parcel2, zzG);
        } else if (z2) {
            zzb(parcel2, i2, 0);
        }
    }
}

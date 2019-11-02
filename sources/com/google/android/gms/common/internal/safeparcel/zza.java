package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class zza {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.zza$zza reason: collision with other inner class name */
    public static class C0881zza extends RuntimeException {
        public C0881zza(String str, Parcel parcel) {
            StringBuilder sb;
            String str2 = str;
            Parcel parcel2 = parcel;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            super(sb2.append(str2).append(" Parcel: pos=").append(parcel2.dataPosition()).append(" size=").append(parcel2.dataSize()).toString());
        }
    }

    public static BigDecimal[] zzA(Parcel parcel, int i) {
        BigDecimal bigDecimal;
        BigInteger bigInteger;
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        int readInt = parcel2.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel2.createByteArray();
            int readInt2 = parcel2.readInt();
            BigDecimal[] bigDecimalArr2 = bigDecimalArr;
            int i3 = i2;
            BigDecimal bigDecimal2 = bigDecimal;
            BigInteger bigInteger2 = bigInteger;
            BigInteger bigInteger3 = new BigInteger(createByteArray);
            BigDecimal bigDecimal3 = new BigDecimal(bigInteger2, readInt2);
            bigDecimalArr2[i3] = bigDecimal2;
        }
        parcel2.setDataPosition(dataPosition + zza);
        return bigDecimalArr;
    }

    public static String[] zzB(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        String[] createStringArray = parcel2.createStringArray();
        parcel2.setDataPosition(zza + dataPosition);
        return createStringArray;
    }

    public static ArrayList<Integer> zzC(Parcel parcel, int i) {
        ArrayList arrayList;
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        int readInt = parcel2.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            boolean add = arrayList4.add(Integer.valueOf(parcel2.readInt()));
        }
        parcel2.setDataPosition(dataPosition + zza);
        return arrayList4;
    }

    public static ArrayList<String> zzD(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        ArrayList createStringArrayList = parcel2.createStringArrayList();
        parcel2.setDataPosition(zza + dataPosition);
        return createStringArrayList;
    }

    public static Parcel zzE(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel2, dataPosition, zza);
        parcel2.setDataPosition(zza + dataPosition);
        return obtain;
    }

    public static Parcel[] zzF(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        int readInt = parcel2.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel2.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel2.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel2, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel2.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel2.setDataPosition(dataPosition + zza);
        return parcelArr;
    }

    public static int zza(Parcel parcel, int i) {
        int i2 = i;
        return (i2 & SupportMenu.CATEGORY_MASK) != -65536 ? 65535 & (i2 >> 16) : parcel.readInt();
    }

    public static <T extends Parcelable> T zza(Parcel parcel, int i, Creator<T> creator) {
        Parcel parcel2 = parcel;
        Creator<T> creator2 = creator;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator2.createFromParcel(parcel2);
        parcel2.setDataPosition(zza + dataPosition);
        return parcelable;
    }

    private static void zza(Parcel parcel, int i, int i2) {
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int i3 = i2;
        int zza2 = zza(parcel2, i);
        if (zza2 != i3) {
            C0881zza zza3 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza4 = new C0881zza(sb2.append("Expected size ").append(i3).append(" got ").append(zza2).append(" (0x").append(Integer.toHexString(zza2)).append(")").toString(), parcel2);
            throw zza3;
        }
    }

    private static void zza(Parcel parcel, int i, int i2, int i3) {
        C0881zza zza;
        StringBuilder sb;
        Parcel parcel2 = parcel;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (i5 != i6) {
            C0881zza zza2 = zza;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            C0881zza zza3 = new C0881zza(sb2.append("Expected size ").append(i6).append(" got ").append(i5).append(" (0x").append(Integer.toHexString(i5)).append(")").toString(), parcel2);
            throw zza2;
        }
    }

    public static void zza(Parcel parcel, int i, List list, ClassLoader classLoader) {
        Parcel parcel2 = parcel;
        List list2 = list;
        ClassLoader classLoader2 = classLoader;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza != 0) {
            parcel2.readList(list2, classLoader2);
            parcel2.setDataPosition(zza + dataPosition);
        }
    }

    public static int zzat(Parcel parcel) {
        return parcel.readInt();
    }

    public static int zzau(Parcel parcel) {
        C0881zza zza;
        StringBuilder sb;
        C0881zza zza2;
        StringBuilder sb2;
        Parcel parcel2 = parcel;
        int zzat = zzat(parcel2);
        int zza3 = zza(parcel2, zzat);
        int dataPosition = parcel2.dataPosition();
        if (zzca(zzat) != 20293) {
            C0881zza zza4 = zza2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            C0881zza zza5 = new C0881zza(sb3.append("Expected object header. Got 0x").append(Integer.toHexString(zzat)).toString(), parcel2);
            throw zza4;
        }
        int i = dataPosition + zza3;
        if (i >= dataPosition && i <= parcel2.dataSize()) {
            return i;
        }
        C0881zza zza6 = zza;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        C0881zza zza7 = new C0881zza(sb5.append("Size read is invalid start=").append(dataPosition).append(" end=").append(i).toString(), parcel2);
        throw zza6;
    }

    public static void zzb(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        parcel2.setDataPosition(zza(parcel2, i) + parcel2.dataPosition());
    }

    public static <T> T[] zzb(Parcel parcel, int i, Creator<T> creator) {
        Parcel parcel2 = parcel;
        Creator<T> creator2 = creator;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        Object[] createTypedArray = parcel2.createTypedArray(creator2);
        parcel2.setDataPosition(zza + dataPosition);
        return createTypedArray;
    }

    public static <T> ArrayList<T> zzc(Parcel parcel, int i, Creator<T> creator) {
        Parcel parcel2 = parcel;
        Creator<T> creator2 = creator;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel2.createTypedArrayList(creator2);
        parcel2.setDataPosition(zza + dataPosition);
        return createTypedArrayList;
    }

    public static boolean zzc(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        zza(parcel2, i, 4);
        return parcel2.readInt() != 0;
    }

    public static int zzca(int i) {
        return 65535 & i;
    }

    public static Boolean zzd(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int zza = zza(parcel2, i2);
        if (zza == 0) {
            return null;
        }
        zza(parcel2, i2, zza, 4);
        return Boolean.valueOf(parcel2.readInt() != 0);
    }

    public static byte zze(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        zza(parcel2, i, 4);
        return (byte) parcel2.readInt();
    }

    public static short zzf(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        zza(parcel2, i, 4);
        return (short) parcel2.readInt();
    }

    public static int zzg(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        zza(parcel2, i, 4);
        return parcel2.readInt();
    }

    public static Integer zzh(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int zza = zza(parcel2, i2);
        if (zza == 0) {
            return null;
        }
        zza(parcel2, i2, zza, 4);
        return Integer.valueOf(parcel2.readInt());
    }

    public static long zzi(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        zza(parcel2, i, 8);
        return parcel2.readLong();
    }

    public static Long zzj(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int zza = zza(parcel2, i2);
        if (zza == 0) {
            return null;
        }
        zza(parcel2, i2, zza, 8);
        return Long.valueOf(parcel2.readLong());
    }

    public static BigInteger zzk(Parcel parcel, int i) {
        BigInteger bigInteger;
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        byte[] createByteArray = parcel2.createByteArray();
        parcel2.setDataPosition(zza + dataPosition);
        BigInteger bigInteger2 = bigInteger;
        BigInteger bigInteger3 = new BigInteger(createByteArray);
        return bigInteger2;
    }

    public static float zzl(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        zza(parcel2, i, 4);
        return parcel2.readFloat();
    }

    public static Float zzm(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int zza = zza(parcel2, i2);
        if (zza == 0) {
            return null;
        }
        zza(parcel2, i2, zza, 4);
        return Float.valueOf(parcel2.readFloat());
    }

    public static double zzn(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        zza(parcel2, i, 8);
        return parcel2.readDouble();
    }

    public static BigDecimal zzo(Parcel parcel, int i) {
        BigDecimal bigDecimal;
        BigInteger bigInteger;
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        byte[] createByteArray = parcel2.createByteArray();
        int readInt = parcel2.readInt();
        parcel2.setDataPosition(zza + dataPosition);
        BigDecimal bigDecimal2 = bigDecimal;
        BigInteger bigInteger2 = bigInteger;
        BigInteger bigInteger3 = new BigInteger(createByteArray);
        BigDecimal bigDecimal3 = new BigDecimal(bigInteger2, readInt);
        return bigDecimal2;
    }

    public static String zzp(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        String readString = parcel2.readString();
        parcel2.setDataPosition(zza + dataPosition);
        return readString;
    }

    public static IBinder zzq(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel2.readStrongBinder();
        parcel2.setDataPosition(zza + dataPosition);
        return readStrongBinder;
    }

    public static Bundle zzr(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        Bundle readBundle = parcel2.readBundle();
        parcel2.setDataPosition(zza + dataPosition);
        return readBundle;
    }

    public static byte[] zzs(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        byte[] createByteArray = parcel2.createByteArray();
        parcel2.setDataPosition(zza + dataPosition);
        return createByteArray;
    }

    public static byte[][] zzt(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        int readInt = parcel2.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel2.createByteArray();
        }
        parcel2.setDataPosition(dataPosition + zza);
        return bArr;
    }

    public static boolean[] zzu(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel2.createBooleanArray();
        parcel2.setDataPosition(zza + dataPosition);
        return createBooleanArray;
    }

    public static int[] zzv(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        int[] createIntArray = parcel2.createIntArray();
        parcel2.setDataPosition(zza + dataPosition);
        return createIntArray;
    }

    public static long[] zzw(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        long[] createLongArray = parcel2.createLongArray();
        parcel2.setDataPosition(zza + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] zzx(Parcel parcel, int i) {
        BigInteger bigInteger;
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        int readInt = parcel2.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            BigInteger[] bigIntegerArr2 = bigIntegerArr;
            int i3 = i2;
            BigInteger bigInteger2 = bigInteger;
            BigInteger bigInteger3 = new BigInteger(parcel2.createByteArray());
            bigIntegerArr2[i3] = bigInteger2;
        }
        parcel2.setDataPosition(dataPosition + zza);
        return bigIntegerArr;
    }

    public static float[] zzy(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        float[] createFloatArray = parcel2.createFloatArray();
        parcel2.setDataPosition(zza + dataPosition);
        return createFloatArray;
    }

    public static double[] zzz(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int zza = zza(parcel2, i);
        int dataPosition = parcel2.dataPosition();
        if (zza == 0) {
            return null;
        }
        double[] createDoubleArray = parcel2.createDoubleArray();
        parcel2.setDataPosition(zza + dataPosition);
        return createDoubleArray;
    }
}

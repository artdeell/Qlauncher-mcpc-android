package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzpk extends IInterface {

    public static abstract class zza extends Binder implements zzpk {

        /* renamed from: com.google.android.gms.internal.zzpk$zza$zza reason: collision with other inner class name */
        private static class C0923zza implements zzpk {
            private IBinder zzoz;

            C0923zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
                String str2 = str;
                boolean z2 = z;
                int i2 = i;
                boolean z3 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str2);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(i2);
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z3 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z3;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public int getIntFlagValue(String str, int i, int i2) throws RemoteException {
                String str2 = str;
                int i3 = i;
                int i4 = i2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public long getLongFlagValue(String str, long j, int i) throws RemoteException {
                String str2 = str;
                long j2 = j;
                int i2 = i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str2);
                    obtain.writeLong(j2);
                    obtain.writeInt(i2);
                    boolean transact = this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    return readLong;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public String getStringFlagValue(String str, String str2, int i) throws RemoteException {
                String str3 = str;
                String str4 = str2;
                int i2 = i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    obtain.writeInt(i2);
                    boolean transact = this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public void init(zzd zzd) throws RemoteException {
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
        }

        public static zzpk asInterface(IBinder iBinder) {
            C0923zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzpk)) {
                return (zzpk) queryLocalInterface;
            }
            C0923zza zza2 = zza;
            C0923zza zza3 = new C0923zza(iBinder2);
            return zza2;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    init(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    boolean booleanFlagValue = getBooleanFlagValue(parcel3.readString(), parcel3.readInt() != 0, parcel3.readInt());
                    parcel4.writeNoException();
                    int i5 = 0;
                    if (booleanFlagValue) {
                        i5 = 1;
                    }
                    parcel4.writeInt(i5);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    int intFlagValue = getIntFlagValue(parcel3.readString(), parcel3.readInt(), parcel3.readInt());
                    parcel4.writeNoException();
                    parcel4.writeInt(intFlagValue);
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    long longFlagValue = getLongFlagValue(parcel3.readString(), parcel3.readLong(), parcel3.readInt());
                    parcel4.writeNoException();
                    parcel4.writeLong(longFlagValue);
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    String stringFlagValue = getStringFlagValue(parcel3.readString(), parcel3.readString(), parcel3.readInt());
                    parcel4.writeNoException();
                    parcel4.writeString(stringFlagValue);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.flags.IFlagProvider");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException;

    int getIntFlagValue(String str, int i, int i2) throws RemoteException;

    long getLongFlagValue(String str, long j, int i) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i) throws RemoteException;

    void init(zzd zzd) throws RemoteException;
}

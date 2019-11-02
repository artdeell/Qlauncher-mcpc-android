package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzex;

public interface zzv extends IInterface {

    public static abstract class zza extends Binder implements zzv {

        /* renamed from: com.google.android.gms.ads.internal.client.zzv$zza$zza reason: collision with other inner class name */
        private static class C0862zza implements zzv {
            private IBinder zzoz;

            C0862zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            /* JADX INFO: finally extract failed */
            public IBinder zza(zzd zzd, AdSizeParcel adSizeParcel, String str, zzex zzex, int i) throws RemoteException {
                zzd zzd2 = zzd;
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                String str2 = str;
                zzex zzex2 = zzex;
                int i2 = i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adSizeParcel2 != null) {
                        obtain.writeInt(1);
                        adSizeParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    IBinder iBinder = null;
                    if (zzex2 != null) {
                        iBinder = zzex2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i2);
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    obtain2.recycle();
                    obtain.recycle();
                    return readStrongBinder;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public IBinder zza(zzd zzd, AdSizeParcel adSizeParcel, String str, zzex zzex, int i, int i2) throws RemoteException {
                zzd zzd2 = zzd;
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                String str2 = str;
                zzex zzex2 = zzex;
                int i3 = i;
                int i4 = i2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adSizeParcel2 != null) {
                        obtain.writeInt(1);
                        adSizeParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    IBinder iBinder = null;
                    if (zzex2 != null) {
                        iBinder = zzex2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    obtain2.recycle();
                    obtain.recycle();
                    return readStrongBinder;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public static zzv zzl(IBinder iBinder) {
            C0862zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzv)) {
                return (zzv) queryLocalInterface;
            }
            C0862zza zza2 = zza;
            C0862zza zza3 = new C0862zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    zzd zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder());
                    AdSizeParcel adSizeParcel = null;
                    if (parcel3.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.createFromParcel(parcel3);
                    }
                    IBinder zza = zza(zzbs, adSizeParcel, parcel3.readString(), com.google.android.gms.internal.zzex.zza.zzE(parcel3.readStrongBinder()), parcel3.readInt());
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zza);
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    zzd zzbs2 = com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder());
                    AdSizeParcel adSizeParcel2 = null;
                    if (parcel3.readInt() != 0) {
                        adSizeParcel2 = AdSizeParcel.CREATOR.createFromParcel(parcel3);
                    }
                    IBinder zza2 = zza(zzbs2, adSizeParcel2, parcel3.readString(), com.google.android.gms.internal.zzex.zza.zzE(parcel3.readStrongBinder()), parcel3.readInt(), parcel3.readInt());
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zza2);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    IBinder zza(zzd zzd, AdSizeParcel adSizeParcel, String str, zzex zzex, int i) throws RemoteException;

    IBinder zza(zzd zzd, AdSizeParcel adSizeParcel, String str, zzex zzex, int i, int i2) throws RemoteException;
}

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzck extends IInterface {

    public static abstract class zza extends Binder implements zzck {

        /* renamed from: com.google.android.gms.internal.zzck$zza$zza reason: collision with other inner class name */
        private static class C0897zza implements zzck {
            private IBinder zzoz;

            C0897zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            /* JADX INFO: finally extract failed */
            public IBinder zza(zzd zzd, zzd zzd2, zzd zzd3, int i) throws RemoteException {
                zzd zzd4 = zzd;
                zzd zzd5 = zzd2;
                zzd zzd6 = zzd3;
                int i2 = i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    obtain.writeStrongBinder(zzd4 != null ? zzd4.asBinder() : null);
                    obtain.writeStrongBinder(zzd5 != null ? zzd5.asBinder() : null);
                    IBinder iBinder = null;
                    if (zzd6 != null) {
                        iBinder = zzd6.asBinder();
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
        }

        public static zzck zzv(IBinder iBinder) {
            C0897zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzck)) {
                return (zzck) queryLocalInterface;
            }
            C0897zza zza2 = zza;
            C0897zza zza3 = new C0897zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    IBinder zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), parcel3.readInt());
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zza);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    IBinder zza(zzd zzd, zzd zzd2, zzd zzd3, int i) throws RemoteException;
}

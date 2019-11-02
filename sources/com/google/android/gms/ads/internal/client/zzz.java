package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzz extends IInterface {

    public static abstract class zza extends Binder implements zzz {

        /* renamed from: com.google.android.gms.ads.internal.client.zzz$zza$zza reason: collision with other inner class name */
        private static class C0866zza implements zzz {
            private IBinder zzoz;

            C0866zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            /* JADX INFO: finally extract failed */
            public IBinder zza(zzd zzd, int i) throws RemoteException {
                zzd zzd2 = zzd;
                int i2 = i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

        public static zzz zzp(IBinder iBinder) {
            C0866zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzz)) {
                return (zzz) queryLocalInterface;
            }
            C0866zza zza2 = zza;
            C0866zza zza3 = new C0866zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                    IBinder zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), parcel3.readInt());
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zza);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    IBinder zza(zzd zzd, int i) throws RemoteException;
}

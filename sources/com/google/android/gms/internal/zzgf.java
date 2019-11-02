package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzgf extends IInterface {

    public static abstract class zza extends Binder implements zzgf {

        /* renamed from: com.google.android.gms.internal.zzgf$zza$zza reason: collision with other inner class name */
        private static class C0916zza implements zzgf {
            private IBinder zzoz;

            C0916zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            /* JADX INFO: finally extract failed */
            public IBinder zzf(zzd zzd) throws RemoteException {
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

        public static zzgf zzR(IBinder iBinder) {
            C0916zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzgf)) {
                return (zzgf) queryLocalInterface;
            }
            C0916zza zza2 = zza;
            C0916zza zza3 = new C0916zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    IBinder zzf = zzf(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zzf);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    IBinder zzf(zzd zzd) throws RemoteException;
}

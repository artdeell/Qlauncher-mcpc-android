package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzj extends IInterface {

    public static abstract class zza extends Binder implements zzj {

        /* renamed from: com.google.android.gms.ads.internal.request.zzj$zza$zza reason: collision with other inner class name */
        private static class C0869zza implements zzj {
            private IBinder zzoz;

            C0869zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(AdRequestInfoParcel adRequestInfoParcel, zzk zzk) throws RemoteException {
                AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
                zzk zzk2 = zzk;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzk2 != null ? zzk2.asBinder() : null);
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
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

            public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) throws RemoteException {
                AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    AdResponseParcel adResponseParcel = obtain2.readInt() != 0 ? AdResponseParcel.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return adResponseParcel;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static zzj zzX(IBinder iBinder) {
            C0869zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzj)) {
                return (zzj) queryLocalInterface;
            }
            C0869zza zza2 = zza;
            C0869zza zza3 = new C0869zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    AdRequestInfoParcel adRequestInfoParcel = null;
                    if (parcel3.readInt() != 0) {
                        adRequestInfoParcel = AdRequestInfoParcel.CREATOR.createFromParcel(parcel3);
                    }
                    AdResponseParcel zzd = zzd(adRequestInfoParcel);
                    parcel4.writeNoException();
                    if (zzd != null) {
                        parcel4.writeInt(1);
                        zzd.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    AdRequestInfoParcel adRequestInfoParcel2 = null;
                    if (parcel3.readInt() != 0) {
                        adRequestInfoParcel2 = AdRequestInfoParcel.CREATOR.createFromParcel(parcel3);
                    }
                    zza(adRequestInfoParcel2, com.google.android.gms.ads.internal.request.zzk.zza.zzY(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zza(AdRequestInfoParcel adRequestInfoParcel, zzk zzk) throws RemoteException;

    AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) throws RemoteException;
}

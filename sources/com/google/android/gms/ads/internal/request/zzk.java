package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzk extends IInterface {

    public static abstract class zza extends Binder implements zzk {

        /* renamed from: com.google.android.gms.ads.internal.request.zzk$zza$zza reason: collision with other inner class name */
        private static class C0870zza implements zzk {
            private IBinder zzoz;

            C0870zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zzb(AdResponseParcel adResponseParcel) throws RemoteException {
                AdResponseParcel adResponseParcel2 = adResponseParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (adResponseParcel2 != null) {
                        obtain.writeInt(1);
                        adResponseParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdResponseListener");
        }

        public static zzk zzY(IBinder iBinder) {
            C0870zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzk)) {
                return (zzk) queryLocalInterface;
            }
            C0870zza zza2 = zza;
            C0870zza zza3 = new C0870zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    zzb(parcel3.readInt() != 0 ? AdResponseParcel.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zzb(AdResponseParcel adResponseParcel) throws RemoteException;
}

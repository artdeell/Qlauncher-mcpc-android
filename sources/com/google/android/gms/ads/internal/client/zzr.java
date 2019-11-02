package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzr extends IInterface {

    public static abstract class zza extends Binder implements zzr {

        /* renamed from: com.google.android.gms.ads.internal.client.zzr$zza$zza reason: collision with other inner class name */
        private static class C0858zza implements zzr {
            private IBinder zzoz;

            C0858zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            /* JADX INFO: finally extract failed */
            public String getMediationAdapterClassName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
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

            public boolean isLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    boolean z = false;
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public void zzf(AdRequestParcel adRequestParcel) throws RemoteException {
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
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
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
        }

        public static zzr zzh(IBinder iBinder) {
            C0858zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzr)) {
                return (zzr) queryLocalInterface;
            }
            C0858zza zza2 = zza;
            C0858zza zza3 = new C0858zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    zzf(parcel3.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    parcel4.writeNoException();
                    parcel4.writeString(mediationAdapterClassName);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean isLoading = isLoading();
                    parcel4.writeNoException();
                    parcel4.writeInt(isLoading ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.client.IAdLoader");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    void zzf(AdRequestParcel adRequestParcel) throws RemoteException;
}

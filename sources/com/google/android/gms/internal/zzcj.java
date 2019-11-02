package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzcj extends IInterface {

    public static abstract class zza extends Binder implements zzcj {

        /* renamed from: com.google.android.gms.internal.zzcj$zza$zza reason: collision with other inner class name */
        private static class C0896zza implements zzcj {
            private IBinder zzoz;

            C0896zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    boolean transact = this.zzoz.transact(4, obtain, obtain2, 0);
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

            /* JADX INFO: finally extract failed */
            public zzd zzK(String str) throws RemoteException {
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return zzbs;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public void zza(zzd zzd) throws RemoteException {
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
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

            public void zza(String str, zzd zzd) throws RemoteException {
                String str2 = str;
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    obtain.writeString(str2);
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
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        }

        public static zzcj zzu(IBinder iBinder) {
            C0896zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzcj)) {
                return (zzcj) queryLocalInterface;
            }
            C0896zza zza2 = zza;
            C0896zza zza3 = new C0896zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    zza(parcel3.readString(), com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    zzd zzK = zzK(parcel3.readString());
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zzK != null ? zzK.asBinder() : null);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    destroy();
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void destroy() throws RemoteException;

    zzd zzK(String str) throws RemoteException;

    void zza(zzd zzd) throws RemoteException;

    void zza(String str, zzd zzd) throws RemoteException;
}

package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzq extends IInterface {

    public static abstract class zza extends Binder implements zzq {

        /* renamed from: com.google.android.gms.common.internal.zzq$zza$zza reason: collision with other inner class name */
        private static class C0883zza implements zzq {
            private IBinder zzoz;

            C0883zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
                    boolean transact = this.zzoz.transact(2, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public static zzq zzaQ(IBinder iBinder) {
            C0883zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzq)) {
                return (zzq) queryLocalInterface;
            }
            C0883zza zza2 = zza;
            C0883zza zza3 = new C0883zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.common.internal.ICancelToken");
                    cancel();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.common.internal.ICancelToken");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void cancel() throws RemoteException;
}

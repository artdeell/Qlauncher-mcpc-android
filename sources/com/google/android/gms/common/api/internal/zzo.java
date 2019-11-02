package com.google.android.gms.common.api.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zzo extends IInterface {

    public static abstract class zza extends Binder implements zzo {

        /* renamed from: com.google.android.gms.common.api.internal.zzo$zza$zza reason: collision with other inner class name */
        private static class C0880zza implements zzo {
            private IBinder zzoz;

            C0880zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zzp(Status status) throws RemoteException {
                Status status2 = status;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.api.internal.IStatusCallback");
                    if (status2 != null) {
                        obtain.writeInt(1);
                        status2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(1, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public static zzo zzaN(IBinder iBinder) {
            C0880zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzo)) {
                return (zzo) queryLocalInterface;
            }
            C0880zza zza2 = zza;
            C0880zza zza3 = new C0880zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.common.api.internal.IStatusCallback");
                    zzp(parcel3.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel3) : null);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.common.api.internal.IStatusCallback");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zzp(Status status) throws RemoteException;
}

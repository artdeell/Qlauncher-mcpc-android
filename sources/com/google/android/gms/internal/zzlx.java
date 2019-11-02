package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zzlx extends IInterface {

    public static abstract class zza extends Binder implements zzlx {

        /* renamed from: com.google.android.gms.internal.zzlx$zza$zza reason: collision with other inner class name */
        private static class C0919zza implements zzlx {
            private IBinder zzoz;

            C0919zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zzv(Status status) throws RemoteException {
                Status status2 = status;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
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

        public zza() {
            attachInterface(this, "com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
        }

        public static zzlx zzaL(IBinder iBinder) {
            C0919zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzlx)) {
                return (zzlx) queryLocalInterface;
            }
            C0919zza zza2 = zza;
            C0919zza zza3 = new C0919zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
                    zzv(parcel3.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel3) : null);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zzv(Status status) throws RemoteException;
}

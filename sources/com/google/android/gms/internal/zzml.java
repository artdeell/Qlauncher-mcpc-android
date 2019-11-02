package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzml extends IInterface {

    public static abstract class zza extends Binder implements zzml {

        /* renamed from: com.google.android.gms.internal.zzml$zza$zza reason: collision with other inner class name */
        private static class C0922zza implements zzml {
            private IBinder zzoz;

            C0922zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzmk zzmk) throws RemoteException {
                zzmk zzmk2 = zzmk;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    IBinder iBinder = null;
                    if (zzmk2 != null) {
                        iBinder = zzmk2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean transact = this.zzoz.transact(1, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public static zzml zzaY(IBinder iBinder) {
            C0922zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzml)) {
                return (zzml) queryLocalInterface;
            }
            C0922zza zza2 = zza;
            C0922zza zza3 = new C0922zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                    zza(com.google.android.gms.internal.zzmk.zza.zzaX(parcel3.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.common.internal.service.ICommonService");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zza(zzmk zzmk) throws RemoteException;
}

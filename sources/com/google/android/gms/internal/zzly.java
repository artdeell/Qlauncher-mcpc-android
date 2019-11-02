package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;

public interface zzly extends IInterface {

    public static abstract class zza extends Binder implements zzly {

        /* renamed from: com.google.android.gms.internal.zzly$zza$zza reason: collision with other inner class name */
        private static class C0920zza implements zzly {
            private IBinder zzoz;

            C0920zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzlx zzlx, LogEventParcelable logEventParcelable) throws RemoteException {
                zzlx zzlx2 = zzlx;
                LogEventParcelable logEventParcelable2 = logEventParcelable;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    IBinder iBinder = null;
                    if (zzlx2 != null) {
                        iBinder = zzlx2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (logEventParcelable2 != null) {
                        obtain.writeInt(1);
                        logEventParcelable2.writeToParcel(obtain, 0);
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

        public static zzly zzaM(IBinder iBinder) {
            C0920zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzly)) {
                return (zzly) queryLocalInterface;
            }
            C0920zza zza2 = zza;
            C0920zza zza3 = new C0920zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    zza(com.google.android.gms.internal.zzlx.zza.zzaL(parcel3.readStrongBinder()), parcel3.readInt() != 0 ? LogEventParcelable.CREATOR.createFromParcel(parcel3) : null);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zza(zzlx zzlx, LogEventParcelable logEventParcelable) throws RemoteException;
}

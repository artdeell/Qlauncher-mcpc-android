package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzex extends IInterface {

    public static abstract class zza extends Binder implements zzex {

        /* renamed from: com.google.android.gms.internal.zzex$zza$zza reason: collision with other inner class name */
        private static class C0905zza implements zzex {
            private IBinder zzoz;

            C0905zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            /* JADX INFO: finally extract failed */
            public zzey zzaf(String str) throws RemoteException {
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzey zzF = com.google.android.gms.internal.zzey.zza.zzF(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return zzF;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public boolean zzag(String str) throws RemoteException {
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        public static zzex zzE(IBinder iBinder) {
            C0905zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzex)) {
                return (zzex) queryLocalInterface;
            }
            C0905zza zza2 = zza;
            C0905zza zza3 = new C0905zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    zzey zzaf = zzaf(parcel3.readString());
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zzaf != null ? zzaf.asBinder() : null);
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    boolean zzag = zzag(parcel3.readString());
                    parcel4.writeNoException();
                    parcel4.writeInt(zzag ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    zzey zzaf(String str) throws RemoteException;

    boolean zzag(String str) throws RemoteException;
}

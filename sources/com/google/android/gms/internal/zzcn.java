package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import java.util.ArrayList;
import java.util.List;

public interface zzcn extends IInterface {

    public static abstract class zza extends Binder implements zzcn {

        /* renamed from: com.google.android.gms.internal.zzcn$zza$zza reason: collision with other inner class name */
        private static class C0899zza implements zzcn {
            private IBinder zzoz;

            C0899zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(10, obtain, obtain2, 0);
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
            public String getAdvertiser() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(8, obtain, obtain2, 0);
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

            /* JADX INFO: finally extract failed */
            public String getBody() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(5, obtain, obtain2, 0);
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

            /* JADX INFO: finally extract failed */
            public String getCallToAction() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(7, obtain, obtain2, 0);
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

            public Bundle getExtras() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public String getHeadline() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
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

            /* JADX INFO: finally extract failed */
            public List getImages() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ArrayList readArrayList = obtain2.readArrayList(getClass().getClassLoader());
                    obtain2.recycle();
                    obtain.recycle();
                    return readArrayList;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public zzd zzdL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
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

            /* JADX INFO: finally extract failed */
            public zzch zzdO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    boolean transact = this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    zzch zzt = com.google.android.gms.internal.zzch.zza.zzt(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return zzt;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        }

        public static zzcn zzx(IBinder iBinder) {
            C0899zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzcn)) {
                return (zzcn) queryLocalInterface;
            }
            C0899zza zza2 = zza;
            C0899zza zza3 = new C0899zza(iBinder2);
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
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzd zzdL = zzdL();
                    parcel4.writeNoException();
                    IBinder iBinder = null;
                    if (zzdL != null) {
                        iBinder = zzdL.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String headline = getHeadline();
                    parcel4.writeNoException();
                    parcel4.writeString(headline);
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    List images = getImages();
                    parcel4.writeNoException();
                    parcel4.writeList(images);
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String body = getBody();
                    parcel4.writeNoException();
                    parcel4.writeString(body);
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    zzch zzdO = zzdO();
                    parcel4.writeNoException();
                    IBinder iBinder2 = null;
                    if (zzdO != null) {
                        iBinder2 = zzdO.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder2);
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String callToAction = getCallToAction();
                    parcel4.writeNoException();
                    parcel4.writeString(callToAction);
                    return true;
                case 8:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    String advertiser = getAdvertiser();
                    parcel4.writeNoException();
                    parcel4.writeString(advertiser);
                    return true;
                case 9:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    Bundle extras = getExtras();
                    parcel4.writeNoException();
                    if (extras != null) {
                        parcel4.writeInt(1);
                        extras.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    destroy();
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void destroy() throws RemoteException;

    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    zzd zzdL() throws RemoteException;

    zzch zzdO() throws RemoteException;
}

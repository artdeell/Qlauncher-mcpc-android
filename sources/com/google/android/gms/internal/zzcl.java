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

public interface zzcl extends IInterface {

    public static abstract class zza extends Binder implements zzcl {

        /* renamed from: com.google.android.gms.internal.zzcl$zza$zza reason: collision with other inner class name */
        private static class C0898zza implements zzcl {
            private IBinder zzoz;

            C0898zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    boolean transact = this.zzoz.transact(12, obtain, obtain2, 0);
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
            public String getBody() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    boolean transact = this.zzoz.transact(11, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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
            public String getPrice() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    boolean transact = this.zzoz.transact(10, obtain, obtain2, 0);
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
            public double getStarRating() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    boolean transact = this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    double readDouble = obtain2.readDouble();
                    obtain2.recycle();
                    obtain.recycle();
                    return readDouble;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public String getStore() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    boolean transact = this.zzoz.transact(9, obtain, obtain2, 0);
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
            public zzch zzdK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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

            /* JADX INFO: finally extract failed */
            public zzd zzdL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
        }

        public static zzcl zzw(IBinder iBinder) {
            C0898zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzcl)) {
                return (zzcl) queryLocalInterface;
            }
            C0898zza zza2 = zza;
            C0898zza zza3 = new C0898zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzd zzdL = zzdL();
                    parcel4.writeNoException();
                    IBinder iBinder = null;
                    if (zzdL != null) {
                        iBinder = zzdL.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String headline = getHeadline();
                    parcel4.writeNoException();
                    parcel4.writeString(headline);
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    List images = getImages();
                    parcel4.writeNoException();
                    parcel4.writeList(images);
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String body = getBody();
                    parcel4.writeNoException();
                    parcel4.writeString(body);
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    zzch zzdK = zzdK();
                    parcel4.writeNoException();
                    IBinder iBinder2 = null;
                    if (zzdK != null) {
                        iBinder2 = zzdK.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder2);
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String callToAction = getCallToAction();
                    parcel4.writeNoException();
                    parcel4.writeString(callToAction);
                    return true;
                case 8:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    double starRating = getStarRating();
                    parcel4.writeNoException();
                    parcel4.writeDouble(starRating);
                    return true;
                case 9:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String store = getStore();
                    parcel4.writeNoException();
                    parcel4.writeString(store);
                    return true;
                case 10:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    String price = getPrice();
                    parcel4.writeNoException();
                    parcel4.writeString(price);
                    return true;
                case 11:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    Bundle extras = getExtras();
                    parcel4.writeNoException();
                    if (extras != null) {
                        parcel4.writeInt(1);
                        extras.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    destroy();
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void destroy() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzch zzdK() throws RemoteException;

    zzd zzdL() throws RemoteException;
}

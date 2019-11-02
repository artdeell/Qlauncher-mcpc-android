package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface zzcp extends IInterface {

    public static abstract class zza extends Binder implements zzcp {

        /* renamed from: com.google.android.gms.internal.zzcp$zza$zza reason: collision with other inner class name */
        private static class C0900zza implements zzcp {
            private IBinder zzoz;

            C0900zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            /* JADX INFO: finally extract failed */
            public List<String> getAvailableAssetNames() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    ArrayList createStringArrayList = obtain2.createStringArrayList();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArrayList;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public String getCustomTemplateId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    boolean transact = this.zzoz.transact(4, obtain, obtain2, 0);
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

            public void performClick(String str) throws RemoteException {
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(5, obtain, obtain2, 0);
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

            public void recordImpression() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    boolean transact = this.zzoz.transact(6, obtain, obtain2, 0);
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
            public String zzO(String str) throws RemoteException {
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
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
            public zzch zzP(String str) throws RemoteException {
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
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
            attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        }

        public static zzcp zzy(IBinder iBinder) {
            C0900zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzcp)) {
                return (zzcp) queryLocalInterface;
            }
            C0900zza zza2 = zza;
            C0900zza zza3 = new C0900zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    String zzO = zzO(parcel3.readString());
                    parcel4.writeNoException();
                    parcel4.writeString(zzO);
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    zzch zzP = zzP(parcel3.readString());
                    parcel4.writeNoException();
                    parcel4.writeStrongBinder(zzP != null ? zzP.asBinder() : null);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    List availableAssetNames = getAvailableAssetNames();
                    parcel4.writeNoException();
                    parcel4.writeStringList(availableAssetNames);
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    String customTemplateId = getCustomTemplateId();
                    parcel4.writeNoException();
                    parcel4.writeString(customTemplateId);
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    performClick(parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    recordImpression();
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    String zzO(String str) throws RemoteException;

    zzch zzP(String str) throws RemoteException;
}

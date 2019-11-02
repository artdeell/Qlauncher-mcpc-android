package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;

public interface zzu extends IInterface {

    public static abstract class zza extends Binder implements zzu {

        /* renamed from: com.google.android.gms.ads.internal.client.zzu$zza$zza reason: collision with other inner class name */
        private static class C0861zza implements zzu {
            private IBinder zzoz;

            C0861zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
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
            public String getMediationAdapterClassName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(18, obtain, obtain2, 0);
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

            public boolean isLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(23, obtain, obtain2, 0);
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

            public boolean isReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
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

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
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

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
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

            public void setManualImpressionsEnabled(boolean z) throws RemoteException {
                boolean z2 = z;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    int i = 0;
                    if (z2) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    boolean transact = this.zzoz.transact(22, obtain, obtain2, 0);
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

            public void setUserId(String str) throws RemoteException {
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(25, obtain, obtain2, 0);
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

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(9, obtain, obtain2, 0);
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

            public void stopLoading() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
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

            public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adSizeParcel2 != null) {
                        obtain.writeInt(1);
                        adSizeParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(13, obtain, obtain2, 0);
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

            public void zza(zzp zzp) throws RemoteException {
                zzp zzp2 = zzp;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzp2 != null ? zzp2.asBinder() : null);
                    boolean transact = this.zzoz.transact(20, obtain, obtain2, 0);
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

            public void zza(zzq zzq) throws RemoteException {
                zzq zzq2 = zzq;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzq2 != null ? zzq2.asBinder() : null);
                    boolean transact = this.zzoz.transact(7, obtain, obtain2, 0);
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

            public void zza(zzw zzw) throws RemoteException {
                zzw zzw2 = zzw;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzw2 != null ? zzw2.asBinder() : null);
                    boolean transact = this.zzoz.transact(8, obtain, obtain2, 0);
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

            public void zza(zzx zzx) throws RemoteException {
                zzx zzx2 = zzx;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzx2 != null ? zzx2.asBinder() : null);
                    boolean transact = this.zzoz.transact(21, obtain, obtain2, 0);
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

            public void zza(zzd zzd) throws RemoteException {
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    boolean transact = this.zzoz.transact(24, obtain, obtain2, 0);
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

            public void zza(zzcf zzcf) throws RemoteException {
                zzcf zzcf2 = zzcf;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzcf2 != null ? zzcf2.asBinder() : null);
                    boolean transact = this.zzoz.transact(19, obtain, obtain2, 0);
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

            public void zza(zzgd zzgd) throws RemoteException {
                zzgd zzgd2 = zzgd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzgd2 != null ? zzgd2.asBinder() : null);
                    boolean transact = this.zzoz.transact(14, obtain, obtain2, 0);
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

            public void zza(zzgh zzgh, String str) throws RemoteException {
                zzgh zzgh2 = zzgh;
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    obtain.writeStrongBinder(zzgh2 != null ? zzgh2.asBinder() : null);
                    obtain.writeString(str2);
                    boolean transact = this.zzoz.transact(15, obtain, obtain2, 0);
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
            public com.google.android.gms.dynamic.zzd zzaM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    com.google.android.gms.dynamic.zzd zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(obtain2.readStrongBinder());
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

            public AdSizeParcel zzaN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    AdSizeParcel adSizeParcel = obtain2.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return adSizeParcel;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public void zzaP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean transact = this.zzoz.transact(11, obtain, obtain2, 0);
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

            public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
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
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        public static zzu zzk(IBinder iBinder) {
            C0861zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzu)) {
                return (zzu) queryLocalInterface;
            }
            C0861zza zza2 = zza;
            C0861zza zza3 = new C0861zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    com.google.android.gms.dynamic.zzd zzaM = zzaM();
                    parcel4.writeNoException();
                    IBinder iBinder = null;
                    if (zzaM != null) {
                        iBinder = zzaM.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    destroy();
                    parcel4.writeNoException();
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean isReady = isReady();
                    parcel4.writeNoException();
                    parcel4.writeInt(isReady ? 1 : 0);
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    AdRequestParcel adRequestParcel = null;
                    if (parcel3.readInt() != 0) {
                        adRequestParcel = AdRequestParcel.CREATOR.createFromParcel(parcel3);
                    }
                    boolean zzb = zzb(adRequestParcel);
                    parcel4.writeNoException();
                    int i5 = 0;
                    if (zzb) {
                        i5 = 1;
                    }
                    parcel4.writeInt(i5);
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    pause();
                    parcel4.writeNoException();
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    resume();
                    parcel4.writeNoException();
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzq.zza.zzg(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 8:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzw.zza.zzm(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 9:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    showInterstitial();
                    parcel4.writeNoException();
                    return true;
                case 10:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    stopLoading();
                    parcel4.writeNoException();
                    return true;
                case 11:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zzaP();
                    parcel4.writeNoException();
                    return true;
                case 12:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    AdSizeParcel zzaN = zzaN();
                    parcel4.writeNoException();
                    if (zzaN != null) {
                        parcel4.writeInt(1);
                        zzaN.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 13:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    AdSizeParcel adSizeParcel = null;
                    if (parcel3.readInt() != 0) {
                        adSizeParcel = AdSizeParcel.CREATOR.createFromParcel(parcel3);
                    }
                    zza(adSizeParcel);
                    parcel4.writeNoException();
                    return true;
                case 14:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.internal.zzgd.zza.zzP(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 15:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.internal.zzgh.zza.zzT(parcel3.readStrongBinder()), parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 18:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    parcel4.writeNoException();
                    parcel4.writeString(mediationAdapterClassName);
                    return true;
                case 19:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.internal.zzcf.zza.zzs(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 20:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzp.zza.zzf(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 21:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.client.zzx.zza.zzn(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 22:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean z = false;
                    if (parcel3.readInt() != 0) {
                        z = true;
                    }
                    setManualImpressionsEnabled(z);
                    parcel4.writeNoException();
                    return true;
                case 23:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean isLoading = isLoading();
                    parcel4.writeNoException();
                    int i6 = 0;
                    if (isLoading) {
                        i6 = 1;
                    }
                    parcel4.writeInt(i6);
                    return true;
                case 24:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    zza(com.google.android.gms.ads.internal.reward.client.zzd.zza.zzac(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 25:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    setUserId(parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void destroy() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(AdSizeParcel adSizeParcel) throws RemoteException;

    void zza(zzp zzp) throws RemoteException;

    void zza(zzq zzq) throws RemoteException;

    void zza(zzw zzw) throws RemoteException;

    void zza(zzx zzx) throws RemoteException;

    void zza(zzd zzd) throws RemoteException;

    void zza(zzcf zzcf) throws RemoteException;

    void zza(zzgd zzgd) throws RemoteException;

    void zza(zzgh zzgh, String str) throws RemoteException;

    com.google.android.gms.dynamic.zzd zzaM() throws RemoteException;

    AdSizeParcel zzaN() throws RemoteException;

    void zzaP() throws RemoteException;

    boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException;
}

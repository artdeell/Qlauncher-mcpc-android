package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.C0876zza;
import com.google.android.gms.dynamic.zzd;
import java.util.List;

public interface zzey extends IInterface {

    public static abstract class zza extends Binder implements zzey {

        /* renamed from: com.google.android.gms.internal.zzey$zza$zza reason: collision with other inner class name */
        private static class C0906zza implements zzey {
            private IBinder zzoz;

            C0906zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

            public Bundle getInterstitialAdapterInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean transact = this.zzoz.transact(18, obtain, obtain2, 0);
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
            public zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

            public boolean isInitialized() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean transact = this.zzoz.transact(13, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean transact = this.zzoz.transact(4, obtain, obtain2, 0);
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

            public void showVideo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
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

            public void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException {
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str3 = str;
                String str4 = str2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str3);
                    obtain.writeString(str4);
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

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza, String str2) throws RemoteException {
                zzd zzd2 = zzd;
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str3 = str;
                com.google.android.gms.ads.internal.reward.mediation.client.zza zza2 = zza;
                String str4 = str2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str3);
                    IBinder iBinder = null;
                    if (zza2 != null) {
                        iBinder = zza2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str4);
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

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
                zzd zzd2 = zzd;
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str2 = str;
                zzez zzez2 = zzez;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    IBinder iBinder = null;
                    if (zzez2 != null) {
                        iBinder = zzez2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
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

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
                zzd zzd2 = zzd;
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str3 = str;
                String str4 = str2;
                zzez zzez2 = zzez;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    IBinder iBinder = null;
                    if (zzez2 != null) {
                        iBinder = zzez2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
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

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
                zzd zzd2 = zzd;
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str3 = str;
                String str4 = str2;
                zzez zzez2 = zzez;
                NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
                List<String> list2 = list;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    IBinder iBinder = null;
                    if (zzez2 != null) {
                        iBinder = zzez2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (nativeAdOptionsParcel2 != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list2);
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

            public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException {
                zzd zzd2 = zzd;
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str2 = str;
                zzez zzez2 = zzez;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adSizeParcel2 != null) {
                        obtain.writeInt(1);
                        adSizeParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    IBinder iBinder = null;
                    if (zzez2 != null) {
                        iBinder = zzez2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
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

            public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException {
                zzd zzd2 = zzd;
                AdSizeParcel adSizeParcel2 = adSizeParcel;
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str3 = str;
                String str4 = str2;
                zzez zzez2 = zzez;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    if (adSizeParcel2 != null) {
                        obtain.writeInt(1);
                        adSizeParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    IBinder iBinder = null;
                    if (zzez2 != null) {
                        iBinder = zzez2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
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

            public void zzb(AdRequestParcel adRequestParcel, String str) throws RemoteException {
                AdRequestParcel adRequestParcel2 = adRequestParcel;
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel2 != null) {
                        obtain.writeInt(1);
                        adRequestParcel2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
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

            /* JADX INFO: finally extract failed */
            public zzfb zzeF() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean transact = this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    zzfb zzI = com.google.android.gms.internal.zzfb.zza.zzI(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return zzI;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public zzfc zzeG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean transact = this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    zzfc zzJ = com.google.android.gms.internal.zzfc.zza.zzJ(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return zzJ;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public Bundle zzeH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean transact = this.zzoz.transact(17, obtain, obtain2, 0);
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

            public Bundle zzeI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean transact = this.zzoz.transact(19, obtain, obtain2, 0);
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static zzey zzF(IBinder iBinder) {
            C0906zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzey)) {
                return (zzey) queryLocalInterface;
            }
            C0906zza zza2 = zza;
            C0906zza zza3 = new C0906zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), parcel3.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.readString(), com.google.android.gms.internal.zzez.zza.zzG(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zzd view = getView();
                    parcel4.writeNoException();
                    IBinder iBinder = null;
                    if (view != null) {
                        iBinder = view.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zzd zzbs = com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder());
                    AdRequestParcel adRequestParcel = null;
                    if (parcel3.readInt() != 0) {
                        adRequestParcel = AdRequestParcel.CREATOR.createFromParcel(parcel3);
                    }
                    zza(zzbs, adRequestParcel, parcel3.readString(), com.google.android.gms.internal.zzez.zza.zzG(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    parcel4.writeNoException();
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    parcel4.writeNoException();
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), parcel3.readInt() != 0 ? AdSizeParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.readString(), parcel3.readString(), com.google.android.gms.internal.zzez.zza.zzG(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), parcel3.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.readString(), parcel3.readString(), com.google.android.gms.internal.zzez.zza.zzG(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 8:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    pause();
                    parcel4.writeNoException();
                    return true;
                case 9:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    resume();
                    parcel4.writeNoException();
                    return true;
                case 10:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), parcel3.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.readString(), C0876zza.zzae(parcel3.readStrongBinder()), parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 11:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    AdRequestParcel adRequestParcel2 = null;
                    if (parcel3.readInt() != 0) {
                        adRequestParcel2 = AdRequestParcel.CREATOR.createFromParcel(parcel3);
                    }
                    zzb(adRequestParcel2, parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 12:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showVideo();
                    parcel4.writeNoException();
                    return true;
                case 13:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    boolean isInitialized = isInitialized();
                    parcel4.writeNoException();
                    parcel4.writeInt(isInitialized ? 1 : 0);
                    return true;
                case 14:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zza(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()), parcel3.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.readString(), parcel3.readString(), com.google.android.gms.internal.zzez.zza.zzG(parcel3.readStrongBinder()), parcel3.readInt() != 0 ? NativeAdOptionsParcel.CREATOR.createFromParcel(parcel3) : null, parcel3.createStringArrayList());
                    parcel4.writeNoException();
                    return true;
                case 15:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zzfb zzeF = zzeF();
                    parcel4.writeNoException();
                    IBinder iBinder2 = null;
                    if (zzeF != null) {
                        iBinder2 = zzeF.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder2);
                    return true;
                case 16:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    zzfc zzeG = zzeG();
                    parcel4.writeNoException();
                    IBinder iBinder3 = null;
                    if (zzeG != null) {
                        iBinder3 = zzeG.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder3);
                    return true;
                case 17:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    Bundle zzeH = zzeH();
                    parcel4.writeNoException();
                    if (zzeH != null) {
                        parcel4.writeInt(1);
                        zzeH.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 18:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    Bundle interstitialAdapterInfo = getInterstitialAdapterInfo();
                    parcel4.writeNoException();
                    if (interstitialAdapterInfo != null) {
                        parcel4.writeInt(1);
                        interstitialAdapterInfo.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 19:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    Bundle zzeI = zzeI();
                    parcel4.writeNoException();
                    if (zzeI != null) {
                        parcel4.writeInt(1);
                        zzeI.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 20:
                    parcel3.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    AdRequestParcel adRequestParcel3 = null;
                    if (parcel3.readInt() != 0) {
                        adRequestParcel3 = AdRequestParcel.CREATOR.createFromParcel(parcel3);
                    }
                    zza(adRequestParcel3, parcel3.readString(), parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzd getView() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(AdRequestParcel adRequestParcel, String str, String str2) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza2, String str2) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException;

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzez zzez) throws RemoteException;

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzez zzez) throws RemoteException;

    void zzb(AdRequestParcel adRequestParcel, String str) throws RemoteException;

    zzfb zzeF() throws RemoteException;

    zzfc zzeG() throws RemoteException;

    Bundle zzeH() throws RemoteException;

    Bundle zzeI() throws RemoteException;
}

package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* renamed from: com.google.android.gms.signin.internal.zze$zza$zza reason: collision with other inner class name */
        private static class C0928zza implements zze {
            private IBinder zzoz;

            C0928zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(int i, Account account, zzd zzd) throws RemoteException {
                int i2 = i;
                Account account2 = account;
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i2);
                    if (account2 != null) {
                        obtain.writeInt(1);
                        account2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

            public void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException {
                AuthAccountRequest authAccountRequest2 = authAccountRequest;
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest2 != null) {
                        obtain.writeInt(1);
                        authAccountRequest2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

            public void zza(ResolveAccountRequest resolveAccountRequest, zzt zzt) throws RemoteException {
                ResolveAccountRequest resolveAccountRequest2 = resolveAccountRequest;
                zzt zzt2 = zzt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest2 != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzt2 != null ? zzt2.asBinder() : null);
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

            public void zza(zzp zzp, int i, boolean z) throws RemoteException {
                zzp zzp2 = zzp;
                int i2 = i;
                boolean z2 = z;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzp2 != null ? zzp2.asBinder() : null);
                    obtain.writeInt(i2);
                    int i3 = 0;
                    if (z2) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
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

            public void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                CheckServerAuthResult checkServerAuthResult2 = checkServerAuthResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult2 != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException {
                RecordConsentRequest recordConsentRequest2 = recordConsentRequest;
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest2 != null) {
                        obtain.writeInt(1);
                        recordConsentRequest2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

            public void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException {
                SignInRequest signInRequest2 = signInRequest;
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (signInRequest2 != null) {
                        obtain.writeInt(1);
                        signInRequest2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

            public void zzav(boolean z) throws RemoteException {
                boolean z2 = z;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    int i = 0;
                    if (z2) {
                        i = 1;
                    }
                    obtain.writeInt(i);
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

            public void zzb(zzd zzd) throws RemoteException {
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

            public void zzka(int i) throws RemoteException {
                int i2 = i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i2);
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
        }

        public static zze zzeb(IBinder iBinder) {
            C0928zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zze)) {
                return (zze) queryLocalInterface;
            }
            C0928zza zza2 = zza;
            C0928zza zza3 = new C0928zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 2:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    AuthAccountRequest authAccountRequest = null;
                    if (parcel3.readInt() != 0) {
                        authAccountRequest = (AuthAccountRequest) AuthAccountRequest.CREATOR.createFromParcel(parcel3);
                    }
                    zza(authAccountRequest, com.google.android.gms.signin.internal.zzd.zza.zzea(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    CheckServerAuthResult checkServerAuthResult = null;
                    if (parcel3.readInt() != 0) {
                        checkServerAuthResult = (CheckServerAuthResult) CheckServerAuthResult.CREATOR.createFromParcel(parcel3);
                    }
                    zza(checkServerAuthResult);
                    parcel4.writeNoException();
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzav(parcel3.readInt() != 0);
                    parcel4.writeNoException();
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    ResolveAccountRequest resolveAccountRequest = null;
                    if (parcel3.readInt() != 0) {
                        resolveAccountRequest = (ResolveAccountRequest) ResolveAccountRequest.CREATOR.createFromParcel(parcel3);
                    }
                    zza(resolveAccountRequest, com.google.android.gms.common.internal.zzt.zza.zzaT(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzka(parcel3.readInt());
                    parcel4.writeNoException();
                    return true;
                case 8:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    int readInt = parcel3.readInt();
                    Account account = null;
                    if (parcel3.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(parcel3);
                    }
                    zza(readInt, account, com.google.android.gms.signin.internal.zzd.zza.zzea(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 9:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzp zzaP = com.google.android.gms.common.internal.zzp.zza.zzaP(parcel3.readStrongBinder());
                    int readInt2 = parcel3.readInt();
                    boolean z = false;
                    if (parcel3.readInt() != 0) {
                        z = true;
                    }
                    zza(zzaP, readInt2, z);
                    parcel4.writeNoException();
                    return true;
                case 10:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    RecordConsentRequest recordConsentRequest = null;
                    if (parcel3.readInt() != 0) {
                        recordConsentRequest = (RecordConsentRequest) RecordConsentRequest.CREATOR.createFromParcel(parcel3);
                    }
                    zza(recordConsentRequest, com.google.android.gms.signin.internal.zzd.zza.zzea(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 11:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    zzb(com.google.android.gms.signin.internal.zzd.zza.zzea(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 12:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                    SignInRequest signInRequest = null;
                    if (parcel3.readInt() != 0) {
                        signInRequest = (SignInRequest) SignInRequest.CREATOR.createFromParcel(parcel3);
                    }
                    zza(signInRequest, com.google.android.gms.signin.internal.zzd.zza.zzea(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.signin.internal.ISignInService");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zza(int i, Account account, zzd zzd) throws RemoteException;

    void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException;

    void zza(ResolveAccountRequest resolveAccountRequest, zzt zzt) throws RemoteException;

    void zza(zzp zzp, int i, boolean z) throws RemoteException;

    void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException;

    void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException;

    void zzav(boolean z) throws RemoteException;

    void zzb(zzd zzd) throws RemoteException;

    void zzka(int i) throws RemoteException;
}

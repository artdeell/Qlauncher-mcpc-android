package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.android.gms.signin.internal.zzd$zza$zza reason: collision with other inner class name */
        private static class C0927zza implements zzd {
            private IBinder zzoz;

            C0927zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(ConnectionResult connectionResult, AuthAccountResult authAccountResult) throws RemoteException {
                ConnectionResult connectionResult2 = connectionResult;
                AuthAccountResult authAccountResult2 = authAccountResult;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (connectionResult2 != null) {
                        obtain.writeInt(1);
                        connectionResult2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (authAccountResult2 != null) {
                        obtain.writeInt(1);
                        authAccountResult2.writeToParcel(obtain, 0);
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

            public void zza(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException {
                Status status2 = status;
                GoogleSignInAccount googleSignInAccount2 = googleSignInAccount;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status2 != null) {
                        obtain.writeInt(1);
                        status2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (googleSignInAccount2 != null) {
                        obtain.writeInt(1);
                        googleSignInAccount2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public void zzb(SignInResponse signInResponse) throws RemoteException {
                SignInResponse signInResponse2 = signInResponse;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (signInResponse2 != null) {
                        obtain.writeInt(1);
                        signInResponse2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public void zzbl(Status status) throws RemoteException {
                Status status2 = status;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status2 != null) {
                        obtain.writeInt(1);
                        status2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public void zzbm(Status status) throws RemoteException {
                Status status2 = status;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status2 != null) {
                        obtain.writeInt(1);
                        status2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        }

        public static zzd zzea(IBinder iBinder) {
            C0927zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzd)) {
                return (zzd) queryLocalInterface;
            }
            C0927zza zza2 = zza;
            C0927zza zza3 = new C0927zza(iBinder2);
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
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    zza(parcel3.readInt() != 0 ? (ConnectionResult) ConnectionResult.CREATOR.createFromParcel(parcel3) : null, parcel3.readInt() != 0 ? (AuthAccountResult) AuthAccountResult.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    zzbl(parcel3.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    zzbm(parcel3.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    zza(parcel3.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(parcel3) : null, parcel3.readInt() != 0 ? (GoogleSignInAccount) GoogleSignInAccount.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 8:
                    parcel3.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                    zzb(parcel3.readInt() != 0 ? (SignInResponse) SignInResponse.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void zza(ConnectionResult connectionResult, AuthAccountResult authAccountResult) throws RemoteException;

    void zza(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void zzb(SignInResponse signInResponse) throws RemoteException;

    void zzbl(Status status) throws RemoteException;

    void zzbm(Status status) throws RemoteException;
}

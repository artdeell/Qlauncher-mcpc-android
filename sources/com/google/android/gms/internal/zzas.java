package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public interface zzas extends IInterface {

    public static abstract class zza extends Binder implements zzas {

        /* renamed from: com.google.android.gms.internal.zzas$zza$zza reason: collision with other inner class name */
        private static class C0891zza implements zzas {
            private IBinder zzoz;

            C0891zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public Bundle zza(Account account) throws RemoteException {
                Account account2 = account;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (account2 != null) {
                        obtain.writeInt(1);
                        account2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(7, obtain, obtain2, 0);
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

            public Bundle zza(Account account, String str, Bundle bundle) throws RemoteException {
                Account account2 = account;
                String str2 = str;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (account2 != null) {
                        obtain.writeInt(1);
                        account2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle3 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle3;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public Bundle zza(Bundle bundle) throws RemoteException {
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle3 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle3;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public Bundle zza(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    obtain.writeString(str2);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle3 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle3;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public Bundle zza(String str, String str2, Bundle bundle) throws RemoteException {
                String str3 = str;
                String str4 = str2;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle3 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle3;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public AccountChangeEventsResponse zza(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException {
                AccountChangeEventsRequest accountChangeEventsRequest2 = accountChangeEventsRequest;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (accountChangeEventsRequest2 != null) {
                        obtain.writeInt(1);
                        accountChangeEventsRequest2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountChangeEventsResponse accountChangeEventsResponse = obtain2.readInt() != 0 ? (AccountChangeEventsResponse) AccountChangeEventsResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return accountChangeEventsResponse;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public static zzas zza(IBinder iBinder) {
            C0891zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.auth.IAuthManagerService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzas)) {
                return (zzas) queryLocalInterface;
            }
            C0891zza zza2 = zza;
            C0891zza zza3 = new C0891zza(iBinder2);
            return zza2;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = i;
            Parcel parcel3 = parcel;
            Parcel parcel4 = parcel2;
            int i4 = i2;
            switch (i3) {
                case 1:
                    parcel3.enforceInterface("com.google.android.auth.IAuthManagerService");
                    Bundle zza = zza(parcel3.readString(), parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    if (zza != null) {
                        parcel4.writeInt(1);
                        zza.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 2:
                    parcel3.enforceInterface("com.google.android.auth.IAuthManagerService");
                    Bundle zza2 = zza(parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    if (zza2 != null) {
                        parcel4.writeInt(1);
                        zza2.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.auth.IAuthManagerService");
                    AccountChangeEventsResponse zza3 = zza(parcel3.readInt() != 0 ? (AccountChangeEventsRequest) AccountChangeEventsRequest.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    if (zza3 != null) {
                        parcel4.writeInt(1);
                        zza3.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.auth.IAuthManagerService");
                    Bundle zza4 = zza(parcel3.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel3) : null, parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    if (zza4 != null) {
                        parcel4.writeInt(1);
                        zza4.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.auth.IAuthManagerService");
                    Bundle zza5 = zza(parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    if (zza5 != null) {
                        parcel4.writeInt(1);
                        zza5.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.auth.IAuthManagerService");
                    Bundle zza6 = zza(parcel3.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    if (zza6 != null) {
                        parcel4.writeInt(1);
                        zza6.writeToParcel(parcel4, 1);
                    } else {
                        parcel4.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.auth.IAuthManagerService");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    Bundle zza(Account account) throws RemoteException;

    Bundle zza(Account account, String str, Bundle bundle) throws RemoteException;

    Bundle zza(Bundle bundle) throws RemoteException;

    Bundle zza(String str, Bundle bundle) throws RemoteException;

    Bundle zza(String str, String str2, Bundle bundle) throws RemoteException;

    AccountChangeEventsResponse zza(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException;
}

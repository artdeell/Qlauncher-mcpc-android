package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.dynamic.zzc$zza$zza reason: collision with other inner class name */
        private static class C0888zza implements zzc {
            private IBinder zzoz;

            C0888zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public Bundle getArguments() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(3, obtain, obtain2, 0);
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
            public int getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public boolean getRetainInstance() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(7, obtain, obtain2, 0);
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

            /* JADX INFO: finally extract failed */
            public String getTag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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
            public int getTargetRequestCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public boolean getUserVisibleHint() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(11, obtain, obtain2, 0);
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

            /* JADX INFO: finally extract failed */
            public zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(12, obtain, obtain2, 0);
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

            public boolean isAdded() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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

            public boolean isDetached() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(14, obtain, obtain2, 0);
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

            public boolean isHidden() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(15, obtain, obtain2, 0);
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

            public boolean isInLayout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(16, obtain, obtain2, 0);
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

            public boolean isRemoving() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(17, obtain, obtain2, 0);
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

            public boolean isResumed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(18, obtain, obtain2, 0);
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

            public boolean isVisible() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(19, obtain, obtain2, 0);
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

            public void setHasOptionsMenu(boolean z) throws RemoteException {
                boolean z2 = z;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    int i = 0;
                    if (z2) {
                        i = 1;
                    }
                    obtain.writeInt(i);
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

            public void setMenuVisibility(boolean z) throws RemoteException {
                boolean z2 = z;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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

            public void setRetainInstance(boolean z) throws RemoteException {
                boolean z2 = z;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    int i = 0;
                    if (z2) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    boolean transact = this.zzoz.transact(23, obtain, obtain2, 0);
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

            public void setUserVisibleHint(boolean z) throws RemoteException {
                boolean z2 = z;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    int i = 0;
                    if (z2) {
                        i = 1;
                    }
                    obtain.writeInt(i);
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

            public void startActivity(Intent intent) throws RemoteException {
                Intent intent2 = intent;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent2 != null) {
                        obtain.writeInt(1);
                        intent2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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

            public void startActivityForResult(Intent intent, int i) throws RemoteException {
                Intent intent2 = intent;
                int i2 = i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent2 != null) {
                        obtain.writeInt(1);
                        intent2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    boolean transact = this.zzoz.transact(26, obtain, obtain2, 0);
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

            public void zzn(zzd zzd) throws RemoteException {
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
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

            public void zzo(zzd zzd) throws RemoteException {
                zzd zzd2 = zzd;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
                    boolean transact = this.zzoz.transact(27, obtain, obtain2, 0);
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
            public zzd zztV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
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
            public zzc zztW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    zzc zzbr = zza.zzbr(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return zzbr;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public zzd zztX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(6, obtain, obtain2, 0);
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
            public zzc zztY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean transact = this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    zzc zzbr = zza.zzbr(obtain2.readStrongBinder());
                    obtain2.recycle();
                    obtain.recycle();
                    return zzbr;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static zzc zzbr(IBinder iBinder) {
            C0888zza zza;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (queryLocalInterface != null && (queryLocalInterface instanceof zzc)) {
                return (zzc) queryLocalInterface;
            }
            C0888zza zza2 = zza;
            C0888zza zza3 = new C0888zza(iBinder2);
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
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    zzd zztV = zztV();
                    parcel4.writeNoException();
                    IBinder iBinder = null;
                    if (zztV != null) {
                        iBinder = zztV.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    Bundle arguments = getArguments();
                    parcel4.writeNoException();
                    if (arguments != null) {
                        parcel4.writeInt(1);
                        arguments.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 4:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    int id = getId();
                    parcel4.writeNoException();
                    parcel4.writeInt(id);
                    return true;
                case 5:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    zzc zztW = zztW();
                    parcel4.writeNoException();
                    IBinder iBinder2 = null;
                    if (zztW != null) {
                        iBinder2 = zztW.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder2);
                    return true;
                case 6:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    zzd zztX = zztX();
                    parcel4.writeNoException();
                    IBinder iBinder3 = null;
                    if (zztX != null) {
                        iBinder3 = zztX.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder3);
                    return true;
                case 7:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean retainInstance = getRetainInstance();
                    parcel4.writeNoException();
                    parcel4.writeInt(retainInstance ? 1 : 0);
                    return true;
                case 8:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    String tag = getTag();
                    parcel4.writeNoException();
                    parcel4.writeString(tag);
                    return true;
                case 9:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    zzc zztY = zztY();
                    parcel4.writeNoException();
                    IBinder iBinder4 = null;
                    if (zztY != null) {
                        iBinder4 = zztY.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder4);
                    return true;
                case 10:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    int targetRequestCode = getTargetRequestCode();
                    parcel4.writeNoException();
                    parcel4.writeInt(targetRequestCode);
                    return true;
                case 11:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean userVisibleHint = getUserVisibleHint();
                    parcel4.writeNoException();
                    int i5 = 0;
                    if (userVisibleHint) {
                        i5 = 1;
                    }
                    parcel4.writeInt(i5);
                    return true;
                case 12:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    zzd view = getView();
                    parcel4.writeNoException();
                    IBinder iBinder5 = null;
                    if (view != null) {
                        iBinder5 = view.asBinder();
                    }
                    parcel4.writeStrongBinder(iBinder5);
                    return true;
                case 13:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean isAdded = isAdded();
                    parcel4.writeNoException();
                    int i6 = 0;
                    if (isAdded) {
                        i6 = 1;
                    }
                    parcel4.writeInt(i6);
                    return true;
                case 14:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean isDetached = isDetached();
                    parcel4.writeNoException();
                    int i7 = 0;
                    if (isDetached) {
                        i7 = 1;
                    }
                    parcel4.writeInt(i7);
                    return true;
                case 15:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean isHidden = isHidden();
                    parcel4.writeNoException();
                    int i8 = 0;
                    if (isHidden) {
                        i8 = 1;
                    }
                    parcel4.writeInt(i8);
                    return true;
                case 16:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean isInLayout = isInLayout();
                    parcel4.writeNoException();
                    int i9 = 0;
                    if (isInLayout) {
                        i9 = 1;
                    }
                    parcel4.writeInt(i9);
                    return true;
                case 17:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean isRemoving = isRemoving();
                    parcel4.writeNoException();
                    int i10 = 0;
                    if (isRemoving) {
                        i10 = 1;
                    }
                    parcel4.writeInt(i10);
                    return true;
                case 18:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean isResumed = isResumed();
                    parcel4.writeNoException();
                    int i11 = 0;
                    if (isResumed) {
                        i11 = 1;
                    }
                    parcel4.writeInt(i11);
                    return true;
                case 19:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean isVisible = isVisible();
                    parcel4.writeNoException();
                    int i12 = 0;
                    if (isVisible) {
                        i12 = 1;
                    }
                    parcel4.writeInt(i12);
                    return true;
                case 20:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    zzn(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 21:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    if (parcel3.readInt() != 0) {
                        z = true;
                    }
                    setHasOptionsMenu(z);
                    parcel4.writeNoException();
                    return true;
                case 22:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z2 = false;
                    if (parcel3.readInt() != 0) {
                        z2 = true;
                    }
                    setMenuVisibility(z2);
                    parcel4.writeNoException();
                    return true;
                case 23:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z3 = false;
                    if (parcel3.readInt() != 0) {
                        z3 = true;
                    }
                    setRetainInstance(z3);
                    parcel4.writeNoException();
                    return true;
                case 24:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z4 = false;
                    if (parcel3.readInt() != 0) {
                        z4 = true;
                    }
                    setUserVisibleHint(z4);
                    parcel4.writeNoException();
                    return true;
                case 25:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    Intent intent = null;
                    if (parcel3.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel3);
                    }
                    startActivity(intent);
                    parcel4.writeNoException();
                    return true;
                case 26:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    Intent intent2 = null;
                    if (parcel3.readInt() != 0) {
                        intent2 = (Intent) Intent.CREATOR.createFromParcel(parcel3);
                    }
                    startActivityForResult(intent2, parcel3.readInt());
                    parcel4.writeNoException();
                    return true;
                case 27:
                    parcel3.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    zzo(com.google.android.gms.dynamic.zzd.zza.zzbs(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 1598968902:
                    parcel4.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    zzd getView() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    void zzn(zzd zzd) throws RemoteException;

    void zzo(zzd zzd) throws RemoteException;

    zzd zztV() throws RemoteException;

    zzc zztW() throws RemoteException;

    zzd zztX() throws RemoteException;

    zzc zztY() throws RemoteException;
}

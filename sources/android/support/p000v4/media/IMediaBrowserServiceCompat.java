package android.support.p000v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p000v4.p002os.ResultReceiver;

/* renamed from: android.support.v4.media.IMediaBrowserServiceCompat */
public interface IMediaBrowserServiceCompat extends IInterface {

    /* renamed from: android.support.v4.media.IMediaBrowserServiceCompat$Stub */
    public static abstract class Stub extends Binder implements IMediaBrowserServiceCompat {
        private static final String DESCRIPTOR = "android.support.v4.media.IMediaBrowserServiceCompat";
        static final int TRANSACTION_addSubscription = 3;
        static final int TRANSACTION_connect = 1;
        static final int TRANSACTION_disconnect = 2;
        static final int TRANSACTION_getMediaItem = 5;
        static final int TRANSACTION_removeSubscription = 4;

        /* renamed from: android.support.v4.media.IMediaBrowserServiceCompat$Stub$Proxy */
        private static class Proxy implements IMediaBrowserServiceCompat {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void addSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                String str2 = str;
                IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    IBinder iBinder = null;
                    if (iMediaBrowserServiceCompatCallbacks2 != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean transact = this.mRemote.transact(3, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void connect(String str, Bundle bundle, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    if (iMediaBrowserServiceCompatCallbacks2 != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean transact = this.mRemote.transact(1, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public void disconnect(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    IBinder iBinder = null;
                    if (iMediaBrowserServiceCompatCallbacks2 != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean transact = this.mRemote.transact(2, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void getMediaItem(String str, ResultReceiver resultReceiver) throws RemoteException {
                String str2 = str;
                ResultReceiver resultReceiver2 = resultReceiver;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    if (resultReceiver2 != null) {
                        obtain.writeInt(1);
                        resultReceiver2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(5, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public void removeSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException {
                String str2 = str;
                IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    IBinder iBinder = null;
                    if (iMediaBrowserServiceCompatCallbacks2 != null) {
                        iBinder = iMediaBrowserServiceCompatCallbacks2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    boolean transact = this.mRemote.transact(4, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaBrowserServiceCompat asInterface(IBinder iBinder) {
            Proxy proxy;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaBrowserServiceCompat)) {
                return (IMediaBrowserServiceCompat) queryLocalInterface;
            }
            Proxy proxy2 = proxy;
            Proxy proxy3 = new Proxy(iBinder2);
            return proxy2;
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
                    parcel3.enforceInterface(DESCRIPTOR);
                    connect(parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null, android.support.p000v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(parcel3.readStrongBinder()));
                    return true;
                case 2:
                    parcel3.enforceInterface(DESCRIPTOR);
                    disconnect(android.support.p000v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(parcel3.readStrongBinder()));
                    return true;
                case 3:
                    parcel3.enforceInterface(DESCRIPTOR);
                    addSubscription(parcel3.readString(), android.support.p000v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(parcel3.readStrongBinder()));
                    return true;
                case 4:
                    parcel3.enforceInterface(DESCRIPTOR);
                    removeSubscription(parcel3.readString(), android.support.p000v4.media.IMediaBrowserServiceCompatCallbacks.Stub.asInterface(parcel3.readStrongBinder()));
                    return true;
                case 5:
                    parcel3.enforceInterface(DESCRIPTOR);
                    getMediaItem(parcel3.readString(), parcel3.readInt() != 0 ? (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel3) : null);
                    return true;
                case 1598968902:
                    parcel4.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void addSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;

    void connect(String str, Bundle bundle, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;

    void disconnect(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;

    void getMediaItem(String str, ResultReceiver resultReceiver) throws RemoteException;

    void removeSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) throws RemoteException;
}

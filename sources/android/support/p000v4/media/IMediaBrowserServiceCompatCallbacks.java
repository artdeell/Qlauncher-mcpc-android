package android.support.p000v4.media;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p000v4.media.session.MediaSessionCompat.Token;
import java.util.List;

/* renamed from: android.support.v4.media.IMediaBrowserServiceCompatCallbacks */
public interface IMediaBrowserServiceCompatCallbacks extends IInterface {

    /* renamed from: android.support.v4.media.IMediaBrowserServiceCompatCallbacks$Stub */
    public static abstract class Stub extends Binder implements IMediaBrowserServiceCompatCallbacks {
        private static final String DESCRIPTOR = "android.support.v4.media.IMediaBrowserServiceCompatCallbacks";
        static final int TRANSACTION_onConnect = 1;
        static final int TRANSACTION_onConnectFailed = 2;
        static final int TRANSACTION_onLoadChildren = 3;

        /* renamed from: android.support.v4.media.IMediaBrowserServiceCompatCallbacks$Stub$Proxy */
        private static class Proxy implements IMediaBrowserServiceCompatCallbacks {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onConnect(String str, Token token, Bundle bundle) throws RemoteException {
                String str2 = str;
                Token token2 = token;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    if (token2 != null) {
                        obtain.writeInt(1);
                        token2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(1, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public void onConnectFailed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(2, obtain, null, 1);
                    obtain.recycle();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            }

            public void onLoadChildren(String str, List list) throws RemoteException {
                String str2 = str;
                List list2 = list;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    obtain.writeList(list2);
                    boolean transact = this.mRemote.transact(3, obtain, null, 1);
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

        public static IMediaBrowserServiceCompatCallbacks asInterface(IBinder iBinder) {
            Proxy proxy;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaBrowserServiceCompatCallbacks)) {
                return (IMediaBrowserServiceCompatCallbacks) queryLocalInterface;
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
                    onConnect(parcel3.readString(), parcel3.readInt() != 0 ? (Token) Token.CREATOR.createFromParcel(parcel3) : null, parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    return true;
                case 2:
                    parcel3.enforceInterface(DESCRIPTOR);
                    onConnectFailed();
                    return true;
                case 3:
                    parcel3.enforceInterface(DESCRIPTOR);
                    onLoadChildren(parcel3.readString(), parcel3.readArrayList(getClass().getClassLoader()));
                    return true;
                case 1598968902:
                    parcel4.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void onConnect(String str, Token token, Bundle bundle) throws RemoteException;

    void onConnectFailed() throws RemoteException;

    void onLoadChildren(String str, List list) throws RemoteException;
}

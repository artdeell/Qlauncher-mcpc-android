package android.support.p000v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p000v4.media.MediaMetadataCompat;
import android.support.p000v4.media.RatingCompat;
import android.support.p000v4.media.session.MediaSessionCompat.QueueItem;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.IMediaSession */
public interface IMediaSession extends IInterface {

    /* renamed from: android.support.v4.media.session.IMediaSession$Stub */
    public static abstract class Stub extends Binder implements IMediaSession {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
        static final int TRANSACTION_adjustVolume = 11;
        static final int TRANSACTION_fastForward = 22;
        static final int TRANSACTION_getExtras = 31;
        static final int TRANSACTION_getFlags = 9;
        static final int TRANSACTION_getLaunchPendingIntent = 8;
        static final int TRANSACTION_getMetadata = 27;
        static final int TRANSACTION_getPackageName = 6;
        static final int TRANSACTION_getPlaybackState = 28;
        static final int TRANSACTION_getQueue = 29;
        static final int TRANSACTION_getQueueTitle = 30;
        static final int TRANSACTION_getRatingType = 32;
        static final int TRANSACTION_getTag = 7;
        static final int TRANSACTION_getVolumeAttributes = 10;
        static final int TRANSACTION_isTransportControlEnabled = 5;
        static final int TRANSACTION_next = 20;
        static final int TRANSACTION_pause = 18;
        static final int TRANSACTION_play = 13;
        static final int TRANSACTION_playFromMediaId = 14;
        static final int TRANSACTION_playFromSearch = 15;
        static final int TRANSACTION_playFromUri = 16;
        static final int TRANSACTION_previous = 21;
        static final int TRANSACTION_rate = 25;
        static final int TRANSACTION_registerCallbackListener = 3;
        static final int TRANSACTION_rewind = 23;
        static final int TRANSACTION_seekTo = 24;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendCustomAction = 26;
        static final int TRANSACTION_sendMediaButton = 2;
        static final int TRANSACTION_setVolumeTo = 12;
        static final int TRANSACTION_skipToQueueItem = 17;
        static final int TRANSACTION_stop = 19;
        static final int TRANSACTION_unregisterCallbackListener = 4;

        /* renamed from: android.support.v4.media.session.IMediaSession$Stub$Proxy */
        private static class Proxy implements IMediaSession {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public void adjustVolume(int i, int i2, String str) throws RemoteException {
                int i3 = i;
                int i4 = i2;
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeString(str2);
                    boolean transact = this.mRemote.transact(11, obtain, obtain2, 0);
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

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void fastForward() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(22, obtain, obtain2, 0);
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

            public Bundle getExtras() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(31, obtain, obtain2, 0);
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
            public long getFlags() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    obtain2.recycle();
                    obtain.recycle();
                    return readLong;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    PendingIntent pendingIntent = obtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return pendingIntent;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public MediaMetadataCompat getMetadata() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    MediaMetadataCompat mediaMetadataCompat = obtain2.readInt() != 0 ? (MediaMetadataCompat) MediaMetadataCompat.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return mediaMetadataCompat;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public String getPackageName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(6, obtain, obtain2, 0);
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

            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    PlaybackStateCompat playbackStateCompat = obtain2.readInt() != 0 ? (PlaybackStateCompat) PlaybackStateCompat.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return playbackStateCompat;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public List<QueueItem> getQueue() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    ArrayList createTypedArrayList = obtain2.createTypedArrayList(QueueItem.CREATOR);
                    obtain2.recycle();
                    obtain.recycle();
                    return createTypedArrayList;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public CharSequence getQueueTitle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    CharSequence charSequence = obtain2.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return charSequence;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            /* JADX INFO: finally extract failed */
            public int getRatingType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(32, obtain, obtain2, 0);
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

            /* JADX INFO: finally extract failed */
            public String getTag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(7, obtain, obtain2, 0);
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

            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    ParcelableVolumeInfo parcelableVolumeInfo = obtain2.readInt() != 0 ? (ParcelableVolumeInfo) ParcelableVolumeInfo.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelableVolumeInfo;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th2;
                }
            }

            public boolean isTransportControlEnabled() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(5, obtain, obtain2, 0);
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

            public void next() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(20, obtain, obtain2, 0);
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

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(18, obtain, obtain2, 0);
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

            public void play() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(13, obtain, obtain2, 0);
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

            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(14, obtain, obtain2, 0);
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

            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(15, obtain, obtain2, 0);
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

            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Uri uri2 = uri;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(16, obtain, obtain2, 0);
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

            public void previous() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(21, obtain, obtain2, 0);
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

            public void rate(RatingCompat ratingCompat) throws RemoteException {
                RatingCompat ratingCompat2 = ratingCompat;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (ratingCompat2 != null) {
                        obtain.writeInt(1);
                        ratingCompat2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(25, obtain, obtain2, 0);
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

            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                IMediaControllerCallback iMediaControllerCallback2 = iMediaControllerCallback;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaControllerCallback2 != null ? iMediaControllerCallback2.asBinder() : null);
                    boolean transact = this.mRemote.transact(3, obtain, obtain2, 0);
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

            public void rewind() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(23, obtain, obtain2, 0);
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

            public void seekTo(long j) throws RemoteException {
                long j2 = j;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j2);
                    boolean transact = this.mRemote.transact(24, obtain, obtain2, 0);
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

            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                ResultReceiverWrapper resultReceiverWrapper2 = resultReceiverWrapper;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiverWrapper2 != null) {
                        obtain.writeInt(1);
                        resultReceiverWrapper2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(1, obtain, obtain2, 0);
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

            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                String str2 = str;
                Bundle bundle2 = bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str2);
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(26, obtain, obtain2, 0);
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

            public boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException {
                KeyEvent keyEvent2 = keyEvent;
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (keyEvent2 != null) {
                        obtain.writeInt(1);
                        keyEvent2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    boolean transact = this.mRemote.transact(2, obtain, obtain2, 0);
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

            public void setVolumeTo(int i, int i2, String str) throws RemoteException {
                int i3 = i;
                int i4 = i2;
                String str2 = str;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeString(str2);
                    boolean transact = this.mRemote.transact(12, obtain, obtain2, 0);
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

            public void skipToQueueItem(long j) throws RemoteException {
                long j2 = j;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j2);
                    boolean transact = this.mRemote.transact(17, obtain, obtain2, 0);
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

            public void stop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean transact = this.mRemote.transact(19, obtain, obtain2, 0);
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

            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                IMediaControllerCallback iMediaControllerCallback2 = iMediaControllerCallback;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iMediaControllerCallback2 != null ? iMediaControllerCallback2.asBinder() : null);
                    boolean transact = this.mRemote.transact(4, obtain, obtain2, 0);
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

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            Proxy proxy;
            IBinder iBinder2 = iBinder;
            if (iBinder2 == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder2.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) queryLocalInterface;
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
                    sendCommand(parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null, parcel3.readInt() != 0 ? (ResultReceiverWrapper) ResultReceiverWrapper.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 2:
                    parcel3.enforceInterface(DESCRIPTOR);
                    boolean sendMediaButton = sendMediaButton(parcel3.readInt() != 0 ? (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    int i5 = 0;
                    if (sendMediaButton) {
                        i5 = 1;
                    }
                    parcel4.writeInt(i5);
                    return true;
                case 3:
                    parcel3.enforceInterface(DESCRIPTOR);
                    registerCallbackListener(android.support.p000v4.media.session.IMediaControllerCallback.Stub.asInterface(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 4:
                    parcel3.enforceInterface(DESCRIPTOR);
                    unregisterCallbackListener(android.support.p000v4.media.session.IMediaControllerCallback.Stub.asInterface(parcel3.readStrongBinder()));
                    parcel4.writeNoException();
                    return true;
                case 5:
                    parcel3.enforceInterface(DESCRIPTOR);
                    boolean isTransportControlEnabled = isTransportControlEnabled();
                    parcel4.writeNoException();
                    int i6 = 0;
                    if (isTransportControlEnabled) {
                        i6 = 1;
                    }
                    parcel4.writeInt(i6);
                    return true;
                case 6:
                    parcel3.enforceInterface(DESCRIPTOR);
                    String packageName = getPackageName();
                    parcel4.writeNoException();
                    parcel4.writeString(packageName);
                    return true;
                case 7:
                    parcel3.enforceInterface(DESCRIPTOR);
                    String tag = getTag();
                    parcel4.writeNoException();
                    parcel4.writeString(tag);
                    return true;
                case 8:
                    parcel3.enforceInterface(DESCRIPTOR);
                    PendingIntent launchPendingIntent = getLaunchPendingIntent();
                    parcel4.writeNoException();
                    if (launchPendingIntent != null) {
                        parcel4.writeInt(1);
                        launchPendingIntent.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 9:
                    parcel3.enforceInterface(DESCRIPTOR);
                    long flags = getFlags();
                    parcel4.writeNoException();
                    parcel4.writeLong(flags);
                    return true;
                case 10:
                    parcel3.enforceInterface(DESCRIPTOR);
                    ParcelableVolumeInfo volumeAttributes = getVolumeAttributes();
                    parcel4.writeNoException();
                    if (volumeAttributes != null) {
                        parcel4.writeInt(1);
                        volumeAttributes.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 11:
                    parcel3.enforceInterface(DESCRIPTOR);
                    adjustVolume(parcel3.readInt(), parcel3.readInt(), parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 12:
                    parcel3.enforceInterface(DESCRIPTOR);
                    setVolumeTo(parcel3.readInt(), parcel3.readInt(), parcel3.readString());
                    parcel4.writeNoException();
                    return true;
                case 13:
                    parcel3.enforceInterface(DESCRIPTOR);
                    play();
                    parcel4.writeNoException();
                    return true;
                case 14:
                    parcel3.enforceInterface(DESCRIPTOR);
                    playFromMediaId(parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 15:
                    parcel3.enforceInterface(DESCRIPTOR);
                    playFromSearch(parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 16:
                    parcel3.enforceInterface(DESCRIPTOR);
                    playFromUri(parcel3.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel3) : null, parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 17:
                    parcel3.enforceInterface(DESCRIPTOR);
                    skipToQueueItem(parcel3.readLong());
                    parcel4.writeNoException();
                    return true;
                case 18:
                    parcel3.enforceInterface(DESCRIPTOR);
                    pause();
                    parcel4.writeNoException();
                    return true;
                case 19:
                    parcel3.enforceInterface(DESCRIPTOR);
                    stop();
                    parcel4.writeNoException();
                    return true;
                case 20:
                    parcel3.enforceInterface(DESCRIPTOR);
                    next();
                    parcel4.writeNoException();
                    return true;
                case 21:
                    parcel3.enforceInterface(DESCRIPTOR);
                    previous();
                    parcel4.writeNoException();
                    return true;
                case 22:
                    parcel3.enforceInterface(DESCRIPTOR);
                    fastForward();
                    parcel4.writeNoException();
                    return true;
                case 23:
                    parcel3.enforceInterface(DESCRIPTOR);
                    rewind();
                    parcel4.writeNoException();
                    return true;
                case 24:
                    parcel3.enforceInterface(DESCRIPTOR);
                    seekTo(parcel3.readLong());
                    parcel4.writeNoException();
                    return true;
                case 25:
                    parcel3.enforceInterface(DESCRIPTOR);
                    rate(parcel3.readInt() != 0 ? (RatingCompat) RatingCompat.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 26:
                    parcel3.enforceInterface(DESCRIPTOR);
                    sendCustomAction(parcel3.readString(), parcel3.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel3) : null);
                    parcel4.writeNoException();
                    return true;
                case 27:
                    parcel3.enforceInterface(DESCRIPTOR);
                    MediaMetadataCompat metadata = getMetadata();
                    parcel4.writeNoException();
                    if (metadata != null) {
                        parcel4.writeInt(1);
                        metadata.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 28:
                    parcel3.enforceInterface(DESCRIPTOR);
                    PlaybackStateCompat playbackState = getPlaybackState();
                    parcel4.writeNoException();
                    if (playbackState != null) {
                        parcel4.writeInt(1);
                        playbackState.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 29:
                    parcel3.enforceInterface(DESCRIPTOR);
                    List queue = getQueue();
                    parcel4.writeNoException();
                    parcel4.writeTypedList(queue);
                    return true;
                case 30:
                    parcel3.enforceInterface(DESCRIPTOR);
                    CharSequence queueTitle = getQueueTitle();
                    parcel4.writeNoException();
                    if (queueTitle != null) {
                        parcel4.writeInt(1);
                        TextUtils.writeToParcel(queueTitle, parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 31:
                    parcel3.enforceInterface(DESCRIPTOR);
                    Bundle extras = getExtras();
                    parcel4.writeNoException();
                    if (extras != null) {
                        parcel4.writeInt(1);
                        extras.writeToParcel(parcel4, 1);
                        return true;
                    }
                    parcel4.writeInt(0);
                    return true;
                case 32:
                    parcel3.enforceInterface(DESCRIPTOR);
                    int ratingType = getRatingType();
                    parcel4.writeNoException();
                    parcel4.writeInt(ratingType);
                    return true;
                case 1598968902:
                    parcel4.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i3, parcel3, parcel4, i4);
            }
        }
    }

    void adjustVolume(int i, int i2, String str) throws RemoteException;

    void fastForward() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    PendingIntent getLaunchPendingIntent() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    PlaybackStateCompat getPlaybackState() throws RemoteException;

    List<QueueItem> getQueue() throws RemoteException;

    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    String getTag() throws RemoteException;

    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(String str, Bundle bundle) throws RemoteException;

    void playFromSearch(String str, Bundle bundle) throws RemoteException;

    void playFromUri(Uri uri, Bundle bundle) throws RemoteException;

    void previous() throws RemoteException;

    void rate(RatingCompat ratingCompat) throws RemoteException;

    void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long j) throws RemoteException;

    void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    void sendCustomAction(String str, Bundle bundle) throws RemoteException;

    boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException;

    void setVolumeTo(int i, int i2, String str) throws RemoteException;

    void skipToQueueItem(long j) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;
}

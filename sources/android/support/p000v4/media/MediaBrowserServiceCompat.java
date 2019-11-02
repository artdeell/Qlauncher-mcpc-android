package android.support.p000v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.media.IMediaBrowserServiceCompat.Stub;
import android.support.p000v4.media.MediaBrowserCompat.MediaItem;
import android.support.p000v4.media.session.MediaSessionCompat.Token;
import android.support.p000v4.p002os.ResultReceiver;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserServiceCompat */
public abstract class MediaBrowserServiceCompat extends Service {
    private static final boolean DBG = false;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserServiceCompat";
    private static final String TAG = "MediaBrowserServiceCompat";
    private ServiceBinder mBinder;
    /* access modifiers changed from: private */
    public final ArrayMap<IBinder, ConnectionRecord> mConnections;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    Token mSession;

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$BrowserRoot */
    public static final class BrowserRoot {
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            IllegalArgumentException illegalArgumentException;
            String str2 = str;
            Bundle bundle2 = bundle;
            if (str2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
                throw illegalArgumentException2;
            }
            this.mRootId = str2;
            this.mExtras = bundle2;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String getRootId() {
            return this.mRootId;
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord */
    private class ConnectionRecord {
        IMediaBrowserServiceCompatCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashSet<String> subscriptions;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        private ConnectionRecord(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            HashSet<String> hashSet;
            this.this$0 = mediaBrowserServiceCompat;
            HashSet<String> hashSet2 = hashSet;
            HashSet<String> hashSet3 = new HashSet<>();
            this.subscriptions = hashSet2;
        }

        /* synthetic */ ConnectionRecord(MediaBrowserServiceCompat mediaBrowserServiceCompat, C00521 r7) {
            C00521 r2 = r7;
            this(mediaBrowserServiceCompat);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$Result */
    public class Result<T> {
        private Object mDebug;
        private boolean mDetachCalled;
        private boolean mSendResultCalled;
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        Result(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj) {
            Object obj2 = obj;
            this.this$0 = mediaBrowserServiceCompat;
            this.mDebug = obj2;
        }

        public void detach() {
            IllegalStateException illegalStateException;
            StringBuilder sb;
            IllegalStateException illegalStateException2;
            StringBuilder sb2;
            if (this.mDetachCalled) {
                IllegalStateException illegalStateException3 = illegalStateException2;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                IllegalStateException illegalStateException4 = new IllegalStateException(sb3.append("detach() called when detach() had already been called for: ").append(this.mDebug).toString());
                throw illegalStateException3;
            } else if (this.mSendResultCalled) {
                IllegalStateException illegalStateException5 = illegalStateException;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                IllegalStateException illegalStateException6 = new IllegalStateException(sb5.append("detach() called when sendResult() had already been called for: ").append(this.mDebug).toString());
                throw illegalStateException5;
            } else {
                this.mDetachCalled = true;
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled;
        }

        /* access modifiers changed from: 0000 */
        public void onResultSent(T t) {
        }

        public void sendResult(T t) {
            IllegalStateException illegalStateException;
            StringBuilder sb;
            T t2 = t;
            if (this.mSendResultCalled) {
                IllegalStateException illegalStateException2 = illegalStateException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("sendResult() called twice for: ").append(this.mDebug).toString());
                throw illegalStateException2;
            }
            this.mSendResultCalled = true;
            onResultSent(t2);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ServiceBinder */
    private class ServiceBinder extends Stub {
        final /* synthetic */ MediaBrowserServiceCompat this$0;

        private ServiceBinder(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.this$0 = mediaBrowserServiceCompat;
        }

        /* synthetic */ ServiceBinder(MediaBrowserServiceCompat mediaBrowserServiceCompat, C00521 r7) {
            C00521 r2 = r7;
            this(mediaBrowserServiceCompat);
        }

        public void addSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            C00583 r9;
            String str2 = str;
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            Handler access$300 = this.this$0.mHandler;
            C00583 r4 = r9;
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks3 = iMediaBrowserServiceCompatCallbacks2;
            final String str3 = str2;
            C00583 r5 = new Runnable(this) {
                final /* synthetic */ ServiceBinder this$1;

                {
                    IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks = r8;
                    String str = r9;
                    this.this$1 = r7;
                }

                public void run() {
                    StringBuilder sb;
                    ConnectionRecord connectionRecord = (ConnectionRecord) this.this$1.this$0.mConnections.get(iMediaBrowserServiceCompatCallbacks3.asBinder());
                    if (connectionRecord == null) {
                        String str = MediaBrowserServiceCompat.TAG;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int w = Log.w(str, sb2.append("addSubscription for callback that isn't registered id=").append(str3).toString());
                        return;
                    }
                    this.this$1.this$0.addSubscription(str3, connectionRecord);
                }
            };
            boolean post = access$300.post(r4);
        }

        public void connect(String str, Bundle bundle, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            C00561 r13;
            IllegalArgumentException illegalArgumentException;
            StringBuilder sb;
            String str2 = str;
            Bundle bundle2 = bundle;
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            int callingUid = Binder.getCallingUid();
            if (!this.this$0.isValidPackage(str2, callingUid)) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Package/uid mismatch: uid=").append(callingUid).append(" package=").append(str2).toString());
                throw illegalArgumentException2;
            }
            Handler access$300 = this.this$0.mHandler;
            C00561 r6 = r13;
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks3 = iMediaBrowserServiceCompatCallbacks2;
            final String str3 = str2;
            final Bundle bundle3 = bundle2;
            final int i = callingUid;
            C00561 r7 = new Runnable(this) {
                final /* synthetic */ ServiceBinder this$1;

                {
                    IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks = r10;
                    String str = r11;
                    Bundle bundle = r12;
                    int i = r13;
                    this.this$1 = r9;
                }

                public void run() {
                    ConnectionRecord connectionRecord;
                    StringBuilder sb;
                    StringBuilder sb2;
                    StringBuilder sb3;
                    IBinder asBinder = iMediaBrowserServiceCompatCallbacks3.asBinder();
                    Object remove = this.this$1.this$0.mConnections.remove(asBinder);
                    ConnectionRecord connectionRecord2 = connectionRecord;
                    ConnectionRecord connectionRecord3 = new ConnectionRecord(this.this$1.this$0, null);
                    ConnectionRecord connectionRecord4 = connectionRecord2;
                    connectionRecord4.pkg = str3;
                    connectionRecord4.rootHints = bundle3;
                    connectionRecord4.callbacks = iMediaBrowserServiceCompatCallbacks3;
                    connectionRecord4.root = this.this$1.this$0.onGetRoot(str3, i, bundle3);
                    if (connectionRecord4.root == null) {
                        String str = MediaBrowserServiceCompat.TAG;
                        StringBuilder sb4 = sb2;
                        StringBuilder sb5 = new StringBuilder();
                        int i = Log.i(str, sb4.append("No root for client ").append(str3).append(" from service ").append(getClass().getName()).toString());
                        try {
                            iMediaBrowserServiceCompatCallbacks3.onConnectFailed();
                        } catch (RemoteException e) {
                            RemoteException remoteException = e;
                            String str2 = MediaBrowserServiceCompat.TAG;
                            StringBuilder sb6 = sb3;
                            StringBuilder sb7 = new StringBuilder();
                            int w = Log.w(str2, sb6.append("Calling onConnectFailed() failed. Ignoring. pkg=").append(str3).toString());
                        }
                    } else {
                        try {
                            Object put = this.this$1.this$0.mConnections.put(asBinder, connectionRecord4);
                            if (this.this$1.this$0.mSession != null) {
                                iMediaBrowserServiceCompatCallbacks3.onConnect(connectionRecord4.root.getRootId(), this.this$1.this$0.mSession, connectionRecord4.root.getExtras());
                            }
                        } catch (RemoteException e2) {
                            RemoteException remoteException2 = e2;
                            String str3 = MediaBrowserServiceCompat.TAG;
                            StringBuilder sb8 = sb;
                            StringBuilder sb9 = new StringBuilder();
                            int w2 = Log.w(str3, sb8.append("Calling onConnect() failed. Dropping client. pkg=").append(str3).toString());
                            Object remove2 = this.this$1.this$0.mConnections.remove(asBinder);
                        }
                    }
                }
            };
            boolean post = access$300.post(r6);
        }

        public void disconnect(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            C00572 r7;
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            Handler access$300 = this.this$0.mHandler;
            C00572 r3 = r7;
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks3 = iMediaBrowserServiceCompatCallbacks2;
            C00572 r4 = new Runnable(this) {
                final /* synthetic */ ServiceBinder this$1;

                {
                    IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks = r7;
                    this.this$1 = r6;
                }

                public void run() {
                    if (((ConnectionRecord) this.this$1.this$0.mConnections.remove(iMediaBrowserServiceCompatCallbacks3.asBinder())) != null) {
                    }
                }
            };
            boolean post = access$300.post(r3);
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver) {
            C00605 r9;
            String str2 = str;
            ResultReceiver resultReceiver2 = resultReceiver;
            if (!TextUtils.isEmpty(str2) && resultReceiver2 != null) {
                Handler access$300 = this.this$0.mHandler;
                C00605 r4 = r9;
                final String str3 = str2;
                final ResultReceiver resultReceiver3 = resultReceiver2;
                C00605 r5 = new Runnable(this) {
                    final /* synthetic */ ServiceBinder this$1;

                    {
                        String str = r8;
                        ResultReceiver resultReceiver = r9;
                        this.this$1 = r7;
                    }

                    public void run() {
                        this.this$1.this$0.performLoadItem(str3, resultReceiver3);
                    }
                };
                boolean post = access$300.post(r4);
            }
        }

        public void removeSubscription(String str, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            C00594 r9;
            String str2 = str;
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            Handler access$300 = this.this$0.mHandler;
            C00594 r4 = r9;
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks3 = iMediaBrowserServiceCompatCallbacks2;
            final String str3 = str2;
            C00594 r5 = new Runnable(this) {
                final /* synthetic */ ServiceBinder this$1;

                {
                    IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks = r8;
                    String str = r9;
                    this.this$1 = r7;
                }

                public void run() {
                    StringBuilder sb;
                    StringBuilder sb2;
                    ConnectionRecord connectionRecord = (ConnectionRecord) this.this$1.this$0.mConnections.get(iMediaBrowserServiceCompatCallbacks3.asBinder());
                    if (connectionRecord == null) {
                        String str = MediaBrowserServiceCompat.TAG;
                        StringBuilder sb3 = sb2;
                        StringBuilder sb4 = new StringBuilder();
                        int w = Log.w(str, sb3.append("removeSubscription for callback that isn't registered id=").append(str3).toString());
                    } else if (!connectionRecord.subscriptions.remove(str3)) {
                        String str2 = MediaBrowserServiceCompat.TAG;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        int w2 = Log.w(str2, sb5.append("removeSubscription called for ").append(str3).append(" which is not subscribed").toString());
                    }
                }
            };
            boolean post = access$300.post(r4);
        }
    }

    public MediaBrowserServiceCompat() {
        ArrayMap<IBinder, ConnectionRecord> arrayMap;
        Handler handler;
        ArrayMap<IBinder, ConnectionRecord> arrayMap2 = arrayMap;
        ArrayMap<IBinder, ConnectionRecord> arrayMap3 = new ArrayMap<>();
        this.mConnections = arrayMap2;
        Handler handler2 = handler;
        Handler handler3 = new Handler();
        this.mHandler = handler2;
    }

    /* access modifiers changed from: private */
    public void addSubscription(String str, ConnectionRecord connectionRecord) {
        String str2 = str;
        ConnectionRecord connectionRecord2 = connectionRecord;
        boolean add = connectionRecord2.subscriptions.add(str2);
        performLoadChildren(str2, connectionRecord2);
    }

    /* access modifiers changed from: private */
    public boolean isValidPackage(String str, int i) {
        String str2 = str;
        int i2 = i;
        if (str2 != null) {
            String[] packagesForUid = getPackageManager().getPackagesForUid(i2);
            int length = packagesForUid.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (packagesForUid[i3].equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void performLoadChildren(String str, ConnectionRecord connectionRecord) {
        C00543 r10;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        String str2 = str;
        ConnectionRecord connectionRecord2 = connectionRecord;
        C00543 r4 = r10;
        final String str3 = str2;
        final ConnectionRecord connectionRecord3 = connectionRecord2;
        C00543 r5 = new Result<List<MediaItem>>(this, str2) {
            final /* synthetic */ MediaBrowserServiceCompat this$0;

            {
                MediaBrowserServiceCompat mediaBrowserServiceCompat = r9;
                Object obj = r10;
                String str = r11;
                ConnectionRecord connectionRecord = r12;
                this.this$0 = mediaBrowserServiceCompat;
            }

            /* access modifiers changed from: 0000 */
            public void onResultSent(List<MediaItem> list) {
                StringBuilder sb;
                IllegalStateException illegalStateException;
                StringBuilder sb2;
                List<MediaItem> list2 = list;
                if (list2 == null) {
                    IllegalStateException illegalStateException2 = illegalStateException;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    IllegalStateException illegalStateException3 = new IllegalStateException(sb3.append("onLoadChildren sent null list for id ").append(str3).toString());
                    throw illegalStateException2;
                } else if (this.this$0.mConnections.get(connectionRecord3.callbacks.asBinder()) == connectionRecord3) {
                    try {
                        connectionRecord3.callbacks.onLoadChildren(str3, list2);
                    } catch (RemoteException e) {
                        RemoteException remoteException = e;
                        String str = MediaBrowserServiceCompat.TAG;
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        int w = Log.w(str, sb5.append("Calling onLoadChildren() failed for id=").append(str3).append(" package=").append(connectionRecord3.pkg).toString());
                    }
                }
            }
        };
        C00543 r3 = r4;
        onLoadChildren(str2, r3);
        if (!r3.isDone()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("onLoadChildren must call detach() or sendResult() before returning for package=").append(connectionRecord2.pkg).append(" id=").append(str2).toString());
            throw illegalStateException2;
        }
    }

    /* access modifiers changed from: private */
    public void performLoadItem(String str, ResultReceiver resultReceiver) {
        C00554 r9;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        String str2 = str;
        C00554 r4 = r9;
        final ResultReceiver resultReceiver2 = resultReceiver;
        C00554 r5 = new Result<MediaItem>(this, str2) {
            final /* synthetic */ MediaBrowserServiceCompat this$0;

            {
                MediaBrowserServiceCompat mediaBrowserServiceCompat = r8;
                Object obj = r9;
                ResultReceiver resultReceiver = r10;
                this.this$0 = mediaBrowserServiceCompat;
            }

            /* access modifiers changed from: 0000 */
            public void onResultSent(MediaItem mediaItem) {
                Bundle bundle;
                MediaItem mediaItem2 = mediaItem;
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                Bundle bundle4 = bundle2;
                bundle4.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem2);
                resultReceiver2.send(0, bundle4);
            }
        };
        C00554 r3 = r4;
        onLoadItem(str2, r3);
        if (!r3.isDone()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("onLoadItem must call detach() or sendResult() before returning for id=").append(str2).toString());
            throw illegalStateException2;
        }
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Nullable
    public Token getSessionToken() {
        return this.mSession;
    }

    public void notifyChildrenChanged(@NonNull String str) {
        C00532 r7;
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        if (str2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
            throw illegalArgumentException2;
        }
        Handler handler = this.mHandler;
        C00532 r3 = r7;
        final String str3 = str2;
        C00532 r4 = new Runnable(this) {
            final /* synthetic */ MediaBrowserServiceCompat this$0;

            {
                String str = r7;
                this.this$0 = r6;
            }

            public void run() {
                for (IBinder iBinder : this.this$0.mConnections.keySet()) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) this.this$0.mConnections.get(iBinder);
                    if (connectionRecord.subscriptions.contains(str3)) {
                        this.this$0.performLoadChildren(str3, connectionRecord);
                    }
                }
            }
        };
        boolean post = handler.post(r3);
    }

    public IBinder onBind(Intent intent) {
        if (SERVICE_INTERFACE.equals(intent.getAction())) {
            return this.mBinder;
        }
        return null;
    }

    public void onCreate() {
        ServiceBinder serviceBinder;
        super.onCreate();
        ServiceBinder serviceBinder2 = serviceBinder;
        ServiceBinder serviceBinder3 = new ServiceBinder(this, null);
        this.mBinder = serviceBinder2;
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaItem>> result);

    public void onLoadItem(String str, Result<MediaItem> result) {
        String str2 = str;
        result.sendResult(null);
    }

    public void setSessionToken(Token token) {
        C00521 r7;
        IllegalStateException illegalStateException;
        IllegalArgumentException illegalArgumentException;
        Token token2 = token;
        if (token2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Session token may not be null.");
            throw illegalArgumentException2;
        } else if (this.mSession != null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("The session token has already been set.");
            throw illegalStateException2;
        } else {
            this.mSession = token2;
            Handler handler = this.mHandler;
            C00521 r3 = r7;
            final Token token3 = token2;
            C00521 r4 = new Runnable(this) {
                final /* synthetic */ MediaBrowserServiceCompat this$0;

                {
                    Token token = r7;
                    this.this$0 = r6;
                }

                public void run() {
                    StringBuilder sb;
                    for (IBinder iBinder : this.this$0.mConnections.keySet()) {
                        ConnectionRecord connectionRecord = (ConnectionRecord) this.this$0.mConnections.get(iBinder);
                        try {
                            connectionRecord.callbacks.onConnect(connectionRecord.root.getRootId(), token3, connectionRecord.root.getExtras());
                        } catch (RemoteException e) {
                            RemoteException remoteException = e;
                            String str = MediaBrowserServiceCompat.TAG;
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            int w = Log.w(str, sb2.append("Connection for ").append(connectionRecord.pkg).append(" is no longer valid.").toString());
                            Object remove = this.this$0.mConnections.remove(iBinder);
                        }
                    }
                }
            };
            boolean post = handler.post(r3);
        }
    }
}

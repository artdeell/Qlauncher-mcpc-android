package android.support.p000v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.media.IMediaBrowserServiceCompat.Stub;
import android.support.p000v4.media.session.MediaSessionCompat.Token;
import android.support.p000v4.p002os.ResultReceiver;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {
    private final MediaBrowserImplBase mImpl;

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback */
    public static class ConnectionCallback {
        public ConnectionCallback() {
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback */
    public static abstract class ItemCallback {
        public ItemCallback() {
        }

        public void onError(@NonNull String str) {
        }

        public void onItemLoaded(MediaItem mediaItem) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase */
    static class MediaBrowserImplBase {
        private static final int CONNECT_STATE_CONNECTED = 2;
        private static final int CONNECT_STATE_CONNECTING = 1;
        private static final int CONNECT_STATE_DISCONNECTED = 0;
        private static final int CONNECT_STATE_SUSPENDED = 3;
        private static final boolean DBG = false;
        private static final String TAG = "MediaBrowserCompat";
        /* access modifiers changed from: private */
        public final ConnectionCallback mCallback;
        /* access modifiers changed from: private */
        public final Context mContext;
        private Bundle mExtras;
        private final Handler mHandler;
        private Token mMediaSessionToken;
        /* access modifiers changed from: private */
        public final Bundle mRootHints;
        private String mRootId;
        /* access modifiers changed from: private */
        public IMediaBrowserServiceCompat mServiceBinder;
        /* access modifiers changed from: private */
        public IMediaBrowserServiceCompatCallbacks mServiceCallbacks;
        /* access modifiers changed from: private */
        public final ComponentName mServiceComponent;
        /* access modifiers changed from: private */
        public MediaServiceConnection mServiceConnection;
        /* access modifiers changed from: private */
        public int mState = 0;
        /* access modifiers changed from: private */
        public final ArrayMap<String, Subscription> mSubscriptions;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection */
        private class MediaServiceConnection implements ServiceConnection {
            final /* synthetic */ MediaBrowserImplBase this$0;

            private MediaServiceConnection(MediaBrowserImplBase mediaBrowserImplBase) {
                this.this$0 = mediaBrowserImplBase;
            }

            /* synthetic */ MediaServiceConnection(MediaBrowserImplBase mediaBrowserImplBase, C00431 r7) {
                C00431 r2 = r7;
                this(mediaBrowserImplBase);
            }

            private boolean isCurrent(String str) {
                StringBuilder sb;
                String str2 = str;
                if (this.this$0.mServiceConnection == this) {
                    return true;
                }
                if (this.this$0.mState != 0) {
                    String str3 = MediaBrowserImplBase.TAG;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int i = Log.i(str3, sb2.append(str2).append(" for ").append(this.this$0.mServiceComponent).append(" with mServiceConnection=").append(this.this$0.mServiceConnection).append(" this=").append(this).toString());
                }
                return false;
            }

            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                StringBuilder sb;
                ComponentName componentName2 = componentName;
                IBinder iBinder2 = iBinder;
                if (isCurrent("onServiceConnected")) {
                    IMediaBrowserServiceCompat access$1302 = MediaBrowserImplBase.access$1302(this.this$0, Stub.asInterface(iBinder2));
                    IMediaBrowserServiceCompatCallbacks access$1202 = MediaBrowserImplBase.access$1202(this.this$0, this.this$0.getNewServiceCallbacks());
                    int access$602 = MediaBrowserImplBase.access$602(this.this$0, 1);
                    try {
                        this.this$0.mServiceBinder.connect(this.this$0.mContext.getPackageName(), this.this$0.mRootHints, this.this$0.mServiceCallbacks);
                    } catch (RemoteException e) {
                        RemoteException remoteException = e;
                        String str = MediaBrowserImplBase.TAG;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int w = Log.w(str, sb2.append("RemoteException during connect for ").append(this.this$0.mServiceComponent).toString());
                    }
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                ComponentName componentName2 = componentName;
                if (isCurrent("onServiceDisconnected")) {
                    IMediaBrowserServiceCompat access$1302 = MediaBrowserImplBase.access$1302(this.this$0, null);
                    IMediaBrowserServiceCompatCallbacks access$1202 = MediaBrowserImplBase.access$1202(this.this$0, null);
                    int access$602 = MediaBrowserImplBase.access$602(this.this$0, 3);
                    this.this$0.mCallback.onConnectionSuspended();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$ServiceCallbacks */
        private static class ServiceCallbacks extends IMediaBrowserServiceCompatCallbacks.Stub {
            private WeakReference<MediaBrowserImplBase> mMediaBrowser;

            public ServiceCallbacks(MediaBrowserImplBase mediaBrowserImplBase) {
                WeakReference<MediaBrowserImplBase> weakReference;
                WeakReference<MediaBrowserImplBase> weakReference2 = weakReference;
                WeakReference<MediaBrowserImplBase> weakReference3 = new WeakReference<>(mediaBrowserImplBase);
                this.mMediaBrowser = weakReference2;
            }

            public void onConnect(String str, Token token, Bundle bundle) {
                String str2 = str;
                Token token2 = token;
                Bundle bundle2 = bundle;
                MediaBrowserImplBase mediaBrowserImplBase = (MediaBrowserImplBase) this.mMediaBrowser.get();
                if (mediaBrowserImplBase != null) {
                    mediaBrowserImplBase.onServiceConnected(this, str2, token2, bundle2);
                }
            }

            public void onConnectFailed() {
                MediaBrowserImplBase mediaBrowserImplBase = (MediaBrowserImplBase) this.mMediaBrowser.get();
                if (mediaBrowserImplBase != null) {
                    mediaBrowserImplBase.onConnectionFailed(this);
                }
            }

            public void onLoadChildren(String str, List list) {
                String str2 = str;
                List list2 = list;
                MediaBrowserImplBase mediaBrowserImplBase = (MediaBrowserImplBase) this.mMediaBrowser.get();
                if (mediaBrowserImplBase != null) {
                    mediaBrowserImplBase.onLoadChildren(this, str2, list2);
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$Subscription */
        private static class Subscription {
            SubscriptionCallback callback;

            /* renamed from: id */
            final String f10id;

            Subscription(String str) {
                this.f10id = str;
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Handler handler;
            ArrayMap<String, Subscription> arrayMap;
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            IllegalArgumentException illegalArgumentException3;
            Context context2 = context;
            ComponentName componentName2 = componentName;
            ConnectionCallback connectionCallback2 = connectionCallback;
            Bundle bundle2 = bundle;
            Handler handler2 = handler;
            Handler handler3 = new Handler();
            this.mHandler = handler2;
            ArrayMap<String, Subscription> arrayMap2 = arrayMap;
            ArrayMap<String, Subscription> arrayMap3 = new ArrayMap<>();
            this.mSubscriptions = arrayMap2;
            if (context2 == null) {
                IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("context must not be null");
                throw illegalArgumentException4;
            } else if (componentName2 == null) {
                IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("service component must not be null");
                throw illegalArgumentException6;
            } else if (connectionCallback2 == null) {
                IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("connection callback must not be null");
                throw illegalArgumentException8;
            } else {
                this.mContext = context2;
                this.mServiceComponent = componentName2;
                this.mCallback = connectionCallback2;
                this.mRootHints = bundle2;
            }
        }

        static /* synthetic */ Bundle access$1002(MediaBrowserImplBase mediaBrowserImplBase, Bundle bundle) {
            Bundle bundle2 = bundle;
            mediaBrowserImplBase.mExtras = bundle2;
            return bundle2;
        }

        static /* synthetic */ IMediaBrowserServiceCompatCallbacks access$1202(MediaBrowserImplBase mediaBrowserImplBase, IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            mediaBrowserImplBase.mServiceCallbacks = iMediaBrowserServiceCompatCallbacks2;
            return iMediaBrowserServiceCompatCallbacks2;
        }

        static /* synthetic */ IMediaBrowserServiceCompat access$1302(MediaBrowserImplBase mediaBrowserImplBase, IMediaBrowserServiceCompat iMediaBrowserServiceCompat) {
            IMediaBrowserServiceCompat iMediaBrowserServiceCompat2 = iMediaBrowserServiceCompat;
            mediaBrowserImplBase.mServiceBinder = iMediaBrowserServiceCompat2;
            return iMediaBrowserServiceCompat2;
        }

        static /* synthetic */ int access$602(MediaBrowserImplBase mediaBrowserImplBase, int i) {
            int i2 = i;
            mediaBrowserImplBase.mState = i2;
            return i2;
        }

        static /* synthetic */ String access$802(MediaBrowserImplBase mediaBrowserImplBase, String str) {
            String str2 = str;
            mediaBrowserImplBase.mRootId = str2;
            return str2;
        }

        static /* synthetic */ Token access$902(MediaBrowserImplBase mediaBrowserImplBase, Token token) {
            Token token2 = token;
            mediaBrowserImplBase.mMediaSessionToken = token2;
            return token2;
        }

        /* access modifiers changed from: private */
        public void forceCloseConnection() {
            if (this.mServiceConnection != null) {
                this.mContext.unbindService(this.mServiceConnection);
            }
            this.mState = 0;
            this.mServiceConnection = null;
            this.mServiceBinder = null;
            this.mServiceCallbacks = null;
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        /* access modifiers changed from: private */
        public ServiceCallbacks getNewServiceCallbacks() {
            ServiceCallbacks serviceCallbacks;
            ServiceCallbacks serviceCallbacks2 = serviceCallbacks;
            ServiceCallbacks serviceCallbacks3 = new ServiceCallbacks(this);
            return serviceCallbacks2;
        }

        /* access modifiers changed from: private */
        public static String getStateLabel(int i) {
            StringBuilder sb;
            int i2 = i;
            switch (i2) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTED";
                case 1:
                    return "CONNECT_STATE_CONNECTING";
                case 2:
                    return "CONNECT_STATE_CONNECTED";
                case 3:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    return sb2.append("UNKNOWN/").append(i2).toString();
            }
        }

        /* access modifiers changed from: private */
        public boolean isCurrent(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, String str) {
            StringBuilder sb;
            String str2 = str;
            if (this.mServiceCallbacks == iMediaBrowserServiceCompatCallbacks) {
                return true;
            }
            if (this.mState != 0) {
                String str3 = TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int i = Log.i(str3, sb2.append(str2).append(" for ").append(this.mServiceComponent).append(" with mServiceConnection=").append(this.mServiceCallbacks).append(" this=").append(this).toString());
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final void onConnectionFailed(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks) {
            C00496 r7;
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            Handler handler = this.mHandler;
            C00496 r3 = r7;
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks3 = iMediaBrowserServiceCompatCallbacks2;
            C00496 r4 = new Runnable(this) {
                final /* synthetic */ MediaBrowserImplBase this$0;

                {
                    IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks = r7;
                    this.this$0 = r6;
                }

                public void run() {
                    StringBuilder sb;
                    StringBuilder sb2;
                    String str = MediaBrowserImplBase.TAG;
                    StringBuilder sb3 = sb;
                    StringBuilder sb4 = new StringBuilder();
                    int e = Log.e(str, sb3.append("onConnectFailed for ").append(this.this$0.mServiceComponent).toString());
                    if (this.this$0.isCurrent(iMediaBrowserServiceCompatCallbacks3, "onConnectFailed")) {
                        if (this.this$0.mState != 1) {
                            String str2 = MediaBrowserImplBase.TAG;
                            StringBuilder sb5 = sb2;
                            StringBuilder sb6 = new StringBuilder();
                            int w = Log.w(str2, sb5.append("onConnect from service while mState=").append(MediaBrowserImplBase.getStateLabel(this.this$0.mState)).append("... ignoring").toString());
                            return;
                        }
                        this.this$0.forceCloseConnection();
                        this.this$0.mCallback.onConnectionFailed();
                    }
                }
            };
            boolean post = handler.post(r3);
        }

        /* access modifiers changed from: private */
        public final void onLoadChildren(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, String str, List list) {
            C00507 r11;
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            String str2 = str;
            List list2 = list;
            Handler handler = this.mHandler;
            C00507 r5 = r11;
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks3 = iMediaBrowserServiceCompatCallbacks2;
            final List list3 = list2;
            final String str3 = str2;
            C00507 r6 = new Runnable(this) {
                final /* synthetic */ MediaBrowserImplBase this$0;

                {
                    IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks = r9;
                    List list = r10;
                    String str = r11;
                    this.this$0 = r8;
                }

                public void run() {
                    if (this.this$0.isCurrent(iMediaBrowserServiceCompatCallbacks3, "onLoadChildren")) {
                        List list = list3;
                        if (list == null) {
                            list = Collections.emptyList();
                        }
                        Subscription subscription = (Subscription) this.this$0.mSubscriptions.get(str3);
                        if (subscription != null) {
                            subscription.callback.onChildrenLoaded(str3, list);
                        }
                    }
                }
            };
            boolean post = handler.post(r5);
        }

        /* access modifiers changed from: private */
        public final void onServiceConnected(IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks, String str, Token token, Bundle bundle) {
            C00485 r13;
            IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks2 = iMediaBrowserServiceCompatCallbacks;
            String str2 = str;
            Token token2 = token;
            Bundle bundle2 = bundle;
            Handler handler = this.mHandler;
            C00485 r6 = r13;
            final IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks3 = iMediaBrowserServiceCompatCallbacks2;
            final String str3 = str2;
            final Token token3 = token2;
            final Bundle bundle3 = bundle2;
            C00485 r7 = new Runnable(this) {
                final /* synthetic */ MediaBrowserImplBase this$0;

                {
                    IMediaBrowserServiceCompatCallbacks iMediaBrowserServiceCompatCallbacks = r10;
                    String str = r11;
                    Token token = r12;
                    Bundle bundle = r13;
                    this.this$0 = r9;
                }

                public void run() {
                    StringBuilder sb;
                    StringBuilder sb2;
                    if (this.this$0.isCurrent(iMediaBrowserServiceCompatCallbacks3, "onConnect")) {
                        if (this.this$0.mState != 1) {
                            String str = MediaBrowserImplBase.TAG;
                            StringBuilder sb3 = sb2;
                            StringBuilder sb4 = new StringBuilder();
                            int w = Log.w(str, sb3.append("onConnect from service while mState=").append(MediaBrowserImplBase.getStateLabel(this.this$0.mState)).append("... ignoring").toString());
                            return;
                        }
                        String access$802 = MediaBrowserImplBase.access$802(this.this$0, str3);
                        Token access$902 = MediaBrowserImplBase.access$902(this.this$0, token3);
                        Bundle access$1002 = MediaBrowserImplBase.access$1002(this.this$0, bundle3);
                        int access$602 = MediaBrowserImplBase.access$602(this.this$0, 2);
                        this.this$0.mCallback.onConnected();
                        for (String str2 : this.this$0.mSubscriptions.keySet()) {
                            try {
                                this.this$0.mServiceBinder.addSubscription(str2, this.this$0.mServiceCallbacks);
                            } catch (RemoteException e) {
                                RemoteException remoteException = e;
                                String str3 = MediaBrowserImplBase.TAG;
                                StringBuilder sb5 = sb;
                                StringBuilder sb6 = new StringBuilder();
                                int d = Log.d(str3, sb5.append("addSubscription failed with RemoteException parentId=").append(str2).toString());
                            }
                        }
                    }
                }
            };
            boolean post = handler.post(r6);
        }

        public void connect() {
            Intent intent;
            MediaServiceConnection mediaServiceConnection;
            StringBuilder sb;
            boolean z;
            C00441 r14;
            RuntimeException runtimeException;
            StringBuilder sb2;
            RuntimeException runtimeException2;
            StringBuilder sb3;
            IllegalStateException illegalStateException;
            StringBuilder sb4;
            if (this.mState != 0) {
                IllegalStateException illegalStateException2 = illegalStateException;
                StringBuilder sb5 = sb4;
                StringBuilder sb6 = new StringBuilder();
                IllegalStateException illegalStateException3 = new IllegalStateException(sb5.append("connect() called while not disconnected (state=").append(getStateLabel(this.mState)).append(")").toString());
                throw illegalStateException2;
            } else if (this.mServiceBinder != null) {
                RuntimeException runtimeException3 = runtimeException2;
                StringBuilder sb7 = sb3;
                StringBuilder sb8 = new StringBuilder();
                RuntimeException runtimeException4 = new RuntimeException(sb7.append("mServiceBinder should be null. Instead it is ").append(this.mServiceBinder).toString());
                throw runtimeException3;
            } else if (this.mServiceCallbacks != null) {
                RuntimeException runtimeException5 = runtimeException;
                StringBuilder sb9 = sb2;
                StringBuilder sb10 = new StringBuilder();
                RuntimeException runtimeException6 = new RuntimeException(sb9.append("mServiceCallbacks should be null. Instead it is ").append(this.mServiceCallbacks).toString());
                throw runtimeException5;
            } else {
                this.mState = 1;
                Intent intent2 = intent;
                Intent intent3 = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                Intent intent4 = intent2;
                Intent component = intent4.setComponent(this.mServiceComponent);
                MediaServiceConnection mediaServiceConnection2 = mediaServiceConnection;
                MediaServiceConnection mediaServiceConnection3 = new MediaServiceConnection(this, null);
                MediaServiceConnection mediaServiceConnection4 = mediaServiceConnection2;
                this.mServiceConnection = mediaServiceConnection4;
                try {
                    z = this.mContext.bindService(intent4, this.mServiceConnection, 1);
                } catch (Exception e) {
                    Exception exc = e;
                    String str = TAG;
                    StringBuilder sb11 = sb;
                    StringBuilder sb12 = new StringBuilder();
                    int e2 = Log.e(str, sb11.append("Failed binding to service ").append(this.mServiceComponent).toString());
                    z = false;
                }
                if (!z) {
                    Handler handler = this.mHandler;
                    C00441 r10 = r14;
                    final MediaServiceConnection mediaServiceConnection5 = mediaServiceConnection4;
                    C00441 r11 = new Runnable(this) {
                        final /* synthetic */ MediaBrowserImplBase this$0;

                        {
                            ServiceConnection serviceConnection = r7;
                            this.this$0 = r6;
                        }

                        public void run() {
                            if (mediaServiceConnection5 == this.this$0.mServiceConnection) {
                                this.this$0.forceCloseConnection();
                                this.this$0.mCallback.onConnectionFailed();
                            }
                        }
                    };
                    boolean post = handler.post(r10);
                }
            }
        }

        public void disconnect() {
            StringBuilder sb;
            if (this.mServiceCallbacks != null) {
                try {
                    this.mServiceBinder.disconnect(this.mServiceCallbacks);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                    String str = TAG;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int w = Log.w(str, sb2.append("RemoteException during connect for ").append(this.mServiceComponent).toString());
                }
            }
            forceCloseConnection();
        }

        /* access modifiers changed from: 0000 */
        public void dump() {
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            StringBuilder sb4;
            StringBuilder sb5;
            StringBuilder sb6;
            StringBuilder sb7;
            StringBuilder sb8;
            StringBuilder sb9;
            int d = Log.d(TAG, "MediaBrowserCompat...");
            String str = TAG;
            StringBuilder sb10 = sb;
            StringBuilder sb11 = new StringBuilder();
            int d2 = Log.d(str, sb10.append("  mServiceComponent=").append(this.mServiceComponent).toString());
            String str2 = TAG;
            StringBuilder sb12 = sb2;
            StringBuilder sb13 = new StringBuilder();
            int d3 = Log.d(str2, sb12.append("  mCallback=").append(this.mCallback).toString());
            String str3 = TAG;
            StringBuilder sb14 = sb3;
            StringBuilder sb15 = new StringBuilder();
            int d4 = Log.d(str3, sb14.append("  mRootHints=").append(this.mRootHints).toString());
            String str4 = TAG;
            StringBuilder sb16 = sb4;
            StringBuilder sb17 = new StringBuilder();
            int d5 = Log.d(str4, sb16.append("  mState=").append(getStateLabel(this.mState)).toString());
            String str5 = TAG;
            StringBuilder sb18 = sb5;
            StringBuilder sb19 = new StringBuilder();
            int d6 = Log.d(str5, sb18.append("  mServiceConnection=").append(this.mServiceConnection).toString());
            String str6 = TAG;
            StringBuilder sb20 = sb6;
            StringBuilder sb21 = new StringBuilder();
            int d7 = Log.d(str6, sb20.append("  mServiceBinder=").append(this.mServiceBinder).toString());
            String str7 = TAG;
            StringBuilder sb22 = sb7;
            StringBuilder sb23 = new StringBuilder();
            int d8 = Log.d(str7, sb22.append("  mServiceCallbacks=").append(this.mServiceCallbacks).toString());
            String str8 = TAG;
            StringBuilder sb24 = sb8;
            StringBuilder sb25 = new StringBuilder();
            int d9 = Log.d(str8, sb24.append("  mRootId=").append(this.mRootId).toString());
            String str9 = TAG;
            StringBuilder sb26 = sb9;
            StringBuilder sb27 = new StringBuilder();
            int d10 = Log.d(str9, sb26.append("  mMediaSessionToken=").append(this.mMediaSessionToken).toString());
        }

        @Nullable
        public Bundle getExtras() {
            IllegalStateException illegalStateException;
            StringBuilder sb;
            if (isConnected()) {
                return this.mExtras;
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("getExtras() called while not connected (state=").append(getStateLabel(this.mState)).append(")").toString());
            throw illegalStateException2;
        }

        public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
            C00463 r11;
            C00474 r112;
            C00452 r113;
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            String str2 = str;
            ItemCallback itemCallback2 = itemCallback;
            if (TextUtils.isEmpty(str2)) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("mediaId is empty.");
                throw illegalArgumentException3;
            } else if (itemCallback2 == null) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("cb is null.");
                throw illegalArgumentException5;
            } else if (this.mState != 2) {
                int i = Log.i(TAG, "Not connected, unable to retrieve the MediaItem.");
                Handler handler = this.mHandler;
                C00452 r6 = r113;
                final ItemCallback itemCallback3 = itemCallback2;
                final String str3 = str2;
                C00452 r7 = new Runnable(this) {
                    final /* synthetic */ MediaBrowserImplBase this$0;

                    {
                        ItemCallback itemCallback = r8;
                        String str = r9;
                        this.this$0 = r7;
                    }

                    public void run() {
                        itemCallback3.onError(str3);
                    }
                };
                boolean post = handler.post(r6);
            } else {
                C00463 r5 = r11;
                final ItemCallback itemCallback4 = itemCallback2;
                final String str4 = str2;
                C00463 r62 = new ResultReceiver(this, this.mHandler) {
                    final /* synthetic */ MediaBrowserImplBase this$0;

                    {
                        Handler handler = r9;
                        ItemCallback itemCallback = r10;
                        String str = r11;
                        this.this$0 = r8;
                    }

                    /* access modifiers changed from: protected */
                    public void onReceiveResult(int i, Bundle bundle) {
                        Bundle bundle2 = bundle;
                        if (i != 0 || bundle2 == null || !bundle2.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                            itemCallback4.onError(str4);
                            return;
                        }
                        Parcelable parcelable = bundle2.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                        if (!(parcelable instanceof MediaItem)) {
                            itemCallback4.onError(str4);
                        } else {
                            itemCallback4.onItemLoaded((MediaItem) parcelable);
                        }
                    }
                };
                try {
                    this.mServiceBinder.getMediaItem(str2, r5);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                    int i2 = Log.i(TAG, "Remote error getting media item.");
                    Handler handler2 = this.mHandler;
                    C00474 r63 = r112;
                    final ItemCallback itemCallback5 = itemCallback2;
                    final String str5 = str2;
                    C00474 r72 = new Runnable(this) {
                        final /* synthetic */ MediaBrowserImplBase this$0;

                        {
                            ItemCallback itemCallback = r8;
                            String str = r9;
                            this.this$0 = r7;
                        }

                        public void run() {
                            itemCallback5.onError(str5);
                        }
                    };
                    boolean post2 = handler2.post(r63);
                }
            }
        }

        @NonNull
        public String getRoot() {
            IllegalStateException illegalStateException;
            StringBuilder sb;
            if (isConnected()) {
                return this.mRootId;
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("getSessionToken() called while not connected(state=").append(getStateLabel(this.mState)).append(")").toString());
            throw illegalStateException2;
        }

        @NonNull
        public ComponentName getServiceComponent() {
            IllegalStateException illegalStateException;
            StringBuilder sb;
            if (isConnected()) {
                return this.mServiceComponent;
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("getServiceComponent() called while not connected (state=").append(this.mState).append(")").toString());
            throw illegalStateException2;
        }

        @NonNull
        public Token getSessionToken() {
            IllegalStateException illegalStateException;
            StringBuilder sb;
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("getSessionToken() called while not connected(state=").append(this.mState).append(")").toString());
            throw illegalStateException2;
        }

        public boolean isConnected() {
            return this.mState == 2;
        }

        public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
            StringBuilder sb;
            Subscription subscription;
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            String str2 = str;
            SubscriptionCallback subscriptionCallback2 = subscriptionCallback;
            if (str2 == null) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("parentId is null");
                throw illegalArgumentException3;
            } else if (subscriptionCallback2 == null) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("callback is null");
                throw illegalArgumentException5;
            } else {
                Subscription subscription2 = (Subscription) this.mSubscriptions.get(str2);
                if (subscription2 == null) {
                    Subscription subscription3 = subscription;
                    Subscription subscription4 = new Subscription(str2);
                    subscription2 = subscription3;
                    Object put = this.mSubscriptions.put(str2, subscription2);
                }
                subscription2.callback = subscriptionCallback2;
                if (this.mState == 2) {
                    try {
                        this.mServiceBinder.addSubscription(str2, this.mServiceCallbacks);
                    } catch (RemoteException e) {
                        RemoteException remoteException = e;
                        String str3 = TAG;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int d = Log.d(str3, sb2.append("addSubscription failed with RemoteException parentId=").append(str2).toString());
                    }
                }
            }
        }

        public void unsubscribe(@NonNull String str) {
            StringBuilder sb;
            IllegalArgumentException illegalArgumentException;
            String str2 = str;
            if (TextUtils.isEmpty(str2)) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("parentId is empty.");
                throw illegalArgumentException2;
            }
            Subscription subscription = (Subscription) this.mSubscriptions.remove(str2);
            if (this.mState == 2 && subscription != null) {
                try {
                    this.mServiceBinder.removeSubscription(str2, this.mServiceCallbacks);
                } catch (RemoteException e) {
                    RemoteException remoteException = e;
                    String str3 = TAG;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    int d = Log.d(str3, sb2.append("removeSubscription failed with RemoteException parentId=").append(str2).toString());
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$Flags */
        public @interface Flags {
        }

        static {
            C00511 r2;
            C00511 r0 = r2;
            C00511 r1 = new Creator<MediaItem>() {
                public MediaItem createFromParcel(Parcel parcel) {
                    MediaItem mediaItem;
                    MediaItem mediaItem2 = mediaItem;
                    MediaItem mediaItem3 = new MediaItem(parcel, (C00431) null);
                    return mediaItem2;
                }

                public MediaItem[] newArray(int i) {
                    return new MediaItem[i];
                }
            };
            CREATOR = r0;
        }

        private MediaItem(Parcel parcel) {
            Parcel parcel2 = parcel;
            this.mFlags = parcel2.readInt();
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel2);
        }

        /* synthetic */ MediaItem(Parcel parcel, C00431 r7) {
            C00431 r2 = r7;
            this(parcel);
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            IllegalArgumentException illegalArgumentException;
            IllegalArgumentException illegalArgumentException2;
            MediaDescriptionCompat mediaDescriptionCompat2 = mediaDescriptionCompat;
            int i2 = i;
            if (mediaDescriptionCompat2 == null) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("description cannot be null");
                throw illegalArgumentException3;
            } else if (TextUtils.isEmpty(mediaDescriptionCompat2.getMediaId())) {
                IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("description must have a non-empty media id");
                throw illegalArgumentException5;
            } else {
                this.mFlags = i2;
                this.mDescription = mediaDescriptionCompat2;
            }
        }

        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @NonNull
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (1 & this.mFlags) != 0;
        }

        public boolean isPlayable() {
            return (2 & this.mFlags) != 0;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder("MediaItem{");
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append("mFlags=").append(this.mFlags);
            StringBuilder append2 = sb4.append(", mDescription=").append(this.mDescription);
            StringBuilder append3 = sb4.append('}');
            return sb4.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            parcel2.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel2, i2);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback */
    public static abstract class SubscriptionCallback {
        public SubscriptionCallback() {
        }

        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String str) {
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        MediaBrowserImplBase mediaBrowserImplBase;
        MediaBrowserImplBase mediaBrowserImplBase2 = mediaBrowserImplBase;
        MediaBrowserImplBase mediaBrowserImplBase3 = new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        this.mImpl = mediaBrowserImplBase2;
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull String str, @NonNull ItemCallback itemCallback) {
        String str2 = str;
        ItemCallback itemCallback2 = itemCallback;
        this.mImpl.getItem(str2, itemCallback2);
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void subscribe(@NonNull String str, @NonNull SubscriptionCallback subscriptionCallback) {
        String str2 = str;
        SubscriptionCallback subscriptionCallback2 = subscriptionCallback;
        this.mImpl.subscribe(str2, subscriptionCallback2);
    }

    public void unsubscribe(@NonNull String str) {
        String str2 = str;
        this.mImpl.unsubscribe(str2);
    }
}

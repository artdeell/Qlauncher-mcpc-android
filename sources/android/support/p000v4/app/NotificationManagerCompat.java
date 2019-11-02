package android.support.p000v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.p000v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.app.NotificationManagerCompat */
public class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final Impl IMPL;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    /* access modifiers changed from: private */
    public static final int SIDE_CHANNEL_BIND_FLAGS = IMPL.getSideChannelBindFlags();
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager = ((NotificationManager) this.mContext.getSystemService("notification"));

    /* renamed from: android.support.v4.app.NotificationManagerCompat$CancelTask */
    private static class CancelTask implements Task {
        final boolean all;

        /* renamed from: id */
        final int f8id;
        final String packageName;
        final String tag;

        public CancelTask(String str) {
            this.packageName = str;
            this.f8id = 0;
            this.tag = null;
            this.all = true;
        }

        public CancelTask(String str, int i, String str2) {
            int i2 = i;
            String str3 = str2;
            this.packageName = str;
            this.f8id = i2;
            this.tag = str3;
            this.all = false;
        }

        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            INotificationSideChannel iNotificationSideChannel2 = iNotificationSideChannel;
            if (this.all) {
                iNotificationSideChannel2.cancelAll(this.packageName);
            } else {
                iNotificationSideChannel2.cancel(this.packageName, this.f8id, this.tag);
            }
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder("CancelTask[");
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append("packageName:").append(this.packageName);
            StringBuilder append2 = sb4.append(", id:").append(this.f8id);
            StringBuilder append3 = sb4.append(", tag:").append(this.tag);
            StringBuilder append4 = sb4.append(", all:").append(this.all);
            StringBuilder append5 = sb4.append("]");
            return sb4.toString();
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$Impl */
    interface Impl {
        void cancelNotification(NotificationManager notificationManager, String str, int i);

        int getSideChannelBindFlags();

        void postNotification(NotificationManager notificationManager, String str, int i, Notification notification);
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ImplBase */
    static class ImplBase implements Impl {
        ImplBase() {
        }

        public void cancelNotification(NotificationManager notificationManager, String str, int i) {
            String str2 = str;
            notificationManager.cancel(i);
        }

        public int getSideChannelBindFlags() {
            return 1;
        }

        public void postNotification(NotificationManager notificationManager, String str, int i, Notification notification) {
            String str2 = str;
            notificationManager.notify(i, notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ImplEclair */
    static class ImplEclair extends ImplBase {
        ImplEclair() {
        }

        public void cancelNotification(NotificationManager notificationManager, String str, int i) {
            NotificationManagerCompatEclair.cancelNotification(notificationManager, str, i);
        }

        public void postNotification(NotificationManager notificationManager, String str, int i, Notification notification) {
            NotificationManagerCompatEclair.postNotification(notificationManager, str, i, notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ImplIceCreamSandwich */
    static class ImplIceCreamSandwich extends ImplEclair {
        ImplIceCreamSandwich() {
        }

        public int getSideChannelBindFlags() {
            return 33;
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$NotifyTask */
    private static class NotifyTask implements Task {

        /* renamed from: id */
        final int f9id;
        final Notification notif;
        final String packageName;
        final String tag;

        public NotifyTask(String str, int i, String str2, Notification notification) {
            int i2 = i;
            String str3 = str2;
            Notification notification2 = notification;
            this.packageName = str;
            this.f9id = i2;
            this.tag = str3;
            this.notif = notification2;
        }

        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.packageName, this.f9id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder("NotifyTask[");
            StringBuilder sb4 = sb2;
            StringBuilder append = sb4.append("packageName:").append(this.packageName);
            StringBuilder append2 = sb4.append(", id:").append(this.f9id);
            StringBuilder append3 = sb4.append(", tag:").append(this.tag);
            StringBuilder append4 = sb4.append("]");
            return sb4.toString();
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$ServiceConnectedEvent */
    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName componentName2, IBinder iBinder2) {
            IBinder iBinder3 = iBinder2;
            this.componentName = componentName2;
            this.iBinder = iBinder3;
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$SideChannelManager */
    private static class SideChannelManager implements Callback, ServiceConnection {
        private static final String KEY_BINDER = "binder";
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, ListenerRecord> mRecordMap;

        /* renamed from: android.support.v4.app.NotificationManagerCompat$SideChannelManager$ListenerRecord */
        private static class ListenerRecord {
            public boolean bound = false;
            public final ComponentName componentName;
            public int retryCount;
            public INotificationSideChannel service;
            public LinkedList<Task> taskQueue;

            public ListenerRecord(ComponentName componentName2) {
                LinkedList<Task> linkedList;
                ComponentName componentName3 = componentName2;
                LinkedList<Task> linkedList2 = linkedList;
                LinkedList<Task> linkedList3 = new LinkedList<>();
                this.taskQueue = linkedList2;
                this.retryCount = 0;
                this.componentName = componentName3;
            }
        }

        public SideChannelManager(Context context) {
            HashMap hashMap;
            HashSet hashSet;
            HandlerThread handlerThread;
            Handler handler;
            Context context2 = context;
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            this.mRecordMap = hashMap2;
            HashSet hashSet2 = hashSet;
            HashSet hashSet3 = new HashSet();
            this.mCachedEnabledPackages = hashSet2;
            this.mContext = context2;
            HandlerThread handlerThread2 = handlerThread;
            HandlerThread handlerThread3 = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = handlerThread2;
            this.mHandlerThread.start();
            Handler handler2 = handler;
            Handler handler3 = new Handler(this.mHandlerThread.getLooper(), this);
            this.mHandler = handler2;
        }

        private boolean ensureServiceBound(ListenerRecord listenerRecord) {
            Intent intent;
            StringBuilder sb;
            ListenerRecord listenerRecord2 = listenerRecord;
            if (listenerRecord2.bound) {
                return true;
            }
            Intent intent2 = intent;
            Intent intent3 = new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL);
            Intent component = intent2.setComponent(listenerRecord2.componentName);
            listenerRecord2.bound = this.mContext.bindService(component, this, NotificationManagerCompat.SIDE_CHANNEL_BIND_FLAGS);
            if (listenerRecord2.bound) {
                listenerRecord2.retryCount = 0;
            } else {
                String str = NotificationManagerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int w = Log.w(str, sb2.append("Unable to bind to listener ").append(listenerRecord2.componentName).toString());
                this.mContext.unbindService(this);
            }
            return listenerRecord2.bound;
        }

        private void ensureServiceUnbound(ListenerRecord listenerRecord) {
            ListenerRecord listenerRecord2 = listenerRecord;
            if (listenerRecord2.bound) {
                this.mContext.unbindService(this);
                listenerRecord2.bound = false;
            }
            listenerRecord2.service = null;
        }

        private void handleQueueTask(Task task) {
            Task task2 = task;
            updateListenerMap();
            for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
                boolean add = listenerRecord.taskQueue.add(task2);
                processListenerQueue(listenerRecord);
            }
        }

        private void handleRetryListenerQueue(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder iBinder2 = iBinder;
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                listenerRecord.service = Stub.asInterface(iBinder2);
                listenerRecord.retryCount = 0;
                processListenerQueue(listenerRecord);
            }
        }

        private void handleServiceDisconnected(ComponentName componentName) {
            ListenerRecord listenerRecord = (ListenerRecord) this.mRecordMap.get(componentName);
            if (listenerRecord != null) {
                ensureServiceUnbound(listenerRecord);
            }
        }

        private void processListenerQueue(ListenerRecord listenerRecord) {
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            StringBuilder sb4;
            ListenerRecord listenerRecord2 = listenerRecord;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                String str = NotificationManagerCompat.TAG;
                StringBuilder sb5 = sb4;
                StringBuilder sb6 = new StringBuilder();
                int d = Log.d(str, sb5.append("Processing component ").append(listenerRecord2.componentName).append(", ").append(listenerRecord2.taskQueue.size()).append(" queued tasks").toString());
            }
            if (!listenerRecord2.taskQueue.isEmpty()) {
                if (!ensureServiceBound(listenerRecord2) || listenerRecord2.service == null) {
                    scheduleListenerRetry(listenerRecord2);
                    return;
                }
                while (true) {
                    Task task = (Task) listenerRecord2.taskQueue.peek();
                    if (task == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            String str2 = NotificationManagerCompat.TAG;
                            StringBuilder sb7 = sb3;
                            StringBuilder sb8 = new StringBuilder();
                            int d2 = Log.d(str2, sb7.append("Sending task ").append(task).toString());
                        }
                        task.send(listenerRecord2.service);
                        Object remove = listenerRecord2.taskQueue.remove();
                    } catch (DeadObjectException e) {
                        DeadObjectException deadObjectException = e;
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            String str3 = NotificationManagerCompat.TAG;
                            StringBuilder sb9 = sb2;
                            StringBuilder sb10 = new StringBuilder();
                            int d3 = Log.d(str3, sb9.append("Remote service has died: ").append(listenerRecord2.componentName).toString());
                        }
                    } catch (RemoteException e2) {
                        RemoteException remoteException = e2;
                        String str4 = NotificationManagerCompat.TAG;
                        StringBuilder sb11 = sb;
                        StringBuilder sb12 = new StringBuilder();
                        int w = Log.w(str4, sb11.append("RemoteException communicating with ").append(listenerRecord2.componentName).toString(), remoteException);
                    }
                }
                if (!listenerRecord2.taskQueue.isEmpty()) {
                    scheduleListenerRetry(listenerRecord2);
                }
            }
        }

        private void scheduleListenerRetry(ListenerRecord listenerRecord) {
            StringBuilder sb;
            StringBuilder sb2;
            ListenerRecord listenerRecord2 = listenerRecord;
            if (!this.mHandler.hasMessages(3, listenerRecord2.componentName)) {
                listenerRecord2.retryCount = 1 + listenerRecord2.retryCount;
                if (listenerRecord2.retryCount > 6) {
                    String str = NotificationManagerCompat.TAG;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    int w = Log.w(str, sb3.append("Giving up on delivering ").append(listenerRecord2.taskQueue.size()).append(" tasks to ").append(listenerRecord2.componentName).append(" after ").append(listenerRecord2.retryCount).append(" retries").toString());
                    listenerRecord2.taskQueue.clear();
                    return;
                }
                int i = NotificationManagerCompat.SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS * (1 << (-1 + listenerRecord2.retryCount));
                if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                    String str2 = NotificationManagerCompat.TAG;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    int d = Log.d(str2, sb5.append("Scheduling retry for ").append(i).append(" ms").toString());
                }
                boolean sendMessageDelayed = this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord2.componentName), (long) i);
            }
        }

        private void updateListenerMap() {
            Intent intent;
            HashSet hashSet;
            StringBuilder sb;
            ListenerRecord listenerRecord;
            StringBuilder sb2;
            ComponentName componentName;
            StringBuilder sb3;
            Set enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (!enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
                this.mCachedEnabledPackages = enabledListenerPackages;
                PackageManager packageManager = this.mContext.getPackageManager();
                Intent intent2 = intent;
                Intent intent3 = new Intent();
                List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent2.setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 4);
                HashSet hashSet2 = hashSet;
                HashSet hashSet3 = new HashSet();
                HashSet<ComponentName> hashSet4 = hashSet2;
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                        ComponentName componentName2 = componentName;
                        ComponentName componentName3 = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                        ComponentName componentName4 = componentName2;
                        if (resolveInfo.serviceInfo.permission != null) {
                            String str = NotificationManagerCompat.TAG;
                            StringBuilder sb4 = sb3;
                            StringBuilder sb5 = new StringBuilder();
                            int w = Log.w(str, sb4.append("Permission present on component ").append(componentName4).append(", not adding listener record.").toString());
                        } else {
                            boolean add = hashSet4.add(componentName4);
                        }
                    }
                }
                for (ComponentName componentName5 : hashSet4) {
                    if (!this.mRecordMap.containsKey(componentName5)) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            String str2 = NotificationManagerCompat.TAG;
                            StringBuilder sb6 = sb2;
                            StringBuilder sb7 = new StringBuilder();
                            int d = Log.d(str2, sb6.append("Adding listener record for ").append(componentName5).toString());
                        }
                        Map<ComponentName, ListenerRecord> map = this.mRecordMap;
                        ComponentName componentName6 = componentName5;
                        ListenerRecord listenerRecord2 = listenerRecord;
                        ListenerRecord listenerRecord3 = new ListenerRecord(componentName5);
                        Object put = map.put(componentName6, listenerRecord2);
                    }
                }
                Iterator it = this.mRecordMap.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (!hashSet4.contains(entry.getKey())) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            String str3 = NotificationManagerCompat.TAG;
                            StringBuilder sb8 = sb;
                            StringBuilder sb9 = new StringBuilder();
                            int d2 = Log.d(str3, sb8.append("Removing listener record for ").append(entry.getKey()).toString());
                        }
                        ensureServiceUnbound((ListenerRecord) entry.getValue());
                        it.remove();
                    }
                }
            }
        }

        public boolean handleMessage(Message message) {
            Message message2 = message;
            switch (message2.what) {
                case 0:
                    handleQueueTask((Task) message2.obj);
                    return true;
                case 1:
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message2.obj;
                    handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                    return true;
                case 2:
                    handleServiceDisconnected((ComponentName) message2.obj);
                    return true;
                case 3:
                    handleRetryListenerQueue((ComponentName) message2.obj);
                    return true;
                default:
                    return false;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ServiceConnectedEvent serviceConnectedEvent;
            StringBuilder sb;
            ComponentName componentName2 = componentName;
            IBinder iBinder2 = iBinder;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                String str = NotificationManagerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int d = Log.d(str, sb2.append("Connected to service ").append(componentName2).toString());
            }
            Handler handler = this.mHandler;
            ServiceConnectedEvent serviceConnectedEvent2 = serviceConnectedEvent;
            ServiceConnectedEvent serviceConnectedEvent3 = new ServiceConnectedEvent(componentName2, iBinder2);
            handler.obtainMessage(1, serviceConnectedEvent2).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            StringBuilder sb;
            ComponentName componentName2 = componentName;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                String str = NotificationManagerCompat.TAG;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                int d = Log.d(str, sb2.append("Disconnected from service ").append(componentName2).toString());
            }
            this.mHandler.obtainMessage(2, componentName2).sendToTarget();
        }

        public void queueTask(Task task) {
            Task task2 = task;
            this.mHandler.obtainMessage(0, task2).sendToTarget();
        }
    }

    /* renamed from: android.support.v4.app.NotificationManagerCompat$Task */
    private interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    static {
        Object obj;
        HashSet hashSet;
        Object obj2;
        ImplBase implBase;
        ImplEclair implEclair;
        ImplIceCreamSandwich implIceCreamSandwich;
        Object obj3 = obj;
        Object obj4 = new Object();
        sEnabledNotificationListenersLock = obj3;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        sEnabledNotificationListenerPackages = hashSet2;
        Object obj5 = obj2;
        Object obj6 = new Object();
        sLock = obj5;
        if (VERSION.SDK_INT >= 14) {
            ImplIceCreamSandwich implIceCreamSandwich2 = implIceCreamSandwich;
            ImplIceCreamSandwich implIceCreamSandwich3 = new ImplIceCreamSandwich();
            IMPL = implIceCreamSandwich2;
        } else if (VERSION.SDK_INT >= 5) {
            ImplEclair implEclair2 = implEclair;
            ImplEclair implEclair3 = new ImplEclair();
            IMPL = implEclair2;
        } else {
            ImplBase implBase2 = implBase;
            ImplBase implBase3 = new ImplBase();
            IMPL = implBase2;
        }
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
    }

    public static NotificationManagerCompat from(Context context) {
        NotificationManagerCompat notificationManagerCompat;
        NotificationManagerCompat notificationManagerCompat2 = notificationManagerCompat;
        NotificationManagerCompat notificationManagerCompat3 = new NotificationManagerCompat(context);
        return notificationManagerCompat2;
    }

    public static Set<String> getEnabledListenerPackages(Context context) {
        HashSet hashSet;
        String string = Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        if (string != null && !string.equals(sEnabledNotificationListeners)) {
            String[] split = string.split(":");
            HashSet hashSet2 = hashSet;
            HashSet hashSet3 = new HashSet(split.length);
            HashSet hashSet4 = hashSet2;
            int length = split.length;
            for (int i = 0; i < length; i++) {
                ComponentName unflattenFromString = ComponentName.unflattenFromString(split[i]);
                if (unflattenFromString != null) {
                    boolean add = hashSet4.add(unflattenFromString.getPackageName());
                }
            }
            Object obj = sEnabledNotificationListenersLock;
            synchronized (obj) {
                try {
                    sEnabledNotificationListenerPackages = hashSet4;
                    sEnabledNotificationListeners = string;
                } catch (Throwable th) {
                    while (true) {
                        Throwable th2 = th;
                        Object obj2 = obj;
                        throw th2;
                    }
                }
            }
        }
        return sEnabledNotificationListenerPackages;
    }

    private void pushSideChannelQueue(Task task) {
        SideChannelManager sideChannelManager;
        Task task2 = task;
        Object obj = sLock;
        synchronized (obj) {
            try {
                if (sSideChannelManager == null) {
                    SideChannelManager sideChannelManager2 = sideChannelManager;
                    SideChannelManager sideChannelManager3 = new SideChannelManager(this.mContext.getApplicationContext());
                    sSideChannelManager = sideChannelManager2;
                }
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    Object obj2 = obj;
                    throw th2;
                }
            }
        }
        sSideChannelManager.queueTask(task2);
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
    }

    public void cancel(int i) {
        cancel(null, i);
    }

    public void cancel(String str, int i) {
        CancelTask cancelTask;
        String str2 = str;
        int i2 = i;
        IMPL.cancelNotification(this.mNotificationManager, str2, i2);
        if (VERSION.SDK_INT <= 19) {
            CancelTask cancelTask2 = cancelTask;
            CancelTask cancelTask3 = new CancelTask(this.mContext.getPackageName(), i2, str2);
            pushSideChannelQueue(cancelTask2);
        }
    }

    public void cancelAll() {
        CancelTask cancelTask;
        this.mNotificationManager.cancelAll();
        if (VERSION.SDK_INT <= 19) {
            CancelTask cancelTask2 = cancelTask;
            CancelTask cancelTask3 = new CancelTask(this.mContext.getPackageName());
            pushSideChannelQueue(cancelTask2);
        }
    }

    public void notify(int i, Notification notification) {
        notify(null, i, notification);
    }

    public void notify(String str, int i, Notification notification) {
        NotifyTask notifyTask;
        String str2 = str;
        int i2 = i;
        Notification notification2 = notification;
        if (useSideChannelForNotification(notification2)) {
            NotifyTask notifyTask2 = notifyTask;
            NotifyTask notifyTask3 = new NotifyTask(this.mContext.getPackageName(), i2, str2, notification2);
            pushSideChannelQueue(notifyTask2);
            IMPL.cancelNotification(this.mNotificationManager, str2, i2);
            return;
        }
        IMPL.postNotification(this.mNotificationManager, str2, i2, notification2);
    }
}

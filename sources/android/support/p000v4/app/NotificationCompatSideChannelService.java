package android.support.p000v4.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.p000v4.app.INotificationSideChannel.Stub;

/* renamed from: android.support.v4.app.NotificationCompatSideChannelService */
public abstract class NotificationCompatSideChannelService extends Service {

    /* renamed from: android.support.v4.app.NotificationCompatSideChannelService$NotificationSideChannelStub */
    private class NotificationSideChannelStub extends Stub {
        final /* synthetic */ NotificationCompatSideChannelService this$0;

        private NotificationSideChannelStub(NotificationCompatSideChannelService notificationCompatSideChannelService) {
            this.this$0 = notificationCompatSideChannelService;
        }

        /* synthetic */ NotificationSideChannelStub(NotificationCompatSideChannelService notificationCompatSideChannelService, C00331 r7) {
            C00331 r2 = r7;
            this(notificationCompatSideChannelService);
        }

        public void cancel(String str, int i, String str2) throws RemoteException {
            String str3 = str;
            int i2 = i;
            String str4 = str2;
            this.this$0.checkPermission(getCallingUid(), str3);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.this$0.cancel(str3, i2, str4);
                restoreCallingIdentity(clearCallingIdentity);
            } catch (Throwable th) {
                Throwable th2 = th;
                restoreCallingIdentity(clearCallingIdentity);
                throw th2;
            }
        }

        public void cancelAll(String str) {
            String str2 = str;
            this.this$0.checkPermission(getCallingUid(), str2);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.this$0.cancelAll(str2);
                restoreCallingIdentity(clearCallingIdentity);
            } catch (Throwable th) {
                Throwable th2 = th;
                restoreCallingIdentity(clearCallingIdentity);
                throw th2;
            }
        }

        public void notify(String str, int i, String str2, Notification notification) throws RemoteException {
            String str3 = str;
            int i2 = i;
            String str4 = str2;
            Notification notification2 = notification;
            this.this$0.checkPermission(getCallingUid(), str3);
            long clearCallingIdentity = clearCallingIdentity();
            try {
                this.this$0.notify(str3, i2, str4, notification2);
                restoreCallingIdentity(clearCallingIdentity);
            } catch (Throwable th) {
                Throwable th2 = th;
                restoreCallingIdentity(clearCallingIdentity);
                throw th2;
            }
        }
    }

    public NotificationCompatSideChannelService() {
    }

    /* access modifiers changed from: private */
    public void checkPermission(int i, String str) {
        SecurityException securityException;
        StringBuilder sb;
        int i2 = i;
        String str2 = str;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i2);
        int length = packagesForUid.length;
        int i3 = 0;
        while (i3 < length) {
            if (!packagesForUid[i3].equals(str2)) {
                i3++;
            } else {
                return;
            }
        }
        SecurityException securityException2 = securityException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        SecurityException securityException3 = new SecurityException(sb2.append("NotificationSideChannelService: Uid ").append(i2).append(" is not authorized for package ").append(str2).toString());
        throw securityException2;
    }

    public abstract void cancel(String str, int i, String str2);

    public abstract void cancelAll(String str);

    public abstract void notify(String str, int i, String str2, Notification notification);

    public IBinder onBind(Intent intent) {
        NotificationSideChannelStub notificationSideChannelStub;
        if (!intent.getAction().equals(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL) || VERSION.SDK_INT > 19) {
            return null;
        }
        NotificationSideChannelStub notificationSideChannelStub2 = notificationSideChannelStub;
        NotificationSideChannelStub notificationSideChannelStub3 = new NotificationSideChannelStub(this, null);
        return notificationSideChannelStub2;
    }
}

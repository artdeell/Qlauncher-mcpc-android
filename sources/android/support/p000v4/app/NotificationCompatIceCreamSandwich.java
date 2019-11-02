package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* renamed from: android.support.v4.app.NotificationCompatIceCreamSandwich */
class NotificationCompatIceCreamSandwich {

    /* renamed from: android.support.v4.app.NotificationCompatIceCreamSandwich$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor {

        /* renamed from: b */
        private android.app.Notification.Builder f5b;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z) {
            android.app.Notification.Builder builder;
            Notification notification2 = notification;
            CharSequence charSequence4 = charSequence;
            CharSequence charSequence5 = charSequence2;
            CharSequence charSequence6 = charSequence3;
            RemoteViews remoteViews2 = remoteViews;
            int i4 = i;
            PendingIntent pendingIntent3 = pendingIntent;
            PendingIntent pendingIntent4 = pendingIntent2;
            Bitmap bitmap2 = bitmap;
            int i5 = i2;
            int i6 = i3;
            boolean z2 = z;
            android.app.Notification.Builder builder2 = builder;
            android.app.Notification.Builder builder3 = new android.app.Notification.Builder(context);
            this.f5b = builder2.setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews2).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((2 & notification2.flags) != 0).setOnlyAlertOnce((8 & notification2.flags) != 0).setAutoCancel((16 & notification2.flags) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence4).setContentText(charSequence5).setContentInfo(charSequence6).setContentIntent(pendingIntent3).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(pendingIntent4, (128 & notification2.flags) != 0).setLargeIcon(bitmap2).setNumber(i4).setProgress(i5, i6, z2);
        }

        public Notification build() {
            return this.f5b.getNotification();
        }

        public android.app.Notification.Builder getBuilder() {
            return this.f5b;
        }
    }

    NotificationCompatIceCreamSandwich() {
    }
}

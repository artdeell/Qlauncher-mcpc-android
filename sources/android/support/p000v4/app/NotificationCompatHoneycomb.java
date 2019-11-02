package android.support.p000v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* renamed from: android.support.v4.app.NotificationCompatHoneycomb */
class NotificationCompatHoneycomb {
    NotificationCompatHoneycomb() {
    }

    static Notification add(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap) {
        Builder builder;
        Notification notification2 = notification;
        CharSequence charSequence4 = charSequence;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        RemoteViews remoteViews2 = remoteViews;
        int i2 = i;
        PendingIntent pendingIntent3 = pendingIntent;
        PendingIntent pendingIntent4 = pendingIntent2;
        Bitmap bitmap2 = bitmap;
        Builder builder2 = builder;
        Builder builder3 = new Builder(context);
        return builder2.setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews2).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((2 & notification2.flags) != 0).setOnlyAlertOnce((8 & notification2.flags) != 0).setAutoCancel((16 & notification2.flags) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence4).setContentText(charSequence5).setContentInfo(charSequence6).setContentIntent(pendingIntent3).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(pendingIntent4, (128 & notification2.flags) != 0).setLargeIcon(bitmap2).setNumber(i2).getNotification();
    }
}

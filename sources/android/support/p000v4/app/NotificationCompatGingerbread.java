package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* renamed from: android.support.v4.app.NotificationCompatGingerbread */
class NotificationCompatGingerbread {
    NotificationCompatGingerbread() {
    }

    public static Notification add(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Notification notification2 = notification;
        PendingIntent pendingIntent3 = pendingIntent2;
        notification2.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notification2.fullScreenIntent = pendingIntent3;
        return notification2;
    }
}

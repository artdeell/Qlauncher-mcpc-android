package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p000v4.app.NotificationCompatBase.Action;
import android.support.p000v4.app.NotificationCompatBase.Action.Factory;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompatKitKat */
class NotificationCompatKitKat {

    /* renamed from: android.support.v4.app.NotificationCompatKitKat$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {

        /* renamed from: b */
        private android.app.Notification.Builder f7b;
        private List<Bundle> mActionExtrasList;
        private Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            ArrayList arrayList2;
            android.app.Notification.Builder builder;
            Bundle bundle2;
            Context context2 = context;
            Notification notification2 = notification;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence3;
            RemoteViews remoteViews2 = remoteViews;
            int i5 = i;
            PendingIntent pendingIntent3 = pendingIntent;
            PendingIntent pendingIntent4 = pendingIntent2;
            Bitmap bitmap2 = bitmap;
            int i6 = i2;
            int i7 = i3;
            boolean z6 = z;
            boolean z7 = z2;
            boolean z8 = z3;
            int i8 = i4;
            CharSequence charSequence8 = charSequence4;
            boolean z9 = z4;
            ArrayList<String> arrayList3 = arrayList;
            Bundle bundle3 = bundle;
            String str3 = str;
            boolean z10 = z5;
            String str4 = str2;
            ArrayList arrayList4 = arrayList2;
            ArrayList arrayList5 = new ArrayList();
            this.mActionExtrasList = arrayList4;
            android.app.Notification.Builder builder2 = builder;
            android.app.Notification.Builder builder3 = new android.app.Notification.Builder(context2);
            this.f7b = builder2.setWhen(notification2.when).setShowWhen(z7).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews2).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((2 & notification2.flags) != 0).setOnlyAlertOnce((8 & notification2.flags) != 0).setAutoCancel((16 & notification2.flags) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence5).setContentText(charSequence6).setSubText(charSequence8).setContentInfo(charSequence7).setContentIntent(pendingIntent3).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(pendingIntent4, (128 & notification2.flags) != 0).setLargeIcon(bitmap2).setNumber(i5).setUsesChronometer(z8).setPriority(i8).setProgress(i6, i7, z6);
            Bundle bundle4 = bundle2;
            Bundle bundle5 = new Bundle();
            this.mExtras = bundle4;
            if (bundle3 != null) {
                this.mExtras.putAll(bundle3);
            }
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                this.mExtras.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList3.toArray(new String[arrayList3.size()]));
            }
            if (z9) {
                this.mExtras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
            }
            if (str3 != null) {
                this.mExtras.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str3);
                if (z10) {
                    this.mExtras.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                } else {
                    this.mExtras.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                }
            }
            if (str4 != null) {
                this.mExtras.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str4);
            }
        }

        public void addAction(Action action) {
            boolean add = this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.f7b, action));
        }

        public Notification build() {
            SparseArray buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (buildActionExtrasMap != null) {
                this.mExtras.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap);
            }
            android.app.Notification.Builder extras = this.f7b.setExtras(this.mExtras);
            return this.f7b.build();
        }

        public android.app.Notification.Builder getBuilder() {
            return this.f7b;
        }
    }

    NotificationCompatKitKat() {
    }

    public static Action getAction(Notification notification, int i, Factory factory, RemoteInput.Factory factory2) {
        Notification notification2 = notification;
        int i2 = i;
        Factory factory3 = factory;
        RemoteInput.Factory factory4 = factory2;
        Notification.Action action = notification2.actions[i2];
        SparseArray sparseParcelableArray = notification2.extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS);
        Bundle bundle = null;
        if (sparseParcelableArray != null) {
            bundle = (Bundle) sparseParcelableArray.get(i2);
        }
        return NotificationCompatJellybean.readAction(factory3, factory4, action.icon, action.title, action.actionIntent, bundle);
    }

    public static int getActionCount(Notification notification) {
        Notification notification2 = notification;
        if (notification2.actions != null) {
            return notification2.actions.length;
        }
        return 0;
    }

    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static String getGroup(Notification notification) {
        return notification.extras.getString(NotificationCompatExtras.EXTRA_GROUP_KEY);
    }

    public static boolean getLocalOnly(Notification notification) {
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY);
    }

    public static String getSortKey(Notification notification) {
        return notification.extras.getString(NotificationCompatExtras.EXTRA_SORT_KEY);
    }

    public static boolean isGroupSummary(Notification notification) {
        return notification.extras.getBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY);
    }
}

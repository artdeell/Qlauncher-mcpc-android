package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.NotificationCompatBase.Action;
import android.support.p000v4.app.NotificationCompatBase.Action.Factory;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.NotificationCompatApi20 */
class NotificationCompatApi20 {

    /* renamed from: android.support.v4.app.NotificationCompatApi20$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {

        /* renamed from: b */
        private android.app.Notification.Builder f3b;
        private Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            android.app.Notification.Builder builder;
            Bundle bundle2;
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
            ArrayList<String> arrayList2 = arrayList;
            Bundle bundle3 = bundle;
            String str3 = str;
            boolean z10 = z5;
            String str4 = str2;
            android.app.Notification.Builder builder2 = builder;
            android.app.Notification.Builder builder3 = new android.app.Notification.Builder(context);
            this.f3b = builder2.setWhen(notification2.when).setShowWhen(z7).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews2).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((2 & notification2.flags) != 0).setOnlyAlertOnce((8 & notification2.flags) != 0).setAutoCancel((16 & notification2.flags) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence5).setContentText(charSequence6).setSubText(charSequence8).setContentInfo(charSequence7).setContentIntent(pendingIntent3).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(pendingIntent4, (128 & notification2.flags) != 0).setLargeIcon(bitmap2).setNumber(i5).setUsesChronometer(z8).setPriority(i8).setProgress(i6, i7, z6).setLocalOnly(z9).setGroup(str3).setGroupSummary(z10).setSortKey(str4);
            Bundle bundle4 = bundle2;
            Bundle bundle5 = new Bundle();
            this.mExtras = bundle4;
            if (bundle3 != null) {
                this.mExtras.putAll(bundle3);
            }
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                this.mExtras.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }

        public void addAction(Action action) {
            Action action2 = action;
            NotificationCompatApi20.addAction(this.f3b, action2);
        }

        public Notification build() {
            android.app.Notification.Builder extras = this.f3b.setExtras(this.mExtras);
            return this.f3b.build();
        }

        public android.app.Notification.Builder getBuilder() {
            return this.f3b;
        }
    }

    NotificationCompatApi20() {
    }

    public static void addAction(android.app.Notification.Builder builder, Action action) {
        android.app.Notification.Action.Builder builder2;
        android.app.Notification.Builder builder3 = builder;
        Action action2 = action;
        android.app.Notification.Action.Builder builder4 = builder2;
        android.app.Notification.Action.Builder builder5 = new android.app.Notification.Action.Builder(action2.getIcon(), action2.getTitle(), action2.getActionIntent());
        android.app.Notification.Action.Builder builder6 = builder4;
        if (action2.getRemoteInputs() != null) {
            RemoteInput[] fromCompat = RemoteInputCompatApi20.fromCompat(action2.getRemoteInputs());
            int length = fromCompat.length;
            for (int i = 0; i < length; i++) {
                android.app.Notification.Action.Builder addRemoteInput = builder6.addRemoteInput(fromCompat[i]);
            }
        }
        if (action2.getExtras() != null) {
            android.app.Notification.Action.Builder addExtras = builder6.addExtras(action2.getExtras());
        }
        android.app.Notification.Builder addAction = builder3.addAction(builder6.build());
    }

    public static Action getAction(Notification notification, int i, Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return getActionCompatFromAction(notification.actions[i], factory, factory2);
    }

    private static Action getActionCompatFromAction(Notification.Action action, Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Notification.Action action2 = action;
        return factory.build(action2.icon, action2.title, action2.actionIntent, action2.getExtras(), RemoteInputCompatApi20.toCompat(action2.getRemoteInputs(), factory2));
    }

    private static Notification.Action getActionFromActionCompat(Action action) {
        android.app.Notification.Action.Builder builder;
        Action action2 = action;
        android.app.Notification.Action.Builder builder2 = builder;
        android.app.Notification.Action.Builder builder3 = new android.app.Notification.Action.Builder(action2.getIcon(), action2.getTitle(), action2.getActionIntent());
        android.app.Notification.Action.Builder addExtras = builder2.addExtras(action2.getExtras());
        RemoteInputCompatBase.RemoteInput[] remoteInputs = action2.getRemoteInputs();
        if (remoteInputs != null) {
            RemoteInput[] fromCompat = RemoteInputCompatApi20.fromCompat(remoteInputs);
            int length = fromCompat.length;
            for (int i = 0; i < length; i++) {
                android.app.Notification.Action.Builder addRemoteInput = addExtras.addRemoteInput(fromCompat[i]);
            }
        }
        return addExtras.build();
    }

    public static Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList, Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Action[] newArray;
        ArrayList<Parcelable> arrayList2 = arrayList;
        Factory factory3 = factory;
        RemoteInputCompatBase.RemoteInput.Factory factory4 = factory2;
        if (arrayList2 == null) {
            newArray = null;
        } else {
            newArray = factory3.newArray(arrayList2.size());
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = getActionCompatFromAction((Notification.Action) arrayList2.get(i), factory3, factory4);
            }
        }
        return newArray;
    }

    public static String getGroup(Notification notification) {
        return notification.getGroup();
    }

    public static boolean getLocalOnly(Notification notification) {
        return (256 & notification.flags) != 0;
    }

    public static ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Action[] actionArr2 = actionArr;
        if (actionArr2 == null) {
            arrayList2 = null;
        } else {
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList(actionArr2.length);
            arrayList2 = arrayList3;
            int length = actionArr2.length;
            for (int i = 0; i < length; i++) {
                boolean add = arrayList2.add(getActionFromActionCompat(actionArr2[i]));
            }
        }
        return arrayList2;
    }

    public static String getSortKey(Notification notification) {
        return notification.getSortKey();
    }

    public static boolean isGroupSummary(Notification notification) {
        return (512 & notification.flags) != 0;
    }
}

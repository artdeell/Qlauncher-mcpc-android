package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.NotificationCompatBase.Action;
import android.support.p000v4.app.NotificationCompatBase.UnreadConversation;
import android.support.p000v4.app.NotificationCompatBase.UnreadConversation.Factory;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.NotificationCompatApi21 */
class NotificationCompatApi21 {
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_MESSAGES = "messages";
    private static final String KEY_ON_READ = "on_read";
    private static final String KEY_ON_REPLY = "on_reply";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REMOTE_INPUT = "remote_input";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "timestamp";

    /* renamed from: android.support.v4.app.NotificationCompatApi21$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {

        /* renamed from: b */
        private android.app.Notification.Builder f4b;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i5, int i6, Notification notification2, String str2, boolean z5, String str3) {
            android.app.Notification.Builder builder;
            Notification notification3 = notification;
            CharSequence charSequence5 = charSequence;
            CharSequence charSequence6 = charSequence2;
            CharSequence charSequence7 = charSequence3;
            RemoteViews remoteViews2 = remoteViews;
            int i7 = i;
            PendingIntent pendingIntent3 = pendingIntent;
            PendingIntent pendingIntent4 = pendingIntent2;
            Bitmap bitmap2 = bitmap;
            int i8 = i2;
            int i9 = i3;
            boolean z6 = z;
            boolean z7 = z2;
            boolean z8 = z3;
            int i10 = i4;
            CharSequence charSequence8 = charSequence4;
            boolean z9 = z4;
            String str4 = str;
            ArrayList<String> arrayList2 = arrayList;
            Bundle bundle2 = bundle;
            int i11 = i5;
            int i12 = i6;
            Notification notification4 = notification2;
            String str5 = str2;
            boolean z10 = z5;
            String str6 = str3;
            android.app.Notification.Builder builder2 = builder;
            android.app.Notification.Builder builder3 = new android.app.Notification.Builder(context);
            this.f4b = builder2.setWhen(notification3.when).setShowWhen(z7).setSmallIcon(notification3.icon, notification3.iconLevel).setContent(notification3.contentView).setTicker(notification3.tickerText, remoteViews2).setSound(notification3.sound, notification3.audioStreamType).setVibrate(notification3.vibrate).setLights(notification3.ledARGB, notification3.ledOnMS, notification3.ledOffMS).setOngoing((2 & notification3.flags) != 0).setOnlyAlertOnce((8 & notification3.flags) != 0).setAutoCancel((16 & notification3.flags) != 0).setDefaults(notification3.defaults).setContentTitle(charSequence5).setContentText(charSequence6).setSubText(charSequence8).setContentInfo(charSequence7).setContentIntent(pendingIntent3).setDeleteIntent(notification3.deleteIntent).setFullScreenIntent(pendingIntent4, (128 & notification3.flags) != 0).setLargeIcon(bitmap2).setNumber(i7).setUsesChronometer(z8).setPriority(i10).setProgress(i8, i9, z6).setLocalOnly(z9).setExtras(bundle2).setGroup(str5).setGroupSummary(z10).setSortKey(str6).setCategory(str4).setColor(i11).setVisibility(i12).setPublicVersion(notification4);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                android.app.Notification.Builder addPerson = this.f4b.addPerson((String) it.next());
            }
        }

        public void addAction(Action action) {
            Action action2 = action;
            NotificationCompatApi20.addAction(this.f4b, action2);
        }

        public Notification build() {
            return this.f4b.build();
        }

        public android.app.Notification.Builder getBuilder() {
            return this.f4b;
        }
    }

    NotificationCompatApi21() {
    }

    private static RemoteInput fromCompatRemoteInput(RemoteInputCompatBase.RemoteInput remoteInput) {
        android.app.RemoteInput.Builder builder;
        RemoteInputCompatBase.RemoteInput remoteInput2 = remoteInput;
        android.app.RemoteInput.Builder builder2 = builder;
        android.app.RemoteInput.Builder builder3 = new android.app.RemoteInput.Builder(remoteInput2.getResultKey());
        return builder2.setLabel(remoteInput2.getLabel()).setChoices(remoteInput2.getChoices()).setAllowFreeFormInput(remoteInput2.getAllowFreeFormInput()).addExtras(remoteInput2.getExtras()).build();
    }

    static Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
        Bundle bundle;
        Bundle bundle2;
        UnreadConversation unreadConversation2 = unreadConversation;
        if (unreadConversation2 == null) {
            return null;
        }
        Bundle bundle3 = bundle;
        Bundle bundle4 = new Bundle();
        Bundle bundle5 = bundle3;
        String str = null;
        if (unreadConversation2.getParticipants() != null) {
            str = null;
            if (unreadConversation2.getParticipants().length > 1) {
                str = unreadConversation2.getParticipants()[0];
            }
        }
        Parcelable[] parcelableArr = new Parcelable[unreadConversation2.getMessages().length];
        for (int i = 0; i < parcelableArr.length; i++) {
            Bundle bundle6 = bundle2;
            Bundle bundle7 = new Bundle();
            Bundle bundle8 = bundle6;
            bundle8.putString(KEY_TEXT, unreadConversation2.getMessages()[i]);
            bundle8.putString(KEY_AUTHOR, str);
            parcelableArr[i] = bundle8;
        }
        bundle5.putParcelableArray(KEY_MESSAGES, parcelableArr);
        RemoteInputCompatBase.RemoteInput remoteInput = unreadConversation2.getRemoteInput();
        if (remoteInput != null) {
            bundle5.putParcelable(KEY_REMOTE_INPUT, fromCompatRemoteInput(remoteInput));
        }
        bundle5.putParcelable(KEY_ON_REPLY, unreadConversation2.getReplyPendingIntent());
        bundle5.putParcelable(KEY_ON_READ, unreadConversation2.getReadPendingIntent());
        bundle5.putStringArray(KEY_PARTICIPANTS, unreadConversation2.getParticipants());
        bundle5.putLong(KEY_TIMESTAMP, unreadConversation2.getLatestTimestamp());
        return bundle5;
    }

    public static String getCategory(Notification notification) {
        return notification.category;
    }

    static UnreadConversation getUnreadConversationFromBundle(Bundle bundle, Factory factory, RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Bundle bundle2 = bundle;
        Factory factory3 = factory;
        RemoteInputCompatBase.RemoteInput.Factory factory4 = factory2;
        if (bundle2 != null) {
            Parcelable[] parcelableArray = bundle2.getParcelableArray(KEY_MESSAGES);
            String[] strArr = null;
            if (parcelableArray != null) {
                String[] strArr2 = new String[parcelableArray.length];
                boolean z = true;
                int i = 0;
                while (true) {
                    if (i >= strArr2.length) {
                        break;
                    } else if (!(parcelableArray[i] instanceof Bundle)) {
                        z = false;
                        break;
                    } else {
                        strArr2[i] = ((Bundle) parcelableArray[i]).getString(KEY_TEXT);
                        if (strArr2[i] == null) {
                            z = false;
                            break;
                        }
                        i++;
                    }
                }
                if (z) {
                    strArr = strArr2;
                }
            }
            PendingIntent pendingIntent = (PendingIntent) bundle2.getParcelable(KEY_ON_READ);
            PendingIntent pendingIntent2 = (PendingIntent) bundle2.getParcelable(KEY_ON_REPLY);
            RemoteInput remoteInput = (RemoteInput) bundle2.getParcelable(KEY_REMOTE_INPUT);
            String[] stringArray = bundle2.getStringArray(KEY_PARTICIPANTS);
            if (stringArray != null && stringArray.length == 1) {
                RemoteInputCompatBase.RemoteInput remoteInput2 = null;
                if (remoteInput != null) {
                    remoteInput2 = toCompatRemoteInput(remoteInput, factory4);
                }
                return factory3.build(strArr, remoteInput2, pendingIntent2, pendingIntent, stringArray, bundle2.getLong(KEY_TIMESTAMP));
            }
        }
        return null;
    }

    private static RemoteInputCompatBase.RemoteInput toCompatRemoteInput(RemoteInput remoteInput, RemoteInputCompatBase.RemoteInput.Factory factory) {
        RemoteInput remoteInput2 = remoteInput;
        return factory.build(remoteInput2.getResultKey(), remoteInput2.getLabel(), remoteInput2.getChoices(), remoteInput2.getAllowFreeFormInput(), remoteInput2.getExtras());
    }
}

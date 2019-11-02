package android.support.p000v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.NotificationCompatBase.Action;
import android.support.p000v4.app.NotificationCompatBase.Action.Factory;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompatJellybean */
class NotificationCompatJellybean {
    static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
    static final String EXTRA_GROUP_KEY = "android.support.groupKey";
    static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
    static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
    static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
    static final String EXTRA_SORT_KEY = "android.support.sortKey";
    static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Class<?> sActionClass;
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock;

    /* renamed from: android.support.v4.app.NotificationCompatJellybean$Builder */
    public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {

        /* renamed from: b */
        private android.app.Notification.Builder f6b;
        private List<Bundle> mActionExtrasList;
        private final Bundle mExtras;

        public Builder(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            ArrayList arrayList;
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
            boolean z5 = z;
            boolean z6 = z2;
            int i8 = i4;
            CharSequence charSequence8 = charSequence4;
            boolean z7 = z3;
            Bundle bundle3 = bundle;
            String str3 = str;
            boolean z8 = z4;
            String str4 = str2;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.mActionExtrasList = arrayList2;
            android.app.Notification.Builder builder2 = builder;
            android.app.Notification.Builder builder3 = new android.app.Notification.Builder(context2);
            this.f6b = builder2.setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, remoteViews2).setSound(notification2.sound, notification2.audioStreamType).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((2 & notification2.flags) != 0).setOnlyAlertOnce((8 & notification2.flags) != 0).setAutoCancel((16 & notification2.flags) != 0).setDefaults(notification2.defaults).setContentTitle(charSequence5).setContentText(charSequence6).setSubText(charSequence8).setContentInfo(charSequence7).setContentIntent(pendingIntent3).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(pendingIntent4, (128 & notification2.flags) != 0).setLargeIcon(bitmap2).setNumber(i5).setUsesChronometer(z6).setPriority(i8).setProgress(i6, i7, z5);
            Bundle bundle4 = bundle2;
            Bundle bundle5 = new Bundle();
            this.mExtras = bundle4;
            if (bundle3 != null) {
                this.mExtras.putAll(bundle3);
            }
            if (z7) {
                this.mExtras.putBoolean("android.support.localOnly", true);
            }
            if (str3 != null) {
                this.mExtras.putString("android.support.groupKey", str3);
                if (z8) {
                    this.mExtras.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.mExtras.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str4 != null) {
                this.mExtras.putString("android.support.sortKey", str4);
            }
        }

        public void addAction(Action action) {
            boolean add = this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.f6b, action));
        }

        public Notification build() {
            Bundle bundle;
            Notification build = this.f6b.build();
            Bundle extras = NotificationCompatJellybean.getExtras(build);
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle(this.mExtras);
            Bundle bundle4 = bundle2;
            for (String str : this.mExtras.keySet()) {
                if (extras.containsKey(str)) {
                    bundle4.remove(str);
                }
            }
            extras.putAll(bundle4);
            SparseArray buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (buildActionExtrasMap != null) {
                NotificationCompatJellybean.getExtras(build).putSparseParcelableArray("android.support.actionExtras", buildActionExtrasMap);
            }
            return build;
        }

        public android.app.Notification.Builder getBuilder() {
            return this.f6b;
        }
    }

    static {
        Object obj;
        Object obj2;
        Object obj3 = obj;
        Object obj4 = new Object();
        sExtrasLock = obj3;
        Object obj5 = obj2;
        Object obj6 = new Object();
        sActionsLock = obj5;
    }

    NotificationCompatJellybean() {
    }

    public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPictureStyle;
        CharSequence charSequence3 = charSequence;
        boolean z3 = z;
        CharSequence charSequence4 = charSequence2;
        Bitmap bitmap3 = bitmap;
        Bitmap bitmap4 = bitmap2;
        boolean z4 = z2;
        BigPictureStyle bigPictureStyle2 = bigPictureStyle;
        BigPictureStyle bigPictureStyle3 = new BigPictureStyle(notificationBuilderWithBuilderAccessor.getBuilder());
        BigPictureStyle bigPicture = bigPictureStyle2.setBigContentTitle(charSequence3).bigPicture(bitmap3);
        if (z4) {
            BigPictureStyle bigLargeIcon = bigPicture.bigLargeIcon(bitmap4);
        }
        if (z3) {
            BigPictureStyle summaryText = bigPicture.setSummaryText(charSequence4);
        }
    }

    public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigTextStyle;
        CharSequence charSequence4 = charSequence;
        boolean z2 = z;
        CharSequence charSequence5 = charSequence2;
        CharSequence charSequence6 = charSequence3;
        BigTextStyle bigTextStyle2 = bigTextStyle;
        BigTextStyle bigTextStyle3 = new BigTextStyle(notificationBuilderWithBuilderAccessor.getBuilder());
        BigTextStyle bigText = bigTextStyle2.setBigContentTitle(charSequence4).bigText(charSequence6);
        if (z2) {
            BigTextStyle summaryText = bigText.setSummaryText(charSequence5);
        }
    }

    public static void addInboxStyle(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle inboxStyle;
        CharSequence charSequence3 = charSequence;
        boolean z2 = z;
        CharSequence charSequence4 = charSequence2;
        ArrayList<CharSequence> arrayList2 = arrayList;
        InboxStyle inboxStyle2 = inboxStyle;
        InboxStyle inboxStyle3 = new InboxStyle(notificationBuilderWithBuilderAccessor.getBuilder());
        InboxStyle bigContentTitle = inboxStyle2.setBigContentTitle(charSequence3);
        if (z2) {
            InboxStyle summaryText = bigContentTitle.setSummaryText(charSequence4);
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            InboxStyle addLine = bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        SparseArray<Bundle> sparseArray;
        List<Bundle> list2 = list;
        SparseArray<Bundle> sparseArray2 = null;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list2.get(i);
            if (bundle != null) {
                if (sparseArray2 == null) {
                    SparseArray<Bundle> sparseArray3 = sparseArray;
                    SparseArray<Bundle> sparseArray4 = new SparseArray<>();
                    sparseArray2 = sparseArray3;
                }
                sparseArray2.put(i, bundle);
            }
        }
        return sparseArray2;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        boolean z = true;
        if (sActionsAccessFailed) {
            return false;
        }
        try {
            if (sActionsField == null) {
                sActionClass = Class.forName("android.app.Notification$Action");
                sActionIconField = sActionClass.getDeclaredField(KEY_ICON);
                sActionTitleField = sActionClass.getDeclaredField(KEY_TITLE);
                sActionIntentField = sActionClass.getDeclaredField(KEY_ACTION_INTENT);
                sActionsField = Notification.class.getDeclaredField("actions");
                sActionsField.setAccessible(true);
            }
        } catch (ClassNotFoundException e) {
            int e2 = Log.e(TAG, "Unable to access notification actions", e);
            sActionsAccessFailed = true;
        } catch (NoSuchFieldException e3) {
            int e4 = Log.e(TAG, "Unable to access notification actions", e3);
            sActionsAccessFailed = true;
        }
        if (sActionsAccessFailed) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.p000v4.app.NotificationCompatBase.Action getAction(android.app.Notification r19, int r20, android.support.p000v4.app.NotificationCompatBase.Action.Factory r21, android.support.p000v4.app.RemoteInputCompatBase.RemoteInput.Factory r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.Object r13 = sActionsLock
            r4 = r13
            r13 = r4
            monitor-enter(r13)
            r13 = r0
            java.lang.Object[] r13 = getActionObjectsLocked(r13)     // Catch:{ IllegalAccessException -> 0x0061 }
            r14 = r1
            r13 = r13[r14]     // Catch:{ IllegalAccessException -> 0x0061 }
            r8 = r13
            r13 = r0
            android.os.Bundle r13 = getExtras(r13)     // Catch:{ IllegalAccessException -> 0x0061 }
            r9 = r13
            r13 = 0
            r10 = r13
            r13 = r9
            if (r13 == 0) goto L_0x0037
            r13 = r9
            java.lang.String r14 = "android.support.actionExtras"
            android.util.SparseArray r13 = r13.getSparseParcelableArray(r14)     // Catch:{ IllegalAccessException -> 0x0061 }
            r11 = r13
            r13 = 0
            r10 = r13
            r13 = r11
            if (r13 == 0) goto L_0x0037
            r13 = r11
            r14 = r1
            java.lang.Object r13 = r13.get(r14)     // Catch:{ IllegalAccessException -> 0x0061 }
            android.os.Bundle r13 = (android.os.Bundle) r13     // Catch:{ IllegalAccessException -> 0x0061 }
            r10 = r13
        L_0x0037:
            r13 = r2
            r14 = r3
            java.lang.reflect.Field r15 = sActionIconField     // Catch:{ IllegalAccessException -> 0x0061 }
            r16 = r8
            int r15 = r15.getInt(r16)     // Catch:{ IllegalAccessException -> 0x0061 }
            java.lang.reflect.Field r16 = sActionTitleField     // Catch:{ IllegalAccessException -> 0x0061 }
            r17 = r8
            java.lang.Object r16 = r16.get(r17)     // Catch:{ IllegalAccessException -> 0x0061 }
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16     // Catch:{ IllegalAccessException -> 0x0061 }
            java.lang.reflect.Field r17 = sActionIntentField     // Catch:{ IllegalAccessException -> 0x0061 }
            r18 = r8
            java.lang.Object r17 = r17.get(r18)     // Catch:{ IllegalAccessException -> 0x0061 }
            android.app.PendingIntent r17 = (android.app.PendingIntent) r17     // Catch:{ IllegalAccessException -> 0x0061 }
            r18 = r10
            android.support.v4.app.NotificationCompatBase$Action r13 = readAction(r13, r14, r15, r16, r17, r18)     // Catch:{ IllegalAccessException -> 0x0061 }
            r12 = r13
            r13 = r4
            monitor-exit(r13)     // Catch:{ all -> 0x0074 }
            r13 = r12
            r0 = r13
        L_0x0060:
            return r0
        L_0x0061:
            r13 = move-exception
            r6 = r13
            java.lang.String r13 = "NotificationCompat"
            java.lang.String r14 = "Unable to access notification actions"
            r15 = r6
            int r13 = android.util.Log.e(r13, r14, r15)     // Catch:{ all -> 0x0074 }
            r13 = 1
            sActionsAccessFailed = r13     // Catch:{ all -> 0x0074 }
            r13 = r4
            monitor-exit(r13)     // Catch:{ all -> 0x0074 }
            r13 = 0
            r0 = r13
            goto L_0x0060
        L_0x0074:
            r13 = move-exception
            r5 = r13
            r13 = r4
            monitor-exit(r13)     // Catch:{ all -> 0x0074 }
            r13 = r5
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.NotificationCompatJellybean.getAction(android.app.Notification, int, android.support.v4.app.NotificationCompatBase$Action$Factory, android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory):android.support.v4.app.NotificationCompatBase$Action");
    }

    public static int getActionCount(Notification notification) {
        Notification notification2 = notification;
        int i = sActionsLock;
        synchronized (i) {
            try {
                Object[] actionObjectsLocked = getActionObjectsLocked(notification2);
                th = actionObjectsLocked != null ? actionObjectsLocked.length : 0;
            } finally {
                Throwable th = th;
                int i2 = i;
                Throwable th2 = th;
            }
        }
        return th;
    }

    private static Action getActionFromBundle(Bundle bundle, Factory factory, RemoteInput.Factory factory2) {
        Bundle bundle2 = bundle;
        return factory.build(bundle2.getInt(KEY_ICON), bundle2.getCharSequence(KEY_TITLE), (PendingIntent) bundle2.getParcelable(KEY_ACTION_INTENT), bundle2.getBundle(KEY_EXTRAS), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle2, KEY_REMOTE_INPUTS), factory2));
    }

    private static Object[] getActionObjectsLocked(Notification notification) {
        Notification notification2 = notification;
        Object obj = sActionsLock;
        synchronized (obj) {
            try {
                if (!ensureActionReflectionReadyLocked()) {
                    return null;
                }
                Object[] objArr = (Object[]) sActionsField.get(notification2);
                return objArr;
            } catch (IllegalAccessException e) {
                int e2 = Log.e(TAG, "Unable to access notification actions", e);
                sActionsAccessFailed = true;
                Object obj2 = obj;
                return null;
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj3 = obj;
                throw th2;
            }
        }
    }

    public static Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList, Factory factory, RemoteInput.Factory factory2) {
        Action[] newArray;
        ArrayList<Parcelable> arrayList2 = arrayList;
        Factory factory3 = factory;
        RemoteInput.Factory factory4 = factory2;
        if (arrayList2 == null) {
            newArray = null;
        } else {
            newArray = factory3.newArray(arrayList2.size());
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = getActionFromBundle((Bundle) arrayList2.get(i), factory3, factory4);
            }
        }
        return newArray;
    }

    private static Bundle getBundleForAction(Action action) {
        Bundle bundle;
        Action action2 = action;
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle();
        Bundle bundle4 = bundle2;
        bundle4.putInt(KEY_ICON, action2.getIcon());
        bundle4.putCharSequence(KEY_TITLE, action2.getTitle());
        bundle4.putParcelable(KEY_ACTION_INTENT, action2.getActionIntent());
        bundle4.putBundle(KEY_EXTRAS, action2.getExtras());
        bundle4.putParcelableArray(KEY_REMOTE_INPUTS, RemoteInputCompatJellybean.toBundleArray(action2.getRemoteInputs()));
        return bundle4;
    }

    public static Bundle getExtras(Notification notification) {
        Bundle bundle;
        Notification notification2 = notification;
        Object obj = sExtrasLock;
        synchronized (obj) {
            try {
                if (sExtrasFieldAccessFailed) {
                    return null;
                }
                if (sExtrasField == null) {
                    Field declaredField = Notification.class.getDeclaredField(KEY_EXTRAS);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        int e = Log.e(TAG, "Notification.extras field is not of type Bundle");
                        sExtrasFieldAccessFailed = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    sExtrasField = declaredField;
                }
                Bundle bundle2 = (Bundle) sExtrasField.get(notification2);
                if (bundle2 == null) {
                    Bundle bundle3 = bundle;
                    Bundle bundle4 = new Bundle();
                    bundle2 = bundle3;
                    sExtrasField.set(notification2, bundle2);
                }
                return bundle2;
            } catch (IllegalAccessException e2) {
                int e3 = Log.e(TAG, "Unable to access notification extras", e2);
            } catch (NoSuchFieldException e4) {
                int e5 = Log.e(TAG, "Unable to access notification extras", e4);
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
        sExtrasFieldAccessFailed = true;
        return null;
    }

    public static String getGroup(Notification notification) {
        return getExtras(notification).getString("android.support.groupKey");
    }

    public static boolean getLocalOnly(Notification notification) {
        return getExtras(notification).getBoolean("android.support.localOnly");
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
                boolean add = arrayList2.add(getBundleForAction(actionArr2[i]));
            }
        }
        return arrayList2;
    }

    public static String getSortKey(Notification notification) {
        return getExtras(notification).getString("android.support.sortKey");
    }

    public static boolean isGroupSummary(Notification notification) {
        return getExtras(notification).getBoolean("android.support.isGroupSummary");
    }

    public static Action readAction(Factory factory, RemoteInput.Factory factory2, int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        Factory factory3 = factory;
        RemoteInput.Factory factory4 = factory2;
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        PendingIntent pendingIntent2 = pendingIntent;
        Bundle bundle2 = bundle;
        RemoteInput[] remoteInputArr = null;
        if (bundle2 != null) {
            remoteInputArr = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(bundle2, "android.support.remoteInputs"), factory4);
        }
        return factory3.build(i2, charSequence2, pendingIntent2, bundle2, remoteInputArr);
    }

    public static Bundle writeActionAndGetExtras(android.app.Notification.Builder builder, Action action) {
        Bundle bundle;
        Action action2 = action;
        android.app.Notification.Builder addAction = builder.addAction(action2.getIcon(), action2.getTitle(), action2.getActionIntent());
        Bundle bundle2 = bundle;
        Bundle bundle3 = new Bundle(action2.getExtras());
        Bundle bundle4 = bundle2;
        if (action2.getRemoteInputs() != null) {
            bundle4.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(action2.getRemoteInputs()));
        }
        return bundle4;
    }
}

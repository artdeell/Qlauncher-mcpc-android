package android.support.p000v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.p000v4.app.NotificationCompatBase.Action.Factory;
import android.support.p000v4.app.NotificationCompatBase.UnreadConversation;
import android.support.p000v4.app.RemoteInputCompatBase.RemoteInput;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.app.NotificationCompat */
public class NotificationCompat {
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
    @ColorInt
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    /* access modifiers changed from: private */
    public static final NotificationCompatImpl IMPL;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* renamed from: android.support.v4.app.NotificationCompat$Action */
    public static class Action extends android.support.p000v4.app.NotificationCompatBase.Action {
        public static final Factory FACTORY;
        public PendingIntent actionIntent;
        public int icon;
        /* access modifiers changed from: private */
        public final Bundle mExtras;
        private final RemoteInput[] mRemoteInputs;
        public CharSequence title;

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Builder */
        public static final class Builder {
            private final Bundle mExtras;
            private final int mIcon;
            private final PendingIntent mIntent;
            private ArrayList<RemoteInput> mRemoteInputs;
            private final CharSequence mTitle;

            public Builder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                Bundle bundle;
                int i2 = i;
                CharSequence charSequence2 = charSequence;
                PendingIntent pendingIntent2 = pendingIntent;
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                this(i2, charSequence2, pendingIntent2, bundle2);
            }

            private Builder(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                CharSequence charSequence2 = charSequence;
                PendingIntent pendingIntent2 = pendingIntent;
                Bundle bundle2 = bundle;
                this.mIcon = i;
                this.mTitle = Builder.limitCharSequenceLength(charSequence2);
                this.mIntent = pendingIntent2;
                this.mExtras = bundle2;
            }

            public Builder(Action action) {
                Bundle bundle;
                Action action2 = action;
                int i = action2.icon;
                CharSequence charSequence = action2.title;
                PendingIntent pendingIntent = action2.actionIntent;
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle(action2.mExtras);
                this(i, charSequence, pendingIntent, bundle2);
            }

            public Builder addExtras(Bundle bundle) {
                Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    this.mExtras.putAll(bundle2);
                }
                return this;
            }

            public Builder addRemoteInput(RemoteInput remoteInput) {
                ArrayList<RemoteInput> arrayList;
                RemoteInput remoteInput2 = remoteInput;
                if (this.mRemoteInputs == null) {
                    ArrayList<RemoteInput> arrayList2 = arrayList;
                    ArrayList<RemoteInput> arrayList3 = new ArrayList<>();
                    this.mRemoteInputs = arrayList2;
                }
                boolean add = this.mRemoteInputs.add(remoteInput2);
                return this;
            }

            public Action build() {
                Action action;
                Action action2 = action;
                Action action3 = new Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, this.mRemoteInputs != null ? (RemoteInput[]) this.mRemoteInputs.toArray(new RemoteInput[this.mRemoteInputs.size()]) : null, null);
                return action2;
            }

            public Builder extend(Extender extender) {
                Builder extend = extender.extend(this);
                return this;
            }

            public Bundle getExtras() {
                return this.mExtras;
            }
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$Extender */
        public interface Extender {
            Builder extend(Builder builder);
        }

        /* renamed from: android.support.v4.app.NotificationCompat$Action$WearableExtender */
        public static final class WearableExtender implements Extender {
            private static final int DEFAULT_FLAGS = 1;
            private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
            private static final int FLAG_AVAILABLE_OFFLINE = 1;
            private static final String KEY_CANCEL_LABEL = "cancelLabel";
            private static final String KEY_CONFIRM_LABEL = "confirmLabel";
            private static final String KEY_FLAGS = "flags";
            private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
            private CharSequence mCancelLabel;
            private CharSequence mConfirmLabel;
            private int mFlags = 1;
            private CharSequence mInProgressLabel;

            public WearableExtender() {
            }

            public WearableExtender(Action action) {
                Action action2 = action;
                Bundle bundle = action2.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
                if (bundle != null) {
                    this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                    this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
                    this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
                    this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
                }
            }

            private void setFlag(int i, boolean z) {
                int i2 = i;
                if (z) {
                    this.mFlags = i2 | this.mFlags;
                    return;
                }
                this.mFlags &= i2 ^ -1;
            }

            public WearableExtender clone() {
                WearableExtender wearableExtender;
                WearableExtender wearableExtender2 = wearableExtender;
                WearableExtender wearableExtender3 = new WearableExtender();
                WearableExtender wearableExtender4 = wearableExtender2;
                wearableExtender4.mFlags = this.mFlags;
                wearableExtender4.mInProgressLabel = this.mInProgressLabel;
                wearableExtender4.mConfirmLabel = this.mConfirmLabel;
                wearableExtender4.mCancelLabel = this.mCancelLabel;
                return wearableExtender4;
            }

            public Builder extend(Builder builder) {
                Bundle bundle;
                Builder builder2 = builder;
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                Bundle bundle4 = bundle2;
                if (this.mFlags != 1) {
                    bundle4.putInt(KEY_FLAGS, this.mFlags);
                }
                if (this.mInProgressLabel != null) {
                    bundle4.putCharSequence(KEY_IN_PROGRESS_LABEL, this.mInProgressLabel);
                }
                if (this.mConfirmLabel != null) {
                    bundle4.putCharSequence(KEY_CONFIRM_LABEL, this.mConfirmLabel);
                }
                if (this.mCancelLabel != null) {
                    bundle4.putCharSequence(KEY_CANCEL_LABEL, this.mCancelLabel);
                }
                builder2.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle4);
                return builder2;
            }

            public CharSequence getCancelLabel() {
                return this.mCancelLabel;
            }

            public CharSequence getConfirmLabel() {
                return this.mConfirmLabel;
            }

            public CharSequence getInProgressLabel() {
                return this.mInProgressLabel;
            }

            public boolean isAvailableOffline() {
                return (1 & this.mFlags) != 0;
            }

            public WearableExtender setAvailableOffline(boolean z) {
                setFlag(1, z);
                return this;
            }

            public WearableExtender setCancelLabel(CharSequence charSequence) {
                this.mCancelLabel = charSequence;
                return this;
            }

            public WearableExtender setConfirmLabel(CharSequence charSequence) {
                this.mConfirmLabel = charSequence;
                return this;
            }

            public WearableExtender setInProgressLabel(CharSequence charSequence) {
                this.mInProgressLabel = charSequence;
                return this;
            }
        }

        static {
            C00311 r2;
            C00311 r0 = r2;
            C00311 r1 = new Factory() {
                public Action build(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr) {
                    Action action;
                    Action action2 = action;
                    Action action3 = new Action(i, charSequence, pendingIntent, bundle, (RemoteInput[]) remoteInputArr, null);
                    return action2;
                }

                public Action[] newArray(int i) {
                    return new Action[i];
                }
            };
            FACTORY = r0;
        }

        public Action(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            Bundle bundle;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            PendingIntent pendingIntent2 = pendingIntent;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            this(i2, charSequence2, pendingIntent2, bundle2, null);
        }

        private Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr) {
            Bundle bundle2;
            CharSequence charSequence2 = charSequence;
            PendingIntent pendingIntent2 = pendingIntent;
            Bundle bundle3 = bundle;
            RemoteInput[] remoteInputArr2 = remoteInputArr;
            this.icon = i;
            this.title = Builder.limitCharSequenceLength(charSequence2);
            this.actionIntent = pendingIntent2;
            if (bundle3 == null) {
                Bundle bundle4 = bundle2;
                Bundle bundle5 = new Bundle();
                bundle3 = bundle4;
            }
            this.mExtras = bundle3;
            this.mRemoteInputs = remoteInputArr2;
        }

        /* synthetic */ Action(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, C00301 r19) {
            C00301 r6 = r19;
            this(i, charSequence, pendingIntent, bundle, remoteInputArr);
        }

        public PendingIntent getActionIntent() {
            return this.actionIntent;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.icon;
        }

        public RemoteInput[] getRemoteInputs() {
            return this.mRemoteInputs;
        }

        public CharSequence getTitle() {
            return this.title;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigPictureStyle */
    public static class BigPictureStyle extends Style {
        Bitmap mBigLargeIcon;
        boolean mBigLargeIconSet;
        Bitmap mPicture;

        public BigPictureStyle() {
        }

        public BigPictureStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigPictureStyle bigLargeIcon(Bitmap bitmap) {
            this.mBigLargeIcon = bitmap;
            this.mBigLargeIconSet = true;
            return this;
        }

        public BigPictureStyle bigPicture(Bitmap bitmap) {
            this.mPicture = bitmap;
            return this;
        }

        public BigPictureStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigPictureStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BigTextStyle */
    public static class BigTextStyle extends Style {
        CharSequence mBigText;

        public BigTextStyle() {
        }

        public BigTextStyle(Builder builder) {
            setBuilder(builder);
        }

        public BigTextStyle bigText(CharSequence charSequence) {
            this.mBigText = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public BigTextStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Builder */
    public static class Builder {
        private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
        public ArrayList<Action> mActions;
        String mCategory;
        int mColor;
        public CharSequence mContentInfo;
        PendingIntent mContentIntent;
        public CharSequence mContentText;
        public CharSequence mContentTitle;
        public Context mContext;
        Bundle mExtras;
        PendingIntent mFullScreenIntent;
        String mGroupKey;
        boolean mGroupSummary;
        public Bitmap mLargeIcon;
        boolean mLocalOnly;
        public Notification mNotification;
        public int mNumber;
        public ArrayList<String> mPeople;
        int mPriority;
        int mProgress;
        boolean mProgressIndeterminate;
        int mProgressMax;
        Notification mPublicVersion;
        boolean mShowWhen = true;
        String mSortKey;
        public Style mStyle;
        public CharSequence mSubText;
        RemoteViews mTickerView;
        public boolean mUseChronometer;
        int mVisibility;

        public Builder(Context context) {
            ArrayList<Action> arrayList;
            Notification notification;
            ArrayList<String> arrayList2;
            Context context2 = context;
            ArrayList<Action> arrayList3 = arrayList;
            ArrayList<Action> arrayList4 = new ArrayList<>();
            this.mActions = arrayList3;
            this.mLocalOnly = false;
            this.mColor = 0;
            this.mVisibility = 0;
            Notification notification2 = notification;
            Notification notification3 = new Notification();
            this.mNotification = notification2;
            this.mContext = context2;
            this.mNotification.when = System.currentTimeMillis();
            this.mNotification.audioStreamType = -1;
            this.mPriority = 0;
            ArrayList<String> arrayList5 = arrayList2;
            ArrayList<String> arrayList6 = new ArrayList<>();
            this.mPeople = arrayList5;
        }

        protected static CharSequence limitCharSequenceLength(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            return (charSequence2 != null && charSequence2.length() > 5120) ? charSequence2.subSequence(0, 5120) : charSequence2;
        }

        private void setFlag(int i, boolean z) {
            int i2 = i;
            if (z) {
                Notification notification = this.mNotification;
                notification.flags = i2 | notification.flags;
                return;
            }
            this.mNotification.flags &= i2 ^ -1;
        }

        public Builder addAction(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            Action action;
            int i2 = i;
            CharSequence charSequence2 = charSequence;
            PendingIntent pendingIntent2 = pendingIntent;
            ArrayList<Action> arrayList = this.mActions;
            Action action2 = action;
            Action action3 = new Action(i2, charSequence2, pendingIntent2);
            boolean add = arrayList.add(action2);
            return this;
        }

        public Builder addAction(Action action) {
            boolean add = this.mActions.add(action);
            return this;
        }

        public Builder addExtras(Bundle bundle) {
            Bundle bundle2;
            Bundle bundle3 = bundle;
            if (bundle3 != null) {
                if (this.mExtras == null) {
                    Bundle bundle4 = bundle2;
                    Bundle bundle5 = new Bundle(bundle3);
                    this.mExtras = bundle4;
                } else {
                    this.mExtras.putAll(bundle3);
                    return this;
                }
            }
            return this;
        }

        public Builder addPerson(String str) {
            boolean add = this.mPeople.add(str);
            return this;
        }

        public Notification build() {
            return NotificationCompat.IMPL.build(this, getExtender());
        }

        public Builder extend(Extender extender) {
            Builder extend = extender.extend(this);
            return this;
        }

        /* access modifiers changed from: protected */
        public BuilderExtender getExtender() {
            BuilderExtender builderExtender;
            BuilderExtender builderExtender2 = builderExtender;
            BuilderExtender builderExtender3 = new BuilderExtender();
            return builderExtender2;
        }

        public Bundle getExtras() {
            Bundle bundle;
            if (this.mExtras == null) {
                Bundle bundle2 = bundle;
                Bundle bundle3 = new Bundle();
                this.mExtras = bundle2;
            }
            return this.mExtras;
        }

        @Deprecated
        public Notification getNotification() {
            return build();
        }

        public Builder setAutoCancel(boolean z) {
            setFlag(16, z);
            return this;
        }

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setColor(@ColorInt int i) {
            this.mColor = i;
            return this;
        }

        public Builder setContent(RemoteViews remoteViews) {
            this.mNotification.contentView = remoteViews;
            return this;
        }

        public Builder setContentInfo(CharSequence charSequence) {
            this.mContentInfo = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.mContentIntent = pendingIntent;
            return this;
        }

        public Builder setContentText(CharSequence charSequence) {
            this.mContentText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setContentTitle(CharSequence charSequence) {
            this.mContentTitle = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setDefaults(int i) {
            int i2 = i;
            this.mNotification.defaults = i2;
            if ((i2 & 4) != 0) {
                Notification notification = this.mNotification;
                notification.flags = 1 | notification.flags;
            }
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.mNotification.deleteIntent = pendingIntent;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            boolean z2 = z;
            this.mFullScreenIntent = pendingIntent;
            setFlag(128, z2);
            return this;
        }

        public Builder setGroup(String str) {
            this.mGroupKey = str;
            return this;
        }

        public Builder setGroupSummary(boolean z) {
            this.mGroupSummary = z;
            return this;
        }

        public Builder setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public Builder setLights(@ColorInt int i, int i2, int i3) {
            int i4 = i2;
            int i5 = i3;
            int i6 = 1;
            this.mNotification.ledARGB = i;
            this.mNotification.ledOnMS = i4;
            this.mNotification.ledOffMS = i5;
            boolean z = (this.mNotification.ledOnMS == 0 || this.mNotification.ledOffMS == 0) ? false : true;
            Notification notification = this.mNotification;
            int i7 = -2 & this.mNotification.flags;
            if (!z) {
                i6 = 0;
            }
            notification.flags = i6 | i7;
            return this;
        }

        public Builder setLocalOnly(boolean z) {
            this.mLocalOnly = z;
            return this;
        }

        public Builder setNumber(int i) {
            this.mNumber = i;
            return this;
        }

        public Builder setOngoing(boolean z) {
            setFlag(2, z);
            return this;
        }

        public Builder setOnlyAlertOnce(boolean z) {
            setFlag(8, z);
            return this;
        }

        public Builder setPriority(int i) {
            this.mPriority = i;
            return this;
        }

        public Builder setProgress(int i, int i2, boolean z) {
            int i3 = i2;
            boolean z2 = z;
            this.mProgressMax = i;
            this.mProgress = i3;
            this.mProgressIndeterminate = z2;
            return this;
        }

        public Builder setPublicVersion(Notification notification) {
            this.mPublicVersion = notification;
            return this;
        }

        public Builder setShowWhen(boolean z) {
            this.mShowWhen = z;
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.mNotification.icon = i;
            return this;
        }

        public Builder setSmallIcon(int i, int i2) {
            int i3 = i2;
            this.mNotification.icon = i;
            this.mNotification.iconLevel = i3;
            return this;
        }

        public Builder setSortKey(String str) {
            this.mSortKey = str;
            return this;
        }

        public Builder setSound(Uri uri) {
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = -1;
            return this;
        }

        public Builder setSound(Uri uri, int i) {
            int i2 = i;
            this.mNotification.sound = uri;
            this.mNotification.audioStreamType = i2;
            return this;
        }

        public Builder setStyle(Style style) {
            Style style2 = style;
            if (this.mStyle != style2) {
                this.mStyle = style2;
                if (this.mStyle != null) {
                    this.mStyle.setBuilder(this);
                }
            }
            return this;
        }

        public Builder setSubText(CharSequence charSequence) {
            this.mSubText = limitCharSequenceLength(charSequence);
            return this;
        }

        public Builder setTicker(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            this.mNotification.tickerText = limitCharSequenceLength(charSequence2);
            return this;
        }

        public Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
            CharSequence charSequence2 = charSequence;
            RemoteViews remoteViews2 = remoteViews;
            this.mNotification.tickerText = limitCharSequenceLength(charSequence2);
            this.mTickerView = remoteViews2;
            return this;
        }

        public Builder setUsesChronometer(boolean z) {
            this.mUseChronometer = z;
            return this;
        }

        public Builder setVibrate(long[] jArr) {
            this.mNotification.vibrate = jArr;
            return this;
        }

        public Builder setVisibility(int i) {
            this.mVisibility = i;
            return this;
        }

        public Builder setWhen(long j) {
            this.mNotification.when = j;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$BuilderExtender */
    protected static class BuilderExtender {
        protected BuilderExtender() {
        }

        public Notification build(Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Builder builder2 = builder;
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$CarExtender */
    public static final class CarExtender implements Extender {
        private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
        private static final String EXTRA_COLOR = "app_color";
        private static final String EXTRA_CONVERSATION = "car_conversation";
        private static final String EXTRA_LARGE_ICON = "large_icon";
        private static final String TAG = "CarExtender";
        private int mColor = 0;
        private Bitmap mLargeIcon;
        private UnreadConversation mUnreadConversation;

        /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation */
        public static class UnreadConversation extends android.support.p000v4.app.NotificationCompatBase.UnreadConversation {
            static final android.support.p000v4.app.NotificationCompatBase.UnreadConversation.Factory FACTORY;
            private final long mLatestTimestamp;
            private final String[] mMessages;
            private final String[] mParticipants;
            private final PendingIntent mReadPendingIntent;
            private final RemoteInput mRemoteInput;
            private final PendingIntent mReplyPendingIntent;

            /* renamed from: android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$Builder */
            public static class Builder {
                private long mLatestTimestamp;
                private final List<String> mMessages;
                private final String mParticipant;
                private PendingIntent mReadPendingIntent;
                private RemoteInput mRemoteInput;
                private PendingIntent mReplyPendingIntent;

                public Builder(String str) {
                    ArrayList arrayList;
                    String str2 = str;
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList();
                    this.mMessages = arrayList2;
                    this.mParticipant = str2;
                }

                public Builder addMessage(String str) {
                    boolean add = this.mMessages.add(str);
                    return this;
                }

                public UnreadConversation build() {
                    UnreadConversation unreadConversation;
                    UnreadConversation unreadConversation2 = unreadConversation;
                    UnreadConversation unreadConversation3 = new UnreadConversation((String[]) this.mMessages.toArray(new String[this.mMessages.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
                    return unreadConversation2;
                }

                public Builder setLatestTimestamp(long j) {
                    this.mLatestTimestamp = j;
                    return this;
                }

                public Builder setReadPendingIntent(PendingIntent pendingIntent) {
                    this.mReadPendingIntent = pendingIntent;
                    return this;
                }

                public Builder setReplyAction(PendingIntent pendingIntent, RemoteInput remoteInput) {
                    PendingIntent pendingIntent2 = pendingIntent;
                    this.mRemoteInput = remoteInput;
                    this.mReplyPendingIntent = pendingIntent2;
                    return this;
                }
            }

            static {
                C00321 r2;
                C00321 r0 = r2;
                C00321 r1 = new android.support.p000v4.app.NotificationCompatBase.UnreadConversation.Factory() {
                    public UnreadConversation build(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                        UnreadConversation unreadConversation;
                        UnreadConversation unreadConversation2 = unreadConversation;
                        UnreadConversation unreadConversation3 = new UnreadConversation(strArr, (RemoteInput) remoteInput, pendingIntent, pendingIntent2, strArr2, j);
                        return unreadConversation2;
                    }
                };
                FACTORY = r0;
            }

            UnreadConversation(String[] strArr, RemoteInput remoteInput, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
                RemoteInput remoteInput2 = remoteInput;
                PendingIntent pendingIntent3 = pendingIntent;
                PendingIntent pendingIntent4 = pendingIntent2;
                String[] strArr3 = strArr2;
                long j2 = j;
                this.mMessages = strArr;
                this.mRemoteInput = remoteInput2;
                this.mReadPendingIntent = pendingIntent4;
                this.mReplyPendingIntent = pendingIntent3;
                this.mParticipants = strArr3;
                this.mLatestTimestamp = j2;
            }

            public long getLatestTimestamp() {
                return this.mLatestTimestamp;
            }

            public String[] getMessages() {
                return this.mMessages;
            }

            public String getParticipant() {
                if (this.mParticipants.length > 0) {
                    return this.mParticipants[0];
                }
                return null;
            }

            public String[] getParticipants() {
                return this.mParticipants;
            }

            public PendingIntent getReadPendingIntent() {
                return this.mReadPendingIntent;
            }

            public RemoteInput getRemoteInput() {
                return this.mRemoteInput;
            }

            public PendingIntent getReplyPendingIntent() {
                return this.mReplyPendingIntent;
            }
        }

        public CarExtender() {
        }

        public CarExtender(Notification notification) {
            Notification notification2 = notification;
            if (VERSION.SDK_INT >= 21) {
                Bundle bundle = NotificationCompat.getExtras(notification2) == null ? null : NotificationCompat.getExtras(notification2).getBundle(EXTRA_CAR_EXTENDER);
                if (bundle != null) {
                    this.mLargeIcon = (Bitmap) bundle.getParcelable(EXTRA_LARGE_ICON);
                    this.mColor = bundle.getInt(EXTRA_COLOR, 0);
                    this.mUnreadConversation = (UnreadConversation) NotificationCompat.IMPL.getUnreadConversationFromBundle(bundle.getBundle(EXTRA_CONVERSATION), UnreadConversation.FACTORY, RemoteInput.FACTORY);
                }
            }
        }

        public Builder extend(Builder builder) {
            Bundle bundle;
            Builder builder2 = builder;
            if (VERSION.SDK_INT < 21) {
                return builder2;
            }
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = bundle2;
            if (this.mLargeIcon != null) {
                bundle4.putParcelable(EXTRA_LARGE_ICON, this.mLargeIcon);
            }
            if (this.mColor != 0) {
                bundle4.putInt(EXTRA_COLOR, this.mColor);
            }
            if (this.mUnreadConversation != null) {
                bundle4.putBundle(EXTRA_CONVERSATION, NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
            }
            builder2.getExtras().putBundle(EXTRA_CAR_EXTENDER, bundle4);
            return builder2;
        }

        @ColorInt
        public int getColor() {
            return this.mColor;
        }

        public Bitmap getLargeIcon() {
            return this.mLargeIcon;
        }

        public UnreadConversation getUnreadConversation() {
            return this.mUnreadConversation;
        }

        public CarExtender setColor(@ColorInt int i) {
            this.mColor = i;
            return this;
        }

        public CarExtender setLargeIcon(Bitmap bitmap) {
            this.mLargeIcon = bitmap;
            return this;
        }

        public CarExtender setUnreadConversation(UnreadConversation unreadConversation) {
            this.mUnreadConversation = unreadConversation;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Extender */
    public interface Extender {
        Builder extend(Builder builder);
    }

    /* renamed from: android.support.v4.app.NotificationCompat$InboxStyle */
    public static class InboxStyle extends Style {
        ArrayList<CharSequence> mTexts;

        public InboxStyle() {
            ArrayList<CharSequence> arrayList;
            ArrayList<CharSequence> arrayList2 = arrayList;
            ArrayList<CharSequence> arrayList3 = new ArrayList<>();
            this.mTexts = arrayList2;
        }

        public InboxStyle(Builder builder) {
            ArrayList<CharSequence> arrayList;
            Builder builder2 = builder;
            ArrayList<CharSequence> arrayList2 = arrayList;
            ArrayList<CharSequence> arrayList3 = new ArrayList<>();
            this.mTexts = arrayList2;
            setBuilder(builder2);
        }

        public InboxStyle addLine(CharSequence charSequence) {
            boolean add = this.mTexts.add(Builder.limitCharSequenceLength(charSequence));
            return this;
        }

        public InboxStyle setBigContentTitle(CharSequence charSequence) {
            this.mBigContentTitle = Builder.limitCharSequenceLength(charSequence);
            return this;
        }

        public InboxStyle setSummaryText(CharSequence charSequence) {
            this.mSummaryText = Builder.limitCharSequenceLength(charSequence);
            this.mSummaryTextSet = true;
            return this;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImpl */
    interface NotificationCompatImpl {
        Notification build(Builder builder, BuilderExtender builderExtender);

        Action getAction(Notification notification, int i);

        int getActionCount(Notification notification);

        Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList);

        Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation);

        String getCategory(Notification notification);

        Bundle getExtras(Notification notification);

        String getGroup(Notification notification);

        boolean getLocalOnly(Notification notification);

        ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr);

        String getSortKey(Notification notification);

        UnreadConversation getUnreadConversationFromBundle(Bundle bundle, UnreadConversation.Factory factory, RemoteInput.Factory factory2);

        boolean isGroupSummary(Notification notification);
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplApi20 */
    static class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
        NotificationCompatImplApi20() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            android.support.p000v4.app.NotificationCompatApi20.Builder builder2;
            Builder builder3 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            android.support.p000v4.app.NotificationCompatApi20.Builder builder4 = builder2;
            android.support.p000v4.app.NotificationCompatApi20.Builder builder5 = new android.support.p000v4.app.NotificationCompatApi20.Builder(builder3.mContext, builder3.mNotification, builder3.mContentTitle, builder3.mContentText, builder3.mContentInfo, builder3.mTickerView, builder3.mNumber, builder3.mContentIntent, builder3.mFullScreenIntent, builder3.mLargeIcon, builder3.mProgressMax, builder3.mProgress, builder3.mProgressIndeterminate, builder3.mShowWhen, builder3.mUseChronometer, builder3.mPriority, builder3.mSubText, builder3.mLocalOnly, builder3.mPeople, builder3.mExtras, builder3.mGroupKey, builder3.mGroupSummary, builder3.mSortKey);
            android.support.p000v4.app.NotificationCompatApi20.Builder builder6 = builder4;
            NotificationCompat.addActionsToBuilder(builder6, builder3.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder6, builder3.mStyle);
            return builderExtender2.build(builder3, builder6);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatApi20.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatApi20.getActionsFromParcelableArrayList(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatApi20.getGroup(notification);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatApi20.getLocalOnly(notification);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return NotificationCompatApi20.getParcelableArrayListForActions(actionArr);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatApi20.getSortKey(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatApi20.isGroupSummary(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplApi21 */
    static class NotificationCompatImplApi21 extends NotificationCompatImplApi20 {
        NotificationCompatImplApi21() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            android.support.p000v4.app.NotificationCompatApi21.Builder builder2;
            Builder builder3 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            android.support.p000v4.app.NotificationCompatApi21.Builder builder4 = builder2;
            android.support.p000v4.app.NotificationCompatApi21.Builder builder5 = new android.support.p000v4.app.NotificationCompatApi21.Builder(builder3.mContext, builder3.mNotification, builder3.mContentTitle, builder3.mContentText, builder3.mContentInfo, builder3.mTickerView, builder3.mNumber, builder3.mContentIntent, builder3.mFullScreenIntent, builder3.mLargeIcon, builder3.mProgressMax, builder3.mProgress, builder3.mProgressIndeterminate, builder3.mShowWhen, builder3.mUseChronometer, builder3.mPriority, builder3.mSubText, builder3.mLocalOnly, builder3.mCategory, builder3.mPeople, builder3.mExtras, builder3.mColor, builder3.mVisibility, builder3.mPublicVersion, builder3.mGroupKey, builder3.mGroupSummary, builder3.mSortKey);
            android.support.p000v4.app.NotificationCompatApi21.Builder builder6 = builder4;
            NotificationCompat.addActionsToBuilder(builder6, builder3.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder6, builder3.mStyle);
            return builderExtender2.build(builder3, builder6);
        }

        public Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
            return NotificationCompatApi21.getBundleForUnreadConversation(unreadConversation);
        }

        public String getCategory(Notification notification) {
            return NotificationCompatApi21.getCategory(notification);
        }

        public UnreadConversation getUnreadConversationFromBundle(Bundle bundle, UnreadConversation.Factory factory, RemoteInput.Factory factory2) {
            return NotificationCompatApi21.getUnreadConversationFromBundle(bundle, factory, factory2);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplBase */
    static class NotificationCompatImplBase implements NotificationCompatImpl {
        NotificationCompatImplBase() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            Builder builder2 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            Notification notification = builder2.mNotification;
            notification.setLatestEventInfo(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentIntent);
            if (builder2.mPriority > 0) {
                notification.flags = 128 | notification.flags;
            }
            return notification;
        }

        public Action getAction(Notification notification, int i) {
            Notification notification2 = notification;
            int i2 = i;
            return null;
        }

        public int getActionCount(Notification notification) {
            Notification notification2 = notification;
            return 0;
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            ArrayList<Parcelable> arrayList2 = arrayList;
            return null;
        }

        public Bundle getBundleForUnreadConversation(UnreadConversation unreadConversation) {
            UnreadConversation unreadConversation2 = unreadConversation;
            return null;
        }

        public String getCategory(Notification notification) {
            Notification notification2 = notification;
            return null;
        }

        public Bundle getExtras(Notification notification) {
            Notification notification2 = notification;
            return null;
        }

        public String getGroup(Notification notification) {
            Notification notification2 = notification;
            return null;
        }

        public boolean getLocalOnly(Notification notification) {
            Notification notification2 = notification;
            return false;
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            Action[] actionArr2 = actionArr;
            return null;
        }

        public String getSortKey(Notification notification) {
            Notification notification2 = notification;
            return null;
        }

        public UnreadConversation getUnreadConversationFromBundle(Bundle bundle, UnreadConversation.Factory factory, RemoteInput.Factory factory2) {
            Bundle bundle2 = bundle;
            UnreadConversation.Factory factory3 = factory;
            RemoteInput.Factory factory4 = factory2;
            return null;
        }

        public boolean isGroupSummary(Notification notification) {
            Notification notification2 = notification;
            return false;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplGingerbread */
    static class NotificationCompatImplGingerbread extends NotificationCompatImplBase {
        NotificationCompatImplGingerbread() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            Builder builder2 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            Notification notification = builder2.mNotification;
            notification.setLatestEventInfo(builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentIntent);
            Notification add = NotificationCompatGingerbread.add(notification, builder2.mContext, builder2.mContentTitle, builder2.mContentText, builder2.mContentIntent, builder2.mFullScreenIntent);
            if (builder2.mPriority > 0) {
                add.flags = 128 | add.flags;
            }
            return add;
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplHoneycomb */
    static class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        NotificationCompatImplHoneycomb() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            Builder builder2 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            return NotificationCompatHoneycomb.add(builder2.mContext, builder2.mNotification, builder2.mContentTitle, builder2.mContentText, builder2.mContentInfo, builder2.mTickerView, builder2.mNumber, builder2.mContentIntent, builder2.mFullScreenIntent, builder2.mLargeIcon);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplIceCreamSandwich */
    static class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        NotificationCompatImplIceCreamSandwich() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            android.support.p000v4.app.NotificationCompatIceCreamSandwich.Builder builder2;
            Builder builder3 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            Builder builder4 = builder3;
            android.support.p000v4.app.NotificationCompatIceCreamSandwich.Builder builder5 = builder2;
            android.support.p000v4.app.NotificationCompatIceCreamSandwich.Builder builder6 = new android.support.p000v4.app.NotificationCompatIceCreamSandwich.Builder(builder3.mContext, builder3.mNotification, builder3.mContentTitle, builder3.mContentText, builder3.mContentInfo, builder3.mTickerView, builder3.mNumber, builder3.mContentIntent, builder3.mFullScreenIntent, builder3.mLargeIcon, builder3.mProgressMax, builder3.mProgress, builder3.mProgressIndeterminate);
            return builderExtender2.build(builder4, builder5);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplJellybean */
    static class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        NotificationCompatImplJellybean() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            android.support.p000v4.app.NotificationCompatJellybean.Builder builder2;
            Builder builder3 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            android.support.p000v4.app.NotificationCompatJellybean.Builder builder4 = builder2;
            android.support.p000v4.app.NotificationCompatJellybean.Builder builder5 = new android.support.p000v4.app.NotificationCompatJellybean.Builder(builder3.mContext, builder3.mNotification, builder3.mContentTitle, builder3.mContentText, builder3.mContentInfo, builder3.mTickerView, builder3.mNumber, builder3.mContentIntent, builder3.mFullScreenIntent, builder3.mLargeIcon, builder3.mProgressMax, builder3.mProgress, builder3.mProgressIndeterminate, builder3.mUseChronometer, builder3.mPriority, builder3.mSubText, builder3.mLocalOnly, builder3.mExtras, builder3.mGroupKey, builder3.mGroupSummary, builder3.mSortKey);
            android.support.p000v4.app.NotificationCompatJellybean.Builder builder6 = builder4;
            NotificationCompat.addActionsToBuilder(builder6, builder3.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder6, builder3.mStyle);
            return builderExtender2.build(builder3, builder6);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatJellybean.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public int getActionCount(Notification notification) {
            return NotificationCompatJellybean.getActionCount(notification);
        }

        public Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> arrayList) {
            return (Action[]) NotificationCompatJellybean.getActionsFromParcelableArrayList(arrayList, Action.FACTORY, RemoteInput.FACTORY);
        }

        public Bundle getExtras(Notification notification) {
            return NotificationCompatJellybean.getExtras(notification);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatJellybean.getGroup(notification);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatJellybean.getLocalOnly(notification);
        }

        public ArrayList<Parcelable> getParcelableArrayListForActions(Action[] actionArr) {
            return NotificationCompatJellybean.getParcelableArrayListForActions(actionArr);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatJellybean.getSortKey(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatJellybean.isGroupSummary(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$NotificationCompatImplKitKat */
    static class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
        NotificationCompatImplKitKat() {
        }

        public Notification build(Builder builder, BuilderExtender builderExtender) {
            android.support.p000v4.app.NotificationCompatKitKat.Builder builder2;
            Builder builder3 = builder;
            BuilderExtender builderExtender2 = builderExtender;
            android.support.p000v4.app.NotificationCompatKitKat.Builder builder4 = builder2;
            android.support.p000v4.app.NotificationCompatKitKat.Builder builder5 = new android.support.p000v4.app.NotificationCompatKitKat.Builder(builder3.mContext, builder3.mNotification, builder3.mContentTitle, builder3.mContentText, builder3.mContentInfo, builder3.mTickerView, builder3.mNumber, builder3.mContentIntent, builder3.mFullScreenIntent, builder3.mLargeIcon, builder3.mProgressMax, builder3.mProgress, builder3.mProgressIndeterminate, builder3.mShowWhen, builder3.mUseChronometer, builder3.mPriority, builder3.mSubText, builder3.mLocalOnly, builder3.mPeople, builder3.mExtras, builder3.mGroupKey, builder3.mGroupSummary, builder3.mSortKey);
            android.support.p000v4.app.NotificationCompatKitKat.Builder builder6 = builder4;
            NotificationCompat.addActionsToBuilder(builder6, builder3.mActions);
            NotificationCompat.addStyleToBuilderJellybean(builder6, builder3.mStyle);
            return builderExtender2.build(builder3, builder6);
        }

        public Action getAction(Notification notification, int i) {
            return (Action) NotificationCompatKitKat.getAction(notification, i, Action.FACTORY, RemoteInput.FACTORY);
        }

        public int getActionCount(Notification notification) {
            return NotificationCompatKitKat.getActionCount(notification);
        }

        public Bundle getExtras(Notification notification) {
            return NotificationCompatKitKat.getExtras(notification);
        }

        public String getGroup(Notification notification) {
            return NotificationCompatKitKat.getGroup(notification);
        }

        public boolean getLocalOnly(Notification notification) {
            return NotificationCompatKitKat.getLocalOnly(notification);
        }

        public String getSortKey(Notification notification) {
            return NotificationCompatKitKat.getSortKey(notification);
        }

        public boolean isGroupSummary(Notification notification) {
            return NotificationCompatKitKat.isGroupSummary(notification);
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$Style */
    public static abstract class Style {
        CharSequence mBigContentTitle;
        Builder mBuilder;
        CharSequence mSummaryText;
        boolean mSummaryTextSet = false;

        public Style() {
        }

        public Notification build() {
            Notification notification = null;
            if (this.mBuilder != null) {
                notification = this.mBuilder.build();
            }
            return notification;
        }

        public void setBuilder(Builder builder) {
            Builder builder2 = builder;
            if (this.mBuilder != builder2) {
                this.mBuilder = builder2;
                if (this.mBuilder != null) {
                    Builder style = this.mBuilder.setStyle(this);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.NotificationCompat$WearableExtender */
    public static final class WearableExtender implements Extender {
        private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
        private static final int DEFAULT_FLAGS = 1;
        private static final int DEFAULT_GRAVITY = 80;
        private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
        private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
        private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
        private static final int FLAG_HINT_HIDE_ICON = 2;
        private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
        private static final int FLAG_START_SCROLL_BOTTOM = 8;
        private static final String KEY_ACTIONS = "actions";
        private static final String KEY_BACKGROUND = "background";
        private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
        private static final String KEY_CONTENT_ICON = "contentIcon";
        private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
        private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
        private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
        private static final String KEY_DISPLAY_INTENT = "displayIntent";
        private static final String KEY_FLAGS = "flags";
        private static final String KEY_GRAVITY = "gravity";
        private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
        private static final String KEY_PAGES = "pages";
        public static final int SCREEN_TIMEOUT_LONG = -1;
        public static final int SCREEN_TIMEOUT_SHORT = 0;
        public static final int SIZE_DEFAULT = 0;
        public static final int SIZE_FULL_SCREEN = 5;
        public static final int SIZE_LARGE = 4;
        public static final int SIZE_MEDIUM = 3;
        public static final int SIZE_SMALL = 2;
        public static final int SIZE_XSMALL = 1;
        public static final int UNSET_ACTION_INDEX = -1;
        private ArrayList<Action> mActions;
        private Bitmap mBackground;
        private int mContentActionIndex;
        private int mContentIcon;
        private int mContentIconGravity;
        private int mCustomContentHeight;
        private int mCustomSizePreset;
        private PendingIntent mDisplayIntent;
        private int mFlags = 1;
        private int mGravity;
        private int mHintScreenTimeout;
        private ArrayList<Notification> mPages;

        public WearableExtender() {
            ArrayList<Action> arrayList;
            ArrayList<Notification> arrayList2;
            ArrayList<Action> arrayList3 = arrayList;
            ArrayList<Action> arrayList4 = new ArrayList<>();
            this.mActions = arrayList3;
            ArrayList<Notification> arrayList5 = arrayList2;
            ArrayList<Notification> arrayList6 = new ArrayList<>();
            this.mPages = arrayList5;
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
        }

        public WearableExtender(Notification notification) {
            ArrayList<Action> arrayList;
            ArrayList<Notification> arrayList2;
            Notification notification2 = notification;
            ArrayList<Action> arrayList3 = arrayList;
            ArrayList<Action> arrayList4 = new ArrayList<>();
            this.mActions = arrayList3;
            ArrayList<Notification> arrayList5 = arrayList2;
            ArrayList<Notification> arrayList6 = new ArrayList<>();
            this.mPages = arrayList5;
            this.mContentIconGravity = 8388613;
            this.mContentActionIndex = -1;
            this.mCustomSizePreset = 0;
            this.mGravity = 80;
            Bundle extras = NotificationCompat.getExtras(notification2);
            Bundle bundle = extras != null ? extras.getBundle(EXTRA_WEARABLE_EXTENSIONS) : null;
            if (bundle != null) {
                Action[] actionsFromParcelableArrayList = NotificationCompat.IMPL.getActionsFromParcelableArrayList(bundle.getParcelableArrayList(KEY_ACTIONS));
                if (actionsFromParcelableArrayList != null) {
                    boolean addAll = Collections.addAll(this.mActions, actionsFromParcelableArrayList);
                }
                this.mFlags = bundle.getInt(KEY_FLAGS, 1);
                this.mDisplayIntent = (PendingIntent) bundle.getParcelable(KEY_DISPLAY_INTENT);
                Notification[] access$500 = NotificationCompat.getNotificationArrayFromBundle(bundle, KEY_PAGES);
                if (access$500 != null) {
                    boolean addAll2 = Collections.addAll(this.mPages, access$500);
                }
                this.mBackground = (Bitmap) bundle.getParcelable(KEY_BACKGROUND);
                this.mContentIcon = bundle.getInt(KEY_CONTENT_ICON);
                this.mContentIconGravity = bundle.getInt(KEY_CONTENT_ICON_GRAVITY, 8388613);
                this.mContentActionIndex = bundle.getInt(KEY_CONTENT_ACTION_INDEX, -1);
                this.mCustomSizePreset = bundle.getInt(KEY_CUSTOM_SIZE_PRESET, 0);
                this.mCustomContentHeight = bundle.getInt(KEY_CUSTOM_CONTENT_HEIGHT);
                this.mGravity = bundle.getInt(KEY_GRAVITY, 80);
                this.mHintScreenTimeout = bundle.getInt(KEY_HINT_SCREEN_TIMEOUT);
            }
        }

        private void setFlag(int i, boolean z) {
            int i2 = i;
            if (z) {
                this.mFlags = i2 | this.mFlags;
                return;
            }
            this.mFlags &= i2 ^ -1;
        }

        public WearableExtender addAction(Action action) {
            boolean add = this.mActions.add(action);
            return this;
        }

        public WearableExtender addActions(List<Action> list) {
            boolean addAll = this.mActions.addAll(list);
            return this;
        }

        public WearableExtender addPage(Notification notification) {
            boolean add = this.mPages.add(notification);
            return this;
        }

        public WearableExtender addPages(List<Notification> list) {
            boolean addAll = this.mPages.addAll(list);
            return this;
        }

        public WearableExtender clearActions() {
            this.mActions.clear();
            return this;
        }

        public WearableExtender clearPages() {
            this.mPages.clear();
            return this;
        }

        public WearableExtender clone() {
            WearableExtender wearableExtender;
            ArrayList<Action> arrayList;
            ArrayList<Notification> arrayList2;
            WearableExtender wearableExtender2 = wearableExtender;
            WearableExtender wearableExtender3 = new WearableExtender();
            WearableExtender wearableExtender4 = wearableExtender2;
            WearableExtender wearableExtender5 = wearableExtender4;
            ArrayList<Action> arrayList3 = arrayList;
            ArrayList<Action> arrayList4 = new ArrayList<>(this.mActions);
            wearableExtender5.mActions = arrayList3;
            wearableExtender4.mFlags = this.mFlags;
            wearableExtender4.mDisplayIntent = this.mDisplayIntent;
            WearableExtender wearableExtender6 = wearableExtender4;
            ArrayList<Notification> arrayList5 = arrayList2;
            ArrayList<Notification> arrayList6 = new ArrayList<>(this.mPages);
            wearableExtender6.mPages = arrayList5;
            wearableExtender4.mBackground = this.mBackground;
            wearableExtender4.mContentIcon = this.mContentIcon;
            wearableExtender4.mContentIconGravity = this.mContentIconGravity;
            wearableExtender4.mContentActionIndex = this.mContentActionIndex;
            wearableExtender4.mCustomSizePreset = this.mCustomSizePreset;
            wearableExtender4.mCustomContentHeight = this.mCustomContentHeight;
            wearableExtender4.mGravity = this.mGravity;
            wearableExtender4.mHintScreenTimeout = this.mHintScreenTimeout;
            return wearableExtender4;
        }

        public Builder extend(Builder builder) {
            Bundle bundle;
            Builder builder2 = builder;
            Bundle bundle2 = bundle;
            Bundle bundle3 = new Bundle();
            Bundle bundle4 = bundle2;
            if (!this.mActions.isEmpty()) {
                bundle4.putParcelableArrayList(KEY_ACTIONS, NotificationCompat.IMPL.getParcelableArrayListForActions((Action[]) this.mActions.toArray(new Action[this.mActions.size()])));
            }
            if (this.mFlags != 1) {
                bundle4.putInt(KEY_FLAGS, this.mFlags);
            }
            if (this.mDisplayIntent != null) {
                bundle4.putParcelable(KEY_DISPLAY_INTENT, this.mDisplayIntent);
            }
            if (!this.mPages.isEmpty()) {
                bundle4.putParcelableArray(KEY_PAGES, (Parcelable[]) this.mPages.toArray(new Notification[this.mPages.size()]));
            }
            if (this.mBackground != null) {
                bundle4.putParcelable(KEY_BACKGROUND, this.mBackground);
            }
            if (this.mContentIcon != 0) {
                bundle4.putInt(KEY_CONTENT_ICON, this.mContentIcon);
            }
            if (this.mContentIconGravity != 8388613) {
                bundle4.putInt(KEY_CONTENT_ICON_GRAVITY, this.mContentIconGravity);
            }
            if (this.mContentActionIndex != -1) {
                bundle4.putInt(KEY_CONTENT_ACTION_INDEX, this.mContentActionIndex);
            }
            if (this.mCustomSizePreset != 0) {
                bundle4.putInt(KEY_CUSTOM_SIZE_PRESET, this.mCustomSizePreset);
            }
            if (this.mCustomContentHeight != 0) {
                bundle4.putInt(KEY_CUSTOM_CONTENT_HEIGHT, this.mCustomContentHeight);
            }
            if (this.mGravity != 80) {
                bundle4.putInt(KEY_GRAVITY, this.mGravity);
            }
            if (this.mHintScreenTimeout != 0) {
                bundle4.putInt(KEY_HINT_SCREEN_TIMEOUT, this.mHintScreenTimeout);
            }
            builder2.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle4);
            return builder2;
        }

        public List<Action> getActions() {
            return this.mActions;
        }

        public Bitmap getBackground() {
            return this.mBackground;
        }

        public int getContentAction() {
            return this.mContentActionIndex;
        }

        public int getContentIcon() {
            return this.mContentIcon;
        }

        public int getContentIconGravity() {
            return this.mContentIconGravity;
        }

        public boolean getContentIntentAvailableOffline() {
            return (1 & this.mFlags) != 0;
        }

        public int getCustomContentHeight() {
            return this.mCustomContentHeight;
        }

        public int getCustomSizePreset() {
            return this.mCustomSizePreset;
        }

        public PendingIntent getDisplayIntent() {
            return this.mDisplayIntent;
        }

        public int getGravity() {
            return this.mGravity;
        }

        public boolean getHintAvoidBackgroundClipping() {
            return (16 & this.mFlags) != 0;
        }

        public boolean getHintHideIcon() {
            return (2 & this.mFlags) != 0;
        }

        public int getHintScreenTimeout() {
            return this.mHintScreenTimeout;
        }

        public boolean getHintShowBackgroundOnly() {
            return (4 & this.mFlags) != 0;
        }

        public List<Notification> getPages() {
            return this.mPages;
        }

        public boolean getStartScrollBottom() {
            return (8 & this.mFlags) != 0;
        }

        public WearableExtender setBackground(Bitmap bitmap) {
            this.mBackground = bitmap;
            return this;
        }

        public WearableExtender setContentAction(int i) {
            this.mContentActionIndex = i;
            return this;
        }

        public WearableExtender setContentIcon(int i) {
            this.mContentIcon = i;
            return this;
        }

        public WearableExtender setContentIconGravity(int i) {
            this.mContentIconGravity = i;
            return this;
        }

        public WearableExtender setContentIntentAvailableOffline(boolean z) {
            setFlag(1, z);
            return this;
        }

        public WearableExtender setCustomContentHeight(int i) {
            this.mCustomContentHeight = i;
            return this;
        }

        public WearableExtender setCustomSizePreset(int i) {
            this.mCustomSizePreset = i;
            return this;
        }

        public WearableExtender setDisplayIntent(PendingIntent pendingIntent) {
            this.mDisplayIntent = pendingIntent;
            return this;
        }

        public WearableExtender setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        public WearableExtender setHintAvoidBackgroundClipping(boolean z) {
            setFlag(16, z);
            return this;
        }

        public WearableExtender setHintHideIcon(boolean z) {
            setFlag(2, z);
            return this;
        }

        public WearableExtender setHintScreenTimeout(int i) {
            this.mHintScreenTimeout = i;
            return this;
        }

        public WearableExtender setHintShowBackgroundOnly(boolean z) {
            setFlag(4, z);
            return this;
        }

        public WearableExtender setStartScrollBottom(boolean z) {
            setFlag(8, z);
            return this;
        }
    }

    static {
        NotificationCompatImplBase notificationCompatImplBase;
        NotificationCompatImplGingerbread notificationCompatImplGingerbread;
        NotificationCompatImplHoneycomb notificationCompatImplHoneycomb;
        NotificationCompatImplIceCreamSandwich notificationCompatImplIceCreamSandwich;
        NotificationCompatImplJellybean notificationCompatImplJellybean;
        NotificationCompatImplKitKat notificationCompatImplKitKat;
        NotificationCompatImplApi20 notificationCompatImplApi20;
        NotificationCompatImplApi21 notificationCompatImplApi21;
        if (VERSION.SDK_INT >= 21) {
            NotificationCompatImplApi21 notificationCompatImplApi212 = notificationCompatImplApi21;
            NotificationCompatImplApi21 notificationCompatImplApi213 = new NotificationCompatImplApi21();
            IMPL = notificationCompatImplApi212;
        } else if (VERSION.SDK_INT >= 20) {
            NotificationCompatImplApi20 notificationCompatImplApi202 = notificationCompatImplApi20;
            NotificationCompatImplApi20 notificationCompatImplApi203 = new NotificationCompatImplApi20();
            IMPL = notificationCompatImplApi202;
        } else if (VERSION.SDK_INT >= 19) {
            NotificationCompatImplKitKat notificationCompatImplKitKat2 = notificationCompatImplKitKat;
            NotificationCompatImplKitKat notificationCompatImplKitKat3 = new NotificationCompatImplKitKat();
            IMPL = notificationCompatImplKitKat2;
        } else if (VERSION.SDK_INT >= 16) {
            NotificationCompatImplJellybean notificationCompatImplJellybean2 = notificationCompatImplJellybean;
            NotificationCompatImplJellybean notificationCompatImplJellybean3 = new NotificationCompatImplJellybean();
            IMPL = notificationCompatImplJellybean2;
        } else if (VERSION.SDK_INT >= 14) {
            NotificationCompatImplIceCreamSandwich notificationCompatImplIceCreamSandwich2 = notificationCompatImplIceCreamSandwich;
            NotificationCompatImplIceCreamSandwich notificationCompatImplIceCreamSandwich3 = new NotificationCompatImplIceCreamSandwich();
            IMPL = notificationCompatImplIceCreamSandwich2;
        } else if (VERSION.SDK_INT >= 11) {
            NotificationCompatImplHoneycomb notificationCompatImplHoneycomb2 = notificationCompatImplHoneycomb;
            NotificationCompatImplHoneycomb notificationCompatImplHoneycomb3 = new NotificationCompatImplHoneycomb();
            IMPL = notificationCompatImplHoneycomb2;
        } else if (VERSION.SDK_INT >= 9) {
            NotificationCompatImplGingerbread notificationCompatImplGingerbread2 = notificationCompatImplGingerbread;
            NotificationCompatImplGingerbread notificationCompatImplGingerbread3 = new NotificationCompatImplGingerbread();
            IMPL = notificationCompatImplGingerbread2;
        } else {
            NotificationCompatImplBase notificationCompatImplBase2 = notificationCompatImplBase;
            NotificationCompatImplBase notificationCompatImplBase3 = new NotificationCompatImplBase();
            IMPL = notificationCompatImplBase2;
        }
    }

    public NotificationCompat() {
    }

    /* access modifiers changed from: private */
    public static void addActionsToBuilder(NotificationBuilderWithActions notificationBuilderWithActions, ArrayList<Action> arrayList) {
        NotificationBuilderWithActions notificationBuilderWithActions2 = notificationBuilderWithActions;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            notificationBuilderWithActions2.addAction((Action) it.next());
        }
    }

    /* access modifiers changed from: private */
    public static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Style style) {
        NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor;
        Style style2 = style;
        if (style2 == null) {
            return;
        }
        if (style2 instanceof BigTextStyle) {
            BigTextStyle bigTextStyle = (BigTextStyle) style2;
            NotificationCompatJellybean.addBigTextStyle(notificationBuilderWithBuilderAccessor2, bigTextStyle.mBigContentTitle, bigTextStyle.mSummaryTextSet, bigTextStyle.mSummaryText, bigTextStyle.mBigText);
        } else if (style2 instanceof InboxStyle) {
            InboxStyle inboxStyle = (InboxStyle) style2;
            NotificationCompatJellybean.addInboxStyle(notificationBuilderWithBuilderAccessor2, inboxStyle.mBigContentTitle, inboxStyle.mSummaryTextSet, inboxStyle.mSummaryText, inboxStyle.mTexts);
        } else if (style2 instanceof BigPictureStyle) {
            BigPictureStyle bigPictureStyle = (BigPictureStyle) style2;
            NotificationCompatJellybean.addBigPictureStyle(notificationBuilderWithBuilderAccessor2, bigPictureStyle.mBigContentTitle, bigPictureStyle.mSummaryTextSet, bigPictureStyle.mSummaryText, bigPictureStyle.mPicture, bigPictureStyle.mBigLargeIcon, bigPictureStyle.mBigLargeIconSet);
        }
    }

    public static Action getAction(Notification notification, int i) {
        return IMPL.getAction(notification, i);
    }

    public static int getActionCount(Notification notification) {
        return IMPL.getActionCount(notification);
    }

    public static String getCategory(Notification notification) {
        return IMPL.getCategory(notification);
    }

    public static Bundle getExtras(Notification notification) {
        return IMPL.getExtras(notification);
    }

    public static String getGroup(Notification notification) {
        return IMPL.getGroup(notification);
    }

    public static boolean getLocalOnly(Notification notification) {
        return IMPL.getLocalOnly(notification);
    }

    /* access modifiers changed from: private */
    public static Notification[] getNotificationArrayFromBundle(Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        String str2 = str;
        Parcelable[] parcelableArray = bundle2.getParcelableArray(str2);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i = 0; i < parcelableArray.length; i++) {
            notificationArr[i] = (Notification) parcelableArray[i];
        }
        bundle2.putParcelableArray(str2, notificationArr);
        return notificationArr;
    }

    public static String getSortKey(Notification notification) {
        return IMPL.getSortKey(notification);
    }

    public static boolean isGroupSummary(Notification notification) {
        return IMPL.isGroupSummary(notification);
    }
}

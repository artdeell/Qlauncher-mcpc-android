package android.support.p000v4.media.session;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Creator<PlaybackStateCompat> CREATOR;
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    /* access modifiers changed from: private */
    public final long mActions;
    /* access modifiers changed from: private */
    public final long mActiveItemId;
    /* access modifiers changed from: private */
    public final long mBufferedPosition;
    /* access modifiers changed from: private */
    public List<CustomAction> mCustomActions;
    /* access modifiers changed from: private */
    public final CharSequence mErrorMessage;
    /* access modifiers changed from: private */
    public final Bundle mExtras;
    /* access modifiers changed from: private */
    public final long mPosition;
    /* access modifiers changed from: private */
    public final float mSpeed;
    /* access modifiers changed from: private */
    public final int mState;
    private Object mStateObj;
    /* access modifiers changed from: private */
    public final long mUpdateTime;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Actions */
    public @interface Actions {
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$Builder */
    public static final class Builder {
        private long mActions;
        private long mActiveItemId = -1;
        private long mBufferedPosition;
        private final List<CustomAction> mCustomActions;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder() {
            ArrayList arrayList;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.mCustomActions = arrayList2;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList;
            PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.mCustomActions = arrayList2;
            this.mState = playbackStateCompat2.mState;
            this.mPosition = playbackStateCompat2.mPosition;
            this.mRate = playbackStateCompat2.mSpeed;
            this.mUpdateTime = playbackStateCompat2.mUpdateTime;
            this.mBufferedPosition = playbackStateCompat2.mBufferedPosition;
            this.mActions = playbackStateCompat2.mActions;
            this.mErrorMessage = playbackStateCompat2.mErrorMessage;
            if (playbackStateCompat2.mCustomActions != null) {
                boolean addAll = this.mCustomActions.addAll(playbackStateCompat2.mCustomActions);
            }
            this.mActiveItemId = playbackStateCompat2.mActiveItemId;
            this.mExtras = playbackStateCompat2.mExtras;
        }

        public Builder addCustomAction(CustomAction customAction) {
            IllegalArgumentException illegalArgumentException;
            CustomAction customAction2 = customAction;
            if (customAction2 == null) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
                throw illegalArgumentException2;
            }
            boolean add = this.mCustomActions.add(customAction2);
            return this;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            CustomAction customAction;
            CustomAction customAction2 = customAction;
            CustomAction customAction3 = new CustomAction(str, str2, i, null, null);
            return addCustomAction(customAction2);
        }

        public PlaybackStateCompat build() {
            PlaybackStateCompat playbackStateCompat;
            PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
            PlaybackStateCompat playbackStateCompat3 = new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras, null);
            return playbackStateCompat2;
        }

        public Builder setActions(long j) {
            this.mActions = j;
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.mActiveItemId = j;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.mBufferedPosition = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.mErrorMessage = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int i, long j, float f, long j2) {
            long j3 = j;
            float f2 = f;
            long j4 = j2;
            this.mState = i;
            this.mPosition = j3;
            this.mUpdateTime = j4;
            this.mRate = f2;
            return this;
        }
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR;
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$Builder */
        public static final class Builder {
            private final String mAction;
            private Bundle mExtras;
            private final int mIcon;
            private final CharSequence mName;

            public Builder(String str, CharSequence charSequence, int i) {
                IllegalArgumentException illegalArgumentException;
                IllegalArgumentException illegalArgumentException2;
                IllegalArgumentException illegalArgumentException3;
                String str2 = str;
                CharSequence charSequence2 = charSequence;
                int i2 = i;
                if (TextUtils.isEmpty(str2)) {
                    IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
                    IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("You must specify an action to build a CustomAction.");
                    throw illegalArgumentException4;
                } else if (TextUtils.isEmpty(charSequence2)) {
                    IllegalArgumentException illegalArgumentException6 = illegalArgumentException2;
                    IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("You must specify a name to build a CustomAction.");
                    throw illegalArgumentException6;
                } else if (i2 == 0) {
                    IllegalArgumentException illegalArgumentException8 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                    throw illegalArgumentException8;
                } else {
                    this.mAction = str2;
                    this.mName = charSequence2;
                    this.mIcon = i2;
                }
            }

            public CustomAction build() {
                CustomAction customAction;
                CustomAction customAction2 = customAction;
                CustomAction customAction3 = new CustomAction(this.mAction, this.mName, this.mIcon, this.mExtras, null);
                return customAction2;
            }

            public Builder setExtras(Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }
        }

        static {
            C00831 r2;
            C00831 r0 = r2;
            C00831 r1 = new Creator<CustomAction>() {
                public CustomAction createFromParcel(Parcel parcel) {
                    CustomAction customAction;
                    CustomAction customAction2 = customAction;
                    CustomAction customAction3 = new CustomAction(parcel, null);
                    return customAction2;
                }

                public CustomAction[] newArray(int i) {
                    return new CustomAction[i];
                }
            };
            CREATOR = r0;
        }

        private CustomAction(Parcel parcel) {
            Parcel parcel2 = parcel;
            this.mAction = parcel2.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
            this.mIcon = parcel2.readInt();
            this.mExtras = parcel2.readBundle();
        }

        /* synthetic */ CustomAction(Parcel parcel, C00821 r7) {
            C00821 r2 = r7;
            this(parcel);
        }

        private CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            CharSequence charSequence2 = charSequence;
            int i2 = i;
            Bundle bundle2 = bundle;
            this.mAction = str;
            this.mName = charSequence2;
            this.mIcon = i2;
            this.mExtras = bundle2;
        }

        /* synthetic */ CustomAction(String str, CharSequence charSequence, int i, Bundle bundle, C00821 r16) {
            C00821 r5 = r16;
            this(str, charSequence, i, bundle);
        }

        public static CustomAction fromCustomAction(Object obj) {
            CustomAction customAction;
            Object obj2 = obj;
            if (obj2 == null || VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction2 = customAction;
            CustomAction customAction3 = new CustomAction(CustomAction.getAction(obj2), CustomAction.getName(obj2), CustomAction.getIcon(obj2), CustomAction.getExtras(obj2));
            CustomAction customAction4 = customAction2;
            customAction4.mCustomActionObj = obj2;
            return customAction4;
        }

        public int describeContents() {
            return 0;
        }

        public String getAction() {
            return this.mAction;
        }

        public Object getCustomAction() {
            if (this.mCustomActionObj != null || VERSION.SDK_INT < 21) {
                return this.mCustomActionObj;
            }
            this.mCustomActionObj = CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
            return this.mCustomActionObj;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public CharSequence getName() {
            return this.mName;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("Action:mName='").append(this.mName).append(", mIcon=").append(this.mIcon).append(", mExtras=").append(this.mExtras).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            int i2 = i;
            parcel2.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, parcel2, i2);
            parcel2.writeInt(this.mIcon);
            parcel2.writeBundle(this.mExtras);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$State */
    public @interface State {
    }

    static {
        C00821 r2;
        C00821 r0 = r2;
        C00821 r1 = new Creator<PlaybackStateCompat>() {
            public PlaybackStateCompat createFromParcel(Parcel parcel) {
                PlaybackStateCompat playbackStateCompat;
                PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
                PlaybackStateCompat playbackStateCompat3 = new PlaybackStateCompat(parcel, null);
                return playbackStateCompat2;
            }

            public PlaybackStateCompat[] newArray(int i) {
                return new PlaybackStateCompat[i];
            }
        };
        CREATOR = r0;
    }

    private PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        ArrayList arrayList;
        long j6 = j;
        long j7 = j2;
        float f2 = f;
        long j8 = j3;
        CharSequence charSequence2 = charSequence;
        long j9 = j4;
        List<CustomAction> list2 = list;
        long j10 = j5;
        Bundle bundle2 = bundle;
        this.mState = i;
        this.mPosition = j6;
        this.mBufferedPosition = j7;
        this.mSpeed = f2;
        this.mActions = j8;
        this.mErrorMessage = charSequence2;
        this.mUpdateTime = j9;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(list2);
        this.mCustomActions = arrayList2;
        this.mActiveItemId = j10;
        this.mExtras = bundle2;
    }

    /* synthetic */ PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List list, long j5, Bundle bundle, C00821 r49) {
        C00821 r16 = r49;
        this(i, j, j2, f, j3, charSequence, j4, list, j5, bundle);
    }

    private PlaybackStateCompat(Parcel parcel) {
        Parcel parcel2 = parcel;
        this.mState = parcel2.readInt();
        this.mPosition = parcel2.readLong();
        this.mSpeed = parcel2.readFloat();
        this.mUpdateTime = parcel2.readLong();
        this.mBufferedPosition = parcel2.readLong();
        this.mActions = parcel2.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        this.mCustomActions = parcel2.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = parcel2.readLong();
        this.mExtras = parcel2.readBundle();
    }

    /* synthetic */ PlaybackStateCompat(Parcel parcel, C00821 r7) {
        C00821 r2 = r7;
        this(parcel);
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        PlaybackStateCompat playbackStateCompat;
        ArrayList arrayList;
        Object obj2 = obj;
        if (obj2 == null || VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> customActions = PlaybackStateCompatApi21.getCustomActions(obj2);
        ArrayList arrayList2 = null;
        if (customActions != null) {
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList(customActions.size());
            arrayList2 = arrayList3;
            for (Object fromCustomAction : customActions) {
                boolean add = arrayList2.add(CustomAction.fromCustomAction(fromCustomAction));
            }
        }
        PlaybackStateCompat playbackStateCompat2 = playbackStateCompat;
        PlaybackStateCompat playbackStateCompat3 = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(obj2), PlaybackStateCompatApi21.getPosition(obj2), PlaybackStateCompatApi21.getBufferedPosition(obj2), PlaybackStateCompatApi21.getPlaybackSpeed(obj2), PlaybackStateCompatApi21.getActions(obj2), PlaybackStateCompatApi21.getErrorMessage(obj2), PlaybackStateCompatApi21.getLastPositionUpdateTime(obj2), arrayList2, PlaybackStateCompatApi21.getActiveQueueItemId(obj2), VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.getExtras(obj2) : null);
        PlaybackStateCompat playbackStateCompat4 = playbackStateCompat2;
        playbackStateCompat4.mStateObj = obj2;
        return playbackStateCompat4;
    }

    public int describeContents() {
        return 0;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getActiveQueueItemId() {
        return this.mActiveItemId;
    }

    public long getBufferedPosition() {
        return this.mBufferedPosition;
    }

    public List<CustomAction> getCustomActions() {
        return this.mCustomActions;
    }

    public CharSequence getErrorMessage() {
        return this.mErrorMessage;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public Object getPlaybackState() {
        ArrayList arrayList;
        if (this.mStateObj != null || VERSION.SDK_INT < 21) {
            return this.mStateObj;
        }
        ArrayList arrayList2 = null;
        if (this.mCustomActions != null) {
            ArrayList arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList(this.mCustomActions.size());
            arrayList2 = arrayList3;
            for (CustomAction customAction : this.mCustomActions) {
                boolean add = arrayList2.add(customAction.getCustomAction());
            }
        }
        if (VERSION.SDK_INT >= 22) {
            this.mStateObj = PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList2, this.mActiveItemId, this.mExtras);
        } else {
            this.mStateObj = PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList2, this.mActiveItemId);
        }
        return this.mStateObj;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public int getState() {
        return this.mState;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder("PlaybackState {");
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("state=").append(this.mState);
        StringBuilder append2 = sb4.append(", position=").append(this.mPosition);
        StringBuilder append3 = sb4.append(", buffered position=").append(this.mBufferedPosition);
        StringBuilder append4 = sb4.append(", speed=").append(this.mSpeed);
        StringBuilder append5 = sb4.append(", updated=").append(this.mUpdateTime);
        StringBuilder append6 = sb4.append(", actions=").append(this.mActions);
        StringBuilder append7 = sb4.append(", error=").append(this.mErrorMessage);
        StringBuilder append8 = sb4.append(", custom actions=").append(this.mCustomActions);
        StringBuilder append9 = sb4.append(", active item id=").append(this.mActiveItemId);
        StringBuilder append10 = sb4.append("}");
        return sb4.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        parcel2.writeInt(this.mState);
        parcel2.writeLong(this.mPosition);
        parcel2.writeFloat(this.mSpeed);
        parcel2.writeLong(this.mUpdateTime);
        parcel2.writeLong(this.mBufferedPosition);
        parcel2.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, parcel2, i2);
        parcel2.writeTypedList(this.mCustomActions);
        parcel2.writeLong(this.mActiveItemId);
        parcel2.writeBundle(this.mExtras);
    }
}

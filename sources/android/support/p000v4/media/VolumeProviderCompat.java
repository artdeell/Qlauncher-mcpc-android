package android.support.p000v4.media;

import android.os.Build.VERSION;
import android.support.p000v4.media.VolumeProviderCompatApi21.Delegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: android.support.v4.media.VolumeProviderCompat */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    /* renamed from: android.support.v4.media.VolumeProviderCompat$Callback */
    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.VolumeProviderCompat$ControlType */
    public @interface ControlType {
    }

    public VolumeProviderCompat(int i, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        this.mControlType = i;
        this.mMaxVolume = i4;
        this.mCurrentVolume = i5;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public Object getVolumeProvider() {
        C00721 r8;
        if (this.mVolumeProviderObj != null || VERSION.SDK_INT < 21) {
            return this.mVolumeProviderObj;
        }
        int i = this.mControlType;
        int i2 = this.mMaxVolume;
        int i3 = this.mCurrentVolume;
        C00721 r5 = r8;
        C00721 r6 = new Delegate(this) {
            final /* synthetic */ VolumeProviderCompat this$0;

            {
                this.this$0 = r5;
            }

            public void onAdjustVolume(int i) {
                int i2 = i;
                this.this$0.onAdjustVolume(i2);
            }

            public void onSetVolumeTo(int i) {
                int i2 = i;
                this.this$0.onSetVolumeTo(i2);
            }
        };
        this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(i, i2, i3, r5);
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int i) {
    }

    public void onSetVolumeTo(int i) {
    }

    public void setCallback(Callback callback) {
        Callback callback2 = callback;
        this.mCallback = callback2;
    }

    public final void setCurrentVolume(int i) {
        int i2 = i;
        this.mCurrentVolume = i2;
        Object volumeProvider = getVolumeProvider();
        if (volumeProvider != null) {
            VolumeProviderCompatApi21.setCurrentVolume(volumeProvider, i2);
        }
        if (this.mCallback != null) {
            this.mCallback.onVolumeChanged(this);
        }
    }
}

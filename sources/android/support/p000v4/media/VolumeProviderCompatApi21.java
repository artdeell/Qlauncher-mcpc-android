package android.support.p000v4.media;

import android.media.VolumeProvider;

/* renamed from: android.support.v4.media.VolumeProviderCompatApi21 */
class VolumeProviderCompatApi21 {

    /* renamed from: android.support.v4.media.VolumeProviderCompatApi21$Delegate */
    public interface Delegate {
        void onAdjustVolume(int i);

        void onSetVolumeTo(int i);
    }

    VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i, int i2, int i3, Delegate delegate) {
        C00731 r10;
        C00731 r4 = r10;
        final Delegate delegate2 = delegate;
        C00731 r5 = new VolumeProvider(i, i2, i3) {
            {
                int i = r10;
                int i2 = r11;
                int i3 = r12;
            }

            public void onAdjustVolume(int i) {
                int i2 = i;
                delegate2.onAdjustVolume(i2);
            }

            public void onSetVolumeTo(int i) {
                int i2 = i;
                delegate2.onSetVolumeTo(i2);
            }
        };
        return r4;
    }

    public static void setCurrentVolume(Object obj, int i) {
        ((VolumeProvider) obj).setCurrentVolume(i);
    }
}

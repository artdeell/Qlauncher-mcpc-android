package android.support.p000v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.CustomAction.Builder;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompatApi21 */
class PlaybackStateCompatApi21 {

    /* renamed from: android.support.v4.media.session.PlaybackStateCompatApi21$CustomAction */
    static final class CustomAction {
        CustomAction() {
        }

        public static String getAction(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getAction();
        }

        public static Bundle getExtras(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getExtras();
        }

        public static int getIcon(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getIcon();
        }

        public static CharSequence getName(Object obj) {
            return ((android.media.session.PlaybackState.CustomAction) obj).getName();
        }

        public static Object newInstance(String str, CharSequence charSequence, int i, Bundle bundle) {
            Builder builder;
            Bundle bundle2 = bundle;
            Builder builder2 = builder;
            Builder builder3 = new Builder(str, charSequence, i);
            Builder builder4 = builder2;
            Builder extras = builder4.setExtras(bundle2);
            return builder4.build();
        }
    }

    PlaybackStateCompatApi21() {
    }

    public static long getActions(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static long getActiveQueueItemId(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    public static long getBufferedPosition(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static List<Object> getCustomActions(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    public static CharSequence getErrorMessage(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long getLastPositionUpdateTime(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static float getPlaybackSpeed(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long getPosition(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static int getState(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static Object newInstance(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        PlaybackState.Builder builder;
        int i2 = i;
        long j6 = j;
        long j7 = j2;
        float f2 = f;
        long j8 = j3;
        CharSequence charSequence2 = charSequence;
        long j9 = j4;
        List<Object> list2 = list;
        long j10 = j5;
        PlaybackState.Builder builder2 = builder;
        PlaybackState.Builder builder3 = new PlaybackState.Builder();
        PlaybackState.Builder builder4 = builder2;
        PlaybackState.Builder state = builder4.setState(i2, j6, f2, j9);
        PlaybackState.Builder bufferedPosition = builder4.setBufferedPosition(j7);
        PlaybackState.Builder actions = builder4.setActions(j8);
        PlaybackState.Builder errorMessage = builder4.setErrorMessage(charSequence2);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            PlaybackState.Builder addCustomAction = builder4.addCustomAction((android.media.session.PlaybackState.CustomAction) it.next());
        }
        PlaybackState.Builder activeQueueItemId = builder4.setActiveQueueItemId(j10);
        return builder4.build();
    }
}

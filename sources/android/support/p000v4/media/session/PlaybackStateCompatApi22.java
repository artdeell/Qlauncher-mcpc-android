package android.support.p000v4.media.session;

import android.media.session.PlaybackState;
import android.media.session.PlaybackState.Builder;
import android.media.session.PlaybackState.CustomAction;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.PlaybackStateCompatApi22 */
class PlaybackStateCompatApi22 {
    PlaybackStateCompatApi22() {
    }

    public static Bundle getExtras(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }

    public static Object newInstance(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5, Bundle bundle) {
        Builder builder;
        int i2 = i;
        long j6 = j;
        long j7 = j2;
        float f2 = f;
        long j8 = j3;
        CharSequence charSequence2 = charSequence;
        long j9 = j4;
        List<Object> list2 = list;
        long j10 = j5;
        Bundle bundle2 = bundle;
        Builder builder2 = builder;
        Builder builder3 = new Builder();
        Builder builder4 = builder2;
        Builder state = builder4.setState(i2, j6, f2, j9);
        Builder bufferedPosition = builder4.setBufferedPosition(j7);
        Builder actions = builder4.setActions(j8);
        Builder errorMessage = builder4.setErrorMessage(charSequence2);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Builder addCustomAction = builder4.addCustomAction((CustomAction) it.next());
        }
        Builder activeQueueItemId = builder4.setActiveQueueItemId(j10);
        Builder extras = builder4.setExtras(bundle2);
        return builder4.build();
    }
}

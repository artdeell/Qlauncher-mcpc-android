package android.support.p000v4.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaButtonReceiver */
public class MediaButtonReceiver extends BroadcastReceiver {
    public MediaButtonReceiver() {
    }

    public static KeyEvent handleIntent(MediaSessionCompat mediaSessionCompat, Intent intent) {
        MediaSessionCompat mediaSessionCompat2 = mediaSessionCompat;
        Intent intent2 = intent;
        if (mediaSessionCompat2 == null || intent2 == null || !"android.intent.action.MEDIA_BUTTON".equals(intent2.getAction()) || !intent2.hasExtra("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        KeyEvent keyEvent = (KeyEvent) intent2.getParcelableExtra("android.intent.extra.KEY_EVENT");
        boolean dispatchMediaButtonEvent = mediaSessionCompat2.getController().dispatchMediaButtonEvent(keyEvent);
        return keyEvent;
    }

    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        ComponentName componentName;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        Context context2 = context;
        Intent intent3 = intent;
        Intent intent4 = intent2;
        Intent intent5 = new Intent("android.intent.action.MEDIA_BUTTON");
        Intent intent6 = intent4;
        Intent intent7 = intent6.setPackage(context2.getPackageName());
        List queryIntentServices = context2.getPackageManager().queryIntentServices(intent6, 0);
        if (queryIntentServices.size() != 1) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Expected 1 Service that handles android.intent.action.MEDIA_BUTTON, found ").append(queryIntentServices.size()).toString());
            throw illegalStateException2;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        Intent intent8 = intent3;
        ComponentName componentName2 = componentName;
        ComponentName componentName3 = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        Intent component = intent8.setComponent(componentName2);
        ComponentName startService = context2.startService(intent3);
    }
}

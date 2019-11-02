package android.support.p000v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.ActivityCompat21.SharedElementCallback21;
import android.support.p000v4.content.ContextCompat;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.app.ActivityCompat */
public class ActivityCompat extends ContextCompat {

    /* renamed from: android.support.v4.app.ActivityCompat$OnRequestPermissionsResultCallback */
    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    /* renamed from: android.support.v4.app.ActivityCompat$SharedElementCallback21Impl */
    private static class SharedElementCallback21Impl extends SharedElementCallback21 {
        private SharedElementCallback mCallback;

        public SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.mCallback = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.mCallback.onCreateSnapshotView(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            List<String> list2 = list;
            Map<String, View> map2 = map;
            this.mCallback.onMapSharedElements(list2, map2);
        }

        public void onRejectSharedElements(List<View> list) {
            List<View> list2 = list;
            this.mCallback.onRejectSharedElements(list2);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            List<String> list4 = list;
            List<View> list5 = list2;
            List<View> list6 = list3;
            this.mCallback.onSharedElementEnd(list4, list5, list6);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            List<String> list4 = list;
            List<View> list5 = list2;
            List<View> list6 = list3;
            this.mCallback.onSharedElementStart(list4, list5, list6);
        }
    }

    public ActivityCompat() {
    }

    private static SharedElementCallback21 createCallback(SharedElementCallback sharedElementCallback) {
        SharedElementCallback21Impl sharedElementCallback21Impl;
        SharedElementCallback sharedElementCallback2 = sharedElementCallback;
        SharedElementCallback21Impl sharedElementCallback21Impl2 = null;
        if (sharedElementCallback2 != null) {
            SharedElementCallback21Impl sharedElementCallback21Impl3 = sharedElementCallback21Impl;
            SharedElementCallback21Impl sharedElementCallback21Impl4 = new SharedElementCallback21Impl(sharedElementCallback2);
            sharedElementCallback21Impl2 = sharedElementCallback21Impl3;
        }
        return sharedElementCallback21Impl2;
    }

    public static void finishAffinity(Activity activity) {
        Activity activity2 = activity;
        if (VERSION.SDK_INT >= 16) {
            ActivityCompatJB.finishAffinity(activity2);
        } else {
            activity2.finish();
        }
    }

    public static void finishAfterTransition(Activity activity) {
        Activity activity2 = activity;
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.finishAfterTransition(activity2);
        } else {
            activity2.finish();
        }
    }

    public static boolean invalidateOptionsMenu(Activity activity) {
        Activity activity2 = activity;
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        ActivityCompatHoneycomb.invalidateOptionsMenu(activity2);
        return true;
    }

    public static void postponeEnterTransition(Activity activity) {
        Activity activity2 = activity;
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.postponeEnterTransition(activity2);
        }
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, int i) {
        Handler handler;
        C00031 r9;
        Activity activity2 = activity;
        String[] strArr2 = strArr;
        int i2 = i;
        if (VERSION.SDK_INT >= 23) {
            ActivityCompatApi23.requestPermissions(activity2, strArr2, i2);
        } else if (activity2 instanceof OnRequestPermissionsResultCallback) {
            Handler handler2 = handler;
            Handler handler3 = new Handler(Looper.getMainLooper());
            C00031 r4 = r9;
            final String[] strArr3 = strArr2;
            final Activity activity3 = activity2;
            final int i3 = i2;
            C00031 r5 = new Runnable() {
                {
                    Activity activity = r8;
                    int i = r9;
                }

                public void run() {
                    int[] iArr = new int[strArr3.length];
                    PackageManager packageManager = activity3.getPackageManager();
                    String packageName = activity3.getPackageName();
                    int length = strArr3.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr3[i], packageName);
                    }
                    ((OnRequestPermissionsResultCallback) activity3).onRequestPermissionsResult(i3, strArr3, iArr);
                }
            };
            boolean post = handler2.post(r4);
        }
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        Activity activity2 = activity;
        SharedElementCallback sharedElementCallback2 = sharedElementCallback;
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.setEnterSharedElementCallback(activity2, createCallback(sharedElementCallback2));
        }
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        Activity activity2 = activity;
        SharedElementCallback sharedElementCallback2 = sharedElementCallback;
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.setExitSharedElementCallback(activity2, createCallback(sharedElementCallback2));
        }
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        Activity activity2 = activity;
        String str2 = str;
        if (VERSION.SDK_INT >= 23) {
            return ActivityCompatApi23.shouldShowRequestPermissionRationale(activity2, str2);
        }
        return false;
    }

    public static void startActivity(Activity activity, Intent intent, @Nullable Bundle bundle) {
        Activity activity2 = activity;
        Intent intent2 = intent;
        Bundle bundle2 = bundle;
        if (VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivity(activity2, intent2, bundle2);
        } else {
            activity2.startActivity(intent2);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, @Nullable Bundle bundle) {
        Activity activity2 = activity;
        Intent intent2 = intent;
        int i2 = i;
        Bundle bundle2 = bundle;
        if (VERSION.SDK_INT >= 16) {
            ActivityCompatJB.startActivityForResult(activity2, intent2, i2, bundle2);
        } else {
            activity2.startActivityForResult(intent2, i2);
        }
    }

    public static void startPostponedEnterTransition(Activity activity) {
        Activity activity2 = activity;
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.startPostponedEnterTransition(activity2);
        }
    }

    public Uri getReferrer(Activity activity) {
        Uri uri;
        Activity activity2 = activity;
        if (VERSION.SDK_INT >= 22) {
            uri = ActivityCompat22.getReferrer(activity2);
        } else {
            Intent intent = activity2.getIntent();
            uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
            if (uri == null) {
                String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                if (stringExtra != null) {
                    return Uri.parse(stringExtra);
                }
                return null;
            }
        }
        return uri;
    }
}

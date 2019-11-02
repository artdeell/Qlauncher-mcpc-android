package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

@TargetApi(14)
@zzhb
public class zzbe implements ActivityLifecycleCallbacks {
    private Activity mActivity;
    private Context mContext;
    private final Object zzpV;

    public zzbe(Application application, Activity activity) {
        Object obj;
        Application application2 = application;
        Activity activity2 = activity;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.zzpV = obj2;
        application2.registerActivityLifecycleCallbacks(this);
        setActivity(activity2);
        this.mContext = application2.getApplicationContext();
    }

    /* JADX INFO: finally extract failed */
    private void setActivity(Activity activity) {
        Activity activity2 = activity;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (!activity2.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.mActivity = activity2;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    @Nullable
    public Activity getActivity() {
        return this.mActivity;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        Activity activity2 = activity;
        Object obj = this.zzpV;
        synchronized (obj) {
            try {
                if (this.mActivity != null) {
                    if (this.mActivity.equals(activity2)) {
                        this.mActivity = null;
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Object obj2 = obj;
                throw th2;
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        setActivity(activity);
    }

    public void onActivityResumed(Activity activity) {
        setActivity(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}

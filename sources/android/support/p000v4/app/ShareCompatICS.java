package android.support.p000v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

/* renamed from: android.support.v4.app.ShareCompatICS */
class ShareCompatICS {
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    ShareCompatICS() {
    }

    public static void configureMenuItem(MenuItem menuItem, Activity activity, Intent intent) {
        ShareActionProvider shareActionProvider;
        StringBuilder sb;
        ShareActionProvider shareActionProvider2;
        MenuItem menuItem2 = menuItem;
        Activity activity2 = activity;
        Intent intent2 = intent;
        ActionProvider actionProvider = menuItem2.getActionProvider();
        if (!(actionProvider instanceof ShareActionProvider)) {
            ShareActionProvider shareActionProvider3 = shareActionProvider2;
            ShareActionProvider shareActionProvider4 = new ShareActionProvider(activity2);
            shareActionProvider = shareActionProvider3;
        } else {
            shareActionProvider = (ShareActionProvider) actionProvider;
        }
        ShareActionProvider shareActionProvider5 = shareActionProvider;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        shareActionProvider5.setShareHistoryFileName(sb2.append(HISTORY_FILENAME_PREFIX).append(activity2.getClass().getName()).toString());
        shareActionProvider.setShareIntent(intent2);
        MenuItem actionProvider2 = menuItem2.setActionProvider(shareActionProvider);
    }
}

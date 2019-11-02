package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.support.p000v4.content.IntentCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.ShareCompat */
public class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    /* access modifiers changed from: private */
    public static ShareCompatImpl IMPL;

    /* renamed from: android.support.v4.app.ShareCompat$IntentBuilder */
    public static class IntentBuilder {
        private Activity mActivity;
        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private CharSequence mChooserTitle;
        private Intent mIntent;
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;

        private IntentBuilder(Activity activity) {
            Intent intent;
            Activity activity2 = activity;
            this.mActivity = activity2;
            Intent intent2 = intent;
            Intent intent3 = new Intent();
            this.mIntent = intent2.setAction("android.intent.action.SEND");
            Intent putExtra = this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, activity2.getPackageName());
            Intent putExtra2 = this.mIntent.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, activity2.getComponentName());
            Intent addFlags = this.mIntent.addFlags(524288);
        }

        private void combineArrayExtra(String str, ArrayList<String> arrayList) {
            String str2 = str;
            ArrayList<String> arrayList2 = arrayList;
            String[] stringArrayExtra = this.mIntent.getStringArrayExtra(str2);
            int i = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(i + arrayList2.size())];
            Object[] array = arrayList2.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList2.size(), i);
            }
            Intent putExtra = this.mIntent.putExtra(str2, strArr);
        }

        private void combineArrayExtra(String str, String[] strArr) {
            String str2 = str;
            String[] strArr2 = strArr;
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str2);
            int i = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr3 = new String[(i + strArr2.length)];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr3, 0, i);
            }
            System.arraycopy(strArr2, 0, strArr3, i, strArr2.length);
            Intent putExtra = intent.putExtra(str2, strArr3);
        }

        public static IntentBuilder from(Activity activity) {
            IntentBuilder intentBuilder;
            IntentBuilder intentBuilder2 = intentBuilder;
            IntentBuilder intentBuilder3 = new IntentBuilder(activity);
            return intentBuilder2;
        }

        public IntentBuilder addEmailBcc(String str) {
            ArrayList<String> arrayList;
            String str2 = str;
            if (this.mBccAddresses == null) {
                ArrayList<String> arrayList2 = arrayList;
                ArrayList<String> arrayList3 = new ArrayList<>();
                this.mBccAddresses = arrayList2;
            }
            boolean add = this.mBccAddresses.add(str2);
            return this;
        }

        public IntentBuilder addEmailBcc(String[] strArr) {
            combineArrayExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder addEmailCc(String str) {
            ArrayList<String> arrayList;
            String str2 = str;
            if (this.mCcAddresses == null) {
                ArrayList<String> arrayList2 = arrayList;
                ArrayList<String> arrayList3 = new ArrayList<>();
                this.mCcAddresses = arrayList2;
            }
            boolean add = this.mCcAddresses.add(str2);
            return this;
        }

        public IntentBuilder addEmailCc(String[] strArr) {
            combineArrayExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder addEmailTo(String str) {
            ArrayList<String> arrayList;
            String str2 = str;
            if (this.mToAddresses == null) {
                ArrayList<String> arrayList2 = arrayList;
                ArrayList<String> arrayList3 = new ArrayList<>();
                this.mToAddresses = arrayList2;
            }
            boolean add = this.mToAddresses.add(str2);
            return this;
        }

        public IntentBuilder addEmailTo(String[] strArr) {
            combineArrayExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        public IntentBuilder addStream(Uri uri) {
            ArrayList<Uri> arrayList;
            Uri uri2 = uri;
            Uri uri3 = (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            if (uri3 == null) {
                return setStream(uri2);
            }
            if (this.mStreams == null) {
                ArrayList<Uri> arrayList2 = arrayList;
                ArrayList<Uri> arrayList3 = new ArrayList<>();
                this.mStreams = arrayList2;
            }
            if (uri3 != null) {
                this.mIntent.removeExtra("android.intent.extra.STREAM");
                boolean add = this.mStreams.add(uri3);
            }
            boolean add2 = this.mStreams.add(uri2);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        /* access modifiers changed from: 0000 */
        public Activity getActivity() {
            return this.mActivity;
        }

        public Intent getIntent() {
            boolean z = true;
            if (this.mToAddresses != null) {
                combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
                this.mToAddresses = null;
            }
            if (this.mCcAddresses != null) {
                combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
                this.mCcAddresses = null;
            }
            if (this.mBccAddresses != null) {
                combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
                this.mBccAddresses = null;
            }
            if (this.mStreams == null || this.mStreams.size() <= 1) {
                z = false;
            }
            boolean equals = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
            if (!z && equals) {
                Intent action = this.mIntent.setAction("android.intent.action.SEND");
                if (this.mStreams == null || this.mStreams.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    Intent putExtra = this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable) this.mStreams.get(0));
                }
                this.mStreams = null;
            }
            if (z && !equals) {
                Intent action2 = this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.mStreams == null || this.mStreams.isEmpty()) {
                    this.mIntent.removeExtra("android.intent.extra.STREAM");
                } else {
                    Intent putParcelableArrayListExtra = this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
                }
            }
            return this.mIntent;
        }

        public IntentBuilder setChooserTitle(@StringRes int i) {
            return setChooserTitle(this.mActivity.getText(i));
        }

        public IntentBuilder setChooserTitle(CharSequence charSequence) {
            this.mChooserTitle = charSequence;
            return this;
        }

        public IntentBuilder setEmailBcc(String[] strArr) {
            Intent putExtra = this.mIntent.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        public IntentBuilder setEmailCc(String[] strArr) {
            Intent putExtra = this.mIntent.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        public IntentBuilder setEmailTo(String[] strArr) {
            String[] strArr2 = strArr;
            if (this.mToAddresses != null) {
                this.mToAddresses = null;
            }
            Intent putExtra = this.mIntent.putExtra("android.intent.extra.EMAIL", strArr2);
            return this;
        }

        public IntentBuilder setHtmlText(String str) {
            String str2 = str;
            Intent putExtra = this.mIntent.putExtra(IntentCompat.EXTRA_HTML_TEXT, str2);
            if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                IntentBuilder text = setText(Html.fromHtml(str2));
            }
            return this;
        }

        public IntentBuilder setStream(Uri uri) {
            Uri uri2 = uri;
            if (!this.mIntent.getAction().equals("android.intent.action.SEND")) {
                Intent action = this.mIntent.setAction("android.intent.action.SEND");
            }
            this.mStreams = null;
            Intent putExtra = this.mIntent.putExtra("android.intent.extra.STREAM", uri2);
            return this;
        }

        public IntentBuilder setSubject(String str) {
            Intent putExtra = this.mIntent.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        public IntentBuilder setText(CharSequence charSequence) {
            Intent putExtra = this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public IntentBuilder setType(String str) {
            Intent type = this.mIntent.setType(str);
            return this;
        }

        public void startChooser() {
            this.mActivity.startActivity(createChooserIntent());
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$IntentReader */
    public static class IntentReader {
        private static final String TAG = "IntentReader";
        private Activity mActivity;
        private ComponentName mCallingActivity;
        private String mCallingPackage;
        private Intent mIntent;
        private ArrayList<Uri> mStreams;

        private IntentReader(Activity activity) {
            Activity activity2 = activity;
            this.mActivity = activity2;
            this.mIntent = activity2.getIntent();
            this.mCallingPackage = ShareCompat.getCallingPackage(activity2);
            this.mCallingActivity = ShareCompat.getCallingActivity(activity2);
        }

        public static IntentReader from(Activity activity) {
            IntentReader intentReader;
            IntentReader intentReader2 = intentReader;
            IntentReader intentReader3 = new IntentReader(activity);
            return intentReader2;
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity == null) {
                return null;
            }
            try {
                return this.mActivity.getPackageManager().getActivityIcon(this.mCallingActivity);
            } catch (NameNotFoundException e) {
                int e2 = Log.e(TAG, "Could not retrieve icon for calling activity", e);
                return null;
            }
        }

        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage == null) {
                return null;
            }
            try {
                return this.mActivity.getPackageManager().getApplicationIcon(this.mCallingPackage);
            } catch (NameNotFoundException e) {
                int e2 = Log.e(TAG, "Could not retrieve icon for calling application", e);
                return null;
            }
        }

        public CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage == null) {
                return null;
            }
            PackageManager packageManager = this.mActivity.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
            } catch (NameNotFoundException e) {
                int e2 = Log.e(TAG, "Could not retrieve label for calling application", e);
                return null;
            }
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String stringExtra = this.mIntent.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra == null) {
                CharSequence text = getText();
                if (text instanceof Spanned) {
                    stringExtra = Html.toHtml((Spanned) text);
                } else if (text != null) {
                    return ShareCompat.IMPL.escapeHtml(text);
                }
            }
            return stringExtra;
        }

        public Uri getStream() {
            return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int i) {
            IndexOutOfBoundsException indexOutOfBoundsException;
            StringBuilder sb;
            int i2 = i;
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (this.mStreams != null) {
                return (Uri) this.mStreams.get(i2);
            }
            if (i2 == 0) {
                return (Uri) this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
            }
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(sb2.append("Stream items available: ").append(getStreamCount()).append(" index requested: ").append(i2).toString());
            throw indexOutOfBoundsException2;
        }

        public int getStreamCount() {
            if (this.mStreams == null && isMultipleShare()) {
                this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            return this.mStreams != null ? this.mStreams.size() : this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            String action = this.mIntent.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImpl */
    interface ShareCompatImpl {
        void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder);

        String escapeHtml(CharSequence charSequence);
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImplBase */
    static class ShareCompatImplBase implements ShareCompatImpl {
        ShareCompatImplBase() {
        }

        private static void withinStyle(StringBuilder sb, CharSequence charSequence, int i, int i2) {
            StringBuilder sb2;
            StringBuilder sb3 = sb;
            CharSequence charSequence2 = charSequence;
            int i3 = i2;
            int i4 = i;
            while (i4 < i3) {
                char charAt = charSequence2.charAt(i4);
                if (charAt == '<') {
                    StringBuilder append = sb3.append("&lt;");
                } else if (charAt == '>') {
                    StringBuilder append2 = sb3.append("&gt;");
                } else if (charAt == '&') {
                    StringBuilder append3 = sb3.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    StringBuilder sb4 = sb3;
                    StringBuilder sb5 = sb2;
                    StringBuilder sb6 = new StringBuilder();
                    StringBuilder append4 = sb4.append(sb5.append("&#").append(charAt).append(";").toString());
                } else if (charAt == ' ') {
                    while (i4 + 1 < i3 && charSequence2.charAt(i4 + 1) == ' ') {
                        StringBuilder append5 = sb3.append("&nbsp;");
                        i4++;
                    }
                    StringBuilder append6 = sb3.append(' ');
                } else {
                    StringBuilder append7 = sb3.append(charAt);
                }
                i4++;
            }
        }

        public void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
            MenuItem intent = menuItem.setIntent(intentBuilder.createChooserIntent());
        }

        public String escapeHtml(CharSequence charSequence) {
            StringBuilder sb;
            CharSequence charSequence2 = charSequence;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = sb2;
            withinStyle(sb4, charSequence2, 0, charSequence2.length());
            return sb4.toString();
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImplICS */
    static class ShareCompatImplICS extends ShareCompatImplBase {
        ShareCompatImplICS() {
        }

        public void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
            MenuItem menuItem2 = menuItem;
            IntentBuilder intentBuilder2 = intentBuilder;
            ShareCompatICS.configureMenuItem(menuItem2, intentBuilder2.getActivity(), intentBuilder2.getIntent());
            if (shouldAddChooserIntent(menuItem2)) {
                MenuItem intent = menuItem2.setIntent(intentBuilder2.createChooserIntent());
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldAddChooserIntent(MenuItem menuItem) {
            return !menuItem.hasSubMenu();
        }
    }

    /* renamed from: android.support.v4.app.ShareCompat$ShareCompatImplJB */
    static class ShareCompatImplJB extends ShareCompatImplICS {
        ShareCompatImplJB() {
        }

        public String escapeHtml(CharSequence charSequence) {
            return ShareCompatJB.escapeHtml(charSequence);
        }

        /* access modifiers changed from: 0000 */
        public boolean shouldAddChooserIntent(MenuItem menuItem) {
            MenuItem menuItem2 = menuItem;
            return false;
        }
    }

    static {
        ShareCompatImplBase shareCompatImplBase;
        ShareCompatImplICS shareCompatImplICS;
        ShareCompatImplJB shareCompatImplJB;
        if (VERSION.SDK_INT >= 16) {
            ShareCompatImplJB shareCompatImplJB2 = shareCompatImplJB;
            ShareCompatImplJB shareCompatImplJB3 = new ShareCompatImplJB();
            IMPL = shareCompatImplJB2;
        } else if (VERSION.SDK_INT >= 14) {
            ShareCompatImplICS shareCompatImplICS2 = shareCompatImplICS;
            ShareCompatImplICS shareCompatImplICS3 = new ShareCompatImplICS();
            IMPL = shareCompatImplICS2;
        } else {
            ShareCompatImplBase shareCompatImplBase2 = shareCompatImplBase;
            ShareCompatImplBase shareCompatImplBase3 = new ShareCompatImplBase();
            IMPL = shareCompatImplBase2;
        }
    }

    public ShareCompat() {
    }

    public static void configureMenuItem(Menu menu, int i, IntentBuilder intentBuilder) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        IntentBuilder intentBuilder2 = intentBuilder;
        MenuItem findItem = menu.findItem(i2);
        if (findItem == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Could not find menu item with id ").append(i2).append(" in the supplied menu").toString());
            throw illegalArgumentException2;
        }
        configureMenuItem(findItem, intentBuilder2);
    }

    public static void configureMenuItem(MenuItem menuItem, IntentBuilder intentBuilder) {
        IMPL.configureMenuItem(menuItem, intentBuilder);
    }

    public static ComponentName getCallingActivity(Activity activity) {
        Activity activity2 = activity;
        ComponentName callingActivity = activity2.getCallingActivity();
        if (callingActivity == null) {
            callingActivity = (ComponentName) activity2.getIntent().getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        }
        return callingActivity;
    }

    public static String getCallingPackage(Activity activity) {
        Activity activity2 = activity;
        String callingPackage = activity2.getCallingPackage();
        if (callingPackage == null) {
            callingPackage = activity2.getIntent().getStringExtra(EXTRA_CALLING_PACKAGE);
        }
        return callingPackage;
    }
}

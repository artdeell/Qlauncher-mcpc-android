package android.support.p000v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.p000v4.app.ActivityCompatApi23.RequestPermissionsRequestCodeValidator;
import android.support.p000v4.media.session.MediaControllerCompat;
import android.support.p000v4.util.SimpleArrayMap;
import android.support.p000v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.LWJGLUtil;
import org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: android.support.v4.app.FragmentActivity */
public class FragmentActivity extends BaseFragmentActivityHoneycomb implements OnRequestPermissionsResultCallback, RequestPermissionsRequestCodeValidator {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final FragmentController mFragments;
    final Handler mHandler;
    MediaControllerCompat mMediaController;
    boolean mOptionsMenuInvalidated;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;

    /* renamed from: android.support.v4.app.FragmentActivity$HostCallbacks */
    class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
        final /* synthetic */ FragmentActivity this$0;

        public HostCallbacks(FragmentActivity fragmentActivity) {
            FragmentActivity fragmentActivity2 = fragmentActivity;
            this.this$0 = fragmentActivity2;
            super(fragmentActivity2);
        }

        public void onAttachFragment(Fragment fragment) {
            Fragment fragment2 = fragment;
            this.this$0.onAttachFragment(fragment2);
        }

        public void onDump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            String str2 = str;
            FileDescriptor fileDescriptor2 = fileDescriptor;
            PrintWriter printWriter2 = printWriter;
            String[] strArr2 = strArr;
            this.this$0.dump(str2, fileDescriptor2, printWriter2, strArr2);
        }

        @Nullable
        public View onFindViewById(int i) {
            return this.this$0.findViewById(i);
        }

        public FragmentActivity onGetHost() {
            return this.this$0;
        }

        public LayoutInflater onGetLayoutInflater() {
            return this.this$0.getLayoutInflater().cloneInContext(this.this$0);
        }

        public int onGetWindowAnimations() {
            Window window = this.this$0.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public boolean onHasView() {
            Window window = this.this$0.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean onHasWindowAnimations() {
            return this.this$0.getWindow() != null;
        }

        public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i) {
            Fragment fragment2 = fragment;
            String[] strArr2 = strArr;
            int i2 = i;
            this.this$0.requestPermissionsFromFragment(fragment2, strArr2, i2);
        }

        public boolean onShouldSaveFragmentState(Fragment fragment) {
            Fragment fragment2 = fragment;
            return !this.this$0.isFinishing();
        }

        public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
            return ActivityCompat.shouldShowRequestPermissionRationale(this.this$0, str);
        }

        public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i) {
            Fragment fragment2 = fragment;
            Intent intent2 = intent;
            int i2 = i;
            this.this$0.startActivityFromFragment(fragment2, intent2, i2);
        }

        public void onSupportInvalidateOptionsMenu() {
            this.this$0.supportInvalidateOptionsMenu();
        }
    }

    /* renamed from: android.support.v4.app.FragmentActivity$NonConfigurationInstances */
    static final class NonConfigurationInstances {
        Object custom;
        List<Fragment> fragments;
        SimpleArrayMap<String, LoaderManager> loaders;

        NonConfigurationInstances() {
        }
    }

    public FragmentActivity() {
        C00121 r5;
        HostCallbacks hostCallbacks;
        C00121 r2 = r5;
        C00121 r3 = new Handler(this) {
            final /* synthetic */ FragmentActivity this$0;

            {
                this.this$0 = r5;
            }

            public void handleMessage(Message message) {
                Message message2 = message;
                switch (message2.what) {
                    case 1:
                        if (this.this$0.mStopped) {
                            this.this$0.doReallyStop(false);
                            return;
                        }
                        return;
                    case 2:
                        this.this$0.onResumeFragments();
                        boolean execPendingActions = this.this$0.mFragments.execPendingActions();
                        return;
                    default:
                        super.handleMessage(message2);
                        return;
                }
            }
        };
        this.mHandler = r2;
        HostCallbacks hostCallbacks2 = hostCallbacks;
        HostCallbacks hostCallbacks3 = new HostCallbacks(this);
        this.mFragments = FragmentController.createController(hostCallbacks2);
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        StringBuilder sb;
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        View view2 = view;
        printWriter2.print(str2);
        if (view2 == null) {
            printWriter2.println("null");
            return;
        }
        printWriter2.println(viewToString(view2));
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                String sb4 = sb2.append(str2).append("  ").toString();
                for (int i = 0; i < childCount; i++) {
                    dumpViewHierarchy(sb4, printWriter2, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        IllegalArgumentException illegalArgumentException;
        Fragment fragment2 = fragment;
        String[] strArr2 = strArr;
        int i2 = i;
        if (i2 == -1) {
            ActivityCompat.requestPermissions(this, strArr2, i2);
        } else if ((i2 & InputDeviceCompat.SOURCE_ANY) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Can only use lower 8 bits for requestCode");
            throw illegalArgumentException2;
        } else {
            this.mRequestedPermissionsFromFragment = true;
            ActivityCompat.requestPermissions(this, strArr2, ((1 + fragment2.mIndex) << 8) + (i2 & 255));
        }
    }

    private static String viewToString(View view) {
        StringBuilder sb;
        String str;
        View view2 = view;
        char c = 'F';
        char c2 = '.';
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(128);
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(view2.getClass().getName());
        StringBuilder append2 = sb4.append('{');
        StringBuilder append3 = sb4.append(Integer.toHexString(System.identityHashCode(view2)));
        StringBuilder append4 = sb4.append(' ');
        switch (view2.getVisibility()) {
            case 0:
                StringBuilder append5 = sb4.append('V');
                break;
            case 4:
                StringBuilder append6 = sb4.append('I');
                break;
            case 8:
                StringBuilder append7 = sb4.append('G');
                break;
            default:
                StringBuilder append8 = sb4.append('.');
                break;
        }
        StringBuilder append9 = sb4.append(view2.isFocusable() ? 'F' : '.');
        StringBuilder append10 = sb4.append(view2.isEnabled() ? 'E' : '.');
        StringBuilder append11 = sb4.append(view2.willNotDraw() ? '.' : 'D');
        StringBuilder append12 = sb4.append(view2.isHorizontalScrollBarEnabled() ? 'H' : '.');
        StringBuilder append13 = sb4.append(view2.isVerticalScrollBarEnabled() ? 'V' : '.');
        StringBuilder append14 = sb4.append(view2.isClickable() ? 'C' : '.');
        StringBuilder append15 = sb4.append(view2.isLongClickable() ? 'L' : '.');
        StringBuilder append16 = sb4.append(' ');
        if (!view2.isFocused()) {
            c = '.';
        }
        StringBuilder append17 = sb4.append(c);
        StringBuilder append18 = sb4.append(view2.isSelected() ? 'S' : '.');
        if (view2.isPressed()) {
            c2 = 'P';
        }
        StringBuilder append19 = sb4.append(c2);
        StringBuilder append20 = sb4.append(' ');
        StringBuilder append21 = sb4.append(view2.getLeft());
        StringBuilder append22 = sb4.append(',');
        StringBuilder append23 = sb4.append(view2.getTop());
        StringBuilder append24 = sb4.append(SignatureVisitor.SUPER);
        StringBuilder append25 = sb4.append(view2.getRight());
        StringBuilder append26 = sb4.append(',');
        StringBuilder append27 = sb4.append(view2.getBottom());
        int id = view2.getId();
        if (id != -1) {
            StringBuilder append28 = sb4.append(" #");
            StringBuilder append29 = sb4.append(Integer.toHexString(id));
            Resources resources = view2.getResources();
            if (!(id == 0 || resources == null)) {
                switch (-16777216 & id) {
                    case 16777216:
                        str = LWJGLUtil.PLATFORM_ANDROID_NAME;
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            NotFoundException notFoundException = e;
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                StringBuilder append30 = sb4.append(" ");
                StringBuilder append31 = sb4.append(str);
                StringBuilder append32 = sb4.append(":");
                StringBuilder append33 = sb4.append(resourceTypeName);
                StringBuilder append34 = sb4.append("/");
                StringBuilder append35 = sb4.append(resourceEntryName);
            }
        }
        StringBuilder append36 = sb4.append("}");
        return sb4.toString();
    }

    /* access modifiers changed from: 0000 */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.onCreateView(view, str, context, attributeSet);
    }

    /* access modifiers changed from: 0000 */
    public void doReallyStop(boolean z) {
        boolean z2 = z;
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z2;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        if (VERSION.SDK_INT >= 11) {
        }
        printWriter2.print(str2);
        printWriter2.print("Local FragmentActivity ");
        printWriter2.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter2.println(" State:");
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        String sb5 = sb3.append(str2).append("  ").toString();
        printWriter2.print(sb5);
        printWriter2.print("mCreated=");
        printWriter2.print(this.mCreated);
        printWriter2.print("mResumed=");
        printWriter2.print(this.mResumed);
        printWriter2.print(" mStopped=");
        printWriter2.print(this.mStopped);
        printWriter2.print(" mReallyStopped=");
        printWriter2.println(this.mReallyStopped);
        this.mFragments.dumpLoaders(sb5, fileDescriptor2, printWriter2, strArr2);
        this.mFragments.getSupportFragmentManager().dump(str2, fileDescriptor2, printWriter2, strArr2);
        printWriter2.print(str2);
        printWriter2.println("View Hierarchy:");
        StringBuilder sb6 = sb2;
        StringBuilder sb7 = new StringBuilder();
        dumpViewHierarchy(sb6.append(str2).append("  ").toString(), printWriter2, getWindow().getDecorView());
    }

    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.getSupportFragmentManager();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.mFragments.getSupportLoaderManager();
    }

    public final MediaControllerCompat getSupportMediaController() {
        return this.mMediaController;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        StringBuilder sb;
        ArrayList arrayList;
        StringBuilder sb2;
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        this.mFragments.noteStateNotSaved();
        int i5 = i3 >> 16;
        if (i5 != 0) {
            int i6 = i5 - 1;
            int activeFragmentsCount = this.mFragments.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i6 < 0 || i6 >= activeFragmentsCount) {
                String str = TAG;
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                int w = Log.w(str, sb3.append("Activity result fragment index out of range: 0x").append(Integer.toHexString(i3)).toString());
                return;
            }
            FragmentController fragmentController = this.mFragments;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(activeFragmentsCount);
            Fragment fragment = (Fragment) fragmentController.getActiveFragments(arrayList2).get(i6);
            if (fragment == null) {
                String str2 = TAG;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                int w2 = Log.w(str2, sb5.append("Activity result no fragment exists for index: 0x").append(Integer.toHexString(i3)).toString());
                return;
            }
            fragment.onActivityResult(65535 & i3, i4, intent2);
            return;
        }
        super.onActivityResult(i3, i4, intent2);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public void onBackPressed() {
        if (!this.mFragments.getSupportFragmentManager().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = configuration;
        super.onConfigurationChanged(configuration2);
        this.mFragments.dispatchConfigurationChanged(configuration2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2 = bundle;
        this.mFragments.attachHost(null);
        super.onCreate(bundle2);
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            this.mFragments.restoreLoaderNonConfig(nonConfigurationInstances.loaders);
        }
        if (bundle2 != null) {
            Parcelable parcelable = bundle2.getParcelable(FRAGMENTS_TAG);
            FragmentController fragmentController = this.mFragments;
            List list = null;
            if (nonConfigurationInstances != null) {
                list = nonConfigurationInstances.fragments;
            }
            fragmentController.restoreAllState(parcelable, list);
        }
        this.mFragments.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        int i2 = i;
        Menu menu2 = menu;
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu2);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i2, menu2) | this.mFragments.dispatchCreateOptionsMenu(menu2, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.dispatchDestroy();
        this.mFragments.doLoaderDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        if (VERSION.SDK_INT >= 5 || i2 != 4 || keyEvent2.getRepeatCount() != 0) {
            return super.onKeyDown(i2, keyEvent2);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        int i2 = i;
        MenuItem menuItem2 = menuItem;
        if (super.onMenuItemSelected(i2, menuItem2)) {
            return true;
        }
        switch (i2) {
            case 0:
                return this.mFragments.dispatchOptionsItemSelected(menuItem2);
            case 6:
                return this.mFragments.dispatchContextItemSelected(menuItem2);
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    public void onPanelClosed(int i, Menu menu) {
        int i2 = i;
        Menu menu2 = menu;
        switch (i2) {
            case 0:
                this.mFragments.dispatchOptionsMenuClosed(menu2);
                break;
        }
        super.onPanelClosed(i2, menu2);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.dispatchPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        boolean execPendingActions = this.mFragments.execPendingActions();
    }

    /* access modifiers changed from: protected */
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        int i2 = i;
        View view2 = view;
        Menu menu2 = menu;
        if (i2 != 0 || menu2 == null) {
            return super.onPreparePanel(i2, view2, menu2);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu2.clear();
            boolean onCreatePanelMenu = onCreatePanelMenu(i2, menu2);
        }
        return onPrepareOptionsPanel(view2, menu2) | this.mFragments.dispatchPrepareOptionsMenu(menu2);
    }

    /* access modifiers changed from: 0000 */
    public void onReallyStop() {
        this.mFragments.doLoaderStop(this.mRetaining);
        this.mFragments.dispatchReallyStop();
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        StringBuilder sb;
        ArrayList arrayList;
        StringBuilder sb2;
        int i2 = i;
        String[] strArr2 = strArr;
        int[] iArr2 = iArr;
        int i3 = 255 & (i2 >> 8);
        if (i3 != 0) {
            int i4 = i3 - 1;
            int activeFragmentsCount = this.mFragments.getActiveFragmentsCount();
            if (activeFragmentsCount == 0 || i4 < 0 || i4 >= activeFragmentsCount) {
                String str = TAG;
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                int w = Log.w(str, sb3.append("Activity result fragment index out of range: 0x").append(Integer.toHexString(i2)).toString());
                return;
            }
            FragmentController fragmentController = this.mFragments;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(activeFragmentsCount);
            Fragment fragment = (Fragment) fragmentController.getActiveFragments(arrayList2).get(i4);
            if (fragment == null) {
                String str2 = TAG;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                int w2 = Log.w(str2, sb5.append("Activity result no fragment exists for index: 0x").append(Integer.toHexString(i2)).toString());
                return;
            }
            fragment.onRequestPermissionsResult(i2 & 255, strArr2, iArr2);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        boolean sendEmptyMessage = this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        boolean execPendingActions = this.mFragments.execPendingActions();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragments.dispatchResume();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        List retainNonConfig = this.mFragments.retainNonConfig();
        SimpleArrayMap retainLoaderNonConfig = this.mFragments.retainLoaderNonConfig();
        if (retainNonConfig == null && retainLoaderNonConfig == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = nonConfigurationInstances;
        NonConfigurationInstances nonConfigurationInstances3 = new NonConfigurationInstances();
        NonConfigurationInstances nonConfigurationInstances4 = nonConfigurationInstances2;
        nonConfigurationInstances4.custom = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances4.fragments = retainNonConfig;
        nonConfigurationInstances4.loaders = retainLoaderNonConfig;
        return nonConfigurationInstances4;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle;
        super.onSaveInstanceState(bundle2);
        Parcelable saveAllState = this.mFragments.saveAllState();
        if (saveAllState != null) {
            bundle2.putParcelable(FRAGMENTS_TAG, saveAllState);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        boolean execPendingActions = this.mFragments.execPendingActions();
        this.mFragments.doLoaderStart();
        this.mFragments.dispatchStart();
        this.mFragments.reportLoaderStart();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        boolean sendEmptyMessage = this.mHandler.sendEmptyMessage(1);
        this.mFragments.dispatchStop();
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setEnterSharedElementCallback(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.setExitSharedElementCallback(this, sharedElementCallback);
    }

    public final void setSupportMediaController(MediaControllerCompat mediaControllerCompat) {
        MediaControllerCompat mediaControllerCompat2 = mediaControllerCompat;
        this.mMediaController = mediaControllerCompat2;
        if (VERSION.SDK_INT >= 21) {
            ActivityCompat21.setMediaController(this, mediaControllerCompat2.getMediaController());
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        IllegalArgumentException illegalArgumentException;
        Intent intent2 = intent;
        int i2 = i;
        if (i2 == -1 || (-65536 & i2) == 0) {
            super.startActivityForResult(intent2, i2);
            return;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        throw illegalArgumentException2;
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        IllegalArgumentException illegalArgumentException;
        Fragment fragment2 = fragment;
        Intent intent2 = intent;
        int i2 = i;
        if (i2 == -1) {
            super.startActivityForResult(intent2, -1);
        } else if ((-65536 & i2) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Can only use lower 16 bits for requestCode");
            throw illegalArgumentException2;
        } else {
            super.startActivityForResult(intent2, ((1 + fragment2.mIndex) << 16) + (65535 & i2));
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.finishAfterTransition(this);
    }

    public void supportInvalidateOptionsMenu() {
        if (VERSION.SDK_INT >= 11) {
            ActivityCompatHoneycomb.invalidateOptionsMenu(this);
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.postponeEnterTransition(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.startPostponedEnterTransition(this);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (this.mRequestedPermissionsFromFragment) {
            this.mRequestedPermissionsFromFragment = false;
        } else if ((i2 & InputDeviceCompat.SOURCE_ANY) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Can only use lower 8 bits for requestCode");
            throw illegalArgumentException2;
        }
    }
}

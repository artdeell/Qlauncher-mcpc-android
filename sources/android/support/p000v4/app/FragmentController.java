package android.support.p000v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.app.FragmentController */
public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    public static final FragmentController createController(FragmentHostCallback<?> fragmentHostCallback) {
        FragmentController fragmentController;
        FragmentController fragmentController2 = fragmentController;
        FragmentController fragmentController3 = new FragmentController(fragmentHostCallback);
        return fragmentController2;
    }

    public void attachHost(Fragment fragment) {
        this.mHost.mFragmentManager.attachController(this.mHost, this.mHost, fragment);
    }

    public void dispatchActivityCreated() {
        this.mHost.mFragmentManager.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        Configuration configuration2 = configuration;
        this.mHost.mFragmentManager.dispatchConfigurationChanged(configuration2);
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        return this.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.mHost.mFragmentManager.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.mFragmentManager.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.mHost.mFragmentManager.dispatchLowMemory();
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        return this.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        Menu menu2 = menu;
        this.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu2);
    }

    public void dispatchPause() {
        this.mHost.mFragmentManager.dispatchPause();
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        return this.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    public void dispatchReallyStop() {
        this.mHost.mFragmentManager.dispatchReallyStop();
    }

    public void dispatchResume() {
        this.mHost.mFragmentManager.dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.mFragmentManager.dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.mFragmentManager.dispatchStop();
    }

    public void doLoaderDestroy() {
        this.mHost.doLoaderDestroy();
    }

    public void doLoaderRetain() {
        this.mHost.doLoaderRetain();
    }

    public void doLoaderStart() {
        this.mHost.doLoaderStart();
    }

    public void doLoaderStop(boolean z) {
        boolean z2 = z;
        this.mHost.doLoaderStop(z2);
    }

    public void dumpLoaders(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        FileDescriptor fileDescriptor2 = fileDescriptor;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        this.mHost.dumpLoaders(str2, fileDescriptor2, printWriter2, strArr2);
    }

    public boolean execPendingActions() {
        return this.mHost.mFragmentManager.execPendingActions();
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List<android.support.v4.app.Fragment>] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.support.p000v4.app.Fragment> getActiveFragments(java.util.List<android.support.p000v4.app.Fragment> r7) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r0
            android.support.v4.app.FragmentHostCallback<?> r2 = r2.mHost
            android.support.v4.app.FragmentManagerImpl r2 = r2.mFragmentManager
            java.util.ArrayList<android.support.v4.app.Fragment> r2 = r2.mActive
            if (r2 != 0) goto L_0x000e
            r2 = 0
            r0 = r2
        L_0x000d:
            return r0
        L_0x000e:
            r2 = r1
            if (r2 != 0) goto L_0x001f
            java.util.ArrayList r2 = new java.util.ArrayList
            r5 = r2
            r2 = r5
            r3 = r5
            r4 = r0
            int r4 = r4.getActiveFragmentsCount()
            r3.<init>(r4)
            r1 = r2
        L_0x001f:
            r2 = r1
            r3 = r0
            android.support.v4.app.FragmentHostCallback<?> r3 = r3.mHost
            android.support.v4.app.FragmentManagerImpl r3 = r3.mFragmentManager
            java.util.ArrayList<android.support.v4.app.Fragment> r3 = r3.mActive
            boolean r2 = r2.addAll(r3)
            r2 = r1
            r0 = r2
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.app.FragmentController.getActiveFragments(java.util.List):java.util.List");
    }

    public int getActiveFragmentsCount() {
        ArrayList<Fragment> arrayList = this.mHost.mFragmentManager.mActive;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mHost.getFragmentManagerImpl();
    }

    public LoaderManager getSupportLoaderManager() {
        return this.mHost.getLoaderManagerImpl();
    }

    public void noteStateNotSaved() {
        this.mHost.mFragmentManager.noteStateNotSaved();
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mHost.mFragmentManager.onCreateView(view, str, context, attributeSet);
    }

    public void reportLoaderStart() {
        this.mHost.reportLoaderStart();
    }

    public void restoreAllState(Parcelable parcelable, List<Fragment> list) {
        Parcelable parcelable2 = parcelable;
        List<Fragment> list2 = list;
        this.mHost.mFragmentManager.restoreAllState(parcelable2, list2);
    }

    public void restoreLoaderNonConfig(SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
        SimpleArrayMap<String, LoaderManager> simpleArrayMap2 = simpleArrayMap;
        this.mHost.restoreLoaderNonConfig(simpleArrayMap2);
    }

    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return this.mHost.retainLoaderNonConfig();
    }

    public List<Fragment> retainNonConfig() {
        return this.mHost.mFragmentManager.retainNonConfig();
    }

    public Parcelable saveAllState() {
        return this.mHost.mFragmentManager.saveAllState();
    }
}

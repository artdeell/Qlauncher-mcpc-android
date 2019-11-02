package android.support.p000v4.widget;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

/* renamed from: android.support.v4.widget.SearchViewCompatHoneycomb */
class SearchViewCompatHoneycomb {

    /* renamed from: android.support.v4.widget.SearchViewCompatHoneycomb$OnCloseListenerCompatBridge */
    interface OnCloseListenerCompatBridge {
        boolean onClose();
    }

    /* renamed from: android.support.v4.widget.SearchViewCompatHoneycomb$OnQueryTextListenerCompatBridge */
    interface OnQueryTextListenerCompatBridge {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    SearchViewCompatHoneycomb() {
    }

    public static CharSequence getQuery(View view) {
        return ((SearchView) view).getQuery();
    }

    public static boolean isIconified(View view) {
        return ((SearchView) view).isIconified();
    }

    public static boolean isQueryRefinementEnabled(View view) {
        return ((SearchView) view).isQueryRefinementEnabled();
    }

    public static boolean isSubmitButtonEnabled(View view) {
        return ((SearchView) view).isSubmitButtonEnabled();
    }

    public static Object newOnCloseListener(OnCloseListenerCompatBridge onCloseListenerCompatBridge) {
        C01402 r4;
        C01402 r1 = r4;
        final OnCloseListenerCompatBridge onCloseListenerCompatBridge2 = onCloseListenerCompatBridge;
        C01402 r2 = new OnCloseListener() {
            public boolean onClose() {
                return onCloseListenerCompatBridge2.onClose();
            }
        };
        return r1;
    }

    public static Object newOnQueryTextListener(OnQueryTextListenerCompatBridge onQueryTextListenerCompatBridge) {
        C01391 r4;
        C01391 r1 = r4;
        final OnQueryTextListenerCompatBridge onQueryTextListenerCompatBridge2 = onQueryTextListenerCompatBridge;
        C01391 r2 = new OnQueryTextListener() {
            public boolean onQueryTextChange(String str) {
                return onQueryTextListenerCompatBridge2.onQueryTextChange(str);
            }

            public boolean onQueryTextSubmit(String str) {
                return onQueryTextListenerCompatBridge2.onQueryTextSubmit(str);
            }
        };
        return r1;
    }

    public static View newSearchView(Context context) {
        SearchView searchView;
        SearchView searchView2 = searchView;
        SearchView searchView3 = new SearchView(context);
        return searchView2;
    }

    public static void setIconified(View view, boolean z) {
        ((SearchView) view).setIconified(z);
    }

    public static void setMaxWidth(View view, int i) {
        ((SearchView) view).setMaxWidth(i);
    }

    public static void setOnCloseListener(Object obj, Object obj2) {
        ((SearchView) obj).setOnCloseListener((OnCloseListener) obj2);
    }

    public static void setOnQueryTextListener(Object obj, Object obj2) {
        ((SearchView) obj).setOnQueryTextListener((OnQueryTextListener) obj2);
    }

    public static void setQuery(View view, CharSequence charSequence, boolean z) {
        ((SearchView) view).setQuery(charSequence, z);
    }

    public static void setQueryHint(View view, CharSequence charSequence) {
        ((SearchView) view).setQueryHint(charSequence);
    }

    public static void setQueryRefinementEnabled(View view, boolean z) {
        ((SearchView) view).setQueryRefinementEnabled(z);
    }

    public static void setSearchableInfo(View view, ComponentName componentName) {
        SearchView searchView = (SearchView) view;
        searchView.setSearchableInfo(((SearchManager) searchView.getContext().getSystemService("search")).getSearchableInfo(componentName));
    }

    public static void setSubmitButtonEnabled(View view, boolean z) {
        ((SearchView) view).setSubmitButtonEnabled(z);
    }
}

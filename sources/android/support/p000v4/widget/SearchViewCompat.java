package android.support.p000v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.widget.SearchViewCompat */
public class SearchViewCompat {
    /* access modifiers changed from: private */
    public static final SearchViewCompatImpl IMPL;

    /* renamed from: android.support.v4.widget.SearchViewCompat$OnCloseListenerCompat */
    public static abstract class OnCloseListenerCompat {
        final Object mListener = SearchViewCompat.IMPL.newOnCloseListener(this);

        public OnCloseListenerCompat() {
        }

        public boolean onClose() {
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$OnQueryTextListenerCompat */
    public static abstract class OnQueryTextListenerCompat {
        final Object mListener = SearchViewCompat.IMPL.newOnQueryTextListener(this);

        public OnQueryTextListenerCompat() {
        }

        public boolean onQueryTextChange(String str) {
            String str2 = str;
            return false;
        }

        public boolean onQueryTextSubmit(String str) {
            String str2 = str;
            return false;
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatHoneycombImpl */
    static class SearchViewCompatHoneycombImpl extends SearchViewCompatStubImpl {
        SearchViewCompatHoneycombImpl() {
        }

        public CharSequence getQuery(View view) {
            return SearchViewCompatHoneycomb.getQuery(view);
        }

        public boolean isIconified(View view) {
            return SearchViewCompatHoneycomb.isIconified(view);
        }

        public boolean isQueryRefinementEnabled(View view) {
            return SearchViewCompatHoneycomb.isQueryRefinementEnabled(view);
        }

        public boolean isSubmitButtonEnabled(View view) {
            return SearchViewCompatHoneycomb.isSubmitButtonEnabled(view);
        }

        public Object newOnCloseListener(OnCloseListenerCompat onCloseListenerCompat) {
            C01382 r6;
            C01382 r2 = r6;
            final OnCloseListenerCompat onCloseListenerCompat2 = onCloseListenerCompat;
            C01382 r3 = new OnCloseListenerCompatBridge(this) {
                final /* synthetic */ SearchViewCompatHoneycombImpl this$0;

                {
                    OnCloseListenerCompat onCloseListenerCompat = r7;
                    this.this$0 = r6;
                }

                public boolean onClose() {
                    return onCloseListenerCompat2.onClose();
                }
            };
            return SearchViewCompatHoneycomb.newOnCloseListener(r2);
        }

        public Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat) {
            C01371 r6;
            C01371 r2 = r6;
            final OnQueryTextListenerCompat onQueryTextListenerCompat2 = onQueryTextListenerCompat;
            C01371 r3 = new OnQueryTextListenerCompatBridge(this) {
                final /* synthetic */ SearchViewCompatHoneycombImpl this$0;

                {
                    OnQueryTextListenerCompat onQueryTextListenerCompat = r7;
                    this.this$0 = r6;
                }

                public boolean onQueryTextChange(String str) {
                    return onQueryTextListenerCompat2.onQueryTextChange(str);
                }

                public boolean onQueryTextSubmit(String str) {
                    return onQueryTextListenerCompat2.onQueryTextSubmit(str);
                }
            };
            return SearchViewCompatHoneycomb.newOnQueryTextListener(r2);
        }

        public View newSearchView(Context context) {
            return SearchViewCompatHoneycomb.newSearchView(context);
        }

        public void setIconified(View view, boolean z) {
            SearchViewCompatHoneycomb.setIconified(view, z);
        }

        public void setMaxWidth(View view, int i) {
            SearchViewCompatHoneycomb.setMaxWidth(view, i);
        }

        public void setOnCloseListener(Object obj, Object obj2) {
            SearchViewCompatHoneycomb.setOnCloseListener(obj, obj2);
        }

        public void setOnQueryTextListener(Object obj, Object obj2) {
            SearchViewCompatHoneycomb.setOnQueryTextListener(obj, obj2);
        }

        public void setQuery(View view, CharSequence charSequence, boolean z) {
            SearchViewCompatHoneycomb.setQuery(view, charSequence, z);
        }

        public void setQueryHint(View view, CharSequence charSequence) {
            SearchViewCompatHoneycomb.setQueryHint(view, charSequence);
        }

        public void setQueryRefinementEnabled(View view, boolean z) {
            SearchViewCompatHoneycomb.setQueryRefinementEnabled(view, z);
        }

        public void setSearchableInfo(View view, ComponentName componentName) {
            SearchViewCompatHoneycomb.setSearchableInfo(view, componentName);
        }

        public void setSubmitButtonEnabled(View view, boolean z) {
            SearchViewCompatHoneycomb.setSubmitButtonEnabled(view, z);
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatIcsImpl */
    static class SearchViewCompatIcsImpl extends SearchViewCompatHoneycombImpl {
        SearchViewCompatIcsImpl() {
        }

        public View newSearchView(Context context) {
            return SearchViewCompatIcs.newSearchView(context);
        }

        public void setImeOptions(View view, int i) {
            SearchViewCompatIcs.setImeOptions(view, i);
        }

        public void setInputType(View view, int i) {
            SearchViewCompatIcs.setInputType(view, i);
        }
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatImpl */
    interface SearchViewCompatImpl {
        CharSequence getQuery(View view);

        boolean isIconified(View view);

        boolean isQueryRefinementEnabled(View view);

        boolean isSubmitButtonEnabled(View view);

        Object newOnCloseListener(OnCloseListenerCompat onCloseListenerCompat);

        Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat);

        View newSearchView(Context context);

        void setIconified(View view, boolean z);

        void setImeOptions(View view, int i);

        void setInputType(View view, int i);

        void setMaxWidth(View view, int i);

        void setOnCloseListener(Object obj, Object obj2);

        void setOnQueryTextListener(Object obj, Object obj2);

        void setQuery(View view, CharSequence charSequence, boolean z);

        void setQueryHint(View view, CharSequence charSequence);

        void setQueryRefinementEnabled(View view, boolean z);

        void setSearchableInfo(View view, ComponentName componentName);

        void setSubmitButtonEnabled(View view, boolean z);
    }

    /* renamed from: android.support.v4.widget.SearchViewCompat$SearchViewCompatStubImpl */
    static class SearchViewCompatStubImpl implements SearchViewCompatImpl {
        SearchViewCompatStubImpl() {
        }

        public CharSequence getQuery(View view) {
            View view2 = view;
            return null;
        }

        public boolean isIconified(View view) {
            View view2 = view;
            return true;
        }

        public boolean isQueryRefinementEnabled(View view) {
            View view2 = view;
            return false;
        }

        public boolean isSubmitButtonEnabled(View view) {
            View view2 = view;
            return false;
        }

        public Object newOnCloseListener(OnCloseListenerCompat onCloseListenerCompat) {
            OnCloseListenerCompat onCloseListenerCompat2 = onCloseListenerCompat;
            return null;
        }

        public Object newOnQueryTextListener(OnQueryTextListenerCompat onQueryTextListenerCompat) {
            OnQueryTextListenerCompat onQueryTextListenerCompat2 = onQueryTextListenerCompat;
            return null;
        }

        public View newSearchView(Context context) {
            Context context2 = context;
            return null;
        }

        public void setIconified(View view, boolean z) {
        }

        public void setImeOptions(View view, int i) {
        }

        public void setInputType(View view, int i) {
        }

        public void setMaxWidth(View view, int i) {
        }

        public void setOnCloseListener(Object obj, Object obj2) {
        }

        public void setOnQueryTextListener(Object obj, Object obj2) {
        }

        public void setQuery(View view, CharSequence charSequence, boolean z) {
        }

        public void setQueryHint(View view, CharSequence charSequence) {
        }

        public void setQueryRefinementEnabled(View view, boolean z) {
        }

        public void setSearchableInfo(View view, ComponentName componentName) {
        }

        public void setSubmitButtonEnabled(View view, boolean z) {
        }
    }

    static {
        SearchViewCompatStubImpl searchViewCompatStubImpl;
        SearchViewCompatHoneycombImpl searchViewCompatHoneycombImpl;
        SearchViewCompatIcsImpl searchViewCompatIcsImpl;
        if (VERSION.SDK_INT >= 14) {
            SearchViewCompatIcsImpl searchViewCompatIcsImpl2 = searchViewCompatIcsImpl;
            SearchViewCompatIcsImpl searchViewCompatIcsImpl3 = new SearchViewCompatIcsImpl();
            IMPL = searchViewCompatIcsImpl2;
        } else if (VERSION.SDK_INT >= 11) {
            SearchViewCompatHoneycombImpl searchViewCompatHoneycombImpl2 = searchViewCompatHoneycombImpl;
            SearchViewCompatHoneycombImpl searchViewCompatHoneycombImpl3 = new SearchViewCompatHoneycombImpl();
            IMPL = searchViewCompatHoneycombImpl2;
        } else {
            SearchViewCompatStubImpl searchViewCompatStubImpl2 = searchViewCompatStubImpl;
            SearchViewCompatStubImpl searchViewCompatStubImpl3 = new SearchViewCompatStubImpl();
            IMPL = searchViewCompatStubImpl2;
        }
    }

    private SearchViewCompat(Context context) {
        Context context2 = context;
    }

    public static CharSequence getQuery(View view) {
        return IMPL.getQuery(view);
    }

    public static boolean isIconified(View view) {
        return IMPL.isIconified(view);
    }

    public static boolean isQueryRefinementEnabled(View view) {
        return IMPL.isQueryRefinementEnabled(view);
    }

    public static boolean isSubmitButtonEnabled(View view) {
        return IMPL.isSubmitButtonEnabled(view);
    }

    public static View newSearchView(Context context) {
        return IMPL.newSearchView(context);
    }

    public static void setIconified(View view, boolean z) {
        IMPL.setIconified(view, z);
    }

    public static void setImeOptions(View view, int i) {
        IMPL.setImeOptions(view, i);
    }

    public static void setInputType(View view, int i) {
        IMPL.setInputType(view, i);
    }

    public static void setMaxWidth(View view, int i) {
        IMPL.setMaxWidth(view, i);
    }

    public static void setOnCloseListener(View view, OnCloseListenerCompat onCloseListenerCompat) {
        IMPL.setOnCloseListener(view, onCloseListenerCompat.mListener);
    }

    public static void setOnQueryTextListener(View view, OnQueryTextListenerCompat onQueryTextListenerCompat) {
        IMPL.setOnQueryTextListener(view, onQueryTextListenerCompat.mListener);
    }

    public static void setQuery(View view, CharSequence charSequence, boolean z) {
        IMPL.setQuery(view, charSequence, z);
    }

    public static void setQueryHint(View view, CharSequence charSequence) {
        IMPL.setQueryHint(view, charSequence);
    }

    public static void setQueryRefinementEnabled(View view, boolean z) {
        IMPL.setQueryRefinementEnabled(view, z);
    }

    public static void setSearchableInfo(View view, ComponentName componentName) {
        IMPL.setSearchableInfo(view, componentName);
    }

    public static void setSubmitButtonEnabled(View view, boolean z) {
        IMPL.setSubmitButtonEnabled(view, z);
    }
}

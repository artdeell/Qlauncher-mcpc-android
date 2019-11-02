package android.support.p000v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.FragmentTabHost */
public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private TabInfo mLastTab;
    private OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList<TabInfo> mTabs;

    /* renamed from: android.support.v4.app.FragmentTabHost$DummyTabFactory */
    static class DummyTabFactory implements TabContentFactory {
        private final Context mContext;

        public DummyTabFactory(Context context) {
            this.mContext = context;
        }

        public View createTabContent(String str) {
            View view;
            String str2 = str;
            View view2 = view;
            View view3 = new View(this.mContext);
            View view4 = view2;
            view4.setMinimumWidth(0);
            view4.setMinimumHeight(0);
            return view4;
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost$SavedState */
    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        String curTab;

        static {
            C00231 r2;
            C00231 r0 = r2;
            C00231 r1 = new Creator<SavedState>() {
                public SavedState createFromParcel(Parcel parcel) {
                    SavedState savedState;
                    SavedState savedState2 = savedState;
                    SavedState savedState3 = new SavedState(parcel, null);
                    return savedState2;
                }

                public SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            CREATOR = r0;
        }

        private SavedState(Parcel parcel) {
            Parcel parcel2 = parcel;
            super(parcel2);
            this.curTab = parcel2.readString();
        }

        /* synthetic */ SavedState(Parcel parcel, C00221 r7) {
            C00221 r2 = r7;
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(this.curTab).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            Parcel parcel2 = parcel;
            super.writeToParcel(parcel2, i);
            parcel2.writeString(this.curTab);
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost$TabInfo */
    static final class TabInfo {
        /* access modifiers changed from: private */
        public final Bundle args;
        /* access modifiers changed from: private */
        public final Class<?> clss;
        /* access modifiers changed from: private */
        public Fragment fragment;
        /* access modifiers changed from: private */
        public final String tag;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            Class<?> cls2 = cls;
            Bundle bundle2 = bundle;
            this.tag = str;
            this.clss = cls2;
            this.args = bundle2;
        }

        static /* synthetic */ Fragment access$102(TabInfo tabInfo, Fragment fragment2) {
            Fragment fragment3 = fragment2;
            tabInfo.fragment = fragment3;
            return fragment3;
        }
    }

    public FragmentTabHost(Context context) {
        ArrayList<TabInfo> arrayList;
        Context context2 = context;
        super(context2, null);
        ArrayList<TabInfo> arrayList2 = arrayList;
        ArrayList<TabInfo> arrayList3 = new ArrayList<>();
        this.mTabs = arrayList2;
        initFragmentTabHost(context2, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        ArrayList<TabInfo> arrayList;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        super(context2, attributeSet2);
        ArrayList<TabInfo> arrayList2 = arrayList;
        ArrayList<TabInfo> arrayList3 = new ArrayList<>();
        this.mTabs = arrayList2;
        initFragmentTabHost(context2, attributeSet2);
    }

    private FragmentTransaction doTabChanged(String str, FragmentTransaction fragmentTransaction) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        String str2 = str;
        FragmentTransaction fragmentTransaction2 = fragmentTransaction;
        TabInfo tabInfo = null;
        for (int i = 0; i < this.mTabs.size(); i++) {
            TabInfo tabInfo2 = (TabInfo) this.mTabs.get(i);
            if (tabInfo2.tag.equals(str2)) {
                tabInfo = tabInfo2;
            }
        }
        if (tabInfo == null) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("No tab known for tag ").append(str2).toString());
            throw illegalStateException2;
        }
        if (this.mLastTab != tabInfo) {
            if (fragmentTransaction2 == null) {
                fragmentTransaction2 = this.mFragmentManager.beginTransaction();
            }
            if (!(this.mLastTab == null || this.mLastTab.fragment == null)) {
                FragmentTransaction detach = fragmentTransaction2.detach(this.mLastTab.fragment);
            }
            if (tabInfo != null) {
                if (tabInfo.fragment == null) {
                    Fragment access$102 = TabInfo.access$102(tabInfo, Fragment.instantiate(this.mContext, tabInfo.clss.getName(), tabInfo.args));
                    FragmentTransaction add = fragmentTransaction2.add(this.mContainerId, tabInfo.fragment, tabInfo.tag);
                } else {
                    FragmentTransaction attach = fragmentTransaction2.attach(tabInfo.fragment);
                }
            }
            this.mLastTab = tabInfo;
        }
        return fragmentTransaction2;
    }

    private void ensureContent() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        if (this.mRealTabContent == null) {
            this.mRealTabContent = (FrameLayout) findViewById(this.mContainerId);
            if (this.mRealTabContent == null) {
                IllegalStateException illegalStateException2 = illegalStateException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("No tab content FrameLayout found for id ").append(this.mContainerId).toString());
                throw illegalStateException2;
            }
        }
    }

    private void ensureHierarchy(Context context) {
        LinearLayout linearLayout;
        LayoutParams layoutParams;
        TabWidget tabWidget;
        LinearLayout.LayoutParams layoutParams2;
        FrameLayout frameLayout;
        LinearLayout.LayoutParams layoutParams3;
        FrameLayout frameLayout2;
        LinearLayout.LayoutParams layoutParams4;
        Context context2 = context;
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout2 = linearLayout;
            LinearLayout linearLayout3 = new LinearLayout(context2);
            LinearLayout linearLayout4 = linearLayout2;
            linearLayout4.setOrientation(1);
            LinearLayout linearLayout5 = linearLayout4;
            LayoutParams layoutParams5 = layoutParams;
            LayoutParams layoutParams6 = new LayoutParams(-1, -1);
            addView(linearLayout5, layoutParams5);
            TabWidget tabWidget2 = tabWidget;
            TabWidget tabWidget3 = new TabWidget(context2);
            TabWidget tabWidget4 = tabWidget2;
            tabWidget4.setId(16908307);
            tabWidget4.setOrientation(0);
            LinearLayout linearLayout6 = linearLayout4;
            TabWidget tabWidget5 = tabWidget4;
            LinearLayout.LayoutParams layoutParams7 = layoutParams2;
            LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2, 0.0f);
            linearLayout6.addView(tabWidget5, layoutParams7);
            FrameLayout frameLayout3 = frameLayout;
            FrameLayout frameLayout4 = new FrameLayout(context2);
            FrameLayout frameLayout5 = frameLayout3;
            frameLayout5.setId(16908305);
            LinearLayout linearLayout7 = linearLayout4;
            FrameLayout frameLayout6 = frameLayout5;
            LinearLayout.LayoutParams layoutParams9 = layoutParams3;
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, 0, 0.0f);
            linearLayout7.addView(frameLayout6, layoutParams9);
            FrameLayout frameLayout7 = frameLayout2;
            FrameLayout frameLayout8 = new FrameLayout(context2);
            FrameLayout frameLayout9 = frameLayout7;
            this.mRealTabContent = frameLayout9;
            this.mRealTabContent.setId(this.mContainerId);
            LinearLayout linearLayout8 = linearLayout4;
            FrameLayout frameLayout10 = frameLayout9;
            LinearLayout.LayoutParams layoutParams11 = layoutParams4;
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
            linearLayout8.addView(frameLayout10, layoutParams11);
        }
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        int[] iArr = new int[1];
        int[] iArr2 = iArr;
        iArr[0] = 16842995;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, iArr2, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    public void addTab(TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        DummyTabFactory dummyTabFactory;
        TabInfo tabInfo;
        TabSpec tabSpec2 = tabSpec;
        Class<?> cls2 = cls;
        Bundle bundle2 = bundle;
        TabSpec tabSpec3 = tabSpec2;
        DummyTabFactory dummyTabFactory2 = dummyTabFactory;
        DummyTabFactory dummyTabFactory3 = new DummyTabFactory(this.mContext);
        TabSpec content = tabSpec3.setContent(dummyTabFactory2);
        String tag = tabSpec2.getTag();
        TabInfo tabInfo2 = tabInfo;
        TabInfo tabInfo3 = new TabInfo(tag, cls2, bundle2);
        TabInfo tabInfo4 = tabInfo2;
        if (this.mAttached) {
            Fragment access$102 = TabInfo.access$102(tabInfo4, this.mFragmentManager.findFragmentByTag(tag));
            if (tabInfo4.fragment != null && !tabInfo4.fragment.isDetached()) {
                FragmentTransaction beginTransaction = this.mFragmentManager.beginTransaction();
                FragmentTransaction detach = beginTransaction.detach(tabInfo4.fragment);
                int commit = beginTransaction.commit();
            }
        }
        boolean add = this.mTabs.add(tabInfo4);
        addTab(tabSpec2);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.mTabs.size(); i++) {
            TabInfo tabInfo = (TabInfo) this.mTabs.get(i);
            Fragment access$102 = TabInfo.access$102(tabInfo, this.mFragmentManager.findFragmentByTag(tabInfo.tag));
            if (tabInfo.fragment != null && !tabInfo.fragment.isDetached()) {
                if (tabInfo.tag.equals(currentTabTag)) {
                    this.mLastTab = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.mFragmentManager.beginTransaction();
                    }
                    FragmentTransaction detach = fragmentTransaction.detach(tabInfo.fragment);
                }
            }
        }
        this.mAttached = true;
        FragmentTransaction doTabChanged = doTabChanged(currentTabTag, fragmentTransaction);
        if (doTabChanged != null) {
            int commit = doTabChanged.commit();
            boolean executePendingTransactions = this.mFragmentManager.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.curTab);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState;
        SavedState savedState2 = savedState;
        SavedState savedState3 = new SavedState(super.onSaveInstanceState());
        SavedState savedState4 = savedState2;
        savedState4.curTab = getCurrentTabTag();
        return savedState4;
    }

    public void onTabChanged(String str) {
        String str2 = str;
        if (this.mAttached) {
            FragmentTransaction doTabChanged = doTabChanged(str2, null);
            if (doTabChanged != null) {
                int commit = doTabChanged.commit();
            }
        }
        if (this.mOnTabChangeListener != null) {
            this.mOnTabChangeListener.onTabChanged(str2);
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        OnTabChangeListener onTabChangeListener2 = onTabChangeListener;
        this.mOnTabChangeListener = onTabChangeListener2;
    }

    @Deprecated
    public void setup() {
        IllegalStateException illegalStateException;
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
        throw illegalStateException2;
    }

    public void setup(Context context, FragmentManager fragmentManager) {
        Context context2 = context;
        FragmentManager fragmentManager2 = fragmentManager;
        ensureHierarchy(context2);
        super.setup();
        this.mContext = context2;
        this.mFragmentManager = fragmentManager2;
        ensureContent();
    }

    public void setup(Context context, FragmentManager fragmentManager, int i) {
        Context context2 = context;
        FragmentManager fragmentManager2 = fragmentManager;
        int i2 = i;
        ensureHierarchy(context2);
        super.setup();
        this.mContext = context2;
        this.mFragmentManager = fragmentManager2;
        this.mContainerId = i2;
        ensureContent();
        this.mRealTabContent.setId(i2);
        if (getId() == -1) {
            setId(16908306);
        }
    }
}

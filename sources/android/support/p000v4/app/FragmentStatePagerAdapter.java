package android.support.p000v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.app.Fragment.SavedState;
import android.support.p000v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.FragmentStatePagerAdapter */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapter";
    private FragmentTransaction mCurTransaction = null;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments;
    private ArrayList<SavedState> mSavedState;

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        ArrayList<SavedState> arrayList;
        ArrayList<Fragment> arrayList2;
        FragmentManager fragmentManager2 = fragmentManager;
        ArrayList<SavedState> arrayList3 = arrayList;
        ArrayList<SavedState> arrayList4 = new ArrayList<>();
        this.mSavedState = arrayList3;
        ArrayList<Fragment> arrayList5 = arrayList2;
        ArrayList<Fragment> arrayList6 = new ArrayList<>();
        this.mFragments = arrayList5;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = fragmentManager2;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ViewGroup viewGroup2 = viewGroup;
        int i2 = i;
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        while (this.mSavedState.size() <= i2) {
            boolean add = this.mSavedState.add(null);
        }
        Object obj2 = this.mSavedState.set(i2, this.mFragmentManager.saveFragmentInstanceState(fragment));
        Object obj3 = this.mFragments.set(i2, null);
        FragmentTransaction remove = this.mCurTransaction.remove(fragment);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        if (this.mCurTransaction != null) {
            int commitAllowingStateLoss = this.mCurTransaction.commitAllowingStateLoss();
            this.mCurTransaction = null;
            boolean executePendingTransactions = this.mFragmentManager.executePendingTransactions();
        }
    }

    public abstract Fragment getItem(int i);

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2 = viewGroup;
        int i2 = i;
        if (this.mFragments.size() > i2) {
            Fragment fragment = (Fragment) this.mFragments.get(i2);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        Fragment item = getItem(i2);
        if (this.mSavedState.size() > i2) {
            SavedState savedState = (SavedState) this.mSavedState.get(i2);
            if (savedState != null) {
                item.setInitialSavedState(savedState);
            }
        }
        while (this.mFragments.size() <= i2) {
            boolean add = this.mFragments.add(null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        Object obj = this.mFragments.set(i2, item);
        FragmentTransaction add2 = this.mCurTransaction.add(viewGroup2.getId(), item);
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        StringBuilder sb;
        Parcelable parcelable2 = parcelable;
        ClassLoader classLoader2 = classLoader;
        if (parcelable2 != null) {
            Bundle bundle = (Bundle) parcelable2;
            bundle.setClassLoader(classLoader2);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (int i = 0; i < parcelableArray.length; i++) {
                    boolean add = this.mSavedState.add((SavedState) parcelableArray[i]);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment fragment = this.mFragmentManager.getFragment(bundle, str);
                    if (fragment != null) {
                        while (this.mFragments.size() <= parseInt) {
                            boolean add2 = this.mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        Object obj = this.mFragments.set(parseInt, fragment);
                    } else {
                        String str2 = TAG;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        int w = Log.w(str2, sb2.append("Bad fragment at key ").append(str).toString());
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        StringBuilder sb;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = null;
        if (this.mSavedState.size() > 0) {
            Bundle bundle4 = bundle2;
            Bundle bundle5 = new Bundle();
            bundle3 = bundle4;
            SavedState[] savedStateArr = new SavedState[this.mSavedState.size()];
            Object[] array = this.mSavedState.toArray(savedStateArr);
            bundle3.putParcelableArray("states", savedStateArr);
        }
        for (int i = 0; i < this.mFragments.size(); i++) {
            Fragment fragment = (Fragment) this.mFragments.get(i);
            if (fragment != null && fragment.isAdded()) {
                if (bundle3 == null) {
                    Bundle bundle6 = bundle;
                    Bundle bundle7 = new Bundle();
                    bundle3 = bundle6;
                }
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                this.mFragmentManager.putFragment(bundle3, sb2.append("f").append(i).toString(), fragment);
            }
        }
        return bundle3;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        ViewGroup viewGroup2 = viewGroup;
        int i2 = i;
        Fragment fragment = (Fragment) obj;
        if (fragment != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
    }
}

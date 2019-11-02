package android.support.p000v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.PagerAdapter */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private DataSetObservable mObservable;

    public PagerAdapter() {
        DataSetObservable dataSetObservable;
        DataSetObservable dataSetObservable2 = dataSetObservable;
        DataSetObservable dataSetObservable3 = new DataSetObservable();
        this.mObservable = dataSetObservable2;
    }

    public void destroyItem(View view, int i, Object obj) {
        UnsupportedOperationException unsupportedOperationException;
        View view2 = view;
        int i2 = i;
        Object obj2 = obj;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Required method destroyItem was not overridden");
        throw unsupportedOperationException2;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        destroyItem((View) viewGroup, i, obj);
    }

    public void finishUpdate(View view) {
    }

    public void finishUpdate(ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    public abstract int getCount();

    public int getItemPosition(Object obj) {
        Object obj2 = obj;
        return -1;
    }

    public CharSequence getPageTitle(int i) {
        int i2 = i;
        return null;
    }

    public float getPageWidth(int i) {
        int i2 = i;
        return 1.0f;
    }

    public Object instantiateItem(View view, int i) {
        UnsupportedOperationException unsupportedOperationException;
        View view2 = view;
        int i2 = i;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("Required method instantiateItem was not overridden");
        throw unsupportedOperationException2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return instantiateItem((View) viewGroup, i);
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    public void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        DataSetObserver dataSetObserver2 = dataSetObserver;
        this.mObservable.registerObserver(dataSetObserver2);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(View view, int i, Object obj) {
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        setPrimaryItem((View) viewGroup, i, obj);
    }

    public void startUpdate(View view) {
    }

    public void startUpdate(ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        DataSetObserver dataSetObserver2 = dataSetObserver;
        this.mObservable.unregisterObserver(dataSetObserver2);
    }
}

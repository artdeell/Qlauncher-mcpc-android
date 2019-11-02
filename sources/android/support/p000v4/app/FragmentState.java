package android.support.p000v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* renamed from: android.support.v4.app.FragmentState */
final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR;
    final Bundle mArguments;
    final String mClassName;
    final int mContainerId;
    final boolean mDetached;
    final int mFragmentId;
    final boolean mFromLayout;
    final int mIndex;
    Fragment mInstance;
    final boolean mRetainInstance;
    Bundle mSavedFragmentState;
    final String mTag;

    static {
        C00211 r2;
        C00211 r0 = r2;
        C00211 r1 = new Creator<FragmentState>() {
            public FragmentState createFromParcel(Parcel parcel) {
                FragmentState fragmentState;
                FragmentState fragmentState2 = fragmentState;
                FragmentState fragmentState3 = new FragmentState(parcel);
                return fragmentState2;
            }

            public FragmentState[] newArray(int i) {
                return new FragmentState[i];
            }
        };
        CREATOR = r0;
    }

    public FragmentState(Parcel parcel) {
        Parcel parcel2 = parcel;
        boolean z = true;
        this.mClassName = parcel2.readString();
        this.mIndex = parcel2.readInt();
        this.mFromLayout = parcel2.readInt() != 0;
        this.mFragmentId = parcel2.readInt();
        this.mContainerId = parcel2.readInt();
        this.mTag = parcel2.readString();
        this.mRetainInstance = parcel2.readInt() != 0;
        if (parcel2.readInt() == 0) {
            z = false;
        }
        this.mDetached = z;
        this.mArguments = parcel2.readBundle();
        this.mSavedFragmentState = parcel2.readBundle();
    }

    public FragmentState(Fragment fragment) {
        Fragment fragment2 = fragment;
        this.mClassName = fragment2.getClass().getName();
        this.mIndex = fragment2.mIndex;
        this.mFromLayout = fragment2.mFromLayout;
        this.mFragmentId = fragment2.mFragmentId;
        this.mContainerId = fragment2.mContainerId;
        this.mTag = fragment2.mTag;
        this.mRetainInstance = fragment2.mRetainInstance;
        this.mDetached = fragment2.mDetached;
        this.mArguments = fragment2.mArguments;
    }

    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(FragmentHostCallback fragmentHostCallback, Fragment fragment) {
        StringBuilder sb;
        FragmentHostCallback fragmentHostCallback2 = fragmentHostCallback;
        Fragment fragment2 = fragment;
        if (this.mInstance != null) {
            return this.mInstance;
        }
        Context context = fragmentHostCallback2.getContext();
        if (this.mArguments != null) {
            this.mArguments.setClassLoader(context.getClassLoader());
        }
        this.mInstance = Fragment.instantiate(context, this.mClassName, this.mArguments);
        if (this.mSavedFragmentState != null) {
            this.mSavedFragmentState.setClassLoader(context.getClassLoader());
            this.mInstance.mSavedFragmentState = this.mSavedFragmentState;
        }
        this.mInstance.setIndex(this.mIndex, fragment2);
        this.mInstance.mFromLayout = this.mFromLayout;
        this.mInstance.mRestored = true;
        this.mInstance.mFragmentId = this.mFragmentId;
        this.mInstance.mContainerId = this.mContainerId;
        this.mInstance.mTag = this.mTag;
        this.mInstance.mRetainInstance = this.mRetainInstance;
        this.mInstance.mDetached = this.mDetached;
        this.mInstance.mFragmentManager = fragmentHostCallback2.mFragmentManager;
        if (FragmentManagerImpl.DEBUG) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            int v = Log.v("FragmentManager", sb2.append("Instantiated fragment ").append(this.mInstance).toString());
        }
        return this.mInstance;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        int i3 = 1;
        parcel2.writeString(this.mClassName);
        parcel2.writeInt(this.mIndex);
        parcel2.writeInt(this.mFromLayout ? 1 : 0);
        parcel2.writeInt(this.mFragmentId);
        parcel2.writeInt(this.mContainerId);
        parcel2.writeString(this.mTag);
        parcel2.writeInt(this.mRetainInstance ? 1 : 0);
        if (!this.mDetached) {
            i3 = 0;
        }
        parcel2.writeInt(i3);
        parcel2.writeBundle(this.mArguments);
        parcel2.writeBundle(this.mSavedFragmentState);
    }
}

package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.BackStackState */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR;
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int mIndex;
    final String mName;
    final int[] mOps;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    static {
        C00091 r2;
        C00091 r0 = r2;
        C00091 r1 = new Creator<BackStackState>() {
            public BackStackState createFromParcel(Parcel parcel) {
                BackStackState backStackState;
                BackStackState backStackState2 = backStackState;
                BackStackState backStackState3 = new BackStackState(parcel);
                return backStackState2;
            }

            public BackStackState[] newArray(int i) {
                return new BackStackState[i];
            }
        };
        CREATOR = r0;
    }

    public BackStackState(Parcel parcel) {
        Parcel parcel2 = parcel;
        this.mOps = parcel2.createIntArray();
        this.mTransition = parcel2.readInt();
        this.mTransitionStyle = parcel2.readInt();
        this.mName = parcel2.readString();
        this.mIndex = parcel2.readInt();
        this.mBreadCrumbTitleRes = parcel2.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        this.mBreadCrumbShortTitleRes = parcel2.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        this.mSharedElementSourceNames = parcel2.createStringArrayList();
        this.mSharedElementTargetNames = parcel2.createStringArrayList();
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int i;
        int i2;
        IllegalStateException illegalStateException;
        BackStackRecord backStackRecord2 = backStackRecord;
        int i3 = 0;
        C0008Op op = backStackRecord2.mHead;
        while (true) {
            C0008Op op2 = op;
            if (op2 == null) {
                break;
            }
            if (op2.removed != null) {
                i3 += op2.removed.size();
            }
            op = op2.next;
        }
        this.mOps = new int[(i3 + (7 * backStackRecord2.mNumOp))];
        if (!backStackRecord2.mAddToBackStack) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Not on back stack");
            throw illegalStateException2;
        }
        C0008Op op3 = backStackRecord2.mHead;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (op3 != null) {
                int i6 = i5 + 1;
                this.mOps[i5] = op3.cmd;
                int i7 = i6 + 1;
                this.mOps[i6] = op3.fragment != null ? op3.fragment.mIndex : -1;
                int i8 = i7 + 1;
                this.mOps[i7] = op3.enterAnim;
                int i9 = i8 + 1;
                this.mOps[i8] = op3.exitAnim;
                int i10 = i9 + 1;
                this.mOps[i9] = op3.popEnterAnim;
                int i11 = i10 + 1;
                this.mOps[i10] = op3.popExitAnim;
                if (op3.removed != null) {
                    int size = op3.removed.size();
                    int i12 = i11 + 1;
                    this.mOps[i11] = size;
                    int i13 = 0;
                    int i14 = i12;
                    while (true) {
                        i2 = i14;
                        if (i13 >= size) {
                            break;
                        }
                        int i15 = i2 + 1;
                        this.mOps[i2] = ((Fragment) op3.removed.get(i13)).mIndex;
                        i13++;
                        i14 = i15;
                    }
                    i = i2;
                } else {
                    i = i11 + 1;
                    this.mOps[i11] = 0;
                }
                op3 = op3.next;
                i4 = i;
            } else {
                this.mTransition = backStackRecord2.mTransition;
                this.mTransitionStyle = backStackRecord2.mTransitionStyle;
                this.mName = backStackRecord2.mName;
                this.mIndex = backStackRecord2.mIndex;
                this.mBreadCrumbTitleRes = backStackRecord2.mBreadCrumbTitleRes;
                this.mBreadCrumbTitleText = backStackRecord2.mBreadCrumbTitleText;
                this.mBreadCrumbShortTitleRes = backStackRecord2.mBreadCrumbShortTitleRes;
                this.mBreadCrumbShortTitleText = backStackRecord2.mBreadCrumbShortTitleText;
                this.mSharedElementSourceNames = backStackRecord2.mSharedElementSourceNames;
                this.mSharedElementTargetNames = backStackRecord2.mSharedElementTargetNames;
                return;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord;
        C0008Op op;
        ArrayList arrayList;
        StringBuilder sb;
        StringBuilder sb2;
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        BackStackRecord backStackRecord2 = backStackRecord;
        BackStackRecord backStackRecord3 = new BackStackRecord(fragmentManagerImpl2);
        BackStackRecord backStackRecord4 = backStackRecord2;
        int i = 0;
        int i2 = 0;
        while (i < this.mOps.length) {
            C0008Op op2 = op;
            C0008Op op3 = new C0008Op();
            C0008Op op4 = op2;
            int[] iArr = this.mOps;
            int i3 = i + 1;
            op4.cmd = iArr[i];
            if (FragmentManagerImpl.DEBUG) {
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                int v = Log.v("FragmentManager", sb3.append("Instantiate ").append(backStackRecord4).append(" op #").append(i2).append(" base fragment #").append(this.mOps[i3]).toString());
            }
            int i4 = i3 + 1;
            int i5 = this.mOps[i3];
            if (i5 >= 0) {
                op4.fragment = (Fragment) fragmentManagerImpl2.mActive.get(i5);
            } else {
                op4.fragment = null;
            }
            int[] iArr2 = this.mOps;
            int i6 = i4 + 1;
            op4.enterAnim = iArr2[i4];
            int[] iArr3 = this.mOps;
            int i7 = i6 + 1;
            op4.exitAnim = iArr3[i6];
            int[] iArr4 = this.mOps;
            int i8 = i7 + 1;
            op4.popEnterAnim = iArr4[i7];
            int[] iArr5 = this.mOps;
            int i9 = i8 + 1;
            op4.popExitAnim = iArr5[i8];
            int i10 = i9 + 1;
            int i11 = this.mOps[i9];
            if (i11 > 0) {
                C0008Op op5 = op4;
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(i11);
                op5.removed = arrayList2;
                int i12 = 0;
                while (i12 < i11) {
                    if (FragmentManagerImpl.DEBUG) {
                        StringBuilder sb5 = sb;
                        StringBuilder sb6 = new StringBuilder();
                        int v2 = Log.v("FragmentManager", sb5.append("Instantiate ").append(backStackRecord4).append(" set remove fragment #").append(this.mOps[i10]).toString());
                    }
                    int i13 = i10 + 1;
                    boolean add = op4.removed.add((Fragment) fragmentManagerImpl2.mActive.get(this.mOps[i10]));
                    i12++;
                    i10 = i13;
                }
            }
            i = i10;
            backStackRecord4.addOp(op4);
            i2++;
        }
        backStackRecord4.mTransition = this.mTransition;
        backStackRecord4.mTransitionStyle = this.mTransitionStyle;
        backStackRecord4.mName = this.mName;
        backStackRecord4.mIndex = this.mIndex;
        backStackRecord4.mAddToBackStack = true;
        backStackRecord4.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        backStackRecord4.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        backStackRecord4.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        backStackRecord4.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        backStackRecord4.mSharedElementSourceNames = this.mSharedElementSourceNames;
        backStackRecord4.mSharedElementTargetNames = this.mSharedElementTargetNames;
        backStackRecord4.bumpBackStackNesting(1);
        return backStackRecord4;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        parcel2.writeIntArray(this.mOps);
        parcel2.writeInt(this.mTransition);
        parcel2.writeInt(this.mTransitionStyle);
        parcel2.writeString(this.mName);
        parcel2.writeInt(this.mIndex);
        parcel2.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel2, 0);
        parcel2.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel2, 0);
        parcel2.writeStringList(this.mSharedElementSourceNames);
        parcel2.writeStringList(this.mSharedElementTargetNames);
    }
}

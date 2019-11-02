package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR;
    private IBinder zzakD;

    static {
        C02381 r2;
        C02381 r0 = r2;
        C02381 r1 = new Creator<BinderWrapper>() {
            /* renamed from: zzan */
            public BinderWrapper createFromParcel(Parcel parcel) {
                BinderWrapper binderWrapper;
                BinderWrapper binderWrapper2 = binderWrapper;
                BinderWrapper binderWrapper3 = new BinderWrapper(parcel, null);
                return binderWrapper2;
            }

            /* renamed from: zzbQ */
            public BinderWrapper[] newArray(int i) {
                return new BinderWrapper[i];
            }
        };
        CREATOR = r0;
    }

    public BinderWrapper() {
        this.zzakD = null;
    }

    public BinderWrapper(IBinder iBinder) {
        IBinder iBinder2 = iBinder;
        this.zzakD = null;
        this.zzakD = iBinder2;
    }

    private BinderWrapper(Parcel parcel) {
        Parcel parcel2 = parcel;
        this.zzakD = null;
        this.zzakD = parcel2.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, C02381 r7) {
        C02381 r2 = r7;
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = i;
        parcel.writeStrongBinder(this.zzakD);
    }
}

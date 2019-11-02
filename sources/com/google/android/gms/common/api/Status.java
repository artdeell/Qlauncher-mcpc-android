package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final Creator<Status> CREATOR;
    public static final Status zzagC;
    public static final Status zzagD;
    public static final Status zzagE;
    public static final Status zzagF;
    public static final Status zzagG;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzade;
    private final String zzafC;

    static {
        Status status;
        Status status2;
        Status status3;
        Status status4;
        Status status5;
        zzc zzc;
        Status status6 = status;
        Status status7 = new Status(0);
        zzagC = status6;
        Status status8 = status2;
        Status status9 = new Status(14);
        zzagD = status8;
        Status status10 = status3;
        Status status11 = new Status(8);
        zzagE = status10;
        Status status12 = status4;
        Status status13 = new Status(15);
        zzagF = status12;
        Status status14 = status5;
        Status status15 = new Status(16);
        zzagG = status14;
        zzc zzc2 = zzc;
        zzc zzc3 = new zzc();
        CREATOR = zzc2;
    }

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        int i3 = i2;
        String str2 = str;
        PendingIntent pendingIntent2 = pendingIntent;
        this.mVersionCode = i;
        this.zzade = i3;
        this.zzafC = str2;
        this.mPendingIntent = pendingIntent2;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzpd() {
        return this.zzafC != null ? this.zzafC : CommonStatusCodes.getStatusCodeString(this.zzade);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof Status) {
            Status status = (Status) obj2;
            if (this.mVersionCode == status.mVersionCode && this.zzade == status.zzade && zzw.equal(this.zzafC, status.zzafC) && zzw.equal(this.mPendingIntent, status.mPendingIntent)) {
                return true;
            }
        }
        return false;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzade;
    }

    public String getStatusMessage() {
        return this.zzafC;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzade), this.zzafC, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzade == 16;
    }

    public boolean isInterrupted() {
        return this.zzade == 14;
    }

    public boolean isSuccess() {
        return this.zzade <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws SendIntentException {
        Activity activity2 = activity;
        int i2 = i;
        if (hasResolution()) {
            activity2.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzy(this).zzg("statusCode", zzpd()).zzg("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    /* access modifiers changed from: 0000 */
    public PendingIntent zzpc() {
        return this.mPendingIntent;
    }
}

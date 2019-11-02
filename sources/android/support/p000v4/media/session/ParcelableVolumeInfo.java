package android.support.p000v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.media.session.ParcelableVolumeInfo */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR;
    public int audioStream;
    public int controlType;
    public int currentVolume;
    public int maxVolume;
    public int volumeType;

    static {
        C00811 r2;
        C00811 r0 = r2;
        C00811 r1 = new Creator<ParcelableVolumeInfo>() {
            public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
                ParcelableVolumeInfo parcelableVolumeInfo;
                ParcelableVolumeInfo parcelableVolumeInfo2 = parcelableVolumeInfo;
                ParcelableVolumeInfo parcelableVolumeInfo3 = new ParcelableVolumeInfo(parcel);
                return parcelableVolumeInfo2;
            }

            public ParcelableVolumeInfo[] newArray(int i) {
                return new ParcelableVolumeInfo[i];
            }
        };
        CREATOR = r0;
    }

    public ParcelableVolumeInfo(int i, int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int i9 = i5;
        this.volumeType = i;
        this.audioStream = i6;
        this.controlType = i7;
        this.maxVolume = i8;
        this.currentVolume = i9;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        Parcel parcel2 = parcel;
        this.volumeType = parcel2.readInt();
        this.controlType = parcel2.readInt();
        this.maxVolume = parcel2.readInt();
        this.currentVolume = parcel2.readInt();
        this.audioStream = parcel2.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        parcel2.writeInt(this.volumeType);
        parcel2.writeInt(this.controlType);
        parcel2.writeInt(this.maxVolume);
        parcel2.writeInt(this.currentVolume);
        parcel2.writeInt(this.audioStream);
    }
}

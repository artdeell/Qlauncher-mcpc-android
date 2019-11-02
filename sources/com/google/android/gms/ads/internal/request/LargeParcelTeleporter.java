package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzna;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

@zzhb
public final class LargeParcelTeleporter implements SafeParcelable {
    public static final Creator<LargeParcelTeleporter> CREATOR;
    final int mVersionCode;
    ParcelFileDescriptor zzIq;
    private Parcelable zzIr;
    private boolean zzIs;

    static {
        zzl zzl;
        zzl zzl2 = zzl;
        zzl zzl3 = new zzl();
        CREATOR = zzl2;
    }

    LargeParcelTeleporter(int i, ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        this.mVersionCode = i;
        this.zzIq = parcelFileDescriptor2;
        this.zzIr = null;
        this.zzIs = true;
    }

    public LargeParcelTeleporter(SafeParcelable safeParcelable) {
        SafeParcelable safeParcelable2 = safeParcelable;
        this.mVersionCode = 1;
        this.zzIq = null;
        this.zzIr = safeParcelable2;
        this.zzIs = false;
    }

    public int describeContents() {
        return 0;
    }

    /* JADX INFO: finally extract failed */
    public void writeToParcel(Parcel parcel, int i) {
        Parcel parcel2 = parcel;
        int i2 = i;
        if (this.zzIq == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzIr.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzIq = zzf(marshall);
            } catch (Throwable th) {
                Throwable th2 = th;
                obtain.recycle();
                throw th2;
            }
        }
        zzl.zza(this, parcel2, i2);
    }

    public <T extends SafeParcelable> T zza(Creator<T> creator) {
        DataInputStream dataInputStream;
        AutoCloseInputStream autoCloseInputStream;
        IllegalStateException illegalStateException;
        Creator<T> creator2 = creator;
        if (this.zzIs) {
            if (this.zzIq == null) {
                zzin.m19e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream2 = dataInputStream;
            AutoCloseInputStream autoCloseInputStream2 = autoCloseInputStream;
            AutoCloseInputStream autoCloseInputStream3 = new AutoCloseInputStream(this.zzIq);
            DataInputStream dataInputStream3 = new DataInputStream(autoCloseInputStream2);
            DataInputStream dataInputStream4 = dataInputStream2;
            try {
                byte[] bArr = new byte[dataInputStream4.readInt()];
                dataInputStream4.readFully(bArr, 0, bArr.length);
                zzna.zzb(dataInputStream4);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzIr = (SafeParcelable) creator2.createFromParcel(obtain);
                    obtain.recycle();
                    this.zzIs = false;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    obtain.recycle();
                    throw th2;
                }
            } catch (IOException e) {
                IOException iOException = e;
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Could not read from parcel file descriptor", iOException);
                throw illegalStateException2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                zzna.zzb(dataInputStream4);
                throw th4;
            }
        }
        return (SafeParcelable) this.zzIr;
    }

    /* access modifiers changed from: protected */
    public <T> ParcelFileDescriptor zzf(byte[] bArr) {
        AutoCloseOutputStream autoCloseOutputStream;
        Throwable th;
        AutoCloseOutputStream autoCloseOutputStream2;
        Thread thread;
        C01841 r13;
        byte[] bArr2 = bArr;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            AutoCloseOutputStream autoCloseOutputStream3 = autoCloseOutputStream2;
            AutoCloseOutputStream autoCloseOutputStream4 = new AutoCloseOutputStream(createPipe[1]);
            autoCloseOutputStream = autoCloseOutputStream3;
            try {
                Thread thread2 = thread;
                C01841 r8 = r13;
                final AutoCloseOutputStream autoCloseOutputStream5 = autoCloseOutputStream;
                final byte[] bArr3 = bArr2;
                C01841 r9 = new Runnable(this) {
                    final /* synthetic */ LargeParcelTeleporter zzIv;

                    {
                        OutputStream outputStream = r8;
                        byte[] bArr = r9;
                        this.zzIv = r7;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
                    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
                    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r8 = this;
                            r0 = r8
                            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x002b, all -> 0x004d }
                            r7 = r4
                            r4 = r7
                            r5 = r7
                            r6 = r0
                            java.io.OutputStream r6 = r11     // Catch:{ IOException -> 0x002b, all -> 0x004d }
                            r5.<init>(r6)     // Catch:{ IOException -> 0x002b, all -> 0x004d }
                            r1 = r4
                            r4 = r1
                            r5 = r0
                            byte[] r5 = r12     // Catch:{ IOException -> 0x0064 }
                            int r5 = r5.length     // Catch:{ IOException -> 0x0064 }
                            r4.writeInt(r5)     // Catch:{ IOException -> 0x0064 }
                            r4 = r1
                            r5 = r0
                            byte[] r5 = r12     // Catch:{ IOException -> 0x0064 }
                            r4.write(r5)     // Catch:{ IOException -> 0x0064 }
                            r4 = r1
                            if (r4 != 0) goto L_0x0026
                            r4 = r0
                            java.io.OutputStream r4 = r11
                            com.google.android.gms.internal.zzna.zzb(r4)
                        L_0x0025:
                            return
                        L_0x0026:
                            r4 = r1
                            com.google.android.gms.internal.zzna.zzb(r4)
                            goto L_0x0025
                        L_0x002b:
                            r4 = move-exception
                            r2 = r4
                            r4 = 0
                            r1 = r4
                        L_0x002f:
                            java.lang.String r4 = "Error transporting the ad response"
                            r5 = r2
                            com.google.android.gms.internal.zzin.zzb(r4, r5)     // Catch:{ all -> 0x0061 }
                            com.google.android.gms.internal.zzih r4 = com.google.android.gms.ads.internal.zzr.zzbF()     // Catch:{ all -> 0x0061 }
                            r5 = r2
                            r6 = 1
                            r4.zzb(r5, r6)     // Catch:{ all -> 0x0061 }
                            r4 = r1
                            if (r4 != 0) goto L_0x0048
                            r4 = r0
                            java.io.OutputStream r4 = r11
                            com.google.android.gms.internal.zzna.zzb(r4)
                            goto L_0x0025
                        L_0x0048:
                            r4 = r1
                            com.google.android.gms.internal.zzna.zzb(r4)
                            goto L_0x0025
                        L_0x004d:
                            r4 = move-exception
                            r3 = r4
                            r4 = 0
                            r1 = r4
                        L_0x0051:
                            r4 = r1
                            if (r4 != 0) goto L_0x005c
                            r4 = r0
                            java.io.OutputStream r4 = r11
                            com.google.android.gms.internal.zzna.zzb(r4)
                        L_0x005a:
                            r4 = r3
                            throw r4
                        L_0x005c:
                            r4 = r1
                            com.google.android.gms.internal.zzna.zzb(r4)
                            goto L_0x005a
                        L_0x0061:
                            r4 = move-exception
                            r3 = r4
                            goto L_0x0051
                        L_0x0064:
                            r4 = move-exception
                            r2 = r4
                            goto L_0x002f
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.LargeParcelTeleporter.C01841.run():void");
                    }
                };
                Thread thread3 = new Thread(r8);
                thread2.start();
                return createPipe[0];
            } catch (IOException e) {
                th = e;
                zzin.zzb("Error transporting the ad response", th);
                zzr.zzbF().zzb(th, true);
                zzna.zzb(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e2) {
            th = e2;
            autoCloseOutputStream = null;
            zzin.zzb("Error transporting the ad response", th);
            zzr.zzbF().zzb(th, true);
            zzna.zzb(autoCloseOutputStream);
            return null;
        }
    }
}

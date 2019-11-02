package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.afma.nano.NanoAfmaSignals.AFMASignals;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

public abstract class zzak implements zzaj {
    protected static GoogleApiClient zznG;
    protected long zznA = 0;
    protected long zznB = 0;
    protected long zznC = 0;
    private boolean zznD = false;
    protected DisplayMetrics zznE;
    protected zzap zznF;
    protected MotionEvent zznx;
    protected LinkedList<MotionEvent> zzny;
    protected long zznz = 0;

    protected zzak(Context context, zzap zzap) {
        LinkedList<MotionEvent> linkedList;
        DisplayMetrics displayMetrics;
        Context context2 = context;
        zzap zzap2 = zzap;
        LinkedList<MotionEvent> linkedList2 = linkedList;
        LinkedList<MotionEvent> linkedList3 = new LinkedList<>();
        this.zzny = linkedList2;
        this.zznF = zzap2;
        try {
            this.zznE = context2.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            UnsupportedOperationException unsupportedOperationException = e;
            DisplayMetrics displayMetrics2 = displayMetrics;
            DisplayMetrics displayMetrics3 = new DisplayMetrics();
            this.zznE = displayMetrics2;
            this.zznE.density = 1.0f;
        }
    }

    private String zza(Context context, String str, boolean z) {
        AFMASignals zzc;
        Context context2 = context;
        String str2 = str;
        if (z) {
            try {
                zzc = zzd(context2);
                this.zznD = true;
            } catch (NoSuchAlgorithmException e) {
                NoSuchAlgorithmException noSuchAlgorithmException = e;
                return Integer.toString(7);
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                return Integer.toString(7);
            } catch (IOException e3) {
                IOException iOException = e3;
                return Integer.toString(3);
            }
        } else {
            zzc = zzc(context2);
        }
        return (zzc == null || zzc.getSerializedSize() == 0) ? Integer.toString(5) : zza(zzc, str2);
    }

    /* access modifiers changed from: protected */
    public String zza(AFMASignals aFMASignals, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        return zza(zzsu.toByteArray(aFMASignals), str);
    }

    /* access modifiers changed from: 0000 */
    public String zza(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] array;
        zzai zzai;
        SecureRandom secureRandom;
        AFMASignals aFMASignals;
        byte[] bArr2 = bArr;
        String str2 = str;
        if (bArr2.length > 239) {
            AFMASignals aFMASignals2 = aFMASignals;
            AFMASignals aFMASignals3 = new AFMASignals();
            AFMASignals aFMASignals4 = aFMASignals2;
            aFMASignals4.psnSignal = Long.valueOf(1);
            bArr2 = zzsu.toByteArray(aFMASignals4);
        }
        if (bArr2.length < 239) {
            byte[] bArr3 = new byte[(239 - bArr2.length)];
            SecureRandom secureRandom2 = secureRandom;
            SecureRandom secureRandom3 = new SecureRandom();
            secureRandom2.nextBytes(bArr3);
            array = ByteBuffer.allocate(240).put((byte) bArr2.length).put(bArr2).put(bArr3).array();
        } else {
            array = ByteBuffer.allocate(240).put((byte) bArr2.length).put(bArr2).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(array);
        byte[] array2 = ByteBuffer.allocate(256).put(instance.digest()).put(array).array();
        byte[] bArr4 = new byte[256];
        zzai zzai2 = zzai;
        zzai zzai3 = new zzai();
        zzai2.zzb(array2, bArr4);
        if (str2 != null && str2.length() > 0) {
            zza(str2, bArr4);
        }
        return this.zznF.zza(bArr4, true);
    }

    public void zza(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (this.zznx != null) {
            this.zznx.recycle();
        }
        this.zznx = MotionEvent.obtain(0, (long) i6, 1, ((float) i4) * this.zznE.density, ((float) i5) * this.zznE.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    public void zza(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        if (this.zznD) {
            this.zznC = 0;
            this.zznB = 0;
            this.zznA = 0;
            this.zznz = 0;
            Iterator it = this.zzny.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzny.clear();
            this.zznx = null;
            this.zznD = false;
        }
        switch (motionEvent2.getAction()) {
            case 0:
                this.zznz = 1 + this.zznz;
                return;
            case 1:
                this.zznx = MotionEvent.obtain(motionEvent2);
                boolean add = this.zzny.add(this.zznx);
                if (this.zzny.size() > 6) {
                    ((MotionEvent) this.zzny.remove()).recycle();
                }
                this.zznB = 1 + this.zznB;
                return;
            case 2:
                this.zznA += (long) (1 + motionEvent2.getHistorySize());
                return;
            case 3:
                this.zznC = 1 + this.zznC;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(String str, byte[] bArr) throws UnsupportedEncodingException {
        zzsl zzsl;
        String str2 = str;
        byte[] bArr2 = bArr;
        if (str2.length() > 32) {
            str2 = str2.substring(0, 32);
        }
        zzsl zzsl2 = zzsl;
        zzsl zzsl3 = new zzsl(str2.getBytes("UTF-8"));
        zzsl2.zzC(bArr2);
    }

    public String zzb(Context context) {
        return zza(context, (String) null, false);
    }

    public String zzb(Context context, String str) {
        return zza(context, str, true);
    }

    /* access modifiers changed from: protected */
    public abstract AFMASignals zzc(Context context);

    /* access modifiers changed from: protected */
    public abstract AFMASignals zzd(Context context);

    /* access modifiers changed from: protected */
    public String zzk(String str) {
        String str2 = str;
        if (str2 != null && str2.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(str2);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            ByteBuffer putLong = wrap.putLong(fromString.getMostSignificantBits());
            ByteBuffer putLong2 = wrap.putLong(fromString.getLeastSignificantBits());
            str2 = this.zznF.zza(bArr, true);
        }
        return str2;
    }
}

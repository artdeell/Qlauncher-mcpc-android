package com.google.android.gms.internal;

public final class zzsq implements Cloneable {
    private static final zzsr zzbum;
    private int mSize;
    private boolean zzbun;
    private int[] zzbuo;
    private zzsr[] zzbup;

    static {
        zzsr zzsr;
        zzsr zzsr2 = zzsr;
        zzsr zzsr3 = new zzsr();
        zzbum = zzsr2;
    }

    zzsq() {
        this(10);
    }

    zzsq(int i) {
        int i2 = i;
        this.zzbun = false;
        int idealIntArraySize = idealIntArraySize(i2);
        this.zzbuo = new int[idealIntArraySize];
        this.zzbup = new zzsr[idealIntArraySize];
        this.mSize = 0;
    }

    /* renamed from: gc */
    private void m21gc() {
        int i = this.mSize;
        int[] iArr = this.zzbuo;
        zzsr[] zzsrArr = this.zzbup;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzsr zzsr = zzsrArr[i3];
            if (zzsr != zzbum) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzsrArr[i2] = zzsr;
                    zzsrArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbun = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int i) {
        int i2 = i;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            } else if (i2 <= -12 + (1 << i3)) {
                i2 = -12 + (1 << i3);
                break;
            } else {
                i3++;
            }
        }
        return i2;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i2 = i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr3[i3] != iArr4[i3]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzsr[] zzsrArr, zzsr[] zzsrArr2, int i) {
        zzsr[] zzsrArr3 = zzsrArr;
        zzsr[] zzsrArr4 = zzsrArr2;
        int i2 = i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (!zzsrArr3[i3].equals(zzsrArr4[i3])) {
                return false;
            }
        }
        return true;
    }

    private int zzmH(int i) {
        int i2 = i;
        int i3 = 0;
        int i4 = -1 + this.mSize;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = this.zzbuo[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i3 ^ -1;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 != this) {
            if (!(obj2 instanceof zzsq)) {
                return false;
            }
            zzsq zzsq = (zzsq) obj2;
            if (size() != zzsq.size()) {
                return false;
            }
            if (!zza(this.zzbuo, zzsq.zzbuo, this.mSize) || !zza(this.zzbup, zzsq.zzbup, this.mSize)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.zzbun) {
            m21gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (31 * ((i * 31) + this.zzbuo[i2])) + this.zzbup[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: 0000 */
    public int size() {
        if (this.zzbun) {
            m21gc();
        }
        return this.mSize;
    }

    /* renamed from: zzJq */
    public final zzsq clone() {
        zzsq zzsq;
        int size = size();
        zzsq zzsq2 = zzsq;
        zzsq zzsq3 = new zzsq(size);
        zzsq zzsq4 = zzsq2;
        System.arraycopy(this.zzbuo, 0, zzsq4.zzbuo, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzbup[i] != null) {
                zzsq4.zzbup[i] = this.zzbup[i].clone();
            }
        }
        zzsq4.mSize = size;
        return zzsq4;
    }

    /* access modifiers changed from: 0000 */
    public void zza(int i, zzsr zzsr) {
        int i2 = i;
        zzsr zzsr2 = zzsr;
        int zzmH = zzmH(i2);
        if (zzmH >= 0) {
            this.zzbup[zzmH] = zzsr2;
            return;
        }
        int i3 = zzmH ^ -1;
        if (i3 >= this.mSize || this.zzbup[i3] != zzbum) {
            if (this.zzbun && this.mSize >= this.zzbuo.length) {
                m21gc();
                i3 = -1 ^ zzmH(i2);
            }
            if (this.mSize >= this.zzbuo.length) {
                int idealIntArraySize = idealIntArraySize(1 + this.mSize);
                int[] iArr = new int[idealIntArraySize];
                zzsr[] zzsrArr = new zzsr[idealIntArraySize];
                System.arraycopy(this.zzbuo, 0, iArr, 0, this.zzbuo.length);
                System.arraycopy(this.zzbup, 0, zzsrArr, 0, this.zzbup.length);
                this.zzbuo = iArr;
                this.zzbup = zzsrArr;
            }
            if (this.mSize - i3 != 0) {
                System.arraycopy(this.zzbuo, i3, this.zzbuo, i3 + 1, this.mSize - i3);
                System.arraycopy(this.zzbup, i3, this.zzbup, i3 + 1, this.mSize - i3);
            }
            this.zzbuo[i3] = i2;
            this.zzbup[i3] = zzsr2;
            this.mSize = 1 + this.mSize;
            return;
        }
        this.zzbuo[i3] = i2;
        this.zzbup[i3] = zzsr2;
    }

    /* access modifiers changed from: 0000 */
    public zzsr zzmF(int i) {
        int zzmH = zzmH(i);
        if (zzmH < 0 || this.zzbup[zzmH] == zzbum) {
            return null;
        }
        return this.zzbup[zzmH];
    }

    /* access modifiers changed from: 0000 */
    public zzsr zzmG(int i) {
        int i2 = i;
        if (this.zzbun) {
            m21gc();
        }
        return this.zzbup[i2];
    }
}

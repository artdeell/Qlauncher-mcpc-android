package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzsr implements Cloneable {
    private zzsp<?, ?> zzbuq;
    private Object zzbur;
    private List<zzsw> zzbus;

    zzsr() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.zzbus = arrayList2;
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzz()];
        writeTo(zzsn.zzE(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        boolean z;
        IllegalStateException illegalStateException;
        Object obj2 = obj;
        if (obj2 == this) {
            z = true;
        } else {
            z = false;
            if (obj2 instanceof zzsr) {
                zzsr zzsr = (zzsr) obj2;
                if (this.zzbur != null && zzsr.zzbur != null) {
                    z = false;
                    if (this.zzbuq == zzsr.zzbuq) {
                        return !this.zzbuq.zzbuk.isArray() ? this.zzbur.equals(zzsr.zzbur) : this.zzbur instanceof byte[] ? Arrays.equals((byte[]) this.zzbur, (byte[]) zzsr.zzbur) : this.zzbur instanceof int[] ? Arrays.equals((int[]) this.zzbur, (int[]) zzsr.zzbur) : this.zzbur instanceof long[] ? Arrays.equals((long[]) this.zzbur, (long[]) zzsr.zzbur) : this.zzbur instanceof float[] ? Arrays.equals((float[]) this.zzbur, (float[]) zzsr.zzbur) : this.zzbur instanceof double[] ? Arrays.equals((double[]) this.zzbur, (double[]) zzsr.zzbur) : this.zzbur instanceof boolean[] ? Arrays.equals((boolean[]) this.zzbur, (boolean[]) zzsr.zzbur) : Arrays.deepEquals((Object[]) this.zzbur, (Object[]) zzsr.zzbur);
                    }
                } else if (this.zzbus != null && zzsr.zzbus != null) {
                    return this.zzbus.equals(zzsr.zzbus);
                } else {
                    try {
                        return Arrays.equals(toByteArray(), zzsr.toByteArray());
                    } catch (IOException e) {
                        IOException iOException = e;
                        IllegalStateException illegalStateException2 = illegalStateException;
                        IllegalStateException illegalStateException3 = new IllegalStateException(iOException);
                        throw illegalStateException2;
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        IllegalStateException illegalStateException;
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            IOException iOException = e;
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(iOException);
            throw illegalStateException2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void writeTo(zzsn zzsn) throws IOException {
        zzsn zzsn2 = zzsn;
        if (this.zzbur != null) {
            this.zzbuq.zza(this.zzbur, zzsn2);
            return;
        }
        for (zzsw writeTo : this.zzbus) {
            writeTo.writeTo(zzsn2);
        }
    }

    /* renamed from: zzJr */
    public final zzsr clone() {
        zzsr zzsr;
        AssertionError assertionError;
        zzsr zzsr2 = zzsr;
        zzsr zzsr3 = new zzsr();
        zzsr zzsr4 = zzsr2;
        try {
            zzsr4.zzbuq = this.zzbuq;
            if (this.zzbus == null) {
                zzsr4.zzbus = null;
            } else {
                boolean addAll = zzsr4.zzbus.addAll(this.zzbus);
            }
            if (this.zzbur == null) {
                return zzsr4;
            }
            if (this.zzbur instanceof zzsu) {
                zzsr4.zzbur = ((zzsu) this.zzbur).clone();
                return zzsr4;
            } else if (this.zzbur instanceof byte[]) {
                zzsr4.zzbur = ((byte[]) this.zzbur).clone();
                return zzsr4;
            } else {
                if (this.zzbur instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzbur;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzsr4.zzbur = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.zzbur instanceof boolean[]) {
                    zzsr4.zzbur = ((boolean[]) this.zzbur).clone();
                    return zzsr4;
                } else if (this.zzbur instanceof int[]) {
                    zzsr4.zzbur = ((int[]) this.zzbur).clone();
                    return zzsr4;
                } else if (this.zzbur instanceof long[]) {
                    zzsr4.zzbur = ((long[]) this.zzbur).clone();
                    return zzsr4;
                } else if (this.zzbur instanceof float[]) {
                    zzsr4.zzbur = ((float[]) this.zzbur).clone();
                    return zzsr4;
                } else if (this.zzbur instanceof double[]) {
                    zzsr4.zzbur = ((double[]) this.zzbur).clone();
                    return zzsr4;
                } else if (this.zzbur instanceof zzsu[]) {
                    zzsu[] zzsuArr = (zzsu[]) this.zzbur;
                    zzsu[] zzsuArr2 = new zzsu[zzsuArr.length];
                    zzsr4.zzbur = zzsuArr2;
                    for (int i2 = 0; i2 < zzsuArr.length; i2++) {
                        zzsuArr2[i2] = zzsuArr[i2].clone();
                    }
                }
                return zzsr4;
            }
        } catch (CloneNotSupportedException e) {
            CloneNotSupportedException cloneNotSupportedException = e;
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError(cloneNotSupportedException);
            throw assertionError2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzsw zzsw) {
        zzsw zzsw2 = zzsw;
        boolean add = this.zzbus.add(zzsw2);
    }

    /* access modifiers changed from: 0000 */
    public <T> T zzb(zzsp<?, T> zzsp) {
        IllegalStateException illegalStateException;
        zzsp<?, T> zzsp2 = zzsp;
        if (this.zzbur == null) {
            this.zzbuq = zzsp2;
            this.zzbur = zzsp2.zzJ(this.zzbus);
            this.zzbus = null;
        } else if (this.zzbuq != zzsp2) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Tried to getExtension with a differernt Extension.");
            throw illegalStateException2;
        }
        return this.zzbur;
    }

    /* access modifiers changed from: 0000 */
    public int zzz() {
        int i;
        if (this.zzbur == null) {
            Iterator it = this.zzbus.iterator();
            int i2 = 0;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = i + ((zzsw) it.next()).zzz();
            }
        } else {
            i = this.zzbuq.zzY(this.zzbur);
        }
        return i;
    }
}

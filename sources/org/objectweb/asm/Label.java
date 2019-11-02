package org.objectweb.asm;

public class Label {

    /* renamed from: a */
    int f365a;

    /* renamed from: b */
    int f366b;

    /* renamed from: c */
    int f367c;

    /* renamed from: d */
    private int f368d;

    /* renamed from: e */
    private int[] f369e;

    /* renamed from: f */
    int f370f;

    /* renamed from: g */
    int f371g;

    /* renamed from: h */
    Frame f372h;

    /* renamed from: i */
    Label f373i;
    public Object info;

    /* renamed from: j */
    Edge f374j;

    /* renamed from: k */
    Label f375k;

    public Label() {
    }

    /* renamed from: a */
    private void m121a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.f369e == null) {
            this.f369e = new int[6];
        }
        if (this.f368d >= this.f369e.length) {
            int[] iArr = new int[(6 + this.f369e.length)];
            System.arraycopy(this.f369e, 0, iArr, 0, this.f369e.length);
            this.f369e = iArr;
        }
        int[] iArr2 = this.f369e;
        int i5 = this.f368d;
        this.f368d = i5 + 1;
        iArr2[i5] = i3;
        int[] iArr3 = this.f369e;
        int i6 = this.f368d;
        this.f368d = i6 + 1;
        iArr3[i6] = i4;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Label mo11188a() {
        if (this.f372h != null) {
            return this.f372h.f338b;
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11189a(long j, int i) {
        long j2 = j;
        int i2 = i;
        if ((1024 & this.f365a) == 0) {
            this.f365a = 1024 | this.f365a;
            this.f369e = new int[(1 + ((i2 - 1) / 32))];
        }
        int[] iArr = this.f369e;
        int i3 = (int) (j2 >>> 32);
        iArr[i3] = iArr[i3] | ((int) j2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo11190a(MethodWriter methodWriter, ByteVector byteVector, int i, boolean z) {
        MethodWriter methodWriter2 = methodWriter;
        ByteVector byteVector2 = byteVector;
        int i2 = i;
        boolean z2 = z;
        if ((2 & this.f365a) == 0) {
            if (z2) {
                m121a(-1 - i2, byteVector2.f280b);
                ByteVector putInt = byteVector2.putInt(-1);
                return;
            }
            m121a(i2, byteVector2.f280b);
            ByteVector putShort = byteVector2.putShort(-1);
        } else if (z2) {
            ByteVector putInt2 = byteVector2.putInt(this.f367c - i2);
        } else {
            ByteVector putShort2 = byteVector2.putShort(this.f367c - i2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo11191a(long j) {
        long j2 = j;
        boolean z = false;
        if ((1024 & this.f365a) != 0) {
            z = false;
            if ((this.f369e[(int) (j2 >>> 32)] & ((int) j2)) != 0) {
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo11192a(Label label) {
        Label label2 = label;
        if (!((1024 & this.f365a) == 0 || (1024 & label2.f365a) == 0)) {
            for (int i = 0; i < this.f369e.length; i++) {
                if ((this.f369e[i] & label2.f369e[i]) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo11193a(MethodWriter methodWriter, int i, byte[] bArr) {
        MethodWriter methodWriter2 = methodWriter;
        int i2 = i;
        byte[] bArr2 = bArr;
        int i3 = 0;
        this.f365a = 2 | this.f365a;
        this.f367c = i2;
        boolean z = false;
        while (i3 < this.f368d) {
            int i4 = i3 + 1;
            int i5 = this.f369e[i3];
            i3 = i4 + 1;
            int i6 = this.f369e[i4];
            if (i5 >= 0) {
                int i7 = i2 - i5;
                if (i7 < -32768 || i7 > 32767) {
                    byte b = 255 & bArr2[i6 - 1];
                    if (b <= 168) {
                        bArr2[i6 - 1] = (byte) (b + 49);
                    } else {
                        bArr2[i6 - 1] = (byte) (b + 20);
                    }
                    z = true;
                }
                int i8 = i6 + 1;
                bArr2[i6] = (byte) (i7 >>> 8);
                bArr2[i8] = (byte) i7;
            } else {
                int i9 = 1 + i5 + i2;
                int i10 = i6 + 1;
                bArr2[i6] = (byte) (i9 >>> 24);
                int i11 = i10 + 1;
                bArr2[i10] = (byte) (i9 >>> 16);
                int i12 = i11 + 1;
                bArr2[i11] = (byte) (i9 >>> 8);
                bArr2[i12] = (byte) i9;
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo11194b(Label label, long j, int i) {
        Edge edge;
        Label label2 = this;
        Label label3 = label;
        long j2 = j;
        int i2 = i;
        while (label2 != null) {
            Label label4 = label2.f375k;
            label2.f375k = null;
            if (label3 != null) {
                if ((2048 & label2.f365a) != 0) {
                    label2 = label4;
                } else {
                    label2.f365a = 2048 | label2.f365a;
                    if ((256 & label2.f365a) != 0 && !label2.mo11192a(label3)) {
                        Edge edge2 = edge;
                        Edge edge3 = new Edge();
                        Edge edge4 = edge2;
                        edge4.f324a = label2.f370f;
                        edge4.f325b = label3.f374j.f325b;
                        edge4.f326c = label2.f374j;
                        label2.f374j = edge4;
                    }
                }
            } else if (label2.mo11191a(j2)) {
                label2 = label4;
            } else {
                label2.mo11189a(j2, i2);
            }
            Label label5 = label4;
            Edge edge5 = label2.f374j;
            while (true) {
                Edge edge6 = edge5;
                if (edge6 == null) {
                    break;
                }
                if (((128 & label2.f365a) == 0 || edge6 != label2.f374j.f326c) && edge6.f325b.f375k == null) {
                    edge6.f325b.f375k = label5;
                    label5 = edge6.f325b;
                }
                edge5 = edge6.f326c;
            }
            label2 = label5;
        }
    }

    public int getOffset() {
        IllegalStateException illegalStateException;
        if ((2 & this.f365a) != 0) {
            return this.f367c;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Label offset position has not been resolved yet");
        throw illegalStateException2;
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("L").append(System.identityHashCode(this)).toString();
    }
}

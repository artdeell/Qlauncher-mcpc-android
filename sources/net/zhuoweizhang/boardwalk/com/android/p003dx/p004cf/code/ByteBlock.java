package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.LabeledItem;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ByteBlock */
public final class ByteBlock implements LabeledItem {
    private final ByteCatchList catches;
    private final int end;
    private final int label;
    private final int start;
    private final IntList successors;

    public ByteBlock(int i, int i2, int i3, IntList intList, ByteCatchList byteCatchList) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        NullPointerException nullPointerException2;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntList intList2 = intList;
        ByteCatchList byteCatchList2 = byteCatchList;
        if (i4 < 0) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException4;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("label < 0");
            throw illegalArgumentException5;
        } else if (i5 < 0) {
            IllegalArgumentException illegalArgumentException7 = illegalArgumentException3;
            IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("start < 0");
            throw illegalArgumentException7;
        } else if (i6 <= i5) {
            IllegalArgumentException illegalArgumentException9 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("end <= start");
            throw illegalArgumentException9;
        } else if (intList2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("targets == null");
            throw nullPointerException3;
        } else {
            int size = intList2.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (intList2.get(i7) < 0) {
                    IllegalArgumentException illegalArgumentException11 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException(sb2.append("successors[").append(i7).append("] == ").append(intList2.get(i7)).toString());
                    throw illegalArgumentException11;
                }
            }
            if (byteCatchList2 == null) {
                NullPointerException nullPointerException5 = nullPointerException;
                NullPointerException nullPointerException6 = new NullPointerException("catches == null");
                throw nullPointerException5;
            }
            this.label = i4;
            this.start = i5;
            this.end = i6;
            this.successors = intList2;
            this.catches = byteCatchList2;
        }
    }

    public ByteCatchList getCatches() {
        return this.catches;
    }

    public int getEnd() {
        return this.end;
    }

    public int getLabel() {
        return this.label;
    }

    public int getStart() {
        return this.start;
    }

    public IntList getSuccessors() {
        return this.successors;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append('{').append(Hex.m51u2(this.label)).append(": ").append(Hex.m51u2(this.start)).append("..").append(Hex.m51u2(this.end)).append('}').toString();
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.LabeledList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.ByteBlockList */
public final class ByteBlockList extends LabeledList {
    public ByteBlockList(int i) {
        super(i);
    }

    public ByteBlock get(int i) {
        return (ByteBlock) get0(i);
    }

    public ByteBlock labelToBlock(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2 = i;
        int indexOfLabel = indexOfLabel(i2);
        if (indexOfLabel >= 0) {
            return get(indexOfLabel);
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("no such label: ").append(Hex.m51u2(i2)).toString());
        throw illegalArgumentException2;
    }

    public void set(int i, ByteBlock byteBlock) {
        super.set(i, byteBlock);
    }
}

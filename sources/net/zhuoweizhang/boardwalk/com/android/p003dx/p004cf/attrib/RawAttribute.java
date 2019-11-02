package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.RawAttribute */
public final class RawAttribute extends BaseAttribute {
    private final ByteArray data;
    private final ConstantPool pool;

    public RawAttribute(String str, ByteArray byteArray, int i, int i2, ConstantPool constantPool) {
        int i3 = i;
        this(str, byteArray.slice(i3, i3 + i2), constantPool);
    }

    public RawAttribute(String str, ByteArray byteArray, ConstantPool constantPool) {
        NullPointerException nullPointerException;
        ByteArray byteArray2 = byteArray;
        ConstantPool constantPool2 = constantPool;
        super(str);
        if (byteArray2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("data == null");
            throw nullPointerException2;
        }
        this.data = byteArray2;
        this.pool = constantPool2;
    }

    public int byteLength() {
        return 6 + this.data.size();
    }

    public ByteArray getData() {
        return this.data;
    }

    public ConstantPool getPool() {
        return this.pool;
    }
}

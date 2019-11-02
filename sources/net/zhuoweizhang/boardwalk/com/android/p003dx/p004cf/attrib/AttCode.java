package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteCatchList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.attrib.AttCode */
public final class AttCode extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Code";
    private final AttributeList attributes;
    private final ByteCatchList catches;
    private final BytecodeArray code;
    private final int maxLocals;
    private final int maxStack;

    public AttCode(int i, int i2, BytecodeArray bytecodeArray, ByteCatchList byteCatchList, AttributeList attributeList) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        MutabilityException mutabilityException;
        MutabilityException mutabilityException2;
        NullPointerException nullPointerException3;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        int i3 = i;
        int i4 = i2;
        BytecodeArray bytecodeArray2 = bytecodeArray;
        ByteCatchList byteCatchList2 = byteCatchList;
        AttributeList attributeList2 = attributeList;
        super(ATTRIBUTE_NAME);
        if (i3 < 0) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("maxStack < 0");
            throw illegalArgumentException3;
        } else if (i4 < 0) {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("maxLocals < 0");
            throw illegalArgumentException5;
        } else if (bytecodeArray2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("code == null");
            throw nullPointerException4;
        } else {
            try {
                if (byteCatchList2.isMutable()) {
                    MutabilityException mutabilityException3 = mutabilityException2;
                    MutabilityException mutabilityException4 = new MutabilityException("catches.isMutable()");
                    throw mutabilityException3;
                }
                try {
                    if (attributeList2.isMutable()) {
                        MutabilityException mutabilityException5 = mutabilityException;
                        MutabilityException mutabilityException6 = new MutabilityException("attributes.isMutable()");
                        throw mutabilityException5;
                    }
                    this.maxStack = i3;
                    this.maxLocals = i4;
                    this.code = bytecodeArray2;
                    this.catches = byteCatchList2;
                    this.attributes = attributeList2;
                } catch (NullPointerException e) {
                    NullPointerException nullPointerException6 = e;
                    NullPointerException nullPointerException7 = nullPointerException2;
                    NullPointerException nullPointerException8 = new NullPointerException("attributes == null");
                    throw nullPointerException7;
                }
            } catch (NullPointerException e2) {
                NullPointerException nullPointerException9 = e2;
                NullPointerException nullPointerException10 = nullPointerException;
                NullPointerException nullPointerException11 = new NullPointerException("catches == null");
                throw nullPointerException10;
            }
        }
    }

    public int byteLength() {
        return 10 + this.code.byteLength() + this.catches.byteLength() + this.attributes.byteLength();
    }

    public AttributeList getAttributes() {
        return this.attributes;
    }

    public ByteCatchList getCatches() {
        return this.catches;
    }

    public BytecodeArray getCode() {
        return this.code;
    }

    public int getMaxLocals() {
        return this.maxLocals;
    }

    public int getMaxStack() {
        return this.maxStack;
    }
}

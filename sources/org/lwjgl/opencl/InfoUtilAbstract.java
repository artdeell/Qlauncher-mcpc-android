package org.lwjgl.opencl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLObject;

abstract class InfoUtilAbstract<T extends CLObject> implements InfoUtil<T> {
    protected InfoUtilAbstract() {
    }

    /* access modifiers changed from: protected */
    public abstract int getInfo(T t, int i, ByteBuffer byteBuffer, PointerBuffer pointerBuffer);

    public int getInfoInt(T t, int i) {
        T t2 = t;
        int i2 = i;
        t2.checkValid();
        ByteBuffer bufferByte = APIUtil.getBufferByte(4);
        int info = getInfo(t2, i2, bufferByte, null);
        return bufferByte.getInt(0);
    }

    public long getInfoLong(T t, int i) {
        T t2 = t;
        int i2 = i;
        t2.checkValid();
        ByteBuffer bufferByte = APIUtil.getBufferByte(8);
        int info = getInfo(t2, i2, bufferByte, null);
        return bufferByte.getLong(0);
    }

    public long getInfoSize(T t, int i) {
        T t2 = t;
        int i2 = i;
        t2.checkValid();
        PointerBuffer bufferPointer = APIUtil.getBufferPointer();
        int info = getInfo(t2, i2, bufferPointer.getBuffer(), null);
        return bufferPointer.get(0);
    }

    public long[] getInfoSizeArray(T t, int i) {
        T t2 = t;
        int i2 = i;
        t2.checkValid();
        int infoSizeArraySize = getInfoSizeArraySize(t2, i2);
        PointerBuffer bufferPointer = APIUtil.getBufferPointer(infoSizeArraySize);
        int info = getInfo(t2, i2, bufferPointer.getBuffer(), null);
        long[] jArr = new long[infoSizeArraySize];
        for (int i3 = 0; i3 < infoSizeArraySize; i3++) {
            jArr[i3] = bufferPointer.get(i3);
        }
        return jArr;
    }

    /* access modifiers changed from: protected */
    public int getInfoSizeArraySize(T t, int i) {
        UnsupportedOperationException unsupportedOperationException;
        T t2 = t;
        int i2 = i;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
    }

    public String getInfoString(T t, int i) {
        T t2 = t;
        int i2 = i;
        t2.checkValid();
        int sizeRet = getSizeRet(t2, i2);
        if (sizeRet <= 1) {
            return null;
        }
        ByteBuffer bufferByte = APIUtil.getBufferByte(sizeRet);
        int info = getInfo(t2, i2, bufferByte, null);
        Buffer limit = bufferByte.limit(sizeRet - 1);
        return APIUtil.getString(bufferByte);
    }

    /* access modifiers changed from: protected */
    public final int getSizeRet(T t, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        T t2 = t;
        int i2 = i;
        PointerBuffer bufferPointer = APIUtil.getBufferPointer();
        if (getInfo(t2, i2, null, bufferPointer) == 0) {
            return (int) bufferPointer.get(0);
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Invalid parameter specified: ").append(LWJGLUtil.toHexString(i2)).toString());
        throw illegalArgumentException2;
    }

    /* access modifiers changed from: protected */
    public PointerBuffer getSizesBuffer(T t, int i) {
        T t2 = t;
        int i2 = i;
        int infoSizeArraySize = getInfoSizeArraySize(t2, i2);
        PointerBuffer bufferPointer = APIUtil.getBufferPointer(infoSizeArraySize);
        PointerBuffer limit = bufferPointer.limit(infoSizeArraySize);
        int info = getInfo(t2, i2, bufferPointer.getBuffer(), null);
        return bufferPointer;
    }
}

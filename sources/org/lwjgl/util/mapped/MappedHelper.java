package org.lwjgl.util.mapped;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public class MappedHelper {
    public MappedHelper() {
    }

    public static long aget(long j) {
        return MappedObjectUnsafe.INSTANCE.getAddress(j);
    }

    public static long aget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getAddress(mappedObject.viewAddress + ((long) i));
    }

    public static void aput(long j, long j2) {
        long j3 = j2;
        MappedObjectUnsafe.INSTANCE.putAddress(j3, j);
    }

    public static void aput(MappedObject mappedObject, long j, int i) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putAddress(mappedObject.viewAddress + ((long) i), j2);
    }

    public static byte bget(long j) {
        return MappedObjectUnsafe.INSTANCE.getByte(j);
    }

    public static byte bget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getByte(mappedObject.viewAddress + ((long) i));
    }

    public static void bput(byte b, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putByte(j2, b);
    }

    public static void bput(MappedObject mappedObject, byte b, int i) {
        byte b2 = b;
        MappedObjectUnsafe.INSTANCE.putByte(mappedObject.viewAddress + ((long) i), b2);
    }

    public static byte bvget(long j) {
        return MappedObjectUnsafe.INSTANCE.getByteVolatile(null, j);
    }

    public static byte bvget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getByteVolatile(null, mappedObject.viewAddress + ((long) i));
    }

    public static void bvput(byte b, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putByteVolatile(null, j2, b);
    }

    public static void bvput(MappedObject mappedObject, byte b, int i) {
        byte b2 = b;
        MappedObjectUnsafe.INSTANCE.putByteVolatile(null, mappedObject.viewAddress + ((long) i), b2);
    }

    public static char cget(long j) {
        return MappedObjectUnsafe.INSTANCE.getChar(j);
    }

    public static char cget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getChar(mappedObject.viewAddress + ((long) i));
    }

    public static void checkAddress(long j, MappedObject mappedObject) {
        mappedObject.checkAddress(j);
    }

    public static void copy(MappedObject mappedObject, MappedObject mappedObject2, int i) {
        MappedObject mappedObject3 = mappedObject;
        MappedObject mappedObject4 = mappedObject2;
        int i2 = i;
        if (MappedObject.CHECKS) {
            mappedObject3.checkRange(i2);
            mappedObject4.checkRange(i2);
        }
        MappedObjectUnsafe.INSTANCE.copyMemory(mappedObject3.viewAddress, mappedObject4.viewAddress, (long) i2);
    }

    public static void cput(char c, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putChar(j2, c);
    }

    public static void cput(MappedObject mappedObject, char c, int i) {
        char c2 = c;
        MappedObjectUnsafe.INSTANCE.putChar(mappedObject.viewAddress + ((long) i), c2);
    }

    public static char cvget(long j) {
        return MappedObjectUnsafe.INSTANCE.getCharVolatile(null, j);
    }

    public static char cvget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getCharVolatile(null, mappedObject.viewAddress + ((long) i));
    }

    public static void cvput(char c, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putCharVolatile(null, j2, c);
    }

    public static void cvput(MappedObject mappedObject, char c, int i) {
        char c2 = c;
        MappedObjectUnsafe.INSTANCE.putCharVolatile(null, mappedObject.viewAddress + ((long) i), c2);
    }

    public static double dget(long j) {
        return MappedObjectUnsafe.INSTANCE.getDouble(j);
    }

    public static double dget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getDouble(mappedObject.viewAddress + ((long) i));
    }

    public static void dput(double d, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putDouble(j2, d);
    }

    public static void dput(MappedObject mappedObject, double d, int i) {
        double d2 = d;
        MappedObjectUnsafe.INSTANCE.putDouble(mappedObject.viewAddress + ((long) i), d2);
    }

    public static MappedObject dup(MappedObject mappedObject, MappedObject mappedObject2) {
        MappedObject mappedObject3 = mappedObject;
        MappedObject mappedObject4 = mappedObject2;
        mappedObject4.baseAddress = mappedObject3.baseAddress;
        mappedObject4.viewAddress = mappedObject3.viewAddress;
        mappedObject4.preventGC = mappedObject3.preventGC;
        return mappedObject4;
    }

    public static double dvget(long j) {
        return MappedObjectUnsafe.INSTANCE.getDoubleVolatile(null, j);
    }

    public static double dvget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getDoubleVolatile(null, mappedObject.viewAddress + ((long) i));
    }

    public static void dvput(double d, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putDoubleVolatile(null, j2, d);
    }

    public static void dvput(MappedObject mappedObject, double d, int i) {
        double d2 = d;
        MappedObjectUnsafe.INSTANCE.putDoubleVolatile(null, mappedObject.viewAddress + ((long) i), d2);
    }

    public static float fget(long j) {
        return MappedObjectUnsafe.INSTANCE.getFloat(j);
    }

    public static float fget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getFloat(mappedObject.viewAddress + ((long) i));
    }

    public static void fput(float f, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putFloat(j2, f);
    }

    public static void fput(MappedObject mappedObject, float f, int i) {
        float f2 = f;
        MappedObjectUnsafe.INSTANCE.putFloat(mappedObject.viewAddress + ((long) i), f2);
    }

    public static float fvget(long j) {
        return MappedObjectUnsafe.INSTANCE.getFloatVolatile(null, j);
    }

    public static float fvget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getFloatVolatile(null, mappedObject.viewAddress + ((long) i));
    }

    public static void fvput(float f, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putFloatVolatile(null, j2, f);
    }

    public static void fvput(MappedObject mappedObject, float f, int i) {
        float f2 = f;
        MappedObjectUnsafe.INSTANCE.putFloatVolatile(null, mappedObject.viewAddress + ((long) i), f2);
    }

    public static int get_view(MappedObject mappedObject, int i) {
        MappedObject mappedObject2 = mappedObject;
        return ((int) (mappedObject2.viewAddress - mappedObject2.baseAddress)) / i;
    }

    public static int get_view_shift(MappedObject mappedObject, int i) {
        MappedObject mappedObject2 = mappedObject;
        return ((int) (mappedObject2.viewAddress - mappedObject2.baseAddress)) >> i;
    }

    public static int iget(long j) {
        return MappedObjectUnsafe.INSTANCE.getInt(j);
    }

    public static int iget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getInt(mappedObject.viewAddress + ((long) i));
    }

    public static void iput(int i, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putInt(j2, i);
    }

    public static void iput(MappedObject mappedObject, int i, int i2) {
        int i3 = i;
        MappedObjectUnsafe.INSTANCE.putInt(mappedObject.viewAddress + ((long) i2), i3);
    }

    public static int ivget(long j) {
        return MappedObjectUnsafe.INSTANCE.getIntVolatile(null, j);
    }

    public static int ivget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getIntVolatile(null, mappedObject.viewAddress + ((long) i));
    }

    public static void ivput(int i, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putIntVolatile(null, j2, i);
    }

    public static void ivput(MappedObject mappedObject, int i, int i2) {
        int i3 = i;
        MappedObjectUnsafe.INSTANCE.putIntVolatile(null, mappedObject.viewAddress + ((long) i2), i3);
    }

    public static long jget(long j) {
        return MappedObjectUnsafe.INSTANCE.getLong(j);
    }

    public static long jget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getLong(mappedObject.viewAddress + ((long) i));
    }

    public static void jput(long j, long j2) {
        long j3 = j2;
        MappedObjectUnsafe.INSTANCE.putLong(j3, j);
    }

    public static void jput(MappedObject mappedObject, long j, int i) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putLong(mappedObject.viewAddress + ((long) i), j2);
    }

    public static long jvget(long j) {
        return MappedObjectUnsafe.INSTANCE.getLongVolatile(null, j);
    }

    public static long jvget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getLongVolatile(null, mappedObject.viewAddress + ((long) i));
    }

    public static void jvput(long j, long j2) {
        long j3 = j2;
        MappedObjectUnsafe.INSTANCE.putLongVolatile(null, j3, j);
    }

    public static void jvput(MappedObject mappedObject, long j, int i) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putLongVolatile(null, mappedObject.viewAddress + ((long) i), j2);
    }

    public static ByteBuffer newBuffer(long j, int i) {
        return MappedObjectUnsafe.newBuffer(j, i);
    }

    public static void put_view(MappedObject mappedObject, int i, int i2) {
        MappedObject mappedObject2 = mappedObject;
        mappedObject2.setViewAddress(mappedObject2.baseAddress + ((long) (i * i2)));
    }

    public static void put_view_next(MappedObject mappedObject, int i) {
        MappedObject mappedObject2 = mappedObject;
        mappedObject2.setViewAddress(mappedObject2.viewAddress + ((long) i));
    }

    public static void put_view_shift(MappedObject mappedObject, int i, int i2) {
        MappedObject mappedObject2 = mappedObject;
        mappedObject2.setViewAddress(mappedObject2.baseAddress + ((long) (i << i2)));
    }

    public static void put_views(MappedSet2 mappedSet2, int i) {
        mappedSet2.view(i);
    }

    public static void put_views(MappedSet3 mappedSet3, int i) {
        mappedSet3.view(i);
    }

    public static void put_views(MappedSet4 mappedSet4, int i) {
        mappedSet4.view(i);
    }

    public static void setup(MappedObject mappedObject, ByteBuffer byteBuffer, int i, int i2) {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        IllegalStateException illegalStateException2;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalStateException illegalStateException3;
        MappedObject mappedObject2 = mappedObject;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i3 = i;
        int i4 = i2;
        if (LWJGLUtil.CHECKS && mappedObject2.baseAddress != 0) {
            IllegalStateException illegalStateException4 = illegalStateException3;
            IllegalStateException illegalStateException5 = new IllegalStateException("this method should not be called by user-code");
            throw illegalStateException4;
        } else if (!LWJGLUtil.CHECKS || byteBuffer2.isDirect()) {
            mappedObject2.preventGC = byteBuffer2;
            if (LWJGLUtil.CHECKS && i3 <= 0) {
                IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("invalid alignment");
                throw illegalArgumentException3;
            } else if (!LWJGLUtil.CHECKS || (i4 > 0 && i4 % i3 == 0)) {
                long address = MemoryUtil.getAddress(byteBuffer2);
                if (!LWJGLUtil.CHECKS || address % ((long) i3) == 0) {
                    mappedObject2.viewAddress = address;
                    mappedObject2.baseAddress = address;
                    return;
                }
                IllegalStateException illegalStateException6 = illegalStateException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalStateException illegalStateException7 = new IllegalStateException(sb2.append("buffer address not aligned on ").append(i3).append(" bytes").toString());
                throw illegalStateException6;
            } else {
                IllegalStateException illegalStateException8 = illegalStateException2;
                IllegalStateException illegalStateException9 = new IllegalStateException("sizeof not a multiple of alignment");
                throw illegalStateException8;
            }
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("bytebuffer must be direct");
            throw illegalArgumentException5;
        }
    }

    public static short sget(long j) {
        return MappedObjectUnsafe.INSTANCE.getShort(j);
    }

    public static short sget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getShort(mappedObject.viewAddress + ((long) i));
    }

    public static MappedObject slice(MappedObject mappedObject, MappedObject mappedObject2) {
        MappedObject mappedObject3 = mappedObject;
        MappedObject mappedObject4 = mappedObject2;
        mappedObject4.baseAddress = mappedObject3.viewAddress;
        mappedObject4.viewAddress = mappedObject3.viewAddress;
        mappedObject4.preventGC = mappedObject3.preventGC;
        return mappedObject4;
    }

    public static void sput(MappedObject mappedObject, short s, int i) {
        short s2 = s;
        MappedObjectUnsafe.INSTANCE.putShort(mappedObject.viewAddress + ((long) i), s2);
    }

    public static void sput(short s, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putShort(j2, s);
    }

    public static short svget(long j) {
        return MappedObjectUnsafe.INSTANCE.getShortVolatile(null, j);
    }

    public static short svget(MappedObject mappedObject, int i) {
        return MappedObjectUnsafe.INSTANCE.getShortVolatile(null, mappedObject.viewAddress + ((long) i));
    }

    public static void svput(MappedObject mappedObject, short s, int i) {
        short s2 = s;
        MappedObjectUnsafe.INSTANCE.putShortVolatile(null, mappedObject.viewAddress + ((long) i), s2);
    }

    public static void svput(short s, long j) {
        long j2 = j;
        MappedObjectUnsafe.INSTANCE.putShortVolatile(null, j2, s);
    }
}

package org.lwjgl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class BufferChecks {
    private BufferChecks() {
    }

    public static void checkArray(long[] jArr, int i) {
        long[] jArr2 = jArr;
        int i2 = i;
        if (LWJGLUtil.CHECKS && jArr2.length < i2) {
            throwArraySizeException(jArr2, i2);
        }
    }

    public static void checkArray(Object[] objArr) {
        IllegalArgumentException illegalArgumentException;
        Object[] objArr2 = objArr;
        if (!LWJGLUtil.CHECKS) {
            return;
        }
        if (objArr2 == null || objArr2.length == 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid array");
            throw illegalArgumentException2;
        }
    }

    public static void checkArray(Object[] objArr, int i) {
        Object[] objArr2 = objArr;
        int i2 = i;
        if (LWJGLUtil.CHECKS && objArr2.length < i2) {
            throwArraySizeException(objArr2, i2);
        }
    }

    public static int checkBuffer(Buffer buffer, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        int i2;
        Buffer buffer2 = buffer;
        int i3 = i;
        if (buffer2 instanceof ByteBuffer) {
            checkBuffer((ByteBuffer) buffer2, i3);
            i2 = 0;
        } else if (buffer2 instanceof ShortBuffer) {
            checkBuffer((ShortBuffer) buffer2, i3);
            i2 = 1;
        } else if (buffer2 instanceof IntBuffer) {
            checkBuffer((IntBuffer) buffer2, i3);
            i2 = 2;
        } else if (buffer2 instanceof LongBuffer) {
            checkBuffer((LongBuffer) buffer2, i3);
            i2 = 4;
        } else if (buffer2 instanceof FloatBuffer) {
            checkBuffer((FloatBuffer) buffer2, i3);
            i2 = 2;
        } else if (buffer2 instanceof DoubleBuffer) {
            checkBuffer((DoubleBuffer) buffer2, i3);
            i2 = 4;
        } else {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unsupported Buffer type specified: ").append(buffer2.getClass()).toString());
            throw illegalArgumentException2;
        }
        return buffer2.position() << i2;
    }

    public static void checkBuffer(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS) {
            checkBufferSize(byteBuffer2, i2);
            checkDirect(byteBuffer2);
        }
    }

    public static void checkBuffer(DoubleBuffer doubleBuffer, int i) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS) {
            checkBufferSize(doubleBuffer2, i2);
            checkDirect(doubleBuffer2);
        }
    }

    public static void checkBuffer(FloatBuffer floatBuffer, int i) {
        FloatBuffer floatBuffer2 = floatBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS) {
            checkBufferSize(floatBuffer2, i2);
            checkDirect(floatBuffer2);
        }
    }

    public static void checkBuffer(IntBuffer intBuffer, int i) {
        IntBuffer intBuffer2 = intBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS) {
            checkBufferSize(intBuffer2, i2);
            checkDirect(intBuffer2);
        }
    }

    public static void checkBuffer(LongBuffer longBuffer, int i) {
        LongBuffer longBuffer2 = longBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS) {
            checkBufferSize(longBuffer2, i2);
            checkDirect(longBuffer2);
        }
    }

    public static void checkBuffer(ShortBuffer shortBuffer, int i) {
        ShortBuffer shortBuffer2 = shortBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS) {
            checkBufferSize(shortBuffer2, i2);
            checkDirect(shortBuffer2);
        }
    }

    public static void checkBuffer(PointerBuffer pointerBuffer, int i) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS && pointerBuffer2.remaining() < i2) {
            throwBufferSizeException(pointerBuffer2, i2);
        }
    }

    public static void checkBufferSize(Buffer buffer, int i) {
        Buffer buffer2 = buffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS && buffer2.remaining() < i2) {
            throwBufferSizeException(buffer2, i2);
        }
    }

    public static void checkDirect(ByteBuffer byteBuffer) {
        IllegalArgumentException illegalArgumentException;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (LWJGLUtil.CHECKS && !byteBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("ByteBuffer is not direct");
            throw illegalArgumentException2;
        }
    }

    public static void checkDirect(DoubleBuffer doubleBuffer) {
        IllegalArgumentException illegalArgumentException;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        if (LWJGLUtil.CHECKS && !doubleBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("DoubleBuffer is not direct");
            throw illegalArgumentException2;
        }
    }

    public static void checkDirect(FloatBuffer floatBuffer) {
        IllegalArgumentException illegalArgumentException;
        FloatBuffer floatBuffer2 = floatBuffer;
        if (LWJGLUtil.CHECKS && !floatBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("FloatBuffer is not direct");
            throw illegalArgumentException2;
        }
    }

    public static void checkDirect(IntBuffer intBuffer) {
        IllegalArgumentException illegalArgumentException;
        IntBuffer intBuffer2 = intBuffer;
        if (LWJGLUtil.CHECKS && !intBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("IntBuffer is not direct");
            throw illegalArgumentException2;
        }
    }

    public static void checkDirect(LongBuffer longBuffer) {
        IllegalArgumentException illegalArgumentException;
        LongBuffer longBuffer2 = longBuffer;
        if (LWJGLUtil.CHECKS && !longBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("LongBuffer is not direct");
            throw illegalArgumentException2;
        }
    }

    public static void checkDirect(ShortBuffer shortBuffer) {
        IllegalArgumentException illegalArgumentException;
        ShortBuffer shortBuffer2 = shortBuffer;
        if (LWJGLUtil.CHECKS && !shortBuffer2.isDirect()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("ShortBuffer is not direct");
            throw illegalArgumentException2;
        }
    }

    public static void checkDirect(PointerBuffer pointerBuffer) {
    }

    public static void checkFunctionAddress(long j) {
        IllegalStateException illegalStateException;
        long j2 = j;
        if (LWJGLUtil.CHECKS && j2 == 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Function is not supported");
            throw illegalStateException2;
        }
    }

    public static void checkNotNull(Object obj) {
        IllegalArgumentException illegalArgumentException;
        Object obj2 = obj;
        if (LWJGLUtil.CHECKS && obj2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Null argument");
            throw illegalArgumentException2;
        }
    }

    public static void checkNullTerminated(ByteBuffer byteBuffer) {
        IllegalArgumentException illegalArgumentException;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (LWJGLUtil.CHECKS && byteBuffer2.get(-1 + byteBuffer2.limit()) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Missing null termination");
            throw illegalArgumentException2;
        }
    }

    public static void checkNullTerminated(ByteBuffer byteBuffer, int i) {
        IllegalArgumentException illegalArgumentException;
        ByteBuffer byteBuffer2 = byteBuffer;
        int i2 = i;
        if (LWJGLUtil.CHECKS) {
            int i3 = 0;
            for (int position = byteBuffer2.position(); position < byteBuffer2.limit(); position++) {
                if (byteBuffer2.get(position) == 0) {
                    i3++;
                }
            }
            if (i3 < i2) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Missing null termination");
                throw illegalArgumentException2;
            }
        }
    }

    public static void checkNullTerminated(IntBuffer intBuffer) {
        IllegalArgumentException illegalArgumentException;
        IntBuffer intBuffer2 = intBuffer;
        if (LWJGLUtil.CHECKS && intBuffer2.get(-1 + intBuffer2.limit()) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Missing null termination");
            throw illegalArgumentException2;
        }
    }

    public static void checkNullTerminated(LongBuffer longBuffer) {
        IllegalArgumentException illegalArgumentException;
        LongBuffer longBuffer2 = longBuffer;
        if (LWJGLUtil.CHECKS && longBuffer2.get(-1 + longBuffer2.limit()) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Missing null termination");
            throw illegalArgumentException2;
        }
    }

    public static void checkNullTerminated(PointerBuffer pointerBuffer) {
        IllegalArgumentException illegalArgumentException;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        if (LWJGLUtil.CHECKS && pointerBuffer2.get(-1 + pointerBuffer2.limit()) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Missing null termination");
            throw illegalArgumentException2;
        }
    }

    private static void throwArraySizeException(long[] jArr, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        long[] jArr2 = jArr;
        int i2 = i;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Number of array elements is ").append(jArr2.length).append(", must be at least ").append(i2).toString());
        throw illegalArgumentException2;
    }

    private static void throwArraySizeException(Object[] objArr, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Object[] objArr2 = objArr;
        int i2 = i;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Number of array elements is ").append(objArr2.length).append(", must be at least ").append(i2).toString());
        throw illegalArgumentException2;
    }

    private static void throwBufferSizeException(Buffer buffer, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Buffer buffer2 = buffer;
        int i2 = i;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Number of remaining buffer elements is ").append(buffer2.remaining()).append(", must be at least ").append(i2).append(". Because at most ").append(i2).append(" elements can be returned, a buffer with at least ").append(i2).append(" elements is required, regardless of actual returned element count").toString());
        throw illegalArgumentException2;
    }

    private static void throwBufferSizeException(PointerBuffer pointerBuffer, int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        int i2 = i;
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Number of remaining pointer buffer elements is ").append(pointerBuffer2.remaining()).append(", must be at least ").append(i2).toString());
        throw illegalArgumentException2;
    }
}

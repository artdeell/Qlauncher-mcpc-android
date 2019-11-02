package org.lwjgl.opencl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.PointerWrapper;

final class APIUtil {
    private static final int BUFFERS_SIZE = 32;
    private static final ObjectDestructor<CLCommandQueue> DESTRUCTOR_CLCommandQueue;
    private static final ObjectDestructor<CLEvent> DESTRUCTOR_CLEvent;
    private static final ObjectDestructor<CLKernel> DESTRUCTOR_CLKernel;
    private static final ObjectDestructor<CLMem> DESTRUCTOR_CLMem;
    private static final ObjectDestructor<CLProgram> DESTRUCTOR_CLProgram;
    private static final ObjectDestructor<CLSampler> DESTRUCTOR_CLSampler;
    private static final ObjectDestructor<CLDevice> DESTRUCTOR_CLSubDevice;
    private static final int INITIAL_BUFFER_SIZE = 256;
    private static final int INITIAL_LENGTHS_SIZE = 4;
    private static final ThreadLocal<char[]> arrayTL;
    private static final ThreadLocal<ByteBuffer> bufferByteTL;
    private static final ThreadLocal<PointerBuffer> bufferPointerTL;
    private static final ThreadLocal<Buffers> buffersTL;
    private static final ThreadLocal<PointerBuffer> lengthsTL;

    private static class Buffers {
        final DoubleBuffer doubles = BufferUtils.createDoubleBuffer(32);
        final FloatBuffer floats = BufferUtils.createFloatBuffer(32);
        final IntBuffer ints = BufferUtils.createIntBuffer(32);
        final IntBuffer intsDebug = BufferUtils.createIntBuffer(1);
        final LongBuffer longs = BufferUtils.createLongBuffer(32);
        final PointerBuffer pointers = BufferUtils.createPointerBuffer(32);
        final ShortBuffer shorts = BufferUtils.createShortBuffer(32);

        Buffers() {
        }
    }

    private interface ObjectDestructor<T extends CLObjectChild> {
        void release(T t);
    }

    static {
        C07591 r2;
        C07632 r22;
        C07643 r23;
        C07654 r24;
        C07665 r25;
        C07676 r26;
        C07687 r27;
        C07698 r28;
        C07709 r29;
        C076010 r210;
        C076111 r211;
        C076212 r212;
        C07591 r0 = r2;
        C07591 r1 = new ThreadLocal<char[]>() {
            /* access modifiers changed from: protected */
            public char[] initialValue() {
                return new char[256];
            }
        };
        arrayTL = r0;
        C07632 r02 = r22;
        C07632 r12 = new ThreadLocal<ByteBuffer>() {
            /* access modifiers changed from: protected */
            public ByteBuffer initialValue() {
                return BufferUtils.createByteBuffer(256);
            }
        };
        bufferByteTL = r02;
        C07643 r03 = r23;
        C07643 r13 = new ThreadLocal<PointerBuffer>() {
            /* access modifiers changed from: protected */
            public PointerBuffer initialValue() {
                return BufferUtils.createPointerBuffer(256);
            }
        };
        bufferPointerTL = r03;
        C07654 r04 = r24;
        C07654 r14 = new ThreadLocal<PointerBuffer>() {
            /* access modifiers changed from: protected */
            public PointerBuffer initialValue() {
                return BufferUtils.createPointerBuffer(4);
            }
        };
        lengthsTL = r04;
        C07665 r05 = r25;
        C07665 r15 = new ThreadLocal<Buffers>() {
            /* access modifiers changed from: protected */
            public Buffers initialValue() {
                Buffers buffers;
                Buffers buffers2 = buffers;
                Buffers buffers3 = new Buffers();
                return buffers2;
            }
        };
        buffersTL = r05;
        C07676 r06 = r26;
        C07676 r16 = new ObjectDestructor<CLDevice>() {
            public void release(CLDevice cLDevice) {
                int clReleaseDeviceEXT = EXTDeviceFission.clReleaseDeviceEXT(cLDevice);
            }
        };
        DESTRUCTOR_CLSubDevice = r06;
        C07687 r07 = r27;
        C07687 r17 = new ObjectDestructor<CLMem>() {
            public void release(CLMem cLMem) {
                int clReleaseMemObject = CL10.clReleaseMemObject(cLMem);
            }
        };
        DESTRUCTOR_CLMem = r07;
        C07698 r08 = r28;
        C07698 r18 = new ObjectDestructor<CLCommandQueue>() {
            public void release(CLCommandQueue cLCommandQueue) {
                int clReleaseCommandQueue = CL10.clReleaseCommandQueue(cLCommandQueue);
            }
        };
        DESTRUCTOR_CLCommandQueue = r08;
        C07709 r09 = r29;
        C07709 r19 = new ObjectDestructor<CLSampler>() {
            public void release(CLSampler cLSampler) {
                int clReleaseSampler = CL10.clReleaseSampler(cLSampler);
            }
        };
        DESTRUCTOR_CLSampler = r09;
        C076010 r010 = r210;
        C076010 r110 = new ObjectDestructor<CLProgram>() {
            public void release(CLProgram cLProgram) {
                int clReleaseProgram = CL10.clReleaseProgram(cLProgram);
            }
        };
        DESTRUCTOR_CLProgram = r010;
        C076111 r011 = r211;
        C076111 r111 = new ObjectDestructor<CLKernel>() {
            public void release(CLKernel cLKernel) {
                int clReleaseKernel = CL10.clReleaseKernel(cLKernel);
            }
        };
        DESTRUCTOR_CLKernel = r011;
        C076212 r012 = r212;
        C076212 r112 = new ObjectDestructor<CLEvent>() {
            public void release(CLEvent cLEvent) {
                int clReleaseEvent = CL10.clReleaseEvent(cLEvent);
            }
        };
        DESTRUCTOR_CLEvent = r012;
    }

    private APIUtil() {
    }

    private static ByteBuffer encode(ByteBuffer byteBuffer, CharSequence charSequence) {
        ByteBuffer byteBuffer2 = byteBuffer;
        CharSequence charSequence2 = charSequence;
        for (int i = 0; i < charSequence2.length(); i++) {
            char charAt = charSequence2.charAt(i);
            if (!LWJGLUtil.DEBUG || 128 > charAt) {
                ByteBuffer put = byteBuffer2.put((byte) charAt);
            } else {
                ByteBuffer put2 = byteBuffer2.put(26);
            }
        }
        return byteBuffer2;
    }

    private static char[] getArray(int i) {
        int i2 = i;
        char[] cArr = (char[]) arrayTL.get();
        if (cArr.length < i2) {
            int length = cArr.length;
            while (true) {
                int i3 = length << 1;
                if (i3 >= i2) {
                    break;
                }
                length = i3;
            }
            cArr = new char[i2];
            arrayTL.set(cArr);
        }
        return cArr;
    }

    static long getBuffer(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer encode = encode(getBufferByte(charSequence2.length()), charSequence2);
        Buffer flip = encode.flip();
        return MemoryUtil.getAddress0((Buffer) encode);
    }

    static long getBuffer(CharSequence charSequence, int i) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer encode = encode(getBufferByteOffset(i + charSequence2.length()), charSequence2);
        Buffer flip = encode.flip();
        return MemoryUtil.getAddress(encode);
    }

    static long getBuffer(CharSequence[] charSequenceArr) {
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ByteBuffer bufferByte = getBufferByte(getTotalLength(charSequenceArr2));
        int length = charSequenceArr2.length;
        for (int i = 0; i < length; i++) {
            ByteBuffer encode = encode(bufferByte, charSequenceArr2[i]);
        }
        Buffer flip = bufferByte.flip();
        return MemoryUtil.getAddress0((Buffer) bufferByte);
    }

    static ByteBuffer getBufferByte(int i) {
        int i2 = i;
        ByteBuffer byteBuffer = (ByteBuffer) bufferByteTL.get();
        if (byteBuffer.capacity() < i2) {
            int capacity = byteBuffer.capacity();
            while (true) {
                int i3 = capacity << 1;
                if (i3 < i2) {
                    capacity = i3;
                } else {
                    ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(i2);
                    bufferByteTL.set(createByteBuffer);
                    return createByteBuffer;
                }
            }
        } else {
            Buffer clear = byteBuffer.clear();
            return byteBuffer;
        }
    }

    private static ByteBuffer getBufferByteOffset(int i) {
        int i2 = i;
        ByteBuffer byteBuffer = (ByteBuffer) bufferByteTL.get();
        if (byteBuffer.capacity() < i2) {
            int capacity = byteBuffer.capacity();
            while (true) {
                int i3 = capacity << 1;
                if (i3 < i2) {
                    capacity = i3;
                } else {
                    ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(i2);
                    ByteBuffer put = createByteBuffer.put(byteBuffer);
                    bufferByteTL.set(createByteBuffer);
                    return createByteBuffer;
                }
            }
        } else {
            Buffer position = byteBuffer.position(byteBuffer.limit());
            Buffer limit = byteBuffer.limit(byteBuffer.capacity());
            return byteBuffer;
        }
    }

    static DoubleBuffer getBufferDouble() {
        return ((Buffers) buffersTL.get()).doubles;
    }

    static FloatBuffer getBufferFloat() {
        return ((Buffers) buffersTL.get()).floats;
    }

    static IntBuffer getBufferInt() {
        return ((Buffers) buffersTL.get()).ints;
    }

    static IntBuffer getBufferIntDebug() {
        return ((Buffers) buffersTL.get()).intsDebug;
    }

    static LongBuffer getBufferLong() {
        return ((Buffers) buffersTL.get()).longs;
    }

    static long getBufferNT(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer encode = encode(getBufferByte(1 + charSequence2.length()), charSequence2);
        ByteBuffer put = encode.put(0);
        Buffer flip = encode.flip();
        return MemoryUtil.getAddress0((Buffer) encode);
    }

    static long getBufferNT(CharSequence[] charSequenceArr) {
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ByteBuffer bufferByte = getBufferByte(getTotalLength(charSequenceArr2) + charSequenceArr2.length);
        int length = charSequenceArr2.length;
        for (int i = 0; i < length; i++) {
            ByteBuffer encode = encode(bufferByte, charSequenceArr2[i]);
            ByteBuffer put = bufferByte.put(0);
        }
        Buffer flip = bufferByte.flip();
        return MemoryUtil.getAddress0((Buffer) bufferByte);
    }

    static PointerBuffer getBufferPointer() {
        return ((Buffers) buffersTL.get()).pointers;
    }

    static PointerBuffer getBufferPointer(int i) {
        int i2 = i;
        PointerBuffer pointerBuffer = (PointerBuffer) bufferPointerTL.get();
        if (pointerBuffer.capacity() < i2) {
            int capacity = pointerBuffer.capacity();
            while (true) {
                int i3 = capacity << 1;
                if (i3 < i2) {
                    capacity = i3;
                } else {
                    PointerBuffer createPointerBuffer = BufferUtils.createPointerBuffer(i2);
                    bufferPointerTL.set(createPointerBuffer);
                    return createPointerBuffer;
                }
            }
        } else {
            PointerBuffer clear = pointerBuffer.clear();
            return pointerBuffer;
        }
    }

    static ShortBuffer getBufferShort() {
        return ((Buffers) buffersTL.get()).shorts;
    }

    static CLPlatform getCLPlatform(PointerBuffer pointerBuffer) {
        IllegalStateException illegalStateException;
        IllegalArgumentException illegalArgumentException;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = 0;
        int remaining = pointerBuffer2.remaining() / 2;
        int i = 0;
        while (true) {
            if (i >= remaining) {
                break;
            }
            long j2 = pointerBuffer2.get(i << 1);
            if (j2 == 0) {
                break;
            } else if (j2 == 4228) {
                j = pointerBuffer2.get(1 + (i << 1));
                break;
            } else {
                i++;
            }
        }
        if (j == 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Could not find CL_CONTEXT_PLATFORM in cl_context_properties.");
            throw illegalArgumentException2;
        }
        CLPlatform cLPlatform = CLPlatform.getCLPlatform(j);
        if (cLPlatform != null) {
            return cLPlatform;
        }
        IllegalStateException illegalStateException2 = illegalStateException;
        IllegalStateException illegalStateException3 = new IllegalStateException("Could not find a valid CLPlatform. Make sure clGetPlatformIDs has been used before.");
        throw illegalStateException2;
    }

    static Set<String> getExtensions(String str) {
        HashSet hashSet;
        StringTokenizer stringTokenizer;
        String str2 = str;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        if (str2 != null) {
            StringTokenizer stringTokenizer2 = stringTokenizer;
            StringTokenizer stringTokenizer3 = new StringTokenizer(str2);
            StringTokenizer stringTokenizer4 = stringTokenizer2;
            while (stringTokenizer4.hasMoreTokens()) {
                boolean add = hashSet4.add(stringTokenizer4.nextToken());
            }
        }
        return hashSet4;
    }

    static long getLengths(CharSequence[] charSequenceArr) {
        CharSequence[] charSequenceArr2 = charSequenceArr;
        PointerBuffer lengths = getLengths(charSequenceArr2.length);
        int length = charSequenceArr2.length;
        for (int i = 0; i < length; i++) {
            PointerBuffer put = lengths.put((long) charSequenceArr2[i].length());
        }
        PointerBuffer flip = lengths.flip();
        return MemoryUtil.getAddress0(lengths);
    }

    static long getLengths(ByteBuffer[] byteBufferArr) {
        ByteBuffer[] byteBufferArr2 = byteBufferArr;
        PointerBuffer lengths = getLengths(byteBufferArr2.length);
        int length = byteBufferArr2.length;
        for (int i = 0; i < length; i++) {
            PointerBuffer put = lengths.put((long) byteBufferArr2[i].remaining());
        }
        PointerBuffer flip = lengths.flip();
        return MemoryUtil.getAddress0(lengths);
    }

    static PointerBuffer getLengths() {
        return getLengths(1);
    }

    static PointerBuffer getLengths(int i) {
        int i2 = i;
        PointerBuffer pointerBuffer = (PointerBuffer) lengthsTL.get();
        if (pointerBuffer.capacity() < i2) {
            int capacity = pointerBuffer.capacity();
            while (true) {
                int i3 = capacity;
                if (i3 < i2) {
                    capacity = i3 << 1;
                } else {
                    PointerBuffer createPointerBuffer = BufferUtils.createPointerBuffer(i2);
                    lengthsTL.set(createPointerBuffer);
                    return createPointerBuffer;
                }
            }
        } else {
            PointerBuffer clear = pointerBuffer.clear();
            return pointerBuffer;
        }
    }

    static ByteBuffer getNativeKernelArgs(long j, CLMem[] cLMemArr, long[] jArr) {
        IllegalArgumentException illegalArgumentException;
        long j2 = j;
        CLMem[] cLMemArr2 = cLMemArr;
        long[] jArr2 = jArr;
        ByteBuffer bufferByte = getBufferByte((cLMemArr2 == null ? 0 : cLMemArr2.length * (4 + PointerBuffer.getPointerSize())) + 12);
        ByteBuffer putLong = bufferByte.putLong(0, j2);
        if (cLMemArr2 == null) {
            ByteBuffer putInt = bufferByte.putInt(8, 0);
        } else {
            ByteBuffer putInt2 = bufferByte.putInt(8, cLMemArr2.length);
            int i = 12;
            int i2 = 0;
            while (i2 < cLMemArr2.length) {
                if (!LWJGLUtil.DEBUG || cLMemArr2[i2].isValid()) {
                    ByteBuffer putInt3 = bufferByte.putInt(i, (int) jArr2[i2]);
                    i += 4 + PointerBuffer.getPointerSize();
                    i2++;
                } else {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("An invalid CLMem object was specified.");
                    throw illegalArgumentException2;
                }
            }
        }
        return bufferByte;
    }

    static long getPointer(PointerWrapper pointerWrapper) {
        return MemoryUtil.getAddress0(getBufferPointer().put(0, pointerWrapper));
    }

    static long getPointerSafe(PointerWrapper pointerWrapper) {
        PointerWrapper pointerWrapper2 = pointerWrapper;
        return MemoryUtil.getAddress0(getBufferPointer().put(0, pointerWrapper2 == null ? 0 : pointerWrapper2.getPointer()));
    }

    static int getSize(PointerBuffer pointerBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        long j = 0;
        for (int position = pointerBuffer2.position(); position < pointerBuffer2.limit(); position++) {
            j += pointerBuffer2.get(position);
        }
        return (int) j;
    }

    static String getString(ByteBuffer byteBuffer) {
        String str;
        ByteBuffer byteBuffer2 = byteBuffer;
        int remaining = byteBuffer2.remaining();
        char[] array = getArray(remaining);
        for (int position = byteBuffer2.position(); position < byteBuffer2.limit(); position++) {
            array[position - byteBuffer2.position()] = (char) byteBuffer2.get(position);
        }
        String str2 = str;
        String str3 = new String(array, 0, remaining);
        return str2;
    }

    static int getTotalLength(CharSequence[] charSequenceArr) {
        CharSequence[] charSequenceArr2 = charSequenceArr;
        int i = 0;
        for (int i2 = 0; i2 < charSequenceArr2.length; i2++) {
            i += charSequenceArr2[i2].length();
        }
        return i;
    }

    static boolean isDevicesParam(int i) {
        switch (i) {
            case CL10.CL_CONTEXT_DEVICES /*4225*/:
            case KHRGLSharing.CL_CURRENT_DEVICE_FOR_GL_CONTEXT_KHR /*8198*/:
            case KHRGLSharing.CL_DEVICES_FOR_GL_CONTEXT_KHR /*8199*/:
            case APPLEGLSharing.CL_CGL_DEVICE_FOR_CURRENT_VIRTUAL_SCREEN_APPLE /*268435458*/:
            case APPLEGLSharing.CL_CGL_DEVICES_FOR_SUPPORTED_VIRTUAL_SCREENS_APPLE /*268435459*/:
                return true;
            default:
                return false;
        }
    }

    static void releaseObjects(CLCommandQueue cLCommandQueue) {
        CLCommandQueue cLCommandQueue2 = cLCommandQueue;
        if (cLCommandQueue2.isValid() && cLCommandQueue2.getReferenceCount() <= 1) {
            releaseObjects(cLCommandQueue2.getCLEventRegistry(), DESTRUCTOR_CLEvent);
        }
    }

    static void releaseObjects(CLContext cLContext) {
        CLContext cLContext2 = cLContext;
        if (cLContext2.isValid() && cLContext2.getReferenceCount() <= 1) {
            releaseObjects(cLContext2.getCLEventRegistry(), DESTRUCTOR_CLEvent);
            releaseObjects(cLContext2.getCLProgramRegistry(), DESTRUCTOR_CLProgram);
            releaseObjects(cLContext2.getCLSamplerRegistry(), DESTRUCTOR_CLSampler);
            releaseObjects(cLContext2.getCLMemRegistry(), DESTRUCTOR_CLMem);
            releaseObjects(cLContext2.getCLCommandQueueRegistry(), DESTRUCTOR_CLCommandQueue);
        }
    }

    static void releaseObjects(CLDevice cLDevice) {
        CLDevice cLDevice2 = cLDevice;
        if (cLDevice2.isValid() && cLDevice2.getReferenceCount() <= 1) {
            releaseObjects(cLDevice2.getSubCLDeviceRegistry(), DESTRUCTOR_CLSubDevice);
        }
    }

    private static <T extends CLObjectChild> void releaseObjects(CLObjectRegistry<T> cLObjectRegistry, ObjectDestructor<T> objectDestructor) {
        CLObjectRegistry<T> cLObjectRegistry2 = cLObjectRegistry;
        ObjectDestructor<T> objectDestructor2 = objectDestructor;
        if (!cLObjectRegistry2.isEmpty()) {
            for (Entry entry : cLObjectRegistry2.getAll()) {
                CLObjectChild cLObjectChild = (CLObjectChild) entry.value;
                while (cLObjectChild.isValid()) {
                    objectDestructor2.release(cLObjectChild);
                }
            }
        }
    }

    static void releaseObjects(CLProgram cLProgram) {
        CLProgram cLProgram2 = cLProgram;
        if (cLProgram2.isValid() && cLProgram2.getReferenceCount() <= 1) {
            releaseObjects(cLProgram2.getCLKernelRegistry(), DESTRUCTOR_CLKernel);
        }
    }
}

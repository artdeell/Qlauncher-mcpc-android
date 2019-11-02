package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

final class APIUtil {
    private static final int BUFFERS_SIZE = 32;
    private static final int INITIAL_BUFFER_SIZE = 256;
    private static final int INITIAL_LENGTHS_SIZE = 4;
    private char[] array = new char[256];
    private ByteBuffer buffer = BufferUtils.createByteBuffer(256);
    private final DoubleBuffer doubles = BufferUtils.createDoubleBuffer(32);
    private final FloatBuffer floats = BufferUtils.createFloatBuffer(32);
    private final IntBuffer ints = BufferUtils.createIntBuffer(32);
    private IntBuffer lengths = BufferUtils.createIntBuffer(4);
    private final LongBuffer longs = BufferUtils.createLongBuffer(32);

    APIUtil() {
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

    private static char[] getArray(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        int i2 = i;
        char[] cArr = contextCapabilities2.util.array;
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
            contextCapabilities2.util.array = cArr;
        }
        return cArr;
    }

    static long getBuffer(ContextCapabilities contextCapabilities, CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer encode = encode(getBufferByte(contextCapabilities, charSequence2.length()), charSequence2);
        Buffer flip = encode.flip();
        return MemoryUtil.getAddress0((Buffer) encode);
    }

    static long getBuffer(ContextCapabilities contextCapabilities, CharSequence charSequence, int i) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer encode = encode(getBufferByteOffset(contextCapabilities, i + charSequence2.length()), charSequence2);
        Buffer flip = encode.flip();
        return MemoryUtil.getAddress(encode);
    }

    static long getBuffer(ContextCapabilities contextCapabilities, CharSequence[] charSequenceArr) {
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ByteBuffer bufferByte = getBufferByte(contextCapabilities, getTotalLength(charSequenceArr2));
        int length = charSequenceArr2.length;
        for (int i = 0; i < length; i++) {
            ByteBuffer encode = encode(bufferByte, charSequenceArr2[i]);
        }
        Buffer flip = bufferByte.flip();
        return MemoryUtil.getAddress0((Buffer) bufferByte);
    }

    static ByteBuffer getBufferByte(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        int i2 = i;
        ByteBuffer byteBuffer = contextCapabilities2.util.buffer;
        if (byteBuffer.capacity() < i2) {
            int capacity = byteBuffer.capacity();
            while (true) {
                int i3 = capacity << 1;
                if (i3 < i2) {
                    capacity = i3;
                } else {
                    ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(i2);
                    contextCapabilities2.util.buffer = createByteBuffer;
                    return createByteBuffer;
                }
            }
        } else {
            Buffer clear = byteBuffer.clear();
            return byteBuffer;
        }
    }

    static long getBufferByte0(ContextCapabilities contextCapabilities) {
        return MemoryUtil.getAddress0((Buffer) getBufferByte(contextCapabilities, 0));
    }

    private static ByteBuffer getBufferByteOffset(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        int i2 = i;
        ByteBuffer byteBuffer = contextCapabilities2.util.buffer;
        if (byteBuffer.capacity() < i2) {
            int capacity = byteBuffer.capacity();
            while (true) {
                int i3 = capacity << 1;
                if (i3 < i2) {
                    capacity = i3;
                } else {
                    ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(i2);
                    ByteBuffer put = createByteBuffer.put(byteBuffer);
                    contextCapabilities2.util.buffer = createByteBuffer;
                    return createByteBuffer;
                }
            }
        } else {
            Buffer position = byteBuffer.position(byteBuffer.limit());
            Buffer limit = byteBuffer.limit(byteBuffer.capacity());
            return byteBuffer;
        }
    }

    static DoubleBuffer getBufferDouble(ContextCapabilities contextCapabilities) {
        return contextCapabilities.util.doubles;
    }

    static FloatBuffer getBufferFloat(ContextCapabilities contextCapabilities) {
        return contextCapabilities.util.floats;
    }

    static IntBuffer getBufferInt(ContextCapabilities contextCapabilities) {
        return contextCapabilities.util.ints;
    }

    static LongBuffer getBufferLong(ContextCapabilities contextCapabilities) {
        return contextCapabilities.util.longs;
    }

    static long getBufferNT(ContextCapabilities contextCapabilities, CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer encode = encode(getBufferByte(contextCapabilities, 1 + charSequence2.length()), charSequence2);
        ByteBuffer put = encode.put(0);
        Buffer flip = encode.flip();
        return MemoryUtil.getAddress0((Buffer) encode);
    }

    static long getBufferNT(ContextCapabilities contextCapabilities, CharSequence[] charSequenceArr) {
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ByteBuffer bufferByte = getBufferByte(contextCapabilities, getTotalLength(charSequenceArr2) + charSequenceArr2.length);
        int length = charSequenceArr2.length;
        for (int i = 0; i < length; i++) {
            ByteBuffer encode = encode(bufferByte, charSequenceArr2[i]);
            ByteBuffer put = bufferByte.put(0);
        }
        Buffer flip = bufferByte.flip();
        return MemoryUtil.getAddress0((Buffer) bufferByte);
    }

    static long getInt(ContextCapabilities contextCapabilities, int i) {
        return MemoryUtil.getAddress0((Buffer) getBufferInt(contextCapabilities).put(0, i));
    }

    static long getLengths(ContextCapabilities contextCapabilities, CharSequence[] charSequenceArr) {
        CharSequence[] charSequenceArr2 = charSequenceArr;
        IntBuffer lengths2 = getLengths(contextCapabilities, charSequenceArr2.length);
        int length = charSequenceArr2.length;
        for (int i = 0; i < length; i++) {
            IntBuffer put = lengths2.put(charSequenceArr2[i].length());
        }
        Buffer flip = lengths2.flip();
        return MemoryUtil.getAddress0((Buffer) lengths2);
    }

    static IntBuffer getLengths(ContextCapabilities contextCapabilities) {
        return getLengths(contextCapabilities, 1);
    }

    static IntBuffer getLengths(ContextCapabilities contextCapabilities, int i) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        int i2 = i;
        IntBuffer intBuffer = contextCapabilities2.util.lengths;
        if (intBuffer.capacity() < i2) {
            int capacity = intBuffer.capacity();
            while (true) {
                int i3 = capacity;
                if (i3 < i2) {
                    capacity = i3 << 1;
                } else {
                    IntBuffer createIntBuffer = BufferUtils.createIntBuffer(i2);
                    contextCapabilities2.util.lengths = createIntBuffer;
                    return createIntBuffer;
                }
            }
        } else {
            Buffer clear = intBuffer.clear();
            return intBuffer;
        }
    }

    static String getString(ContextCapabilities contextCapabilities, ByteBuffer byteBuffer) {
        String str;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        ByteBuffer byteBuffer2 = byteBuffer;
        int remaining = byteBuffer2.remaining();
        char[] array2 = getArray(contextCapabilities2, remaining);
        for (int position = byteBuffer2.position(); position < byteBuffer2.limit(); position++) {
            array2[position - byteBuffer2.position()] = (char) byteBuffer2.get(position);
        }
        String str2 = str;
        String str3 = new String(array2, 0, remaining);
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
}

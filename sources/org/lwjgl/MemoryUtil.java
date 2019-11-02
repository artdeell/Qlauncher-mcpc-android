package org.lwjgl;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.dex.DexFormat;

public final class MemoryUtil {
    private static final Charset ascii = Charset.forName("ISO-8859-1");
    private static final Accessor memUtil;
    private static final Charset utf16 = Charset.forName("UTF-16LE");
    private static final Charset utf8 = Charset.forName("UTF-8");

    interface Accessor {
        long getAddress(Buffer buffer);
    }

    private static class AccessorJNI implements Accessor {
        private AccessorJNI() {
        }

        /* synthetic */ AccessorJNI(C07461 r4) {
            C07461 r1 = r4;
            this();
        }

        public long getAddress(Buffer buffer) {
            return BufferUtils.getBufferAddress(buffer);
        }
    }

    private static class AccessorReflect implements Accessor {
        private final Field address;

        AccessorReflect() {
            UnsupportedOperationException unsupportedOperationException;
            try {
                this.address = MemoryUtil.getAddressField();
                this.address.setAccessible(true);
            } catch (NoSuchFieldException e) {
                NoSuchFieldException noSuchFieldException = e;
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(noSuchFieldException);
                throw unsupportedOperationException2;
            }
        }

        public long getAddress(Buffer buffer) {
            try {
                return this.address.getLong(buffer);
            } catch (IllegalAccessException e) {
                IllegalAccessException illegalAccessException = e;
                return 0;
            }
        }
    }

    private static class CharSequenceNT implements CharSequence {
        final CharSequence source;

        CharSequenceNT(CharSequence charSequence) {
            this.source = charSequence;
        }

        public char charAt(int i) {
            int i2 = i;
            if (i2 == this.source.length()) {
                return 0;
            }
            return this.source.charAt(i2);
        }

        public int length() {
            return 1 + this.source.length();
        }

        public CharSequence subSequence(int i, int i2) {
            CharSequenceNT charSequenceNT;
            CharSequenceNT charSequenceNT2 = charSequenceNT;
            CharSequenceNT charSequenceNT3 = new CharSequenceNT(this.source.subSequence(i, Math.min(i2, this.source.length())));
            return charSequenceNT2;
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(this.source).append(DexFormat.MAGIC_SUFFIX).toString();
        }
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r6v16, types: [org.lwjgl.MemoryUtil$Accessor] */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v23, types: [org.lwjgl.MemoryUtil$Accessor] */
    /* JADX WARNING: type inference failed for: r6v24, types: [org.lwjgl.MemoryUtil$Accessor] */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r6v25 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 13 */
    static {
        /*
            java.lang.String r6 = "ISO-8859-1"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)
            ascii = r6
            java.lang.String r6 = "UTF-8"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)
            utf8 = r6
            java.lang.String r6 = "UTF-16LE"
            java.nio.charset.Charset r6 = java.nio.charset.Charset.forName(r6)
            utf16 = r6
            java.lang.String r6 = "org.lwjgl.MemoryUtilSun$AccessorUnsafe"
            org.lwjgl.MemoryUtil$Accessor r6 = loadAccessor(r6)     // Catch:{ Exception -> 0x0047 }
            r5 = r6
            r6 = r5
            r2 = r6
        L_0x0021:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r9 = r6
            r6 = r9
            r7 = r9
            r7.<init>()
            java.lang.String r7 = "MemoryUtil Accessor: "
            java.lang.StringBuilder r6 = r6.append(r7)
            r7 = r2
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            org.lwjgl.LWJGLUtil.log(r6)
            r6 = r2
            memUtil = r6
            return
        L_0x0047:
            r6 = move-exception
            r0 = r6
            java.lang.String r6 = "org.lwjgl.MemoryUtilSun$AccessorReflectFast"
            org.lwjgl.MemoryUtil$Accessor r6 = loadAccessor(r6)     // Catch:{ Exception -> 0x0053 }
            r4 = r6
            r6 = r4
            r2 = r6
            goto L_0x0021
        L_0x0053:
            r6 = move-exception
            r1 = r6
            org.lwjgl.MemoryUtil$AccessorReflect r6 = new org.lwjgl.MemoryUtil$AccessorReflect     // Catch:{ Exception -> 0x005f }
            r9 = r6
            r6 = r9
            r7 = r9
            r7.<init>()     // Catch:{ Exception -> 0x005f }
            r2 = r6
            goto L_0x0021
        L_0x005f:
            r6 = move-exception
            r3 = r6
            java.lang.String r6 = "Unsupported JVM detected, this will likely result in low performance. Please inform LWJGL developers."
            org.lwjgl.LWJGLUtil.log(r6)
            org.lwjgl.MemoryUtil$AccessorJNI r6 = new org.lwjgl.MemoryUtil$AccessorJNI
            r9 = r6
            r6 = r9
            r7 = r9
            r8 = 0
            r7.<init>(r8)
            r2 = r6
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.MemoryUtil.<clinit>():void");
    }

    private MemoryUtil() {
    }

    private static String decode(ByteBuffer byteBuffer, Charset charset) {
        ByteBuffer byteBuffer2 = byteBuffer;
        Charset charset2 = charset;
        if (byteBuffer2 == null) {
            return null;
        }
        return decodeImpl(byteBuffer2, charset2);
    }

    public static String decodeASCII(ByteBuffer byteBuffer) {
        return decode(byteBuffer, ascii);
    }

    private static String decodeImpl(ByteBuffer byteBuffer, Charset charset) {
        RuntimeException runtimeException;
        ByteBuffer byteBuffer2 = byteBuffer;
        CharsetDecoder newDecoder = charset.newDecoder();
        int remaining = (int) (((float) byteBuffer2.remaining()) * newDecoder.averageCharsPerByte());
        CharBuffer createCharBuffer = BufferUtils.createCharBuffer(remaining);
        if (remaining == 0 && byteBuffer2.remaining() == 0) {
            return LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        CharsetDecoder reset = newDecoder.reset();
        while (true) {
            CoderResult coderResult = byteBuffer2.hasRemaining() ? newDecoder.decode(byteBuffer2, createCharBuffer, true) : CoderResult.UNDERFLOW;
            if (coderResult.isUnderflow()) {
                coderResult = newDecoder.flush(createCharBuffer);
            }
            if (coderResult.isUnderflow()) {
                Buffer flip = createCharBuffer.flip();
                return createCharBuffer.toString();
            } else if (coderResult.isOverflow()) {
                remaining = 1 + (remaining * 2);
                CharBuffer createCharBuffer2 = BufferUtils.createCharBuffer(remaining);
                Buffer flip2 = createCharBuffer.flip();
                CharBuffer put = createCharBuffer2.put(createCharBuffer);
                createCharBuffer = createCharBuffer2;
            } else {
                try {
                    coderResult.throwException();
                } catch (CharacterCodingException e) {
                    CharacterCodingException characterCodingException = e;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException(characterCodingException);
                    throw runtimeException2;
                }
            }
        }
    }

    public static String decodeUTF16(ByteBuffer byteBuffer) {
        return decode(byteBuffer, utf16);
    }

    public static String decodeUTF8(ByteBuffer byteBuffer) {
        return decode(byteBuffer, utf8);
    }

    private static ByteBuffer encode(CharSequence charSequence, Charset charset) {
        CharSequenceNT charSequenceNT;
        CharSequence charSequence2 = charSequence;
        Charset charset2 = charset;
        if (charSequence2 == null) {
            return null;
        }
        CharSequenceNT charSequenceNT2 = charSequenceNT;
        CharSequenceNT charSequenceNT3 = new CharSequenceNT(charSequence2);
        return encode(CharBuffer.wrap(charSequenceNT2), charset2);
    }

    private static ByteBuffer encode(CharBuffer charBuffer, Charset charset) {
        RuntimeException runtimeException;
        CharBuffer charBuffer2 = charBuffer;
        CharsetEncoder newEncoder = charset.newEncoder();
        int remaining = (int) (((float) charBuffer2.remaining()) * newEncoder.averageBytesPerChar());
        ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(remaining);
        if (remaining == 0 && charBuffer2.remaining() == 0) {
            return createByteBuffer;
        }
        CharsetEncoder reset = newEncoder.reset();
        while (true) {
            CoderResult coderResult = charBuffer2.hasRemaining() ? newEncoder.encode(charBuffer2, createByteBuffer, true) : CoderResult.UNDERFLOW;
            if (coderResult.isUnderflow()) {
                coderResult = newEncoder.flush(createByteBuffer);
            }
            if (coderResult.isUnderflow()) {
                Buffer flip = createByteBuffer.flip();
                return createByteBuffer;
            } else if (coderResult.isOverflow()) {
                remaining = 1 + (remaining * 2);
                ByteBuffer createByteBuffer2 = BufferUtils.createByteBuffer(remaining);
                Buffer flip2 = createByteBuffer.flip();
                ByteBuffer put = createByteBuffer2.put(createByteBuffer);
                createByteBuffer = createByteBuffer2;
            } else {
                try {
                    coderResult.throwException();
                } catch (CharacterCodingException e) {
                    CharacterCodingException characterCodingException = e;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException(characterCodingException);
                    throw runtimeException2;
                }
            }
        }
    }

    public static ByteBuffer encodeASCII(CharSequence charSequence) {
        return encode(charSequence, ascii);
    }

    public static ByteBuffer encodeUTF16(CharSequence charSequence) {
        return encode(charSequence, utf16);
    }

    public static ByteBuffer encodeUTF8(CharSequence charSequence) {
        return encode(charSequence, utf8);
    }

    public static long getAddress(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        return getAddress(byteBuffer2, byteBuffer2.position());
    }

    public static long getAddress(ByteBuffer byteBuffer, int i) {
        return getAddress0((Buffer) byteBuffer) + ((long) i);
    }

    public static long getAddress(CharBuffer charBuffer) {
        CharBuffer charBuffer2 = charBuffer;
        return getAddress(charBuffer2, charBuffer2.position());
    }

    public static long getAddress(CharBuffer charBuffer, int i) {
        return getAddress0((Buffer) charBuffer) + ((long) (i << 1));
    }

    public static long getAddress(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        return getAddress(doubleBuffer2, doubleBuffer2.position());
    }

    public static long getAddress(DoubleBuffer doubleBuffer, int i) {
        return getAddress0((Buffer) doubleBuffer) + ((long) (i << 3));
    }

    public static long getAddress(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        return getAddress(floatBuffer2, floatBuffer2.position());
    }

    public static long getAddress(FloatBuffer floatBuffer, int i) {
        return getAddress0((Buffer) floatBuffer) + ((long) (i << 2));
    }

    public static long getAddress(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        return getAddress(intBuffer2, intBuffer2.position());
    }

    public static long getAddress(IntBuffer intBuffer, int i) {
        return getAddress0((Buffer) intBuffer) + ((long) (i << 2));
    }

    public static long getAddress(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        return getAddress(longBuffer2, longBuffer2.position());
    }

    public static long getAddress(LongBuffer longBuffer, int i) {
        return getAddress0((Buffer) longBuffer) + ((long) (i << 3));
    }

    public static long getAddress(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        return getAddress(shortBuffer2, shortBuffer2.position());
    }

    public static long getAddress(ShortBuffer shortBuffer, int i) {
        return getAddress0((Buffer) shortBuffer) + ((long) (i << 1));
    }

    public static long getAddress(PointerBuffer pointerBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        return getAddress(pointerBuffer2, pointerBuffer2.position());
    }

    public static long getAddress(PointerBuffer pointerBuffer, int i) {
        return getAddress0(pointerBuffer) + ((long) (i * PointerBuffer.getPointerSize()));
    }

    public static long getAddress0(Buffer buffer) {
        return memUtil.getAddress(buffer);
    }

    public static long getAddress0(PointerBuffer pointerBuffer) {
        return memUtil.getAddress(pointerBuffer.getBuffer());
    }

    public static long getAddress0Safe(Buffer buffer) {
        Buffer buffer2 = buffer;
        if (buffer2 == null) {
            return 0;
        }
        return memUtil.getAddress(buffer2);
    }

    public static long getAddress0Safe(PointerBuffer pointerBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        if (pointerBuffer2 == null) {
            return 0;
        }
        return memUtil.getAddress(pointerBuffer2.getBuffer());
    }

    static Field getAddressField() throws NoSuchFieldException {
        try {
            return getDeclaredFieldRecursive(ByteBuffer.class, "effectiveDirectAddress");
        } catch (NoSuchFieldException e) {
            NoSuchFieldException noSuchFieldException = e;
            return getDeclaredFieldRecursive(ByteBuffer.class, "address");
        }
    }

    public static long getAddressSafe(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer2 == null) {
            return 0;
        }
        return getAddress(byteBuffer2);
    }

    public static long getAddressSafe(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i2 = i;
        if (byteBuffer2 == null) {
            return 0;
        }
        return getAddress(byteBuffer2, i2);
    }

    public static long getAddressSafe(CharBuffer charBuffer) {
        CharBuffer charBuffer2 = charBuffer;
        if (charBuffer2 == null) {
            return 0;
        }
        return getAddress(charBuffer2);
    }

    public static long getAddressSafe(CharBuffer charBuffer, int i) {
        CharBuffer charBuffer2 = charBuffer;
        int i2 = i;
        if (charBuffer2 == null) {
            return 0;
        }
        return getAddress(charBuffer2, i2);
    }

    public static long getAddressSafe(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        if (doubleBuffer2 == null) {
            return 0;
        }
        return getAddress(doubleBuffer2);
    }

    public static long getAddressSafe(DoubleBuffer doubleBuffer, int i) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        int i2 = i;
        if (doubleBuffer2 == null) {
            return 0;
        }
        return getAddress(doubleBuffer2, i2);
    }

    public static long getAddressSafe(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        if (floatBuffer2 == null) {
            return 0;
        }
        return getAddress(floatBuffer2);
    }

    public static long getAddressSafe(FloatBuffer floatBuffer, int i) {
        FloatBuffer floatBuffer2 = floatBuffer;
        int i2 = i;
        if (floatBuffer2 == null) {
            return 0;
        }
        return getAddress(floatBuffer2, i2);
    }

    public static long getAddressSafe(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        if (intBuffer2 == null) {
            return 0;
        }
        return getAddress(intBuffer2);
    }

    public static long getAddressSafe(IntBuffer intBuffer, int i) {
        IntBuffer intBuffer2 = intBuffer;
        int i2 = i;
        if (intBuffer2 == null) {
            return 0;
        }
        return getAddress(intBuffer2, i2);
    }

    public static long getAddressSafe(LongBuffer longBuffer) {
        LongBuffer longBuffer2 = longBuffer;
        if (longBuffer2 == null) {
            return 0;
        }
        return getAddress(longBuffer2);
    }

    public static long getAddressSafe(LongBuffer longBuffer, int i) {
        LongBuffer longBuffer2 = longBuffer;
        int i2 = i;
        if (longBuffer2 == null) {
            return 0;
        }
        return getAddress(longBuffer2, i2);
    }

    public static long getAddressSafe(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        if (shortBuffer2 == null) {
            return 0;
        }
        return getAddress(shortBuffer2);
    }

    public static long getAddressSafe(ShortBuffer shortBuffer, int i) {
        ShortBuffer shortBuffer2 = shortBuffer;
        int i2 = i;
        if (shortBuffer2 == null) {
            return 0;
        }
        return getAddress(shortBuffer2, i2);
    }

    public static long getAddressSafe(PointerBuffer pointerBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        if (pointerBuffer2 == null) {
            return 0;
        }
        return getAddress(pointerBuffer2);
    }

    public static long getAddressSafe(PointerBuffer pointerBuffer, int i) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        int i2 = i;
        if (pointerBuffer2 == null) {
            return 0;
        }
        return getAddress(pointerBuffer2, i2);
    }

    private static Field getDeclaredFieldRecursive(Class<?> cls, String str) throws NoSuchFieldException {
        NoSuchFieldException noSuchFieldException;
        StringBuilder sb;
        Class<?> cls2 = cls;
        String str2 = str;
        Class<?> cls3 = cls2;
        do {
            try {
                return cls3.getDeclaredField(str2);
            } catch (NoSuchFieldException e) {
                NoSuchFieldException noSuchFieldException2 = e;
                cls3 = cls3.getSuperclass();
                if (cls3 == null) {
                    NoSuchFieldException noSuchFieldException3 = noSuchFieldException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    NoSuchFieldException noSuchFieldException4 = new NoSuchFieldException(sb2.append(str2).append(" does not exist in ").append(cls2.getSimpleName()).append(" or any of its superclasses.").toString());
                    throw noSuchFieldException3;
                }
            }
        } while (cls3 == null);
        NoSuchFieldException noSuchFieldException32 = noSuchFieldException;
        StringBuilder sb22 = sb;
        StringBuilder sb32 = new StringBuilder();
        NoSuchFieldException noSuchFieldException42 = new NoSuchFieldException(sb22.append(str2).append(" does not exist in ").append(cls2.getSimpleName()).append(" or any of its superclasses.").toString());
        throw noSuchFieldException32;
    }

    private static Accessor loadAccessor(String str) throws Exception {
        return (Accessor) Class.forName(str).newInstance();
    }
}

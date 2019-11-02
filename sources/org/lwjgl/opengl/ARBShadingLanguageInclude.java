package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ARBShadingLanguageInclude {
    public static final int GL_NAMED_STRING_LENGTH_ARB = 36329;
    public static final int GL_NAMED_STRING_TYPE_ARB = 36330;
    public static final int GL_SHADER_INCLUDE_ARB = 36270;

    private ARBShadingLanguageInclude() {
    }

    public static void glCompileShaderIncludeARB(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glCompileShaderIncludeARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2, i4);
        nglCompileShaderIncludeARB(i3, i4, MemoryUtil.getAddress(byteBuffer2), 0, j);
    }

    public static void glCompileShaderIncludeARB(int i, CharSequence[] charSequenceArr) {
        int i2 = i;
        CharSequence[] charSequenceArr2 = charSequenceArr;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCompileShaderIncludeARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkArray(charSequenceArr2);
        nglCompileShaderIncludeARB2(i2, charSequenceArr2.length, APIUtil.getBuffer(capabilities, charSequenceArr2), APIUtil.getLengths(capabilities, charSequenceArr2), j);
    }

    public static void glDeleteNamedStringARB(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteNamedStringARB(charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glDeleteNamedStringARB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glDeleteNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglDeleteNamedStringARB(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static String glGetNamedStringARB(CharSequence charSequence, int i) {
        CharSequence charSequence2 = charSequence;
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer lengths = APIUtil.getLengths(capabilities);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, i2 + charSequence2.length());
        nglGetNamedStringARB(charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), i2, MemoryUtil.getAddress0((Buffer) lengths), MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(charSequence2.length() + lengths.get(0));
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetNamedStringARB(CharSequence charSequence, IntBuffer intBuffer, ByteBuffer byteBuffer) {
        CharSequence charSequence2 = charSequence;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer2);
        nglGetNamedStringARB(charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), byteBuffer2.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glGetNamedStringARB(ByteBuffer byteBuffer, int i, IntBuffer intBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetNamedStringivARB(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGetNamedStringARB(ByteBuffer byteBuffer, IntBuffer intBuffer, ByteBuffer byteBuffer2) {
        ByteBuffer byteBuffer3 = byteBuffer;
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        long j = GLContext.getCapabilities().glGetNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer3);
        if (intBuffer2 != null) {
            BufferChecks.checkBuffer(intBuffer2, 1);
        }
        BufferChecks.checkDirect(byteBuffer4);
        nglGetNamedStringARB(byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), MemoryUtil.getAddressSafe(intBuffer2), MemoryUtil.getAddress(byteBuffer4), j);
    }

    public static int glGetNamedStringiARB(CharSequence charSequence, int i) {
        CharSequence charSequence2 = charSequence;
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetNamedStringivARB(charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), i2, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetNamedStringiARB(CharSequence charSequence, int i, IntBuffer intBuffer) {
        CharSequence charSequence2 = charSequence;
        int i2 = i;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetNamedStringivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 1);
        nglGetNamedStringivARB(charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), i2, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static boolean glIsNamedStringARB(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glIsNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        return nglIsNamedStringARB(charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static boolean glIsNamedStringARB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glIsNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        return nglIsNamedStringARB(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glNamedStringARB(int i, CharSequence charSequence, CharSequence charSequence2) {
        int i2 = i;
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        nglNamedStringARB(i2, charSequence3.length(), APIUtil.getBuffer(capabilities, charSequence3), charSequence4.length(), APIUtil.getBuffer(capabilities, charSequence4, charSequence3.length()), j);
    }

    public static void glNamedStringARB(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int i2 = i;
        ByteBuffer byteBuffer3 = byteBuffer;
        ByteBuffer byteBuffer4 = byteBuffer2;
        long j = GLContext.getCapabilities().glNamedStringARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer3);
        BufferChecks.checkDirect(byteBuffer4);
        nglNamedStringARB(i2, byteBuffer3.remaining(), MemoryUtil.getAddress(byteBuffer3), byteBuffer4.remaining(), MemoryUtil.getAddress(byteBuffer4), j);
    }

    static native void nglCompileShaderIncludeARB(int i, int i2, long j, long j2, long j3);

    static native void nglCompileShaderIncludeARB2(int i, int i2, long j, long j2, long j3);

    static native void nglDeleteNamedStringARB(int i, long j, long j2);

    static native void nglGetNamedStringARB(int i, long j, int i2, long j2, long j3, long j4);

    static native void nglGetNamedStringivARB(int i, long j, int i2, long j2, long j3);

    static native boolean nglIsNamedStringARB(int i, long j, long j2);

    static native void nglNamedStringARB(int i, int i2, long j, int i3, long j2, long j3);
}

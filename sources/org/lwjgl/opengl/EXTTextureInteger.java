package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTTextureInteger {
    public static final int GL_ALPHA16I_EXT = 36234;
    public static final int GL_ALPHA16UI_EXT = 36216;
    public static final int GL_ALPHA32I_EXT = 36228;
    public static final int GL_ALPHA32UI_EXT = 36210;
    public static final int GL_ALPHA8I_EXT = 36240;
    public static final int GL_ALPHA8UI_EXT = 36222;
    public static final int GL_ALPHA_INTEGER_EXT = 36247;
    public static final int GL_BGRA_INTEGER_EXT = 36251;
    public static final int GL_BGR_INTEGER_EXT = 36250;
    public static final int GL_BLUE_INTEGER_EXT = 36246;
    public static final int GL_GREEN_INTEGER_EXT = 36245;
    public static final int GL_INTENSITY16I_EXT = 36235;
    public static final int GL_INTENSITY16UI_EXT = 36217;
    public static final int GL_INTENSITY32I_EXT = 36229;
    public static final int GL_INTENSITY32UI_EXT = 36211;
    public static final int GL_INTENSITY8I_EXT = 36241;
    public static final int GL_INTENSITY8UI_EXT = 36223;
    public static final int GL_LUMINANCE16I_EXT = 36236;
    public static final int GL_LUMINANCE16UI_EXT = 36218;
    public static final int GL_LUMINANCE32I_EXT = 36230;
    public static final int GL_LUMINANCE32UI_EXT = 36212;
    public static final int GL_LUMINANCE8I_EXT = 36242;
    public static final int GL_LUMINANCE8UI_EXT = 36224;
    public static final int GL_LUMINANCE_ALPHA16I_EXT = 36237;
    public static final int GL_LUMINANCE_ALPHA16UI_EXT = 36219;
    public static final int GL_LUMINANCE_ALPHA32I_EXT = 36231;
    public static final int GL_LUMINANCE_ALPHA32UI_EXT = 36213;
    public static final int GL_LUMINANCE_ALPHA8I_EXT = 36243;
    public static final int GL_LUMINANCE_ALPHA8UI_EXT = 36225;
    public static final int GL_LUMINANCE_ALPHA_INTEGER_EXT = 36253;
    public static final int GL_LUMINANCE_INTEGER_EXT = 36252;
    public static final int GL_RED_INTEGER_EXT = 36244;
    public static final int GL_RGB16I_EXT = 36233;
    public static final int GL_RGB16UI_EXT = 36215;
    public static final int GL_RGB32I_EXT = 36227;
    public static final int GL_RGB32UI_EXT = 36209;
    public static final int GL_RGB8I_EXT = 36239;
    public static final int GL_RGB8UI_EXT = 36221;
    public static final int GL_RGBA16I_EXT = 36232;
    public static final int GL_RGBA16UI_EXT = 36214;
    public static final int GL_RGBA32I_EXT = 36226;
    public static final int GL_RGBA32UI_EXT = 36208;
    public static final int GL_RGBA8I_EXT = 36238;
    public static final int GL_RGBA8UI_EXT = 36220;
    public static final int GL_RGBA_INTEGER_EXT = 36249;
    public static final int GL_RGBA_INTEGER_MODE_EXT = 36254;
    public static final int GL_RGB_INTEGER_EXT = 36248;

    private EXTTextureInteger() {
    }

    public static void glClearColorIiEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glClearColorIiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglClearColorIiEXT(i5, i6, i7, i8, j);
    }

    public static void glClearColorIuiEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glClearColorIuiEXT;
        BufferChecks.checkFunctionAddress(j);
        nglClearColorIuiEXT(i5, i6, i7, i8, j);
    }

    public static void glGetTexParameterIEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexParameterIivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetTexParameterIiEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexParameterIivEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGetTexParameterIuEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetTexParameterIuivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetTexParameterIuiEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetTexParameterIuivEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glTexParameterIEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexParameterIivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexParameterIiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexParameterIivEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTexParameterIivEXT(i4, i5, APIUtil.getInt(capabilities, i6), j);
    }

    public static void glTexParameterIuEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglTexParameterIuivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glTexParameterIuiEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glTexParameterIuivEXT;
        BufferChecks.checkFunctionAddress(j);
        nglTexParameterIuivEXT(i4, i5, APIUtil.getInt(capabilities, i6), j);
    }

    static native void nglClearColorIiEXT(int i, int i2, int i3, int i4, long j);

    static native void nglClearColorIuiEXT(int i, int i2, int i3, int i4, long j);

    static native void nglGetTexParameterIivEXT(int i, int i2, long j, long j2);

    static native void nglGetTexParameterIuivEXT(int i, int i2, long j, long j2);

    static native void nglTexParameterIivEXT(int i, int i2, long j, long j2);

    static native void nglTexParameterIuivEXT(int i, int i2, long j, long j2);
}

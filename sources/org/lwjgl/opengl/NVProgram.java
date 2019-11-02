package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public class NVProgram {
    public static final int GL_PROGRAM_ERROR_POSITION_NV = 34379;
    public static final int GL_PROGRAM_ERROR_STRING_NV = 34932;
    public static final int GL_PROGRAM_LENGTH_NV = 34343;
    public static final int GL_PROGRAM_RESIDENT_NV = 34375;
    public static final int GL_PROGRAM_STRING_NV = 34344;
    public static final int GL_PROGRAM_TARGET_NV = 34374;

    public NVProgram() {
    }

    public static boolean glAreProgramsResidentNV(IntBuffer intBuffer, ByteBuffer byteBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glAreProgramsResidentNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        BufferChecks.checkBuffer(byteBuffer2, intBuffer2.remaining());
        return nglAreProgramsResidentNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glBindProgramNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindProgramNV;
        BufferChecks.checkFunctionAddress(j);
        nglBindProgramNV(i3, i4, j);
    }

    public static void glDeleteProgramsNV(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteProgramsNV;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteProgramsNV(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteProgramsNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteProgramsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteProgramsNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenProgramsNV() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenProgramsNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenProgramsNV(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenProgramsNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenProgramsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenProgramsNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    @Deprecated
    public static int glGetProgramNV(int i, int i2) {
        return glGetProgramiNV(i, i2);
    }

    public static void glGetProgramNV(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetProgramivNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGetProgramivNV(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static String glGetProgramStringNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramStringNV;
        BufferChecks.checkFunctionAddress(j);
        int glGetProgramiNV = glGetProgramiNV(i3, 34343);
        ByteBuffer bufferByte = APIUtil.getBufferByte(capabilities, glGetProgramiNV);
        nglGetProgramStringNV(i3, i4, MemoryUtil.getAddress(bufferByte), j);
        Buffer limit = bufferByte.limit(glGetProgramiNV);
        return APIUtil.getString(capabilities, bufferByte);
    }

    public static void glGetProgramStringNV(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glGetProgramStringNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglGetProgramStringNV(i3, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static int glGetProgramiNV(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetProgramivNV;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetProgramivNV(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsProgramNV(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsProgramNV;
        BufferChecks.checkFunctionAddress(j);
        return nglIsProgramNV(i2, j);
    }

    public static void glLoadProgramNV(int i, int i2, CharSequence charSequence) {
        int i3 = i;
        int i4 = i2;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glLoadProgramNV;
        BufferChecks.checkFunctionAddress(j);
        nglLoadProgramNV(i3, i4, charSequence2.length(), APIUtil.getBuffer(capabilities, charSequence2), j);
    }

    public static void glLoadProgramNV(int i, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glLoadProgramNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglLoadProgramNV(i3, i4, byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glRequestResidentProgramsNV(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glRequestResidentProgramsNV;
        BufferChecks.checkFunctionAddress(j);
        nglRequestResidentProgramsNV(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glRequestResidentProgramsNV(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glRequestResidentProgramsNV;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglRequestResidentProgramsNV(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    static native boolean nglAreProgramsResidentNV(int i, long j, long j2, long j3);

    static native void nglBindProgramNV(int i, int i2, long j);

    static native void nglDeleteProgramsNV(int i, long j, long j2);

    static native void nglGenProgramsNV(int i, long j, long j2);

    static native void nglGetProgramStringNV(int i, int i2, long j, long j2);

    static native void nglGetProgramivNV(int i, int i2, long j, long j2);

    static native boolean nglIsProgramNV(int i, long j);

    static native void nglLoadProgramNV(int i, int i2, int i3, long j, long j2);

    static native void nglRequestResidentProgramsNV(int i, long j, long j2);
}

package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;

public final class ARBVertexBlend {
    public static final int GL_ACTIVE_VERTEX_UNITS_ARB = 34469;
    public static final int GL_CURRENT_WEIGHT_ARB = 34472;
    public static final int GL_MAX_VERTEX_UNITS_ARB = 34468;
    public static final int GL_MODELVIEW0_ARB = 5888;
    public static final int GL_MODELVIEW10_ARB = 34602;
    public static final int GL_MODELVIEW11_ARB = 34603;
    public static final int GL_MODELVIEW12_ARB = 34604;
    public static final int GL_MODELVIEW13_ARB = 34605;
    public static final int GL_MODELVIEW14_ARB = 34606;
    public static final int GL_MODELVIEW15_ARB = 34607;
    public static final int GL_MODELVIEW16_ARB = 34608;
    public static final int GL_MODELVIEW17_ARB = 34609;
    public static final int GL_MODELVIEW18_ARB = 34610;
    public static final int GL_MODELVIEW19_ARB = 34611;
    public static final int GL_MODELVIEW1_ARB = 34058;
    public static final int GL_MODELVIEW20_ARB = 34612;
    public static final int GL_MODELVIEW21_ARB = 34613;
    public static final int GL_MODELVIEW22_ARB = 34614;
    public static final int GL_MODELVIEW23_ARB = 34615;
    public static final int GL_MODELVIEW24_ARB = 34616;
    public static final int GL_MODELVIEW25_ARB = 34617;
    public static final int GL_MODELVIEW26_ARB = 34618;
    public static final int GL_MODELVIEW27_ARB = 34619;
    public static final int GL_MODELVIEW28_ARB = 34620;
    public static final int GL_MODELVIEW29_ARB = 34621;
    public static final int GL_MODELVIEW2_ARB = 34594;
    public static final int GL_MODELVIEW30_ARB = 34622;
    public static final int GL_MODELVIEW31_ARB = 34623;
    public static final int GL_MODELVIEW3_ARB = 34595;
    public static final int GL_MODELVIEW4_ARB = 34596;
    public static final int GL_MODELVIEW5_ARB = 34597;
    public static final int GL_MODELVIEW6_ARB = 34598;
    public static final int GL_MODELVIEW7_ARB = 34599;
    public static final int GL_MODELVIEW8_ARB = 34600;
    public static final int GL_MODELVIEW9_ARB = 34601;
    public static final int GL_VERTEX_BLEND_ARB = 34471;
    public static final int GL_WEIGHT_ARRAY_ARB = 34477;
    public static final int GL_WEIGHT_ARRAY_POINTER_ARB = 34476;
    public static final int GL_WEIGHT_ARRAY_SIZE_ARB = 34475;
    public static final int GL_WEIGHT_ARRAY_STRIDE_ARB = 34474;
    public static final int GL_WEIGHT_ARRAY_TYPE_ARB = 34473;
    public static final int GL_WEIGHT_SUM_UNITY_ARB = 34470;

    private ARBVertexBlend() {
    }

    public static void glVertexBlendARB(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glVertexBlendARB;
        BufferChecks.checkFunctionAddress(j);
        nglVertexBlendARB(i2, j);
    }

    public static void glWeightARB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glWeightbvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglWeightbvARB(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glWeightARB(DoubleBuffer doubleBuffer) {
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        long j = GLContext.getCapabilities().glWeightdvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(doubleBuffer2);
        nglWeightdvARB(doubleBuffer2.remaining(), MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glWeightARB(FloatBuffer floatBuffer) {
        FloatBuffer floatBuffer2 = floatBuffer;
        long j = GLContext.getCapabilities().glWeightfvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(floatBuffer2);
        nglWeightfvARB(floatBuffer2.remaining(), MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glWeightARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glWeightivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglWeightivARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glWeightARB(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glWeightsvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglWeightsvARB(shortBuffer2.remaining(), MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glWeightPointerARB(int i, int i2, int i3, long j) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j2 = j;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j3 = capabilities.glWeightPointerARB;
        BufferChecks.checkFunctionAddress(j3);
        GLChecks.ensureArrayVBOenabled(capabilities);
        nglWeightPointerARBBO(i4, i5, i6, j2, j3);
    }

    public static void glWeightPointerARB(int i, int i2, DoubleBuffer doubleBuffer) {
        int i3 = i;
        int i4 = i2;
        DoubleBuffer doubleBuffer2 = doubleBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glWeightPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(doubleBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_vertex_blend_glWeightPointerARB_pPointer = doubleBuffer2;
        }
        nglWeightPointerARB(i3, 5130, i4, MemoryUtil.getAddress(doubleBuffer2), j);
    }

    public static void glWeightPointerARB(int i, int i2, FloatBuffer floatBuffer) {
        int i3 = i;
        int i4 = i2;
        FloatBuffer floatBuffer2 = floatBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glWeightPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(floatBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_vertex_blend_glWeightPointerARB_pPointer = floatBuffer2;
        }
        nglWeightPointerARB(i3, GL11.GL_FLOAT, i4, MemoryUtil.getAddress(floatBuffer2), j);
    }

    public static void glWeightPointerARB(int i, boolean z, int i2, ByteBuffer byteBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glWeightPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(byteBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_vertex_blend_glWeightPointerARB_pPointer = byteBuffer2;
        }
        nglWeightPointerARB(i3, z2 ? 5121 : 5120, i4, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glWeightPointerARB(int i, boolean z, int i2, IntBuffer intBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glWeightPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(intBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_vertex_blend_glWeightPointerARB_pPointer = intBuffer2;
        }
        nglWeightPointerARB(i3, z2 ? 5125 : 5124, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glWeightPointerARB(int i, boolean z, int i2, ShortBuffer shortBuffer) {
        int i3 = i;
        boolean z2 = z;
        int i4 = i2;
        ShortBuffer shortBuffer2 = shortBuffer;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glWeightPointerARB;
        BufferChecks.checkFunctionAddress(j);
        GLChecks.ensureArrayVBOdisabled(capabilities);
        BufferChecks.checkDirect(shortBuffer2);
        if (LWJGLUtil.CHECKS) {
            StateTracker.getReferences(capabilities).ARB_vertex_blend_glWeightPointerARB_pPointer = shortBuffer2;
        }
        nglWeightPointerARB(i3, z2 ? 5123 : 5122, i4, MemoryUtil.getAddress(shortBuffer2), j);
    }

    public static void glWeightuARB(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glWeightubvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        nglWeightubvARB(byteBuffer2.remaining(), MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glWeightuARB(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glWeightuivARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglWeightuivARB(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glWeightuARB(ShortBuffer shortBuffer) {
        ShortBuffer shortBuffer2 = shortBuffer;
        long j = GLContext.getCapabilities().glWeightusvARB;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(shortBuffer2);
        nglWeightusvARB(shortBuffer2.remaining(), MemoryUtil.getAddress(shortBuffer2), j);
    }

    static native void nglVertexBlendARB(int i, long j);

    static native void nglWeightPointerARB(int i, int i2, int i3, long j, long j2);

    static native void nglWeightPointerARBBO(int i, int i2, int i3, long j, long j2);

    static native void nglWeightbvARB(int i, long j, long j2);

    static native void nglWeightdvARB(int i, long j, long j2);

    static native void nglWeightfvARB(int i, long j, long j2);

    static native void nglWeightivARB(int i, long j, long j2);

    static native void nglWeightsvARB(int i, long j, long j2);

    static native void nglWeightubvARB(int i, long j, long j2);

    static native void nglWeightuivARB(int i, long j, long j2);

    static native void nglWeightusvARB(int i, long j, long j2);
}

package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class ATIDrawBuffers {
    public static final int GL_DRAW_BUFFER0_ATI = 34853;
    public static final int GL_DRAW_BUFFER10_ATI = 34863;
    public static final int GL_DRAW_BUFFER11_ATI = 34864;
    public static final int GL_DRAW_BUFFER12_ATI = 34865;
    public static final int GL_DRAW_BUFFER13_ATI = 34866;
    public static final int GL_DRAW_BUFFER14_ATI = 34867;
    public static final int GL_DRAW_BUFFER15_ATI = 34868;
    public static final int GL_DRAW_BUFFER1_ATI = 34854;
    public static final int GL_DRAW_BUFFER2_ATI = 34855;
    public static final int GL_DRAW_BUFFER3_ATI = 34856;
    public static final int GL_DRAW_BUFFER4_ATI = 34857;
    public static final int GL_DRAW_BUFFER5_ATI = 34858;
    public static final int GL_DRAW_BUFFER6_ATI = 34859;
    public static final int GL_DRAW_BUFFER7_ATI = 34860;
    public static final int GL_DRAW_BUFFER8_ATI = 34861;
    public static final int GL_DRAW_BUFFER9_ATI = 34862;
    public static final int GL_MAX_DRAW_BUFFERS_ATI = 34852;

    private ATIDrawBuffers() {
    }

    public static void glDrawBuffersATI(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDrawBuffersATI;
        BufferChecks.checkFunctionAddress(j);
        nglDrawBuffersATI(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDrawBuffersATI(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDrawBuffersATI;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDrawBuffersATI(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    static native void nglDrawBuffersATI(int i, long j, long j2);
}

package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTSeparateShaderObjects {
    public static final int GL_ACTIVE_PROGRAM_EXT = 35725;

    private EXTSeparateShaderObjects() {
    }

    public static void glActiveProgramEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glActiveProgramEXT;
        BufferChecks.checkFunctionAddress(j);
        nglActiveProgramEXT(i2, j);
    }

    public static int glCreateShaderProgramEXT(int i, CharSequence charSequence) {
        int i2 = i;
        CharSequence charSequence2 = charSequence;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glCreateShaderProgramEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglCreateShaderProgramEXT(i2, APIUtil.getBufferNT(capabilities, charSequence2), j);
    }

    public static int glCreateShaderProgramEXT(int i, ByteBuffer byteBuffer) {
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j = GLContext.getCapabilities().glCreateShaderProgramEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(byteBuffer2);
        BufferChecks.checkNullTerminated(byteBuffer2);
        return nglCreateShaderProgramEXT(i2, MemoryUtil.getAddress(byteBuffer2), j);
    }

    public static void glUseShaderProgramEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glUseShaderProgramEXT;
        BufferChecks.checkFunctionAddress(j);
        nglUseShaderProgramEXT(i3, i4, j);
    }

    static native void nglActiveProgramEXT(int i, long j);

    static native int nglCreateShaderProgramEXT(int i, long j, long j2);

    static native void nglUseShaderProgramEXT(int i, int i2, long j);
}

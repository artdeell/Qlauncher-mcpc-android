package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBGetProgramBinary {
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 34814;
    public static final int GL_PROGRAM_BINARY_FORMATS = 34815;
    public static final int GL_PROGRAM_BINARY_LENGTH = 34625;
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 33367;

    private ARBGetProgramBinary() {
    }

    public static void glGetProgramBinary(int i, IntBuffer intBuffer, IntBuffer intBuffer2, ByteBuffer byteBuffer) {
        GL41.glGetProgramBinary(i, intBuffer, intBuffer2, byteBuffer);
    }

    public static void glProgramBinary(int i, int i2, ByteBuffer byteBuffer) {
        GL41.glProgramBinary(i, i2, byteBuffer);
    }

    public static void glProgramParameteri(int i, int i2, int i3) {
        GL41.glProgramParameteri(i, i2, i3);
    }
}

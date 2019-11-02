package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.MemoryUtil;

public final class EXTFramebufferObject {
    public static final int GL_COLOR_ATTACHMENT0_EXT = 36064;
    public static final int GL_COLOR_ATTACHMENT10_EXT = 36074;
    public static final int GL_COLOR_ATTACHMENT11_EXT = 36075;
    public static final int GL_COLOR_ATTACHMENT12_EXT = 36076;
    public static final int GL_COLOR_ATTACHMENT13_EXT = 36077;
    public static final int GL_COLOR_ATTACHMENT14_EXT = 36078;
    public static final int GL_COLOR_ATTACHMENT15_EXT = 36079;
    public static final int GL_COLOR_ATTACHMENT1_EXT = 36065;
    public static final int GL_COLOR_ATTACHMENT2_EXT = 36066;
    public static final int GL_COLOR_ATTACHMENT3_EXT = 36067;
    public static final int GL_COLOR_ATTACHMENT4_EXT = 36068;
    public static final int GL_COLOR_ATTACHMENT5_EXT = 36069;
    public static final int GL_COLOR_ATTACHMENT6_EXT = 36070;
    public static final int GL_COLOR_ATTACHMENT7_EXT = 36071;
    public static final int GL_COLOR_ATTACHMENT8_EXT = 36072;
    public static final int GL_COLOR_ATTACHMENT9_EXT = 36073;
    public static final int GL_DEPTH_ATTACHMENT_EXT = 36096;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_EXT = 36049;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_EXT = 36048;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET_EXT = 36052;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_EXT = 36051;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_EXT = 36050;
    public static final int GL_FRAMEBUFFER_BINDING_EXT = 36006;
    public static final int GL_FRAMEBUFFER_COMPLETE_EXT = 36053;
    public static final int GL_FRAMEBUFFER_EXT = 36160;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT = 36054;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT = 36057;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT = 36059;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT = 36058;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT = 36055;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT = 36060;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED_EXT = 36061;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION_EXT = 1286;
    public static final int GL_MAX_COLOR_ATTACHMENTS_EXT = 36063;
    public static final int GL_MAX_RENDERBUFFER_SIZE_EXT = 34024;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE_EXT = 36179;
    public static final int GL_RENDERBUFFER_BINDING_EXT = 36007;
    public static final int GL_RENDERBUFFER_BLUE_SIZE_EXT = 36178;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE_EXT = 36180;
    public static final int GL_RENDERBUFFER_EXT = 36161;
    public static final int GL_RENDERBUFFER_GREEN_SIZE_EXT = 36177;
    public static final int GL_RENDERBUFFER_HEIGHT_EXT = 36163;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_EXT = 36164;
    public static final int GL_RENDERBUFFER_RED_SIZE_EXT = 36176;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE_EXT = 36181;
    public static final int GL_RENDERBUFFER_WIDTH_EXT = 36162;
    public static final int GL_STENCIL_ATTACHMENT_EXT = 36128;
    public static final int GL_STENCIL_INDEX16_EXT = 36169;
    public static final int GL_STENCIL_INDEX1_EXT = 36166;
    public static final int GL_STENCIL_INDEX4_EXT = 36167;
    public static final int GL_STENCIL_INDEX8_EXT = 36168;

    private EXTFramebufferObject() {
    }

    public static void glBindFramebufferEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindFramebufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBindFramebufferEXT(i3, i4, j);
    }

    public static void glBindRenderbufferEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long j = GLContext.getCapabilities().glBindRenderbufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglBindRenderbufferEXT(i3, i4, j);
    }

    public static int glCheckFramebufferStatusEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glCheckFramebufferStatusEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglCheckFramebufferStatusEXT(i2, j);
    }

    public static void glDeleteFramebuffersEXT(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteFramebuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteFramebuffersEXT(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteFramebuffersEXT(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteFramebuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteFramebuffersEXT(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glDeleteRenderbuffersEXT(int i) {
        int i2 = i;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glDeleteRenderbuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        nglDeleteRenderbuffersEXT(1, APIUtil.getInt(capabilities, i2), j);
    }

    public static void glDeleteRenderbuffersEXT(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glDeleteRenderbuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglDeleteRenderbuffersEXT(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glFramebufferRenderbufferEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glFramebufferRenderbufferEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferRenderbufferEXT(i5, i6, i7, i8, j);
    }

    public static void glFramebufferTexture1DEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTexture1DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTexture1DEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glFramebufferTexture2DEXT(int i, int i2, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        long j = GLContext.getCapabilities().glFramebufferTexture2DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTexture2DEXT(i6, i7, i8, i9, i10, j);
    }

    public static void glFramebufferTexture3DEXT(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        long j = GLContext.getCapabilities().glFramebufferTexture3DEXT;
        BufferChecks.checkFunctionAddress(j);
        nglFramebufferTexture3DEXT(i7, i8, i9, i10, i11, i12, j);
    }

    public static int glGenFramebuffersEXT() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenFramebuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenFramebuffersEXT(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenFramebuffersEXT(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenFramebuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenFramebuffersEXT(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGenRenderbuffersEXT() {
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGenRenderbuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGenRenderbuffersEXT(1, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static void glGenRenderbuffersEXT(IntBuffer intBuffer) {
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGenRenderbuffersEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkDirect(intBuffer2);
        nglGenRenderbuffersEXT(intBuffer2.remaining(), MemoryUtil.getAddress(intBuffer2), j);
    }

    public static void glGenerateMipmapEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glGenerateMipmapEXT;
        BufferChecks.checkFunctionAddress(j);
        nglGenerateMipmapEXT(i2, j);
    }

    @Deprecated
    public static int glGetFramebufferAttachmentParameterEXT(int i, int i2, int i3) {
        return glGetFramebufferAttachmentParameteriEXT(i, i2, i3);
    }

    public static void glGetFramebufferAttachmentParameterEXT(int i, int i2, int i3, IntBuffer intBuffer) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetFramebufferAttachmentParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetFramebufferAttachmentParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetFramebufferAttachmentParameteriEXT(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetFramebufferAttachmentParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetFramebufferAttachmentParameterivEXT(i4, i5, i6, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    @Deprecated
    public static int glGetRenderbufferParameterEXT(int i, int i2) {
        return glGetRenderbufferParameteriEXT(i, i2);
    }

    public static void glGetRenderbufferParameterEXT(int i, int i2, IntBuffer intBuffer) {
        int i3 = i;
        int i4 = i2;
        IntBuffer intBuffer2 = intBuffer;
        long j = GLContext.getCapabilities().glGetRenderbufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        BufferChecks.checkBuffer(intBuffer2, 4);
        nglGetRenderbufferParameterivEXT(i3, i4, MemoryUtil.getAddress(intBuffer2), j);
    }

    public static int glGetRenderbufferParameteriEXT(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ContextCapabilities capabilities = GLContext.getCapabilities();
        long j = capabilities.glGetRenderbufferParameterivEXT;
        BufferChecks.checkFunctionAddress(j);
        IntBuffer bufferInt = APIUtil.getBufferInt(capabilities);
        nglGetRenderbufferParameterivEXT(i3, i4, MemoryUtil.getAddress(bufferInt), j);
        return bufferInt.get(0);
    }

    public static boolean glIsFramebufferEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsFramebufferEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglIsFramebufferEXT(i2, j);
    }

    public static boolean glIsRenderbufferEXT(int i) {
        int i2 = i;
        long j = GLContext.getCapabilities().glIsRenderbufferEXT;
        BufferChecks.checkFunctionAddress(j);
        return nglIsRenderbufferEXT(i2, j);
    }

    public static void glRenderbufferStorageEXT(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j = GLContext.getCapabilities().glRenderbufferStorageEXT;
        BufferChecks.checkFunctionAddress(j);
        nglRenderbufferStorageEXT(i5, i6, i7, i8, j);
    }

    static native void nglBindFramebufferEXT(int i, int i2, long j);

    static native void nglBindRenderbufferEXT(int i, int i2, long j);

    static native int nglCheckFramebufferStatusEXT(int i, long j);

    static native void nglDeleteFramebuffersEXT(int i, long j, long j2);

    static native void nglDeleteRenderbuffersEXT(int i, long j, long j2);

    static native void nglFramebufferRenderbufferEXT(int i, int i2, int i3, int i4, long j);

    static native void nglFramebufferTexture1DEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglFramebufferTexture2DEXT(int i, int i2, int i3, int i4, int i5, long j);

    static native void nglFramebufferTexture3DEXT(int i, int i2, int i3, int i4, int i5, int i6, long j);

    static native void nglGenFramebuffersEXT(int i, long j, long j2);

    static native void nglGenRenderbuffersEXT(int i, long j, long j2);

    static native void nglGenerateMipmapEXT(int i, long j);

    static native void nglGetFramebufferAttachmentParameterivEXT(int i, int i2, int i3, long j, long j2);

    static native void nglGetRenderbufferParameterivEXT(int i, int i2, long j, long j2);

    static native boolean nglIsFramebufferEXT(int i, long j);

    static native boolean nglIsRenderbufferEXT(int i, long j);

    static native void nglRenderbufferStorageEXT(int i, int i2, int i3, int i4, long j);
}

package org.lwjgl.opengl;

public final class ARBVertexAttribBinding {
    public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 33498;
    public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 33497;
    public static final int GL_VERTEX_ATTRIB_BINDING = 33492;
    public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 33493;
    public static final int GL_VERTEX_BINDING_DIVISOR = 33494;
    public static final int GL_VERTEX_BINDING_OFFSET = 33495;
    public static final int GL_VERTEX_BINDING_STRIDE = 33496;

    private ARBVertexAttribBinding() {
    }

    public static void glBindVertexBuffer(int i, int i2, long j, int i3) {
        GL43.glBindVertexBuffer(i, i2, j, i3);
    }

    public static void glVertexAttribBinding(int i, int i2) {
        GL43.glVertexAttribBinding(i, i2);
    }

    public static void glVertexAttribFormat(int i, int i2, int i3, boolean z, int i4) {
        GL43.glVertexAttribFormat(i, i2, i3, z, i4);
    }

    public static void glVertexAttribIFormat(int i, int i2, int i3, int i4) {
        GL43.glVertexAttribIFormat(i, i2, i3, i4);
    }

    public static void glVertexAttribLFormat(int i, int i2, int i3, int i4) {
        GL43.glVertexAttribLFormat(i, i2, i3, i4);
    }

    public static void glVertexBindingDivisor(int i, int i2) {
        GL43.glVertexBindingDivisor(i, i2);
    }
}

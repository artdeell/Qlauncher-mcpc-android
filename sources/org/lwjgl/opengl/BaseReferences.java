package org.lwjgl.opengl;

import java.nio.Buffer;
import java.util.Arrays;

class BaseReferences {
    int arrayBuffer;
    int elementArrayBuffer;
    int glClientActiveTexture;
    final Buffer[] glTexCoordPointer_buffer;
    final Buffer[] glVertexAttribPointer_buffer;
    int indirectBuffer;
    int pixelPackBuffer;
    int pixelUnpackBuffer;
    int vertexArrayObject;

    BaseReferences(ContextCapabilities contextCapabilities) {
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        this.glVertexAttribPointer_buffer = new Buffer[((contextCapabilities2.OpenGL20 || contextCapabilities2.GL_ARB_vertex_shader) ? GL11.glGetInteger(34921) : 0)];
        int glGetInteger = contextCapabilities2.OpenGL20 ? GL11.glGetInteger(34930) : (contextCapabilities2.OpenGL13 || contextCapabilities2.GL_ARB_multitexture) ? GL11.glGetInteger(34018) : 1;
        this.glTexCoordPointer_buffer = new Buffer[glGetInteger];
    }

    /* access modifiers changed from: 0000 */
    public void clear() {
        this.elementArrayBuffer = 0;
        this.arrayBuffer = 0;
        this.glClientActiveTexture = 0;
        Arrays.fill(this.glVertexAttribPointer_buffer, null);
        Arrays.fill(this.glTexCoordPointer_buffer, null);
        this.vertexArrayObject = 0;
        this.pixelPackBuffer = 0;
        this.pixelUnpackBuffer = 0;
        this.indirectBuffer = 0;
    }

    /* access modifiers changed from: 0000 */
    public void copy(BaseReferences baseReferences, int i) {
        BaseReferences baseReferences2 = baseReferences;
        int i2 = i;
        if ((i2 & 2) != 0) {
            this.elementArrayBuffer = baseReferences2.elementArrayBuffer;
            this.arrayBuffer = baseReferences2.arrayBuffer;
            this.glClientActiveTexture = baseReferences2.glClientActiveTexture;
            System.arraycopy(baseReferences2.glVertexAttribPointer_buffer, 0, this.glVertexAttribPointer_buffer, 0, this.glVertexAttribPointer_buffer.length);
            System.arraycopy(baseReferences2.glTexCoordPointer_buffer, 0, this.glTexCoordPointer_buffer, 0, this.glTexCoordPointer_buffer.length);
            this.vertexArrayObject = baseReferences2.vertexArrayObject;
            this.indirectBuffer = baseReferences2.indirectBuffer;
        }
        if ((i2 & 1) != 0) {
            this.pixelPackBuffer = baseReferences2.pixelPackBuffer;
            this.pixelUnpackBuffer = baseReferences2.pixelUnpackBuffer;
        }
    }
}

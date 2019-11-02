package org.lwjgl.test.opengl.pbuffers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Pbuffer;

abstract class TextureRenderer {
    protected final int height;
    protected Pbuffer pbuffer;
    private final int texID;
    protected final int width;

    protected TextureRenderer(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.width = i4;
        this.height = i5;
        this.texID = i6;
        try {
            this.pbuffer = init(i4, i5, i6);
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void destroy() {
        this.pbuffer.destroy();
    }

    /* access modifiers changed from: 0000 */
    public void enable() {
        RuntimeException runtimeException;
        try {
            if (this.pbuffer.isBufferLost()) {
                System.out.println("Buffer contents lost - recreating the pbuffer");
                this.pbuffer.destroy();
                this.pbuffer = init(this.width, this.height, this.texID);
            }
            this.pbuffer.makeCurrent();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
            throw runtimeException2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Pbuffer init(int i, int i2, int i3) throws LWJGLException;

    /* access modifiers changed from: 0000 */
    public abstract void updateTexture();
}

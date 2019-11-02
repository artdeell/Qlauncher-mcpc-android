package org.lwjgl.test.opengl.pbuffers;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;

final class UniqueRenderer extends TextureRenderer {
    UniqueRenderer(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    /* access modifiers changed from: protected */
    public Pbuffer init(int i, int i2, int i3) {
        LWJGLException lWJGLException;
        Pbuffer pbuffer;
        PixelFormat pixelFormat;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        Pbuffer pbuffer2 = null;
        try {
            Pbuffer pbuffer3 = pbuffer;
            int i7 = i4;
            int i8 = i5;
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(16, 0, 0, 0, 0);
            Pbuffer pbuffer4 = new Pbuffer(i7, i8, pixelFormat2, null, null);
            Pbuffer pbuffer5 = pbuffer3;
            try {
                pbuffer5.makeCurrent();
                PbufferTest.initGLState(i4, i5, 0.5f);
                GL11.glBindTexture(3553, i6);
                Display.makeCurrent();
                return pbuffer5;
            } catch (LWJGLException e) {
                lWJGLException = e;
                pbuffer2 = pbuffer5;
                lWJGLException.printStackTrace();
                System.exit(-1);
                return pbuffer2;
            }
        } catch (LWJGLException e2) {
            lWJGLException = e2;
            lWJGLException.printStackTrace();
            System.exit(-1);
            return pbuffer2;
        }
    }

    public void updateTexture() {
        GL11.glCopyTexImage2D(3553, 0, GL11.GL_RGB, 0, 0, this.width, this.height, 0);
    }
}

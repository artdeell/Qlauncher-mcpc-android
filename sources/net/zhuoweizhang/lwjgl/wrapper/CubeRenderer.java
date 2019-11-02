package net.zhuoweizhang.lwjgl.wrapper;

import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

class CubeRenderer implements Renderer {
    private float mAngle;
    private Cube mCube;
    private boolean mTranslucentBackground;

    public CubeRenderer(boolean z) {
        Cube cube;
        this.mTranslucentBackground = z;
        Cube cube2 = cube;
        Cube cube3 = new Cube();
        this.mCube = cube2;
    }

    public void onDrawFrame(GL10 gl10) {
        GL10 gl102 = gl10;
        GL11.glClear(16640);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -3.0f);
        GL11.glRotatef(this.mAngle, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(0.25f * this.mAngle, 1.0f, 0.0f, 0.0f);
        GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        GL11.glEnableClientState(GL11.GL_COLOR_ARRAY);
        this.mCube.draw(gl102);
        GL11.glRotatef(2.0f * this.mAngle, 0.0f, 1.0f, 1.0f);
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        this.mCube.draw(gl102);
        this.mAngle = 1.2f + this.mAngle;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GL10 gl102 = gl10;
        int i3 = i;
        int i4 = i2;
        GL11.glViewport(0, 0, i3, i4);
        float f = ((float) i3) / ((float) i4);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glFrustum((double) (-f), (double) f, -1.0d, 1.0d, 1.0d, 10.0d);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GL10 gl102 = gl10;
        EGLConfig eGLConfig2 = eGLConfig;
        try {
            Display.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GL11.glDisable(GL11.GL_DITHER);
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, 4353);
        if (this.mTranslucentBackground) {
            GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        }
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
}

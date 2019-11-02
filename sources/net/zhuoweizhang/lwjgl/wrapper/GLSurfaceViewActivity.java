package net.zhuoweizhang.lwjgl.wrapper;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class GLSurfaceViewActivity extends Activity {
    private GLSurfaceView mGLSurfaceView;

    public GLSurfaceViewActivity() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        GLSurfaceView gLSurfaceView;
        CubeRenderer cubeRenderer;
        Bundle bundle2 = bundle;
        System.loadLibrary("glshim");
        super.onCreate(bundle2);
        GLSurfaceView gLSurfaceView2 = gLSurfaceView;
        GLSurfaceView gLSurfaceView3 = new GLSurfaceView(this);
        this.mGLSurfaceView = gLSurfaceView2;
        GLSurfaceView gLSurfaceView4 = this.mGLSurfaceView;
        CubeRenderer cubeRenderer2 = cubeRenderer;
        CubeRenderer cubeRenderer3 = new CubeRenderer(false);
        gLSurfaceView4.setRenderer(cubeRenderer2);
        setContentView(this.mGLSurfaceView);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mGLSurfaceView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mGLSurfaceView.onResume();
    }
}

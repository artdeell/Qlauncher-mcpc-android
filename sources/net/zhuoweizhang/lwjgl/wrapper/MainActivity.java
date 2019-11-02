package net.zhuoweizhang.lwjgl.wrapper;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.lwjgl.test.opengl.Gears;

public class MainActivity extends Activity {
    public static final String TAG = "LWJGLWrapperTest";
    /* access modifiers changed from: private */
    public static Gears gears;
    private GLSurfaceView mGLView;

    private class WrappedRenderer implements Renderer {
        final /* synthetic */ MainActivity this$0;

        private WrappedRenderer(MainActivity mainActivity) {
            this.this$0 = mainActivity;
        }

        /* synthetic */ WrappedRenderer(MainActivity mainActivity, C07361 r7) {
            C07361 r2 = r7;
            this(mainActivity);
        }

        public void onDrawFrame(GL10 gl10) {
            GL10 gl102 = gl10;
            MainActivity.gears.tick();
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GL10 gl102 = gl10;
            int i3 = i;
            int i4 = i2;
            int i5 = Log.i(MainActivity.TAG, "Surface changed");
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GL10 gl102 = gl10;
            EGLConfig eGLConfig2 = eGLConfig;
            int i = Log.i(MainActivity.TAG, "Surface created");
            this.this$0.initGears();
        }
    }

    public MainActivity() {
    }

    public void initGears() {
        try {
            gears.init();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        GLSurfaceView gLSurfaceView;
        WrappedRenderer wrappedRenderer;
        Gears gears2;
        Bundle bundle2 = bundle;
        System.loadLibrary("glshim");
        super.onCreate(bundle2);
        GLSurfaceView gLSurfaceView2 = gLSurfaceView;
        GLSurfaceView gLSurfaceView3 = new GLSurfaceView(this);
        this.mGLView = gLSurfaceView2;
        GLSurfaceView gLSurfaceView4 = this.mGLView;
        WrappedRenderer wrappedRenderer2 = wrappedRenderer;
        WrappedRenderer wrappedRenderer3 = new WrappedRenderer(this, null);
        gLSurfaceView4.setRenderer(wrappedRenderer2);
        setContentView(this.mGLView);
        Gears gears3 = gears2;
        Gears gears4 = new Gears();
        gears = gears3;
    }

    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    public void onPause() {
        super.onPause();
        this.mGLView.onPause();
    }

    public void onResume() {
        super.onResume();
        this.mGLView.onResume();
    }
}

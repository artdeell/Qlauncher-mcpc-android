package net.zhuoweizhang.boardwalk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;

public class BoardwalkGLSurfaceView extends GLSurfaceView {
    public BoardwalkGLSurfaceView(Context context) {
        super(context);
    }

    public BoardwalkGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder surfaceHolder2 = surfaceHolder;
        System.out.println("Surface destroyed!");
    }
}

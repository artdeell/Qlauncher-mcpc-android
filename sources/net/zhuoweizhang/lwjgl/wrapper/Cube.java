package net.zhuoweizhang.lwjgl.wrapper;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import org.lwjgl.opengl.GL11;

class Cube {
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;
    private IntBuffer mVertexBuffer;

    public Cube() {
        int[] iArr = {-65536, -65536, -65536, 65536, -65536, -65536, 65536, 65536, -65536, -65536, 65536, -65536, -65536, -65536, 65536, 65536, -65536, 65536, 65536, 65536, 65536, -65536, 65536, 65536};
        float[] fArr = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        byte[] bArr = {0, 4, 5, 0, 5, 1, 1, 5, 6, 1, 6, 2, 2, 6, 7, 2, 7, 3, 3, 7, 4, 3, 4, 0, 4, 7, 6, 4, 6, 5, 3, 0, 1, 3, 1, 2};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4 * iArr.length);
        ByteBuffer order = allocateDirect.order(ByteOrder.nativeOrder());
        this.mVertexBuffer = allocateDirect.asIntBuffer();
        IntBuffer put = this.mVertexBuffer.put(iArr);
        Buffer position = this.mVertexBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(4 * fArr.length);
        ByteBuffer order2 = allocateDirect2.order(ByteOrder.nativeOrder());
        this.mColorBuffer = allocateDirect2.asFloatBuffer();
        FloatBuffer put2 = this.mColorBuffer.put(fArr);
        Buffer position2 = this.mColorBuffer.position(0);
        this.mIndexBuffer = ByteBuffer.allocateDirect(bArr.length);
        ByteBuffer put3 = this.mIndexBuffer.put(bArr);
        Buffer position3 = this.mIndexBuffer.position(0);
    }

    public void draw(GL10 gl10) {
        GL10 gl102 = gl10;
        GL11.glFrontFace(2304);
        GL11.glVertexPointer(3, 0, this.mVertexBuffer);
        GL11.glColorPointer(4, 0, this.mColorBuffer);
        GL11.glDrawElements(4, 36, (int) GL11.GL_UNSIGNED_BYTE, this.mIndexBuffer);
    }
}

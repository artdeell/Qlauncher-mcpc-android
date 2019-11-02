package org.lwjgl.test.glu.tessellation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLUtessellatorCallbackAdapter;

public class TessCallback extends GLUtessellatorCallbackAdapter {
    public TessCallback() {
    }

    public void begin(int i) {
        GL11.glBegin(i);
    }

    public void combine(double[] dArr, Object[] objArr, float[] fArr, Object[] objArr2) {
        VertexData vertexData;
        double[] dArr2 = dArr;
        Object[] objArr3 = objArr;
        float[] fArr2 = fArr;
        Object[] objArr4 = objArr2;
        for (int i = 0; i < objArr4.length; i++) {
            Object[] objArr5 = objArr4;
            int i2 = i;
            VertexData vertexData2 = vertexData;
            VertexData vertexData3 = new VertexData(new double[]{dArr2[0], dArr2[1], dArr2[2], 1.0d, 1.0d, 1.0d});
            objArr5[i2] = vertexData2;
        }
    }

    public void end() {
        GL11.glEnd();
    }

    public void vertex(Object obj) {
        VertexData vertexData = (VertexData) obj;
        GL11.glVertex3d(vertexData.data[0], vertexData.data[1], vertexData.data[2]);
        GL11.glColor3d(vertexData.data[3], vertexData.data[4], vertexData.data[5]);
    }
}

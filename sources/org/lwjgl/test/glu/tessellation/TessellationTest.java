package org.lwjgl.test.glu.tessellation;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLUtessellator;

public class TessellationTest {
    private GLUtessellator tesselator;

    public TessellationTest() {
    }

    private void createDisplay() throws LWJGLException {
        DisplayMode displayMode;
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(300, 300);
        Display.setDisplayMode(displayMode2);
        Display.create();
        Display.setVSyncEnabled(true);
        GL11.glEnable(3553);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0d);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glViewport(0, 0, 300, 300);
        GL11.glMatrixMode(5888);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, (double) 300, (double) 300, 0.0d, 1.0d, -1.0d);
        GL11.glMatrixMode(5888);
    }

    private void loop() {
        while (true) {
            render();
            Display.update();
            Display.sync(100);
            if (Display.isCloseRequested()) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] strArr) throws LWJGLException {
        TessellationTest tessellationTest;
        String[] strArr2 = strArr;
        TessellationTest tessellationTest2 = tessellationTest;
        TessellationTest tessellationTest3 = new TessellationTest();
        tessellationTest2.start();
    }

    private void render() {
        GL11.glTranslatef(150.0f, 125.0f, 0.0f);
        GL11.glScalef(50.0f, 50.0f, 1.0f);
        double[][] dArr = new double[5][];
        double[][] dArr2 = dArr;
        dArr[0] = new double[]{0.6000000238418579d, -0.10000000149011612d, 0.0d, 1.0d, 1.0d, 1.0d};
        double[][] dArr3 = dArr2;
        double[][] dArr4 = dArr3;
        dArr3[1] = new double[]{1.350000023841858d, 1.399999976158142d, 0.0d, 1.0d, 1.0d, 1.0d};
        double[][] dArr5 = dArr4;
        double[][] dArr6 = dArr5;
        dArr5[2] = new double[]{2.0999999046325684d, -0.10000000149011612d, 0.0d, 1.0d, 1.0d, 1.0d};
        double[][] dArr7 = dArr6;
        double[][] dArr8 = dArr7;
        dArr7[3] = new double[]{0.6000000238418579d, 0.8999999761581421d, 0.0d, 1.0d, 1.0d, 1.0d};
        double[][] dArr9 = dArr8;
        double[][] dArr10 = dArr9;
        dArr9[4] = new double[]{2.0999999046325684d, 0.8999999761581421d, 0.0d, 1.0d, 1.0d, 1.0d};
        double[][] dArr11 = dArr10;
        double[][] dArr12 = new double[4][];
        double[][] dArr13 = dArr12;
        dArr12[0] = new double[]{0.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d};
        double[][] dArr14 = dArr13;
        double[][] dArr15 = dArr14;
        dArr14[1] = new double[]{1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d};
        double[][] dArr16 = dArr15;
        double[][] dArr17 = dArr16;
        dArr16[2] = new double[]{1.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d};
        double[][] dArr18 = dArr17;
        double[][] dArr19 = dArr18;
        dArr18[3] = new double[]{0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d};
        double[][] dArr20 = dArr19;
        double[][] dArr21 = new double[3][];
        double[][] dArr22 = dArr21;
        dArr21[0] = new double[]{0.30000001192092896d, 0.30000001192092896d, 0.0d, 0.0d, 0.0d, 0.0d};
        double[][] dArr23 = dArr22;
        double[][] dArr24 = dArr23;
        dArr23[1] = new double[]{0.699999988079071d, 0.30000001192092896d, 0.0d, 0.0d, 0.0d, 0.0d};
        double[][] dArr25 = dArr24;
        double[][] dArr26 = dArr25;
        dArr25[2] = new double[]{0.5d, 0.699999988079071d, 0.0d, 0.0d, 0.0d, 0.0d};
        double[][] dArr27 = dArr26;
        setWindingRule(GLU.GLU_TESS_WINDING_POSITIVE);
        beginPolygon();
        beginContour();
        renderContour(dArr11, 5);
        endContour();
        endPolygon();
        GL11.glTranslatef(-2.0f, 0.0f, 0.0f);
        setWindingRule(GLU.GLU_TESS_WINDING_ODD);
        beginPolygon();
        beginContour();
        renderContour(dArr20, 4);
        endContour();
        beginContour();
        renderContour(dArr27, 3);
        endContour();
        endPolygon();
        end();
    }

    private void start() throws LWJGLException {
        createDisplay();
        init();
        loop();
    }

    /* access modifiers changed from: 0000 */
    public void beginContour() {
        this.tesselator.gluTessBeginContour();
    }

    /* access modifiers changed from: 0000 */
    public void beginPolygon() {
        this.tesselator.gluTessBeginPolygon(null);
    }

    /* access modifiers changed from: 0000 */
    public void end() {
        this.tesselator.gluDeleteTess();
    }

    /* access modifiers changed from: 0000 */
    public void endContour() {
        this.tesselator.gluTessEndContour();
    }

    /* access modifiers changed from: 0000 */
    public void endPolygon() {
        this.tesselator.gluTessEndPolygon();
    }

    /* access modifiers changed from: 0000 */
    public void init() {
        TessCallback tessCallback;
        this.tesselator = GLU.gluNewTess();
        TessCallback tessCallback2 = tessCallback;
        TessCallback tessCallback3 = new TessCallback();
        TessCallback tessCallback4 = tessCallback2;
        this.tesselator.gluTessCallback(100101, tessCallback4);
        this.tesselator.gluTessCallback(100100, tessCallback4);
        this.tesselator.gluTessCallback(100102, tessCallback4);
        this.tesselator.gluTessCallback(GLU.GLU_TESS_COMBINE, tessCallback4);
    }

    /* access modifiers changed from: 0000 */
    public void renderContour(double[][] dArr, int i) {
        VertexData vertexData;
        double[][] dArr2 = dArr;
        int i2 = i;
        for (int i3 = 0; i3 < i2; i3++) {
            GLUtessellator gLUtessellator = this.tesselator;
            double[] dArr3 = dArr2[i3];
            VertexData vertexData2 = vertexData;
            VertexData vertexData3 = new VertexData(dArr2[i3]);
            gLUtessellator.gluTessVertex(dArr3, 0, vertexData2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setWindingRule(int i) {
        this.tesselator.gluTessProperty(GLU.GLU_TESS_WINDING_RULE, (double) i);
    }
}

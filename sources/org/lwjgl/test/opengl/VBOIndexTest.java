package org.lwjgl.test.opengl;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

public final class VBOIndexTest {
    private static float angle;
    private static int buffer_id;
    private static boolean finished;
    private static IntBuffer indices;
    private static int indices_buffer_id;
    private static ByteBuffer mapped_buffer;
    private static FloatBuffer mapped_float_buffer;
    private static ByteBuffer mapped_indices_buffer;
    private static IntBuffer mapped_indices_int_buffer;
    private static FloatBuffer vertices;

    static {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        int i = -1;
        try {
            DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
            int i2 = 0;
            while (true) {
                if (i2 < availableDisplayModes.length) {
                    if (availableDisplayModes[i2].getWidth() == 640 && availableDisplayModes[i2].getHeight() == 480 && availableDisplayModes[i2].getBitsPerPixel() >= 16) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (i != -1) {
                PrintStream printStream = System.out;
                StringBuilder sb4 = sb3;
                StringBuilder sb5 = new StringBuilder();
                printStream.println(sb4.append("Setting display mode to ").append(availableDisplayModes[i]).toString());
                Display.setDisplayMode(availableDisplayModes[i]);
                System.out.println("Created display.");
            }
        } catch (Exception e) {
            Exception exc = e;
            PrintStream printStream2 = System.err;
            StringBuilder sb6 = sb;
            StringBuilder sb7 = new StringBuilder();
            printStream2.println(sb6.append("Failed to create display due to ").append(exc).toString());
        }
        try {
            Display.create();
            System.out.println("Created OpenGL.");
        } catch (Exception e2) {
            Exception exc2 = e2;
            PrintStream printStream3 = System.err;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            printStream3.println(sb8.append("Failed to create OpenGL due to ").append(exc2).toString());
            System.exit(1);
        }
    }

    public VBOIndexTest() {
    }

    private static void cleanup() {
        IntBuffer asIntBuffer = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asIntBuffer();
        IntBuffer put = asIntBuffer.put(0, buffer_id);
        IntBuffer put2 = asIntBuffer.put(1, indices_buffer_id);
        ARBVertexBufferObject.glDeleteBuffersARB(asIntBuffer);
        Display.destroy();
    }

    private static void init() throws Exception {
        StringBuilder sb;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Timer resolution: ").append(Sys.getTimerResolution()).toString());
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluOrtho2D(0.0f, (float) Display.getDisplayMode().getWidth(), 0.0f, (float) Display.getDisplayMode().getHeight());
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
        if (!GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
            System.out.println("ARB VBO not supported!");
            System.exit(1);
        }
        IntBuffer asIntBuffer = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder()).asIntBuffer();
        ARBVertexBufferObject.glGenBuffersARB(asIntBuffer);
        buffer_id = asIntBuffer.get(0);
        indices_buffer_id = asIntBuffer.get(1);
        ARBVertexBufferObject.glBindBufferARB(34962, buffer_id);
        ARBVertexBufferObject.glBindBufferARB(34963, indices_buffer_id);
        vertices = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        FloatBuffer put = vertices.put(-50.0f).put(-50.0f).put(50.0f).put(-50.0f).put(50.0f).put(50.0f).put(-50.0f).put(50.0f);
        Buffer rewind = vertices.rewind();
        indices = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asIntBuffer();
        IntBuffer put2 = indices.put(0).put(1).put(2).put(3);
        Buffer rewind2 = indices.rewind();
        ARBVertexBufferObject.glBufferDataARB(34962, 32, 35040);
        ARBVertexBufferObject.glBufferDataARB(34963, 16, 35040);
        GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        GL11.glVertexPointer(2, (int) GL11.GL_FLOAT, 0, 0);
    }

    public static void main(String[] strArr) {
        String[] strArr2 = strArr;
        try {
            init();
            while (!finished) {
                Display.update();
                if (!Display.isVisible()) {
                    Thread.sleep(200);
                } else if (Display.isCloseRequested()) {
                    System.exit(0);
                }
                mainLoop();
                render();
            }
            cleanup();
        } catch (Throwable th) {
            Throwable th2 = th;
            cleanup();
            throw th2;
        }
        System.exit(0);
    }

    private static void mainLoop() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        angle = 1.0f + angle;
        if (angle > 360.0f) {
            angle = 0.0f;
        }
        if (!(Mouse.getDX() == 0 && Mouse.getDY() == 0 && Mouse.getDWheel() == 0)) {
            PrintStream printStream = System.out;
            StringBuilder sb4 = sb3;
            StringBuilder sb5 = new StringBuilder();
            printStream.println(sb4.append("Mouse moved ").append(Mouse.getDX()).append(" ").append(Mouse.getDY()).append(" ").append(Mouse.getDWheel()).toString());
        }
        for (int i = 0; i < Mouse.getButtonCount(); i++) {
            if (Mouse.isButtonDown(i)) {
                PrintStream printStream2 = System.out;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                printStream2.println(sb6.append("Button ").append(i).append(" down").toString());
            }
        }
        if (Keyboard.isKeyDown(1)) {
            finished = true;
        }
        for (int i2 = 0; i2 < Keyboard.getNumKeyboardEvents(); i2++) {
            boolean next = Keyboard.next();
            if (Keyboard.getEventKey() == 1 && Keyboard.getEventKeyState()) {
                finished = true;
            }
            if (Keyboard.getEventKey() == 20 && Keyboard.getEventKeyState()) {
                PrintStream printStream3 = System.out;
                StringBuilder sb8 = sb;
                StringBuilder sb9 = new StringBuilder();
                printStream3.println(sb8.append("Current time: ").append(Sys.getTime()).toString());
            }
        }
    }

    private static void render() {
        GL11.glClear(16384);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) (Display.getDisplayMode().getWidth() / 2), (float) (Display.getDisplayMode().getHeight() / 2), 0.0f);
        GL11.glRotatef(angle, 0.0f, 0.0f, 1.0f);
        ByteBuffer glMapBufferARB = ARBVertexBufferObject.glMapBufferARB(34962, 35001, mapped_buffer);
        if (glMapBufferARB != mapped_buffer) {
            mapped_float_buffer = glMapBufferARB.order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        mapped_buffer = glMapBufferARB;
        ByteBuffer glMapBufferARB2 = ARBVertexBufferObject.glMapBufferARB(34963, 35001, mapped_indices_buffer);
        if (glMapBufferARB2 != mapped_indices_buffer) {
            mapped_indices_int_buffer = glMapBufferARB2.order(ByteOrder.nativeOrder()).asIntBuffer();
        }
        mapped_indices_buffer = glMapBufferARB2;
        Buffer rewind = mapped_float_buffer.rewind();
        Buffer rewind2 = vertices.rewind();
        FloatBuffer put = mapped_float_buffer.put(vertices);
        Buffer rewind3 = mapped_indices_int_buffer.rewind();
        Buffer rewind4 = indices.rewind();
        IntBuffer put2 = mapped_indices_int_buffer.put(indices);
        if (ARBVertexBufferObject.glUnmapBufferARB(34962) && ARBVertexBufferObject.glUnmapBufferARB(34963)) {
            GL11.glDrawElements(7, 4, (int) GL11.GL_UNSIGNED_INT, 0);
        }
        GL11.glPopMatrix();
    }
}

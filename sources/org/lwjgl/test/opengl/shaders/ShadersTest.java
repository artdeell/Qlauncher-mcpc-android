package org.lwjgl.test.opengl.shaders;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.test.openal.PositionTest;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

public final class ShadersTest {
    private static float angle;
    private static DisplayMode displayMode;
    private static float frameTime;
    private static boolean run = true;
    private static Shader shader;
    private static float sin;
    private static int specularity = 4;
    private static Sphere sphere;
    private static final FloatBuffer vectorBuffer = BufferUtils.createFloatBuffer(4);

    private ShadersTest() {
    }

    private static void argsError() {
        System.out.println("\nInvalid program arguments.");
        System.out.println("\nUsage: ShadersTest <shaderType>, where <shaderType> argument can be one of the following:\n");
        System.out.println("none\t- Use fixed function rendering.");
        System.out.println("vp\t- Use ARB_vertex_program (low-level) only.");
        System.out.println("vsh\t- Use ARB_vertex_shader (GLSL) only.");
        System.out.println("fp\t- Use ARB_vertex_program + ARB_fragment_program (low-level).");
        System.out.println("fsh\t- Use ARB_vertex_shader + ARB_fragment_shader (GLSL).");
        System.out.println("uni\t- Use ARB_uniform_buffer_object to update shader uniforms (GLSL).");
        cleanup();
        System.exit(-1);
    }

    private static DisplayMode chooseMode(DisplayMode[] displayModeArr, int i, int i2) {
        DisplayMode[] displayModeArr2 = displayModeArr;
        int i3 = i;
        int i4 = i2;
        DisplayMode displayMode2 = null;
        int length = displayModeArr2.length;
        for (int i5 = 0; i5 < length; i5++) {
            DisplayMode displayMode3 = displayModeArr2[i5];
            if (displayMode3.getWidth() == i3 && displayMode3.getHeight() == i4 && displayMode3.getFrequency() <= 85 && (displayMode2 == null || (displayMode3.getBitsPerPixel() >= displayMode2.getBitsPerPixel() && displayMode3.getFrequency() > displayMode2.getFrequency()))) {
                displayMode2 = displayMode3;
            }
        }
        return displayMode2;
    }

    private static void cleanup() {
        if (shader != null) {
            shader.cleanup();
        }
        if (Display.isCreated()) {
            Display.destroy();
        }
    }

    static int getDisplayHeight() {
        return displayMode.getHeight();
    }

    static int getDisplayWidth() {
        return displayMode.getWidth();
    }

    static float getSin() {
        return sin;
    }

    static int getSpecularity() {
        return specularity;
    }

    private static void handleIO() {
        if (Keyboard.getNumKeyboardEvents() != 0) {
            while (Keyboard.next()) {
                if (!Keyboard.getEventKeyState()) {
                    switch (Keyboard.getEventKey()) {
                        case 1:
                            run = false;
                            break;
                        case 12:
                            if (specularity <= 1) {
                                break;
                            } else {
                                specularity = -1 + specularity;
                                break;
                            }
                        case 13:
                            if (specularity >= 8) {
                                break;
                            } else {
                                specularity = 1 + specularity;
                                break;
                            }
                    }
                }
            }
        }
        do {
        } while (Mouse.next());
    }

    private static void initialize(String[] strArr) {
        ShaderUNI shaderUNI;
        ShaderFSH shaderFSH;
        ShaderVSH shaderVSH;
        ShaderFP shaderFP;
        ShaderVP shaderVP;
        Sphere sphere2;
        StringBuilder sb;
        PixelFormat pixelFormat;
        String[] strArr2 = strArr;
        if (strArr2.length != 1) {
            argsError();
        }
        try {
            DisplayMode[] availableDisplayModes = Display.getAvailableDisplayModes();
            DisplayMode chooseMode = chooseMode(availableDisplayModes, 1024, 768);
            if (chooseMode == null) {
                chooseMode = chooseMode(availableDisplayModes, 800, 600);
            }
            if (chooseMode == null) {
                chooseMode = chooseMode(availableDisplayModes, PositionTest.WINDOW_WIDTH, 480);
            }
            if (chooseMode == null) {
                kill("Failed to set an appropriate display mode.");
            }
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Setting display mode to: ").append(chooseMode).toString());
            Display.setDisplayMode(chooseMode);
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(8, 24, 0);
            Display.create(pixelFormat2);
            displayMode = chooseMode;
        } catch (LWJGLException e) {
            kill(e.getMessage());
        }
        ContextCapabilities capabilities = GLContext.getCapabilities();
        if ("NONE".equalsIgnoreCase(strArr2[0])) {
            shader = null;
        } else if ("VP".equalsIgnoreCase(strArr2[0])) {
            if (!capabilities.GL_ARB_vertex_program) {
                kill("The ARB_vertex_program extension is not supported.");
            }
            ShaderVP shaderVP2 = shaderVP;
            ShaderVP shaderVP3 = new ShaderVP("shaderVP.vp");
            shader = shaderVP2;
        } else if ("FP".equalsIgnoreCase(strArr2[0])) {
            if (!capabilities.GL_ARB_vertex_program) {
                kill("The ARB_vertex_program extension is not supported.");
            }
            if (!capabilities.GL_ARB_fragment_program) {
                kill("The ARB_fragment_program extension is not supported.");
            }
            ShaderFP shaderFP2 = shaderFP;
            ShaderFP shaderFP3 = new ShaderFP("shaderFP.vp", "shaderFP.fp");
            shader = shaderFP2;
        } else if ("VSH".equalsIgnoreCase(strArr2[0])) {
            if (!capabilities.GL_ARB_vertex_shader) {
                kill("The ARB_vertex_shader extension is not supported.");
            }
            ShaderVSH shaderVSH2 = shaderVSH;
            ShaderVSH shaderVSH3 = new ShaderVSH("shaderVSH.vsh");
            shader = shaderVSH2;
        } else if ("FSH".equalsIgnoreCase(strArr2[0])) {
            if (!capabilities.GL_ARB_vertex_shader) {
                kill("The ARB_vertex_shader extension is not supported.");
            }
            if (!capabilities.GL_ARB_fragment_shader) {
                kill("The ARB_fragment_shader extension is not supported.");
            }
            ShaderFSH shaderFSH2 = shaderFSH;
            ShaderFSH shaderFSH3 = new ShaderFSH("shaderFSH.vsh", "shaderFSH.fsh");
            shader = shaderFSH2;
        } else if ("UNI".equalsIgnoreCase(strArr2[0])) {
            if (!capabilities.OpenGL31 && !capabilities.GL_ARB_uniform_buffer_object) {
                kill("Neither OpenGL version 3.1 nor ARB_uniform_buffer_object are supported.");
            }
            ShaderUNI shaderUNI2 = shaderUNI;
            ShaderUNI shaderUNI3 = new ShaderUNI("shaderUNI.vsh");
            shader = shaderUNI2;
        } else {
            argsError();
        }
        GL11.glViewport(0, 0, displayMode.getWidth(), displayMode.getHeight());
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(45.0f, ((float) displayMode.getWidth()) / ((float) displayMode.getHeight()), 1.0f, 10.0f);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -4.0f);
        GL11.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        GL11.glPushMatrix();
        GL11.glClearDepth(1.0d);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, 4354);
        GL11.glFrontFace(2305);
        GL11.glPolygonMode(GL11.GL_FRONT, GL11.GL_FILL);
        GL11.glCullFace(GL11.GL_BACK);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glAlphaFunc(GL11.GL_NOTEQUAL, 0.0f);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        if (shader == null) {
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(16384);
        }
        Buffer clear = vectorBuffer.clear();
        FloatBuffer put = vectorBuffer.put(1.0f).put(1.0f).put(1.0f).put(1.0f);
        Buffer clear2 = vectorBuffer.clear();
        GL11.glLight(16384, 4609, vectorBuffer);
        FloatBuffer put2 = vectorBuffer.put(1.0f).put(1.0f).put(1.0f).put(1.0f);
        Buffer clear3 = vectorBuffer.clear();
        GL11.glLight(16384, 4608, vectorBuffer);
        FloatBuffer put3 = vectorBuffer.put(1.0f).put(1.0f).put(0.5f).put(1.0f);
        Buffer clear4 = vectorBuffer.clear();
        GL11.glLight(16384, 4610, vectorBuffer);
        FloatBuffer put4 = vectorBuffer.put(-0.33333334f).put(0.33333334f).put(0.33333334f).put(0.0f);
        Buffer clear5 = vectorBuffer.clear();
        GL11.glLight(16384, 4611, vectorBuffer);
        FloatBuffer put5 = vectorBuffer.put(0.2f).put(0.2f).put(0.2f).put(1.0f);
        Buffer clear6 = vectorBuffer.clear();
        GL11.glLightModel((int) GL11.GL_LIGHT_MODEL_AMBIENT, vectorBuffer);
        Sphere sphere3 = sphere2;
        Sphere sphere4 = new Sphere();
        sphere = sphere3;
    }

    static void kill(String str) {
        StringBuilder sb;
        String str2 = str;
        System.out.println("The ShaderTest program was terminated because an error occured.\n");
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder append = sb2.append("Reason: ");
        if (str2 == null) {
            str2 = "Unknown";
        }
        printStream.println(append.append(str2).toString());
        cleanup();
        System.exit(-1);
    }

    static void kill(String str, Throwable th) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2 = str;
        Throwable th2 = th;
        System.out.println("The ShaderTest program was terminated because an exception occured.\n");
        PrintStream printStream = System.out;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        if (sb3.append("Reason: ").append(str2).toString() == null) {
            str2 = "Unknown";
        }
        printStream.println(str2);
        PrintStream printStream2 = System.out;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        printStream2.println(sb5.append("Exception message: ").append(th2.getMessage()).toString());
        cleanup();
        System.exit(-1);
    }

    public static void main(String[] strArr) {
        initialize(strArr);
        long j = 0;
        while (run) {
            if (!Display.isVisible()) {
                Thread.yield();
            } else {
                long time = Sys.getTime();
                frameTime = (float) (((double) (time - j)) / ((double) Sys.getTimerResolution()));
                j = time;
                angle = 0.1f + angle;
                sin = (float) Math.sin(Math.toRadians((double) angle));
                handleIO();
                GL11.glClear(16640);
                if (shader != null) {
                    shader.render();
                } else {
                    renderObject();
                }
                GL11.glPopMatrix();
                GL11.glPushMatrix();
            }
            Display.update();
            if (Display.isCloseRequested()) {
                break;
            }
        }
        cleanup();
        System.exit(0);
    }

    static void renderObject() {
        GL11.glColor3b(-1, -1, -1);
        sphere.draw(1.0f, 32, 32);
    }
}

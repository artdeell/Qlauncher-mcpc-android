package org.lwjgl.test.opengl;

import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.Util;
import org.lwjgl.test.openal.PositionTest;

public final class VersionTest {
    private VersionTest() {
    }

    private static void argsError(String str) {
        StringBuilder sb;
        String str2 = str;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("\nInvalid arguments error: ").append(str2).toString());
        System.out.println("\nUsage: VersionTest <majorVersion> <minorVersion> {'core'|'compatibility', <layer>, 'debug', 'fc'}:\n");
        System.out.println("majorVersion\t- Major OpenGL version.");
        System.out.println("majorVersion\t- Minor OpenGL version.");
        System.out.println("core\t- Sets the Core Profile bit (optional, requires 3.2+).");
        System.out.println("compatibility\t- Sets the Compatibility Profile bit (optional, requires 3.2+).");
        System.out.println("ws\t- Sets the OpenGL ES Profile bit (optional, requires 2.0).");
        System.out.println("layer\t- Layer plane (optional).");
        System.out.println("debug\t- Enables debug mode (optional).");
        System.out.println("fc\t- Enables forward compatibility mode (optional, requires 3.0+).");
        cleanup();
        System.exit(-1);
    }

    private static DisplayMode chooseMode(DisplayMode[] displayModeArr, int i, int i2) {
        DisplayMode[] displayModeArr2 = displayModeArr;
        int i3 = i;
        int i4 = i2;
        DisplayMode displayMode = null;
        int length = displayModeArr2.length;
        for (int i5 = 0; i5 < length; i5++) {
            DisplayMode displayMode2 = displayModeArr2[i5];
            if (displayMode2.getWidth() == i3 && displayMode2.getHeight() == i4 && displayMode2.getFrequency() <= 85 && (displayMode == null || (displayMode2.getBitsPerPixel() >= displayMode.getBitsPerPixel() && displayMode2.getFrequency() > displayMode.getFrequency()))) {
                displayMode = displayMode2;
            }
        }
        return displayMode;
    }

    private static void cleanup() {
        if (Display.isCreated()) {
            Display.destroy();
        }
    }

    private static void initialize(String[] strArr) {
        int i;
        ContextAttribs contextAttribs;
        StringBuilder sb;
        boolean z;
        StringTokenizer stringTokenizer;
        boolean z2;
        boolean z3;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        StringBuilder sb9;
        StringBuilder sb10;
        StringBuilder sb11;
        StringBuilder sb12;
        StringBuilder sb13;
        StringBuilder sb14;
        StringBuilder sb15;
        StringBuilder sb16;
        StringBuilder sb17;
        PixelFormat pixelFormat;
        StringBuilder sb18;
        String[] strArr2 = strArr;
        if (strArr2.length < 2) {
            argsError("Insufficient number of arguments");
        }
        int i2 = 1;
        try {
            i2 = Integer.parseInt(strArr2[0]);
            i = Integer.parseInt(strArr2[1]);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = e;
            argsError("Invalid number format");
            i = 0;
        }
        ContextAttribs contextAttribs2 = contextAttribs;
        ContextAttribs contextAttribs3 = new ContextAttribs(i2, i);
        ContextAttribs contextAttribs4 = contextAttribs2;
        if (2 < strArr2.length) {
            for (int i3 = 2; i3 < strArr2.length; i3++) {
                if (Pattern.matches("[0-9]+", strArr2[i3])) {
                    contextAttribs4 = contextAttribs4.withLayer(Integer.parseInt(strArr2[i3]));
                } else if ("debug".equalsIgnoreCase(strArr2[i3])) {
                    contextAttribs4 = contextAttribs4.withDebug(true);
                } else if ("fc".equalsIgnoreCase(strArr2[i3])) {
                    contextAttribs4 = contextAttribs4.withForwardCompatible(true);
                } else if ("core".equalsIgnoreCase(strArr2[i3])) {
                    contextAttribs4 = contextAttribs4.withProfileCore(true);
                } else if ("compatibility".equalsIgnoreCase(strArr2[i3])) {
                    contextAttribs4 = contextAttribs4.withProfileCompatibility(true);
                } else if ("es".equalsIgnoreCase(strArr2[i3])) {
                    contextAttribs4 = contextAttribs4.withProfileES(true);
                } else {
                    StringBuilder sb19 = sb18;
                    StringBuilder sb20 = new StringBuilder();
                    argsError(sb19.append("Unknown argument: '").append(strArr2[i3]).append("'").toString());
                }
            }
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
            StringBuilder sb21 = sb17;
            StringBuilder sb22 = new StringBuilder();
            printStream.println(sb21.append("Setting display mode to: ").append(chooseMode).toString());
            Display.setDisplayMode(chooseMode);
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat(8, 24, 0);
            Display.create(pixelFormat2, contextAttribs4);
        } catch (LWJGLException e2) {
            kill(e2.getMessage());
        }
        System.out.println("\n---------\n");
        PrintStream printStream2 = System.out;
        StringBuilder sb23 = sb;
        StringBuilder sb24 = new StringBuilder();
        printStream2.println(sb23.append("Requested ").append(contextAttribs4).toString());
        String glGetString = GL11.glGetString(GL11.GL_VERSION);
        try {
            GL11.glVertex3f(0.0f, 0.0f, 0.0f);
            Util.checkGLError();
            z = true;
        } catch (Throwable th) {
            Throwable th2 = th;
            z = false;
        }
        StringTokenizer stringTokenizer2 = stringTokenizer;
        StringTokenizer stringTokenizer3 = new StringTokenizer(glGetString, ". ");
        StringTokenizer stringTokenizer4 = stringTokenizer2;
        int parseInt = Integer.parseInt(stringTokenizer4.nextToken());
        int parseInt2 = Integer.parseInt(stringTokenizer4.nextToken());
        if (3 < parseInt || (parseInt == 3 && 2 <= parseInt2)) {
            int glGetInteger = GL11.glGetInteger(GL32.GL_CONTEXT_PROFILE_MASK);
            z3 = (glGetInteger & 2) != 0;
            z2 = (glGetInteger & 1) != 0;
        } else {
            z3 = false;
            z2 = false;
        }
        PrintStream printStream3 = System.out;
        StringBuilder sb25 = sb2;
        StringBuilder sb26 = new StringBuilder();
        printStream3.println(sb25.append("\nGL_VERSION returned : ").append(glGetString).toString());
        PrintStream printStream4 = System.out;
        StringBuilder sb27 = sb3;
        StringBuilder sb28 = new StringBuilder();
        printStream4.println(sb27.append("\tCore profile: ").append(z2).toString());
        PrintStream printStream5 = System.out;
        StringBuilder sb29 = sb4;
        StringBuilder sb30 = new StringBuilder();
        printStream5.println(sb29.append("\tCompatibility profile: ").append(z3).toString());
        PrintStream printStream6 = System.out;
        StringBuilder sb31 = sb5;
        StringBuilder sb32 = new StringBuilder();
        printStream6.println(sb31.append("ARB_compatibility present: ").append(GLContext.getCapabilities().GL_ARB_compatibility).toString());
        PrintStream printStream7 = System.out;
        StringBuilder sb33 = sb6;
        StringBuilder sb34 = new StringBuilder();
        printStream7.println(sb33.append("Deprecated functionality present: ").append(z).toString());
        if (!z && GLContext.getCapabilities().GL_ARB_compatibility) {
            System.out.println("\tARB_compatibility is present, but LWJGL has enabled pseudo-forward compatible mode.");
        }
        System.out.println("\n---------");
        if (i2 < 3 || (i2 == 3 && i == 0)) {
            System.out.println("\nA version less than or equal to 3.0 is requested, the context\nreturned may implement any of the following versions:");
            System.out.println("\n1) Any version no less than that requested and no greater than 3.0.");
            boolean z4 = (i2 < parseInt || (i2 == parseInt && i <= parseInt2)) && (parseInt < 3 || (parseInt == 3 && parseInt2 == 0));
            PrintStream printStream8 = System.out;
            StringBuilder sb35 = sb7;
            StringBuilder sb36 = new StringBuilder();
            printStream8.println(sb35.append("\t").append(z4).toString());
            boolean z5 = false | z4;
            System.out.println("\n2) Version 3.1, if the GL_ARB_compatibility extension is also implemented.");
            boolean z6 = parseInt == 3 && parseInt2 == 1 && GLContext.getCapabilities().GL_ARB_compatibility;
            PrintStream printStream9 = System.out;
            StringBuilder sb37 = sb8;
            StringBuilder sb38 = new StringBuilder();
            printStream9.println(sb37.append("\t").append(z6).toString());
            boolean z7 = z5 | z6;
            System.out.println("\n3) The compatibility profile of version 3.2 or greater.");
            boolean z8 = z3;
            PrintStream printStream10 = System.out;
            StringBuilder sb39 = sb9;
            StringBuilder sb40 = new StringBuilder();
            printStream10.println(sb39.append("\t").append(z8).toString());
            boolean z9 = z7 | z8;
            PrintStream printStream11 = System.out;
            StringBuilder sb41 = sb10;
            StringBuilder sb42 = new StringBuilder();
            printStream11.println(sb41.append("\nTEST ").append(z9 ? "SUCCEEDED" : "FAILED").toString());
            if (!z9 && contextAttribs4.isForwardCompatible()) {
                System.out.println("\t(probably because the forward compatible flag was set)");
            }
        } else if (i2 == 3 && i == 1) {
            System.out.println("\nVersion 3.1 is requested, the context returned may implement\nany of the following versions:");
            System.out.println("\n1) Version 3.1. The GL_ARB_compatibility extension may or may not\nbe implemented, as determined by the implementation.");
            boolean z10 = parseInt == 3 && parseInt2 == 1;
            PrintStream printStream12 = System.out;
            StringBuilder sb43 = sb14;
            StringBuilder sb44 = new StringBuilder();
            printStream12.println(sb43.append("\t").append(z10).toString());
            boolean z11 = false | z10;
            System.out.println("\n2) The core profile of version 3.2 or greater.");
            boolean z12 = z2;
            PrintStream printStream13 = System.out;
            StringBuilder sb45 = sb15;
            StringBuilder sb46 = new StringBuilder();
            printStream13.println(sb45.append("\t").append(z12).toString());
            boolean z13 = z11 | z12;
            PrintStream printStream14 = System.out;
            StringBuilder sb47 = sb16;
            StringBuilder sb48 = new StringBuilder();
            printStream14.println(sb47.append("\nTEST ").append(z13 ? "SUCCEEDED" : "FAILED").toString());
        } else {
            System.out.println("\nVersion 3.2 or greater is requested, the context returned may\nimplement any of the following versions:");
            System.out.println("\n1) The requested profile of the requested version.");
            boolean z14 = i2 == parseInt && i == parseInt2 && (!contextAttribs4.isProfileCompatibility() || z3) && (!contextAttribs4.isProfileCore() || z2);
            PrintStream printStream15 = System.out;
            StringBuilder sb49 = sb11;
            StringBuilder sb50 = new StringBuilder();
            printStream15.println(sb49.append("\t").append(z14).toString());
            boolean z15 = false | z14;
            System.out.println("\n2) The requested profile of any later version, so long as no\nfeatures have been removed from that later version and profile.");
            boolean z16 = i2 < parseInt || (i2 == parseInt && i < parseInt2 && ((!contextAttribs4.isProfileCompatibility() || z3) && (!contextAttribs4.isProfileCore() || z2)));
            PrintStream printStream16 = System.out;
            StringBuilder sb51 = sb12;
            StringBuilder sb52 = new StringBuilder();
            printStream16.println(sb51.append("\t").append(z16).toString());
            boolean z17 = z15 | z16;
            PrintStream printStream17 = System.out;
            StringBuilder sb53 = sb13;
            StringBuilder sb54 = new StringBuilder();
            printStream17.println(sb53.append("\nTEST ").append(z17 ? "SUCCEEDED" : "FAILED").toString());
        }
    }

    static void kill(String str) {
        StringBuilder sb;
        String str2 = str;
        System.out.println("The VersionTest program was terminated because an error occured.\n");
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

    public static void main(String[] strArr) {
        initialize(strArr);
        cleanup();
        System.exit(0);
    }
}

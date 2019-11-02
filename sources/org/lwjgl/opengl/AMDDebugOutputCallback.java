package org.lwjgl.opengl;

import java.io.PrintStream;
import org.lwjgl.PointerWrapperAbstract;

public final class AMDDebugOutputCallback extends PointerWrapperAbstract {
    private static final long CALLBACK_POINTER;
    private static final int GL_DEBUG_CATEGORY_API_ERROR_AMD = 37193;
    private static final int GL_DEBUG_CATEGORY_APPLICATION_AMD = 37199;
    private static final int GL_DEBUG_CATEGORY_DEPRECATION_AMD = 37195;
    private static final int GL_DEBUG_CATEGORY_OTHER_AMD = 37200;
    private static final int GL_DEBUG_CATEGORY_PERFORMANCE_AMD = 37197;
    private static final int GL_DEBUG_CATEGORY_SHADER_COMPILER_AMD = 37198;
    private static final int GL_DEBUG_CATEGORY_UNDEFINED_BEHAVIOR_AMD = 37196;
    private static final int GL_DEBUG_CATEGORY_WINDOW_SYSTEM_AMD = 37194;
    private static final int GL_DEBUG_SEVERITY_HIGH_AMD = 37190;
    private static final int GL_DEBUG_SEVERITY_LOW_AMD = 37192;
    private static final int GL_DEBUG_SEVERITY_MEDIUM_AMD = 37191;
    private final Handler handler;

    public interface Handler {
        void handleMessage(int i, int i2, int i3, String str);
    }

    static {
        long j = 0;
        try {
            j = ((Long) Class.forName("org.lwjgl.opengl.CallbackUtil").getDeclaredMethod("getDebugOutputCallbackAMD", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
            Exception exc = e;
        }
        CALLBACK_POINTER = j;
    }

    public AMDDebugOutputCallback() {
        C07781 r4;
        C07781 r2 = r4;
        C07781 r3 = new Handler() {
            private String printUnknownToken(int i) {
                StringBuilder sb;
                int i2 = i;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append("Unknown (0x").append(Integer.toHexString(i2).toUpperCase()).append(")").toString();
            }

            public void handleMessage(int i, int i2, int i3, String str) {
                StringBuilder sb;
                String str2;
                StringBuilder sb2;
                String str3;
                StringBuilder sb3;
                StringBuilder sb4;
                int i4 = i;
                int i5 = i2;
                int i6 = i3;
                String str4 = str;
                System.err.println("[LWJGL] AMD_debug_output message");
                PrintStream printStream = System.err;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                printStream.println(sb5.append("\tID: ").append(i4).toString());
                switch (i5) {
                    case 37193:
                        str2 = "API ERROR";
                        break;
                    case 37194:
                        str2 = "WINDOW SYSTEM";
                        break;
                    case 37195:
                        str2 = "DEPRECATION";
                        break;
                    case 37196:
                        str2 = "UNDEFINED BEHAVIOR";
                        break;
                    case 37197:
                        str2 = "PERFORMANCE";
                        break;
                    case 37198:
                        str2 = "SHADER COMPILER";
                        break;
                    case 37199:
                        str2 = "APPLICATION";
                        break;
                    case 37200:
                        str2 = "OTHER";
                        break;
                    default:
                        str2 = printUnknownToken(i5);
                        break;
                }
                PrintStream printStream2 = System.err;
                StringBuilder sb7 = sb2;
                StringBuilder sb8 = new StringBuilder();
                printStream2.println(sb7.append("\tCategory: ").append(str2).toString());
                switch (i6) {
                    case 37190:
                        str3 = "HIGH";
                        break;
                    case 37191:
                        str3 = "MEDIUM";
                        break;
                    case 37192:
                        str3 = "LOW";
                        break;
                    default:
                        str3 = printUnknownToken(i6);
                        break;
                }
                PrintStream printStream3 = System.err;
                StringBuilder sb9 = sb3;
                StringBuilder sb10 = new StringBuilder();
                printStream3.println(sb9.append("\tSeverity: ").append(str3).toString());
                PrintStream printStream4 = System.err;
                StringBuilder sb11 = sb4;
                StringBuilder sb12 = new StringBuilder();
                printStream4.println(sb11.append("\tMessage: ").append(str4).toString());
            }
        };
        this(r2);
    }

    public AMDDebugOutputCallback(Handler handler2) {
        Handler handler3 = handler2;
        super(CALLBACK_POINTER);
        this.handler = handler3;
    }

    /* access modifiers changed from: 0000 */
    public Handler getHandler() {
        return this.handler;
    }
}

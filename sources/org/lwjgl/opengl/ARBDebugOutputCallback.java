package org.lwjgl.opengl;

import java.io.PrintStream;
import org.lwjgl.PointerWrapperAbstract;

public final class ARBDebugOutputCallback extends PointerWrapperAbstract {
    private static final long CALLBACK_POINTER;
    private static final int GL_DEBUG_SEVERITY_HIGH_ARB = 37190;
    private static final int GL_DEBUG_SEVERITY_LOW_ARB = 37192;
    private static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 37191;
    private static final int GL_DEBUG_SOURCE_API_ARB = 33350;
    private static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 33354;
    private static final int GL_DEBUG_SOURCE_OTHER_ARB = 33355;
    private static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 33352;
    private static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 33353;
    private static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 33351;
    private static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 33357;
    private static final int GL_DEBUG_TYPE_ERROR_ARB = 33356;
    private static final int GL_DEBUG_TYPE_OTHER_ARB = 33361;
    private static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 33360;
    private static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 33359;
    private static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 33358;
    private final Handler handler;

    public interface Handler {
        void handleMessage(int i, int i2, int i3, int i4, String str);
    }

    static {
        long j = 0;
        try {
            j = ((Long) Class.forName("org.lwjgl.opengl.CallbackUtil").getDeclaredMethod("getDebugOutputCallbackARB", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
            Exception exc = e;
        }
        CALLBACK_POINTER = j;
    }

    public ARBDebugOutputCallback() {
        C07791 r4;
        C07791 r2 = r4;
        C07791 r3 = new Handler() {
            private String printUnknownToken(int i) {
                StringBuilder sb;
                int i2 = i;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                return sb2.append("Unknown (0x").append(Integer.toHexString(i2).toUpperCase()).append(")").toString();
            }

            public void handleMessage(int i, int i2, int i3, int i4, String str) {
                StringBuilder sb;
                String str2;
                StringBuilder sb2;
                String str3;
                StringBuilder sb3;
                String str4;
                StringBuilder sb4;
                StringBuilder sb5;
                int i5 = i;
                int i6 = i2;
                int i7 = i3;
                int i8 = i4;
                String str5 = str;
                System.err.println("[LWJGL] ARB_debug_output message");
                PrintStream printStream = System.err;
                StringBuilder sb6 = sb;
                StringBuilder sb7 = new StringBuilder();
                printStream.println(sb6.append("\tID: ").append(i7).toString());
                switch (i5) {
                    case 33350:
                        str2 = "API";
                        break;
                    case 33351:
                        str2 = "WINDOW SYSTEM";
                        break;
                    case 33352:
                        str2 = "SHADER COMPILER";
                        break;
                    case 33353:
                        str2 = "THIRD PARTY";
                        break;
                    case 33354:
                        str2 = "APPLICATION";
                        break;
                    case 33355:
                        str2 = "OTHER";
                        break;
                    default:
                        str2 = printUnknownToken(i5);
                        break;
                }
                PrintStream printStream2 = System.err;
                StringBuilder sb8 = sb2;
                StringBuilder sb9 = new StringBuilder();
                printStream2.println(sb8.append("\tSource: ").append(str2).toString());
                switch (i6) {
                    case 33356:
                        str3 = "ERROR";
                        break;
                    case 33357:
                        str3 = "DEPRECATED BEHAVIOR";
                        break;
                    case 33358:
                        str3 = "UNDEFINED BEHAVIOR";
                        break;
                    case 33359:
                        str3 = "PORTABILITY";
                        break;
                    case 33360:
                        str3 = "PERFORMANCE";
                        break;
                    case 33361:
                        str3 = "OTHER";
                        break;
                    default:
                        str3 = printUnknownToken(i6);
                        break;
                }
                PrintStream printStream3 = System.err;
                StringBuilder sb10 = sb3;
                StringBuilder sb11 = new StringBuilder();
                printStream3.println(sb10.append("\tType: ").append(str3).toString());
                switch (i8) {
                    case 37190:
                        str4 = "HIGH";
                        break;
                    case 37191:
                        str4 = "MEDIUM";
                        break;
                    case 37192:
                        str4 = "LOW";
                        break;
                    default:
                        str4 = printUnknownToken(i8);
                        break;
                }
                PrintStream printStream4 = System.err;
                StringBuilder sb12 = sb4;
                StringBuilder sb13 = new StringBuilder();
                printStream4.println(sb12.append("\tSeverity: ").append(str4).toString());
                PrintStream printStream5 = System.err;
                StringBuilder sb14 = sb5;
                StringBuilder sb15 = new StringBuilder();
                printStream5.println(sb14.append("\tMessage: ").append(str5).toString());
            }
        };
        this(r2);
    }

    public ARBDebugOutputCallback(Handler handler2) {
        Handler handler3 = handler2;
        super(CALLBACK_POINTER);
        this.handler = handler3;
    }

    /* access modifiers changed from: 0000 */
    public Handler getHandler() {
        return this.handler;
    }
}

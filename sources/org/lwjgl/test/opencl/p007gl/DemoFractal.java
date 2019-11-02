package org.lwjgl.test.opencl.p007gl;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opencl.C0774CL;
import org.lwjgl.opencl.CL10;
import org.lwjgl.opencl.CL10GL;
import org.lwjgl.opencl.CLBuildProgramCallback;
import org.lwjgl.opencl.CLCapabilities;
import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLDeviceCapabilities;
import org.lwjgl.opencl.CLEvent;
import org.lwjgl.opencl.CLKernel;
import org.lwjgl.opencl.CLMem;
import org.lwjgl.opencl.CLProgram;
import org.lwjgl.opencl.KHRGLEvent;
import org.lwjgl.opengl.ARBSync;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLSync;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.ReadableColor;

/* renamed from: org.lwjgl.test.opencl.gl.DemoFractal */
public class DemoFractal {
    private static final int COLOR_MAP_SIZE = 256;
    private static final int MAX_PARALLELISM_LEVEL = 8;
    private boolean buffersInitialized;
    private CLContext clContext;
    private CLEvent[] clEvents;
    private GLSync[] clSyncs;
    private CLMem[] colorMap;
    private int dlist;
    private boolean doublePrecision = true;
    private double dragMaxX;
    private double dragMaxY;
    private double dragMinX;
    private double dragMinY;
    private double dragX;
    private double dragY;
    private boolean dragging;
    private boolean drawSeparator;
    private int fsh;
    private CLMem[] glBuffers;
    private CLEvent glEvent;
    private IntBuffer glIDs;
    private GLSync glSync;
    private int height = 512;
    private final PointerBuffer kernel2DGlobalWorkSize;
    private CLKernel[] kernels;
    private int maxIterations = 500;
    private double maxX = 0.6000000238418579d;
    private double maxY = 1.2999999523162842d;
    private double minX = -2.0d;
    private double minY = -1.2000000476837158d;
    private int mouseX;
    private int mouseY;
    private Set<String> params;
    private int program;
    private CLProgram[] programs;
    private CLCommandQueue[] queues;
    private boolean rebuild;
    private boolean run = true;
    private int slices;
    private final PointerBuffer syncBuffer = BufferUtils.createPointerBuffer(1);
    private boolean syncCLtoGL;
    private boolean syncGLtoCL;
    private boolean useTextures;
    private int vsh;
    private int width = 512;

    public DemoFractal(String[] strArr) {
        HashSet hashSet;
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        IllegalArgumentException illegalArgumentException3;
        IllegalArgumentException illegalArgumentException4;
        IllegalArgumentException illegalArgumentException5;
        IllegalArgumentException illegalArgumentException6;
        StringBuilder sb;
        String[] strArr2 = strArr;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.params = hashSet2;
        int i = 0;
        while (i < strArr2.length) {
            String str = strArr2[i];
            if (str.charAt(0) == '-' || str.charAt(0) == '/') {
                String substring = str.substring(1);
                if ("forcePBO".equalsIgnoreCase(substring)) {
                    boolean add = this.params.add("forcePBO");
                } else if ("forceCPU".equalsIgnoreCase(substring)) {
                    boolean add2 = this.params.add("forceCPU");
                } else if ("debugGL".equalsIgnoreCase(substring)) {
                    boolean add3 = this.params.add("debugGL");
                } else if ("iterations".equalsIgnoreCase(substring)) {
                    if (strArr2.length < 1 + i + 1) {
                        IllegalArgumentException illegalArgumentException7 = illegalArgumentException4;
                        IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("Invalid iterations argument specified.");
                        throw illegalArgumentException7;
                    }
                    i++;
                    try {
                        this.maxIterations = Integer.parseInt(strArr2[i]);
                    } catch (NumberFormatException e) {
                        NumberFormatException numberFormatException = e;
                        IllegalArgumentException illegalArgumentException9 = illegalArgumentException5;
                        IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("Invalid number of iterations specified.");
                        throw illegalArgumentException9;
                    }
                } else if (!"res".equalsIgnoreCase(substring)) {
                    continue;
                } else if (strArr2.length < 1 + i + 2) {
                    IllegalArgumentException illegalArgumentException11 = illegalArgumentException;
                    IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException("Invalid res argument specified.");
                    throw illegalArgumentException11;
                } else {
                    int i2 = i + 1;
                    try {
                        this.width = Integer.parseInt(strArr2[i2]);
                        i = i2 + 1;
                        this.height = Integer.parseInt(strArr2[i]);
                        if (this.width < 1 || this.height < 1) {
                            IllegalArgumentException illegalArgumentException13 = illegalArgumentException3;
                            IllegalArgumentException illegalArgumentException14 = new IllegalArgumentException("Invalid res dimensions specified.");
                            throw illegalArgumentException13;
                        }
                    } catch (NumberFormatException e2) {
                        NumberFormatException numberFormatException2 = e2;
                        IllegalArgumentException illegalArgumentException15 = illegalArgumentException2;
                        IllegalArgumentException illegalArgumentException16 = new IllegalArgumentException("Invalid res dimensions specified.");
                        throw illegalArgumentException15;
                    }
                }
                i++;
            } else {
                IllegalArgumentException illegalArgumentException17 = illegalArgumentException6;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                IllegalArgumentException illegalArgumentException18 = new IllegalArgumentException(sb2.append("Invalid command-line argument: ").append(strArr2[i]).toString());
                throw illegalArgumentException17;
            }
        }
        this.kernel2DGlobalWorkSize = BufferUtils.createPointerBuffer(2);
    }

    private void buildPrograms() {
        RuntimeException runtimeException;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        if (this.programs[0] != null) {
            CLProgram[] cLProgramArr = this.programs;
            int length = cLProgramArr.length;
            for (int i = 0; i < length; i++) {
                int clReleaseProgram = CL10.clReleaseProgram(cLProgramArr[i]);
            }
        }
        try {
            createPrograms();
            int i2 = 0;
            while (i2 < this.programs.length) {
                CLDevice cLDevice = this.queues[i2].getCLDevice();
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder(this.useTextures ? "-D USE_TEXTURE" : LibrariesRepository.MOJANG_MAVEN_REPO);
                StringBuilder sb7 = sb5;
                CLDeviceCapabilities deviceCapabilities = CLCapabilities.getDeviceCapabilities(cLDevice);
                if (this.doublePrecision && isDoubleFPAvailable(cLDevice)) {
                    StringBuilder append = sb7.append(" -D DOUBLE_FP");
                    if (!deviceCapabilities.CL_KHR_fp64 && deviceCapabilities.CL_AMD_fp64) {
                        StringBuilder append2 = sb7.append(" -D AMD_FP");
                    }
                }
                PrintStream printStream = System.out;
                StringBuilder sb8 = sb2;
                StringBuilder sb9 = new StringBuilder();
                printStream.println(sb8.append("\nOpenCL COMPILER OPTIONS: ").append(sb7).toString());
                try {
                    int clBuildProgram = CL10.clBuildProgram(this.programs[i2], cLDevice, (CharSequence) sb7, (CLBuildProgramCallback) null);
                    PrintStream printStream2 = System.out;
                    StringBuilder sb10 = sb4;
                    StringBuilder sb11 = new StringBuilder();
                    printStream2.println(sb10.append("BUILD LOG: ").append(this.programs[i2].getBuildInfoString(cLDevice, CL10.CL_PROGRAM_BUILD_LOG)).toString());
                    i2++;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    PrintStream printStream3 = System.out;
                    StringBuilder sb12 = sb3;
                    StringBuilder sb13 = new StringBuilder();
                    printStream3.println(sb12.append("BUILD LOG: ").append(this.programs[i2].getBuildInfoString(cLDevice, CL10.CL_PROGRAM_BUILD_LOG)).toString());
                    throw th2;
                }
            }
            this.rebuild = false;
            for (int i3 = 0; i3 < this.kernels.length; i3++) {
                this.kernels[i3] = CL10.clCreateKernel(this.programs[Math.min(i3, this.programs.length)], (CharSequence) "mandelbrot", (IntBuffer) null);
            }
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(iOException);
            throw runtimeException2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x021d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void compute(boolean r29) {
        /*
            r28 = this;
            r2 = r28
            r3 = r29
            r20 = r2
            r0 = r20
            int r0 = r0.width
            r20 = r0
            r0 = r20
            float r0 = (float) r0
            r20 = r0
            r21 = r2
            r0 = r21
            int r0 = r0.slices
            r21 = r0
            r0 = r21
            float r0 = (float) r0
            r21 = r0
            float r20 = r20 / r21
            r0 = r20
            int r0 = (int) r0
            r20 = r0
            r4 = r20
            r20 = r2
            r0 = r20
            double r0 = r0.maxX
            r20 = r0
            r22 = r2
            r0 = r22
            double r0 = r0.minX
            r22 = r0
            double r20 = r20 - r22
            r22 = r2
            r0 = r22
            int r0 = r0.slices
            r22 = r0
            r0 = r22
            double r0 = (double) r0
            r22 = r0
            double r20 = r20 / r22
            r5 = r20
            r20 = r2
            r0 = r20
            double r0 = r0.maxY
            r20 = r0
            r22 = r2
            r0 = r22
            double r0 = r0.minY
            r22 = r0
            double r20 = r20 - r22
            r7 = r20
            r20 = r2
            r0 = r20
            org.lwjgl.PointerBuffer r0 = r0.kernel2DGlobalWorkSize
            r20 = r0
            r21 = 0
            r22 = r4
            r0 = r22
            long r0 = (long) r0
            r22 = r0
            org.lwjgl.PointerBuffer r20 = r20.put(r21, r22)
            r21 = 1
            r22 = r2
            r0 = r22
            int r0 = r0.height
            r22 = r0
            r0 = r22
            long r0 = (long) r0
            r22 = r0
            org.lwjgl.PointerBuffer r20 = r20.put(r21, r22)
            r20 = 0
            r10 = r20
        L_0x008a:
            r20 = r10
            r21 = r2
            r0 = r21
            int r0 = r0.slices
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 >= r1) goto L_0x026e
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLKernel[] r0 = r0.kernels
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            r21 = 0
            r22 = r4
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r21 = 1
            r22 = r2
            r0 = r22
            int r0 = r0.height
            r22 = r0
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r20 = r3
            if (r20 == 0) goto L_0x00d6
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            org.lwjgl.opencl.CLDevice r20 = r20.getCLDevice()
            boolean r20 = isDoubleFPAvailable(r20)
            if (r20 != 0) goto L_0x0221
        L_0x00d6:
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLKernel[] r0 = r0.kernels
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            r21 = 2
            r22 = r2
            r0 = r22
            double r0 = r0.minX
            r22 = r0
            r24 = r5
            r26 = r10
            r0 = r26
            double r0 = (double) r0
            r26 = r0
            double r24 = r24 * r26
            double r22 = r22 + r24
            r0 = r22
            float r0 = (float) r0
            r22 = r0
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r21 = 3
            r22 = r2
            r0 = r22
            double r0 = r0.minY
            r22 = r0
            r0 = r22
            float r0 = (float) r0
            r22 = r0
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r21 = 4
            r22 = r5
            r0 = r22
            float r0 = (float) r0
            r22 = r0
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r21 = 5
            r22 = r7
            r0 = r22
            float r0 = (float) r0
            r22 = r0
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
        L_0x012f:
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            r21 = r2
            r0 = r21
            org.lwjgl.opencl.CLMem[] r0 = r0.glBuffers
            r21 = r0
            r22 = r10
            r21 = r21[r22]
            r22 = 0
            r23 = 0
            int r20 = org.lwjgl.opencl.CL10GL.clEnqueueAcquireGLObjects(r20, r21, r22, r23)
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            r21 = r2
            r0 = r21
            org.lwjgl.opencl.CLKernel[] r0 = r0.kernels
            r21 = r0
            r22 = r10
            r21 = r21[r22]
            r22 = 2
            r23 = 0
            r24 = r2
            r0 = r24
            org.lwjgl.PointerBuffer r0 = r0.kernel2DGlobalWorkSize
            r24 = r0
            r25 = 0
            r26 = 0
            r27 = 0
            int r20 = org.lwjgl.opencl.CL10.clEnqueueNDRangeKernel(r20, r21, r22, r23, r24, r25, r26, r27)
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            r17 = r20
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLMem[] r0 = r0.glBuffers
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            r18 = r20
            r20 = r2
            r0 = r20
            boolean r0 = r0.syncGLtoCL
            r20 = r0
            if (r20 == 0) goto L_0x0268
            r20 = r2
            r0 = r20
            org.lwjgl.PointerBuffer r0 = r0.syncBuffer
            r20 = r0
            r19 = r20
        L_0x01ad:
            r20 = r17
            r21 = r18
            r22 = 0
            r23 = r19
            int r20 = org.lwjgl.opencl.CL10GL.clEnqueueReleaseGLObjects(r20, r21, r22, r23)
            r20 = r2
            r0 = r20
            boolean r0 = r0.syncGLtoCL
            r20 = r0
            if (r20 == 0) goto L_0x021d
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLEvent[] r0 = r0.clEvents
            r20 = r0
            r21 = r10
            r22 = r2
            r0 = r22
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r22 = r0
            r23 = r10
            r22 = r22[r23]
            r23 = r2
            r0 = r23
            org.lwjgl.PointerBuffer r0 = r0.syncBuffer
            r23 = r0
            r24 = 0
            long r23 = r23.get(r24)
            org.lwjgl.opencl.CLEvent r22 = r22.getCLEvent(r23)
            r20[r21] = r22
            r20 = r2
            r0 = r20
            org.lwjgl.opengl.GLSync[] r0 = r0.clSyncs
            r20 = r0
            r21 = r10
            r22 = r2
            r0 = r22
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r22 = r0
            r23 = r10
            r22 = r22[r23]
            org.lwjgl.opencl.CLObject r22 = r22.getParent()
            org.lwjgl.opencl.CLContext r22 = (org.lwjgl.opencl.CLContext) r22
            r23 = r2
            r0 = r23
            org.lwjgl.opencl.CLEvent[] r0 = r0.clEvents
            r23 = r0
            r24 = r10
            r23 = r23[r24]
            r24 = 0
            org.lwjgl.opengl.GLSync r22 = org.lwjgl.opengl.ARBCLEvent.glCreateSyncFromCLeventARB(r22, r23, r24)
            r20[r21] = r22
        L_0x021d:
            int r10 = r10 + 1
            goto L_0x008a
        L_0x0221:
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLKernel[] r0 = r0.kernels
            r20 = r0
            r21 = r10
            r20 = r20[r21]
            r21 = 2
            r22 = r2
            r0 = r22
            double r0 = r0.minX
            r22 = r0
            r24 = r5
            r26 = r10
            r0 = r26
            double r0 = (double) r0
            r26 = r0
            double r24 = r24 * r26
            double r22 = r22 + r24
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r21 = 3
            r22 = r2
            r0 = r22
            double r0 = r0.minY
            r22 = r0
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r21 = 4
            r22 = r5
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            r21 = 5
            r22 = r7
            org.lwjgl.opencl.CLKernel r20 = r20.setArg(r21, r22)
            goto L_0x012f
        L_0x0268:
            r20 = 0
            r19 = r20
            goto L_0x01ad
        L_0x026e:
            r20 = r2
            r0 = r20
            boolean r0 = r0.syncGLtoCL
            r20 = r0
            if (r20 != 0) goto L_0x029f
            r20 = 0
            r11 = r20
        L_0x027c:
            r20 = r11
            r21 = r2
            r0 = r21
            int r0 = r0.slices
            r21 = r0
            r0 = r20
            r1 = r21
            if (r0 >= r1) goto L_0x029f
            r20 = r2
            r0 = r20
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r20 = r0
            r21 = r11
            r20 = r20[r21]
            int r20 = org.lwjgl.opencl.CL10.clFinish(r20)
            int r11 = r11 + 1
            goto L_0x027c
        L_0x029f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.test.opencl.p007gl.DemoFractal.compute(boolean):void");
    }

    private void createPrograms() throws IOException {
        String programSource = getProgramSource("org/lwjgl/test/opencl/gl/Mandelbrot.cl");
        for (int i = 0; i < this.programs.length; i++) {
            this.programs[i] = CL10.clCreateProgramWithSource(this.clContext, (CharSequence) programSource, (IntBuffer) null);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r12v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r8v12, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r8v16, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r13v3 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r8v25, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getProgramSource(java.lang.String r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r8 = r8.getContextClassLoader()
            r9 = r1
            java.net.URL r8 = r8.getResource(r9)
            r2 = r8
            r8 = 0
            r3 = r8
            r8 = r2
            if (r8 == 0) goto L_0x001b
            r8 = r2
            java.io.InputStream r8 = r8.openStream()
            r3 = r8
        L_0x001b:
            r8 = r3
            if (r8 != 0) goto L_0x003e
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r13 = r8
            r8 = r13
            r9 = r13
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r13 = r10
            r10 = r13
            r11 = r13
            r11.<init>()
            java.lang.String r11 = "src/java/"
            java.lang.StringBuilder r10 = r10.append(r11)
            r11 = r1
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            r3 = r8
        L_0x003e:
            java.io.BufferedReader r8 = new java.io.BufferedReader
            r13 = r8
            r8 = r13
            r9 = r13
            java.io.InputStreamReader r10 = new java.io.InputStreamReader
            r13 = r10
            r10 = r13
            r11 = r13
            r12 = r3
            r11.<init>(r12)
            r9.<init>(r10)
            r4 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r13 = r8
            r8 = r13
            r9 = r13
            r9.<init>()
            r5 = r8
        L_0x0059:
            r8 = r4
            java.lang.String r8 = r8.readLine()     // Catch:{ all -> 0x006f }
            r7 = r8
            r8 = r7
            if (r8 == 0) goto L_0x0077
            r8 = r5
            r9 = r7
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x006f }
            java.lang.String r9 = "\n"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x006f }
            goto L_0x0059
        L_0x006f:
            r8 = move-exception
            r6 = r8
            r8 = r3
            r8.close()
            r8 = r6
            throw r8
        L_0x0077:
            r8 = r3
            r8.close()
            r8 = r5
            java.lang.String r8 = r8.toString()
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.test.opencl.p007gl.DemoFractal.getProgramSource(java.lang.String):java.lang.String");
    }

    private void handleIO() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        if (Keyboard.getNumKeyboardEvents() != 0) {
            while (Keyboard.next()) {
                if (!Keyboard.getEventKeyState()) {
                    int eventKey = Keyboard.getEventKey();
                    if (2 > eventKey || eventKey > 9) {
                        switch (Keyboard.getEventKey()) {
                            case 1:
                                this.run = false;
                                break;
                            case 32:
                                this.doublePrecision = !this.doublePrecision;
                                PrintStream printStream = System.out;
                                StringBuilder sb4 = sb;
                                StringBuilder sb5 = new StringBuilder();
                                printStream.println(sb4.append("DOUBLE PRECISION IS NOW: ").append(this.doublePrecision ? "ON" : "OFF").toString());
                                this.rebuild = true;
                                break;
                            case 57:
                                this.drawSeparator = !this.drawSeparator;
                                PrintStream printStream2 = System.out;
                                StringBuilder sb6 = sb2;
                                StringBuilder sb7 = new StringBuilder();
                                printStream2.println(sb6.append("SEPARATOR DRAWING IS NOW: ").append(this.drawSeparator ? "ON" : "OFF").toString());
                                break;
                            case 199:
                                this.minX = -2.0d;
                                this.minY = -1.2000000476837158d;
                                this.maxX = 0.6000000238418579d;
                                this.maxY = 1.2999999523162842d;
                                break;
                        }
                    } else {
                        this.slices = Math.min(1 + (eventKey - 2), Math.min(this.queues.length, 8));
                        PrintStream printStream3 = System.out;
                        StringBuilder sb8 = sb3;
                        StringBuilder sb9 = new StringBuilder();
                        printStream3.println(sb8.append("NEW PARALLELISM LEVEL: ").append(this.slices).toString());
                        this.buffersInitialized = false;
                    }
                }
            }
        }
        while (Mouse.next()) {
            int eventButton = Mouse.getEventButton();
            int x = Mouse.getX();
            int y = Mouse.getY();
            if (!Mouse.isButtonDown(0) || (x == this.mouseX && y == this.mouseY)) {
                if (this.dragging) {
                    this.dragging = false;
                }
                if (eventButton == -1) {
                    int eventDWheel = Mouse.getEventDWheel();
                    if (eventDWheel != 0) {
                        double d = (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157)) ? 0.25d : 0.05d;
                        double d2 = eventDWheel > 0 ? d : -d;
                        double d3 = d2 * (this.maxX - this.minX);
                        double d4 = d2 * (this.maxY - this.minY);
                        double d5 = 2.0d * d3 * ((((double) x) / ((double) this.width)) - 0.5d);
                        double d6 = 2.0d * d4 * ((((double) y) / ((double) this.height)) - 0.5d);
                        this.minX += d3 + d5;
                        this.minY += d4 - d6;
                        this.maxX += d5 + (-d3);
                        this.maxY += (-d4) - d6;
                    }
                }
            } else {
                if (!this.dragging) {
                    this.dragging = true;
                    this.dragX = (double) this.mouseX;
                    this.dragY = (double) this.mouseY;
                    this.dragMinX = this.minX;
                    this.dragMinY = this.minY;
                    this.dragMaxX = this.maxX;
                    this.dragMaxY = this.maxY;
                }
                double d7 = ((((double) x) - this.dragX) * (this.maxX - this.minX)) / ((double) this.width);
                double d8 = ((((double) y) - this.dragY) * (this.maxY - this.minY)) / ((double) this.height);
                this.minX = this.dragMinX - d7;
                this.minY = this.dragMinY - d8;
                this.maxX = this.dragMaxX - d7;
                this.maxY = this.dragMaxY - d8;
            }
            this.mouseX = x;
            this.mouseY = y;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0413, code lost:
        if (r2.params.contains("forcePBO") == false) goto L_0x0415;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x045a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0502  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x064e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x065d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initCL(org.lwjgl.opengl.Drawable r38) throws java.lang.Exception {
        /*
            r37 = this;
            r2 = r37
            r3 = r38
            java.util.List r24 = org.lwjgl.opencl.CLPlatform.getPlatforms()
            r4 = r24
            r24 = r4
            if (r24 != 0) goto L_0x001c
            java.lang.RuntimeException r24 = new java.lang.RuntimeException
            r36 = r24
            r24 = r36
            r25 = r36
            java.lang.String r26 = "No OpenCL platforms found."
            r25.<init>(r26)
            throw r24
        L_0x001c:
            r24 = r4
            r25 = 0
            java.lang.Object r24 = r24.get(r25)
            org.lwjgl.opencl.CLPlatform r24 = (org.lwjgl.opencl.CLPlatform) r24
            r5 = r24
            org.lwjgl.test.opencl.gl.DemoFractal$1 r24 = new org.lwjgl.test.opencl.gl.DemoFractal$1
            r36 = r24
            r24 = r36
            r25 = r36
            r26 = r2
            r25.<init>(r26)
            r6 = r24
            r24 = r2
            r0 = r24
            java.util.Set<java.lang.String> r0 = r0.params
            r24 = r0
            java.lang.String r25 = "forceCPU"
            boolean r24 = r24.contains(r25)
            if (r24 == 0) goto L_0x007d
            r24 = 2
            r7 = r24
        L_0x004b:
            r24 = r5
            r25 = r7
            r26 = r6
            java.util.List r24 = r24.getDevices(r25, r26)
            r8 = r24
            r24 = r8
            if (r24 != 0) goto L_0x0082
            r24 = 2
            r7 = r24
            r24 = r5
            r25 = r7
            r26 = r6
            java.util.List r24 = r24.getDevices(r25, r26)
            r8 = r24
            r24 = r8
            if (r24 != 0) goto L_0x0082
            java.lang.RuntimeException r24 = new java.lang.RuntimeException
            r36 = r24
            r24 = r36
            r25 = r36
            java.lang.String r26 = "No OpenCL devices found with KHR_gl_sharing support."
            r25.<init>(r26)
            throw r24
        L_0x007d:
            r24 = 4
            r7 = r24
            goto L_0x004b
        L_0x0082:
            org.lwjgl.test.opencl.gl.DemoFractal$2 r24 = new org.lwjgl.test.opencl.gl.DemoFractal$2
            r36 = r24
            r24 = r36
            r25 = r36
            r26 = r2
            r25.<init>(r26)
            r9 = r24
            r24 = r2
            r25 = r5
            r26 = r8
            r27 = r9
            r28 = r3
            r29 = 0
            org.lwjgl.opencl.CLContext r25 = org.lwjgl.opencl.CLContext.create(r25, r26, r27, r28, r29)
            r0 = r25
            r1 = r24
            r1.clContext = r0
            r24 = r2
            r25 = r8
            int r25 = r25.size()
            r26 = 8
            int r25 = java.lang.Math.min(r25, r26)
            r0 = r25
            r1 = r24
            r1.slices = r0
            r24 = r2
            r25 = r2
            r0 = r25
            int r0 = r0.slices
            r25 = r0
            r0 = r25
            org.lwjgl.opencl.CLCommandQueue[] r0 = new org.lwjgl.opencl.CLCommandQueue[r0]
            r25 = r0
            r0 = r25
            r1 = r24
            r1.queues = r0
            r24 = r2
            r25 = r2
            r0 = r25
            int r0 = r0.slices
            r25 = r0
            r0 = r25
            org.lwjgl.opencl.CLKernel[] r0 = new org.lwjgl.opencl.CLKernel[r0]
            r25 = r0
            r0 = r25
            r1 = r24
            r1.kernels = r0
            r24 = r2
            r25 = r2
            r0 = r25
            int r0 = r0.slices
            r25 = r0
            r0 = r25
            org.lwjgl.opencl.CLMem[] r0 = new org.lwjgl.opencl.CLMem[r0]
            r25 = r0
            r0 = r25
            r1 = r24
            r1.colorMap = r0
            r24 = 0
            r10 = r24
        L_0x0101:
            r24 = r2
            r0 = r24
            int r0 = r0.slices
            r24 = r0
            r11 = r24
            r24 = r10
            r25 = r11
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x01fc
            r24 = r2
            r0 = r24
            org.lwjgl.opencl.CLMem[] r0 = r0.colorMap
            r24 = r0
            r25 = r10
            r26 = r2
            r0 = r26
            org.lwjgl.opencl.CLContext r0 = r0.clContext
            r26 = r0
            r27 = 4
            r29 = 256(0x100, double:1.265E-321)
            r31 = 0
            org.lwjgl.opencl.CLMem r26 = org.lwjgl.opencl.CL10.clCreateBuffer(r26, r27, r29, r31)
            r24[r25] = r26
            r24 = r2
            r0 = r24
            org.lwjgl.opencl.CLMem[] r0 = r0.colorMap
            r24 = r0
            r25 = r10
            r24 = r24[r25]
            r24.checkValid()
            r24 = r2
            r0 = r24
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r24 = r0
            r25 = r10
            r26 = r2
            r0 = r26
            org.lwjgl.opencl.CLContext r0 = r0.clContext
            r26 = r0
            r27 = r8
            r28 = r10
            java.lang.Object r27 = r27.get(r28)
            org.lwjgl.opencl.CLDevice r27 = (org.lwjgl.opencl.CLDevice) r27
            r28 = 2
            r30 = 0
            org.lwjgl.opencl.CLCommandQueue r26 = org.lwjgl.opencl.CL10.clCreateCommandQueue(r26, r27, r28, r30)
            r24[r25] = r26
            r24 = r2
            r0 = r24
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r24 = r0
            r25 = r10
            r24 = r24[r25]
            r24.checkValid()
            r24 = r2
            r0 = r24
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r24 = r0
            r25 = r10
            r24 = r24[r25]
            r25 = r2
            r0 = r25
            org.lwjgl.opencl.CLMem[] r0 = r0.colorMap
            r25 = r0
            r26 = r10
            r25 = r25[r26]
            r26 = 1
            r27 = 2
            r29 = 0
            r31 = 256(0x100, double:1.265E-321)
            r33 = 0
            r34 = 0
            r35 = 0
            java.nio.ByteBuffer r24 = org.lwjgl.opencl.CL10.clEnqueueMapBuffer(r24, r25, r26, r27, r29, r31, r33, r34, r35)
            r21 = r24
            r24 = r21
            java.nio.IntBuffer r24 = r24.asIntBuffer()
            r22 = r24
            r24 = 3
            r0 = r24
            org.lwjgl.util.ReadableColor[] r0 = new org.lwjgl.util.ReadableColor[r0]
            r24 = r0
            r23 = r24
            r24 = r23
            r25 = 0
            org.lwjgl.util.ReadableColor r26 = org.lwjgl.util.Color.BLUE
            r24[r25] = r26
            r24 = r23
            r25 = 1
            org.lwjgl.util.ReadableColor r26 = org.lwjgl.util.Color.GREEN
            r24[r25] = r26
            r24 = r23
            r25 = 2
            org.lwjgl.util.ReadableColor r26 = org.lwjgl.util.Color.RED
            r24[r25] = r26
            r24 = r22
            r25 = 32
            r26 = r23
            initColorMap(r24, r25, r26)
            r24 = r2
            r0 = r24
            org.lwjgl.opencl.CLCommandQueue[] r0 = r0.queues
            r24 = r0
            r25 = r10
            r24 = r24[r25]
            r25 = r2
            r0 = r25
            org.lwjgl.opencl.CLMem[] r0 = r0.colorMap
            r25 = r0
            r26 = r10
            r25 = r25[r26]
            r26 = r21
            r27 = 0
            r28 = 0
            int r24 = org.lwjgl.opencl.CL10.clEnqueueUnmapMemObject(r24, r25, r26, r27, r28)
            int r10 = r10 + 1
            goto L_0x0101
        L_0x01fc:
            r24 = 1
            r12 = r24
            r24 = r8
            java.util.Iterator r24 = r24.iterator()
            r13 = r24
        L_0x0208:
            r24 = r13
            boolean r24 = r24.hasNext()
            if (r24 == 0) goto L_0x0222
            r24 = r13
            java.lang.Object r24 = r24.next()
            org.lwjgl.opencl.CLDevice r24 = (org.lwjgl.opencl.CLDevice) r24
            boolean r24 = isDoubleFPAvailable(r24)
            if (r24 != 0) goto L_0x0208
            r24 = 0
            r12 = r24
        L_0x0222:
            r24 = r12
            if (r24 == 0) goto L_0x0258
            r24 = 1
            r14 = r24
        L_0x022a:
            r24 = r2
            r25 = r14
            r0 = r25
            org.lwjgl.opencl.CLProgram[] r0 = new org.lwjgl.opencl.CLProgram[r0]
            r25 = r0
            r0 = r25
            r1 = r24
            r1.programs = r0
            org.lwjgl.opengl.ContextCapabilities r24 = org.lwjgl.opengl.GLContext.getCapabilities()
            r15 = r24
            r24 = r15
            r0 = r24
            boolean r0 = r0.OpenGL20
            r24 = r0
            if (r24 != 0) goto L_0x0263
            java.lang.RuntimeException r24 = new java.lang.RuntimeException
            r36 = r24
            r24 = r36
            r25 = r36
            java.lang.String r26 = "OpenGL 2.0 is required to run this demo."
            r25.<init>(r26)
            throw r24
        L_0x0258:
            r24 = r2
            r0 = r24
            int r0 = r0.slices
            r24 = r0
            r14 = r24
            goto L_0x022a
        L_0x0263:
            r24 = r7
            r25 = 2
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x0285
            r24 = r15
            r0 = r24
            boolean r0 = r0.OpenGL21
            r24 = r0
            if (r24 != 0) goto L_0x0285
            java.lang.RuntimeException r24 = new java.lang.RuntimeException
            r36 = r24
            r24 = r36
            r25 = r36
            java.lang.String r26 = "OpenGL 2.1 is required to run this demo."
            r25.<init>(r26)
            throw r24
        L_0x0285:
            r24 = r2
            r0 = r24
            java.util.Set<java.lang.String> r0 = r0.params
            r24 = r0
            java.lang.String r25 = "debugGL"
            boolean r24 = r24.contains(r25)
            if (r24 == 0) goto L_0x02ad
            r24 = r15
            r0 = r24
            boolean r0 = r0.GL_ARB_debug_output
            r24 = r0
            if (r24 == 0) goto L_0x0319
            org.lwjgl.opengl.ARBDebugOutputCallback r24 = new org.lwjgl.opengl.ARBDebugOutputCallback
            r36 = r24
            r24 = r36
            r25 = r36
            r25.<init>()
            org.lwjgl.opengl.ARBDebugOutput.glDebugMessageCallbackARB(r24)
        L_0x02ad:
            r24 = r7
            r25 = 4
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x0333
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "OpenCL Device Type: GPU (Use -forceCPU to use CPU)"
            r24.println(r25)
        L_0x02be:
            r24 = 0
            r16 = r24
        L_0x02c2:
            r24 = r8
            int r24 = r24.size()
            r17 = r24
            r24 = r16
            r25 = r17
            r0 = r24
            r1 = r25
            if (r0 >= r1) goto L_0x033b
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r36 = r25
            r25 = r36
            r26 = r36
            r26.<init>()
            java.lang.String r26 = "OpenCL Device #"
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r16
            r27 = 1
            int r26 = r26 + 1
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r26 = " supports KHR_gl_event = "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r8
            r27 = r16
            java.lang.Object r26 = r26.get(r27)
            org.lwjgl.opencl.CLDevice r26 = (org.lwjgl.opencl.CLDevice) r26
            org.lwjgl.opencl.CLDeviceCapabilities r26 = org.lwjgl.opencl.CLCapabilities.getDeviceCapabilities(r26)
            r0 = r26
            boolean r0 = r0.CL_KHR_gl_event
            r26 = r0
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            r24.println(r25)
            int r16 = r16 + 1
            goto L_0x02c2
        L_0x0319:
            r24 = r15
            r0 = r24
            boolean r0 = r0.GL_AMD_debug_output
            r24 = r0
            if (r24 == 0) goto L_0x02ad
            org.lwjgl.opengl.AMDDebugOutputCallback r24 = new org.lwjgl.opengl.AMDDebugOutputCallback
            r36 = r24
            r24 = r36
            r25 = r36
            r25.<init>()
            org.lwjgl.opengl.AMDDebugOutput.glDebugMessageCallbackAMD(r24)
            goto L_0x02ad
        L_0x0333:
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "OpenCL Device Type: CPU"
            r24.println(r25)
            goto L_0x02be
        L_0x033b:
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r36 = r25
            r25 = r36
            r26 = r36
            r26.<init>()
            java.lang.String r26 = "\nMax Iterations: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r2
            r0 = r26
            int r0 = r0.maxIterations
            r26 = r0
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r26 = " (Use -iterations <count> to change)"
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            r24.println(r25)
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r36 = r25
            r25 = r36
            r26 = r36
            r26.<init>()
            java.lang.String r26 = "Display resolution: "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r2
            r0 = r26
            int r0 = r0.width
            r26 = r0
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r26 = "x"
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r2
            r0 = r26
            int r0 = r0.height
            r26 = r0
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r26 = " (Use -res <width> <height> to change)"
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            r24.println(r25)
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r36 = r25
            r25 = r36
            r26 = r36
            r26.<init>()
            java.lang.String r26 = "\nOpenGL caps.GL_ARB_sync = "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r15
            r0 = r26
            boolean r0 = r0.GL_ARB_sync
            r26 = r0
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            r24.println(r25)
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r36 = r25
            r25 = r36
            r26 = r36
            r26.<init>()
            java.lang.String r26 = "OpenGL caps.GL_ARB_cl_event = "
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r15
            r0 = r26
            boolean r0 = r0.GL_ARB_cl_event
            r26 = r0
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            r24.println(r25)
            r24 = r7
            r25 = 4
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x0638
            r24 = r15
            r0 = r24
            boolean r0 = r0.OpenGL21
            r24 = r0
            if (r24 == 0) goto L_0x0415
            r24 = r2
            r0 = r24
            java.util.Set<java.lang.String> r0 = r0.params
            r24 = r0
            java.lang.String r25 = "forcePBO"
            boolean r24 = r24.contains(r25)
            if (r24 != 0) goto L_0x0638
        L_0x0415:
            r24 = 1
            r18 = r24
        L_0x0419:
            r24 = r2
            r25 = r18
            r0 = r25
            r1 = r24
            r1.useTextures = r0
            r24 = r2
            r0 = r24
            boolean r0 = r0.useTextures
            r24 = r0
            if (r24 == 0) goto L_0x063e
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "\nCL/GL Sharing method: TEXTURES (use -forcePBO to use PBO + DrawPixels)"
            r24.println(r25)
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "Rendering method: Shader on a fullscreen quad"
            r24.println(r25)
        L_0x043b:
            r24 = r2
            r24.buildPrograms()
            r24 = r2
            r25 = r15
            r0 = r25
            boolean r0 = r0.GL_ARB_cl_event
            r25 = r0
            r0 = r25
            r1 = r24
            r1.syncGLtoCL = r0
            r24 = r2
            r0 = r24
            boolean r0 = r0.syncGLtoCL
            r24 = r0
            if (r24 == 0) goto L_0x064e
            r24 = r2
            r25 = r2
            r0 = r25
            int r0 = r0.slices
            r25 = r0
            r0 = r25
            org.lwjgl.opencl.CLEvent[] r0 = new org.lwjgl.opencl.CLEvent[r0]
            r25 = r0
            r0 = r25
            r1 = r24
            r1.clEvents = r0
            r24 = r2
            r25 = r2
            r0 = r25
            int r0 = r0.slices
            r25 = r0
            r0 = r25
            org.lwjgl.opengl.GLSync[] r0 = new org.lwjgl.opengl.GLSync[r0]
            r25 = r0
            r0 = r25
            r1 = r24
            r1.clSyncs = r0
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "\nGL to CL sync: Using OpenCL events"
            r24.println(r25)
        L_0x048d:
            r24 = r15
            r0 = r24
            boolean r0 = r0.OpenGL32
            r24 = r0
            if (r24 != 0) goto L_0x04a1
            r24 = r15
            r0 = r24
            boolean r0 = r0.GL_ARB_sync
            r24 = r0
            if (r24 == 0) goto L_0x0657
        L_0x04a1:
            r24 = 1
            r19 = r24
        L_0x04a5:
            r24 = r2
            r25 = r19
            r0 = r25
            r1 = r24
            r1.syncCLtoGL = r0
            r24 = r2
            r0 = r24
            boolean r0 = r0.syncCLtoGL
            r24 = r0
            if (r24 == 0) goto L_0x04e7
            r24 = r8
            java.util.Iterator r24 = r24.iterator()
            r20 = r24
        L_0x04c1:
            r24 = r20
            boolean r24 = r24.hasNext()
            if (r24 == 0) goto L_0x04e7
            r24 = r20
            java.lang.Object r24 = r24.next()
            org.lwjgl.opencl.CLDevice r24 = (org.lwjgl.opencl.CLDevice) r24
            org.lwjgl.opencl.CLDeviceCapabilities r24 = org.lwjgl.opencl.CLCapabilities.getDeviceCapabilities(r24)
            r0 = r24
            boolean r0 = r0.CL_KHR_gl_event
            r24 = r0
            if (r24 != 0) goto L_0x04c1
            r24 = r2
            r25 = 0
            r0 = r25
            r1 = r24
            r1.syncCLtoGL = r0
        L_0x04e7:
            r24 = r2
            r0 = r24
            boolean r0 = r0.syncCLtoGL
            r24 = r0
            if (r24 == 0) goto L_0x065d
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "CL to GL sync: Using OpenGL sync objects"
            r24.println(r25)
        L_0x04f8:
            r24 = r2
            r0 = r24
            boolean r0 = r0.useTextures
            r24 = r0
            if (r24 == 0) goto L_0x0630
            r24 = r2
            r25 = 1
            int r25 = org.lwjgl.opengl.GL11.glGenLists(r25)
            r0 = r25
            r1 = r24
            r1.dlist = r0
            r24 = r2
            r0 = r24
            int r0 = r0.dlist
            r24 = r0
            r25 = 4864(0x1300, float:6.816E-42)
            org.lwjgl.opengl.GL11.glNewList(r24, r25)
            r24 = 7
            org.lwjgl.opengl.GL11.glBegin(r24)
            r24 = 0
            r25 = 0
            org.lwjgl.opengl.GL11.glTexCoord2f(r24, r25)
            r24 = 0
            r25 = 0
            org.lwjgl.opengl.GL11.glVertex2f(r24, r25)
            r24 = 0
            r25 = 1065353216(0x3f800000, float:1.0)
            org.lwjgl.opengl.GL11.glTexCoord2f(r24, r25)
            r24 = 0
            r25 = r2
            r0 = r25
            int r0 = r0.height
            r25 = r0
            org.lwjgl.opengl.GL11.glVertex2i(r24, r25)
            r24 = 1065353216(0x3f800000, float:1.0)
            r25 = 1065353216(0x3f800000, float:1.0)
            org.lwjgl.opengl.GL11.glTexCoord2f(r24, r25)
            r24 = r2
            r0 = r24
            int r0 = r0.width
            r24 = r0
            r0 = r24
            float r0 = (float) r0
            r24 = r0
            r25 = r2
            r0 = r25
            int r0 = r0.height
            r25 = r0
            r0 = r25
            float r0 = (float) r0
            r25 = r0
            org.lwjgl.opengl.GL11.glVertex2f(r24, r25)
            r24 = 1065353216(0x3f800000, float:1.0)
            r25 = 0
            org.lwjgl.opengl.GL11.glTexCoord2f(r24, r25)
            r24 = r2
            r0 = r24
            int r0 = r0.width
            r24 = r0
            r0 = r24
            float r0 = (float) r0
            r24 = r0
            r25 = 0
            org.lwjgl.opengl.GL11.glVertex2f(r24, r25)
            org.lwjgl.opengl.GL11.glEnd()
            org.lwjgl.opengl.GL11.glEndList()
            r24 = r2
            r25 = 35633(0x8b31, float:4.9932E-41)
            int r25 = org.lwjgl.opengl.GL20.glCreateShader(r25)
            r0 = r25
            r1 = r24
            r1.vsh = r0
            r24 = r2
            r0 = r24
            int r0 = r0.vsh
            r24 = r0
            java.lang.String r25 = "varying vec2 texCoord;\n\nvoid main(void) {\n\tgl_Position = ftransform();\n\ttexCoord = gl_MultiTexCoord0.xy;\n}"
            org.lwjgl.opengl.GL20.glShaderSource(r24, r25)
            r24 = r2
            r0 = r24
            int r0 = r0.vsh
            r24 = r0
            org.lwjgl.opengl.GL20.glCompileShader(r24)
            r24 = r2
            r25 = 35632(0x8b30, float:4.9931E-41)
            int r25 = org.lwjgl.opengl.GL20.glCreateShader(r25)
            r0 = r25
            r1 = r24
            r1.fsh = r0
            r24 = r2
            r0 = r24
            int r0 = r0.fsh
            r24 = r0
            java.lang.String r25 = "uniform sampler2D mandelbrot;\n\nvarying vec2 texCoord;\n\nvoid main(void) {\n\tgl_FragColor = texture2D(mandelbrot, texCoord);}"
            org.lwjgl.opengl.GL20.glShaderSource(r24, r25)
            r24 = r2
            r0 = r24
            int r0 = r0.fsh
            r24 = r0
            org.lwjgl.opengl.GL20.glCompileShader(r24)
            r24 = r2
            int r25 = org.lwjgl.opengl.GL20.glCreateProgram()
            r0 = r25
            r1 = r24
            r1.program = r0
            r24 = r2
            r0 = r24
            int r0 = r0.program
            r24 = r0
            r25 = r2
            r0 = r25
            int r0 = r0.vsh
            r25 = r0
            org.lwjgl.opengl.GL20.glAttachShader(r24, r25)
            r24 = r2
            r0 = r24
            int r0 = r0.program
            r24 = r0
            r25 = r2
            r0 = r25
            int r0 = r0.fsh
            r25 = r0
            org.lwjgl.opengl.GL20.glAttachShader(r24, r25)
            r24 = r2
            r0 = r24
            int r0 = r0.program
            r24 = r0
            org.lwjgl.opengl.GL20.glLinkProgram(r24)
            r24 = r2
            r0 = r24
            int r0 = r0.program
            r24 = r0
            org.lwjgl.opengl.GL20.glUseProgram(r24)
            r24 = r2
            r0 = r24
            int r0 = r0.program
            r24 = r0
            java.lang.String r25 = "mandelbrot"
            int r24 = org.lwjgl.opengl.GL20.glGetUniformLocation(r24, r25)
            r25 = 0
            org.lwjgl.opengl.GL20.glUniform1i(r24, r25)
        L_0x0630:
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = ""
            r24.println(r25)
            return
        L_0x0638:
            r24 = 0
            r18 = r24
            goto L_0x0419
        L_0x063e:
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "\nCL/GL Sharing method: PIXEL BUFFER OBJECTS"
            r24.println(r25)
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "Rendering method: DrawPixels"
            r24.println(r25)
            goto L_0x043b
        L_0x064e:
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "\nGL to CL sync: Using clFinish"
            r24.println(r25)
            goto L_0x048d
        L_0x0657:
            r24 = 0
            r19 = r24
            goto L_0x04a5
        L_0x065d:
            java.io.PrintStream r24 = java.lang.System.out
            java.lang.String r25 = "CL to GL sync: Using glFinish"
            r24.println(r25)
            goto L_0x04f8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.test.opencl.p007gl.DemoFractal.initCL(org.lwjgl.opengl.Drawable):void");
    }

    private static void initColorMap(IntBuffer intBuffer, int i, ReadableColor... readableColorArr) {
        IntBuffer intBuffer2 = intBuffer;
        int i2 = i;
        ReadableColor[] readableColorArr2 = readableColorArr;
        for (int i3 = 0; i3 < -1 + readableColorArr2.length; i3++) {
            ReadableColor readableColor = readableColorArr2[i3];
            int red = readableColor.getRed();
            int green = readableColor.getGreen();
            int blue = readableColor.getBlue();
            ReadableColor readableColor2 = readableColorArr2[i3 + 1];
            int red2 = readableColor2.getRed();
            int green2 = readableColor2.getGreen();
            int i4 = red2 - red;
            int i5 = green2 - green;
            int blue2 = readableColor2.getBlue() - blue;
            for (int i6 = 0; i6 < i2; i6++) {
                float f = ((float) i6) / ((float) (i2 - 1));
                IntBuffer put = intBuffer2.put((((int) (((float) red) + (f * ((float) i4)))) << 0) | (((int) (((float) green) + (f * ((float) i5)))) << 8) | (((int) (((float) blue) + (f * ((float) blue2)))) << 16));
            }
        }
    }

    private void initGLObjects() {
        if (this.glBuffers == null) {
            this.glBuffers = new CLMem[this.slices];
            this.glIDs = BufferUtils.createIntBuffer(this.slices);
        } else {
            CLMem[] cLMemArr = this.glBuffers;
            int length = cLMemArr.length;
            for (int i = 0; i < length; i++) {
                int clReleaseMemObject = CL10.clReleaseMemObject(cLMemArr[i]);
            }
            if (this.useTextures) {
                GL11.glDeleteTextures(this.glIDs);
            } else {
                GL15.glDeleteBuffers(this.glIDs);
            }
        }
        if (this.useTextures) {
            GL11.glGenTextures(this.glIDs);
            for (int i2 = 0; i2 < this.slices; i2++) {
                GL11.glBindTexture(3553, this.glIDs.get(i2));
                GL11.glTexImage2D(3553, 0, (int) GL11.GL_RGBA, this.width / this.slices, this.height, 0, (int) GL11.GL_RGBA, (int) GL11.GL_UNSIGNED_BYTE, (ByteBuffer) null);
                GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
                GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                this.glBuffers[i2] = CL10GL.clCreateFromGLTexture2D(this.clContext, 2, 3553, 0, this.glIDs.get(i2), null);
            }
            GL11.glBindTexture(3553, 0);
        } else {
            GL15.glGenBuffers(this.glIDs);
            for (int i3 = 0; i3 < this.slices; i3++) {
                GL15.glBindBuffer(35052, this.glIDs.get(i3));
                GL15.glBufferData(35052, (long) ((4 * (this.width * this.height)) / this.slices), 35040);
                this.glBuffers[i3] = CL10GL.clCreateFromGLBuffer(this.clContext, 2, this.glIDs.get(i3), null);
            }
            GL15.glBindBuffer(35052, 0);
        }
        this.buffersInitialized = true;
    }

    private static void initView(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        GL11.glViewport(0, 0, i3, i4);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, (double) i3, 0.0d, (double) i4, 0.0d, 1.0d);
    }

    private static boolean isDoubleFPAvailable(CLDevice cLDevice) {
        CLDeviceCapabilities deviceCapabilities = CLCapabilities.getDeviceCapabilities(cLDevice);
        return deviceCapabilities.CL_KHR_fp64 || deviceCapabilities.CL_AMD_fp64;
    }

    public static void main(String[] strArr) {
        DemoFractal demoFractal;
        DemoFractal demoFractal2 = demoFractal;
        DemoFractal demoFractal3 = new DemoFractal(strArr);
        DemoFractal demoFractal4 = demoFractal2;
        demoFractal4.init();
        demoFractal4.run();
    }

    private void render() {
        GL11.glClear(16384);
        if (this.syncGLtoCL) {
            for (int i = 0; i < this.slices; i++) {
                ARBSync.glWaitSync(this.clSyncs[i], 0, 0);
            }
        }
        int i2 = this.width / this.slices;
        if (this.useTextures) {
            for (int i3 = 0; i3 < this.slices; i3++) {
                if (this.drawSeparator) {
                    int i4 = i3;
                }
                GL11.glBindTexture(3553, this.glIDs.get(i3));
                GL11.glCallList(this.dlist);
            }
        } else {
            for (int i5 = 0; i5 < this.slices; i5++) {
                int i6 = this.drawSeparator ? i5 : 0;
                GL15.glBindBuffer(35052, this.glIDs.get(i5));
                GL11.glRasterPos2i(i6 + (i2 * i5), 0);
                GL11.glDrawPixels(i2, this.height, (int) GL11.GL_RGBA, (int) GL11.GL_UNSIGNED_BYTE, 0);
            }
            GL15.glBindBuffer(35052, 0);
        }
        if (this.syncCLtoGL) {
            this.glSync = ARBSync.glFenceSync(37143, 0);
            this.glEvent = KHRGLEvent.clCreateEventFromGLsyncKHR(this.clContext, this.glSync, null);
        }
    }

    private void run() {
        StringBuilder sb;
        long currentTimeMillis = 5000 + System.currentTimeMillis();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!this.run) {
                break;
            }
            if (!Display.isVisible()) {
                Thread.yield();
            }
            handleIO();
            display();
            Display.update();
            if (Display.isCloseRequested()) {
                break;
            } else if (currentTimeMillis > System.currentTimeMillis()) {
                j = j2 + 1;
            } else {
                long currentTimeMillis2 = 5000 + (currentTimeMillis - System.currentTimeMillis());
                currentTimeMillis = 5000 + System.currentTimeMillis();
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append(j2).append(" frames in 5 seconds = ").append(((float) j2) / (((float) currentTimeMillis2) / 1000.0f)).toString());
                j = 0;
            }
        }
        int clReleaseContext = CL10.clReleaseContext(this.clContext);
        if (this.useTextures) {
            GL20.glDeleteProgram(this.program);
            GL20.glDeleteShader(this.fsh);
            GL20.glDeleteShader(this.vsh);
            GL11.glDeleteLists(this.dlist, 1);
        }
        C0774CL.destroy();
        Display.destroy();
    }

    private void setKernelConstants() {
        for (int i = 0; i < this.slices; i++) {
            CLKernel arg = this.kernels[i].setArg(6, (CLObject) this.glBuffers[i]).setArg(7, (CLObject) this.colorMap[i]).setArg(8, 256).setArg(9, this.maxIterations);
        }
    }

    public void display() {
        if (!this.syncCLtoGL || this.glEvent == null) {
            GL11.glFinish();
        } else {
            CLCommandQueue[] cLCommandQueueArr = this.queues;
            int length = cLCommandQueueArr.length;
            for (int i = 0; i < length; i++) {
                int clEnqueueWaitForEvents = CL10.clEnqueueWaitForEvents(cLCommandQueueArr[i], this.glEvent);
            }
        }
        if (!this.buffersInitialized) {
            initGLObjects();
            setKernelConstants();
        }
        if (this.rebuild) {
            buildPrograms();
            setKernelConstants();
        }
        compute(this.doublePrecision);
        render();
    }

    public void init() {
        RuntimeException runtimeException;
        DisplayMode displayMode;
        PixelFormat pixelFormat;
        ContextAttribs contextAttribs;
        RuntimeException runtimeException2;
        try {
            C0774CL.create();
            DisplayMode displayMode2 = displayMode;
            DisplayMode displayMode3 = new DisplayMode(this.width, this.height);
            Display.setDisplayMode(displayMode2);
            Display.setTitle("OpenCL Fractal Demo");
            Display.setSwapInterval(0);
            PixelFormat pixelFormat2 = pixelFormat;
            PixelFormat pixelFormat3 = new PixelFormat();
            ContextAttribs contextAttribs2 = contextAttribs;
            ContextAttribs contextAttribs3 = new ContextAttribs();
            Display.create(pixelFormat2, contextAttribs2.withDebug(this.params.contains("debugGL")));
            try {
                initCL(Display.getDrawable());
                GL11.glDisable(GL11.GL_DEPTH_TEST);
                GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                initView(Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());
                initGLObjects();
                GL11.glFinish();
                setKernelConstants();
            } catch (Exception e) {
                Exception exc = e;
                if (this.clContext != null) {
                    int clReleaseContext = CL10.clReleaseContext(this.clContext);
                }
                Display.destroy();
                RuntimeException runtimeException3 = runtimeException2;
                RuntimeException runtimeException4 = new RuntimeException(exc);
                throw runtimeException3;
            }
        } catch (LWJGLException e2) {
            LWJGLException lWJGLException = e2;
            RuntimeException runtimeException5 = runtimeException;
            RuntimeException runtimeException6 = new RuntimeException(lWJGLException);
            throw runtimeException5;
        }
    }
}

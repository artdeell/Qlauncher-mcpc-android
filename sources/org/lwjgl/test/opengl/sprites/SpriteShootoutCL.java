package org.lwjgl.test.opengl.sprites;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opencl.C0774CL;
import org.lwjgl.opencl.CL10;
import org.lwjgl.opencl.CL10GL;
import org.lwjgl.opencl.CLBuildProgramCallback;
import org.lwjgl.opencl.CLCapabilities;
import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLContextCallback;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLKernel;
import org.lwjgl.opencl.CLMem;
import org.lwjgl.opencl.CLPlatform;
import org.lwjgl.opencl.CLProgram;
import org.lwjgl.opencl.api.Filter;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.Util;
import org.lwjgl.util.glu.GLU;

public final class SpriteShootoutCL {
    private static final int ANIMATION_TICKS = 60;
    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private boolean animate = true;
    /* access modifiers changed from: private */
    public int ballCount = GLU.GLU_SMOOTH;
    /* access modifiers changed from: private */
    public int ballSize = 42;
    /* access modifiers changed from: private */
    public CLContext clContext;
    /* access modifiers changed from: private */
    public CLDevice clDevice;
    /* access modifiers changed from: private */
    public CLMem clTransform;
    private boolean colorMask = true;
    /* access modifiers changed from: private */
    public IntBuffer errorCode = BufferUtils.createIntBuffer(1);
    /* access modifiers changed from: private */
    public CLKernel kernel;
    /* access modifiers changed from: private */
    public PointerBuffer kernelGlobalWorkSize;
    /* access modifiers changed from: private */
    public CLProgram program;
    /* access modifiers changed from: private */
    public CLCommandQueue queue;
    private boolean render = true;
    private SpriteRenderer renderer;
    private boolean run = true;
    private boolean smooth;
    private int texBigID;
    private int texID;
    private int texSmallID;
    private boolean vsync;

    private abstract class SpriteRenderer {
        protected int animVBO;
        protected int progID;
        final /* synthetic */ SpriteShootoutCL this$0;

        private SpriteRenderer(SpriteShootoutCL spriteShootoutCL) {
            this.this$0 = spriteShootoutCL;
        }

        /* synthetic */ SpriteRenderer(SpriteShootoutCL spriteShootoutCL, C08361 r7) {
            C08361 r2 = r7;
            this(spriteShootoutCL);
        }

        /* access modifiers changed from: protected */
        public void createKernel(String str) {
            StringBuilder sb;
            RuntimeException runtimeException;
            StringBuilder sb2;
            CLProgram access$002 = SpriteShootoutCL.access$002(this.this$0, CL10.clCreateProgramWithSource(this.this$0.clContext, (CharSequence) str, this.this$0.errorCode));
            SpriteShootoutCL.checkCLError(this.this$0.errorCode);
            int clBuildProgram = CL10.clBuildProgram(this.this$0.program, this.this$0.clDevice, (CharSequence) LibrariesRepository.MOJANG_MAVEN_REPO, (CLBuildProgramCallback) null);
            if (clBuildProgram != 0) {
                PrintStream printStream = System.out;
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                printStream.println(sb3.append("BUILD LOG: ").append(this.this$0.program.getBuildInfoString(this.this$0.clDevice, CL10.CL_PROGRAM_BUILD_LOG)).toString());
                RuntimeException runtimeException2 = runtimeException;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                RuntimeException runtimeException3 = new RuntimeException(sb5.append("Failed to build CL program, status: ").append(clBuildProgram).toString());
                throw runtimeException2;
            }
            CLKernel access$502 = SpriteShootoutCL.access$502(this.this$0, CL10.clCreateKernel(this.this$0.program, (CharSequence) "animate", this.this$0.errorCode));
            SpriteShootoutCL.checkCLError(this.this$0.errorCode);
            PointerBuffer access$602 = SpriteShootoutCL.access$602(this.this$0, BufferUtils.createPointerBuffer(1));
            PointerBuffer put = this.this$0.kernelGlobalWorkSize.put(0, (long) this.this$0.ballCount);
            CLKernel arg = this.this$0.kernel.setArg(0, (int) SpriteShootoutCL.SCREEN_WIDTH);
            CLKernel arg2 = this.this$0.kernel.setArg(1, (int) SpriteShootoutCL.SCREEN_HEIGHT);
        }

        /* access modifiers changed from: protected */
        public void createProgram(int i) {
            RuntimeException runtimeException;
            RuntimeException runtimeException2;
            int i2 = i;
            int glCreateShader = GL20.glCreateShader(35632);
            GL20.glShaderSource(glCreateShader, (CharSequence) "#version 110\nuniform sampler2D COLOR_MAP;void main(void) {\n     gl_FragColor = texture2D(COLOR_MAP, gl_PointCoord);\n}");
            GL20.glCompileShader(glCreateShader);
            if (GL20.glGetShaderi(glCreateShader, 35713) == 0) {
                System.out.println(GL20.glGetShaderInfoLog(glCreateShader, GL20.glGetShaderi(glCreateShader, 35716)));
                RuntimeException runtimeException3 = runtimeException2;
                RuntimeException runtimeException4 = new RuntimeException("Failed to compile fragment shader.");
                throw runtimeException3;
            }
            this.progID = GL20.glCreateProgram();
            GL20.glAttachShader(this.progID, i2);
            GL20.glAttachShader(this.progID, glCreateShader);
            GL20.glLinkProgram(this.progID);
            if (GL20.glGetProgrami(this.progID, 35714) == 0) {
                System.out.println(GL20.glGetProgramInfoLog(this.progID, GL20.glGetProgrami(this.progID, 35716)));
                RuntimeException runtimeException5 = runtimeException;
                RuntimeException runtimeException6 = new RuntimeException("Failed to link shader program.");
                throw runtimeException5;
            }
            GL20.glUseProgram(this.progID);
            GL20.glUniform1i(GL20.glGetUniformLocation(this.progID, (CharSequence) "COLOR_MAP"), 0);
            GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        }

        /* access modifiers changed from: protected */
        public abstract void render(boolean z, boolean z2, int i);

        public void updateBallSize() {
            GL11.glPointSize((float) this.this$0.ballSize);
            CLKernel arg = this.this$0.kernel.setArg(2, 0.5f * ((float) this.this$0.ballSize));
        }

        public void updateBalls(int i) {
            Random random;
            int i2 = i;
            PointerBuffer put = this.this$0.kernelGlobalWorkSize.put(0, (long) this.this$0.ballCount);
            FloatBuffer createFloatBuffer = BufferUtils.createFloatBuffer(i2 * 4);
            Random random2 = random;
            Random random3 = new Random();
            Random random4 = random2;
            for (int i3 = 0; i3 < i2; i3++) {
                FloatBuffer put2 = createFloatBuffer.put(((float) ((int) (random4.nextFloat() * ((float) (800 - this.this$0.ballSize))))) + (0.5f * ((float) this.this$0.ballSize)));
                FloatBuffer put3 = createFloatBuffer.put(((float) ((int) (random4.nextFloat() * ((float) (600 - this.this$0.ballSize))))) + (0.5f * ((float) this.this$0.ballSize)));
                FloatBuffer put4 = createFloatBuffer.put((0.4f * random4.nextFloat()) - 0.2f);
                FloatBuffer put5 = createFloatBuffer.put((0.4f * random4.nextFloat()) - 0.2f);
            }
            Buffer flip = createFloatBuffer.flip();
            if (this.animVBO != 0) {
                int clReleaseMemObject = CL10.clReleaseMemObject(this.this$0.clTransform);
                GL15.glDeleteBuffers(this.animVBO);
            }
            this.animVBO = GL15.glGenBuffers();
            GL15.glBindBuffer(34962, this.animVBO);
            GL15.glBufferData(34962, createFloatBuffer, 35044);
            GL11.glVertexPointer(2, (int) GL11.GL_FLOAT, 16, 0);
            CLMem access$902 = SpriteShootoutCL.access$902(this.this$0, CL10GL.clCreateFromGLBuffer(this.this$0.clContext, 1, this.animVBO, this.this$0.errorCode));
            SpriteShootoutCL.checkCLError(this.this$0.errorCode);
            CLKernel arg = this.this$0.kernel.setArg(4, (CLObject) this.this$0.clTransform);
        }
    }

    private class SpriteRendererDefault extends SpriteRenderer {
        final /* synthetic */ SpriteShootoutCL this$0;

        SpriteRendererDefault(SpriteShootoutCL spriteShootoutCL) {
            RuntimeException runtimeException;
            SpriteShootoutCL spriteShootoutCL2 = spriteShootoutCL;
            this.this$0 = spriteShootoutCL2;
            super(spriteShootoutCL2, null);
            System.out.println("Shootout Implementation: OpenCL GPU animation");
            int glCreateShader = GL20.glCreateShader(35633);
            GL20.glShaderSource(glCreateShader, (CharSequence) "#version 150\nvoid main(void) {\n     gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;\n}");
            GL20.glCompileShader(glCreateShader);
            if (GL20.glGetShaderi(glCreateShader, 35713) == 0) {
                System.out.println(GL20.glGetShaderInfoLog(glCreateShader, GL20.glGetShaderi(glCreateShader, 35716)));
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException("Failed to compile vertex shader.");
                throw runtimeException2;
            }
            createProgram(glCreateShader);
            Util.checkGLError();
            createKernel("kernel void animate(\n        const int WIDTH,\n        const int HEIGHT,\n        const float radius,\n        const int delta,\n        global float4 *balls\n) {\n    unsigned int b = get_global_id(0);\n\n     float4 anim = balls[b];\n     anim.xy = anim.xy + anim.zw * delta;\n     float2 animC = clamp(anim.xy, (float2)radius, (float2)(WIDTH - radius, HEIGHT - radius));\n     if ( anim.x != animC.x ) anim.z = -anim.z;\n     if ( anim.y != animC.y ) anim.w = -anim.w;\n\n     balls[b] = (float4)(animC, anim.zw);\n}");
            updateBallSize();
        }

        public void render(boolean z, boolean z2, int i) {
            boolean z3 = z;
            int i2 = i;
            if (z2) {
                CLKernel arg = this.this$0.kernel.setArg(3, i2);
                int clEnqueueAcquireGLObjects = CL10GL.clEnqueueAcquireGLObjects(this.this$0.queue, this.this$0.clTransform, (PointerBuffer) null, (PointerBuffer) null);
                int clEnqueueNDRangeKernel = CL10.clEnqueueNDRangeKernel(this.this$0.queue, this.this$0.kernel, 1, null, this.this$0.kernelGlobalWorkSize, null, null, null);
                int clEnqueueReleaseGLObjects = CL10GL.clEnqueueReleaseGLObjects(this.this$0.queue, this.this$0.clTransform, (PointerBuffer) null, (PointerBuffer) null);
                int clFinish = CL10.clFinish(this.this$0.queue);
            }
            if (z3) {
                GL11.glDrawArrays(0, 0, this.this$0.ballCount);
            }
        }

        public void updateBalls(int i) {
            super.updateBalls(i);
        }
    }

    private SpriteShootoutCL() {
    }

    static /* synthetic */ CLProgram access$002(SpriteShootoutCL spriteShootoutCL, CLProgram cLProgram) {
        CLProgram cLProgram2 = cLProgram;
        spriteShootoutCL.program = cLProgram2;
        return cLProgram2;
    }

    static /* synthetic */ CLKernel access$502(SpriteShootoutCL spriteShootoutCL, CLKernel cLKernel) {
        CLKernel cLKernel2 = cLKernel;
        spriteShootoutCL.kernel = cLKernel2;
        return cLKernel2;
    }

    static /* synthetic */ PointerBuffer access$602(SpriteShootoutCL spriteShootoutCL, PointerBuffer pointerBuffer) {
        PointerBuffer pointerBuffer2 = pointerBuffer;
        spriteShootoutCL.kernelGlobalWorkSize = pointerBuffer2;
        return pointerBuffer2;
    }

    static /* synthetic */ CLMem access$902(SpriteShootoutCL spriteShootoutCL, CLMem cLMem) {
        CLMem cLMem2 = cLMem;
        spriteShootoutCL.clTransform = cLMem2;
        return cLMem2;
    }

    /* access modifiers changed from: private */
    public static void checkCLError(IntBuffer intBuffer) {
        org.lwjgl.opencl.Util.checkCLError(intBuffer.get(0));
    }

    private static int createTexture(String str) throws IOException {
        BufferedImage read = ImageIO.read(SpriteShootoutCL.class.getClassLoader().getResource(str));
        int width = read.getWidth();
        int height = read.getHeight();
        ByteBuffer readImage = readImage(read);
        int glGenTextures = GL11.glGenTextures();
        GL11.glBindTexture(3553, glGenTextures);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glTexImage2D(3553, 0, (int) GL11.GL_RGBA, width, height, 0, 32993, (int) GL11.GL_UNSIGNED_BYTE, readImage);
        return glGenTextures;
    }

    private void destroy() {
        if (this.clContext != null) {
            int clReleaseContext = CL10.clReleaseContext(this.clContext);
        }
        Display.destroy();
        System.exit(0);
    }

    private void handleInput() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        if (Display.isCloseRequested()) {
            this.run = false;
        }
        while (Keyboard.next()) {
            if (!Keyboard.getEventKeyState()) {
                switch (Keyboard.getEventKey()) {
                    case 1:
                        this.run = false;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        this.ballCount = 1 << (-2 + Keyboard.getEventKey());
                        updateBalls(this.ballCount);
                        break;
                    case 19:
                        this.render = !this.render;
                        PrintStream printStream = System.out;
                        StringBuilder sb7 = sb4;
                        StringBuilder sb8 = new StringBuilder();
                        printStream.println(sb7.append("Rendering is now ").append(this.render ? "on" : "off").append(".").toString());
                        break;
                    case 20:
                        if (this.texID == this.texBigID) {
                            this.texID = this.texSmallID;
                            this.ballSize = 16;
                        } else {
                            this.texID = this.texBigID;
                            this.ballSize = 42;
                        }
                        this.renderer.updateBallSize();
                        GL11.glBindTexture(3553, this.texID);
                        PrintStream printStream2 = System.out;
                        StringBuilder sb9 = sb2;
                        StringBuilder sb10 = new StringBuilder();
                        printStream2.println(sb9.append("Now using the ").append(this.texID == this.texBigID ? "big" : "small").append(" texture.").toString());
                        break;
                    case 30:
                        this.animate = !this.animate;
                        PrintStream printStream3 = System.out;
                        StringBuilder sb11 = sb6;
                        StringBuilder sb12 = new StringBuilder();
                        printStream3.println(sb11.append("Animation is now ").append(this.animate ? "on" : "off").append(".").toString());
                        break;
                    case 31:
                        this.smooth = !this.smooth;
                        PrintStream printStream4 = System.out;
                        StringBuilder sb13 = sb3;
                        StringBuilder sb14 = new StringBuilder();
                        printStream4.println(sb13.append("Smooth animation is now ").append(this.smooth ? "on" : "off").append(".").toString());
                        break;
                    case 46:
                        this.colorMask = !this.colorMask;
                        GL11.glColorMask(this.colorMask, this.colorMask, this.colorMask, false);
                        PrintStream printStream5 = System.out;
                        StringBuilder sb15 = sb5;
                        StringBuilder sb16 = new StringBuilder();
                        printStream5.println(sb15.append("Color mask is now ").append(this.colorMask ? "on" : "off").append(".").toString());
                        if (!this.colorMask) {
                            GL11.glDisable(GL11.GL_BLEND);
                            GL11.glDisable(GL11.GL_ALPHA_TEST);
                            break;
                        } else {
                            GL11.glEnable(GL11.GL_BLEND);
                            GL11.glEnable(GL11.GL_ALPHA_TEST);
                            break;
                        }
                    case 47:
                        this.vsync = !this.vsync;
                        Display.setVSyncEnabled(this.vsync);
                        PrintStream printStream6 = System.out;
                        StringBuilder sb17 = sb;
                        StringBuilder sb18 = new StringBuilder();
                        printStream6.println(sb17.append("VSYNC is now ").append(this.vsync ? "enabled" : "disabled").append(".").toString());
                        break;
                    case 74:
                    case 78:
                        int i = (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54)) ? 1000 : (Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184)) ? 100 : (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157)) ? 10 : 1;
                        if (Keyboard.getEventKey() == 74) {
                            i = -i;
                        }
                        this.ballCount += i * 100;
                        if (this.ballCount <= 0) {
                            this.ballCount = 1;
                        }
                        updateBalls(this.ballCount);
                        break;
                }
            }
        }
        do {
        } while (Mouse.next());
    }

    private void initCL() throws LWJGLException {
        C08361 r15;
        CLPlatform cLPlatform;
        C08372 r152;
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        C0774CL.create();
        List platforms = CLPlatform.getPlatforms();
        if (platforms == null) {
            RuntimeException runtimeException3 = runtimeException2;
            RuntimeException runtimeException4 = new RuntimeException("No OpenCL platforms found.");
            throw runtimeException3;
        }
        C08361 r9 = r15;
        C08361 r10 = new Filter<CLDevice>(this) {
            final /* synthetic */ SpriteShootoutCL this$0;

            {
                this.this$0 = r5;
            }

            public boolean accept(CLDevice cLDevice) {
                return CLCapabilities.getDeviceCapabilities(cLDevice).CL_KHR_gl_sharing;
            }
        };
        C08361 r2 = r9;
        List list = null;
        Iterator it = platforms.iterator();
        while (true) {
            cLPlatform = null;
            if (!it.hasNext()) {
                break;
            }
            CLPlatform cLPlatform2 = (CLPlatform) it.next();
            list = cLPlatform2.getDevices(4, r2);
            if (list != null) {
                cLPlatform = cLPlatform2;
                break;
            }
        }
        if (list == null) {
            RuntimeException runtimeException5 = runtimeException;
            RuntimeException runtimeException6 = new RuntimeException("No OpenCL GPU device found.");
            throw runtimeException5;
        }
        this.clDevice = (CLDevice) list.get(0);
        list.clear();
        boolean add = list.add(this.clDevice);
        CLPlatform cLPlatform3 = cLPlatform;
        List list2 = list;
        C08372 r12 = r152;
        C08372 r13 = new CLContextCallback(this) {
            final /* synthetic */ SpriteShootoutCL this$0;

            {
                this.this$0 = r5;
            }

            /* access modifiers changed from: protected */
            public void handleMessage(String str, ByteBuffer byteBuffer) {
                StringBuilder sb;
                String str2 = str;
                ByteBuffer byteBuffer2 = byteBuffer;
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("[CONTEXT MESSAGE] ").append(str2).toString());
            }
        };
        this.clContext = CLContext.create(cLPlatform3, list2, r12, Display.getDrawable(), this.errorCode);
        checkCLError(this.errorCode);
        this.queue = CL10.clCreateCommandQueue(this.clContext, this.clDevice, 0, this.errorCode);
        checkCLError(this.errorCode);
    }

    private void initGL() throws LWJGLException {
        DisplayMode displayMode;
        RuntimeException runtimeException;
        Display.setLocation((-800 + Display.getDisplayMode().getWidth()) / 2, (-600 + Display.getDisplayMode().getHeight()) / 2);
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT);
        Display.setDisplayMode(displayMode2);
        Display.setTitle("Sprite Shootout - CL");
        Display.create();
        ContextCapabilities capabilities = GLContext.getCapabilities();
        if (!capabilities.OpenGL20) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("OpenGL 2.0 is required for this demo.");
            throw runtimeException2;
        }
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0d, 800.0d, 0.0d, 600.0d, -1.0d, 1.0d);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        try {
            this.texSmallID = createTexture("res/ball_sm.png");
            this.texBigID = createTexture("res/ball.png");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        this.texID = this.texBigID;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(1, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.0f);
        GL11.glColorMask(this.colorMask, this.colorMask, this.colorMask, false);
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        if (capabilities.GL_ARB_compatibility || !capabilities.OpenGL31) {
            GL11.glEnable(34913);
        }
        Util.checkGLError();
    }

    public static void main(String[] strArr) {
        SpriteShootoutCL spriteShootoutCL;
        String[] strArr2 = strArr;
        try {
            SpriteShootoutCL spriteShootoutCL2 = spriteShootoutCL;
            SpriteShootoutCL spriteShootoutCL3 = new SpriteShootoutCL();
            spriteShootoutCL2.start();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    private static byte packUByte01(float f) {
        return (byte) ((int) (255.0f * f));
    }

    private static ByteBuffer readImage(BufferedImage bufferedImage) throws IOException {
        BufferedImage bufferedImage2 = bufferedImage;
        WritableRaster raster = bufferedImage2.getRaster();
        int numBands = raster.getNumBands();
        int width = bufferedImage2.getWidth();
        int height = bufferedImage2.getHeight();
        int i = numBands * width * height;
        byte[] bArr = new byte[i];
        Object dataElements = raster.getDataElements(0, 0, width, height, bArr);
        ByteBuffer createByteBuffer = BufferUtils.createByteBuffer(i);
        if (numBands == 4) {
            for (int i2 = 0; i2 < 4 * width * height; i2 += 4) {
                float unpackUByte01 = unpackUByte01(bArr[i2 + 3]);
                ByteBuffer put = createByteBuffer.put(packUByte01(unpackUByte01 * unpackUByte01(bArr[i2 + 2])));
                ByteBuffer put2 = createByteBuffer.put(packUByte01(unpackUByte01 * unpackUByte01(bArr[i2 + 1])));
                ByteBuffer put3 = createByteBuffer.put(packUByte01(unpackUByte01 * unpackUByte01(bArr[i2 + 0])));
                ByteBuffer put4 = createByteBuffer.put(bArr[i2 + 3]);
            }
        } else if (numBands == 3) {
            for (int i3 = 0; i3 < 3 * width * height; i3 += 3) {
                ByteBuffer put5 = createByteBuffer.put(bArr[i3 + 2]);
                ByteBuffer put6 = createByteBuffer.put(bArr[i3 + 1]);
                ByteBuffer put7 = createByteBuffer.put(bArr[i3 + 0]);
            }
        } else {
            ByteBuffer put8 = createByteBuffer.put(bArr, 0, i);
        }
        Buffer flip = createByteBuffer.flip();
        return createByteBuffer;
    }

    private void run() {
        StringBuilder sb;
        long currentTimeMillis = 5000 + System.currentTimeMillis();
        long j = 0;
        long time = Sys.getTime();
        int timerResolution = (int) (Sys.getTimerResolution() / 60);
        this.renderer.render(false, true, 0);
        while (this.run) {
            Display.processMessages();
            handleInput();
            GL11.glClear(16384);
            long time2 = Sys.getTime();
            int i = (int) (time2 - time);
            if (this.smooth || i >= timerResolution) {
                this.renderer.render(this.render, this.animate, i);
                time = time2;
            } else {
                this.renderer.render(this.render, false, 0);
            }
            Display.update(false);
            if (currentTimeMillis > System.currentTimeMillis()) {
                j++;
            } else {
                long currentTimeMillis2 = 5000 + (currentTimeMillis - System.currentTimeMillis());
                currentTimeMillis = 5000 + System.currentTimeMillis();
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("FPS: ").append(((double) Math.round(10.0d * (((double) j) / (((double) currentTimeMillis2) / 1000.0d)))) / 10.0d).append(", Balls: ").append(this.ballCount).toString());
                j = 0;
            }
        }
    }

    private void start() throws LWJGLException {
        SpriteRendererDefault spriteRendererDefault;
        try {
            initGL();
            initCL();
            SpriteRendererDefault spriteRendererDefault2 = spriteRendererDefault;
            SpriteRendererDefault spriteRendererDefault3 = new SpriteRendererDefault(this);
            this.renderer = spriteRendererDefault2;
            updateBalls(this.ballCount);
            run();
            destroy();
        } catch (Throwable th) {
            Throwable th2 = th;
            destroy();
            throw th2;
        }
    }

    private static float unpackUByte01(byte b) {
        return ((float) (b & 255)) / 255.0f;
    }

    private void updateBalls(int i) {
        StringBuilder sb;
        int i2 = i;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("NUMBER OF BALLS: ").append(i2).toString());
        this.renderer.updateBalls(this.ballCount);
    }
}

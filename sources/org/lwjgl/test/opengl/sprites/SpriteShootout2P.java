package org.lwjgl.test.opengl.sprites;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Random;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.EXTTransformFeedback;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.Util;
import org.lwjgl.util.glu.GLU;

public final class SpriteShootout2P {
    private static final int ANIMATION_TICKS = 60;
    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;
    private boolean animate = true;
    /* access modifiers changed from: private */
    public int ballCount = GLU.GLU_SMOOTH;
    /* access modifiers changed from: private */
    public int ballSize = 42;
    private boolean colorMask = true;
    private boolean render = true;
    private SpriteRenderer renderer;
    private boolean run = true;
    private boolean smooth;
    private int texBigID;
    private int texID;
    private int texSmallID;
    private boolean vsync;

    private abstract class SpriteRenderer {
        protected int progID;
        final /* synthetic */ SpriteShootout2P this$0;

        private SpriteRenderer(SpriteShootout2P spriteShootout2P) {
            this.this$0 = spriteShootout2P;
        }

        /* synthetic */ SpriteRenderer(SpriteShootout2P spriteShootout2P, C08351 r7) {
            C08351 r2 = r7;
            this(spriteShootout2P);
        }

        /* access modifiers changed from: protected */
        public void createPrograms(int i) {
            RuntimeException runtimeException;
            RuntimeException runtimeException2;
            int i2 = i;
            int glCreateShader = GL20.glCreateShader(35632);
            GL20.glShaderSource(glCreateShader, (CharSequence) "uniform sampler2D COLOR_MAP;\nvoid main(void) {\n     gl_FragColor = texture2D(COLOR_MAP, gl_PointCoord);\n}");
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
            updateBallSize();
            GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        }

        /* access modifiers changed from: protected */
        public abstract void render(boolean z, boolean z2, int i);

        public void updateBallSize() {
            GL11.glPointSize((float) this.this$0.ballSize);
        }

        /* access modifiers changed from: protected */
        public abstract void updateBalls(int i);
    }

    private class SpriteRendererTF extends SpriteRenderer {
        private int ballSizeLoc;
        private int currVBO;
        private int deltaLoc;
        private int depthLoc;
        private int depthVBO;
        private int progIDTF;
        private int[] tfVBO = new int[2];
        final /* synthetic */ SpriteShootout2P this$0;

        SpriteRendererTF(SpriteShootout2P spriteShootout2P) {
            RuntimeException runtimeException;
            RuntimeException runtimeException2;
            RuntimeException runtimeException3;
            SpriteShootout2P spriteShootout2P2 = spriteShootout2P;
            this.this$0 = spriteShootout2P2;
            super(spriteShootout2P2, null);
            System.out.println("Shootout Implementation: TF GPU animation & 2-pass rendering");
            int glCreateShader = GL20.glCreateShader(35633);
            GL20.glShaderSource(glCreateShader, (CharSequence) "#version 130\nconst float WIDTH = 800;\nconst float HEIGHT = 600;\nuniform float ballSize;\nuniform float delta;\nvoid main(void) {\n     vec4 anim = gl_Vertex;\n     anim.xy = anim.xy + anim.zw * delta;\n     vec2 animC = clamp(anim.xy, vec2(ballSize), vec2(WIDTH - ballSize, HEIGHT - ballSize));\n     if ( anim.x != animC.x ) anim.z = -anim.z;\n     if ( anim.y != animC.y ) anim.w = -anim.w;\n     gl_Position = vec4(animC, anim.zw);\n}");
            GL20.glCompileShader(glCreateShader);
            if (GL20.glGetShaderi(glCreateShader, 35713) == 0) {
                System.out.println(GL20.glGetShaderInfoLog(glCreateShader, GL20.glGetShaderi(glCreateShader, 35716)));
                RuntimeException runtimeException4 = runtimeException3;
                RuntimeException runtimeException5 = new RuntimeException("Failed to compile vertex shader.");
                throw runtimeException4;
            }
            this.progIDTF = GL20.glCreateProgram();
            GL20.glAttachShader(this.progIDTF, glCreateShader);
            int i = this.progIDTF;
            CharSequence[] charSequenceArr = new CharSequence[1];
            CharSequence[] charSequenceArr2 = charSequenceArr;
            charSequenceArr[0] = "gl_Position";
            GL30.glTransformFeedbackVaryings(i, charSequenceArr2, 35981);
            GL20.glLinkProgram(this.progIDTF);
            if (GL20.glGetProgrami(this.progIDTF, 35714) == 0) {
                System.out.println(GL20.glGetProgramInfoLog(this.progIDTF, GL20.glGetProgrami(this.progIDTF, 35716)));
                RuntimeException runtimeException6 = runtimeException2;
                RuntimeException runtimeException7 = new RuntimeException("Failed to link shader program.");
                throw runtimeException6;
            }
            GL20.glUseProgram(this.progIDTF);
            this.ballSizeLoc = GL20.glGetUniformLocation(this.progIDTF, (CharSequence) "ballSize");
            this.deltaLoc = GL20.glGetUniformLocation(this.progIDTF, (CharSequence) "delta");
            GL20.glUniform1f(this.ballSizeLoc, 0.5f * ((float) spriteShootout2P2.ballSize));
            int glCreateShader2 = GL20.glCreateShader(35633);
            GL20.glShaderSource(glCreateShader2, (CharSequence) "#version 130\nin float depth;\nvoid main(void) {\n     gl_Position = gl_ModelViewProjectionMatrix * vec4(gl_Vertex.xy, depth, gl_Vertex.w);\n}");
            GL20.glCompileShader(glCreateShader2);
            if (GL20.glGetShaderi(glCreateShader2, 35713) == 0) {
                System.out.println(GL20.glGetShaderInfoLog(glCreateShader2, GL20.glGetShaderi(glCreateShader2, 35716)));
                RuntimeException runtimeException8 = runtimeException;
                RuntimeException runtimeException9 = new RuntimeException("Failed to compile vertex shader.");
                throw runtimeException8;
            }
            createPrograms(glCreateShader2);
            this.depthLoc = GL20.glGetAttribLocation(this.progID, (CharSequence) "depth");
        }

        public void render(boolean z, boolean z2, int i) {
            boolean z3 = z;
            int i2 = i;
            if (z2) {
                GL20.glDisableVertexAttribArray(this.depthLoc);
                int i3 = this.currVBO;
                this.currVBO = 1 - this.currVBO;
                GL20.glUseProgram(this.progIDTF);
                GL20.glUniform1f(this.deltaLoc, (float) i2);
                GL15.glBindBuffer(34962, this.tfVBO[i3]);
                GL11.glVertexPointer(4, (int) GL11.GL_FLOAT, 0, 0);
                GL11.glEnable(35977);
                if (GLContext.getCapabilities().OpenGL30) {
                    GL30.glBindBufferBase(35982, 0, this.tfVBO[1 - i3]);
                    GL30.glBeginTransformFeedback(0);
                    GL11.glDrawArrays(0, 0, 2 * this.this$0.ballCount);
                    GL30.glEndTransformFeedback();
                } else {
                    EXTTransformFeedback.glBindBufferBaseEXT(35982, 0, this.tfVBO[1 - i3]);
                    EXTTransformFeedback.glBeginTransformFeedbackEXT(0);
                    GL11.glDrawArrays(0, 0, 2 * this.this$0.ballCount);
                    EXTTransformFeedback.glEndTransformFeedbackEXT();
                }
                GL11.glDisable(35977);
                GL20.glUseProgram(this.progID);
                GL11.glVertexPointer(2, (int) GL11.GL_FLOAT, 16, 0);
                GL20.glEnableVertexAttribArray(this.depthLoc);
            }
            if (z3) {
                GL11.glAlphaFunc(514, 1.0f);
                GL11.glDisable(GL11.GL_BLEND);
                GL11.glDrawArrays(0, 0, this.this$0.ballCount);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glAlphaFunc(GL11.GL_GREATER, 0.0f);
                GL11.glDepthMask(false);
                GL11.glDrawArrays(0, this.this$0.ballCount, this.this$0.ballCount);
                GL11.glDepthMask(true);
            }
        }

        public void updateBallSize() {
            GL20.glUseProgram(this.progIDTF);
            GL20.glUniform1f(this.ballSizeLoc, 0.5f * ((float) this.this$0.ballSize));
            super.updateBallSize();
        }

        public void updateBalls(int i) {
            Random random;
            int i2 = i;
            FloatBuffer createFloatBuffer = BufferUtils.createFloatBuffer(i2 * 2);
            float f = 1.9f / ((float) i2);
            float parseFloat = Float.parseFloat("0x1.fffffep-1");
            for (int i3 = 0; i3 < i2; i3++) {
                FloatBuffer put = createFloatBuffer.put(parseFloat);
                parseFloat -= f;
            }
            for (int i4 = 0; i4 < i2; i4++) {
                FloatBuffer put2 = createFloatBuffer.put(createFloatBuffer.get((i2 - 1) - i4));
            }
            Buffer flip = createFloatBuffer.flip();
            if (this.depthVBO != 0) {
                GL15.glDeleteBuffers(this.depthVBO);
            }
            this.depthVBO = GL15.glGenBuffers();
            GL15.glBindBuffer(34962, this.depthVBO);
            GL15.glBufferData(34962, createFloatBuffer, 35044);
            GL20.glEnableVertexAttribArray(this.depthLoc);
            GL20.glVertexAttribPointer(this.depthLoc, 1, (int) GL11.GL_FLOAT, false, 0, 0);
            FloatBuffer createFloatBuffer2 = BufferUtils.createFloatBuffer(4 * i2 * 2);
            Random random2 = random;
            Random random3 = new Random();
            Random random4 = random2;
            for (int i5 = 0; i5 < i2; i5++) {
                FloatBuffer put3 = createFloatBuffer2.put((float) ((int) ((random4.nextFloat() * ((float) (800 - this.this$0.ballSize))) + (0.5f * ((float) this.this$0.ballSize)))));
                FloatBuffer put4 = createFloatBuffer2.put((float) ((int) ((random4.nextFloat() * ((float) (600 - this.this$0.ballSize))) + (0.5f * ((float) this.this$0.ballSize)))));
                FloatBuffer put5 = createFloatBuffer2.put((0.4f * random4.nextFloat()) - 0.2f);
                FloatBuffer put6 = createFloatBuffer2.put((0.4f * random4.nextFloat()) - 0.2f);
            }
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = 4 * ((i2 - 1) - i6);
                FloatBuffer put7 = createFloatBuffer2.put(createFloatBuffer2.get(i7 + 0));
                FloatBuffer put8 = createFloatBuffer2.put(createFloatBuffer2.get(i7 + 1));
                FloatBuffer put9 = createFloatBuffer2.put(createFloatBuffer2.get(i7 + 2));
                FloatBuffer put10 = createFloatBuffer2.put(createFloatBuffer2.get(i7 + 3));
            }
            Buffer flip2 = createFloatBuffer2.flip();
            if (this.tfVBO[0] != 0) {
                for (int i8 = 0; i8 < this.tfVBO.length; i8++) {
                    GL15.glDeleteBuffers(this.tfVBO[i8]);
                }
            }
            for (int i9 = 0; i9 < this.tfVBO.length; i9++) {
                this.tfVBO[i9] = GL15.glGenBuffers();
                GL15.glBindBuffer(35982, this.tfVBO[i9]);
                GL15.glBufferData(35982, createFloatBuffer2, 35044);
            }
            GL15.glBindBuffer(34962, this.tfVBO[0]);
            GL11.glVertexPointer(2, (int) GL11.GL_FLOAT, 16, 0);
        }
    }

    private SpriteShootout2P() {
    }

    private static int createTexture(String str) throws IOException {
        BufferedImage read = ImageIO.read(SpriteShootout2P.class.getClassLoader().getResource(str));
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
        Display.destroy();
    }

    private void handleInput() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        int i;
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
                        if (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54)) {
                            i = 1000;
                            if (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157)) {
                                i = 1000 * 5;
                            }
                        } else {
                            i = (Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184)) ? 100 : (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157)) ? 10 : 1;
                        }
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

    private void initGL() throws LWJGLException {
        DisplayMode displayMode;
        PixelFormat pixelFormat;
        RuntimeException runtimeException;
        Display.setLocation((-800 + Display.getDisplayMode().getWidth()) / 2, (-600 + Display.getDisplayMode().getHeight()) / 2);
        DisplayMode displayMode2 = displayMode;
        DisplayMode displayMode3 = new DisplayMode(SCREEN_WIDTH, SCREEN_HEIGHT);
        Display.setDisplayMode(displayMode2);
        Display.setTitle("Sprite Shootout 2-pass");
        PixelFormat pixelFormat2 = pixelFormat;
        PixelFormat pixelFormat3 = new PixelFormat(0, 24, 0);
        Display.create(pixelFormat2);
        ContextCapabilities capabilities = GLContext.getCapabilities();
        if (capabilities.OpenGL30 || (capabilities.OpenGL20 && capabilities.GL_EXT_transform_feedback)) {
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
            GL11.glColorMask(this.colorMask, this.colorMask, this.colorMask, false);
            GL11.glDepthMask(true);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDepthFunc(513);
            GL11.glClearDepth(1.0d);
            if (capabilities.GL_ARB_compatibility || !capabilities.OpenGL31) {
                GL11.glEnable(34913);
            }
            GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
            GL11.glEnableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
            Util.checkGLError();
            return;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("OpenGL 3.0 or 2.0 + EXT_transform_feedback is required for this demo.");
        throw runtimeException2;
    }

    public static void main(String[] strArr) {
        SpriteShootout2P spriteShootout2P;
        String[] strArr2 = strArr;
        try {
            SpriteShootout2P spriteShootout2P2 = spriteShootout2P;
            SpriteShootout2P spriteShootout2P3 = new SpriteShootout2P();
            spriteShootout2P2.start();
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
            GL11.glClear(16640);
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
        SpriteRendererTF spriteRendererTF;
        try {
            initGL();
            SpriteRendererTF spriteRendererTF2 = spriteRendererTF;
            SpriteRendererTF spriteRendererTF3 = new SpriteRendererTF(this);
            this.renderer = spriteRendererTF2;
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

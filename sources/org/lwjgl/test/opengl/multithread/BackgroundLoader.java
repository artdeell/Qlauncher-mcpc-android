package org.lwjgl.test.opengl.multithread;

import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Drawable;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.GLSync;
import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;

abstract class BackgroundLoader {
    private static final int HEIGHT = 32;
    private static final int WIDTH = 32;
    /* access modifiers changed from: private */
    public Drawable drawable;
    private GLSync fence;
    /* access modifiers changed from: private */
    public final ReentrantLock lock;
    /* access modifiers changed from: private */
    public boolean running = true;
    /* access modifiers changed from: private */
    public int texID;
    /* access modifiers changed from: private */
    public ByteBuffer texture = BufferUtils.createByteBuffer(GL11.GL_AUX_BUFFERS);

    protected BackgroundLoader() {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2 = reentrantLock;
        ReentrantLock reentrantLock3 = new ReentrantLock();
        this.lock = reentrantLock2;
    }

    static /* synthetic */ int access$302(BackgroundLoader backgroundLoader, int i) {
        int i2 = i;
        backgroundLoader.texID = i2;
        return i2;
    }

    static /* synthetic */ GLSync access$502(BackgroundLoader backgroundLoader, GLSync gLSync) {
        GLSync gLSync2 = gLSync;
        backgroundLoader.fence = gLSync2;
        return gLSync2;
    }

    /* access modifiers changed from: private */
    public void createCheckerTexture(ReadableColor readableColor, ReadableColor readableColor2, int i) {
        ReadableColor readableColor3 = readableColor;
        ReadableColor readableColor4 = readableColor2;
        int i2 = i;
        int i3 = 0;
        for (int i4 = 0; i4 < 32; i4++) {
            for (int i5 = 0; i5 < 32; i5++) {
                ReadableColor readableColor5 = (i5 / i2) % 2 == 0 ? (i4 / i2) % 2 == 0 ? readableColor3 : readableColor4 : (i4 / i2) % 2 == 0 ? readableColor4 : readableColor3;
                ReadableColor readableColor6 = readableColor5;
                ByteBuffer put = this.texture.put(i3 + 0, readableColor6.getRedByte());
                ByteBuffer put2 = this.texture.put(i3 + 1, readableColor6.getGreenByte());
                ByteBuffer put3 = this.texture.put(i3 + 2, readableColor6.getBlueByte());
                i3 += 3;
            }
        }
    }

    /* access modifiers changed from: private */
    public void createGradientTexture(ReadableColor readableColor, ReadableColor readableColor2) {
        ReadableColor readableColor3 = readableColor;
        ReadableColor readableColor4 = readableColor2;
        float f = 0.0f;
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            for (int i3 = 0; i3 < 32; i3++) {
                ByteBuffer put = this.texture.put(i + 0, lerp(readableColor3.getRed(), readableColor4.getRed(), f));
                ByteBuffer put2 = this.texture.put(i + 1, lerp(readableColor3.getGreen(), readableColor4.getGreen(), f));
                ByteBuffer put3 = this.texture.put(i + 2, lerp(readableColor3.getBlue(), readableColor4.getBlue(), f));
                i += 3;
            }
            f += 0.032258064f;
        }
    }

    private static byte lerp(int i, int i2, float f) {
        float f2 = f;
        return (byte) Math.round(((1.0f - f2) * ((float) i)) + (f2 * ((float) i2)));
    }

    /* access modifiers changed from: 0000 */
    public void cleanup() {
        this.running = false;
    }

    /* access modifiers changed from: 0000 */
    public abstract Drawable getDrawable() throws LWJGLException;

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public int getTexID() {
        this.lock.lock();
        try {
            if (this.fence != null) {
                GL32.glWaitSync(this.fence, 0, -1);
                this.fence = null;
            }
            int i = this.texID;
            this.lock.unlock();
            return i;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.lock.unlock();
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void start() throws LWJGLException {
        Thread thread;
        C08331 r6;
        this.drawable = getDrawable();
        Thread thread2 = thread;
        C08331 r3 = r6;
        C08331 r4 = new Runnable(this) {
            final /* synthetic */ BackgroundLoader this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                RuntimeException runtimeException;
                System.out.println("-- Background Thread started --");
                System.out.println("** Sleeping, no texture created yet **");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    this.this$0.drawable.makeCurrent();
                    System.out.println("** Drawable created **");
                    this.this$0.createCheckerTexture(Color.RED, Color.WHITE, 2);
                    this.this$0.lock.lock();
                    int access$302 = BackgroundLoader.access$302(this.this$0, GL11.glGenTextures());
                    GL11.glBindTexture(3553, this.this$0.texID);
                    GL11.glTexImage2D(3553, 0, (int) GL11.GL_RGB, 32, 32, 0, (int) GL11.GL_RGB, (int) GL11.GL_UNSIGNED_BYTE, this.this$0.texture);
                    GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
                    GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
                    GL11.glBindTexture(3553, 0);
                    boolean z = GLContext.getCapabilities().OpenGL32;
                    if (z) {
                        GLSync access$502 = BackgroundLoader.access$502(this.this$0, GL32.glFenceSync(37143, 0));
                    } else {
                        GL11.glFlush();
                    }
                    this.this$0.lock.unlock();
                    System.out.println("** Dummy texture created **");
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    while (this.this$0.running) {
                        if (System.currentTimeMillis() - currentTimeMillis < 5000) {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            if (i % 2 == 0) {
                                this.this$0.createGradientTexture(Color.RED, Color.BLUE);
                            } else {
                                this.this$0.createGradientTexture(Color.GREEN, Color.YELLOW);
                            }
                            this.this$0.lock.lock();
                            GL11.glBindTexture(3553, this.this$0.texID);
                            GL11.glTexImage2D(3553, 0, (int) GL11.GL_RGB, 32, 32, 0, (int) GL11.GL_RGB, (int) GL11.GL_UNSIGNED_BYTE, this.this$0.texture);
                            GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
                            GL11.glTexParameteri(3553, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
                            GL11.glBindTexture(3553, 0);
                            if (z) {
                                GLSync access$5022 = BackgroundLoader.access$502(this.this$0, GL32.glFenceSync(37143, 0));
                            } else {
                                GL11.glFlush();
                            }
                            this.this$0.lock.unlock();
                            System.out.println("** Created new gradient texture **");
                            currentTimeMillis = System.currentTimeMillis();
                            i++;
                        }
                    }
                    this.this$0.drawable.destroy();
                    System.out.println("-- Background Thread finished --");
                } catch (LWJGLException e3) {
                    LWJGLException lWJGLException = e3;
                    RuntimeException runtimeException2 = runtimeException;
                    RuntimeException runtimeException3 = new RuntimeException(lWJGLException);
                    throw runtimeException2;
                }
            }
        };
        Thread thread3 = new Thread(r3);
        thread2.start();
    }
}

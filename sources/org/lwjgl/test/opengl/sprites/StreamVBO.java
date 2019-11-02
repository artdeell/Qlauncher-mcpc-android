package org.lwjgl.test.opengl.sprites;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

public class StreamVBO {

    /* renamed from: ID */
    private int f233ID;
    private long cursor;
    private final int padding;
    private final long size;
    private final int target;

    public StreamVBO(int i, int i2) {
        this(i, i2, 64);
    }

    public StreamVBO(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.target = i4;
        this.padding = i6;
        this.size = (long) Math.max(pad(i5), i6);
        this.f233ID = GL15.glGenBuffers();
        GL15.glBindBuffer(i4, this.f233ID);
        GL15.glBufferData(i4, this.size, 35040);
    }

    private ByteBuffer doMap(int i, ByteBuffer byteBuffer) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!LWJGLUtil.CHECKS || this.size >= ((long) i2)) {
            if (this.size < this.cursor + ((long) i2)) {
                reset();
            }
            ByteBuffer glMapBufferRange = GL30.glMapBufferRange(this.target, this.cursor, (long) i2, 34, byteBuffer2);
            this.cursor += (long) i2;
            return glMapBufferRange;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(Integer.toString(i2));
        throw illegalArgumentException2;
    }

    private int pad(int i) {
        int i2 = i;
        int i3 = i2 % this.padding;
        return i3 == 0 ? i2 : (i2 + this.padding) - i3;
    }

    public void bind() {
        GL15.glBindBuffer(this.target, this.f233ID);
    }

    public void destroy() {
        GL15.glBindBuffer(this.target, 0);
        GL15.glDeleteBuffers(this.f233ID);
    }

    public int getID() {
        return this.f233ID;
    }

    public int getPadding() {
        return this.padding;
    }

    public long getSize() {
        return this.size;
    }

    public int getTarget() {
        return this.target;
    }

    public void init(int i, ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        GL15.glBufferSubData(this.target, (long) i, byteBuffer2);
    }

    public ByteBuffer map(int i) {
        return map(i, null);
    }

    public ByteBuffer map(int i, ByteBuffer byteBuffer) {
        return doMap(pad(i), byteBuffer);
    }

    public void reset() {
        GL15.glBufferData(this.target, this.size, 35040);
        this.cursor = 0;
    }

    public void unmap() {
        boolean glUnmapBuffer = GL15.glUnmapBuffer(this.target);
    }
}

package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;

class EventQueue {
    private static final int QUEUE_SIZE = 200;
    private final int event_size;
    private final ByteBuffer queue;

    protected EventQueue(int i) {
        int i2 = i;
        this.event_size = i2;
        this.queue = ByteBuffer.allocate(i2 * 200);
    }

    /* access modifiers changed from: protected */
    public void clearEvents() {
        synchronized (this) {
            try {
                Buffer clear = this.queue.clear();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void copyEvents(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = byteBuffer;
        synchronized (this) {
            try {
                Buffer flip = this.queue.flip();
                int limit = this.queue.limit();
                if (byteBuffer2.remaining() < this.queue.remaining()) {
                    Buffer limit2 = this.queue.limit(byteBuffer2.remaining() + this.queue.position());
                }
                ByteBuffer put = byteBuffer2.put(this.queue);
                Buffer limit3 = this.queue.limit(limit);
                ByteBuffer compact = this.queue.compact();
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public boolean putEvent(ByteBuffer byteBuffer) {
        boolean z;
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        ByteBuffer byteBuffer2 = byteBuffer;
        synchronized (this) {
            try {
                if (byteBuffer2.remaining() != this.event_size) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Internal error: event size ").append(this.event_size).append(" does not equal the given event size ").append(byteBuffer2.remaining()).toString());
                    throw illegalArgumentException2;
                } else if (this.queue.remaining() >= byteBuffer2.remaining()) {
                    ByteBuffer put = this.queue.put(byteBuffer2);
                    z = true;
                } else {
                    z = false;
                }
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }
}

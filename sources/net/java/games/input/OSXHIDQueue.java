package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class OSXHIDQueue {
    private final Map map;
    private final long queue_address;
    private boolean released;

    public OSXHIDQueue(long j, int i) throws IOException {
        HashMap hashMap;
        long j2 = j;
        int i2 = i;
        HashMap hashMap2 = hashMap;
        HashMap hashMap3 = new HashMap();
        this.map = hashMap2;
        this.queue_address = j2;
        try {
            createQueue(i2);
        } catch (IOException e) {
            IOException iOException = e;
            release();
            throw iOException;
        }
    }

    private final void checkReleased() throws IOException {
        IOException iOException;
        if (this.released) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException("Queue is released");
            throw iOException2;
        }
    }

    private final void close() throws IOException {
        nClose(this.queue_address);
    }

    private final void createQueue(int i) throws IOException {
        open(i);
        try {
            start();
        } catch (IOException e) {
            IOException iOException = e;
            close();
            throw iOException;
        }
    }

    private static final native void nAddElement(long j, long j2) throws IOException;

    private static final native void nClose(long j) throws IOException;

    private static final native boolean nGetNextEvent(long j, OSXEvent oSXEvent) throws IOException;

    private static final native void nOpen(long j, int i) throws IOException;

    private static final native void nReleaseQueue(long j) throws IOException;

    private static final native void nRemoveElement(long j, long j2) throws IOException;

    private static final native void nStart(long j) throws IOException;

    private static final native void nStop(long j) throws IOException;

    private final void open(int i) throws IOException {
        int i2 = i;
        nOpen(this.queue_address, i2);
    }

    private final void start() throws IOException {
        nStart(this.queue_address);
    }

    private final void stop() throws IOException {
        nStop(this.queue_address);
    }

    public final void addElement(OSXHIDElement oSXHIDElement, OSXComponent oSXComponent) throws IOException {
        Long l;
        OSXHIDElement oSXHIDElement2 = oSXHIDElement;
        OSXComponent oSXComponent2 = oSXComponent;
        nAddElement(this.queue_address, oSXHIDElement2.getCookie());
        Map map2 = this.map;
        Long l2 = l;
        Long l3 = new Long(oSXHIDElement2.getCookie());
        Object put = map2.put(l2, oSXComponent2);
    }

    public final boolean getNextEvent(OSXEvent oSXEvent) throws IOException {
        boolean z;
        OSXEvent oSXEvent2 = oSXEvent;
        synchronized (this) {
            try {
                checkReleased();
                th = nGetNextEvent(this.queue_address, oSXEvent2);
            } finally {
                z = th;
                Throwable th = z;
            }
        }
        return z;
    }

    public final OSXComponent mapEvent(OSXEvent oSXEvent) {
        Long l;
        OSXEvent oSXEvent2 = oSXEvent;
        Map map2 = this.map;
        Long l2 = l;
        Long l3 = new Long(oSXEvent2.getCookie());
        return (OSXComponent) map2.get(l2);
    }

    public final void release() throws IOException {
        synchronized (this) {
            try {
                if (!this.released) {
                    this.released = true;
                    stop();
                    close();
                    nReleaseQueue(this.queue_address);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final void removeElement(OSXHIDElement oSXHIDElement) throws IOException {
        Long l;
        OSXHIDElement oSXHIDElement2 = oSXHIDElement;
        nRemoveElement(this.queue_address, oSXHIDElement2.getCookie());
        Map map2 = this.map;
        Long l2 = l;
        Long l3 = new Long(oSXHIDElement2.getCookie());
        Object remove = map2.remove(l2);
    }

    public final void setQueueDepth(int i) throws IOException {
        int i2 = i;
        synchronized (this) {
            try {
                checkReleased();
                stop();
                close();
                createQueue(i2);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}

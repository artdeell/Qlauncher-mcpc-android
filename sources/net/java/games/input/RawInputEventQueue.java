package net.java.games.input;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

final class RawInputEventQueue {
    private List devices;
    private final Object monitor;

    private final class QueueThread extends Thread {
        private IOException exception;
        private boolean initialized;
        private final RawInputEventQueue this$0;
        private DummyWindow window;

        public QueueThread(RawInputEventQueue rawInputEventQueue) {
            this.this$0 = rawInputEventQueue;
            setDaemon(true);
        }

        public final IOException getException() {
            return this.exception;
        }

        public final boolean isInitialized() {
            return this.initialized;
        }

        public final void run() {
            HashSet hashSet;
            DummyWindow dummyWindow;
            try {
                DummyWindow dummyWindow2 = dummyWindow;
                DummyWindow dummyWindow3 = new DummyWindow();
                this.window = dummyWindow2;
            } catch (IOException e) {
                this.exception = e;
            }
            this.initialized = true;
            r2 = RawInputEventQueue.access$000(this.this$0);
            synchronized (r2) {
                try {
                    RawInputEventQueue.access$000(this.this$0).notify();
                } finally {
                    while (true) {
                        int i = th;
                        Object obj = r2;
                        Throwable th = i;
                    }
                }
            }
            if (this.exception == null) {
                HashSet hashSet2 = hashSet;
                HashSet hashSet3 = new HashSet();
                HashSet hashSet4 = hashSet2;
                int i2 = 0;
                while (th < RawInputEventQueue.access$100(this.this$0).size()) {
                    try {
                        boolean add = hashSet4.add(((RawDevice) RawInputEventQueue.access$100(this.this$0).get(th)).getInfo());
                        i2 = th + 1;
                    } catch (IOException e2) {
                        this.exception = e2;
                        return;
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        this.window.destroy();
                        throw th3;
                    }
                }
                RawDeviceInfo[] rawDeviceInfoArr = new RawDeviceInfo[hashSet4.size()];
                Object[] array = hashSet4.toArray(rawDeviceInfoArr);
                RawInputEventQueue.access$200(this.window, rawDeviceInfoArr);
                while (!isInterrupted()) {
                    RawInputEventQueue.access$300(this.this$0, this.window);
                }
                this.window.destroy();
            }
        }
    }

    RawInputEventQueue() {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        this.monitor = obj2;
    }

    static Object access$000(RawInputEventQueue rawInputEventQueue) {
        return rawInputEventQueue.monitor;
    }

    static List access$100(RawInputEventQueue rawInputEventQueue) {
        return rawInputEventQueue.devices;
    }

    static void access$200(DummyWindow dummyWindow, RawDeviceInfo[] rawDeviceInfoArr) throws IOException {
        registerDevices(dummyWindow, rawDeviceInfoArr);
    }

    static void access$300(RawInputEventQueue rawInputEventQueue, DummyWindow dummyWindow) throws IOException {
        rawInputEventQueue.poll(dummyWindow);
    }

    private final void addKeyboardEvent(long j, long j2, int i, int i2, int i3, int i4, long j3) {
        long j4 = j2;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        long j5 = j3;
        RawDevice lookupDevice = lookupDevice(j);
        if (lookupDevice != null) {
            lookupDevice.addKeyboardEvent(j4, i5, i6, i7, i8, j5);
        }
    }

    private final void addMouseEvent(long j, long j2, int i, int i2, int i3, long j3, long j4, long j5, long j6) {
        long j7 = j2;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        long j8 = j3;
        long j9 = j4;
        long j10 = j5;
        long j11 = j6;
        RawDevice lookupDevice = lookupDevice(j);
        if (lookupDevice != null) {
            lookupDevice.addMouseEvent(j7, i4, i5, i6, j8, j9, j10, j11);
        }
    }

    private final RawDevice lookupDevice(long j) {
        long j2 = j;
        for (int i = 0; i < this.devices.size(); i++) {
            RawDevice rawDevice = (RawDevice) this.devices.get(i);
            if (rawDevice.getHandle() == j2) {
                return rawDevice;
            }
        }
        return null;
    }

    private final native void nPoll(long j) throws IOException;

    private static final native void nRegisterDevices(int i, long j, RawDeviceInfo[] rawDeviceInfoArr) throws IOException;

    private final void poll(DummyWindow dummyWindow) throws IOException {
        nPoll(dummyWindow.getHwnd());
    }

    private static final void registerDevices(DummyWindow dummyWindow, RawDeviceInfo[] rawDeviceInfoArr) throws IOException {
        nRegisterDevices(0, dummyWindow.getHwnd(), rawDeviceInfoArr);
    }

    public final void start(List list) throws IOException {
        QueueThread queueThread;
        this.devices = list;
        QueueThread queueThread2 = queueThread;
        QueueThread queueThread3 = new QueueThread(this);
        QueueThread queueThread4 = queueThread2;
        boolean z = this.monitor;
        synchronized (z) {
            try {
                queueThread4.start();
                while (true) {
                    th = queueThread4.isInitialized();
                    if (th) {
                        break;
                    }
                    try {
                        this.monitor.wait();
                    } catch (InterruptedException e) {
                        InterruptedException interruptedException = e;
                    }
                }
            } finally {
                while (true) {
                    Throwable th = th;
                    boolean z2 = z;
                    Throwable th2 = th;
                }
            }
        }
        if (queueThread4.getException() != null) {
            throw queueThread4.getException();
        }
    }
}

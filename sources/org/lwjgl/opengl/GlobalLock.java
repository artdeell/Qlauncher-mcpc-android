package org.lwjgl.opengl;

final class GlobalLock {
    static final Object lock;

    static {
        Object obj;
        Object obj2 = obj;
        Object obj3 = new Object();
        lock = obj2;
    }

    GlobalLock() {
    }
}

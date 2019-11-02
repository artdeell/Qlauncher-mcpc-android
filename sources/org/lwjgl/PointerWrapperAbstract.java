package org.lwjgl;

public abstract class PointerWrapperAbstract implements PointerWrapper {
    protected final long pointer;

    protected PointerWrapperAbstract(long j) {
        this.pointer = j;
    }

    public final void checkValid() {
        IllegalStateException illegalStateException;
        StringBuilder sb;
        if (LWJGLUtil.DEBUG && !isValid()) {
            IllegalStateException illegalStateException2 = illegalStateException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("This ").append(getClass().getSimpleName()).append(" pointer is not valid.").toString());
            throw illegalStateException2;
        }
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (this != obj2) {
            if (!(obj2 instanceof PointerWrapperAbstract)) {
                return false;
            }
            if (this.pointer != ((PointerWrapperAbstract) obj2).pointer) {
                return false;
            }
        }
        return true;
    }

    public final long getPointer() {
        checkValid();
        return this.pointer;
    }

    public int hashCode() {
        return (int) (this.pointer ^ (this.pointer >>> 32));
    }

    public boolean isValid() {
        return this.pointer != 0;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getClass().getSimpleName()).append(" pointer (0x").append(Long.toHexString(this.pointer).toUpperCase()).append(")").toString();
    }
}

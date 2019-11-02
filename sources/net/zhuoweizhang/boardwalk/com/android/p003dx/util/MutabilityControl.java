package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.MutabilityControl */
public class MutabilityControl {
    private boolean mutable;

    public MutabilityControl() {
        this.mutable = true;
    }

    public MutabilityControl(boolean z) {
        this.mutable = z;
    }

    public final boolean isImmutable() {
        return !this.mutable;
    }

    public final boolean isMutable() {
        return this.mutable;
    }

    public void setImmutable() {
        this.mutable = false;
    }

    public final void throwIfImmutable() {
        MutabilityException mutabilityException;
        if (!this.mutable) {
            MutabilityException mutabilityException2 = mutabilityException;
            MutabilityException mutabilityException3 = new MutabilityException("immutable instance");
            throw mutabilityException2;
        }
    }

    public final void throwIfMutable() {
        MutabilityException mutabilityException;
        if (this.mutable) {
            MutabilityException mutabilityException2 = mutabilityException;
            MutabilityException mutabilityException3 = new MutabilityException("mutable instance");
            throw mutabilityException2;
        }
    }
}

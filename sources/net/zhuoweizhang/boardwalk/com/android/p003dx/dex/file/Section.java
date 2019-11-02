package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.Collection;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.Section */
public abstract class Section {
    private final int alignment;
    private final DexFile file;
    private int fileOffset;
    private final String name;
    private boolean prepared;

    public Section(String str, DexFile dexFile, int i) {
        NullPointerException nullPointerException;
        String str2 = str;
        DexFile dexFile2 = dexFile;
        int i2 = i;
        if (dexFile2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("file == null");
            throw nullPointerException2;
        }
        validateAlignment(i2);
        this.name = str2;
        this.file = dexFile2;
        this.alignment = i2;
        this.fileOffset = -1;
        this.prepared = false;
    }

    public static void validateAlignment(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 <= 0 || (i2 & (i2 - 1)) != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("invalid alignment");
            throw illegalArgumentException2;
        }
    }

    /* access modifiers changed from: protected */
    public final void align(AnnotatedOutput annotatedOutput) {
        annotatedOutput.alignTo(this.alignment);
    }

    public abstract int getAbsoluteItemOffset(Item item);

    public final int getAbsoluteOffset(int i) {
        RuntimeException runtimeException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("relative < 0");
            throw illegalArgumentException2;
        } else if (this.fileOffset >= 0) {
            return i2 + this.fileOffset;
        } else {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("fileOffset not yet set");
            throw runtimeException2;
        }
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final DexFile getFile() {
        return this.file;
    }

    public final int getFileOffset() {
        RuntimeException runtimeException;
        if (this.fileOffset >= 0) {
            return this.fileOffset;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("fileOffset not set");
        throw runtimeException2;
    }

    /* access modifiers changed from: protected */
    public final String getName() {
        return this.name;
    }

    public abstract Collection<? extends Item> items();

    public final void prepare() {
        throwIfPrepared();
        prepare0();
        this.prepared = true;
    }

    /* access modifiers changed from: protected */
    public abstract void prepare0();

    public final int setFileOffset(int i) {
        RuntimeException runtimeException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("fileOffset < 0");
            throw illegalArgumentException2;
        } else if (this.fileOffset >= 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("fileOffset already set");
            throw runtimeException2;
        } else {
            int i3 = -1 + this.alignment;
            int i4 = (i2 + i3) & (i3 ^ -1);
            this.fileOffset = i4;
            return i4;
        }
    }

    /* access modifiers changed from: protected */
    public final void throwIfNotPrepared() {
        RuntimeException runtimeException;
        if (!this.prepared) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("not prepared");
            throw runtimeException2;
        }
    }

    /* access modifiers changed from: protected */
    public final void throwIfPrepared() {
        RuntimeException runtimeException;
        if (this.prepared) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("already prepared");
            throw runtimeException2;
        }
    }

    public abstract int writeSize();

    public final void writeTo(AnnotatedOutput annotatedOutput) {
        RuntimeException runtimeException;
        StringBuilder sb;
        StringBuilder sb2;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        align(annotatedOutput2);
        int cursor = annotatedOutput2.getCursor();
        if (this.fileOffset < 0) {
            this.fileOffset = cursor;
        } else if (this.fileOffset != cursor) {
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb3.append("alignment mismatch: for ").append(this).append(", at ").append(cursor).append(", but expected ").append(this.fileOffset).toString());
            throw runtimeException2;
        }
        if (annotatedOutput2.annotates()) {
            if (this.name != null) {
                AnnotatedOutput annotatedOutput3 = annotatedOutput2;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                annotatedOutput3.annotate(0, sb5.append("\n").append(this.name).append(":").toString());
            } else if (cursor != 0) {
                annotatedOutput2.annotate(0, "\n");
            }
        }
        writeTo0(annotatedOutput2);
    }

    /* access modifiers changed from: protected */
    public abstract void writeTo0(AnnotatedOutput annotatedOutput);
}

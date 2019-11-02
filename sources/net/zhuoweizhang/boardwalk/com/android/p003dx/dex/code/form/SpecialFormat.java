package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.SpecialFormat */
public final class SpecialFormat extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        SpecialFormat specialFormat;
        SpecialFormat specialFormat2 = specialFormat;
        SpecialFormat specialFormat3 = new SpecialFormat();
        THE_ONE = specialFormat2;
    }

    private SpecialFormat() {
    }

    public int codeSize() {
        RuntimeException runtimeException;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        RuntimeException runtimeException;
        DalvInsn dalvInsn2 = dalvInsn;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        RuntimeException runtimeException;
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        return true;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        RuntimeException runtimeException;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("unsupported");
        throw runtimeException2;
    }
}

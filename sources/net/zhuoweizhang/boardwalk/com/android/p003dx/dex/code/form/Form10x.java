package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.SimpleInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form10x */
public final class Form10x extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form10x form10x;
        Form10x form10x2 = form10x;
        Form10x form10x3 = new Form10x();
        THE_ONE = form10x2;
    }

    private Form10x() {
    }

    public int codeSize() {
        return 1;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        DalvInsn dalvInsn2 = dalvInsn;
        boolean z2 = z;
        return LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        return (dalvInsn2 instanceof SimpleInsn) && dalvInsn2.getRegisters().size() == 0;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        write(annotatedOutput, opcodeUnit(dalvInsn, 0));
    }
}

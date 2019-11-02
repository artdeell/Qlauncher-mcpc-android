package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.TargetInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form30t */
public final class Form30t extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form30t form30t;
        Form30t form30t2 = form30t;
        Form30t form30t3 = new Form30t();
        THE_ONE = form30t2;
    }

    private Form30t() {
    }

    public boolean branchFits(TargetInsn targetInsn) {
        TargetInsn targetInsn2 = targetInsn;
        return true;
    }

    public int codeSize() {
        return 3;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        return branchString(dalvInsn);
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        boolean z2 = z;
        return branchComment(dalvInsn);
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        return (dalvInsn2 instanceof TargetInsn) && dalvInsn2.getRegisters().size() == 0;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        write(annotatedOutput, opcodeUnit(dalvInsn2, 0), ((TargetInsn) dalvInsn2).getTargetOffset());
    }
}

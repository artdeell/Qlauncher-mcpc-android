package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.TargetInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form20t */
public final class Form20t extends InsnFormat {
    public static final InsnFormat THE_ONE;

    static {
        Form20t form20t;
        Form20t form20t2 = form20t;
        Form20t form20t3 = new Form20t();
        THE_ONE = form20t2;
    }

    private Form20t() {
    }

    public boolean branchFits(TargetInsn targetInsn) {
        int targetOffset = targetInsn.getTargetOffset();
        return targetOffset != 0 && signedFitsInShort(targetOffset);
    }

    public int codeSize() {
        return 2;
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
        if (!(dalvInsn2 instanceof TargetInsn) || dalvInsn2.getRegisters().size() != 0) {
            return false;
        }
        TargetInsn targetInsn = (TargetInsn) dalvInsn2;
        if (targetInsn.hasTargetOffset()) {
            return branchFits(targetInsn);
        }
        return true;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        write(annotatedOutput, opcodeUnit(dalvInsn2, 0), (short) ((TargetInsn) dalvInsn2).getTargetOffset());
    }
}

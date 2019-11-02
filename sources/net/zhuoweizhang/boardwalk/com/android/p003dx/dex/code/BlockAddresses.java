package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.SourcePosition;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.BlockAddresses */
public final class BlockAddresses {
    private final CodeAddress[] ends;
    private final CodeAddress[] lasts;
    private final CodeAddress[] starts;

    public BlockAddresses(RopMethod ropMethod) {
        RopMethod ropMethod2 = ropMethod;
        int maxLabel = ropMethod2.getBlocks().getMaxLabel();
        this.starts = new CodeAddress[maxLabel];
        this.lasts = new CodeAddress[maxLabel];
        this.ends = new CodeAddress[maxLabel];
        setupArrays(ropMethod2);
    }

    private void setupArrays(RopMethod ropMethod) {
        CodeAddress codeAddress;
        CodeAddress codeAddress2;
        CodeAddress codeAddress3;
        BasicBlockList blocks = ropMethod.getBlocks();
        int size = blocks.size();
        for (int i = 0; i < size; i++) {
            BasicBlock basicBlock = blocks.get(i);
            int label = basicBlock.getLabel();
            Insn insn = basicBlock.getInsns().get(0);
            CodeAddress[] codeAddressArr = this.starts;
            int i2 = label;
            CodeAddress codeAddress4 = codeAddress;
            CodeAddress codeAddress5 = new CodeAddress(insn.getPosition());
            codeAddressArr[i2] = codeAddress4;
            SourcePosition position = basicBlock.getLastInsn().getPosition();
            CodeAddress[] codeAddressArr2 = this.lasts;
            int i3 = label;
            CodeAddress codeAddress6 = codeAddress2;
            CodeAddress codeAddress7 = new CodeAddress(position);
            codeAddressArr2[i3] = codeAddress6;
            CodeAddress[] codeAddressArr3 = this.ends;
            int i4 = label;
            CodeAddress codeAddress8 = codeAddress3;
            CodeAddress codeAddress9 = new CodeAddress(position);
            codeAddressArr3[i4] = codeAddress8;
        }
    }

    public CodeAddress getEnd(int i) {
        return this.ends[i];
    }

    public CodeAddress getEnd(BasicBlock basicBlock) {
        return this.ends[basicBlock.getLabel()];
    }

    public CodeAddress getLast(int i) {
        return this.lasts[i];
    }

    public CodeAddress getLast(BasicBlock basicBlock) {
        return this.lasts[basicBlock.getLabel()];
    }

    public CodeAddress getStart(int i) {
        return this.starts[i];
    }

    public CodeAddress getStart(BasicBlock basicBlock) {
        return this.starts[basicBlock.getLabel()];
    }
}

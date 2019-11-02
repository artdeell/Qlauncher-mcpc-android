package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.InsnList */
public final class InsnList extends FixedSizeList {
    public InsnList(int i) {
        super(i);
    }

    public boolean contentEquals(InsnList insnList) {
        InsnList insnList2 = insnList;
        if (insnList2 != null) {
            int size = size();
            if (size == insnList2.size()) {
                int i = 0;
                while (i < size) {
                    if (get(i).contentEquals(insnList2.get(i))) {
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void forEach(Visitor visitor) {
        Visitor visitor2 = visitor;
        int size = size();
        for (int i = 0; i < size; i++) {
            get(i).accept(visitor2);
        }
    }

    public Insn get(int i) {
        return (Insn) get0(i);
    }

    public Insn getLast() {
        return get(-1 + size());
    }

    public void set(int i, Insn insn) {
        set0(i, insn);
    }

    public InsnList withRegisterOffset(int i) {
        InsnList insnList;
        int i2 = i;
        int size = size();
        InsnList insnList2 = insnList;
        InsnList insnList3 = new InsnList(size);
        InsnList insnList4 = insnList2;
        for (int i3 = 0; i3 < size; i3++) {
            Insn insn = (Insn) get0(i3);
            if (insn != null) {
                insnList4.set0(i3, insn.withRegisterOffset(i2));
            }
        }
        if (isImmutable()) {
            insnList4.setImmutable();
        }
        return insnList4;
    }
}

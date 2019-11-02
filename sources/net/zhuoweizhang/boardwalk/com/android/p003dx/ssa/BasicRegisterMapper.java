package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.BasicRegisterMapper */
public class BasicRegisterMapper extends RegisterMapper {
    private IntList oldToNew;
    private int runningCountNewRegisters;

    public BasicRegisterMapper(int i) {
        IntList intList;
        IntList intList2 = intList;
        IntList intList3 = new IntList(i);
        this.oldToNew = intList2;
    }

    public void addMapping(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (i4 >= this.oldToNew.size()) {
            for (int size = i4 - this.oldToNew.size(); size >= 0; size--) {
                this.oldToNew.add(-1);
            }
        }
        this.oldToNew.set(i4, i5);
        if (this.runningCountNewRegisters < i5 + i6) {
            this.runningCountNewRegisters = i5 + i6;
        }
    }

    public int getNewRegisterCount() {
        return this.runningCountNewRegisters;
    }

    public RegisterSpec map(RegisterSpec registerSpec) {
        int i;
        RuntimeException runtimeException;
        RegisterSpec registerSpec2 = registerSpec;
        if (registerSpec2 == null) {
            return null;
        }
        try {
            i = this.oldToNew.get(registerSpec2.getReg());
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            i = -1;
        }
        if (i >= 0) {
            return registerSpec2.withReg(i);
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("no mapping specified for register");
        throw runtimeException2;
    }

    public int oldToNew(int i) {
        int i2 = i;
        if (i2 >= this.oldToNew.size()) {
            return -1;
        }
        return this.oldToNew.get(i2);
    }

    public String toHuman() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("Old\tNew\n");
        int size = this.oldToNew.size();
        for (int i = 0; i < size; i++) {
            StringBuilder append2 = sb4.append(i);
            StringBuilder append3 = sb4.append(9);
            StringBuilder append4 = sb4.append(this.oldToNew.get(i));
            StringBuilder append5 = sb4.append(10);
        }
        StringBuilder append6 = sb4.append("new reg count:");
        StringBuilder append7 = sb4.append(this.runningCountNewRegisters);
        StringBuilder append8 = sb4.append(10);
        return sb4.toString();
    }
}

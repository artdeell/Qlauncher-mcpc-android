package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back.InterferenceGraph;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.BitIntSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntSet;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.InterferenceRegisterMapper */
public class InterferenceRegisterMapper extends BasicRegisterMapper {
    private final ArrayList<BitIntSet> newRegInterference;
    private final InterferenceGraph oldRegInterference;

    public InterferenceRegisterMapper(InterferenceGraph interferenceGraph, int i) {
        ArrayList<BitIntSet> arrayList;
        InterferenceGraph interferenceGraph2 = interferenceGraph;
        super(i);
        ArrayList<BitIntSet> arrayList2 = arrayList;
        ArrayList<BitIntSet> arrayList3 = new ArrayList<>();
        this.newRegInterference = arrayList2;
        this.oldRegInterference = interferenceGraph2;
    }

    private void addInterfence(int i, int i2) {
        BitIntSet bitIntSet;
        int i3 = i;
        int i4 = i2;
        this.newRegInterference.ensureCapacity(i3 + 1);
        while (i3 >= this.newRegInterference.size()) {
            ArrayList<BitIntSet> arrayList = this.newRegInterference;
            BitIntSet bitIntSet2 = bitIntSet;
            BitIntSet bitIntSet3 = new BitIntSet(i3 + 1);
            boolean add = arrayList.add(bitIntSet2);
        }
        this.oldRegInterference.mergeInterferenceSet(i4, (IntSet) this.newRegInterference.get(i3));
    }

    public void addMapping(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        super.addMapping(i4, i5, i6);
        addInterfence(i5, i4);
        if (i6 == 2) {
            addInterfence(i5 + 1, i4);
        }
    }

    public boolean areAnyPinned(RegisterSpecList registerSpecList, int i, int i2) {
        boolean z;
        RegisterSpecList registerSpecList2 = registerSpecList;
        int i3 = i;
        int i4 = i2;
        int size = registerSpecList2.size();
        int i5 = 0;
        while (true) {
            z = false;
            if (i5 >= size) {
                break;
            }
            RegisterSpec registerSpec = registerSpecList2.get(i5);
            int oldToNew = oldToNew(registerSpec.getReg());
            if (oldToNew == i3 || ((registerSpec.getCategory() == 2 && oldToNew + 1 == i3) || (i4 == 2 && oldToNew == i3 + 1))) {
                z = true;
            } else {
                i5++;
            }
        }
        z = true;
        return z;
    }

    public boolean interferes(int i, int i2, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (i5 < this.newRegInterference.size()) {
            IntSet intSet = (IntSet) this.newRegInterference.get(i5);
            if (intSet != null) {
                if (i6 == 1) {
                    return intSet.has(i4);
                }
                return intSet.has(i4) || interferes(i4, i5 + 1, i6 + -1);
            }
        }
        return false;
    }

    public boolean interferes(RegisterSpec registerSpec, int i) {
        RegisterSpec registerSpec2 = registerSpec;
        return interferes(registerSpec2.getReg(), i, registerSpec2.getCategory());
    }
}

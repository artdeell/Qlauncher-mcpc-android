package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SetFactory;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntSet;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.back.InterferenceGraph */
public class InterferenceGraph {
    private final ArrayList<IntSet> interference;

    public InterferenceGraph(int i) {
        ArrayList<IntSet> arrayList;
        int i2 = i;
        ArrayList<IntSet> arrayList2 = arrayList;
        ArrayList<IntSet> arrayList3 = new ArrayList<>(i2);
        this.interference = arrayList2;
        for (int i3 = 0; i3 < i2; i3++) {
            boolean add = this.interference.add(SetFactory.makeInterferenceSet(i2));
        }
    }

    private void ensureCapacity(int i) {
        int i2 = i;
        this.interference.ensureCapacity(i2);
        for (int size = this.interference.size(); size < i2; size++) {
            boolean add = this.interference.add(SetFactory.makeInterferenceSet(i2));
        }
    }

    public void add(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        ensureCapacity(1 + Math.max(i3, i4));
        ((IntSet) this.interference.get(i3)).add(i4);
        ((IntSet) this.interference.get(i4)).add(i3);
    }

    public void dumpToStdout() {
        StringBuilder sb;
        StringBuilder sb2;
        int size = this.interference.size();
        for (int i = 0; i < size; i++) {
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = sb3;
            StringBuilder sb6 = sb5;
            StringBuilder sb7 = sb2;
            StringBuilder sb8 = new StringBuilder();
            StringBuilder append = sb6.append(sb7.append("Reg ").append(i).append(":").append(((IntSet) this.interference.get(i)).toString()).toString());
            System.out.println(sb5.toString());
        }
    }

    public void mergeInterferenceSet(int i, IntSet intSet) {
        int i2 = i;
        IntSet intSet2 = intSet;
        if (i2 < this.interference.size()) {
            intSet2.merge((IntSet) this.interference.get(i2));
        }
    }
}

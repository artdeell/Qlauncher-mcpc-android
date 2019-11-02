package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

import java.util.Arrays;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.LabeledList */
public class LabeledList extends FixedSizeList {
    private final IntList labelToIndex;

    public LabeledList(int i) {
        IntList intList;
        int i2 = i;
        super(i2);
        IntList intList2 = intList;
        IntList intList3 = new IntList(i2);
        this.labelToIndex = intList2;
    }

    public LabeledList(LabeledList labeledList) {
        LabeledList labeledList2 = labeledList;
        super(labeledList2.size());
        this.labelToIndex = labeledList2.labelToIndex.mutableCopy();
        int size = labeledList2.size();
        for (int i = 0; i < size; i++) {
            Object r4 = labeledList2.get0(i);
            if (r4 != null) {
                set0(i, r4);
            }
        }
    }

    private void addLabelIndex(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int size = this.labelToIndex.size();
        for (int i5 = 0; i5 <= i3 - size; i5++) {
            this.labelToIndex.add(-1);
        }
        this.labelToIndex.set(i3, i4);
    }

    private void rebuildLabelToIndex() {
        int size = size();
        for (int i = 0; i < size; i++) {
            LabeledItem labeledItem = (LabeledItem) get0(i);
            if (labeledItem != null) {
                this.labelToIndex.set(labeledItem.getLabel(), i);
            }
        }
    }

    private void removeLabel(int i) {
        int i2 = i;
        this.labelToIndex.set(i2, -1);
    }

    public final int[] getLabelsInOrder() {
        NullPointerException nullPointerException;
        StringBuilder sb;
        int size = size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            LabeledItem labeledItem = (LabeledItem) get0(i);
            if (labeledItem == null) {
                NullPointerException nullPointerException2 = nullPointerException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                NullPointerException nullPointerException3 = new NullPointerException(sb2.append("null at index ").append(i).toString());
                throw nullPointerException2;
            }
            iArr[i] = labeledItem.getLabel();
        }
        Arrays.sort(iArr);
        return iArr;
    }

    public final int getMaxLabel() {
        int size = -1 + this.labelToIndex.size();
        while (size >= 0 && this.labelToIndex.get(size) < 0) {
            size--;
        }
        int i = size + 1;
        this.labelToIndex.shrink(i);
        return i;
    }

    public final int indexOfLabel(int i) {
        int i2 = i;
        if (i2 >= this.labelToIndex.size()) {
            return -1;
        }
        return this.labelToIndex.get(i2);
    }

    /* access modifiers changed from: protected */
    public void set(int i, LabeledItem labeledItem) {
        int i2 = i;
        LabeledItem labeledItem2 = labeledItem;
        LabeledItem labeledItem3 = (LabeledItem) getOrNull0(i2);
        set0(i2, labeledItem2);
        if (labeledItem3 != null) {
            removeLabel(labeledItem3.getLabel());
        }
        if (labeledItem2 != null) {
            addLabelIndex(labeledItem2.getLabel(), i2);
        }
    }

    public void shrinkToFit() {
        super.shrinkToFit();
        rebuildLabelToIndex();
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityControl;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.SwitchList */
public final class SwitchList extends MutabilityControl {
    private int size;
    private final IntList targets;
    private final IntList values;

    public SwitchList(int i) {
        IntList intList;
        IntList intList2;
        int i2 = i;
        super(true);
        IntList intList3 = intList;
        IntList intList4 = new IntList(i2);
        this.values = intList3;
        IntList intList5 = intList2;
        IntList intList6 = new IntList(i2 + 1);
        this.targets = intList5;
        this.size = i2;
    }

    public void add(int i, int i2) {
        IllegalArgumentException illegalArgumentException;
        int i3 = i;
        int i4 = i2;
        throwIfImmutable();
        if (i4 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("target < 0");
            throw illegalArgumentException2;
        }
        this.values.add(i3);
        this.targets.add(i4);
    }

    public int getDefaultTarget() {
        return this.targets.get(this.size);
    }

    public int getTarget(int i) {
        return this.targets.get(i);
    }

    public IntList getTargets() {
        return this.targets;
    }

    public int getValue(int i) {
        return this.values.get(i);
    }

    public IntList getValues() {
        return this.values;
    }

    public void removeSuperfluousDefaults() {
        IllegalArgumentException illegalArgumentException;
        int i = 0;
        throwIfImmutable();
        int i2 = this.size;
        if (i2 != -1 + this.targets.size()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("incomplete instance");
            throw illegalArgumentException2;
        }
        int i3 = this.targets.get(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.targets.get(i4);
            if (i5 != i3) {
                if (i4 != i) {
                    this.targets.set(i, i5);
                    this.values.set(i, this.values.get(i4));
                }
                i++;
            }
        }
        if (i != i2) {
            this.values.shrink(i);
            this.targets.set(i, i3);
            this.targets.shrink(i + 1);
            this.size = i;
        }
    }

    public void setDefaultTarget(int i) {
        RuntimeException runtimeException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        throwIfImmutable();
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("target < 0");
            throw illegalArgumentException2;
        } else if (this.targets.size() != this.size) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("non-default elements not all set");
            throw runtimeException2;
        } else {
            this.targets.add(i2);
        }
    }

    public void setImmutable() {
        this.values.setImmutable();
        this.targets.setImmutable();
        super.setImmutable();
    }

    public int size() {
        return this.size;
    }
}

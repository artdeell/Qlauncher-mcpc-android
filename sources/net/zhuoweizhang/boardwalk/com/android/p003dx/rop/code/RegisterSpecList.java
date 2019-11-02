package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList */
public final class RegisterSpecList extends FixedSizeList implements TypeList {
    public static final RegisterSpecList EMPTY;

    static {
        RegisterSpecList registerSpecList;
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(0);
        EMPTY = registerSpecList2;
    }

    public RegisterSpecList(int i) {
        super(i);
    }

    public static RegisterSpecList make(RegisterSpec registerSpec) {
        RegisterSpecList registerSpecList;
        RegisterSpec registerSpec2 = registerSpec;
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(1);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        registerSpecList4.set(0, registerSpec2);
        return registerSpecList4;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        RegisterSpecList registerSpecList;
        RegisterSpec registerSpec3 = registerSpec;
        RegisterSpec registerSpec4 = registerSpec2;
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(2);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        registerSpecList4.set(0, registerSpec3);
        registerSpecList4.set(1, registerSpec4);
        return registerSpecList4;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2, RegisterSpec registerSpec3) {
        RegisterSpecList registerSpecList;
        RegisterSpec registerSpec4 = registerSpec;
        RegisterSpec registerSpec5 = registerSpec2;
        RegisterSpec registerSpec6 = registerSpec3;
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(3);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        registerSpecList4.set(0, registerSpec4);
        registerSpecList4.set(1, registerSpec5);
        registerSpecList4.set(2, registerSpec6);
        return registerSpecList4;
    }

    public static RegisterSpecList make(RegisterSpec registerSpec, RegisterSpec registerSpec2, RegisterSpec registerSpec3, RegisterSpec registerSpec4) {
        RegisterSpecList registerSpecList;
        RegisterSpec registerSpec5 = registerSpec;
        RegisterSpec registerSpec6 = registerSpec2;
        RegisterSpec registerSpec7 = registerSpec3;
        RegisterSpec registerSpec8 = registerSpec4;
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(4);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        registerSpecList4.set(0, registerSpec5);
        registerSpecList4.set(1, registerSpec6);
        registerSpecList4.set(2, registerSpec7);
        registerSpecList4.set(3, registerSpec8);
        return registerSpecList4;
    }

    public RegisterSpec get(int i) {
        return (RegisterSpec) get0(i);
    }

    public int getRegistersSize() {
        int i;
        int size = size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= size) {
                return i4;
            }
            RegisterSpec registerSpec = (RegisterSpec) get0(i2);
            if (registerSpec != null) {
                i = registerSpec.getNextReg();
                if (i > i4) {
                    i2++;
                    i3 = i;
                }
            }
            i = i4;
            i2++;
            i3 = i;
        }
    }

    public Type getType(int i) {
        return get(i).getType().getType();
    }

    public int getWordCount() {
        int i = 0;
        for (int i2 = 0; i2 < size(); i2++) {
            i += getType(i2).getCategory();
        }
        return i;
    }

    public int indexOfRegister(int i) {
        int i2 = i;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (get(i3).getReg() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void set(int i, RegisterSpec registerSpec) {
        set0(i, registerSpec);
    }

    public RegisterSpec specForRegister(int i) {
        int i2 = i;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            RegisterSpec registerSpec = get(i3);
            if (registerSpec.getReg() == i2) {
                return registerSpec;
            }
        }
        return null;
    }

    public RegisterSpecList subset(BitSet bitSet) {
        RegisterSpecList registerSpecList;
        BitSet bitSet2 = bitSet;
        int size = size() - bitSet2.cardinality();
        if (size == 0) {
            return EMPTY;
        }
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(size);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        int i = 0;
        for (int i2 = 0; i2 < size(); i2++) {
            if (!bitSet2.get(i2)) {
                registerSpecList4.set0(i, get0(i2));
                i++;
            }
        }
        if (isImmutable()) {
            registerSpecList4.setImmutable();
        }
        return registerSpecList4;
    }

    public TypeList withAddedType(Type type) {
        UnsupportedOperationException unsupportedOperationException;
        Type type2 = type;
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("unsupported");
        throw unsupportedOperationException2;
    }

    public RegisterSpecList withExpandedRegisters(int i, boolean z, BitSet bitSet) {
        RegisterSpecList registerSpecList;
        int i2 = i;
        boolean z2 = z;
        BitSet bitSet2 = bitSet;
        int size = size();
        if (size == 0) {
            return this;
        }
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(size);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        int i3 = 0;
        boolean z3 = z2;
        int i4 = i2;
        while (i3 < size) {
            RegisterSpec registerSpec = (RegisterSpec) get0(i3);
            boolean z4 = bitSet2 == null ? true : !bitSet2.get(i3);
            if (z4) {
                registerSpecList4.set0(i3, registerSpec.withReg(i4));
                if (!z3) {
                    i4 += registerSpec.getCategory();
                }
            } else {
                registerSpecList4.set0(i3, registerSpec);
            }
            i3++;
            z3 = z3 ? false : z3;
        }
        if (isImmutable()) {
            registerSpecList4.setImmutable();
        }
        return registerSpecList4;
    }

    public RegisterSpecList withFirst(RegisterSpec registerSpec) {
        RegisterSpecList registerSpecList;
        RegisterSpec registerSpec2 = registerSpec;
        int size = size();
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(size + 1);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        for (int i = 0; i < size; i++) {
            registerSpecList4.set0(i + 1, get0(i));
        }
        registerSpecList4.set0(0, registerSpec2);
        if (isImmutable()) {
            registerSpecList4.setImmutable();
        }
        return registerSpecList4;
    }

    public RegisterSpecList withOffset(int i) {
        RegisterSpecList registerSpecList;
        int i2 = i;
        int size = size();
        if (size == 0) {
            return this;
        }
        RegisterSpecList registerSpecList2 = registerSpecList;
        RegisterSpecList registerSpecList3 = new RegisterSpecList(size);
        RegisterSpecList registerSpecList4 = registerSpecList2;
        for (int i3 = 0; i3 < size; i3++) {
            RegisterSpec registerSpec = (RegisterSpec) get0(i3);
            if (registerSpec != null) {
                registerSpecList4.set0(i3, registerSpec.withOffset(i2));
            }
        }
        if (isImmutable()) {
            registerSpecList4.setImmutable();
        }
        return registerSpecList4;
    }

    public RegisterSpecList withoutFirst() {
        RegisterSpecList registerSpecList;
        RegisterSpecList registerSpecList2;
        int size = -1 + size();
        if (size == 0) {
            registerSpecList2 = EMPTY;
        } else {
            RegisterSpecList registerSpecList3 = registerSpecList;
            RegisterSpecList registerSpecList4 = new RegisterSpecList(size);
            registerSpecList2 = registerSpecList3;
            for (int i = 0; i < size; i++) {
                registerSpecList2.set0(i, get0(i + 1));
            }
            if (isImmutable()) {
                registerSpecList2.setImmutable();
                return registerSpecList2;
            }
        }
        return registerSpecList2;
    }

    public RegisterSpecList withoutLast() {
        RegisterSpecList registerSpecList;
        RegisterSpecList registerSpecList2;
        int size = -1 + size();
        if (size == 0) {
            registerSpecList2 = EMPTY;
        } else {
            RegisterSpecList registerSpecList3 = registerSpecList;
            RegisterSpecList registerSpecList4 = new RegisterSpecList(size);
            registerSpecList2 = registerSpecList3;
            for (int i = 0; i < size; i++) {
                registerSpecList2.set0(i, get0(i));
            }
            if (isImmutable()) {
                registerSpecList2.setImmutable();
                return registerSpecList2;
            }
        }
        return registerSpecList2;
    }
}

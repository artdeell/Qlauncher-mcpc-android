package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.MutabilityControl;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecSet */
public final class RegisterSpecSet extends MutabilityControl {
    public static final RegisterSpecSet EMPTY;
    private int size;
    private final RegisterSpec[] specs;

    static {
        RegisterSpecSet registerSpecSet;
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        RegisterSpecSet registerSpecSet3 = new RegisterSpecSet(0);
        EMPTY = registerSpecSet2;
    }

    public RegisterSpecSet(int i) {
        int i2 = i;
        super(i2 != 0);
        this.specs = new RegisterSpec[i2];
        this.size = 0;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof RegisterSpecSet) {
            RegisterSpecSet registerSpecSet = (RegisterSpecSet) obj2;
            RegisterSpec[] registerSpecArr = registerSpecSet.specs;
            int length = this.specs.length;
            if (length == registerSpecArr.length && size() == registerSpecSet.size()) {
                for (int i = 0; i < length; i++) {
                    RegisterSpec registerSpec = this.specs[i];
                    RegisterSpec registerSpec2 = registerSpecArr[i];
                    if (registerSpec != registerSpec2) {
                        if (registerSpec != null) {
                            if (!registerSpec.equals(registerSpec2)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public RegisterSpec findMatchingLocal(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        int length = this.specs.length;
        for (int i = 0; i < length; i++) {
            RegisterSpec registerSpec3 = this.specs[i];
            if (registerSpec3 != null && registerSpec2.matchesVariable(registerSpec3)) {
                return registerSpec3;
            }
        }
        return null;
    }

    public RegisterSpec get(int i) {
        IllegalArgumentException illegalArgumentException;
        try {
            return this.specs[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus reg");
            throw illegalArgumentException2;
        }
    }

    public RegisterSpec get(RegisterSpec registerSpec) {
        return get(registerSpec.getReg());
    }

    public int getMaxSize() {
        return this.specs.length;
    }

    public int hashCode() {
        int length = this.specs.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            RegisterSpec registerSpec = this.specs[i2];
            i = (registerSpec == null ? 0 : registerSpec.hashCode()) + (i * 31);
        }
        return i;
    }

    public void intersect(RegisterSpecSet registerSpecSet, boolean z) {
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        boolean z2 = z;
        throwIfImmutable();
        RegisterSpec[] registerSpecArr = registerSpecSet2.specs;
        int length = this.specs.length;
        int min = Math.min(length, registerSpecArr.length);
        this.size = -1;
        for (int i = 0; i < min; i++) {
            RegisterSpec registerSpec = this.specs[i];
            if (registerSpec != null) {
                RegisterSpec intersect = registerSpec.intersect(registerSpecArr[i], z2);
                if (intersect != registerSpec) {
                    this.specs[i] = intersect;
                }
            }
        }
        while (min < length) {
            this.specs[min] = null;
            min++;
        }
    }

    public RegisterSpec localItemToSpec(LocalItem localItem) {
        LocalItem localItem2 = localItem;
        int length = this.specs.length;
        for (int i = 0; i < length; i++) {
            RegisterSpec registerSpec = this.specs[i];
            if (registerSpec != null && localItem2.equals(registerSpec.getLocalItem())) {
                return registerSpec;
            }
        }
        return null;
    }

    public RegisterSpecSet mutableCopy() {
        RegisterSpecSet registerSpecSet;
        int length = this.specs.length;
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        RegisterSpecSet registerSpecSet3 = new RegisterSpecSet(length);
        RegisterSpecSet registerSpecSet4 = registerSpecSet2;
        for (int i = 0; i < length; i++) {
            RegisterSpec registerSpec = this.specs[i];
            if (registerSpec != null) {
                registerSpecSet4.put(registerSpec);
            }
        }
        registerSpecSet4.size = this.size;
        return registerSpecSet4;
    }

    public void put(RegisterSpec registerSpec) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        RegisterSpec registerSpec2 = registerSpec;
        throwIfImmutable();
        if (registerSpec2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("spec == null");
            throw nullPointerException2;
        }
        this.size = -1;
        try {
            int reg = registerSpec2.getReg();
            this.specs[reg] = registerSpec2;
            if (reg > 0) {
                int i = reg - 1;
                RegisterSpec registerSpec3 = this.specs[i];
                if (registerSpec3 != null && registerSpec3.getCategory() == 2) {
                    this.specs[i] = null;
                }
            }
            if (registerSpec2.getCategory() == 2) {
                this.specs[reg + 1] = null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("spec.getReg() out of range");
            throw illegalArgumentException2;
        }
    }

    public void putAll(RegisterSpecSet registerSpecSet) {
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        int maxSize = registerSpecSet2.getMaxSize();
        for (int i = 0; i < maxSize; i++) {
            RegisterSpec registerSpec = registerSpecSet2.get(i);
            if (registerSpec != null) {
                put(registerSpec);
            }
        }
    }

    public void remove(RegisterSpec registerSpec) {
        IllegalArgumentException illegalArgumentException;
        try {
            this.specs[registerSpec.getReg()] = null;
            this.size = -1;
        } catch (ArrayIndexOutOfBoundsException e) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bogus reg");
            throw illegalArgumentException2;
        }
    }

    public int size() {
        int i = this.size;
        if (i < 0) {
            int length = this.specs.length;
            i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.specs[i2] != null) {
                    i++;
                }
            }
            this.size = i;
        }
        return i;
    }

    public String toString() {
        StringBuffer stringBuffer;
        boolean z = false;
        int length = this.specs.length;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(length * 25);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append('{');
        for (int i = 0; i < length; i++) {
            RegisterSpec registerSpec = this.specs[i];
            if (registerSpec != null) {
                if (z) {
                    StringBuffer append2 = stringBuffer4.append(", ");
                } else {
                    z = true;
                }
                StringBuffer append3 = stringBuffer4.append(registerSpec);
            }
        }
        StringBuffer append4 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }

    public RegisterSpecSet withOffset(int i) {
        RegisterSpecSet registerSpecSet;
        int i2 = i;
        int length = this.specs.length;
        RegisterSpecSet registerSpecSet2 = registerSpecSet;
        RegisterSpecSet registerSpecSet3 = new RegisterSpecSet(length + i2);
        RegisterSpecSet registerSpecSet4 = registerSpecSet2;
        for (int i3 = 0; i3 < length; i3++) {
            RegisterSpec registerSpec = this.specs[i3];
            if (registerSpec != null) {
                registerSpecSet4.put(registerSpec.withOffset(i2));
            }
        }
        registerSpecSet4.size = this.size;
        if (isImmutable()) {
            registerSpecSet4.setImmutable();
        }
        return registerSpecSet4;
    }
}

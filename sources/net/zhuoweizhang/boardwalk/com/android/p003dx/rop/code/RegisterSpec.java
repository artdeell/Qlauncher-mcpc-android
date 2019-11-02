package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import java.util.HashMap;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec */
public final class RegisterSpec implements TypeBearer, ToHuman, Comparable<RegisterSpec> {
    public static final String PREFIX = "v";
    private static final ForComparison theInterningItem;
    private static final HashMap<Object, RegisterSpec> theInterns;
    private final LocalItem local;
    private final int reg;
    private final TypeBearer type;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec$ForComparison */
    private static class ForComparison {
        /* access modifiers changed from: private */
        public LocalItem local;
        /* access modifiers changed from: private */
        public int reg;
        /* access modifiers changed from: private */
        public TypeBearer type;

        private ForComparison() {
        }

        /* synthetic */ ForComparison(C07131 r4) {
            C07131 r1 = r4;
            this();
        }

        public boolean equals(Object obj) {
            Object obj2 = obj;
            if (!(obj2 instanceof RegisterSpec)) {
                return false;
            }
            return ((RegisterSpec) obj2).equals(this.reg, this.type, this.local);
        }

        public int hashCode() {
            return RegisterSpec.hashCodeOf(this.reg, this.type, this.local);
        }

        public void set(int i, TypeBearer typeBearer, LocalItem localItem) {
            TypeBearer typeBearer2 = typeBearer;
            LocalItem localItem2 = localItem;
            this.reg = i;
            this.type = typeBearer2;
            this.local = localItem2;
        }

        public RegisterSpec toRegisterSpec() {
            RegisterSpec registerSpec;
            RegisterSpec registerSpec2 = registerSpec;
            RegisterSpec registerSpec3 = new RegisterSpec(this.reg, this.type, this.local, null);
            return registerSpec2;
        }
    }

    static {
        HashMap<Object, RegisterSpec> hashMap;
        ForComparison forComparison;
        HashMap<Object, RegisterSpec> hashMap2 = hashMap;
        HashMap<Object, RegisterSpec> hashMap3 = new HashMap<>(1000);
        theInterns = hashMap2;
        ForComparison forComparison2 = forComparison;
        ForComparison forComparison3 = new ForComparison(null);
        theInterningItem = forComparison2;
    }

    private RegisterSpec(int i, TypeBearer typeBearer, LocalItem localItem) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        TypeBearer typeBearer2 = typeBearer;
        LocalItem localItem2 = localItem;
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("reg < 0");
            throw illegalArgumentException2;
        } else if (typeBearer2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("type == null");
            throw nullPointerException2;
        } else {
            this.reg = i2;
            this.type = typeBearer2;
            this.local = localItem2;
        }
    }

    /* synthetic */ RegisterSpec(int i, TypeBearer typeBearer, LocalItem localItem, C07131 r13) {
        C07131 r4 = r13;
        this(i, typeBearer, localItem);
    }

    /* access modifiers changed from: private */
    public boolean equals(int i, TypeBearer typeBearer, LocalItem localItem) {
        LocalItem localItem2 = localItem;
        return this.reg == i && this.type.equals(typeBearer) && (this.local == localItem2 || (this.local != null && this.local.equals(localItem2)));
    }

    /* access modifiers changed from: private */
    public static int hashCodeOf(int i, TypeBearer typeBearer, LocalItem localItem) {
        LocalItem localItem2 = localItem;
        return i + (31 * (((localItem2 != null ? localItem2.hashCode() : 0) * 31) + typeBearer.hashCode()));
    }

    private static RegisterSpec intern(int i, TypeBearer typeBearer, LocalItem localItem) {
        int i2 = i;
        TypeBearer typeBearer2 = typeBearer;
        LocalItem localItem2 = localItem;
        RegisterSpec registerSpec = theInterns;
        synchronized (registerSpec) {
            try {
                theInterningItem.set(i2, typeBearer2, localItem2);
                th = (RegisterSpec) theInterns.get(theInterningItem);
                if (th != null) {
                    return th;
                }
                RegisterSpec registerSpec2 = theInterningItem.toRegisterSpec();
                Object put = theInterns.put(registerSpec2, registerSpec2);
                return registerSpec2;
            } finally {
                Throwable th = th;
                RegisterSpec registerSpec3 = registerSpec;
                Throwable th2 = th;
            }
        }
    }

    public static RegisterSpec make(int i, TypeBearer typeBearer) {
        return intern(i, typeBearer, null);
    }

    public static RegisterSpec make(int i, TypeBearer typeBearer, LocalItem localItem) {
        NullPointerException nullPointerException;
        int i2 = i;
        TypeBearer typeBearer2 = typeBearer;
        LocalItem localItem2 = localItem;
        if (localItem2 != null) {
            return intern(i2, typeBearer2, localItem2);
        }
        NullPointerException nullPointerException2 = nullPointerException;
        NullPointerException nullPointerException3 = new NullPointerException("local  == null");
        throw nullPointerException2;
    }

    public static RegisterSpec makeLocalOptional(int i, TypeBearer typeBearer, LocalItem localItem) {
        return intern(i, typeBearer, localItem);
    }

    public static String regString(int i) {
        StringBuilder sb;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(PREFIX).append(i2).toString();
    }

    private String toString0(boolean z) {
        StringBuffer stringBuffer;
        boolean z2 = z;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(40);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(regString());
        StringBuffer append2 = stringBuffer4.append(":");
        if (this.local != null) {
            StringBuffer append3 = stringBuffer4.append(this.local.toString());
        }
        Type type2 = this.type.getType();
        StringBuffer append4 = stringBuffer4.append(type2);
        if (type2 != this.type) {
            StringBuffer append5 = stringBuffer4.append("=");
            if (z2 && (this.type instanceof CstString)) {
                StringBuffer append6 = stringBuffer4.append(((CstString) this.type).toQuoted());
            } else if (!z2 || !(this.type instanceof Constant)) {
                StringBuffer append7 = stringBuffer4.append(this.type);
            } else {
                StringBuffer append8 = stringBuffer4.append(this.type.toHuman());
            }
        }
        return stringBuffer4.toString();
    }

    public int compareTo(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        if (this.reg >= registerSpec2.reg) {
            if (this.reg > registerSpec2.reg) {
                return 1;
            }
            int compareTo = this.type.getType().compareTo(registerSpec2.type.getType());
            if (compareTo != 0) {
                return compareTo;
            }
            if (this.local == null) {
                if (registerSpec2.local == null) {
                    return 0;
                }
            } else if (registerSpec2.local == null) {
                return 1;
            } else {
                return this.local.compareTo(registerSpec2.local);
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (obj2 instanceof RegisterSpec) {
            RegisterSpec registerSpec = (RegisterSpec) obj2;
            return equals(registerSpec.reg, registerSpec.type, registerSpec.local);
        } else if (!(obj2 instanceof ForComparison)) {
            return false;
        } else {
            ForComparison forComparison = (ForComparison) obj2;
            return equals(forComparison.reg, forComparison.type, forComparison.local);
        }
    }

    public boolean equalsUsingSimpleType(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        return matchesVariable(registerSpec2) && this.reg == registerSpec2.reg;
    }

    public final int getBasicFrameType() {
        return this.type.getBasicFrameType();
    }

    public final int getBasicType() {
        return this.type.getBasicType();
    }

    public int getCategory() {
        return this.type.getType().getCategory();
    }

    public TypeBearer getFrameType() {
        return this.type.getFrameType();
    }

    public LocalItem getLocalItem() {
        return this.local;
    }

    public int getNextReg() {
        return this.reg + getCategory();
    }

    public int getReg() {
        return this.reg;
    }

    public Type getType() {
        return this.type.getType();
    }

    public TypeBearer getTypeBearer() {
        return this.type;
    }

    public int hashCode() {
        return hashCodeOf(this.reg, this.type, this.local);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r7 != false) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec intersect(net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec r16, boolean r17) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r12 = r0
            r13 = r1
            if (r12 != r13) goto L_0x000e
            r12 = r0
            r3 = r12
        L_0x000b:
            r12 = r3
            r0 = r12
        L_0x000d:
            return r0
        L_0x000e:
            r12 = 0
            r3 = r12
            r12 = r1
            if (r12 == 0) goto L_0x000b
            r12 = r0
            int r12 = r12.reg
            r4 = r12
            r12 = r1
            int r12 = r12.getReg()
            r5 = r12
            r12 = 0
            r3 = r12
            r12 = r4
            r13 = r5
            if (r12 != r13) goto L_0x000b
            r12 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r12 = r12.local
            if (r12 == 0) goto L_0x0036
            r12 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r12 = r12.local
            r13 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r13 = r13.getLocalItem()
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x0078
        L_0x0036:
            r12 = 0
            r6 = r12
        L_0x0038:
            r12 = r6
            r13 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r13 = r13.local
            if (r12 != r13) goto L_0x007d
            r12 = 1
            r7 = r12
        L_0x0040:
            r12 = r2
            if (r12 == 0) goto L_0x0048
            r12 = 0
            r3 = r12
            r12 = r7
            if (r12 == 0) goto L_0x000b
        L_0x0048:
            r12 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r12 = r12.getType()
            r8 = r12
            r12 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r12 = r12.getType()
            r9 = r12
            r12 = 0
            r3 = r12
            r12 = r8
            r13 = r9
            if (r12 != r13) goto L_0x000b
            r12 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r12 = r12.type
            r13 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r13 = r13.getTypeBearer()
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0080
            r12 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r12 = r12.type
            r10 = r12
        L_0x006c:
            r12 = r10
            r13 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r13 = r13.type
            if (r12 != r13) goto L_0x0083
            r12 = r7
            if (r12 == 0) goto L_0x0083
            r12 = r0
            r0 = r12
            goto L_0x000d
        L_0x0078:
            r12 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r12 = r12.local
            r6 = r12
            goto L_0x0038
        L_0x007d:
            r12 = 0
            r7 = r12
            goto L_0x0040
        L_0x0080:
            r12 = r8
            r10 = r12
            goto L_0x006c
        L_0x0083:
            r12 = r6
            if (r12 != 0) goto L_0x0093
            r12 = r0
            int r12 = r12.reg
            r13 = r10
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r12 = make(r12, r13)
            r11 = r12
        L_0x008f:
            r12 = r11
            r0 = r12
            goto L_0x000d
        L_0x0093:
            r12 = r0
            int r12 = r12.reg
            r13 = r10
            r14 = r6
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r12 = make(r12, r13, r14)
            r11 = r12
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.intersect(net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec, boolean):net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec");
    }

    public boolean isCategory1() {
        return this.type.getType().isCategory1();
    }

    public boolean isCategory2() {
        return this.type.getType().isCategory2();
    }

    public final boolean isConstant() {
        return false;
    }

    public boolean matchesVariable(RegisterSpec registerSpec) {
        RegisterSpec registerSpec2 = registerSpec;
        return registerSpec2 != null && this.type.getType().equals(registerSpec2.type.getType()) && (this.local == registerSpec2.local || (this.local != null && this.local.equals(registerSpec2.local)));
    }

    public String regString() {
        return regString(this.reg);
    }

    public String toHuman() {
        return toString0(true);
    }

    public String toString() {
        return toString0(false);
    }

    public RegisterSpec withLocalItem(LocalItem localItem) {
        LocalItem localItem2 = localItem;
        if (this.local != localItem2 && (this.local == null || !this.local.equals(localItem2))) {
            return makeLocalOptional(this.reg, this.type, localItem2);
        }
        return this;
    }

    public RegisterSpec withOffset(int i) {
        int i2 = i;
        if (i2 != 0) {
            return withReg(i2 + this.reg);
        }
        return this;
    }

    public RegisterSpec withReg(int i) {
        int i2 = i;
        if (this.reg != i2) {
            return makeLocalOptional(i2, this.type, this.local);
        }
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r4v1, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer] */
    /* JADX WARNING: type inference failed for: r3v14, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r3v16, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec withSimpleType() {
        /*
            r6 = this;
            r0 = r6
            r3 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.TypeBearer r3 = r3.type
            r1 = r3
            r3 = r1
            boolean r3 = r3 instanceof net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type
            if (r3 == 0) goto L_0x0022
            r3 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r3 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type) r3
            r2 = r3
        L_0x000e:
            r3 = r2
            boolean r3 = r3.isUninitialized()
            if (r3 == 0) goto L_0x001b
            r3 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r3 = r3.getInitializedType()
            r2 = r3
        L_0x001b:
            r3 = r2
            r4 = r1
            if (r3 != r4) goto L_0x0029
            r3 = r0
            r0 = r3
        L_0x0021:
            return r0
        L_0x0022:
            r3 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r3 = r3.getType()
            r2 = r3
            goto L_0x000e
        L_0x0029:
            r3 = r0
            int r3 = r3.reg
            r4 = r2
            r5 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.LocalItem r5 = r5.local
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r3 = makeLocalOptional(r3, r4, r5)
            r0 = r3
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec.withSimpleType():net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec");
    }

    public RegisterSpec withType(TypeBearer typeBearer) {
        return makeLocalOptional(this.reg, typeBearer, this.local);
    }
}

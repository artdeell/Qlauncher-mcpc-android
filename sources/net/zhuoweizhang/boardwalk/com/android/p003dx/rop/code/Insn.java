package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code;

import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.StdTypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ToHuman;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn */
public abstract class Insn implements ToHuman {
    private final Rop opcode;
    private final SourcePosition position;
    private final RegisterSpec result;
    private final RegisterSpecList sources;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn$BaseVisitor */
    public static class BaseVisitor implements Visitor {
        public BaseVisitor() {
        }

        public void visitFillArrayDataInsn(FillArrayDataInsn fillArrayDataInsn) {
        }

        public void visitPlainCstInsn(PlainCstInsn plainCstInsn) {
        }

        public void visitPlainInsn(PlainInsn plainInsn) {
        }

        public void visitSwitchInsn(SwitchInsn switchInsn) {
        }

        public void visitThrowingCstInsn(ThrowingCstInsn throwingCstInsn) {
        }

        public void visitThrowingInsn(ThrowingInsn throwingInsn) {
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn$Visitor */
    public interface Visitor {
        void visitFillArrayDataInsn(FillArrayDataInsn fillArrayDataInsn);

        void visitPlainCstInsn(PlainCstInsn plainCstInsn);

        void visitPlainInsn(PlainInsn plainInsn);

        void visitSwitchInsn(SwitchInsn switchInsn);

        void visitThrowingCstInsn(ThrowingCstInsn throwingCstInsn);

        void visitThrowingInsn(ThrowingInsn throwingInsn);
    }

    public Insn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        Rop rop2 = rop;
        SourcePosition sourcePosition2 = sourcePosition;
        RegisterSpec registerSpec2 = registerSpec;
        RegisterSpecList registerSpecList2 = registerSpecList;
        if (rop2 == null) {
            NullPointerException nullPointerException4 = nullPointerException3;
            NullPointerException nullPointerException5 = new NullPointerException("opcode == null");
            throw nullPointerException4;
        } else if (sourcePosition2 == null) {
            NullPointerException nullPointerException6 = nullPointerException2;
            NullPointerException nullPointerException7 = new NullPointerException("position == null");
            throw nullPointerException6;
        } else if (registerSpecList2 == null) {
            NullPointerException nullPointerException8 = nullPointerException;
            NullPointerException nullPointerException9 = new NullPointerException("sources == null");
            throw nullPointerException8;
        } else {
            this.opcode = rop2;
            this.position = sourcePosition2;
            this.result = registerSpec2;
            this.sources = registerSpecList2;
        }
    }

    private static boolean equalsHandleNulls(Object obj, Object obj2) {
        Object obj3 = obj;
        Object obj4 = obj2;
        return obj3 == obj4 || (obj3 != null && obj3.equals(obj4));
    }

    public abstract void accept(Visitor visitor);

    public final boolean canThrow() {
        return this.opcode.canThrow();
    }

    public boolean contentEquals(Insn insn) {
        Insn insn2 = insn;
        return this.opcode == insn2.getOpcode() && this.position.equals(insn2.getPosition()) && getClass() == insn2.getClass() && equalsHandleNulls(this.result, insn2.getResult()) && equalsHandleNulls(this.sources, insn2.getSources()) && StdTypeList.equalContents(getCatches(), insn2.getCatches());
    }

    public Insn copy() {
        return withRegisterOffset(0);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public abstract TypeList getCatches();

    public String getInlineString() {
        return null;
    }

    public final RegisterSpec getLocalAssignment() {
        RegisterSpec registerSpec = this.opcode.getOpcode() == 54 ? this.sources.get(0) : this.result;
        if (registerSpec == null || registerSpec.getLocalItem() == null) {
            return null;
        }
        return registerSpec;
    }

    public final Rop getOpcode() {
        return this.opcode;
    }

    public final SourcePosition getPosition() {
        return this.position;
    }

    public final RegisterSpec getResult() {
        return this.result;
    }

    public final RegisterSpecList getSources() {
        return this.sources;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public String toHuman() {
        return toHumanWithInline(getInlineString());
    }

    /* access modifiers changed from: protected */
    public final String toHumanWithInline(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(80);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(this.position);
        StringBuffer append2 = stringBuffer4.append(": ");
        StringBuffer append3 = stringBuffer4.append(this.opcode.getNickname());
        if (str2 != null) {
            StringBuffer append4 = stringBuffer4.append("(");
            StringBuffer append5 = stringBuffer4.append(str2);
            StringBuffer append6 = stringBuffer4.append(")");
        }
        if (this.result == null) {
            StringBuffer append7 = stringBuffer4.append(" .");
        } else {
            StringBuffer append8 = stringBuffer4.append(" ");
            StringBuffer append9 = stringBuffer4.append(this.result.toHuman());
        }
        StringBuffer append10 = stringBuffer4.append(" <-");
        int size = this.sources.size();
        if (size == 0) {
            StringBuffer append11 = stringBuffer4.append(" .");
        } else {
            for (int i = 0; i < size; i++) {
                StringBuffer append12 = stringBuffer4.append(" ");
                StringBuffer append13 = stringBuffer4.append(this.sources.get(i).toHuman());
            }
        }
        return stringBuffer4.toString();
    }

    public String toString() {
        return toStringWithInline(getInlineString());
    }

    /* access modifiers changed from: protected */
    public final String toStringWithInline(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(80);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append("Insn{");
        StringBuffer append2 = stringBuffer4.append(this.position);
        StringBuffer append3 = stringBuffer4.append(' ');
        StringBuffer append4 = stringBuffer4.append(this.opcode);
        if (str2 != null) {
            StringBuffer append5 = stringBuffer4.append(' ');
            StringBuffer append6 = stringBuffer4.append(str2);
        }
        StringBuffer append7 = stringBuffer4.append(" :: ");
        if (this.result != null) {
            StringBuffer append8 = stringBuffer4.append(this.result);
            StringBuffer append9 = stringBuffer4.append(" <- ");
        }
        StringBuffer append10 = stringBuffer4.append(this.sources);
        StringBuffer append11 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }

    public abstract Insn withAddedCatch(Type type);

    public abstract Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList);

    public abstract Insn withRegisterOffset(int i);

    public Insn withSourceLiteral() {
        return this;
    }
}

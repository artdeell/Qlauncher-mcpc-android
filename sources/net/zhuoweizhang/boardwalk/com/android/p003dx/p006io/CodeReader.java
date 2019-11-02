package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io;

import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions.DecodedInstruction;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.CodeReader */
public final class CodeReader {
    private Visitor fallbackVisitor = null;
    private Visitor fieldVisitor = null;
    private Visitor methodVisitor = null;
    private Visitor stringVisitor = null;
    private Visitor typeVisitor = null;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.CodeReader$Visitor */
    public interface Visitor {
        void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction);
    }

    public CodeReader() {
    }

    private void callVisit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
        DecodedInstruction decodedInstruction2;
        DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
        Visitor visitor = null;
        switch (OpcodeInfo.getIndexType(decodedInstruction.getOpcode())) {
            case STRING_REF:
                visitor = this.stringVisitor;
                break;
            case TYPE_REF:
                visitor = this.typeVisitor;
                break;
            case FIELD_REF:
                visitor = this.fieldVisitor;
                break;
            case METHOD_REF:
                visitor = this.methodVisitor;
                break;
        }
        if (visitor == null) {
            visitor = this.fallbackVisitor;
        }
        if (visitor != null) {
            visitor.visit(decodedInstructionArr2, decodedInstruction2);
        }
    }

    public void setAllVisitors(Visitor visitor) {
        Visitor visitor2 = visitor;
        this.fallbackVisitor = visitor2;
        this.stringVisitor = visitor2;
        this.typeVisitor = visitor2;
        this.fieldVisitor = visitor2;
        this.methodVisitor = visitor2;
    }

    public void setFallbackVisitor(Visitor visitor) {
        Visitor visitor2 = visitor;
        this.fallbackVisitor = visitor2;
    }

    public void setFieldVisitor(Visitor visitor) {
        Visitor visitor2 = visitor;
        this.fieldVisitor = visitor2;
    }

    public void setMethodVisitor(Visitor visitor) {
        Visitor visitor2 = visitor;
        this.methodVisitor = visitor2;
    }

    public void setStringVisitor(Visitor visitor) {
        Visitor visitor2 = visitor;
        this.stringVisitor = visitor2;
    }

    public void setTypeVisitor(Visitor visitor) {
        Visitor visitor2 = visitor;
        this.typeVisitor = visitor2;
    }

    public void visitAll(DecodedInstruction[] decodedInstructionArr) throws DexException {
        DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
        int length = decodedInstructionArr2.length;
        for (int i = 0; i < length; i++) {
            DecodedInstruction decodedInstruction = decodedInstructionArr2[i];
            if (decodedInstruction != null) {
                callVisit(decodedInstructionArr2, decodedInstruction);
            }
        }
    }

    public void visitAll(short[] sArr) throws DexException {
        visitAll(DecodedInstruction.decodeAll(sArr));
    }
}

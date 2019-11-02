package net.zhuoweizhang.boardwalk.com.android.p003dx.merge;

import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.CodeReader;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.CodeReader.Visitor;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions.DecodedInstruction;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions.ShortArrayCodeOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.InstructionTransformer */
final class InstructionTransformer {
    /* access modifiers changed from: private */
    public final IndexMap indexMap;
    private int mappedAt;
    /* access modifiers changed from: private */
    public DecodedInstruction[] mappedInstructions;
    private final CodeReader reader;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.InstructionTransformer$FieldVisitor */
    private class FieldVisitor implements Visitor {
        final /* synthetic */ InstructionTransformer this$0;

        private FieldVisitor(InstructionTransformer instructionTransformer) {
            this.this$0 = instructionTransformer;
        }

        /* synthetic */ FieldVisitor(InstructionTransformer instructionTransformer, C07111 r7) {
            C07111 r2 = r7;
            this(instructionTransformer);
        }

        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
            DecodedInstruction decodedInstruction2 = decodedInstruction;
            int adjustField = this.this$0.indexMap.adjustField(decodedInstruction2.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction2.getOpcode() == 27, adjustField);
            this.this$0.mappedInstructions[InstructionTransformer.access$608(this.this$0)] = decodedInstruction2.withIndex(adjustField);
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.InstructionTransformer$GenericVisitor */
    private class GenericVisitor implements Visitor {
        final /* synthetic */ InstructionTransformer this$0;

        private GenericVisitor(InstructionTransformer instructionTransformer) {
            this.this$0 = instructionTransformer;
        }

        /* synthetic */ GenericVisitor(InstructionTransformer instructionTransformer, C07111 r7) {
            C07111 r2 = r7;
            this(instructionTransformer);
        }

        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
            this.this$0.mappedInstructions[InstructionTransformer.access$608(this.this$0)] = decodedInstruction;
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.InstructionTransformer$MethodVisitor */
    private class MethodVisitor implements Visitor {
        final /* synthetic */ InstructionTransformer this$0;

        private MethodVisitor(InstructionTransformer instructionTransformer) {
            this.this$0 = instructionTransformer;
        }

        /* synthetic */ MethodVisitor(InstructionTransformer instructionTransformer, C07111 r7) {
            C07111 r2 = r7;
            this(instructionTransformer);
        }

        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
            DecodedInstruction decodedInstruction2 = decodedInstruction;
            int adjustMethod = this.this$0.indexMap.adjustMethod(decodedInstruction2.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction2.getOpcode() == 27, adjustMethod);
            this.this$0.mappedInstructions[InstructionTransformer.access$608(this.this$0)] = decodedInstruction2.withIndex(adjustMethod);
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.InstructionTransformer$StringVisitor */
    private class StringVisitor implements Visitor {
        final /* synthetic */ InstructionTransformer this$0;

        private StringVisitor(InstructionTransformer instructionTransformer) {
            this.this$0 = instructionTransformer;
        }

        /* synthetic */ StringVisitor(InstructionTransformer instructionTransformer, C07111 r7) {
            C07111 r2 = r7;
            this(instructionTransformer);
        }

        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
            DecodedInstruction decodedInstruction2 = decodedInstruction;
            int adjustString = this.this$0.indexMap.adjustString(decodedInstruction2.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction2.getOpcode() == 27, adjustString);
            this.this$0.mappedInstructions[InstructionTransformer.access$608(this.this$0)] = decodedInstruction2.withIndex(adjustString);
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.InstructionTransformer$TypeVisitor */
    private class TypeVisitor implements Visitor {
        final /* synthetic */ InstructionTransformer this$0;

        private TypeVisitor(InstructionTransformer instructionTransformer) {
            this.this$0 = instructionTransformer;
        }

        /* synthetic */ TypeVisitor(InstructionTransformer instructionTransformer, C07111 r7) {
            C07111 r2 = r7;
            this(instructionTransformer);
        }

        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            DecodedInstruction[] decodedInstructionArr2 = decodedInstructionArr;
            DecodedInstruction decodedInstruction2 = decodedInstruction;
            int adjustType = this.this$0.indexMap.adjustType(decodedInstruction2.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction2.getOpcode() == 27, adjustType);
            this.this$0.mappedInstructions[InstructionTransformer.access$608(this.this$0)] = decodedInstruction2.withIndex(adjustType);
        }
    }

    public InstructionTransformer(IndexMap indexMap2) {
        CodeReader codeReader;
        GenericVisitor genericVisitor;
        StringVisitor stringVisitor;
        TypeVisitor typeVisitor;
        FieldVisitor fieldVisitor;
        MethodVisitor methodVisitor;
        this.indexMap = indexMap2;
        CodeReader codeReader2 = codeReader;
        CodeReader codeReader3 = new CodeReader();
        this.reader = codeReader2;
        CodeReader codeReader4 = this.reader;
        GenericVisitor genericVisitor2 = genericVisitor;
        GenericVisitor genericVisitor3 = new GenericVisitor(this, null);
        codeReader4.setAllVisitors(genericVisitor2);
        CodeReader codeReader5 = this.reader;
        StringVisitor stringVisitor2 = stringVisitor;
        StringVisitor stringVisitor3 = new StringVisitor(this, null);
        codeReader5.setStringVisitor(stringVisitor2);
        CodeReader codeReader6 = this.reader;
        TypeVisitor typeVisitor2 = typeVisitor;
        TypeVisitor typeVisitor3 = new TypeVisitor(this, null);
        codeReader6.setTypeVisitor(typeVisitor2);
        CodeReader codeReader7 = this.reader;
        FieldVisitor fieldVisitor2 = fieldVisitor;
        FieldVisitor fieldVisitor3 = new FieldVisitor(this, null);
        codeReader7.setFieldVisitor(fieldVisitor2);
        CodeReader codeReader8 = this.reader;
        MethodVisitor methodVisitor2 = methodVisitor;
        MethodVisitor methodVisitor3 = new MethodVisitor(this, null);
        codeReader8.setMethodVisitor(methodVisitor2);
    }

    static /* synthetic */ int access$608(InstructionTransformer instructionTransformer) {
        InstructionTransformer instructionTransformer2 = instructionTransformer;
        int i = instructionTransformer2.mappedAt;
        instructionTransformer2.mappedAt = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public static void jumboCheck(boolean z, int i) {
        DexException dexException;
        StringBuilder sb;
        int i2 = i;
        if (!z && i2 > 65535) {
            DexException dexException2 = dexException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            DexException dexException3 = new DexException(sb2.append("Cannot merge new index ").append(i2).append(" into a non-jumbo instruction!").toString());
            throw dexException2;
        }
    }

    public short[] transform(short[] sArr) throws DexException {
        ShortArrayCodeOutput shortArrayCodeOutput;
        DecodedInstruction[] decodeAll = DecodedInstruction.decodeAll(sArr);
        int length = decodeAll.length;
        this.mappedInstructions = new DecodedInstruction[length];
        this.mappedAt = 0;
        this.reader.visitAll(decodeAll);
        ShortArrayCodeOutput shortArrayCodeOutput2 = shortArrayCodeOutput;
        ShortArrayCodeOutput shortArrayCodeOutput3 = new ShortArrayCodeOutput(length);
        ShortArrayCodeOutput shortArrayCodeOutput4 = shortArrayCodeOutput2;
        DecodedInstruction[] decodedInstructionArr = this.mappedInstructions;
        int length2 = decodedInstructionArr.length;
        for (int i = 0; i < length2; i++) {
            DecodedInstruction decodedInstruction = decodedInstructionArr[i];
            if (decodedInstruction != null) {
                decodedInstruction.encode(shortArrayCodeOutput4);
            }
        }
        return shortArrayCodeOutput4.getArray();
    }
}

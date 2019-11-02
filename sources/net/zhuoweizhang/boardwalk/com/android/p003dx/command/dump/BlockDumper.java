package net.zhuoweizhang.boardwalk.com.android.p003dx.command.dump;

import java.io.PrintStream;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BasicBlocker;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteCatchList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ByteCatchList.Item;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ConcreteMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Ropper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.CodeObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.StdAttributeFactory;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Member;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Method;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.BasicBlockList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.DexTranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Insn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.InsnList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dump.BlockDumper */
public class BlockDumper extends BaseDumper {
    protected DirectClassFile classFile = null;
    private boolean first = true;
    private boolean optimize;
    private boolean rop;
    protected boolean suppressDump = true;

    BlockDumper(byte[] bArr, PrintStream printStream, String str, boolean z, Args args) {
        boolean z2 = z;
        Args args2 = args;
        super(bArr, printStream, str, args2);
        this.rop = z2;
        this.optimize = args2.optimize;
    }

    public static void dump(byte[] bArr, PrintStream printStream, String str, boolean z, Args args) {
        BlockDumper blockDumper;
        BlockDumper blockDumper2 = blockDumper;
        BlockDumper blockDumper3 = new BlockDumper(bArr, printStream, str, z, args);
        blockDumper2.dump();
    }

    private void regularDump(ConcreteMethod concreteMethod) {
        CodeObserver codeObserver;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        ConcreteMethod concreteMethod2 = concreteMethod;
        BytecodeArray code = concreteMethod2.getCode();
        ByteArray bytes = code.getBytes();
        ByteBlockList identifyBlocks = BasicBlocker.identifyBlocks(concreteMethod2);
        int size = identifyBlocks.size();
        CodeObserver codeObserver2 = codeObserver;
        CodeObserver codeObserver3 = new CodeObserver(bytes, this);
        CodeObserver codeObserver4 = codeObserver2;
        setAt(bytes, 0);
        this.suppressDump = false;
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            ByteBlock byteBlock = identifyBlocks.get(i2);
            int start = byteBlock.getStart();
            int end = byteBlock.getEnd();
            if (i < start) {
                ByteArray byteArray = bytes;
                int i3 = i;
                int i4 = start - i;
                StringBuilder sb6 = sb5;
                StringBuilder sb7 = new StringBuilder();
                parsed(byteArray, i3, i4, sb6.append("dead code ").append(Hex.m51u2(i)).append("..").append(Hex.m51u2(start)).toString());
            }
            ByteArray byteArray2 = bytes;
            int i5 = start;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            parsed(byteArray2, i5, 0, sb8.append("block ").append(Hex.m51u2(byteBlock.getLabel())).append(": ").append(Hex.m51u2(start)).append("..").append(Hex.m51u2(end)).toString());
            changeIndent(1);
            while (start < end) {
                int parseInstruction = code.parseInstruction(start, codeObserver4);
                codeObserver4.setPreviousOffset(start);
                start += parseInstruction;
            }
            IntList successors = byteBlock.getSuccessors();
            int size2 = successors.size();
            if (size2 == 0) {
                parsed(bytes, end, 0, "returns");
            } else {
                for (int i6 = 0; i6 < size2; i6++) {
                    int i7 = successors.get(i6);
                    ByteArray byteArray3 = bytes;
                    int i8 = end;
                    StringBuilder sb10 = sb3;
                    StringBuilder sb11 = new StringBuilder();
                    parsed(byteArray3, i8, 0, sb10.append("next ").append(Hex.m51u2(i7)).toString());
                }
            }
            ByteCatchList catches = byteBlock.getCatches();
            int size3 = catches.size();
            for (int i9 = 0; i9 < size3; i9++) {
                Item item = catches.get(i9);
                CstType exceptionClass = item.getExceptionClass();
                StringBuilder sb12 = sb4;
                StringBuilder sb13 = new StringBuilder();
                parsed(bytes, end, 0, sb12.append("catch ").append(exceptionClass == CstType.OBJECT ? "<any>" : exceptionClass.toHuman()).append(" -> ").append(Hex.m51u2(item.getHandlerPc())).toString());
            }
            changeIndent(-1);
            i2++;
            i = end;
        }
        int size4 = bytes.size();
        if (i < size4) {
            ByteArray byteArray4 = bytes;
            int i10 = i;
            int i11 = size4 - i;
            StringBuilder sb14 = sb;
            StringBuilder sb15 = new StringBuilder();
            parsed(byteArray4, i10, i11, sb14.append("dead code ").append(Hex.m51u2(i)).append("..").append(Hex.m51u2(size4)).toString());
        }
        this.suppressDump = true;
    }

    private void ropDump(ConcreteMethod concreteMethod) {
        StringBuffer stringBuffer;
        StringBuilder sb;
        ConcreteMethod concreteMethod2 = concreteMethod;
        DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
        ByteArray bytes = concreteMethod2.getCode().getBytes();
        RopMethod convert = Ropper.convert(concreteMethod2, dexTranslationAdvice);
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(2000);
        StringBuffer stringBuffer4 = stringBuffer2;
        if (this.optimize) {
            boolean isStatic = AccessFlags.isStatic(concreteMethod2.getAccessFlags());
            convert = Optimizer.optimize(convert, computeParamWidth(concreteMethod2, isStatic), isStatic, true, dexTranslationAdvice);
        }
        BasicBlockList blocks = convert.getBlocks();
        int[] labelsInOrder = blocks.getLabelsInOrder();
        StringBuffer stringBuffer5 = stringBuffer4;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuffer append = stringBuffer5.append(sb2.append("first ").append(Hex.m51u2(convert.getFirstLabel())).append("\n").toString());
        int length = labelsInOrder.length;
        for (int i = 0; i < length; i++) {
            int i2 = labelsInOrder[i];
            BasicBlock basicBlock = blocks.get(blocks.indexOfLabel(i2));
            StringBuffer append2 = stringBuffer4.append("block ");
            StringBuffer append3 = stringBuffer4.append(Hex.m51u2(i2));
            StringBuffer append4 = stringBuffer4.append("\n");
            IntList labelToPredecessors = convert.labelToPredecessors(i2);
            int size = labelToPredecessors.size();
            for (int i3 = 0; i3 < size; i3++) {
                StringBuffer append5 = stringBuffer4.append("  pred ");
                StringBuffer append6 = stringBuffer4.append(Hex.m51u2(labelToPredecessors.get(i3)));
                StringBuffer append7 = stringBuffer4.append("\n");
            }
            InsnList insns = basicBlock.getInsns();
            int size2 = insns.size();
            for (int i4 = 0; i4 < size2; i4++) {
                Insn insn = insns.get(i4);
                StringBuffer append8 = stringBuffer4.append("  ");
                StringBuffer append9 = stringBuffer4.append(insns.get(i4).toHuman());
                StringBuffer append10 = stringBuffer4.append("\n");
            }
            IntList successors = basicBlock.getSuccessors();
            int size3 = successors.size();
            if (size3 == 0) {
                StringBuffer append11 = stringBuffer4.append("  returns\n");
            } else {
                int primarySuccessor = basicBlock.getPrimarySuccessor();
                for (int i5 = 0; i5 < size3; i5++) {
                    int i6 = successors.get(i5);
                    StringBuffer append12 = stringBuffer4.append("  next ");
                    StringBuffer append13 = stringBuffer4.append(Hex.m51u2(i6));
                    if (size3 != 1 && i6 == primarySuccessor) {
                        StringBuffer append14 = stringBuffer4.append(" *");
                    }
                    StringBuffer append15 = stringBuffer4.append("\n");
                }
            }
        }
        this.suppressDump = false;
        setAt(bytes, 0);
        parsed(bytes, 0, bytes.size(), stringBuffer4.toString());
        this.suppressDump = true;
    }

    public void changeIndent(int i) {
        int i2 = i;
        if (!this.suppressDump) {
            super.changeIndent(i2);
        }
    }

    public void dump() {
        ByteArray byteArray;
        DirectClassFile directClassFile;
        DirectClassFile directClassFile2;
        ByteArray byteArray2 = byteArray;
        ByteArray byteArray3 = new ByteArray(getBytes());
        ByteArray byteArray4 = byteArray2;
        DirectClassFile directClassFile3 = directClassFile;
        DirectClassFile directClassFile4 = new DirectClassFile(byteArray4, getFilePath(), getStrictParse());
        this.classFile = directClassFile3;
        this.classFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
        int magic = this.classFile.getMagic();
        DirectClassFile directClassFile5 = directClassFile2;
        DirectClassFile directClassFile6 = new DirectClassFile(byteArray4, getFilePath(), getStrictParse());
        DirectClassFile directClassFile7 = directClassFile5;
        directClassFile7.setAttributeFactory(StdAttributeFactory.THE_ONE);
        directClassFile7.setObserver(this);
        int magic2 = directClassFile7.getMagic();
    }

    public void endParsingMember(ByteArray byteArray, int i, String str, String str2, Member member) {
        ConcreteMethod concreteMethod;
        ByteArray byteArray2 = byteArray;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        Member member2 = member;
        if ((member2 instanceof Method) && shouldDumpMethod(str3) && (1280 & member2.getAccessFlags()) == 0) {
            ConcreteMethod concreteMethod2 = concreteMethod;
            ConcreteMethod concreteMethod3 = new ConcreteMethod((Method) member2, this.classFile, true, true);
            ConcreteMethod concreteMethod4 = concreteMethod2;
            if (this.rop) {
                ropDump(concreteMethod4);
            } else {
                regularDump(concreteMethod4);
            }
        }
    }

    public void parsed(ByteArray byteArray, int i, int i2, String str) {
        ByteArray byteArray2 = byteArray;
        int i3 = i;
        int i4 = i2;
        String str2 = str;
        if (!this.suppressDump) {
            super.parsed(byteArray2, i3, i4, str2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldDumpMethod(String str) {
        return this.args.method == null || this.args.method.equals(str);
    }

    public void startParsingMember(ByteArray byteArray, int i, String str, String str2) {
        StringBuilder sb;
        ByteArray byteArray2 = byteArray;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        if (str4.indexOf(40) >= 0 && shouldDumpMethod(str3)) {
            setAt(byteArray2, i2);
            this.suppressDump = false;
            if (this.first) {
                this.first = false;
            } else {
                parsed(byteArray2, i2, 0, "\n");
            }
            ByteArray byteArray3 = byteArray2;
            int i3 = i2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            parsed(byteArray3, i3, 0, sb2.append("method ").append(str3).append(" ").append(str4).toString());
            this.suppressDump = true;
        }
    }
}

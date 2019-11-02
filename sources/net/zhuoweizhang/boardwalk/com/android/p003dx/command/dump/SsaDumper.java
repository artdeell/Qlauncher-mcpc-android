package net.zhuoweizhang.boardwalk.com.android.p003dx.command.dump;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.ConcreteMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Ropper;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Member;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Method;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.AccessFlags;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.DexTranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer.OptionalStep;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaBasicBlock;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dump.SsaDumper */
public class SsaDumper extends BlockDumper {
    private SsaDumper(byte[] bArr, PrintStream printStream, String str, Args args) {
        super(bArr, printStream, str, true, args);
    }

    public static void dump(byte[] bArr, PrintStream printStream, String str, Args args) {
        SsaDumper ssaDumper;
        SsaDumper ssaDumper2 = ssaDumper;
        SsaDumper ssaDumper3 = new SsaDumper(bArr, printStream, str, args);
        ssaDumper2.dump();
    }

    public void endParsingMember(ByteArray byteArray, int i, String str, String str2, Member member) {
        ConcreteMethod concreteMethod;
        SsaMethod ssaMethod;
        StringBuffer stringBuffer;
        StringBuilder sb;
        StringBuilder sb2;
        ByteArray byteArray2 = byteArray;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        Member member2 = member;
        if ((member2 instanceof Method) && shouldDumpMethod(str3) && (1280 & member2.getAccessFlags()) == 0) {
            ConcreteMethod concreteMethod2 = concreteMethod;
            ConcreteMethod concreteMethod3 = new ConcreteMethod((Method) member2, this.classFile, true, true);
            ConcreteMethod concreteMethod4 = concreteMethod2;
            DexTranslationAdvice dexTranslationAdvice = DexTranslationAdvice.THE_ONE;
            RopMethod convert = Ropper.convert(concreteMethod4, dexTranslationAdvice);
            boolean isStatic = AccessFlags.isStatic(concreteMethod4.getAccessFlags());
            int computeParamWidth = computeParamWidth(concreteMethod4, isStatic);
            if (this.args.ssaStep == null) {
                ssaMethod = Optimizer.debugNoRegisterAllocation(convert, computeParamWidth, isStatic, true, dexTranslationAdvice, EnumSet.allOf(OptionalStep.class));
            } else {
                if ("edge-split".equals(this.args.ssaStep)) {
                    ssaMethod = Optimizer.debugEdgeSplit(convert, computeParamWidth, isStatic, true, dexTranslationAdvice);
                } else {
                    if ("phi-placement".equals(this.args.ssaStep)) {
                        ssaMethod = Optimizer.debugPhiPlacement(convert, computeParamWidth, isStatic, true, dexTranslationAdvice);
                    } else {
                        if ("renaming".equals(this.args.ssaStep)) {
                            ssaMethod = Optimizer.debugRenaming(convert, computeParamWidth, isStatic, true, dexTranslationAdvice);
                        } else {
                            ssaMethod = "dead-code".equals(this.args.ssaStep) ? Optimizer.debugDeadCodeRemover(convert, computeParamWidth, isStatic, true, dexTranslationAdvice) : null;
                        }
                    }
                }
            }
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer(2000);
            StringBuffer stringBuffer4 = stringBuffer2;
            StringBuffer append = stringBuffer4.append("first ");
            StringBuffer append2 = stringBuffer4.append(Hex.m51u2(ssaMethod.blockIndexToRopLabel(ssaMethod.getEntryBlockIndex())));
            StringBuffer append3 = stringBuffer4.append(10);
            ArrayList arrayList = (ArrayList) ssaMethod.getBlocks().clone();
            Collections.sort(arrayList, SsaBasicBlock.LABEL_COMPARATOR);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) it.next();
                StringBuffer append4 = stringBuffer4.append("block ").append(Hex.m51u2(ssaBasicBlock.getRopLabel())).append(10);
                BitSet predecessors = ssaBasicBlock.getPredecessors();
                int nextSetBit = predecessors.nextSetBit(0);
                while (true) {
                    int i3 = nextSetBit;
                    if (i3 < 0) {
                        break;
                    }
                    StringBuffer append5 = stringBuffer4.append("  pred ");
                    StringBuffer append6 = stringBuffer4.append(Hex.m51u2(ssaMethod.blockIndexToRopLabel(i3)));
                    StringBuffer append7 = stringBuffer4.append(10);
                    nextSetBit = predecessors.nextSetBit(i3 + 1);
                }
                StringBuffer stringBuffer5 = stringBuffer4;
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                StringBuffer append8 = stringBuffer5.append(sb3.append("  live in:").append(ssaBasicBlock.getLiveInRegs()).toString());
                StringBuffer append9 = stringBuffer4.append("\n");
                Iterator it2 = ssaBasicBlock.getInsns().iterator();
                while (it2.hasNext()) {
                    SsaInsn ssaInsn = (SsaInsn) it2.next();
                    StringBuffer append10 = stringBuffer4.append("  ");
                    StringBuffer append11 = stringBuffer4.append(ssaInsn.toHuman());
                    StringBuffer append12 = stringBuffer4.append(10);
                }
                if (ssaBasicBlock.getSuccessors().cardinality() == 0) {
                    StringBuffer append13 = stringBuffer4.append("  returns\n");
                } else {
                    int primarySuccessorRopLabel = ssaBasicBlock.getPrimarySuccessorRopLabel();
                    IntList ropLabelSuccessorList = ssaBasicBlock.getRopLabelSuccessorList();
                    int size = ropLabelSuccessorList.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        StringBuffer append14 = stringBuffer4.append("  next ");
                        StringBuffer append15 = stringBuffer4.append(Hex.m51u2(ropLabelSuccessorList.get(i4)));
                        if (size != 1 && primarySuccessorRopLabel == ropLabelSuccessorList.get(i4)) {
                            StringBuffer append16 = stringBuffer4.append(" *");
                        }
                        StringBuffer append17 = stringBuffer4.append(10);
                    }
                }
                StringBuffer stringBuffer6 = stringBuffer4;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                StringBuffer append18 = stringBuffer6.append(sb5.append("  live out:").append(ssaBasicBlock.getLiveOutRegs()).toString());
                StringBuffer append19 = stringBuffer4.append("\n");
            }
            this.suppressDump = false;
            setAt(byteArray2, 0);
            parsed(byteArray2, 0, byteArray2.size(), stringBuffer4.toString());
            this.suppressDump = true;
        }
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.IntList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.LocalVariableExtractor */
public class LocalVariableExtractor {
    private final ArrayList<SsaBasicBlock> blocks;
    private final SsaMethod method;
    private final LocalVariableInfo resultInfo;
    private final BitSet workSet;

    private LocalVariableExtractor(SsaMethod ssaMethod) {
        LocalVariableInfo localVariableInfo;
        BitSet bitSet;
        NullPointerException nullPointerException;
        SsaMethod ssaMethod2 = ssaMethod;
        if (ssaMethod2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("method == null");
            throw nullPointerException2;
        }
        ArrayList blocks2 = ssaMethod2.getBlocks();
        this.method = ssaMethod2;
        this.blocks = blocks2;
        LocalVariableInfo localVariableInfo2 = localVariableInfo;
        LocalVariableInfo localVariableInfo3 = new LocalVariableInfo(ssaMethod2);
        this.resultInfo = localVariableInfo2;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(blocks2.size());
        this.workSet = bitSet2;
    }

    private LocalVariableInfo doit() {
        if (this.method.getRegCount() > 0) {
            int entryBlockIndex = this.method.getEntryBlockIndex();
            while (true) {
                int i = entryBlockIndex;
                if (i < 0) {
                    break;
                }
                this.workSet.clear(i);
                processBlock(i);
                entryBlockIndex = this.workSet.nextSetBit(0);
            }
        }
        this.resultInfo.setImmutable();
        return this.resultInfo;
    }

    public static LocalVariableInfo extract(SsaMethod ssaMethod) {
        LocalVariableExtractor localVariableExtractor;
        LocalVariableExtractor localVariableExtractor2 = localVariableExtractor;
        LocalVariableExtractor localVariableExtractor3 = new LocalVariableExtractor(ssaMethod);
        return localVariableExtractor2.doit();
    }

    private void processBlock(int i) {
        RegisterSpecSet registerSpecSet;
        RegisterSpecSet registerSpecSet2;
        int i2 = i;
        boolean z = true;
        RegisterSpecSet mutableCopyOfStarts = this.resultInfo.mutableCopyOfStarts(i2);
        SsaBasicBlock ssaBasicBlock = (SsaBasicBlock) this.blocks.get(i2);
        ArrayList insns = ssaBasicBlock.getInsns();
        int size = insns.size();
        if (i2 != this.method.getExitBlockIndex()) {
            SsaInsn ssaInsn = (SsaInsn) insns.get(size - 1);
            if (!(ssaInsn.getOriginalRopInsn().getCatches().size() != 0) || ssaInsn.getResult() == null) {
                z = false;
            }
            int i3 = size - 1;
            int i4 = 0;
            RegisterSpecSet registerSpecSet3 = mutableCopyOfStarts;
            while (true) {
                registerSpecSet = registerSpecSet3;
                if (i4 >= size) {
                    break;
                }
                if (!z || i4 != i3) {
                    registerSpecSet2 = registerSpecSet;
                } else {
                    registerSpecSet.setImmutable();
                    registerSpecSet2 = registerSpecSet.mutableCopy();
                }
                SsaInsn ssaInsn2 = (SsaInsn) insns.get(i4);
                RegisterSpec localAssignment = ssaInsn2.getLocalAssignment();
                if (localAssignment == null) {
                    RegisterSpec result = ssaInsn2.getResult();
                    if (!(result == null || registerSpecSet2.get(result.getReg()) == null)) {
                        registerSpecSet2.remove(registerSpecSet2.get(result.getReg()));
                    }
                } else {
                    RegisterSpec withSimpleType = localAssignment.withSimpleType();
                    if (!withSimpleType.equals(registerSpecSet2.get(withSimpleType))) {
                        RegisterSpec localItemToSpec = registerSpecSet2.localItemToSpec(withSimpleType.getLocalItem());
                        if (!(localItemToSpec == null || localItemToSpec.getReg() == withSimpleType.getReg())) {
                            registerSpecSet2.remove(localItemToSpec);
                        }
                        this.resultInfo.addAssignment(ssaInsn2, withSimpleType);
                        registerSpecSet2.put(withSimpleType);
                    }
                }
                i4++;
                registerSpecSet3 = registerSpecSet2;
            }
            registerSpecSet.setImmutable();
            IntList successorList = ssaBasicBlock.getSuccessorList();
            int size2 = successorList.size();
            int primarySuccessorIndex = ssaBasicBlock.getPrimarySuccessorIndex();
            for (int i5 = 0; i5 < size2; i5++) {
                int i6 = successorList.get(i5);
                if (this.resultInfo.mergeStarts(i6, i6 == primarySuccessorIndex ? registerSpecSet : mutableCopyOfStarts)) {
                    this.workSet.set(i6);
                }
            }
        }
    }
}

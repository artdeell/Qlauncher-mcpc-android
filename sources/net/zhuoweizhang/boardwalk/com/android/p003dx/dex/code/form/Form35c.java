package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.form;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.InsnFormat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.code.form.Form35c */
public final class Form35c extends InsnFormat {
    private static final int MAX_NUM_OPS = 5;
    public static final InsnFormat THE_ONE;

    static {
        Form35c form35c;
        Form35c form35c2 = form35c;
        Form35c form35c3 = new Form35c();
        THE_ONE = form35c2;
    }

    private Form35c() {
    }

    private static RegisterSpecList explicitize(RegisterSpecList registerSpecList) {
        RegisterSpecList registerSpecList2;
        RegisterSpecList registerSpecList3 = registerSpecList;
        int i = 0;
        int wordCount = wordCount(registerSpecList3);
        int size = registerSpecList3.size();
        if (wordCount == size) {
            return registerSpecList3;
        }
        RegisterSpecList registerSpecList4 = registerSpecList2;
        RegisterSpecList registerSpecList5 = new RegisterSpecList(wordCount);
        RegisterSpecList registerSpecList6 = registerSpecList4;
        for (int i2 = 0; i2 < size; i2++) {
            RegisterSpec registerSpec = registerSpecList3.get(i2);
            registerSpecList6.set(i, registerSpec);
            if (registerSpec.getCategory() == 2) {
                registerSpecList6.set(i + 1, RegisterSpec.make(1 + registerSpec.getReg(), Type.VOID));
                i += 2;
            } else {
                i++;
            }
        }
        registerSpecList6.setImmutable();
        return registerSpecList6;
    }

    private static int wordCount(RegisterSpecList registerSpecList) {
        RegisterSpecList registerSpecList2 = registerSpecList;
        int i = 0;
        int size = registerSpecList2.size();
        if (size <= 5) {
            int i2 = 0;
            while (i2 < size) {
                RegisterSpec registerSpec = registerSpecList2.get(i2);
                int category = i + registerSpec.getCategory();
                if (unsignedFitsInNibble(-1 + registerSpec.getReg() + registerSpec.getCategory())) {
                    i2++;
                    i = category;
                }
            }
            if (i > 5) {
                i = -1;
            }
            return i;
        }
        return -1;
    }

    public int codeSize() {
        return 3;
    }

    public BitSet compatibleRegs(DalvInsn dalvInsn) {
        BitSet bitSet;
        RegisterSpecList registers = dalvInsn.getRegisters();
        int size = registers.size();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(size);
        BitSet bitSet4 = bitSet2;
        for (int i = 0; i < size; i++) {
            RegisterSpec registerSpec = registers.get(i);
            bitSet4.set(i, unsignedFitsInNibble(-1 + registerSpec.getReg() + registerSpec.getCategory()));
        }
        return bitSet4;
    }

    public String insnArgString(DalvInsn dalvInsn) {
        StringBuilder sb;
        DalvInsn dalvInsn2 = dalvInsn;
        RegisterSpecList explicitize = explicitize(dalvInsn2.getRegisters());
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(regListString(explicitize)).append(", ").append(cstString(dalvInsn2)).toString();
    }

    public String insnCommentString(DalvInsn dalvInsn, boolean z) {
        return z ? cstComment(dalvInsn) : LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    public boolean isCompatible(DalvInsn dalvInsn) {
        DalvInsn dalvInsn2 = dalvInsn;
        if (dalvInsn2 instanceof CstInsn) {
            CstInsn cstInsn = (CstInsn) dalvInsn2;
            if (unsignedFitsInShort(cstInsn.getIndex())) {
                Constant constant = cstInsn.getConstant();
                if (((constant instanceof CstMethodRef) || (constant instanceof CstType)) && wordCount(cstInsn.getRegisters()) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void writeTo(AnnotatedOutput annotatedOutput, DalvInsn dalvInsn) {
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        DalvInsn dalvInsn2 = dalvInsn;
        int index = ((CstInsn) dalvInsn2).getIndex();
        RegisterSpecList explicitize = explicitize(dalvInsn2.getRegisters());
        int size = explicitize.size();
        write(annotatedOutput2, opcodeUnit(dalvInsn2, makeByte(size > 4 ? explicitize.get(4).getReg() : 0, size)), (short) index, codeUnit(size > 0 ? explicitize.get(0).getReg() : 0, size > 1 ? explicitize.get(1).getReg() : 0, size > 2 ? explicitize.get(2).getReg() : 0, size > 3 ? explicitize.get(3).getReg() : 0));
    }
}

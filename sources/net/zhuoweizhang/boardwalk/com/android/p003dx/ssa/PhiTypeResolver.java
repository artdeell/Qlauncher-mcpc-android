package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.BitSet;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.Merger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.PhiTypeResolver */
public class PhiTypeResolver {
    SsaMethod ssaMeth;
    private final BitSet worklist;

    private PhiTypeResolver(SsaMethod ssaMethod) {
        BitSet bitSet;
        SsaMethod ssaMethod2 = ssaMethod;
        this.ssaMeth = ssaMethod2;
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(ssaMethod2.getRegCount());
        this.worklist = bitSet2;
    }

    private static boolean equalsHandlesNulls(LocalItem localItem, LocalItem localItem2) {
        LocalItem localItem3 = localItem;
        LocalItem localItem4 = localItem2;
        return localItem3 == localItem4 || (localItem3 != null && localItem3.equals(localItem4));
    }

    public static void process(SsaMethod ssaMethod) {
        PhiTypeResolver phiTypeResolver;
        PhiTypeResolver phiTypeResolver2 = phiTypeResolver;
        PhiTypeResolver phiTypeResolver3 = new PhiTypeResolver(ssaMethod);
        phiTypeResolver2.run();
    }

    private void run() {
        int regCount = this.ssaMeth.getRegCount();
        for (int i = 0; i < regCount; i++) {
            SsaInsn definitionForRegister = this.ssaMeth.getDefinitionForRegister(i);
            if (definitionForRegister != null && definitionForRegister.getResult().getBasicType() == 0) {
                this.worklist.set(i);
            }
        }
        while (true) {
            int nextSetBit = this.worklist.nextSetBit(0);
            if (nextSetBit >= 0) {
                this.worklist.clear(nextSetBit);
                if (resolveResultType((PhiInsn) this.ssaMeth.getDefinitionForRegister(nextSetBit))) {
                    List useListForRegister = this.ssaMeth.getUseListForRegister(nextSetBit);
                    int size = useListForRegister.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        SsaInsn ssaInsn = (SsaInsn) useListForRegister.get(i2);
                        RegisterSpec result = ssaInsn.getResult();
                        if (result != null && (ssaInsn instanceof PhiInsn)) {
                            this.worklist.set(result.getReg());
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean resolveResultType(PhiInsn phiInsn) {
        RegisterSpec registerSpec;
        StringBuilder sb;
        RuntimeException runtimeException;
        StringBuilder sb2;
        PhiInsn phiInsn2 = phiInsn;
        phiInsn2.updateSourcesToDefinitions(this.ssaMeth);
        RegisterSpecList sources = phiInsn2.getSources();
        int i = -1;
        int size = sources.size();
        int i2 = 0;
        RegisterSpec registerSpec2 = null;
        while (true) {
            registerSpec = registerSpec2;
            if (i2 >= size) {
                break;
            }
            RegisterSpec registerSpec3 = sources.get(i2);
            if (registerSpec3.getBasicType() != 0) {
                i = i2;
            } else {
                registerSpec3 = registerSpec;
            }
            i2++;
            registerSpec2 = registerSpec3;
        }
        if (registerSpec != null) {
            LocalItem localItem = registerSpec.getLocalItem();
            TypeBearer type = registerSpec.getType();
            boolean z = true;
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 != i) {
                    RegisterSpec registerSpec4 = sources.get(i3);
                    if (registerSpec4.getBasicType() != 0) {
                        z = z && equalsHandlesNulls(localItem, registerSpec4.getLocalItem());
                        type = Merger.mergeType(type, registerSpec4.getType());
                    }
                }
            }
            if (type != null) {
                LocalItem localItem2 = z ? localItem : null;
                RegisterSpec result = phiInsn2.getResult();
                if (result.getTypeBearer() != type || !equalsHandlesNulls(localItem2, result.getLocalItem())) {
                    phiInsn2.changeResultType(type, localItem2);
                    return true;
                }
            } else {
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                StringBuilder sb5 = sb3;
                for (int i4 = 0; i4 < size; i4++) {
                    StringBuilder append = sb5.append(sources.get(i4).toString());
                    StringBuilder append2 = sb5.append(' ');
                }
                RuntimeException runtimeException2 = runtimeException;
                StringBuilder sb6 = sb2;
                StringBuilder sb7 = new StringBuilder();
                RuntimeException runtimeException3 = new RuntimeException(sb6.append("Couldn't map types in phi insn:").append(sb5).toString());
                throw runtimeException2;
            }
        }
        return false;
    }
}

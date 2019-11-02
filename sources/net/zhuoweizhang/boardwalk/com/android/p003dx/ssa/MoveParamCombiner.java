package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.HashSet;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.CstInsn;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.LocalItem;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.MoveParamCombiner */
public class MoveParamCombiner {
    /* access modifiers changed from: private */
    public final SsaMethod ssaMeth;

    private MoveParamCombiner(SsaMethod ssaMethod) {
        this.ssaMeth = ssaMethod;
    }

    /* access modifiers changed from: private */
    public int getParamIndex(NormalSsaInsn normalSsaInsn) {
        return ((CstInteger) ((CstInsn) normalSsaInsn.getOriginalRopInsn()).getConstant()).getValue();
    }

    public static void process(SsaMethod ssaMethod) {
        MoveParamCombiner moveParamCombiner;
        MoveParamCombiner moveParamCombiner2 = moveParamCombiner;
        MoveParamCombiner moveParamCombiner3 = new MoveParamCombiner(ssaMethod);
        moveParamCombiner2.run();
    }

    private void run() {
        HashSet hashSet;
        C07211 r9;
        RegisterSpec[] registerSpecArr = new RegisterSpec[this.ssaMeth.getParamWidth()];
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        SsaMethod ssaMethod = this.ssaMeth;
        C07211 r4 = r9;
        final RegisterSpec[] registerSpecArr2 = registerSpecArr;
        final HashSet hashSet5 = hashSet4;
        C07211 r5 = new Visitor(this) {
            final /* synthetic */ MoveParamCombiner this$0;

            {
                RegisterSpec[] registerSpecArr = r8;
                HashSet hashSet = r9;
                this.this$0 = r7;
            }

            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
            }

            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                C07221 r15;
                NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
                if (normalSsaInsn2.getOpcode().getOpcode() == 3) {
                    int access$000 = this.this$0.getParamIndex(normalSsaInsn2);
                    if (registerSpecArr2[access$000] == null) {
                        registerSpecArr2[access$000] = normalSsaInsn2.getResult();
                        return;
                    }
                    RegisterSpec registerSpec = registerSpecArr2[access$000];
                    RegisterSpec result = normalSsaInsn2.getResult();
                    LocalItem localItem = registerSpec.getLocalItem();
                    LocalItem localItem2 = result.getLocalItem();
                    if (localItem != null) {
                        if (localItem2 == null) {
                            localItem2 = localItem;
                        } else if (localItem.equals(localItem2)) {
                            localItem2 = localItem;
                        } else {
                            return;
                        }
                    }
                    this.this$0.ssaMeth.getDefinitionForRegister(registerSpec.getReg()).setResultLocal(localItem2);
                    C07221 r10 = r15;
                    final RegisterSpec registerSpec2 = result;
                    final RegisterSpec registerSpec3 = registerSpec;
                    C07221 r11 = new RegisterMapper(this) {
                        final /* synthetic */ C07211 this$1;

                        {
                            RegisterSpec registerSpec = r8;
                            RegisterSpec registerSpec2 = r9;
                            this.this$1 = r7;
                        }

                        public int getNewRegisterCount() {
                            return this.this$1.this$0.ssaMeth.getRegCount();
                        }

                        public RegisterSpec map(RegisterSpec registerSpec) {
                            RegisterSpec registerSpec2 = registerSpec;
                            if (registerSpec2.getReg() == registerSpec2.getReg()) {
                                registerSpec2 = registerSpec3;
                            }
                            return registerSpec2;
                        }
                    };
                    C07221 r7 = r10;
                    List useListForRegister = this.this$0.ssaMeth.getUseListForRegister(result.getReg());
                    for (int size = -1 + useListForRegister.size(); size >= 0; size--) {
                        ((SsaInsn) useListForRegister.get(size)).mapSourceRegisters(r7);
                    }
                    boolean add = hashSet5.add(normalSsaInsn2);
                }
            }

            public void visitPhiInsn(PhiInsn phiInsn) {
            }
        };
        ssaMethod.forEachInsn(r4);
        this.ssaMeth.deleteInsns(hashSet4);
    }
}

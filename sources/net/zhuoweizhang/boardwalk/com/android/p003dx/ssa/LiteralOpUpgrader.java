package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegOps;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rop;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.TranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeBearer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.SsaInsn.Visitor;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.LiteralOpUpgrader */
public class LiteralOpUpgrader {
    private final SsaMethod ssaMeth;

    private LiteralOpUpgrader(SsaMethod ssaMethod) {
        this.ssaMeth = ssaMethod;
    }

    /* access modifiers changed from: private */
    public static boolean isConstIntZeroOrKnownNull(RegisterSpec registerSpec) {
        TypeBearer typeBearer = registerSpec.getTypeBearer();
        if (typeBearer instanceof CstLiteralBits) {
            return ((CstLiteralBits) typeBearer).getLongBits() == 0;
        }
        return false;
    }

    public static void process(SsaMethod ssaMethod) {
        LiteralOpUpgrader literalOpUpgrader;
        LiteralOpUpgrader literalOpUpgrader2 = literalOpUpgrader;
        LiteralOpUpgrader literalOpUpgrader3 = new LiteralOpUpgrader(ssaMethod);
        literalOpUpgrader2.run();
    }

    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r12v2, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn] */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r10v19 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void replacePlainInsn(net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.NormalSsaInsn r19, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpecList r20, int r21, net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r10 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Insn r10 = r10.getOriginalRopInsn()
            r5 = r10
            r10 = r3
            r11 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r11 = r11.getResult()
            r12 = r2
            r13 = r4
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.Rop r10 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.Rops.ropFor(r10, r11, r12, r13)
            r6 = r10
            r10 = r4
            if (r10 != 0) goto L_0x006f
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn r10 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainInsn
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r6
            r13 = r5
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r13 = r13.getPosition()
            r14 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r14 = r14.getResult()
            r15 = r2
            r11.<init>(r12, r13, r14, r15)
            r7 = r10
        L_0x0038:
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn r10 = new net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r7
            r13 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r13 = r13.getBlock()
            r11.<init>(r12, r13)
            r8 = r10
            r10 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaBasicBlock r10 = r10.getBlock()
            java.util.ArrayList r10 = r10.getInsns()
            r9 = r10
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r10 = r10.ssaMeth
            r11 = r1
            r10.onInsnRemoved(r11)
            r10 = r9
            r11 = r9
            r12 = r1
            int r11 = r11.lastIndexOf(r12)
            r12 = r8
            java.lang.Object r10 = r10.set(r11, r12)
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.ssa.SsaMethod r10 = r10.ssaMeth
            r11 = r8
            r10.onInsnAdded(r11)
            return
        L_0x006f:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainCstInsn r10 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.code.PlainCstInsn
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r6
            r13 = r5
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r13 = r13.getPosition()
            r14 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpec r14 = r14.getResult()
            r15 = r2
            r16 = r4
            r11.<init>(r12, r13, r14, r15, r16)
            r7 = r10
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.LiteralOpUpgrader.replacePlainInsn(net.zhuoweizhang.boardwalk.com.android.dx.ssa.NormalSsaInsn, net.zhuoweizhang.boardwalk.com.android.dx.rop.code.RegisterSpecList, int, net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant):void");
    }

    private void run() {
        C07201 r7;
        TranslationAdvice advice = Optimizer.getAdvice();
        SsaMethod ssaMethod = this.ssaMeth;
        C07201 r3 = r7;
        final TranslationAdvice translationAdvice = advice;
        C07201 r4 = new Visitor(this) {
            final /* synthetic */ LiteralOpUpgrader this$0;

            {
                TranslationAdvice translationAdvice = r7;
                this.this$0 = r6;
            }

            public void visitMoveInsn(NormalSsaInsn normalSsaInsn) {
            }

            public void visitNonMoveInsn(NormalSsaInsn normalSsaInsn) {
                NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
                Rop opcode = normalSsaInsn2.getOriginalRopInsn().getOpcode();
                RegisterSpecList sources = normalSsaInsn2.getSources();
                if (this.this$0.tryReplacingWithConstant(normalSsaInsn2) || sources.size() != 2) {
                    return;
                }
                if (opcode.getBranchingness() == 4) {
                    if (LiteralOpUpgrader.isConstIntZeroOrKnownNull(sources.get(0))) {
                        this.this$0.replacePlainInsn(normalSsaInsn2, sources.withoutFirst(), RegOps.flippedIfOpcode(opcode.getOpcode()), null);
                    } else if (LiteralOpUpgrader.isConstIntZeroOrKnownNull(sources.get(1))) {
                        this.this$0.replacePlainInsn(normalSsaInsn2, sources.withoutLast(), opcode.getOpcode(), null);
                    }
                } else if (translationAdvice.hasConstantOperation(opcode, sources.get(0), sources.get(1))) {
                    normalSsaInsn2.upgradeToLiteral();
                } else if (opcode.isCommutative() && translationAdvice.hasConstantOperation(opcode, sources.get(1), sources.get(0))) {
                    normalSsaInsn2.setNewSources(RegisterSpecList.make(sources.get(1), sources.get(0)));
                    normalSsaInsn2.upgradeToLiteral();
                }
            }

            public void visitPhiInsn(PhiInsn phiInsn) {
            }
        };
        ssaMethod.forEachInsn(r3);
    }

    /* access modifiers changed from: private */
    public boolean tryReplacingWithConstant(NormalSsaInsn normalSsaInsn) {
        NormalSsaInsn normalSsaInsn2 = normalSsaInsn;
        Rop opcode = normalSsaInsn2.getOriginalRopInsn().getOpcode();
        RegisterSpec result = normalSsaInsn2.getResult();
        if (!(result == null || this.ssaMeth.isRegALocal(result) || opcode.getOpcode() == 5)) {
            TypeBearer typeBearer = normalSsaInsn2.getResult().getTypeBearer();
            if (typeBearer.isConstant() && typeBearer.getBasicType() == 6) {
                replacePlainInsn(normalSsaInsn2, RegisterSpecList.EMPTY, 5, (Constant) typeBearer);
                if (opcode.getOpcode() == 56) {
                    ArrayList insns = ((SsaBasicBlock) this.ssaMeth.getBlocks().get(normalSsaInsn2.getBlock().getPredecessors().nextSetBit(0))).getInsns();
                    replacePlainInsn((NormalSsaInsn) insns.get(-1 + insns.size()), RegisterSpecList.EMPTY, 6, null);
                }
                return true;
            }
        }
        return false;
    }
}

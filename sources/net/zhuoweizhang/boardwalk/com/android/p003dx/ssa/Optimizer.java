package net.zhuoweizhang.boardwalk.com.android.p003dx.ssa;

import java.util.EnumSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.TranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back.InterferenceGraph;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back.LivenessAnalyzer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.back.SsaToRop;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.Optimizer */
public class Optimizer {
    private static TranslationAdvice advice;
    private static boolean preserveLocals = true;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.ssa.Optimizer$OptionalStep */
    public enum OptionalStep {
    }

    public Optimizer() {
    }

    public static SsaMethod debugDeadCodeRemover(RopMethod ropMethod, int i, boolean z, boolean z2, TranslationAdvice translationAdvice) {
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        boolean z3 = z;
        TranslationAdvice translationAdvice2 = translationAdvice;
        preserveLocals = z2;
        advice = translationAdvice2;
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod2, i2, z3);
        DeadCodeRemover.process(convertToSsaMethod);
        return convertToSsaMethod;
    }

    public static SsaMethod debugEdgeSplit(RopMethod ropMethod, int i, boolean z, boolean z2, TranslationAdvice translationAdvice) {
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        boolean z3 = z;
        TranslationAdvice translationAdvice2 = translationAdvice;
        preserveLocals = z2;
        advice = translationAdvice2;
        return SsaConverter.testEdgeSplit(ropMethod2, i2, z3);
    }

    public static SsaMethod debugNoRegisterAllocation(RopMethod ropMethod, int i, boolean z, boolean z2, TranslationAdvice translationAdvice, EnumSet<OptionalStep> enumSet) {
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        boolean z3 = z;
        TranslationAdvice translationAdvice2 = translationAdvice;
        EnumSet<OptionalStep> enumSet2 = enumSet;
        preserveLocals = z2;
        advice = translationAdvice2;
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod2, i2, z3);
        runSsaFormSteps(convertToSsaMethod, enumSet2);
        InterferenceGraph constructInterferenceGraph = LivenessAnalyzer.constructInterferenceGraph(convertToSsaMethod);
        return convertToSsaMethod;
    }

    public static SsaMethod debugPhiPlacement(RopMethod ropMethod, int i, boolean z, boolean z2, TranslationAdvice translationAdvice) {
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        boolean z3 = z;
        TranslationAdvice translationAdvice2 = translationAdvice;
        preserveLocals = z2;
        advice = translationAdvice2;
        return SsaConverter.testPhiPlacement(ropMethod2, i2, z3);
    }

    public static SsaMethod debugRenaming(RopMethod ropMethod, int i, boolean z, boolean z2, TranslationAdvice translationAdvice) {
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        boolean z3 = z;
        TranslationAdvice translationAdvice2 = translationAdvice;
        preserveLocals = z2;
        advice = translationAdvice2;
        return SsaConverter.convertToSsaMethod(ropMethod2, i2, z3);
    }

    public static TranslationAdvice getAdvice() {
        return advice;
    }

    public static boolean getPreserveLocals() {
        return preserveLocals;
    }

    public static RopMethod optimize(RopMethod ropMethod, int i, boolean z, boolean z2, TranslationAdvice translationAdvice) {
        return optimize(ropMethod, i, z, z2, translationAdvice, EnumSet.allOf(OptionalStep.class));
    }

    public static RopMethod optimize(RopMethod ropMethod, int i, boolean z, boolean z2, TranslationAdvice translationAdvice, EnumSet<OptionalStep> enumSet) {
        RopMethod ropMethod2 = ropMethod;
        int i2 = i;
        boolean z3 = z;
        TranslationAdvice translationAdvice2 = translationAdvice;
        EnumSet<OptionalStep> enumSet2 = enumSet;
        preserveLocals = z2;
        advice = translationAdvice2;
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod2, i2, z3);
        runSsaFormSteps(convertToSsaMethod, enumSet2);
        RopMethod convertToRopMethod = SsaToRop.convertToRopMethod(convertToSsaMethod, false);
        if (convertToRopMethod.getBlocks().getRegCount() > advice.getMaxOptimalRegisterCount()) {
            convertToRopMethod = optimizeMinimizeRegisters(ropMethod2, i2, z3, enumSet2);
        }
        return convertToRopMethod;
    }

    private static RopMethod optimizeMinimizeRegisters(RopMethod ropMethod, int i, boolean z, EnumSet<OptionalStep> enumSet) {
        EnumSet<OptionalStep> enumSet2 = enumSet;
        SsaMethod convertToSsaMethod = SsaConverter.convertToSsaMethod(ropMethod, i, z);
        EnumSet clone = enumSet2.clone();
        boolean remove = clone.remove(OptionalStep.CONST_COLLECTOR);
        runSsaFormSteps(convertToSsaMethod, clone);
        return SsaToRop.convertToRopMethod(convertToSsaMethod, true);
    }

    private static void runSsaFormSteps(SsaMethod ssaMethod, EnumSet<OptionalStep> enumSet) {
        SsaMethod ssaMethod2 = ssaMethod;
        EnumSet<OptionalStep> enumSet2 = enumSet;
        boolean z = false;
        boolean z2 = true;
        if (enumSet2.contains(OptionalStep.MOVE_PARAM_COMBINER)) {
            MoveParamCombiner.process(ssaMethod2);
        }
        if (enumSet2.contains(OptionalStep.SCCP)) {
            SCCP.process(ssaMethod2);
            DeadCodeRemover.process(ssaMethod2);
            z2 = false;
        }
        if (enumSet2.contains(OptionalStep.LITERAL_UPGRADE)) {
            LiteralOpUpgrader.process(ssaMethod2);
            DeadCodeRemover.process(ssaMethod2);
            z2 = false;
        }
        boolean remove = enumSet2.remove(OptionalStep.ESCAPE_ANALYSIS);
        if (enumSet2.contains(OptionalStep.ESCAPE_ANALYSIS)) {
            EscapeAnalysis.process(ssaMethod2);
            DeadCodeRemover.process(ssaMethod2);
            z2 = false;
        }
        if (enumSet2.contains(OptionalStep.CONST_COLLECTOR)) {
            ConstCollector.process(ssaMethod2);
            DeadCodeRemover.process(ssaMethod2);
        } else {
            z = z2;
        }
        if (z) {
            DeadCodeRemover.process(ssaMethod2);
        }
        PhiTypeResolver.process(ssaMethod2);
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.p005cf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.EnumSet;
import java.util.HashSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.TranslationAdvice;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer;
import net.zhuoweizhang.boardwalk.com.android.p003dx.ssa.Optimizer.OptionalStep;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.cf.OptimizerOptions */
public class OptimizerOptions {
    private static HashSet<String> dontOptimizeList;
    private static HashSet<String> optimizeList;
    private static boolean optimizeListsLoaded;

    private OptimizerOptions() {
    }

    public static void compareOptimizerStep(RopMethod ropMethod, int i, boolean z, CfOptions cfOptions, TranslationAdvice translationAdvice, RopMethod ropMethod2) {
        RopMethod ropMethod3 = ropMethod;
        int i2 = i;
        boolean z2 = z;
        CfOptions cfOptions2 = cfOptions;
        TranslationAdvice translationAdvice2 = translationAdvice;
        RopMethod ropMethod4 = ropMethod2;
        EnumSet allOf = EnumSet.allOf(OptionalStep.class);
        boolean remove = allOf.remove(OptionalStep.CONST_COLLECTOR);
        RopMethod optimize = Optimizer.optimize(ropMethod3, i2, z2, cfOptions2.localInfo, translationAdvice2, allOf);
        int effectiveInstructionCount = ropMethod4.getBlocks().getEffectiveInstructionCount();
        int effectiveInstructionCount2 = optimize.getBlocks().getEffectiveInstructionCount();
        PrintStream printf = System.err.printf("optimize step regs:(%d/%d/%.2f%%) insns:(%d/%d/%.2f%%)\n", new Object[]{Integer.valueOf(ropMethod4.getBlocks().getRegCount()), Integer.valueOf(optimize.getBlocks().getRegCount()), Double.valueOf(100.0d * ((double) (((float) (optimize.getBlocks().getRegCount() - ropMethod4.getBlocks().getRegCount())) / ((float) optimize.getBlocks().getRegCount())))), Integer.valueOf(effectiveInstructionCount), Integer.valueOf(effectiveInstructionCount2), Double.valueOf(100.0d * ((double) (((float) (effectiveInstructionCount2 - effectiveInstructionCount)) / ((float) effectiveInstructionCount2))))});
    }

    public static void loadOptimizeLists(String str, String str2) {
        RuntimeException runtimeException;
        String str3 = str;
        String str4 = str2;
        if (!optimizeListsLoaded) {
            if (str3 == null || str4 == null) {
                if (str3 != null) {
                    optimizeList = loadStringsFromFile(str3);
                }
                if (str4 != null) {
                    dontOptimizeList = loadStringsFromFile(str4);
                }
                optimizeListsLoaded = true;
                return;
            }
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("optimize and don't optimize lists  are mutually exclusive.");
            throw runtimeException2;
        }
    }

    private static HashSet<String> loadStringsFromFile(String str) {
        HashSet hashSet;
        RuntimeException runtimeException;
        StringBuilder sb;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str2 = str;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        try {
            FileReader fileReader2 = fileReader;
            FileReader fileReader3 = new FileReader(str2);
            FileReader fileReader4 = fileReader2;
            BufferedReader bufferedReader2 = bufferedReader;
            BufferedReader bufferedReader3 = new BufferedReader(fileReader4);
            BufferedReader bufferedReader4 = bufferedReader2;
            while (true) {
                String readLine = bufferedReader4.readLine();
                if (readLine != null) {
                    boolean add = hashSet4.add(readLine);
                } else {
                    fileReader4.close();
                    return hashSet4;
                }
            }
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb2.append("Error with optimize list: ").append(str2).toString(), iOException);
            throw runtimeException2;
        }
    }

    public static boolean shouldOptimize(String str) {
        String str2 = str;
        boolean z = true;
        if (optimizeList != null) {
            z = optimizeList.contains(str2);
        } else if (dontOptimizeList != null && dontOptimizeList.contains(str2)) {
            return false;
        }
        return z;
    }
}

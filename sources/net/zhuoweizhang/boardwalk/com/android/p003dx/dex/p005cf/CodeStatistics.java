package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.p005cf;

import java.io.PrintStream;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RopMethod;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.cf.CodeStatistics */
public final class CodeStatistics {
    private static final boolean DEBUG = false;
    public static int dexRunningDeltaInsns = 0;
    public static int dexRunningDeltaRegisters = 0;
    public static int dexRunningTotalInsns = 0;
    public static int runningDeltaInsns = 0;
    public static int runningDeltaRegisters = 0;
    public static int runningOriginalBytes = 0;
    public static int runningTotalInsns = 0;

    private CodeStatistics() {
    }

    public static void dumpStatistics(PrintStream printStream) {
        PrintStream printStream2 = printStream;
        PrintStream printf = printStream2.printf("Optimizer Delta Rop Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", new Object[]{Integer.valueOf(runningDeltaInsns), Integer.valueOf(runningTotalInsns), Double.valueOf(100.0d * ((double) (((float) runningDeltaInsns) / ((float) (runningTotalInsns + Math.abs(runningDeltaInsns)))))), Integer.valueOf(runningDeltaRegisters)});
        PrintStream printf2 = printStream2.printf("Optimizer Delta Dex Insns: Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", new Object[]{Integer.valueOf(dexRunningDeltaInsns), Integer.valueOf(dexRunningTotalInsns), Double.valueOf(100.0d * ((double) (((float) dexRunningDeltaInsns) / ((float) (dexRunningTotalInsns + Math.abs(dexRunningDeltaInsns)))))), Integer.valueOf(dexRunningDeltaRegisters)});
        PrintStream printf3 = printStream2.printf("Original bytecode byte count: %d\n", new Object[]{Integer.valueOf(runningOriginalBytes)});
    }

    public static void updateDexStatistics(DalvCode dalvCode, DalvCode dalvCode2) {
        DalvCode dalvCode3 = dalvCode;
        DalvCode dalvCode4 = dalvCode2;
        dexRunningDeltaInsns += dalvCode4.getInsns().codeSize() - dalvCode3.getInsns().codeSize();
        dexRunningDeltaRegisters += dalvCode4.getInsns().getRegistersSize() - dalvCode3.getInsns().getRegistersSize();
        dexRunningTotalInsns += dalvCode4.getInsns().codeSize();
    }

    public static void updateOriginalByteCount(int i) {
        runningOriginalBytes = i + runningOriginalBytes;
    }

    public static void updateRopStatistics(RopMethod ropMethod, RopMethod ropMethod2) {
        RopMethod ropMethod3 = ropMethod;
        RopMethod ropMethod4 = ropMethod2;
        int effectiveInstructionCount = ropMethod3.getBlocks().getEffectiveInstructionCount();
        int regCount = ropMethod3.getBlocks().getRegCount();
        int effectiveInstructionCount2 = ropMethod4.getBlocks().getEffectiveInstructionCount();
        runningDeltaInsns += effectiveInstructionCount2 - effectiveInstructionCount;
        runningDeltaRegisters += ropMethod4.getBlocks().getRegCount() - regCount;
        runningTotalInsns = effectiveInstructionCount2 + runningTotalInsns;
    }
}

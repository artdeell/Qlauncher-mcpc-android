package org.lwjgl.util.mapped;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.util.glu.GLU;

final class CacheLineSize {
    private CacheLineSize() {
    }

    private static long doTest(int i, int i2, int i3, IntBuffer intBuffer, ExecutorCompletionService<Long> executorCompletionService) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        IntBuffer intBuffer2 = intBuffer;
        ExecutorCompletionService<Long> executorCompletionService2 = executorCompletionService;
        for (int i7 = 0; i7 < i4; i7++) {
            submitTest(executorCompletionService2, i7, i5, intBuffer2, i6);
        }
        return waitForResults(i4, executorCompletionService2);
    }

    static int getCacheLineSize() {
        ExecutorCompletionService executorCompletionService;
        boolean z;
        StringBuilder sb;
        StringBuilder sb2;
        int intValue = LWJGLUtil.getPrivilegedInteger("org.lwjgl.util.mapped.CacheLineMaxSize", 1024).intValue() / 4;
        double intValue2 = 1.0d + (((double) LWJGLUtil.getPrivilegedInteger("org.lwjgl.util.mapped.CacheLineTimeThreshold", 50).intValue()) / 100.0d);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        ExecutorCompletionService executorCompletionService2 = executorCompletionService;
        ExecutorCompletionService executorCompletionService3 = new ExecutorCompletionService(newFixedThreadPool);
        ExecutorCompletionService executorCompletionService4 = executorCompletionService2;
        try {
            IntBuffer memory = getMemory(intValue);
            for (int i = 0; i < 10; i++) {
                long doTest = doTest(2, GLU.GLU_SMOOTH, 0, memory, executorCompletionService4);
            }
            long j = 0;
            int i2 = 64;
            int i3 = intValue;
            int i4 = 0;
            while (true) {
                z = false;
                if (i3 < 1) {
                    break;
                }
                long doTest2 = doTest(2, GLU.GLU_SMOOTH, i3, memory, executorCompletionService4);
                if (j > 0) {
                    if (((double) doTest2) / ((double) (j / ((long) i4))) > intValue2) {
                        i2 = 4 * (i3 << 1);
                        z = true;
                        break;
                    }
                }
                j += doTest2;
                i4++;
                i3 >>= 1;
            }
            if (LWJGLUtil.DEBUG) {
                if (z) {
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    LWJGLUtil.log(sb3.append("Cache line size detected: ").append(i2).append(" bytes").toString());
                } else {
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    LWJGLUtil.log(sb5.append("Failed to detect cache line size, assuming ").append(i2).append(" bytes").toString());
                }
            }
            newFixedThreadPool.shutdown();
            return i2;
        } catch (Throwable th) {
            Throwable th2 = th;
            newFixedThreadPool.shutdown();
            throw th2;
        }
    }

    private static IntBuffer getMemory(int i) {
        int i2 = i;
        int pageSize = MappedObjectUnsafe.INSTANCE.pageSize();
        ByteBuffer order = ByteBuffer.allocateDirect(pageSize + (i2 * 4)).order(ByteOrder.nativeOrder());
        if (MemoryUtil.getAddress(order) % ((long) pageSize) != 0) {
            Buffer position = order.position(pageSize - ((int) (MemoryUtil.getAddress(order) & ((long) (pageSize - 1)))));
        }
        return order.asIntBuffer();
    }

    public static void main(String[] strArr) {
        String[] strArr2 = strArr;
        int cacheLineSize = CacheUtil.getCacheLineSize();
    }

    static long memoryLoop(int i, int i2, IntBuffer intBuffer, int i3) {
        int i4 = i2;
        long address = MemoryUtil.getAddress(intBuffer) + ((long) (4 * i * i3));
        long nanoTime = System.nanoTime();
        for (int i5 = 0; i5 < i4; i5++) {
            MappedHelper.ivput(1 + MappedHelper.ivget(address), address);
        }
        return System.nanoTime() - nanoTime;
    }

    private static void submitTest(ExecutorCompletionService<Long> executorCompletionService, int i, int i2, IntBuffer intBuffer, int i3) {
        C08491 r12;
        ExecutorCompletionService<Long> executorCompletionService2 = executorCompletionService;
        C08491 r6 = r12;
        final int i4 = i;
        final int i5 = i2;
        final IntBuffer intBuffer2 = intBuffer;
        final int i6 = i3;
        C08491 r7 = new Callable<Long>() {
            {
                int i = r9;
                IntBuffer intBuffer = r10;
                int i2 = r11;
            }

            public Long call() throws Exception {
                return Long.valueOf(CacheLineSize.memoryLoop(i4, i5, intBuffer2, i6));
            }
        };
        Future submit = executorCompletionService2.submit(r6);
    }

    private static long waitForResults(int i, ExecutorCompletionService<Long> executorCompletionService) {
        RuntimeException runtimeException;
        int i2 = i;
        ExecutorCompletionService<Long> executorCompletionService2 = executorCompletionService;
        long j = 0;
        int i3 = 0;
        while (i3 < i2) {
            try {
                j += ((Long) executorCompletionService2.take().get()).longValue();
                i3++;
            } catch (Exception e) {
                Exception exc = e;
                RuntimeException runtimeException2 = runtimeException;
                RuntimeException runtimeException3 = new RuntimeException(exc);
                throw runtimeException2;
            }
        }
        return j;
    }
}

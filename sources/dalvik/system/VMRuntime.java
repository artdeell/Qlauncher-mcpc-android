package dalvik.system;

public final class VMRuntime {
    private static final VMRuntime THE_ONE;

    static {
        VMRuntime vMRuntime;
        VMRuntime vMRuntime2 = vMRuntime;
        VMRuntime vMRuntime3 = new VMRuntime();
        THE_ONE = vMRuntime2;
    }

    private VMRuntime() {
    }

    public static VMRuntime getRuntime() {
        return THE_ONE;
    }

    private native long nativeMinimumHeapSize(long j, boolean z);

    private native void nativeSetTargetHeapUtilization(float f);

    public native void disableJitCompilation();

    public native void gcSoftReferences();

    @Deprecated
    public native long getExternalBytesAllocated();

    public long getMinimumHeapSize() {
        return nativeMinimumHeapSize(0, false);
    }

    public native float getTargetHeapUtilization();

    public native void runFinalizationSync();

    public long setMinimumHeapSize(long j) {
        long j2;
        long j3 = j;
        synchronized (this) {
            try {
                th = nativeMinimumHeapSize(j3, true);
            } finally {
                j2 = th;
                Throwable th = j2;
            }
        }
        return j2;
    }

    public float setTargetHeapUtilization(float f) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        float f2 = f;
        if (((double) f2) <= 0.0d || ((double) f2) >= 1.0d) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append(f2).append(" out of range (0,1)").toString());
            throw illegalArgumentException2;
        }
        synchronized (this) {
            try {
                th = getTargetHeapUtilization();
                nativeSetTargetHeapUtilization(f2);
            } finally {
                Throwable th = th;
                Throwable th2 = th;
            }
        }
        return th;
    }

    public native void startJitCompilation();

    @Deprecated
    public native boolean trackExternalAllocation(long j);

    @Deprecated
    public native void trackExternalFree(long j);
}

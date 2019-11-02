package org.lwjgl.opengl;

import org.lwjgl.Sys;

class Sync {
    private static final long NANOS_IN_SECOND = 1000000000;
    private static boolean initialised = false;
    private static long nextFrame = 0;
    private static RunningAvg sleepDurations;
    private static RunningAvg yieldDurations;

    private static class RunningAvg {
        private static final float DAMPEN_FACTOR = 0.9f;
        private static final long DAMPEN_THRESHOLD = 10000000;
        private int offset = 0;
        private final long[] slots;

        public RunningAvg(int i) {
            this.slots = new long[i];
        }

        public void add(long j) {
            long j2 = j;
            long[] jArr = this.slots;
            int i = this.offset;
            this.offset = i + 1;
            jArr[i % this.slots.length] = j2;
            this.offset %= this.slots.length;
        }

        public long avg() {
            long j = 0;
            for (int i = 0; i < this.slots.length; i++) {
                j += this.slots[i];
            }
            return j / ((long) this.slots.length);
        }

        public void dampenForLowResTicker() {
            if (avg() > DAMPEN_THRESHOLD) {
                for (int i = 0; i < this.slots.length; i++) {
                    long[] jArr = this.slots;
                    jArr[i] = (long) (DAMPEN_FACTOR * ((float) jArr[i]));
                }
            }
        }

        public void init(long j) {
            long j2 = j;
            while (this.offset < this.slots.length) {
                long[] jArr = this.slots;
                int i = this.offset;
                this.offset = i + 1;
                jArr[i] = j2;
            }
        }
    }

    static {
        RunningAvg runningAvg;
        RunningAvg runningAvg2;
        RunningAvg runningAvg3 = runningAvg;
        RunningAvg runningAvg4 = new RunningAvg(10);
        sleepDurations = runningAvg3;
        RunningAvg runningAvg5 = runningAvg2;
        RunningAvg runningAvg6 = new RunningAvg(10);
        yieldDurations = runningAvg5;
    }

    Sync() {
    }

    private static long getTime() {
        return (NANOS_IN_SECOND * Sys.getTime()) / Sys.getTimerResolution();
    }

    private static void initialise() {
        Thread thread;
        C08061 r8;
        initialised = true;
        sleepDurations.init(1000000);
        yieldDurations.init((long) ((int) (1.333d * ((double) (-(getTime() - getTime()))))));
        nextFrame = getTime();
        if (System.getProperty("os.name").startsWith("Win")) {
            Thread thread2 = thread;
            C08061 r3 = r8;
            C08061 r4 = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (Exception e) {
                        Exception exc = e;
                    }
                }
            };
            Thread thread3 = new Thread(r3);
            Thread thread4 = thread2;
            thread4.setName("LWJGL Timer");
            thread4.setDaemon(true);
            thread4.start();
        }
    }

    public static void sync(int i) {
        int i2 = i;
        if (i2 > 0) {
            if (!initialised) {
                initialise();
            }
            try {
                long time = getTime();
                while (nextFrame - time > sleepDurations.avg()) {
                    Thread.sleep(1);
                    RunningAvg runningAvg = sleepDurations;
                    long time2 = getTime();
                    runningAvg.add(time2 - time);
                    time = time2;
                }
                sleepDurations.dampenForLowResTicker();
                long time3 = getTime();
                while (true) {
                    long j = time3;
                    if (nextFrame - j <= yieldDurations.avg()) {
                        break;
                    }
                    Thread.yield();
                    RunningAvg runningAvg2 = yieldDurations;
                    long time4 = getTime();
                    runningAvg2.add(time4 - j);
                    time3 = time4;
                }
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
            nextFrame = Math.max(nextFrame + (NANOS_IN_SECOND / ((long) i2)), getTime());
        }
    }
}

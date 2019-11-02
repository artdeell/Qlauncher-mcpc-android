package org.lwjgl.util;

import org.lwjgl.Sys;

public class Timer {
    private static final int QUERY_INTERVAL = 50;
    private static long currentTime;
    private static int queryCount;
    private static long resolution = Sys.getTimerResolution();
    private long lastTime;
    private boolean paused;
    private long startTime;

    static {
        tick();
    }

    public Timer() {
        reset();
        resume();
    }

    public static void tick() {
        currentTime = Sys.getTime();
        queryCount = 1 + queryCount;
        if (queryCount > 50) {
            queryCount = 0;
            resolution = Sys.getTimerResolution();
        }
    }

    public float getTime() {
        if (!this.paused) {
            this.lastTime = currentTime - this.startTime;
        }
        return (float) (((double) this.lastTime) / ((double) resolution));
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void pause() {
        this.paused = true;
    }

    public void reset() {
        set(0.0f);
    }

    public void resume() {
        this.paused = false;
        this.startTime = currentTime - this.lastTime;
    }

    public void set(float f) {
        long j = (long) (((double) f) * ((double) resolution));
        this.startTime = currentTime - j;
        this.lastTime = j;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("Timer[Time=").append(getTime()).append(", Paused=").append(this.paused).append("]").toString();
    }
}

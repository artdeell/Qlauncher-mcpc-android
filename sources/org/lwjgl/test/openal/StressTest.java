package org.lwjgl.test.openal;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

public class StressTest extends BasicTest {
    private IntBuffer buffers;
    private IntBuffer sources;

    public StressTest() {
    }

    private void createBuffers() {
        this.buffers = BufferUtils.createIntBuffer(10);
        Buffer limit = this.buffers.position(0).limit(10);
        AL10.alGenBuffers(this.buffers);
        if (AL10.alGetError() != 0) {
            System.out.println("Unable to create 10 buffers");
            Buffer limit2 = this.sources.position(0).limit(4);
            AL10.alDeleteSources(this.sources);
            alExit();
        }
    }

    private void createSources() {
        this.sources = BufferUtils.createIntBuffer(4);
        Buffer limit = this.sources.position(0).limit(4);
        AL10.alGenSources(this.sources);
        if (AL10.alGetError() != 0) {
            System.out.println("Unable to create 4 sources");
            alExit();
        }
    }

    private int getRandomBuffer() {
        return (int) (10.0d * Math.random());
    }

    private void loadSamples() throws Exception {
        StringBuilder sb;
        int alGetError = AL10.alGetError();
        WaveData create = WaveData.create("ding.wav");
        for (int i = 1; i <= 10; i++) {
            AL10.alBufferData(this.buffers.get(i - 1), create.format, create.data, create.samplerate);
            if (AL10.alGetError() != 0) {
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("Failed to load ").append(i).append(".wav into buffer").toString());
                Buffer limit = this.sources.position(0).limit(4);
                AL10.alDeleteSources(this.sources);
                Buffer limit2 = this.buffers.position(0).limit(10);
                AL10.alDeleteBuffers(this.buffers);
                alExit();
            }
        }
        create.dispose();
    }

    public static void main(String[] strArr) {
        StressTest stressTest;
        String[] strArr2 = strArr;
        StressTest stressTest2 = stressTest;
        StressTest stressTest3 = new StressTest();
        stressTest2.execute(strArr2);
        System.exit(0);
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        String[] strArr2 = strArr;
        createSources();
        createBuffers();
        try {
            loadSamples();
            runTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        alExit();
    }

    public void runTest() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        StringBuilder sb9;
        StringBuilder sb10;
        StringBuilder sb11;
        int i = 0;
        int i2 = 1;
        long currentTimeMillis = System.currentTimeMillis();
        AL10.alSourcei(this.sources.get(0), 4103, 1);
        AL10.alSourcei(this.sources.get(0), 4105, this.buffers.get(0));
        AL10.alSourcePlay(this.sources.get(0));
        while (System.currentTimeMillis() - currentTimeMillis < 2000) {
            int randomBuffer = getRandomBuffer();
            PrintStream printStream = System.out;
            StringBuilder sb12 = sb5;
            StringBuilder sb13 = new StringBuilder();
            printStream.println(sb12.append("random:").append(randomBuffer).toString());
            AL10.alSourceStop(this.sources.get(i2));
            if (AL10.alGetError() != 0) {
                System.out.println("Error stopping source.");
            }
            PrintStream printStream2 = System.out;
            StringBuilder sb14 = sb6;
            StringBuilder sb15 = new StringBuilder();
            printStream2.println(sb14.append("Stopped source: ").append(i2).toString());
            AL10.alSourcei(this.sources.get(i2), 4105, this.buffers.get(randomBuffer));
            if (AL10.alGetError() != 0) {
                System.out.println("Error linking buffer and source.");
            }
            PrintStream printStream3 = System.out;
            StringBuilder sb16 = sb7;
            StringBuilder sb17 = new StringBuilder();
            printStream3.println(sb16.append("linked source ").append(i2).append(" with buffer ").append(randomBuffer).toString());
            PrintStream printStream4 = System.out;
            StringBuilder sb18 = sb8;
            StringBuilder sb19 = new StringBuilder();
            printStream4.println(sb18.append("playing source ").append(i2).toString());
            int i3 = i2 + 1;
            AL10.alSourcePlay(this.sources.get(i2));
            i2 = i3 == 4 ? 1 : i3;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                InterruptedException interruptedException = e;
            }
            i++;
            if (i % 10 == 0) {
                System.out.println("========================");
                PrintStream printStream5 = System.out;
                StringBuilder sb20 = sb9;
                StringBuilder sb21 = new StringBuilder();
                printStream5.println(sb20.append("MaxMemory: ").append(Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).toString());
                PrintStream printStream6 = System.out;
                StringBuilder sb22 = sb10;
                StringBuilder sb23 = new StringBuilder();
                printStream6.println(sb22.append("FreeMemory: ").append(Runtime.getRuntime().freeMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).toString());
                PrintStream printStream7 = System.out;
                StringBuilder sb24 = sb11;
                StringBuilder sb25 = new StringBuilder();
                printStream7.println(sb24.append("TotalMemory: ").append(Runtime.getRuntime().totalMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).toString());
                System.out.println("========================");
            }
        }
        for (int i4 = 0; i4 < 4; i4++) {
            AL10.alSourceStop(this.sources.get(i4));
            PrintStream printStream8 = System.out;
            StringBuilder sb26 = sb4;
            StringBuilder sb27 = new StringBuilder();
            printStream8.println(sb26.append("Stopping source ").append(i4 + 1).toString());
        }
        try {
            System.out.println("Test completed");
            System.out.println("========================");
            PrintStream printStream9 = System.out;
            StringBuilder sb28 = sb;
            StringBuilder sb29 = new StringBuilder();
            printStream9.println(sb28.append("MaxMemory: ").append(Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).toString());
            PrintStream printStream10 = System.out;
            StringBuilder sb30 = sb2;
            StringBuilder sb31 = new StringBuilder();
            printStream10.println(sb30.append("FreeMemory: ").append(Runtime.getRuntime().freeMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).toString());
            PrintStream printStream11 = System.out;
            StringBuilder sb32 = sb3;
            StringBuilder sb33 = new StringBuilder();
            printStream11.println(sb32.append("TotalMemory: ").append(Runtime.getRuntime().totalMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID).toString());
            System.out.println("========================");
            System.out.println("Push any key to exit...");
            int read = System.in.read();
        } catch (Exception e2) {
            Exception exc = e2;
        }
        Buffer limit = this.sources.position(0).limit(4);
        AL10.alDeleteSources(this.sources);
        Buffer limit2 = this.buffers.position(0).limit(10);
        AL10.alDeleteBuffers(this.buffers);
    }
}

package org.lwjgl.test;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.LWJGLException;
import org.lwjgl.util.WaveData;

public class WaveDataTest {
    String filePath = "Footsteps.wav";

    public WaveDataTest() {
    }

    private void executeBrokenCreationTest() {
        if (WaveData.create(LibrariesRepository.MOJANG_MAVEN_REPO) == null) {
            System.out.println("executeBrokenCreationTest::success");
        }
    }

    private void executeCreationTest() {
        if (WaveData.create(this.filePath) != null) {
            System.out.println("executeCreationTest::success");
        }
    }

    private void executeMidStreamCreationTest() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(WaveDataTest.class.getClassLoader().getResource(this.filePath));
            long skip = audioInputStream.skip((long) ((((audioInputStream.getFormat().getChannels() * ((int) audioInputStream.getFrameLength())) * audioInputStream.getFormat().getSampleSizeInBits()) / 8) / 4));
            if (WaveData.create(audioInputStream) == null) {
                System.out.println("executeMidStreamCreationTest::success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeStreamCreationTest() {
        File file;
        try {
            File file2 = file;
            File file3 = new File(this.filePath);
            if (WaveData.create(AudioSystem.getAudioInputStream(file2)) == null) {
                System.out.println("executeMidStreamCreationTest::success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] strArr) throws LWJGLException {
        WaveDataTest waveDataTest;
        String[] strArr2 = strArr;
        WaveDataTest waveDataTest2 = waveDataTest;
        WaveDataTest waveDataTest3 = new WaveDataTest();
        waveDataTest2.executeTest();
        System.exit(0);
    }

    private void pause(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
        }
    }

    public void executeTest() throws LWJGLException {
        executeCreationTest();
        executeBrokenCreationTest();
        executeMidStreamCreationTest();
    }
}

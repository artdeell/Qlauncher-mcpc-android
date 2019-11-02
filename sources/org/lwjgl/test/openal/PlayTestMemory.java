package org.lwjgl.test.openal;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

public class PlayTestMemory extends BasicTest {
    private boolean usingVorbis;

    public PlayTestMemory() {
    }

    public static void main(String[] strArr) {
        PlayTestMemory playTestMemory;
        String[] strArr2 = strArr;
        PlayTestMemory playTestMemory2 = playTestMemory;
        PlayTestMemory playTestMemory3 = new PlayTestMemory();
        playTestMemory2.execute(strArr2);
        System.exit(0);
    }

    /* access modifiers changed from: protected */
    public void execute(String[] strArr) {
        StringBuilder sb;
        StringBuilder sb2;
        String[] strArr2 = strArr;
        if (strArr2.length < 1) {
            System.out.println("no argument supplied, assuming Footsteps.wav");
            strArr2 = new String[1];
            strArr2[0] = "Footsteps.wav";
        }
        if (strArr2[0].endsWith(".ogg")) {
            System.out.print("Attempting to load Ogg Vorbis file, checking for extension...");
            if (AL10.alIsExtensionPresent("AL_EXT_vorbis")) {
                System.out.println("found");
                this.usingVorbis = true;
            } else {
                System.out.println("not supported");
                alExit();
                System.exit(-1);
            }
        }
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(1);
        IntBuffer createIntBuffer2 = BufferUtils.createIntBuffer(1);
        Buffer limit = createIntBuffer.position(0).limit(1);
        AL10.alGenBuffers(createIntBuffer);
        int alGetError = AL10.alGetError();
        if (alGetError != 0) {
            exit(alGetError);
        }
        Buffer limit2 = createIntBuffer2.position(0).limit(1);
        AL10.alGenSources(createIntBuffer2);
        int alGetError2 = AL10.alGetError();
        if (alGetError2 != 0) {
            exit(alGetError2);
        }
        ByteBuffer data = getData(strArr2[0]);
        if (data == null) {
            PrintStream printStream = System.out;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            printStream.println(sb3.append("Error loading file: ").append(strArr2[0]).toString());
            System.exit(-1);
        }
        PrintStream printStream2 = System.out;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        printStream2.println(sb5.append("loaded ").append(data.capacity()).toString());
        if (this.usingVorbis) {
            AL10.alBufferData(createIntBuffer.get(0), (int) AL10.AL_FORMAT_VORBIS_EXT, data, -1);
            Buffer clear = data.clear();
        } else {
            WaveData create = WaveData.create(data.array());
            AL10.alBufferData(createIntBuffer.get(0), create.format, create.data, create.samplerate);
            create.dispose();
        }
        int alGetError3 = AL10.alGetError();
        if (alGetError3 != 0) {
            exit(alGetError3);
        }
        AL10.alSourcei(createIntBuffer2.get(0), 4105, createIntBuffer.get(0));
        int alGetError4 = AL10.alGetError();
        if (alGetError4 != 0) {
            exit(alGetError4);
        }
        AL10.alSourcei(createIntBuffer2.get(0), 4103, 1);
        int alGetError5 = AL10.alGetError();
        if (alGetError5 != 0) {
            exit(alGetError5);
        }
        AL10.alSourcePlay(createIntBuffer2.get(0));
        int alGetError6 = AL10.alGetError();
        if (alGetError6 != 0) {
            exit(alGetError6);
        }
        try {
            System.out.println("Waiting 5 seconds for sound to complete");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
        }
        AL10.alSourceStop(createIntBuffer2.get(0));
        int alGetError7 = AL10.alGetError();
        if (alGetError7 != 0) {
            exit(alGetError7);
        }
        Buffer limit3 = createIntBuffer2.position(0).limit(1);
        AL10.alDeleteSources(createIntBuffer2);
        int alGetError8 = AL10.alGetError();
        if (alGetError8 != 0) {
            exit(alGetError8);
        }
        Buffer limit4 = createIntBuffer.position(0).limit(1);
        AL10.alDeleteBuffers(createIntBuffer);
        int alGetError9 = AL10.alGetError();
        if (alGetError9 != 0) {
            exit(alGetError9);
        }
        alExit();
    }

    /* access modifiers changed from: protected */
    public ByteBuffer getData(String str) {
        StringBuilder sb;
        BufferedInputStream bufferedInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2 = str;
        PrintStream printStream = System.out;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        printStream.println(sb2.append("Attempting to load: ").append(str2).toString());
        try {
            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(WaveData.class.getClassLoader().getResourceAsStream(str2));
            BufferedInputStream bufferedInputStream4 = bufferedInputStream2;
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
            byte[] bArr = new byte[4096];
            while (true) {
                int read = bufferedInputStream4.read(bArr, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream4.write(bArr, 0, read);
            }
            bufferedInputStream4.close();
            ByteBuffer allocate = this.usingVorbis ? ByteBuffer.allocateDirect(byteArrayOutputStream4.size()) : ByteBuffer.allocate(byteArrayOutputStream4.size());
            ByteBuffer order = allocate.order(ByteOrder.nativeOrder());
            ByteBuffer put = allocate.put(byteArrayOutputStream4.toByteArray());
            Buffer rewind = allocate.rewind();
            return allocate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

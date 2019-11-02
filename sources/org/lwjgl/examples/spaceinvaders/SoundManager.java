package org.lwjgl.examples.spaceinvaders;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.util.WaveData;

public class SoundManager {
    private int bufferIndex;
    private int[] buffers = new int[256];
    private IntBuffer scratchBuffer = BufferUtils.createIntBuffer(256);
    private boolean soundOutput;
    private int sourceIndex;
    private int[] sources;

    public SoundManager() {
    }

    public int addSound(String str) {
        StringBuilder sb;
        String str2 = str;
        Buffer limit = this.scratchBuffer.rewind().position(0).limit(1);
        AL10.alGenBuffers(this.scratchBuffer);
        this.buffers[this.bufferIndex] = this.scratchBuffer.get(0);
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        WaveData create = WaveData.create(sb2.append("spaceinvaders/").append(str2).toString());
        AL10.alBufferData(this.buffers[this.bufferIndex], create.format, create.data, create.samplerate);
        create.dispose();
        int i = this.bufferIndex;
        this.bufferIndex = i + 1;
        return i;
    }

    public void destroy() {
        if (this.soundOutput) {
            Buffer limit = this.scratchBuffer.position(0).limit(this.sources.length);
            Buffer flip = this.scratchBuffer.put(this.sources).flip();
            AL10.alSourceStop(this.scratchBuffer);
            AL10.alDeleteSources(this.scratchBuffer);
            Buffer limit2 = this.scratchBuffer.position(0).limit(this.bufferIndex);
            Buffer flip2 = this.scratchBuffer.put(this.buffers, 0, this.bufferIndex).flip();
            AL10.alDeleteBuffers(this.scratchBuffer);
            C0758AL.destroy();
        }
    }

    public void initialize(int i) {
        LWJGLException lWJGLException;
        StringBuilder sb;
        int i2 = i;
        try {
            C0758AL.create();
            Buffer limit = this.scratchBuffer.limit(i2);
            AL10.alGenSources(this.scratchBuffer);
            Buffer rewind = this.scratchBuffer.rewind();
            IntBuffer intBuffer = this.scratchBuffer;
            int[] iArr = new int[i2];
            this.sources = iArr;
            IntBuffer intBuffer2 = intBuffer.get(iArr);
            if (AL10.alGetError() != 0) {
                LWJGLException lWJGLException2 = lWJGLException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLException lWJGLException3 = new LWJGLException(sb2.append("Unable to allocate ").append(i2).append(" sources").toString());
                throw lWJGLException2;
            }
            this.soundOutput = true;
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.out.println("Sound disabled");
        }
    }

    public boolean isPlayingSound() {
        return AL10.alGetSourcei(this.sources[-1 + this.sources.length], 4112) == 4114;
    }

    public void playEffect(int i) {
        int i2 = i;
        if (this.soundOutput) {
            int[] iArr = this.sources;
            int i3 = this.sourceIndex;
            this.sourceIndex = i3 + 1;
            int i4 = iArr[i3 % (-1 + this.sources.length)];
            AL10.alSourcei(i4, 4105, this.buffers[i2]);
            AL10.alSourcePlay(i4);
        }
    }

    public void playSound(int i) {
        int i2 = i;
        if (this.soundOutput) {
            AL10.alSourcei(this.sources[-1 + this.sources.length], 4105, this.buffers[i2]);
            AL10.alSourcePlay(this.sources[-1 + this.sources.length]);
        }
    }
}

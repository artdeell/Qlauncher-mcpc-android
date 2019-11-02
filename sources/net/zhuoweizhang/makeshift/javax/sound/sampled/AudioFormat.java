package net.zhuoweizhang.makeshift.javax.sound.sampled;

public class AudioFormat {
    protected boolean bigEndian;
    protected int channels;
    protected float sampleRate;
    protected int sampleSizeInBits;
    protected boolean signed;

    public AudioFormat(float f, int i, int i2, boolean z, boolean z2) {
        int i3 = i;
        int i4 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        this.sampleRate = f;
        this.sampleSizeInBits = i3;
        this.channels = i4;
        this.signed = z3;
        this.bigEndian = z4;
    }

    public int getChannels() {
        return this.channels;
    }

    public float getSampleRate() {
        return this.sampleRate;
    }

    public int getSampleSizeInBits() {
        return this.sampleSizeInBits;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }
}

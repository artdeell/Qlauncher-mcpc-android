package org.lwjgl.util;

import com.sun.media.sound.WaveFileReader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import org.lwjgl.LWJGLUtil;

public class WaveData {
    static final /* synthetic */ boolean $assertionsDisabled = (!WaveData.class.desiredAssertionStatus());
    public final ByteBuffer data;
    public final int format;
    public final int samplerate;

    private WaveData(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.data = byteBuffer;
        this.format = i3;
        this.samplerate = i4;
    }

    private static ByteBuffer convertAudioBytes(byte[] bArr, boolean z, ByteOrder byteOrder) {
        byte[] bArr2 = bArr;
        boolean z2 = z;
        ByteOrder byteOrder2 = byteOrder;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr2.length);
        ByteBuffer order = allocateDirect.order(ByteOrder.nativeOrder());
        ByteBuffer wrap = ByteBuffer.wrap(bArr2);
        ByteBuffer order2 = wrap.order(byteOrder2);
        if (z2) {
            ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
            ShortBuffer asShortBuffer2 = wrap.asShortBuffer();
            while (asShortBuffer2.hasRemaining()) {
                ShortBuffer put = asShortBuffer.put(asShortBuffer2.get());
            }
        } else {
            while (wrap.hasRemaining()) {
                ByteBuffer put2 = allocateDirect.put(wrap.get());
            }
        }
        Buffer rewind = allocateDirect.rewind();
        return allocateDirect;
    }

    public static WaveData create(InputStream inputStream) {
        StringBuilder sb;
        try {
            return create(AudioSystem.getAudioInputStream(inputStream));
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Unable to create from inputstream, ").append(exc.getMessage()).toString());
            return null;
        }
    }

    public static WaveData create(String str) {
        return create(Thread.currentThread().getContextClassLoader().getResource(str));
    }

    public static WaveData create(URL url) {
        StringBuilder sb;
        WaveFileReader waveFileReader;
        BufferedInputStream bufferedInputStream;
        URL url2 = url;
        try {
            WaveFileReader waveFileReader2 = waveFileReader;
            WaveFileReader waveFileReader3 = new WaveFileReader();
            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(url2.openStream());
            return create(waveFileReader2.getAudioInputStream(bufferedInputStream2));
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Unable to create from: ").append(url2).append(", ").append(exc.getMessage()).toString());
            return null;
        }
    }

    public static WaveData create(ByteBuffer byteBuffer) {
        StringBuilder sb;
        byte[] bArr;
        ByteBuffer byteBuffer2 = byteBuffer;
        try {
            if (byteBuffer2.hasArray()) {
                bArr = byteBuffer2.array();
            } else {
                bArr = new byte[byteBuffer2.capacity()];
                ByteBuffer byteBuffer3 = byteBuffer2.get(bArr);
            }
            return create(bArr);
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Unable to create from ByteBuffer, ").append(exc.getMessage()).toString());
            return null;
        }
    }

    public static WaveData create(AudioInputStream audioInputStream) {
        int i;
        AssertionError assertionError;
        AssertionError assertionError2;
        WaveData waveData;
        AssertionError assertionError3;
        AudioInputStream audioInputStream2 = audioInputStream;
        AudioFormat format2 = audioInputStream2.getFormat();
        if (format2.getChannels() == 1) {
            if (format2.getSampleSizeInBits() == 8) {
                i = 4352;
            } else if (format2.getSampleSizeInBits() == 16) {
                i = 4353;
            } else {
                i = 0;
                if (!$assertionsDisabled) {
                    AssertionError assertionError4 = assertionError3;
                    AssertionError assertionError5 = new AssertionError("Illegal sample size");
                    throw assertionError4;
                }
            }
        } else if (format2.getChannels() != 2) {
            i = 0;
            if (!$assertionsDisabled) {
                AssertionError assertionError6 = assertionError;
                AssertionError assertionError7 = new AssertionError("Only mono or stereo is supported");
                throw assertionError6;
            }
        } else if (format2.getSampleSizeInBits() == 8) {
            i = 4354;
        } else if (format2.getSampleSizeInBits() == 16) {
            i = 4355;
        } else {
            i = 0;
            if (!$assertionsDisabled) {
                AssertionError assertionError8 = assertionError2;
                AssertionError assertionError9 = new AssertionError("Illegal sample size");
                throw assertionError8;
            }
        }
        try {
            if (audioInputStream2.available() <= 0) {
                int channels = ((audioInputStream2.getFormat().getChannels() * ((int) audioInputStream2.getFrameLength())) * audioInputStream2.getFormat().getSampleSizeInBits()) / 8;
            }
            byte[] bArr = new byte[audioInputStream2.available()];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                int read = audioInputStream2.read(bArr, i3, bArr.length - i3);
                if (read != -1 && i3 < bArr.length) {
                    i2 = i3 + read;
                }
            }
            WaveData waveData2 = waveData;
            WaveData waveData3 = new WaveData(convertAudioBytes(bArr, format2.getSampleSizeInBits() == 16, format2.isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN), i, (int) format2.getSampleRate());
            WaveData waveData4 = waveData2;
            try {
                audioInputStream2.close();
                return waveData4;
            } catch (IOException e) {
                IOException iOException = e;
                return waveData4;
            }
        } catch (IOException e2) {
            IOException iOException2 = e2;
            return null;
        }
    }

    public static WaveData create(byte[] bArr) {
        StringBuilder sb;
        BufferedInputStream bufferedInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
            ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(bArr);
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(byteArrayInputStream2);
            return create(AudioSystem.getAudioInputStream(bufferedInputStream2));
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Unable to create from byte array, ").append(exc.getMessage()).toString());
            return null;
        }
    }

    public void dispose() {
        Buffer clear = this.data.clear();
    }
}

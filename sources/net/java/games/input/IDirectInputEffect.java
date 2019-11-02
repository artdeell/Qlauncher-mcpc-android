package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;

final class IDirectInputEffect implements Rumbler {
    private final long address;
    private final DIEffectInfo info;
    private boolean released;

    public IDirectInputEffect(long j, DIEffectInfo dIEffectInfo) {
        DIEffectInfo dIEffectInfo2 = dIEffectInfo;
        this.address = j;
        this.info = dIEffectInfo2;
    }

    private final void checkReleased() throws IOException {
        IOException iOException;
        if (this.released) {
            IOException iOException2 = iOException;
            IOException iOException3 = new IOException();
            throw iOException2;
        }
    }

    private static final native void nRelease(long j);

    private static final native int nSetGain(long j, int i);

    private static final native int nStart(long j, int i, int i2);

    private static final native int nStop(long j);

    private final void setGain(int i) throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int i2 = i;
        int nSetGain = nSetGain(this.address, i2);
        if (nSetGain != 3 && nSetGain != 4 && nSetGain != 0 && nSetGain != 8 && nSetGain != 12) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to set effect gain (0x").append(Integer.toHexString(nSetGain)).append(")").toString());
            throw iOException2;
        }
    }

    private final void start(int i, int i2) throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int i3 = i;
        int i4 = i2;
        int nStart = nStart(this.address, i3, i4);
        if (nStart != 0) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to start effect (0x").append(Integer.toHexString(nStart)).append(")").toString());
            throw iOException2;
        }
    }

    private final void stop() throws IOException {
        IOException iOException;
        StringBuffer stringBuffer;
        int nStop = nStop(this.address);
        if (nStop != 0) {
            IOException iOException2 = iOException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            IOException iOException3 = new IOException(stringBuffer2.append("Failed to stop effect (0x").append(Integer.toHexString(nStop)).append(")").toString());
            throw iOException2;
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        release();
    }

    public final Identifier getAxisIdentifier() {
        return null;
    }

    public final String getAxisName() {
        return null;
    }

    public final void release() {
        synchronized (this) {
            try {
                if (!this.released) {
                    this.released = true;
                    nRelease(this.address);
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }

    public final void rumble(float f) {
        StringBuffer stringBuffer;
        float f2 = f;
        synchronized (this) {
            try {
                checkReleased();
                if (f2 > 0.0f) {
                    setGain(Math.round(10000.0f * f2));
                    start(1, 0);
                } else {
                    stop();
                }
            } catch (IOException e) {
                IOException iOException = e;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                DirectInputEnvironmentPlugin.logln(stringBuffer2.append("Failed to set rumbler gain: ").append(iOException.getMessage()).toString());
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
    }
}

package net.java.games.input;

import java.io.IOException;
import net.java.games.input.Component.Identifier;

abstract class LinuxForceFeedbackEffect implements Rumbler {
    private final LinuxEventDevice device;
    private final int ff_id = this.upload_task.doUpload(-1, 0.0f);
    private final UploadTask upload_task;
    private final WriteTask write_task;

    /* renamed from: net.java.games.input.LinuxForceFeedbackEffect$1 */
    static class C06221 {
    }

    private final class UploadTask extends LinuxDeviceTask {

        /* renamed from: id */
        private int f155id;
        private float intensity;
        private final LinuxForceFeedbackEffect this$0;

        private UploadTask(LinuxForceFeedbackEffect linuxForceFeedbackEffect) {
            this.this$0 = linuxForceFeedbackEffect;
        }

        UploadTask(LinuxForceFeedbackEffect linuxForceFeedbackEffect, C06221 r7) {
            C06221 r2 = r7;
            this(linuxForceFeedbackEffect);
        }

        public final int doUpload(int i, float f) throws IOException {
            float f2 = f;
            this.f155id = i;
            this.intensity = f2;
            Object execute = LinuxEnvironmentPlugin.execute(this);
            return this.f155id;
        }

        /* access modifiers changed from: protected */
        public final Object execute() throws IOException {
            this.f155id = this.this$0.upload(this.f155id, this.intensity);
            return null;
        }
    }

    private final class WriteTask extends LinuxDeviceTask {
        private final LinuxForceFeedbackEffect this$0;
        private int value;

        private WriteTask(LinuxForceFeedbackEffect linuxForceFeedbackEffect) {
            this.this$0 = linuxForceFeedbackEffect;
        }

        WriteTask(LinuxForceFeedbackEffect linuxForceFeedbackEffect, C06221 r7) {
            C06221 r2 = r7;
            this(linuxForceFeedbackEffect);
        }

        /* access modifiers changed from: protected */
        public final Object execute() throws IOException {
            LinuxForceFeedbackEffect.access$300(this.this$0).writeEvent(21, LinuxForceFeedbackEffect.access$200(this.this$0), this.value);
            return null;
        }

        public final void write(int i) throws IOException {
            this.value = i;
            Object execute = LinuxEnvironmentPlugin.execute(this);
        }
    }

    public LinuxForceFeedbackEffect(LinuxEventDevice linuxEventDevice) throws IOException {
        WriteTask writeTask;
        UploadTask uploadTask;
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        WriteTask writeTask2 = writeTask;
        WriteTask writeTask3 = new WriteTask(this, null);
        this.write_task = writeTask2;
        UploadTask uploadTask2 = uploadTask;
        UploadTask uploadTask3 = new UploadTask(this, null);
        this.upload_task = uploadTask2;
        this.device = linuxEventDevice2;
    }

    static int access$200(LinuxForceFeedbackEffect linuxForceFeedbackEffect) {
        return linuxForceFeedbackEffect.ff_id;
    }

    static LinuxEventDevice access$300(LinuxForceFeedbackEffect linuxForceFeedbackEffect) {
        return linuxForceFeedbackEffect.device;
    }

    public final Identifier getAxisIdentifier() {
        return null;
    }

    public final String getAxisName() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final LinuxEventDevice getDevice() {
        return this.device;
    }

    public final void rumble(float f) {
        StringBuffer stringBuffer;
        float f2 = f;
        synchronized (this) {
            if (f2 > 0.0f) {
                try {
                    int doUpload = this.upload_task.doUpload(this.ff_id, f2);
                    this.write_task.write(1);
                } catch (IOException e) {
                    IOException iOException = e;
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    LinuxEnvironmentPlugin.logln(stringBuffer2.append("Failed to rumble: ").append(iOException).toString());
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            } else {
                this.write_task.write(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract int upload(int i, float f) throws IOException;
}

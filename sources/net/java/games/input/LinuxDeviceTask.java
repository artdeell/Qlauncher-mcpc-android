package net.java.games.input;

import java.io.IOException;

abstract class LinuxDeviceTask {
    public static final int COMPLETED = 2;
    public static final int FAILED = 3;
    public static final int INPROGRESS = 1;
    private IOException exception;
    private Object result;
    private int state = 1;

    LinuxDeviceTask() {
    }

    public final void doExecute() {
        try {
            this.result = execute();
            this.state = 2;
        } catch (IOException e) {
            this.exception = e;
            this.state = 3;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object execute() throws IOException;

    public final IOException getException() {
        return this.exception;
    }

    public final Object getResult() {
        return this.result;
    }

    public final int getState() {
        return this.state;
    }
}

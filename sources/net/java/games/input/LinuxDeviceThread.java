package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class LinuxDeviceThread extends Thread {
    private final List tasks;

    public LinuxDeviceThread() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.tasks = arrayList2;
        setDaemon(true);
        start();
    }

    /* JADX INFO: finally extract failed */
    public final Object execute(LinuxDeviceTask linuxDeviceTask) throws IOException {
        RuntimeException runtimeException;
        StringBuffer stringBuffer;
        LinuxDeviceTask linuxDeviceTask2 = linuxDeviceTask;
        synchronized (this) {
            try {
                boolean add = this.tasks.add(linuxDeviceTask2);
                notify();
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
        synchronized (linuxDeviceTask2) {
            while (linuxDeviceTask2.getState() == 1) {
                try {
                    try {
                        linuxDeviceTask2.wait();
                    } catch (InterruptedException e) {
                        InterruptedException interruptedException = e;
                    }
                } catch (Throwable th3) {
                    while (true) {
                        Throwable th4 = th3;
                        LinuxDeviceTask linuxDeviceTask3 = linuxDeviceTask2;
                        throw th4;
                    }
                }
            }
        }
        switch (linuxDeviceTask2.getState()) {
            case 2:
                return linuxDeviceTask2.getResult();
            case 3:
                throw linuxDeviceTask2.getException();
            default:
                RuntimeException runtimeException2 = runtimeException;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                RuntimeException runtimeException3 = new RuntimeException(stringBuffer2.append("Invalid task state: ").append(linuxDeviceTask2.getState()).toString());
                throw runtimeException2;
        }
    }

    public final void run() {
        LinuxDeviceTask linuxDeviceTask;
        synchronized (this) {
            while (true) {
                try {
                    if (!this.tasks.isEmpty()) {
                        linuxDeviceTask = (LinuxDeviceTask) this.tasks.remove(0);
                        linuxDeviceTask.doExecute();
                        synchronized (linuxDeviceTask) {
                            linuxDeviceTask.notify();
                        }
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            InterruptedException interruptedException = e;
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    throw th2;
                }
            }
        }
    }
}

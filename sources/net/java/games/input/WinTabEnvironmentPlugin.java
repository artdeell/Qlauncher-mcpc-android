package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.util.plugins.Plugin;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class WinTabEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final List active_devices;
    private final Controller[] controllers;
    private final WinTabContext winTabContext;

    private final class ShutdownHook extends Thread {
        private final WinTabEnvironmentPlugin this$0;

        private ShutdownHook(WinTabEnvironmentPlugin winTabEnvironmentPlugin) {
            this.this$0 = winTabEnvironmentPlugin;
        }

        ShutdownHook(WinTabEnvironmentPlugin winTabEnvironmentPlugin, C06301 r7) {
            C06301 r2 = r7;
            this(winTabEnvironmentPlugin);
        }

        public final void run() {
            for (int i = 0; i < WinTabEnvironmentPlugin.access$200(this.this$0).size(); i++) {
            }
            WinTabEnvironmentPlugin.access$300(this.this$0).close();
        }
    }

    static {
        supported = false;
        if (getPrivilegedProperty("os.name", LibrariesRepository.MOJANG_MAVEN_REPO).trim().startsWith("Windows")) {
            supported = true;
            loadLibrary("jinput-wintab");
        }
    }

    public WinTabEnvironmentPlugin() {
        ArrayList arrayList;
        Exception exc;
        WinTabContext winTabContext2;
        StringBuffer stringBuffer;
        C06334 r12;
        DummyWindow dummyWindow;
        WinTabContext winTabContext3;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.active_devices = arrayList2;
        if (isSupported()) {
            Controller[] controllerArr = new Controller[0];
            try {
                DummyWindow dummyWindow2 = dummyWindow;
                DummyWindow dummyWindow3 = new DummyWindow();
                DummyWindow dummyWindow4 = dummyWindow2;
                try {
                    WinTabContext winTabContext4 = winTabContext3;
                    WinTabContext winTabContext5 = new WinTabContext(dummyWindow4);
                    WinTabContext winTabContext6 = winTabContext4;
                    try {
                        winTabContext6.open();
                        controllerArr = winTabContext6.getControllers();
                        winTabContext2 = winTabContext6;
                    } catch (Exception e) {
                        Exception exc2 = e;
                        dummyWindow4.destroy();
                        throw exc2;
                    } catch (Exception e2) {
                        exc = e2;
                        winTabContext2 = winTabContext6;
                        StringBuffer stringBuffer2 = stringBuffer;
                        StringBuffer stringBuffer3 = new StringBuffer();
                        logln(stringBuffer2.append("Failed to enumerate devices: ").append(exc.getMessage()).toString());
                        exc.printStackTrace();
                        this.controllers = controllerArr;
                        this.winTabContext = winTabContext2;
                        C06334 r9 = r12;
                        C06334 r10 = new PrivilegedAction(this) {
                            private final WinTabEnvironmentPlugin this$0;

                            {
                                this.this$0 = r5;
                            }

                            public final Object run() {
                                ShutdownHook shutdownHook;
                                Runtime runtime = Runtime.getRuntime();
                                ShutdownHook shutdownHook2 = shutdownHook;
                                ShutdownHook shutdownHook3 = new ShutdownHook(this.this$0, null);
                                runtime.addShutdownHook(shutdownHook2);
                                return null;
                            }
                        };
                        Object doPrivileged = AccessController.doPrivileged(r9);
                        return;
                    }
                } catch (Exception e3) {
                    exc = e3;
                    winTabContext2 = null;
                    StringBuffer stringBuffer22 = stringBuffer;
                    StringBuffer stringBuffer32 = new StringBuffer();
                    logln(stringBuffer22.append("Failed to enumerate devices: ").append(exc.getMessage()).toString());
                    exc.printStackTrace();
                    this.controllers = controllerArr;
                    this.winTabContext = winTabContext2;
                    C06334 r92 = r12;
                    C06334 r102 = new PrivilegedAction(this) {
                        private final WinTabEnvironmentPlugin this$0;

                        {
                            this.this$0 = r5;
                        }

                        public final Object run() {
                            ShutdownHook shutdownHook;
                            Runtime runtime = Runtime.getRuntime();
                            ShutdownHook shutdownHook2 = shutdownHook;
                            ShutdownHook shutdownHook3 = new ShutdownHook(this.this$0, null);
                            runtime.addShutdownHook(shutdownHook2);
                            return null;
                        }
                    };
                    Object doPrivileged2 = AccessController.doPrivileged(r92);
                    return;
                }
            } catch (Exception e4) {
                exc = e4;
                winTabContext2 = null;
                StringBuffer stringBuffer222 = stringBuffer;
                StringBuffer stringBuffer322 = new StringBuffer();
                logln(stringBuffer222.append("Failed to enumerate devices: ").append(exc.getMessage()).toString());
                exc.printStackTrace();
                this.controllers = controllerArr;
                this.winTabContext = winTabContext2;
                C06334 r922 = r12;
                C06334 r1022 = new PrivilegedAction(this) {
                    private final WinTabEnvironmentPlugin this$0;

                    {
                        this.this$0 = r5;
                    }

                    public final Object run() {
                        ShutdownHook shutdownHook;
                        Runtime runtime = Runtime.getRuntime();
                        ShutdownHook shutdownHook2 = shutdownHook;
                        ShutdownHook shutdownHook3 = new ShutdownHook(this.this$0, null);
                        runtime.addShutdownHook(shutdownHook2);
                        return null;
                    }
                };
                Object doPrivileged22 = AccessController.doPrivileged(r922);
                return;
            }
            this.controllers = controllerArr;
            this.winTabContext = winTabContext2;
            C06334 r9222 = r12;
            C06334 r10222 = new PrivilegedAction(this) {
                private final WinTabEnvironmentPlugin this$0;

                {
                    this.this$0 = r5;
                }

                public final Object run() {
                    ShutdownHook shutdownHook;
                    Runtime runtime = Runtime.getRuntime();
                    ShutdownHook shutdownHook2 = shutdownHook;
                    ShutdownHook shutdownHook3 = new ShutdownHook(this.this$0, null);
                    runtime.addShutdownHook(shutdownHook2);
                    return null;
                }
            };
            Object doPrivileged222 = AccessController.doPrivileged(r9222);
            return;
        }
        this.winTabContext = null;
        this.controllers = new Controller[0];
    }

    static boolean access$002(boolean z) {
        boolean z2 = z;
        supported = z2;
        return z2;
    }

    static List access$200(WinTabEnvironmentPlugin winTabEnvironmentPlugin) {
        return winTabEnvironmentPlugin.active_devices;
    }

    static WinTabContext access$300(WinTabEnvironmentPlugin winTabEnvironmentPlugin) {
        return winTabEnvironmentPlugin.winTabContext;
    }

    static String getPrivilegedProperty(String str) {
        C06312 r4;
        C06312 r1 = r4;
        C06312 r2 = new PrivilegedAction(str) {
            private final String val$property;

            {
                this.val$property = r5;
            }

            public Object run() {
                return System.getProperty(this.val$property);
            }
        };
        return (String) AccessController.doPrivileged(r1);
    }

    static String getPrivilegedProperty(String str, String str2) {
        C06323 r6;
        C06323 r2 = r6;
        C06323 r3 = new PrivilegedAction(str, str2) {
            private final String val$default_value;
            private final String val$property;

            {
                String str = r7;
                this.val$property = r6;
                this.val$default_value = str;
            }

            public Object run() {
                return System.getProperty(this.val$property, this.val$default_value);
            }
        };
        return (String) AccessController.doPrivileged(r2);
    }

    static void loadLibrary(String str) {
        C06301 r4;
        C06301 r1 = r4;
        C06301 r2 = new PrivilegedAction(str) {
            private final String val$lib_name;

            {
                this.val$lib_name = r5;
            }

            public final Object run() {
                StringBuffer stringBuffer;
                try {
                    String property = System.getProperty("net.java.games.input.librarypath");
                    if (property != null) {
                        StringBuffer stringBuffer2 = stringBuffer;
                        StringBuffer stringBuffer3 = new StringBuffer();
                        System.load(stringBuffer2.append(property).append(File.separator).append(System.mapLibraryName(this.val$lib_name)).toString());
                    } else {
                        System.loadLibrary(this.val$lib_name);
                    }
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                    boolean access$002 = WinTabEnvironmentPlugin.access$002(false);
                }
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r1);
    }

    public Controller[] getControllers() {
        return this.controllers;
    }

    public boolean isSupported() {
        return supported;
    }
}

package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Controller.Type;
import net.java.games.util.plugins.Plugin;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class DirectInputEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final List active_devices;
    private final Controller[] controllers;
    private final DummyWindow window;

    private final class ShutdownHook extends Thread {
        private final DirectInputEnvironmentPlugin this$0;

        private ShutdownHook(DirectInputEnvironmentPlugin directInputEnvironmentPlugin) {
            this.this$0 = directInputEnvironmentPlugin;
        }

        ShutdownHook(DirectInputEnvironmentPlugin directInputEnvironmentPlugin, C06091 r7) {
            C06091 r2 = r7;
            this(directInputEnvironmentPlugin);
        }

        public final void run() {
            for (int i = 0; i < DirectInputEnvironmentPlugin.access$200(this.this$0).size(); i++) {
                ((IDirectInputDevice) DirectInputEnvironmentPlugin.access$200(this.this$0).get(i)).release();
            }
        }
    }

    static {
        supported = false;
        if (getPrivilegedProperty("os.name", LibrariesRepository.MOJANG_MAVEN_REPO).trim().startsWith("Windows")) {
            supported = true;
            if ("x86".equals(getPrivilegedProperty("os.arch"))) {
                loadLibrary("jinput-dx8");
            } else {
                loadLibrary("jinput-dx8_64");
            }
        }
    }

    public DirectInputEnvironmentPlugin() {
        ArrayList arrayList;
        IOException iOException;
        DummyWindow dummyWindow;
        StringBuffer stringBuffer;
        C06124 r11;
        DummyWindow dummyWindow2;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.active_devices = arrayList2;
        Controller[] controllerArr = new Controller[0];
        if (isSupported()) {
            try {
                DummyWindow dummyWindow3 = dummyWindow2;
                DummyWindow dummyWindow4 = new DummyWindow();
                DummyWindow dummyWindow5 = dummyWindow3;
                try {
                    controllerArr = enumControllers(dummyWindow5);
                    dummyWindow = dummyWindow5;
                } catch (IOException e) {
                    IOException iOException2 = e;
                    dummyWindow5.destroy();
                    throw iOException2;
                } catch (IOException e2) {
                    iOException = e2;
                    dummyWindow = dummyWindow5;
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    logln(stringBuffer2.append("Failed to enumerate devices: ").append(iOException.getMessage()).toString());
                    this.window = dummyWindow;
                    this.controllers = controllerArr;
                    C06124 r8 = r11;
                    C06124 r9 = new PrivilegedAction(this) {
                        private final DirectInputEnvironmentPlugin this$0;

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
                    Object doPrivileged = AccessController.doPrivileged(r8);
                    return;
                }
            } catch (IOException e3) {
                iOException = e3;
                dummyWindow = null;
                StringBuffer stringBuffer22 = stringBuffer;
                StringBuffer stringBuffer32 = new StringBuffer();
                logln(stringBuffer22.append("Failed to enumerate devices: ").append(iOException.getMessage()).toString());
                this.window = dummyWindow;
                this.controllers = controllerArr;
                C06124 r82 = r11;
                C06124 r92 = new PrivilegedAction(this) {
                    private final DirectInputEnvironmentPlugin this$0;

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
                Object doPrivileged2 = AccessController.doPrivileged(r82);
                return;
            }
            this.window = dummyWindow;
            this.controllers = controllerArr;
            C06124 r822 = r11;
            C06124 r922 = new PrivilegedAction(this) {
                private final DirectInputEnvironmentPlugin this$0;

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
            Object doPrivileged22 = AccessController.doPrivileged(r822);
            return;
        }
        this.window = null;
        this.controllers = controllerArr;
    }

    static boolean access$002(boolean z) {
        boolean z2 = z;
        supported = z2;
        return z2;
    }

    static List access$200(DirectInputEnvironmentPlugin directInputEnvironmentPlugin) {
        return directInputEnvironmentPlugin.active_devices;
    }

    private final Component[] createComponents(IDirectInputDevice iDirectInputDevice, boolean z) {
        ArrayList arrayList;
        DIComponent dIComponent;
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        boolean z2 = z;
        List objects = iDirectInputDevice2.getObjects();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < objects.size(); i++) {
            DIDeviceObject dIDeviceObject = (DIDeviceObject) objects.get(i);
            Identifier identifier = dIDeviceObject.getIdentifier();
            if (identifier != null) {
                if (z2 && (identifier instanceof Button)) {
                    identifier = DIIdentifierMap.mapMouseButtonIdentifier((Button) identifier);
                }
                DIComponent dIComponent2 = dIComponent;
                DIComponent dIComponent3 = new DIComponent(identifier, dIDeviceObject);
                DIComponent dIComponent4 = dIComponent2;
                boolean add = arrayList4.add(dIComponent4);
                iDirectInputDevice2.registerComponent(dIDeviceObject, dIComponent4);
            }
        }
        Component[] componentArr = new Component[arrayList4.size()];
        Object[] array = arrayList4.toArray(componentArr);
        return componentArr;
    }

    private final AbstractController createControllerFromDevice(IDirectInputDevice iDirectInputDevice, Type type) {
        DIAbstractController dIAbstractController;
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        Type type2 = type;
        DIAbstractController dIAbstractController2 = dIAbstractController;
        DIAbstractController dIAbstractController3 = new DIAbstractController(iDirectInputDevice2, createComponents(iDirectInputDevice2, false), new Controller[0], iDirectInputDevice2.getRumblers(), type2);
        return dIAbstractController2;
    }

    private final Controller createControllerFromDevice(IDirectInputDevice iDirectInputDevice) {
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        switch (iDirectInputDevice2.getType()) {
            case 18:
                return createMouseFromDevice(iDirectInputDevice2);
            case 19:
                return createKeyboardFromDevice(iDirectInputDevice2);
            case 20:
            case 23:
            case 24:
                return createControllerFromDevice(iDirectInputDevice2, Type.STICK);
            case 21:
                return createControllerFromDevice(iDirectInputDevice2, Type.GAMEPAD);
            case 22:
                return createControllerFromDevice(iDirectInputDevice2, Type.WHEEL);
            default:
                return createControllerFromDevice(iDirectInputDevice2, Type.UNKNOWN);
        }
    }

    private final Keyboard createKeyboardFromDevice(IDirectInputDevice iDirectInputDevice) {
        DIKeyboard dIKeyboard;
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        DIKeyboard dIKeyboard2 = dIKeyboard;
        DIKeyboard dIKeyboard3 = new DIKeyboard(iDirectInputDevice2, createComponents(iDirectInputDevice2, false), new Controller[0], iDirectInputDevice2.getRumblers());
        return dIKeyboard2;
    }

    private final Mouse createMouseFromDevice(IDirectInputDevice iDirectInputDevice) {
        DIMouse dIMouse;
        IDirectInputDevice iDirectInputDevice2 = iDirectInputDevice;
        DIMouse dIMouse2 = dIMouse;
        DIMouse dIMouse3 = new DIMouse(iDirectInputDevice2, createComponents(iDirectInputDevice2, true), new Controller[0], iDirectInputDevice2.getRumblers());
        DIMouse dIMouse4 = dIMouse2;
        if (dIMouse4.getX() == null || dIMouse4.getY() == null || dIMouse4.getPrimaryButton() == null) {
            return null;
        }
        return dIMouse4;
    }

    private final Controller[] enumControllers(DummyWindow dummyWindow) throws IOException {
        ArrayList arrayList;
        IDirectInput iDirectInput;
        DummyWindow dummyWindow2 = dummyWindow;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        IDirectInput iDirectInput2 = iDirectInput;
        IDirectInput iDirectInput3 = new IDirectInput(dummyWindow2);
        IDirectInput iDirectInput4 = iDirectInput2;
        try {
            List devices = iDirectInput4.getDevices();
            for (int i = 0; i < devices.size(); i++) {
                IDirectInputDevice iDirectInputDevice = (IDirectInputDevice) devices.get(i);
                Controller createControllerFromDevice = createControllerFromDevice(iDirectInputDevice);
                if (createControllerFromDevice != null) {
                    boolean add = arrayList4.add(createControllerFromDevice);
                    boolean add2 = this.active_devices.add(iDirectInputDevice);
                } else {
                    iDirectInputDevice.release();
                }
            }
            iDirectInput4.release();
            Controller[] controllerArr = new Controller[arrayList4.size()];
            Object[] array = arrayList4.toArray(controllerArr);
            return controllerArr;
        } catch (Throwable th) {
            Throwable th2 = th;
            iDirectInput4.release();
            throw th2;
        }
    }

    static String getPrivilegedProperty(String str) {
        C06102 r4;
        C06102 r1 = r4;
        C06102 r2 = new PrivilegedAction(str) {
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
        C06113 r6;
        C06113 r2 = r6;
        C06113 r3 = new PrivilegedAction(str, str2) {
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
        C06091 r4;
        C06091 r1 = r4;
        C06091 r2 = new PrivilegedAction(str) {
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
                    boolean access$002 = DirectInputEnvironmentPlugin.access$002(false);
                }
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r1);
    }

    public final Controller[] getControllers() {
        return this.controllers;
    }

    public boolean isSupported() {
        return supported;
    }
}

package net.java.games.input;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Axis;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Controller.Type;
import net.java.games.util.plugins.Plugin;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class LinuxEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static final String LIBNAME = "jinput-linux";
    private static final String POSTFIX64BIT = "64";
    private static final LinuxDeviceThread device_thread;
    private static boolean supported;
    private final Controller[] controllers;
    private final List devices;

    private final class ShutdownHook extends Thread {
        private final LinuxEnvironmentPlugin this$0;

        private ShutdownHook(LinuxEnvironmentPlugin linuxEnvironmentPlugin) {
            this.this$0 = linuxEnvironmentPlugin;
        }

        ShutdownHook(LinuxEnvironmentPlugin linuxEnvironmentPlugin, C06131 r7) {
            C06131 r2 = r7;
            this(linuxEnvironmentPlugin);
        }

        public final void run() {
            StringBuffer stringBuffer;
            for (int i = 0; i < LinuxEnvironmentPlugin.access$200(this.this$0).size(); i++) {
                try {
                    ((LinuxDevice) LinuxEnvironmentPlugin.access$200(this.this$0).get(i)).close();
                } catch (IOException e) {
                    IOException iOException = e;
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    ControllerEnvironment.logln(stringBuffer2.append("Failed to close device: ").append(iOException.getMessage()).toString());
                }
            }
        }
    }

    static {
        LinuxDeviceThread linuxDeviceThread;
        supported = false;
        LinuxDeviceThread linuxDeviceThread2 = linuxDeviceThread;
        LinuxDeviceThread linuxDeviceThread3 = new LinuxDeviceThread();
        device_thread = linuxDeviceThread2;
        if (getPrivilegedProperty("os.name", LibrariesRepository.MOJANG_MAVEN_REPO).trim().equals("Linux")) {
            supported = true;
            if ("i386".equals(getPrivilegedProperty("os.arch"))) {
                loadLibrary(LIBNAME);
            } else {
                loadLibrary("jinput-linux64");
            }
        }
    }

    public LinuxEnvironmentPlugin() {
        ArrayList arrayList;
        StringBuffer stringBuffer;
        C06164 r4;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.devices = arrayList2;
        if (isSupported()) {
            this.controllers = enumerateControllers();
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            logln(stringBuffer2.append("Linux plugin claims to have found ").append(this.controllers.length).append(" controllers").toString());
            C06164 r1 = r4;
            C06164 r2 = new PrivilegedAction(this) {
                private final LinuxEnvironmentPlugin this$0;

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
            Object doPrivileged = AccessController.doPrivileged(r1);
            return;
        }
        this.controllers = new Controller[0];
    }

    static boolean access$002(boolean z) {
        boolean z2 = z;
        supported = z2;
        return z2;
    }

    static List access$200(LinuxEnvironmentPlugin linuxEnvironmentPlugin) {
        return linuxEnvironmentPlugin.devices;
    }

    private static final Component[] createComponents(List list, LinuxEventDevice linuxEventDevice) {
        ArrayList arrayList;
        LinuxPOV linuxPOV;
        LinuxComponent linuxComponent;
        StringBuffer stringBuffer;
        List list2 = list;
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        LinuxEventComponent[][] linuxEventComponentArr = (LinuxEventComponent[][]) Array.newInstance(LinuxEventComponent.class, new int[]{4, 2});
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < list2.size(); i++) {
            LinuxEventComponent linuxEventComponent = (LinuxEventComponent) list2.get(i);
            Identifier identifier = linuxEventComponent.getIdentifier();
            if (identifier == Axis.POV) {
                int code = linuxEventComponent.getDescriptor().getCode();
                switch (code) {
                    case 16:
                        linuxEventComponentArr[0][0] = linuxEventComponent;
                        break;
                    case 17:
                        linuxEventComponentArr[0][1] = linuxEventComponent;
                        break;
                    case 18:
                        linuxEventComponentArr[1][0] = linuxEventComponent;
                        break;
                    case 19:
                        linuxEventComponentArr[1][1] = linuxEventComponent;
                        break;
                    case 20:
                        linuxEventComponentArr[2][0] = linuxEventComponent;
                        break;
                    case 21:
                        linuxEventComponentArr[2][1] = linuxEventComponent;
                        break;
                    case 22:
                        linuxEventComponentArr[3][0] = linuxEventComponent;
                        break;
                    case 23:
                        linuxEventComponentArr[3][1] = linuxEventComponent;
                        break;
                    default:
                        StringBuffer stringBuffer2 = stringBuffer;
                        StringBuffer stringBuffer3 = new StringBuffer();
                        logln(stringBuffer2.append("Unknown POV instance: ").append(code).toString());
                        break;
                }
            } else if (identifier != null) {
                LinuxComponent linuxComponent2 = linuxComponent;
                LinuxComponent linuxComponent3 = new LinuxComponent(linuxEventComponent);
                LinuxComponent linuxComponent4 = linuxComponent2;
                boolean add = arrayList4.add(linuxComponent4);
                linuxEventDevice2.registerComponent(linuxEventComponent.getDescriptor(), linuxComponent4);
            }
        }
        for (int i2 = 0; i2 < linuxEventComponentArr.length; i2++) {
            LinuxEventComponent linuxEventComponent2 = linuxEventComponentArr[i2][0];
            LinuxEventComponent linuxEventComponent3 = linuxEventComponentArr[i2][1];
            if (!(linuxEventComponent2 == null || linuxEventComponent3 == null)) {
                LinuxPOV linuxPOV2 = linuxPOV;
                LinuxPOV linuxPOV3 = new LinuxPOV(linuxEventComponent2, linuxEventComponent3);
                LinuxPOV linuxPOV4 = linuxPOV2;
                boolean add2 = arrayList4.add(linuxPOV4);
                linuxEventDevice2.registerComponent(linuxEventComponent2.getDescriptor(), linuxPOV4);
                linuxEventDevice2.registerComponent(linuxEventComponent3.getDescriptor(), linuxPOV4);
            }
        }
        Component[] componentArr = new Component[arrayList4.size()];
        Object[] array = arrayList4.toArray(componentArr);
        return componentArr;
    }

    private static final Controller createControllerFromDevice(LinuxEventDevice linuxEventDevice) throws IOException {
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        Component[] createComponents = createComponents(linuxEventDevice2.getComponents(), linuxEventDevice2);
        Type type = linuxEventDevice2.getType();
        if (type == Type.MOUSE) {
            return createMouseFromDevice(linuxEventDevice2, createComponents);
        }
        if (type == Type.KEYBOARD) {
            return createKeyboardFromDevice(linuxEventDevice2, createComponents);
        }
        if (type == Type.STICK || type == Type.GAMEPAD) {
            return createJoystickFromDevice(linuxEventDevice2, createComponents, type);
        }
        return null;
    }

    private static final Controller createJoystickFromDevice(LinuxEventDevice linuxEventDevice, Component[] componentArr, Type type) throws IOException {
        LinuxAbstractController linuxAbstractController;
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        LinuxAbstractController linuxAbstractController2 = linuxAbstractController;
        LinuxAbstractController linuxAbstractController3 = new LinuxAbstractController(linuxEventDevice2, componentArr, new Controller[0], linuxEventDevice2.getRumblers(), type);
        return linuxAbstractController2;
    }

    private static final Controller createJoystickFromJoystickDevice(LinuxJoystickDevice linuxJoystickDevice) {
        ArrayList arrayList;
        LinuxJoystickAbstractController linuxJoystickAbstractController;
        LinuxJoystickAxis linuxJoystickAxis;
        LinuxJoystickPOV linuxJoystickPOV;
        LinuxJoystickPOV linuxJoystickPOV2;
        LinuxJoystickPOV linuxJoystickPOV3;
        LinuxJoystickButton linuxJoystickButton;
        LinuxJoystickDevice linuxJoystickDevice2 = linuxJoystickDevice;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        byte[] axisMap = linuxJoystickDevice2.getAxisMap();
        char[] buttonMap = linuxJoystickDevice2.getButtonMap();
        LinuxJoystickAxis[] linuxJoystickAxisArr = new LinuxJoystickAxis[6];
        for (int i = 0; i < linuxJoystickDevice2.getNumButtons(); i++) {
            Identifier buttonID = LinuxNativeTypesMap.getButtonID(buttonMap[i]);
            if (buttonID != null) {
                LinuxJoystickButton linuxJoystickButton2 = linuxJoystickButton;
                LinuxJoystickButton linuxJoystickButton3 = new LinuxJoystickButton(buttonID);
                LinuxJoystickButton linuxJoystickButton4 = linuxJoystickButton2;
                linuxJoystickDevice2.registerButton(i, linuxJoystickButton4);
                boolean add = arrayList4.add(linuxJoystickButton4);
            }
        }
        for (int i2 = 0; i2 < linuxJoystickDevice2.getNumAxes(); i2++) {
            LinuxJoystickAxis linuxJoystickAxis2 = linuxJoystickAxis;
            LinuxJoystickAxis linuxJoystickAxis3 = new LinuxJoystickAxis((Axis) LinuxNativeTypesMap.getAbsAxisID(axisMap[i2]));
            LinuxJoystickAxis linuxJoystickAxis4 = linuxJoystickAxis2;
            linuxJoystickDevice2.registerAxis(i2, linuxJoystickAxis4);
            if (axisMap[i2] == 16) {
                linuxJoystickAxisArr[0] = linuxJoystickAxis4;
            } else if (axisMap[i2] == 17) {
                linuxJoystickAxisArr[1] = linuxJoystickAxis4;
                LinuxJoystickPOV linuxJoystickPOV4 = linuxJoystickPOV3;
                LinuxJoystickPOV linuxJoystickPOV5 = new LinuxJoystickPOV(Axis.POV, linuxJoystickAxisArr[0], linuxJoystickAxisArr[1]);
                LinuxJoystickPOV linuxJoystickPOV6 = linuxJoystickPOV4;
                linuxJoystickDevice2.registerPOV(linuxJoystickPOV6);
                boolean add2 = arrayList4.add(linuxJoystickPOV6);
            } else if (axisMap[i2] == 18) {
                linuxJoystickAxisArr[2] = linuxJoystickAxis4;
            } else if (axisMap[i2] == 19) {
                linuxJoystickAxisArr[3] = linuxJoystickAxis4;
                LinuxJoystickPOV linuxJoystickPOV7 = linuxJoystickPOV2;
                LinuxJoystickPOV linuxJoystickPOV8 = new LinuxJoystickPOV(Axis.POV, linuxJoystickAxisArr[2], linuxJoystickAxisArr[3]);
                LinuxJoystickPOV linuxJoystickPOV9 = linuxJoystickPOV7;
                linuxJoystickDevice2.registerPOV(linuxJoystickPOV9);
                boolean add3 = arrayList4.add(linuxJoystickPOV9);
            } else if (axisMap[i2] == 20) {
                linuxJoystickAxisArr[4] = linuxJoystickAxis4;
            } else if (axisMap[i2] == 21) {
                linuxJoystickAxisArr[5] = linuxJoystickAxis4;
                LinuxJoystickPOV linuxJoystickPOV10 = linuxJoystickPOV;
                LinuxJoystickPOV linuxJoystickPOV11 = new LinuxJoystickPOV(Axis.POV, linuxJoystickAxisArr[4], linuxJoystickAxisArr[5]);
                LinuxJoystickPOV linuxJoystickPOV12 = linuxJoystickPOV10;
                linuxJoystickDevice2.registerPOV(linuxJoystickPOV12);
                boolean add4 = arrayList4.add(linuxJoystickPOV12);
            } else {
                boolean add5 = arrayList4.add(linuxJoystickAxis4);
            }
        }
        LinuxJoystickAbstractController linuxJoystickAbstractController2 = linuxJoystickAbstractController;
        LinuxJoystickAbstractController linuxJoystickAbstractController3 = new LinuxJoystickAbstractController(linuxJoystickDevice2, (Component[]) arrayList4.toArray(new Component[0]), new Controller[0], new Rumbler[0]);
        return linuxJoystickAbstractController2;
    }

    private static final Keyboard createKeyboardFromDevice(LinuxEventDevice linuxEventDevice, Component[] componentArr) throws IOException {
        LinuxKeyboard linuxKeyboard;
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        LinuxKeyboard linuxKeyboard2 = linuxKeyboard;
        LinuxKeyboard linuxKeyboard3 = new LinuxKeyboard(linuxEventDevice2, componentArr, new Controller[0], linuxEventDevice2.getRumblers());
        return linuxKeyboard2;
    }

    private static final Mouse createMouseFromDevice(LinuxEventDevice linuxEventDevice, Component[] componentArr) throws IOException {
        LinuxMouse linuxMouse;
        LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
        LinuxMouse linuxMouse2 = linuxMouse;
        LinuxMouse linuxMouse3 = new LinuxMouse(linuxEventDevice2, componentArr, new Controller[0], linuxEventDevice2.getRumblers());
        LinuxMouse linuxMouse4 = linuxMouse2;
        if (linuxMouse4.getX() == null || linuxMouse4.getY() == null || linuxMouse4.getPrimaryButton() == null) {
            return null;
        }
        return linuxMouse4;
    }

    private final Controller[] enumerateControllers() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        LinuxCombinedController linuxCombinedController;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = arrayList4;
        ArrayList arrayList7 = arrayList2;
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = arrayList7;
        ArrayList arrayList10 = arrayList3;
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = arrayList10;
        enumerateEventControllers(arrayList9);
        enumerateJoystickControllers(arrayList12);
        int i = 0;
        while (i < arrayList9.size()) {
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList12.size()) {
                    break;
                }
                Controller controller = (Controller) arrayList9.get(i);
                Controller controller2 = (Controller) arrayList12.get(i2);
                if (controller.getName().equals(controller2.getName())) {
                    Component[] components = controller.getComponents();
                    Component[] components2 = controller2.getComponents();
                    if (components.length == components2.length) {
                        boolean z = false;
                        for (int i3 = 0; i3 < components.length; i3++) {
                            if (components[i3].getIdentifier() != components2[i3].getIdentifier()) {
                                z = true;
                            }
                        }
                        if (!z) {
                            ArrayList arrayList13 = arrayList6;
                            LinuxCombinedController linuxCombinedController2 = linuxCombinedController;
                            LinuxCombinedController linuxCombinedController3 = new LinuxCombinedController((LinuxAbstractController) arrayList9.remove(i), (LinuxJoystickAbstractController) arrayList12.remove(i2));
                            boolean add = arrayList13.add(linuxCombinedController2);
                            i--;
                            int i4 = i2 - 1;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i2++;
            }
            i++;
        }
        boolean addAll = arrayList6.addAll(arrayList9);
        boolean addAll2 = arrayList6.addAll(arrayList12);
        Controller[] controllerArr = new Controller[arrayList6.size()];
        Object[] array = arrayList6.toArray(controllerArr);
        return controllerArr;
    }

    private final void enumerateEventControllers(List list) {
        File file;
        C06208 r13;
        StringBuffer stringBuffer;
        LinuxEventDevice linuxEventDevice;
        StringBuffer stringBuffer2;
        List list2 = list;
        File file2 = file;
        File file3 = new File("/dev/input");
        C06208 r10 = r13;
        C06208 r11 = new FilenameFilter(this) {
            private final LinuxEnvironmentPlugin this$0;

            {
                this.this$0 = r5;
            }

            public final boolean accept(File file, String str) {
                File file2 = file;
                return str.startsWith("event");
            }
        };
        File[] listFilesPrivileged = listFilesPrivileged(file2, r10);
        if (listFilesPrivileged != null) {
            for (int i = 0; i < listFilesPrivileged.length; i++) {
                File file4 = listFilesPrivileged[i];
                try {
                    LinuxEventDevice linuxEventDevice2 = linuxEventDevice;
                    LinuxEventDevice linuxEventDevice3 = new LinuxEventDevice(getAbsolutePathPrivileged(file4));
                    LinuxEventDevice linuxEventDevice4 = linuxEventDevice2;
                    try {
                        Controller createControllerFromDevice = createControllerFromDevice(linuxEventDevice4);
                        if (createControllerFromDevice != null) {
                            boolean add = list2.add(createControllerFromDevice);
                            boolean add2 = this.devices.add(linuxEventDevice4);
                        } else {
                            linuxEventDevice4.close();
                        }
                    } catch (IOException e) {
                        IOException iOException = e;
                        StringBuffer stringBuffer3 = stringBuffer2;
                        StringBuffer stringBuffer4 = new StringBuffer();
                        logln(stringBuffer3.append("Failed to create Controller: ").append(iOException.getMessage()).toString());
                        linuxEventDevice4.close();
                    }
                } catch (IOException e2) {
                    IOException iOException2 = e2;
                    StringBuffer stringBuffer5 = stringBuffer;
                    StringBuffer stringBuffer6 = new StringBuffer();
                    logln(stringBuffer5.append("Failed to open device (").append(file4).append("): ").append(iOException2.getMessage()).toString());
                }
            }
        }
    }

    private final void enumerateJoystickControllers(List list) {
        StringBuffer stringBuffer;
        LinuxJoystickDevice linuxJoystickDevice;
        List list2 = list;
        File[] enumerateJoystickDeviceFiles = enumerateJoystickDeviceFiles("/dev/input");
        if (enumerateJoystickDeviceFiles == null || enumerateJoystickDeviceFiles.length == 0) {
            enumerateJoystickDeviceFiles = enumerateJoystickDeviceFiles("/dev");
            if (enumerateJoystickDeviceFiles == null) {
                return;
            }
        }
        for (int i = 0; i < enumerateJoystickDeviceFiles.length; i++) {
            File file = enumerateJoystickDeviceFiles[i];
            try {
                LinuxJoystickDevice linuxJoystickDevice2 = linuxJoystickDevice;
                LinuxJoystickDevice linuxJoystickDevice3 = new LinuxJoystickDevice(getAbsolutePathPrivileged(file));
                LinuxJoystickDevice linuxJoystickDevice4 = linuxJoystickDevice2;
                Controller createJoystickFromJoystickDevice = createJoystickFromJoystickDevice(linuxJoystickDevice4);
                if (createJoystickFromJoystickDevice != null) {
                    boolean add = list2.add(createJoystickFromJoystickDevice);
                    boolean add2 = this.devices.add(linuxJoystickDevice4);
                } else {
                    linuxJoystickDevice4.close();
                }
            } catch (IOException e) {
                IOException iOException = e;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                logln(stringBuffer2.append("Failed to open device (").append(file).append("): ").append(iOException.getMessage()).toString());
            }
        }
    }

    private static final File[] enumerateJoystickDeviceFiles(String str) {
        File file;
        C06175 r4;
        File file2 = file;
        File file3 = new File(str);
        C06175 r2 = r4;
        C06175 r3 = new FilenameFilter() {
            public final boolean accept(File file, String str) {
                File file2 = file;
                return str.startsWith("js");
            }
        };
        return listFilesPrivileged(file2, r2);
    }

    public static final Object execute(LinuxDeviceTask linuxDeviceTask) throws IOException {
        return device_thread.execute(linuxDeviceTask);
    }

    private static String getAbsolutePathPrivileged(File file) {
        C06186 r4;
        C06186 r1 = r4;
        C06186 r2 = new PrivilegedAction(file) {
            private final File val$file;

            {
                this.val$file = r5;
            }

            public Object run() {
                return this.val$file.getAbsolutePath();
            }
        };
        return (String) AccessController.doPrivileged(r1);
    }

    private static final Button getButtonIdentifier(int i) {
        switch (i) {
            case 0:
                return Button.f40_0;
            case 1:
                return Button.f41_1;
            case 2:
                return Button.f42_2;
            case 3:
                return Button.f43_3;
            case 4:
                return Button.f44_4;
            case 5:
                return Button.f45_5;
            case 6:
                return Button.f46_6;
            case 7:
                return Button.f47_7;
            case 8:
                return Button.f48_8;
            case 9:
                return Button.f49_9;
            case 10:
                return Button._10;
            case 11:
                return Button._11;
            case 12:
                return Button._12;
            case 13:
                return Button._13;
            case 14:
                return Button._14;
            case 15:
                return Button._15;
            case 16:
                return Button._16;
            case 17:
                return Button._17;
            case 18:
                return Button._18;
            case 19:
                return Button._19;
            case 20:
                return Button._20;
            case 21:
                return Button._21;
            case 22:
                return Button._22;
            case 23:
                return Button._23;
            case 24:
                return Button._24;
            case 25:
                return Button._25;
            case 26:
                return Button._26;
            case 27:
                return Button._27;
            case 28:
                return Button._28;
            case 29:
                return Button._29;
            case 30:
                return Button._30;
            case 31:
                return Button._31;
            default:
                return null;
        }
    }

    static String getPrivilegedProperty(String str) {
        C06142 r4;
        C06142 r1 = r4;
        C06142 r2 = new PrivilegedAction(str) {
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
        C06153 r6;
        C06153 r2 = r6;
        C06153 r3 = new PrivilegedAction(str, str2) {
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

    private static File[] listFilesPrivileged(File file, FilenameFilter filenameFilter) {
        C06197 r6;
        C06197 r2 = r6;
        C06197 r3 = new PrivilegedAction(file, filenameFilter) {
            private final File val$dir;
            private final FilenameFilter val$filter;

            {
                FilenameFilter filenameFilter = r7;
                this.val$dir = r6;
                this.val$filter = filenameFilter;
            }

            public Object run() {
                return this.val$dir.listFiles(this.val$filter);
            }
        };
        return (File[]) AccessController.doPrivileged(r2);
    }

    static void loadLibrary(String str) {
        C06131 r4;
        C06131 r1 = r4;
        C06131 r2 = new PrivilegedAction(str) {
            private final String val$lib_name;

            {
                this.val$lib_name = r5;
            }

            public final Object run() {
                StringBuffer stringBuffer;
                StringBuffer stringBuffer2;
                String property = System.getProperty("net.java.games.input.librarypath");
                if (property != null) {
                    try {
                        StringBuffer stringBuffer3 = stringBuffer2;
                        StringBuffer stringBuffer4 = new StringBuffer();
                        System.load(stringBuffer3.append(property).append(File.separator).append(System.mapLibraryName(this.val$lib_name)).toString());
                    } catch (UnsatisfiedLinkError e) {
                        UnsatisfiedLinkError unsatisfiedLinkError = e;
                        StringBuffer stringBuffer5 = stringBuffer;
                        StringBuffer stringBuffer6 = new StringBuffer();
                        ControllerEnvironment.logln(stringBuffer5.append("Failed to load library: ").append(unsatisfiedLinkError.getMessage()).toString());
                        unsatisfiedLinkError.printStackTrace();
                        boolean access$002 = LinuxEnvironmentPlugin.access$002(false);
                    }
                } else {
                    System.loadLibrary(this.val$lib_name);
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

package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.util.plugins.Plugin;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class RawInputEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final Controller[] controllers;

    static {
        supported = false;
        if (getPrivilegedProperty("os.name", LibrariesRepository.MOJANG_MAVEN_REPO).trim().startsWith("Windows")) {
            supported = true;
            if ("x86".equals(getPrivilegedProperty("os.arch"))) {
                loadLibrary("jinput-raw");
            } else {
                loadLibrary("jinput-raw_64");
            }
        }
    }

    public RawInputEnvironmentPlugin() {
        StringBuffer stringBuffer;
        RawInputEventQueue rawInputEventQueue;
        Controller[] controllerArr = new Controller[0];
        if (isSupported()) {
            try {
                RawInputEventQueue rawInputEventQueue2 = rawInputEventQueue;
                RawInputEventQueue rawInputEventQueue3 = new RawInputEventQueue();
                controllerArr = enumControllers(rawInputEventQueue2);
            } catch (IOException e) {
                IOException iOException = e;
                StringBuffer stringBuffer2 = stringBuffer;
                StringBuffer stringBuffer3 = new StringBuffer();
                logln(stringBuffer2.append("Failed to enumerate devices: ").append(iOException.getMessage()).toString());
            }
        }
        this.controllers = controllerArr;
    }

    static boolean access$002(boolean z) {
        boolean z2 = z;
        supported = z2;
        return z2;
    }

    private static final void createControllersFromDevices(RawInputEventQueue rawInputEventQueue, List list, List list2, List list3) throws IOException {
        ArrayList arrayList;
        RawInputEventQueue rawInputEventQueue2 = rawInputEventQueue;
        List list4 = list;
        List list5 = list2;
        List list6 = list3;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < list5.size(); i++) {
            RawDevice rawDevice = (RawDevice) list5.get(i);
            SetupAPIDevice lookupSetupAPIDevice = lookupSetupAPIDevice(rawDevice.getName(), list6);
            if (lookupSetupAPIDevice != null) {
                Controller createControllerFromDevice = rawDevice.getInfo().createControllerFromDevice(rawDevice, lookupSetupAPIDevice);
                if (createControllerFromDevice != null) {
                    boolean add = list4.add(createControllerFromDevice);
                    boolean add2 = arrayList4.add(rawDevice);
                }
            }
        }
        rawInputEventQueue2.start(arrayList4);
    }

    private final Controller[] enumControllers(RawInputEventQueue rawInputEventQueue) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        RawInputEventQueue rawInputEventQueue2 = rawInputEventQueue;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = arrayList3;
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = arrayList6;
        enumerateDevices(rawInputEventQueue2, arrayList8);
        createControllersFromDevices(rawInputEventQueue2, arrayList5, arrayList8, enumSetupAPIDevices());
        Controller[] controllerArr = new Controller[arrayList5.size()];
        Object[] array = arrayList5.toArray(controllerArr);
        return controllerArr;
    }

    private static final List enumSetupAPIDevices() throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        nEnumSetupAPIDevices(getKeyboardClassGUID(), arrayList4);
        nEnumSetupAPIDevices(getMouseClassGUID(), arrayList4);
        return arrayList4;
    }

    private static final native void enumerateDevices(RawInputEventQueue rawInputEventQueue, List list) throws IOException;

    private static final native byte[] getKeyboardClassGUID();

    private static final native byte[] getMouseClassGUID();

    static String getPrivilegedProperty(String str) {
        C06282 r4;
        C06282 r1 = r4;
        C06282 r2 = new PrivilegedAction(str) {
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
        C06293 r6;
        C06293 r2 = r6;
        C06293 r3 = new PrivilegedAction(str, str2) {
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
        C06271 r4;
        C06271 r1 = r4;
        C06271 r2 = new PrivilegedAction(str) {
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
                    boolean access$002 = RawInputEnvironmentPlugin.access$002(false);
                }
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r1);
    }

    private static final SetupAPIDevice lookupSetupAPIDevice(String str, List list) {
        List list2 = list;
        String upperCase = str.replaceAll("#", "\\\\").toUpperCase();
        for (int i = 0; i < list2.size(); i++) {
            SetupAPIDevice setupAPIDevice = (SetupAPIDevice) list2.get(i);
            if (upperCase.indexOf(setupAPIDevice.getInstanceId().toUpperCase()) != -1) {
                return setupAPIDevice;
            }
        }
        return null;
    }

    private static final native void nEnumSetupAPIDevices(byte[] bArr, List list) throws IOException;

    public final Controller[] getControllers() {
        return this.controllers;
    }

    public boolean isSupported() {
        return supported;
    }
}

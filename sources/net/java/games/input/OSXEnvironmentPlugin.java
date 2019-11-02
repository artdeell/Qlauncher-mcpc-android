package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller.Type;
import net.java.games.util.plugins.Plugin;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public final class OSXEnvironmentPlugin extends ControllerEnvironment implements Plugin {
    private static boolean supported;
    private final Controller[] controllers;

    static {
        supported = false;
        if (getPrivilegedProperty("os.name", LibrariesRepository.MOJANG_MAVEN_REPO).trim().equals("Mac OS X")) {
            supported = true;
            loadLibrary("jinput-osx");
        }
    }

    public OSXEnvironmentPlugin() {
        if (isSupported()) {
            this.controllers = enumerateControllers();
            return;
        }
        this.controllers = new Controller[0];
    }

    static boolean access$002(boolean z) {
        boolean z2 = z;
        supported = z2;
        return z2;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<net.java.games.input.OSXHIDElement>, for r14v0, types: [java.util.List<net.java.games.input.OSXHIDElement>, java.util.List] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void addElements(net.java.games.input.OSXHIDQueue r13, java.util.List<net.java.games.input.OSXHIDElement> r14, java.util.List r15, boolean r16) throws java.io.IOException {
        /*
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r8 = r1
            java.util.Iterator r8 = r8.iterator()
            r4 = r8
        L_0x000b:
            r8 = r4
            boolean r8 = r8.hasNext()
            if (r8 == 0) goto L_0x0058
            r8 = r4
            java.lang.Object r8 = r8.next()
            net.java.games.input.OSXHIDElement r8 = (net.java.games.input.OSXHIDElement) r8
            r5 = r8
            r8 = r5
            net.java.games.input.Component$Identifier r8 = r8.getIdentifier()
            r6 = r8
            r8 = r6
            if (r8 == 0) goto L_0x000b
            r8 = r3
            if (r8 == 0) goto L_0x002e
            r8 = r6
            net.java.games.input.Component$Identifier$Button r9 = net.java.games.input.Component.Identifier.Button.f40_0
            if (r8 != r9) goto L_0x0046
            net.java.games.input.Component$Identifier$Button r8 = net.java.games.input.Component.Identifier.Button.LEFT
            r6 = r8
        L_0x002e:
            net.java.games.input.OSXComponent r8 = new net.java.games.input.OSXComponent
            r12 = r8
            r8 = r12
            r9 = r12
            r10 = r6
            r11 = r5
            r9.<init>(r10, r11)
            r7 = r8
            r8 = r2
            r9 = r7
            boolean r8 = r8.add(r9)
            r8 = r0
            r9 = r5
            r10 = r7
            r8.addElement(r9, r10)
            goto L_0x000b
        L_0x0046:
            r8 = r6
            net.java.games.input.Component$Identifier$Button r9 = net.java.games.input.Component.Identifier.Button.f41_1
            if (r8 != r9) goto L_0x004f
            net.java.games.input.Component$Identifier$Button r8 = net.java.games.input.Component.Identifier.Button.RIGHT
            r6 = r8
            goto L_0x002e
        L_0x004f:
            r8 = r6
            net.java.games.input.Component$Identifier$Button r9 = net.java.games.input.Component.Identifier.Button.f42_2
            if (r8 != r9) goto L_0x002e
            net.java.games.input.Component$Identifier$Button r8 = net.java.games.input.Component.Identifier.Button.MIDDLE
            r6 = r8
            goto L_0x002e
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.java.games.input.OSXEnvironmentPlugin.addElements(net.java.games.input.OSXHIDQueue, java.util.List, java.util.List, boolean):void");
    }

    private static final AbstractController createControllerFromDevice(OSXHIDDevice oSXHIDDevice, List list, Type type) throws IOException {
        ArrayList arrayList;
        OSXAbstractController oSXAbstractController;
        OSXHIDDevice oSXHIDDevice2 = oSXHIDDevice;
        List list2 = list;
        Type type2 = type;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        OSXHIDQueue createQueue = oSXHIDDevice2.createQueue(32);
        try {
            addElements(createQueue, list2, arrayList4, false);
            Component[] componentArr = new Component[arrayList4.size()];
            Object[] array = arrayList4.toArray(componentArr);
            OSXAbstractController oSXAbstractController2 = oSXAbstractController;
            OSXAbstractController oSXAbstractController3 = new OSXAbstractController(oSXHIDDevice2, createQueue, componentArr, new Controller[0], new Rumbler[0], type2);
            return oSXAbstractController2;
        } catch (IOException e) {
            IOException iOException = e;
            createQueue.release();
            throw iOException;
        }
    }

    private static final void createControllersFromDevice(OSXHIDDevice oSXHIDDevice, List list) throws IOException {
        OSXHIDDevice oSXHIDDevice2 = oSXHIDDevice;
        List list2 = list;
        UsagePair usagePair = oSXHIDDevice2.getUsagePair();
        if (usagePair != null) {
            List elements = oSXHIDDevice2.getElements();
            if (usagePair.getUsagePage() == UsagePage.GENERIC_DESKTOP && (usagePair.getUsage() == GenericDesktopUsage.MOUSE || usagePair.getUsage() == GenericDesktopUsage.POINTER)) {
                Mouse createMouseFromDevice = createMouseFromDevice(oSXHIDDevice2, elements);
                if (createMouseFromDevice != null) {
                    boolean add = list2.add(createMouseFromDevice);
                }
            } else if (usagePair.getUsagePage() == UsagePage.GENERIC_DESKTOP && (usagePair.getUsage() == GenericDesktopUsage.KEYBOARD || usagePair.getUsage() == GenericDesktopUsage.KEYPAD)) {
                Keyboard createKeyboardFromDevice = createKeyboardFromDevice(oSXHIDDevice2, elements);
                if (createKeyboardFromDevice != null) {
                    boolean add2 = list2.add(createKeyboardFromDevice);
                }
            } else if (usagePair.getUsagePage() == UsagePage.GENERIC_DESKTOP && usagePair.getUsage() == GenericDesktopUsage.JOYSTICK) {
                AbstractController createControllerFromDevice = createControllerFromDevice(oSXHIDDevice2, elements, Type.STICK);
                if (createControllerFromDevice != null) {
                    boolean add3 = list2.add(createControllerFromDevice);
                }
            } else if (usagePair.getUsagePage() == UsagePage.GENERIC_DESKTOP && usagePair.getUsage() == GenericDesktopUsage.GAME_PAD) {
                AbstractController createControllerFromDevice2 = createControllerFromDevice(oSXHIDDevice2, elements, Type.GAMEPAD);
                if (createControllerFromDevice2 != null) {
                    boolean add4 = list2.add(createControllerFromDevice2);
                }
            }
        }
    }

    private static final Keyboard createKeyboardFromDevice(OSXHIDDevice oSXHIDDevice, List list) throws IOException {
        ArrayList arrayList;
        OSXKeyboard oSXKeyboard;
        OSXHIDDevice oSXHIDDevice2 = oSXHIDDevice;
        List list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        OSXHIDQueue createQueue = oSXHIDDevice2.createQueue(32);
        try {
            addElements(createQueue, list2, arrayList4, false);
            Component[] componentArr = new Component[arrayList4.size()];
            Object[] array = arrayList4.toArray(componentArr);
            OSXKeyboard oSXKeyboard2 = oSXKeyboard;
            OSXKeyboard oSXKeyboard3 = new OSXKeyboard(oSXHIDDevice2, createQueue, componentArr, new Controller[0], new Rumbler[0]);
            return oSXKeyboard2;
        } catch (IOException e) {
            IOException iOException = e;
            createQueue.release();
            throw iOException;
        }
    }

    private static final Mouse createMouseFromDevice(OSXHIDDevice oSXHIDDevice, List list) throws IOException {
        ArrayList arrayList;
        OSXMouse oSXMouse;
        OSXHIDDevice oSXHIDDevice2 = oSXHIDDevice;
        List list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        OSXHIDQueue createQueue = oSXHIDDevice2.createQueue(32);
        try {
            addElements(createQueue, list2, arrayList4, true);
            Component[] componentArr = new Component[arrayList4.size()];
            Object[] array = arrayList4.toArray(componentArr);
            OSXMouse oSXMouse2 = oSXMouse;
            OSXMouse oSXMouse3 = new OSXMouse(oSXHIDDevice2, createQueue, componentArr, new Controller[0], new Rumbler[0]);
            OSXMouse oSXMouse4 = oSXMouse2;
            if (oSXMouse4.getPrimaryButton() != null && oSXMouse4.getX() != null && oSXMouse4.getY() != null) {
                return oSXMouse4;
            }
            createQueue.release();
            return null;
        } catch (IOException e) {
            IOException iOException = e;
            createQueue.release();
            throw iOException;
        }
    }

    private static final Controller[] enumerateControllers() {
        ArrayList arrayList;
        StringBuffer stringBuffer;
        OSXHIDDeviceIterator oSXHIDDeviceIterator;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        boolean z;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        try {
            OSXHIDDeviceIterator oSXHIDDeviceIterator2 = oSXHIDDeviceIterator;
            OSXHIDDeviceIterator oSXHIDDeviceIterator3 = new OSXHIDDeviceIterator();
            OSXHIDDeviceIterator oSXHIDDeviceIterator4 = oSXHIDDeviceIterator2;
            while (true) {
                try {
                    OSXHIDDevice next = oSXHIDDeviceIterator4.next();
                    if (next == null) {
                        oSXHIDDeviceIterator4.close();
                        Controller[] controllerArr = new Controller[arrayList4.size()];
                        Object[] array = arrayList4.toArray(controllerArr);
                        return controllerArr;
                    }
                    try {
                        int size = arrayList4.size();
                        createControllersFromDevice(next, arrayList4);
                        z = size != arrayList4.size();
                    } catch (IOException e) {
                        IOException iOException = e;
                        StringBuffer stringBuffer4 = stringBuffer3;
                        StringBuffer stringBuffer5 = new StringBuffer();
                        logln(stringBuffer4.append("Failed to create controllers from device: ").append(next.getProductName()).toString());
                        z = false;
                    }
                    if (!z) {
                        next.release();
                    }
                } catch (IOException e2) {
                    IOException iOException2 = e2;
                    StringBuffer stringBuffer6 = stringBuffer2;
                    StringBuffer stringBuffer7 = new StringBuffer();
                    logln(stringBuffer6.append("Failed to enumerate device: ").append(iOException2.getMessage()).toString());
                } catch (Throwable th) {
                    Throwable th2 = th;
                    oSXHIDDeviceIterator4.close();
                    throw th2;
                }
            }
        } catch (IOException e3) {
            IOException iOException3 = e3;
            StringBuffer stringBuffer8 = stringBuffer;
            StringBuffer stringBuffer9 = new StringBuffer();
            log(stringBuffer8.append("Failed to enumerate devices: ").append(iOException3.getMessage()).toString());
            return new Controller[0];
        }
    }

    static String getPrivilegedProperty(String str) {
        C06242 r4;
        C06242 r1 = r4;
        C06242 r2 = new PrivilegedAction(str) {
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
        C06253 r6;
        C06253 r2 = r6;
        C06253 r3 = new PrivilegedAction(str, str2) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        if (r7 >= r1) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean isMacOSXEqualsOrBetterThan(int r14, int r15) {
        /*
            r0 = r14
            r1 = r15
            java.util.StringTokenizer r9 = new java.util.StringTokenizer
            r13 = r9
            r9 = r13
            r10 = r13
            java.lang.String r11 = "os.version"
            java.lang.String r11 = java.lang.System.getProperty(r11)
            java.lang.String r12 = "."
            r10.<init>(r11, r12)
            r2 = r9
            r9 = r2
            java.lang.String r9 = r9.nextToken()     // Catch:{ Exception -> 0x0040 }
            r4 = r9
            r9 = r2
            java.lang.String r9 = r9.nextToken()     // Catch:{ Exception -> 0x0040 }
            r5 = r9
            r9 = r4
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0040 }
            r6 = r9
            r9 = r5
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0040 }
            r7 = r9
            r9 = r6
            r10 = r0
            if (r9 > r10) goto L_0x003b
            r9 = 0
            r8 = r9
            r9 = r6
            r10 = r0
            if (r9 != r10) goto L_0x003d
            r9 = 0
            r8 = r9
            r9 = r7
            r10 = r1
            if (r9 < r10) goto L_0x003d
        L_0x003b:
            r9 = 1
            r8 = r9
        L_0x003d:
            r9 = r8
            r0 = r9
        L_0x003f:
            return r0
        L_0x0040:
            r9 = move-exception
            r3 = r9
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r13 = r9
            r9 = r13
            r10 = r13
            r10.<init>()
            java.lang.String r10 = "Exception occurred while trying to determine OS version: "
            java.lang.StringBuffer r9 = r9.append(r10)
            r10 = r3
            java.lang.StringBuffer r9 = r9.append(r10)
            java.lang.String r9 = r9.toString()
            logln(r9)
            r9 = 0
            r0 = r9
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: net.java.games.input.OSXEnvironmentPlugin.isMacOSXEqualsOrBetterThan(int, int):boolean");
    }

    static void loadLibrary(String str) {
        C06231 r4;
        C06231 r1 = r4;
        C06231 r2 = new PrivilegedAction(str) {
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
                    boolean access$002 = OSXEnvironmentPlugin.access$002(false);
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

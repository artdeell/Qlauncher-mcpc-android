package net.java.games.input;

import java.io.File;
import java.io.PrintStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import net.java.games.util.plugins.Plugins;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

class DefaultControllerEnvironment extends ControllerEnvironment {
    static Class class$net$java$games$input$ControllerEnvironment;
    static String libPath;
    private ArrayList controllers;
    private Collection loadedPlugins;

    public DefaultControllerEnvironment() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.loadedPlugins = arrayList2;
    }

    static void access$000(DefaultControllerEnvironment defaultControllerEnvironment) {
        defaultControllerEnvironment.scanControllers();
    }

    private void addControllers(Controller[] controllerArr) {
        Controller[] controllerArr2 = controllerArr;
        for (int i = 0; i < controllerArr2.length; i++) {
            boolean add = this.controllers.add(controllerArr2[i]);
        }
    }

    static Class class$(String str) {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError();
            throw noClassDefFoundError2.initCause(classNotFoundException);
        }
    }

    static String getPrivilegedProperty(String str) {
        C06062 r4;
        C06062 r1 = r4;
        C06062 r2 = new PrivilegedAction(str) {
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
        C06073 r6;
        C06073 r2 = r6;
        C06073 r3 = new PrivilegedAction(str, str2) {
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
        C06051 r4;
        C06051 r1 = r4;
        C06051 r2 = new PrivilegedAction(str) {
            private final String val$lib_name;

            {
                this.val$lib_name = r5;
            }

            public final Object run() {
                StringBuffer stringBuffer;
                String property = System.getProperty("net.java.games.input.librarypath");
                if (property != null) {
                    StringBuffer stringBuffer2 = stringBuffer;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    System.load(stringBuffer2.append(property).append(File.separator).append(System.mapLibraryName(this.val$lib_name)).toString());
                } else {
                    System.loadLibrary(this.val$lib_name);
                }
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r1);
    }

    private void scanControllers() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        String privilegedProperty = getPrivilegedProperty("jinput.controllerPluginPath");
        if (privilegedProperty == null) {
            privilegedProperty = "controller";
        }
        StringBuffer stringBuffer3 = stringBuffer;
        StringBuffer stringBuffer4 = new StringBuffer();
        scanControllersAt(stringBuffer3.append(getPrivilegedProperty("java.home")).append(File.separator).append("lib").append(File.separator).append(privilegedProperty).toString());
        StringBuffer stringBuffer5 = stringBuffer2;
        StringBuffer stringBuffer6 = new StringBuffer();
        scanControllersAt(stringBuffer5.append(getPrivilegedProperty("user.dir")).append(File.separator).append(privilegedProperty).toString());
    }

    private void scanControllersAt(String str) {
        File file;
        Plugins plugins;
        Class cls;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        File file2 = file;
        File file3 = new File(str);
        File file4 = file2;
        if (file4.exists()) {
            try {
                Plugins plugins2 = plugins;
                Plugins plugins3 = new Plugins(file4);
                Plugins plugins4 = plugins2;
                if (class$net$java$games$input$ControllerEnvironment == null) {
                    cls = class$("net.java.games.input.ControllerEnvironment");
                    class$net$java$games$input$ControllerEnvironment = cls;
                } else {
                    cls = class$net$java$games$input$ControllerEnvironment;
                }
                Class[] clsArr = plugins4.getExtends(cls);
                int i = 0;
                while (true) {
                    if (i < clsArr.length) {
                        try {
                            StringBuffer stringBuffer3 = stringBuffer;
                            StringBuffer stringBuffer4 = new StringBuffer();
                            ControllerEnvironment.logln(stringBuffer3.append("ControllerEnvironment ").append(clsArr[i].getName()).append(" loaded by ").append(clsArr[i].getClassLoader()).toString());
                            ControllerEnvironment controllerEnvironment = (ControllerEnvironment) clsArr[i].newInstance();
                            if (controllerEnvironment.isSupported()) {
                                addControllers(controllerEnvironment.getControllers());
                                boolean add = this.loadedPlugins.add(controllerEnvironment.getClass().getName());
                            } else {
                                StringBuffer stringBuffer5 = stringBuffer2;
                                StringBuffer stringBuffer6 = new StringBuffer();
                                logln(stringBuffer5.append(clsArr[i].getName()).append(" is not supported").toString());
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Controller[] getControllers() {
        ArrayList arrayList;
        C06084 r17;
        StringBuffer stringBuffer;
        StringTokenizer stringTokenizer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        StringBuffer stringBuffer6;
        StringBuffer stringBuffer7;
        StringBuffer stringBuffer8;
        StringBuffer stringBuffer9;
        StringBuffer stringBuffer10;
        if (this.controllers == null) {
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.controllers = arrayList2;
            C06084 r13 = r17;
            C06084 r14 = new PrivilegedAction(this) {
                private final DefaultControllerEnvironment this$0;

                {
                    this.this$0 = r5;
                }

                public Object run() {
                    DefaultControllerEnvironment.access$000(this.this$0);
                    return null;
                }
            };
            Object doPrivileged = AccessController.doPrivileged(r13);
            StringBuffer stringBuffer11 = stringBuffer;
            StringBuffer stringBuffer12 = new StringBuffer();
            String stringBuffer13 = stringBuffer11.append(getPrivilegedProperty("jinput.plugins", LibrariesRepository.MOJANG_MAVEN_REPO)).append(" ").append(getPrivilegedProperty("net.java.games.input.plugins", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
            if (!getPrivilegedProperty("jinput.useDefaultPlugin", "true").toLowerCase().trim().equals("false") && !getPrivilegedProperty("net.java.games.input.useDefaultPlugin", "true").toLowerCase().trim().equals("false")) {
                String trim = getPrivilegedProperty("os.name", LibrariesRepository.MOJANG_MAVEN_REPO).trim();
                if (trim.equals("Linux")) {
                    StringBuffer stringBuffer14 = stringBuffer10;
                    StringBuffer stringBuffer15 = new StringBuffer();
                    stringBuffer13 = stringBuffer14.append(stringBuffer13).append(" net.java.games.input.LinuxEnvironmentPlugin").toString();
                } else if (trim.equals("Mac OS X")) {
                    StringBuffer stringBuffer16 = stringBuffer9;
                    StringBuffer stringBuffer17 = new StringBuffer();
                    stringBuffer13 = stringBuffer16.append(stringBuffer13).append(" net.java.games.input.OSXEnvironmentPlugin").toString();
                } else if (trim.equals("Windows XP") || trim.equals("Windows Vista")) {
                    StringBuffer stringBuffer18 = stringBuffer4;
                    StringBuffer stringBuffer19 = new StringBuffer();
                    stringBuffer13 = stringBuffer18.append(stringBuffer13).append(" net.java.games.input.DirectAndRawInputEnvironmentPlugin").toString();
                } else if (trim.equals("Windows 98") || trim.equals("Windows 2000")) {
                    StringBuffer stringBuffer20 = stringBuffer5;
                    StringBuffer stringBuffer21 = new StringBuffer();
                    stringBuffer13 = stringBuffer20.append(stringBuffer13).append(" net.java.games.input.DirectInputEnvironmentPlugin").toString();
                } else if (trim.startsWith("Windows")) {
                    PrintStream printStream = System.out;
                    StringBuffer stringBuffer22 = stringBuffer7;
                    StringBuffer stringBuffer23 = new StringBuffer();
                    printStream.println(stringBuffer22.append("WARNING: Found unknown Windows version: ").append(trim).toString());
                    System.out.println("Attempting to use default windows plug-in.");
                    System.out.flush();
                    StringBuffer stringBuffer24 = stringBuffer8;
                    StringBuffer stringBuffer25 = new StringBuffer();
                    stringBuffer13 = stringBuffer24.append(stringBuffer13).append(" net.java.games.input.DirectAndRawInputEnvironmentPlugin").toString();
                } else {
                    PrintStream printStream2 = System.out;
                    StringBuffer stringBuffer26 = stringBuffer6;
                    StringBuffer stringBuffer27 = new StringBuffer();
                    printStream2.println(stringBuffer26.append("Trying to use default plugin, OS name ").append(trim).append(" not recognised").toString());
                }
            }
            StringTokenizer stringTokenizer2 = stringTokenizer;
            StringTokenizer stringTokenizer3 = new StringTokenizer(stringBuffer13, " \t\n\r\f,;:");
            StringTokenizer stringTokenizer4 = stringTokenizer2;
            while (stringTokenizer4.hasMoreTokens()) {
                String nextToken = stringTokenizer4.nextToken();
                try {
                    if (!this.loadedPlugins.contains(nextToken)) {
                        PrintStream printStream3 = System.out;
                        StringBuffer stringBuffer28 = stringBuffer2;
                        StringBuffer stringBuffer29 = new StringBuffer();
                        printStream3.println(stringBuffer28.append("Loading: ").append(nextToken).toString());
                        Class cls = Class.forName(nextToken);
                        ControllerEnvironment controllerEnvironment = (ControllerEnvironment) cls.newInstance();
                        if (controllerEnvironment.isSupported()) {
                            addControllers(controllerEnvironment.getControllers());
                            boolean add = this.loadedPlugins.add(controllerEnvironment.getClass().getName());
                        } else {
                            StringBuffer stringBuffer30 = stringBuffer3;
                            StringBuffer stringBuffer31 = new StringBuffer();
                            logln(stringBuffer30.append(cls.getName()).append(" is not supported").toString());
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        Controller[] controllerArr = new Controller[this.controllers.size()];
        Iterator it = this.controllers.iterator();
        int i = 0;
        while (it.hasNext()) {
            controllerArr[i] = (Controller) it.next();
            i++;
        }
        return controllerArr;
    }

    public boolean isSupported() {
        return true;
    }
}

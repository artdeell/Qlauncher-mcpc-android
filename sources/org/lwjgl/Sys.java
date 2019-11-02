package org.lwjgl;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.input.Mouse;

public final class Sys {
    private static final String JNI_LIBRARY_NAME = "lwjgl";
    private static final String POSTFIX64BIT = "64";
    private static final String VERSION = "2.9.1";
    private static final SysImplementation implementation = createImplementation();
    private static final boolean is64Bit = (implementation.getPointerSize() == 8);

    static {
        LinkageError linkageError;
        StringBuilder sb;
        loadLibrary(JNI_LIBRARY_NAME);
        int jNIVersion = implementation.getJNIVersion();
        int requiredJNIVersion = implementation.getRequiredJNIVersion();
        if (jNIVersion != requiredJNIVersion) {
            LinkageError linkageError2 = linkageError;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LinkageError linkageError3 = new LinkageError(sb2.append("Version mismatch: jar version is '").append(requiredJNIVersion).append("', native library version is '").append(jNIVersion).append("'").toString());
            throw linkageError2;
        }
        implementation.setDebug(LWJGLUtil.DEBUG);
    }

    private Sys() {
    }

    public static void alert(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        boolean isGrabbed = Mouse.isGrabbed();
        if (isGrabbed) {
            Mouse.setGrabbed(false);
        }
        if (str3 == null) {
            str3 = LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        if (str4 == null) {
            str4 = LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        implementation.alert(str3, str4);
        if (isGrabbed) {
            Mouse.setGrabbed(true);
        }
    }

    private static SysImplementation createImplementation() {
        AndroidSysImplementation androidSysImplementation;
        MacOSXSysImplementation macOSXSysImplementation;
        WindowsSysImplementation windowsSysImplementation;
        LinuxSysImplementation linuxSysImplementation;
        IllegalStateException illegalStateException;
        switch (LWJGLUtil.getPlatform()) {
            case 1:
                LinuxSysImplementation linuxSysImplementation2 = linuxSysImplementation;
                LinuxSysImplementation linuxSysImplementation3 = new LinuxSysImplementation();
                return linuxSysImplementation2;
            case 2:
                MacOSXSysImplementation macOSXSysImplementation2 = macOSXSysImplementation;
                MacOSXSysImplementation macOSXSysImplementation3 = new MacOSXSysImplementation();
                return macOSXSysImplementation2;
            case 3:
                WindowsSysImplementation windowsSysImplementation2 = windowsSysImplementation;
                WindowsSysImplementation windowsSysImplementation3 = new WindowsSysImplementation();
                return windowsSysImplementation2;
            case LWJGLUtil.PLATFORM_ANDROID /*1337*/:
                AndroidSysImplementation androidSysImplementation2 = androidSysImplementation;
                AndroidSysImplementation androidSysImplementation3 = new AndroidSysImplementation();
                return androidSysImplementation2;
            default:
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Unsupported platform");
                throw illegalStateException2;
        }
    }

    private static void doLoadLibrary(String str) {
        C07481 r4;
        C07481 r1 = r4;
        final String str2 = str;
        C07481 r2 = new PrivilegedAction<Object>() {
            public Object run() {
                StringBuilder sb;
                String property = System.getProperty("org.lwjgl.librarypath");
                if (property != null) {
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    System.load(sb2.append(property).append(File.separator).append(System.mapLibraryName(str2)).toString());
                } else {
                    System.loadLibrary(str2);
                }
                return null;
            }
        };
        Object doPrivileged = AccessController.doPrivileged(r1);
    }

    public static String getClipboard() {
        return implementation.getClipboard();
    }

    public static long getTime() {
        return Long.MAX_VALUE & implementation.getTime();
    }

    public static long getTimerResolution() {
        return implementation.getTimerResolution();
    }

    public static String getVersion() {
        return VERSION;
    }

    public static void initialize() {
    }

    public static boolean is64Bit() {
        return is64Bit;
    }

    private static void loadLibrary(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str2 = str;
        String property = System.getProperty("os.arch");
        if ("amd64".equals(property) || "x86_64".equals(property)) {
            try {
                StringBuilder sb5 = sb4;
                StringBuilder sb6 = new StringBuilder();
                doLoadLibrary(sb5.append(str2).append(POSTFIX64BIT).toString());
                return;
            } catch (UnsatisfiedLinkError e) {
                UnsatisfiedLinkError unsatisfiedLinkError = e;
                StringBuilder sb7 = sb3;
                StringBuilder sb8 = new StringBuilder();
                LWJGLUtil.log(sb7.append("Failed to load 64 bit library: ").append(unsatisfiedLinkError.getMessage()).toString());
            }
        }
        try {
            doLoadLibrary(str2);
        } catch (UnsatisfiedLinkError e2) {
            UnsatisfiedLinkError unsatisfiedLinkError2 = e2;
            if (implementation.has64Bit()) {
                try {
                    StringBuilder sb9 = sb2;
                    StringBuilder sb10 = new StringBuilder();
                    doLoadLibrary(sb9.append(str2).append(POSTFIX64BIT).toString());
                    return;
                } catch (UnsatisfiedLinkError e3) {
                    UnsatisfiedLinkError unsatisfiedLinkError3 = e3;
                    StringBuilder sb11 = sb;
                    StringBuilder sb12 = new StringBuilder();
                    LWJGLUtil.log(sb11.append("Failed to load 64 bit library: ").append(unsatisfiedLinkError3.getMessage()).toString());
                }
            }
            throw unsatisfiedLinkError2;
        }
    }

    public static boolean openURL(String str) {
        C07492 r14;
        C07503 r142;
        URL url;
        String str2 = str;
        try {
            Class cls = Class.forName("javax.jnlp.ServiceManager");
            C07492 r8 = r14;
            final Class cls2 = cls;
            C07492 r9 = new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    Class[] clsArr = new Class[1];
                    Class[] clsArr2 = clsArr;
                    clsArr[0] = String.class;
                    return cls2.getMethod("lookup", clsArr2);
                }
            };
            Method method = (Method) AccessController.doPrivileged(r8);
            Class cls3 = cls;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = "javax.jnlp.BasicService";
            Object invoke = method.invoke(cls3, objArr2);
            C07503 r82 = r142;
            final Class cls4 = Class.forName("javax.jnlp.BasicService");
            C07503 r92 = new PrivilegedExceptionAction<Method>() {
                public Method run() throws Exception {
                    Class[] clsArr = new Class[1];
                    Class[] clsArr2 = clsArr;
                    clsArr[0] = URL.class;
                    return cls4.getMethod("showDocument", clsArr2);
                }
            };
            Method method2 = (Method) AccessController.doPrivileged(r82);
            try {
                Object[] objArr3 = new Object[1];
                Object[] objArr4 = objArr3;
                URL url2 = url;
                URL url3 = new URL(str2);
                objArr4[0] = url2;
                return ((Boolean) method2.invoke(invoke, objArr3)).booleanValue();
            } catch (MalformedURLException e) {
                e.printStackTrace(System.err);
                return false;
            }
        } catch (Exception e2) {
            Exception exc = e2;
            return implementation.openURL(str2);
        }
    }
}

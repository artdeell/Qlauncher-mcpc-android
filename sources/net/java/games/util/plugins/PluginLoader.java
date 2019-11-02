package net.java.games.util.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginLoader extends URLClassLoader {
    static final boolean DEBUG = false;
    static Class class$net$java$games$util$plugins$Plugin;
    boolean localDLLs = true;
    File parentDir;

    public PluginLoader(File file) throws MalformedURLException {
        File file2 = file;
        super(new URL[]{file2.toURL()}, Thread.currentThread().getContextClassLoader());
        this.parentDir = file2.getParentFile();
        if (System.getProperty("net.java.games.util.plugins.nolocalnative") != null) {
            this.localDLLs = false;
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

    private boolean classImplementsPlugin(Class cls) {
        Class cls2;
        Class cls3 = cls;
        boolean z = true;
        if (cls3 == null) {
            z = false;
        } else {
            Class[] interfaces = cls3.getInterfaces();
            int i = 0;
            while (true) {
                if (i < interfaces.length) {
                    Class cls4 = interfaces[i];
                    if (class$net$java$games$util$plugins$Plugin == null) {
                        cls2 = class$("net.java.games.util.plugins.Plugin");
                        class$net$java$games$util$plugins$Plugin = cls2;
                    } else {
                        cls2 = class$net$java$games$util$plugins$Plugin;
                    }
                    if (cls4 == cls2) {
                        break;
                    }
                    i++;
                } else {
                    int i2 = 0;
                    while (i2 < interfaces.length) {
                        if (!classImplementsPlugin(interfaces[i2])) {
                            i2++;
                        }
                    }
                    return classImplementsPlugin(cls3.getSuperclass());
                }
            }
        }
        return z;
    }

    public boolean attemptPluginDefine(Class cls) {
        Class cls2 = cls;
        return !cls2.isInterface() && classImplementsPlugin(cls2);
    }

    /* access modifiers changed from: protected */
    public String findLibrary(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        if (!this.localDLLs) {
            return super.findLibrary(str2);
        }
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append(this.parentDir.getPath()).append(File.separator).append(System.mapLibraryName(str2)).toString();
    }
}

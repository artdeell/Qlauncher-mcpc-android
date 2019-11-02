package net.java.games.util.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Plugins {
    static final boolean DEBUG = true;
    List pluginList;

    public Plugins(File file) throws IOException {
        ArrayList arrayList;
        File file2 = file;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.pluginList = arrayList2;
        scanPlugins(file2);
    }

    private boolean classExtends(Class cls, Class cls2) {
        Class cls3 = cls;
        Class cls4 = cls2;
        if (cls3 == null) {
            return false;
        }
        if (cls3 == cls4) {
            return true;
        }
        return classExtends(cls3.getSuperclass(), cls4);
    }

    private boolean classImplementsAll(Class cls, Set set) {
        Class cls2 = cls;
        Set set2 = set;
        boolean z = true;
        if (cls2 == null) {
            z = false;
        } else {
            Class[] interfaces = cls2.getInterfaces();
            int i = 0;
            while (true) {
                if (i < interfaces.length) {
                    if (set2.contains(interfaces[i])) {
                        boolean remove = set2.remove(interfaces[i]);
                        if (set2.size() == 0) {
                            break;
                        }
                    }
                    i++;
                } else {
                    int i2 = 0;
                    while (i2 < interfaces.length) {
                        if (!classImplementsAll(interfaces[i2], set2)) {
                            i2++;
                        }
                    }
                    return classImplementsAll(cls2.getSuperclass(), set2);
                }
            }
        }
        return z;
    }

    private boolean classImplementsAny(Class cls, Set set) {
        Class cls2 = cls;
        Set set2 = set;
        boolean z = true;
        if (cls2 == null) {
            z = false;
        } else {
            Class[] interfaces = cls2.getInterfaces();
            int i = 0;
            while (true) {
                if (i < interfaces.length) {
                    if (set2.contains(interfaces[i])) {
                        break;
                    }
                    i++;
                } else {
                    int i2 = 0;
                    while (i2 < interfaces.length) {
                        if (!classImplementsAny(interfaces[i2], set2)) {
                            i2++;
                        }
                    }
                    return classImplementsAny(cls2.getSuperclass(), set2);
                }
            }
        }
        return z;
    }

    private void processJar(File file) {
        StringBuffer stringBuffer;
        PluginLoader pluginLoader;
        JarFile jarFile;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        File file2 = file;
        try {
            PrintStream printStream = System.out;
            StringBuffer stringBuffer5 = stringBuffer;
            StringBuffer stringBuffer6 = new StringBuffer();
            printStream.println(stringBuffer5.append("Scanning jar: ").append(file2.getName()).toString());
            PluginLoader pluginLoader2 = pluginLoader;
            PluginLoader pluginLoader3 = new PluginLoader(file2);
            PluginLoader pluginLoader4 = pluginLoader2;
            JarFile jarFile2 = jarFile;
            JarFile jarFile3 = new JarFile(file2);
            Enumeration entries = jarFile2.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                PrintStream printStream2 = System.out;
                StringBuffer stringBuffer7 = stringBuffer2;
                StringBuffer stringBuffer8 = new StringBuffer();
                printStream2.println(stringBuffer7.append("Examining file : ").append(jarEntry.getName()).toString());
                if (jarEntry.getName().endsWith("Plugin.class")) {
                    PrintStream printStream3 = System.out;
                    StringBuffer stringBuffer9 = stringBuffer3;
                    StringBuffer stringBuffer10 = new StringBuffer();
                    printStream3.println(stringBuffer9.append("Found candidate class: ").append(jarEntry.getName()).toString());
                    String name = jarEntry.getName();
                    Class loadClass = pluginLoader4.loadClass(name.substring(0, -6 + name.length()).replace(ClassPathElement.SEPARATOR_CHAR, '.'));
                    if (pluginLoader4.attemptPluginDefine(loadClass)) {
                        PrintStream printStream4 = System.out;
                        StringBuffer stringBuffer11 = stringBuffer4;
                        StringBuffer stringBuffer12 = new StringBuffer();
                        printStream4.println(stringBuffer11.append("Adding class to plugins:").append(loadClass.getName()).toString());
                        boolean add = this.pluginList.add(loadClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void scanPlugins(File file) throws IOException {
        FileNotFoundException fileNotFoundException;
        StringBuffer stringBuffer;
        File file2 = file;
        File[] listFiles = file2.listFiles();
        if (listFiles == null) {
            FileNotFoundException fileNotFoundException2 = fileNotFoundException;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            FileNotFoundException fileNotFoundException3 = new FileNotFoundException(stringBuffer2.append("Plugin directory ").append(file2.getName()).append(" not found.").toString());
            throw fileNotFoundException2;
        }
        for (int i = 0; i < listFiles.length; i++) {
            File file3 = listFiles[i];
            if (file3.getName().endsWith(".jar")) {
                processJar(file3);
            } else if (file3.isDirectory()) {
                scanPlugins(file3);
            }
        }
    }

    public Class[] get() {
        return (Class[]) this.pluginList.toArray(new Class[this.pluginList.size()]);
    }

    public Class[] getExtends(Class cls) {
        ArrayList arrayList;
        Class cls2 = cls;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.pluginList.size());
        ArrayList arrayList4 = arrayList2;
        for (Class cls3 : this.pluginList) {
            if (classExtends(cls3, cls2)) {
                boolean add = arrayList4.add(cls3);
            }
        }
        return (Class[]) arrayList4.toArray(new Class[arrayList4.size()]);
    }

    public Class[] getImplementsAll(Class[] clsArr) {
        ArrayList arrayList;
        HashSet hashSet;
        Class[] clsArr2 = clsArr;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.pluginList.size());
        ArrayList arrayList4 = arrayList2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        for (int i = 0; i < clsArr2.length; i++) {
            boolean add = hashSet4.add(clsArr2[i]);
        }
        for (Class cls : this.pluginList) {
            if (classImplementsAll(cls, hashSet4)) {
                boolean add2 = arrayList4.add(cls);
            }
        }
        return (Class[]) arrayList4.toArray(new Class[arrayList4.size()]);
    }

    public Class[] getImplementsAny(Class[] clsArr) {
        ArrayList arrayList;
        HashSet hashSet;
        Class[] clsArr2 = clsArr;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.pluginList.size());
        ArrayList arrayList4 = arrayList2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = hashSet2;
        for (int i = 0; i < clsArr2.length; i++) {
            boolean add = hashSet4.add(clsArr2[i]);
        }
        for (Class cls : this.pluginList) {
            if (classImplementsAny(cls, hashSet4)) {
                boolean add2 = arrayList4.add(cls);
            }
        }
        return (Class[]) arrayList4.toArray(new Class[arrayList4.size()]);
    }
}

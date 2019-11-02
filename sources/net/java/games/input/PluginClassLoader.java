package net.java.games.input;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

class PluginClassLoader extends ClassLoader {
    static final boolean $assertionsDisabled;
    private static final FileFilter JAR_FILTER;
    static Class class$net$java$games$input$PluginClassLoader;
    private static String pluginDirectory;

    /* renamed from: net.java.games.input.PluginClassLoader$1 */
    static class C06261 {
    }

    private static class JarFileFilter implements FileFilter {
        private JarFileFilter() {
        }

        JarFileFilter(C06261 r4) {
            C06261 r1 = r4;
            this();
        }

        public boolean accept(File file) {
            return file.getName().toUpperCase().endsWith(".JAR");
        }
    }

    static {
        Class cls;
        JarFileFilter jarFileFilter;
        if (class$net$java$games$input$PluginClassLoader == null) {
            cls = class$("net.java.games.input.PluginClassLoader");
            class$net$java$games$input$PluginClassLoader = cls;
        } else {
            cls = class$net$java$games$input$PluginClassLoader;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
        JarFileFilter jarFileFilter2 = jarFileFilter;
        JarFileFilter jarFileFilter3 = new JarFileFilter(null);
        JAR_FILTER = jarFileFilter2;
    }

    public PluginClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
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

    private byte[] loadClassData(String str) throws ClassNotFoundException {
        ClassNotFoundException classNotFoundException;
        StringBuffer stringBuffer;
        String str2 = str;
        if (pluginDirectory == null) {
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            pluginDirectory = stringBuffer2.append(DefaultControllerEnvironment.libPath).append(File.separator).append("controller").toString();
        }
        try {
            return loadClassFromDirectory(str2);
        } catch (Exception e) {
            Exception exc = e;
            try {
                return loadClassFromJAR(str2);
            } catch (IOException e2) {
                IOException iOException = e2;
                ClassNotFoundException classNotFoundException2 = classNotFoundException;
                ClassNotFoundException classNotFoundException3 = new ClassNotFoundException(str2, iOException);
                throw classNotFoundException2;
            }
        }
    }

    private byte[] loadClassFromDirectory(String str) throws ClassNotFoundException, IOException {
        StringTokenizer stringTokenizer;
        StringBuffer stringBuffer;
        File file;
        FileInputStream fileInputStream;
        AssertionError assertionError;
        AssertionError assertionError2;
        ClassNotFoundException classNotFoundException;
        String str2 = str;
        StringTokenizer stringTokenizer2 = stringTokenizer;
        StringTokenizer stringTokenizer3 = new StringTokenizer(str2, ".");
        StringTokenizer stringTokenizer4 = stringTokenizer2;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(pluginDirectory);
        StringBuffer stringBuffer4 = stringBuffer2;
        while (stringTokenizer4.hasMoreTokens()) {
            StringBuffer append = stringBuffer4.append(File.separator);
            StringBuffer append2 = stringBuffer4.append(stringTokenizer4.nextToken());
        }
        StringBuffer append3 = stringBuffer4.append(".class");
        File file2 = file;
        File file3 = new File(stringBuffer4.toString());
        File file4 = file2;
        if (!file4.exists()) {
            ClassNotFoundException classNotFoundException2 = classNotFoundException;
            ClassNotFoundException classNotFoundException3 = new ClassNotFoundException(str2);
            throw classNotFoundException2;
        }
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file4);
        FileInputStream fileInputStream4 = fileInputStream2;
        if ($assertionsDisabled || file4.length() <= 2147483647L) {
            int length = (int) file4.length();
            byte[] bArr = new byte[length];
            int read = fileInputStream4.read(bArr);
            if ($assertionsDisabled || length == read) {
                return bArr;
            }
            AssertionError assertionError3 = assertionError;
            AssertionError assertionError4 = new AssertionError();
            throw assertionError3;
        }
        AssertionError assertionError5 = assertionError2;
        AssertionError assertionError6 = new AssertionError();
        throw assertionError5;
    }

    private byte[] loadClassFromJAR(String str) throws ClassNotFoundException, IOException {
        File file;
        FileNotFoundException fileNotFoundException;
        JarFile jarFile;
        StringBuffer stringBuffer;
        AssertionError assertionError;
        AssertionError assertionError2;
        AssertionError assertionError3;
        ClassNotFoundException classNotFoundException;
        StringBuffer stringBuffer2;
        String str2 = str;
        File file2 = file;
        File file3 = new File(pluginDirectory);
        File[] listFiles = file2.listFiles(JAR_FILTER);
        if (listFiles == null) {
            ClassNotFoundException classNotFoundException2 = classNotFoundException;
            StringBuffer stringBuffer3 = stringBuffer2;
            StringBuffer stringBuffer4 = new StringBuffer();
            ClassNotFoundException classNotFoundException3 = new ClassNotFoundException(stringBuffer3.append("Could not find class ").append(str2).toString());
            throw classNotFoundException2;
        }
        for (int i = 0; i < listFiles.length; i++) {
            JarFile jarFile2 = jarFile;
            JarFile jarFile3 = new JarFile(listFiles[i]);
            JarFile jarFile4 = jarFile2;
            JarFile jarFile5 = jarFile4;
            StringBuffer stringBuffer5 = stringBuffer;
            StringBuffer stringBuffer6 = new StringBuffer();
            JarEntry jarEntry = jarFile5.getJarEntry(stringBuffer5.append(str2).append(".class").toString());
            if (jarEntry != null) {
                InputStream inputStream = jarFile4.getInputStream(jarEntry);
                if ($assertionsDisabled || jarEntry.getSize() <= 2147483647L) {
                    int size = (int) jarEntry.getSize();
                    if ($assertionsDisabled || size >= 0) {
                        byte[] bArr = new byte[size];
                        int read = inputStream.read(bArr);
                        if ($assertionsDisabled || size == read) {
                            return bArr;
                        }
                        AssertionError assertionError4 = assertionError;
                        AssertionError assertionError5 = new AssertionError();
                        throw assertionError4;
                    }
                    AssertionError assertionError6 = assertionError2;
                    AssertionError assertionError7 = new AssertionError();
                    throw assertionError6;
                }
                AssertionError assertionError8 = assertionError3;
                AssertionError assertionError9 = new AssertionError();
                throw assertionError8;
            }
        }
        FileNotFoundException fileNotFoundException2 = fileNotFoundException;
        FileNotFoundException fileNotFoundException3 = new FileNotFoundException(str2);
        throw fileNotFoundException2;
    }

    /* access modifiers changed from: protected */
    public Class findClass(String str) throws ClassNotFoundException {
        String str2 = str;
        byte[] loadClassData = loadClassData(str2);
        return defineClass(str2, loadClassData, 0, loadClassData.length);
    }
}

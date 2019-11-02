package org.lwjgl.util.applet;

import java.applet.Applet;
import java.applet.AppletStub;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.MediaTracker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;
import java.util.zip.GZIPInputStream;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class AppletLoader extends Applet implements Runnable, AppletStub {
    public static final int STATE_CHECKING_CACHE = 4;
    public static final int STATE_CHECKING_FOR_UPDATES = 5;
    public static final int STATE_CHECK_JRE_VERSION = 2;
    public static final int STATE_DETERMINING_PACKAGES = 3;
    public static final int STATE_DONE = 13;
    public static final int STATE_DOWNLOADING = 6;
    public static final int STATE_EXTRACTING_PACKAGES = 7;
    public static final int STATE_INIT = 1;
    public static final int STATE_INITIALIZE_REAL_APPLET = 11;
    public static final int STATE_START_REAL_APPLET = 12;
    public static final int STATE_SWITCHING_APPLET = 10;
    public static final int STATE_UPDATING_CLASSPATH = 9;
    public static final int STATE_VALIDATING_PACKAGES = 8;
    protected static boolean natives_loaded;
    protected Thread animationThread;
    protected Color bgColor = Color.white;
    protected boolean cacheEnabled;
    protected boolean certificateRefused;
    protected String[] certificateRefusedMessage;
    protected ClassLoader classLoader;
    protected int concurrentLookupThreads;
    protected int currentSizeExtract;
    protected boolean debugMode;
    protected String[] errorMessage;
    protected boolean fatalError;
    protected Color fgColor = Color.black;
    protected int[] fileSizes;
    protected HashMap<String, Long> filesLastModified;
    protected String[] genericErrorMessage;
    protected boolean headless = false;
    protected String[] headlessMessage;
    protected boolean headlessWaiting = true;
    protected Thread loaderThread;
    protected Image logo;
    protected Image logoBuffer;
    protected Applet lwjglApplet;
    protected boolean lzmaSupported;
    protected String[] minimumJREMessage;
    protected boolean minimumJreNotFound;
    protected int nativeJarCount;
    protected Image offscreen;
    protected boolean pack200Supported;
    protected boolean painting;
    protected volatile int percentage;
    protected boolean prependHost;
    protected Image progressbar;
    protected Image progressbarBuffer;
    protected volatile int state = 1;
    protected String subtaskMessage = LibrariesRepository.MOJANG_MAVEN_REPO;
    protected int totalDownloadSize;
    protected int totalSizeExtract;
    protected URL[] urlList;

    public AppletLoader() {
        String[] strArr = new String[3];
        String[] strArr2 = strArr;
        strArr[0] = "An error occured while loading the applet.";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "Please contact support to resolve this issue.";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "<placeholder for error message>";
        this.genericErrorMessage = strArr6;
        String[] strArr7 = new String[3];
        String[] strArr8 = strArr7;
        strArr7[0] = "Permissions for Applet Refused.";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[1] = "Please accept the permissions dialog to allow";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[2] = "the applet to continue the loading process.";
        this.certificateRefusedMessage = strArr12;
        String[] strArr13 = new String[3];
        String[] strArr14 = strArr13;
        strArr13[0] = "Your version of Java is out of date.";
        String[] strArr15 = strArr14;
        String[] strArr16 = strArr15;
        strArr15[1] = "Visit java.com to get the latest version.";
        String[] strArr17 = strArr16;
        String[] strArr18 = strArr17;
        strArr17[2] = "Java <al_min_jre> or greater is required.";
        this.minimumJREMessage = strArr18;
    }

    protected static boolean certificatesMatch(Certificate[] certificateArr, Certificate[] certificateArr2) throws Exception {
        StringBuilder sb;
        Certificate[] certificateArr3 = certificateArr;
        Certificate[] certificateArr4 = certificateArr2;
        if (certificateArr3 == null || certificateArr4 == null) {
            return false;
        }
        if (certificateArr3.length != certificateArr4.length) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("Certificate chain differs in length [").append(certificateArr3.length).append(" vs ").append(certificateArr4.length).append("]!").toString());
            return false;
        }
        for (int i = 0; i < certificateArr3.length; i++) {
            if (!certificateArr3[i].equals(certificateArr4[i])) {
                System.out.println("Certificate mismatch found!");
                return false;
            }
        }
        return true;
    }

    private static String generateStacktrace(Exception exc) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        Exception exc2 = exc;
        StringWriter stringWriter2 = stringWriter;
        StringWriter stringWriter3 = new StringWriter();
        StringWriter stringWriter4 = stringWriter2;
        Exception exc3 = exc2;
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(stringWriter4);
        exc3.printStackTrace(printWriter2);
        return stringWriter4.toString();
    }

    protected static Certificate[] getCurrentCertificates() throws Exception {
        URL url;
        StringBuilder sb;
        Certificate[] certificates = AppletLoader.class.getProtectionDomain().getCodeSource().getCertificates();
        if (certificates == null) {
            URL location = AppletLoader.class.getProtectionDomain().getCodeSource().getLocation();
            URL url2 = url;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            URL url3 = new URL(sb2.append("jar:").append(location.toString()).append("!/org/lwjgl/util/applet/AppletLoader.class").toString());
            JarURLConnection jarURLConnection = (JarURLConnection) url2.openConnection();
            jarURLConnection.setDefaultUseCaches(true);
            certificates = jarURLConnection.getCertificates();
            jarURLConnection.setDefaultUseCaches(false);
        }
        return certificates;
    }

    private void unloadNatives(String str) {
        File file;
        String str2 = str;
        if (natives_loaded) {
            try {
                Field declaredField = ClassLoader.class.getDeclaredField("loadedLibraryNames");
                declaredField.setAccessible(true);
                Vector vector = (Vector) declaredField.get(getClass().getClassLoader());
                File file2 = file;
                File file3 = new File(str2);
                String canonicalPath = file2.getCanonicalPath();
                int i = 0;
                while (i < vector.size()) {
                    if (((String) vector.get(i)).startsWith(canonicalPath)) {
                        Object remove = vector.remove(i);
                        i--;
                    }
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void appletResize(int i, int i2) {
        resize(i, i2);
    }

    /* access modifiers changed from: protected */
    public void cleanUp() {
        this.progressbar = null;
        this.logo = null;
        this.logoBuffer = null;
        this.progressbarBuffer = null;
        this.offscreen = null;
    }

    /* access modifiers changed from: protected */
    public boolean compareVersion(File file, String str) {
        StringBuilder sb;
        File file2 = file;
        String str2 = str;
        if (file2.exists()) {
            String readStringFile = readStringFile(file2);
            if (readStringFile != null && readStringFile.equals(str2)) {
                this.percentage = 90;
                if (this.debugMode) {
                    PrintStream printStream = System.out;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    printStream.println(sb2.append("Loading Cached Applet Version: ").append(str2).toString());
                }
                debug_sleep(2000);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void debug_sleep(long j) {
        long j2 = j;
        if (this.debugMode) {
            sleep(j2);
        }
    }

    public void destroy() {
        if (this.lwjglApplet != null) {
            this.lwjglApplet.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void downloadJars(String str) throws Exception {
        String fileName;
        int i;
        Exception exc;
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        StringBuilder sb2;
        FileOutputStream fileOutputStream2;
        int i2;
        Exception exc2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        String str2 = str;
        setState(6);
        this.percentage = 15;
        int i3 = 0;
        th = new byte[65536];
        int i4 = 0;
        loop0:
        while (true) {
            if (i4 < this.urlList.length) {
                if (this.fileSizes[i4] != -2) {
                    int i5 = 0;
                    boolean z = true;
                    fileName = getFileName(this.urlList[i4]);
                    while (z) {
                        debug_sleep(2000);
                        try {
                            URLConnection openConnection = this.urlList[i4].openConnection();
                            openConnection.setUseCaches(false);
                            if (openConnection instanceof HttpURLConnection) {
                                openConnection.setRequestProperty("Cache-Control", "no-store,max-age=0,no-cache");
                                openConnection.connect();
                            }
                            i = getJarInputStream(fileName, openConnection);
                            FileOutputStream fileOutputStream3 = fileOutputStream;
                            StringBuilder sb7 = sb2;
                            StringBuilder sb8 = new StringBuilder();
                            FileOutputStream fileOutputStream4 = new FileOutputStream(sb7.append(str2).append(fileName).toString());
                            fileOutputStream2 = fileOutputStream3;
                            i2 = 0;
                            long currentTimeMillis = System.currentTimeMillis();
                            int i6 = 0;
                            String str3 = LibrariesRepository.MOJANG_MAVEN_REPO;
                            while (true) {
                                int read = i.read(th, 0, th.length);
                                if (read == -1) {
                                    break;
                                }
                                debug_sleep(10);
                                fileOutputStream2.write(th, 0, read);
                                i2 += read;
                                int i7 = i3 + i2;
                                this.percentage = 15 + ((i7 * 45) / this.totalDownloadSize);
                                StringBuilder sb9 = sb4;
                                StringBuilder sb10 = new StringBuilder();
                                this.subtaskMessage = sb9.append("Retrieving: ").append(fileName).append(" ").append((i7 * 100) / this.totalDownloadSize).append("%").toString();
                                i6 += read;
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (currentTimeMillis2 >= 1000) {
                                    float f = ((float) ((int) (100.0f * (((float) i6) / ((float) currentTimeMillis2))))) / 100.0f;
                                    StringBuilder sb11 = sb6;
                                    StringBuilder sb12 = new StringBuilder();
                                    str3 = sb11.append(" - ").append(f).append(" KB/sec").toString();
                                    i6 = 0;
                                    currentTimeMillis = System.currentTimeMillis();
                                }
                                StringBuilder sb13 = sb5;
                                StringBuilder sb14 = new StringBuilder();
                                this.subtaskMessage = sb13.append(this.subtaskMessage).append(str3).toString();
                            }
                            i.close();
                            fileOutputStream2.close();
                            if (openConnection instanceof HttpURLConnection) {
                                if (i2 != this.fileSizes[i4]) {
                                    if (this.fileSizes[i4] > 0 || i2 == 0) {
                                        Exception exc3 = exc2;
                                        StringBuilder sb15 = sb3;
                                        StringBuilder sb16 = new StringBuilder();
                                        Exception exc4 = new Exception(sb15.append("size mismatch on download of ").append(fileName).append(" expected ").append(this.fileSizes[i4]).append(" got ").append(i2).toString());
                                    }
                                }
                            }
                            i3 += this.fileSizes[i4];
                            z = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                            i5++;
                            if (i5 < 3) {
                                z = true;
                                Thread.sleep(100);
                            } else {
                                Exception exc5 = exc;
                                StringBuilder sb17 = sb;
                                StringBuilder sb18 = new StringBuilder();
                                Exception exc6 = new Exception(sb17.append("failed to download ").append(fileName).append(" after ").append(3).append(" attempts").toString());
                                throw exc5;
                            }
                        } finally {
                            int i8 = th;
                            i.close();
                            fileOutputStream2.close();
                            Throwable th = i8;
                        }
                    }
                    continue;
                }
                i4++;
            } else {
                this.subtaskMessage = LibrariesRepository.MOJANG_MAVEN_REPO;
                return;
            }
        }
        Exception exc32 = exc2;
        StringBuilder sb152 = sb3;
        StringBuilder sb162 = new StringBuilder();
        Exception exc42 = new Exception(sb152.append("size mismatch on download of ").append(fileName).append(" expected ").append(this.fileSizes[i4]).append(" got ").append(i2).toString());
        throw exc32;
    }

    /* access modifiers changed from: protected */
    public void extractGZip(String str, String str2) throws Exception {
        File file;
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String str3 = str2;
        File file2 = file;
        File file3 = new File(str);
        File file4 = file2;
        GZIPInputStream gZIPInputStream2 = gZIPInputStream;
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file4);
        GZIPInputStream gZIPInputStream3 = new GZIPInputStream(fileInputStream2);
        GZIPInputStream gZIPInputStream4 = gZIPInputStream2;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(str3);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        try {
            byte[] bArr = new byte[16384];
            int read = gZIPInputStream4.read(bArr);
            while (true) {
                int i = read;
                if (i >= 1) {
                    fileOutputStream4.write(bArr, 0, i);
                    read = gZIPInputStream4.read(bArr);
                } else {
                    gZIPInputStream4.close();
                    fileOutputStream4.close();
                    boolean delete = file4.delete();
                    return;
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            gZIPInputStream4.close();
            fileOutputStream4.close();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public void extractJars(String str) throws Exception {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        StringBuilder sb9;
        StringBuilder sb10;
        StringBuilder sb11;
        StringBuilder sb12;
        StringBuilder sb13;
        StringBuilder sb14;
        StringBuilder sb15;
        StringBuilder sb16;
        StringBuilder sb17;
        StringBuilder sb18;
        StringBuilder sb19;
        StringBuilder sb20;
        StringBuilder sb21;
        String str2 = str;
        setState(7);
        float length = 10.0f / ((float) this.urlList.length);
        for (int i = 0; i < this.urlList.length; i++) {
            if (this.fileSizes[i] != -2) {
                this.percentage = 55 + ((int) (length * ((float) (i + 1))));
                String fileName = getFileName(this.urlList[i]);
                if (fileName.endsWith(".pack.lzma")) {
                    StringBuilder sb22 = sb16;
                    StringBuilder sb23 = new StringBuilder();
                    this.subtaskMessage = sb22.append("Extracting: ").append(fileName).append(" to ").append(replaceLast(fileName, ".lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    debug_sleep(1000);
                    StringBuilder sb24 = sb17;
                    StringBuilder sb25 = new StringBuilder();
                    String sb26 = sb24.append(str2).append(fileName).toString();
                    StringBuilder sb27 = sb18;
                    StringBuilder sb28 = new StringBuilder();
                    extractLZMA(sb26, sb27.append(str2).append(replaceLast(fileName, ".lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).toString());
                    StringBuilder sb29 = sb19;
                    StringBuilder sb30 = new StringBuilder();
                    this.subtaskMessage = sb29.append("Extracting: ").append(replaceLast(fileName, ".lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).append(" to ").append(replaceLast(fileName, ".pack.lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    debug_sleep(1000);
                    StringBuilder sb31 = sb20;
                    StringBuilder sb32 = new StringBuilder();
                    String sb33 = sb31.append(str2).append(replaceLast(fileName, ".lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    StringBuilder sb34 = sb21;
                    StringBuilder sb35 = new StringBuilder();
                    extractPack(sb33, sb34.append(str2).append(replaceLast(fileName, ".pack.lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).toString());
                } else if (fileName.endsWith(".pack.gz")) {
                    StringBuilder sb36 = sb10;
                    StringBuilder sb37 = new StringBuilder();
                    this.subtaskMessage = sb36.append("Extracting: ").append(fileName).append(" to ").append(replaceLast(fileName, ".gz", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    debug_sleep(1000);
                    StringBuilder sb38 = sb11;
                    StringBuilder sb39 = new StringBuilder();
                    String sb40 = sb38.append(str2).append(fileName).toString();
                    StringBuilder sb41 = sb12;
                    StringBuilder sb42 = new StringBuilder();
                    extractGZip(sb40, sb41.append(str2).append(replaceLast(fileName, ".gz", LibrariesRepository.MOJANG_MAVEN_REPO)).toString());
                    StringBuilder sb43 = sb13;
                    StringBuilder sb44 = new StringBuilder();
                    this.subtaskMessage = sb43.append("Extracting: ").append(replaceLast(fileName, ".gz", LibrariesRepository.MOJANG_MAVEN_REPO)).append(" to ").append(replaceLast(fileName, ".pack.gz", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    debug_sleep(1000);
                    StringBuilder sb45 = sb14;
                    StringBuilder sb46 = new StringBuilder();
                    String sb47 = sb45.append(str2).append(replaceLast(fileName, ".gz", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    StringBuilder sb48 = sb15;
                    StringBuilder sb49 = new StringBuilder();
                    extractPack(sb47, sb48.append(str2).append(replaceLast(fileName, ".pack.gz", LibrariesRepository.MOJANG_MAVEN_REPO)).toString());
                } else if (fileName.endsWith(".pack")) {
                    StringBuilder sb50 = sb7;
                    StringBuilder sb51 = new StringBuilder();
                    this.subtaskMessage = sb50.append("Extracting: ").append(fileName).append(" to ").append(replaceLast(fileName, ".pack", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    debug_sleep(1000);
                    StringBuilder sb52 = sb8;
                    StringBuilder sb53 = new StringBuilder();
                    String sb54 = sb52.append(str2).append(fileName).toString();
                    StringBuilder sb55 = sb9;
                    StringBuilder sb56 = new StringBuilder();
                    extractPack(sb54, sb55.append(str2).append(replaceLast(fileName, ".pack", LibrariesRepository.MOJANG_MAVEN_REPO)).toString());
                } else if (fileName.endsWith(".lzma")) {
                    StringBuilder sb57 = sb4;
                    StringBuilder sb58 = new StringBuilder();
                    this.subtaskMessage = sb57.append("Extracting: ").append(fileName).append(" to ").append(replaceLast(fileName, ".lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    debug_sleep(1000);
                    StringBuilder sb59 = sb5;
                    StringBuilder sb60 = new StringBuilder();
                    String sb61 = sb59.append(str2).append(fileName).toString();
                    StringBuilder sb62 = sb6;
                    StringBuilder sb63 = new StringBuilder();
                    extractLZMA(sb61, sb62.append(str2).append(replaceLast(fileName, ".lzma", LibrariesRepository.MOJANG_MAVEN_REPO)).toString());
                } else if (fileName.endsWith(".gz")) {
                    StringBuilder sb64 = sb;
                    StringBuilder sb65 = new StringBuilder();
                    this.subtaskMessage = sb64.append("Extracting: ").append(fileName).append(" to ").append(replaceLast(fileName, ".gz", LibrariesRepository.MOJANG_MAVEN_REPO)).toString();
                    debug_sleep(1000);
                    StringBuilder sb66 = sb2;
                    StringBuilder sb67 = new StringBuilder();
                    String sb68 = sb66.append(str2).append(fileName).toString();
                    StringBuilder sb69 = sb3;
                    StringBuilder sb70 = new StringBuilder();
                    extractGZip(sb68, sb69.append(str2).append(replaceLast(fileName, ".gz", LibrariesRepository.MOJANG_MAVEN_REPO)).toString());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void extractLZMA(String str, String str2) throws Exception {
        File file;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        String str3 = str2;
        File file2 = file;
        File file3 = new File(str);
        File file4 = file2;
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file4);
        FileInputStream fileInputStream4 = fileInputStream2;
        Class cls = Class.forName("LZMA.LzmaInputStream");
        Class[] clsArr = new Class[1];
        Class[] clsArr2 = clsArr;
        clsArr[0] = InputStream.class;
        Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr2);
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = fileInputStream4;
        InputStream inputStream = (InputStream) declaredConstructor.newInstance(objArr2);
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(str3);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        byte[] bArr = new byte[16384];
        try {
            int read = inputStream.read(bArr);
            while (true) {
                int i = read;
                if (i >= 1) {
                    fileOutputStream4.write(bArr, 0, i);
                    read = inputStream.read(bArr);
                } else {
                    inputStream.close();
                    fileOutputStream4.close();
                    boolean delete = file4.delete();
                    return;
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            inputStream.close();
            fileOutputStream4.close();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public void extractNatives(String str) throws Exception {
        File file;
        StringBuilder sb;
        JarFile jarFile;
        StringBuilder sb2;
        File file2;
        StringBuilder sb3;
        File file3;
        StringBuilder sb4;
        FileOutputStream fileOutputStream;
        StringBuilder sb5;
        Exception exc;
        StringBuilder sb6;
        StringBuilder sb7;
        String str2 = str;
        setState(7);
        float f = 15.0f / ((float) this.nativeJarCount);
        File file4 = file;
        StringBuilder sb8 = sb;
        StringBuilder sb9 = new StringBuilder();
        File file5 = new File(sb8.append(str2).append("natives").toString());
        File file6 = file4;
        if (!file6.exists()) {
            boolean mkdir = file6.mkdir();
        }
        Certificate[] currentCertificates = getCurrentCertificates();
        for (int length = this.urlList.length - this.nativeJarCount; length < this.urlList.length; length++) {
            if (this.fileSizes[length] != -2) {
                String jarName = getJarName(this.urlList[length]);
                JarFile jarFile2 = jarFile;
                StringBuilder sb10 = sb2;
                StringBuilder sb11 = new StringBuilder();
                JarFile jarFile3 = new JarFile(sb10.append(str2).append(jarName).toString(), true);
                JarFile jarFile4 = jarFile2;
                Enumeration entries = jarFile4.entries();
                this.totalSizeExtract = 0;
                int length2 = length - (this.urlList.length - this.nativeJarCount);
                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) entries.nextElement();
                    if (!jarEntry.isDirectory() && jarEntry.getName().indexOf(47) == -1) {
                        this.totalSizeExtract = (int) (((long) this.totalSizeExtract) + jarEntry.getSize());
                    }
                }
                this.currentSizeExtract = 0;
                Enumeration entries2 = jarFile4.entries();
                while (entries2.hasMoreElements()) {
                    JarEntry jarEntry2 = (JarEntry) entries2.nextElement();
                    if (!jarEntry2.isDirectory() && jarEntry2.getName().indexOf(47) == -1) {
                        File file7 = file3;
                        StringBuilder sb12 = sb4;
                        StringBuilder sb13 = new StringBuilder();
                        File file8 = new File(sb12.append(str2).append("natives").append(File.separator).append(jarEntry2.getName()).toString());
                        File file9 = file7;
                        if (!file9.exists() || file9.delete()) {
                            debug_sleep(1000);
                            InputStream inputStream = jarFile4.getInputStream(jarFile4.getEntry(jarEntry2.getName()));
                            FileOutputStream fileOutputStream2 = fileOutputStream;
                            StringBuilder sb14 = sb5;
                            StringBuilder sb15 = new StringBuilder();
                            FileOutputStream fileOutputStream3 = new FileOutputStream(sb14.append(str2).append("natives").append(File.separator).append(jarEntry2.getName()).toString());
                            FileOutputStream fileOutputStream4 = fileOutputStream2;
                            try {
                                byte[] bArr = new byte[65536];
                                while (true) {
                                    int read = inputStream.read(bArr, 0, bArr.length);
                                    if (read == -1) {
                                        break;
                                    }
                                    debug_sleep(10);
                                    fileOutputStream4.write(bArr, 0, read);
                                    this.currentSizeExtract = read + this.currentSizeExtract;
                                    this.percentage = 65 + ((int) (f * (((float) length2) + (((float) this.currentSizeExtract) / ((float) this.totalSizeExtract)))));
                                    StringBuilder sb16 = sb7;
                                    StringBuilder sb17 = new StringBuilder();
                                    this.subtaskMessage = sb16.append("Extracting: ").append(jarEntry2.getName()).append(" ").append((100 * this.currentSizeExtract) / this.totalSizeExtract).append("%").toString();
                                }
                                inputStream.close();
                                fileOutputStream4.close();
                                if (!certificatesMatch(currentCertificates, jarEntry2.getCertificates())) {
                                    boolean delete = file9.delete();
                                    Exception exc2 = exc;
                                    StringBuilder sb18 = sb6;
                                    StringBuilder sb19 = new StringBuilder();
                                    Exception exc3 = new Exception(sb18.append("The certificate(s) in ").append(jarName).append(" do not match the AppletLoader!").toString());
                                    throw exc2;
                                }
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                inputStream.close();
                                fileOutputStream4.close();
                                throw th2;
                            }
                        }
                    }
                }
                this.subtaskMessage = LibrariesRepository.MOJANG_MAVEN_REPO;
                jarFile4.close();
                File file10 = file2;
                StringBuilder sb20 = sb3;
                StringBuilder sb21 = new StringBuilder();
                File file11 = new File(sb20.append(str2).append(jarName).toString());
                boolean delete2 = file10.delete();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void extractPack(String str, String str2) throws Exception {
        File file;
        FileOutputStream fileOutputStream;
        JarOutputStream jarOutputStream;
        String str3 = str2;
        File file2 = file;
        File file3 = new File(str);
        File file4 = file2;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(str3);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        JarOutputStream jarOutputStream2 = jarOutputStream;
        JarOutputStream jarOutputStream3 = new JarOutputStream(fileOutputStream4);
        JarOutputStream jarOutputStream4 = jarOutputStream2;
        try {
            Pack200.newUnpacker().unpack(file4, jarOutputStream4);
            jarOutputStream4.close();
            fileOutputStream4.close();
            boolean delete = file4.delete();
        } catch (Throwable th) {
            Throwable th2 = th;
            jarOutputStream4.close();
            fileOutputStream4.close();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public void fatalErrorOccured(String str, Exception exc) {
        String str2 = str;
        Exception exc2 = exc;
        this.fatalError = true;
        if (this.minimumJreNotFound) {
            this.errorMessage = this.minimumJREMessage;
            this.errorMessage[-1 + this.errorMessage.length] = str2;
        } else if (this.certificateRefused) {
            this.errorMessage = this.certificateRefusedMessage;
        } else {
            this.errorMessage = this.genericErrorMessage;
            this.errorMessage[-1 + this.errorMessage.length] = str2;
        }
        System.out.println(str2);
        if (exc2 != null) {
            System.out.println(exc2.getMessage());
            System.out.println(generateStacktrace(exc2));
        }
        repaint();
    }

    public Applet getApplet() {
        return this.lwjglApplet;
    }

    /* access modifiers changed from: protected */
    public boolean getBooleanParameter(String str, boolean z) {
        boolean z2 = z;
        String parameter = getParameter(str);
        if (parameter != null) {
            z2 = Boolean.parseBoolean(parameter);
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public String getCacheDirectory() throws Exception {
        C08413 r4;
        C08413 r1 = r4;
        C08413 r2 = new PrivilegedExceptionAction<String>(this) {
            final /* synthetic */ AppletLoader this$0;

            {
                this.this$0 = r5;
            }

            public String run() throws Exception {
                StringBuilder sb;
                StringBuilder sb2;
                String str = LibrariesRepository.MOJANG_MAVEN_REPO;
                if (this.this$0.prependHost) {
                    String host = this.this$0.getCodeBase().getHost();
                    if (host == null || host.length() == 0) {
                        host = "localhost";
                    }
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    str = sb3.append(host).append(File.separator).toString();
                }
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                return sb5.append(this.this$0.getLWJGLCacheDir()).append(File.separator).append(str).append(this.this$0.getParameter("al_title")).append(File.separator).toString();
            }
        };
        return (String) AccessController.doPrivileged(r1);
    }

    /* access modifiers changed from: protected */
    public Color getColor(String str, Color color) {
        StringTokenizer stringTokenizer;
        Color color2;
        Color color3 = color;
        String parameter = getParameter(str);
        if (parameter == null) {
            return color3;
        }
        if (parameter.indexOf(",") != -1) {
            StringTokenizer stringTokenizer2 = stringTokenizer;
            StringTokenizer stringTokenizer3 = new StringTokenizer(parameter, ",");
            StringTokenizer stringTokenizer4 = stringTokenizer2;
            try {
                Color color4 = color2;
                Color color5 = new Color(Integer.parseInt(stringTokenizer4.nextToken().trim()), Integer.parseInt(stringTokenizer4.nextToken().trim()), Integer.parseInt(stringTokenizer4.nextToken().trim()));
                return color4;
            } catch (Exception e) {
                Exception exc = e;
                return color3;
            }
        } else {
            try {
                return Color.decode(parameter);
            } catch (NumberFormatException e2) {
                NumberFormatException numberFormatException = e2;
                try {
                    return (Color) Color.class.getField(parameter).get(null);
                } catch (Exception e3) {
                    Exception exc2 = e3;
                    return color3;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getDescriptionForState() {
        switch (this.state) {
            case 1:
                return "Initializing loader";
            case 2:
                return "Checking version";
            case 3:
                return "Determining packages to load";
            case 4:
                return "Calculating download size";
            case 5:
                return "Checking for updates";
            case 6:
                return "Downloading packages";
            case 7:
                return "Extracting downloaded packages";
            case 8:
                return "Validating packages";
            case 9:
                return "Updating classpath";
            case 10:
                return "Switching applet";
            case 11:
                return "Initializing real applet";
            case 12:
                return "Starting real applet";
            case 13:
                return "Done loading";
            default:
                return "unknown state";
        }
    }

    /* access modifiers changed from: protected */
    public String getFileName(URL url) {
        String file = url.getFile();
        return file.substring(1 + file.lastIndexOf(47));
    }

    /* access modifiers changed from: protected */
    public Image getImage(String str) {
        Image image;
        StringBuilder sb;
        URL url;
        String str2 = str;
        if (str2.length() == 0) {
            image = null;
        } else {
            try {
                URL url2 = url;
                URL url3 = new URL(getCodeBase(), str2);
                image = getImage(url2);
            } catch (Exception e) {
                Exception exc = e;
                image = null;
            }
            if (image == null) {
                image = getImage(Thread.currentThread().getContextClassLoader().getResource(str2));
            }
            if (image == null) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                fatalErrorOccured(sb2.append("Unable to load the logo/progressbar image: ").append(str2).toString(), null);
                return null;
            }
        }
        return image;
    }

    public Image getImage(URL url) {
        MediaTracker mediaTracker;
        URL url2 = url;
        try {
            MediaTracker mediaTracker2 = mediaTracker;
            MediaTracker mediaTracker3 = new MediaTracker(this);
            MediaTracker mediaTracker4 = mediaTracker2;
            Image image = AppletLoader.super.getImage(url2);
            mediaTracker4.addImage(image, 0);
            mediaTracker4.waitForAll();
            if (!mediaTracker4.isErrorAny()) {
                return image;
            }
        } catch (Exception e) {
            Exception exc = e;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getIntParameter(String str, int i) {
        int i2 = i;
        String parameter = getParameter(str);
        if (parameter != null) {
            i2 = Integer.parseInt(parameter);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void getJarInfo(File file) throws Exception {
        HashMap<String, Long> hashMap;
        File file2;
        LinkedList linkedList;
        Integer num;
        C08435 r16;
        File file3 = file;
        setState(4);
        HashMap<String, Long> hashMap2 = hashMap;
        HashMap<String, Long> hashMap3 = new HashMap<>();
        this.filesLastModified = hashMap2;
        this.fileSizes = new int[this.urlList.length];
        File file4 = file2;
        File file5 = new File(file3, "timestamps");
        File file6 = file4;
        if (file6.exists()) {
            setState(5);
            this.filesLastModified = readHashMapFile(file6);
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(this.concurrentLookupThreads);
        LinkedList linkedList2 = linkedList;
        LinkedList linkedList3 = new LinkedList();
        LinkedList linkedList4 = linkedList2;
        Integer num2 = num;
        Integer num3 = new Integer(1);
        Integer num4 = num2;
        for (int i = 0; i < this.urlList.length; i++) {
            LinkedList linkedList5 = linkedList4;
            ExecutorService executorService = newFixedThreadPool;
            C08435 r11 = r16;
            final int i2 = i;
            final Integer num5 = num4;
            C08435 r12 = new Runnable(this) {
                final /* synthetic */ AppletLoader this$0;

                {
                    int i = r8;
                    Object obj = r9;
                    this.this$0 = r7;
                }

                /* JADX INFO: finally extract failed */
                public void run() {
                    RuntimeException runtimeException;
                    StringBuilder sb;
                    Object obj;
                    Throwable th;
                    try {
                        URLConnection openConnection = this.this$0.urlList[i2].openConnection();
                        openConnection.setDefaultUseCaches(false);
                        if (openConnection instanceof HttpURLConnection) {
                            ((HttpURLConnection) openConnection).setRequestMethod("HEAD");
                        }
                        this.this$0.fileSizes[i2] = openConnection.getContentLength();
                        long lastModified = openConnection.getLastModified();
                        String fileName = this.this$0.getFileName(this.this$0.urlList[i2]);
                        if (this.this$0.cacheEnabled && lastModified != 0 && this.this$0.filesLastModified.containsKey(fileName) && ((Long) this.this$0.filesLastModified.get(fileName)).longValue() == lastModified) {
                            this.this$0.fileSizes[i2] = -2;
                        }
                        if (this.this$0.fileSizes[i2] >= 0) {
                            obj = num5;
                            synchronized (obj) {
                                this.this$0.totalDownloadSize += this.this$0.fileSizes[i2];
                            }
                        }
                        Object put = this.this$0.filesLastModified.put(fileName, Long.valueOf(lastModified));
                    } catch (Exception e) {
                        Exception exc = e;
                        RuntimeException runtimeException2 = runtimeException;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        RuntimeException runtimeException3 = new RuntimeException(sb2.append("Failed to fetch information for ").append(this.this$0.urlList[i2]).toString(), exc);
                        throw runtimeException2;
                    } catch (Throwable th2) {
                        while (true) {
                            th = th2;
                            Object obj2 = obj;
                        }
                        throw th;
                    }
                }
            };
            boolean add = linkedList5.add(executorService.submit(r11));
        }
        while (!linkedList4.isEmpty()) {
            Iterator it = linkedList4.iterator();
            while (it.hasNext()) {
                Future future = (Future) it.next();
                if (future.isDone()) {
                    Object obj = future.get();
                    it.remove();
                    this.percentage = 5 + ((int) (((float) (10 * (this.urlList.length - linkedList4.size()))) / ((float) this.urlList.length)));
                }
            }
            Thread.sleep(10);
        }
        newFixedThreadPool.shutdown();
    }

    /* access modifiers changed from: protected */
    public InputStream getJarInputStream(String str, URLConnection uRLConnection) throws Exception {
        Exception exc;
        StringBuilder sb;
        C08446 r15;
        String str2 = str;
        URLConnection uRLConnection2 = uRLConnection;
        InputStream[] inputStreamArr = new InputStream[1];
        for (int i = 0; i < 3 && inputStreamArr[0] == null; i++) {
            C08446 r10 = r15;
            final InputStream[] inputStreamArr2 = inputStreamArr;
            final URLConnection uRLConnection3 = uRLConnection2;
            C08446 r11 = new Thread(this) {
                final /* synthetic */ AppletLoader this$0;

                {
                    InputStream[] inputStreamArr = r8;
                    URLConnection uRLConnection = r9;
                    this.this$0 = r7;
                }

                public void run() {
                    try {
                        inputStreamArr2[0] = uRLConnection3.getInputStream();
                    } catch (IOException e) {
                        IOException iOException = e;
                    }
                }
            };
            C08446 r5 = r10;
            r5.setName("JarInputStreamThread");
            r5.start();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (inputStreamArr[0] != null) {
                    break;
                }
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    r5.join(1000);
                    i2 = i4;
                } catch (InterruptedException e) {
                    InterruptedException interruptedException = e;
                    i2 = i4;
                }
            }
            if (inputStreamArr[0] == null) {
                try {
                    r5.interrupt();
                    r5.join();
                } catch (InterruptedException e2) {
                    InterruptedException interruptedException2 = e2;
                }
            }
        }
        if (inputStreamArr[0] != null) {
            return inputStreamArr[0];
        }
        Exception exc2 = exc;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        Exception exc3 = new Exception(sb2.append("Unable to get input stream for ").append(str2).toString());
        throw exc2;
    }

    /* access modifiers changed from: protected */
    public String getJarName(URL url) {
        String file = url.getFile();
        if (file.endsWith(".pack.lzma")) {
            file = replaceLast(file, ".pack.lzma", LibrariesRepository.MOJANG_MAVEN_REPO);
        } else if (file.endsWith(".pack.gz")) {
            file = replaceLast(file, ".pack.gz", LibrariesRepository.MOJANG_MAVEN_REPO);
        } else if (file.endsWith(".pack")) {
            file = replaceLast(file, ".pack", LibrariesRepository.MOJANG_MAVEN_REPO);
        } else if (file.endsWith(".lzma")) {
            file = replaceLast(file, ".lzma", LibrariesRepository.MOJANG_MAVEN_REPO);
        } else if (file.endsWith(".gz")) {
            file = replaceLast(file, ".gz", LibrariesRepository.MOJANG_MAVEN_REPO);
        }
        return file.substring(1 + file.lastIndexOf(47));
    }

    /* access modifiers changed from: protected */
    public String getLWJGLCacheDir() {
        StringBuilder sb;
        String property = System.getProperty("deployment.user.cachedir");
        if (property == null || System.getProperty("os.name").startsWith("Win")) {
            property = System.getProperty("java.io.tmpdir");
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(property).append(File.separator).append("lwjglcache").toString();
    }

    public String[] getMessages() {
        return this.headlessMessage;
    }

    public int getStatus() {
        if (this.fatalError) {
            this.headlessMessage = this.errorMessage;
            if (this.certificateRefused) {
                return -2;
            }
            return this.minimumJreNotFound ? -3 : -1;
        }
        if (this.percentage == 100 && this.headlessWaiting) {
            this.headlessWaiting = false;
        }
        if (this.percentage == 95) {
            this.percentage = 100;
        }
        String[] strArr = new String[2];
        strArr[0] = getDescriptionForState();
        strArr[1] = this.subtaskMessage;
        this.headlessMessage = strArr;
        return this.percentage;
    }

    /* access modifiers changed from: protected */
    public String getStringParameter(String str, String str2) {
        String str3 = str2;
        String parameter = getParameter(str);
        return parameter != null ? parameter : str3;
    }

    public boolean imageUpdate(Image image, int i, int i2, int i3, int i4, int i5) {
        Image image2 = image;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        if (this.state == 13) {
            return false;
        }
        if (i6 == 16 && !this.painting) {
            Image image3 = image2 == this.logo ? this.logoBuffer : this.progressbarBuffer;
            Graphics graphics = image3.getGraphics();
            graphics.setColor(this.bgColor);
            graphics.fillRect(0, 0, image3.getWidth(null), image3.getHeight(null));
            if (image2 == this.progressbar && this.logo != null) {
                boolean drawImage = graphics.drawImage(this.logoBuffer, (this.progressbar.getWidth(null) / 2) - (this.logo.getWidth(null) / 2), (this.progressbar.getHeight(null) / 2) - (this.logo.getHeight(null) / 2), null);
            }
            boolean drawImage2 = graphics.drawImage(image2, 0, 0, this);
            graphics.dispose();
            repaint();
        }
        return true;
    }

    public void init() {
        StringBuilder sb;
        setState(1);
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "al_main";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "al_jars";
        String[] strArr5 = strArr4;
        int length = strArr5.length;
        for (int i = 0; i < length; i++) {
            String str = strArr5[i];
            if (getParameter(str) == null) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                fatalErrorOccured(sb2.append("missing required applet parameter: ").append(str).toString(), null);
                return;
            }
        }
        this.cacheEnabled = getBooleanParameter("al_cache", true);
        this.debugMode = getBooleanParameter("al_debug", false);
        this.prependHost = getBooleanParameter("al_prepend_host", true);
        this.headless = getBooleanParameter("al_headless", false);
        this.concurrentLookupThreads = getIntParameter("al_lookup_threads", 1);
        this.bgColor = getColor("boxbgcolor", Color.white);
        setBackground(this.bgColor);
        this.fgColor = getColor("boxfgcolor", Color.black);
        if (!this.headless) {
            this.logo = getImage(getStringParameter("al_logo", "appletlogo.gif"));
            this.progressbar = getImage(getStringParameter("al_progressbar", "appletprogress.gif"));
        }
        try {
            Class cls = Class.forName("LZMA.LzmaInputStream");
            this.lzmaSupported = true;
        } catch (Throwable th) {
            Throwable th2 = th;
        }
        try {
            String simpleName = Pack200.class.getSimpleName();
            this.pack200Supported = true;
        } catch (Throwable th3) {
            Throwable th4 = th3;
        }
    }

    public boolean isMinJREVersionAvailable() throws Exception {
        setState(2);
        String stringParameter = getStringParameter("al_min_jre", "1.5");
        String str = System.getProperty("java.version").split("-")[0];
        String[] split = str.split("-")[0].split("[_\\.]");
        String[] split2 = str.split("[_\\.]");
        int max = Math.max(split.length, split2.length);
        int[] iArr = new int[max];
        int[] iArr2 = new int[max];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        for (int i2 = 0; i2 < split2.length; i2++) {
            iArr2[i2] = Integer.parseInt(split2[i2]);
        }
        for (int i3 = 0; i3 < max; i3++) {
            if (iArr[i3] < iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isZipValid(java.io.File r23) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            java.util.zip.ZipFile r15 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0098 }
            r21 = r15
            r15 = r21
            r16 = r21
            r17 = r2
            r16.<init>(r17)     // Catch:{ IOException -> 0x0098 }
            r3 = r15
            r15 = r3
            java.util.Enumeration r15 = r15.entries()     // Catch:{ all -> 0x0090 }
            r6 = r15
            r15 = 4096(0x1000, float:5.74E-42)
            byte[] r15 = new byte[r15]     // Catch:{ all -> 0x0090 }
            r7 = r15
        L_0x001d:
            r15 = r6
            boolean r15 = r15.hasMoreElements()     // Catch:{ all -> 0x0090 }
            if (r15 == 0) goto L_0x0089
            r15 = r6
            java.lang.Object r15 = r15.nextElement()     // Catch:{ all -> 0x0090 }
            java.util.zip.ZipEntry r15 = (java.util.zip.ZipEntry) r15     // Catch:{ all -> 0x0090 }
            r8 = r15
            java.util.zip.CRC32 r15 = new java.util.zip.CRC32     // Catch:{ all -> 0x0090 }
            r21 = r15
            r15 = r21
            r16 = r21
            r16.<init>()     // Catch:{ all -> 0x0090 }
            r9 = r15
            java.util.zip.CheckedInputStream r15 = new java.util.zip.CheckedInputStream     // Catch:{ all -> 0x0090 }
            r21 = r15
            r15 = r21
            r16 = r21
            java.io.BufferedInputStream r17 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0090 }
            r21 = r17
            r17 = r21
            r18 = r21
            r19 = r3
            r20 = r8
            java.io.InputStream r19 = r19.getInputStream(r20)     // Catch:{ all -> 0x0090 }
            r18.<init>(r19)     // Catch:{ all -> 0x0090 }
            r18 = r9
            r16.<init>(r17, r18)     // Catch:{ all -> 0x0090 }
            r10 = r15
        L_0x0059:
            r15 = r10
            r16 = r7
            r17 = 0
            r18 = r7
            r0 = r18
            int r0 = r0.length     // Catch:{ all -> 0x0090 }
            r18 = r0
            int r15 = r15.read(r16, r17, r18)     // Catch:{ all -> 0x0090 }
            r16 = -1
            r0 = r16
            if (r15 != r0) goto L_0x0059
            r15 = r9
            long r15 = r15.getValue()     // Catch:{ all -> 0x0090 }
            r11 = r15
            r15 = r8
            long r15 = r15.getCrc()     // Catch:{ all -> 0x0090 }
            r13 = r15
            r15 = r11
            r17 = r13
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 == 0) goto L_0x001d
            r15 = r3
            r15.close()     // Catch:{ IOException -> 0x0098 }
            r15 = 0
            r1 = r15
        L_0x0088:
            return r1
        L_0x0089:
            r15 = r3
            r15.close()     // Catch:{ IOException -> 0x0098 }
            r15 = 1
            r1 = r15
            goto L_0x0088
        L_0x0090:
            r15 = move-exception
            r4 = r15
            r15 = r3
            r15.close()     // Catch:{ IOException -> 0x0098 }
            r15 = r4
            throw r15     // Catch:{ IOException -> 0x0098 }
        L_0x0098:
            r15 = move-exception
            r5 = r15
            r15 = r5
            r15.printStackTrace()
            r15 = 0
            r1 = r15
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.applet.AppletLoader.isZipValid(java.io.File):boolean");
    }

    /* access modifiers changed from: protected */
    public void loadJarURLs() throws Exception {
        String parameter;
        StringBuilder sb;
        StringTokenizer stringTokenizer;
        StringTokenizer stringTokenizer2;
        URL url;
        URL url2;
        setState(3);
        String parameter2 = getParameter("al_jars");
        String property = System.getProperty("os.name");
        if (property.startsWith("Win")) {
            parameter = System.getProperty("os.arch").endsWith("64") ? getParameter("al_windows64") : getParameter("al_windows32");
            if (parameter == null) {
                parameter = getParameter("al_windows");
            }
        } else if (property.startsWith("Linux") || property.startsWith("Unix")) {
            parameter = System.getProperty("os.arch").endsWith("64") ? getParameter("al_linux64") : getParameter("al_linux32");
            if (parameter == null) {
                parameter = getParameter("al_linux");
            }
        } else if (property.startsWith("Mac") || property.startsWith("Darwin")) {
            String parameter3 = System.getProperty("os.arch").endsWith("64") ? getParameter("al_mac64") : System.getProperty("os.arch").contains("ppc") ? getParameter("al_macppc") : getParameter("al_mac32");
            if (parameter == null) {
                parameter = getParameter("al_mac");
            }
        } else if (property.startsWith("Solaris") || property.startsWith("SunOS")) {
            parameter = getParameter("al_solaris");
        } else if (property.startsWith("FreeBSD")) {
            parameter = getParameter("al_freebsd");
        } else {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            fatalErrorOccured(sb2.append("OS (").append(property).append(") not supported").toString(), null);
            return;
        }
        if (parameter == null) {
            fatalErrorOccured("no lwjgl natives files found", null);
            return;
        }
        StringTokenizer stringTokenizer3 = stringTokenizer;
        StringTokenizer stringTokenizer4 = new StringTokenizer(trimExtensionByCapabilities(parameter2), ", ");
        StringTokenizer stringTokenizer5 = stringTokenizer3;
        StringTokenizer stringTokenizer6 = stringTokenizer2;
        StringTokenizer stringTokenizer7 = new StringTokenizer(trimExtensionByCapabilities(parameter), ", ");
        StringTokenizer stringTokenizer8 = stringTokenizer6;
        int countTokens = stringTokenizer5.countTokens();
        this.nativeJarCount = stringTokenizer8.countTokens();
        this.urlList = new URL[(countTokens + this.nativeJarCount)];
        URL codeBase = getCodeBase();
        for (int i = 0; i < countTokens; i++) {
            URL[] urlArr = this.urlList;
            int i2 = i;
            URL url3 = url2;
            URL url4 = new URL(codeBase, stringTokenizer5.nextToken());
            urlArr[i2] = url3;
        }
        for (int i3 = countTokens; i3 < countTokens + this.nativeJarCount; i3++) {
            URL[] urlArr2 = this.urlList;
            int i4 = i3;
            URL url5 = url;
            URL url6 = new URL(codeBase, stringTokenizer8.nextToken());
            urlArr2[i4] = url5;
        }
    }

    public void paint(Graphics graphics) {
        Graphics graphics2 = graphics;
        if (this.state == 13) {
            cleanUp();
            return;
        }
        if (!this.headless) {
            if (this.offscreen == null) {
                this.offscreen = createImage(getWidth(), getHeight());
                if (this.logo != null) {
                    this.logoBuffer = createImage(this.logo.getWidth(null), this.logo.getHeight(null));
                    boolean drawImage = this.offscreen.getGraphics().drawImage(this.logo, 0, 0, this);
                    boolean imageUpdate = imageUpdate(this.logo, 16, 0, 0, 0, 0);
                }
                if (this.progressbar != null) {
                    this.progressbarBuffer = createImage(this.progressbar.getWidth(null), this.progressbar.getHeight(null));
                    boolean drawImage2 = this.offscreen.getGraphics().drawImage(this.progressbar, 0, 0, this);
                    boolean imageUpdate2 = imageUpdate(this.progressbar, 16, 0, 0, 0, 0);
                }
            }
            Graphics graphics3 = this.offscreen.getGraphics();
            FontMetrics fontMetrics = graphics3.getFontMetrics();
            graphics3.setColor(this.bgColor);
            graphics3.fillRect(0, 0, this.offscreen.getWidth(null), this.offscreen.getHeight(null));
            graphics3.setColor(this.fgColor);
            if (this.fatalError) {
                for (int i = 0; i < this.errorMessage.length; i++) {
                    if (this.errorMessage[i] != null) {
                        graphics3.drawString(this.errorMessage[i], (this.offscreen.getWidth(null) - fontMetrics.stringWidth(this.errorMessage[i])) / 2, ((this.offscreen.getHeight(null) - (fontMetrics.getHeight() * this.errorMessage.length)) / 2) + (i * fontMetrics.getHeight()));
                    }
                }
            } else {
                graphics3.setColor(this.fgColor);
                this.painting = true;
                int width = this.offscreen.getWidth(null) / 2;
                int height = this.offscreen.getHeight(null) / 2;
                if (this.logo != null) {
                    boolean drawImage3 = graphics3.drawImage(this.logoBuffer, width - (this.logo.getWidth(null) / 2), height - (this.logo.getHeight(null) / 2), this);
                }
                String descriptionForState = getDescriptionForState();
                int width2 = (this.offscreen.getWidth(null) - fontMetrics.stringWidth(descriptionForState)) / 2;
                int i2 = height + 20;
                if (this.logo != null) {
                    i2 += this.logo.getHeight(null) / 2;
                } else {
                    if (this.progressbar != null) {
                        i2 += this.progressbar.getHeight(null) / 2;
                    }
                }
                graphics3.drawString(descriptionForState, width2, i2);
                if (this.subtaskMessage.length() > 0) {
                    graphics3.drawString(this.subtaskMessage, (this.offscreen.getWidth(null) - fontMetrics.stringWidth(this.subtaskMessage)) / 2, i2 + 20);
                }
                if (this.progressbar != null) {
                    graphics3.clipRect(width - (this.progressbar.getWidth(null) / 2), 0, (this.progressbar.getWidth(null) * this.percentage) / 100, this.offscreen.getHeight(null));
                    boolean drawImage4 = graphics3.drawImage(this.progressbarBuffer, width - (this.progressbar.getWidth(null) / 2), height - (this.progressbar.getHeight(null) / 2), this);
                }
                this.painting = false;
            }
            graphics3.dispose();
            boolean drawImage5 = graphics2.drawImage(this.offscreen, (getWidth() - this.offscreen.getWidth(null)) / 2, (getHeight() - this.offscreen.getHeight(null)) / 2, null);
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Long> readHashMapFile(File file) {
        HashMap hashMap;
        try {
            return (HashMap) readObjectFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            return hashMap2;
        }
    }

    /* access modifiers changed from: protected */
    public Object readObjectFile(File file) throws Exception {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream2 = fileInputStream;
        FileInputStream fileInputStream3 = new FileInputStream(file);
        FileInputStream fileInputStream4 = fileInputStream2;
        try {
            ObjectInputStream objectInputStream2 = objectInputStream;
            ObjectInputStream objectInputStream3 = new ObjectInputStream(fileInputStream4);
            ObjectInputStream objectInputStream4 = objectInputStream2;
            Object readObject = objectInputStream4.readObject();
            objectInputStream4.close();
            fileInputStream4.close();
            return readObject;
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            Throwable th2 = th;
            fileInputStream4.close();
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public String readStringFile(File file) {
        try {
            return (String) readObjectFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String replaceLast(String str, String str2, String str3) {
        StringBuilder sb;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        int lastIndexOf = str4.lastIndexOf(str5);
        if (lastIndexOf == -1) {
            return str4;
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(str4.substring(0, lastIndexOf)).append(str6).append(str4.substring(lastIndexOf + str5.length())).toString();
    }

    public void run() {
        StringBuilder sb;
        File file;
        File file2;
        C08402 r13;
        File file3;
        StringBuilder sb2;
        this.percentage = 5;
        try {
            debug_sleep(2000);
            if (!isMinJREVersionAvailable()) {
                this.minimumJreNotFound = true;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                fatalErrorOccured(sb3.append("Java ").append(getStringParameter("al_min_jre", "1.5")).append(" or greater is required.").toString(), null);
                this.loaderThread = null;
                return;
            }
            loadJarURLs();
            String cacheDirectory = getCacheDirectory();
            File file4 = file;
            File file5 = new File(cacheDirectory);
            File file6 = file4;
            if (!file6.exists()) {
                boolean mkdirs = file6.mkdirs();
            }
            File file7 = file2;
            File file8 = new File(file6, "version");
            File file9 = file7;
            String parameter = getParameter("al_version");
            boolean z = false;
            if (parameter != null) {
                z = compareVersion(file9, parameter.toLowerCase());
            }
            if (!z) {
                getJarInfo(file6);
                downloadJars(cacheDirectory);
                extractJars(cacheDirectory);
                extractNatives(cacheDirectory);
                validateJars(cacheDirectory);
                if (parameter != null) {
                    this.percentage = 90;
                    writeObjectFile(file9, parameter.toLowerCase());
                }
                File file10 = file3;
                File file11 = new File(file6, "timestamps");
                writeObjectFile(file10, this.filesLastModified);
            }
            updateClassPath(cacheDirectory);
            setLWJGLProperties();
            if (this.headless) {
                while (this.headlessWaiting) {
                    Thread.sleep(100);
                }
            }
            C08402 r8 = r13;
            C08402 r9 = new Runnable(this) {
                final /* synthetic */ AppletLoader this$0;

                {
                    this.this$0 = r5;
                }

                public void run() {
                    StringBuilder sb;
                    try {
                        this.this$0.switchApplet();
                    } catch (Exception e) {
                        Exception exc = e;
                        AppletLoader appletLoader = this.this$0;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        appletLoader.fatalErrorOccured(sb2.append("This occurred while '").append(this.this$0.getDescriptionForState()).append("'").toString(), exc);
                    }
                    this.this$0.setState(13);
                    this.this$0.repaint();
                }
            };
            EventQueue.invokeAndWait(r8);
            this.loaderThread = null;
        } catch (Exception e) {
            Exception exc = e;
            this.certificateRefused = exc instanceof AccessControlException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            fatalErrorOccured(sb5.append("This occurred while '").append(getDescriptionForState()).append("'").toString(), exc);
            this.loaderThread = null;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.loaderThread = null;
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public void setLWJGLProperties() {
        StringBuilder sb;
        String parameter = getParameter("lwjgl_arguments");
        if (parameter != null && parameter.length() > 0) {
            int indexOf = parameter.indexOf("-Dorg.lwjgl");
            while (true) {
                int i = indexOf;
                if (i != -1) {
                    int indexOf2 = parameter.indexOf(" ", i);
                    if (indexOf2 == -1) {
                        indexOf2 = parameter.length();
                    }
                    String[] split = parameter.substring(i + 2, indexOf2).split("=");
                    String property = System.setProperty(split[0], split[1]);
                    if (this.debugMode) {
                        PrintStream printStream = System.out;
                        StringBuilder sb2 = sb;
                        StringBuilder sb3 = new StringBuilder();
                        printStream.println(sb2.append("Setting property ").append(split[0]).append(" to ").append(split[1]).toString());
                    }
                    indexOf = parameter.indexOf("-Dorg.lwjgl", indexOf2);
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setState(int i) {
        this.state = i;
        if (this.debugMode) {
            System.out.println(getDescriptionForState());
        }
    }

    /* access modifiers changed from: protected */
    public void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (Exception e) {
            Exception exc = e;
        }
    }

    public void start() {
        Thread thread;
        C08391 r5;
        if (this.lwjglApplet != null) {
            this.lwjglApplet.start();
        } else if (this.loaderThread == null && !this.fatalError) {
            Thread thread2 = thread;
            Thread thread3 = new Thread(this);
            this.loaderThread = thread2;
            this.loaderThread.setName("AppletLoader.loaderThread");
            this.loaderThread.start();
            if (!this.headless) {
                C08391 r2 = r5;
                C08391 r3 = new Thread(this) {
                    final /* synthetic */ AppletLoader this$0;

                    {
                        this.this$0 = r5;
                    }

                    public void run() {
                        while (this.this$0.loaderThread != null) {
                            this.this$0.repaint();
                            this.this$0.sleep(100);
                        }
                        this.this$0.animationThread = null;
                    }
                };
                this.animationThread = r2;
                this.animationThread.setName("AppletLoader.animationthread");
                this.animationThread.start();
            }
        }
    }

    public void stop() {
        if (this.lwjglApplet != null) {
            this.lwjglApplet.stop();
        }
    }

    /* access modifiers changed from: protected */
    public void switchApplet() throws Exception {
        LayoutManager layoutManager;
        setState(10);
        this.percentage = 100;
        debug_sleep(2000);
        Thread.currentThread().setContextClassLoader(this.classLoader);
        this.lwjglApplet = (Applet) this.classLoader.loadClass(getParameter("al_main")).newInstance();
        this.lwjglApplet.setStub(this);
        this.lwjglApplet.setSize(getWidth(), getHeight());
        LayoutManager layoutManager2 = layoutManager;
        LayoutManager borderLayout = new BorderLayout();
        setLayout(layoutManager2);
        Component add = add(this.lwjglApplet);
        validate();
        setState(11);
        this.lwjglApplet.init();
        setState(12);
        this.lwjglApplet.start();
    }

    /* access modifiers changed from: protected */
    public String trimExtensionByCapabilities(String str) {
        StringBuilder sb;
        String str2 = str;
        if (!this.pack200Supported) {
            str2 = str2.replace(".pack", LibrariesRepository.MOJANG_MAVEN_REPO);
        }
        if (!this.lzmaSupported && str2.endsWith(".lzma")) {
            str2 = str2.replace(".lzma", LibrariesRepository.MOJANG_MAVEN_REPO);
            PrintStream printStream = System.out;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            printStream.println(sb2.append("LZMA decoder (lzma.jar) not found, trying ").append(str2).append(" without lzma extension.").toString());
        }
        return str2;
    }

    public final void update(Graphics graphics) {
        paint(graphics);
    }

    /* access modifiers changed from: protected */
    public void updateClassPath(String str) throws Exception {
        C08424 r17;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        URL url;
        File file;
        String str2 = str;
        setState(9);
        this.percentage = 95;
        URL[] urlArr = new URL[this.urlList.length];
        for (int i = 0; i < this.urlList.length; i++) {
            URL[] urlArr2 = urlArr;
            int i2 = i;
            URL url2 = url;
            File file2 = file;
            File file3 = new File(str2, getJarName(this.urlList[i]));
            URL url3 = new URL(file2.toURI().toString().replace("!", "%21"));
            urlArr2[i2] = url2;
        }
        Certificate[] currentCertificates = getCurrentCertificates();
        String property = System.getProperty("os.name");
        C08424 r8 = r17;
        final boolean z = property.startsWith("Mac") || property.startsWith("Darwin");
        final Certificate[] certificateArr = currentCertificates;
        final String str3 = str2;
        C08424 r9 = new URLClassLoader(this, urlArr) {
            final /* synthetic */ AppletLoader this$0;

            {
                URL[] urlArr = r10;
                boolean z = r11;
                Certificate[] certificateArr = r12;
                String str = r13;
                this.this$0 = r9;
            }

            /* access modifiers changed from: protected */
            public String findLibrary(String str) {
                StringBuilder sb;
                File file;
                String str2 = str;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                String sb4 = sb2.append(str3).append("natives").append(File.separator).append(System.mapLibraryName(str2)).toString();
                File file2 = file;
                File file3 = new File(sb4);
                return file2.exists() ? sb4 : super.findLibrary(str2);
            }

            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v1 */
            /* JADX WARNING: type inference failed for: r2v2 */
            /* JADX WARNING: type inference failed for: r2v3 */
            /* JADX WARNING: type inference failed for: r9v4 */
            /* JADX WARNING: type inference failed for: r0v1, types: [java.security.PermissionCollection] */
            /* JADX WARNING: type inference failed for: r2v4 */
            /* JADX WARNING: type inference failed for: r2v5 */
            /* JADX WARNING: type inference failed for: r9v13, types: [java.security.PermissionCollection] */
            /* JADX WARNING: type inference failed for: r2v6 */
            /* JADX WARNING: type inference failed for: r9v21, types: [java.security.PermissionCollection] */
            /* JADX WARNING: type inference failed for: r9v24, types: [java.security.PermissionCollection] */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* JADX WARNING: type inference failed for: r15v4 */
            /* JADX WARNING: type inference failed for: r9v31 */
            /* JADX WARNING: type inference failed for: r10v14, types: [java.security.Permissions] */
            /* JADX WARNING: type inference failed for: r6v0 */
            /* JADX WARNING: type inference failed for: r9v32, types: [java.security.PermissionCollection] */
            /* JADX WARNING: type inference failed for: r9v34 */
            /* JADX WARNING: type inference failed for: r2v8 */
            /* JADX WARNING: type inference failed for: r9v35 */
            /* JADX WARNING: type inference failed for: r0v2, types: [java.security.PermissionCollection] */
            /* JADX WARNING: type inference failed for: r2v9 */
            /* JADX WARNING: type inference failed for: r2v10 */
            /* JADX WARNING: type inference failed for: r2v11 */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v1
              assigns: []
              uses: []
              mth insns count: 108
            	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:30)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
             */
            /* JADX WARNING: Unknown variable types count: 17 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.security.PermissionCollection getPermissions(java.security.CodeSource r17) {
                /*
                    r16 = this;
                    r0 = r16
                    r1 = r17
                    r9 = 0
                    r2 = r9
                    r9 = r0
                    boolean r9 = r12     // Catch:{ Exception -> 0x00c6 }
                    r4 = r9
                    r9 = 0
                    r2 = r9
                    r9 = r4
                    if (r9 == 0) goto L_0x0039
                    r9 = r0
                    java.security.cert.Certificate[] r9 = r13     // Catch:{ Exception -> 0x00c6 }
                    r10 = r1
                    java.security.cert.Certificate[] r10 = r10.getCertificates()     // Catch:{ Exception -> 0x00c6 }
                    boolean r9 = org.lwjgl.util.applet.AppletLoader.certificatesMatch(r9, r10)     // Catch:{ Exception -> 0x00c6 }
                    r5 = r9
                    r9 = 0
                    r2 = r9
                    r9 = r5
                    if (r9 == 0) goto L_0x0039
                    java.security.Permissions r9 = new java.security.Permissions     // Catch:{ Exception -> 0x00c6 }
                    r15 = r9
                    r9 = r15
                    r10 = r15
                    r10.<init>()     // Catch:{ Exception -> 0x00c6 }
                    r6 = r9
                    r9 = r6
                    java.security.AllPermission r10 = new java.security.AllPermission     // Catch:{ Exception -> 0x00cd }
                    r15 = r10
                    r10 = r15
                    r11 = r15
                    r11.<init>()     // Catch:{ Exception -> 0x00cd }
                    r9.add(r10)     // Catch:{ Exception -> 0x00cd }
                    r9 = r6
                    r0 = r9
                L_0x0038:
                    return r0
                L_0x0039:
                    java.lang.Class<java.security.SecureClassLoader> r9 = java.security.SecureClassLoader.class
                    java.lang.String r10 = "getPermissions"
                    r11 = 1
                    java.lang.Class[] r11 = new java.lang.Class[r11]     // Catch:{ Exception -> 0x00c6 }
                    r15 = r11
                    r11 = r15
                    r12 = r15
                    r13 = 0
                    java.lang.Class<java.security.CodeSource> r14 = java.security.CodeSource.class
                    r12[r13] = r14     // Catch:{ Exception -> 0x00c6 }
                    java.lang.reflect.Method r9 = r9.getDeclaredMethod(r10, r11)     // Catch:{ Exception -> 0x00c6 }
                    r7 = r9
                    r9 = r7
                    r10 = 1
                    r9.setAccessible(r10)     // Catch:{ Exception -> 0x00c6 }
                    r9 = r7
                    r10 = r0
                    java.lang.Class r10 = r10.getClass()     // Catch:{ Exception -> 0x00c6 }
                    java.lang.ClassLoader r10 = r10.getClassLoader()     // Catch:{ Exception -> 0x00c6 }
                    r11 = 1
                    java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x00c6 }
                    r15 = r11
                    r11 = r15
                    r12 = r15
                    r13 = 0
                    r14 = r1
                    r12[r13] = r14     // Catch:{ Exception -> 0x00c6 }
                    java.lang.Object r9 = r9.invoke(r10, r11)     // Catch:{ Exception -> 0x00c6 }
                    java.security.PermissionCollection r9 = (java.security.PermissionCollection) r9     // Catch:{ Exception -> 0x00c6 }
                    r2 = r9
                    r9 = r0
                    org.lwjgl.util.applet.AppletLoader r9 = r9.this$0     // Catch:{ Exception -> 0x00c6 }
                    java.net.URL r9 = r9.getCodeBase()     // Catch:{ Exception -> 0x00c6 }
                    java.lang.String r9 = r9.getHost()     // Catch:{ Exception -> 0x00c6 }
                    r8 = r9
                    r9 = r8
                    if (r9 == 0) goto L_0x0095
                    r9 = r8
                    int r9 = r9.length()     // Catch:{ Exception -> 0x00c6 }
                    if (r9 <= 0) goto L_0x0095
                    r9 = r2
                    java.net.SocketPermission r10 = new java.net.SocketPermission     // Catch:{ Exception -> 0x00c6 }
                    r15 = r10
                    r10 = r15
                    r11 = r15
                    r12 = r8
                    java.lang.String r13 = "connect,accept"
                    r11.<init>(r12, r13)     // Catch:{ Exception -> 0x00c6 }
                    r9.add(r10)     // Catch:{ Exception -> 0x00c6 }
                L_0x0092:
                    r9 = r2
                    r0 = r9
                    goto L_0x0038
                L_0x0095:
                    java.lang.String r9 = "file"
                    r10 = r1
                    java.net.URL r10 = r10.getLocation()     // Catch:{ Exception -> 0x00c6 }
                    java.lang.String r10 = r10.getProtocol()     // Catch:{ Exception -> 0x00c6 }
                    boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x00c6 }
                    if (r9 == 0) goto L_0x0092
                    r9 = r2
                    java.io.FilePermission r10 = new java.io.FilePermission     // Catch:{ Exception -> 0x00c6 }
                    r15 = r10
                    r10 = r15
                    r11 = r15
                    r12 = r1
                    java.net.URL r12 = r12.getLocation()     // Catch:{ Exception -> 0x00c6 }
                    java.lang.String r12 = r12.getFile()     // Catch:{ Exception -> 0x00c6 }
                    r13 = 47
                    char r14 = java.io.File.separatorChar     // Catch:{ Exception -> 0x00c6 }
                    java.lang.String r12 = r12.replace(r13, r14)     // Catch:{ Exception -> 0x00c6 }
                    java.lang.String r13 = "read"
                    r11.<init>(r12, r13)     // Catch:{ Exception -> 0x00c6 }
                    r9.add(r10)     // Catch:{ Exception -> 0x00c6 }
                    goto L_0x0092
                L_0x00c6:
                    r9 = move-exception
                    r3 = r9
                L_0x00c8:
                    r9 = r3
                    r9.printStackTrace()
                    goto L_0x0092
                L_0x00cd:
                    r9 = move-exception
                    r3 = r9
                    r9 = r6
                    r2 = r9
                    goto L_0x00c8
                */
                throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.applet.AppletLoader.C08424.getPermissions(java.security.CodeSource):java.security.PermissionCollection");
            }
        };
        this.classLoader = r8;
        debug_sleep(2000);
        unloadNatives(str2);
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        String property2 = System.setProperty("org.lwjgl.librarypath", sb4.append(str2).append("natives").toString());
        StringBuilder sb6 = sb2;
        StringBuilder sb7 = new StringBuilder();
        String property3 = System.setProperty("net.java.games.input.librarypath", sb6.append(str2).append("natives").toString());
        StringBuilder sb8 = sb3;
        StringBuilder sb9 = new StringBuilder();
        String property4 = System.setProperty("java.library.path", sb8.append(str2).append("natives").toString());
        natives_loaded = true;
    }

    /* access modifiers changed from: protected */
    public void validateJars(String str) throws Exception {
        StringBuilder sb;
        File file;
        Exception exc;
        StringBuilder sb2;
        String str2 = str;
        setState(8);
        this.percentage = 80;
        float length = 10.0f / ((float) this.urlList.length);
        for (int i = 0; i < this.urlList.length - this.nativeJarCount; i++) {
            debug_sleep(1000);
            if (this.fileSizes[i] != -2) {
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                this.subtaskMessage = sb3.append("Validating: ").append(getJarName(this.urlList[i])).toString();
                File file2 = file;
                File file3 = new File(str2, getJarName(this.urlList[i]));
                if (!isZipValid(file2)) {
                    Exception exc2 = exc;
                    StringBuilder sb5 = sb2;
                    StringBuilder sb6 = new StringBuilder();
                    Exception exc3 = new Exception(sb5.append("The file ").append(getJarName(this.urlList[i])).append(" is corrupt!").toString());
                    throw exc2;
                }
                this.percentage = 80 + ((int) (length * ((float) i)));
            }
        }
        this.subtaskMessage = LibrariesRepository.MOJANG_MAVEN_REPO;
    }

    /* access modifiers changed from: protected */
    public void writeObjectFile(File file, Object obj) throws Exception {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        Object obj2 = obj;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        try {
            ObjectOutputStream objectOutputStream2 = objectOutputStream;
            ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(fileOutputStream4);
            ObjectOutputStream objectOutputStream4 = objectOutputStream2;
            objectOutputStream4.writeObject(obj2);
            objectOutputStream4.close();
            fileOutputStream4.close();
        } catch (Throwable th) {
            Throwable th2 = th;
            fileOutputStream4.close();
            throw th2;
        }
    }
}

package org.lwjgl.util.mapped;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import org.lwjgl.LWJGLUtil;

public class MappedObjectClassLoader extends URLClassLoader {
    static boolean FORKED;
    static final String MAPPEDOBJECT_PACKAGE_PREFIX;
    private static long total_time_transforming;

    static {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        MAPPEDOBJECT_PACKAGE_PREFIX = sb2.append(MappedObjectClassLoader.class.getPackage().getName()).append(".").toString();
    }

    private MappedObjectClassLoader(Class<?> cls) {
        super(((URLClassLoader) cls.getClassLoader()).getURLs());
    }

    private static byte[] copyOf(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int i2 = i;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, Math.min(bArr2.length, i2));
        return bArr3;
    }

    public static boolean fork(Class<?> cls, String[] strArr) {
        Error error;
        MappedObjectClassLoader mappedObjectClassLoader;
        Class<?> cls2 = cls;
        String[] strArr2 = strArr;
        if (FORKED) {
            return false;
        }
        FORKED = true;
        try {
            MappedObjectClassLoader mappedObjectClassLoader2 = mappedObjectClassLoader;
            MappedObjectClassLoader mappedObjectClassLoader3 = new MappedObjectClassLoader(cls2);
            MappedObjectClassLoader mappedObjectClassLoader4 = mappedObjectClassLoader2;
            Class loadMappedObject = mappedObjectClassLoader4.loadMappedObject();
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            clsArr[0] = String[].class;
            Method method = mappedObjectClassLoader4.loadClass(cls2.getName()).getMethod("main", clsArr2);
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = strArr2;
            Object invoke = method.invoke(null, objArr2);
        } catch (InvocationTargetException e) {
            Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e.getCause());
        } catch (Throwable th) {
            Throwable th2 = th;
            Error error2 = error;
            Error error3 = new Error("failed to fork", th2);
            throw error2;
        }
        return true;
    }

    private static void printActivity(String str, long j, long j2) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        String str2 = str;
        long j3 = j;
        long j4 = j2;
        StringBuilder sb4 = sb;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder(sb5.append(MappedObjectClassLoader.class.getSimpleName()).append(": ").append(str2).toString());
        StringBuilder sb8 = sb4;
        if (MappedObjectTransformer.PRINT_TIMING) {
            StringBuilder sb9 = sb8;
            StringBuilder sb10 = sb3;
            StringBuilder sb11 = new StringBuilder();
            StringBuilder append = sb9.append(sb10.append("\n\ttransforming took ").append((j4 - j3) / 1000).append(" micros (total: ").append((total_time_transforming / 1000) / 1000).append("ms)").toString());
        }
        LWJGLUtil.log(sb8);
    }

    private static byte[] readStream(InputStream inputStream) {
        int i;
        InputStream inputStream2 = inputStream;
        byte[] bArr = new byte[256];
        int i2 = 0;
        while (true) {
            i = i2;
            try {
                if (bArr.length == i) {
                    bArr = copyOf(bArr, i * 2);
                }
                int read = inputStream2.read(bArr, i, bArr.length - i);
                if (read == -1) {
                    break;
                }
                i2 = i + read;
            } catch (IOException e) {
                IOException iOException = e;
                try {
                    inputStream2.close();
                } catch (IOException e2) {
                    IOException iOException2 = e2;
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                    IOException iOException3 = e3;
                }
                throw th2;
            }
        }
        try {
            inputStream2.close();
        } catch (IOException e4) {
            IOException iOException4 = e4;
        }
        return copyOf(bArr, i);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> cls;
        String str2 = str;
        boolean z2 = z;
        synchronized (this) {
            try {
                if (str2.startsWith("java.") || str2.startsWith("javax.") || str2.startsWith("sun.") || str2.startsWith("sunw.") || str2.startsWith("org.objectweb.asm.")) {
                    cls = super.loadClass(str2, z2);
                } else {
                    String replace = str2.replace('.', ClassPathElement.SEPARATOR_CHAR);
                    boolean startsWith = str2.startsWith(MAPPEDOBJECT_PACKAGE_PREFIX);
                    if (!startsWith || (!str2.equals(MappedObjectClassLoader.class.getName()) && !str2.equals(MappedObjectTransformer.class.getName()) && !str2.equals(CacheUtil.class.getName()))) {
                        byte[] readStream = readStream(getResourceAsStream(replace.concat(".class")));
                        if (!startsWith || str2.substring(MAPPEDOBJECT_PACKAGE_PREFIX.length()).indexOf(46) != -1) {
                            long nanoTime = System.nanoTime();
                            byte[] transformMappedAPI = MappedObjectTransformer.transformMappedAPI(replace, readStream);
                            long nanoTime2 = System.nanoTime();
                            total_time_transforming += nanoTime2 - nanoTime;
                            if (readStream != transformMappedAPI) {
                                readStream = transformMappedAPI;
                                if (MappedObjectTransformer.PRINT_ACTIVITY) {
                                    printActivity(replace, nanoTime, nanoTime2);
                                }
                            }
                        }
                        cls = super.defineClass(str2, readStream, 0, readStream.length);
                        if (z2) {
                            resolveClass(cls);
                        }
                    } else {
                        cls = super.loadClass(str2, z2);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
        return cls;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public Class<?> loadMappedObject() throws ClassNotFoundException {
        Class defineClass;
        synchronized (this) {
            try {
                String name = MappedObject.class.getName();
                String replace = name.replace('.', ClassPathElement.SEPARATOR_CHAR);
                byte[] readStream = readStream(getResourceAsStream(replace.concat(".class")));
                long nanoTime = System.nanoTime();
                byte[] transformMappedObject = MappedObjectTransformer.transformMappedObject(readStream);
                long nanoTime2 = System.nanoTime();
                total_time_transforming += nanoTime2 - nanoTime;
                if (MappedObjectTransformer.PRINT_ACTIVITY) {
                    printActivity(replace, nanoTime, nanoTime2);
                }
                defineClass = super.defineClass(name, transformMappedObject, 0, transformMappedObject.length);
                resolveClass(defineClass);
            } catch (Throwable th) {
                Throwable th2 = th;
                throw th2;
            }
        }
        return defineClass;
    }
}

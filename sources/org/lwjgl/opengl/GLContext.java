package org.lwjgl.opengl;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.Sys;

public final class GLContext {
    private static final Map<Object, ContextCapabilities> capability_cache;
    private static final ThreadLocal<ContextCapabilities> current_capabilities;
    private static boolean did_auto_load;
    private static CapabilitiesCacheEntry fast_path_cache;
    private static int gl_ref_count;
    private static final ThreadLocal<CapabilitiesCacheEntry> thread_cache_entries;

    private static final class CapabilitiesCacheEntry {
        ContextCapabilities capabilities;
        Thread owner;

        private CapabilitiesCacheEntry() {
        }

        /* synthetic */ CapabilitiesCacheEntry(C07901 r4) {
            C07901 r1 = r4;
            this();
        }
    }

    static {
        ThreadLocal<ContextCapabilities> threadLocal;
        CapabilitiesCacheEntry capabilitiesCacheEntry;
        ThreadLocal<CapabilitiesCacheEntry> threadLocal2;
        WeakHashMap weakHashMap;
        ThreadLocal<ContextCapabilities> threadLocal3 = threadLocal;
        ThreadLocal<ContextCapabilities> threadLocal4 = new ThreadLocal<>();
        current_capabilities = threadLocal3;
        CapabilitiesCacheEntry capabilitiesCacheEntry2 = capabilitiesCacheEntry;
        CapabilitiesCacheEntry capabilitiesCacheEntry3 = new CapabilitiesCacheEntry(null);
        fast_path_cache = capabilitiesCacheEntry2;
        ThreadLocal<CapabilitiesCacheEntry> threadLocal5 = threadLocal2;
        ThreadLocal<CapabilitiesCacheEntry> threadLocal6 = new ThreadLocal<>();
        thread_cache_entries = threadLocal5;
        WeakHashMap weakHashMap2 = weakHashMap;
        WeakHashMap weakHashMap3 = new WeakHashMap();
        capability_cache = weakHashMap2;
        Sys.initialize();
    }

    public GLContext() {
    }

    public static ContextCapabilities getCapabilities() {
        RuntimeException runtimeException;
        ContextCapabilities capabilitiesImpl = getCapabilitiesImpl();
        if (capabilitiesImpl != null) {
            return capabilitiesImpl;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("No OpenGL context found in the current thread.");
        throw runtimeException2;
    }

    static ContextCapabilities getCapabilities(Object obj) {
        return (ContextCapabilities) capability_cache.get(obj);
    }

    private static ContextCapabilities getCapabilitiesImpl() {
        CapabilitiesCacheEntry capabilitiesCacheEntry = fast_path_cache;
        return capabilitiesCacheEntry.owner == Thread.currentThread() ? capabilitiesCacheEntry.capabilities : getThreadLocalCapabilities();
    }

    static long getFunctionAddress(String str) {
        return ngetFunctionAddress(MemoryUtil.getAddress(MemoryUtil.encodeASCII(str)));
    }

    static long getFunctionAddress(String[] strArr) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        for (int i = 0; i < length; i++) {
            long functionAddress = getFunctionAddress(strArr2[i]);
            if (functionAddress != 0) {
                return functionAddress;
            }
        }
        return 0;
    }

    static long getPlatformSpecificFunctionAddress(String str, String[] strArr, String[] strArr2, String str2) {
        C07901 r10;
        String str3 = str;
        String[] strArr3 = strArr;
        String[] strArr4 = strArr2;
        String str4 = str2;
        C07901 r6 = r10;
        C07901 r7 = new PrivilegedAction<String>() {
            public String run() {
                return System.getProperty("os.name");
            }
        };
        String str5 = (String) AccessController.doPrivileged(r6);
        for (int i = 0; i < strArr3.length; i++) {
            if (str5.startsWith(strArr3[i])) {
                return getFunctionAddress(str4.replaceFirst(str3, strArr4[i]));
            }
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01fa, code lost:
        if (2 <= r8) goto L_0x01fc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int getSupportedExtensions(java.util.Set<java.lang.String> r34) {
        /*
            r2 = r34
            java.lang.String r26 = "1.3"
            if (r26 != 0) goto L_0x0014
            java.lang.IllegalStateException r26 = new java.lang.IllegalStateException
            r33 = r26
            r26 = r33
            r27 = r33
            java.lang.String r28 = "glGetString(GL_VERSION) returned null - possibly caused by missing current context."
            r27.<init>(r28)
            throw r26
        L_0x0014:
            java.util.StringTokenizer r26 = new java.util.StringTokenizer
            r33 = r26
            r26 = r33
            r27 = r33
            java.lang.String r28 = "1.3"
            java.lang.String r29 = ". "
            r27.<init>(r28, r29)
            r3 = r26
            r26 = r3
            java.lang.String r26 = r26.nextToken()
            r4 = r26
            r26 = r3
            java.lang.String r26 = r26.nextToken()
            r5 = r26
            r26 = 0
            r6 = r26
            r26 = r4
            int r26 = java.lang.Integer.parseInt(r26)     // Catch:{ NumberFormatException -> 0x0139 }
            r6 = r26
            r26 = r5
            int r26 = java.lang.Integer.parseInt(r26)     // Catch:{ NumberFormatException -> 0x0139 }
            r25 = r26
            r26 = r25
            r8 = r26
        L_0x004d:
            r26 = 4
            r0 = r26
            int[][] r0 = new int[r0][]
            r26 = r0
            r33 = r26
            r26 = r33
            r27 = r33
            r28 = 0
            r29 = 5
            r0 = r29
            int[] r0 = new int[r0]
            r29 = r0
            r29 = {1, 2, 3, 4, 5} // fill-array
            r27[r28] = r29
            r33 = r26
            r26 = r33
            r27 = r33
            r28 = 1
            r29 = 2
            r0 = r29
            int[] r0 = new int[r0]
            r29 = r0
            r29 = {0, 1} // fill-array
            r27[r28] = r29
            r33 = r26
            r26 = r33
            r27 = r33
            r28 = 2
            r29 = 4
            r0 = r29
            int[] r0 = new int[r0]
            r29 = r0
            r29 = {0, 1, 2, 3} // fill-array
            r27[r28] = r29
            r33 = r26
            r26 = r33
            r27 = r33
            r28 = 3
            r29 = 5
            r0 = r29
            int[] r0 = new int[r0]
            r29 = r0
            r29 = {0, 1, 2, 3, 4} // fill-array
            r27[r28] = r29
            r9 = r26
            r26 = 1
            r10 = r26
        L_0x00af:
            r26 = r10
            r27 = r9
            r0 = r27
            int r0 = r0.length
            r27 = r0
            r0 = r26
            r1 = r27
            if (r0 > r1) goto L_0x0168
            r26 = r9
            r27 = r10
            r28 = 1
            int r27 = r27 + -1
            r26 = r26[r27]
            r20 = r26
            r26 = r20
            r0 = r26
            int r0 = r0.length
            r26 = r0
            r21 = r26
            r26 = 0
            r22 = r26
        L_0x00d7:
            r26 = r22
            r27 = r21
            r0 = r26
            r1 = r27
            if (r0 >= r1) goto L_0x0164
            r26 = r20
            r27 = r22
            r26 = r26[r27]
            r23 = r26
            r26 = r10
            r27 = r6
            r0 = r26
            r1 = r27
            if (r0 < r1) goto L_0x0107
            r26 = r10
            r27 = r6
            r0 = r26
            r1 = r27
            if (r0 != r1) goto L_0x0136
            r26 = r23
            r27 = r8
            r0 = r26
            r1 = r27
            if (r0 > r1) goto L_0x0136
        L_0x0107:
            r26 = r2
            java.lang.StringBuilder r27 = new java.lang.StringBuilder
            r33 = r27
            r27 = r33
            r28 = r33
            r28.<init>()
            java.lang.String r28 = "OpenGL"
            java.lang.StringBuilder r27 = r27.append(r28)
            r28 = r10
            java.lang.String r28 = java.lang.Integer.toString(r28)
            java.lang.StringBuilder r27 = r27.append(r28)
            r28 = r23
            java.lang.String r28 = java.lang.Integer.toString(r28)
            java.lang.StringBuilder r27 = r27.append(r28)
            java.lang.String r27 = r27.toString()
            boolean r26 = r26.add(r27)
        L_0x0136:
            int r22 = r22 + 1
            goto L_0x00d7
        L_0x0139:
            r26 = move-exception
            r7 = r26
            java.lang.StringBuilder r26 = new java.lang.StringBuilder
            r33 = r26
            r26 = r33
            r27 = r33
            r27.<init>()
            java.lang.String r27 = "The major and/or minor OpenGL version is malformed: "
            java.lang.StringBuilder r26 = r26.append(r27)
            r27 = r7
            java.lang.String r27 = r27.getMessage()
            java.lang.StringBuilder r26 = r26.append(r27)
            java.lang.String r26 = r26.toString()
            org.lwjgl.LWJGLUtil.log(r26)
            r26 = 0
            r8 = r26
            goto L_0x004d
        L_0x0164:
            int r10 = r10 + 1
            goto L_0x00af
        L_0x0168:
            r26 = 0
            r11 = r26
            r26 = r6
            r27 = 3
            r0 = r26
            r1 = r27
            if (r0 >= r1) goto L_0x01bc
            r26 = 7939(0x1f03, float:1.1125E-41)
            java.lang.String r26 = org.lwjgl.opengl.GL11.glGetString(r26)
            r16 = r26
            r26 = r16
            if (r26 != 0) goto L_0x0190
            java.lang.IllegalStateException r26 = new java.lang.IllegalStateException
            r33 = r26
            r26 = r33
            r27 = r33
            java.lang.String r28 = "glGetString(GL_EXTENSIONS) returned null - is there a context current?"
            r27.<init>(r28)
            throw r26
        L_0x0190:
            java.util.StringTokenizer r26 = new java.util.StringTokenizer
            r33 = r26
            r26 = r33
            r27 = r33
            r28 = r16
            r27.<init>(r28)
            r17 = r26
        L_0x019f:
            r26 = r17
            boolean r26 = r26.hasMoreTokens()
            r18 = r26
            r26 = 0
            r11 = r26
            r26 = r18
            if (r26 == 0) goto L_0x020b
            r26 = r2
            r27 = r17
            java.lang.String r27 = r27.nextToken()
            boolean r26 = r26.add(r27)
            goto L_0x019f
        L_0x01bc:
            r26 = 33309(0x821d, float:4.6676E-41)
            int r26 = org.lwjgl.opengl.GL11.glGetInteger(r26)
            r12 = r26
            r26 = 0
            r13 = r26
        L_0x01c9:
            r26 = r13
            r27 = r12
            r0 = r26
            r1 = r27
            if (r0 >= r1) goto L_0x01e4
            r26 = r2
            r27 = 7939(0x1f03, float:1.1125E-41)
            r28 = r13
            java.lang.String r27 = org.lwjgl.opengl.GL30.glGetStringi(r27, r28)
            boolean r26 = r26.add(r27)
            int r13 = r13 + 1
            goto L_0x01c9
        L_0x01e4:
            r26 = 3
            r27 = r6
            r0 = r26
            r1 = r27
            if (r0 < r1) goto L_0x01fc
            r26 = 0
            r11 = r26
            r26 = 2
            r27 = r8
            r0 = r26
            r1 = r27
            if (r0 > r1) goto L_0x020b
        L_0x01fc:
            org.lwjgl.opengl.Util.checkGLError()
            r26 = 37158(0x9126, float:5.207E-41)
            int r26 = org.lwjgl.opengl.GL11.glGetInteger(r26)     // Catch:{ OpenGLException -> 0x0210 }
            r11 = r26
            org.lwjgl.opengl.Util.checkGLError()     // Catch:{ OpenGLException -> 0x0210 }
        L_0x020b:
            r26 = r11
            r2 = r26
        L_0x020f:
            return r2
        L_0x0210:
            r26 = move-exception
            r14 = r26
            java.lang.String r26 = "Failed to retrieve CONTEXT_PROFILE_MASK"
            org.lwjgl.LWJGLUtil.log(r26)
            r26 = r11
            r2 = r26
            goto L_0x020f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.GLContext.getSupportedExtensions(java.util.Set):int");
    }

    private static ContextCapabilities getThreadLocalCapabilities() {
        return (ContextCapabilities) current_capabilities.get();
    }

    static void initNativeStubs(Class<?> cls, Set set, String str) {
        StringBuilder sb;
        C07912 r7;
        Class<?> cls2 = cls;
        Set set2 = set;
        String str2 = str;
        resetNativeStubs(cls2);
        if (set2.contains(str2)) {
            try {
                C07912 r4 = r7;
                final Class<?> cls3 = cls2;
                C07912 r5 = new PrivilegedExceptionAction<Object>() {
                    public Object run() throws Exception {
                        Object invoke = cls3.getDeclaredMethod("initNativeStubs", new Class[0]).invoke(null, new Object[0]);
                        return null;
                    }
                };
                Object doPrivileged = AccessController.doPrivileged(r4);
            } catch (Exception e) {
                Exception exc = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Failed to initialize extension ").append(cls2).append(" - exception: ").append(exc).toString());
                boolean remove = set2.remove(str2);
            }
        }
    }

    public static void loadOpenGLLibrary() throws LWJGLException {
        synchronized (GLContext.class) {
            try {
                if (gl_ref_count == 0) {
                    nLoadOpenGLLibrary();
                }
                gl_ref_count = 1 + gl_ref_count;
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<GLContext> cls = GLContext.class;
                throw th2;
            }
        }
    }

    private static native void nLoadOpenGLLibrary() throws LWJGLException;

    private static native void nUnloadOpenGLLibrary();

    private static native long ngetFunctionAddress(long j);

    static native void resetNativeStubs(Class cls);

    static void setCapabilities(ContextCapabilities contextCapabilities) {
        CapabilitiesCacheEntry capabilitiesCacheEntry;
        ContextCapabilities contextCapabilities2 = contextCapabilities;
        current_capabilities.set(contextCapabilities2);
        CapabilitiesCacheEntry capabilitiesCacheEntry2 = (CapabilitiesCacheEntry) thread_cache_entries.get();
        if (capabilitiesCacheEntry2 == null) {
            CapabilitiesCacheEntry capabilitiesCacheEntry3 = capabilitiesCacheEntry;
            CapabilitiesCacheEntry capabilitiesCacheEntry4 = new CapabilitiesCacheEntry(null);
            capabilitiesCacheEntry2 = capabilitiesCacheEntry3;
            thread_cache_entries.set(capabilitiesCacheEntry2);
        }
        capabilitiesCacheEntry2.owner = Thread.currentThread();
        capabilitiesCacheEntry2.capabilities = contextCapabilities2;
        fast_path_cache = capabilitiesCacheEntry2;
    }

    public static void unloadOpenGLLibrary() {
        synchronized (GLContext.class) {
            try {
                gl_ref_count = -1 + gl_ref_count;
                if (gl_ref_count == 0 && LWJGLUtil.getPlatform() != 1) {
                    nUnloadOpenGLLibrary();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<GLContext> cls = GLContext.class;
                throw th2;
            }
        }
    }

    public static void useContext(Object obj) throws LWJGLException {
        Object obj2 = obj;
        synchronized (GLContext.class) {
            try {
                useContext(obj2, false);
            } catch (Throwable th) {
                Throwable th2 = th;
                Class<GLContext> cls = GLContext.class;
                throw th2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        if (did_auto_load != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
        unloadOpenGLLibrary();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0051, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        r2 = r5;
        r5 = org.lwjgl.opengl.GLContext.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x0008, B:15:0x0024] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void useContext(java.lang.Object r9, boolean r10) throws org.lwjgl.LWJGLException {
        /*
            r0 = r9
            r1 = r10
            java.lang.Class<org.lwjgl.opengl.GLContext> r5 = org.lwjgl.opengl.GLContext.class
            monitor-enter(r5)
            r5 = r0
            if (r5 != 0) goto L_0x001a
            org.lwjgl.opengl.ContextCapabilities.unloadAllStubs()     // Catch:{ all -> 0x0051 }
            r5 = 0
            setCapabilities(r5)     // Catch:{ all -> 0x0051 }
            boolean r5 = did_auto_load     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x0016
            unloadOpenGLLibrary()     // Catch:{ all -> 0x0051 }
        L_0x0016:
            java.lang.Class<org.lwjgl.opengl.GLContext> r5 = org.lwjgl.opengl.GLContext.class
            monitor-exit(r5)
            return
        L_0x001a:
            int r5 = gl_ref_count     // Catch:{ all -> 0x0051 }
            if (r5 != 0) goto L_0x0024
            loadOpenGLLibrary()     // Catch:{ all -> 0x0051 }
            r5 = 1
            did_auto_load = r5     // Catch:{ all -> 0x0051 }
        L_0x0024:
            java.util.Map<java.lang.Object, org.lwjgl.opengl.ContextCapabilities> r5 = capability_cache     // Catch:{ LWJGLException -> 0x0046 }
            r6 = r0
            java.lang.Object r5 = r5.get(r6)     // Catch:{ LWJGLException -> 0x0046 }
            org.lwjgl.opengl.ContextCapabilities r5 = (org.lwjgl.opengl.ContextCapabilities) r5     // Catch:{ LWJGLException -> 0x0046 }
            r4 = r5
            r5 = r4
            if (r5 != 0) goto L_0x0058
            org.lwjgl.opengl.ContextCapabilities r5 = new org.lwjgl.opengl.ContextCapabilities     // Catch:{ LWJGLException -> 0x0046 }
            r8 = r5
            r5 = r8
            r6 = r8
            r7 = r1
            r6.<init>(r7)     // Catch:{ LWJGLException -> 0x0046 }
            java.util.Map<java.lang.Object, org.lwjgl.opengl.ContextCapabilities> r5 = capability_cache     // Catch:{ LWJGLException -> 0x0046 }
            r6 = r0
            org.lwjgl.opengl.ContextCapabilities r7 = getCapabilities()     // Catch:{ LWJGLException -> 0x0046 }
            java.lang.Object r5 = r5.put(r6, r7)     // Catch:{ LWJGLException -> 0x0046 }
            goto L_0x0016
        L_0x0046:
            r5 = move-exception
            r3 = r5
            boolean r5 = did_auto_load     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x004f
            unloadOpenGLLibrary()     // Catch:{ all -> 0x0051 }
        L_0x004f:
            r5 = r3
            throw r5     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r5 = move-exception
            r2 = r5
            java.lang.Class<org.lwjgl.opengl.GLContext> r5 = org.lwjgl.opengl.GLContext.class
            monitor-exit(r5)
            r5 = r2
            throw r5
        L_0x0058:
            r5 = r4
            setCapabilities(r5)     // Catch:{ LWJGLException -> 0x0046 }
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.opengl.GLContext.useContext(java.lang.Object, boolean):void");
    }
}

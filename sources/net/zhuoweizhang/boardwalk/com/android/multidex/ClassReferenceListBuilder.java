package net.zhuoweizhang.boardwalk.com.android.multidex;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.DirectClassFile;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct.StdAttributeFactory;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.TypeList;

public class ClassReferenceListBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = (!ClassReferenceListBuilder.class.desiredAssertionStatus());
    private static final String CLASS_EXTENSION = ".class";
    private static final String EOL = System.getProperty("line.separator");
    private static final int STATUS_ERROR = 1;
    private static String USAGE_MESSAGE;
    private Path path;
    private Set<String> toKeep;

    private static class Path {
        static final /* synthetic */ boolean $assertionsDisabled = (!ClassReferenceListBuilder.class.desiredAssertionStatus());
        private ByteArrayOutputStream baos;
        private String definition;
        /* access modifiers changed from: private */
        public List<ClassPathElement> elements;
        private byte[] readBuffer = new byte[20480];

        public Path(String str) throws IOException {
            ArrayList arrayList;
            ByteArrayOutputStream byteArrayOutputStream;
            IOException iOException;
            StringBuilder sb;
            File file;
            String str2 = str;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            this.elements = arrayList2;
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(40960);
            this.baos = byteArrayOutputStream2;
            this.definition = str2;
            String[] split = str2.split(Pattern.quote(File.pathSeparator));
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                try {
                    File file2 = file;
                    File file3 = new File(str3);
                    addElement(ClassReferenceListBuilder.getClassPathElement(file2));
                    i++;
                } catch (IOException e) {
                    IOException iOException2 = e;
                    IOException iOException3 = iOException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IOException iOException4 = new IOException(sb2.append("\"").append(str3).append("\" can not be used as a classpath").append(" element. (").append(iOException2.getMessage()).append(")").toString(), iOException2);
                    throw iOException3;
                }
            }
        }

        private void addElement(ClassPathElement classPathElement) {
            AssertionError assertionError;
            ClassPathElement classPathElement2 = classPathElement;
            if ($assertionsDisabled || classPathElement2 != null) {
                boolean add = this.elements.add(classPathElement2);
                return;
            }
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }

        /* access modifiers changed from: private */
        public DirectClassFile getClass(String str) throws FileNotFoundException {
            DirectClassFile directClassFile;
            FileNotFoundException fileNotFoundException;
            DirectClassFile directClassFile2;
            Throwable th;
            DirectClassFile directClassFile3;
            String str2 = str;
            Iterator it = this.elements.iterator();
            DirectClassFile directClassFile4 = null;
            while (true) {
                DirectClassFile directClassFile5 = directClassFile4;
                if (!it.hasNext()) {
                    directClassFile = directClassFile5;
                    break;
                }
                try {
                    InputStream open = ((ClassPathElement) it.next()).open(str2);
                    try {
                        byte[] readStream = readStream(open, this.baos, this.readBuffer);
                        this.baos.reset();
                        DirectClassFile directClassFile6 = directClassFile3;
                        DirectClassFile directClassFile7 = new DirectClassFile(readStream, str2, false);
                        directClassFile = directClassFile6;
                        try {
                            directClassFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
                            try {
                                open.close();
                                break;
                            } catch (IOException e) {
                                IOException iOException = e;
                                directClassFile2 = directClassFile;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            directClassFile5 = directClassFile;
                            open.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        open.close();
                        throw th;
                    }
                } catch (IOException e2) {
                    IOException iOException2 = e2;
                    directClassFile2 = directClassFile5;
                }
                directClassFile4 = directClassFile2;
            }
            if (directClassFile != null) {
                return directClassFile;
            }
            FileNotFoundException fileNotFoundException2 = fileNotFoundException;
            FileNotFoundException fileNotFoundException3 = new FileNotFoundException(str2);
            throw fileNotFoundException2;
        }

        private static byte[] readStream(InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) throws IOException {
            InputStream inputStream2 = inputStream;
            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
            byte[] bArr2 = bArr;
            while (true) {
                try {
                    int read = inputStream2.read(bArr2);
                    if (read < 0) {
                        inputStream2.close();
                        return byteArrayOutputStream2.toByteArray();
                    }
                    byteArrayOutputStream2.write(bArr2, 0, read);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    inputStream2.close();
                    throw th2;
                }
            }
        }

        public String toString() {
            return this.definition;
        }
    }

    static {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        USAGE_MESSAGE = sb2.append("Usage:").append(EOL).append(EOL).append("Short version: Don't use this.").append(EOL).append(EOL).append("Slightly longer version: This tool is used by mainDexClasses script to find direct").append(EOL).append("references of some classes.").append(EOL).toString();
    }

    private ClassReferenceListBuilder(Path path2) {
        HashSet hashSet;
        Path path3 = path2;
        HashSet hashSet2 = hashSet;
        HashSet hashSet3 = new HashSet();
        this.toKeep = hashSet2;
        this.path = path3;
    }

    private void addClassWithHierachy(String str) {
        StringBuilder sb;
        String str2 = str;
        if (!this.toKeep.contains(str2)) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            try {
                DirectClassFile access$100 = this.path.getClass(sb2.append(str2).append(CLASS_EXTENSION).toString());
                boolean add = this.toKeep.add(str2);
                CstType superclass = access$100.getSuperclass();
                if (superclass != null) {
                    addClassWithHierachy(superclass.getClassType().getClassName());
                }
                TypeList interfaces = access$100.getInterfaces();
                int size = interfaces.size();
                for (int i = 0; i < size; i++) {
                    addClassWithHierachy(interfaces.getType(i).getClassName());
                }
            } catch (FileNotFoundException e) {
                FileNotFoundException fileNotFoundException = e;
            }
        }
    }

    private void addDependencies(ConstantPool constantPool) {
        AssertionError assertionError;
        ConstantPool constantPool2 = constantPool;
        int size = constantPool2.size();
        Constant[] entries = constantPool2.getEntries();
        int length = entries.length;
        for (int i = 0; i < length; i++) {
            Constant constant = entries[i];
            if (constant instanceof CstType) {
                String descriptor = ((CstType) constant).getClassType().getDescriptor();
                if (descriptor.endsWith(";")) {
                    int lastIndexOf = descriptor.lastIndexOf(91);
                    if (lastIndexOf < 0) {
                        addClassWithHierachy(descriptor.substring(1, -1 + descriptor.length()));
                    } else if ($assertionsDisabled || (descriptor.length() > lastIndexOf + 3 && descriptor.charAt(lastIndexOf + 1) == 'L')) {
                        addClassWithHierachy(descriptor.substring(lastIndexOf + 2, -1 + descriptor.length()));
                    } else {
                        AssertionError assertionError2 = assertionError;
                        AssertionError assertionError3 = new AssertionError();
                        throw assertionError2;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private void addRoots(ZipFile zipFile) throws IOException {
        IOException iOException;
        StringBuilder sb;
        ZipFile zipFile2 = zipFile;
        Enumeration entries = zipFile2.entries();
        while (entries.hasMoreElements()) {
            String name = ((ZipEntry) entries.nextElement()).getName();
            if (name.endsWith(CLASS_EXTENSION)) {
                boolean add = this.toKeep.add(name.substring(0, name.length() - CLASS_EXTENSION.length()));
            }
        }
        Enumeration entries2 = zipFile2.entries();
        while (entries2.hasMoreElements()) {
            String name2 = ((ZipEntry) entries2.nextElement()).getName();
            if (name2.endsWith(CLASS_EXTENSION)) {
                try {
                    addDependencies(this.path.getClass(name2).getConstantPool());
                } catch (FileNotFoundException e) {
                    FileNotFoundException fileNotFoundException = e;
                    IOException iOException2 = iOException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IOException iOException3 = new IOException(sb2.append("Class ").append(name2).append(" is missing form original class path ").append(this.path).toString(), fileNotFoundException);
                    throw iOException2;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static ClassPathElement getClassPathElement(File file) throws ZipException, IOException {
        FileNotFoundException fileNotFoundException;
        IOException iOException;
        StringBuilder sb;
        ArchivePathElement archivePathElement;
        ZipFile zipFile;
        FolderPathElement folderPathElement;
        File file2 = file;
        if (file2.isDirectory()) {
            FolderPathElement folderPathElement2 = folderPathElement;
            FolderPathElement folderPathElement3 = new FolderPathElement(file2);
            return folderPathElement2;
        } else if (file2.isFile()) {
            ArchivePathElement archivePathElement2 = archivePathElement;
            ZipFile zipFile2 = zipFile;
            ZipFile zipFile3 = new ZipFile(file2);
            ArchivePathElement archivePathElement3 = new ArchivePathElement(zipFile2);
            return archivePathElement2;
        } else if (file2.exists()) {
            IOException iOException2 = iOException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IOException iOException3 = new IOException(sb2.append(file2.getAbsolutePath()).append(" is not a directory neither a zip file").toString());
            throw iOException2;
        } else {
            FileNotFoundException fileNotFoundException2 = fileNotFoundException;
            FileNotFoundException fileNotFoundException3 = new FileNotFoundException(file2.getAbsolutePath());
            throw fileNotFoundException2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void main(java.lang.String[] r29) {
        /*
            r2 = r29
            r24 = r2
            r0 = r24
            int r0 = r0.length
            r24 = r0
            r25 = 2
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x0019
            printUsage()
            r24 = 1
            java.lang.System.exit(r24)
        L_0x0019:
            java.util.zip.ZipFile r24 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0095 }
            r28 = r24
            r24 = r28
            r25 = r28
            r26 = r2
            r27 = 0
            r26 = r26[r27]     // Catch:{ IOException -> 0x0095 }
            r25.<init>(r26)     // Catch:{ IOException -> 0x0095 }
            r3 = r24
            r24 = 0
            r4 = r24
            net.zhuoweizhang.boardwalk.com.android.multidex.ClassReferenceListBuilder$Path r24 = new net.zhuoweizhang.boardwalk.com.android.multidex.ClassReferenceListBuilder$Path     // Catch:{ IOException -> 0x00d8, all -> 0x0139 }
            r28 = r24
            r24 = r28
            r25 = r28
            r26 = r2
            r27 = 1
            r26 = r26[r27]     // Catch:{ IOException -> 0x00d8, all -> 0x0139 }
            r25.<init>(r26)     // Catch:{ IOException -> 0x00d8, all -> 0x0139 }
            r5 = r24
            net.zhuoweizhang.boardwalk.com.android.multidex.ClassReferenceListBuilder r24 = new net.zhuoweizhang.boardwalk.com.android.multidex.ClassReferenceListBuilder     // Catch:{ IOException -> 0x018d }
            r28 = r24
            r24 = r28
            r25 = r28
            r26 = r5
            r25.<init>(r26)     // Catch:{ IOException -> 0x018d }
            r6 = r24
            r24 = r6
            r25 = r3
            r24.addRoots(r25)     // Catch:{ IOException -> 0x018d }
            r24 = r6
            r0 = r24
            java.util.Set<java.lang.String> r0 = r0.toKeep     // Catch:{ IOException -> 0x018d }
            r24 = r0
            printList(r24)     // Catch:{ IOException -> 0x018d }
            r24 = r3
            r24.close()     // Catch:{ IOException -> 0x0174 }
        L_0x0069:
            r24 = r5
            if (r24 == 0) goto L_0x00d7
            r24 = r5
            java.util.List r24 = r24.elements
            java.util.Iterator r24 = r24.iterator()
            r19 = r24
        L_0x0079:
            r24 = r19
            boolean r24 = r24.hasNext()
            if (r24 == 0) goto L_0x00d7
            r24 = r19
            java.lang.Object r24 = r24.next()
            net.zhuoweizhang.boardwalk.com.android.multidex.ClassPathElement r24 = (net.zhuoweizhang.boardwalk.com.android.multidex.ClassPathElement) r24
            r20 = r24
            r24 = r20
            r24.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x0079
        L_0x0091:
            r24 = move-exception
            r21 = r24
            goto L_0x0079
        L_0x0095:
            r24 = move-exception
            r23 = r24
            java.io.PrintStream r24 = java.lang.System.err
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r28 = r25
            r25 = r28
            r26 = r28
            r26.<init>()
            java.lang.String r26 = "\""
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r2
            r27 = 0
            r26 = r26[r27]
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r26 = "\" can not be read as a zip archive. ("
            java.lang.StringBuilder r25 = r25.append(r26)
            r26 = r23
            java.lang.String r26 = r26.getMessage()
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r26 = ")"
            java.lang.StringBuilder r25 = r25.append(r26)
            java.lang.String r25 = r25.toString()
            r24.println(r25)
            r24 = 1
            java.lang.System.exit(r24)
        L_0x00d7:
            return
        L_0x00d8:
            r24 = move-exception
            r7 = r24
            r24 = 0
            r5 = r24
        L_0x00df:
            java.io.PrintStream r24 = java.lang.System.err     // Catch:{ all -> 0x0181 }
            java.lang.StringBuilder r25 = new java.lang.StringBuilder     // Catch:{ all -> 0x0181 }
            r28 = r25
            r25 = r28
            r26 = r28
            r26.<init>()     // Catch:{ all -> 0x0181 }
            java.lang.String r26 = "A fatal error occured: "
            java.lang.StringBuilder r25 = r25.append(r26)     // Catch:{ all -> 0x0181 }
            r26 = r7
            java.lang.String r26 = r26.getMessage()     // Catch:{ all -> 0x0181 }
            java.lang.StringBuilder r25 = r25.append(r26)     // Catch:{ all -> 0x0181 }
            java.lang.String r25 = r25.toString()     // Catch:{ all -> 0x0181 }
            r24.println(r25)     // Catch:{ all -> 0x0181 }
            r24 = 1
            java.lang.System.exit(r24)     // Catch:{ all -> 0x0181 }
            r24 = r3
            r24.close()     // Catch:{ IOException -> 0x0179 }
        L_0x010d:
            r24 = r5
            if (r24 == 0) goto L_0x00d7
            r24 = r5
            java.util.List r24 = r24.elements
            java.util.Iterator r24 = r24.iterator()
            r15 = r24
        L_0x011d:
            r24 = r15
            boolean r24 = r24.hasNext()
            if (r24 == 0) goto L_0x00d7
            r24 = r15
            java.lang.Object r24 = r24.next()
            net.zhuoweizhang.boardwalk.com.android.multidex.ClassPathElement r24 = (net.zhuoweizhang.boardwalk.com.android.multidex.ClassPathElement) r24
            r16 = r24
            r24 = r16
            r24.close()     // Catch:{ IOException -> 0x0135 }
            goto L_0x011d
        L_0x0135:
            r24 = move-exception
            r17 = r24
            goto L_0x011d
        L_0x0139:
            r24 = move-exception
            r22 = r24
            r24 = r22
            r9 = r24
        L_0x0140:
            r24 = r3
            r24.close()     // Catch:{ IOException -> 0x017d }
        L_0x0145:
            r24 = r4
            if (r24 == 0) goto L_0x0171
            r24 = r4
            java.util.List r24 = r24.elements
            java.util.Iterator r24 = r24.iterator()
            r11 = r24
        L_0x0155:
            r24 = r11
            boolean r24 = r24.hasNext()
            if (r24 == 0) goto L_0x0171
            r24 = r11
            java.lang.Object r24 = r24.next()
            net.zhuoweizhang.boardwalk.com.android.multidex.ClassPathElement r24 = (net.zhuoweizhang.boardwalk.com.android.multidex.ClassPathElement) r24
            r12 = r24
            r24 = r12
            r24.close()     // Catch:{ IOException -> 0x016d }
            goto L_0x0155
        L_0x016d:
            r24 = move-exception
            r13 = r24
            goto L_0x0155
        L_0x0171:
            r24 = r9
            throw r24
        L_0x0174:
            r24 = move-exception
            r18 = r24
            goto L_0x0069
        L_0x0179:
            r24 = move-exception
            r14 = r24
            goto L_0x010d
        L_0x017d:
            r24 = move-exception
            r10 = r24
            goto L_0x0145
        L_0x0181:
            r24 = move-exception
            r8 = r24
            r24 = r5
            r4 = r24
            r24 = r8
            r9 = r24
            goto L_0x0140
        L_0x018d:
            r24 = move-exception
            r7 = r24
            goto L_0x00df
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.multidex.ClassReferenceListBuilder.main(java.lang.String[]):void");
    }

    private static void printList(Set<String> set) {
        for (String print : set) {
            System.out.print(print);
            System.out.println(CLASS_EXTENSION);
        }
    }

    private static void printUsage() {
        System.err.print(USAGE_MESSAGE);
    }
}

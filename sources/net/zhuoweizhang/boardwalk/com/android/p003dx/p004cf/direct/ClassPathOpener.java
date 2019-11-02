package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.dex.util.FileUtils;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.ClassPathOpener */
public class ClassPathOpener {
    public static final FileNameFilter acceptAll;
    private final Consumer consumer;
    private FileNameFilter filter;
    private final String pathname;
    private final boolean sort;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.ClassPathOpener$Consumer */
    public interface Consumer {
        void onException(Exception exc);

        void onProcessArchiveStart(File file);

        boolean processFileBytes(String str, long j, byte[] bArr);
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.ClassPathOpener$FileNameFilter */
    public interface FileNameFilter {
        boolean accept(String str);
    }

    static {
        C06521 r2;
        C06521 r0 = r2;
        C06521 r1 = new FileNameFilter() {
            public boolean accept(String str) {
                String str2 = str;
                return true;
            }
        };
        acceptAll = r0;
    }

    public ClassPathOpener(String str, boolean z, Consumer consumer2) {
        this(str, z, acceptAll, consumer2);
    }

    public ClassPathOpener(String str, boolean z, FileNameFilter fileNameFilter, Consumer consumer2) {
        boolean z2 = z;
        FileNameFilter fileNameFilter2 = fileNameFilter;
        Consumer consumer3 = consumer2;
        this.pathname = str;
        this.sort = z2;
        this.consumer = consumer3;
        this.filter = fileNameFilter2;
    }

    /* access modifiers changed from: private */
    public static int compareClassNames(String str, String str2) {
        String str3 = str2;
        return str.replace('$', '0').replace("package-info", LibrariesRepository.MOJANG_MAVEN_REPO).compareTo(str3.replace('$', '0').replace("package-info", LibrariesRepository.MOJANG_MAVEN_REPO));
    }

    private boolean processArchive(File file) throws IOException {
        ZipFile zipFile;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        C06543 r20;
        File file2 = file;
        ZipFile zipFile2 = zipFile;
        ZipFile zipFile3 = new ZipFile(file2);
        ZipFile zipFile4 = zipFile2;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(40000);
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        byte[] bArr = new byte[20000];
        ArrayList list = Collections.list(zipFile4.entries());
        if (this.sort) {
            ArrayList arrayList = list;
            C06543 r15 = r20;
            C06543 r16 = new Comparator<ZipEntry>(this) {
                final /* synthetic */ ClassPathOpener this$0;

                {
                    this.this$0 = r5;
                }

                public int compare(ZipEntry zipEntry, ZipEntry zipEntry2) {
                    return ClassPathOpener.compareClassNames(zipEntry.getName(), zipEntry2.getName());
                }
            };
            Collections.sort(arrayList, r15);
        }
        this.consumer.onProcessArchiveStart(file2);
        Iterator it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            ZipEntry zipEntry = (ZipEntry) it.next();
            if (!zipEntry.isDirectory()) {
                String name = zipEntry.getName();
                if (this.filter.accept(name)) {
                    InputStream inputStream = zipFile4.getInputStream(zipEntry);
                    byteArrayOutputStream4.reset();
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream4.write(bArr, 0, read);
                    }
                    inputStream.close();
                    z = z2 | this.consumer.processFileBytes(name, zipEntry.getTime(), byteArrayOutputStream4.toByteArray());
                } else {
                    z = z2;
                }
                z2 = z;
            }
        }
        zipFile4.close();
        return z2;
    }

    private boolean processDirectory(File file, boolean z) {
        C06532 r11;
        File file2;
        File file3 = file;
        if (z) {
            File file4 = file2;
            File file5 = new File(file3, ".");
            file3 = file4;
        }
        File[] listFiles = file3.listFiles();
        int length = listFiles.length;
        if (this.sort) {
            File[] fileArr = listFiles;
            C06532 r8 = r11;
            C06532 r9 = new Comparator<File>(this) {
                final /* synthetic */ ClassPathOpener this$0;

                {
                    this.this$0 = r5;
                }

                public int compare(File file, File file2) {
                    return ClassPathOpener.compareClassNames(file.getName(), file2.getName());
                }
            };
            Arrays.sort(fileArr, r8);
        }
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            z2 |= processOne(listFiles[i], false);
        }
        return z2;
    }

    private boolean processOne(File file, boolean z) {
        File file2 = file;
        boolean z2 = z;
        try {
            if (file2.isDirectory()) {
                return processDirectory(file2, z2);
            }
            String path = file2.getPath();
            if (path.endsWith(".zip") || path.endsWith(".jar") || path.endsWith(".apk")) {
                return processArchive(file2);
            }
            if (this.filter.accept(path)) {
                return this.consumer.processFileBytes(path, file2.lastModified(), FileUtils.readFile(file2));
            }
            return false;
        } catch (Exception e) {
            this.consumer.onException(e);
        }
    }

    public boolean process() {
        File file;
        File file2 = file;
        File file3 = new File(this.pathname);
        return processOne(file2, true);
    }
}

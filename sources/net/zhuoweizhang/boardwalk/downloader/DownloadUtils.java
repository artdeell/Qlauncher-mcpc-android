package net.zhuoweizhang.boardwalk.downloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import net.zhuoweizhang.boardwalk.util.IoUtil;

public class DownloadUtils {
    public static final String USER_AGENT = "Boardwalk";
    public static final Charset utf8 = Charset.forName("UTF-8");

    public DownloadUtils() {
    }

    public static void download(String str, OutputStream outputStream) throws IOException {
        RuntimeException runtimeException;
        URL url;
        OutputStream outputStream2 = outputStream;
        try {
            URL url2 = url;
            URL url3 = new URL(str);
            download(url2, outputStream2);
        } catch (MalformedURLException e) {
            MalformedURLException malformedURLException = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(malformedURLException);
            throw runtimeException2;
        }
    }

    public static void download(URL url, OutputStream outputStream) throws IOException {
        OutputStream outputStream2 = outputStream;
        InputStream inputStream = null;
        byte[] bArr = new byte[16384];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            IoUtil.pipe(inputStream, outputStream2, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    Exception exc = e;
                }
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    Exception exc2 = e2;
                }
            }
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void downloadFile(java.lang.String r13, java.io.File r14) throws java.io.IOException {
        /*
            r0 = r13
            r1 = r14
            r7 = r1
            java.io.File r7 = r7.getParentFile()
            boolean r7 = r7.mkdirs()
            r7 = r1
            java.lang.String r7 = r7.getName()
            java.lang.String r8 = ".part"
            r9 = r1
            java.io.File r9 = r9.getParentFile()
            java.io.File r7 = java.io.File.createTempFile(r7, r8, r9)
            r3 = r7
            r7 = 0
            r4 = r7
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x004f }
            r12 = r7
            r7 = r12
            r8 = r12
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x004f }
            r12 = r9
            r9 = r12
            r10 = r12
            r11 = r3
            r10.<init>(r11)     // Catch:{ all -> 0x004f }
            r8.<init>(r9)     // Catch:{ all -> 0x004f }
            r5 = r7
            r7 = r0
            r8 = r5
            download(r7, r8)     // Catch:{ all -> 0x0066 }
            r7 = r3
            r8 = r1
            boolean r7 = r7.renameTo(r8)     // Catch:{ all -> 0x0066 }
            r7 = r5
            if (r7 == 0) goto L_0x0042
            r7 = r5
            r7.close()
        L_0x0042:
            r7 = r3
            boolean r7 = r7.exists()
            if (r7 == 0) goto L_0x004e
            r7 = r3
            boolean r7 = r7.delete()
        L_0x004e:
            return
        L_0x004f:
            r7 = move-exception
            r6 = r7
        L_0x0051:
            r7 = r4
            if (r7 == 0) goto L_0x0058
            r7 = r4
            r7.close()
        L_0x0058:
            r7 = r3
            boolean r7 = r7.exists()
            if (r7 == 0) goto L_0x0064
            r7 = r3
            boolean r7 = r7.delete()
        L_0x0064:
            r7 = r6
            throw r7
        L_0x0066:
            r7 = move-exception
            r6 = r7
            r7 = r5
            r4 = r7
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.downloader.DownloadUtils.downloadFile(java.lang.String, java.io.File):void");
    }

    public static String downloadString(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        String str3 = str;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        download(str3, (OutputStream) byteArrayOutputStream4);
        String str4 = str2;
        String str5 = new String(byteArrayOutputStream4.toByteArray(), utf8);
        return str4;
    }
}

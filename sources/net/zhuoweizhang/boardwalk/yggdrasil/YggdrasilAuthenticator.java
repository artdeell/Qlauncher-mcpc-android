package net.zhuoweizhang.boardwalk.yggdrasil;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.UUID;

public class YggdrasilAuthenticator {
    private static final String API_URL = "https://authserver.mojang.com";
    private String clientName = "Minecraft";
    private int clientVersion = 1;
    private Gson gson;

    public YggdrasilAuthenticator() {
        Gson gson2;
        Gson gson3 = gson2;
        Gson gson4 = new Gson();
        this.gson = gson3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T makeRequest(java.lang.String r26, java.lang.Object r27, java.lang.Class<T> r28) throws java.io.IOException {
        /*
            r25 = this;
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r20 = 0
            r6 = r20
            r20 = 16384(0x4000, float:2.2959E-41)
            r0 = r20
            byte[] r0 = new byte[r0]
            r20 = r0
            r7 = r20
            java.io.ByteArrayOutputStream r20 = new java.io.ByteArrayOutputStream
            r24 = r20
            r20 = r24
            r21 = r24
            r21.<init>()
            r8 = r20
            r20 = r2
            r0 = r20
            com.google.gson.Gson r0 = r0.gson
            r20 = r0
            r21 = r4
            java.lang.String r20 = r20.toJson(r21)
            r9 = r20
            java.net.URL r20 = new java.net.URL     // Catch:{ all -> 0x0176 }
            r24 = r20
            r20 = r24
            r21 = r24
            java.lang.StringBuilder r22 = new java.lang.StringBuilder     // Catch:{ all -> 0x0176 }
            r24 = r22
            r22 = r24
            r23 = r24
            r23.<init>()     // Catch:{ all -> 0x0176 }
            java.lang.String r23 = "https://authserver.mojang.com/"
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ all -> 0x0176 }
            r23 = r3
            java.lang.StringBuilder r22 = r22.append(r23)     // Catch:{ all -> 0x0176 }
            java.lang.String r22 = r22.toString()     // Catch:{ all -> 0x0176 }
            r21.<init>(r22)     // Catch:{ all -> 0x0176 }
            r10 = r20
            r20 = r10
            java.net.URLConnection r20 = r20.openConnection()     // Catch:{ all -> 0x013d }
            java.net.HttpURLConnection r20 = (java.net.HttpURLConnection) r20     // Catch:{ all -> 0x013d }
            r13 = r20
            r20 = r13
            java.lang.String r21 = "User-Agent"
            java.lang.String r22 = "Boardwalk"
            r20.setRequestProperty(r21, r22)     // Catch:{ all -> 0x013d }
            r20 = r13
            r21 = 1
            r20.setDoInput(r21)     // Catch:{ all -> 0x013d }
            r20 = r13
            java.lang.String r21 = "POST"
            r20.setRequestMethod(r21)     // Catch:{ all -> 0x013d }
            r20 = r13
            java.lang.String r21 = "Content-Type"
            java.lang.String r22 = "application/json"
            r20.setRequestProperty(r21, r22)     // Catch:{ all -> 0x013d }
            r20 = r13
            r20.connect()     // Catch:{ all -> 0x013d }
            r20 = 0
            r14 = r20
            r20 = r13
            java.io.OutputStream r20 = r20.getOutputStream()     // Catch:{ all -> 0x012e }
            r14 = r20
            r20 = r14
            r21 = r9
            java.nio.charset.Charset r22 = net.zhuoweizhang.boardwalk.downloader.DownloadUtils.utf8     // Catch:{ all -> 0x012e }
            byte[] r21 = r21.getBytes(r22)     // Catch:{ all -> 0x012e }
            r20.write(r21)     // Catch:{ all -> 0x012e }
            r20 = r14
            if (r20 == 0) goto L_0x00ac
            r20 = r14
            r20.close()     // Catch:{ all -> 0x013d }
        L_0x00ac:
            r20 = r13
            int r20 = r20.getResponseCode()     // Catch:{ all -> 0x013d }
            r16 = r20
            r20 = 0
            r6 = r20
            r20 = r16
            r21 = 200(0xc8, float:2.8E-43)
            r0 = r20
            r1 = r21
            if (r0 == r1) goto L_0x014c
            r20 = r13
            java.io.InputStream r20 = r20.getErrorStream()     // Catch:{ all -> 0x013d }
            r6 = r20
        L_0x00ca:
            r20 = r6
            r21 = r8
            r22 = r7
            net.zhuoweizhang.boardwalk.util.IoUtil.pipe(r20, r21, r22)     // Catch:{ all -> 0x013d }
            r20 = r6
            if (r20 == 0) goto L_0x00dc
            r20 = r6
            r20.close()     // Catch:{ Exception -> 0x016d }
        L_0x00dc:
            java.lang.String r20 = new java.lang.String
            r24 = r20
            r20 = r24
            r21 = r24
            r22 = r8
            byte[] r22 = r22.toByteArray()
            java.nio.charset.Charset r23 = net.zhuoweizhang.boardwalk.downloader.DownloadUtils.utf8
            r21.<init>(r22, r23)
            r17 = r20
            r20 = r16
            r21 = 200(0xc8, float:2.8E-43)
            r0 = r20
            r1 = r21
            if (r0 == r1) goto L_0x015a
            java.lang.RuntimeException r20 = new java.lang.RuntimeException
            r24 = r20
            r20 = r24
            r21 = r24
            java.lang.StringBuilder r22 = new java.lang.StringBuilder
            r24 = r22
            r22 = r24
            r23 = r24
            r23.<init>()
            java.lang.String r23 = "Status: "
            java.lang.StringBuilder r22 = r22.append(r23)
            r23 = r16
            java.lang.StringBuilder r22 = r22.append(r23)
            java.lang.String r23 = ":"
            java.lang.StringBuilder r22 = r22.append(r23)
            r23 = r17
            java.lang.StringBuilder r22 = r22.append(r23)
            java.lang.String r22 = r22.toString()
            r21.<init>(r22)
            throw r20
        L_0x012e:
            r20 = move-exception
            r15 = r20
            r20 = r14
            if (r20 == 0) goto L_0x013a
            r20 = r14
            r20.close()     // Catch:{ all -> 0x013d }
        L_0x013a:
            r20 = r15
            throw r20     // Catch:{ all -> 0x013d }
        L_0x013d:
            r20 = move-exception
            r11 = r20
        L_0x0140:
            r20 = r6
            if (r20 == 0) goto L_0x0149
            r20 = r6
            r20.close()     // Catch:{ Exception -> 0x0172 }
        L_0x0149:
            r20 = r11
            throw r20
        L_0x014c:
            r20 = r13
            java.io.InputStream r20 = r20.getInputStream()     // Catch:{ all -> 0x013d }
            r19 = r20
            r20 = r19
            r6 = r20
            goto L_0x00ca
        L_0x015a:
            r20 = r2
            r0 = r20
            com.google.gson.Gson r0 = r0.gson
            r20 = r0
            r21 = r17
            r22 = r5
            java.lang.Object r20 = r20.fromJson(r21, r22)
            r2 = r20
            return r2
        L_0x016d:
            r20 = move-exception
            r18 = r20
            goto L_0x00dc
        L_0x0172:
            r20 = move-exception
            r12 = r20
            goto L_0x0149
        L_0x0176:
            r20 = move-exception
            r11 = r20
            r20 = 0
            r6 = r20
            goto L_0x0140
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.yggdrasil.YggdrasilAuthenticator.makeRequest(java.lang.String, java.lang.Object, java.lang.Class):java.lang.Object");
    }

    public AuthenticateResponse authenticate(String str, String str2, UUID uuid) throws IOException {
        AuthenticateRequest authenticateRequest;
        AuthenticateRequest authenticateRequest2 = authenticateRequest;
        AuthenticateRequest authenticateRequest3 = new AuthenticateRequest(str, str2, uuid, this.clientName, this.clientVersion);
        return (AuthenticateResponse) makeRequest("authenticate", authenticateRequest2, AuthenticateResponse.class);
    }

    public RefreshResponse refresh(String str, UUID uuid) throws IOException {
        RefreshRequest refreshRequest;
        RefreshRequest refreshRequest2 = refreshRequest;
        RefreshRequest refreshRequest3 = new RefreshRequest(str, uuid);
        return (RefreshResponse) makeRequest("refresh", refreshRequest2, RefreshResponse.class);
    }
}

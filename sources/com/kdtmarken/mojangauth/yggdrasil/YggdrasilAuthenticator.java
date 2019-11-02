package com.kdtmarken.mojangauth.yggdrasil;

import android.util.Log;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.UUID;

public class YggdrasilAuthenticator {
    private static final String API_URL = "https://authserver.mojang.com/";
    private String clientName = "Minecraft";
    private int clientVersion = 1;
    private Gson gson;

    private <T> T makeRequest(String str, Object obj, Class<T> cls) throws IOException, Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        URL url;
        StringBuffer stringBuffer;
        RuntimeException runtimeException;
        String str2;
        RuntimeException runtimeException2;
        String str3 = str;
        Object obj2 = obj;
        Class<T> cls2 = cls;
        InputStream inputStream = null;
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        String json = this.gson.toJson(obj2);
        try {
            URL url2 = url;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            URL url3 = new URL(stringBuffer2.append(API_URL).append(str3).toString());
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
                httpURLConnection.setRequestProperty("User-Agent", "Minecraft");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.connect();
                OutputStream outputStream = null;
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                outputStream2.write(json.getBytes(Charset.forName("UTF-8")));
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    inputStream = httpURLConnection.getErrorStream();
                } else {
                    inputStream = httpURLConnection.getInputStream();
                }
                pipe(inputStream, byteArrayOutputStream4, bArr);
                if (inputStream != null) {
                    inputStream.close();
                }
                String str4 = str2;
                String str5 = new String(byteArrayOutputStream4.toByteArray(), Charset.forName("UTF-8"));
                String str6 = str4;
                if (responseCode == 200) {
                    int i = Log.i("Result", "Login successful");
                    return this.gson.fromJson(str6, cls2);
                }
                RuntimeException runtimeException3 = runtimeException2;
                RuntimeException runtimeException4 = new RuntimeException("Invalid username or password");
                throw runtimeException3;
            } catch (Exception e) {
                throw e;
            } catch (UnknownHostException e2) {
                UnknownHostException unknownHostException = e2;
                RuntimeException runtimeException5 = runtimeException;
                RuntimeException runtimeException6 = new RuntimeException("Can't connect to the server");
                throw runtimeException5;
            } catch (Throwable th) {
                Throwable th2 = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th2;
            }
        } catch (Exception e3) {
            throw e3;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th4;
        }
    }

    public AuthenticateResponse authenticate(String str, String str2, UUID uuid) throws IOException, Throwable {
        AuthenticateRequest authenticateRequest;
        NoClassDefFoundError noClassDefFoundError;
        String str3 = "authenticate";
        AuthenticateRequest authenticateRequest2 = authenticateRequest;
        AuthenticateRequest authenticateRequest3 = new AuthenticateRequest(str, str2, uuid, this.clientName, this.clientVersion);
        try {
            return (AuthenticateResponse) makeRequest(str3, authenticateRequest2, Class.forName("com.kdtmarken.mojangauth.yggdrasil.AuthenticateResponse"));
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    public RefreshResponse refresh(String str, UUID uuid) throws IOException, Throwable {
        RefreshRequest refreshRequest;
        NoClassDefFoundError noClassDefFoundError;
        String str2 = "refresh";
        RefreshRequest refreshRequest2 = refreshRequest;
        RefreshRequest refreshRequest3 = new RefreshRequest(str, uuid);
        try {
            return (RefreshResponse) makeRequest(str2, refreshRequest2, Class.forName("com.kdtmarken.mojangauth.yggdrasil.RefreshResponse"));
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError(classNotFoundException.getMessage());
            throw noClassDefFoundError2;
        }
    }

    private void pipe(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        byte[] bArr2 = bArr;
        while (true) {
            int read = inputStream2.read(bArr2);
            if (read >= 0) {
                outputStream2.write(bArr2, 0, read);
            } else {
                return;
            }
        }
    }

    public YggdrasilAuthenticator() {
        Gson gson2;
        Gson gson3 = gson2;
        Gson gson4 = new Gson();
        this.gson = gson3;
    }
}

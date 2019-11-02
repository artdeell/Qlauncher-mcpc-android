package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class zzna {
    public static long zza(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return zza(inputStream, outputStream, z, 1024);
    }

    /* JADX INFO: finally extract failed */
    public static long zza(InputStream inputStream, OutputStream outputStream, boolean z, int i) throws IOException {
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        boolean z2 = z;
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream2.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream2.write(bArr, 0, read);
            } catch (Throwable th) {
                Throwable th2 = th;
                if (z2) {
                    zzb(inputStream2);
                    zzb(outputStream2);
                }
                throw th2;
            }
        }
        if (z2) {
            zzb(inputStream2);
            zzb(outputStream2);
        }
        return j;
    }

    public static void zza(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        if (parcelFileDescriptor2 != null) {
            try {
                parcelFileDescriptor2.close();
            } catch (IOException e) {
                IOException iOException = e;
            }
        }
    }

    public static byte[] zza(InputStream inputStream, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2 = inputStream;
        boolean z2 = z;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        long zza = zza(inputStream2, byteArrayOutputStream4, z2);
        return byteArrayOutputStream4.toByteArray();
    }

    public static void zzb(Closeable closeable) {
        Closeable closeable2 = closeable;
        if (closeable2 != null) {
            try {
                closeable2.close();
            } catch (IOException e) {
                IOException iOException = e;
            }
        }
    }

    public static byte[] zzk(InputStream inputStream) throws IOException {
        return zza(inputStream, true);
    }
}

package com.tonicsystems.jarjar.util;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public class ClassHeaderReader {
    private static final int CHUNK = 2048;
    private int access;

    /* renamed from: b */
    private byte[] f20b = new byte[8192];
    private MyByteArrayInputStream bin;
    private int bsize = 0;
    private DataInputStream data;

    /* renamed from: in */
    private InputStream f21in;
    private String[] interfaces;
    private int[] items = new int[1000];
    private String superClass;
    private String thisClass;

    private static class MyByteArrayInputStream extends ByteArrayInputStream {
        public MyByteArrayInputStream() {
            super(new byte[0]);
        }

        public void readFrom(byte[] bArr, int i) {
            byte[] bArr2 = bArr;
            int i2 = i;
            this.buf = bArr2;
            this.pos = i2;
            this.count = bArr2.length;
        }
    }

    public ClassHeaderReader() {
        MyByteArrayInputStream myByteArrayInputStream;
        DataInputStream dataInputStream;
        MyByteArrayInputStream myByteArrayInputStream2 = myByteArrayInputStream;
        MyByteArrayInputStream myByteArrayInputStream3 = new MyByteArrayInputStream();
        this.bin = myByteArrayInputStream2;
        DataInputStream dataInputStream2 = dataInputStream;
        DataInputStream dataInputStream3 = new DataInputStream(this.bin);
        this.data = dataInputStream2;
    }

    private void buffer(int i) throws IOException {
        EOFException eOFException;
        int i2 = i;
        if (i2 > this.f20b.length) {
            this.f20b = (byte[]) resizeArray(this.f20b, 2 * this.f20b.length);
        }
        if (i2 > this.bsize) {
            this.bsize = this.bsize + read(this.f21in, this.f20b, this.bsize, ((int) (2048.0d * Math.ceil((double) (((float) i2) / 2048.0f)))) - this.bsize);
            if (i2 > this.bsize) {
                EOFException eOFException2 = eOFException;
                EOFException eOFException3 = new EOFException();
                throw eOFException2;
            }
        }
    }

    private static int read(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        InputStream inputStream2 = inputStream;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = 0;
        while (true) {
            i3 = i6;
            if (i3 >= i5) {
                break;
            }
            int read = inputStream2.read(bArr2, i4 + i3, i5 - i3);
            if (read == -1) {
                break;
            }
            i6 = i3 + read;
        }
        return i3;
    }

    private String readClass(int i) throws IOException {
        int readUnsignedShort = readUnsignedShort(i);
        if (readUnsignedShort == 0) {
            return null;
        }
        this.bin.readFrom(this.f20b, this.items[readUnsignedShort(this.items[readUnsignedShort])]);
        return this.data.readUTF();
    }

    private int readUnsignedShort(int i) {
        int i2 = i;
        byte[] bArr = this.f20b;
        return ((255 & bArr[i2]) << 8) | (255 & bArr[i2 + 1]);
    }

    private static Object resizeArray(Object obj, int i) {
        Object obj2 = obj;
        int i2 = i;
        if (Array.getLength(obj2) >= i2) {
            return obj2;
        }
        Object newInstance = Array.newInstance(obj2.getClass().getComponentType(), i2);
        System.arraycopy(obj2, 0, newInstance, 0, Array.getLength(obj2));
        return newInstance;
    }

    public int getAccess() {
        return this.access;
    }

    public String getClassName() {
        return this.thisClass;
    }

    public String[] getInterfaces() {
        return this.interfaces;
    }

    public String getSuperName() {
        return this.superClass;
    }

    public void read(InputStream inputStream) throws IOException {
        ClassFormatError classFormatError;
        IllegalStateException illegalStateException;
        StringBuilder sb;
        int i;
        InputStream inputStream2 = inputStream;
        try {
            this.f21in = inputStream2;
            this.bsize = 0;
            this.access = 0;
            this.superClass = null;
            this.thisClass = null;
            this.interfaces = null;
            try {
                buffer(4);
            } catch (IOException e) {
                IOException iOException = e;
            }
            if (this.f20b[0] == -54 && this.f20b[1] == -2 && this.f20b[2] == -70 && this.f20b[3] == -66) {
                buffer(6);
                int readUnsignedShort = readUnsignedShort(4);
                int readUnsignedShort2 = readUnsignedShort(6);
                int readUnsignedShort3 = readUnsignedShort(8);
                this.items = (int[]) resizeArray(this.items, readUnsignedShort3);
                int i2 = 10;
                int i3 = 1;
                while (i3 < readUnsignedShort3) {
                    buffer(i2 + 3);
                    byte b = this.f20b[i2];
                    this.items[i3] = i2 + 1;
                    switch (b) {
                        case 1:
                            i = 2 + readUnsignedShort(i2 + 1);
                            break;
                        case 3:
                        case 4:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            i = 4;
                            break;
                        case 5:
                        case 6:
                            i = 8;
                            i3++;
                            break;
                        case 7:
                        case 8:
                            i = 2;
                            break;
                        default:
                            IllegalStateException illegalStateException2 = illegalStateException;
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            IllegalStateException illegalStateException3 = new IllegalStateException(sb2.append("Unknown constant pool tag ").append(b).toString());
                            throw illegalStateException2;
                    }
                    i2 += i + 1;
                    i3++;
                }
                buffer(i2 + 8);
                this.access = readUnsignedShort(i2);
                this.thisClass = readClass(i2 + 2);
                this.superClass = readClass(i2 + 4);
                int readUnsignedShort4 = readUnsignedShort(i2 + 6);
                int i4 = i2 + 8;
                buffer(i4 + (readUnsignedShort4 * 2));
                this.interfaces = new String[readUnsignedShort4];
                for (int i5 = 0; i5 < readUnsignedShort4; i5++) {
                    this.interfaces[i5] = readClass(i4);
                    i4 += 2;
                }
                inputStream2.close();
                return;
            }
            ClassFormatError classFormatError2 = classFormatError;
            ClassFormatError classFormatError3 = new ClassFormatError("Bad magic number");
            throw classFormatError2;
        } catch (Throwable th) {
            Throwable th2 = th;
            inputStream2.close();
            throw th2;
        }
    }
}

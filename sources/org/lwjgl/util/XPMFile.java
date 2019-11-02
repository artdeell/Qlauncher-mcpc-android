package org.lwjgl.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class XPMFile {
    private static final int CHARACTERS_PER_PIXEL = 3;
    private static final int HEIGHT = 1;
    private static final int NUMBER_OF_COLORS = 2;
    private static final int WIDTH = 0;
    private static int[] format = new int[4];
    private byte[] bytes;

    private XPMFile() {
    }

    public static XPMFile load(InputStream inputStream) {
        XPMFile xPMFile;
        InputStream inputStream2 = inputStream;
        XPMFile xPMFile2 = xPMFile;
        XPMFile xPMFile3 = new XPMFile();
        XPMFile xPMFile4 = xPMFile2;
        xPMFile4.readImage(inputStream2);
        return xPMFile4;
    }

    public static XPMFile load(String str) throws IOException {
        FileInputStream fileInputStream;
        File file;
        FileInputStream fileInputStream2 = fileInputStream;
        File file2 = file;
        File file3 = new File(str);
        FileInputStream fileInputStream3 = new FileInputStream(file2);
        return load((InputStream) fileInputStream2);
    }

    public static void main(String[] strArr) {
        StringBuilder sb;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        File file;
        String[] strArr2 = strArr;
        if (strArr2.length != 1) {
            System.out.println("usage:\nXPMFile <file>");
        }
        try {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            String sb4 = sb2.append(strArr2[0].substring(0, strArr2[0].indexOf("."))).append(".raw").toString();
            XPMFile load = load(strArr2[0]);
            BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
            FileOutputStream fileOutputStream2 = fileOutputStream;
            File file2 = file;
            File file3 = new File(sb4);
            FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
            BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(fileOutputStream2);
            BufferedOutputStream bufferedOutputStream4 = bufferedOutputStream2;
            bufferedOutputStream4.write(load.getBytes());
            bufferedOutputStream4.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String nextLineOfInterest(LineNumberReader lineNumberReader) throws IOException {
        String readLine;
        LineNumberReader lineNumberReader2 = lineNumberReader;
        do {
            readLine = lineNumberReader2.readLine();
        } while (!readLine.startsWith("\""));
        return readLine.substring(1, readLine.lastIndexOf(34));
    }

    private static Object[] parseColor(String str) {
        String str2 = str;
        return new Object[]{str2.substring(0, format[3]), Integer.valueOf(Integer.parseInt(str2.substring(4 + format[3]), 16))};
    }

    private static int[] parseFormat(String str) {
        StringTokenizer stringTokenizer;
        StringTokenizer stringTokenizer2 = stringTokenizer;
        StringTokenizer stringTokenizer3 = new StringTokenizer(str);
        StringTokenizer stringTokenizer4 = stringTokenizer2;
        return new int[]{Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken()), Integer.parseInt(stringTokenizer4.nextToken())};
    }

    private void parseImageLine(String str, int[] iArr, HashMap<String, Integer> hashMap, int i) {
        String str2 = str;
        int[] iArr2 = iArr;
        HashMap<String, Integer> hashMap2 = hashMap;
        int i2 = i * 4 * iArr2[0];
        for (int i3 = 0; i3 < iArr2[0]; i3++) {
            int intValue = ((Integer) hashMap2.get(str2.substring(i3 * iArr2[3], (i3 * iArr2[3]) + iArr2[3]))).intValue();
            this.bytes[i2 + (i3 * 4)] = (byte) ((16711680 & intValue) >> 16);
            this.bytes[i2 + 1 + (i3 * 4)] = (byte) ((65280 & intValue) >> 8);
            this.bytes[i2 + 2 + (i3 * 4)] = (byte) ((intValue & 255) >> 0);
            this.bytes[i2 + 3 + (i3 * 4)] = -1;
        }
    }

    private void readImage(InputStream inputStream) {
        IllegalArgumentException illegalArgumentException;
        LineNumberReader lineNumberReader;
        InputStreamReader inputStreamReader;
        HashMap hashMap;
        try {
            LineNumberReader lineNumberReader2 = lineNumberReader;
            InputStreamReader inputStreamReader2 = inputStreamReader;
            InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream);
            LineNumberReader lineNumberReader3 = new LineNumberReader(inputStreamReader2);
            LineNumberReader lineNumberReader4 = lineNumberReader2;
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = hashMap2;
            format = parseFormat(nextLineOfInterest(lineNumberReader4));
            for (int i = 0; i < format[2]; i++) {
                Object[] parseColor = parseColor(nextLineOfInterest(lineNumberReader4));
                Object put = hashMap4.put((String) parseColor[0], (Integer) parseColor[1]);
            }
            this.bytes = new byte[(4 * format[0] * format[1])];
            for (int i2 = 0; i2 < format[1]; i2++) {
                parseImageLine(nextLineOfInterest(lineNumberReader4), format, hashMap4, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Unable to parse XPM File");
            throw illegalArgumentException2;
        }
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public int getHeight() {
        return format[1];
    }

    public int getWidth() {
        return format[0];
    }
}

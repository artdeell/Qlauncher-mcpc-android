package com.tonicsystems.jarjar;

import com.tonicsystems.jarjar.util.RuntimeIOException;
import com.tonicsystems.jarjar.util.StandaloneJarProcessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

public class Main {
    private static final String HELP;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private int level = 0;
    private List patterns;
    private boolean verbose;

    static {
        RuntimeIOException runtimeIOException;
        try {
            HELP = readIntoString(Main.class.getResourceAsStream("help.txt"));
        } catch (IOException e) {
            IOException iOException = e;
            RuntimeIOException runtimeIOException2 = runtimeIOException;
            RuntimeIOException runtimeIOException3 = new RuntimeIOException(iOException);
            throw runtimeIOException2;
        }
    }

    public Main() {
    }

    public static void main(String[] strArr) throws Exception {
        Main main;
        String[] strArr2 = strArr;
        Main main2 = main;
        Main main3 = new Main();
        MainUtil.runMain(main2, strArr2, "help");
    }

    private static String readIntoString(InputStream inputStream) throws IOException {
        StringBuilder sb;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        InputStream inputStream2 = inputStream;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        BufferedReader bufferedReader2 = bufferedReader;
        InputStreamReader inputStreamReader2 = inputStreamReader;
        InputStreamReader inputStreamReader3 = new InputStreamReader(inputStream2, "UTF-8");
        BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
        BufferedReader bufferedReader4 = bufferedReader2;
        while (true) {
            String readLine = bufferedReader4.readLine();
            if (readLine == null) {
                return sb4.toString();
            }
            StringBuilder append = sb4.append(readLine).append(LINE_SEPARATOR);
        }
    }

    public void find(String str, String str2, String str3) throws IOException {
        IllegalArgumentException illegalArgumentException;
        IllegalArgumentException illegalArgumentException2;
        StringBuilder sb;
        int i;
        PrintWriter printWriter;
        TextDepHandler textDepHandler;
        DepFind depFind;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (str4 == null || str5 == null) {
            IllegalArgumentException illegalArgumentException3 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("level and cp1 are required");
            throw illegalArgumentException3;
        }
        if (str6 == null) {
            str6 = str5;
        }
        if ("class".equals(str4)) {
            i = 0;
        } else if ("jar".equals(str4)) {
            i = 1;
        } else {
            IllegalArgumentException illegalArgumentException5 = illegalArgumentException2;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(sb2.append("unknown level ").append(str4).toString());
            throw illegalArgumentException5;
        }
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(System.out);
        PrintWriter printWriter4 = printWriter2;
        TextDepHandler textDepHandler2 = textDepHandler;
        TextDepHandler textDepHandler3 = new TextDepHandler(printWriter4, i);
        TextDepHandler textDepHandler4 = textDepHandler2;
        DepFind depFind2 = depFind;
        DepFind depFind3 = new DepFind();
        depFind2.run(str5, str6, textDepHandler4);
        printWriter4.flush();
    }

    public void help() {
        System.err.print(HELP);
    }

    public void process(File file, File file2, File file3) throws IOException {
        IllegalArgumentException illegalArgumentException;
        MainProcessor mainProcessor;
        StringBuilder sb;
        StringBuilder sb2;
        File file4 = file;
        File file5 = file2;
        File file6 = file3;
        if (file4 == null || file5 == null || file6 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("rulesFile, inJar, and outJar are required");
            throw illegalArgumentException2;
        }
        MainProcessor mainProcessor2 = mainProcessor;
        MainProcessor mainProcessor3 = new MainProcessor(RulesFileParser.parse(file4), Boolean.getBoolean("verbose"), Boolean.getBoolean("skipManifest"));
        MainProcessor mainProcessor4 = mainProcessor2;
        long currentTimeMillis = System.currentTimeMillis();
        StandaloneJarProcessor.run(file5, file6, mainProcessor4);
        PrintStream printStream = System.out;
        StringBuilder sb3 = sb;
        StringBuilder sb4 = new StringBuilder();
        printStream.println(sb3.append("Standalong jar processor: ").append(System.currentTimeMillis() - currentTimeMillis).toString());
        mainProcessor4.strip(file6);
        PrintStream printStream2 = System.out;
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = new StringBuilder();
        printStream2.println(sb5.append("Proc strip: ").append(System.currentTimeMillis() - currentTimeMillis).toString());
    }

    public void strings(String str) throws IOException {
        StringDumper stringDumper;
        PrintWriter printWriter;
        IllegalArgumentException illegalArgumentException;
        String str2 = str;
        if (str2 == null) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("cp is required");
            throw illegalArgumentException2;
        }
        StringDumper stringDumper2 = stringDumper;
        StringDumper stringDumper3 = new StringDumper();
        String str3 = str2;
        PrintWriter printWriter2 = printWriter;
        PrintWriter printWriter3 = new PrintWriter(System.out);
        stringDumper2.run(str3, printWriter2);
    }
}

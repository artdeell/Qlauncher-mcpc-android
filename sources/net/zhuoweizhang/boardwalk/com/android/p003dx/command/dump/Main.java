package net.zhuoweizhang.boardwalk.com.android.p003dx.command.dump;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import net.zhuoweizhang.boardwalk.com.android.dex.util.FileUtils;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.HexParser;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.command.dump.Main */
public class Main {
    static Args parsedArgs;

    static {
        Args args;
        Args args2 = args;
        Args args3 = new Args();
        parsedArgs = args2;
    }

    private Main() {
    }

    public static void main(String[] strArr) {
        StringBuilder sb;
        RuntimeException runtimeException;
        String str;
        RuntimeException runtimeException2;
        StringBuilder sb2;
        RuntimeException runtimeException3;
        String[] strArr2 = strArr;
        int i = 0;
        while (i < strArr2.length) {
            String str2 = strArr2[i];
            if (str2.equals("--") || !str2.startsWith("--")) {
                break;
            }
            if (str2.equals("--bytes")) {
                parsedArgs.rawBytes = true;
            } else if (str2.equals("--basic-blocks")) {
                parsedArgs.basicBlocks = true;
            } else if (str2.equals("--rop-blocks")) {
                parsedArgs.ropBlocks = true;
            } else if (str2.equals("--optimize")) {
                parsedArgs.optimize = true;
            } else if (str2.equals("--ssa-blocks")) {
                parsedArgs.ssaBlocks = true;
            } else if (str2.startsWith("--ssa-step=")) {
                parsedArgs.ssaStep = str2.substring(1 + str2.indexOf(61));
            } else if (str2.equals("--debug")) {
                parsedArgs.debug = true;
            } else if (str2.equals("--dot")) {
                parsedArgs.dotDump = true;
            } else if (str2.equals("--strict")) {
                parsedArgs.strictParse = true;
            } else if (str2.startsWith("--width=")) {
                String substring = str2.substring(1 + str2.indexOf(61));
                parsedArgs.width = Integer.parseInt(substring);
            } else if (str2.startsWith("--method=")) {
                parsedArgs.method = str2.substring(1 + str2.indexOf(61));
            } else {
                PrintStream printStream = System.err;
                StringBuilder sb3 = sb2;
                StringBuilder sb4 = new StringBuilder();
                printStream.println(sb3.append("unknown option: ").append(str2).toString());
                RuntimeException runtimeException4 = runtimeException3;
                RuntimeException runtimeException5 = new RuntimeException("usage");
                throw runtimeException4;
            }
            i++;
        }
        if (i == strArr2.length) {
            System.err.println("no input files specified");
            RuntimeException runtimeException6 = runtimeException2;
            RuntimeException runtimeException7 = new RuntimeException("usage");
            throw runtimeException6;
        }
        while (i < strArr2.length) {
            try {
                String str3 = strArr2[i];
                PrintStream printStream2 = System.out;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                printStream2.println(sb5.append("reading ").append(str3).append("...").toString());
                byte[] readFile = FileUtils.readFile(str3);
                if (!str3.endsWith(".class")) {
                    String str4 = str;
                    String str5 = new String(readFile, "utf-8");
                    readFile = HexParser.parse(str4);
                }
                processOne(str3, readFile);
            } catch (UnsupportedEncodingException e) {
                UnsupportedEncodingException unsupportedEncodingException = e;
                RuntimeException runtimeException8 = runtimeException;
                RuntimeException runtimeException9 = new RuntimeException("shouldn't happen", unsupportedEncodingException);
                throw runtimeException8;
            } catch (ParseException e2) {
                ParseException parseException = e2;
                System.err.println("\ntrouble parsing:");
                if (parsedArgs.debug) {
                    parseException.printStackTrace();
                } else {
                    parseException.printContext(System.err);
                }
            }
            i++;
        }
    }

    private static void processOne(String str, byte[] bArr) {
        String str2 = str;
        byte[] bArr2 = bArr;
        if (parsedArgs.dotDump) {
            DotDumper.dump(bArr2, str2, parsedArgs);
        } else if (parsedArgs.basicBlocks) {
            BlockDumper.dump(bArr2, System.out, str2, false, parsedArgs);
        } else if (parsedArgs.ropBlocks) {
            BlockDumper.dump(bArr2, System.out, str2, true, parsedArgs);
        } else if (parsedArgs.ssaBlocks) {
            parsedArgs.optimize = false;
            SsaDumper.dump(bArr2, System.out, str2, parsedArgs);
        } else {
            ClassDumper.dump(bArr2, System.out, str2, parsedArgs);
        }
    }
}

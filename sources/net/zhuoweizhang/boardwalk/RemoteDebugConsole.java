package net.zhuoweizhang.boardwalk;

import dalvik.system.VMRuntime;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RemoteDebugConsole implements Runnable {
    public ServerSocket serverSock;

    public RemoteDebugConsole() {
    }

    public static long parseM(String str) {
        int i;
        String str2 = str;
        int length = -1 + str2.length();
        switch (str2.charAt(length)) {
            case 'K':
            case 'k':
                i = 1024;
                break;
            case 'M':
            case 'm':
                i = 1048576;
                break;
            default:
                i = 1;
                length++;
                break;
        }
        return Long.parseLong(str2.substring(0, length)) * ((long) i);
    }

    public static void start() {
        Thread thread;
        RemoteDebugConsole remoteDebugConsole;
        Thread thread2 = thread;
        RemoteDebugConsole remoteDebugConsole2 = remoteDebugConsole;
        RemoteDebugConsole remoteDebugConsole3 = new RemoteDebugConsole();
        Thread thread3 = new Thread(remoteDebugConsole2);
        thread2.start();
    }

    public void run() {
        while (true) {
            try {
                runOnce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void runOnce() throws Exception {
        ServerSocket serverSocket;
        Scanner scanner;
        PrintStream printStream;
        if (this.serverSock != null) {
            this.serverSock.close();
        }
        ServerSocket serverSocket2 = serverSocket;
        ServerSocket serverSocket3 = new ServerSocket(15554);
        this.serverSock = serverSocket2;
        while (true) {
            Socket accept = this.serverSock.accept();
            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            Scanner scanner2 = scanner;
            Scanner scanner3 = new Scanner(inputStream);
            Scanner scanner4 = scanner2;
            PrintStream printStream2 = printStream;
            PrintStream printStream3 = new PrintStream(outputStream);
            PrintStream printStream4 = printStream2;
            while (true) {
                String nextLine = scanner4.nextLine();
                if (nextLine == null) {
                    break;
                }
                String[] split = nextLine.split(" ");
                if (split.length >= 1) {
                    String str = split[0];
                    if (str.equals("heapmaxfree")) {
                        DalvikTweaks.setHeapMaxFree(parseM(split[1]));
                    } else if (str.equals("heapminfree")) {
                        DalvikTweaks.setHeapMinFree(parseM(split[1]));
                    } else if (str.equals("utilset")) {
                        float targetHeapUtilization = VMRuntime.getRuntime().setTargetHeapUtilization(Float.parseFloat(split[1]));
                    } else if (str.equals("utilget")) {
                        printStream4.println(VMRuntime.getRuntime().getTargetHeapUtilization());
                    } else if (str.equals("gc")) {
                        System.gc();
                    } else if (str.equals("alloc")) {
                        byte[] bArr = new byte[((int) parseM(split[1]))];
                    } else {
                        printStream4.println("?");
                    }
                }
            }
            accept.close();
        }
    }
}

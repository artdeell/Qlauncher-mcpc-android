package adrt;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ADRTLogCatReader implements Runnable {
    private static Context context;

    public ADRTLogCatReader() {
    }

    public static void onContext(Context context2, String str) {
        ADRTLogCatReader aDRTLogCatReader;
        Thread thread;
        Context context3 = context2;
        String str2 = str;
        if (context == null) {
            context = context3.getApplicationContext();
            if ((2 & context3.getApplicationInfo().flags) != 0) {
                try {
                    PackageInfo packageInfo = context3.getPackageManager().getPackageInfo(str2, 128);
                    ADRTSender.onContext(context, str2);
                    ADRTLogCatReader aDRTLogCatReader2 = aDRTLogCatReader;
                    ADRTLogCatReader aDRTLogCatReader3 = new ADRTLogCatReader();
                    ADRTLogCatReader aDRTLogCatReader4 = aDRTLogCatReader2;
                    Thread thread2 = thread;
                    Thread thread3 = new Thread(aDRTLogCatReader4, "LogCat");
                    thread2.start();
                } catch (NameNotFoundException e) {
                    NameNotFoundException nameNotFoundException = e;
                }
            }
        }
    }

    public void run() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        try {
            InputStreamReader inputStreamReader2 = inputStreamReader;
            InputStreamReader inputStreamReader3 = new InputStreamReader(Runtime.getRuntime().exec("logcat -v threadtime").getInputStream());
            InputStreamReader inputStreamReader4 = inputStreamReader2;
            BufferedReader bufferedReader2 = bufferedReader;
            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader4, 20);
            BufferedReader bufferedReader4 = bufferedReader2;
            while (true) {
                String readLine = bufferedReader4.readLine();
                if (readLine != null) {
                    String[] strArr = new String[1];
                    String[] strArr2 = strArr;
                    strArr[0] = readLine;
                    ADRTSender.sendLogcatLines(strArr2);
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            IOException iOException = e;
        }
    }
}

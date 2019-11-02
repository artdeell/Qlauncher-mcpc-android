package adrt;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public class ADRTSender {
    private static Context context;
    private static String debuggerPackageName;

    public ADRTSender() {
    }

    public static void onContext(Context context2, String str) {
        String str2 = str;
        context = context2;
        debuggerPackageName = str2;
    }

    public static void sendBreakpointHit(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayList<String> arrayList5, ArrayList<String> arrayList6) {
        Intent intent;
        String str2 = str;
        ArrayList<String> arrayList7 = arrayList;
        ArrayList<String> arrayList8 = arrayList2;
        ArrayList<String> arrayList9 = arrayList3;
        ArrayList<String> arrayList10 = arrayList4;
        ArrayList<String> arrayList11 = arrayList5;
        ArrayList<String> arrayList12 = arrayList6;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage(debuggerPackageName);
        Intent action = intent4.setAction("com.adrt.BREAKPOINT_HIT");
        Intent putExtra = intent4.putExtra("package", str2);
        Intent putExtra2 = intent4.putExtra("variables", arrayList7);
        Intent putExtra3 = intent4.putExtra("variableValues", arrayList8);
        Intent putExtra4 = intent4.putExtra("variableKinds", arrayList9);
        Intent putExtra5 = intent4.putExtra("stackMethods", arrayList10);
        Intent putExtra6 = intent4.putExtra("stackLocations", arrayList11);
        Intent putExtra7 = intent4.putExtra("stackLocationKinds", arrayList12);
        context.sendBroadcast(intent4);
    }

    public static void sendConnect(String str) {
        Intent intent;
        String str2 = str;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage(debuggerPackageName);
        Intent action = intent4.setAction("com.adrt.CONNECT");
        Intent putExtra = intent4.putExtra("package", str2);
        context.sendBroadcast(intent4);
    }

    public static void sendFields(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        Intent intent;
        String str3 = str;
        String str4 = str2;
        ArrayList<String> arrayList4 = arrayList;
        ArrayList<String> arrayList5 = arrayList2;
        ArrayList<String> arrayList6 = arrayList3;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage(debuggerPackageName);
        Intent action = intent4.setAction("com.adrt.FIELDS");
        Intent putExtra = intent4.putExtra("package", str3);
        Intent putExtra2 = intent4.putExtra("path", str4);
        Intent putExtra3 = intent4.putExtra("fields", arrayList4);
        Intent putExtra4 = intent4.putExtra("fieldValues", arrayList5);
        Intent putExtra5 = intent4.putExtra("fieldKinds", arrayList6);
        context.sendBroadcast(intent4);
    }

    public static void sendLogcatLines(String[] strArr) {
        Intent intent;
        String[] strArr2 = strArr;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage(debuggerPackageName);
        Intent action = intent4.setAction("com.adrt.LOGCAT_ENTRIES");
        Intent putExtra = intent4.putExtra("lines", strArr2);
        context.sendBroadcast(intent4);
    }

    public static void sendStop(String str) {
        Intent intent;
        String str2 = str;
        Intent intent2 = intent;
        Intent intent3 = new Intent();
        Intent intent4 = intent2;
        Intent intent5 = intent4.setPackage(debuggerPackageName);
        Intent action = intent4.setAction("com.adrt.STOP");
        Intent putExtra = intent4.putExtra("package", str2);
        context.sendBroadcast(intent4);
    }
}

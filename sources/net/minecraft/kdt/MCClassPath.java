package net.minecraft.kdt;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.MainActivity;
import net.zhuoweizhang.boardwalk.com.android.p003dx.Version;

public class MCClassPath {
    private static String[] classes;
    public static String classpath;
    public static String mainpath = "/data/data/net.minecraft.kdt";
    public static String mpModAddNewMo;
    public static String mpModDisable;
    public static String mpModEnable;
    public static String mpProfiles;
    public static String[] versionList;

    static {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        StringBuffer stringBuffer6 = stringBuffer;
        StringBuffer stringBuffer7 = new StringBuffer();
        classpath = stringBuffer6.append(mainpath).append("/libAndMC/").toString();
        StringBuffer stringBuffer8 = stringBuffer2;
        StringBuffer stringBuffer9 = new StringBuffer();
        mpProfiles = stringBuffer8.append(mainpath).append("/Users").toString();
        StringBuffer stringBuffer10 = stringBuffer3;
        StringBuffer stringBuffer11 = new StringBuffer();
        mpModEnable = stringBuffer10.append(mainpath).append("/ModsManager/✅Enabled").toString();
        StringBuffer stringBuffer12 = stringBuffer4;
        StringBuffer stringBuffer13 = new StringBuffer();
        mpModDisable = stringBuffer12.append(mainpath).append("/ModsManager/❌Disabled").toString();
        StringBuffer stringBuffer14 = stringBuffer5;
        StringBuffer stringBuffer15 = new StringBuffer();
        mpModAddNewMo = stringBuffer14.append(mainpath).append("/ModsManager/➕Add mod").toString();
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "net.minecraft.client.main.Main";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "net.minecraft.client.Minecraft";
        classes = strArr4;
        String[] strArr5 = new String[5];
        String[] strArr6 = strArr5;
        strArr5[0] = "1.1";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[1] = "1.7.2";
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[2] = "1.7.10";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[3] = Version.VERSION;
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[4] = MainActivity.VERSION_TO_LAUNCH;
        versionList = strArr14;
    }

    public static String generate(String str, int i) {
        StringBuilder sb;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        StringBuffer stringBuffer6;
        StringBuffer stringBuffer7;
        String str2 = str;
        int i2 = i;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder sb5 = sb4;
        StringBuffer stringBuffer8 = stringBuffer;
        StringBuffer stringBuffer9 = new StringBuffer();
        StringBuffer stringBuffer10 = stringBuffer2;
        StringBuffer stringBuffer11 = new StringBuffer();
        StringBuffer stringBuffer12 = stringBuffer3;
        StringBuffer stringBuffer13 = new StringBuffer();
        StringBuilder append = sb5.append(stringBuffer8.append(stringBuffer10.append(stringBuffer12.append(classpath).append("Minecraft-").toString()).append(str2).toString()).append(".jar:").toString());
        for (int i3 = 1; i3 < i2; i3++) {
            String str3 = ":";
            if (i3 == i2) {
                str3 = LibrariesRepository.MOJANG_MAVEN_REPO;
            }
            StringBuilder sb6 = sb4;
            StringBuffer stringBuffer14 = stringBuffer4;
            StringBuffer stringBuffer15 = new StringBuffer();
            StringBuffer stringBuffer16 = stringBuffer5;
            StringBuffer stringBuffer17 = new StringBuffer();
            StringBuffer stringBuffer18 = stringBuffer6;
            StringBuffer stringBuffer19 = new StringBuffer();
            StringBuffer stringBuffer20 = stringBuffer7;
            StringBuffer stringBuffer21 = new StringBuffer();
            StringBuilder append2 = sb6.append(stringBuffer14.append(stringBuffer16.append(stringBuffer18.append(stringBuffer20.append(classpath).append("lib").toString()).append(i3).toString()).append(".jar").toString()).append(str3).toString());
        }
        return sb4.toString();
    }

    public static String[] nonExist(int i) {
        ArrayList arrayList;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        File file;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        File file2;
        StringBuffer stringBuffer6;
        int i2 = i;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        for (int i3 = 1; i3 < i2; i3++) {
            StringBuffer stringBuffer7 = stringBuffer4;
            StringBuffer stringBuffer8 = new StringBuffer();
            StringBuffer stringBuffer9 = stringBuffer5;
            StringBuffer stringBuffer10 = new StringBuffer();
            String stringBuffer11 = stringBuffer7.append(stringBuffer9.append("lib").append(i3).toString()).append(".jar").toString();
            File file3 = file2;
            StringBuffer stringBuffer12 = stringBuffer6;
            StringBuffer stringBuffer13 = new StringBuffer();
            File file4 = new File(stringBuffer12.append(classpath).append(stringBuffer11).toString());
            if (!file3.exists()) {
                boolean add = arrayList4.add(stringBuffer11);
            }
        }
        String[] strArr = versionList;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str = strArr[i4];
            StringBuffer stringBuffer14 = stringBuffer;
            StringBuffer stringBuffer15 = new StringBuffer();
            StringBuffer stringBuffer16 = stringBuffer2;
            StringBuffer stringBuffer17 = new StringBuffer();
            String stringBuffer18 = stringBuffer14.append(stringBuffer16.append("Minecraft-").append(str).toString()).append(".jar").toString();
            StringBuffer stringBuffer19 = stringBuffer3;
            StringBuffer stringBuffer20 = new StringBuffer();
            String stringBuffer21 = stringBuffer19.append(classpath).append(stringBuffer18).toString();
            File file5 = file;
            File file6 = new File(stringBuffer21);
            if (!file5.exists()) {
                boolean add2 = arrayList4.add(stringBuffer18);
            }
        }
        return (String[]) arrayList4.toArray(new String[0]);
    }

    public static void extractList(Context context, String[] strArr) throws Exception {
        File file;
        StringBuffer stringBuffer;
        Context context2 = context;
        String[] strArr2 = strArr;
        File file2 = file;
        File file3 = new File(classpath);
        boolean mkdir = file2.mkdir();
        String[] strArr3 = strArr2;
        for (int i = 0; i < strArr3.length; i++) {
            String str = strArr3[i];
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            FileAccess.write(stringBuffer2.append(classpath).append(str).toString(), FileAccess.loadFromAssetToByte(context2, str));
        }
    }

    public static void throwError(Activity activity, Exception exc) {
        AnonymousClass100000000 r9;
        Activity activity2 = activity;
        Activity activity3 = activity2;
        AnonymousClass100000000 r5 = r9;
        AnonymousClass100000000 r6 = new Runnable(activity2, exc) {
            private final Activity val$ctx;
            private final Exception val$e;

            {
                Exception exc = r8;
                this.val$ctx = r7;
                this.val$e = exc;
            }

            @Override
            public void run() {
                Builder builder;
                Builder builder2 = builder;
                Builder builder3 = new Builder(this.val$ctx);
                AlertDialog show = builder2.setTitle("Error").setMessage(Log.getStackTraceString(this.val$e)).setPositiveButton("OK", null).show();
            }
        };
        activity3.runOnUiThread(r5);
    }

    public static void showOnUiThread(Activity activity, CharSequence charSequence, CharSequence charSequence2) {
        AnonymousClass100000001 r11;
        Activity activity2 = activity;
        Activity activity3 = activity2;
        AnonymousClass100000001 r6 = r11;
        AnonymousClass100000001 r7 = new Runnable(activity2, charSequence, charSequence2) {
            private final Activity val$ctx;
            private final CharSequence val$message;
            private final CharSequence val$title;

            {
                CharSequence charSequence = r9;
                CharSequence charSequence2 = r10;
                this.val$ctx = r8;
                this.val$title = charSequence;
                this.val$message = charSequence2;
            }

            @Override
            public void run() {
                Builder builder;
                Builder builder2 = builder;
                Builder builder3 = new Builder(this.val$ctx);
                AlertDialog show = builder2.setTitle(this.val$title).setMessage(this.val$message).setPositiveButton("OK", null).show();
            }
        };
        activity3.runOnUiThread(r6);
    }

    public static Class loadClassFromClassesList(DexClassLoader dexClassLoader) throws ClassesNotFoundException {
        ClassesNotFoundException classesNotFoundException;
        DexClassLoader dexClassLoader2 = dexClassLoader;
        Class cls = null;
        String[] strArr = classes;
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                break;
            }
            String str = strArr[i];
            try {
                cls = dexClassLoader2.loadClass(str);
                break;
            } catch (ClassNotFoundException e) {
                ClassNotFoundException classNotFoundException = e;
                if (str.equals(classes[classes.length - 1])) {
                    ClassesNotFoundException classesNotFoundException2 = classesNotFoundException;
                    ClassesNotFoundException classesNotFoundException3 = new ClassesNotFoundException();
                    throw classesNotFoundException2;
                }
                i++;
            }
        }
        return cls;
    }

    public MCClassPath() {
    }
}

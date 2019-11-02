package net.zhuoweizhang.boardwalk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.internal.view.SupportMenu;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import junit.framework.TestCase;
import junit.framework.TestResult;
import net.zhuoweizhang.boardwalk.downloader.MinecraftDownloader;
import net.zhuoweizhang.boardwalk.downloader.MinecraftLaunch;
import net.zhuoweizhang.boardwalk.model.MinecraftVersion;
import net.zhuoweizhang.boardwalk.util.DroidUtil;
import org.lwjgl.opengl.AndroidContextImplementation;
import org.lwjgl.opengl.AndroidDisplay;
import org.lwjgl.opengl.AndroidKeyCodes;

public class MainActivity extends Activity implements OnTouchListener {
    public static final int KEY_BACKSPACE = 14;
    private static final int MSG_LEFT_MOUSE_BUTTON_CHECK = 1028;
    public static final String VERSION_TO_LAUNCH = "1.9";
    private static int[] hotbarKeys = {2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static final String initText = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ";
    private static String[] libsToRename;
    private Button debugButton;
    private DisplayMetrics displayMetrics;
    private Button downButton;
    /* access modifiers changed from: private */
    public int fingerStillThreshold = 8;
    /* access modifiers changed from: private */
    public GLSurfaceView glSurfaceView;
    private int guiScale = 1;
    /* access modifiers changed from: private */
    public String hiddenTextContents = initText;
    /* access modifiers changed from: private */
    public boolean hiddenTextIgnoreUpdate = true;
    private TextView hiddenTextView;
    private PopupWindow hiddenTextWindow;
    /* access modifiers changed from: private */
    public int initialX;
    /* access modifiers changed from: private */
    public int initialY;
    private Button inventoryButton;
    private Button jumpButton;
    private Button keyboardButton;
    private Button leftButton;
    private ViewGroup overlayView;
    private Button primaryButton;
    private Button rightButton;
    /* access modifiers changed from: private */
    public boolean rightOverride = false;
    /* access modifiers changed from: private */
    public int scaleFactor = 1;
    private Button secondaryButton;
    private Drawable secondaryButtonColorBackground;
    private Drawable secondaryButtonDefaultBackground;
    private Button shiftButton;
    private Button talkButton;
    /* access modifiers changed from: private */
    public Handler theHandler;
    private Button thirdPersonButton;
    /* access modifiers changed from: private */
    public boolean triggeredLeftMouseButton = false;
    private Button upButton;

    private class PopupTextWatcher implements TextWatcher, OnEditorActionListener {
        final /* synthetic */ MainActivity this$0;

        private PopupTextWatcher(MainActivity mainActivity) {
            this.this$0 = mainActivity;
        }

        /* synthetic */ PopupTextWatcher(MainActivity mainActivity, C06401 r7) {
            C06401 r2 = r7;
            this(mainActivity);
        }

        public void afterTextChanged(Editable editable) {
            StringBuilder sb;
            Editable editable2 = editable;
            if (!this.this$0.hiddenTextIgnoreUpdate) {
                String obj = editable2.toString();
                String access$1100 = this.this$0.hiddenTextContents;
                PrintStream printStream = System.out;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                printStream.println(sb2.append("New: ").append(obj).append(" old: ").append(access$1100).toString());
                if (obj.length() < access$1100.length()) {
                    for (int i = 0; i < access$1100.length() - obj.length(); i++) {
                        this.this$0.sendKeyPress(14, true);
                        this.this$0.sendKeyPress(14, false);
                    }
                } else {
                    for (int i2 = 0; i2 < obj.length() - access$1100.length(); i2++) {
                        char charAt = obj.charAt(i2 + access$1100.length());
                        this.this$0.sendKeyPress(0, charAt, true);
                        this.this$0.sendKeyPress(0, charAt, false);
                    }
                }
                String access$1102 = MainActivity.access$1102(this.this$0, obj);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            TextView textView2 = textView;
            int i2 = i;
            KeyEvent keyEvent2 = keyEvent;
            this.this$0.sendKeyPress(28, 10, true);
            this.this$0.sendKeyPress(28, 0, false);
            return true;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    static {
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "vecmath";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "testcases";
        libsToRename = strArr4;
    }

    public MainActivity() {
        C06401 r5;
        C06401 r2 = r5;
        C06401 r3 = new Handler(this) {
            final /* synthetic */ MainActivity this$0;

            {
                this.this$0 = r5;
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1028:
                        int i = AndroidDisplay.mouseX;
                        int i2 = AndroidDisplay.mouseY;
                        if (AndroidDisplay.grab && Math.abs(this.this$0.initialX - i) < this.this$0.fingerStillThreshold && Math.abs(this.this$0.initialY - i2) < this.this$0.fingerStillThreshold) {
                            boolean access$302 = MainActivity.access$302(this.this$0, true);
                            this.this$0.sendMouseButton(0, true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.theHandler = r2;
    }

    static /* synthetic */ int access$002(MainActivity mainActivity, int i) {
        int i2 = i;
        mainActivity.initialX = i2;
        return i2;
    }

    static /* synthetic */ boolean access$1002(MainActivity mainActivity, boolean z) {
        boolean z2 = z;
        mainActivity.hiddenTextIgnoreUpdate = z2;
        return z2;
    }

    static /* synthetic */ String access$1102(MainActivity mainActivity, String str) {
        String str2 = str;
        mainActivity.hiddenTextContents = str2;
        return str2;
    }

    static /* synthetic */ int access$202(MainActivity mainActivity, int i) {
        int i2 = i;
        mainActivity.initialY = i2;
        return i2;
    }

    static /* synthetic */ boolean access$302(MainActivity mainActivity, boolean z) {
        boolean z2 = z;
        mainActivity.triggeredLeftMouseButton = z2;
        return z2;
    }

    private static String[] buildMCArgs(Context context, String str) {
        File file;
        File file2;
        ArrayList arrayList;
        Context context2 = context;
        String str2 = str;
        File file3 = file;
        File file4 = new File("/sdcard/boardwalk/gamedir");
        File file5 = file3;
        boolean mkdirs = file5.mkdirs();
        File file6 = file2;
        File file7 = new File(file5, "assets");
        File file8 = file6;
        boolean mkdirs2 = file8.mkdirs();
        SharedPreferences sharedPreferences = context2.getSharedPreferences("launcher_prefs", 0);
        String string = sharedPreferences.getString("auth_accessToken", "0");
        String string2 = sharedPreferences.getString("auth_profile_id", "00000000-0000-0000-0000-000000000000");
        boolean equals = string2.equals("00000000-0000-0000-0000-000000000000");
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(Arrays.asList(new String[]{"--username", sharedPreferences.getString("auth_profile_name", "Player"), "--version", str2, "--gameDir", file5.getAbsolutePath(), "--assetsDir", file8.getAbsolutePath(), "--assetIndex", str2, "--uuid", string2, "--accessToken", string, "--userProperties", "{}", "--userType", equals ? "legacy" : "mojang"}));
        ArrayList arrayList4 = arrayList2;
        if (equals) {
            boolean add = arrayList4.add("--demo");
        }
        return (String[]) arrayList4.toArray(new String[0]);
    }

    private Button findButton(int i) {
        Button button = (Button) findViewById(i);
        button.setOnTouchListener(this);
        return button;
    }

    public static void fixRSAPadding(File file, File file2) throws Exception {
        File file3 = file;
        File file4 = file2;
        System.out.println(Cipher.getInstance("RSA"));
        System.out.println(Cipher.getInstance("RSA/ECB/PKCS1Padding"));
        if (VERSION.SDK_INT < 23) {
            Class cls = Class.forName("org.apache.harmony.security.fortress.Services");
            Class cls2 = cls;
            String str = "getServices";
            try {
                Class[] clsArr = new Class[1];
                Class[] clsArr2 = clsArr;
                clsArr[0] = String.class;
                Method method = cls2.getMethod(str, clsArr2);
                Method method2 = method;
                Object[] objArr = new Object[1];
                Object[] objArr2 = objArr;
                objArr[0] = "Cipher.RSA";
                ArrayList arrayList = (ArrayList) method2.invoke(null, objArr2);
                Method method3 = method;
                Object[] objArr3 = new Object[1];
                Object[] objArr4 = objArr3;
                objArr3[0] = "Cipher.RSA/ECB/PKCS1PADDING";
                ArrayList arrayList2 = (ArrayList) method3.invoke(null, objArr4);
                arrayList.clear();
                boolean addAll = arrayList.addAll(arrayList2);
            } catch (NoSuchMethodException e) {
                NoSuchMethodException noSuchMethodException = e;
                Field declaredField = cls.getDeclaredField("services");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(null);
                Object put = map.put("Cipher.RSA", map.get("Cipher.RSA/ECB/PKCS1PADDING"));
            }
        }
    }

    public static void forceUserHome(String str) throws Exception {
        Field field;
        String str2 = str;
        Properties properties = System.getProperties();
        Class cls = properties.getClass();
        while (true) {
            Class cls2 = cls;
            field = null;
            if (cls2 == null) {
                break;
            }
            try {
                field = cls2.getDeclaredField("defaults");
                break;
            } catch (Exception e) {
                Exception exc = e;
                cls = cls2.getSuperclass();
            }
        }
        if (field != null) {
            field.setAccessible(true);
            Object put = ((Properties) field.get(properties)).put("user.home", str2);
        }
    }

    public static void initEnvs() {
        RuntimeException runtimeException;
        try {
            DalvikTweaks.setenv("LIBGL_MIPMAP", "3", true);
            String property = System.setProperty("user.home", "/sdcard/boardwalk");
            if (!System.getProperty("user.home", "/").equals("/sdcard/boardwalk")) {
                forceUserHome("/sdcard/boardwalk");
            }
            String property2 = System.setProperty("org.apache.logging.log4j.level", "INFO");
            String property3 = System.setProperty("org.apache.logging.log4j.simplelog.level", "INFO");
            String property4 = System.setProperty("net.zhuoweizhang.boardwalk.org.apache.logging.log4j.level", "INFO");
            String property5 = System.setProperty("net.zhuoweizhang.boardwalk.org.apache.logging.log4j.simplelog.level", "INFO");
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }

    private void registerShutdownHook() {
        Thread thread;
        C06445 r7;
        Thread thread2 = thread;
        C06445 r4 = r7;
        C06445 r5 = new Runnable(this) {
            final /* synthetic */ MainActivity this$0;

            {
                this.this$0 = r5;
            }

            public void run() {
                Intent intent;
                if (DroidUtil.isConnected(this.this$0)) {
                    MainActivity mainActivity = this.this$0;
                    Intent intent2 = intent;
                    Intent intent3 = new Intent(this.this$0, PostExitActivity.class);
                    mainActivity.startActivity(intent2);
                }
            }
        };
        Thread thread3 = new Thread(r4);
        Runtime.getRuntime().addShutdownHook(thread2);
    }

    public static void runCraft(File file) {
        RuntimeException runtimeException;
        File file2;
        DexClassLoader dexClassLoader;
        File file3;
        File file4;
        File file5 = file;
        try {
            File file6 = file2;
            File file7 = new File("/data/data/net.zhuoweizhang.boardwalk/files/dalvik-cache");
            File file8 = file6;
            boolean mkdirs = file8.mkdirs();
            DexClassLoader dexClassLoader2 = dexClassLoader;
            DexClassLoader dexClassLoader3 = new DexClassLoader(file5.getAbsolutePath(), file8.getAbsolutePath(), LibrariesRepository.MOJANG_MAVEN_REPO, MainActivity.class.getClassLoader());
            DexClassLoader dexClassLoader4 = dexClassLoader2;
            File file9 = file3;
            File file10 = new File("/sdcard/boardwalk/spongy.jar");
            fixRSAPadding(file9, file8);
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            clsArr[0] = String[].class;
            Method method = dexClassLoader4.loadClass("net.minecraft.client.main.Main").getMethod("main", clsArr2);
            File file11 = file4;
            File file12 = new File("/sdcard/boardwalk/gamedir");
            File file13 = file11;
            boolean mkdirs2 = file13.mkdirs();
            Method method2 = method;
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = new String[]{"--accessToken", "0", "--userProperties", "{}", "--version", "mcp", "--gameDir", file13.getAbsolutePath()};
            Object invoke = method2.invoke(null, objArr2);
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }

    public static void runCraft2(Context context, String str) {
        RuntimeException runtimeException;
        DexClassLoader dexClassLoader;
        Class loadClass;
        Context context2 = context;
        String str2 = str;
        try {
            MinecraftVersion versionInfo = MinecraftDownloader.getVersionInfo(str2);
            File dir = context2.getDir("dalvik-cache", 0);
            boolean mkdirs = dir.mkdirs();
            DexClassLoader dexClassLoader2 = dexClassLoader;
            DexClassLoader dexClassLoader3 = new DexClassLoader(MinecraftLaunch.getClassPath(versionInfo), dir.getAbsolutePath(), context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).applicationInfo.nativeLibraryDir, MainActivity.class.getClassLoader());
            DexClassLoader dexClassLoader4 = dexClassLoader2;
            fixRSAPadding(null, null);
            try {
                loadClass = dexClassLoader4.loadClass("net.minecraft.client.main.Main");
            } catch (ClassNotFoundException e) {
                ClassNotFoundException classNotFoundException = e;
                loadClass = dexClassLoader4.loadClass("net.minecraft.client.Minecraft");
            }
            Class cls = loadClass;
            String str3 = "main";
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            clsArr[0] = String[].class;
            Method method = cls.getMethod(str3, clsArr2);
            Object[] objArr = new Object[1];
            Object[] objArr2 = objArr;
            objArr[0] = buildMCArgs(context2, str2);
            Object invoke = method.invoke(null, objArr2);
        } catch (Exception e2) {
            Exception exc = e2;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }

    public static void runDex(Context context, List<File> list, File file) {
        StringBuilder sb;
        ArrayList arrayList;
        StringBuilder sb2;
        ArrayList arrayList2;
        RuntimeException runtimeException;
        StringBuilder sb3;
        File file2;
        StringBuilder sb4;
        RuntimeException runtimeException2;
        Context context2 = context;
        List<File> list2 = list;
        File file3 = file;
        PrintStream printStream = System.out;
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder();
        printStream.println(sb5.append("Dexing ").append(list2).toString());
        boolean delete = file3.delete();
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = arrayList3;
        for (File file4 : list2) {
            if (!file4.getName().endsWith("_dexed.jar")) {
                StringBuilder sb7 = sb3;
                StringBuilder sb8 = new StringBuilder();
                String sb9 = sb7.append(file4.getAbsolutePath()).append("_dexed.jar").toString();
                File file5 = file2;
                File file6 = new File(sb9);
                boolean delete2 = file5.delete();
                boolean add = arrayList5.add(sb9);
                String[] strArr = new String[5];
                strArr[0] = "--dex";
                strArr[1] = "--no-optimize";
                strArr[2] = "--num-threads=4";
                String[] strArr2 = strArr;
                StringBuilder sb10 = sb4;
                StringBuilder sb11 = new StringBuilder();
                strArr2[3] = sb10.append("--output=").append(sb9).toString();
                strArr[4] = file4.getAbsolutePath();
                try {
                    runExt(context2, "com.android.dx.command.Main", Arrays.asList(strArr));
                } catch (Exception e) {
                    Exception exc = e;
                    RuntimeException runtimeException3 = runtimeException2;
                    RuntimeException runtimeException4 = new RuntimeException(exc);
                    throw runtimeException3;
                }
            }
        }
        String[] strArr3 = new String[4];
        strArr3[0] = "--dex";
        strArr3[1] = "--no-optimize";
        strArr3[2] = "--num-threads=4";
        String[] strArr4 = strArr3;
        StringBuilder sb12 = sb2;
        StringBuilder sb13 = new StringBuilder();
        strArr4[3] = sb12.append("--output=").append(file3.getAbsolutePath()).toString();
        ArrayList arrayList6 = arrayList2;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = arrayList6;
        boolean addAll = arrayList8.addAll(Arrays.asList(strArr3));
        boolean addAll2 = arrayList8.addAll(arrayList5);
        try {
            runExt(context2, "com.android.dx.command.Main", arrayList8);
        } catch (Exception e2) {
            Exception exc2 = e2;
            RuntimeException runtimeException5 = runtimeException;
            RuntimeException runtimeException6 = new RuntimeException(exc2);
            throw runtimeException5;
        }
    }

    public static void runExt(Context context, String str, List<String> list) throws IOException, InterruptedException {
        ArrayList arrayList;
        StringBuilder sb;
        ProcessBuilder processBuilder;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        Context context2 = context;
        String str2 = str;
        List<String> list2 = list;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add("dalvikvm");
        ArrayList arrayList5 = arrayList4;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        boolean add2 = arrayList5.add(sb2.append("-Djava.library.path=").append(System.getProperty("java.library.path")).toString());
        boolean add3 = arrayList4.add("-classpath");
        boolean add4 = arrayList4.add(context2.getPackageCodePath());
        boolean add5 = arrayList4.add("-Xms384M");
        boolean add6 = arrayList4.add("-Xmx768M");
        boolean add7 = arrayList4.add(str2);
        boolean addAll = arrayList4.addAll(list2);
        ProcessBuilder processBuilder2 = processBuilder;
        ProcessBuilder processBuilder3 = new ProcessBuilder(arrayList4);
        Process start = processBuilder2.redirectErrorStream(true).start();
        BufferedReader bufferedReader2 = bufferedReader;
        InputStreamReader inputStreamReader2 = inputStreamReader;
        InputStreamReader inputStreamReader3 = new InputStreamReader(start.getInputStream());
        BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
        BufferedReader bufferedReader4 = bufferedReader2;
        while (true) {
            String readLine = bufferedReader4.readLine();
            if (readLine != null) {
                System.out.println(readLine);
            } else {
                int waitFor = start.waitFor();
                return;
            }
        }
    }

    public static List<File> runRenameLibs(File file, List<File> list) {
        StringBuilder sb;
        ArrayList arrayList;
        StringBuilder sb2;
        boolean z;
        File file2;
        StringBuilder sb3;
        File file3 = file;
        List<File> list2 = list;
        PrintStream printStream = System.out;
        StringBuilder sb4 = sb;
        StringBuilder sb5 = new StringBuilder();
        printStream.println(sb4.append("Before rename: ").append(list2).toString());
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(list2.size());
        ArrayList arrayList4 = arrayList2;
        for (File file4 : list2) {
            String name = file4.getName();
            if (name.endsWith("_renamed.jar") || name.endsWith("_dexed.jar")) {
                boolean delete = file4.delete();
            } else {
                String[] strArr = libsToRename;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    z = false;
                    if (i >= length) {
                        break;
                    } else if (name.contains(strArr[i])) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    File file5 = file2;
                    StringBuilder sb6 = sb3;
                    StringBuilder sb7 = new StringBuilder();
                    File file6 = new File(sb6.append(file4.getAbsolutePath()).append("_renamed.jar").toString());
                    File file7 = file5;
                    MinecraftLaunch.runRename(file3, file4, file7);
                    boolean add = arrayList4.add(file7);
                } else {
                    boolean add2 = arrayList4.add(file4);
                }
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder sb8 = sb2;
        StringBuilder sb9 = new StringBuilder();
        printStream2.println(sb8.append("After rename: ").append(arrayList4).toString());
        return arrayList4;
    }

    public static void runTest(File file, String str) {
        RuntimeException runtimeException;
        File file2;
        DexClassLoader dexClassLoader;
        StringBuilder sb;
        File file3 = file;
        String str2 = str;
        try {
            File file4 = file2;
            File file5 = new File("/data/data/net.zhuoweizhang.boardwalk/files/dalvik-cache");
            File file6 = file4;
            boolean mkdirs = file6.mkdirs();
            DexClassLoader dexClassLoader2 = dexClassLoader;
            DexClassLoader dexClassLoader3 = new DexClassLoader(file3.getAbsolutePath(), file6.getAbsolutePath(), LibrariesRepository.MOJANG_MAVEN_REPO, MainActivity.class.getClassLoader());
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            TestResult run = ((TestCase) dexClassLoader2.loadClass(sb2.append("net.zhuoweizhang.boardwalk.testcase.").append(str2).toString()).newInstance()).run();
        } catch (Exception e) {
            Exception exc = e;
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException(exc);
            throw runtimeException2;
        }
    }

    /* access modifiers changed from: private */
    public void sendKeyPress(int i, char c, boolean z) {
        AndroidDisplay.setKey(i, c, z);
    }

    /* access modifiers changed from: private */
    public void sendKeyPress(int i, boolean z) {
        sendKeyPress(i, 0, z);
    }

    /* access modifiers changed from: private */
    public void sendMouseButton(int i, boolean z) {
        AndroidDisplay.setMouseButtonInGrabMode((byte) i, z ? (byte) 1 : 0);
    }

    private void setRightOverride(boolean z) {
        this.rightOverride = z;
        this.secondaryButton.setBackgroundDrawable(this.rightOverride ? this.secondaryButtonColorBackground : this.secondaryButtonDefaultBackground);
    }

    public void calculateMcScale() {
        int i = 1;
        int i2 = AndroidDisplay.windowWidth;
        int i3 = AndroidDisplay.windowHeight;
        while (i2 / (i + 1) >= 320 && i3 / (i + 1) >= 240) {
            i++;
        }
        this.guiScale = i;
    }

    public boolean handleGuiBar(int i, int i2, MotionEvent motionEvent) {
        boolean z;
        int i3 = i;
        int i4 = i2;
        MotionEvent motionEvent2 = motionEvent;
        if (AndroidDisplay.grab) {
            switch (motionEvent2.getActionMasked()) {
                case 0:
                case 5:
                    z = true;
                    break;
                case 1:
                case 3:
                case 6:
                    z = false;
                    break;
                default:
                    return false;
            }
            int i5 = AndroidDisplay.windowWidth;
            int i6 = AndroidDisplay.windowHeight;
            int mcscale = mcscale(20);
            int mcscale2 = mcscale(180);
            int i7 = (i5 / 2) - (mcscale2 / 2);
            if (i3 >= i7 && i3 < i7 + mcscale2 && i4 >= 0 && i4 < 0 + mcscale) {
                sendKeyPress(hotbarKeys[((i3 - i7) / mcscale(20)) % 9], z);
                return true;
            }
        }
        return false;
    }

    public int mcscale(int i) {
        return i * this.guiScale;
    }

    public void onCreate(Bundle bundle) {
        DisplayMetrics displayMetrics2;
        ColorDrawable colorDrawable;
        C06412 r6;
        C06423 r62;
        super.onCreate(bundle);
        LaunchMinecraftTask.setupWorkingDir(this);
        initEnvs();
        if (DalvikTweaks.isDalvik()) {
            DalvikTweaks.setDefaultStackSize(524288);
        }
        System.loadLibrary("glshim");
        DisplayMetrics displayMetrics3 = displayMetrics2;
        DisplayMetrics displayMetrics4 = new DisplayMetrics();
        this.displayMetrics = displayMetrics3;
        getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
        setContentView(2130903044);
        this.upButton = findButton(C0646R.C0648id.control_up);
        this.downButton = findButton(C0646R.C0648id.control_down);
        this.leftButton = findButton(C0646R.C0648id.control_left);
        this.rightButton = findButton(C0646R.C0648id.control_right);
        this.jumpButton = findButton(C0646R.C0648id.control_jump);
        this.primaryButton = findButton(C0646R.C0648id.control_primary);
        this.secondaryButton = findButton(C0646R.C0648id.control_secondary);
        this.debugButton = findButton(C0646R.C0648id.control_debug);
        this.shiftButton = findButton(C0646R.C0648id.control_shift);
        this.keyboardButton = findButton(C0646R.C0648id.control_keyboard);
        this.inventoryButton = findButton(C0646R.C0648id.control_inventory);
        this.talkButton = findButton(C0646R.C0648id.control_talk);
        this.thirdPersonButton = findButton(C0646R.C0648id.control_thirdperson);
        this.overlayView = (ViewGroup) findViewById(C0646R.C0648id.main_control_overlay);
        this.secondaryButtonDefaultBackground = this.secondaryButton.getBackground();
        ColorDrawable colorDrawable2 = colorDrawable;
        ColorDrawable colorDrawable3 = new ColorDrawable(SupportMenu.CATEGORY_MASK);
        this.secondaryButtonColorBackground = colorDrawable2;
        registerShutdownHook();
        this.fingerStillThreshold = getResources().getDimensionPixelSize(C0646R.dimen.finger_still_threshold);
        this.glSurfaceView = (GLSurfaceView) findViewById(C0646R.C0648id.main_gl_surface);
        GLSurfaceView gLSurfaceView = this.glSurfaceView;
        C06412 r3 = r6;
        C06412 r4 = new OnTouchListener(this) {
            final /* synthetic */ MainActivity this$0;

            {
                this.this$0 = r5;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                View view2 = view;
                MotionEvent motionEvent2 = motionEvent;
                int x = ((int) motionEvent2.getX()) / this.this$0.scaleFactor;
                int height = (this.this$0.glSurfaceView.getHeight() - ((int) motionEvent2.getY())) / this.this$0.scaleFactor;
                if (this.this$0.handleGuiBar(x, height, motionEvent2)) {
                    return true;
                }
                AndroidDisplay.mouseX = x;
                AndroidDisplay.mouseY = height;
                switch (motionEvent2.getActionMasked()) {
                    case 0:
                    case 5:
                        AndroidDisplay.putMouseEventWithCoords(this.this$0.rightOverride ? (byte) 1 : 0, 1, x, height, 0, System.nanoTime());
                        if (!this.this$0.rightOverride) {
                            AndroidDisplay.mouseLeft = true;
                        }
                        if (AndroidDisplay.grab) {
                            int access$002 = MainActivity.access$002(this.this$0, x);
                            int access$202 = MainActivity.access$202(this.this$0, height);
                            boolean sendEmptyMessageDelayed = this.this$0.theHandler.sendEmptyMessageDelayed(1028, 500);
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                    case 6:
                        AndroidDisplay.putMouseEventWithCoords(this.this$0.rightOverride ? (byte) 1 : 0, 0, x, height, 0, System.nanoTime());
                        if (!this.this$0.rightOverride) {
                            AndroidDisplay.mouseLeft = false;
                        }
                        if (AndroidDisplay.grab) {
                            if (!this.this$0.triggeredLeftMouseButton && Math.abs(this.this$0.initialX - x) < this.this$0.fingerStillThreshold && Math.abs(this.this$0.initialY - height) < this.this$0.fingerStillThreshold) {
                                this.this$0.sendMouseButton(1, true);
                                this.this$0.sendMouseButton(1, false);
                            }
                            if (this.this$0.triggeredLeftMouseButton) {
                                this.this$0.sendMouseButton(0, false);
                            }
                            boolean access$302 = MainActivity.access$302(this.this$0, false);
                            this.this$0.theHandler.removeMessages(1028);
                            break;
                        }
                        break;
                }
                return true;
            }
        };
        gLSurfaceView.setOnTouchListener(r3);
        GLSurfaceView gLSurfaceView2 = this.glSurfaceView;
        C06423 r32 = r62;
        C06423 r42 = new Renderer(this) {
            final /* synthetic */ MainActivity this$0;

            {
                this.this$0 = r5;
            }

            public void onDrawFrame(GL10 gl10) {
            }

            public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            }

            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                StringBuilder sb;
                StringBuilder sb2;
                GL10 gl102 = gl10;
                EGLConfig eGLConfig2 = eGLConfig;
                AndroidDisplay.windowWidth = this.this$0.glSurfaceView.getWidth() / this.this$0.scaleFactor;
                AndroidDisplay.windowHeight = this.this$0.glSurfaceView.getHeight() / this.this$0.scaleFactor;
                this.this$0.calculateMcScale();
                PrintStream printStream = System.out;
                StringBuilder sb3 = sb;
                StringBuilder sb4 = new StringBuilder();
                printStream.println(sb3.append("WidthHeight: ").append(AndroidDisplay.windowWidth).append(":").append(AndroidDisplay.windowHeight).toString());
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                AndroidContextImplementation.theEgl = egl10;
                AndroidContextImplementation.context = egl10.eglGetCurrentContext();
                AndroidContextImplementation.display = egl10.eglGetCurrentDisplay();
                AndroidContextImplementation.read = egl10.eglGetCurrentSurface(12378);
                AndroidContextImplementation.draw = egl10.eglGetCurrentSurface(12377);
                boolean eglMakeCurrent = egl10.eglMakeCurrent(AndroidContextImplementation.display, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                PrintStream printStream2 = System.out;
                StringBuilder sb5 = sb2;
                StringBuilder sb6 = new StringBuilder();
                printStream2.println(sb5.append("Gave up context: ").append(AndroidContextImplementation.context).toString());
                MainActivity.runCraft2(this.this$0, this.this$0.getSharedPreferences("launcher_prefs", 0).getString("selected_version", MainActivity.VERSION_TO_LAUNCH));
                while (true) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (Exception e) {
                        Exception exc = e;
                    }
                }
            }
        };
        gLSurfaceView2.setRenderer(r32);
        this.glSurfaceView.requestRender();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        if (i2 == 4) {
            sendKeyPress(1, true);
            return true;
        }
        Integer num = (Integer) AndroidKeyCodes.keyCodeMap.get(Integer.valueOf(i2));
        if (num == null) {
            return super.onKeyDown(i2, keyEvent2);
        }
        sendKeyPress(num.intValue(), true);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int i2 = i;
        KeyEvent keyEvent2 = keyEvent;
        if (i2 == 4) {
            sendKeyPress(1, false);
            return true;
        }
        Integer num = (Integer) AndroidKeyCodes.keyCodeMap.get(Integer.valueOf(i2));
        if (num == null) {
            return super.onKeyDown(i2, keyEvent2);
        }
        sendKeyPress(num.intValue(), false);
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        View view2 = view;
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                z = true;
                break;
            case 1:
            case 3:
            case 6:
                z = false;
                break;
            default:
                return false;
        }
        if (view2 == this.upButton) {
            sendKeyPress(17, z);
            return false;
        } else if (view2 == this.downButton) {
            sendKeyPress(31, z);
            return false;
        } else if (view2 == this.leftButton) {
            sendKeyPress(30, z);
            return false;
        } else if (view2 == this.rightButton) {
            sendKeyPress(32, z);
            return false;
        } else if (view2 == this.jumpButton) {
            sendKeyPress(57, z);
            return false;
        } else if (view2 == this.primaryButton) {
            sendMouseButton(0, z);
            return false;
        } else if (view2 == this.secondaryButton) {
            if (AndroidDisplay.grab) {
                sendMouseButton(1, z);
                return false;
            }
            setRightOverride(z);
            return false;
        } else if (view2 == this.debugButton) {
            sendKeyPress(61, z);
            return false;
        } else if (view2 == this.shiftButton) {
            sendKeyPress(42, z);
            return false;
        } else if (view2 == this.inventoryButton) {
            sendKeyPress(18, z);
            return false;
        } else if (view2 == this.talkButton) {
            sendKeyPress(20, z);
            return false;
        } else if (view2 == this.keyboardButton) {
            showHiddenTextbox();
            return false;
        } else {
            if (view2 == this.thirdPersonButton) {
                sendKeyPress(63, z);
                return false;
            }
            return false;
        }
    }

    public void showHiddenTextbox() {
        EditText editText;
        PopupTextWatcher popupTextWatcher;
        LinearLayout linearLayout;
        PopupWindow popupWindow;
        ColorDrawable colorDrawable;
        C06434 r9;
        this.hiddenTextIgnoreUpdate = true;
        if (this.hiddenTextWindow == null) {
            EditText editText2 = editText;
            EditText editText3 = new EditText(this);
            this.hiddenTextView = editText2;
            PopupTextWatcher popupTextWatcher2 = popupTextWatcher;
            PopupTextWatcher popupTextWatcher3 = new PopupTextWatcher(this, null);
            PopupTextWatcher popupTextWatcher4 = popupTextWatcher2;
            this.hiddenTextView.addTextChangedListener(popupTextWatcher4);
            this.hiddenTextView.setOnEditorActionListener(popupTextWatcher4);
            this.hiddenTextView.setSingleLine(true);
            this.hiddenTextView.setImeOptions(301989893);
            this.hiddenTextView.setInputType(1);
            LinearLayout linearLayout2 = linearLayout;
            LinearLayout linearLayout3 = new LinearLayout(this);
            LinearLayout linearLayout4 = linearLayout2;
            linearLayout4.addView(this.hiddenTextView);
            PopupWindow popupWindow2 = popupWindow;
            PopupWindow popupWindow3 = new PopupWindow(linearLayout4);
            this.hiddenTextWindow = popupWindow2;
            this.hiddenTextWindow.setWindowLayoutMode(-2, -2);
            this.hiddenTextWindow.setFocusable(true);
            this.hiddenTextWindow.setInputMethodMode(1);
            PopupWindow popupWindow4 = this.hiddenTextWindow;
            ColorDrawable colorDrawable2 = colorDrawable;
            ColorDrawable colorDrawable3 = new ColorDrawable();
            popupWindow4.setBackgroundDrawable(colorDrawable2);
            this.hiddenTextWindow.setClippingEnabled(false);
            this.hiddenTextWindow.setTouchable(false);
            this.hiddenTextWindow.setOutsideTouchable(true);
            PopupWindow popupWindow5 = this.hiddenTextWindow;
            C06434 r5 = r9;
            C06434 r6 = new OnDismissListener(this) {
                final /* synthetic */ MainActivity this$0;

                {
                    this.this$0 = r5;
                }

                public void onDismiss() {
                    boolean access$1002 = MainActivity.access$1002(this.this$0, true);
                }
            };
            popupWindow5.setOnDismissListener(r5);
        }
        this.hiddenTextView.setText(initText);
        this.hiddenTextContents = this.hiddenTextView.getText().toString();
        Selection.setSelection((Spannable) this.hiddenTextView.getText(), this.hiddenTextContents.length());
        this.hiddenTextWindow.showAtLocation(getWindow().getDecorView(), 51, -10000, 0);
        boolean requestFocus = this.hiddenTextView.requestFocus();
        showKeyboardView();
        this.hiddenTextIgnoreUpdate = false;
    }

    public void showKeyboardView() {
        boolean showSoftInput = ((InputMethodManager) getSystemService("input_method")).showSoftInput(getWindow().getDecorView(), 2);
    }
}

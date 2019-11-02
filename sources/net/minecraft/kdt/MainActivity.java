package net.minecraft.kdt;

import adrt.ADRTLogCatReader;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.internal.view.SupportMenu;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import net.minecraft.kdt.MCProfile.Builder;
import net.zhuoweizhang.boardwalk.BoardwalkGLSurfaceView;
import net.zhuoweizhang.boardwalk.DalvikTweaks;
import org.lwjgl.opengl.AndroidContextImplementation;
import org.lwjgl.opengl.AndroidDisplay;

public class MainActivity extends Activity implements OnTouchListener {
    public static int KEY_BACKSPACE = 14;
    /* access modifiers changed from: private */
    public static final int MSG_LEFT_MOUSE_BUTTON_CHECK = 1028;
    public static final String initText = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    /* access modifiers changed from: private */
    public static boolean triggeredLeftMouseButton = false;
    /* access modifiers changed from: private */
    public Builder allProfile;
    /* access modifiers changed from: private */
    public boolean canExit;
    private Button debugButton;
    private DisplayMetrics displayMetrics;
    private Button downButton;
    /* access modifiers changed from: private */
    public int fingerStillThreshold = 8;
    /* access modifiers changed from: private */
    public BoardwalkGLSurfaceView glSurfaceView;
    private int guiScale;
    public String hiddenTextContents;
    public boolean hiddenTextIgnoreUpdate;
    private EditText hiddenTextView;
    private PopupWindow hiddenTextWindow;
    private int[] hotbarKeys = {2, 3, 4, 5, 6, 7, 8, 9, 10};
    /* access modifiers changed from: private */
    public int initialX;
    /* access modifiers changed from: private */
    public int initialY;
    private Button inventoryButton;
    private Button jumpButton;
    private Button keyboardButton;
    private Button leftButton;
    private LayoutParams mParams;
    /* access modifiers changed from: private */
    public LinearLayout mainView;
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
    private Button upButton;
    private WindowManager winManager;

    private class PopupTextWatcher implements TextWatcher, OnEditorActionListener {
        private final MainActivity this$0;

        static MainActivity access$0(PopupTextWatcher popupTextWatcher) {
            return popupTextWatcher.this$0;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        PopupTextWatcher(MainActivity mainActivity) {
            this.this$0 = mainActivity;
        }

        public void afterTextChanged(Editable editable) {
            StringBuffer stringBuffer;
            StringBuffer stringBuffer2;
            StringBuffer stringBuffer3;
            Editable editable2 = editable;
            if (!this.this$0.hiddenTextIgnoreUpdate) {
                String editable3 = editable2.toString();
                String str = this.this$0.hiddenTextContents;
                PrintStream printStream = System.out;
                StringBuffer stringBuffer4 = stringBuffer;
                StringBuffer stringBuffer5 = new StringBuffer();
                StringBuffer stringBuffer6 = stringBuffer2;
                StringBuffer stringBuffer7 = new StringBuffer();
                StringBuffer stringBuffer8 = stringBuffer3;
                StringBuffer stringBuffer9 = new StringBuffer();
                printStream.println(stringBuffer4.append(stringBuffer6.append(stringBuffer8.append("New: ").append(editable3).toString()).append(" old: ").toString()).append(str).toString());
                if (editable3.length() < str.length()) {
                    for (int i = 0; i < str.length() - editable3.length(); i++) {
                        this.this$0.sendKeyPress(MainActivity.KEY_BACKSPACE, true);
                        this.this$0.sendKeyPress(MainActivity.KEY_BACKSPACE, false);
                    }
                } else if (editable3.length() == 0) {
                    this.this$0.hiddenTextContents = MainActivity.initText;
                } else {
                    for (int i2 = 0; i2 < editable3.length() - str.length(); i2++) {
                        char charAt = editable3.charAt(str.length() + i2);
                        this.this$0.sendKeyPress(0, charAt, true);
                        this.this$0.sendKeyPress(0, charAt, false);
                        if (!editable3.substring(editable3.length() - 1).equals(".") && !this.this$0.allProfile.getVersion().equals("1.7.10")) {
                            this.this$0.sendKeyPress(MainActivity.KEY_BACKSPACE, true);
                            this.this$0.sendKeyPress(MainActivity.KEY_BACKSPACE, false);
                        }
                    }
                }
                this.this$0.hiddenTextContents = editable3;
            }
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            TextView textView2 = textView;
            int i2 = i;
            KeyEvent keyEvent2 = keyEvent;
            this.this$0.sendKeyPress(28, 10, true);
            this.this$0.sendKeyPress(28, 0, false);
            return true;
        }
    }

    public void forceUserHome(String str) throws Exception {
        String str2 = str;
        Properties properties = System.getProperties();
        Class cls = properties.getClass();
        Field field = null;
        while (true) {
            if (cls == null) {
                break;
            }
            try {
                field = cls.getDeclaredField("defaults");
                break;
            } catch (Exception e) {
                Exception exc = e;
                cls = cls.getSuperclass();
            }
        }
        if (field != null) {
            field.setAccessible(true);
            Object put = ((Properties) field.get(properties)).put("user.home", str2);
        }
    }

    public void initEnvs() {
        try {
            if (!isNougatOrAbove()) {
                DalvikTweaks.setenv("LIBGL_MIPMAP", "3", true);
            }
            String property = System.setProperty("user.home", FileAccess.MAIN_PATH);
            if (!System.getProperty("user.home", "/").equals(FileAccess.MAIN_PATH)) {
                forceUserHome(FileAccess.MAIN_PATH);
            }
            String property2 = System.setProperty("org.apache.logging.log4j.level", "INFO");
            String property3 = System.setProperty("org.apache.logging.log4j.simplelog.level", "INFO");
            String property4 = System.setProperty("net.zhuoweizhang.boardwalk.org.apache.logging.log4j.level", "INFO");
            String property5 = System.setProperty("net.zhuoweizhang.boardwalk.org.apache.logging.log4j.simplelog.level", "INFO");
        } catch (Exception e) {
            MCClassPath.throwError(this, e);
        }
    }

    private String[] getMCArgs() {
        File file;
        StringBuffer stringBuffer;
        String nickname = this.allProfile.getNickname();
        String version = this.allProfile.getVersion();
        File file2 = file;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        File file3 = new File(stringBuffer2.append(FileAccess.MAIN_PATH).append("/gamedir").toString());
        File file4 = file2;
        boolean mkdirs = file4.mkdirs();
        String[] strArr = new String[18];
        String[] strArr2 = strArr;
        strArr[0] = "--username";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = nickname;
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = "--version";
        String[] strArr7 = strArr6;
        String[] strArr8 = strArr7;
        strArr7[3] = version;
        String[] strArr9 = strArr8;
        String[] strArr10 = strArr9;
        strArr9[4] = "--gameDir";
        String[] strArr11 = strArr10;
        String[] strArr12 = strArr11;
        strArr11[5] = file4.getAbsolutePath();
        String[] strArr13 = strArr12;
        String[] strArr14 = strArr13;
        strArr13[6] = "--assetsDir";
        String[] strArr15 = strArr14;
        String[] strArr16 = strArr15;
        strArr15[7] = "/sdcard/boardwalk/gamedir/assets";
        String[] strArr17 = strArr16;
        String[] strArr18 = strArr17;
        strArr17[8] = "--assetIndex";
        String[] strArr19 = strArr18;
        String[] strArr20 = strArr19;
        strArr19[9] = version;
        String[] strArr21 = strArr20;
        String[] strArr22 = strArr21;
        strArr21[10] = "--uuid";
        String[] strArr23 = strArr22;
        String[] strArr24 = strArr23;
        strArr23[11] = this.allProfile.getProfileID();
        String[] strArr25 = strArr24;
        String[] strArr26 = strArr25;
        strArr25[12] = "--accessToken";
        String[] strArr27 = strArr26;
        String[] strArr28 = strArr27;
        strArr27[13] = this.allProfile.getAccessToken();
        String[] strArr29 = strArr28;
        String[] strArr30 = strArr29;
        strArr29[14] = "--userProperties";
        String[] strArr31 = strArr30;
        String[] strArr32 = strArr31;
        strArr31[15] = "{}";
        String[] strArr33 = strArr32;
        String[] strArr34 = strArr33;
        strArr33[16] = "--userType";
        String[] strArr35 = strArr34;
        String[] strArr36 = strArr35;
        strArr35[17] = "mojang";
        return strArr36;
    }

    /* access modifiers changed from: private */
    public void runCraft() throws Exception {
        NoClassDefFoundError noClassDefFoundError;
        NoClassDefFoundError noClassDefFoundError2;
        File dir = getDir("dalvik-cache", 0);
        boolean mkdirs = dir.mkdirs();
        DexClassLoader dexClassLoader = r11;
        DexClassLoader dexClassLoader2 = dexClassLoader;
        r11 = dexClassLoader;
        try {
            DexClassLoader dexClassLoader3 = new DexClassLoader(MCClassPath.generate(this.allProfile.getVersion(), FileAccess.ADDED_LIBS), dir.getAbsolutePath(), getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.nativeLibraryDir, Class.forName("net.minecraft.kdt.MainActivity").getClassLoader());
            Class loadClassFromClassesList = MCClassPath.loadClassFromClassesList(dexClassLoader2);
            String str = "main";
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            try {
                clsArr[0] = Class.forName("[Ljava.lang.String;");
                Method method = loadClassFromClassesList.getMethod(str, clsArr2);
                Object obj = null;
                Object[] objArr = new Object[1];
                Object[] objArr2 = objArr;
                objArr[0] = (Object) getMCArgs();
                Object invoke = method.invoke(obj, objArr2);
            } catch (ClassNotFoundException e) {
                ClassNotFoundException classNotFoundException = e;
                NoClassDefFoundError noClassDefFoundError3 = noClassDefFoundError2;
                NoClassDefFoundError noClassDefFoundError4 = new NoClassDefFoundError(classNotFoundException.getMessage());
                throw noClassDefFoundError3;
            }
        } catch (ClassNotFoundException e2) {
            ClassNotFoundException classNotFoundException2 = e2;
            NoClassDefFoundError noClassDefFoundError5 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError6 = new NoClassDefFoundError(classNotFoundException2.getMessage());
            throw noClassDefFoundError5;
        }
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1028:
                int i = AndroidDisplay.mouseX;
                int i2 = AndroidDisplay.mouseY;
                if (AndroidDisplay.grab && Math.abs(this.initialX - i) < this.fingerStillThreshold && Math.abs(this.initialY - i2) < this.fingerStillThreshold) {
                    triggeredLeftMouseButton = true;
                    sendMouseButton(0, true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int mcscale(int i) {
        return this.guiScale * i;
    }

    @Override
    public void onCreate(Bundle bundle) {
        DisplayMetrics displayMetrics2;
        ColorDrawable colorDrawable;
        AnonymousClass100000000 r9;
        AnonymousClass100000002 r92;
        Bundle bundle2 = bundle;
        ADRTLogCatReader.onContext(this, "com.aide.ui");
        super.onCreate(bundle2);
        try {
            this.allProfile = MCProfile.load(getIntent().getStringExtra("POFfilepath"));
        } catch (Exception e) {
            MCClassPath.throwError(this, e);
        }
        initEnvs();
        setGuiVisibleView();
        System.loadLibrary("glshim");
        DisplayMetrics displayMetrics3 = displayMetrics2;
        DisplayMetrics displayMetrics4 = new DisplayMetrics();
        this.displayMetrics = displayMetrics3;
        getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
        setContentView(C0634R.layout.main);
        this.upButton = findButton(C0634R.C0636id.control_up);
        this.downButton = findButton(C0634R.C0636id.control_down);
        this.leftButton = findButton(C0634R.C0636id.control_left);
        this.rightButton = findButton(C0634R.C0636id.control_right);
        this.jumpButton = findButton(C0634R.C0636id.control_jump);
        this.primaryButton = findButton(C0634R.C0636id.control_primary);
        this.secondaryButton = findButton(C0634R.C0636id.control_secondary);
        this.debugButton = findButton(C0634R.C0636id.control_debug);
        this.shiftButton = findButton(C0634R.C0636id.control_shift);
        this.keyboardButton = findButton(C0634R.C0636id.control_keyboard);
        this.inventoryButton = findButton(C0634R.C0636id.control_inventory);
        this.talkButton = findButton(C0634R.C0636id.control_talk);
        this.thirdPersonButton = findButton(C0634R.C0636id.control_thirdperson);
        this.overlayView = (ViewGroup) findViewById(C0634R.C0636id.main_control_overlay);
        this.secondaryButtonDefaultBackground = this.secondaryButton.getBackground();
        ColorDrawable colorDrawable2 = colorDrawable;
        ColorDrawable colorDrawable3 = new ColorDrawable(SupportMenu.CATEGORY_MASK);
        this.secondaryButtonColorBackground = colorDrawable2;
        this.glSurfaceView = (BoardwalkGLSurfaceView) findViewById(C0634R.C0636id.mainGLSurfaceView);
        BoardwalkGLSurfaceView boardwalkGLSurfaceView = this.glSurfaceView;
        AnonymousClass100000000 r6 = r9;
        AnonymousClass100000000 r7 = new OnTouchListener(this) {
            private final MainActivity this$0;

            {
                this.this$0 = r6;
            }

            static MainActivity access$0(AnonymousClass100000000 r4) {
                return r4.this$0;
            }

            @Override
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
                            this.this$0.initialX = x;
                            this.this$0.initialY = height;
                            boolean sendEmptyMessageDelayed = this.this$0.theHandler.sendEmptyMessageDelayed(1028, (long) 500);
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
                            MainActivity mainActivity = this.this$0;
                            if (!MainActivity.triggeredLeftMouseButton && Math.abs(this.this$0.initialX - x) < this.this$0.fingerStillThreshold && Math.abs(this.this$0.initialY - height) < this.this$0.fingerStillThreshold) {
                                this.this$0.sendMouseButton(1, true);
                                this.this$0.sendMouseButton(1, false);
                            }
                            MainActivity mainActivity2 = this.this$0;
                            if (MainActivity.triggeredLeftMouseButton) {
                                this.this$0.sendMouseButton(0, false);
                            }
                            MainActivity mainActivity3 = this.this$0;
                            MainActivity.triggeredLeftMouseButton = false;
                            this.this$0.theHandler.removeMessages(1028);
                            break;
                        }
                        break;
                }
                return true;
            }
        };
        boardwalkGLSurfaceView.setOnTouchListener(r6);
        BoardwalkGLSurfaceView boardwalkGLSurfaceView2 = this.glSurfaceView;
        AnonymousClass100000002 r62 = r92;
        AnonymousClass100000002 r72 = new Renderer(this) {
            private final MainActivity this$0;

            {
                this.this$0 = r6;
            }

            static MainActivity access$0(AnonymousClass100000002 r4) {
                return r4.this$0;
            }

            public void onDrawFrame(GL10 gl10) {
            }

            public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            }

            @Override
            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                StringBuffer stringBuffer;
                StringBuffer stringBuffer2;
                StringBuffer stringBuffer3;
                StringBuffer stringBuffer4;
                Timer timer;
                AnonymousClass100000001 r12;
                GL10 gl102 = gl10;
                EGLConfig eGLConfig2 = eGLConfig;
                AndroidDisplay.windowWidth = this.this$0.glSurfaceView.getWidth() / this.this$0.scaleFactor;
                AndroidDisplay.windowHeight = this.this$0.glSurfaceView.getHeight() / this.this$0.scaleFactor;
                this.this$0.calculateMcScale();
                PrintStream printStream = System.out;
                StringBuffer stringBuffer5 = stringBuffer;
                StringBuffer stringBuffer6 = new StringBuffer();
                StringBuffer stringBuffer7 = stringBuffer2;
                StringBuffer stringBuffer8 = new StringBuffer();
                StringBuffer stringBuffer9 = stringBuffer3;
                StringBuffer stringBuffer10 = new StringBuffer();
                printStream.println(stringBuffer5.append(stringBuffer7.append(stringBuffer9.append("WidthHeight: ").append(AndroidDisplay.windowWidth).toString()).append(":").toString()).append(AndroidDisplay.windowHeight).toString());
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                AndroidContextImplementation.theEgl = egl10;
                AndroidContextImplementation.context = egl10.eglGetCurrentContext();
                AndroidContextImplementation.display = egl10.eglGetCurrentDisplay();
                AndroidContextImplementation.read = egl10.eglGetCurrentSurface(12378);
                AndroidContextImplementation.draw = egl10.eglGetCurrentSurface(12377);
                boolean eglMakeCurrent = egl10.eglMakeCurrent(AndroidContextImplementation.display, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                PrintStream printStream2 = System.out;
                StringBuffer stringBuffer11 = stringBuffer4;
                StringBuffer stringBuffer12 = new StringBuffer();
                printStream2.println(stringBuffer11.append("Gave up context: ").append(AndroidContextImplementation.context).toString());
                if (this.this$0.isNougatOrAbove()) {
                    Timer timer2 = timer;
                    Timer timer3 = new Timer();
                    AnonymousClass100000001 r8 = r12;
                    AnonymousClass100000001 r9 = new TimerTask(this) {
                        private final AnonymousClass100000002 this$0;

                        {
                            this.this$0 = r6;
                        }

                        static AnonymousClass100000002 access$0(AnonymousClass100000001 r4) {
                            return r4.this$0;
                        }

                        @Override
                        public void run() {
                            try {
                                AnonymousClass100000002.access$0(this.this$0).runCraft();
                            } catch (Exception e) {
                                MCClassPath.throwError(AnonymousClass100000002.access$0(this.this$0), e);
                            }
                        }
                    };
                    timer2.schedule(r8, (long) 10);
                    return;
                }
                try {
                    this.this$0.runCraft();
                    while (true) {
                        Thread.sleep(2147483647L);
                    }
                } catch (Exception e) {
                    MCClassPath.throwError(this.this$0, e);
                }
            }
        };
        boardwalkGLSurfaceView2.setRenderer(r62);
        this.glSurfaceView.requestRender();
        this.glSurfaceView.setRenderMode(0);
        this.glSurfaceView.setPreserveEGLContextOnPause(true);
        toggleGui(null);
    }

    /* access modifiers changed from: protected */
    @Override
    public void onStop() {
        Timer timer;
        AnonymousClass100000003 r6;
        super.onStop();
        if (this.canExit) {
            Timer timer2 = timer;
            Timer timer3 = new Timer();
            AnonymousClass100000003 r3 = r6;
            AnonymousClass100000003 r4 = new TimerTask(this) {
                private final MainActivity this$0;

                {
                    this.this$0 = r6;
                }

                static MainActivity access$0(AnonymousClass100000003 r4) {
                    return r4.this$0;
                }

                @Override
                public void run() {
                    System.exit(0);
                }
            };
            timer2.schedule(r3, (long) 500);
        }
    }

    /* access modifiers changed from: private */
    public boolean isNougatOrAbove() {
        return VERSION.SDK_INT >= 24;
    }

    public void forceCloseSure(View view) {
        AlertDialog.Builder builder;
        AnonymousClass100000004 r8;
        View view2 = view;
        AlertDialog.Builder builder2 = builder;
        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        AlertDialog.Builder negativeButton = builder2.setTitle("Are you sure want to force close?").setMessage("Make sure you already close your world or it may corrupt!").setNegativeButton(17039360, null);
        AnonymousClass100000004 r5 = r8;
        AnonymousClass100000004 r6 = new OnClickListener(this) {
            private final MainActivity this$0;

            {
                this.this$0 = r6;
            }

            static MainActivity access$0(AnonymousClass100000004 r4) {
                return r4.this$0;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterface dialogInterface2 = dialogInterface;
                int i2 = i;
                this.this$0.canExit = false;
                System.exit(0);
            }
        };
        AlertDialog show = negativeButton.setPositiveButton(17039370, r5).show();
    }

    private Button findButton(int i) {
        Button button = (Button) findViewById(i);
        button.setOnTouchListener(this);
        return button;
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
        } else if (view2 == this.downButton) {
            sendKeyPress(31, z);
        } else if (view2 == this.leftButton) {
            sendKeyPress(30, z);
        } else if (view2 == this.rightButton) {
            sendKeyPress(32, z);
        } else if (view2 == this.jumpButton) {
            sendKeyPress(57, z);
        } else if (view2 == this.primaryButton) {
            sendMouseButton(0, z);
        } else if (view2 == this.secondaryButton) {
            if (AndroidDisplay.grab) {
                sendMouseButton(1, z);
            } else {
                setRightOverride(z);
            }
        } else if (view2 == this.debugButton) {
            sendKeyPress(61, z);
        } else if (view2 == this.shiftButton) {
            sendKeyPress(42, z);
        } else if (view2 == this.inventoryButton) {
            sendKeyPress(18, z);
        } else if (view2 == this.talkButton) {
            sendKeyPress(20, z);
        } else if (view2 == this.keyboardButton) {
            showHiddenTextbox();
        } else if (view2 == this.thirdPersonButton) {
            sendKeyPress(63, z);
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        sendKeyPress(1, true);
    }

    public void showHiddenTextbox() {
        AnonymousClass100000006 r10;
        EditText editText;
        PopupTextWatcher popupTextWatcher;
        LinearLayout linearLayout;
        PopupWindow popupWindow;
        ColorDrawable colorDrawable;
        AnonymousClass100000005 r102;
        this.hiddenTextIgnoreUpdate = true;
        if (this.hiddenTextWindow == null) {
            EditText editText2 = editText;
            EditText editText3 = new EditText(this);
            this.hiddenTextView = editText2;
            PopupTextWatcher popupTextWatcher2 = popupTextWatcher;
            PopupTextWatcher popupTextWatcher3 = new PopupTextWatcher(this);
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
            AnonymousClass100000005 r6 = r102;
            AnonymousClass100000005 r7 = new OnDismissListener(this) {
                private final MainActivity this$0;

                {
                    this.this$0 = r6;
                }

                static MainActivity access$0(AnonymousClass100000005 r4) {
                    return r4.this$0;
                }

                public void onDismiss() {
                    this.this$0.hiddenTextIgnoreUpdate = true;
                }
            };
            popupWindow5.setOnDismissListener(r6);
        }
        this.hiddenTextView.setText(initText);
        this.hiddenTextContents = this.hiddenTextView.getText().toString();
        Selection.setSelection(this.hiddenTextView.getText(), this.hiddenTextContents.length());
        this.hiddenTextWindow.showAtLocation(getWindow().getDecorView(), 51, -10000, 0);
        boolean requestFocus = this.hiddenTextView.requestFocus();
        showKeyboardView();
        EditText editText4 = this.hiddenTextView;
        AnonymousClass100000006 r62 = r10;
        AnonymousClass100000006 r72 = new OnFocusChangeListener(this) {
            private final MainActivity this$0;

            {
                this.this$0 = r6;
            }

            static MainActivity access$0(AnonymousClass100000006 r4) {
                return r4.this$0;
            }

            @Override
            public void onFocusChange(View view, boolean z) {
                View view2 = view;
                this.this$0.visibleView(this.this$0.mainView, z);
            }
        };
        editText4.setOnFocusChangeListener(r62);
        this.hiddenTextIgnoreUpdate = false;
    }

    public void showKeyboardView() {
        boolean showSoftInput = ((InputMethodManager) getSystemService("input_method")).showSoftInput(getWindow().getDecorView(), 2);
        visibleView(this.mainView, true);
    }

    private void setRightOverride(boolean z) {
        this.rightOverride = z;
        this.secondaryButton.setBackgroundDrawable(this.rightOverride ? this.secondaryButtonColorBackground : this.secondaryButtonDefaultBackground);
    }

    public void toggleGui(View view) {
        View view2 = view;
        switch (this.overlayView.getVisibility()) {
            case 0:
                this.overlayView.setVisibility(8);
                return;
            case 8:
                this.overlayView.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void visibleView(View view, boolean z) {
        view.setVisibility(z ? 8 : 0);
    }

    private void setGuiVisibleView() {
        LinearLayout linearLayout;
        LayoutParams layoutParams;
        LinearLayout linearLayout2 = linearLayout;
        LinearLayout linearLayout3 = new LinearLayout(this);
        this.mainView = linearLayout2;
        this.mainView = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(C0634R.layout.guibtn, this.mainView);
        this.winManager = (WindowManager) getSystemService("window");
        LayoutParams layoutParams2 = layoutParams;
        LayoutParams layoutParams3 = new LayoutParams();
        this.mParams = layoutParams2;
        this.mParams.width = -2;
        this.mParams.height = -2;
        this.mParams.gravity = 83;
        this.mParams.format = -3;
        this.mParams.type = 2;
        this.mParams.flags = 8;
        this.winManager.addView(this.mainView, this.mParams);
    }

    /* access modifiers changed from: private */
    public void sendKeyPress(int i, boolean z) {
        sendKeyPress(i, 0, z);
    }

    /* access modifiers changed from: private */
    public void sendKeyPress(int i, char c, boolean z) {
        AndroidDisplay.setKey(i, c, z);
    }

    /* access modifiers changed from: private */
    public void sendMouseButton(int i, boolean z) {
        AndroidDisplay.setMouseButtonInGrabMode((byte) i, z ? (byte) 1 : 0);
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
        if (!AndroidDisplay.grab) {
            return false;
        }
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
        if (i3 < i7 || i3 >= i7 + mcscale2 || i4 < 0 || i4 >= 0 + mcscale) {
            return false;
        }
        sendKeyPress(this.hotbarKeys[((i3 - i7) / mcscale(20)) % 9], z);
        return true;
    }

    public MainActivity() {
        Handler handler;
        Handler handler2 = handler;
        Handler handler3 = new Handler();
        this.theHandler = handler2;
        this.hiddenTextIgnoreUpdate = true;
        this.hiddenTextContents = initText;
        this.canExit = true;
    }
}

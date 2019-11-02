package org.lwjgl.opengl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.lwjgl.LWJGLUtil;

public class XRandR {
    private static final Pattern SCREEN_PATTERN1 = Pattern.compile("^(\\d+)x(\\d+)\\+(\\d+)\\+(\\d+)$");
    private static final Pattern SCREEN_PATTERN2 = Pattern.compile("^(\\d+)x(\\d+)$");
    private static Screen[] current;
    private static Map<String, Screen[]> screens;

    public static class Screen implements Cloneable {
        public final int height;
        public final String name;
        public final int width;
        public int xPos;
        public int yPos;

        private Screen(String str, int i, int i2, int i3, int i4) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            this.name = str;
            this.width = i5;
            this.height = i6;
            this.xPos = i7;
            this.yPos = i8;
        }

        /* synthetic */ Screen(String str, int i, int i2, int i3, int i4, C08101 r19) {
            C08101 r6 = r19;
            this(str, i, i2, i3, i4);
        }

        /* access modifiers changed from: private */
        public void getArgs(List<String> list) {
            StringBuilder sb;
            StringBuilder sb2;
            List<String> list2 = list;
            boolean add = list2.add("--output");
            boolean add2 = list2.add(this.name);
            boolean add3 = list2.add("--mode");
            List<String> list3 = list2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            boolean add4 = list3.add(sb3.append(this.width).append("x").append(this.height).toString());
            boolean add5 = list2.add("--pos");
            List<String> list4 = list2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            boolean add6 = list4.add(sb5.append(this.xPos).append("x").append(this.yPos).toString());
        }

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            return sb2.append(this.name).append(" ").append(this.width).append("x").append(this.height).append(" @ ").append(this.xPos).append("x").append(this.yPos).toString();
        }
    }

    public XRandR() {
    }

    public static Screen[] getConfiguration() {
        populate();
        return (Screen[]) current.clone();
    }

    public static Screen[] getResolutions(String str) {
        String str2 = str;
        populate();
        return (Screen[]) ((Screen[]) screens.get(str2)).clone();
    }

    public static String[] getScreenNames() {
        populate();
        return (String[]) screens.keySet().toArray(new String[screens.size()]);
    }

    private static void parseScreen(List<Screen> list, String str, String str2) {
        int i;
        int i2;
        Screen screen;
        StringBuilder sb;
        List<Screen> list2 = list;
        String str3 = str;
        String str4 = str2;
        Matcher matcher = SCREEN_PATTERN1.matcher(str4);
        if (!matcher.matches()) {
            matcher = SCREEN_PATTERN2.matcher(str4);
            if (!matcher.matches()) {
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Did not match: ").append(str4).toString());
                return;
            }
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        int parseInt2 = Integer.parseInt(matcher.group(2));
        if (matcher.groupCount() > 3) {
            i = Integer.parseInt(matcher.group(3));
            i2 = Integer.parseInt(matcher.group(4));
        } else {
            i = 0;
            i2 = 0;
        }
        List<Screen> list3 = list2;
        Screen screen2 = screen;
        Screen screen3 = new Screen(str3, parseInt, parseInt2, i, i2, null);
        boolean add = list3.add(screen2);
    }

    private static void populate() {
        HashMap hashMap;
        StringBuilder sb;
        ArrayList arrayList;
        ArrayList arrayList2;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        if (screens == null) {
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            screens = hashMap2;
            try {
                Runtime runtime = Runtime.getRuntime();
                String[] strArr = new String[2];
                String[] strArr2 = strArr;
                strArr[0] = "xrandr";
                String[] strArr3 = strArr2;
                String[] strArr4 = strArr3;
                strArr3[1] = "-q";
                Process exec = runtime.exec(strArr4);
                ArrayList arrayList3 = arrayList;
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = arrayList3;
                ArrayList arrayList6 = arrayList2;
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = arrayList6;
                String str = null;
                BufferedReader bufferedReader2 = bufferedReader;
                InputStreamReader inputStreamReader2 = inputStreamReader;
                InputStreamReader inputStreamReader3 = new InputStreamReader(exec.getInputStream());
                BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
                BufferedReader bufferedReader4 = bufferedReader2;
                while (true) {
                    String readLine = bufferedReader4.readLine();
                    if (readLine != null) {
                        String[] split = readLine.trim().split("\\s+");
                        if ("connected".equals(split[1])) {
                            if (str != null) {
                                Object put = screens.put(str, arrayList8.toArray(new Screen[arrayList8.size()]));
                                arrayList8.clear();
                            }
                            str = split[0];
                            parseScreen(arrayList5, str, "primary".equals(split[2]) ? split[3] : split[2]);
                        } else if (Pattern.matches("\\d*x\\d*", split[0])) {
                            parseScreen(arrayList8, str, split[0]);
                        }
                    } else {
                        Object put2 = screens.put(str, arrayList8.toArray(new Screen[arrayList8.size()]));
                        current = (Screen[]) arrayList5.toArray(new Screen[arrayList5.size()]);
                        return;
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Exception in XRandR.populate(): ").append(th2.getMessage()).toString());
                screens.clear();
                current = new Screen[0];
            }
        }
    }

    public static void setConfiguration(Screen... screenArr) {
        ArrayList arrayList;
        StringBuilder sb;
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        StringBuilder sb2;
        boolean z;
        IllegalArgumentException illegalArgumentException;
        Screen[] screenArr2 = screenArr;
        if (screenArr2.length == 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Must specify at least one screen");
            throw illegalArgumentException2;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        boolean add = arrayList4.add("xrandr");
        Screen[] screenArr3 = current;
        int length = screenArr3.length;
        for (int i = 0; i < length; i++) {
            Screen screen = screenArr3[i];
            int length2 = screenArr2.length;
            int i2 = 0;
            while (true) {
                z = false;
                if (i2 >= length2) {
                    break;
                } else if (screenArr2[i2].name.equals(screen.name)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                boolean add2 = arrayList4.add("--output");
                boolean add3 = arrayList4.add(screen.name);
                boolean add4 = arrayList4.add("--off");
            }
        }
        int length3 = screenArr2.length;
        for (int i3 = 0; i3 < length3; i3++) {
            screenArr2[i3].getArgs(arrayList4);
        }
        try {
            BufferedReader bufferedReader2 = bufferedReader;
            InputStreamReader inputStreamReader2 = inputStreamReader;
            InputStreamReader inputStreamReader3 = new InputStreamReader(Runtime.getRuntime().exec((String[]) arrayList4.toArray(new String[arrayList4.size()])).getInputStream());
            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader2);
            BufferedReader bufferedReader4 = bufferedReader2;
            while (true) {
                String readLine = bufferedReader4.readLine();
                if (readLine != null) {
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    LWJGLUtil.log(sb3.append("Unexpected output from xrandr process: ").append(readLine).toString());
                } else {
                    current = screenArr2;
                    return;
                }
            }
        } catch (IOException e) {
            IOException iOException = e;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            LWJGLUtil.log(sb5.append("XRandR exception in setConfiguration(): ").append(iOException.getMessage()).toString());
        }
    }
}

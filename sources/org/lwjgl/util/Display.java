package org.lwjgl.util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.DisplayMode;

public final class Display {
    static final /* synthetic */ boolean $assertionsDisabled = (!Display.class.desiredAssertionStatus());
    private static final boolean DEBUG = false;

    public Display() {
    }

    public static DisplayMode[] getAvailableDisplayModes(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws LWJGLException {
        ArrayList arrayList;
        AssertionError assertionError;
        StringBuilder sb;
        int i9 = i;
        int i10 = i2;
        int i11 = i3;
        int i12 = i4;
        int i13 = i5;
        int i14 = i6;
        int i15 = i7;
        int i16 = i8;
        DisplayMode[] availableDisplayModes = org.lwjgl.opengl.Display.getAvailableDisplayModes();
        if (LWJGLUtil.DEBUG) {
            System.out.println("Available screen modes:");
            int length = availableDisplayModes.length;
            for (int i17 = 0; i17 < length; i17++) {
                System.out.println(availableDisplayModes[i17]);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(availableDisplayModes.length);
        ArrayList arrayList4 = arrayList2;
        int i18 = 0;
        while (i18 < availableDisplayModes.length) {
            if ($assertionsDisabled || availableDisplayModes[i18] != null) {
                if ((i9 == -1 || availableDisplayModes[i18].getWidth() >= i9) && ((i11 == -1 || availableDisplayModes[i18].getWidth() <= i11) && ((i10 == -1 || availableDisplayModes[i18].getHeight() >= i10) && ((i12 == -1 || availableDisplayModes[i18].getHeight() <= i12) && ((i13 == -1 || availableDisplayModes[i18].getBitsPerPixel() >= i13) && ((i14 == -1 || availableDisplayModes[i18].getBitsPerPixel() <= i14) && (availableDisplayModes[i18].getFrequency() == 0 || ((i15 == -1 || availableDisplayModes[i18].getFrequency() >= i15) && (i16 == -1 || availableDisplayModes[i18].getFrequency() <= i16))))))))) {
                    boolean add = arrayList4.add(availableDisplayModes[i18]);
                }
                i18++;
            } else {
                AssertionError assertionError2 = assertionError;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                AssertionError assertionError3 = new AssertionError(sb2.append(LibrariesRepository.MOJANG_MAVEN_REPO).append(i18).append(" ").append(availableDisplayModes.length).toString());
                throw assertionError2;
            }
        }
        DisplayMode[] displayModeArr = new DisplayMode[arrayList4.size()];
        Object[] array = arrayList4.toArray(displayModeArr);
        if (LWJGLUtil.DEBUG) {
        }
        return displayModeArr;
    }

    public static DisplayMode setDisplayMode(DisplayMode[] displayModeArr, String[] strArr) throws Exception {
        AnonymousClass1Sorter r13;
        Exception exc;
        StringBuilder sb;
        StringBuilder sb2;
        DisplayMode[] displayModeArr2 = displayModeArr;
        DisplayMode[] displayModeArr3 = displayModeArr2;
        AnonymousClass1Sorter r10 = r13;
        final String[] strArr2 = strArr;
        AnonymousClass1Sorter r11 = new Comparator<DisplayMode>() {
            final AnonymousClass1FieldAccessor[] accessors = new AnonymousClass1FieldAccessor[strArr2.length];

            {
                AnonymousClass1FieldAccessor r14;
                AnonymousClass1FieldAccessor r142;
                AnonymousClass1FieldAccessor r143;
                for (int i = 0; i < this.accessors.length; i++) {
                    int indexOf = strArr2[i].indexOf(61);
                    if (indexOf > 0) {
                        AnonymousClass1FieldAccessor[] r4 = this.accessors;
                        int i2 = i;
                        AnonymousClass1FieldAccessor r6 = r143;
                        AnonymousClass1FieldAccessor r7 = new Object(strArr2[i].substring(0, indexOf), 0, Integer.parseInt(strArr2[i].substring(indexOf + 1, strArr2[i].length())), true) {
                            final String fieldName;
                            final int order;
                            final int preferred;
                            final boolean usePreferred;

                            {
                                int i = r9;
                                int i2 = r10;
                                boolean z = r11;
                                this.fieldName = r8;
                                this.order = i;
                                this.preferred = i2;
                                this.usePreferred = z;
                            }

                            /* access modifiers changed from: 0000 */
                            public int getInt(DisplayMode displayMode) {
                                IllegalArgumentException illegalArgumentException;
                                StringBuilder sb;
                                DisplayMode displayMode2 = displayMode;
                                if ("width".equals(this.fieldName)) {
                                    return displayMode2.getWidth();
                                }
                                if ("height".equals(this.fieldName)) {
                                    return displayMode2.getHeight();
                                }
                                if ("freq".equals(this.fieldName)) {
                                    return displayMode2.getFrequency();
                                }
                                if ("bpp".equals(this.fieldName)) {
                                    return displayMode2.getBitsPerPixel();
                                }
                                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown field ").append(this.fieldName).toString());
                                throw illegalArgumentException2;
                            }
                        };
                        r4[i2] = r6;
                    } else if (strArr2[i].charAt(0) == '-') {
                        AnonymousClass1FieldAccessor[] r42 = this.accessors;
                        int i3 = i;
                        AnonymousClass1FieldAccessor r62 = r142;
                        AnonymousClass1FieldAccessor r72 = new Object(strArr2[i].substring(1), -1, 0, false) {
                            final String fieldName;
                            final int order;
                            final int preferred;
                            final boolean usePreferred;

                            {
                                int i = r9;
                                int i2 = r10;
                                boolean z = r11;
                                this.fieldName = r8;
                                this.order = i;
                                this.preferred = i2;
                                this.usePreferred = z;
                            }

                            /* access modifiers changed from: 0000 */
                            public int getInt(DisplayMode displayMode) {
                                IllegalArgumentException illegalArgumentException;
                                StringBuilder sb;
                                DisplayMode displayMode2 = displayMode;
                                if ("width".equals(this.fieldName)) {
                                    return displayMode2.getWidth();
                                }
                                if ("height".equals(this.fieldName)) {
                                    return displayMode2.getHeight();
                                }
                                if ("freq".equals(this.fieldName)) {
                                    return displayMode2.getFrequency();
                                }
                                if ("bpp".equals(this.fieldName)) {
                                    return displayMode2.getBitsPerPixel();
                                }
                                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown field ").append(this.fieldName).toString());
                                throw illegalArgumentException2;
                            }
                        };
                        r42[i3] = r62;
                    } else {
                        AnonymousClass1FieldAccessor[] r43 = this.accessors;
                        int i4 = i;
                        AnonymousClass1FieldAccessor r63 = r14;
                        AnonymousClass1FieldAccessor r73 = new Object(strArr2[i], 1, 0, false) {
                            final String fieldName;
                            final int order;
                            final int preferred;
                            final boolean usePreferred;

                            {
                                int i = r9;
                                int i2 = r10;
                                boolean z = r11;
                                this.fieldName = r8;
                                this.order = i;
                                this.preferred = i2;
                                this.usePreferred = z;
                            }

                            /* access modifiers changed from: 0000 */
                            public int getInt(DisplayMode displayMode) {
                                IllegalArgumentException illegalArgumentException;
                                StringBuilder sb;
                                DisplayMode displayMode2 = displayMode;
                                if ("width".equals(this.fieldName)) {
                                    return displayMode2.getWidth();
                                }
                                if ("height".equals(this.fieldName)) {
                                    return displayMode2.getHeight();
                                }
                                if ("freq".equals(this.fieldName)) {
                                    return displayMode2.getFrequency();
                                }
                                if ("bpp".equals(this.fieldName)) {
                                    return displayMode2.getBitsPerPixel();
                                }
                                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                                StringBuilder sb2 = sb;
                                StringBuilder sb3 = new StringBuilder();
                                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("Unknown field ").append(this.fieldName).toString());
                                throw illegalArgumentException2;
                            }
                        };
                        r43[i4] = r63;
                    }
                }
            }

            public int compare(DisplayMode displayMode, DisplayMode displayMode2) {
                DisplayMode displayMode3 = displayMode;
                DisplayMode displayMode4 = displayMode2;
                AnonymousClass1FieldAccessor[] r3 = this.accessors;
                int length = r3.length;
                for (int i = 0; i < length; i++) {
                    AnonymousClass1FieldAccessor r6 = r3[i];
                    int i2 = r6.getInt(displayMode3);
                    int i3 = r6.getInt(displayMode4);
                    if (r6.usePreferred && i2 != i3) {
                        if (i2 != r6.preferred) {
                            if (i3 == r6.preferred) {
                                return 1;
                            }
                            int abs = Math.abs(i2 - r6.preferred);
                            int abs2 = Math.abs(i3 - r6.preferred);
                            if (abs >= abs2) {
                                if (abs > abs2) {
                                    return 1;
                                }
                            }
                        }
                        return -1;
                    } else if (i2 < i3) {
                        return r6.order;
                    } else {
                        if (i2 != i3) {
                            return -r6.order;
                        }
                    }
                }
                return 0;
            }
        };
        Arrays.sort(displayModeArr3, r10);
        if (LWJGLUtil.DEBUG) {
            System.out.println("Sorted display modes:");
            int length = displayModeArr2.length;
            for (int i = 0; i < length; i++) {
                System.out.println(displayModeArr2[i]);
            }
        }
        int length2 = displayModeArr2.length;
        int i2 = 0;
        while (i2 < length2) {
            DisplayMode displayMode = displayModeArr2[i2];
            try {
                if (LWJGLUtil.DEBUG) {
                    PrintStream printStream = System.out;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    printStream.println(sb3.append("Attempting to set displaymode: ").append(displayMode).toString());
                }
                org.lwjgl.opengl.Display.setDisplayMode(displayMode);
                return displayMode;
            } catch (Exception e) {
                Exception exc2 = e;
                if (LWJGLUtil.DEBUG) {
                    PrintStream printStream2 = System.out;
                    StringBuilder sb5 = sb;
                    StringBuilder sb6 = new StringBuilder();
                    printStream2.println(sb5.append("Failed to set display mode to ").append(displayMode).toString());
                    exc2.printStackTrace();
                }
                i2++;
            }
        }
        Exception exc3 = exc;
        Exception exc4 = new Exception("Failed to set display mode.");
        throw exc3;
    }
}

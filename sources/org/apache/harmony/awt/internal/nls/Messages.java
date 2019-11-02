package org.apache.harmony.awt.internal.nls;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
    private static ResourceBundle bundle;

    public static String getString(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        if (bundle == null) {
            return str2;
        }
        try {
            return bundle.getString(str2);
        } catch (MissingResourceException e) {
            MissingResourceException missingResourceException = e;
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            return stringBuffer2.append("Missing message: ").append(str2).toString();
        }
    }

    public static String getString(String str, Object obj) {
        String str2 = str;
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = obj;
        return getString(str2, objArr2);
    }

    public static String getString(String str, int i) {
        String str2 = str;
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = Integer.toString(i);
        return getString(str2, objArr2);
    }

    public static String getString(String str, char c) {
        String str2 = str;
        Object[] objArr = new Object[1];
        Object[] objArr2 = objArr;
        objArr[0] = String.valueOf(c);
        return getString(str2, objArr2);
    }

    public static String getString(String str, Object obj, Object obj2) {
        Object obj3 = obj2;
        String str2 = str;
        Object[] objArr = new Object[2];
        Object[] objArr2 = objArr;
        objArr[0] = obj;
        Object[] objArr3 = objArr2;
        Object[] objArr4 = objArr3;
        objArr3[1] = obj3;
        return getString(str2, objArr4);
    }

    public static String getString(String str, Object[] objArr) {
        String str2 = str;
        Object[] objArr2 = objArr;
        String str3 = str2;
        if (bundle != null) {
            try {
                str3 = bundle.getString(str2);
            } catch (MissingResourceException e) {
                MissingResourceException missingResourceException = e;
            }
        }
        return format(str3, objArr2);
    }

    public static String format(String str, Object[] objArr) {
        StringBuilder sb;
        int i;
        String str2 = str;
        Object[] objArr2 = objArr;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(str2.length() + (objArr2.length * 20));
        StringBuilder sb4 = sb2;
        String[] strArr = new String[objArr2.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= objArr2.length) {
                break;
            }
            if (objArr2[i3] == null) {
                strArr[i3] = "<null>";
            } else {
                strArr[i3] = objArr2[i3].toString();
            }
            i2 = i3 + 1;
        }
        int i4 = 0;
        int indexOf = str2.indexOf(123, 0);
        while (true) {
            int i5 = indexOf;
            if (i5 < 0) {
                break;
            }
            if (i5 != 0 && str2.charAt(i5 - 1) == '\\') {
                if (i5 != 1) {
                    StringBuilder append = sb4.append(str2.substring(i4, i5 - 1));
                }
                StringBuilder append2 = sb4.append('{');
                i = i5 + 1;
            } else if (i5 > str2.length() - 3) {
                StringBuilder append3 = sb4.append(str2.substring(i4, str2.length()));
                i = str2.length();
            } else {
                byte digit = (byte) Character.digit(str2.charAt(i5 + 1), 10);
                if (digit < 0 || str2.charAt(i5 + 2) != '}') {
                    StringBuilder append4 = sb4.append(str2.substring(i4, i5 + 1));
                    i = i5 + 1;
                } else {
                    StringBuilder append5 = sb4.append(str2.substring(i4, i5));
                    if (digit >= strArr.length) {
                        StringBuilder append6 = sb4.append("<missing argument>");
                    } else {
                        StringBuilder append7 = sb4.append(strArr[digit]);
                    }
                    i = i5 + 3;
                }
            }
            i4 = i;
            indexOf = str2.indexOf(123, i4);
        }
        if (i4 < str2.length()) {
            StringBuilder append8 = sb4.append(str2.substring(i4, str2.length()));
        }
        return sb4.toString();
    }

    public static ResourceBundle setLocale(Locale locale, String str) {
        AnonymousClass100000000 r10;
        try {
            AnonymousClass100000000 r5 = r10;
            AnonymousClass100000000 r6 = new PrivilegedAction<Object>(str, locale, null) {
                private final ClassLoader val$loader;
                private final Locale val$locale;
                private final String val$resource;

                {
                    Locale locale = r9;
                    ClassLoader classLoader = r10;
                    this.val$resource = r8;
                    this.val$locale = locale;
                    this.val$loader = classLoader;
                }

                public Object run() {
                    return ResourceBundle.getBundle(this.val$resource, this.val$locale, this.val$loader != null ? this.val$loader : ClassLoader.getSystemClassLoader());
                }
            };
            return (ResourceBundle) AccessController.doPrivileged(r5);
        } catch (MissingResourceException e) {
            MissingResourceException missingResourceException = e;
            return null;
        }
    }

    static {
        bundle = null;
        try {
            bundle = setLocale(Locale.getDefault(), "org.apache.harmony.awt.internal.nls.messages");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Messages() {
    }
}

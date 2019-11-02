package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;

@zzhb
public class zzbi {
    private static boolean zza(UnicodeBlock unicodeBlock) {
        UnicodeBlock unicodeBlock2 = unicodeBlock;
        return unicodeBlock2 == UnicodeBlock.BOPOMOFO || unicodeBlock2 == UnicodeBlock.BOPOMOFO_EXTENDED || unicodeBlock2 == UnicodeBlock.CJK_COMPATIBILITY || unicodeBlock2 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlock2 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || unicodeBlock2 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlock2 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlock2 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || unicodeBlock2 == UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS || unicodeBlock2 == UnicodeBlock.HANGUL_JAMO || unicodeBlock2 == UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock2 == UnicodeBlock.HIRAGANA || unicodeBlock2 == UnicodeBlock.KATAKANA || unicodeBlock2 == UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    static boolean zzi(int i) {
        int i2 = i;
        return Character.isLetter(i2) && (zza(UnicodeBlock.of(i2)) || zzj(i2));
    }

    private static boolean zzj(int i) {
        int i2 = i;
        return (i2 >= 65382 && i2 <= 65437) || (i2 >= 65441 && i2 <= 65500);
    }

    public static int zzx(String str) {
        byte[] bytes;
        String str2 = str;
        try {
            bytes = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            bytes = str2.getBytes();
        }
        return zznd.zza(bytes, 0, bytes.length, 0);
    }

    public static String[] zzy(String str) {
        ArrayList arrayList;
        String str2;
        int i;
        boolean z;
        String str3;
        String str4;
        String str5;
        String str6 = str;
        if (str6 == null) {
            return null;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        char[] charArray = str6.toCharArray();
        int length = str6.length();
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            int codePointAt = Character.codePointAt(charArray, i3);
            int charCount = Character.charCount(codePointAt);
            if (zzi(codePointAt)) {
                if (z2) {
                    ArrayList arrayList5 = arrayList4;
                    String str7 = str5;
                    String str8 = new String(charArray, i2, i3 - i2);
                    boolean add = arrayList5.add(str7);
                }
                ArrayList arrayList6 = arrayList4;
                String str9 = str4;
                String str10 = new String(charArray, i3, charCount);
                boolean add2 = arrayList6.add(str9);
                i = i2;
                z = false;
            } else if (Character.isLetterOrDigit(codePointAt) || Character.getType(codePointAt) == 6 || Character.getType(codePointAt) == 8) {
                if (!z2) {
                    i2 = i3;
                }
                i = i2;
                z = true;
            } else if (z2) {
                ArrayList arrayList7 = arrayList4;
                String str11 = str3;
                String str12 = new String(charArray, i2, i3 - i2);
                boolean add3 = arrayList7.add(str11);
                i = i2;
                z = false;
            } else {
                i = i2;
                z = z2;
            }
            i3 += charCount;
            i2 = i;
            z2 = z;
        }
        if (z2) {
            ArrayList arrayList8 = arrayList4;
            String str13 = str2;
            String str14 = new String(charArray, i2, i3 - i2);
            boolean add4 = arrayList8.add(str13);
        }
        return (String[]) arrayList4.toArray(new String[arrayList4.size()]);
    }
}

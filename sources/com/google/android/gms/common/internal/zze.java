package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zze {
    public static final zze zzakF = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(8192, 8202));
    public static final zze zzakG = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(8192, 8198)).zza(zza(8200, 8202));
    public static final zze zzakH = zza(0, 127);
    public static final zze zzakI;
    public static final zze zzakJ = zza(9, 13).zza(zza(28, ' ')).zza(zzc(5760)).zza(zzc(6158)).zza(zza(8192, 8198)).zza(zza(8200, 8203)).zza(zza(8232, 8233)).zza(zzc(8287)).zza(zzc(12288));
    public static final zze zzakK;
    public static final zze zzakL;
    public static final zze zzakM;
    public static final zze zzakN;
    public static final zze zzakO;
    public static final zze zzakP = zza(0, 31).zza(zza(127, 159));
    public static final zze zzakQ = zza(0, ' ').zza(zza(127, 160)).zza(zzc(173)).zza(zza(1536, 1539)).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(8192, 8207)).zza(zza(8232, 8239)).zza(zza(8287, 8292)).zza(zza(8298, 8303)).zza(zzc(12288)).zza(zza(55296, 63743)).zza(zza((CharSequence) "﻿￹￺￻"));
    public static final zze zzakR = zza(0, 1273).zza(zzc(1470)).zza(zza(1488, 1514)).zza(zzc(1523)).zza(zzc(1524)).zza(zza(1536, 1791)).zza(zza(1872, 1919)).zza(zza(3584, 3711)).zza(zza(7680, 8367)).zza(zza(8448, 8506)).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
    public static final zze zzakS;
    public static final zze zzakT;

    private static class zza extends zze {
        List<zze> zzala;

        zza(List<zze> list) {
            this.zzala = list;
        }

        public zze zza(zze zze) {
            ArrayList arrayList;
            zza zza;
            zze zze2 = zze;
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(this.zzala);
            ArrayList arrayList4 = arrayList2;
            boolean add = arrayList4.add(zzx.zzz(zze2));
            zza zza2 = zza;
            zza zza3 = new zza(arrayList4);
            return zza2;
        }

        public boolean zzd(char c) {
            char c2 = c;
            for (zze zzd : this.zzala) {
                if (zzd.zzd(c2)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        C02391 r10;
        C02455 r102;
        C02466 r103;
        C02477 r104;
        C02488 r105;
        C02499 r106;
        C024010 r107;
        zze zza2 = zza('0', '9');
        char[] charArray = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
        int length = charArray.length;
        zze zze = zza2;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            zze = zze.zza(zza(c, (char) (c + 9)));
        }
        zzakI = zze;
        C02391 r6 = r10;
        C02391 r7 = new zze() {
            public boolean zzd(char c) {
                return Character.isDigit(c);
            }
        };
        zzakK = r6;
        C02455 r62 = r102;
        C02455 r72 = new zze() {
            public boolean zzd(char c) {
                return Character.isLetter(c);
            }
        };
        zzakL = r62;
        C02466 r63 = r103;
        C02466 r73 = new zze() {
            public boolean zzd(char c) {
                return Character.isLetterOrDigit(c);
            }
        };
        zzakM = r63;
        C02477 r64 = r104;
        C02477 r74 = new zze() {
            public boolean zzd(char c) {
                return Character.isUpperCase(c);
            }
        };
        zzakN = r64;
        C02488 r65 = r105;
        C02488 r75 = new zze() {
            public boolean zzd(char c) {
                return Character.isLowerCase(c);
            }
        };
        zzakO = r65;
        C02499 r66 = r106;
        C02499 r76 = new zze() {
            public zze zza(zze zze) {
                Object zzz = zzx.zzz(zze);
                return this;
            }

            public boolean zzb(CharSequence charSequence) {
                Object zzz = zzx.zzz(charSequence);
                return true;
            }

            public boolean zzd(char c) {
                char c2 = c;
                return true;
            }
        };
        zzakS = r66;
        C024010 r67 = r107;
        C024010 r77 = new zze() {
            public zze zza(zze zze) {
                return (zze) zzx.zzz(zze);
            }

            public boolean zzb(CharSequence charSequence) {
                return charSequence.length() == 0;
            }

            public boolean zzd(char c) {
                char c2 = c;
                return false;
            }
        };
        zzakT = r67;
    }

    public zze() {
    }

    public static zze zza(char c, char c2) {
        C02444 r7;
        char c3 = c;
        char c4 = c2;
        zzx.zzac(c4 >= c3);
        C02444 r3 = r7;
        final char c5 = c3;
        final char c6 = c4;
        C02444 r4 = new zze() {
            {
                char c = r7;
            }

            public boolean zzd(char c) {
                char c2 = c;
                return c5 <= c2 && c2 <= c6;
            }
        };
        return r3;
    }

    public static zze zza(CharSequence charSequence) {
        C02422 r7;
        C02433 r72;
        CharSequence charSequence2 = charSequence;
        switch (charSequence2.length()) {
            case 0:
                return zzakT;
            case 1:
                return zzc(charSequence2.charAt(0));
            case 2:
                C02422 r2 = r7;
                final char charAt = charSequence2.charAt(0);
                final char charAt2 = charSequence2.charAt(1);
                C02422 r3 = new zze() {
                    {
                        char c = r7;
                    }

                    public boolean zzd(char c) {
                        char c2 = c;
                        return c2 == charAt || c2 == charAt2;
                    }
                };
                return r2;
            default:
                char[] charArray = charSequence2.toString().toCharArray();
                Arrays.sort(charArray);
                C02433 r22 = r72;
                final char[] cArr = charArray;
                C02433 r32 = new zze() {
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(cArr, c) >= 0;
                    }
                };
                return r22;
        }
    }

    public static zze zzc(char c) {
        C024111 r4;
        C024111 r1 = r4;
        final char c2 = c;
        C024111 r2 = new zze() {
            public zze zza(zze zze) {
                zze zze2 = zze;
                return zze2.zzd(c2) ? zze2 : zze.super.zza(zze2);
            }

            public boolean zzd(char c) {
                return c == c2;
            }
        };
        return r1;
    }

    public zze zza(zze zze) {
        zza zza2;
        zza zza3 = zza2;
        zza zza4 = new zza(Arrays.asList(new zze[]{this, (zze) zzx.zzz(zze)}));
        return zza3;
    }

    public boolean zzb(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        for (int length = -1 + charSequence2.length(); length >= 0; length--) {
            if (!zzd(charSequence2.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}

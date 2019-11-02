package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

public class zzan {
    private static final String[] zzov;
    private String zzor = "googleads.g.doubleclick.net";
    private String zzos = "/pagead/ads";
    private String zzot = "ad.doubleclick.net";
    private String[] zzou;
    private zzaj zzow;

    static {
        String[] strArr = new String[2];
        String[] strArr2 = strArr;
        strArr[0] = "/aclk";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = "/pcs/click";
        zzov = strArr4;
    }

    public zzan(zzaj zzaj) {
        zzaj zzaj2 = zzaj;
        String[] strArr = new String[3];
        String[] strArr2 = strArr;
        strArr[0] = ".doubleclick.net";
        String[] strArr3 = strArr2;
        String[] strArr4 = strArr3;
        strArr3[1] = ".googleadservices.com";
        String[] strArr5 = strArr4;
        String[] strArr6 = strArr5;
        strArr5[2] = ".googlesyndication.com";
        this.zzou = strArr6;
        this.zzow = zzaj2;
    }

    private Uri zza(Uri uri, Context context, String str, boolean z) throws zzao {
        zzao zzao;
        zzao zzao2;
        zzao zzao3;
        Uri uri2 = uri;
        Context context2 = context;
        String str2 = str;
        boolean z2 = z;
        try {
            boolean zza = zza(uri2);
            if (zza) {
                if (uri2.toString().contains("dc_ms=")) {
                    zzao zzao4 = zzao3;
                    zzao zzao5 = new zzao("Parameter already exists: dc_ms");
                    throw zzao4;
                }
            } else if (uri2.getQueryParameter("ms") != null) {
                zzao zzao6 = zzao2;
                zzao zzao7 = new zzao("Query parameter already exists: ms");
                throw zzao6;
            }
            String zzb = z2 ? this.zzow.zzb(context2, str2) : this.zzow.zzb(context2);
            return zza ? zzb(uri2, "dc_ms", zzb) : zza(uri2, "ms", zzb);
        } catch (UnsupportedOperationException e) {
            UnsupportedOperationException unsupportedOperationException = e;
            zzao zzao8 = zzao;
            zzao zzao9 = new zzao("Provided Uri is not in a valid state");
            throw zzao8;
        }
    }

    private Uri zza(Uri uri, String str, String str2) throws UnsupportedOperationException {
        StringBuilder sb;
        Uri uri2 = uri;
        String str3 = str;
        String str4 = str2;
        String uri3 = uri2.toString();
        int indexOf = uri3.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri3.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return uri2.buildUpon().appendQueryParameter(str3, str4).build();
        }
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder(uri3.substring(0, indexOf + 1));
        return Uri.parse(sb2.append(str3).append("=").append(str4).append("&").append(uri3.substring(indexOf + 1)).toString());
    }

    private Uri zzb(Uri uri, String str, String str2) {
        StringBuilder sb;
        StringBuilder sb2;
        Uri uri2 = uri;
        String str3 = str;
        String str4 = str2;
        String uri3 = uri2.toString();
        int indexOf = uri3.indexOf(";adurl");
        if (indexOf != -1) {
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder(uri3.substring(0, indexOf + 1));
            return Uri.parse(sb3.append(str3).append("=").append(str4).append(";").append(uri3.substring(indexOf + 1)).toString());
        }
        String encodedPath = uri2.getEncodedPath();
        int indexOf2 = uri3.indexOf(encodedPath);
        StringBuilder sb5 = sb;
        StringBuilder sb6 = new StringBuilder(uri3.substring(0, indexOf2 + encodedPath.length()));
        return Uri.parse(sb5.append(";").append(str3).append("=").append(str4).append(";").append(uri3.substring(indexOf2 + encodedPath.length())).toString());
    }

    public Uri zza(Uri uri, Context context) throws zzao {
        zzao zzao;
        Uri uri2 = uri;
        try {
            return zza(uri2, context, uri2.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            UnsupportedOperationException unsupportedOperationException = e;
            zzao zzao2 = zzao;
            zzao zzao3 = new zzao("Provided Uri is not in a valid state");
            throw zzao2;
        }
    }

    public void zza(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        this.zzow.zza(motionEvent2);
    }

    public boolean zza(Uri uri) {
        NullPointerException nullPointerException;
        Uri uri2 = uri;
        if (uri2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException();
            throw nullPointerException2;
        }
        try {
            return uri2.getHost().equals(this.zzot);
        } catch (NullPointerException e) {
            NullPointerException nullPointerException4 = e;
            return false;
        }
    }

    public zzaj zzab() {
        return this.zzow;
    }

    public boolean zzb(Uri uri) {
        boolean z;
        NullPointerException nullPointerException;
        Uri uri2 = uri;
        if (uri2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException();
            throw nullPointerException2;
        }
        try {
            String host = uri2.getHost();
            String[] strArr = this.zzou;
            int length = strArr.length;
            int i = 0;
            while (true) {
                z = false;
                if (i >= length) {
                    break;
                } else if (host.endsWith(strArr[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            return z;
        } catch (NullPointerException e) {
            NullPointerException nullPointerException4 = e;
            return false;
        }
    }

    public boolean zzc(Uri uri) {
        Uri uri2 = uri;
        boolean z = false;
        if (zzb(uri2)) {
            String[] strArr = zzov;
            int length = strArr.length;
            int i = 0;
            while (true) {
                z = false;
                if (i >= length) {
                    break;
                }
                if (uri2.getPath().endsWith(strArr[i])) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        return z;
    }
}

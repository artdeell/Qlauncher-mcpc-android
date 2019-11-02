package com.google.android.gms.internal;

import com.ipaulpro.afilechooser.utils.MimeTypeParser;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzhb
class zzhi {
    private final String zzEY;
    private String zzF;
    private int zzGu;
    private final List<String> zzJI;
    private final List<String> zzJJ;
    private final String zzJK;
    private final String zzJL;
    private final String zzJM;
    private final String zzJN;
    private final boolean zzJO;
    private final boolean zzJP;

    public zzhi(int i, Map<String, String> map) {
        int i2 = i;
        Map<String, String> map2 = map;
        this.zzF = (String) map2.get("url");
        this.zzJL = (String) map2.get("base_uri");
        this.zzJM = (String) map2.get("post_parameters");
        this.zzJO = parseBoolean((String) map2.get("drt_include"));
        this.zzJP = parseBoolean((String) map2.get("pan_include"));
        this.zzJK = (String) map2.get("activation_overlay_url");
        this.zzJJ = zzav((String) map2.get("check_packages"));
        this.zzEY = (String) map2.get("request_id");
        this.zzJN = (String) map2.get(MimeTypeParser.TAG_TYPE);
        this.zzJI = zzav((String) map2.get("errors"));
        this.zzGu = i2;
    }

    private static boolean parseBoolean(String str) {
        String str2 = str;
        return str2 != null && (str2.equals("1") || str2.equals("true"));
    }

    private List<String> zzav(String str) {
        String str2 = str;
        if (str2 == null) {
            return null;
        }
        return Arrays.asList(str2.split(","));
    }

    public int getErrorCode() {
        return this.zzGu;
    }

    public String getRequestId() {
        return this.zzEY;
    }

    public String getType() {
        return this.zzJN;
    }

    public String getUrl() {
        return this.zzF;
    }

    public void setUrl(String str) {
        String str2 = str;
        this.zzF = str2;
    }

    public List<String> zzgE() {
        return this.zzJI;
    }

    public String zzgF() {
        return this.zzJM;
    }

    public boolean zzgG() {
        return this.zzJO;
    }

    public boolean zzgH() {
        return this.zzJP;
    }
}

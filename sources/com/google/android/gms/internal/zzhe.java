package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzhn.zza;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzhb
public final class zzhe {
    private static final SimpleDateFormat zzJg;

    static {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyyMMdd", Locale.US);
        zzJg = simpleDateFormat2;
    }

    private static String zzL(int i) {
        int i2 = i;
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i2)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x01f5 A[Catch:{ JSONException -> 0x030e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r88, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r89, java.lang.String r90) {
        /*
            r2 = r88
            r3 = r89
            r4 = r90
            org.json.JSONObject r51 = new org.json.JSONObject     // Catch:{ JSONException -> 0x030e }
            r87 = r51
            r51 = r87
            r52 = r87
            r53 = r4
            r52.<init>(r53)     // Catch:{ JSONException -> 0x030e }
            r5 = r51
            r51 = r5
            java.lang.String r52 = "ad_base_url"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r7 = r51
            r51 = r5
            java.lang.String r52 = "ad_url"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r8 = r51
            r51 = r5
            java.lang.String r52 = "ad_size"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r9 = r51
            r51 = r3
            if (r51 == 0) goto L_0x03c5
            r51 = r3
            r0 = r51
            int r0 = r0.zzHz     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            if (r51 == 0) goto L_0x03c5
            r51 = 1
            r10 = r51
        L_0x004b:
            r51 = r10
            if (r51 == 0) goto L_0x00d4
            r51 = r5
            java.lang.String r52 = "ad_json"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r11 = r51
        L_0x005b:
            r51 = -1
            r12 = r51
            r51 = r5
            java.lang.String r52 = "debug_dialog"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r14 = r51
            r51 = r5
            java.lang.String r52 = "interstitial_timeout"
            boolean r51 = r51.has(r52)     // Catch:{ JSONException -> 0x030e }
            if (r51 == 0) goto L_0x03cb
            r51 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r53 = r5
            java.lang.String r54 = "interstitial_timeout"
            double r53 = r53.getDouble(r54)     // Catch:{ JSONException -> 0x030e }
            double r51 = r51 * r53
            r0 = r51
            long r0 = (long) r0     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r15 = r51
        L_0x008b:
            r51 = r5
            java.lang.String r52 = "orientation"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r17 = r51
            r51 = -1
            r18 = r51
            java.lang.String r51 = "portrait"
            r52 = r17
            boolean r51 = r51.equals(r52)     // Catch:{ JSONException -> 0x030e }
            if (r51 == 0) goto L_0x00e2
            com.google.android.gms.internal.zzis r51 = com.google.android.gms.ads.internal.zzr.zzbE()     // Catch:{ JSONException -> 0x030e }
            int r51 = r51.zzhw()     // Catch:{ JSONException -> 0x030e }
            r18 = r51
        L_0x00af:
            r51 = r11
            boolean r51 = android.text.TextUtils.isEmpty(r51)     // Catch:{ JSONException -> 0x030e }
            if (r51 != 0) goto L_0x00f7
            r51 = r7
            boolean r51 = android.text.TextUtils.isEmpty(r51)     // Catch:{ JSONException -> 0x030e }
            if (r51 == 0) goto L_0x03bb
            java.lang.String r51 = "Could not parse the mediation config: Missing required ad_base_url field"
            com.google.android.gms.internal.zzin.zzaK(r51)     // Catch:{ JSONException -> 0x030e }
            com.google.android.gms.ads.internal.request.AdResponseParcel r51 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x030e }
            r87 = r51
            r51 = r87
            r52 = r87
            r53 = 0
            r52.<init>(r53)     // Catch:{ JSONException -> 0x030e }
            r2 = r51
        L_0x00d3:
            return r2
        L_0x00d4:
            r51 = r5
            java.lang.String r52 = "ad_html"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r11 = r51
            goto L_0x005b
        L_0x00e2:
            java.lang.String r51 = "landscape"
            r52 = r17
            boolean r51 = r51.equals(r52)     // Catch:{ JSONException -> 0x030e }
            if (r51 == 0) goto L_0x00af
            com.google.android.gms.internal.zzis r51 = com.google.android.gms.ads.internal.zzr.zzbE()     // Catch:{ JSONException -> 0x030e }
            int r51 = r51.zzhv()     // Catch:{ JSONException -> 0x030e }
            r18 = r51
            goto L_0x00af
        L_0x00f7:
            r51 = r8
            boolean r51 = android.text.TextUtils.isEmpty(r51)     // Catch:{ JSONException -> 0x030e }
            if (r51 != 0) goto L_0x0344
            r51 = r3
            r52 = r2
            r53 = r3
            r0 = r53
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r0.zzrl     // Catch:{ JSONException -> 0x030e }
            r53 = r0
            r0 = r53
            java.lang.String r0 = r0.afmaVersion     // Catch:{ JSONException -> 0x030e }
            r53 = r0
            r54 = r8
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            com.google.android.gms.ads.internal.request.AdResponseParcel r51 = com.google.android.gms.internal.zzhd.zza(r51, r52, r53, r54, r55, r56, r57, r58, r59)     // Catch:{ JSONException -> 0x030e }
            r21 = r51
            r51 = r21
            r0 = r51
            java.lang.String r0 = r0.zzEF     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r7 = r51
            r51 = r21
            r0 = r51
            java.lang.String r0 = r0.body     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r22 = r51
            r51 = r21
            r0 = r51
            long r0 = r0.zzHX     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r12 = r51
        L_0x0141:
            r51 = r5
            java.lang.String r52 = "click_urls"
            org.json.JSONArray r51 = r51.optJSONArray(r52)     // Catch:{ JSONException -> 0x030e }
            r23 = r51
            r51 = r21
            if (r51 != 0) goto L_0x0391
            r51 = 0
            r24 = r51
        L_0x0153:
            r51 = r23
            if (r51 == 0) goto L_0x0161
            r51 = r23
            r52 = r24
            java.util.List r51 = zza(r51, r52)     // Catch:{ JSONException -> 0x030e }
            r24 = r51
        L_0x0161:
            r51 = r5
            java.lang.String r52 = "impression_urls"
            org.json.JSONArray r51 = r51.optJSONArray(r52)     // Catch:{ JSONException -> 0x030e }
            r25 = r51
            r51 = r21
            if (r51 != 0) goto L_0x039d
            r51 = 0
            r26 = r51
        L_0x0173:
            r51 = r25
            if (r51 == 0) goto L_0x0181
            r51 = r25
            r52 = r26
            java.util.List r51 = zza(r51, r52)     // Catch:{ JSONException -> 0x030e }
            r26 = r51
        L_0x0181:
            r51 = r5
            java.lang.String r52 = "manual_impression_urls"
            org.json.JSONArray r51 = r51.optJSONArray(r52)     // Catch:{ JSONException -> 0x030e }
            r27 = r51
            r51 = r21
            if (r51 != 0) goto L_0x03a9
            r51 = 0
            r28 = r51
        L_0x0193:
            r51 = r27
            if (r51 == 0) goto L_0x01a1
            r51 = r27
            r52 = r28
            java.util.List r51 = zza(r51, r52)     // Catch:{ JSONException -> 0x030e }
            r28 = r51
        L_0x01a1:
            r51 = r21
            if (r51 == 0) goto L_0x03b5
            r51 = r21
            r0 = r51
            int r0 = r0.orientation     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r52 = -1
            r0 = r51
            r1 = r52
            if (r0 == r1) goto L_0x01bf
            r51 = r21
            r0 = r51
            int r0 = r0.orientation     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r18 = r51
        L_0x01bf:
            r51 = r21
            r0 = r51
            long r0 = r0.zzHS     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r53 = 0
            int r51 = (r51 > r53 ? 1 : (r51 == r53 ? 0 : -1))
            if (r51 <= 0) goto L_0x03b5
            r51 = r21
            r0 = r51
            long r0 = r0.zzHS     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r29 = r51
        L_0x01d7:
            r51 = r5
            java.lang.String r52 = "active_view"
            java.lang.String r51 = r51.optString(r52)     // Catch:{ JSONException -> 0x030e }
            r31 = r51
            r51 = r5
            java.lang.String r52 = "ad_is_javascript"
            r53 = 0
            boolean r51 = r51.optBoolean(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r32 = r51
            r51 = 0
            r33 = r51
            r51 = r32
            if (r51 == 0) goto L_0x0201
            r51 = r5
            java.lang.String r52 = "ad_passback_url"
            r53 = 0
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r33 = r51
        L_0x0201:
            r51 = r5
            java.lang.String r52 = "mediation"
            r53 = 0
            boolean r51 = r51.optBoolean(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r34 = r51
            r51 = r5
            java.lang.String r52 = "custom_render_allowed"
            r53 = 0
            boolean r51 = r51.optBoolean(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r35 = r51
            r51 = r5
            java.lang.String r52 = "content_url_opted_out"
            r53 = 1
            boolean r51 = r51.optBoolean(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r36 = r51
            r51 = r5
            java.lang.String r52 = "prefetch"
            r53 = 0
            boolean r51 = r51.optBoolean(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r37 = r51
            r51 = r5
            java.lang.String r52 = "oauth2_token_status"
            r53 = 0
            int r51 = r51.optInt(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r38 = r51
            r51 = r5
            java.lang.String r52 = "refresh_interval_milliseconds"
            r53 = -1
            long r51 = r51.optLong(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r39 = r51
            r51 = r5
            java.lang.String r52 = "mediation_config_cache_time_milliseconds"
            r53 = -1
            long r51 = r51.optLong(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r41 = r51
            r51 = r5
            java.lang.String r52 = "gws_query_id"
            java.lang.String r53 = ""
            java.lang.String r51 = r51.optString(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r43 = r51
            java.lang.String r51 = "height"
            r52 = r5
            java.lang.String r53 = "fluid"
            java.lang.String r54 = ""
            java.lang.String r52 = r52.optString(r53, r54)     // Catch:{ JSONException -> 0x030e }
            boolean r51 = r51.equals(r52)     // Catch:{ JSONException -> 0x030e }
            r44 = r51
            r51 = r5
            java.lang.String r52 = "native_express"
            r53 = 0
            boolean r51 = r51.optBoolean(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r45 = r51
            r51 = r5
            java.lang.String r52 = "video_start_urls"
            org.json.JSONArray r51 = r51.optJSONArray(r52)     // Catch:{ JSONException -> 0x030e }
            r52 = 0
            java.util.List r51 = zza(r51, r52)     // Catch:{ JSONException -> 0x030e }
            r46 = r51
            r51 = r5
            java.lang.String r52 = "video_complete_urls"
            org.json.JSONArray r51 = r51.optJSONArray(r52)     // Catch:{ JSONException -> 0x030e }
            r52 = 0
            java.util.List r51 = zza(r51, r52)     // Catch:{ JSONException -> 0x030e }
            r47 = r51
            r51 = r5
            java.lang.String r52 = "rewards"
            org.json.JSONArray r51 = r51.optJSONArray(r52)     // Catch:{ JSONException -> 0x030e }
            com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel r51 = com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel.zza(r51)     // Catch:{ JSONException -> 0x030e }
            r48 = r51
            r51 = r5
            java.lang.String r52 = "use_displayed_impression"
            r53 = 0
            boolean r51 = r51.optBoolean(r52, r53)     // Catch:{ JSONException -> 0x030e }
            r49 = r51
            com.google.android.gms.ads.internal.request.AdResponseParcel r51 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x030e }
            r87 = r51
            r51 = r87
            r52 = r87
            r53 = r3
            r54 = r7
            r55 = r22
            r56 = r24
            r57 = r26
            r58 = r29
            r60 = r34
            r61 = r41
            r63 = r28
            r64 = r39
            r66 = r18
            r67 = r9
            r68 = r12
            r70 = r14
            r71 = r32
            r72 = r33
            r73 = r31
            r74 = r35
            r75 = r10
            r76 = r3
            r0 = r76
            boolean r0 = r0.zzHB     // Catch:{ JSONException -> 0x030e }
            r76 = r0
            r77 = r36
            r78 = r37
            r79 = r38
            r80 = r43
            r81 = r44
            r82 = r45
            r83 = r48
            r84 = r46
            r85 = r47
            r86 = r49
            r52.<init>(r53, r54, r55, r56, r57, r58, r60, r61, r63, r64, r66, r67, r68, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86)     // Catch:{ JSONException -> 0x030e }
            r50 = r51
            r51 = r50
            r2 = r51
            goto L_0x00d3
        L_0x030e:
            r51 = move-exception
            r6 = r51
            java.lang.StringBuilder r51 = new java.lang.StringBuilder
            r87 = r51
            r51 = r87
            r52 = r87
            r52.<init>()
            java.lang.String r52 = "Could not parse the mediation config: "
            java.lang.StringBuilder r51 = r51.append(r52)
            r52 = r6
            java.lang.String r52 = r52.getMessage()
            java.lang.StringBuilder r51 = r51.append(r52)
            java.lang.String r51 = r51.toString()
            com.google.android.gms.internal.zzin.zzaK(r51)
            com.google.android.gms.ads.internal.request.AdResponseParcel r51 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r87 = r51
            r51 = r87
            r52 = r87
            r53 = 0
            r52.<init>(r53)
            r2 = r51
            goto L_0x00d3
        L_0x0344:
            java.lang.StringBuilder r51 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x030e }
            r87 = r51
            r51 = r87
            r52 = r87
            r52.<init>()     // Catch:{ JSONException -> 0x030e }
            java.lang.String r52 = "Could not parse the mediation config: Missing required "
            java.lang.StringBuilder r51 = r51.append(r52)     // Catch:{ JSONException -> 0x030e }
            r19 = r51
            r51 = r10
            if (r51 == 0) goto L_0x03d1
            java.lang.String r51 = "ad_json"
            r20 = r51
        L_0x035f:
            r51 = r19
            r52 = r20
            java.lang.StringBuilder r51 = r51.append(r52)     // Catch:{ JSONException -> 0x030e }
            java.lang.String r52 = " or "
            java.lang.StringBuilder r51 = r51.append(r52)     // Catch:{ JSONException -> 0x030e }
            java.lang.String r52 = "ad_url"
            java.lang.StringBuilder r51 = r51.append(r52)     // Catch:{ JSONException -> 0x030e }
            java.lang.String r52 = " field."
            java.lang.StringBuilder r51 = r51.append(r52)     // Catch:{ JSONException -> 0x030e }
            java.lang.String r51 = r51.toString()     // Catch:{ JSONException -> 0x030e }
            com.google.android.gms.internal.zzin.zzaK(r51)     // Catch:{ JSONException -> 0x030e }
            com.google.android.gms.ads.internal.request.AdResponseParcel r51 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x030e }
            r87 = r51
            r51 = r87
            r52 = r87
            r53 = 0
            r52.<init>(r53)     // Catch:{ JSONException -> 0x030e }
            r2 = r51
            goto L_0x00d3
        L_0x0391:
            r51 = r21
            r0 = r51
            java.util.List<java.lang.String> r0 = r0.zzBQ     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r24 = r51
            goto L_0x0153
        L_0x039d:
            r51 = r21
            r0 = r51
            java.util.List<java.lang.String> r0 = r0.zzBR     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r26 = r51
            goto L_0x0173
        L_0x03a9:
            r51 = r21
            r0 = r51
            java.util.List<java.lang.String> r0 = r0.zzHV     // Catch:{ JSONException -> 0x030e }
            r51 = r0
            r28 = r51
            goto L_0x0193
        L_0x03b5:
            r51 = r15
            r29 = r51
            goto L_0x01d7
        L_0x03bb:
            r51 = r11
            r22 = r51
            r51 = 0
            r21 = r51
            goto L_0x0141
        L_0x03c5:
            r51 = 0
            r10 = r51
            goto L_0x004b
        L_0x03cb:
            r51 = -1
            r15 = r51
            goto L_0x008b
        L_0x03d1:
            java.lang.String r51 = "ad_html"
            r20 = r51
            goto L_0x035f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhe.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List<java.lang.String>] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 8 */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> zza(@android.support.annotation.Nullable org.json.JSONArray r7, @android.support.annotation.Nullable java.util.List<java.lang.String> r8) throws org.json.JSONException {
        /*
            r0 = r7
            r1 = r8
            r3 = r0
            if (r3 != 0) goto L_0x000a
            r3 = 0
            r1 = r3
        L_0x0007:
            r3 = r1
            r0 = r3
            return r0
        L_0x000a:
            r3 = r1
            if (r3 != 0) goto L_0x0016
            java.util.LinkedList r3 = new java.util.LinkedList
            r6 = r3
            r3 = r6
            r4 = r6
            r4.<init>()
            r1 = r3
        L_0x0016:
            r3 = 0
            r2 = r3
        L_0x0018:
            r3 = r2
            r4 = r0
            int r4 = r4.length()
            if (r3 >= r4) goto L_0x0007
            r3 = r1
            r4 = r0
            r5 = r2
            java.lang.String r4 = r4.getString(r5)
            boolean r3 = r3.add(r4)
            int r2 = r2 + 1
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhe.zza(org.json.JSONArray, java.util.List):java.util.List");
    }

    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zzhj zzhj, zza zza, Location location, zzbm zzbm, String str, String str2, List<String> list, Bundle bundle) {
        StringBuilder sb;
        HashMap hashMap;
        StringBuilder sb2;
        JSONObject jSONObject;
        StringBuilder sb3;
        Context context2 = context;
        AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
        zzhj zzhj2 = zzhj;
        zza zza2 = zza;
        Location location2 = location;
        zzbm zzbm2 = zzbm;
        String str3 = str;
        String str4 = str2;
        List<String> list2 = list;
        Bundle bundle2 = bundle;
        try {
            HashMap hashMap2 = hashMap;
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = hashMap2;
            if (list2.size() > 0) {
                Object put = hashMap4.put("eid", TextUtils.join(",", list2));
            }
            if (adRequestInfoParcel2.zzHs != null) {
                Object put2 = hashMap4.put("ad_pos", adRequestInfoParcel2.zzHs);
            }
            zza(hashMap4, adRequestInfoParcel2.zzHt);
            Object put3 = hashMap4.put("format", adRequestInfoParcel2.zzrp.zzuh);
            if (adRequestInfoParcel2.zzrp.width == -1) {
                Object put4 = hashMap4.put("smart_w", "full");
            }
            if (adRequestInfoParcel2.zzrp.height == -2) {
                Object put5 = hashMap4.put("smart_h", "auto");
            }
            if (adRequestInfoParcel2.zzrp.zzul) {
                Object put6 = hashMap4.put("fluid", "height");
            }
            if (adRequestInfoParcel2.zzrp.zzuj != null) {
                StringBuilder sb4 = sb3;
                StringBuilder sb5 = new StringBuilder();
                StringBuilder sb6 = sb4;
                AdSizeParcel[] adSizeParcelArr = adRequestInfoParcel2.zzrp.zzuj;
                int length = adSizeParcelArr.length;
                for (int i = 0; i < length; i++) {
                    AdSizeParcel adSizeParcel = adSizeParcelArr[i];
                    if (sb6.length() != 0) {
                        StringBuilder append = sb6.append("|");
                    }
                    StringBuilder append2 = sb6.append(adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / zzhj2.zzHF) : adSizeParcel.width);
                    StringBuilder append3 = sb6.append("x");
                    StringBuilder append4 = sb6.append(adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / zzhj2.zzHF) : adSizeParcel.height);
                }
                Object put7 = hashMap4.put("sz", sb6);
            }
            if (adRequestInfoParcel2.zzHz != 0) {
                Object put8 = hashMap4.put("native_version", Integer.valueOf(adRequestInfoParcel2.zzHz));
                if (!adRequestInfoParcel2.zzrp.zzum) {
                    Object put9 = hashMap4.put("native_templates", adRequestInfoParcel2.zzrH);
                    Object put10 = hashMap4.put("native_image_orientation", zzc(adRequestInfoParcel2.zzrD));
                    if (!adRequestInfoParcel2.zzHK.isEmpty()) {
                        Object put11 = hashMap4.put("native_custom_templates", adRequestInfoParcel2.zzHK);
                    }
                }
            }
            Object put12 = hashMap4.put("slotname", adRequestInfoParcel2.zzrj);
            Object put13 = hashMap4.put("pn", adRequestInfoParcel2.applicationInfo.packageName);
            if (adRequestInfoParcel2.zzHu != null) {
                Object put14 = hashMap4.put("vc", Integer.valueOf(adRequestInfoParcel2.zzHu.versionCode));
            }
            Object put15 = hashMap4.put("ms", str4);
            Object put16 = hashMap4.put("seq_num", adRequestInfoParcel2.zzHw);
            Object put17 = hashMap4.put("session_id", adRequestInfoParcel2.zzHx);
            Object put18 = hashMap4.put("js", adRequestInfoParcel2.zzrl.afmaVersion);
            zza(hashMap4, zzhj2, zza2);
            Object put19 = hashMap4.put("platform", Build.MANUFACTURER);
            Object put20 = hashMap4.put("submodel", Build.MODEL);
            if (adRequestInfoParcel2.zzHt.versionCode >= 2 && adRequestInfoParcel2.zzHt.zztK != null) {
                zza(hashMap4, adRequestInfoParcel2.zzHt.zztK);
            }
            if (adRequestInfoParcel2.versionCode >= 2) {
                Object put21 = hashMap4.put("quality_signals", adRequestInfoParcel2.zzHy);
            }
            if (adRequestInfoParcel2.versionCode >= 4 && adRequestInfoParcel2.zzHB) {
                Object put22 = hashMap4.put("forceHttps", Boolean.valueOf(adRequestInfoParcel2.zzHB));
            }
            if (bundle2 != null) {
                Object put23 = hashMap4.put("content_info", bundle2);
            }
            if (adRequestInfoParcel2.versionCode >= 5) {
                Object put24 = hashMap4.put("u_sd", Float.valueOf(adRequestInfoParcel2.zzHF));
                Object put25 = hashMap4.put("sh", Integer.valueOf(adRequestInfoParcel2.zzHE));
                Object put26 = hashMap4.put("sw", Integer.valueOf(adRequestInfoParcel2.zzHD));
            } else {
                Object put27 = hashMap4.put("u_sd", Float.valueOf(zzhj2.zzHF));
                Object put28 = hashMap4.put("sh", Integer.valueOf(zzhj2.zzHE));
                Object put29 = hashMap4.put("sw", Integer.valueOf(zzhj2.zzHD));
            }
            if (adRequestInfoParcel2.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel2.zzHG)) {
                    HashMap hashMap5 = hashMap4;
                    String str5 = "view_hierarchy";
                    try {
                        JSONObject jSONObject2 = jSONObject;
                        JSONObject jSONObject3 = new JSONObject(adRequestInfoParcel2.zzHG);
                        Object put30 = hashMap5.put(str5, jSONObject2);
                    } catch (JSONException e) {
                        zzin.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                Object put31 = hashMap4.put("correlation_id", Long.valueOf(adRequestInfoParcel2.zzHH));
            }
            if (adRequestInfoParcel2.versionCode >= 7) {
                Object put32 = hashMap4.put("request_id", adRequestInfoParcel2.zzHI);
            }
            if (adRequestInfoParcel2.versionCode >= 11 && adRequestInfoParcel2.zzHM != null) {
                Object put33 = hashMap4.put("capability", adRequestInfoParcel2.zzHM.toBundle());
            }
            zza(hashMap4, str3);
            if (adRequestInfoParcel2.versionCode >= 12 && !TextUtils.isEmpty(adRequestInfoParcel2.zzHN)) {
                Object put34 = hashMap4.put("anchor", adRequestInfoParcel2.zzHN);
            }
            if (adRequestInfoParcel2.versionCode >= 13) {
                Object put35 = hashMap4.put("avol", Float.valueOf(adRequestInfoParcel2.zzHO));
            }
            if (adRequestInfoParcel2.versionCode >= 14 && adRequestInfoParcel2.zzHP > 0) {
                Object put36 = hashMap4.put("target_api", Integer.valueOf(adRequestInfoParcel2.zzHP));
            }
            if (adRequestInfoParcel2.versionCode >= 15) {
                Object put37 = hashMap4.put("scroll_index", Integer.valueOf(adRequestInfoParcel2.zzHQ == -1 ? -1 : adRequestInfoParcel2.zzHQ));
            }
            if (zzin.zzQ(2)) {
                String jSONObject4 = zzr.zzbC().zzG(hashMap4).toString(2);
                StringBuilder sb7 = sb2;
                StringBuilder sb8 = new StringBuilder();
                zzin.m20v(sb7.append("Ad Request JSON: ").append(jSONObject4).toString());
            }
            return zzr.zzbC().zzG(hashMap4);
        } catch (JSONException e2) {
            JSONException jSONException = e2;
            StringBuilder sb9 = sb;
            StringBuilder sb10 = new StringBuilder();
            zzin.zzaK(sb9.append("Problem serializing ad request to JSON: ").append(jSONException.getMessage()).toString());
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2;
        HashMap<String, Object> hashMap3 = hashMap;
        Location location2 = location;
        HashMap hashMap4 = hashMap2;
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = hashMap4;
        Float valueOf = Float.valueOf(1000.0f * location2.getAccuracy());
        Long valueOf2 = Long.valueOf(1000 * location2.getTime());
        Long valueOf3 = Long.valueOf((long) (1.0E7d * location2.getLatitude()));
        Long valueOf4 = Long.valueOf((long) (1.0E7d * location2.getLongitude()));
        Object put = hashMap6.put("radius", valueOf);
        Object put2 = hashMap6.put("lat", valueOf3);
        Object put3 = hashMap6.put("long", valueOf4);
        Object put4 = hashMap6.put("time", valueOf2);
        Object put5 = hashMap3.put("uule", hashMap6);
    }

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        Date date;
        HashMap<String, Object> hashMap2 = hashMap;
        AdRequestParcel adRequestParcel2 = adRequestParcel;
        String zzhm = zzil.zzhm();
        if (zzhm != null) {
            Object put = hashMap2.put("abf", zzhm);
        }
        if (adRequestParcel2.zztC != -1) {
            SimpleDateFormat simpleDateFormat = zzJg;
            Date date2 = date;
            Date date3 = new Date(adRequestParcel2.zztC);
            Object put2 = hashMap2.put("cust_age", simpleDateFormat.format(date2));
        }
        if (adRequestParcel2.extras != null) {
            Object put3 = hashMap2.put("extras", adRequestParcel2.extras);
        }
        if (adRequestParcel2.zztD != -1) {
            Object put4 = hashMap2.put("cust_gender", Integer.valueOf(adRequestParcel2.zztD));
        }
        if (adRequestParcel2.zztE != null) {
            Object put5 = hashMap2.put("kw", adRequestParcel2.zztE);
        }
        if (adRequestParcel2.zztG != -1) {
            Object put6 = hashMap2.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel2.zztG));
        }
        if (adRequestParcel2.zztF) {
            Object put7 = hashMap2.put("adtest", "on");
        }
        if (adRequestParcel2.versionCode >= 2) {
            if (adRequestParcel2.zztH) {
                Object put8 = hashMap2.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(adRequestParcel2.zztI)) {
                Object put9 = hashMap2.put("ppid", adRequestParcel2.zztI);
            }
            if (adRequestParcel2.zztJ != null) {
                zza(hashMap2, adRequestParcel2.zztJ);
            }
        }
        if (adRequestParcel2.versionCode >= 3 && adRequestParcel2.zztL != null) {
            Object put10 = hashMap2.put("url", adRequestParcel2.zztL);
        }
        if (adRequestParcel2.versionCode >= 5) {
            if (adRequestParcel2.zztN != null) {
                Object put11 = hashMap2.put("custom_targeting", adRequestParcel2.zztN);
            }
            if (adRequestParcel2.zztO != null) {
                Object put12 = hashMap2.put("category_exclusions", adRequestParcel2.zztO);
            }
            if (adRequestParcel2.zztP != null) {
                Object put13 = hashMap2.put("request_agent", adRequestParcel2.zztP);
            }
        }
        if (adRequestParcel2.versionCode >= 6 && adRequestParcel2.zztQ != null) {
            Object put14 = hashMap2.put("request_pkg", adRequestParcel2.zztQ);
        }
        if (adRequestParcel2.versionCode >= 7) {
            Object put15 = hashMap2.put("is_designed_for_families", Boolean.valueOf(adRequestParcel2.zztR));
        }
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        HashMap<String, Object> hashMap2 = hashMap;
        SearchAdRequestParcel searchAdRequestParcel2 = searchAdRequestParcel;
        if (Color.alpha(searchAdRequestParcel2.zzvd) != 0) {
            Object put = hashMap2.put("acolor", zzL(searchAdRequestParcel2.zzvd));
        }
        if (Color.alpha(searchAdRequestParcel2.backgroundColor) != 0) {
            Object put2 = hashMap2.put("bgcolor", zzL(searchAdRequestParcel2.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel2.zzve) == 0 || Color.alpha(searchAdRequestParcel2.zzvf) == 0)) {
            Object put3 = hashMap2.put("gradientto", zzL(searchAdRequestParcel2.zzve));
            Object put4 = hashMap2.put("gradientfrom", zzL(searchAdRequestParcel2.zzvf));
        }
        if (Color.alpha(searchAdRequestParcel2.zzvg) != 0) {
            Object put5 = hashMap2.put("bcolor", zzL(searchAdRequestParcel2.zzvg));
        }
        Object put6 = hashMap2.put("bthick", Integer.toString(searchAdRequestParcel2.zzvh));
        switch (searchAdRequestParcel2.zzvi) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            Object put7 = hashMap2.put("btype", str);
        }
        String str2 = null;
        switch (searchAdRequestParcel2.zzvj) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            Object put8 = hashMap2.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel2.zzvk != null) {
            Object put9 = hashMap2.put("channel", searchAdRequestParcel2.zzvk);
        }
        if (Color.alpha(searchAdRequestParcel2.zzvl) != 0) {
            Object put10 = hashMap2.put("dcolor", zzL(searchAdRequestParcel2.zzvl));
        }
        if (searchAdRequestParcel2.zzvm != null) {
            Object put11 = hashMap2.put("font", searchAdRequestParcel2.zzvm);
        }
        if (Color.alpha(searchAdRequestParcel2.zzvn) != 0) {
            Object put12 = hashMap2.put("hcolor", zzL(searchAdRequestParcel2.zzvn));
        }
        Object put13 = hashMap2.put("headersize", Integer.toString(searchAdRequestParcel2.zzvo));
        if (searchAdRequestParcel2.zzvp != null) {
            Object put14 = hashMap2.put("q", searchAdRequestParcel2.zzvp);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzhj zzhj, zza zza) {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        HashMap<String, Object> hashMap2 = hashMap;
        zzhj zzhj2 = zzhj;
        zza zza2 = zza;
        Object put = hashMap2.put("am", Integer.valueOf(zzhj2.zzJQ));
        Object put2 = hashMap2.put("cog", zzy(zzhj2.zzJR));
        Object put3 = hashMap2.put("coh", zzy(zzhj2.zzJS));
        if (!TextUtils.isEmpty(zzhj2.zzJT)) {
            Object put4 = hashMap2.put("carrier", zzhj2.zzJT);
        }
        Object put5 = hashMap2.put("gl", zzhj2.zzJU);
        if (zzhj2.zzJV) {
            Object put6 = hashMap2.put("simulator", Integer.valueOf(1));
        }
        if (zzhj2.zzJW) {
            Object put7 = hashMap2.put("is_sidewinder", Integer.valueOf(1));
        }
        Object put8 = hashMap2.put("ma", zzy(zzhj2.zzJX));
        Object put9 = hashMap2.put("sp", zzy(zzhj2.zzJY));
        Object put10 = hashMap2.put("hl", zzhj2.zzJZ);
        if (!TextUtils.isEmpty(zzhj2.zzKa)) {
            Object put11 = hashMap2.put("mv", zzhj2.zzKa);
        }
        Object put12 = hashMap2.put("muv", Integer.valueOf(zzhj2.zzKb));
        if (zzhj2.zzKc != -2) {
            Object put13 = hashMap2.put("cnt", Integer.valueOf(zzhj2.zzKc));
        }
        Object put14 = hashMap2.put("gnt", Integer.valueOf(zzhj2.zzKd));
        Object put15 = hashMap2.put("pt", Integer.valueOf(zzhj2.zzKe));
        Object put16 = hashMap2.put("rm", Integer.valueOf(zzhj2.zzKf));
        Object put17 = hashMap2.put("riv", Integer.valueOf(zzhj2.zzKg));
        Bundle bundle5 = bundle;
        Bundle bundle6 = new Bundle();
        Bundle bundle7 = bundle5;
        bundle7.putString("build", zzhj2.zzKl);
        Bundle bundle8 = bundle2;
        Bundle bundle9 = new Bundle();
        Bundle bundle10 = bundle8;
        bundle10.putBoolean("is_charging", zzhj2.zzKi);
        bundle10.putDouble("battery_level", zzhj2.zzKh);
        bundle7.putBundle("battery", bundle10);
        Bundle bundle11 = bundle3;
        Bundle bundle12 = new Bundle();
        Bundle bundle13 = bundle11;
        bundle13.putInt("active_network_state", zzhj2.zzKk);
        bundle13.putBoolean("active_network_metered", zzhj2.zzKj);
        if (zza2 != null) {
            Bundle bundle14 = bundle4;
            Bundle bundle15 = new Bundle();
            Bundle bundle16 = bundle14;
            bundle16.putInt("predicted_latency_micros", zza2.zzKq);
            bundle16.putLong("predicted_down_throughput_bps", zza2.zzKr);
            bundle16.putLong("predicted_up_throughput_bps", zza2.zzKs);
            bundle13.putBundle("predictions", bundle16);
        }
        bundle7.putBundle("network", bundle13);
        Object put18 = hashMap2.put("device", bundle7);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        HashMap hashMap2;
        HashMap<String, Object> hashMap3 = hashMap;
        String str2 = str;
        if (str2 != null) {
            HashMap hashMap4 = hashMap2;
            HashMap hashMap5 = new HashMap();
            HashMap hashMap6 = hashMap4;
            Object put = hashMap6.put("token", str2);
            Object put2 = hashMap3.put("pan", hashMap6);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        NativeAdOptionsParcel nativeAdOptionsParcel2 = nativeAdOptionsParcel;
        switch (nativeAdOptionsParcel2 != null ? nativeAdOptionsParcel2.zzyB : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    public static JSONObject zzc(AdResponseParcel adResponseParcel) throws JSONException {
        JSONObject jSONObject;
        AdResponseParcel adResponseParcel2 = adResponseParcel;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = jSONObject2;
        if (adResponseParcel2.zzEF != null) {
            JSONObject put = jSONObject4.put("ad_base_url", adResponseParcel2.zzEF);
        }
        if (adResponseParcel2.zzHW != null) {
            JSONObject put2 = jSONObject4.put("ad_size", adResponseParcel2.zzHW);
        }
        JSONObject put3 = jSONObject4.put("native", adResponseParcel2.zzuk);
        if (adResponseParcel2.zzuk) {
            JSONObject put4 = jSONObject4.put("ad_json", adResponseParcel2.body);
        } else {
            JSONObject put5 = jSONObject4.put("ad_html", adResponseParcel2.body);
        }
        if (adResponseParcel2.zzHY != null) {
            JSONObject put6 = jSONObject4.put("debug_dialog", adResponseParcel2.zzHY);
        }
        if (adResponseParcel2.zzHS != -1) {
            JSONObject put7 = jSONObject4.put("interstitial_timeout", ((double) adResponseParcel2.zzHS) / 1000.0d);
        }
        if (adResponseParcel2.orientation == zzr.zzbE().zzhw()) {
            JSONObject put8 = jSONObject4.put("orientation", "portrait");
        } else if (adResponseParcel2.orientation == zzr.zzbE().zzhv()) {
            JSONObject put9 = jSONObject4.put("orientation", "landscape");
        }
        if (adResponseParcel2.zzBQ != null) {
            JSONObject put10 = jSONObject4.put("click_urls", zzi(adResponseParcel2.zzBQ));
        }
        if (adResponseParcel2.zzBR != null) {
            JSONObject put11 = jSONObject4.put("impression_urls", zzi(adResponseParcel2.zzBR));
        }
        if (adResponseParcel2.zzHV != null) {
            JSONObject put12 = jSONObject4.put("manual_impression_urls", zzi(adResponseParcel2.zzHV));
        }
        if (adResponseParcel2.zzIb != null) {
            JSONObject put13 = jSONObject4.put("active_view", adResponseParcel2.zzIb);
        }
        JSONObject put14 = jSONObject4.put("ad_is_javascript", adResponseParcel2.zzHZ);
        if (adResponseParcel2.zzIa != null) {
            JSONObject put15 = jSONObject4.put("ad_passback_url", adResponseParcel2.zzIa);
        }
        JSONObject put16 = jSONObject4.put("mediation", adResponseParcel2.zzHT);
        JSONObject put17 = jSONObject4.put("custom_render_allowed", adResponseParcel2.zzIc);
        JSONObject put18 = jSONObject4.put("content_url_opted_out", adResponseParcel2.zzId);
        JSONObject put19 = jSONObject4.put("prefetch", adResponseParcel2.zzIe);
        JSONObject put20 = jSONObject4.put("oauth2_token_status", adResponseParcel2.zzIf);
        if (adResponseParcel2.zzBU != -1) {
            JSONObject put21 = jSONObject4.put("refresh_interval_milliseconds", adResponseParcel2.zzBU);
        }
        if (adResponseParcel2.zzHU != -1) {
            JSONObject put22 = jSONObject4.put("mediation_config_cache_time_milliseconds", adResponseParcel2.zzHU);
        }
        if (!TextUtils.isEmpty(adResponseParcel2.zzIi)) {
            JSONObject put23 = jSONObject4.put("gws_query_id", adResponseParcel2.zzIi);
        }
        JSONObject put24 = jSONObject4.put("fluid", adResponseParcel2.zzul ? "height" : LibrariesRepository.MOJANG_MAVEN_REPO);
        JSONObject put25 = jSONObject4.put("native_express", adResponseParcel2.zzum);
        if (adResponseParcel2.zzIk != null) {
            JSONObject put26 = jSONObject4.put("video_start_urls", zzi(adResponseParcel2.zzIk));
        }
        if (adResponseParcel2.zzIl != null) {
            JSONObject put27 = jSONObject4.put("video_complete_urls", zzi(adResponseParcel2.zzIl));
        }
        if (adResponseParcel2.zzIj != null) {
            JSONObject put28 = jSONObject4.put("rewards", adResponseParcel2.zzIj.zzgR());
        }
        JSONObject put29 = jSONObject4.put("use_displayed_impression", adResponseParcel2.zzIm);
        return jSONObject4;
    }

    @Nullable
    static JSONArray zzi(List<String> list) throws JSONException {
        JSONArray jSONArray;
        List<String> list2 = list;
        JSONArray jSONArray2 = jSONArray;
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = jSONArray2;
        for (String put : list2) {
            JSONArray put2 = jSONArray4.put(put);
        }
        return jSONArray4;
    }

    private static Integer zzy(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}

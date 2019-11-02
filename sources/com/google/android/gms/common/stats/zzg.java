package com.google.android.gms.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import net.zhuoweizhang.boardwalk.LibrariesRepository;

public class zzg {
    public static String zza(WakeLock wakeLock, String str) {
        StringBuilder sb;
        WakeLock wakeLock2 = wakeLock;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder append = sb2.append(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock2))));
        if (TextUtils.isEmpty(str2)) {
            str2 = LibrariesRepository.MOJANG_MAVEN_REPO;
        }
        return append.append(str2).toString();
    }
}

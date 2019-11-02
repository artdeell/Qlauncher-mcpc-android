package net.zhuoweizhang.boardwalk.model;

import java.util.Map;

public class MinecraftVersionList {
    public static final String TYPE_OLD_ALPHA = "old_alpha";
    public static final String TYPE_OLD_BETA = "old_beta";
    public static final String TYPE_RELEASE = "release";
    public static final String TYPE_SNAPSHOT = "snapshot";
    public Map<String, String> latest;
    public Version[] versions;

    public static class Version {

        /* renamed from: id */
        public String f184id;
        public String releaseTime;
        public String time;
        public String type;

        public Version() {
        }
    }

    public MinecraftVersionList() {
    }
}

package net.zhuoweizhang.boardwalk.model;

import net.zhuoweizhang.boardwalk.model.MinecraftVersionList.Version;

public class MinecraftVersion extends Version {
    public String assets;
    public DependentLibrary[] libraries;
    public String mainClass;
    public String minecraftArguments;
    public int minimumLauncherVersion;

    public MinecraftVersion() {
    }
}

package net.minecraft.client;

import net.zhuoweizhang.boardwalk.downloader.DownloadUtils;

public class ClientBrandRetriever {
    public ClientBrandRetriever() {
    }

    public static String getClientModName() {
        return DownloadUtils.USER_AGENT;
    }
}

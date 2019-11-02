package com.kdtmarken.mojangauth.yggdrasil;

import java.util.UUID;

public class RefreshRequest {
    public String accessToken;
    public UUID clientToken;

    public RefreshRequest(String str, UUID uuid) {
        UUID uuid2 = uuid;
        this.accessToken = str;
        this.clientToken = uuid2;
    }
}

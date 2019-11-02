package com.kdtmarken.mojangauth.yggdrasil;

import java.util.UUID;

public class RefreshResponse {
    public String accessToken;
    public UUID clientToken;
    public Profile selectedProfile;

    public RefreshResponse() {
    }
}

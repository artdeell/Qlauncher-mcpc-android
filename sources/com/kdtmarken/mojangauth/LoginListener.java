package com.kdtmarken.mojangauth;

public interface LoginListener {
    void onBeforeLogin();

    void onLoginDone(String[] strArr);
}

package com.kdtmarken.mojangauth;

public interface RefreshListener {
    void onException(Exception exc);

    void onRefreshDone(boolean z, String str);
}

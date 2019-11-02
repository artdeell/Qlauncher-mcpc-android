package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;

public final class DexException extends ExceptionWithContext {
    public DexException(String str) {
        super(str);
    }

    public DexException(Throwable th) {
        super(th);
    }
}

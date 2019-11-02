package net.zhuoweizhang.boardwalk.com.android.p003dx.p006io.instructions;

import java.io.EOFException;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.io.instructions.CodeInput */
public interface CodeInput extends CodeCursor {
    boolean hasMore();

    int read() throws EOFException;

    int readInt() throws EOFException;

    long readLong() throws EOFException;
}

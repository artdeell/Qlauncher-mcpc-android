package net.zhuoweizhang.boardwalk.com.android.p003dx.util;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.util.IntSet */
public interface IntSet {
    void add(int i);

    int elements();

    boolean has(int i);

    IntIterator iterator();

    void merge(IntSet intSet);

    void remove(int i);
}

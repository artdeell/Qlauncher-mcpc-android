package net.zhuoweizhang.makeshift.java.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<E> extends java.util.PriorityQueue<E> {
    private List<E> backingList;
    private int currentIndex = 0;

    public PriorityQueue(int i, Comparator<? super E> comparator) {
        ArrayList arrayList;
        int i2 = i;
        super(1, comparator);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(i2);
        this.backingList = arrayList2;
    }

    public boolean add(E e) {
        return this.backingList.add(e);
    }

    public boolean isEmpty() {
        return this.currentIndex >= this.backingList.size();
    }

    public E remove() {
        int i = this.currentIndex;
        this.currentIndex = i + 1;
        return this.backingList.get(i);
    }
}

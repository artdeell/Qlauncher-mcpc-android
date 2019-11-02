package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MixedItemSection */
public final class MixedItemSection extends Section {
    private static final Comparator<OffsettedItem> TYPE_SORTER;
    private final HashMap<OffsettedItem, OffsettedItem> interns;
    private final ArrayList<OffsettedItem> items;
    private final SortType sort;
    private int writeSize = -1;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MixedItemSection$SortType */
    enum SortType {
    }

    static {
        C06671 r2;
        C06671 r0 = r2;
        C06671 r1 = new Comparator<OffsettedItem>() {
            public int compare(OffsettedItem offsettedItem, OffsettedItem offsettedItem2) {
                return offsettedItem.itemType().compareTo(offsettedItem2.itemType());
            }
        };
        TYPE_SORTER = r0;
    }

    public MixedItemSection(String str, DexFile dexFile, int i, SortType sortType) {
        ArrayList<OffsettedItem> arrayList;
        HashMap<OffsettedItem, OffsettedItem> hashMap;
        SortType sortType2 = sortType;
        super(str, dexFile, i);
        ArrayList<OffsettedItem> arrayList2 = arrayList;
        ArrayList<OffsettedItem> arrayList3 = new ArrayList<>(100);
        this.items = arrayList2;
        HashMap<OffsettedItem, OffsettedItem> hashMap2 = hashMap;
        HashMap<OffsettedItem, OffsettedItem> hashMap3 = new HashMap<>(100);
        this.interns = hashMap2;
        this.sort = sortType2;
    }

    public void add(OffsettedItem offsettedItem) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        OffsettedItem offsettedItem2 = offsettedItem;
        throwIfPrepared();
        try {
            if (offsettedItem2.getAlignment() > getAlignment()) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("incompatible item alignment");
                throw illegalArgumentException2;
            }
            boolean add = this.items.add(offsettedItem2);
        } catch (NullPointerException e) {
            NullPointerException nullPointerException2 = e;
            NullPointerException nullPointerException3 = nullPointerException;
            NullPointerException nullPointerException4 = new NullPointerException("item == null");
            throw nullPointerException3;
        }
    }

    public <T extends OffsettedItem> T get(T t) {
        NoSuchElementException noSuchElementException;
        T t2 = t;
        throwIfNotPrepared();
        OffsettedItem offsettedItem = (OffsettedItem) this.interns.get(t2);
        if (offsettedItem != null) {
            return offsettedItem;
        }
        NoSuchElementException noSuchElementException2 = noSuchElementException;
        NoSuchElementException noSuchElementException3 = new NoSuchElementException(t2.toString());
        throw noSuchElementException2;
    }

    public int getAbsoluteItemOffset(Item item) {
        return ((OffsettedItem) item).getAbsoluteOffset();
    }

    public <T extends OffsettedItem> T intern(T t) {
        T t2 = t;
        throwIfPrepared();
        OffsettedItem offsettedItem = (OffsettedItem) this.interns.get(t2);
        if (offsettedItem != null) {
            return offsettedItem;
        }
        add(t2);
        Object put = this.interns.put(t2, t2);
        return t2;
    }

    public Collection<? extends Item> items() {
        return this.items;
    }

    public void placeItems() {
        StringBuilder sb;
        RuntimeException runtimeException;
        StringBuilder sb2;
        throwIfNotPrepared();
        switch (this.sort) {
            case INSTANCE:
                Collections.sort(this.items);
                break;
            case TYPE:
                Collections.sort(this.items, TYPE_SORTER);
                break;
        }
        int size = this.items.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            OffsettedItem offsettedItem = (OffsettedItem) this.items.get(i);
            try {
                int place = offsettedItem.place(this, i2);
                if (place < i2) {
                    RuntimeException runtimeException2 = runtimeException;
                    StringBuilder sb3 = sb2;
                    StringBuilder sb4 = new StringBuilder();
                    RuntimeException runtimeException3 = new RuntimeException(sb3.append("bogus place() result for ").append(offsettedItem).toString());
                    throw runtimeException2;
                }
                i2 = place + offsettedItem.writeSize();
                i++;
            } catch (RuntimeException e) {
                RuntimeException runtimeException4 = e;
                StringBuilder sb5 = sb;
                StringBuilder sb6 = new StringBuilder();
                throw ExceptionWithContext.withContext(runtimeException4, sb5.append("...while placing ").append(offsettedItem).toString());
            }
        }
        this.writeSize = i2;
    }

    /* access modifiers changed from: protected */
    public void prepare0() {
        DexFile file = getFile();
        int i = 0;
        while (true) {
            int i2 = i;
            int size = this.items.size();
            if (i2 < size) {
                int i3 = i2;
                while (i3 < size) {
                    ((OffsettedItem) this.items.get(i3)).addContents(file);
                    i3++;
                }
                i = i3;
            } else {
                return;
            }
        }
    }

    public int size() {
        return this.items.size();
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        RuntimeException runtimeException;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        throwIfNotPrepared();
        if (this.writeSize == -1) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("write size not yet set");
            throw runtimeException2;
        }
        int i = this.writeSize;
        int fileOffset = i == 0 ? 0 : getFileOffset();
        String name = getName();
        if (name == null) {
            name = "<unnamed>";
        }
        char[] cArr = new char[(15 - name.length())];
        Arrays.fill(cArr, ' ');
        String str2 = str;
        String str3 = new String(cArr);
        String str4 = str2;
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb3 = sb;
            StringBuilder sb4 = new StringBuilder();
            annotatedOutput3.annotate(4, sb3.append(name).append("_size:").append(str4).append(Hex.m53u4(i)).toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb5 = sb2;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput4.annotate(4, sb5.append(name).append("_off: ").append(str4).append(Hex.m53u4(fileOffset)).toString());
        }
        annotatedOutput2.writeInt(i);
        annotatedOutput2.writeInt(fileOffset);
    }

    public void writeIndexAnnotation(AnnotatedOutput annotatedOutput, ItemType itemType, String str) {
        TreeMap treeMap;
        StringBuilder sb;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        ItemType itemType2 = itemType;
        String str2 = str;
        throwIfNotPrepared();
        TreeMap treeMap2 = treeMap;
        TreeMap treeMap3 = new TreeMap();
        TreeMap treeMap4 = treeMap2;
        Iterator it = this.items.iterator();
        while (it.hasNext()) {
            OffsettedItem offsettedItem = (OffsettedItem) it.next();
            if (offsettedItem.itemType() == itemType2) {
                Object put = treeMap4.put(offsettedItem.toHuman(), offsettedItem);
            }
        }
        if (treeMap4.size() != 0) {
            annotatedOutput2.annotate(0, str2);
            for (Entry entry : treeMap4.entrySet()) {
                String str3 = (String) entry.getKey();
                OffsettedItem offsettedItem2 = (OffsettedItem) entry.getValue();
                AnnotatedOutput annotatedOutput3 = annotatedOutput2;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                annotatedOutput3.annotate(0, sb2.append(offsettedItem2.offsetString()).append(' ').append(str3).append(10).toString());
            }
        }
    }

    public int writeSize() {
        throwIfNotPrepared();
        return this.writeSize;
    }

    /* access modifiers changed from: protected */
    public void writeTo0(AnnotatedOutput annotatedOutput) {
        RuntimeException runtimeException;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean annotates = annotatedOutput2.annotates();
        DexFile file = getFile();
        Iterator it = this.items.iterator();
        int i = 0;
        boolean z = true;
        while (it.hasNext()) {
            OffsettedItem offsettedItem = (OffsettedItem) it.next();
            if (annotates) {
                if (z) {
                    z = false;
                } else {
                    annotatedOutput2.annotate(0, "\n");
                }
            }
            int alignment = -1 + offsettedItem.getAlignment();
            int i2 = (i + alignment) & (alignment ^ -1);
            if (i != i2) {
                annotatedOutput2.writeZeroes(i2 - i);
                i = i2;
            }
            offsettedItem.writeTo(file, annotatedOutput2);
            i += offsettedItem.writeSize();
        }
        if (i != this.writeSize) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("output size mismatch");
            throw runtimeException2;
        }
    }
}

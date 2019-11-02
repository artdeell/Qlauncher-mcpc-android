package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.HashMap;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.Statistics */
public final class Statistics {
    private final HashMap<String, Data> dataMap;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.Statistics$Data */
    private static class Data {
        private int count = 1;
        private int largestSize;
        /* access modifiers changed from: private */
        public final String name;
        private int smallestSize;
        private int totalSize;

        public Data(Item item, String str) {
            String str2 = str;
            int writeSize = item.writeSize();
            this.name = str2;
            this.totalSize = writeSize;
            this.largestSize = writeSize;
            this.smallestSize = writeSize;
        }

        public void add(Item item) {
            int writeSize = item.writeSize();
            this.count = 1 + this.count;
            this.totalSize = writeSize + this.totalSize;
            if (writeSize > this.largestSize) {
                this.largestSize = writeSize;
            }
            if (writeSize < this.smallestSize) {
                this.smallestSize = writeSize;
            }
        }

        public String toHuman() {
            StringBuilder sb;
            StringBuilder sb2;
            StringBuilder sb3;
            StringBuilder sb4;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = sb5;
            StringBuilder sb8 = sb2;
            StringBuilder sb9 = new StringBuilder();
            StringBuilder append = sb7.append(sb8.append("  ").append(this.name).append(": ").append(this.count).append(" item").append(this.count == 1 ? LibrariesRepository.MOJANG_MAVEN_REPO : "s").append("; ").append(this.totalSize).append(" bytes total\n").toString());
            if (this.smallestSize == this.largestSize) {
                StringBuilder sb10 = sb7;
                StringBuilder sb11 = sb4;
                StringBuilder sb12 = new StringBuilder();
                StringBuilder append2 = sb10.append(sb11.append("    ").append(this.smallestSize).append(" bytes/item\n").toString());
            } else {
                int i = this.totalSize / this.count;
                StringBuilder sb13 = sb7;
                StringBuilder sb14 = sb3;
                StringBuilder sb15 = new StringBuilder();
                StringBuilder append3 = sb13.append(sb14.append("    ").append(this.smallestSize).append("..").append(this.largestSize).append(" bytes/item; average ").append(i).append("\n").toString());
            }
            return sb7.toString();
        }

        public void writeAnnotation(AnnotatedOutput annotatedOutput) {
            annotatedOutput.annotate(toHuman());
        }
    }

    public Statistics() {
        HashMap<String, Data> hashMap;
        HashMap<String, Data> hashMap2 = hashMap;
        HashMap<String, Data> hashMap3 = new HashMap<>(50);
        this.dataMap = hashMap2;
    }

    public void add(Item item) {
        Data data;
        Item item2 = item;
        String typeName = item2.typeName();
        Data data2 = (Data) this.dataMap.get(typeName);
        if (data2 == null) {
            HashMap<String, Data> hashMap = this.dataMap;
            String str = typeName;
            Data data3 = data;
            Data data4 = new Data(item2, typeName);
            Object put = hashMap.put(str, data3);
            return;
        }
        data2.add(item2);
    }

    public void addAll(Section section) {
        for (Item add : section.items()) {
            add(add);
        }
    }

    public String toHuman() {
        StringBuilder sb;
        TreeMap treeMap;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append("Statistics:\n");
        TreeMap treeMap2 = treeMap;
        TreeMap treeMap3 = new TreeMap();
        TreeMap treeMap4 = treeMap2;
        for (Data data : this.dataMap.values()) {
            Object put = treeMap4.put(data.name, data);
        }
        for (Data human : treeMap4.values()) {
            StringBuilder append2 = sb4.append(human.toHuman());
        }
        return sb4.toString();
    }

    public final void writeAnnotation(AnnotatedOutput annotatedOutput) {
        TreeMap treeMap;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        if (this.dataMap.size() != 0) {
            annotatedOutput2.annotate(0, "\nstatistics:\n");
            TreeMap treeMap2 = treeMap;
            TreeMap treeMap3 = new TreeMap();
            TreeMap treeMap4 = treeMap2;
            for (Data data : this.dataMap.values()) {
                Object put = treeMap4.put(data.name, data);
            }
            for (Data writeAnnotation : treeMap4.values()) {
                writeAnnotation.writeAnnotation(annotatedOutput2);
            }
        }
    }
}

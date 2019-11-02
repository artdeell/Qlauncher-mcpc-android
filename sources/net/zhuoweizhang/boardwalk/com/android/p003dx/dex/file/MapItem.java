package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.MapItem */
public final class MapItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int WRITE_SIZE = 12;
    private final Item firstItem;
    private final int itemCount;
    private final Item lastItem;
    private final Section section;
    private final ItemType type;

    private MapItem(ItemType itemType, Section section2, Item item, Item item2, int i) {
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        NullPointerException nullPointerException3;
        NullPointerException nullPointerException4;
        ItemType itemType2 = itemType;
        Section section3 = section2;
        Item item3 = item;
        Item item4 = item2;
        int i2 = i;
        super(4, 12);
        if (itemType2 == null) {
            NullPointerException nullPointerException5 = nullPointerException4;
            NullPointerException nullPointerException6 = new NullPointerException("type == null");
            throw nullPointerException5;
        } else if (section3 == null) {
            NullPointerException nullPointerException7 = nullPointerException3;
            NullPointerException nullPointerException8 = new NullPointerException("section == null");
            throw nullPointerException7;
        } else if (item3 == null) {
            NullPointerException nullPointerException9 = nullPointerException2;
            NullPointerException nullPointerException10 = new NullPointerException("firstItem == null");
            throw nullPointerException9;
        } else if (item4 == null) {
            NullPointerException nullPointerException11 = nullPointerException;
            NullPointerException nullPointerException12 = new NullPointerException("lastItem == null");
            throw nullPointerException11;
        } else if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("itemCount <= 0");
            throw illegalArgumentException2;
        } else {
            this.type = itemType2;
            this.section = section3;
            this.firstItem = item3;
            this.lastItem = item4;
            this.itemCount = i2;
        }
    }

    private MapItem(Section section2) {
        NullPointerException nullPointerException;
        Section section3 = section2;
        super(4, 12);
        if (section3 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("section == null");
            throw nullPointerException2;
        }
        this.type = ItemType.TYPE_MAP_LIST;
        this.section = section3;
        this.firstItem = null;
        this.lastItem = null;
        this.itemCount = 1;
    }

    public static void addMap(Section[] sectionArr, MixedItemSection mixedItemSection) {
        ArrayList arrayList;
        UniformListItem uniformListItem;
        MapItem mapItem;
        MapItem mapItem2;
        MapItem mapItem3;
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException;
        Section[] sectionArr2 = sectionArr;
        MixedItemSection mixedItemSection2 = mixedItemSection;
        if (sectionArr2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("sections == null");
            throw nullPointerException2;
        } else if (mixedItemSection2.items().size() != 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("mapSection.items().size() != 0");
            throw illegalArgumentException2;
        } else {
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(50);
            ArrayList arrayList4 = arrayList2;
            int length = sectionArr2.length;
            for (int i = 0; i < length; i++) {
                Section section2 = sectionArr2[i];
                int i2 = 0;
                Item item = null;
                Item item2 = null;
                ItemType itemType = null;
                for (Item item3 : section2.items()) {
                    ItemType itemType2 = item3.itemType();
                    if (itemType2 != itemType) {
                        if (i2 != 0) {
                            ArrayList arrayList5 = arrayList4;
                            MapItem mapItem4 = mapItem3;
                            MapItem mapItem5 = new MapItem(itemType, section2, item2, item, i2);
                            boolean add = arrayList5.add(mapItem4);
                        }
                        i2 = 0;
                        item2 = item3;
                        itemType = itemType2;
                    }
                    i2++;
                    item = item3;
                }
                if (i2 != 0) {
                    ArrayList arrayList6 = arrayList4;
                    MapItem mapItem6 = mapItem2;
                    MapItem mapItem7 = new MapItem(itemType, section2, item2, item, i2);
                    boolean add2 = arrayList6.add(mapItem6);
                } else if (section2 == mixedItemSection2) {
                    ArrayList arrayList7 = arrayList4;
                    MapItem mapItem8 = mapItem;
                    MapItem mapItem9 = new MapItem(mixedItemSection2);
                    boolean add3 = arrayList7.add(mapItem8);
                }
            }
            MixedItemSection mixedItemSection3 = mixedItemSection2;
            UniformListItem uniformListItem2 = uniformListItem;
            UniformListItem uniformListItem3 = new UniformListItem(ItemType.TYPE_MAP_LIST, arrayList4);
            mixedItemSection3.add(uniformListItem2);
        }
    }

    public void addContents(DexFile dexFile) {
    }

    public ItemType itemType() {
        return ItemType.TYPE_MAP_ITEM;
    }

    public final String toHuman() {
        return toString();
    }

    public String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        StringBuffer append = stringBuffer4.append(getClass().getName());
        StringBuffer append2 = stringBuffer4.append('{');
        StringBuffer append3 = stringBuffer4.append(this.section.toString());
        StringBuffer append4 = stringBuffer4.append(' ');
        StringBuffer append5 = stringBuffer4.append(this.type.toHuman());
        StringBuffer append6 = stringBuffer4.append('}');
        return stringBuffer4.toString();
    }

    /* access modifiers changed from: protected */
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int mapValue = this.type.getMapValue();
        int absoluteItemOffset = this.firstItem == null ? this.section.getFileOffset() : this.section.getAbsoluteItemOffset(this.firstItem);
        if (annotatedOutput2.annotates()) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            annotatedOutput3.annotate(0, sb5.append(offsetString()).append(' ').append(this.type.getTypeName()).append(" map").toString());
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb7 = sb2;
            StringBuilder sb8 = new StringBuilder();
            annotatedOutput4.annotate(2, sb7.append("  type:   ").append(Hex.m51u2(mapValue)).append(" // ").append(this.type.toString()).toString());
            annotatedOutput2.annotate(2, "  unused: 0");
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            StringBuilder sb9 = sb3;
            StringBuilder sb10 = new StringBuilder();
            annotatedOutput5.annotate(4, sb9.append("  size:   ").append(Hex.m53u4(this.itemCount)).toString());
            AnnotatedOutput annotatedOutput6 = annotatedOutput2;
            StringBuilder sb11 = sb4;
            StringBuilder sb12 = new StringBuilder();
            annotatedOutput6.annotate(4, sb11.append("  offset: ").append(Hex.m53u4(absoluteItemOffset)).toString());
        }
        annotatedOutput2.writeShort(mapValue);
        annotatedOutput2.writeShort(0);
        annotatedOutput2.writeInt(this.itemCount);
        annotatedOutput2.writeInt(absoluteItemOffset);
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.merge;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.dex.Annotation;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData.Field;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData.Method;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassDef;
import net.zhuoweizhang.boardwalk.com.android.dex.Code;
import net.zhuoweizhang.boardwalk.com.android.dex.Code.CatchHandler;
import net.zhuoweizhang.boardwalk.com.android.dex.Code.Try;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex;
import net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section;
import net.zhuoweizhang.boardwalk.com.android.dex.DexException;
import net.zhuoweizhang.boardwalk.com.android.dex.FieldId;
import net.zhuoweizhang.boardwalk.com.android.dex.MethodId;
import net.zhuoweizhang.boardwalk.com.android.dex.ProtoId;
import net.zhuoweizhang.boardwalk.com.android.dex.TableOfContents;
import net.zhuoweizhang.boardwalk.com.android.dex.TypeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.DexMerger */
public final class DexMerger {
    private static final byte DBG_ADVANCE_LINE = 2;
    private static final byte DBG_ADVANCE_PC = 1;
    private static final byte DBG_END_LOCAL = 5;
    private static final byte DBG_END_SEQUENCE = 0;
    private static final byte DBG_RESTART_LOCAL = 6;
    private static final byte DBG_SET_EPILOGUE_BEGIN = 8;
    private static final byte DBG_SET_FILE = 9;
    private static final byte DBG_SET_PROLOGUE_END = 7;
    private static final byte DBG_START_LOCAL = 3;
    private static final byte DBG_START_LOCAL_EXTENDED = 4;
    /* access modifiers changed from: private */
    public final IndexMap aIndexMap;
    private final InstructionTransformer aInstructionTransformer;
    /* access modifiers changed from: private */
    public final Section annotationOut;
    /* access modifiers changed from: private */
    public final Section annotationSetOut;
    /* access modifiers changed from: private */
    public final Section annotationSetRefListOut;
    /* access modifiers changed from: private */
    public final Section annotationsDirectoryOut;
    /* access modifiers changed from: private */
    public final IndexMap bIndexMap;
    private final InstructionTransformer bInstructionTransformer;
    /* access modifiers changed from: private */
    public final Section classDataOut;
    /* access modifiers changed from: private */
    public final Section codeOut;
    private final CollisionPolicy collisionPolicy;
    private int compactWasteThreshold;
    /* access modifiers changed from: private */
    public final TableOfContents contentsOut;
    /* access modifiers changed from: private */
    public final Section debugInfoOut;
    /* access modifiers changed from: private */
    public final Dex dexA;
    /* access modifiers changed from: private */
    public final Dex dexB;
    private final Dex dexOut;
    /* access modifiers changed from: private */
    public final Section encodedArrayOut;
    /* access modifiers changed from: private */
    public final Section headerOut;
    /* access modifiers changed from: private */
    public final Section idsDefsOut;
    /* access modifiers changed from: private */
    public final Section mapListOut;
    /* access modifiers changed from: private */
    public final Section stringDataOut;
    /* access modifiers changed from: private */
    public final Section typeListOut;
    private final WriterSizes writerSizes;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.DexMerger$IdMerger */
    abstract class IdMerger<T extends Comparable<T>> {
        private final Section out;
        final /* synthetic */ DexMerger this$0;

        /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.DexMerger$IdMerger$UnsortedValue */
        class UnsortedValue implements Comparable<UnsortedValue> {
            final int index;
            final IndexMap indexMap;
            final int offset;
            final Dex source;
            final /* synthetic */ IdMerger this$1;
            final T value;

            UnsortedValue(IdMerger idMerger, Dex dex, IndexMap indexMap2, T t, int i, int i2) {
                Dex dex2 = dex;
                IndexMap indexMap3 = indexMap2;
                T t2 = t;
                int i3 = i;
                int i4 = i2;
                this.this$1 = idMerger;
                this.source = dex2;
                this.indexMap = indexMap3;
                this.value = t2;
                this.index = i3;
                this.offset = i4;
            }

            public int compareTo(UnsortedValue unsortedValue) {
                return this.value.compareTo(unsortedValue.value);
            }
        }

        protected IdMerger(DexMerger dexMerger, Section section) {
            Section section2 = section;
            this.this$0 = dexMerger;
            this.out = section2;
        }

        private List<UnsortedValue> readUnsortedValues(Dex dex, IndexMap indexMap) {
            ArrayList arrayList;
            UnsortedValue unsortedValue;
            Dex dex2 = dex;
            IndexMap indexMap2 = indexMap;
            TableOfContents.Section section = getSection(dex2.getTableOfContents());
            if (!section.exists()) {
                return Collections.emptyList();
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            Section open = dex2.open(section.off);
            for (int i = 0; i < section.size; i++) {
                ArrayList arrayList5 = arrayList4;
                UnsortedValue unsortedValue2 = unsortedValue;
                UnsortedValue unsortedValue3 = new UnsortedValue(this, dex2, indexMap2, read(open, indexMap2, 0), i, open.getPosition());
                boolean add = arrayList5.add(unsortedValue2);
            }
            return arrayList4;
        }

        /* access modifiers changed from: 0000 */
        public abstract TableOfContents.Section getSection(TableOfContents tableOfContents);

        public final void mergeSorted() {
            int i;
            Comparable comparable;
            int i2;
            boolean z;
            boolean z2;
            int i3;
            Comparable comparable2;
            Comparable comparable3;
            Comparable comparable4;
            int i4;
            int i5;
            TableOfContents.Section section = getSection(this.this$0.dexA.getTableOfContents());
            TableOfContents.Section section2 = getSection(this.this$0.dexB.getTableOfContents());
            getSection(this.this$0.contentsOut).off = this.out.getPosition();
            Section section3 = section.exists() ? this.this$0.dexA.open(section.off) : null;
            Section section4 = section2.exists() ? this.this$0.dexB.open(section2.off) : null;
            int i6 = -1;
            int i7 = 0;
            Comparable comparable5 = null;
            Comparable comparable6 = null;
            int i8 = -1;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (comparable6 != null || i9 >= section.size) {
                    i = i8;
                    comparable = comparable6;
                } else {
                    i = section3.getPosition();
                    comparable = read(section3, this.this$0.aIndexMap, i9);
                }
                if (comparable5 != null || i7 >= section2.size) {
                    i2 = i6;
                } else {
                    int position = section4.getPosition();
                    comparable5 = read(section4, this.this$0.bIndexMap, i7);
                    i2 = position;
                }
                if (comparable == null || comparable5 == null) {
                    z = comparable != null;
                    z2 = comparable5 != null;
                } else {
                    int compareTo = comparable.compareTo(comparable5);
                    z = compareTo <= 0;
                    z2 = compareTo >= 0;
                }
                if (z) {
                    int i11 = i9 + 1;
                    updateIndex(i, this.this$0.aIndexMap, i9, i10);
                    i9 = i11;
                    i3 = -1;
                    comparable = null;
                    comparable2 = comparable;
                } else {
                    i3 = i;
                    comparable2 = null;
                }
                if (z2) {
                    int i12 = i7 + 1;
                    updateIndex(i2, this.this$0.bIndexMap, i7, i10);
                    comparable4 = null;
                    i5 = -1;
                    i4 = i12;
                    comparable3 = comparable5;
                } else {
                    comparable3 = comparable2;
                    comparable4 = comparable5;
                    i4 = i7;
                    i5 = i2;
                }
                if (comparable3 == null) {
                    getSection(this.this$0.contentsOut).size = i10;
                    return;
                }
                write(comparable3);
                i10++;
                i8 = i3;
                i6 = i5;
                i7 = i4;
                comparable5 = comparable4;
                comparable6 = comparable;
            }
        }

        public final void mergeUnsorted() {
            ArrayList arrayList;
            int i;
            getSection(this.this$0.contentsOut).off = this.out.getPosition();
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = arrayList2;
            boolean addAll = arrayList4.addAll(readUnsortedValues(this.this$0.dexA, this.this$0.aIndexMap));
            boolean addAll2 = arrayList4.addAll(readUnsortedValues(this.this$0.dexB, this.this$0.bIndexMap));
            Collections.sort(arrayList4);
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList4.size(); i3 = i) {
                i = i3 + 1;
                UnsortedValue unsortedValue = (UnsortedValue) arrayList4.get(i3);
                updateIndex(unsortedValue.offset, this.this$0.getIndexMap(unsortedValue.source), unsortedValue.index, i2 - 1);
                while (i < arrayList4.size() && unsortedValue.compareTo((UnsortedValue) arrayList4.get(i)) == 0) {
                    int i4 = i + 1;
                    UnsortedValue unsortedValue2 = (UnsortedValue) arrayList4.get(i);
                    updateIndex(unsortedValue2.offset, this.this$0.getIndexMap(unsortedValue2.source), unsortedValue2.index, i2 - 1);
                    i = i4;
                }
                write(unsortedValue.value);
                i2++;
            }
            getSection(this.this$0.contentsOut).size = i2;
        }

        /* access modifiers changed from: 0000 */
        public abstract T read(Section section, IndexMap indexMap, int i);

        /* access modifiers changed from: 0000 */
        public abstract void updateIndex(int i, IndexMap indexMap, int i2, int i3);

        /* access modifiers changed from: 0000 */
        public abstract void write(T t);
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.merge.DexMerger$WriterSizes */
    private static class WriterSizes {
        /* access modifiers changed from: private */
        public int annotation;
        /* access modifiers changed from: private */
        public int annotationsDirectory;
        /* access modifiers changed from: private */
        public int annotationsSet;
        /* access modifiers changed from: private */
        public int annotationsSetRefList;
        /* access modifiers changed from: private */
        public int classData;
        /* access modifiers changed from: private */
        public int code;
        /* access modifiers changed from: private */
        public int debugInfo;
        /* access modifiers changed from: private */
        public int encodedArray;
        /* access modifiers changed from: private */
        public int header = 112;
        /* access modifiers changed from: private */
        public int idsDefs;
        /* access modifiers changed from: private */
        public int mapList;
        /* access modifiers changed from: private */
        public int stringData;
        /* access modifiers changed from: private */
        public int typeList;

        public WriterSizes(Dex dex, Dex dex2) {
            Dex dex3 = dex;
            Dex dex4 = dex2;
            plus(dex3.getTableOfContents(), false);
            plus(dex4.getTableOfContents(), false);
            fourByteAlign();
        }

        public WriterSizes(DexMerger dexMerger) {
            DexMerger dexMerger2 = dexMerger;
            this.header = dexMerger2.headerOut.used();
            this.idsDefs = dexMerger2.idsDefsOut.used();
            this.mapList = dexMerger2.mapListOut.used();
            this.typeList = dexMerger2.typeListOut.used();
            this.classData = dexMerger2.classDataOut.used();
            this.code = dexMerger2.codeOut.used();
            this.stringData = dexMerger2.stringDataOut.used();
            this.debugInfo = dexMerger2.debugInfoOut.used();
            this.encodedArray = dexMerger2.encodedArrayOut.used();
            this.annotationsDirectory = dexMerger2.annotationsDirectoryOut.used();
            this.annotationsSet = dexMerger2.annotationSetOut.used();
            this.annotationsSetRefList = dexMerger2.annotationSetRefListOut.used();
            this.annotation = dexMerger2.annotationOut.used();
            fourByteAlign();
        }

        private static int fourByteAlign(int i) {
            return -4 & (i + 3);
        }

        private void fourByteAlign() {
            this.header = fourByteAlign(this.header);
            this.idsDefs = fourByteAlign(this.idsDefs);
            this.mapList = fourByteAlign(this.mapList);
            this.typeList = fourByteAlign(this.typeList);
            this.classData = fourByteAlign(this.classData);
            this.code = fourByteAlign(this.code);
            this.stringData = fourByteAlign(this.stringData);
            this.debugInfo = fourByteAlign(this.debugInfo);
            this.encodedArray = fourByteAlign(this.encodedArray);
            this.annotationsDirectory = fourByteAlign(this.annotationsDirectory);
            this.annotationsSet = fourByteAlign(this.annotationsSet);
            this.annotationsSetRefList = fourByteAlign(this.annotationsSetRefList);
            this.annotation = fourByteAlign(this.annotation);
        }

        private void plus(TableOfContents tableOfContents, boolean z) {
            TableOfContents tableOfContents2 = tableOfContents;
            boolean z2 = z;
            this.idsDefs += (4 * tableOfContents2.stringIds.size) + (4 * tableOfContents2.typeIds.size) + (12 * tableOfContents2.protoIds.size) + (8 * tableOfContents2.fieldIds.size) + (8 * tableOfContents2.methodIds.size) + (32 * tableOfContents2.classDefs.size);
            this.mapList = 4 + (12 * tableOfContents2.sections.length);
            this.typeList += fourByteAlign(tableOfContents2.typeLists.byteCount);
            this.stringData += tableOfContents2.stringDatas.byteCount;
            this.annotationsDirectory += tableOfContents2.annotationsDirectories.byteCount;
            this.annotationsSet += tableOfContents2.annotationSets.byteCount;
            this.annotationsSetRefList += tableOfContents2.annotationSetRefLists.byteCount;
            if (z2) {
                this.code += tableOfContents2.codes.byteCount;
                this.classData += tableOfContents2.classDatas.byteCount;
                this.encodedArray += tableOfContents2.encodedArrays.byteCount;
                this.annotation += tableOfContents2.annotations.byteCount;
                this.debugInfo += tableOfContents2.debugInfos.byteCount;
                return;
            }
            this.code += (int) Math.ceil(1.25d * ((double) tableOfContents2.codes.byteCount));
            this.classData += (int) Math.ceil(1.34d * ((double) tableOfContents2.classDatas.byteCount));
            this.encodedArray += 2 * tableOfContents2.encodedArrays.byteCount;
            this.annotation += (int) Math.ceil((double) (2 * tableOfContents2.annotations.byteCount));
            this.debugInfo += 2 * tableOfContents2.debugInfos.byteCount;
        }

        public int size() {
            return this.header + this.idsDefs + this.mapList + this.typeList + this.classData + this.code + this.stringData + this.debugInfo + this.encodedArray + this.annotationsDirectory + this.annotationsSet + this.annotationsSetRefList + this.annotation;
        }
    }

    public DexMerger(Dex dex, Dex dex2, CollisionPolicy collisionPolicy2) throws IOException {
        WriterSizes writerSizes2;
        Dex dex3 = dex;
        Dex dex4 = dex2;
        Dex dex5 = dex3;
        Dex dex6 = dex4;
        CollisionPolicy collisionPolicy3 = collisionPolicy2;
        WriterSizes writerSizes3 = writerSizes2;
        WriterSizes writerSizes4 = new WriterSizes(dex3, dex4);
        this(dex5, dex6, collisionPolicy3, writerSizes3);
    }

    private DexMerger(Dex dex, Dex dex2, CollisionPolicy collisionPolicy2, WriterSizes writerSizes2) throws IOException {
        Dex dex3;
        IndexMap indexMap;
        IndexMap indexMap2;
        InstructionTransformer instructionTransformer;
        InstructionTransformer instructionTransformer2;
        Dex dex4 = dex;
        Dex dex5 = dex2;
        CollisionPolicy collisionPolicy3 = collisionPolicy2;
        WriterSizes writerSizes3 = writerSizes2;
        this.compactWasteThreshold = 1048576;
        this.dexA = dex4;
        this.dexB = dex5;
        this.collisionPolicy = collisionPolicy3;
        this.writerSizes = writerSizes3;
        Dex dex6 = dex3;
        Dex dex7 = new Dex(writerSizes3.size());
        this.dexOut = dex6;
        TableOfContents tableOfContents = dex4.getTableOfContents();
        TableOfContents tableOfContents2 = dex5.getTableOfContents();
        IndexMap indexMap3 = indexMap;
        IndexMap indexMap4 = new IndexMap(this.dexOut, tableOfContents);
        this.aIndexMap = indexMap3;
        IndexMap indexMap5 = indexMap2;
        IndexMap indexMap6 = new IndexMap(this.dexOut, tableOfContents2);
        this.bIndexMap = indexMap5;
        InstructionTransformer instructionTransformer3 = instructionTransformer;
        InstructionTransformer instructionTransformer4 = new InstructionTransformer(this.aIndexMap);
        this.aInstructionTransformer = instructionTransformer3;
        InstructionTransformer instructionTransformer5 = instructionTransformer2;
        InstructionTransformer instructionTransformer6 = new InstructionTransformer(this.bIndexMap);
        this.bInstructionTransformer = instructionTransformer5;
        this.headerOut = this.dexOut.appendSection(writerSizes3.header, "header");
        this.idsDefsOut = this.dexOut.appendSection(writerSizes3.idsDefs, "ids defs");
        this.contentsOut = this.dexOut.getTableOfContents();
        this.contentsOut.dataOff = this.dexOut.getNextSectionStart();
        this.contentsOut.mapList.off = this.dexOut.getNextSectionStart();
        this.contentsOut.mapList.size = 1;
        this.mapListOut = this.dexOut.appendSection(writerSizes3.mapList, "map list");
        this.contentsOut.typeLists.off = this.dexOut.getNextSectionStart();
        this.typeListOut = this.dexOut.appendSection(writerSizes3.typeList, "type list");
        this.contentsOut.annotationSetRefLists.off = this.dexOut.getNextSectionStart();
        this.annotationSetRefListOut = this.dexOut.appendSection(writerSizes3.annotationsSetRefList, "annotation set ref list");
        this.contentsOut.annotationSets.off = this.dexOut.getNextSectionStart();
        this.annotationSetOut = this.dexOut.appendSection(writerSizes3.annotationsSet, "annotation sets");
        this.contentsOut.classDatas.off = this.dexOut.getNextSectionStart();
        this.classDataOut = this.dexOut.appendSection(writerSizes3.classData, "class data");
        this.contentsOut.codes.off = this.dexOut.getNextSectionStart();
        this.codeOut = this.dexOut.appendSection(writerSizes3.code, "code");
        this.contentsOut.stringDatas.off = this.dexOut.getNextSectionStart();
        this.stringDataOut = this.dexOut.appendSection(writerSizes3.stringData, "string data");
        this.contentsOut.debugInfos.off = this.dexOut.getNextSectionStart();
        this.debugInfoOut = this.dexOut.appendSection(writerSizes3.debugInfo, "debug info");
        this.contentsOut.annotations.off = this.dexOut.getNextSectionStart();
        this.annotationOut = this.dexOut.appendSection(writerSizes3.annotation, "annotation");
        this.contentsOut.encodedArrays.off = this.dexOut.getNextSectionStart();
        this.encodedArrayOut = this.dexOut.appendSection(writerSizes3.encodedArray, "encoded array");
        this.contentsOut.annotationsDirectories.off = this.dexOut.getNextSectionStart();
        this.annotationsDirectoryOut = this.dexOut.appendSection(writerSizes3.annotationsDirectory, "annotations directory");
        this.contentsOut.dataSize = this.dexOut.getNextSectionStart() - this.contentsOut.dataOff;
    }

    /* access modifiers changed from: private */
    public IndexMap getIndexMap(Dex dex) {
        IllegalArgumentException illegalArgumentException;
        Dex dex2 = dex;
        if (dex2 == this.dexA) {
            return this.aIndexMap;
        }
        if (dex2 == this.dexB) {
            return this.bIndexMap;
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
        throw illegalArgumentException2;
    }

    private SortableType[] getSortedTypes() {
        boolean z;
        SortableType[] sortableTypeArr = new SortableType[this.contentsOut.typeIds.size];
        readSortableTypes(sortableTypeArr, this.dexA, this.aIndexMap);
        readSortableTypes(sortableTypeArr, this.dexB, this.bIndexMap);
        do {
            z = true;
            int length = sortableTypeArr.length;
            for (int i = 0; i < length; i++) {
                SortableType sortableType = sortableTypeArr[i];
                if (sortableType != null && !sortableType.isDepthAssigned()) {
                    z &= sortableType.tryAssignDepth(sortableTypeArr);
                }
            }
        } while (!z);
        Arrays.sort(sortableTypeArr, SortableType.NULLS_LAST_ORDER);
        int indexOf = Arrays.asList(sortableTypeArr).indexOf(null);
        return indexOf != -1 ? (SortableType[]) Arrays.copyOfRange(sortableTypeArr, 0, indexOf) : sortableTypeArr;
    }

    public static void main(String[] strArr) throws IOException {
        Dex dex;
        File file;
        File file2;
        DexMerger dexMerger;
        Dex dex2;
        File file3;
        String[] strArr2 = strArr;
        if (strArr2.length < 2) {
            printUsage();
            return;
        }
        Dex dex3 = dex;
        File file4 = file;
        File file5 = new File(strArr2[1]);
        Dex dex4 = new Dex(file4);
        Dex dex5 = dex3;
        for (int i = 2; i < strArr2.length; i++) {
            DexMerger dexMerger2 = dexMerger;
            Dex dex6 = dex5;
            Dex dex7 = dex2;
            File file6 = file3;
            File file7 = new File(strArr2[i]);
            Dex dex8 = new Dex(file6);
            DexMerger dexMerger3 = new DexMerger(dex6, dex7, CollisionPolicy.KEEP_FIRST);
            dex5 = dexMerger2.merge();
        }
        Dex dex9 = dex5;
        File file8 = file2;
        File file9 = new File(strArr2[0]);
        dex9.writeTo(file8);
    }

    private void mergeAnnotations() {
        C07107 r5;
        C07107 r1 = r5;
        C07107 r2 = new IdMerger<Annotation>(this, this.annotationOut) {
            final /* synthetic */ DexMerger this$0;

            {
                DexMerger dexMerger = r7;
                Section section = r8;
                this.this$0 = dexMerger;
            }

            /* access modifiers changed from: 0000 */
            public TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.annotations;
            }

            /* access modifiers changed from: 0000 */
            public Annotation read(Section section, IndexMap indexMap, int i) {
                int i2 = i;
                return indexMap.adjust(section.readAnnotation());
            }

            /* access modifiers changed from: 0000 */
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                int i4 = i2;
                int i5 = i3;
                indexMap.putAnnotationOffset(i, this.this$0.annotationOut.getPosition());
            }

            /* access modifiers changed from: 0000 */
            public void write(Annotation annotation) {
                annotation.writeTo(this.this$0.annotationOut);
            }
        };
        r1.mergeUnsorted();
    }

    private void mergeClassDefs() {
        SortableType[] sortedTypes = getSortedTypes();
        this.contentsOut.classDefs.off = this.idsDefsOut.getPosition();
        this.contentsOut.classDefs.size = sortedTypes.length;
        int length = sortedTypes.length;
        for (int i = 0; i < length; i++) {
            SortableType sortableType = sortedTypes[i];
            Dex dex = sortableType.getDex();
            transformClassDef(dex, sortableType.getClassDef(), dex == this.dexA ? this.aIndexMap : this.bIndexMap);
        }
    }

    private Dex mergeDexes() throws IOException {
        mergeStringIds();
        mergeTypeIds();
        mergeTypeLists();
        mergeProtoIds();
        mergeFieldIds();
        mergeMethodIds();
        mergeAnnotations();
        unionAnnotationSetsAndDirectories();
        mergeClassDefs();
        this.contentsOut.header.off = 0;
        this.contentsOut.header.size = 1;
        this.contentsOut.fileSize = this.dexOut.getLength();
        this.contentsOut.computeSizesFromOffsets();
        this.contentsOut.writeHeader(this.headerOut);
        this.contentsOut.writeMap(this.mapListOut);
        this.dexOut.writeHashes();
        return this.dexOut;
    }

    private void mergeFieldIds() {
        C07085 r5;
        C07085 r1 = r5;
        C07085 r2 = new IdMerger<FieldId>(this, this.idsDefsOut) {
            final /* synthetic */ DexMerger this$0;

            {
                DexMerger dexMerger = r7;
                Section section = r8;
                this.this$0 = dexMerger;
            }

            /* access modifiers changed from: 0000 */
            public TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.fieldIds;
            }

            /* access modifiers changed from: 0000 */
            public FieldId read(Section section, IndexMap indexMap, int i) {
                int i2 = i;
                return indexMap.adjust(section.readFieldId());
            }

            /* access modifiers changed from: 0000 */
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                IllegalArgumentException illegalArgumentException;
                StringBuilder sb;
                int i4 = i;
                IndexMap indexMap2 = indexMap;
                int i5 = i2;
                int i6 = i3;
                if (i6 < 0 || i6 > 65535) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("field ID not in [0, 0xffff]: ").append(i6).toString());
                    throw illegalArgumentException2;
                }
                indexMap2.fieldIds[i5] = (short) i6;
            }

            /* access modifiers changed from: 0000 */
            public void write(FieldId fieldId) {
                fieldId.writeTo(this.this$0.idsDefsOut);
            }
        };
        r1.mergeSorted();
    }

    private void mergeMethodIds() {
        C07096 r5;
        C07096 r1 = r5;
        C07096 r2 = new IdMerger<MethodId>(this, this.idsDefsOut) {
            final /* synthetic */ DexMerger this$0;

            {
                DexMerger dexMerger = r7;
                Section section = r8;
                this.this$0 = dexMerger;
            }

            /* access modifiers changed from: 0000 */
            public TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.methodIds;
            }

            /* access modifiers changed from: 0000 */
            public MethodId read(Section section, IndexMap indexMap, int i) {
                int i2 = i;
                return indexMap.adjust(section.readMethodId());
            }

            /* access modifiers changed from: 0000 */
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                IllegalArgumentException illegalArgumentException;
                StringBuilder sb;
                int i4 = i;
                IndexMap indexMap2 = indexMap;
                int i5 = i2;
                int i6 = i3;
                if (i6 < 0 || i6 > 65535) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("method ID not in [0, 0xffff]: ").append(i6).toString());
                    throw illegalArgumentException2;
                }
                indexMap2.methodIds[i5] = (short) i6;
            }

            /* access modifiers changed from: 0000 */
            public void write(MethodId methodId) {
                methodId.writeTo(this.this$0.idsDefsOut);
            }
        };
        r1.mergeSorted();
    }

    private void mergeProtoIds() {
        C07074 r5;
        C07074 r1 = r5;
        C07074 r2 = new IdMerger<ProtoId>(this, this.idsDefsOut) {
            final /* synthetic */ DexMerger this$0;

            {
                DexMerger dexMerger = r7;
                Section section = r8;
                this.this$0 = dexMerger;
            }

            /* access modifiers changed from: 0000 */
            public TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.protoIds;
            }

            /* access modifiers changed from: 0000 */
            public ProtoId read(Section section, IndexMap indexMap, int i) {
                int i2 = i;
                return indexMap.adjust(section.readProtoId());
            }

            /* access modifiers changed from: 0000 */
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                IllegalArgumentException illegalArgumentException;
                StringBuilder sb;
                int i4 = i;
                IndexMap indexMap2 = indexMap;
                int i5 = i2;
                int i6 = i3;
                if (i6 < 0 || i6 > 65535) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("proto ID not in [0, 0xffff]: ").append(i6).toString());
                    throw illegalArgumentException2;
                }
                indexMap2.protoIds[i5] = (short) i6;
            }

            /* access modifiers changed from: 0000 */
            public void write(ProtoId protoId) {
                protoId.writeTo(this.this$0.idsDefsOut);
            }
        };
        r1.mergeSorted();
    }

    private void mergeStringIds() {
        C07041 r5;
        C07041 r1 = r5;
        C07041 r2 = new IdMerger<String>(this, this.idsDefsOut) {
            final /* synthetic */ DexMerger this$0;

            {
                DexMerger dexMerger = r7;
                Section section = r8;
                this.this$0 = dexMerger;
            }

            /* access modifiers changed from: 0000 */
            public TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.stringIds;
            }

            /* access modifiers changed from: 0000 */
            public String read(Section section, IndexMap indexMap, int i) {
                IndexMap indexMap2 = indexMap;
                int i2 = i;
                return section.readString();
            }

            /* access modifiers changed from: 0000 */
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                int i4 = i;
                indexMap.stringIds[i2] = i3;
            }

            /* access modifiers changed from: 0000 */
            public void write(String str) {
                String str2 = str;
                TableOfContents.Section section = this.this$0.contentsOut.stringDatas;
                section.size = 1 + section.size;
                this.this$0.idsDefsOut.writeInt(this.this$0.stringDataOut.getPosition());
                this.this$0.stringDataOut.writeStringData(str2);
            }
        };
        r1.mergeSorted();
    }

    private void mergeTypeIds() {
        C07052 r5;
        C07052 r1 = r5;
        C07052 r2 = new IdMerger<Integer>(this, this.idsDefsOut) {
            final /* synthetic */ DexMerger this$0;

            {
                DexMerger dexMerger = r7;
                Section section = r8;
                this.this$0 = dexMerger;
            }

            /* access modifiers changed from: 0000 */
            public TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.typeIds;
            }

            /* access modifiers changed from: 0000 */
            public Integer read(Section section, IndexMap indexMap, int i) {
                int i2 = i;
                return Integer.valueOf(indexMap.adjustString(section.readInt()));
            }

            /* access modifiers changed from: 0000 */
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                IllegalArgumentException illegalArgumentException;
                StringBuilder sb;
                int i4 = i;
                IndexMap indexMap2 = indexMap;
                int i5 = i2;
                int i6 = i3;
                if (i6 < 0 || i6 > 65535) {
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("type ID not in [0, 0xffff]: ").append(i6).toString());
                    throw illegalArgumentException2;
                }
                indexMap2.typeIds[i5] = (short) i6;
            }

            /* access modifiers changed from: 0000 */
            public void write(Integer num) {
                this.this$0.idsDefsOut.writeInt(num.intValue());
            }
        };
        r1.mergeSorted();
    }

    private void mergeTypeLists() {
        C07063 r5;
        C07063 r1 = r5;
        C07063 r2 = new IdMerger<TypeList>(this, this.typeListOut) {
            final /* synthetic */ DexMerger this$0;

            {
                DexMerger dexMerger = r7;
                Section section = r8;
                this.this$0 = dexMerger;
            }

            /* access modifiers changed from: 0000 */
            public TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.typeLists;
            }

            /* access modifiers changed from: 0000 */
            public TypeList read(Section section, IndexMap indexMap, int i) {
                int i2 = i;
                return indexMap.adjustTypeList(section.readTypeList());
            }

            /* access modifiers changed from: 0000 */
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                int i4 = i2;
                int i5 = i3;
                indexMap.putTypeListOffset(i, this.this$0.typeListOut.getPosition());
            }

            /* access modifiers changed from: 0000 */
            public void write(TypeList typeList) {
                TypeList typeList2 = typeList;
                this.this$0.typeListOut.writeTypeList(typeList2);
            }
        };
        r1.mergeUnsorted();
    }

    private static void printUsage() {
        System.out.println("Usage: DexMerger <out.dex> <a.dex> <b.dex> ...");
        System.out.println();
        System.out.println("If a class is defined in several dex, the class found in the first dex will be used.");
    }

    private void readSortableTypes(SortableType[] sortableTypeArr, Dex dex, IndexMap indexMap) {
        SortableType sortableType;
        DexException dexException;
        StringBuilder sb;
        SortableType[] sortableTypeArr2 = sortableTypeArr;
        Dex dex2 = dex;
        IndexMap indexMap2 = indexMap;
        for (ClassDef classDef : dex2.classDefs()) {
            IndexMap indexMap3 = indexMap2;
            SortableType sortableType2 = sortableType;
            SortableType sortableType3 = new SortableType(dex2, classDef);
            SortableType adjust = indexMap3.adjust(sortableType2);
            int typeIndex = adjust.getTypeIndex();
            if (sortableTypeArr2[typeIndex] == null) {
                sortableTypeArr2[typeIndex] = adjust;
            } else if (this.collisionPolicy != CollisionPolicy.KEEP_FIRST) {
                DexException dexException2 = dexException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                DexException dexException3 = new DexException(sb2.append("Multiple dex files define ").append((String) dex2.typeNames().get(classDef.getTypeIndex())).toString());
                throw dexException2;
            }
        }
    }

    private void transformAnnotationDirectories(Dex dex, IndexMap indexMap) {
        Dex dex2 = dex;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section = dex2.getTableOfContents().annotationsDirectories;
        if (section.exists()) {
            Section open = dex2.open(section.off);
            for (int i = 0; i < section.size; i++) {
                transformAnnotationDirectory(open, indexMap2);
            }
        }
    }

    private void transformAnnotationDirectory(Section section, IndexMap indexMap) {
        int i;
        Section section2 = section;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section3 = this.contentsOut.annotationsDirectories;
        section3.size = 1 + section3.size;
        this.annotationsDirectoryOut.assertFourByteAligned();
        indexMap2.putAnnotationDirectoryOffset(section2.getPosition(), this.annotationsDirectoryOut.getPosition());
        this.annotationsDirectoryOut.writeInt(indexMap2.adjustAnnotationSet(section2.readInt()));
        int readInt = section2.readInt();
        this.annotationsDirectoryOut.writeInt(readInt);
        int readInt2 = section2.readInt();
        this.annotationsDirectoryOut.writeInt(readInt2);
        int readInt3 = section2.readInt();
        this.annotationsDirectoryOut.writeInt(readInt3);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.annotationsDirectoryOut.writeInt(indexMap2.adjustField(section2.readInt()));
            this.annotationsDirectoryOut.writeInt(indexMap2.adjustAnnotationSet(section2.readInt()));
        }
        int i3 = 0;
        while (true) {
            if (i3 >= readInt2) {
                break;
            }
            this.annotationsDirectoryOut.writeInt(indexMap2.adjustMethod(section2.readInt()));
            this.annotationsDirectoryOut.writeInt(indexMap2.adjustAnnotationSet(section2.readInt()));
            i3++;
        }
        for (i = 0; i < readInt3; i++) {
            this.annotationsDirectoryOut.writeInt(indexMap2.adjustMethod(section2.readInt()));
            this.annotationsDirectoryOut.writeInt(indexMap2.adjustAnnotationSetRefList(section2.readInt()));
        }
    }

    private void transformAnnotationSet(IndexMap indexMap, Section section) {
        IndexMap indexMap2 = indexMap;
        Section section2 = section;
        TableOfContents.Section section3 = this.contentsOut.annotationSets;
        section3.size = 1 + section3.size;
        this.annotationSetOut.assertFourByteAligned();
        indexMap2.putAnnotationSetOffset(section2.getPosition(), this.annotationSetOut.getPosition());
        int readInt = section2.readInt();
        this.annotationSetOut.writeInt(readInt);
        for (int i = 0; i < readInt; i++) {
            this.annotationSetOut.writeInt(indexMap2.adjustAnnotation(section2.readInt()));
        }
    }

    private void transformAnnotationSetRefList(IndexMap indexMap, Section section) {
        IndexMap indexMap2 = indexMap;
        Section section2 = section;
        TableOfContents.Section section3 = this.contentsOut.annotationSetRefLists;
        section3.size = 1 + section3.size;
        this.annotationSetRefListOut.assertFourByteAligned();
        indexMap2.putAnnotationSetRefListOffset(section2.getPosition(), this.annotationSetRefListOut.getPosition());
        int readInt = section2.readInt();
        this.annotationSetRefListOut.writeInt(readInt);
        for (int i = 0; i < readInt; i++) {
            this.annotationSetRefListOut.writeInt(indexMap2.adjustAnnotationSet(section2.readInt()));
        }
    }

    private void transformAnnotationSetRefLists(Dex dex, IndexMap indexMap) {
        Dex dex2 = dex;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section = dex2.getTableOfContents().annotationSetRefLists;
        if (section.exists()) {
            Section open = dex2.open(section.off);
            for (int i = 0; i < section.size; i++) {
                transformAnnotationSetRefList(indexMap2, open);
            }
        }
    }

    private void transformAnnotationSets(Dex dex, IndexMap indexMap) {
        Dex dex2 = dex;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section = dex2.getTableOfContents().annotationSets;
        if (section.exists()) {
            Section open = dex2.open(section.off);
            for (int i = 0; i < section.size; i++) {
                transformAnnotationSet(indexMap2, open);
            }
        }
    }

    private int[] transformCatchHandlers(IndexMap indexMap, CatchHandler[] catchHandlerArr) {
        IndexMap indexMap2 = indexMap;
        CatchHandler[] catchHandlerArr2 = catchHandlerArr;
        int position = this.codeOut.getPosition();
        this.codeOut.writeUleb128(catchHandlerArr2.length);
        int[] iArr = new int[catchHandlerArr2.length];
        for (int i = 0; i < catchHandlerArr2.length; i++) {
            iArr[i] = this.codeOut.getPosition() - position;
            transformEncodedCatchHandler(catchHandlerArr2[i], indexMap2);
        }
        return iArr;
    }

    private void transformClassData(Dex dex, ClassData classData, IndexMap indexMap) {
        Dex dex2 = dex;
        ClassData classData2 = classData;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section = this.contentsOut.classDatas;
        section.size = 1 + section.size;
        Field[] staticFields = classData2.getStaticFields();
        Field[] instanceFields = classData2.getInstanceFields();
        Method[] directMethods = classData2.getDirectMethods();
        Method[] virtualMethods = classData2.getVirtualMethods();
        this.classDataOut.writeUleb128(staticFields.length);
        this.classDataOut.writeUleb128(instanceFields.length);
        this.classDataOut.writeUleb128(directMethods.length);
        this.classDataOut.writeUleb128(virtualMethods.length);
        transformFields(indexMap2, staticFields);
        transformFields(indexMap2, instanceFields);
        transformMethods(dex2, indexMap2, directMethods);
        transformMethods(dex2, indexMap2, virtualMethods);
    }

    private void transformClassDef(Dex dex, ClassDef classDef, IndexMap indexMap) {
        Dex dex2 = dex;
        ClassDef classDef2 = classDef;
        IndexMap indexMap2 = indexMap;
        this.idsDefsOut.assertFourByteAligned();
        this.idsDefsOut.writeInt(classDef2.getTypeIndex());
        this.idsDefsOut.writeInt(classDef2.getAccessFlags());
        this.idsDefsOut.writeInt(classDef2.getSupertypeIndex());
        this.idsDefsOut.writeInt(classDef2.getInterfacesOffset());
        this.idsDefsOut.writeInt(indexMap2.adjustString(classDef2.getSourceFileIndex()));
        this.idsDefsOut.writeInt(indexMap2.adjustAnnotationDirectory(classDef2.getAnnotationsOffset()));
        if (classDef2.getClassDataOffset() == 0) {
            this.idsDefsOut.writeInt(0);
        } else {
            this.idsDefsOut.writeInt(this.classDataOut.getPosition());
            transformClassData(dex2, dex2.readClassData(classDef2), indexMap2);
        }
        this.idsDefsOut.writeInt(indexMap2.adjustStaticValues(classDef2.getStaticValuesOffset()));
    }

    private void transformCode(Dex dex, Code code, IndexMap indexMap) {
        Dex dex2 = dex;
        Code code2 = code;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section = this.contentsOut.codes;
        section.size = 1 + section.size;
        this.codeOut.assertFourByteAligned();
        this.codeOut.writeUnsignedShort(code2.getRegistersSize());
        this.codeOut.writeUnsignedShort(code2.getInsSize());
        this.codeOut.writeUnsignedShort(code2.getOutsSize());
        Try[] tries = code2.getTries();
        CatchHandler[] catchHandlers = code2.getCatchHandlers();
        this.codeOut.writeUnsignedShort(tries.length);
        int debugInfoOffset = code2.getDebugInfoOffset();
        if (debugInfoOffset != 0) {
            this.codeOut.writeInt(this.debugInfoOut.getPosition());
            transformDebugInfoItem(dex2.open(debugInfoOffset), indexMap2);
        } else {
            this.codeOut.writeInt(0);
        }
        short[] transform = (dex2 == this.dexA ? this.aInstructionTransformer : this.bInstructionTransformer).transform(code2.getInstructions());
        this.codeOut.writeInt(transform.length);
        this.codeOut.write(transform);
        if (tries.length > 0) {
            if (transform.length % 2 == 1) {
                this.codeOut.writeShort(0);
            }
            Section open = this.dexOut.open(this.codeOut.getPosition());
            this.codeOut.skip(8 * tries.length);
            transformTries(open, tries, transformCatchHandlers(indexMap2, catchHandlers));
        }
    }

    private void transformDebugInfoItem(Section section, IndexMap indexMap) {
        Section section2 = section;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section3 = this.contentsOut.debugInfos;
        section3.size = 1 + section3.size;
        this.debugInfoOut.writeUleb128(section2.readUleb128());
        int readUleb128 = section2.readUleb128();
        this.debugInfoOut.writeUleb128(readUleb128);
        for (int i = 0; i < readUleb128; i++) {
            this.debugInfoOut.writeUleb128p1(indexMap2.adjustString(section2.readUleb128p1()));
        }
        while (true) {
            byte readByte = section2.readByte();
            this.debugInfoOut.writeByte(readByte);
            switch (readByte) {
                case 0:
                    return;
                case 1:
                    this.debugInfoOut.writeUleb128(section2.readUleb128());
                    break;
                case 2:
                    this.debugInfoOut.writeSleb128(section2.readSleb128());
                    break;
                case 3:
                case 4:
                    this.debugInfoOut.writeUleb128(section2.readUleb128());
                    this.debugInfoOut.writeUleb128p1(indexMap2.adjustString(section2.readUleb128p1()));
                    this.debugInfoOut.writeUleb128p1(indexMap2.adjustType(section2.readUleb128p1()));
                    if (readByte != 4) {
                        break;
                    } else {
                        this.debugInfoOut.writeUleb128p1(indexMap2.adjustString(section2.readUleb128p1()));
                        break;
                    }
                case 5:
                case 6:
                    this.debugInfoOut.writeUleb128(section2.readUleb128());
                    break;
                case 9:
                    this.debugInfoOut.writeUleb128p1(indexMap2.adjustString(section2.readUleb128p1()));
                    break;
            }
        }
    }

    private void transformEncodedCatchHandler(CatchHandler catchHandler, IndexMap indexMap) {
        CatchHandler catchHandler2 = catchHandler;
        IndexMap indexMap2 = indexMap;
        int catchAllAddress = catchHandler2.getCatchAllAddress();
        int[] typeIndexes = catchHandler2.getTypeIndexes();
        int[] addresses = catchHandler2.getAddresses();
        if (catchAllAddress != -1) {
            this.codeOut.writeSleb128(-typeIndexes.length);
        } else {
            this.codeOut.writeSleb128(typeIndexes.length);
        }
        for (int i = 0; i < typeIndexes.length; i++) {
            this.codeOut.writeUleb128(indexMap2.adjustType(typeIndexes[i]));
            this.codeOut.writeUleb128(addresses[i]);
        }
        if (catchAllAddress != -1) {
            this.codeOut.writeUleb128(catchAllAddress);
        }
    }

    private void transformFields(IndexMap indexMap, Field[] fieldArr) {
        IndexMap indexMap2 = indexMap;
        Field[] fieldArr2 = fieldArr;
        int i = 0;
        int length = fieldArr2.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i < length) {
                Field field = fieldArr2[i];
                int adjustField = indexMap2.adjustField(field.getFieldIndex());
                this.classDataOut.writeUleb128(adjustField - i3);
                this.classDataOut.writeUleb128(field.getAccessFlags());
                i++;
                i2 = adjustField;
            } else {
                return;
            }
        }
    }

    private void transformMethods(Dex dex, IndexMap indexMap, Method[] methodArr) {
        Dex dex2 = dex;
        IndexMap indexMap2 = indexMap;
        Method[] methodArr2 = methodArr;
        int length = methodArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i < length) {
                Method method = methodArr2[i];
                int adjustMethod = indexMap2.adjustMethod(method.getMethodIndex());
                this.classDataOut.writeUleb128(adjustMethod - i3);
                this.classDataOut.writeUleb128(method.getAccessFlags());
                if (method.getCodeOffset() == 0) {
                    this.classDataOut.writeUleb128(0);
                } else {
                    this.codeOut.alignToFourBytesWithZeroFill();
                    this.classDataOut.writeUleb128(this.codeOut.getPosition());
                    transformCode(dex2, dex2.readCode(method), indexMap2);
                }
                i++;
                i2 = adjustMethod;
            } else {
                return;
            }
        }
    }

    private void transformStaticValues(Section section, IndexMap indexMap) {
        Section section2 = section;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section3 = this.contentsOut.encodedArrays;
        section3.size = 1 + section3.size;
        indexMap2.putStaticValuesOffset(section2.getPosition(), this.encodedArrayOut.getPosition());
        indexMap2.adjustEncodedArray(section2.readEncodedArray()).writeTo(this.encodedArrayOut);
    }

    private void transformStaticValues(Dex dex, IndexMap indexMap) {
        Dex dex2 = dex;
        IndexMap indexMap2 = indexMap;
        TableOfContents.Section section = dex2.getTableOfContents().encodedArrays;
        if (section.exists()) {
            Section open = dex2.open(section.off);
            for (int i = 0; i < section.size; i++) {
                transformStaticValues(open, indexMap2);
            }
        }
    }

    private void transformTries(Section section, Try[] tryArr, int[] iArr) {
        Section section2 = section;
        Try[] tryArr2 = tryArr;
        int[] iArr2 = iArr;
        int length = tryArr2.length;
        for (int i = 0; i < length; i++) {
            Try tryR = tryArr2[i];
            section2.writeInt(tryR.getStartAddress());
            section2.writeUnsignedShort(tryR.getInstructionCount());
            section2.writeUnsignedShort(iArr2[tryR.getCatchHandlerIndex()]);
        }
    }

    private void unionAnnotationSetsAndDirectories() {
        transformAnnotationSets(this.dexA, this.aIndexMap);
        transformAnnotationSets(this.dexB, this.bIndexMap);
        transformAnnotationSetRefLists(this.dexA, this.aIndexMap);
        transformAnnotationSetRefLists(this.dexB, this.bIndexMap);
        transformAnnotationDirectories(this.dexA, this.aIndexMap);
        transformAnnotationDirectories(this.dexB, this.bIndexMap);
        transformStaticValues(this.dexA, this.aIndexMap);
        transformStaticValues(this.dexB, this.bIndexMap);
    }

    public Dex merge() throws IOException {
        WriterSizes writerSizes2;
        DexMerger dexMerger;
        Dex dex;
        long nanoTime = System.nanoTime();
        Dex mergeDexes = mergeDexes();
        WriterSizes writerSizes3 = writerSizes2;
        WriterSizes writerSizes4 = new WriterSizes(this);
        WriterSizes writerSizes5 = writerSizes3;
        int size = this.writerSizes.size() - writerSizes5.size();
        if (size > this.compactWasteThreshold) {
            DexMerger dexMerger2 = dexMerger;
            Dex dex2 = this.dexOut;
            Dex dex3 = dex;
            Dex dex4 = new Dex(0);
            DexMerger dexMerger3 = new DexMerger(dex2, dex3, CollisionPolicy.FAIL, writerSizes5);
            mergeDexes = dexMerger2.mergeDexes();
            PrintStream printf = System.out.printf("Result compacted from %.1fKiB to %.1fKiB to save %.1fKiB%n", new Object[]{Float.valueOf(((float) this.dexOut.getLength()) / 1024.0f), Float.valueOf(((float) mergeDexes.getLength()) / 1024.0f), Float.valueOf(((float) size) / 1024.0f)});
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        PrintStream printf2 = System.out.printf("Merged dex A (%d defs/%.1fKiB) with dex B (%d defs/%.1fKiB). Result is %d defs/%.1fKiB. Took %.1fs%n", new Object[]{Integer.valueOf(this.dexA.getTableOfContents().classDefs.size), Float.valueOf(((float) this.dexA.getLength()) / 1024.0f), Integer.valueOf(this.dexB.getTableOfContents().classDefs.size), Float.valueOf(((float) this.dexB.getLength()) / 1024.0f), Integer.valueOf(mergeDexes.getTableOfContents().classDefs.size), Float.valueOf(((float) mergeDexes.getLength()) / 1024.0f), Float.valueOf(((float) nanoTime2) / 1.0E9f)});
        return mergeDexes;
    }

    public void setCompactWasteThreshold(int i) {
        int i2 = i;
        this.compactWasteThreshold = i2;
    }
}

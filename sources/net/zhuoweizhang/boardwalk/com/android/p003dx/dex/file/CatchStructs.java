package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CatchHandlerList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CatchTable;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.CatchTable.Entry;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArrayAnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.CatchStructs */
public final class CatchStructs {
    private static final int TRY_ITEM_WRITE_SIZE = 8;
    private final DalvCode code;
    private int encodedHandlerHeaderSize = 0;
    private byte[] encodedHandlers = null;
    private TreeMap<CatchHandlerList, Integer> handlerOffsets = null;
    private CatchTable table = null;

    public CatchStructs(DalvCode dalvCode) {
        this.code = dalvCode;
    }

    private static void annotateAndConsumeHandlers(CatchHandlerList catchHandlerList, int i, int i2, String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        PrintWriter printWriter2 = printWriter;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        CatchHandlerList catchHandlerList2 = catchHandlerList;
        String str2 = str;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        String human = catchHandlerList2.toHuman(str2, sb2.append(Hex.m51u2(i3)).append(": ").toString());
        if (printWriter2 != null) {
            printWriter2.println(human);
        }
        annotatedOutput2.annotate(i4, human);
    }

    private void annotateEntries(String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        int i = 0;
        finishProcessingIfNecessary();
        boolean z = annotatedOutput2 != null;
        int i2 = z ? 6 : 0;
        int i3 = z ? 2 : 0;
        int size = this.table.size();
        StringBuilder sb7 = sb;
        StringBuilder sb8 = new StringBuilder();
        String sb9 = sb7.append(str2).append("  ").toString();
        if (z) {
            AnnotatedOutput annotatedOutput3 = annotatedOutput2;
            StringBuilder sb10 = sb6;
            StringBuilder sb11 = new StringBuilder();
            annotatedOutput3.annotate(0, sb10.append(str2).append("tries:").toString());
        } else {
            PrintWriter printWriter3 = printWriter2;
            StringBuilder sb12 = sb2;
            StringBuilder sb13 = new StringBuilder();
            printWriter3.println(sb12.append(str2).append("tries:").toString());
        }
        for (int i4 = 0; i4 < size; i4++) {
            Entry entry = this.table.get(i4);
            CatchHandlerList handlers = entry.getHandlers();
            StringBuilder sb14 = sb5;
            StringBuilder sb15 = new StringBuilder();
            String sb16 = sb14.append(sb9).append("try ").append(Hex.u2or4(entry.getStart())).append("..").append(Hex.u2or4(entry.getEnd())).toString();
            String human = handlers.toHuman(sb9, LibrariesRepository.MOJANG_MAVEN_REPO);
            if (z) {
                annotatedOutput2.annotate(i2, sb16);
                annotatedOutput2.annotate(i3, human);
            } else {
                printWriter2.println(sb16);
                printWriter2.println(human);
            }
        }
        if (z) {
            AnnotatedOutput annotatedOutput4 = annotatedOutput2;
            StringBuilder sb17 = sb3;
            StringBuilder sb18 = new StringBuilder();
            annotatedOutput4.annotate(0, sb17.append(str2).append("handlers:").toString());
            AnnotatedOutput annotatedOutput5 = annotatedOutput2;
            int i5 = this.encodedHandlerHeaderSize;
            StringBuilder sb19 = sb4;
            StringBuilder sb20 = new StringBuilder();
            annotatedOutput5.annotate(i5, sb19.append(sb9).append("size: ").append(Hex.m51u2(this.handlerOffsets.size())).toString());
            CatchHandlerList catchHandlerList = null;
            for (Map.Entry entry2 : this.handlerOffsets.entrySet()) {
                CatchHandlerList catchHandlerList2 = (CatchHandlerList) entry2.getKey();
                int intValue = ((Integer) entry2.getValue()).intValue();
                if (catchHandlerList != null) {
                    annotateAndConsumeHandlers(catchHandlerList, i, intValue - i, sb9, printWriter2, annotatedOutput2);
                }
                catchHandlerList = catchHandlerList2;
                i = intValue;
            }
            annotateAndConsumeHandlers(catchHandlerList, i, this.encodedHandlers.length - i, sb9, printWriter2, annotatedOutput2);
        }
    }

    private void finishProcessingIfNecessary() {
        if (this.table == null) {
            this.table = this.code.getCatches();
        }
    }

    public void debugPrint(PrintWriter printWriter, String str) {
        annotateEntries(str, printWriter, null);
    }

    public void encode(DexFile dexFile) {
        TreeMap treeMap;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        int i;
        UnsupportedOperationException unsupportedOperationException;
        DexFile dexFile2 = dexFile;
        finishProcessingIfNecessary();
        TypeIdsSection typeIds = dexFile2.getTypeIds();
        int size = this.table.size();
        TreeMap treeMap2 = treeMap;
        TreeMap treeMap3 = new TreeMap();
        this.handlerOffsets = treeMap2;
        for (int i2 = 0; i2 < size; i2++) {
            Object put = this.handlerOffsets.put(this.table.get(i2).getHandlers(), null);
        }
        if (this.handlerOffsets.size() > 65535) {
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException("too many catch handlers");
            throw unsupportedOperationException2;
        }
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput();
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
        this.encodedHandlerHeaderSize = byteArrayAnnotatedOutput4.writeUleb128(this.handlerOffsets.size());
        for (Map.Entry entry : this.handlerOffsets.entrySet()) {
            CatchHandlerList catchHandlerList = (CatchHandlerList) entry.getKey();
            int size2 = catchHandlerList.size();
            boolean catchesAll = catchHandlerList.catchesAll();
            Object value = entry.setValue(Integer.valueOf(byteArrayAnnotatedOutput4.getCursor()));
            if (catchesAll) {
                int writeSleb128 = byteArrayAnnotatedOutput4.writeSleb128(-(size2 - 1));
                i = size2 - 1;
            } else {
                int writeSleb1282 = byteArrayAnnotatedOutput4.writeSleb128(size2);
                i = size2;
            }
            for (int i3 = 0; i3 < i; i3++) {
                CatchHandlerList.Entry entry2 = catchHandlerList.get(i3);
                int writeUleb128 = byteArrayAnnotatedOutput4.writeUleb128(typeIds.indexOf(entry2.getExceptionType()));
                int writeUleb1282 = byteArrayAnnotatedOutput4.writeUleb128(entry2.getHandler());
            }
            if (catchesAll) {
                int writeUleb1283 = byteArrayAnnotatedOutput4.writeUleb128(catchHandlerList.get(i).getHandler());
            }
        }
        this.encodedHandlers = byteArrayAnnotatedOutput4.toByteArray();
    }

    public int triesSize() {
        finishProcessingIfNecessary();
        return this.table.size();
    }

    public int writeSize() {
        return (8 * triesSize()) + this.encodedHandlers.length;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        UnsupportedOperationException unsupportedOperationException;
        StringBuilder sb;
        DexFile dexFile2 = dexFile;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        finishProcessingIfNecessary();
        if (annotatedOutput2.annotates()) {
            annotateEntries("  ", null, annotatedOutput2);
        }
        int size = this.table.size();
        for (int i = 0; i < size; i++) {
            Entry entry = this.table.get(i);
            int start = entry.getStart();
            int end = entry.getEnd();
            int i2 = end - start;
            if (i2 >= 65536) {
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(sb2.append("bogus exception range: ").append(Hex.m53u4(start)).append("..").append(Hex.m53u4(end)).toString());
                throw unsupportedOperationException2;
            }
            annotatedOutput2.writeInt(start);
            annotatedOutput2.writeShort(i2);
            annotatedOutput2.writeShort(((Integer) this.handlerOffsets.get(entry.getHandlers())).intValue());
        }
        annotatedOutput2.write(this.encodedHandlers);
    }
}

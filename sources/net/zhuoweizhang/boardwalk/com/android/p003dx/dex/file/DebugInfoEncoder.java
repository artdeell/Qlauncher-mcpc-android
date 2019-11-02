package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import android.support.p000v4.view.InputDeviceCompat;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList.Disposition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList.Entry;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.PositionList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.code.RegisterSpec;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.AnnotatedOutput;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArrayAnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoEncoder */
public final class DebugInfoEncoder {
    private static final boolean DEBUG = false;
    private int address = 0;
    private AnnotatedOutput annotateTo;
    private final int codeSize;
    private PrintWriter debugPrint;
    private final Prototype desc;
    private final DexFile file;
    private final boolean isStatic;
    private final Entry[] lastEntryForReg;
    private int line = 1;
    private final LocalList locals;
    private final ByteArrayAnnotatedOutput output;
    private final PositionList positions;
    private String prefix;
    private final int regSize;
    private boolean shouldConsume;

    public DebugInfoEncoder(PositionList positionList, LocalList localList, DexFile dexFile, int i, int i2, boolean z, CstMethodRef cstMethodRef) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        PositionList positionList2 = positionList;
        LocalList localList2 = localList;
        DexFile dexFile2 = dexFile;
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        this.positions = positionList2;
        this.locals = localList2;
        this.file = dexFile2;
        this.desc = cstMethodRef2.getPrototype();
        this.isStatic = z2;
        this.codeSize = i3;
        this.regSize = i4;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput();
        this.output = byteArrayAnnotatedOutput2;
        this.lastEntryForReg = new Entry[i4];
    }

    private void annotate(int i, String str) {
        StringBuilder sb;
        int i2 = i;
        String str2 = str;
        if (this.prefix != null) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            str2 = sb2.append(this.prefix).append(str2).toString();
        }
        if (this.annotateTo != null) {
            AnnotatedOutput annotatedOutput = this.annotateTo;
            if (!this.shouldConsume) {
                i2 = 0;
            }
            annotatedOutput.annotate(i2, str2);
        }
        if (this.debugPrint != null) {
            this.debugPrint.println(str2);
        }
    }

    private ArrayList<PositionList.Entry> buildSortedPositions() {
        ArrayList arrayList;
        C06651 r8;
        int size = this.positions == null ? 0 : this.positions.size();
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(size);
        ArrayList arrayList4 = arrayList2;
        for (int i = 0; i < size; i++) {
            boolean add = arrayList4.add(this.positions.get(i));
        }
        ArrayList arrayList5 = arrayList4;
        C06651 r5 = r8;
        C06651 r6 = new Comparator<PositionList.Entry>(this) {
            final /* synthetic */ DebugInfoEncoder this$0;

            {
                this.this$0 = r5;
            }

            public int compare(PositionList.Entry entry, PositionList.Entry entry2) {
                return entry.getAddress() - entry2.getAddress();
            }

            public boolean equals(Object obj) {
                return obj == this;
            }
        };
        Collections.sort(arrayList5, r5);
        return arrayList4;
    }

    private static int computeOpcode(int i, int i2) {
        RuntimeException runtimeException;
        int i3 = i;
        int i4 = i2;
        if (i3 >= -4 && i3 <= 10) {
            return 10 + i3 + 4 + (i4 * 15);
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("Parameter out of range");
        throw runtimeException2;
    }

    private byte[] convert0() throws IOException {
        int i;
        int i2 = 0;
        ArrayList buildSortedPositions = buildSortedPositions();
        emitHeader(buildSortedPositions, extractMethodArguments());
        this.output.writeByte(7);
        if (!(this.annotateTo == null && this.debugPrint == null)) {
            annotate(1, String.format("%04x: prologue end", new Object[]{Integer.valueOf(this.address)}));
        }
        int size = buildSortedPositions.size();
        int size2 = this.locals.size();
        int i3 = 0;
        while (true) {
            int emitLocalsAtAddress = emitLocalsAtAddress(i2);
            int emitPositionsAtAddress = emitPositionsAtAddress(i3, buildSortedPositions);
            int i4 = emitLocalsAtAddress < size2 ? this.locals.get(emitLocalsAtAddress).getAddress() : Integer.MAX_VALUE;
            int i5 = emitPositionsAtAddress < size ? ((PositionList.Entry) buildSortedPositions.get(emitPositionsAtAddress)).getAddress() : Integer.MAX_VALUE;
            int min = Math.min(i5, i4);
            if (min != Integer.MAX_VALUE) {
                if (min == this.codeSize && i4 == Integer.MAX_VALUE && i5 == Integer.MAX_VALUE) {
                    break;
                }
                if (min == i5) {
                    int i6 = emitPositionsAtAddress + 1;
                    emitPosition((PositionList.Entry) buildSortedPositions.get(emitPositionsAtAddress));
                    i = i6;
                } else {
                    emitAdvancePc(min - this.address);
                    i = emitPositionsAtAddress;
                }
                i3 = i;
                i2 = emitLocalsAtAddress;
            } else {
                break;
            }
        }
        emitEndSequence();
        return this.output.toByteArray();
    }

    private void emitAdvanceLine(int i) throws IOException {
        int i2 = i;
        int cursor = this.output.getCursor();
        this.output.writeByte(2);
        int writeSleb128 = this.output.writeSleb128(i2);
        this.line = i2 + this.line;
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("line = %d", new Object[]{Integer.valueOf(this.line)}));
        }
    }

    private void emitAdvancePc(int i) throws IOException {
        int i2 = i;
        int cursor = this.output.getCursor();
        this.output.writeByte(1);
        int writeUleb128 = this.output.writeUleb128(i2);
        this.address = i2 + this.address;
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: advance pc", new Object[]{Integer.valueOf(this.address)}));
        }
    }

    private void emitEndSequence() {
        this.output.writeByte(0);
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(1, "end sequence");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void emitHeader(java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.PositionList.Entry> r35, java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList.Entry> r36) throws java.io.IOException {
        /*
            r34 = this;
            r2 = r34
            r3 = r35
            r4 = r36
            r29 = 0
            r5 = r29
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.AnnotatedOutput r0 = r0.annotateTo
            r29 = r0
            if (r29 != 0) goto L_0x001e
            r29 = r2
            r0 = r29
            java.io.PrintWriter r0 = r0.debugPrint
            r29 = r0
            if (r29 == 0) goto L_0x023d
        L_0x001e:
            r29 = 1
            r6 = r29
        L_0x0022:
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r29 = r0
            int r29 = r29.getCursor()
            r7 = r29
            r29 = r3
            int r29 = r29.size()
            if (r29 <= 0) goto L_0x0052
            r29 = r2
            r30 = r3
            r31 = 0
            java.lang.Object r30 = r30.get(r31)
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.PositionList$Entry r30 = (net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.PositionList.Entry) r30
            net.zhuoweizhang.boardwalk.com.android.dx.rop.code.SourcePosition r30 = r30.getPosition()
            int r30 = r30.getLine()
            r0 = r30
            r1 = r29
            r1.line = r0
        L_0x0052:
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r29 = r0
            r30 = r2
            r0 = r30
            int r0 = r0.line
            r30 = r0
            int r29 = r29.writeUleb128(r30)
            r29 = r6
            if (r29 == 0) goto L_0x00a0
            r29 = r2
            r30 = r2
            r0 = r30
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r30 = r0
            int r30 = r30.getCursor()
            r31 = r7
            int r30 = r30 - r31
            java.lang.StringBuilder r31 = new java.lang.StringBuilder
            r33 = r31
            r31 = r33
            r32 = r33
            r32.<init>()
            java.lang.String r32 = "line_start: "
            java.lang.StringBuilder r31 = r31.append(r32)
            r32 = r2
            r0 = r32
            int r0 = r0.line
            r32 = r0
            java.lang.StringBuilder r31 = r31.append(r32)
            java.lang.String r31 = r31.toString()
            r29.annotate(r30, r31)
        L_0x00a0:
            r29 = r2
            int r29 = r29.getParamBase()
            r9 = r29
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Prototype r0 = r0.desc
            r29 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.StdTypeList r29 = r29.getParameterTypes()
            r10 = r29
            r29 = r10
            int r29 = r29.size()
            r11 = r29
            r29 = r2
            r0 = r29
            boolean r0 = r0.isStatic
            r29 = r0
            if (r29 != 0) goto L_0x02a0
            r29 = r4
            java.util.Iterator r29 = r29.iterator()
            r27 = r29
        L_0x00d0:
            r29 = r27
            boolean r29 = r29.hasNext()
            if (r29 == 0) goto L_0x00fe
            r29 = r27
            java.lang.Object r29 = r29.next()
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$Entry r29 = (net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList.Entry) r29
            r28 = r29
            r29 = r9
            r30 = r28
            int r30 = r30.getRegister()
            r0 = r29
            r1 = r30
            if (r0 != r1) goto L_0x00d0
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$Entry[] r0 = r0.lastEntryForReg
            r29 = r0
            r30 = r9
            r31 = r28
            r29[r30] = r31
        L_0x00fe:
            r29 = r9
            r30 = 1
            int r29 = r29 + 1
            r12 = r29
        L_0x0106:
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r29 = r0
            int r29 = r29.getCursor()
            r13 = r29
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r29 = r0
            r30 = r11
            int r29 = r29.writeUleb128(r30)
            r29 = r6
            if (r29 == 0) goto L_0x015d
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r29 = r0
            int r29 = r29.getCursor()
            r30 = r13
            int r29 = r29 - r30
            r25 = r29
            r29 = 1
            r0 = r29
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r29 = r0
            r26 = r29
            r29 = r26
            r30 = 0
            r31 = r11
            java.lang.Integer r31 = java.lang.Integer.valueOf(r31)
            r29[r30] = r31
            r29 = r2
            r30 = r25
            java.lang.String r31 = "parameters_size: %04x"
            r32 = r26
            java.lang.String r31 = java.lang.String.format(r31, r32)
            r29.annotate(r30, r31)
        L_0x015d:
            r29 = 0
            r15 = r29
            r29 = r12
            r16 = r29
        L_0x0165:
            r29 = r15
            r30 = r11
            r0 = r29
            r1 = r30
            if (r0 >= r1) goto L_0x025d
            r29 = r10
            r30 = r15
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r29 = r29.get(r30)
            r20 = r29
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r29 = r0
            int r29 = r29.getCursor()
            r21 = r29
            r29 = r4
            java.util.Iterator r29 = r29.iterator()
            r22 = r29
        L_0x018f:
            r29 = r22
            boolean r29 = r29.hasNext()
            if (r29 == 0) goto L_0x029a
            r29 = r22
            java.lang.Object r29 = r29.next()
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$Entry r29 = (net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList.Entry) r29
            r23 = r29
            r29 = r16
            r30 = r23
            int r30 = r30.getRegister()
            r0 = r29
            r1 = r30
            if (r0 != r1) goto L_0x018f
            r29 = r23
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r29 = r29.getSignature()
            if (r29 == 0) goto L_0x0243
            r29 = r2
            r30 = 0
            r29.emitStringIndex(r30)
        L_0x01be:
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$Entry[] r0 = r0.lastEntryForReg
            r29 = r0
            r30 = r16
            r31 = r23
            r29[r30] = r31
        L_0x01cc:
            r29 = r23
            if (r29 != 0) goto L_0x01d7
            r29 = r2
            r30 = 0
            r29.emitStringIndex(r30)
        L_0x01d7:
            r29 = r6
            if (r29 == 0) goto L_0x022d
            r29 = r23
            if (r29 == 0) goto L_0x01e7
            r29 = r23
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r29 = r29.getSignature()
            if (r29 == 0) goto L_0x0250
        L_0x01e7:
            java.lang.String r29 = "<unnamed>"
            r24 = r29
        L_0x01eb:
            r29 = r2
            r30 = r2
            r0 = r30
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArrayAnnotatedOutput r0 = r0.output
            r30 = r0
            int r30 = r30.getCursor()
            r31 = r21
            int r30 = r30 - r31
            java.lang.StringBuilder r31 = new java.lang.StringBuilder
            r33 = r31
            r31 = r33
            r32 = r33
            r32.<init>()
            java.lang.String r32 = "parameter "
            java.lang.StringBuilder r31 = r31.append(r32)
            r32 = r24
            java.lang.StringBuilder r31 = r31.append(r32)
            java.lang.String r32 = " "
            java.lang.StringBuilder r31 = r31.append(r32)
            java.lang.String r32 = "v"
            java.lang.StringBuilder r31 = r31.append(r32)
            r32 = r16
            java.lang.StringBuilder r31 = r31.append(r32)
            java.lang.String r31 = r31.toString()
            r29.annotate(r30, r31)
        L_0x022d:
            r29 = r16
            r30 = r20
            int r30 = r30.getCategory()
            int r29 = r29 + r30
            r16 = r29
            int r15 = r15 + 1
            goto L_0x0165
        L_0x023d:
            r29 = 0
            r6 = r29
            goto L_0x0022
        L_0x0243:
            r29 = r2
            r30 = r23
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r30 = r30.getName()
            r29.emitStringIndex(r30)
            goto L_0x01be
        L_0x0250:
            r29 = r23
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r29 = r29.getName()
            java.lang.String r29 = r29.toHuman()
            r24 = r29
            goto L_0x01eb
        L_0x025d:
            r29 = r2
            r0 = r29
            net.zhuoweizhang.boardwalk.com.android.dx.dex.code.LocalList$Entry[] r0 = r0.lastEntryForReg
            r29 = r0
            r17 = r29
            r29 = r17
            r0 = r29
            int r0 = r0.length
            r29 = r0
            r18 = r29
        L_0x0270:
            r29 = r5
            r30 = r18
            r0 = r29
            r1 = r30
            if (r0 >= r1) goto L_0x0299
            r29 = r17
            r30 = r5
            r29 = r29[r30]
            r19 = r29
            r29 = r19
            if (r29 != 0) goto L_0x0289
        L_0x0286:
            int r5 = r5 + 1
            goto L_0x0270
        L_0x0289:
            r29 = r19
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r29 = r29.getSignature()
            if (r29 == 0) goto L_0x0286
            r29 = r2
            r30 = r19
            r29.emitLocalStartExtended(r30)
            goto L_0x0286
        L_0x0299:
            return
        L_0x029a:
            r29 = 0
            r23 = r29
            goto L_0x01cc
        L_0x02a0:
            r29 = r9
            r12 = r29
            goto L_0x0106
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.DebugInfoEncoder.emitHeader(java.util.ArrayList, java.util.ArrayList):void");
    }

    private void emitLocalEnd(Entry entry) throws IOException {
        Entry entry2 = entry;
        int cursor = this.output.getCursor();
        this.output.writeByte(5);
        int writeUleb128 = this.output.writeUleb128(entry2.getRegister());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: -local %s", new Object[]{Integer.valueOf(this.address), entryAnnotationString(entry2)}));
        }
    }

    private void emitLocalRestart(Entry entry) throws IOException {
        Entry entry2 = entry;
        int cursor = this.output.getCursor();
        this.output.writeByte(6);
        emitUnsignedLeb128(entry2.getRegister());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: +local restart %s", new Object[]{Integer.valueOf(this.address), entryAnnotationString(entry2)}));
        }
    }

    private void emitLocalStart(Entry entry) throws IOException {
        Entry entry2 = entry;
        if (entry2.getSignature() != null) {
            emitLocalStartExtended(entry2);
            return;
        }
        int cursor = this.output.getCursor();
        this.output.writeByte(3);
        emitUnsignedLeb128(entry2.getRegister());
        emitStringIndex(entry2.getName());
        emitTypeIndex(entry2.getType());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: +local %s", new Object[]{Integer.valueOf(this.address), entryAnnotationString(entry2)}));
        }
    }

    private void emitLocalStartExtended(Entry entry) throws IOException {
        Entry entry2 = entry;
        int cursor = this.output.getCursor();
        this.output.writeByte(4);
        emitUnsignedLeb128(entry2.getRegister());
        emitStringIndex(entry2.getName());
        emitTypeIndex(entry2.getType());
        emitStringIndex(entry2.getSignature());
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(this.output.getCursor() - cursor, String.format("%04x: +localx %s", new Object[]{Integer.valueOf(this.address), entryAnnotationString(entry2)}));
        }
    }

    private int emitLocalsAtAddress(int i) throws IOException {
        RuntimeException runtimeException;
        int i2 = i;
        int size = this.locals.size();
        while (i2 < size && this.locals.get(i2).getAddress() == this.address) {
            int i3 = i2 + 1;
            Entry entry = this.locals.get(i2);
            int register = entry.getRegister();
            Entry entry2 = this.lastEntryForReg[register];
            if (entry == entry2) {
                i2 = i3;
            } else {
                this.lastEntryForReg[register] = entry;
                if (entry.isStart()) {
                    if (entry2 == null || !entry.matches(entry2)) {
                        emitLocalStart(entry);
                    } else if (entry2.isStart()) {
                        RuntimeException runtimeException2 = runtimeException;
                        RuntimeException runtimeException3 = new RuntimeException("shouldn't happen");
                        throw runtimeException2;
                    } else {
                        emitLocalRestart(entry);
                    }
                } else if (entry.getDisposition() != Disposition.END_REPLACED) {
                    emitLocalEnd(entry);
                }
                i2 = i3;
            }
        }
        return i2;
    }

    private void emitPosition(PositionList.Entry entry) throws IOException {
        int i;
        int i2;
        int i3;
        RuntimeException runtimeException;
        PositionList.Entry entry2 = entry;
        int line2 = entry2.getPosition().getLine();
        int i4 = line2 - this.line;
        int address2 = entry2.getAddress() - this.address;
        if (address2 < 0) {
            RuntimeException runtimeException2 = runtimeException;
            RuntimeException runtimeException3 = new RuntimeException("Position entries must be in ascending address order");
            throw runtimeException2;
        }
        if (i4 < -4 || i4 > 10) {
            emitAdvanceLine(i4);
            i4 = 0;
        }
        int computeOpcode = computeOpcode(i4, address2);
        if ((computeOpcode & InputDeviceCompat.SOURCE_ANY) > 0) {
            emitAdvancePc(address2);
            int computeOpcode2 = computeOpcode(i4, 0);
            if ((computeOpcode2 & InputDeviceCompat.SOURCE_ANY) > 0) {
                emitAdvanceLine(i4);
                i3 = computeOpcode(0, 0);
                i = 0;
                i2 = 0;
            } else {
                i2 = i4;
                i3 = computeOpcode2;
                i = 0;
            }
        } else {
            i = address2;
            i2 = i4;
            i3 = computeOpcode;
        }
        this.output.writeByte(i3);
        this.line = i2 + this.line;
        this.address = i + this.address;
        if (this.annotateTo != null || this.debugPrint != null) {
            annotate(1, String.format("%04x: line %d", new Object[]{Integer.valueOf(this.address), Integer.valueOf(this.line)}));
        }
    }

    private int emitPositionsAtAddress(int i, ArrayList<PositionList.Entry> arrayList) throws IOException {
        int i2 = i;
        ArrayList<PositionList.Entry> arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i2 < size && ((PositionList.Entry) arrayList2.get(i2)).getAddress() == this.address) {
            int i3 = i2 + 1;
            emitPosition((PositionList.Entry) arrayList2.get(i2));
            i2 = i3;
        }
        return i2;
    }

    private void emitStringIndex(CstString cstString) throws IOException {
        CstString cstString2 = cstString;
        if (cstString2 == null || this.file == null) {
            int writeUleb128 = this.output.writeUleb128(0);
        } else {
            int writeUleb1282 = this.output.writeUleb128(1 + this.file.getStringIds().indexOf(cstString2));
        }
    }

    private void emitTypeIndex(CstType cstType) throws IOException {
        CstType cstType2 = cstType;
        if (cstType2 == null || this.file == null) {
            int writeUleb128 = this.output.writeUleb128(0);
        } else {
            int writeUleb1282 = this.output.writeUleb128(1 + this.file.getTypeIds().indexOf(cstType2));
        }
    }

    private void emitUnsignedLeb128(int i) throws IOException {
        RuntimeException runtimeException;
        StringBuilder sb;
        int i2 = i;
        if (i2 < 0) {
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            RuntimeException runtimeException3 = new RuntimeException(sb2.append("Signed value where unsigned required: ").append(i2).toString());
            throw runtimeException2;
        }
        int writeUleb128 = this.output.writeUleb128(i2);
    }

    private String entryAnnotationString(Entry entry) {
        StringBuilder sb;
        Entry entry2 = entry;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = sb2;
        StringBuilder append = sb4.append(RegisterSpec.PREFIX);
        StringBuilder append2 = sb4.append(entry2.getRegister());
        StringBuilder append3 = sb4.append(' ');
        CstString name = entry2.getName();
        if (name == null) {
            StringBuilder append4 = sb4.append("null");
        } else {
            StringBuilder append5 = sb4.append(name.toHuman());
        }
        StringBuilder append6 = sb4.append(' ');
        CstType type = entry2.getType();
        if (type == null) {
            StringBuilder append7 = sb4.append("null");
        } else {
            StringBuilder append8 = sb4.append(type.toHuman());
        }
        CstString signature = entry2.getSignature();
        if (signature != null) {
            StringBuilder append9 = sb4.append(' ');
            StringBuilder append10 = sb4.append(signature.toHuman());
        }
        return sb4.toString();
    }

    private ArrayList<Entry> extractMethodArguments() {
        ArrayList arrayList;
        BitSet bitSet;
        C06662 r12;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(this.desc.getParameterTypes().size());
        ArrayList arrayList4 = arrayList2;
        int paramBase = getParamBase();
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(this.regSize - paramBase);
        BitSet bitSet4 = bitSet2;
        int size = this.locals.size();
        for (int i = 0; i < size; i++) {
            Entry entry = this.locals.get(i);
            int register = entry.getRegister();
            if (register >= paramBase && !bitSet4.get(register - paramBase)) {
                bitSet4.set(register - paramBase);
                boolean add = arrayList4.add(entry);
            }
        }
        ArrayList arrayList5 = arrayList4;
        C06662 r9 = r12;
        C06662 r10 = new Comparator<Entry>(this) {
            final /* synthetic */ DebugInfoEncoder this$0;

            {
                this.this$0 = r5;
            }

            public int compare(Entry entry, Entry entry2) {
                return entry.getRegister() - entry2.getRegister();
            }

            public boolean equals(Object obj) {
                return obj == this;
            }
        };
        Collections.sort(arrayList5, r9);
        return arrayList4;
    }

    private int getParamBase() {
        return (this.regSize - this.desc.getParameterTypes().getWordCount()) - (this.isStatic ? 0 : 1);
    }

    public byte[] convert() {
        try {
            return convert0();
        } catch (IOException e) {
            throw ExceptionWithContext.withContext(e, "...while encoding debug info");
        }
    }

    public byte[] convertAndAnnotate(String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput, boolean z) {
        PrintWriter printWriter2 = printWriter;
        AnnotatedOutput annotatedOutput2 = annotatedOutput;
        boolean z2 = z;
        this.prefix = str;
        this.debugPrint = printWriter2;
        this.annotateTo = annotatedOutput2;
        this.shouldConsume = z2;
        return convert();
    }
}

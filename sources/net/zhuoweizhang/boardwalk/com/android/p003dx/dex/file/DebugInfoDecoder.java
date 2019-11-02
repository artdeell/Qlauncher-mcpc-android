package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import net.zhuoweizhang.boardwalk.com.android.dex.Leb128;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvCode;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.DalvInsnList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.LocalList.Disposition;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.PositionList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.code.PositionList.Entry;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Prototype;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder */
public class DebugInfoDecoder {
    private int address = 0;
    private final int codesize;
    private final Prototype desc;
    private final byte[] encoded;
    private final DexFile file;
    private final boolean isStatic;
    private final LocalEntry[] lastEntryForReg;
    private int line = 1;
    private final ArrayList<LocalEntry> locals;
    private final ArrayList<PositionEntry> positions;
    private final int regSize;
    private final int thisStringIdx;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry */
    private static class LocalEntry {
        public int address;
        public boolean isStart;
        public int nameIndex;
        public int reg;
        public int signatureIndex;
        public int typeIndex;

        public LocalEntry(int i, boolean z, int i2, int i3, int i4, int i5) {
            boolean z2 = z;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            int i9 = i5;
            this.address = i;
            this.isStart = z2;
            this.reg = i6;
            this.nameIndex = i7;
            this.typeIndex = i8;
            this.signatureIndex = i9;
        }

        public String toString() {
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(this.address);
            objArr[1] = this.isStart ? "start" : "end";
            objArr[2] = Integer.valueOf(this.reg);
            objArr[3] = Integer.valueOf(this.nameIndex);
            objArr[4] = Integer.valueOf(this.typeIndex);
            objArr[5] = Integer.valueOf(this.signatureIndex);
            return String.format("[%x %s v%d %04x %04x %04x]", objArr);
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$PositionEntry */
    private static class PositionEntry {
        public int address;
        public int line;

        public PositionEntry(int i, int i2) {
            int i3 = i2;
            this.address = i;
            this.line = i3;
        }
    }

    DebugInfoDecoder(byte[] bArr, int i, int i2, boolean z, CstMethodRef cstMethodRef, DexFile dexFile) {
        ArrayList<PositionEntry> arrayList;
        ArrayList<LocalEntry> arrayList2;
        CstString cstString;
        NullPointerException nullPointerException;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        boolean z2 = z;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        DexFile dexFile2 = dexFile;
        if (bArr2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("encoded == null");
            throw nullPointerException2;
        }
        this.encoded = bArr2;
        this.isStatic = z2;
        this.desc = cstMethodRef2.getPrototype();
        this.file = dexFile2;
        this.regSize = i4;
        ArrayList<PositionEntry> arrayList3 = arrayList;
        ArrayList<PositionEntry> arrayList4 = new ArrayList<>();
        this.positions = arrayList3;
        ArrayList<LocalEntry> arrayList5 = arrayList2;
        ArrayList<LocalEntry> arrayList6 = new ArrayList<>();
        this.locals = arrayList5;
        this.codesize = i3;
        this.lastEntryForReg = new LocalEntry[i4];
        int i5 = -1;
        try {
            StringIdsSection stringIds = dexFile2.getStringIds();
            CstString cstString2 = cstString;
            CstString cstString3 = new CstString("this");
            i5 = stringIds.indexOf(cstString2);
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
        }
        this.thisStringIdx = i5;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 160 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0187 A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decode0() throws java.io.IOException {
        /*
            r46 = this;
            r2 = r46
            net.zhuoweizhang.boardwalk.com.android.dex.util.ByteArrayByteInput r37 = new net.zhuoweizhang.boardwalk.com.android.dex.util.ByteArrayByteInput
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = r2
            r0 = r39
            byte[] r0 = r0.encoded
            r39 = r0
            r38.<init>(r39)
            r3 = r37
            r37 = r2
            r38 = r3
            int r38 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readUnsignedLeb128(r38)
            r0 = r38
            r1 = r37
            r1.line = r0
            r37 = r3
            int r37 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readUnsignedLeb128(r37)
            r4 = r37
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Prototype r0 = r0.desc
            r37 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.StdTypeList r37 = r37.getParameterTypes()
            r5 = r37
            r37 = r2
            int r37 = r37.getParamBase()
            r6 = r37
            r37 = r4
            r38 = r5
            int r38 = r38.size()
            r0 = r37
            r1 = r38
            if (r0 == r1) goto L_0x005f
            java.lang.RuntimeException r37 = new java.lang.RuntimeException
            r45 = r37
            r37 = r45
            r38 = r45
            java.lang.String r39 = "Mismatch between parameters_size and prototype"
            r38.<init>(r39)
            throw r37
        L_0x005f:
            r37 = r2
            r0 = r37
            boolean r0 = r0.isStatic
            r37 = r0
            if (r37 != 0) goto L_0x00a6
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry r37 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = 0
            r40 = 1
            r41 = r6
            r42 = r2
            r0 = r42
            int r0 = r0.thisStringIdx
            r42 = r0
            r43 = 0
            r44 = 0
            r38.<init>(r39, r40, r41, r42, r43, r44)
            r7 = r37
            r37 = r2
            r0 = r37
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry> r0 = r0.locals
            r37 = r0
            r38 = r7
            boolean r37 = r37.add(r38)
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg
            r37 = r0
            r38 = r6
            r39 = r7
            r37[r38] = r39
            int r6 = r6 + 1
        L_0x00a6:
            r37 = 0
            r9 = r37
        L_0x00aa:
            r37 = r9
            r38 = r4
            r0 = r37
            r1 = r38
            if (r0 >= r1) goto L_0x0187
            r37 = r5
            r38 = r9
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r37 = r37.getType(r38)
            r34 = r37
            r37 = r2
            r38 = r3
            int r37 = r37.readStringIndex(r38)
            r35 = r37
            r37 = r35
            r38 = -1
            r0 = r37
            r1 = r38
            if (r0 != r1) goto L_0x0116
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry r37 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = 0
            r40 = 1
            r41 = r6
            r42 = -1
            r43 = 0
            r44 = 0
            r38.<init>(r39, r40, r41, r42, r43, r44)
            r36 = r37
        L_0x00eb:
            r37 = r2
            r0 = r37
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry> r0 = r0.locals
            r37 = r0
            r38 = r36
            boolean r37 = r37.add(r38)
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg
            r37 = r0
            r38 = r6
            r39 = r36
            r37[r38] = r39
            r37 = r6
            r38 = r34
            int r38 = r38.getCategory()
            int r37 = r37 + r38
            r6 = r37
            int r9 = r9 + 1
            goto L_0x00aa
        L_0x0116:
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry r37 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = 0
            r40 = 1
            r41 = r6
            r42 = r35
            r43 = 0
            r44 = 0
            r38.<init>(r39, r40, r41, r42, r43, r44)
            r36 = r37
            goto L_0x00eb
        L_0x0130:
            r37 = r3
            int r37 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readUnsignedLeb128(r37)
            r29 = r37
            r37 = r2
            r38 = r3
            int r37 = r37.readStringIndex(r38)
            r30 = r37
            r37 = r2
            r38 = r3
            int r37 = r37.readStringIndex(r38)
            r31 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry r37 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = r2
            r0 = r39
            int r0 = r0.address
            r39 = r0
            r40 = 1
            r41 = r29
            r42 = r30
            r43 = r31
            r44 = 0
            r38.<init>(r39, r40, r41, r42, r43, r44)
            r32 = r37
            r37 = r2
            r0 = r37
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry> r0 = r0.locals
            r37 = r0
            r38 = r32
            boolean r37 = r37.add(r38)
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg
            r37 = r0
            r38 = r29
            r39 = r32
            r37[r38] = r39
        L_0x0187:
            r37 = 255(0xff, float:3.57E-43)
            r38 = r3
            byte r38 = r38.readByte()
            r37 = r37 & r38
            r10 = r37
            r37 = r10
            switch(r37) {
                case 0: goto L_0x043f;
                case 1: goto L_0x03a6;
                case 2: goto L_0x03c0;
                case 3: goto L_0x0130;
                case 4: goto L_0x01c9;
                case 5: goto L_0x02e6;
                case 6: goto L_0x022c;
                case 7: goto L_0x0187;
                case 8: goto L_0x0187;
                case 9: goto L_0x0187;
                default: goto L_0x0198;
            }
        L_0x0198:
            r37 = r10
            r38 = 10
            r0 = r37
            r1 = r38
            if (r0 >= r1) goto L_0x03da
            java.lang.RuntimeException r37 = new java.lang.RuntimeException
            r45 = r37
            r37 = r45
            r38 = r45
            java.lang.StringBuilder r39 = new java.lang.StringBuilder
            r45 = r39
            r39 = r45
            r40 = r45
            r40.<init>()
            java.lang.String r40 = "Invalid extended opcode encountered "
            java.lang.StringBuilder r39 = r39.append(r40)
            r40 = r10
            java.lang.StringBuilder r39 = r39.append(r40)
            java.lang.String r39 = r39.toString()
            r38.<init>(r39)
            throw r37
        L_0x01c9:
            r37 = r3
            int r37 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readUnsignedLeb128(r37)
            r21 = r37
            r37 = r2
            r38 = r3
            int r37 = r37.readStringIndex(r38)
            r22 = r37
            r37 = r2
            r38 = r3
            int r37 = r37.readStringIndex(r38)
            r23 = r37
            r37 = r2
            r38 = r3
            int r37 = r37.readStringIndex(r38)
            r24 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry r37 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = r2
            r0 = r39
            int r0 = r0.address
            r39 = r0
            r40 = 1
            r41 = r21
            r42 = r22
            r43 = r23
            r44 = r24
            r38.<init>(r39, r40, r41, r42, r43, r44)
            r25 = r37
            r37 = r2
            r0 = r37
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry> r0 = r0.locals
            r37 = r0
            r38 = r25
            boolean r37 = r37.add(r38)
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg
            r37 = r0
            r38 = r21
            r39 = r25
            r37[r38] = r39
            goto L_0x0187
        L_0x022c:
            r37 = r3
            int r37 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readUnsignedLeb128(r37)
            r16 = r37
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg     // Catch:{ NullPointerException -> 0x0273 }
            r37 = r0
            r38 = r16
            r37 = r37[r38]     // Catch:{ NullPointerException -> 0x0273 }
            r18 = r37
            r37 = r18
            r0 = r37
            boolean r0 = r0.isStart     // Catch:{ NullPointerException -> 0x0273 }
            r37 = r0
            if (r37 == 0) goto L_0x029d
            java.lang.RuntimeException r37 = new java.lang.RuntimeException     // Catch:{ NullPointerException -> 0x0273 }
            r45 = r37
            r37 = r45
            r38 = r45
            java.lang.StringBuilder r39 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0273 }
            r45 = r39
            r39 = r45
            r40 = r45
            r40.<init>()     // Catch:{ NullPointerException -> 0x0273 }
            java.lang.String r40 = "nonsensical RESTART_LOCAL on live register v"
            java.lang.StringBuilder r39 = r39.append(r40)     // Catch:{ NullPointerException -> 0x0273 }
            r40 = r16
            java.lang.StringBuilder r39 = r39.append(r40)     // Catch:{ NullPointerException -> 0x0273 }
            java.lang.String r39 = r39.toString()     // Catch:{ NullPointerException -> 0x0273 }
            r38.<init>(r39)     // Catch:{ NullPointerException -> 0x0273 }
            throw r37     // Catch:{ NullPointerException -> 0x0273 }
        L_0x0273:
            r37 = move-exception
            r17 = r37
            java.lang.RuntimeException r37 = new java.lang.RuntimeException
            r45 = r37
            r37 = r45
            r38 = r45
            java.lang.StringBuilder r39 = new java.lang.StringBuilder
            r45 = r39
            r39 = r45
            r40 = r45
            r40.<init>()
            java.lang.String r40 = "Encountered RESTART_LOCAL on new v"
            java.lang.StringBuilder r39 = r39.append(r40)
            r40 = r16
            java.lang.StringBuilder r39 = r39.append(r40)
            java.lang.String r39 = r39.toString()
            r38.<init>(r39)
            throw r37
        L_0x029d:
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry r37 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry     // Catch:{ NullPointerException -> 0x0273 }
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = r2
            r0 = r39
            int r0 = r0.address     // Catch:{ NullPointerException -> 0x0273 }
            r39 = r0
            r40 = 1
            r41 = r16
            r42 = r18
            r0 = r42
            int r0 = r0.nameIndex     // Catch:{ NullPointerException -> 0x0273 }
            r42 = r0
            r43 = r18
            r0 = r43
            int r0 = r0.typeIndex     // Catch:{ NullPointerException -> 0x0273 }
            r43 = r0
            r44 = 0
            r38.<init>(r39, r40, r41, r42, r43, r44)     // Catch:{ NullPointerException -> 0x0273 }
            r19 = r37
            r37 = r2
            r0 = r37
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry> r0 = r0.locals
            r37 = r0
            r38 = r19
            boolean r37 = r37.add(r38)
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg
            r37 = r0
            r38 = r16
            r39 = r19
            r37[r38] = r39
            goto L_0x0187
        L_0x02e6:
            r37 = r3
            int r37 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readUnsignedLeb128(r37)
            r11 = r37
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg     // Catch:{ NullPointerException -> 0x032d }
            r37 = r0
            r38 = r11
            r37 = r37[r38]     // Catch:{ NullPointerException -> 0x032d }
            r13 = r37
            r37 = r13
            r0 = r37
            boolean r0 = r0.isStart     // Catch:{ NullPointerException -> 0x032d }
            r37 = r0
            if (r37 != 0) goto L_0x0357
            java.lang.RuntimeException r37 = new java.lang.RuntimeException     // Catch:{ NullPointerException -> 0x032d }
            r45 = r37
            r37 = r45
            r38 = r45
            java.lang.StringBuilder r39 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x032d }
            r45 = r39
            r39 = r45
            r40 = r45
            r40.<init>()     // Catch:{ NullPointerException -> 0x032d }
            java.lang.String r40 = "nonsensical END_LOCAL on dead register v"
            java.lang.StringBuilder r39 = r39.append(r40)     // Catch:{ NullPointerException -> 0x032d }
            r40 = r11
            java.lang.StringBuilder r39 = r39.append(r40)     // Catch:{ NullPointerException -> 0x032d }
            java.lang.String r39 = r39.toString()     // Catch:{ NullPointerException -> 0x032d }
            r38.<init>(r39)     // Catch:{ NullPointerException -> 0x032d }
            throw r37     // Catch:{ NullPointerException -> 0x032d }
        L_0x032d:
            r37 = move-exception
            r12 = r37
            java.lang.RuntimeException r37 = new java.lang.RuntimeException
            r45 = r37
            r37 = r45
            r38 = r45
            java.lang.StringBuilder r39 = new java.lang.StringBuilder
            r45 = r39
            r39 = r45
            r40 = r45
            r40.<init>()
            java.lang.String r40 = "Encountered END_LOCAL on new v"
            java.lang.StringBuilder r39 = r39.append(r40)
            r40 = r11
            java.lang.StringBuilder r39 = r39.append(r40)
            java.lang.String r39 = r39.toString()
            r38.<init>(r39)
            throw r37
        L_0x0357:
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry r37 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry     // Catch:{ NullPointerException -> 0x032d }
            r45 = r37
            r37 = r45
            r38 = r45
            r39 = r2
            r0 = r39
            int r0 = r0.address     // Catch:{ NullPointerException -> 0x032d }
            r39 = r0
            r40 = 0
            r41 = r11
            r42 = r13
            r0 = r42
            int r0 = r0.nameIndex     // Catch:{ NullPointerException -> 0x032d }
            r42 = r0
            r43 = r13
            r0 = r43
            int r0 = r0.typeIndex     // Catch:{ NullPointerException -> 0x032d }
            r43 = r0
            r44 = r13
            r0 = r44
            int r0 = r0.signatureIndex     // Catch:{ NullPointerException -> 0x032d }
            r44 = r0
            r38.<init>(r39, r40, r41, r42, r43, r44)     // Catch:{ NullPointerException -> 0x032d }
            r14 = r37
            r37 = r2
            r0 = r37
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry> r0 = r0.locals
            r37 = r0
            r38 = r14
            boolean r37 = r37.add(r38)
            r37 = r2
            r0 = r37
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$LocalEntry[] r0 = r0.lastEntryForReg
            r37 = r0
            r38 = r11
            r39 = r14
            r37[r38] = r39
            goto L_0x0187
        L_0x03a6:
            r37 = r2
            r38 = r2
            r0 = r38
            int r0 = r0.address
            r38 = r0
            r39 = r3
            int r39 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readUnsignedLeb128(r39)
            int r38 = r38 + r39
            r0 = r38
            r1 = r37
            r1.address = r0
            goto L_0x0187
        L_0x03c0:
            r37 = r2
            r38 = r2
            r0 = r38
            int r0 = r0.line
            r38 = r0
            r39 = r3
            int r39 = net.zhuoweizhang.boardwalk.com.android.dex.Leb128.readSignedLeb128(r39)
            int r38 = r38 + r39
            r0 = r38
            r1 = r37
            r1.line = r0
            goto L_0x0187
        L_0x03da:
            r37 = r10
            r38 = 10
            int r37 = r37 + -10
            r27 = r37
            r37 = r2
            r38 = r2
            r0 = r38
            int r0 = r0.address
            r38 = r0
            r39 = r27
            r40 = 15
            int r39 = r39 / 15
            int r38 = r38 + r39
            r0 = r38
            r1 = r37
            r1.address = r0
            r37 = r2
            r38 = r2
            r0 = r38
            int r0 = r0.line
            r38 = r0
            r39 = -4
            r40 = r27
            r41 = 15
            int r40 = r40 % 15
            int r39 = r39 + r40
            int r38 = r38 + r39
            r0 = r38
            r1 = r37
            r1.line = r0
            r37 = r2
            r0 = r37
            java.util.ArrayList<net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$PositionEntry> r0 = r0.positions
            r37 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$PositionEntry r38 = new net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DebugInfoDecoder$PositionEntry
            r45 = r38
            r38 = r45
            r39 = r45
            r40 = r2
            r0 = r40
            int r0 = r0.address
            r40 = r0
            r41 = r2
            r0 = r41
            int r0 = r0.line
            r41 = r0
            r39.<init>(r40, r41)
            boolean r37 = r37.add(r38)
            goto L_0x0187
        L_0x043f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file.DebugInfoDecoder.decode0():void");
    }

    private int getParamBase() {
        return (this.regSize - this.desc.getParameterTypes().getWordCount()) - (this.isStatic ? 0 : 1);
    }

    private int readStringIndex(ByteInput byteInput) throws IOException {
        return -1 + Leb128.readUnsignedLeb128(byteInput);
    }

    public static void validateEncode(byte[] bArr, DexFile dexFile, CstMethodRef cstMethodRef, DalvCode dalvCode, boolean z) {
        StringBuilder sb;
        byte[] bArr2 = bArr;
        DexFile dexFile2 = dexFile;
        CstMethodRef cstMethodRef2 = cstMethodRef;
        DalvCode dalvCode2 = dalvCode;
        boolean z2 = z;
        PositionList positions2 = dalvCode2.getPositions();
        LocalList locals2 = dalvCode2.getLocals();
        DalvInsnList insns = dalvCode2.getInsns();
        try {
            validateEncode0(bArr2, insns.codeSize(), insns.getRegistersSize(), z2, cstMethodRef2, dexFile2, positions2, locals2);
        } catch (RuntimeException e) {
            RuntimeException runtimeException = e;
            System.err.println("instructions:");
            insns.debugPrint((OutputStream) System.err, "  ", true);
            System.err.println("local list:");
            locals2.debugPrint(System.err, "  ");
            RuntimeException runtimeException2 = runtimeException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            throw ExceptionWithContext.withContext(runtimeException2, sb2.append("while processing ").append(cstMethodRef2.toHuman()).toString());
        }
    }

    private static void validateEncode0(byte[] bArr, int i, int i2, boolean z, CstMethodRef cstMethodRef, DexFile dexFile, PositionList positionList, LocalList localList) {
        DebugInfoDecoder debugInfoDecoder;
        boolean z2;
        RuntimeException runtimeException;
        StringBuilder sb;
        int i3;
        LocalEntry localEntry;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        int i4;
        boolean z3;
        RuntimeException runtimeException2;
        StringBuilder sb5;
        RuntimeException runtimeException3;
        StringBuilder sb6;
        PositionList positionList2 = positionList;
        LocalList localList2 = localList;
        DebugInfoDecoder debugInfoDecoder2 = debugInfoDecoder;
        DebugInfoDecoder debugInfoDecoder3 = new DebugInfoDecoder(bArr, i, i2, z, cstMethodRef, dexFile);
        DebugInfoDecoder debugInfoDecoder4 = debugInfoDecoder2;
        debugInfoDecoder4.decode();
        List<PositionEntry> positionList3 = debugInfoDecoder4.getPositionList();
        if (positionList3.size() != positionList2.size()) {
            RuntimeException runtimeException4 = runtimeException3;
            StringBuilder sb7 = sb6;
            StringBuilder sb8 = new StringBuilder();
            RuntimeException runtimeException5 = new RuntimeException(sb7.append("Decoded positions table not same size was ").append(positionList3.size()).append(" expected ").append(positionList2.size()).toString());
            throw runtimeException4;
        }
        for (PositionEntry positionEntry : positionList3) {
            int size = -1 + positionList2.size();
            while (true) {
                z3 = false;
                if (size < 0) {
                    break;
                }
                Entry entry = positionList2.get(size);
                if (positionEntry.line == entry.getPosition().getLine() && positionEntry.address == entry.getAddress()) {
                    z3 = true;
                    break;
                }
                size--;
            }
            if (!z3) {
                RuntimeException runtimeException6 = runtimeException2;
                StringBuilder sb9 = sb5;
                StringBuilder sb10 = new StringBuilder();
                RuntimeException runtimeException7 = new RuntimeException(sb9.append("Could not match position entry: ").append(positionEntry.address).append(", ").append(positionEntry.line).toString());
                throw runtimeException6;
            }
        }
        List<LocalEntry> locals2 = debugInfoDecoder4.getLocals();
        int i5 = debugInfoDecoder4.thisStringIdx;
        int size2 = locals2.size();
        int paramBase = debugInfoDecoder4.getParamBase();
        int i6 = 0;
        while (i6 < size2) {
            LocalEntry localEntry2 = (LocalEntry) locals2.get(i6);
            int i7 = localEntry2.nameIndex;
            if (i7 < 0 || i7 == i5) {
                int i8 = i6 + 1;
                while (true) {
                    if (i8 >= size2) {
                        break;
                    }
                    LocalEntry localEntry3 = (LocalEntry) locals2.get(i8);
                    if (localEntry3.address == 0) {
                        if (localEntry2.reg == localEntry3.reg && localEntry3.isStart) {
                            Object obj = locals2.set(i6, localEntry3);
                            Object remove = locals2.remove(i8);
                            i4 = size2 - 1;
                            break;
                        }
                        i8++;
                    } else {
                        i4 = size2;
                        break;
                    }
                }
                i6++;
                size2 = i4;
            }
            i4 = size2;
            i6++;
            size2 = i4;
        }
        int size3 = localList2.size();
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i9 >= size3) {
                z2 = false;
                break;
            }
            LocalList.Entry entry2 = localList2.get(i9);
            if (entry2.getDisposition() != Disposition.END_REPLACED) {
                i3 = i10;
                do {
                    localEntry = (LocalEntry) locals2.get(i3);
                    if (localEntry.nameIndex >= 0) {
                        break;
                    }
                    i3++;
                } while (i3 < size2);
                int i11 = localEntry.address;
                if (localEntry.reg != entry2.getRegister()) {
                    PrintStream printStream = System.err;
                    StringBuilder sb11 = sb2;
                    StringBuilder sb12 = new StringBuilder();
                    printStream.println(sb11.append("local register mismatch at orig ").append(i9).append(" / decoded ").append(i3).toString());
                    z2 = true;
                    break;
                }
                if (localEntry.isStart != entry2.isStart()) {
                    PrintStream printStream2 = System.err;
                    StringBuilder sb13 = sb3;
                    StringBuilder sb14 = new StringBuilder();
                    printStream2.println(sb13.append("local start/end mismatch at orig ").append(i9).append(" / decoded ").append(i3).toString());
                    z2 = true;
                    break;
                }
                if (i11 == entry2.getAddress() || (i11 == 0 && localEntry.reg >= paramBase)) {
                    i10 = i3 + 1;
                }
            }
            i9++;
        }
        PrintStream printStream3 = System.err;
        StringBuilder sb15 = sb4;
        StringBuilder sb16 = new StringBuilder();
        printStream3.println(sb15.append("local address mismatch at orig ").append(i9).append(" / decoded ").append(i3).toString());
        z2 = true;
        if (z2) {
            System.err.println("decoded locals:");
            for (LocalEntry localEntry4 : locals2) {
                PrintStream printStream4 = System.err;
                StringBuilder sb17 = sb;
                StringBuilder sb18 = new StringBuilder();
                printStream4.println(sb17.append("  ").append(localEntry4).toString());
            }
            RuntimeException runtimeException8 = runtimeException;
            RuntimeException runtimeException9 = new RuntimeException("local table problem");
            throw runtimeException8;
        }
    }

    public void decode() {
        try {
            decode0();
        } catch (Exception e) {
            throw ExceptionWithContext.withContext(e, "...while decoding debug info");
        }
    }

    public List<LocalEntry> getLocals() {
        return this.locals;
    }

    public List<PositionEntry> getPositionList() {
        return this.positions;
    }
}

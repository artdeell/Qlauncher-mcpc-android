package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.cst;

import java.util.BitSet;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.StdConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.cst.ConstantPoolParser */
public final class ConstantPoolParser {
    private final ByteArray bytes;
    private int endOffset = -1;
    private ParseObserver observer;
    private final int[] offsets;
    private final StdConstantPool pool;

    public ConstantPoolParser(ByteArray byteArray) {
        StdConstantPool stdConstantPool;
        ByteArray byteArray2 = byteArray;
        int unsignedShort = byteArray2.getUnsignedShort(8);
        this.bytes = byteArray2;
        StdConstantPool stdConstantPool2 = stdConstantPool;
        StdConstantPool stdConstantPool3 = new StdConstantPool(unsignedShort);
        this.pool = stdConstantPool2;
        this.offsets = new int[unsignedShort];
    }

    private void determineOffsets() {
        ParseException parseException;
        ParseException parseException2;
        ParseException parseException3;
        int i;
        StringBuilder sb;
        ParseException parseException4;
        StringBuilder sb2;
        int i2 = 10;
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 < this.offsets.length) {
                this.offsets[i4] = i2;
                int unsignedByte = this.bytes.getUnsignedByte(i2);
                switch (unsignedByte) {
                    case 1:
                        i2 += 3 + this.bytes.getUnsignedShort(i2 + 1);
                        i = 1;
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        i2 += 5;
                        i = 1;
                        break;
                    case 5:
                    case 6:
                        i = 2;
                        i2 += 9;
                        break;
                    case 7:
                    case 8:
                        i2 += 3;
                        i = 1;
                        break;
                    case 15:
                        ParseException parseException5 = parseException3;
                        ParseException parseException6 = new ParseException("MethodHandle not supported");
                        throw parseException5;
                    case 16:
                        ParseException parseException7 = parseException2;
                        ParseException parseException8 = new ParseException("MethodType not supported");
                        throw parseException7;
                    case 18:
                        ParseException parseException9 = parseException;
                        ParseException parseException10 = new ParseException("InvokeDynamic not supported");
                        throw parseException9;
                    default:
                        try {
                            ParseException parseException11 = parseException4;
                            StringBuilder sb3 = sb2;
                            StringBuilder sb4 = new StringBuilder();
                            ParseException parseException12 = new ParseException(sb3.append("unknown tag byte: ").append(Hex.m50u1(unsignedByte)).toString());
                            throw parseException11;
                        } catch (ParseException e) {
                            ParseException parseException13 = e;
                            ParseException parseException14 = parseException13;
                            StringBuilder sb5 = sb;
                            StringBuilder sb6 = new StringBuilder();
                            parseException14.addContext(sb5.append("...while preparsing cst ").append(Hex.m51u2(i4)).append(" at offset ").append(Hex.m53u4(i2)).toString());
                            throw parseException13;
                        }
                }
                i3 = i4 + i;
            } else {
                this.endOffset = i2;
                return;
            }
        }
    }

    private void parse() {
        BitSet bitSet;
        int i;
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        determineOffsets();
        if (this.observer != null) {
            ParseObserver parseObserver = this.observer;
            ByteArray byteArray = this.bytes;
            StringBuilder sb5 = sb4;
            StringBuilder sb6 = new StringBuilder();
            parseObserver.parsed(byteArray, 8, 2, sb5.append("constant_pool_count: ").append(Hex.m51u2(this.offsets.length)).toString());
            this.observer.parsed(this.bytes, 10, 0, "\nconstant_pool:");
            this.observer.changeIndent(1);
        }
        BitSet bitSet2 = bitSet;
        BitSet bitSet3 = new BitSet(this.offsets.length);
        BitSet bitSet4 = bitSet2;
        for (int i2 = 1; i2 < this.offsets.length; i2++) {
            if (this.offsets[i2] != 0 && this.pool.getOrNull(i2) == null) {
                Constant parse0 = parse0(i2, bitSet4);
            }
        }
        if (this.observer != null) {
            for (int i3 = 1; i3 < this.offsets.length; i3++) {
                Constant orNull = this.pool.getOrNull(i3);
                if (orNull != null) {
                    int i4 = this.offsets[i3];
                    int i5 = this.endOffset;
                    int i6 = i3 + 1;
                    while (true) {
                        if (i6 >= this.offsets.length) {
                            i = i5;
                            break;
                        }
                        int i7 = this.offsets[i6];
                        if (i7 != 0) {
                            i = i7;
                            break;
                        }
                        i6++;
                    }
                    if (bitSet4.get(i3)) {
                        StringBuilder sb7 = sb3;
                        StringBuilder sb8 = new StringBuilder();
                        sb2 = sb7.append(Hex.m51u2(i3)).append(": utf8{\"").append(orNull.toHuman()).append("\"}").toString();
                    } else {
                        StringBuilder sb9 = sb;
                        StringBuilder sb10 = new StringBuilder();
                        sb2 = sb9.append(Hex.m51u2(i3)).append(": ").append(orNull.toString()).toString();
                    }
                    this.observer.parsed(this.bytes, i4, i - i4, sb2);
                }
            }
            this.observer.changeIndent(-1);
            this.observer.parsed(this.bytes, this.endOffset, 0, "end constant_pool");
        }
    }

    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r10v26 */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r10v28 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: type inference failed for: r10v30 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r17v9 */
    /* JADX WARNING: type inference failed for: r10v32 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r10v34, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant] */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r17v10 */
    /* JADX WARNING: type inference failed for: r10v36 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r10v40, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstDouble] */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r10v44, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstLong] */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r10v48, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstFloat] */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r10v52, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger] */
    /* JADX WARNING: type inference failed for: r9v9 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r12v42, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant] */
    /* JADX WARNING: type inference failed for: r10v55 */
    /* JADX WARNING: type inference failed for: r0v1, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant] */
    /* JADX WARNING: type inference failed for: r10v57, types: [net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString] */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 20 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant parse0(int r19, java.util.BitSet r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.StdConstantPool r10 = r10.pool
            r11 = r1
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r10 = r10.getOrNull(r11)
            r3 = r10
            r10 = r3
            if (r10 == 0) goto L_0x0015
            r10 = r3
            r0 = r10
        L_0x0014:
            return r0
        L_0x0015:
            r10 = r0
            int[] r10 = r10.offsets
            r11 = r1
            r10 = r10[r11]
            r4 = r10
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r10 = r10.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11 = r4
            int r10 = r10.getUnsignedByte(r11)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r8 = r10
            r10 = r8
            switch(r10) {
                case 1: goto L_0x0088;
                case 2: goto L_0x0029;
                case 3: goto L_0x00a0;
                case 4: goto L_0x00b1;
                case 5: goto L_0x00c2;
                case 6: goto L_0x00d3;
                case 7: goto L_0x00e4;
                case 8: goto L_0x010c;
                case 9: goto L_0x0120;
                case 10: goto L_0x0155;
                case 11: goto L_0x018a;
                case 12: goto L_0x01bf;
                case 13: goto L_0x0029;
                case 14: goto L_0x0029;
                case 15: goto L_0x01f4;
                case 16: goto L_0x0244;
                case 17: goto L_0x0029;
                case 18: goto L_0x0252;
                default: goto L_0x0029;
            }     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
        L_0x0029:
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r10 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r12
            r12 = r17
            r13 = r17
            r13.<init>()     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            java.lang.String r13 = "unknown tag byte: "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r13 = r8
            java.lang.String r13 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m50u1(r13)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            java.lang.String r12 = r12.toString()     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11.<init>(r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            throw r10     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
        L_0x0053:
            r10 = move-exception
            r7 = r10
            r10 = r7
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r17 = r11
            r11 = r17
            r12 = r17
            r12.<init>()
            java.lang.String r12 = "...while parsing cst "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r1
            java.lang.String r12 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r12)
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = " at offset "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r4
            java.lang.String r12 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r12)
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.addContext(r11)
            r10 = r7
            throw r10
        L_0x0088:
            r10 = r0
            r11 = r4
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r10 = r10.parseUtf8(r11)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            r10 = r2
            r11 = r1
            r10.set(r11)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
        L_0x0094:
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.StdConstantPool r10 = r10.pool
            r11 = r1
            r12 = r9
            r10.set(r11, r12)
            r10 = r9
            r0 = r10
            goto L_0x0014
        L_0x00a0:
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r10 = r10.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11 = r4
            r12 = 1
            int r11 = r11 + 1
            int r10 = r10.getInt(r11)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInteger r10 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger.make(r10)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x00b1:
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r10 = r10.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11 = r4
            r12 = 1
            int r11 = r11 + 1
            int r10 = r10.getInt(r11)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstFloat r10 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFloat.make(r10)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x00c2:
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r10 = r10.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11 = r4
            r12 = 1
            int r11 = r11 + 1
            long r10 = r10.getLong(r11)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstLong r10 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLong.make(r10)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x00d3:
            r10 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r10 = r10.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11 = r4
            r12 = 1
            int r11 = r11 + 1
            long r10 = r10.getLong(r11)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstDouble r10 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstDouble.make(r10)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x00e4:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r10 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r0
            r13 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r13 = r13.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r4
            r15 = 1
            int r14 = r14 + 1
            int r13 = r13.getUnsignedShort(r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r12 = r12.parse0(r13, r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r12 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString) r12     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            java.lang.String r12 = r12.getString()     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.type.Type r12 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type.internClassName(r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11.<init>(r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x010c:
            r10 = r0
            r11 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r11 = r11.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r12 = r4
            r13 = 1
            int r12 = r12 + 1
            int r11 = r11.getUnsignedShort(r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r12 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r10 = r10.parse0(r11, r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x0120:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstFieldRef r10 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstFieldRef     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r0
            r13 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r13 = r13.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r4
            r15 = 1
            int r14 = r14 + 1
            int r13 = r13.getUnsignedShort(r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r12 = r12.parse0(r13, r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r12 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType) r12     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r13 = r0
            r14 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r14 = r14.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r4
            r16 = 3
            int r15 = r15 + 3
            int r14 = r14.getUnsignedShort(r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r13 = r13.parse0(r14, r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstNat r13 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat) r13     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11.<init>(r12, r13)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x0155:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstMethodRef r10 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstMethodRef     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r0
            r13 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r13 = r13.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r4
            r15 = 1
            int r14 = r14 + 1
            int r13 = r13.getUnsignedShort(r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r12 = r12.parse0(r13, r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r12 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType) r12     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r13 = r0
            r14 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r14 = r14.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r4
            r16 = 3
            int r15 = r15 + 3
            int r14 = r14.getUnsignedShort(r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r13 = r13.parse0(r14, r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstNat r13 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat) r13     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11.<init>(r12, r13)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x018a:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInterfaceMethodRef r10 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstInterfaceMethodRef     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r0
            r13 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r13 = r13.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r4
            r15 = 1
            int r14 = r14 + 1
            int r13 = r13.getUnsignedShort(r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r12 = r12.parse0(r13, r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r12 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType) r12     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r13 = r0
            r14 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r14 = r14.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r4
            r16 = 3
            int r15 = r15 + 3
            int r14 = r14.getUnsignedShort(r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r13 = r13.parse0(r14, r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstNat r13 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat) r13     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11.<init>(r12, r13)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x01bf:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstNat r10 = new net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstNat     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r0
            r13 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r13 = r13.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r4
            r15 = 1
            int r14 = r14 + 1
            int r13 = r13.getUnsignedShort(r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r14 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r12 = r12.parse0(r13, r14)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r12 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString) r12     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r13 = r0
            r14 = r0
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r14 = r14.bytes     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r4
            r16 = 3
            int r15 = r15 + 3
            int r14 = r14.getUnsignedShort(r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r15 = r2
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r13 = r13.parse0(r14, r15)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstString r13 = (net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString) r13     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r11.<init>(r12, r13)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r9 = r10
            goto L_0x0094
        L_0x01f4:
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r10 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            java.lang.String r12 = "MethodHandle not supported"
            r11.<init>(r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            throw r10     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
        L_0x0202:
            r10 = move-exception
            r5 = r10
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r10 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException
            r17 = r10
            r10 = r17
            r11 = r17
            r12 = r5
            r11.<init>(r12)
            r6 = r10
            r10 = r6
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r17 = r11
            r11 = r17
            r12 = r17
            r12.<init>()
            java.lang.String r12 = "...while parsing cst "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r1
            java.lang.String r12 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m51u2(r12)
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r12 = " at offset "
            java.lang.StringBuilder r11 = r11.append(r12)
            r12 = r4
            java.lang.String r12 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m53u4(r12)
            java.lang.StringBuilder r11 = r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.addContext(r11)
            r10 = r6
            throw r10
        L_0x0244:
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r10 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            java.lang.String r12 = "MethodType not supported"
            r11.<init>(r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            throw r10     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
        L_0x0252:
            net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException r10 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.iface.ParseException     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            r17 = r10
            r10 = r17
            r11 = r17
            java.lang.String r12 = "InvokeDynamic not supported"
            r11.<init>(r12)     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
            throw r10     // Catch:{ ParseException -> 0x0053, RuntimeException -> 0x0202 }
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.cst.ConstantPoolParser.parse0(int, java.util.BitSet):net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant");
    }

    private void parseIfNecessary() {
        if (this.endOffset < 0) {
            parse();
        }
    }

    private CstString parseUtf8(int i) {
        ParseException parseException;
        CstString cstString;
        int i2 = i;
        int i3 = i2 + 3;
        try {
            CstString cstString2 = cstString;
            CstString cstString3 = new CstString(this.bytes.slice(i3, this.bytes.getUnsignedShort(i2 + 1) + i3));
            return cstString2;
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            ParseException parseException2 = parseException;
            ParseException parseException3 = new ParseException((Throwable) illegalArgumentException);
            throw parseException2;
        }
    }

    public int getEndOffset() {
        parseIfNecessary();
        return this.endOffset;
    }

    public StdConstantPool getPool() {
        parseIfNecessary();
        return this.pool;
    }

    public void setObserver(ParseObserver parseObserver) {
        ParseObserver parseObserver2 = parseObserver;
        this.observer = parseObserver2;
    }
}

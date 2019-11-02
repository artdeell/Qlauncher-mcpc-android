package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code;

import java.util.ArrayList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstDouble;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFloat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstKnownNull;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLong;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Bits;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BytecodeArray */
public final class BytecodeArray {
    public static final Visitor EMPTY_VISITOR;
    private final ByteArray bytes;
    private final ConstantPool pool;

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BytecodeArray$BaseVisitor */
    public static class BaseVisitor implements Visitor {
        private int previousOffset = -1;

        BaseVisitor() {
        }

        public int getPreviousOffset() {
            return this.previousOffset;
        }

        public void setPreviousOffset(int i) {
            int i2 = i;
            this.previousOffset = i2;
        }

        public void visitBranch(int i, int i2, int i3, int i4) {
        }

        public void visitConstant(int i, int i2, int i3, Constant constant, int i4) {
        }

        public void visitInvalid(int i, int i2, int i3) {
        }

        public void visitLocal(int i, int i2, int i3, int i4, Type type, int i5) {
        }

        public void visitNewarray(int i, int i2, CstType cstType, ArrayList<Constant> arrayList) {
        }

        public void visitNoArgs(int i, int i2, int i3, Type type) {
        }

        public void visitSwitch(int i, int i2, int i3, SwitchList switchList, int i4) {
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BytecodeArray$ConstantParserVisitor */
    class ConstantParserVisitor extends BaseVisitor {
        Constant cst;
        int length;
        final /* synthetic */ BytecodeArray this$0;
        int value;

        ConstantParserVisitor(BytecodeArray bytecodeArray) {
            this.this$0 = bytecodeArray;
        }

        private void clear() {
            this.length = 0;
        }

        public int getPreviousOffset() {
            return -1;
        }

        public void setPreviousOffset(int i) {
        }

        public void visitBranch(int i, int i2, int i3, int i4) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            clear();
        }

        public void visitConstant(int i, int i2, int i3, Constant constant, int i4) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            this.cst = constant;
            this.length = i7;
            this.value = i8;
        }

        public void visitInvalid(int i, int i2, int i3) {
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            clear();
        }

        public void visitLocal(int i, int i2, int i3, int i4, Type type, int i5) {
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            Type type2 = type;
            int i10 = i5;
            clear();
        }

        public void visitNewarray(int i, int i2, CstType cstType, ArrayList<Constant> arrayList) {
            int i3 = i;
            int i4 = i2;
            CstType cstType2 = cstType;
            ArrayList<Constant> arrayList2 = arrayList;
            clear();
        }

        public void visitNoArgs(int i, int i2, int i3, Type type) {
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            Type type2 = type;
            clear();
        }

        public void visitSwitch(int i, int i2, int i3, SwitchList switchList, int i4) {
            int i5 = i;
            int i6 = i2;
            int i7 = i3;
            SwitchList switchList2 = switchList;
            int i8 = i4;
            clear();
        }
    }

    /* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BytecodeArray$Visitor */
    public interface Visitor {
        int getPreviousOffset();

        void setPreviousOffset(int i);

        void visitBranch(int i, int i2, int i3, int i4);

        void visitConstant(int i, int i2, int i3, Constant constant, int i4);

        void visitInvalid(int i, int i2, int i3);

        void visitLocal(int i, int i2, int i3, int i4, Type type, int i5);

        void visitNewarray(int i, int i2, CstType cstType, ArrayList<Constant> arrayList);

        void visitNoArgs(int i, int i2, int i3, Type type);

        void visitSwitch(int i, int i2, int i3, SwitchList switchList, int i4);
    }

    static {
        BaseVisitor baseVisitor;
        BaseVisitor baseVisitor2 = baseVisitor;
        BaseVisitor baseVisitor3 = new BaseVisitor();
        EMPTY_VISITOR = baseVisitor2;
    }

    public BytecodeArray(ByteArray byteArray, ConstantPool constantPool) {
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        ByteArray byteArray2 = byteArray;
        ConstantPool constantPool2 = constantPool;
        if (byteArray2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("bytes == null");
            throw nullPointerException3;
        } else if (constantPool2 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("pool == null");
            throw nullPointerException5;
        } else {
            this.bytes = byteArray2;
            this.pool = constantPool2;
        }
    }

    private int parseLookupswitch(int i, Visitor visitor) {
        SwitchList switchList;
        int i2 = i;
        Visitor visitor2 = visitor;
        int i3 = -4 & (i2 + 4);
        int i4 = 0;
        for (int i5 = i2 + 1; i5 < i3; i5++) {
            i4 = (i4 << 8) | this.bytes.getUnsignedByte(i5);
        }
        int i6 = i2 + this.bytes.getInt(i3);
        int i7 = this.bytes.getInt(i3 + 4);
        int i8 = i3 + 8;
        SwitchList switchList2 = switchList;
        SwitchList switchList3 = new SwitchList(i7);
        SwitchList switchList4 = switchList2;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = this.bytes.getInt(i8);
            int i11 = i2 + this.bytes.getInt(i8 + 4);
            i8 += 8;
            switchList4.add(i10, i11);
        }
        switchList4.setDefaultTarget(i6);
        switchList4.removeSuperfluousDefaults();
        switchList4.setImmutable();
        int i12 = i8 - i2;
        visitor2.visitSwitch(171, i2, i12, switchList4, i4);
        return i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x026b, code lost:
        r23 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0271  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseNewarray(int r31, net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray.Visitor r32) {
        /*
            r30 = this;
            r2 = r30
            r3 = r31
            r4 = r32
            r24 = r2
            r0 = r24
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r24 = r0
            r25 = r3
            r26 = 1
            int r25 = r25 + 1
            int r24 = r24.getUnsignedByte(r25)
            r5 = r24
            r24 = r5
            switch(r24) {
                case 4: goto L_0x004a;
                case 5: goto L_0x010a;
                case 6: goto L_0x0116;
                case 7: goto L_0x0110;
                case 8: goto L_0x011c;
                case 9: goto L_0x0122;
                case 10: goto L_0x0128;
                case 11: goto L_0x012e;
                default: goto L_0x001f;
            }
        L_0x001f:
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.SimException r24 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.code.SimException
            r29 = r24
            r24 = r29
            r25 = r29
            java.lang.StringBuilder r26 = new java.lang.StringBuilder
            r29 = r26
            r26 = r29
            r27 = r29
            r27.<init>()
            java.lang.String r27 = "bad newarray code "
            java.lang.StringBuilder r26 = r26.append(r27)
            r27 = r5
            java.lang.String r27 = net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex.m50u1(r27)
            java.lang.StringBuilder r26 = r26.append(r27)
            java.lang.String r26 = r26.toString()
            r25.<init>(r26)
            throw r24
        L_0x004a:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.BOOLEAN_ARRAY
            r6 = r24
        L_0x004e:
            r24 = r4
            int r24 = r24.getPreviousOffset()
            r7 = r24
            net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BytecodeArray$ConstantParserVisitor r24 = new net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BytecodeArray$ConstantParserVisitor
            r29 = r24
            r24 = r29
            r25 = r29
            r26 = r2
            r25.<init>(r26)
            r8 = r24
            r24 = r7
            if (r24 < 0) goto L_0x0277
            r24 = r2
            r25 = r7
            r26 = r8
            int r24 = r24.parseInstruction(r25, r26)
            r24 = r8
            r0 = r24
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r0 = r0.cst
            r24 = r0
            r0 = r24
            boolean r0 = r0 instanceof net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger
            r24 = r0
            if (r24 == 0) goto L_0x0277
            r24 = r7
            r25 = r8
            r0 = r25
            int r0 = r0.length
            r25 = r0
            int r24 = r24 + r25
            r25 = r3
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x0277
            r24 = r8
            r0 = r24
            int r0 = r0.value
            r24 = r0
            r9 = r24
        L_0x00a1:
            r24 = r3
            r25 = 2
            int r24 = r24 + 2
            r10 = r24
            java.util.ArrayList r24 = new java.util.ArrayList
            r29 = r24
            r24 = r29
            r25 = r29
            r25.<init>()
            r11 = r24
            r24 = r9
            if (r24 == 0) goto L_0x0271
            r24 = r10
            r13 = r24
            r24 = 0
            r12 = r24
        L_0x00c2:
            r24 = r2
            r0 = r24
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r24 = r0
            r14 = r24
            r24 = r13
            r25 = 1
            int r24 = r24 + 1
            r15 = r24
            r24 = r14
            r25 = r13
            int r24 = r24.getUnsignedByte(r25)
            r25 = 89
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x0134
        L_0x00e4:
            r24 = r12
            r25 = 2
            r0 = r24
            r1 = r25
            if (r0 < r1) goto L_0x00f8
            r24 = r12
            r25 = r9
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x0250
        L_0x00f8:
            r24 = r4
            r25 = r3
            r26 = 2
            r27 = r6
            r28 = 0
            r24.visitNewarray(r25, r26, r27, r28)
            r24 = 2
            r2 = r24
        L_0x0109:
            return r2
        L_0x010a:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.CHAR_ARRAY
            r6 = r24
            goto L_0x004e
        L_0x0110:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.DOUBLE_ARRAY
            r6 = r24
            goto L_0x004e
        L_0x0116:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.FLOAT_ARRAY
            r6 = r24
            goto L_0x004e
        L_0x011c:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.BYTE_ARRAY
            r6 = r24
            goto L_0x004e
        L_0x0122:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.SHORT_ARRAY
            r6 = r24
            goto L_0x004e
        L_0x0128:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.INT_ARRAY
            r6 = r24
            goto L_0x004e
        L_0x012e:
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.CstType r24 = net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType.LONG_ARRAY
            r6 = r24
            goto L_0x004e
        L_0x0134:
            r24 = r2
            r25 = r15
            r26 = r8
            int r24 = r24.parseInstruction(r25, r26)
            r24 = r8
            r0 = r24
            int r0 = r0.length
            r24 = r0
            if (r24 == 0) goto L_0x00e4
            r24 = r8
            r0 = r24
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r0 = r0.cst
            r24 = r0
            r0 = r24
            boolean r0 = r0 instanceof net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstInteger
            r24 = r0
            if (r24 == 0) goto L_0x00e4
            r24 = r8
            r0 = r24
            int r0 = r0.value
            r24 = r0
            r25 = r12
            r0 = r24
            r1 = r25
            if (r0 != r1) goto L_0x00e4
            r24 = r15
            r25 = r8
            r0 = r25
            int r0 = r0.length
            r25 = r0
            int r24 = r24 + r25
            r17 = r24
            r24 = r2
            r25 = r17
            r26 = r8
            int r24 = r24.parseInstruction(r25, r26)
            r24 = r8
            r0 = r24
            int r0 = r0.length
            r24 = r0
            if (r24 == 0) goto L_0x00e4
            r24 = r8
            r0 = r24
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r0 = r0.cst
            r24 = r0
            r0 = r24
            boolean r0 = r0 instanceof net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstLiteralBits
            r24 = r0
            if (r24 == 0) goto L_0x00e4
            r24 = r17
            r25 = r8
            r0 = r25
            int r0 = r0.length
            r25 = r0
            int r24 = r24 + r25
            r19 = r24
            r24 = r11
            r25 = r8
            r0 = r25
            net.zhuoweizhang.boardwalk.com.android.dx.rop.cst.Constant r0 = r0.cst
            r25 = r0
            boolean r24 = r24.add(r25)
            r24 = r2
            r0 = r24
            net.zhuoweizhang.boardwalk.com.android.dx.util.ByteArray r0 = r0.bytes
            r24 = r0
            r21 = r24
            r24 = r19
            r25 = 1
            int r24 = r24 + 1
            r13 = r24
            r24 = r21
            r25 = r19
            int r24 = r24.getUnsignedByte(r25)
            r22 = r24
            r24 = r5
            switch(r24) {
                case 4: goto L_0x01e7;
                case 5: goto L_0x01f6;
                case 6: goto L_0x0214;
                case 7: goto L_0x0205;
                case 8: goto L_0x01e7;
                case 9: goto L_0x0223;
                case 10: goto L_0x0232;
                case 11: goto L_0x0241;
                default: goto L_0x01d7;
            }
        L_0x01d7:
            r24 = 1
            r23 = r24
        L_0x01db:
            r24 = r23
            if (r24 != 0) goto L_0x00e4
            int r12 = r12 + 1
            r24 = r13
            r10 = r24
            goto L_0x00c2
        L_0x01e7:
            r24 = r22
            r25 = 84
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x026b
            r24 = 1
            r23 = r24
            goto L_0x01db
        L_0x01f6:
            r24 = r22
            r25 = 85
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x026b
            r24 = 1
            r23 = r24
            goto L_0x01db
        L_0x0205:
            r24 = r22
            r25 = 82
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x026b
            r24 = 1
            r23 = r24
            goto L_0x01db
        L_0x0214:
            r24 = r22
            r25 = 81
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x026b
            r24 = 1
            r23 = r24
            goto L_0x01db
        L_0x0223:
            r24 = r22
            r25 = 86
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x026b
            r24 = 1
            r23 = r24
            goto L_0x01db
        L_0x0232:
            r24 = r22
            r25 = 79
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x026b
            r24 = 1
            r23 = r24
            goto L_0x01db
        L_0x0241:
            r24 = r22
            r25 = 80
            r0 = r24
            r1 = r25
            if (r0 == r1) goto L_0x026b
            r24 = 1
            r23 = r24
            goto L_0x01db
        L_0x0250:
            r24 = r4
            r25 = r3
            r26 = r10
            r27 = r3
            int r26 = r26 - r27
            r27 = r6
            r28 = r11
            r24.visitNewarray(r25, r26, r27, r28)
            r24 = r10
            r25 = r3
            int r24 = r24 - r25
            r2 = r24
            goto L_0x0109
        L_0x026b:
            r24 = 0
            r23 = r24
            goto L_0x01db
        L_0x0271:
            r24 = 0
            r12 = r24
            goto L_0x00e4
        L_0x0277:
            r24 = 0
            r9 = r24
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.code.BytecodeArray.parseNewarray(int, net.zhuoweizhang.boardwalk.com.android.dx.cf.code.BytecodeArray$Visitor):int");
    }

    private int parseTableswitch(int i, Visitor visitor) {
        SwitchList switchList;
        SimException simException;
        int i2 = i;
        Visitor visitor2 = visitor;
        int i3 = -4 & (i2 + 4);
        int i4 = 0;
        for (int i5 = i2 + 1; i5 < i3; i5++) {
            i4 = (i4 << 8) | this.bytes.getUnsignedByte(i5);
        }
        int i6 = i2 + this.bytes.getInt(i3);
        int i7 = this.bytes.getInt(i3 + 4);
        int i8 = this.bytes.getInt(i3 + 8);
        int i9 = 1 + (i8 - i7);
        int i10 = i3 + 12;
        if (i7 > i8) {
            SimException simException2 = simException;
            SimException simException3 = new SimException("low / high inversion");
            throw simException2;
        }
        SwitchList switchList2 = switchList;
        SwitchList switchList3 = new SwitchList(i9);
        SwitchList switchList4 = switchList2;
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = i2 + this.bytes.getInt(i10);
            i10 += 4;
            switchList4.add(i7 + i11, i12);
        }
        switchList4.setDefaultTarget(i6);
        switchList4.removeSuperfluousDefaults();
        switchList4.setImmutable();
        int i13 = i10 - i2;
        visitor2.visitSwitch(171, i2, i13, switchList4, i4);
        return i13;
    }

    private int parseWide(int i, Visitor visitor) {
        int i2 = i;
        Visitor visitor2 = visitor;
        int unsignedByte = this.bytes.getUnsignedByte(i2 + 1);
        int unsignedShort = this.bytes.getUnsignedShort(i2 + 2);
        switch (unsignedByte) {
            case 21:
                visitor2.visitLocal(21, i2, 4, unsignedShort, Type.INT, 0);
                return 4;
            case 22:
                visitor2.visitLocal(21, i2, 4, unsignedShort, Type.LONG, 0);
                return 4;
            case 23:
                visitor2.visitLocal(21, i2, 4, unsignedShort, Type.FLOAT, 0);
                return 4;
            case 24:
                visitor2.visitLocal(21, i2, 4, unsignedShort, Type.DOUBLE, 0);
                return 4;
            case 25:
                visitor2.visitLocal(21, i2, 4, unsignedShort, Type.OBJECT, 0);
                return 4;
            case 54:
                visitor2.visitLocal(54, i2, 4, unsignedShort, Type.INT, 0);
                return 4;
            case 55:
                visitor2.visitLocal(54, i2, 4, unsignedShort, Type.LONG, 0);
                return 4;
            case 56:
                visitor2.visitLocal(54, i2, 4, unsignedShort, Type.FLOAT, 0);
                return 4;
            case 57:
                visitor2.visitLocal(54, i2, 4, unsignedShort, Type.DOUBLE, 0);
                return 4;
            case 58:
                visitor2.visitLocal(54, i2, 4, unsignedShort, Type.OBJECT, 0);
                return 4;
            case 132:
                visitor2.visitLocal(unsignedByte, i2, 6, unsignedShort, Type.INT, this.bytes.getShort(i2 + 4));
                return 6;
            case 169:
                visitor2.visitLocal(unsignedByte, i2, 4, unsignedShort, Type.RETURN_ADDRESS, 0);
                return 4;
            default:
                visitor2.visitInvalid(196, i2, 1);
                return 1;
        }
    }

    public int byteLength() {
        return 4 + this.bytes.size();
    }

    public void forEach(Visitor visitor) {
        Visitor visitor2 = visitor;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bytes.size()) {
                i = i2 + parseInstruction(i2, visitor2);
            } else {
                return;
            }
        }
    }

    public ByteArray getBytes() {
        return this.bytes;
    }

    public int[] getInstructionOffsets() {
        int size = this.bytes.size();
        int[] makeBitSet = Bits.makeBitSet(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return makeBitSet;
            }
            Bits.set(makeBitSet, i2, true);
            i = i2 + parseInstruction(i2, null);
        }
    }

    public int parseInstruction(int i, Visitor visitor) {
        SimException simException;
        StringBuilder sb;
        StringBuilder sb2;
        ParseException parseException;
        int i2 = i;
        Visitor visitor2 = visitor;
        Visitor visitor3 = visitor2 == null ? EMPTY_VISITOR : visitor2;
        try {
            int unsignedByte = this.bytes.getUnsignedByte(i2);
            int opInfo = 31 & ByteOps.opInfo(unsignedByte);
            switch (unsignedByte) {
                case 0:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.VOID);
                    return 1;
                case 1:
                    visitor3.visitConstant(18, i2, 1, CstKnownNull.THE_ONE, 0);
                    return 1;
                case 2:
                    visitor3.visitConstant(18, i2, 1, CstInteger.VALUE_M1, -1);
                    return 1;
                case 3:
                    visitor3.visitConstant(18, i2, 1, CstInteger.VALUE_0, 0);
                    return 1;
                case 4:
                    visitor3.visitConstant(18, i2, 1, CstInteger.VALUE_1, 1);
                    return 1;
                case 5:
                    visitor3.visitConstant(18, i2, 1, CstInteger.VALUE_2, 2);
                    return 1;
                case 6:
                    visitor3.visitConstant(18, i2, 1, CstInteger.VALUE_3, 3);
                    return 1;
                case 7:
                    visitor3.visitConstant(18, i2, 1, CstInteger.VALUE_4, 4);
                    return 1;
                case 8:
                    visitor3.visitConstant(18, i2, 1, CstInteger.VALUE_5, 5);
                    return 1;
                case 9:
                    visitor3.visitConstant(18, i2, 1, CstLong.VALUE_0, 0);
                    return 1;
                case 10:
                    visitor3.visitConstant(18, i2, 1, CstLong.VALUE_1, 0);
                    return 1;
                case 11:
                    visitor3.visitConstant(18, i2, 1, CstFloat.VALUE_0, 0);
                    return 1;
                case 12:
                    visitor3.visitConstant(18, i2, 1, CstFloat.VALUE_1, 0);
                    return 1;
                case 13:
                    visitor3.visitConstant(18, i2, 1, CstFloat.VALUE_2, 0);
                    return 1;
                case 14:
                    visitor3.visitConstant(18, i2, 1, CstDouble.VALUE_0, 0);
                    return 1;
                case 15:
                    visitor3.visitConstant(18, i2, 1, CstDouble.VALUE_1, 0);
                    return 1;
                case 16:
                    int i3 = this.bytes.getByte(i2 + 1);
                    visitor3.visitConstant(18, i2, 2, CstInteger.make(i3), i3);
                    return 2;
                case 17:
                    int i4 = this.bytes.getShort(i2 + 1);
                    visitor3.visitConstant(18, i2, 3, CstInteger.make(i4), i4);
                    return 3;
                case 18:
                    Constant constant = this.pool.get(this.bytes.getUnsignedByte(i2 + 1));
                    int i5 = 0;
                    if (constant instanceof CstInteger) {
                        i5 = ((CstInteger) constant).getValue();
                    }
                    visitor3.visitConstant(18, i2, 2, constant, i5);
                    return 2;
                case 19:
                    Constant constant2 = this.pool.get(this.bytes.getUnsignedShort(i2 + 1));
                    int i6 = 0;
                    if (constant2 instanceof CstInteger) {
                        i6 = ((CstInteger) constant2).getValue();
                    }
                    visitor3.visitConstant(18, i2, 3, constant2, i6);
                    return 3;
                case 20:
                    visitor3.visitConstant(20, i2, 3, this.pool.get(this.bytes.getUnsignedShort(i2 + 1)), 0);
                    return 3;
                case 21:
                    visitor3.visitLocal(21, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.INT, 0);
                    return 2;
                case 22:
                    visitor3.visitLocal(21, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.LONG, 0);
                    return 2;
                case 23:
                    visitor3.visitLocal(21, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.FLOAT, 0);
                    return 2;
                case 24:
                    visitor3.visitLocal(21, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.DOUBLE, 0);
                    return 2;
                case 25:
                    visitor3.visitLocal(21, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.OBJECT, 0);
                    return 2;
                case 26:
                case 27:
                case 28:
                case 29:
                    visitor3.visitLocal(21, i2, 1, unsignedByte - 26, Type.INT, 0);
                    return 1;
                case 30:
                case 31:
                case 32:
                case 33:
                    visitor3.visitLocal(21, i2, 1, unsignedByte - 30, Type.LONG, 0);
                    return 1;
                case 34:
                case 35:
                case 36:
                case 37:
                    visitor3.visitLocal(21, i2, 1, unsignedByte - 34, Type.FLOAT, 0);
                    return 1;
                case 38:
                case 39:
                case 40:
                case 41:
                    visitor3.visitLocal(21, i2, 1, unsignedByte - 38, Type.DOUBLE, 0);
                    return 1;
                case 42:
                case 43:
                case 44:
                case 45:
                    visitor3.visitLocal(21, i2, 1, unsignedByte - 42, Type.OBJECT, 0);
                    return 1;
                case 46:
                    visitor3.visitNoArgs(46, i2, 1, Type.INT);
                    return 1;
                case 47:
                    visitor3.visitNoArgs(46, i2, 1, Type.LONG);
                    return 1;
                case 48:
                    visitor3.visitNoArgs(46, i2, 1, Type.FLOAT);
                    return 1;
                case 49:
                    visitor3.visitNoArgs(46, i2, 1, Type.DOUBLE);
                    return 1;
                case 50:
                    visitor3.visitNoArgs(46, i2, 1, Type.OBJECT);
                    return 1;
                case 51:
                    visitor3.visitNoArgs(46, i2, 1, Type.BYTE);
                    return 1;
                case 52:
                    visitor3.visitNoArgs(46, i2, 1, Type.CHAR);
                    return 1;
                case 53:
                    visitor3.visitNoArgs(46, i2, 1, Type.SHORT);
                    return 1;
                case 54:
                    visitor3.visitLocal(54, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.INT, 0);
                    return 2;
                case 55:
                    visitor3.visitLocal(54, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.LONG, 0);
                    return 2;
                case 56:
                    visitor3.visitLocal(54, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.FLOAT, 0);
                    return 2;
                case 57:
                    visitor3.visitLocal(54, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.DOUBLE, 0);
                    return 2;
                case 58:
                    visitor3.visitLocal(54, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.OBJECT, 0);
                    return 2;
                case 59:
                case 60:
                case 61:
                case 62:
                    visitor3.visitLocal(54, i2, 1, unsignedByte - 59, Type.INT, 0);
                    return 1;
                case 63:
                case 64:
                case 65:
                case 66:
                    visitor3.visitLocal(54, i2, 1, unsignedByte - 63, Type.LONG, 0);
                    return 1;
                case 67:
                case 68:
                case 69:
                case 70:
                    visitor3.visitLocal(54, i2, 1, unsignedByte - 67, Type.FLOAT, 0);
                    return 1;
                case 71:
                case 72:
                case 73:
                case 74:
                    visitor3.visitLocal(54, i2, 1, unsignedByte - 71, Type.DOUBLE, 0);
                    return 1;
                case 75:
                case 76:
                case 77:
                case 78:
                    visitor3.visitLocal(54, i2, 1, unsignedByte - 75, Type.OBJECT, 0);
                    return 1;
                case 79:
                    visitor3.visitNoArgs(79, i2, 1, Type.INT);
                    return 1;
                case 80:
                    visitor3.visitNoArgs(79, i2, 1, Type.LONG);
                    return 1;
                case 81:
                    visitor3.visitNoArgs(79, i2, 1, Type.FLOAT);
                    return 1;
                case 82:
                    visitor3.visitNoArgs(79, i2, 1, Type.DOUBLE);
                    return 1;
                case 83:
                    visitor3.visitNoArgs(79, i2, 1, Type.OBJECT);
                    return 1;
                case 84:
                    visitor3.visitNoArgs(79, i2, 1, Type.BYTE);
                    return 1;
                case 85:
                    visitor3.visitNoArgs(79, i2, 1, Type.CHAR);
                    return 1;
                case 86:
                    visitor3.visitNoArgs(79, i2, 1, Type.SHORT);
                    return 1;
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.VOID);
                    return 1;
                case 96:
                case 100:
                case 104:
                case 108:
                case 112:
                case 116:
                case 120:
                case 122:
                case 124:
                case 126:
                case 128:
                case 130:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.INT);
                    return 1;
                case 97:
                case 101:
                case 105:
                case 109:
                case 113:
                case 117:
                case 121:
                case 123:
                case 125:
                case 127:
                case 129:
                case 131:
                    visitor3.visitNoArgs(unsignedByte - 1, i2, 1, Type.LONG);
                    return 1;
                case 98:
                case 102:
                case 106:
                case 110:
                case 114:
                case 118:
                    visitor3.visitNoArgs(unsignedByte - 2, i2, 1, Type.FLOAT);
                    return 1;
                case 99:
                case 103:
                case 107:
                case 111:
                case 115:
                case 119:
                    visitor3.visitNoArgs(unsignedByte - 3, i2, 1, Type.DOUBLE);
                    return 1;
                case 132:
                    visitor3.visitLocal(unsignedByte, i2, 3, this.bytes.getUnsignedByte(i2 + 1), Type.INT, this.bytes.getByte(i2 + 2));
                    return 3;
                case 133:
                case 140:
                case 143:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.LONG);
                    return 1;
                case 134:
                case 137:
                case 144:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.FLOAT);
                    return 1;
                case 135:
                case 138:
                case 141:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.DOUBLE);
                    return 1;
                case 136:
                case 139:
                case 142:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 190:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.INT);
                    return 1;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 198:
                case 199:
                    visitor3.visitBranch(unsignedByte, i2, 3, i2 + this.bytes.getShort(i2 + 1));
                    return 3;
                case 169:
                    visitor3.visitLocal(unsignedByte, i2, 2, this.bytes.getUnsignedByte(i2 + 1), Type.RETURN_ADDRESS, 0);
                    return 2;
                case 170:
                    return parseTableswitch(i2, visitor3);
                case 171:
                    return parseLookupswitch(i2, visitor3);
                case 172:
                    visitor3.visitNoArgs(172, i2, 1, Type.INT);
                    return 1;
                case 173:
                    visitor3.visitNoArgs(172, i2, 1, Type.LONG);
                    return 1;
                case 174:
                    visitor3.visitNoArgs(172, i2, 1, Type.FLOAT);
                    return 1;
                case 175:
                    visitor3.visitNoArgs(172, i2, 1, Type.DOUBLE);
                    return 1;
                case 176:
                    visitor3.visitNoArgs(172, i2, 1, Type.OBJECT);
                    return 1;
                case 177:
                case 191:
                case 194:
                case 195:
                    visitor3.visitNoArgs(unsignedByte, i2, 1, Type.VOID);
                    return 1;
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case 193:
                    visitor3.visitConstant(unsignedByte, i2, 3, this.pool.get(this.bytes.getUnsignedShort(i2 + 1)), 0);
                    return 3;
                case 185:
                    visitor3.visitConstant(unsignedByte, i2, 5, this.pool.get(this.bytes.getUnsignedShort(i2 + 1)), this.bytes.getUnsignedByte(i2 + 3) | (this.bytes.getUnsignedByte(i2 + 4) << 8));
                    return 5;
                case 186:
                    ParseException parseException2 = parseException;
                    ParseException parseException3 = new ParseException("invokedynamic not supported");
                    throw parseException2;
                case 188:
                    return parseNewarray(i2, visitor3);
                case 196:
                    return parseWide(i2, visitor3);
                case 197:
                    visitor3.visitConstant(unsignedByte, i2, 4, this.pool.get(this.bytes.getUnsignedShort(i2 + 1)), this.bytes.getUnsignedByte(i2 + 3));
                    return 4;
                case 200:
                case 201:
                    visitor3.visitBranch(unsignedByte == 200 ? 167 : 168, i2, 5, i2 + this.bytes.getInt(i2 + 1));
                    return 5;
                default:
                    visitor3.visitInvalid(unsignedByte, i2, 1);
                    return 1;
            }
        } catch (SimException e) {
            SimException simException2 = e;
            SimException simException3 = simException2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            simException3.addContext(sb3.append("...at bytecode offset ").append(Hex.m53u4(i2)).toString());
            throw simException2;
        } catch (RuntimeException e2) {
            RuntimeException runtimeException = e2;
            SimException simException4 = simException;
            SimException simException5 = new SimException((Throwable) runtimeException);
            SimException simException6 = simException4;
            SimException simException7 = simException6;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            simException7.addContext(sb5.append("...at bytecode offset ").append(Hex.m53u4(i2)).toString());
            throw simException6;
        }
    }

    public void processWorkSet(int[] iArr, Visitor visitor) {
        NullPointerException nullPointerException;
        int[] iArr2 = iArr;
        Visitor visitor2 = visitor;
        if (visitor2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("visitor == null");
            throw nullPointerException2;
        }
        while (true) {
            int findFirst = Bits.findFirst(iArr2, 0);
            if (findFirst >= 0) {
                Bits.clear(iArr2, findFirst);
                int parseInstruction = parseInstruction(findFirst, visitor2);
                visitor2.setPreviousOffset(findFirst);
            } else {
                return;
            }
        }
    }

    public int size() {
        return this.bytes.size();
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.AttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Member;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdAttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstNat;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.MemberListParser */
abstract class MemberListParser {
    private final AttributeFactory attributeFactory;

    /* renamed from: cf */
    private final DirectClassFile f165cf;
    private final CstType definer;
    private int endOffset;
    private ParseObserver observer;
    private final int offset;

    public MemberListParser(DirectClassFile directClassFile, CstType cstType, int i, AttributeFactory attributeFactory2) {
        NullPointerException nullPointerException;
        IllegalArgumentException illegalArgumentException;
        NullPointerException nullPointerException2;
        DirectClassFile directClassFile2 = directClassFile;
        CstType cstType2 = cstType;
        int i2 = i;
        AttributeFactory attributeFactory3 = attributeFactory2;
        if (directClassFile2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("cf == null");
            throw nullPointerException3;
        } else if (i2 < 0) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("offset < 0");
            throw illegalArgumentException2;
        } else if (attributeFactory3 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("attributeFactory == null");
            throw nullPointerException5;
        } else {
            this.f165cf = directClassFile2;
            this.definer = cstType2;
            this.offset = i2;
            this.attributeFactory = attributeFactory3;
            this.endOffset = -1;
        }
    }

    private void parse() {
        ParseException parseException;
        StringBuilder sb;
        StringBuilder sb2;
        AttributeListParser attributeListParser;
        CstNat cstNat;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        StringBuilder sb8;
        int attributeContext = getAttributeContext();
        int count = getCount();
        int i = 2 + this.offset;
        ByteArray bytes = this.f165cf.getBytes();
        ConstantPool constantPool = this.f165cf.getConstantPool();
        if (this.observer != null) {
            ParseObserver parseObserver = this.observer;
            ByteArray byteArray = bytes;
            int i2 = this.offset;
            StringBuilder sb9 = sb8;
            StringBuilder sb10 = new StringBuilder();
            parseObserver.parsed(byteArray, i2, 2, sb9.append(humanName()).append("s_count: ").append(Hex.m51u2(count)).toString());
        }
        int i3 = 0;
        while (i3 < count) {
            try {
                int unsignedShort = bytes.getUnsignedShort(i);
                int unsignedShort2 = bytes.getUnsignedShort(i + 2);
                CstString cstString = (CstString) constantPool.get(unsignedShort2);
                CstString cstString2 = (CstString) constantPool.get(bytes.getUnsignedShort(i + 4));
                if (this.observer != null) {
                    this.observer.startParsingMember(bytes, i, cstString.getString(), cstString2.getString());
                    ParseObserver parseObserver2 = this.observer;
                    ByteArray byteArray2 = bytes;
                    int i4 = i;
                    StringBuilder sb11 = sb4;
                    StringBuilder sb12 = new StringBuilder();
                    parseObserver2.parsed(byteArray2, i4, 0, sb11.append("\n").append(humanName()).append("s[").append(i3).append("]:\n").toString());
                    this.observer.changeIndent(1);
                    ParseObserver parseObserver3 = this.observer;
                    ByteArray byteArray3 = bytes;
                    int i5 = i;
                    StringBuilder sb13 = sb5;
                    StringBuilder sb14 = new StringBuilder();
                    parseObserver3.parsed(byteArray3, i5, 2, sb13.append("access_flags: ").append(humanAccessFlags(unsignedShort)).toString());
                    ParseObserver parseObserver4 = this.observer;
                    ByteArray byteArray4 = bytes;
                    int i6 = i + 2;
                    StringBuilder sb15 = sb6;
                    StringBuilder sb16 = new StringBuilder();
                    parseObserver4.parsed(byteArray4, i6, 2, sb15.append("name: ").append(cstString.toHuman()).toString());
                    ParseObserver parseObserver5 = this.observer;
                    ByteArray byteArray5 = bytes;
                    int i7 = i + 4;
                    StringBuilder sb17 = sb7;
                    StringBuilder sb18 = new StringBuilder();
                    parseObserver5.parsed(byteArray5, i7, 2, sb17.append("descriptor: ").append(cstString2.toHuman()).toString());
                }
                AttributeListParser attributeListParser2 = attributeListParser;
                AttributeListParser attributeListParser3 = new AttributeListParser(this.f165cf, attributeContext, i + 6, this.attributeFactory);
                AttributeListParser attributeListParser4 = attributeListParser2;
                attributeListParser4.setObserver(this.observer);
                i = attributeListParser4.getEndOffset();
                StdAttributeList list = attributeListParser4.getList();
                list.setImmutable();
                int i8 = i3;
                int i9 = unsignedShort;
                CstNat cstNat2 = cstNat;
                CstNat cstNat3 = new CstNat(cstString, cstString2);
                Member member = set(i8, i9, cstNat2, list);
                if (this.observer != null) {
                    this.observer.changeIndent(-1);
                    ParseObserver parseObserver6 = this.observer;
                    ByteArray byteArray6 = bytes;
                    int i10 = i;
                    StringBuilder sb19 = sb3;
                    StringBuilder sb20 = new StringBuilder();
                    parseObserver6.parsed(byteArray6, i10, 0, sb19.append("end ").append(humanName()).append("s[").append(i3).append("]\n").toString());
                    this.observer.endParsingMember(bytes, i, cstString.getString(), cstString2.getString(), member);
                }
                i3++;
            } catch (ParseException e) {
                ParseException parseException2 = e;
                ParseException parseException3 = parseException2;
                StringBuilder sb21 = sb2;
                StringBuilder sb22 = new StringBuilder();
                parseException3.addContext(sb21.append("...while parsing ").append(humanName()).append("s[").append(i3).append("]").toString());
                throw parseException2;
            } catch (RuntimeException e2) {
                RuntimeException runtimeException = e2;
                ParseException parseException4 = parseException;
                ParseException parseException5 = new ParseException((Throwable) runtimeException);
                ParseException parseException6 = parseException4;
                ParseException parseException7 = parseException6;
                StringBuilder sb23 = sb;
                StringBuilder sb24 = new StringBuilder();
                parseException7.addContext(sb23.append("...while parsing ").append(humanName()).append("s[").append(i3).append("]").toString());
                throw parseException6;
            }
        }
        this.endOffset = i;
    }

    /* access modifiers changed from: protected */
    public abstract int getAttributeContext();

    /* access modifiers changed from: protected */
    public final int getCount() {
        return this.f165cf.getBytes().getUnsignedShort(this.offset);
    }

    /* access modifiers changed from: protected */
    public final CstType getDefiner() {
        return this.definer;
    }

    public int getEndOffset() {
        parseIfNecessary();
        return this.endOffset;
    }

    /* access modifiers changed from: protected */
    public abstract String humanAccessFlags(int i);

    /* access modifiers changed from: protected */
    public abstract String humanName();

    /* access modifiers changed from: protected */
    public final void parseIfNecessary() {
        if (this.endOffset < 0) {
            parse();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Member set(int i, int i2, CstNat cstNat, AttributeList attributeList);

    public final void setObserver(ParseObserver parseObserver) {
        ParseObserver parseObserver2 = parseObserver;
        this.observer = parseObserver2;
    }
}

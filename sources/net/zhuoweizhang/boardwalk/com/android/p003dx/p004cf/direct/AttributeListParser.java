package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Attribute;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.StdAttributeList;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AttributeListParser */
final class AttributeListParser {
    private final AttributeFactory attributeFactory;

    /* renamed from: cf */
    private final DirectClassFile f164cf;
    private final int context;
    private int endOffset;
    private final StdAttributeList list;
    private ParseObserver observer;
    private final int offset;

    public AttributeListParser(DirectClassFile directClassFile, int i, int i2, AttributeFactory attributeFactory2) {
        StdAttributeList stdAttributeList;
        NullPointerException nullPointerException;
        NullPointerException nullPointerException2;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        AttributeFactory attributeFactory3 = attributeFactory2;
        if (directClassFile2 == null) {
            NullPointerException nullPointerException3 = nullPointerException2;
            NullPointerException nullPointerException4 = new NullPointerException("cf == null");
            throw nullPointerException3;
        } else if (attributeFactory3 == null) {
            NullPointerException nullPointerException5 = nullPointerException;
            NullPointerException nullPointerException6 = new NullPointerException("attributeFactory == null");
            throw nullPointerException5;
        } else {
            int unsignedShort = directClassFile2.getBytes().getUnsignedShort(i4);
            this.f164cf = directClassFile2;
            this.context = i3;
            this.offset = i4;
            this.attributeFactory = attributeFactory3;
            StdAttributeList stdAttributeList2 = stdAttributeList;
            StdAttributeList stdAttributeList3 = new StdAttributeList(unsignedShort);
            this.list = stdAttributeList2;
            this.endOffset = -1;
        }
    }

    private void parse() {
        ParseException parseException;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        int size = this.list.size();
        int i = 2 + this.offset;
        ByteArray bytes = this.f164cf.getBytes();
        if (this.observer != null) {
            ParseObserver parseObserver = this.observer;
            ByteArray byteArray = bytes;
            int i2 = this.offset;
            StringBuilder sb6 = sb5;
            StringBuilder sb7 = new StringBuilder();
            parseObserver.parsed(byteArray, i2, 2, sb6.append("attributes_count: ").append(Hex.m51u2(size)).toString());
        }
        int i3 = i;
        int i4 = 0;
        while (i4 < size) {
            try {
                if (this.observer != null) {
                    ParseObserver parseObserver2 = this.observer;
                    ByteArray byteArray2 = bytes;
                    int i5 = i3;
                    StringBuilder sb8 = sb4;
                    StringBuilder sb9 = new StringBuilder();
                    parseObserver2.parsed(byteArray2, i5, 0, sb8.append("\nattributes[").append(i4).append("]:\n").toString());
                    this.observer.changeIndent(1);
                }
                Attribute parse = this.attributeFactory.parse(this.f164cf, this.context, i3, this.observer);
                int byteLength = i3 + parse.byteLength();
                this.list.set(i4, parse);
                if (this.observer != null) {
                    this.observer.changeIndent(-1);
                    ParseObserver parseObserver3 = this.observer;
                    ByteArray byteArray3 = bytes;
                    int i6 = byteLength;
                    StringBuilder sb10 = sb3;
                    StringBuilder sb11 = new StringBuilder();
                    parseObserver3.parsed(byteArray3, i6, 0, sb10.append("end attributes[").append(i4).append("]\n").toString());
                }
                i4++;
                i3 = byteLength;
            } catch (ParseException e) {
                ParseException parseException2 = e;
                ParseException parseException3 = parseException2;
                StringBuilder sb12 = sb2;
                StringBuilder sb13 = new StringBuilder();
                parseException3.addContext(sb12.append("...while parsing attributes[").append(i4).append("]").toString());
                throw parseException2;
            } catch (RuntimeException e2) {
                RuntimeException runtimeException = e2;
                ParseException parseException4 = parseException;
                ParseException parseException5 = new ParseException((Throwable) runtimeException);
                ParseException parseException6 = parseException4;
                ParseException parseException7 = parseException6;
                StringBuilder sb14 = sb;
                StringBuilder sb15 = new StringBuilder();
                parseException7.addContext(sb14.append("...while parsing attributes[").append(i4).append("]").toString());
                throw parseException6;
            }
        }
        this.endOffset = i3;
    }

    private void parseIfNecessary() {
        if (this.endOffset < 0) {
            parse();
        }
    }

    public int getEndOffset() {
        parseIfNecessary();
        return this.endOffset;
    }

    public StdAttributeList getList() {
        parseIfNecessary();
        return this.list;
    }

    public void setObserver(ParseObserver parseObserver) {
        ParseObserver parseObserver2 = parseObserver;
        this.observer = parseObserver2;
    }
}

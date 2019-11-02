package net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.direct;

import net.zhuoweizhang.boardwalk.LibrariesRepository;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.attrib.RawAttribute;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.Attribute;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseException;
import net.zhuoweizhang.boardwalk.com.android.p003dx.p004cf.iface.ParseObserver;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.ConstantPool;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArray;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.Hex;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.cf.direct.AttributeFactory */
public class AttributeFactory {
    public static final int CTX_CLASS = 0;
    public static final int CTX_CODE = 3;
    public static final int CTX_COUNT = 4;
    public static final int CTX_FIELD = 1;
    public static final int CTX_METHOD = 2;

    public AttributeFactory() {
    }

    public final Attribute parse(DirectClassFile directClassFile, int i, int i2, ParseObserver parseObserver) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        NullPointerException nullPointerException;
        DirectClassFile directClassFile2 = directClassFile;
        int i3 = i;
        int i4 = i2;
        ParseObserver parseObserver2 = parseObserver;
        if (directClassFile2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cf == null");
            throw nullPointerException2;
        } else if (i3 < 0 || i3 >= 4) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("bad context");
            throw illegalArgumentException2;
        } else {
            try {
                ByteArray bytes = directClassFile2.getBytes();
                ConstantPool constantPool = directClassFile2.getConstantPool();
                int unsignedShort = bytes.getUnsignedShort(i4);
                int i5 = bytes.getInt(i4 + 2);
                CstString cstString = (CstString) constantPool.get(unsignedShort);
                if (parseObserver2 != null) {
                    ParseObserver parseObserver3 = parseObserver2;
                    ByteArray byteArray = bytes;
                    int i6 = i4;
                    StringBuilder sb5 = sb3;
                    StringBuilder sb6 = new StringBuilder();
                    parseObserver3.parsed(byteArray, i6, 2, sb5.append("name: ").append(cstString.toHuman()).toString());
                    ParseObserver parseObserver4 = parseObserver2;
                    ByteArray byteArray2 = bytes;
                    int i7 = i4 + 2;
                    StringBuilder sb7 = sb4;
                    StringBuilder sb8 = new StringBuilder();
                    parseObserver4.parsed(byteArray2, i7, 4, sb7.append("length: ").append(Hex.m53u4(i5)).toString());
                }
                return parse0(directClassFile2, i3, cstString.getString(), i4 + 6, i5, parseObserver2);
            } catch (ParseException e) {
                ParseException parseException = e;
                StringBuilder sb9 = sb;
                StringBuilder sb10 = new StringBuilder();
                StringBuilder append = sb9.append("...while parsing ");
                if (0 != 0) {
                    StringBuilder sb11 = sb2;
                    StringBuilder sb12 = new StringBuilder();
                    str = sb11.append(null.toHuman()).append(" ").toString();
                } else {
                    str = LibrariesRepository.MOJANG_MAVEN_REPO;
                }
                parseException.addContext(append.append(str).append("attribute at offset ").append(Hex.m53u4(i4)).toString());
                throw parseException;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Attribute parse0(DirectClassFile directClassFile, int i, String str, int i2, int i3, ParseObserver parseObserver) {
        RawAttribute rawAttribute;
        DirectClassFile directClassFile2 = directClassFile;
        int i4 = i;
        String str2 = str;
        int i5 = i2;
        int i6 = i3;
        ParseObserver parseObserver2 = parseObserver;
        ByteArray bytes = directClassFile2.getBytes();
        RawAttribute rawAttribute2 = rawAttribute;
        RawAttribute rawAttribute3 = new RawAttribute(str2, bytes, i5, i6, directClassFile2.getConstantPool());
        RawAttribute rawAttribute4 = rawAttribute2;
        if (parseObserver2 != null) {
            parseObserver2.parsed(bytes, i5, i6, "attribute data");
        }
        return rawAttribute4;
    }
}

package net.zhuoweizhang.boardwalk.com.android.p003dx.dex.file;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ExceptionWithContext;
import net.zhuoweizhang.boardwalk.com.android.p003dx.dex.DexOptions;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.Constant;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstBaseMethodRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstEnumRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstFieldRef;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstString;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.cst.CstType;
import net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type.Type;
import net.zhuoweizhang.boardwalk.com.android.p003dx.util.ByteArrayAnnotatedOutput;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.dex.file.DexFile */
public final class DexFile {
    private final MixedItemSection byteData;
    private final MixedItemSection classData;
    private final ClassDefsSection classDefs;
    private DexOptions dexOptions;
    private int dumpWidth = 79;
    private final FieldIdsSection fieldIds;
    private int fileSize = -1;
    private final HeaderSection header;
    private final MixedItemSection map;
    private final MethodIdsSection methodIds;
    private final ProtoIdsSection protoIds;
    private final Section[] sections;
    private final MixedItemSection stringData;
    private final StringIdsSection stringIds;
    private final TypeIdsSection typeIds;
    private final MixedItemSection typeLists;
    private final MixedItemSection wordData;

    public DexFile(DexOptions dexOptions2) {
        HeaderSection headerSection;
        MixedItemSection mixedItemSection;
        MixedItemSection mixedItemSection2;
        MixedItemSection mixedItemSection3;
        MixedItemSection mixedItemSection4;
        MixedItemSection mixedItemSection5;
        StringIdsSection stringIdsSection;
        TypeIdsSection typeIdsSection;
        ProtoIdsSection protoIdsSection;
        FieldIdsSection fieldIdsSection;
        MethodIdsSection methodIdsSection;
        ClassDefsSection classDefsSection;
        MixedItemSection mixedItemSection6;
        this.dexOptions = dexOptions2;
        HeaderSection headerSection2 = headerSection;
        HeaderSection headerSection3 = new HeaderSection(this);
        this.header = headerSection2;
        MixedItemSection mixedItemSection7 = mixedItemSection;
        MixedItemSection mixedItemSection8 = new MixedItemSection(null, this, 4, SortType.NONE);
        this.typeLists = mixedItemSection7;
        MixedItemSection mixedItemSection9 = mixedItemSection2;
        MixedItemSection mixedItemSection10 = new MixedItemSection("word_data", this, 4, SortType.TYPE);
        this.wordData = mixedItemSection9;
        MixedItemSection mixedItemSection11 = mixedItemSection3;
        MixedItemSection mixedItemSection12 = new MixedItemSection("string_data", this, 1, SortType.INSTANCE);
        this.stringData = mixedItemSection11;
        MixedItemSection mixedItemSection13 = mixedItemSection4;
        MixedItemSection mixedItemSection14 = new MixedItemSection(null, this, 1, SortType.NONE);
        this.classData = mixedItemSection13;
        MixedItemSection mixedItemSection15 = mixedItemSection5;
        MixedItemSection mixedItemSection16 = new MixedItemSection("byte_data", this, 1, SortType.TYPE);
        this.byteData = mixedItemSection15;
        StringIdsSection stringIdsSection2 = stringIdsSection;
        StringIdsSection stringIdsSection3 = new StringIdsSection(this);
        this.stringIds = stringIdsSection2;
        TypeIdsSection typeIdsSection2 = typeIdsSection;
        TypeIdsSection typeIdsSection3 = new TypeIdsSection(this);
        this.typeIds = typeIdsSection2;
        ProtoIdsSection protoIdsSection2 = protoIdsSection;
        ProtoIdsSection protoIdsSection3 = new ProtoIdsSection(this);
        this.protoIds = protoIdsSection2;
        FieldIdsSection fieldIdsSection2 = fieldIdsSection;
        FieldIdsSection fieldIdsSection3 = new FieldIdsSection(this);
        this.fieldIds = fieldIdsSection2;
        MethodIdsSection methodIdsSection2 = methodIdsSection;
        MethodIdsSection methodIdsSection3 = new MethodIdsSection(this);
        this.methodIds = methodIdsSection2;
        ClassDefsSection classDefsSection2 = classDefsSection;
        ClassDefsSection classDefsSection3 = new ClassDefsSection(this);
        this.classDefs = classDefsSection2;
        MixedItemSection mixedItemSection17 = mixedItemSection6;
        MixedItemSection mixedItemSection18 = new MixedItemSection("map", this, 4, SortType.NONE);
        this.map = mixedItemSection17;
        Section[] sectionArr = new Section[13];
        sectionArr[0] = this.header;
        sectionArr[1] = this.stringIds;
        sectionArr[2] = this.typeIds;
        sectionArr[3] = this.protoIds;
        sectionArr[4] = this.fieldIds;
        sectionArr[5] = this.methodIds;
        sectionArr[6] = this.classDefs;
        sectionArr[7] = this.wordData;
        sectionArr[8] = this.typeLists;
        sectionArr[9] = this.stringData;
        sectionArr[10] = this.byteData;
        sectionArr[11] = this.classData;
        sectionArr[12] = this.map;
        this.sections = sectionArr;
    }

    private static void calcChecksum(byte[] bArr) {
        Adler32 adler32;
        byte[] bArr2 = bArr;
        Adler32 adler322 = adler32;
        Adler32 adler323 = new Adler32();
        Adler32 adler324 = adler322;
        adler324.update(bArr2, 12, -12 + bArr2.length);
        int value = (int) adler324.getValue();
        bArr2[8] = (byte) value;
        bArr2[9] = (byte) (value >> 8);
        bArr2[10] = (byte) (value >> 16);
        bArr2[11] = (byte) (value >> 24);
    }

    private static void calcSignature(byte[] bArr) {
        RuntimeException runtimeException;
        RuntimeException runtimeException2;
        RuntimeException runtimeException3;
        StringBuilder sb;
        byte[] bArr2 = bArr;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr2, 32, -32 + bArr2.length);
            try {
                int digest = instance.digest(bArr2, 12, 20);
                if (digest != 20) {
                    RuntimeException runtimeException4 = runtimeException3;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    RuntimeException runtimeException5 = new RuntimeException(sb2.append("unexpected digest write: ").append(digest).append(" bytes").toString());
                    throw runtimeException4;
                }
            } catch (DigestException e) {
                DigestException digestException = e;
                RuntimeException runtimeException6 = runtimeException2;
                RuntimeException runtimeException7 = new RuntimeException(digestException);
                throw runtimeException6;
            }
        } catch (NoSuchAlgorithmException e2) {
            NoSuchAlgorithmException noSuchAlgorithmException = e2;
            RuntimeException runtimeException8 = runtimeException;
            RuntimeException runtimeException9 = new RuntimeException(noSuchAlgorithmException);
            throw runtimeException8;
        }
    }

    private ByteArrayAnnotatedOutput toDex0(boolean z, boolean z2) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput;
        RuntimeException runtimeException;
        ExceptionWithContext exceptionWithContext;
        ExceptionWithContext exceptionWithContext2;
        StringBuilder sb;
        ExceptionWithContext exceptionWithContext3;
        StringBuilder sb2;
        RuntimeException runtimeException2;
        StringBuilder sb3;
        StringBuilder sb4;
        boolean z3 = z;
        boolean z4 = z2;
        this.classDefs.prepare();
        this.classData.prepare();
        this.wordData.prepare();
        this.byteData.prepare();
        this.methodIds.prepare();
        this.fieldIds.prepare();
        this.protoIds.prepare();
        this.typeLists.prepare();
        this.typeIds.prepare();
        this.stringIds.prepare();
        this.stringData.prepare();
        this.header.prepare();
        int length = this.sections.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i < length) {
                Section section = this.sections[i];
                int fileOffset = section.setFileOffset(i3);
                if (fileOffset < i3) {
                    RuntimeException runtimeException3 = runtimeException2;
                    StringBuilder sb5 = sb3;
                    StringBuilder sb6 = new StringBuilder();
                    RuntimeException runtimeException4 = new RuntimeException(sb5.append("bogus placement for section ").append(i).toString());
                    throw runtimeException3;
                }
                try {
                    if (section == this.map) {
                        MapItem.addMap(this.sections, this.map);
                        this.map.prepare();
                    }
                    if (section instanceof MixedItemSection) {
                        ((MixedItemSection) section).placeItems();
                    }
                    i++;
                    i2 = fileOffset + section.writeSize();
                } catch (RuntimeException e) {
                    RuntimeException runtimeException5 = e;
                    StringBuilder sb7 = sb4;
                    StringBuilder sb8 = new StringBuilder();
                    throw ExceptionWithContext.withContext(runtimeException5, sb7.append("...while writing section ").append(i).toString());
                }
            } else {
                this.fileSize = i3;
                byte[] bArr = new byte[this.fileSize];
                ByteArrayAnnotatedOutput byteArrayAnnotatedOutput2 = byteArrayAnnotatedOutput;
                ByteArrayAnnotatedOutput byteArrayAnnotatedOutput3 = new ByteArrayAnnotatedOutput(bArr);
                ByteArrayAnnotatedOutput byteArrayAnnotatedOutput4 = byteArrayAnnotatedOutput2;
                int i4 = 0;
                if (z3) {
                    byteArrayAnnotatedOutput4.enableAnnotations(this.dumpWidth, z4);
                }
                while (i4 < length) {
                    try {
                        Section section2 = this.sections[i4];
                        int fileOffset2 = section2.getFileOffset() - byteArrayAnnotatedOutput4.getCursor();
                        if (fileOffset2 < 0) {
                            ExceptionWithContext exceptionWithContext4 = exceptionWithContext3;
                            StringBuilder sb9 = sb2;
                            StringBuilder sb10 = new StringBuilder();
                            ExceptionWithContext exceptionWithContext5 = new ExceptionWithContext(sb9.append("excess write of ").append(-fileOffset2).toString());
                            throw exceptionWithContext4;
                        }
                        byteArrayAnnotatedOutput4.writeZeroes(section2.getFileOffset() - byteArrayAnnotatedOutput4.getCursor());
                        section2.writeTo(byteArrayAnnotatedOutput4);
                        i4++;
                    } catch (RuntimeException e2) {
                        RuntimeException runtimeException6 = e2;
                        if (runtimeException6 instanceof ExceptionWithContext) {
                            exceptionWithContext2 = (ExceptionWithContext) runtimeException6;
                        } else {
                            ExceptionWithContext exceptionWithContext6 = exceptionWithContext;
                            ExceptionWithContext exceptionWithContext7 = new ExceptionWithContext((Throwable) runtimeException6);
                            exceptionWithContext2 = exceptionWithContext6;
                        }
                        ExceptionWithContext exceptionWithContext8 = exceptionWithContext2;
                        StringBuilder sb11 = sb;
                        StringBuilder sb12 = new StringBuilder();
                        exceptionWithContext8.addContext(sb11.append("...while writing section ").append(i4).toString());
                        throw exceptionWithContext2;
                    }
                }
                if (byteArrayAnnotatedOutput4.getCursor() != this.fileSize) {
                    RuntimeException runtimeException7 = runtimeException;
                    RuntimeException runtimeException8 = new RuntimeException("foreshortened write");
                    throw runtimeException7;
                }
                calcSignature(bArr);
                calcChecksum(bArr);
                if (z3) {
                    this.wordData.writeIndexAnnotation(byteArrayAnnotatedOutput4, ItemType.TYPE_CODE_ITEM, "\nmethod code index:\n\n");
                    getStatistics().writeAnnotation(byteArrayAnnotatedOutput4);
                    byteArrayAnnotatedOutput4.finishAnnotating();
                }
                return byteArrayAnnotatedOutput4;
            }
        }
    }

    public void add(ClassDefItem classDefItem) {
        ClassDefItem classDefItem2 = classDefItem;
        this.classDefs.add(classDefItem2);
    }

    /* access modifiers changed from: 0000 */
    public IndexedItem findItemOrNull(Constant constant) {
        Constant constant2 = constant;
        if (constant2 instanceof CstString) {
            return this.stringIds.get(constant2);
        }
        if (constant2 instanceof CstType) {
            return this.typeIds.get(constant2);
        }
        if (constant2 instanceof CstBaseMethodRef) {
            return this.methodIds.get(constant2);
        }
        if (constant2 instanceof CstFieldRef) {
            return this.fieldIds.get(constant2);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public MixedItemSection getByteData() {
        return this.byteData;
    }

    /* access modifiers changed from: 0000 */
    public MixedItemSection getClassData() {
        return this.classData;
    }

    /* access modifiers changed from: 0000 */
    public ClassDefsSection getClassDefs() {
        return this.classDefs;
    }

    public ClassDefItem getClassOrNull(String str) {
        CstType cstType;
        try {
            Type internClassName = Type.internClassName(str);
            ClassDefsSection classDefsSection = this.classDefs;
            CstType cstType2 = cstType;
            CstType cstType3 = new CstType(internClassName);
            return (ClassDefItem) classDefsSection.get(cstType2);
        } catch (IllegalArgumentException e) {
            IllegalArgumentException illegalArgumentException = e;
            return null;
        }
    }

    public DexOptions getDexOptions() {
        return this.dexOptions;
    }

    public FieldIdsSection getFieldIds() {
        return this.fieldIds;
    }

    public int getFileSize() {
        RuntimeException runtimeException;
        if (this.fileSize >= 0) {
            return this.fileSize;
        }
        RuntimeException runtimeException2 = runtimeException;
        RuntimeException runtimeException3 = new RuntimeException("file size not yet known");
        throw runtimeException2;
    }

    /* access modifiers changed from: 0000 */
    public Section getFirstDataSection() {
        return this.wordData;
    }

    /* access modifiers changed from: 0000 */
    public Section getLastDataSection() {
        return this.map;
    }

    /* access modifiers changed from: 0000 */
    public MixedItemSection getMap() {
        return this.map;
    }

    public MethodIdsSection getMethodIds() {
        return this.methodIds;
    }

    /* access modifiers changed from: 0000 */
    public ProtoIdsSection getProtoIds() {
        return this.protoIds;
    }

    public Statistics getStatistics() {
        Statistics statistics;
        Statistics statistics2 = statistics;
        Statistics statistics3 = new Statistics();
        Statistics statistics4 = statistics2;
        Section[] sectionArr = this.sections;
        int length = sectionArr.length;
        for (int i = 0; i < length; i++) {
            statistics4.addAll(sectionArr[i]);
        }
        return statistics4;
    }

    /* access modifiers changed from: 0000 */
    public MixedItemSection getStringData() {
        return this.stringData;
    }

    /* access modifiers changed from: 0000 */
    public StringIdsSection getStringIds() {
        return this.stringIds;
    }

    public TypeIdsSection getTypeIds() {
        return this.typeIds;
    }

    /* access modifiers changed from: 0000 */
    public MixedItemSection getTypeLists() {
        return this.typeLists;
    }

    /* access modifiers changed from: 0000 */
    public MixedItemSection getWordData() {
        return this.wordData;
    }

    /* access modifiers changed from: 0000 */
    public void internIfAppropriate(Constant constant) {
        NullPointerException nullPointerException;
        Constant constant2 = constant;
        if (constant2 instanceof CstString) {
            StringIdItem intern = this.stringIds.intern((CstString) constant2);
        } else if (constant2 instanceof CstType) {
            TypeIdItem intern2 = this.typeIds.intern((CstType) constant2);
        } else if (constant2 instanceof CstBaseMethodRef) {
            MethodIdItem intern3 = this.methodIds.intern((CstBaseMethodRef) constant2);
        } else if (constant2 instanceof CstFieldRef) {
            FieldIdItem intern4 = this.fieldIds.intern((CstFieldRef) constant2);
        } else if (constant2 instanceof CstEnumRef) {
            FieldIdItem intern5 = this.fieldIds.intern(((CstEnumRef) constant2).getFieldRef());
        } else if (constant2 == null) {
            NullPointerException nullPointerException2 = nullPointerException;
            NullPointerException nullPointerException3 = new NullPointerException("cst == null");
            throw nullPointerException2;
        }
    }

    public boolean isEmpty() {
        return this.classDefs.items().isEmpty();
    }

    public void setDumpWidth(int i) {
        IllegalArgumentException illegalArgumentException;
        int i2 = i;
        if (i2 < 40) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("dumpWidth < 40");
            throw illegalArgumentException2;
        }
        this.dumpWidth = i2;
    }

    public byte[] toDex(Writer writer, boolean z) throws IOException {
        Writer writer2 = writer;
        boolean z2 = z;
        boolean z3 = writer2 != null;
        ByteArrayAnnotatedOutput dex0 = toDex0(z3, z2);
        if (z3) {
            dex0.writeAnnotationsTo(writer2);
        }
        return dex0.getArray();
    }

    public void writeTo(OutputStream outputStream, Writer writer, boolean z) throws IOException {
        OutputStream outputStream2 = outputStream;
        Writer writer2 = writer;
        boolean z2 = z;
        boolean z3 = writer2 != null;
        ByteArrayAnnotatedOutput dex0 = toDex0(z3, z2);
        if (outputStream2 != null) {
            outputStream2.write(dex0.getArray());
        }
        if (z3) {
            dex0.writeAnnotationsTo(writer2);
        }
    }
}

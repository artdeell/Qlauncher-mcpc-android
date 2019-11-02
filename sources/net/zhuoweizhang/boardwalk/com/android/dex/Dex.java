package net.zhuoweizhang.boardwalk.com.android.dex;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UTFDataFormatException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData.Field;
import net.zhuoweizhang.boardwalk.com.android.dex.ClassData.Method;
import net.zhuoweizhang.boardwalk.com.android.dex.Code.CatchHandler;
import net.zhuoweizhang.boardwalk.com.android.dex.Code.Try;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;
import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteOutput;
import net.zhuoweizhang.boardwalk.com.android.dex.util.FileUtils;

public final class Dex {
    private static final int CHECKSUM_OFFSET = 8;
    private static final int CHECKSUM_SIZE = 4;
    static final short[] EMPTY_SHORT_ARRAY = new short[0];
    private static final int SIGNATURE_OFFSET = 12;
    private static final int SIGNATURE_SIZE = 20;
    private ByteBuffer data;
    private final FieldIdTable fieldIds;
    private final MethodIdTable methodIds;
    private int nextSectionStart;
    private final ProtoIdTable protoIds;
    /* access modifiers changed from: private */
    public final StringTable strings;
    /* access modifiers changed from: private */
    public final TableOfContents tableOfContents;
    private final TypeIndexToDescriptorIndexTable typeIds;
    private final TypeIndexToDescriptorTable typeNames;

    private final class ClassDefIterable implements Iterable<ClassDef> {
        final /* synthetic */ Dex this$0;

        private ClassDefIterable(Dex dex) {
            this.this$0 = dex;
        }

        /* synthetic */ ClassDefIterable(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public Iterator<ClassDef> iterator() {
            ClassDefIterator classDefIterator;
            if (!this.this$0.tableOfContents.classDefs.exists()) {
                return Collections.emptySet().iterator();
            }
            ClassDefIterator classDefIterator2 = classDefIterator;
            ClassDefIterator classDefIterator3 = new ClassDefIterator(this.this$0, null);
            return classDefIterator2;
        }
    }

    private final class ClassDefIterator implements Iterator<ClassDef> {
        private int count;

        /* renamed from: in */
        private final Section f161in;
        final /* synthetic */ Dex this$0;

        private ClassDefIterator(Dex dex) {
            this.this$0 = dex;
            this.f161in = this.this$0.open(this.this$0.tableOfContents.classDefs.off);
            this.count = 0;
        }

        /* synthetic */ ClassDefIterator(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public boolean hasNext() {
            return this.count < this.this$0.tableOfContents.classDefs.size;
        }

        public ClassDef next() {
            NoSuchElementException noSuchElementException;
            if (!hasNext()) {
                NoSuchElementException noSuchElementException2 = noSuchElementException;
                NoSuchElementException noSuchElementException3 = new NoSuchElementException();
                throw noSuchElementException2;
            }
            this.count = 1 + this.count;
            return this.f161in.readClassDef();
        }

        public void remove() {
            UnsupportedOperationException unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }
    }

    private final class FieldIdTable extends AbstractList<FieldId> implements RandomAccess {
        final /* synthetic */ Dex this$0;

        private FieldIdTable(Dex dex) {
            this.this$0 = dex;
        }

        /* synthetic */ FieldIdTable(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public FieldId get(int i) {
            int i2 = i;
            Dex.checkBounds(i2, this.this$0.tableOfContents.fieldIds.size);
            return this.this$0.open(this.this$0.tableOfContents.fieldIds.off + (i2 * 8)).readFieldId();
        }

        public int size() {
            return this.this$0.tableOfContents.fieldIds.size;
        }
    }

    private final class MethodIdTable extends AbstractList<MethodId> implements RandomAccess {
        final /* synthetic */ Dex this$0;

        private MethodIdTable(Dex dex) {
            this.this$0 = dex;
        }

        /* synthetic */ MethodIdTable(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public MethodId get(int i) {
            int i2 = i;
            Dex.checkBounds(i2, this.this$0.tableOfContents.methodIds.size);
            return this.this$0.open(this.this$0.tableOfContents.methodIds.off + (i2 * 8)).readMethodId();
        }

        public int size() {
            return this.this$0.tableOfContents.methodIds.size;
        }
    }

    private final class ProtoIdTable extends AbstractList<ProtoId> implements RandomAccess {
        final /* synthetic */ Dex this$0;

        private ProtoIdTable(Dex dex) {
            this.this$0 = dex;
        }

        /* synthetic */ ProtoIdTable(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public ProtoId get(int i) {
            int i2 = i;
            Dex.checkBounds(i2, this.this$0.tableOfContents.protoIds.size);
            return this.this$0.open(this.this$0.tableOfContents.protoIds.off + (i2 * 12)).readProtoId();
        }

        public int size() {
            return this.this$0.tableOfContents.protoIds.size;
        }
    }

    public final class Section implements ByteInput, ByteOutput {
        private final ByteBuffer data;
        private final int initialPosition;
        private final String name;
        final /* synthetic */ Dex this$0;

        private Section(Dex dex, String str, ByteBuffer byteBuffer) {
            String str2 = str;
            ByteBuffer byteBuffer2 = byteBuffer;
            this.this$0 = dex;
            this.name = str2;
            this.data = byteBuffer2;
            this.initialPosition = byteBuffer2.position();
        }

        /* synthetic */ Section(Dex dex, String str, ByteBuffer byteBuffer, C06491 r13) {
            C06491 r4 = r13;
            this(dex, str, byteBuffer);
        }

        private int findCatchHandlerIndex(CatchHandler[] catchHandlerArr, int i) {
            IllegalArgumentException illegalArgumentException;
            CatchHandler[] catchHandlerArr2 = catchHandlerArr;
            int i2 = i;
            for (int i3 = 0; i3 < catchHandlerArr2.length; i3++) {
                if (catchHandlerArr2[i3].getOffset() == i2) {
                    return i3;
                }
            }
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
            throw illegalArgumentException2;
        }

        private byte[] getBytesFrom(int i) {
            int i2 = i;
            byte[] bArr = new byte[(this.data.position() - i2)];
            Buffer position = this.data.position(i2);
            ByteBuffer byteBuffer = this.data.get(bArr);
            return bArr;
        }

        private CatchHandler readCatchHandler(int i) {
            CatchHandler catchHandler;
            int i2 = i;
            int readSleb128 = readSleb128();
            int abs = Math.abs(readSleb128);
            int[] iArr = new int[abs];
            int[] iArr2 = new int[abs];
            for (int i3 = 0; i3 < abs; i3++) {
                iArr[i3] = readUleb128();
                iArr2[i3] = readUleb128();
            }
            CatchHandler catchHandler2 = catchHandler;
            CatchHandler catchHandler3 = new CatchHandler(iArr, iArr2, readSleb128 <= 0 ? readUleb128() : -1, i2);
            return catchHandler2;
        }

        private CatchHandler[] readCatchHandlers() {
            int position = this.data.position();
            int readUleb128 = readUleb128();
            CatchHandler[] catchHandlerArr = new CatchHandler[readUleb128];
            for (int i = 0; i < readUleb128; i++) {
                catchHandlerArr[i] = readCatchHandler(this.data.position() - position);
            }
            return catchHandlerArr;
        }

        /* access modifiers changed from: private */
        public ClassData readClassData() {
            ClassData classData;
            ClassData classData2 = classData;
            ClassData classData3 = new ClassData(readFields(readUleb128()), readFields(readUleb128()), readMethods(readUleb128()), readMethods(readUleb128()));
            return classData2;
        }

        /* access modifiers changed from: private */
        public Code readCode() {
            Try[] tryArr;
            CatchHandler[] catchHandlerArr;
            Code code;
            int readUnsignedShort = readUnsignedShort();
            int readUnsignedShort2 = readUnsignedShort();
            int readUnsignedShort3 = readUnsignedShort();
            int readUnsignedShort4 = readUnsignedShort();
            int readInt = readInt();
            short[] readShortArray = readShortArray(readInt());
            if (readUnsignedShort4 > 0) {
                if (readShortArray.length % 2 == 1) {
                    short readShort = readShort();
                }
                Section open = this.this$0.open(this.data.position());
                skip(readUnsignedShort4 * 8);
                catchHandlerArr = readCatchHandlers();
                tryArr = open.readTries(readUnsignedShort4, catchHandlerArr);
            } else {
                tryArr = new Try[0];
                catchHandlerArr = new CatchHandler[0];
            }
            Code code2 = code;
            Code code3 = new Code(readUnsignedShort, readUnsignedShort2, readUnsignedShort3, readInt, readShortArray, tryArr, catchHandlerArr);
            return code2;
        }

        private Field[] readFields(int i) {
            Field field;
            int i2 = i;
            Field[] fieldArr = new Field[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 += readUleb128();
                Field[] fieldArr2 = fieldArr;
                int i5 = i4;
                Field field2 = field;
                Field field3 = new Field(i3, readUleb128());
                fieldArr2[i5] = field2;
            }
            return fieldArr;
        }

        private Method[] readMethods(int i) {
            Method method;
            int i2 = i;
            Method[] methodArr = new Method[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 += readUleb128();
                Method[] methodArr2 = methodArr;
                int i5 = i4;
                Method method2 = method;
                Method method3 = new Method(i3, readUleb128(), readUleb128());
                methodArr2[i5] = method2;
            }
            return methodArr;
        }

        private Try[] readTries(int i, CatchHandler[] catchHandlerArr) {
            Try tryR;
            int i2 = i;
            CatchHandler[] catchHandlerArr2 = catchHandlerArr;
            Try[] tryArr = new Try[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                Try[] tryArr2 = tryArr;
                int i4 = i3;
                Try tryR2 = tryR;
                Try tryR3 = new Try(readInt(), readUnsignedShort(), findCatchHandlerIndex(catchHandlerArr2, readUnsignedShort()));
                tryArr2[i4] = tryR2;
            }
            return tryArr;
        }

        public void alignToFourBytes() {
            Buffer position = this.data.position(-4 & (3 + this.data.position()));
        }

        public void alignToFourBytesWithZeroFill() {
            while ((3 & this.data.position()) != 0) {
                ByteBuffer put = this.data.put(0);
            }
        }

        public void assertFourByteAligned() {
            IllegalStateException illegalStateException;
            if ((3 & this.data.position()) != 0) {
                IllegalStateException illegalStateException2 = illegalStateException;
                IllegalStateException illegalStateException3 = new IllegalStateException("Not four byte aligned!");
                throw illegalStateException2;
            }
        }

        public int getPosition() {
            return this.data.position();
        }

        public Annotation readAnnotation() {
            EncodedValueReader encodedValueReader;
            Annotation annotation;
            EncodedValue encodedValue;
            byte readByte = readByte();
            int position = this.data.position();
            EncodedValueReader encodedValueReader2 = encodedValueReader;
            EncodedValueReader encodedValueReader3 = new EncodedValueReader((ByteInput) this, 29);
            encodedValueReader2.skipValue();
            Annotation annotation2 = annotation;
            Dex dex = this.this$0;
            byte b = readByte;
            EncodedValue encodedValue2 = encodedValue;
            EncodedValue encodedValue3 = new EncodedValue(getBytesFrom(position));
            Annotation annotation3 = new Annotation(dex, b, encodedValue2);
            return annotation2;
        }

        public byte readByte() {
            return this.data.get();
        }

        public byte[] readByteArray(int i) {
            byte[] bArr = new byte[i];
            ByteBuffer byteBuffer = this.data.get(bArr);
            return bArr;
        }

        public ClassDef readClassDef() {
            ClassDef classDef;
            ClassDef classDef2 = classDef;
            ClassDef classDef3 = new ClassDef(this.this$0, getPosition(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt());
            return classDef2;
        }

        public EncodedValue readEncodedArray() {
            EncodedValueReader encodedValueReader;
            EncodedValue encodedValue;
            int position = this.data.position();
            EncodedValueReader encodedValueReader2 = encodedValueReader;
            EncodedValueReader encodedValueReader3 = new EncodedValueReader((ByteInput) this, 28);
            encodedValueReader2.skipValue();
            EncodedValue encodedValue2 = encodedValue;
            EncodedValue encodedValue3 = new EncodedValue(getBytesFrom(position));
            return encodedValue2;
        }

        public FieldId readFieldId() {
            FieldId fieldId;
            FieldId fieldId2 = fieldId;
            FieldId fieldId3 = new FieldId(this.this$0, readUnsignedShort(), readUnsignedShort(), readInt());
            return fieldId2;
        }

        public int readInt() {
            return this.data.getInt();
        }

        public MethodId readMethodId() {
            MethodId methodId;
            MethodId methodId2 = methodId;
            MethodId methodId3 = new MethodId(this.this$0, readUnsignedShort(), readUnsignedShort(), readInt());
            return methodId2;
        }

        public ProtoId readProtoId() {
            ProtoId protoId;
            ProtoId protoId2 = protoId;
            ProtoId protoId3 = new ProtoId(this.this$0, readInt(), readInt(), readInt());
            return protoId2;
        }

        public short readShort() {
            return this.data.getShort();
        }

        public short[] readShortArray(int i) {
            short[] sArr;
            int i2 = i;
            if (i2 == 0) {
                sArr = Dex.EMPTY_SHORT_ARRAY;
            } else {
                sArr = new short[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    sArr[i3] = readShort();
                }
            }
            return sArr;
        }

        public int readSleb128() {
            return Leb128.readSignedLeb128(this);
        }

        public String readString() {
            DexException dexException;
            DexException dexException2;
            StringBuilder sb;
            int readInt = readInt();
            int position = this.data.position();
            int limit = this.data.limit();
            Buffer position2 = this.data.position(readInt);
            Buffer limit2 = this.data.limit(this.data.capacity());
            try {
                int readUleb128 = readUleb128();
                String decode = Mutf8.decode(this, new char[readUleb128]);
                if (decode.length() != readUleb128) {
                    DexException dexException3 = dexException2;
                    StringBuilder sb2 = sb;
                    StringBuilder sb3 = new StringBuilder();
                    DexException dexException4 = new DexException(sb2.append("Declared length ").append(readUleb128).append(" doesn't match decoded length of ").append(decode.length()).toString());
                    throw dexException3;
                }
                Buffer position3 = this.data.position(position);
                Buffer limit3 = this.data.limit(limit);
                return decode;
            } catch (UTFDataFormatException e) {
                UTFDataFormatException uTFDataFormatException = e;
                DexException dexException5 = dexException;
                DexException dexException6 = new DexException((Throwable) uTFDataFormatException);
                throw dexException5;
            } catch (Throwable th) {
                Throwable th2 = th;
                Buffer position4 = this.data.position(position);
                Buffer limit4 = this.data.limit(limit);
                throw th2;
            }
        }

        public TypeList readTypeList() {
            TypeList typeList;
            short[] readShortArray = readShortArray(readInt());
            alignToFourBytes();
            TypeList typeList2 = typeList;
            TypeList typeList3 = new TypeList(this.this$0, readShortArray);
            return typeList2;
        }

        public int readUleb128() {
            return Leb128.readUnsignedLeb128(this);
        }

        public int readUleb128p1() {
            return -1 + Leb128.readUnsignedLeb128(this);
        }

        public int readUnsignedShort() {
            return 65535 & readShort();
        }

        public int remaining() {
            return this.data.remaining();
        }

        public void skip(int i) {
            IllegalArgumentException illegalArgumentException;
            int i2 = i;
            if (i2 < 0) {
                IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
                throw illegalArgumentException2;
            }
            Buffer position = this.data.position(i2 + this.data.position());
        }

        public int used() {
            return this.data.position() - this.initialPosition;
        }

        public void write(byte[] bArr) {
            byte[] bArr2 = bArr;
            ByteBuffer put = this.data.put(bArr2);
        }

        public void write(short[] sArr) {
            short[] sArr2 = sArr;
            int length = sArr2.length;
            for (int i = 0; i < length; i++) {
                writeShort(sArr2[i]);
            }
        }

        public void writeByte(int i) {
            ByteBuffer put = this.data.put((byte) i);
        }

        public void writeInt(int i) {
            int i2 = i;
            ByteBuffer putInt = this.data.putInt(i2);
        }

        public void writeShort(short s) {
            short s2 = s;
            ByteBuffer putShort = this.data.putShort(s2);
        }

        public void writeSleb128(int i) {
            DexException dexException;
            StringBuilder sb;
            try {
                Leb128.writeSignedLeb128(this, i);
            } catch (ArrayIndexOutOfBoundsException e) {
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
                DexException dexException2 = dexException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                DexException dexException3 = new DexException(sb2.append("Section limit ").append(this.data.limit()).append(" exceeded by ").append(this.name).toString());
                throw dexException2;
            }
        }

        public void writeStringData(String str) {
            AssertionError assertionError;
            String str2 = str;
            try {
                writeUleb128(str2.length());
                write(Mutf8.encode(str2));
                writeByte(0);
            } catch (UTFDataFormatException e) {
                UTFDataFormatException uTFDataFormatException = e;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = new AssertionError();
                throw assertionError2;
            }
        }

        public void writeTypeList(TypeList typeList) {
            short[] types = typeList.getTypes();
            writeInt(types.length);
            int length = types.length;
            for (int i = 0; i < length; i++) {
                writeShort(types[i]);
            }
            alignToFourBytesWithZeroFill();
        }

        public void writeUleb128(int i) {
            DexException dexException;
            StringBuilder sb;
            try {
                Leb128.writeUnsignedLeb128(this, i);
            } catch (ArrayIndexOutOfBoundsException e) {
                ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = e;
                DexException dexException2 = dexException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                DexException dexException3 = new DexException(sb2.append("Section limit ").append(this.data.limit()).append(" exceeded by ").append(this.name).toString());
                throw dexException2;
            }
        }

        public void writeUleb128p1(int i) {
            writeUleb128(i + 1);
        }

        /* JADX WARNING: type inference failed for: r4v2, types: [short] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeUnsignedShort(int r9) {
            /*
                r8 = this;
                r0 = r8
                r1 = r9
                r3 = r1
                short r3 = (short) r3
                r2 = r3
                r3 = r1
                r4 = 65535(0xffff, float:9.1834E-41)
                r5 = r2
                r4 = r4 & r5
                if (r3 == r4) goto L_0x002d
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                r7 = r3
                r3 = r7
                r4 = r7
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r7 = r5
                r5 = r7
                r6 = r7
                r6.<init>()
                java.lang.String r6 = "Expected an unsigned short: "
                java.lang.StringBuilder r5 = r5.append(r6)
                r6 = r1
                java.lang.StringBuilder r5 = r5.append(r6)
                java.lang.String r5 = r5.toString()
                r4.<init>(r5)
                throw r3
            L_0x002d:
                r3 = r0
                r4 = r2
                r3.writeShort(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.zhuoweizhang.boardwalk.com.android.dex.Dex.Section.writeUnsignedShort(int):void");
        }
    }

    private final class StringTable extends AbstractList<String> implements RandomAccess {
        final /* synthetic */ Dex this$0;

        private StringTable(Dex dex) {
            this.this$0 = dex;
        }

        /* synthetic */ StringTable(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public String get(int i) {
            int i2 = i;
            Dex.checkBounds(i2, this.this$0.tableOfContents.stringIds.size);
            return this.this$0.open(this.this$0.tableOfContents.stringIds.off + (i2 * 4)).readString();
        }

        public int size() {
            return this.this$0.tableOfContents.stringIds.size;
        }
    }

    private final class TypeIndexToDescriptorIndexTable extends AbstractList<Integer> implements RandomAccess {
        final /* synthetic */ Dex this$0;

        private TypeIndexToDescriptorIndexTable(Dex dex) {
            this.this$0 = dex;
        }

        /* synthetic */ TypeIndexToDescriptorIndexTable(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public Integer get(int i) {
            return Integer.valueOf(this.this$0.descriptorIndexFromTypeIndex(i));
        }

        public int size() {
            return this.this$0.tableOfContents.typeIds.size;
        }
    }

    private final class TypeIndexToDescriptorTable extends AbstractList<String> implements RandomAccess {
        final /* synthetic */ Dex this$0;

        private TypeIndexToDescriptorTable(Dex dex) {
            this.this$0 = dex;
        }

        /* synthetic */ TypeIndexToDescriptorTable(Dex dex, C06491 r7) {
            C06491 r2 = r7;
            this(dex);
        }

        public String get(int i) {
            return this.this$0.strings.get(this.this$0.descriptorIndexFromTypeIndex(i));
        }

        public int size() {
            return this.this$0.tableOfContents.typeIds.size;
        }
    }

    public Dex(int i) throws IOException {
        TableOfContents tableOfContents2;
        StringTable stringTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable;
        ProtoIdTable protoIdTable;
        FieldIdTable fieldIdTable;
        MethodIdTable methodIdTable;
        int i2 = i;
        TableOfContents tableOfContents3 = tableOfContents2;
        TableOfContents tableOfContents4 = new TableOfContents();
        this.tableOfContents = tableOfContents3;
        this.nextSectionStart = 0;
        StringTable stringTable2 = stringTable;
        StringTable stringTable3 = new StringTable(this, null);
        this.strings = stringTable2;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable2 = typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable3 = new TypeIndexToDescriptorIndexTable(this, null);
        this.typeIds = typeIndexToDescriptorIndexTable2;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable2 = typeIndexToDescriptorTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable3 = new TypeIndexToDescriptorTable(this, null);
        this.typeNames = typeIndexToDescriptorTable2;
        ProtoIdTable protoIdTable2 = protoIdTable;
        ProtoIdTable protoIdTable3 = new ProtoIdTable(this, null);
        this.protoIds = protoIdTable2;
        FieldIdTable fieldIdTable2 = fieldIdTable;
        FieldIdTable fieldIdTable3 = new FieldIdTable(this, null);
        this.fieldIds = fieldIdTable2;
        MethodIdTable methodIdTable2 = methodIdTable;
        MethodIdTable methodIdTable3 = new MethodIdTable(this, null);
        this.methodIds = methodIdTable2;
        this.data = ByteBuffer.wrap(new byte[i2]);
        ByteBuffer order = this.data.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Dex(File file) throws IOException {
        TableOfContents tableOfContents2;
        StringTable stringTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable;
        ProtoIdTable protoIdTable;
        FieldIdTable fieldIdTable;
        MethodIdTable methodIdTable;
        DexException dexException;
        StringBuilder sb;
        FileInputStream fileInputStream;
        ZipFile zipFile;
        DexException dexException2;
        StringBuilder sb2;
        File file2 = file;
        TableOfContents tableOfContents3 = tableOfContents2;
        TableOfContents tableOfContents4 = new TableOfContents();
        this.tableOfContents = tableOfContents3;
        this.nextSectionStart = 0;
        StringTable stringTable2 = stringTable;
        StringTable stringTable3 = new StringTable(this, null);
        this.strings = stringTable2;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable2 = typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable3 = new TypeIndexToDescriptorIndexTable(this, null);
        this.typeIds = typeIndexToDescriptorIndexTable2;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable2 = typeIndexToDescriptorTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable3 = new TypeIndexToDescriptorTable(this, null);
        this.typeNames = typeIndexToDescriptorTable2;
        ProtoIdTable protoIdTable2 = protoIdTable;
        ProtoIdTable protoIdTable3 = new ProtoIdTable(this, null);
        this.protoIds = protoIdTable2;
        FieldIdTable fieldIdTable2 = fieldIdTable;
        FieldIdTable fieldIdTable3 = new FieldIdTable(this, null);
        this.fieldIds = fieldIdTable2;
        MethodIdTable methodIdTable2 = methodIdTable;
        MethodIdTable methodIdTable3 = new MethodIdTable(this, null);
        this.methodIds = methodIdTable2;
        if (FileUtils.hasArchiveSuffix(file2.getName())) {
            ZipFile zipFile2 = zipFile;
            ZipFile zipFile3 = new ZipFile(file2);
            ZipFile zipFile4 = zipFile2;
            ZipEntry entry = zipFile4.getEntry(DexFormat.DEX_IN_JAR_NAME);
            if (entry != null) {
                loadFrom(zipFile4.getInputStream(entry));
                zipFile4.close();
                return;
            }
            DexException dexException3 = dexException2;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            DexException dexException4 = new DexException(sb3.append("Expected classes.dex in ").append(file2).toString());
            throw dexException3;
        } else if (file2.getName().endsWith(".dex")) {
            FileInputStream fileInputStream2 = fileInputStream;
            FileInputStream fileInputStream3 = new FileInputStream(file2);
            loadFrom(fileInputStream2);
        } else {
            DexException dexException5 = dexException;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            DexException dexException6 = new DexException(sb5.append("unknown output extension: ").append(file2).toString());
            throw dexException5;
        }
    }

    public Dex(InputStream inputStream) throws IOException {
        TableOfContents tableOfContents2;
        StringTable stringTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable;
        ProtoIdTable protoIdTable;
        FieldIdTable fieldIdTable;
        MethodIdTable methodIdTable;
        InputStream inputStream2 = inputStream;
        TableOfContents tableOfContents3 = tableOfContents2;
        TableOfContents tableOfContents4 = new TableOfContents();
        this.tableOfContents = tableOfContents3;
        this.nextSectionStart = 0;
        StringTable stringTable2 = stringTable;
        StringTable stringTable3 = new StringTable(this, null);
        this.strings = stringTable2;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable2 = typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable3 = new TypeIndexToDescriptorIndexTable(this, null);
        this.typeIds = typeIndexToDescriptorIndexTable2;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable2 = typeIndexToDescriptorTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable3 = new TypeIndexToDescriptorTable(this, null);
        this.typeNames = typeIndexToDescriptorTable2;
        ProtoIdTable protoIdTable2 = protoIdTable;
        ProtoIdTable protoIdTable3 = new ProtoIdTable(this, null);
        this.protoIds = protoIdTable2;
        FieldIdTable fieldIdTable2 = fieldIdTable;
        FieldIdTable fieldIdTable3 = new FieldIdTable(this, null);
        this.fieldIds = fieldIdTable2;
        MethodIdTable methodIdTable2 = methodIdTable;
        MethodIdTable methodIdTable3 = new MethodIdTable(this, null);
        this.methodIds = methodIdTable2;
        loadFrom(inputStream2);
    }

    private Dex(ByteBuffer byteBuffer) throws IOException {
        TableOfContents tableOfContents2;
        StringTable stringTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable;
        ProtoIdTable protoIdTable;
        FieldIdTable fieldIdTable;
        MethodIdTable methodIdTable;
        ByteBuffer byteBuffer2 = byteBuffer;
        TableOfContents tableOfContents3 = tableOfContents2;
        TableOfContents tableOfContents4 = new TableOfContents();
        this.tableOfContents = tableOfContents3;
        this.nextSectionStart = 0;
        StringTable stringTable2 = stringTable;
        StringTable stringTable3 = new StringTable(this, null);
        this.strings = stringTable2;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable2 = typeIndexToDescriptorIndexTable;
        TypeIndexToDescriptorIndexTable typeIndexToDescriptorIndexTable3 = new TypeIndexToDescriptorIndexTable(this, null);
        this.typeIds = typeIndexToDescriptorIndexTable2;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable2 = typeIndexToDescriptorTable;
        TypeIndexToDescriptorTable typeIndexToDescriptorTable3 = new TypeIndexToDescriptorTable(this, null);
        this.typeNames = typeIndexToDescriptorTable2;
        ProtoIdTable protoIdTable2 = protoIdTable;
        ProtoIdTable protoIdTable3 = new ProtoIdTable(this, null);
        this.protoIds = protoIdTable2;
        FieldIdTable fieldIdTable2 = fieldIdTable;
        FieldIdTable fieldIdTable3 = new FieldIdTable(this, null);
        this.fieldIds = fieldIdTable2;
        MethodIdTable methodIdTable2 = methodIdTable;
        MethodIdTable methodIdTable3 = new MethodIdTable(this, null);
        this.methodIds = methodIdTable2;
        this.data = byteBuffer2;
        ByteBuffer order = this.data.order(ByteOrder.LITTLE_ENDIAN);
        this.tableOfContents.readFrom(this);
    }

    public Dex(byte[] bArr) throws IOException {
        this(ByteBuffer.wrap(bArr));
    }

    /* access modifiers changed from: private */
    public static void checkBounds(int i, int i2) {
        IndexOutOfBoundsException indexOutOfBoundsException;
        StringBuilder sb;
        int i3 = i;
        int i4 = i2;
        if (i3 < 0 || i3 >= i4) {
            IndexOutOfBoundsException indexOutOfBoundsException2 = indexOutOfBoundsException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException3 = new IndexOutOfBoundsException(sb2.append("index:").append(i3).append(", length=").append(i4).toString());
            throw indexOutOfBoundsException2;
        }
    }

    public static Dex create(ByteBuffer byteBuffer) throws IOException {
        Dex dex;
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer order = byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBuffer2.get(0) == 100 && byteBuffer2.get(1) == 101 && byteBuffer2.get(2) == 121 && byteBuffer2.get(3) == 10) {
            Buffer position = byteBuffer2.position(8);
            int i = byteBuffer2.getInt();
            int i2 = byteBuffer2.getInt();
            Buffer position2 = byteBuffer2.position(i);
            Buffer limit = byteBuffer2.limit(i + i2);
            byteBuffer2 = byteBuffer2.slice();
        }
        Dex dex2 = dex;
        Dex dex3 = new Dex(byteBuffer2);
        return dex2;
    }

    private void loadFrom(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2 = inputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream2;
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream2.read(bArr);
            if (read != -1) {
                byteArrayOutputStream4.write(bArr, 0, read);
            } else {
                inputStream2.close();
                this.data = ByteBuffer.wrap(byteArrayOutputStream4.toByteArray());
                ByteBuffer order = this.data.order(ByteOrder.LITTLE_ENDIAN);
                this.tableOfContents.readFrom(this);
                return;
            }
        }
    }

    public int annotationDirectoryOffsetFromClassDefIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.classDefs.size);
        return this.data.getInt(4 + 4 + 4 + 4 + 4 + this.tableOfContents.classDefs.off + (i2 * 32));
    }

    public Section appendSection(int i, String str) {
        Section section;
        IllegalStateException illegalStateException;
        int i2 = i;
        String str2 = str;
        if ((i2 & 3) != 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("Not four byte aligned!");
            throw illegalStateException2;
        }
        int i3 = i2 + this.nextSectionStart;
        ByteBuffer duplicate = this.data.duplicate();
        ByteBuffer order = duplicate.order(ByteOrder.LITTLE_ENDIAN);
        Buffer position = duplicate.position(this.nextSectionStart);
        Buffer limit = duplicate.limit(i3);
        Section section2 = section;
        Section section3 = new Section(this, str2, duplicate, null);
        Section section4 = section2;
        this.nextSectionStart = i3;
        return section4;
    }

    public Iterable<ClassDef> classDefs() {
        ClassDefIterable classDefIterable;
        ClassDefIterable classDefIterable2 = classDefIterable;
        ClassDefIterable classDefIterable3 = new ClassDefIterable(this, null);
        return classDefIterable2;
    }

    public int computeChecksum() throws IOException {
        Adler32 adler32;
        Adler32 adler322 = adler32;
        Adler32 adler323 = new Adler32();
        Adler32 adler324 = adler322;
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        Buffer limit = duplicate.limit(duplicate.capacity());
        Buffer position = duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(bArr.length, duplicate.remaining());
            ByteBuffer byteBuffer = duplicate.get(bArr, 0, min);
            adler324.update(bArr, 0, min);
        }
        return (int) adler324.getValue();
    }

    public byte[] computeSignature() throws IOException {
        AssertionError assertionError;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.data.duplicate();
            Buffer limit = duplicate.limit(duplicate.capacity());
            Buffer position = duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(bArr.length, duplicate.remaining());
                ByteBuffer byteBuffer = duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            NoSuchAlgorithmException noSuchAlgorithmException = e;
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = new AssertionError();
            throw assertionError2;
        }
    }

    public int declaringClassIndexFromMethodIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.methodIds.size);
        return 65535 & this.data.getShort(this.tableOfContents.methodIds.off + (i2 * 8));
    }

    public int descriptorIndexFromTypeIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.typeIds.size);
        return this.data.getInt(this.tableOfContents.typeIds.off + (i2 * 4));
    }

    public List<FieldId> fieldIds() {
        return this.fieldIds;
    }

    public int findClassDefIndexFromTypeIndex(int i) {
        int i2;
        int i3 = i;
        checkBounds(i3, this.tableOfContents.typeIds.size);
        if (!this.tableOfContents.classDefs.exists()) {
            i2 = -1;
        } else {
            i2 = 0;
            while (i2 < this.tableOfContents.classDefs.size) {
                if (typeIndexFromClassDefIndex(i2) != i3) {
                    i2++;
                }
            }
            return -1;
        }
        return i2;
    }

    public int findFieldIndex(FieldId fieldId) {
        return Collections.binarySearch(this.fieldIds, fieldId);
    }

    public int findMethodIndex(MethodId methodId) {
        return Collections.binarySearch(this.methodIds, methodId);
    }

    public int findStringIndex(String str) {
        return Collections.binarySearch(this.strings, str);
    }

    public int findTypeIndex(String str) {
        return Collections.binarySearch(this.typeNames, str);
    }

    public byte[] getBytes() {
        ByteBuffer duplicate = this.data.duplicate();
        byte[] bArr = new byte[duplicate.capacity()];
        Buffer position = duplicate.position(0);
        ByteBuffer byteBuffer = duplicate.get(bArr);
        return bArr;
    }

    public int getLength() {
        return this.data.capacity();
    }

    public int getNextSectionStart() {
        return this.nextSectionStart;
    }

    public TableOfContents getTableOfContents() {
        return this.tableOfContents;
    }

    public short[] interfaceTypeIndicesFromClassDefIndex(int i) {
        short[] sArr;
        AssertionError assertionError;
        StringBuilder sb;
        int i2 = i;
        checkBounds(i2, this.tableOfContents.classDefs.size);
        int i3 = this.data.getInt(4 + 4 + 4 + this.tableOfContents.classDefs.off + (i2 * 32));
        if (i3 == 0) {
            sArr = EMPTY_SHORT_ARRAY;
        } else {
            int i4 = this.data.getInt(i3);
            if (i4 <= 0) {
                AssertionError assertionError2 = assertionError;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                AssertionError assertionError3 = new AssertionError(sb2.append("Unexpected interfaces list size: ").append(i4).toString());
                throw assertionError2;
            }
            int i5 = i3 + 4;
            sArr = new short[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                sArr[i6] = this.data.getShort(i5);
                i5 += 2;
            }
        }
        return sArr;
    }

    public List<MethodId> methodIds() {
        return this.methodIds;
    }

    public int nameIndexFromFieldIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.fieldIds.size);
        return this.data.getInt(2 + 2 + this.tableOfContents.fieldIds.off + (i2 * 8));
    }

    public int nameIndexFromMethodIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.methodIds.size);
        return this.data.getInt(2 + 2 + this.tableOfContents.methodIds.off + (i2 * 8));
    }

    public Section open(int i) {
        IllegalArgumentException illegalArgumentException;
        StringBuilder sb;
        Section section;
        int i2 = i;
        if (i2 < 0 || i2 >= this.data.capacity()) {
            IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(sb2.append("position=").append(i2).append(" length=").append(this.data.capacity()).toString());
            throw illegalArgumentException2;
        }
        ByteBuffer duplicate = this.data.duplicate();
        ByteBuffer order = duplicate.order(ByteOrder.LITTLE_ENDIAN);
        Buffer position = duplicate.position(i2);
        Buffer limit = duplicate.limit(this.data.capacity());
        Section section2 = section;
        Section section3 = new Section(this, "section", duplicate, null);
        return section2;
    }

    public short[] parameterTypeIndicesFromMethodIndex(int i) {
        short[] sArr;
        AssertionError assertionError;
        StringBuilder sb;
        int i2 = i;
        checkBounds(i2, this.tableOfContents.methodIds.size);
        short s = 65535 & this.data.getShort(2 + this.tableOfContents.methodIds.off + (i2 * 8));
        checkBounds(s, this.tableOfContents.protoIds.size);
        int i3 = this.data.getInt(4 + 4 + this.tableOfContents.protoIds.off + (s * 12));
        if (i3 == 0) {
            sArr = EMPTY_SHORT_ARRAY;
        } else {
            int i4 = this.data.getInt(i3);
            if (i4 <= 0) {
                AssertionError assertionError2 = assertionError;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                AssertionError assertionError3 = new AssertionError(sb2.append("Unexpected parameter type list size: ").append(i4).toString());
                throw assertionError2;
            }
            int i5 = i3 + 4;
            sArr = new short[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                sArr[i6] = this.data.getShort(i5);
                i5 += 2;
            }
        }
        return sArr;
    }

    public List<ProtoId> protoIds() {
        return this.protoIds;
    }

    public ClassData readClassData(ClassDef classDef) {
        IllegalArgumentException illegalArgumentException;
        int classDataOffset = classDef.getClassDataOffset();
        if (classDataOffset != 0) {
            return open(classDataOffset).readClassData();
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("offset == 0");
        throw illegalArgumentException2;
    }

    public Code readCode(Method method) {
        IllegalArgumentException illegalArgumentException;
        int codeOffset = method.getCodeOffset();
        if (codeOffset != 0) {
            return open(codeOffset).readCode();
        }
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("offset == 0");
        throw illegalArgumentException2;
    }

    public TypeList readTypeList(int i) {
        int i2 = i;
        return i2 == 0 ? TypeList.EMPTY : open(i2).readTypeList();
    }

    public int returnTypeIndexFromMethodIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.methodIds.size);
        short s = 65535 & this.data.getShort(2 + this.tableOfContents.methodIds.off + (i2 * 8));
        checkBounds(s, this.tableOfContents.protoIds.size);
        return this.data.getInt(4 + this.tableOfContents.protoIds.off + (s * 12));
    }

    public List<String> strings() {
        return this.strings;
    }

    public List<Integer> typeIds() {
        return this.typeIds;
    }

    public int typeIndexFromClassDefIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (i2 * 32));
    }

    public int typeIndexFromFieldIndex(int i) {
        int i2 = i;
        checkBounds(i2, this.tableOfContents.fieldIds.size);
        return 65535 & this.data.getShort(2 + this.tableOfContents.fieldIds.off + (i2 * 8));
    }

    public List<String> typeNames() {
        return this.typeNames;
    }

    public void writeHashes() throws IOException {
        open(12).write(computeSignature());
        open(8).writeInt(computeChecksum());
    }

    public void writeTo(File file) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = fileOutputStream;
        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
        FileOutputStream fileOutputStream4 = fileOutputStream2;
        writeTo((OutputStream) fileOutputStream4);
        fileOutputStream4.close();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        OutputStream outputStream2 = outputStream;
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        Buffer clear = duplicate.clear();
        while (duplicate.hasRemaining()) {
            int min = Math.min(bArr.length, duplicate.remaining());
            ByteBuffer byteBuffer = duplicate.get(bArr, 0, min);
            outputStream2.write(bArr, 0, min);
        }
    }
}

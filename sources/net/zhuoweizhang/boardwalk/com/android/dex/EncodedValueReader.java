package net.zhuoweizhang.boardwalk.com.android.dex;

import net.zhuoweizhang.boardwalk.com.android.dex.util.ByteInput;

public final class EncodedValueReader {
    public static final int ENCODED_ANNOTATION = 29;
    public static final int ENCODED_ARRAY = 28;
    public static final int ENCODED_BOOLEAN = 31;
    public static final int ENCODED_BYTE = 0;
    public static final int ENCODED_CHAR = 3;
    public static final int ENCODED_DOUBLE = 17;
    public static final int ENCODED_ENUM = 27;
    public static final int ENCODED_FIELD = 25;
    public static final int ENCODED_FLOAT = 16;
    public static final int ENCODED_INT = 4;
    public static final int ENCODED_LONG = 6;
    public static final int ENCODED_METHOD = 26;
    public static final int ENCODED_NULL = 30;
    public static final int ENCODED_SHORT = 2;
    public static final int ENCODED_STRING = 23;
    public static final int ENCODED_TYPE = 24;
    private static final int MUST_READ = -1;
    private int annotationType;
    private int arg;

    /* renamed from: in */
    protected final ByteInput f162in;
    private int type;

    public EncodedValueReader(EncodedValue encodedValue) {
        this(encodedValue.asByteInput());
    }

    public EncodedValueReader(EncodedValue encodedValue, int i) {
        this(encodedValue.asByteInput(), i);
    }

    public EncodedValueReader(ByteInput byteInput) {
        ByteInput byteInput2 = byteInput;
        this.type = -1;
        this.f162in = byteInput2;
    }

    public EncodedValueReader(ByteInput byteInput, int i) {
        ByteInput byteInput2 = byteInput;
        int i2 = i;
        this.type = -1;
        this.f162in = byteInput2;
        this.type = i2;
    }

    private void checkType(int i) {
        IllegalStateException illegalStateException;
        int i2 = i;
        if (peek() != i2) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException(String.format("Expected %x but was %x", new Object[]{Integer.valueOf(i2), Integer.valueOf(peek())}));
            throw illegalStateException2;
        }
    }

    public int getAnnotationType() {
        return this.annotationType;
    }

    public int peek() {
        if (this.type == -1) {
            byte readByte = 255 & this.f162in.readByte();
            this.type = readByte & 31;
            this.arg = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public int readAnnotation() {
        checkType(29);
        this.type = -1;
        this.annotationType = Leb128.readUnsignedLeb128(this.f162in);
        return Leb128.readUnsignedLeb128(this.f162in);
    }

    public int readAnnotationName() {
        return Leb128.readUnsignedLeb128(this.f162in);
    }

    public int readArray() {
        checkType(28);
        this.type = -1;
        return Leb128.readUnsignedLeb128(this.f162in);
    }

    public boolean readBoolean() {
        checkType(31);
        this.type = -1;
        return this.arg != 0;
    }

    public byte readByte() {
        checkType(0);
        this.type = -1;
        return (byte) EncodedValueCodec.readSignedInt(this.f162in, this.arg);
    }

    public char readChar() {
        checkType(3);
        this.type = -1;
        return (char) EncodedValueCodec.readUnsignedInt(this.f162in, this.arg, false);
    }

    public double readDouble() {
        checkType(17);
        this.type = -1;
        return Double.longBitsToDouble(EncodedValueCodec.readUnsignedLong(this.f162in, this.arg, true));
    }

    public int readEnum() {
        checkType(27);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.f162in, this.arg, false);
    }

    public int readField() {
        checkType(25);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.f162in, this.arg, false);
    }

    public float readFloat() {
        checkType(16);
        this.type = -1;
        return Float.intBitsToFloat(EncodedValueCodec.readUnsignedInt(this.f162in, this.arg, true));
    }

    public int readInt() {
        checkType(4);
        this.type = -1;
        return EncodedValueCodec.readSignedInt(this.f162in, this.arg);
    }

    public long readLong() {
        checkType(6);
        this.type = -1;
        return EncodedValueCodec.readSignedLong(this.f162in, this.arg);
    }

    public int readMethod() {
        checkType(26);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.f162in, this.arg, false);
    }

    public void readNull() {
        checkType(30);
        this.type = -1;
    }

    public short readShort() {
        checkType(2);
        this.type = -1;
        return (short) EncodedValueCodec.readSignedInt(this.f162in, this.arg);
    }

    public int readString() {
        checkType(23);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.f162in, this.arg, false);
    }

    public int readType() {
        checkType(24);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.f162in, this.arg, false);
    }

    public void skipValue() {
        DexException dexException;
        StringBuilder sb;
        int i = 0;
        switch (peek()) {
            case 0:
                byte readByte = readByte();
                return;
            case 2:
                short readShort = readShort();
                return;
            case 3:
                char readChar = readChar();
                return;
            case 4:
                int readInt = readInt();
                return;
            case 6:
                long readLong = readLong();
                return;
            case 16:
                float readFloat = readFloat();
                return;
            case 17:
                double readDouble = readDouble();
                return;
            case 23:
                int readString = readString();
                return;
            case 24:
                int readType = readType();
                return;
            case 25:
                int readField = readField();
                return;
            case 26:
                int readMethod = readMethod();
                return;
            case 27:
                int readEnum = readEnum();
                return;
            case 28:
                int readArray = readArray();
                while (i < readArray) {
                    skipValue();
                    i++;
                }
                return;
            case 29:
                int readAnnotation = readAnnotation();
                while (i < readAnnotation) {
                    int readAnnotationName = readAnnotationName();
                    skipValue();
                    i++;
                }
                return;
            case 30:
                readNull();
                return;
            case 31:
                boolean readBoolean = readBoolean();
                return;
            default:
                DexException dexException2 = dexException;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                DexException dexException3 = new DexException(sb2.append("Unexpected type: ").append(Integer.toHexString(this.type)).toString());
                throw dexException2;
        }
    }
}

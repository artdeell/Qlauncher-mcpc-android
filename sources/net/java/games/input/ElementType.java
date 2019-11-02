package net.java.games.input;

final class ElementType {
    public static final ElementType COLLECTION;
    public static final ElementType FEATURE;
    public static final ElementType INPUT_AXIS;
    public static final ElementType INPUT_BUTTON;
    public static final ElementType INPUT_MISC;
    public static final ElementType INPUT_SCANCODES;
    public static final ElementType OUTPUT;
    private static final ElementType[] map = new ElementType[514];
    private final int type_id;

    static {
        ElementType elementType;
        ElementType elementType2;
        ElementType elementType3;
        ElementType elementType4;
        ElementType elementType5;
        ElementType elementType6;
        ElementType elementType7;
        ElementType elementType8 = elementType;
        ElementType elementType9 = new ElementType(1);
        INPUT_MISC = elementType8;
        ElementType elementType10 = elementType2;
        ElementType elementType11 = new ElementType(2);
        INPUT_BUTTON = elementType10;
        ElementType elementType12 = elementType3;
        ElementType elementType13 = new ElementType(3);
        INPUT_AXIS = elementType12;
        ElementType elementType14 = elementType4;
        ElementType elementType15 = new ElementType(4);
        INPUT_SCANCODES = elementType14;
        ElementType elementType16 = elementType5;
        ElementType elementType17 = new ElementType(129);
        OUTPUT = elementType16;
        ElementType elementType18 = elementType6;
        ElementType elementType19 = new ElementType(257);
        FEATURE = elementType18;
        ElementType elementType20 = elementType7;
        ElementType elementType21 = new ElementType(513);
        COLLECTION = elementType20;
    }

    private ElementType(int i) {
        int i2 = i;
        map[i2] = this;
        this.type_id = i2;
    }

    public static final ElementType map(int i) {
        int i2 = i;
        if (i2 < 0 || i2 >= map.length) {
            return null;
        }
        return map[i2];
    }

    public final String toString() {
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        return stringBuffer2.append("ElementType (0x").append(Integer.toHexString(this.type_id)).append(")").toString();
    }
}

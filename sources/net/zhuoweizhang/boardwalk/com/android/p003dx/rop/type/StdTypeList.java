package net.zhuoweizhang.boardwalk.com.android.p003dx.rop.type;

import net.zhuoweizhang.boardwalk.com.android.p003dx.util.FixedSizeList;

/* renamed from: net.zhuoweizhang.boardwalk.com.android.dx.rop.type.StdTypeList */
public final class StdTypeList extends FixedSizeList implements TypeList {
    public static final StdTypeList BOOLEANARR_INT = make(Type.BOOLEAN_ARRAY, Type.INT);
    public static final StdTypeList BYTEARR_INT = make(Type.BYTE_ARRAY, Type.INT);
    public static final StdTypeList CHARARR_INT = make(Type.CHAR_ARRAY, Type.INT);
    public static final StdTypeList DOUBLE = make(Type.DOUBLE);
    public static final StdTypeList DOUBLEARR_INT = make(Type.DOUBLE_ARRAY, Type.INT);
    public static final StdTypeList DOUBLE_DOUBLE = make(Type.DOUBLE, Type.DOUBLE);
    public static final StdTypeList DOUBLE_DOUBLEARR_INT = make(Type.DOUBLE, Type.DOUBLE_ARRAY, Type.INT);
    public static final StdTypeList DOUBLE_OBJECT = make(Type.DOUBLE, Type.OBJECT);
    public static final StdTypeList EMPTY;
    public static final StdTypeList FLOAT = make(Type.FLOAT);
    public static final StdTypeList FLOATARR_INT = make(Type.FLOAT_ARRAY, Type.INT);
    public static final StdTypeList FLOAT_FLOAT = make(Type.FLOAT, Type.FLOAT);
    public static final StdTypeList FLOAT_FLOATARR_INT = make(Type.FLOAT, Type.FLOAT_ARRAY, Type.INT);
    public static final StdTypeList FLOAT_OBJECT = make(Type.FLOAT, Type.OBJECT);
    public static final StdTypeList INT = make(Type.INT);
    public static final StdTypeList INTARR_INT = make(Type.INT_ARRAY, Type.INT);
    public static final StdTypeList INT_BOOLEANARR_INT = make(Type.INT, Type.BOOLEAN_ARRAY, Type.INT);
    public static final StdTypeList INT_BYTEARR_INT = make(Type.INT, Type.BYTE_ARRAY, Type.INT);
    public static final StdTypeList INT_CHARARR_INT = make(Type.INT, Type.CHAR_ARRAY, Type.INT);
    public static final StdTypeList INT_INT = make(Type.INT, Type.INT);
    public static final StdTypeList INT_INTARR_INT = make(Type.INT, Type.INT_ARRAY, Type.INT);
    public static final StdTypeList INT_OBJECT = make(Type.INT, Type.OBJECT);
    public static final StdTypeList INT_SHORTARR_INT = make(Type.INT, Type.SHORT_ARRAY, Type.INT);
    public static final StdTypeList LONG = make(Type.LONG);
    public static final StdTypeList LONGARR_INT = make(Type.LONG_ARRAY, Type.INT);
    public static final StdTypeList LONG_INT = make(Type.LONG, Type.INT);
    public static final StdTypeList LONG_LONG = make(Type.LONG, Type.LONG);
    public static final StdTypeList LONG_LONGARR_INT = make(Type.LONG, Type.LONG_ARRAY, Type.INT);
    public static final StdTypeList LONG_OBJECT = make(Type.LONG, Type.OBJECT);
    public static final StdTypeList OBJECT = make(Type.OBJECT);
    public static final StdTypeList OBJECTARR_INT = make(Type.OBJECT_ARRAY, Type.INT);
    public static final StdTypeList OBJECT_OBJECT = make(Type.OBJECT, Type.OBJECT);
    public static final StdTypeList OBJECT_OBJECTARR_INT = make(Type.OBJECT, Type.OBJECT_ARRAY, Type.INT);
    public static final StdTypeList RETURN_ADDRESS = make(Type.RETURN_ADDRESS);
    public static final StdTypeList SHORTARR_INT = make(Type.SHORT_ARRAY, Type.INT);
    public static final StdTypeList THROWABLE = make(Type.THROWABLE);

    static {
        StdTypeList stdTypeList;
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(0);
        EMPTY = stdTypeList2;
    }

    public StdTypeList(int i) {
        super(i);
    }

    public static int compareContents(TypeList typeList, TypeList typeList2) {
        TypeList typeList3 = typeList;
        TypeList typeList4 = typeList2;
        int size = typeList3.size();
        int size2 = typeList4.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int compareTo = typeList3.getType(i).compareTo(typeList4.getType(i));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static boolean equalContents(TypeList typeList, TypeList typeList2) {
        TypeList typeList3 = typeList;
        TypeList typeList4 = typeList2;
        int size = typeList3.size();
        if (typeList4.size() == size) {
            int i = 0;
            while (i < size) {
                if (typeList3.getType(i).equals(typeList4.getType(i))) {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public static int hashContents(TypeList typeList) {
        TypeList typeList2 = typeList;
        int i = 0;
        for (int i2 = 0; i2 < typeList2.size(); i2++) {
            i = (i * 31) + typeList2.getType(i2).hashCode();
        }
        return i;
    }

    public static StdTypeList make(Type type) {
        StdTypeList stdTypeList;
        Type type2 = type;
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(1);
        StdTypeList stdTypeList4 = stdTypeList2;
        stdTypeList4.set(0, type2);
        return stdTypeList4;
    }

    public static StdTypeList make(Type type, Type type2) {
        StdTypeList stdTypeList;
        Type type3 = type;
        Type type4 = type2;
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(2);
        StdTypeList stdTypeList4 = stdTypeList2;
        stdTypeList4.set(0, type3);
        stdTypeList4.set(1, type4);
        return stdTypeList4;
    }

    public static StdTypeList make(Type type, Type type2, Type type3) {
        StdTypeList stdTypeList;
        Type type4 = type;
        Type type5 = type2;
        Type type6 = type3;
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(3);
        StdTypeList stdTypeList4 = stdTypeList2;
        stdTypeList4.set(0, type4);
        stdTypeList4.set(1, type5);
        stdTypeList4.set(2, type6);
        return stdTypeList4;
    }

    public static StdTypeList make(Type type, Type type2, Type type3, Type type4) {
        StdTypeList stdTypeList;
        Type type5 = type;
        Type type6 = type2;
        Type type7 = type3;
        Type type8 = type4;
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(4);
        StdTypeList stdTypeList4 = stdTypeList2;
        stdTypeList4.set(0, type5);
        stdTypeList4.set(1, type6);
        stdTypeList4.set(2, type7);
        stdTypeList4.set(3, type8);
        return stdTypeList4;
    }

    public static String toHuman(TypeList typeList) {
        StringBuffer stringBuffer;
        TypeList typeList2 = typeList;
        int size = typeList2.size();
        if (size == 0) {
            return "<empty>";
        }
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer(100);
        StringBuffer stringBuffer4 = stringBuffer2;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                StringBuffer append = stringBuffer4.append(", ");
            }
            StringBuffer append2 = stringBuffer4.append(typeList2.getType(i).toHuman());
        }
        return stringBuffer4.toString();
    }

    public Type get(int i) {
        return (Type) get0(i);
    }

    public Type getType(int i) {
        return get(i);
    }

    public int getWordCount() {
        int i = 0;
        for (int i2 = 0; i2 < size(); i2++) {
            i += get(i2).getCategory();
        }
        return i;
    }

    public void set(int i, Type type) {
        set0(i, type);
    }

    public TypeList withAddedType(Type type) {
        StdTypeList stdTypeList;
        Type type2 = type;
        int size = size();
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(size + 1);
        StdTypeList stdTypeList4 = stdTypeList2;
        for (int i = 0; i < size; i++) {
            stdTypeList4.set0(i, get0(i));
        }
        stdTypeList4.set(size, type2);
        stdTypeList4.setImmutable();
        return stdTypeList4;
    }

    public StdTypeList withFirst(Type type) {
        StdTypeList stdTypeList;
        Type type2 = type;
        int size = size();
        StdTypeList stdTypeList2 = stdTypeList;
        StdTypeList stdTypeList3 = new StdTypeList(size + 1);
        StdTypeList stdTypeList4 = stdTypeList2;
        stdTypeList4.set0(0, type2);
        for (int i = 0; i < size; i++) {
            stdTypeList4.set0(i + 1, getOrNull0(i));
        }
        return stdTypeList4;
    }
}

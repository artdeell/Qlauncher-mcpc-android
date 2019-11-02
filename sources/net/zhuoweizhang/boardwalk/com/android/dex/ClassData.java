package net.zhuoweizhang.boardwalk.com.android.dex;

public final class ClassData {
    private final Method[] directMethods;
    private final Field[] instanceFields;
    private final Field[] staticFields;
    private final Method[] virtualMethods;

    public static class Field {
        private final int accessFlags;
        private final int fieldIndex;

        public Field(int i, int i2) {
            int i3 = i2;
            this.fieldIndex = i;
            this.accessFlags = i3;
        }

        public int getAccessFlags() {
            return this.accessFlags;
        }

        public int getFieldIndex() {
            return this.fieldIndex;
        }
    }

    public static class Method {
        private final int accessFlags;
        private final int codeOffset;
        private final int methodIndex;

        public Method(int i, int i2, int i3) {
            int i4 = i2;
            int i5 = i3;
            this.methodIndex = i;
            this.accessFlags = i4;
            this.codeOffset = i5;
        }

        public int getAccessFlags() {
            return this.accessFlags;
        }

        public int getCodeOffset() {
            return this.codeOffset;
        }

        public int getMethodIndex() {
            return this.methodIndex;
        }
    }

    public ClassData(Field[] fieldArr, Field[] fieldArr2, Method[] methodArr, Method[] methodArr2) {
        Field[] fieldArr3 = fieldArr2;
        Method[] methodArr3 = methodArr;
        Method[] methodArr4 = methodArr2;
        this.staticFields = fieldArr;
        this.instanceFields = fieldArr3;
        this.directMethods = methodArr3;
        this.virtualMethods = methodArr4;
    }

    public Field[] allFields() {
        Field[] fieldArr = new Field[(this.staticFields.length + this.instanceFields.length)];
        System.arraycopy(this.staticFields, 0, fieldArr, 0, this.staticFields.length);
        System.arraycopy(this.instanceFields, 0, fieldArr, this.staticFields.length, this.instanceFields.length);
        return fieldArr;
    }

    public Method[] allMethods() {
        Method[] methodArr = new Method[(this.directMethods.length + this.virtualMethods.length)];
        System.arraycopy(this.directMethods, 0, methodArr, 0, this.directMethods.length);
        System.arraycopy(this.virtualMethods, 0, methodArr, this.directMethods.length, this.virtualMethods.length);
        return methodArr;
    }

    public Method[] getDirectMethods() {
        return this.directMethods;
    }

    public Field[] getInstanceFields() {
        return this.instanceFields;
    }

    public Field[] getStaticFields() {
        return this.staticFields;
    }

    public Method[] getVirtualMethods() {
        return this.virtualMethods;
    }
}

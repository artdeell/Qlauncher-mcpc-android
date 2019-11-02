package org.lwjgl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import sun.misc.Unsafe;
import sun.reflect.FieldAccessor;

final class MemoryUtilSun {

    private static class AccessorReflectFast implements Accessor {
        private final FieldAccessor addressAccessor;

        AccessorReflectFast() {
            UnsupportedOperationException unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException2;
            try {
                Field addressField = MemoryUtil.getAddressField();
                addressField.setAccessible(true);
                try {
                    Method declaredMethod = Field.class.getDeclaredMethod("acquireFieldAccessor", new Class[]{Boolean.TYPE});
                    declaredMethod.setAccessible(true);
                    this.addressAccessor = (FieldAccessor) declaredMethod.invoke(addressField, new Object[]{Boolean.valueOf(true)});
                } catch (Exception e) {
                    Exception exc = e;
                    UnsupportedOperationException unsupportedOperationException3 = unsupportedOperationException2;
                    UnsupportedOperationException unsupportedOperationException4 = new UnsupportedOperationException(exc);
                    throw unsupportedOperationException3;
                }
            } catch (NoSuchFieldException e2) {
                NoSuchFieldException noSuchFieldException = e2;
                UnsupportedOperationException unsupportedOperationException5 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException6 = new UnsupportedOperationException(noSuchFieldException);
                throw unsupportedOperationException5;
            }
        }

        public long getAddress(Buffer buffer) {
            return this.addressAccessor.getLong(buffer);
        }
    }

    private static class AccessorUnsafe implements Accessor {
        private final long address;
        private final Unsafe unsafe;

        AccessorUnsafe() {
            UnsupportedOperationException unsupportedOperationException;
            try {
                this.unsafe = getUnsafeInstance();
                this.address = this.unsafe.objectFieldOffset(MemoryUtil.getAddressField());
            } catch (Exception e) {
                Exception exc = e;
                UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(exc);
                throw unsupportedOperationException2;
            }
        }

        private static Unsafe getUnsafeInstance() {
            UnsupportedOperationException unsupportedOperationException;
            Field[] declaredFields = Unsafe.class.getDeclaredFields();
            int length = declaredFields.length;
            for (int i = 0; i < length; i++) {
                Field field = declaredFields[i];
                if (field.getType().equals(Unsafe.class)) {
                    int modifiers = field.getModifiers();
                    if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                        field.setAccessible(true);
                        try {
                            return (Unsafe) field.get(null);
                        } catch (IllegalAccessException e) {
                            IllegalAccessException illegalAccessException = e;
                        }
                    }
                }
            }
            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
            throw unsupportedOperationException2;
        }

        public long getAddress(Buffer buffer) {
            return this.unsafe.getLong(buffer, this.address);
        }
    }

    private MemoryUtilSun() {
    }
}

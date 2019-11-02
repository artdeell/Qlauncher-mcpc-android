package org.lwjgl.util.mapped;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

final class MappedObjectUnsafe {
    private static final long BUFFER_ADDRESS_OFFSET = getObjectFieldOffset(ByteBuffer.class, "address");
    private static final long BUFFER_CAPACITY_OFFSET = getObjectFieldOffset(ByteBuffer.class, "capacity");
    static final Unsafe INSTANCE = getUnsafeInstance();
    private static final ByteBuffer global = ByteBuffer.allocateDirect(4096);

    MappedObjectUnsafe() {
    }

    private static long getObjectFieldOffset(Class<?> cls, String str) {
        UnsupportedOperationException unsupportedOperationException;
        Class<?> cls2 = cls;
        String str2 = str;
        while (cls2 != null) {
            try {
                return INSTANCE.objectFieldOffset(cls2.getDeclaredField(str2));
            } catch (Throwable th) {
                Throwable th2 = th;
                cls2 = cls2.getSuperclass();
            }
        }
        UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
        UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException();
        throw unsupportedOperationException2;
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

    static ByteBuffer newBuffer(long j, int i) {
        IllegalStateException illegalStateException;
        long j2 = j;
        int i2 = i;
        if (j2 <= 0 || i2 < 0) {
            IllegalStateException illegalStateException2 = illegalStateException;
            IllegalStateException illegalStateException3 = new IllegalStateException("you almost crashed the jvm");
            throw illegalStateException2;
        }
        ByteBuffer order = global.duplicate().order(ByteOrder.nativeOrder());
        INSTANCE.putLong(order, BUFFER_ADDRESS_OFFSET, j2);
        INSTANCE.putInt(order, BUFFER_CAPACITY_OFFSET, i2);
        Buffer position = order.position(0);
        Buffer limit = order.limit(i2);
        return order;
    }
}

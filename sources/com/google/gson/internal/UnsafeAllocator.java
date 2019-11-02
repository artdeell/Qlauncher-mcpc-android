package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {
    public UnsafeAllocator() {
    }

    public static UnsafeAllocator create() {
        C04904 r23;
        C04893 r232;
        C04882 r233;
        C04871 r234;
        try {
            Class cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            C04871 r15 = r234;
            Class[] clsArr = new Class[1];
            Class[] clsArr2 = clsArr;
            clsArr[0] = Class.class;
            final Method method = cls.getMethod("allocateInstance", clsArr2);
            final Object obj2 = obj;
            C04871 r16 = new UnsafeAllocator() {
                {
                    Object obj = r7;
                }

                public <T> T newInstance(Class<T> cls) throws Exception {
                    Class<T> cls2 = cls;
                    Method method = method;
                    Object obj = obj2;
                    Object[] objArr = new Object[1];
                    Object[] objArr2 = objArr;
                    objArr[0] = cls2;
                    return method.invoke(obj, objArr2);
                }
            };
            return r15;
        } catch (Exception e) {
            Exception exc = e;
            Class<ObjectInputStream> cls2 = ObjectInputStream.class;
            String str = "newInstance";
            try {
                Class[] clsArr3 = new Class[2];
                Class[] clsArr4 = clsArr3;
                clsArr3[0] = Class.class;
                Class[] clsArr5 = clsArr4;
                Class[] clsArr6 = clsArr5;
                clsArr5[1] = Class.class;
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr6);
                declaredMethod.setAccessible(true);
                C04882 r152 = r233;
                final Method method2 = declaredMethod;
                C04882 r162 = new UnsafeAllocator() {
                    public <T> T newInstance(Class<T> cls) throws Exception {
                        Class<T> cls2 = cls;
                        Method method = method2;
                        Object[] objArr = new Object[2];
                        Object[] objArr2 = objArr;
                        objArr[0] = cls2;
                        Object[] objArr3 = objArr2;
                        Object[] objArr4 = objArr3;
                        objArr3[1] = Object.class;
                        return method.invoke(null, objArr4);
                    }
                };
                return r152;
            } catch (Exception e2) {
                Exception exc2 = e2;
                Class<ObjectStreamClass> cls3 = ObjectStreamClass.class;
                String str2 = "getConstructorId";
                try {
                    Class[] clsArr7 = new Class[1];
                    Class[] clsArr8 = clsArr7;
                    clsArr7[0] = Class.class;
                    Method declaredMethod2 = cls3.getDeclaredMethod(str2, clsArr8);
                    declaredMethod2.setAccessible(true);
                    Method method3 = declaredMethod2;
                    Object[] objArr = new Object[1];
                    Object[] objArr2 = objArr;
                    objArr[0] = Object.class;
                    int intValue = ((Integer) method3.invoke(null, objArr2)).intValue();
                    Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                    declaredMethod3.setAccessible(true);
                    C04893 r153 = r232;
                    final Method method4 = declaredMethod3;
                    final int i = intValue;
                    C04893 r163 = new UnsafeAllocator() {
                        {
                            int i = r7;
                        }

                        public <T> T newInstance(Class<T> cls) throws Exception {
                            Class<T> cls2 = cls;
                            return method4.invoke(null, new Object[]{cls2, Integer.valueOf(i)});
                        }
                    };
                    return r153;
                } catch (Exception e3) {
                    Exception exc3 = e3;
                    C04904 r154 = r23;
                    C04904 r164 = new UnsafeAllocator() {
                        public <T> T newInstance(Class<T> cls) {
                            UnsupportedOperationException unsupportedOperationException;
                            StringBuilder sb;
                            Class<T> cls2 = cls;
                            UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException;
                            StringBuilder sb2 = sb;
                            StringBuilder sb3 = new StringBuilder();
                            UnsupportedOperationException unsupportedOperationException3 = new UnsupportedOperationException(sb2.append("Cannot allocate ").append(cls2).toString());
                            throw unsupportedOperationException2;
                        }
                    };
                    return r154;
                }
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}

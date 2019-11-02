package org.lwjgl.input;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.InputImplementation;

final class OpenGLPackageAccess {
    static final Object global_lock;

    static {
        Error error;
        C07561 r4;
        try {
            C07561 r1 = r4;
            C07561 r2 = new PrivilegedExceptionAction<Object>() {
                public Object run() throws Exception {
                    Field declaredField = Class.forName("org.lwjgl.opengl.GlobalLock").getDeclaredField("lock");
                    declaredField.setAccessible(true);
                    return declaredField.get(null);
                }
            };
            global_lock = AccessController.doPrivileged(r1);
        } catch (PrivilegedActionException e) {
            PrivilegedActionException privilegedActionException = e;
            Error error2 = error;
            Error error3 = new Error(privilegedActionException);
            throw error2;
        }
    }

    OpenGLPackageAccess() {
    }

    static InputImplementation createImplementation() {
        Error error;
        C07572 r5;
        try {
            C07572 r2 = r5;
            C07572 r3 = new PrivilegedExceptionAction<InputImplementation>() {
                public InputImplementation run() throws Exception {
                    Method declaredMethod = Display.class.getDeclaredMethod("getImplementation", new Class[0]);
                    declaredMethod.setAccessible(true);
                    return (InputImplementation) declaredMethod.invoke(null, new Object[0]);
                }
            };
            return (InputImplementation) AccessController.doPrivileged(r2);
        } catch (PrivilegedActionException e) {
            PrivilegedActionException privilegedActionException = e;
            Error error2 = error;
            Error error3 = new Error(privilegedActionException);
            throw error2;
        }
    }
}

package org.lwjgl.opengl;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.IllegalComponentStateException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

final class AWTUtil {
    AWTUtil() {
    }

    public static Cursor createCursor(int i, int i2, int i3, int i4, int i5, IntBuffer intBuffer, IntBuffer intBuffer2) throws LWJGLException {
        BufferedImage bufferedImage;
        Point point;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        BufferedImage bufferedImage2 = bufferedImage;
        BufferedImage bufferedImage3 = new BufferedImage(i6, i7, 2);
        BufferedImage bufferedImage4 = bufferedImage2;
        int[] iArr = new int[intBuffer3.remaining()];
        int position = intBuffer3.position();
        IntBuffer intBuffer5 = intBuffer3.get(iArr);
        Buffer position2 = intBuffer3.position(position);
        bufferedImage4.setRGB(0, 0, i6, i7, iArr, 0, i6);
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        BufferedImage bufferedImage5 = bufferedImage4;
        Point point2 = point;
        Point point3 = new Point(i8, i9);
        return defaultToolkit.createCustomCursor(bufferedImage5, point2, "LWJGL Custom cursor");
    }

    public static Robot createRobot(Component component) {
        StringBuilder sb;
        C07811 r6;
        try {
            C07811 r3 = r6;
            final Component component2 = component;
            C07811 r4 = new PrivilegedExceptionAction<Robot>() {
                public Robot run() throws Exception {
                    Robot robot;
                    Robot robot2 = robot;
                    Robot robot3 = new Robot(component2.getGraphicsConfiguration().getDevice());
                    return robot2;
                }
            };
            return (Robot) AccessController.doPrivileged(r3);
        } catch (PrivilegedActionException e) {
            PrivilegedActionException privilegedActionException = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Got exception while creating robot: ").append(privilegedActionException.getCause()).toString());
            return null;
        }
    }

    public static int getButtonCount() {
        return 3;
    }

    public static Point getCursorPosition(Component component) {
        StringBuilder sb;
        StringBuilder sb2;
        Component component2 = component;
        try {
            Point pointerLocation = getPointerLocation(component2);
            if (pointerLocation != null) {
                Point locationOnScreen = component2.getLocationOnScreen();
                pointerLocation.translate(-locationOnScreen.x, -locationOnScreen.y);
                pointerLocation.move(pointerLocation.x, transformY(component2, pointerLocation.y));
                return pointerLocation;
            }
        } catch (IllegalComponentStateException e) {
            IllegalComponentStateException illegalComponentStateException = e;
            StringBuilder sb3 = sb2;
            StringBuilder sb4 = new StringBuilder();
            LWJGLUtil.log(sb3.append("Failed to set cursor position: ").append(illegalComponentStateException).toString());
        } catch (NoClassDefFoundError e2) {
            NoClassDefFoundError noClassDefFoundError = e2;
            StringBuilder sb5 = sb;
            StringBuilder sb6 = new StringBuilder();
            LWJGLUtil.log(sb5.append("Failed to query cursor position: ").append(noClassDefFoundError).toString());
        }
        return null;
    }

    public static int getMaxCursorSize() {
        Dimension bestCursorSize = Toolkit.getDefaultToolkit().getBestCursorSize(IDirectInputDevice.DI_FFNOMINALMAX, IDirectInputDevice.DI_FFNOMINALMAX);
        return Math.min(bestCursorSize.width, bestCursorSize.height);
    }

    public static int getMinCursorSize() {
        Dimension bestCursorSize = Toolkit.getDefaultToolkit().getBestCursorSize(0, 0);
        return Math.max(bestCursorSize.width, bestCursorSize.height);
    }

    public static int getNativeCursorCapabilities() {
        int i = 4;
        if (LWJGLUtil.getPlatform() == 2 && !LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 4)) {
            return 0;
        }
        if (Toolkit.getDefaultToolkit().getMaximumCursorColors() >= 32767 && getMaxCursorSize() > 0) {
            i = 3;
        }
        return i;
    }

    private static Point getPointerLocation(Component component) {
        StringBuilder sb;
        C07822 r10;
        try {
            GraphicsConfiguration graphicsConfiguration = component.getGraphicsConfiguration();
            Point point = null;
            if (graphicsConfiguration != null) {
                C07822 r8 = r10;
                C07822 r9 = new PrivilegedExceptionAction<PointerInfo>() {
                    public PointerInfo run() throws Exception {
                        return MouseInfo.getPointerInfo();
                    }
                };
                PointerInfo pointerInfo = (PointerInfo) AccessController.doPrivileged(r8);
                point = null;
                if (pointerInfo.getDevice() == graphicsConfiguration.getDevice()) {
                    point = pointerInfo.getLocation();
                }
            }
            return point;
        } catch (Exception e) {
            Exception exc = e;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            LWJGLUtil.log(sb2.append("Failed to query pointer location: ").append(exc.getCause()).toString());
            return null;
        }
    }

    public static boolean hasWheel() {
        return true;
    }

    public static void setCursorPosition(Component component, Robot robot, int i, int i2) {
        StringBuilder sb;
        Component component2 = component;
        Robot robot2 = robot;
        int i3 = i;
        int i4 = i2;
        if (robot2 != null) {
            try {
                Point locationOnScreen = component2.getLocationOnScreen();
                robot2.mouseMove(i3 + locationOnScreen.x, locationOnScreen.y + transformY(component2, i4));
            } catch (IllegalComponentStateException e) {
                IllegalComponentStateException illegalComponentStateException = e;
                StringBuilder sb2 = sb;
                StringBuilder sb3 = new StringBuilder();
                LWJGLUtil.log(sb2.append("Failed to set cursor position: ").append(illegalComponentStateException).toString());
            }
        }
    }

    private static int transformY(Component component, int i) {
        return (-1 + component.getHeight()) - i;
    }
}

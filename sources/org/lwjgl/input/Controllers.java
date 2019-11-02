package org.lwjgl.input;

import java.util.ArrayList;
import java.util.Iterator;
import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;
import org.lwjgl.LWJGLException;

public class Controllers {
    private static int controllerCount;
    private static ArrayList<JInputController> controllers;
    private static boolean created;
    private static ControllerEvent event;
    private static ArrayList<ControllerEvent> events;

    static {
        ArrayList<JInputController> arrayList;
        ArrayList<ControllerEvent> arrayList2;
        ArrayList<JInputController> arrayList3 = arrayList;
        ArrayList<JInputController> arrayList4 = new ArrayList<>();
        controllers = arrayList3;
        ArrayList<ControllerEvent> arrayList5 = arrayList2;
        ArrayList<ControllerEvent> arrayList6 = new ArrayList<>();
        events = arrayList5;
    }

    public Controllers() {
    }

    static void addEvent(ControllerEvent controllerEvent) {
        ControllerEvent controllerEvent2 = controllerEvent;
        if (controllerEvent2 != null) {
            boolean add = events.add(controllerEvent2);
        }
    }

    public static void clearEvents() {
        events.clear();
    }

    public static void create() throws LWJGLException {
        LWJGLException lWJGLException;
        ArrayList arrayList;
        if (!created) {
            try {
                Controller[] controllers2 = ControllerEnvironment.getDefaultEnvironment().getControllers();
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = arrayList2;
                int length = controllers2.length;
                for (int i = 0; i < length; i++) {
                    Controller controller = controllers2[i];
                    if (!controller.getType().equals(Type.KEYBOARD) && !controller.getType().equals(Type.MOUSE)) {
                        boolean add = arrayList4.add(controller);
                    }
                }
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    createController((Controller) it.next());
                }
                created = true;
            } catch (Throwable th) {
                Throwable th2 = th;
                LWJGLException lWJGLException2 = lWJGLException;
                LWJGLException lWJGLException3 = new LWJGLException("Failed to initialise controllers", th2);
                throw lWJGLException2;
            }
        }
    }

    private static void createController(Controller controller) {
        JInputController jInputController;
        Controller controller2 = controller;
        Controller[] controllers2 = controller2.getControllers();
        if (controllers2.length == 0) {
            JInputController jInputController2 = jInputController;
            JInputController jInputController3 = new JInputController(controllerCount, controller2);
            boolean add = controllers.add(jInputController2);
            controllerCount = 1 + controllerCount;
            return;
        }
        int length = controllers2.length;
        for (int i = 0; i < length; i++) {
            createController(controllers2[i]);
        }
    }

    public static void destroy() {
    }

    public static Controller getController(int i) {
        return (Controller) controllers.get(i);
    }

    public static int getControllerCount() {
        return controllers.size();
    }

    public static int getEventControlIndex() {
        return event.getControlIndex();
    }

    public static long getEventNanoseconds() {
        return event.getTimeStamp();
    }

    public static Controller getEventSource() {
        return event.getSource();
    }

    public static boolean isCreated() {
        return created;
    }

    public static boolean isEventAxis() {
        return event.isAxis();
    }

    public static boolean isEventButton() {
        return event.isButton();
    }

    public static boolean isEventPovX() {
        return event.isPovX();
    }

    public static boolean isEventPovY() {
        return event.isPovY();
    }

    public static boolean isEventXAxis() {
        return event.isXAxis();
    }

    public static boolean isEventYAxis() {
        return event.isYAxis();
    }

    public static boolean next() {
        if (events.size() == 0) {
            event = null;
            return false;
        }
        event = (ControllerEvent) events.remove(0);
        return event != null;
    }

    public static void poll() {
        for (int i = 0; i < controllers.size(); i++) {
            getController(i).poll();
        }
    }
}

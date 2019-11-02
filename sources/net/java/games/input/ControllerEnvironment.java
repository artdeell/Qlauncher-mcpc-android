package net.java.games.input;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ControllerEnvironment {
    static final boolean $assertionsDisabled;
    static Class class$net$java$games$input$ControllerEnvironment;
    private static ControllerEnvironment defaultEnvironment;
    protected final ArrayList controllerListeners;

    static {
        Class cls;
        DefaultControllerEnvironment defaultControllerEnvironment;
        if (class$net$java$games$input$ControllerEnvironment == null) {
            cls = class$("net.java.games.input.ControllerEnvironment");
            class$net$java$games$input$ControllerEnvironment = cls;
        } else {
            cls = class$net$java$games$input$ControllerEnvironment;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
        DefaultControllerEnvironment defaultControllerEnvironment2 = defaultControllerEnvironment;
        DefaultControllerEnvironment defaultControllerEnvironment3 = new DefaultControllerEnvironment();
        defaultEnvironment = defaultControllerEnvironment2;
    }

    protected ControllerEnvironment() {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.controllerListeners = arrayList2;
    }

    static Class class$(String str) {
        NoClassDefFoundError noClassDefFoundError;
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            NoClassDefFoundError noClassDefFoundError2 = noClassDefFoundError;
            NoClassDefFoundError noClassDefFoundError3 = new NoClassDefFoundError();
            throw noClassDefFoundError2.initCause(classNotFoundException);
        }
    }

    public static ControllerEnvironment getDefaultEnvironment() {
        return defaultEnvironment;
    }

    static void log(String str) {
        System.out.print(str);
    }

    static void logln(String str) {
        StringBuffer stringBuffer;
        String str2 = str;
        StringBuffer stringBuffer2 = stringBuffer;
        StringBuffer stringBuffer3 = new StringBuffer();
        log(stringBuffer2.append(str2).append("\n").toString());
    }

    public void addControllerListener(ControllerListener controllerListener) {
        AssertionError assertionError;
        ControllerListener controllerListener2 = controllerListener;
        if ($assertionsDisabled || controllerListener2 != null) {
            boolean add = this.controllerListeners.add(controllerListener2);
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }

    /* access modifiers changed from: protected */
    public void fireControllerAdded(Controller controller) {
        ControllerEvent controllerEvent;
        ControllerEvent controllerEvent2 = controllerEvent;
        ControllerEvent controllerEvent3 = new ControllerEvent(controller);
        ControllerEvent controllerEvent4 = controllerEvent2;
        Iterator it = this.controllerListeners.iterator();
        while (it.hasNext()) {
            ((ControllerListener) it.next()).controllerAdded(controllerEvent4);
        }
    }

    /* access modifiers changed from: protected */
    public void fireControllerRemoved(Controller controller) {
        ControllerEvent controllerEvent;
        ControllerEvent controllerEvent2 = controllerEvent;
        ControllerEvent controllerEvent3 = new ControllerEvent(controller);
        ControllerEvent controllerEvent4 = controllerEvent2;
        Iterator it = this.controllerListeners.iterator();
        while (it.hasNext()) {
            ((ControllerListener) it.next()).controllerRemoved(controllerEvent4);
        }
    }

    public abstract Controller[] getControllers();

    public abstract boolean isSupported();

    public void removeControllerListener(ControllerListener controllerListener) {
        AssertionError assertionError;
        ControllerListener controllerListener2 = controllerListener;
        if ($assertionsDisabled || controllerListener2 != null) {
            boolean remove = this.controllerListeners.remove(controllerListener2);
            return;
        }
        AssertionError assertionError2 = assertionError;
        AssertionError assertionError3 = new AssertionError();
        throw assertionError2;
    }
}

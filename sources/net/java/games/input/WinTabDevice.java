package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.java.games.input.Controller.Type;

public class WinTabDevice extends AbstractController {
    private WinTabContext context;
    private List eventList;

    private WinTabDevice(WinTabContext winTabContext, int i, String str, Component[] componentArr) {
        ArrayList arrayList;
        WinTabContext winTabContext2 = winTabContext;
        int i2 = i;
        super(str, componentArr, new Controller[0], new Rumbler[0]);
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        this.eventList = arrayList2;
        this.context = winTabContext2;
    }

    public static WinTabDevice createDevice(WinTabContext winTabContext, int i) {
        StringBuffer stringBuffer;
        ArrayList arrayList;
        StringBuffer stringBuffer2;
        StringBuffer stringBuffer3;
        StringBuffer stringBuffer4;
        StringBuffer stringBuffer5;
        StringBuffer stringBuffer6;
        StringBuffer stringBuffer7;
        StringBuffer stringBuffer8;
        WinTabDevice winTabDevice;
        StringBuffer stringBuffer9;
        WinTabContext winTabContext2 = winTabContext;
        int i2 = i;
        String nGetName = nGetName(i2);
        StringBuffer stringBuffer10 = stringBuffer;
        StringBuffer stringBuffer11 = new StringBuffer();
        WinTabEnvironmentPlugin.logln(stringBuffer10.append("Device ").append(i2).append(", name: ").append(nGetName).toString());
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = arrayList2;
        int[] nGetAxisDetails = nGetAxisDetails(i2, 1);
        if (nGetAxisDetails.length == 0) {
            WinTabEnvironmentPlugin.logln("ZAxis not supported");
        } else {
            StringBuffer stringBuffer12 = stringBuffer2;
            StringBuffer stringBuffer13 = new StringBuffer();
            WinTabEnvironmentPlugin.logln(stringBuffer12.append("Xmin: ").append(nGetAxisDetails[0]).append(", Xmax: ").append(nGetAxisDetails[1]).toString());
            boolean addAll = arrayList4.addAll(WinTabComponent.createComponents(winTabContext2, i2, 1, nGetAxisDetails));
        }
        int[] nGetAxisDetails2 = nGetAxisDetails(i2, 2);
        if (nGetAxisDetails2.length == 0) {
            WinTabEnvironmentPlugin.logln("YAxis not supported");
        } else {
            StringBuffer stringBuffer14 = stringBuffer3;
            StringBuffer stringBuffer15 = new StringBuffer();
            WinTabEnvironmentPlugin.logln(stringBuffer14.append("Ymin: ").append(nGetAxisDetails2[0]).append(", Ymax: ").append(nGetAxisDetails2[1]).toString());
            boolean addAll2 = arrayList4.addAll(WinTabComponent.createComponents(winTabContext2, i2, 2, nGetAxisDetails2));
        }
        int[] nGetAxisDetails3 = nGetAxisDetails(i2, 3);
        if (nGetAxisDetails3.length == 0) {
            WinTabEnvironmentPlugin.logln("ZAxis not supported");
        } else {
            StringBuffer stringBuffer16 = stringBuffer4;
            StringBuffer stringBuffer17 = new StringBuffer();
            WinTabEnvironmentPlugin.logln(stringBuffer16.append("Zmin: ").append(nGetAxisDetails3[0]).append(", Zmax: ").append(nGetAxisDetails3[1]).toString());
            boolean addAll3 = arrayList4.addAll(WinTabComponent.createComponents(winTabContext2, i2, 3, nGetAxisDetails3));
        }
        int[] nGetAxisDetails4 = nGetAxisDetails(i2, 4);
        if (nGetAxisDetails4.length == 0) {
            WinTabEnvironmentPlugin.logln("NPressureAxis not supported");
        } else {
            StringBuffer stringBuffer18 = stringBuffer5;
            StringBuffer stringBuffer19 = new StringBuffer();
            WinTabEnvironmentPlugin.logln(stringBuffer18.append("NPressMin: ").append(nGetAxisDetails4[0]).append(", NPressMax: ").append(nGetAxisDetails4[1]).toString());
            boolean addAll4 = arrayList4.addAll(WinTabComponent.createComponents(winTabContext2, i2, 4, nGetAxisDetails4));
        }
        int[] nGetAxisDetails5 = nGetAxisDetails(i2, 5);
        if (nGetAxisDetails5.length == 0) {
            WinTabEnvironmentPlugin.logln("TPressureAxis not supported");
        } else {
            StringBuffer stringBuffer20 = stringBuffer6;
            StringBuffer stringBuffer21 = new StringBuffer();
            WinTabEnvironmentPlugin.logln(stringBuffer20.append("TPressureAxismin: ").append(nGetAxisDetails5[0]).append(", TPressureAxismax: ").append(nGetAxisDetails5[1]).toString());
            boolean addAll5 = arrayList4.addAll(WinTabComponent.createComponents(winTabContext2, i2, 5, nGetAxisDetails5));
        }
        int[] nGetAxisDetails6 = nGetAxisDetails(i2, 6);
        if (nGetAxisDetails6.length == 0) {
            WinTabEnvironmentPlugin.logln("OrientationAxis not supported");
        } else {
            StringBuffer stringBuffer22 = stringBuffer7;
            StringBuffer stringBuffer23 = new StringBuffer();
            WinTabEnvironmentPlugin.logln(stringBuffer22.append("OrientationAxis mins/maxs: ").append(nGetAxisDetails6[0]).append(",").append(nGetAxisDetails6[1]).append(", ").append(nGetAxisDetails6[2]).append(",").append(nGetAxisDetails6[3]).append(", ").append(nGetAxisDetails6[4]).append(",").append(nGetAxisDetails6[5]).toString());
            boolean addAll6 = arrayList4.addAll(WinTabComponent.createComponents(winTabContext2, i2, 6, nGetAxisDetails6));
        }
        int[] nGetAxisDetails7 = nGetAxisDetails(i2, 7);
        if (nGetAxisDetails7.length == 0) {
            WinTabEnvironmentPlugin.logln("RotationAxis not supported");
        } else {
            WinTabEnvironmentPlugin.logln("RotationAxis is supported (by the device, not by this plugin)");
            boolean addAll7 = arrayList4.addAll(WinTabComponent.createComponents(winTabContext2, i2, 7, nGetAxisDetails7));
        }
        String[] nGetCursorNames = nGetCursorNames(i2);
        boolean addAll8 = arrayList4.addAll(WinTabComponent.createCursors(winTabContext2, i2, nGetCursorNames));
        for (int i3 = 0; i3 < nGetCursorNames.length; i3++) {
            StringBuffer stringBuffer24 = stringBuffer9;
            StringBuffer stringBuffer25 = new StringBuffer();
            WinTabEnvironmentPlugin.logln(stringBuffer24.append("Cursor ").append(i3).append("'s name: ").append(nGetCursorNames[i3]).toString());
        }
        int nGetMaxButtonCount = nGetMaxButtonCount(i2);
        StringBuffer stringBuffer26 = stringBuffer8;
        StringBuffer stringBuffer27 = new StringBuffer();
        WinTabEnvironmentPlugin.logln(stringBuffer26.append("Device has ").append(nGetMaxButtonCount).append(" buttons").toString());
        boolean addAll9 = arrayList4.addAll(WinTabComponent.createButtons(winTabContext2, i2, nGetMaxButtonCount));
        WinTabDevice winTabDevice2 = winTabDevice;
        WinTabDevice winTabDevice3 = new WinTabDevice(winTabContext2, i2, nGetName, (Component[]) arrayList4.toArray(new Component[0]));
        return winTabDevice2;
    }

    private static final native int[] nGetAxisDetails(int i, int i2);

    private static final native String[] nGetCursorNames(int i);

    private static final native int nGetMaxButtonCount(int i);

    private static final native String nGetName(int i);

    /* access modifiers changed from: protected */
    public boolean getNextDeviceEvent(Event event) throws IOException {
        Event event2 = event;
        boolean z = false;
        if (this.eventList.size() > 0) {
            event2.set((Event) this.eventList.remove(0));
            z = true;
        }
        return z;
    }

    public Type getType() {
        return Type.TRACKPAD;
    }

    /* access modifiers changed from: protected */
    public void pollDevice() throws IOException {
        this.context.processEvents();
        super.pollDevice();
    }

    public void processPacket(WinTabPacket winTabPacket) {
        WinTabPacket winTabPacket2 = winTabPacket;
        Component[] components = getComponents();
        for (int i = 0; i < components.length; i++) {
            Event processPacket = ((WinTabComponent) components[i]).processPacket(winTabPacket2);
            if (processPacket != null) {
                boolean add = this.eventList.add(processPacket);
            }
        }
    }
}

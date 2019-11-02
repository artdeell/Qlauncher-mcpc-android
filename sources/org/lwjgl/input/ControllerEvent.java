package org.lwjgl.input;

class ControllerEvent {
    public static final int AXIS = 2;
    public static final int BUTTON = 1;
    public static final int POVX = 3;
    public static final int POVY = 4;
    private int index;
    private Controller source;
    private long timeStamp;
    private int type;
    private boolean xaxis;
    private boolean yaxis;

    ControllerEvent(Controller controller, long j, int i, int i2, boolean z, boolean z2) {
        long j2 = j;
        int i3 = i;
        int i4 = i2;
        boolean z3 = z;
        boolean z4 = z2;
        this.source = controller;
        this.timeStamp = j2;
        this.type = i3;
        this.index = i4;
        this.xaxis = z3;
        this.yaxis = z4;
    }

    public int getControlIndex() {
        return this.index;
    }

    public Controller getSource() {
        return this.source;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isAxis() {
        return this.type == 2;
    }

    public boolean isButton() {
        return this.type == 1;
    }

    public boolean isPovX() {
        return this.type == 3;
    }

    public boolean isPovY() {
        return this.type == 4;
    }

    public boolean isXAxis() {
        return this.xaxis;
    }

    public boolean isYAxis() {
        return this.yaxis;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append("[").append(this.source).append(" type=").append(this.type).append(" xaxis=").append(this.xaxis).append(" yaxis=").append(this.yaxis).append("]").toString();
    }
}

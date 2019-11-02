package net.java.games.input;

import net.java.games.input.Component.Identifier.Axis;

public class LinuxJoystickPOV extends LinuxJoystickAxis {
    private LinuxJoystickAxis hatX;
    private LinuxJoystickAxis hatY;

    LinuxJoystickPOV(Axis axis, LinuxJoystickAxis linuxJoystickAxis, LinuxJoystickAxis linuxJoystickAxis2) {
        LinuxJoystickAxis linuxJoystickAxis3 = linuxJoystickAxis;
        LinuxJoystickAxis linuxJoystickAxis4 = linuxJoystickAxis2;
        super(axis, false);
        this.hatX = linuxJoystickAxis3;
        this.hatY = linuxJoystickAxis4;
    }

    /* access modifiers changed from: protected */
    public LinuxJoystickAxis getXAxis() {
        return this.hatX;
    }

    /* access modifiers changed from: protected */
    public LinuxJoystickAxis getYAxis() {
        return this.hatY;
    }

    /* access modifiers changed from: protected */
    public void updateValue() {
        StringBuffer stringBuffer;
        float pollData = this.hatX.getPollData();
        float pollData2 = this.hatY.getPollData();
        resetHasPolled();
        if (pollData == -1.0f && pollData2 == -1.0f) {
            setValue(0.125f);
        } else if (pollData == -1.0f && pollData2 == 0.0f) {
            setValue(1.0f);
        } else if (pollData == -1.0f && pollData2 == 1.0f) {
            setValue(0.875f);
        } else if (pollData == 0.0f && pollData2 == -1.0f) {
            setValue(0.25f);
        } else if (pollData == 0.0f && pollData2 == 0.0f) {
            setValue(0.0f);
        } else if (pollData == 0.0f && pollData2 == 1.0f) {
            setValue(0.75f);
        } else if (pollData == 1.0f && pollData2 == -1.0f) {
            setValue(0.375f);
        } else if (pollData == 1.0f && pollData2 == 0.0f) {
            setValue(0.5f);
        } else if (pollData == 1.0f && pollData2 == 1.0f) {
            setValue(0.625f);
        } else {
            StringBuffer stringBuffer2 = stringBuffer;
            StringBuffer stringBuffer3 = new StringBuffer();
            LinuxEnvironmentPlugin.logln(stringBuffer2.append("Unknown values x = ").append(pollData).append(" | y = ").append(pollData2).toString());
            setValue(0.0f);
        }
    }
}

package org.lwjgl.util.input;

import org.lwjgl.input.Controller;

public class ControllerAdapter implements Controller {
    public ControllerAdapter() {
    }

    public int getAxisCount() {
        return 0;
    }

    public String getAxisName(int i) {
        int i2 = i;
        return "axis n/a";
    }

    public float getAxisValue(int i) {
        int i2 = i;
        return 0.0f;
    }

    public int getButtonCount() {
        return 0;
    }

    public String getButtonName(int i) {
        int i2 = i;
        return "button n/a";
    }

    public float getDeadZone(int i) {
        int i2 = i;
        return 0.0f;
    }

    public int getIndex() {
        return 0;
    }

    public String getName() {
        return "Dummy Controller";
    }

    public float getPovX() {
        return 0.0f;
    }

    public float getPovY() {
        return 0.0f;
    }

    public float getRXAxisDeadZone() {
        return 0.0f;
    }

    public float getRXAxisValue() {
        return 0.0f;
    }

    public float getRYAxisDeadZone() {
        return 0.0f;
    }

    public float getRYAxisValue() {
        return 0.0f;
    }

    public float getRZAxisDeadZone() {
        return 0.0f;
    }

    public float getRZAxisValue() {
        return 0.0f;
    }

    public int getRumblerCount() {
        return 0;
    }

    public String getRumblerName(int i) {
        int i2 = i;
        return "rumber n/a";
    }

    public float getXAxisDeadZone() {
        return 0.0f;
    }

    public float getXAxisValue() {
        return 0.0f;
    }

    public float getYAxisDeadZone() {
        return 0.0f;
    }

    public float getYAxisValue() {
        return 0.0f;
    }

    public float getZAxisDeadZone() {
        return 0.0f;
    }

    public float getZAxisValue() {
        return 0.0f;
    }

    public boolean isButtonPressed(int i) {
        int i2 = i;
        return false;
    }

    public void poll() {
    }

    public void setDeadZone(int i, float f) {
    }

    public void setRXAxisDeadZone(float f) {
    }

    public void setRYAxisDeadZone(float f) {
    }

    public void setRZAxisDeadZone(float f) {
    }

    public void setRumblerStrength(int i, float f) {
    }

    public void setXAxisDeadZone(float f) {
    }

    public void setYAxisDeadZone(float f) {
    }

    public void setZAxisDeadZone(float f) {
    }
}

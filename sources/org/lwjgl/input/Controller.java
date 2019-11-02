package org.lwjgl.input;

public interface Controller {
    int getAxisCount();

    String getAxisName(int i);

    float getAxisValue(int i);

    int getButtonCount();

    String getButtonName(int i);

    float getDeadZone(int i);

    int getIndex();

    String getName();

    float getPovX();

    float getPovY();

    float getRXAxisDeadZone();

    float getRXAxisValue();

    float getRYAxisDeadZone();

    float getRYAxisValue();

    float getRZAxisDeadZone();

    float getRZAxisValue();

    int getRumblerCount();

    String getRumblerName(int i);

    float getXAxisDeadZone();

    float getXAxisValue();

    float getYAxisDeadZone();

    float getYAxisValue();

    float getZAxisDeadZone();

    float getZAxisValue();

    boolean isButtonPressed(int i);

    void poll();

    void setDeadZone(int i, float f);

    void setRXAxisDeadZone(float f);

    void setRYAxisDeadZone(float f);

    void setRZAxisDeadZone(float f);

    void setRumblerStrength(int i, float f);

    void setXAxisDeadZone(float f);

    void setYAxisDeadZone(float f);

    void setZAxisDeadZone(float f);
}

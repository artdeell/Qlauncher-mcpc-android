package org.lwjgl.util;

import java.io.Serializable;

public final class Dimension implements Serializable, ReadableDimension, WritableDimension {
    static final long serialVersionUID = 1;
    private int height;
    private int width;

    public Dimension() {
    }

    public Dimension(int i, int i2) {
        int i3 = i2;
        this.width = i;
        this.height = i3;
    }

    public Dimension(ReadableDimension readableDimension) {
        setSize(readableDimension);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        boolean z = false;
        if (obj2 instanceof ReadableDimension) {
            ReadableDimension readableDimension = (ReadableDimension) obj2;
            z = false;
            if (this.width == readableDimension.getWidth()) {
                z = false;
                if (this.height == readableDimension.getHeight()) {
                    z = true;
                }
            }
        }
        return z;
    }

    public int getHeight() {
        return this.height;
    }

    public void getSize(WritableDimension writableDimension) {
        writableDimension.setSize(this);
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i = this.width + this.height;
        return ((i * (i + 1)) / 2) + this.width;
    }

    public void setHeight(int i) {
        int i2 = i;
        this.height = i2;
    }

    public void setSize(int i, int i2) {
        int i3 = i2;
        this.width = i;
        this.height = i3;
    }

    public void setSize(ReadableDimension readableDimension) {
        ReadableDimension readableDimension2 = readableDimension;
        this.width = readableDimension2.getWidth();
        this.height = readableDimension2.getHeight();
    }

    public void setWidth(int i) {
        int i2 = i;
        this.width = i2;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getClass().getName()).append("[width=").append(this.width).append(",height=").append(this.height).append("]").toString();
    }
}

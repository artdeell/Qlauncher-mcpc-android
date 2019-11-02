package org.lwjgl.util;

import java.io.Serializable;

public final class Point implements ReadablePoint, WritablePoint, Serializable {
    static final long serialVersionUID = 1;

    /* renamed from: x */
    private int f234x;

    /* renamed from: y */
    private int f235y;

    public Point() {
    }

    public Point(int i, int i2) {
        setLocation(i, i2);
    }

    public Point(ReadablePoint readablePoint) {
        setLocation(readablePoint);
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof Point)) {
            return super.equals(obj2);
        }
        Point point = (Point) obj2;
        return this.f234x == point.f234x && this.f235y == point.f235y;
    }

    public void getLocation(WritablePoint writablePoint) {
        writablePoint.setLocation(this.f234x, this.f235y);
    }

    public int getX() {
        return this.f234x;
    }

    public int getY() {
        return this.f235y;
    }

    public int hashCode() {
        int i = this.f234x + this.f235y;
        return ((i * (i + 1)) / 2) + this.f234x;
    }

    public void setLocation(int i, int i2) {
        int i3 = i2;
        this.f234x = i;
        this.f235y = i3;
    }

    public void setLocation(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        this.f234x = readablePoint2.getX();
        this.f235y = readablePoint2.getY();
    }

    public void setX(int i) {
        int i2 = i;
        this.f234x = i2;
    }

    public void setY(int i) {
        int i2 = i;
        this.f235y = i2;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getClass().getName()).append("[x=").append(this.f234x).append(",y=").append(this.f235y).append("]").toString();
    }

    public void translate(int i, int i2) {
        int i3 = i2;
        this.f234x = i + this.f234x;
        this.f235y = i3 + this.f235y;
    }

    public void translate(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        this.f234x += readablePoint2.getX();
        this.f235y += readablePoint2.getY();
    }

    public void untranslate(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        this.f234x -= readablePoint2.getX();
        this.f235y -= readablePoint2.getY();
    }
}

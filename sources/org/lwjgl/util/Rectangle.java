package org.lwjgl.util;

import java.io.Serializable;

public final class Rectangle implements ReadableRectangle, WritableRectangle, Serializable {
    static final long serialVersionUID = 1;
    private int height;
    private int width;

    /* renamed from: x */
    private int f236x;

    /* renamed from: y */
    private int f237y;

    public Rectangle() {
    }

    public Rectangle(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.f236x = i;
        this.f237y = i5;
        this.width = i6;
        this.height = i7;
    }

    public Rectangle(ReadablePoint readablePoint, ReadableDimension readableDimension) {
        ReadablePoint readablePoint2 = readablePoint;
        ReadableDimension readableDimension2 = readableDimension;
        this.f236x = readablePoint2.getX();
        this.f237y = readablePoint2.getY();
        this.width = readableDimension2.getWidth();
        this.height = readableDimension2.getHeight();
    }

    public Rectangle(ReadableRectangle readableRectangle) {
        ReadableRectangle readableRectangle2 = readableRectangle;
        this.f236x = readableRectangle2.getX();
        this.f237y = readableRectangle2.getY();
        this.width = readableRectangle2.getWidth();
        this.height = readableRectangle2.getHeight();
    }

    public void add(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int min = Math.min(this.f236x, i3);
        int max = Math.max(this.f236x + this.width, i3);
        int min2 = Math.min(this.f237y, i4);
        int max2 = Math.max(this.f237y + this.height, i4);
        this.f236x = min;
        this.f237y = min2;
        this.width = max - min;
        this.height = max2 - min2;
    }

    public void add(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        add(readablePoint2.getX(), readablePoint2.getY());
    }

    public void add(ReadableRectangle readableRectangle) {
        ReadableRectangle readableRectangle2 = readableRectangle;
        int min = Math.min(this.f236x, readableRectangle2.getX());
        int max = Math.max(this.f236x + this.width, readableRectangle2.getX() + readableRectangle2.getWidth());
        int min2 = Math.min(this.f237y, readableRectangle2.getY());
        int max2 = Math.max(this.f237y + this.height, readableRectangle2.getY() + readableRectangle2.getHeight());
        this.f236x = min;
        this.f237y = min2;
        this.width = max - min;
        this.height = max2 - min2;
    }

    public boolean contains(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = this.width;
        int i6 = this.height;
        if ((i5 | i6) >= 0) {
            int i7 = this.f236x;
            int i8 = this.f237y;
            if (i3 >= i7 && i4 >= i8) {
                int i9 = i5 + i7;
                int i10 = i6 + i8;
                if ((i9 < i7 || i9 > i3) && (i10 < i8 || i10 > i4)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        if (r10 <= r9) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r12 <= r11) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean contains(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r13 = r0
            int r13 = r13.width
            r5 = r13
            r13 = r0
            int r13 = r13.height
            r6 = r13
            r13 = r4
            r14 = r3
            r15 = r5
            r16 = r6
            r15 = r15 | r16
            r14 = r14 | r15
            r13 = r13 | r14
            if (r13 >= 0) goto L_0x0020
        L_0x001d:
            r13 = 0
            r0 = r13
        L_0x001f:
            return r0
        L_0x0020:
            r13 = r0
            int r13 = r13.f236x
            r7 = r13
            r13 = r0
            int r13 = r13.f237y
            r8 = r13
            r13 = r1
            r14 = r7
            if (r13 < r14) goto L_0x001d
            r13 = r2
            r14 = r8
            if (r13 < r14) goto L_0x001d
            r13 = r5
            r14 = r7
            int r13 = r13 + r14
            r9 = r13
            r13 = r3
            r14 = r1
            int r13 = r13 + r14
            r10 = r13
            r13 = r10
            r14 = r1
            if (r13 > r14) goto L_0x005b
            r13 = r9
            r14 = r7
            if (r13 >= r14) goto L_0x001d
            r13 = r10
            r14 = r9
            if (r13 > r14) goto L_0x001d
        L_0x0044:
            r13 = r6
            r14 = r8
            int r13 = r13 + r14
            r11 = r13
            r13 = r4
            r14 = r2
            int r13 = r13 + r14
            r12 = r13
            r13 = r12
            r14 = r2
            if (r13 > r14) goto L_0x0066
            r13 = r11
            r14 = r8
            if (r13 >= r14) goto L_0x001d
            r13 = r12
            r14 = r11
            if (r13 > r14) goto L_0x001d
        L_0x0058:
            r13 = 1
            r0 = r13
            goto L_0x001f
        L_0x005b:
            r13 = r9
            r14 = r7
            if (r13 < r14) goto L_0x0044
            r13 = r10
            r14 = r9
            if (r13 <= r14) goto L_0x0044
            r13 = 0
            r0 = r13
            goto L_0x001f
        L_0x0066:
            r13 = r11
            r14 = r8
            if (r13 < r14) goto L_0x0058
            r13 = r12
            r14 = r11
            if (r13 <= r14) goto L_0x0058
            r13 = 0
            r0 = r13
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.lwjgl.util.Rectangle.contains(int, int, int, int):boolean");
    }

    public boolean contains(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        return contains(readablePoint2.getX(), readablePoint2.getY());
    }

    public boolean contains(ReadableRectangle readableRectangle) {
        ReadableRectangle readableRectangle2 = readableRectangle;
        return contains(readableRectangle2.getX(), readableRectangle2.getY(), readableRectangle2.getWidth(), readableRectangle2.getHeight());
    }

    public boolean equals(Object obj) {
        Object obj2 = obj;
        if (!(obj2 instanceof Rectangle)) {
            return super.equals(obj2);
        }
        Rectangle rectangle = (Rectangle) obj2;
        return this.f236x == rectangle.f236x && this.f237y == rectangle.f237y && this.width == rectangle.width && this.height == rectangle.height;
    }

    public void getBounds(WritableRectangle writableRectangle) {
        writableRectangle.setBounds(this.f236x, this.f237y, this.width, this.height);
    }

    public int getHeight() {
        return this.height;
    }

    public void getLocation(WritablePoint writablePoint) {
        writablePoint.setLocation(this.f236x, this.f237y);
    }

    public void getSize(WritableDimension writableDimension) {
        writableDimension.setSize(this.width, this.height);
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.f236x;
    }

    public int getY() {
        return this.f237y;
    }

    public void grow(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        this.f236x -= i3;
        this.f237y -= i4;
        this.width += i3 * 2;
        this.height += i4 * 2;
    }

    public Rectangle intersection(ReadableRectangle readableRectangle, Rectangle rectangle) {
        Rectangle rectangle2;
        ReadableRectangle readableRectangle2 = readableRectangle;
        Rectangle rectangle3 = rectangle;
        int i = this.f236x;
        int i2 = this.f237y;
        int x = readableRectangle2.getX();
        int y = readableRectangle2.getY();
        long j = ((long) i) + ((long) this.width);
        long j2 = ((long) i2) + ((long) this.height);
        long width2 = ((long) x) + ((long) readableRectangle2.getWidth());
        long height2 = ((long) y) + ((long) readableRectangle2.getHeight());
        if (i < x) {
            i = x;
        }
        if (i2 < y) {
            i2 = y;
        }
        if (j > width2) {
            j = width2;
        }
        if (j2 > height2) {
            j2 = height2;
        }
        long j3 = j - ((long) i);
        long j4 = j2 - ((long) i2);
        if (j3 < -2147483648L) {
            j3 = -2147483648L;
        }
        if (j4 < -2147483648L) {
            j4 = -2147483648L;
        }
        if (rectangle3 == null) {
            Rectangle rectangle4 = rectangle2;
            Rectangle rectangle5 = new Rectangle(i, i2, (int) j3, (int) j4);
            return rectangle4;
        }
        rectangle3.setBounds(i, i2, (int) j3, (int) j4);
        return rectangle3;
    }

    public boolean intersects(ReadableRectangle readableRectangle) {
        ReadableRectangle readableRectangle2 = readableRectangle;
        int i = this.width;
        int i2 = this.height;
        int width2 = readableRectangle2.getWidth();
        int height2 = readableRectangle2.getHeight();
        if (width2 > 0 && height2 > 0 && i > 0 && i2 > 0) {
            int i3 = this.f236x;
            int i4 = this.f237y;
            int x = readableRectangle2.getX();
            int y = readableRectangle2.getY();
            int i5 = width2 + x;
            int i6 = height2 + y;
            int i7 = i + i3;
            int i8 = i2 + i4;
            if ((i5 < x || i5 > i3) && ((i6 < y || i6 > i4) && ((i7 < i3 || i7 > x) && (i8 < i4 || i8 > y)))) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.width <= 0 || this.height <= 0;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        this.f236x = i;
        this.f237y = i5;
        this.width = i6;
        this.height = i7;
    }

    public void setBounds(ReadablePoint readablePoint, ReadableDimension readableDimension) {
        ReadablePoint readablePoint2 = readablePoint;
        ReadableDimension readableDimension2 = readableDimension;
        this.f236x = readablePoint2.getX();
        this.f237y = readablePoint2.getY();
        this.width = readableDimension2.getWidth();
        this.height = readableDimension2.getHeight();
    }

    public void setBounds(ReadableRectangle readableRectangle) {
        ReadableRectangle readableRectangle2 = readableRectangle;
        this.f236x = readableRectangle2.getX();
        this.f237y = readableRectangle2.getY();
        this.width = readableRectangle2.getWidth();
        this.height = readableRectangle2.getHeight();
    }

    public void setHeight(int i) {
        int i2 = i;
        this.height = i2;
    }

    public void setLocation(int i, int i2) {
        int i3 = i2;
        this.f236x = i;
        this.f237y = i3;
    }

    public void setLocation(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        this.f236x = readablePoint2.getX();
        this.f237y = readablePoint2.getY();
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

    public void setX(int i) {
        int i2 = i;
        this.f236x = i2;
    }

    public void setY(int i) {
        int i2 = i;
        this.f237y = i2;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2 = sb;
        StringBuilder sb3 = new StringBuilder();
        return sb2.append(getClass().getName()).append("[x=").append(this.f236x).append(",y=").append(this.f237y).append(",width=").append(this.width).append(",height=").append(this.height).append("]").toString();
    }

    public void translate(int i, int i2) {
        int i3 = i2;
        this.f236x = i + this.f236x;
        this.f237y = i3 + this.f237y;
    }

    public void translate(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        this.f236x += readablePoint2.getX();
        this.f237y += readablePoint2.getY();
    }

    public WritableRectangle union(ReadableRectangle readableRectangle, WritableRectangle writableRectangle) {
        ReadableRectangle readableRectangle2 = readableRectangle;
        WritableRectangle writableRectangle2 = writableRectangle;
        int min = Math.min(this.f236x, readableRectangle2.getX());
        int max = Math.max(this.f236x + this.width, readableRectangle2.getX() + readableRectangle2.getWidth());
        int min2 = Math.min(this.f237y, readableRectangle2.getY());
        writableRectangle2.setBounds(min, min2, max - min, Math.max(this.f237y + this.height, readableRectangle2.getY() + readableRectangle2.getHeight()) - min2);
        return writableRectangle2;
    }

    public void untranslate(ReadablePoint readablePoint) {
        ReadablePoint readablePoint2 = readablePoint;
        this.f236x -= readablePoint2.getX();
        this.f237y -= readablePoint2.getY();
    }
}

package org.lwjgl.examples.spaceinvaders;

import java.awt.Rectangle;

public abstract class Entity {

    /* renamed from: dx */
    protected float f186dx;

    /* renamed from: dy */
    protected float f187dy;
    private Rectangle him;

    /* renamed from: me */
    private Rectangle f188me;
    protected Sprite sprite;

    /* renamed from: x */
    protected float f189x;

    /* renamed from: y */
    protected float f190y;

    protected Entity(Sprite sprite2, int i, int i2) {
        Rectangle rectangle;
        Rectangle rectangle2;
        Sprite sprite3 = sprite2;
        int i3 = i;
        int i4 = i2;
        Rectangle rectangle3 = rectangle;
        Rectangle rectangle4 = new Rectangle();
        this.f188me = rectangle3;
        Rectangle rectangle5 = rectangle2;
        Rectangle rectangle6 = new Rectangle();
        this.him = rectangle5;
        this.sprite = sprite3;
        this.f189x = (float) i3;
        this.f190y = (float) i4;
    }

    public abstract void collidedWith(Entity entity);

    public boolean collidesWith(Entity entity) {
        Entity entity2 = entity;
        this.f188me.setBounds((int) this.f189x, (int) this.f190y, this.sprite.getWidth(), this.sprite.getHeight());
        this.him.setBounds((int) entity2.f189x, (int) entity2.f190y, entity2.sprite.getWidth(), entity2.sprite.getHeight());
        return this.f188me.intersects(this.him);
    }

    public void doLogic() {
    }

    public void draw() {
        this.sprite.draw((int) this.f189x, (int) this.f190y);
    }

    public float getHorizontalMovement() {
        return this.f186dx;
    }

    public float getVerticalMovement() {
        return this.f187dy;
    }

    public int getX() {
        return (int) this.f189x;
    }

    public int getY() {
        return (int) this.f190y;
    }

    public void move(long j) {
        long j2 = j;
        this.f189x += (((float) j2) * this.f186dx) / 1000.0f;
        this.f190y += (((float) j2) * this.f187dy) / 1000.0f;
    }

    public void setHorizontalMovement(float f) {
        float f2 = f;
        this.f186dx = f2;
    }

    public void setVerticalMovement(float f) {
        float f2 = f;
        this.f187dy = f2;
    }
}

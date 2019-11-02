package org.lwjgl.examples.spaceinvaders;

public class ShotEntity extends Entity {
    private static final int TOP_BORDER = -100;
    private Game game;
    private float moveSpeed = -300.0f;
    private boolean used;

    public ShotEntity(Game game2, String str, int i, int i2) {
        Game game3 = game2;
        super(game3.getSprite(str), i, i2);
        this.game = game3;
        this.f187dy = this.moveSpeed;
    }

    public void collidedWith(Entity entity) {
        Entity entity2 = entity;
        if (!this.used && (entity2 instanceof AlienEntity)) {
            this.game.removeEntity(this);
            this.game.removeEntity(entity2);
            this.game.notifyAlienKilled();
            this.used = true;
        }
    }

    public void move(long j) {
        super.move(j);
        if (this.f190y < -100.0f) {
            this.game.removeEntity(this);
        }
    }

    public void reinitialize(int i, int i2) {
        int i3 = i2;
        this.f189x = (float) i;
        this.f190y = (float) i3;
        this.used = false;
    }
}

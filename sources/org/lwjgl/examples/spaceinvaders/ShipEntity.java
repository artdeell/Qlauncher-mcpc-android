package org.lwjgl.examples.spaceinvaders;

public class ShipEntity extends Entity {
    private static final int LEFT_BORDER = 10;
    private static final int RIGHT_BORDER = 750;
    private Game game;

    public ShipEntity(Game game2, String str, int i, int i2) {
        Game game3 = game2;
        super(game3.getSprite(str), i, i2);
        this.game = game3;
    }

    public void collidedWith(Entity entity) {
        if (entity instanceof AlienEntity) {
            this.game.notifyDeath();
        }
    }

    public void move(long j) {
        long j2 = j;
        if (this.f186dx < 0.0f && this.f189x < 10.0f) {
            return;
        }
        if (this.f186dx <= 0.0f || this.f189x <= 750.0f) {
            super.move(j2);
        }
    }
}

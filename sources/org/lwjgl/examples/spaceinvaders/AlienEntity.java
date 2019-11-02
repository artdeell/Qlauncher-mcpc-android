package org.lwjgl.examples.spaceinvaders;

public class AlienEntity extends Entity {
    private static final int BOTTOM_BORDER = 570;
    private static final int DOWNWARD_MOVEMENT = 10;
    private static final int LEFT_BORDER = 10;
    private static final int RIGHT_BORDER = 750;
    private long frameDuration = 250;
    private int frameNumber;
    private Sprite[] frames = new Sprite[4];
    private Game game;
    private long lastFrameChange;
    private float moveSpeed = 75.0f;

    public AlienEntity(Game game2, int i, int i2) {
        Game game3 = game2;
        super(game3.getSprite("alien.gif"), i, i2);
        this.frames[0] = this.sprite;
        this.frames[1] = game3.getSprite("alien2.gif");
        this.frames[2] = this.sprite;
        this.frames[3] = game3.getSprite("alien3.gif");
        this.game = game3;
        this.f186dx = -this.moveSpeed;
    }

    public void collidedWith(Entity entity) {
    }

    public void doLogic() {
        this.f186dx = -this.f186dx;
        this.f190y = 10.0f + this.f190y;
        if (this.f190y > 570.0f) {
            this.game.notifyDeath();
        }
    }

    public void move(long j) {
        long j2 = j;
        this.lastFrameChange = j2 + this.lastFrameChange;
        if (this.lastFrameChange > this.frameDuration) {
            this.lastFrameChange = 0;
            this.frameNumber = 1 + this.frameNumber;
            if (this.frameNumber >= this.frames.length) {
                this.frameNumber = 0;
            }
            this.sprite = this.frames[this.frameNumber];
        }
        if (this.f186dx < 0.0f && this.f189x < 10.0f) {
            this.game.updateLogic();
        }
        if (this.f186dx > 0.0f && this.f189x > 750.0f) {
            this.game.updateLogic();
        }
        super.move(j2);
    }
}

package org.lwjgl.examples.spaceinvaders;

import java.util.ArrayList;
import java.util.Iterator;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Game {
    public static boolean gameRunning = true;
    private static boolean isApplication;
    private static long timerTicksPerSecond = Sys.getTimerResolution();
    private int SOUND_HIT;
    private int SOUND_LOOSE;
    private int SOUND_SHOT;
    private int SOUND_START;
    private int SOUND_WIN;
    private String WINDOW_TITLE = "Space Invaders 104 (for LWJGL)";
    private int alienCount;
    private ArrayList<Entity> entities;
    private boolean fireHasBeenReleased;
    private long firingInterval;
    private int fps;
    private boolean fullscreen;
    private Sprite gotYou;
    private int height = 600;
    private long lastFire;
    private long lastFpsTime;
    private long lastLoopTime;
    private boolean logicRequiredThisLoop;
    private Sprite message;
    private int mouseX;
    private float moveSpeed;
    private Sprite pressAnyKey;
    private ArrayList<Entity> removeList;
    private ShipEntity ship;
    private int shotIndex;
    private ShotEntity[] shots;
    private SoundManager soundManager;
    private TextureLoader textureLoader;
    private boolean waitingForKeyPress;
    private int width = 800;
    private Sprite youWin;

    public Game(boolean z) {
        ArrayList<Entity> arrayList;
        ArrayList<Entity> arrayList2;
        boolean z2 = z;
        ArrayList<Entity> arrayList3 = arrayList;
        ArrayList<Entity> arrayList4 = new ArrayList<>();
        this.entities = arrayList3;
        ArrayList<Entity> arrayList5 = arrayList2;
        ArrayList<Entity> arrayList6 = new ArrayList<>();
        this.removeList = arrayList5;
        this.moveSpeed = 300.0f;
        this.firingInterval = 500;
        this.waitingForKeyPress = true;
        this.lastLoopTime = getTime();
        this.fullscreen = z2;
        initialize();
    }

    private void gameLoop() {
        while (gameRunning) {
            GL11.glClear(16640);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            frameRendering();
            Display.update();
        }
        this.soundManager.destroy();
        Display.destroy();
    }

    public static long getTime() {
        return (1000 * Sys.getTime()) / timerTicksPerSecond;
    }

    private boolean hasInput(int i) {
        switch (i) {
            case 57:
                if (Keyboard.isKeyDown(57) || Mouse.isButtonDown(0)) {
                    return true;
                }
            case 203:
                if (Keyboard.isKeyDown(203) || this.mouseX < 0) {
                    return true;
                }
            case 205:
                if (Keyboard.isKeyDown(205) || this.mouseX > 0) {
                    return true;
                }
        }
        return false;
    }

    private void initEntities() {
        ShipEntity shipEntity;
        AlienEntity alienEntity;
        ShipEntity shipEntity2 = shipEntity;
        ShipEntity shipEntity3 = new ShipEntity(this, "ship.gif", NativeDefinitions.KEY_SUBTITLE, 550);
        this.ship = shipEntity2;
        boolean add = this.entities.add(this.ship);
        this.alienCount = 0;
        for (int i = 0; i < 5; i++) {
            for (int i2 = 0; i2 < 12; i2++) {
                AlienEntity alienEntity2 = alienEntity;
                AlienEntity alienEntity3 = new AlienEntity(this, 100 + (i2 * 50), 50 + (i * 30));
                boolean add2 = this.entities.add(alienEntity2);
                this.alienCount = 1 + this.alienCount;
            }
        }
    }

    public static void main(String[] strArr) {
        Game game;
        String[] strArr2 = strArr;
        boolean z = true;
        isApplication = true;
        System.out.println("Use -fullscreen for fullscreen mode");
        if (strArr2.length <= 0 || !"-fullscreen".equalsIgnoreCase(strArr2[0])) {
            z = false;
        }
        Game game2 = game;
        Game game3 = new Game(z);
        game2.execute();
        System.exit(0);
    }

    private boolean setDisplayMode() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        try {
            DisplayMode[] availableDisplayModes = org.lwjgl.util.Display.getAvailableDisplayModes(this.width, this.height, -1, -1, -1, -1, 60, 60);
            String[] strArr = new String[4];
            String[] strArr2 = strArr;
            StringBuilder sb4 = sb;
            StringBuilder sb5 = new StringBuilder();
            strArr2[0] = sb4.append("width=").append(this.width).toString();
            String[] strArr3 = strArr;
            StringBuilder sb6 = sb2;
            StringBuilder sb7 = new StringBuilder();
            strArr3[1] = sb6.append("height=").append(this.height).toString();
            strArr[2] = "freq=60";
            String[] strArr4 = strArr;
            StringBuilder sb8 = sb3;
            StringBuilder sb9 = new StringBuilder();
            strArr4[3] = sb8.append("bpp=").append(Display.getDisplayMode().getBitsPerPixel()).toString();
            DisplayMode displayMode = org.lwjgl.util.Display.setDisplayMode(availableDisplayModes, strArr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to enter fullscreen, continuing in windowed mode");
            return false;
        }
    }

    public static void sleep(long j) {
        try {
            Thread.sleep((j * timerTicksPerSecond) / 1000);
        } catch (InterruptedException e) {
            InterruptedException interruptedException = e;
        }
    }

    private void startGame() {
        this.entities.clear();
        initEntities();
    }

    public void execute() {
        gameLoop();
    }

    public void frameRendering() {
        StringBuilder sb;
        Display.sync(60);
        long time = getTime() - this.lastLoopTime;
        this.lastLoopTime = getTime();
        this.lastFpsTime = time + this.lastFpsTime;
        this.fps = 1 + this.fps;
        if (this.lastFpsTime >= 1000) {
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            Display.setTitle(sb2.append(this.WINDOW_TITLE).append(" (FPS: ").append(this.fps).append(")").toString());
            this.lastFpsTime = 0;
            this.fps = 0;
        }
        if (!this.waitingForKeyPress) {
            if (!this.soundManager.isPlayingSound()) {
                Iterator it = this.entities.iterator();
                while (it.hasNext()) {
                    ((Entity) it.next()).move(time);
                }
            }
        }
        Iterator it2 = this.entities.iterator();
        while (it2.hasNext()) {
            ((Entity) it2.next()).draw();
        }
        int i = 0;
        while (true) {
            if (i >= this.entities.size()) {
                break;
            }
            int i2 = i + 1;
            while (true) {
                if (i2 >= this.entities.size()) {
                    break;
                }
                Entity entity = (Entity) this.entities.get(i);
                Entity entity2 = (Entity) this.entities.get(i2);
                if (entity.collidesWith(entity2)) {
                    entity.collidedWith(entity2);
                    entity2.collidedWith(entity);
                }
                i2++;
            }
            i++;
        }
        boolean removeAll = this.entities.removeAll(this.removeList);
        this.removeList.clear();
        if (this.logicRequiredThisLoop) {
            Iterator it3 = this.entities.iterator();
            while (it3.hasNext()) {
                ((Entity) it3.next()).doLogic();
            }
            this.logicRequiredThisLoop = false;
        }
        if (this.waitingForKeyPress) {
            this.message.draw(NativeDefinitions.BTN_TOOL_FINGER, 250);
        }
        this.ship.setHorizontalMovement(0.0f);
        this.mouseX = Mouse.getDX();
        boolean hasInput = hasInput(203);
        boolean hasInput2 = hasInput(205);
        boolean hasInput3 = hasInput(57);
        if (!this.waitingForKeyPress) {
            if (!this.soundManager.isPlayingSound()) {
                if (hasInput && !hasInput2) {
                    this.ship.setHorizontalMovement(-this.moveSpeed);
                } else if (hasInput2 && !hasInput) {
                    this.ship.setHorizontalMovement(this.moveSpeed);
                }
                if (hasInput3) {
                    tryToFire();
                }
                if ((!Display.isCloseRequested() || Keyboard.isKeyDown(1)) && isApplication) {
                    gameRunning = false;
                }
                return;
            }
        }
        if (!hasInput3) {
            this.fireHasBeenReleased = true;
        }
        if (hasInput3) {
            if (this.fireHasBeenReleased) {
                if (!this.soundManager.isPlayingSound()) {
                    this.waitingForKeyPress = false;
                    this.fireHasBeenReleased = false;
                    startGame();
                    this.soundManager.playSound(this.SOUND_START);
                }
            }
        }
        if (!Display.isCloseRequested()) {
        }
        gameRunning = false;
    }

    public Sprite getSprite(String str) {
        Sprite sprite;
        String str2 = str;
        Sprite sprite2 = sprite;
        Sprite sprite3 = new Sprite(this.textureLoader, str2);
        return sprite2;
    }

    public void initialize() {
        TextureLoader textureLoader2;
        SoundManager soundManager2;
        ShotEntity shotEntity;
        try {
            boolean displayMode = setDisplayMode();
            Display.setTitle(this.WINDOW_TITLE);
            Display.setFullscreen(this.fullscreen);
            Display.create();
            if (isApplication) {
                Mouse.setGrabbed(true);
            }
            GL11.glEnable(3553);
            GL11.glDisable(GL11.GL_DEPTH_TEST);
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0d, (double) this.width, (double) this.height, 0.0d, -1.0d, 1.0d);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glViewport(0, 0, this.width, this.height);
            TextureLoader textureLoader3 = textureLoader2;
            TextureLoader textureLoader4 = new TextureLoader();
            this.textureLoader = textureLoader3;
            SoundManager soundManager3 = soundManager2;
            SoundManager soundManager4 = new SoundManager();
            this.soundManager = soundManager3;
            this.soundManager.initialize(8);
            this.SOUND_SHOT = this.soundManager.addSound("shot.wav");
            this.SOUND_HIT = this.soundManager.addSound("hit.wav");
            this.SOUND_START = this.soundManager.addSound("start.wav");
            this.SOUND_WIN = this.soundManager.addSound("win.wav");
            this.SOUND_LOOSE = this.soundManager.addSound("loose.wav");
            this.gotYou = getSprite("gotyou.gif");
            this.pressAnyKey = getSprite("pressanykey.gif");
            this.youWin = getSprite("youwin.gif");
            this.message = this.pressAnyKey;
            this.shots = new ShotEntity[5];
            for (int i = 0; i < this.shots.length; i++) {
                ShotEntity[] shotEntityArr = this.shots;
                int i2 = i;
                ShotEntity shotEntity2 = shotEntity;
                ShotEntity shotEntity3 = new ShotEntity(this, "shot.gif", 0, 0);
                shotEntityArr[i2] = shotEntity2;
            }
            startGame();
        } catch (LWJGLException e) {
            LWJGLException lWJGLException = e;
            System.out.println("Game exiting - exception in initialization:");
            lWJGLException.printStackTrace();
            gameRunning = false;
        }
    }

    public void notifyAlienKilled() {
        this.alienCount = -1 + this.alienCount;
        if (this.alienCount == 0) {
            notifyWin();
        }
        Iterator it = this.entities.iterator();
        while (it.hasNext()) {
            Entity entity = (Entity) it.next();
            if (entity instanceof AlienEntity) {
                entity.setHorizontalMovement(1.02f * entity.getHorizontalMovement());
            }
        }
        this.soundManager.playEffect(this.SOUND_HIT);
    }

    public void notifyDeath() {
        if (!this.waitingForKeyPress) {
            this.soundManager.playSound(this.SOUND_LOOSE);
        }
        this.message = this.gotYou;
        this.waitingForKeyPress = true;
    }

    public void notifyWin() {
        this.message = this.youWin;
        this.waitingForKeyPress = true;
        this.soundManager.playSound(this.SOUND_WIN);
    }

    public void removeEntity(Entity entity) {
        Entity entity2 = entity;
        boolean add = this.removeList.add(entity2);
    }

    public void tryToFire() {
        if (System.currentTimeMillis() - this.lastFire >= this.firingInterval) {
            this.lastFire = System.currentTimeMillis();
            ShotEntity[] shotEntityArr = this.shots;
            int i = this.shotIndex;
            this.shotIndex = i + 1;
            ShotEntity shotEntity = shotEntityArr[i % this.shots.length];
            shotEntity.reinitialize(10 + this.ship.getX(), -30 + this.ship.getY());
            boolean add = this.entities.add(shotEntity);
            this.soundManager.playEffect(this.SOUND_SHOT);
        }
    }

    public void updateLogic() {
        this.logicRequiredThisLoop = true;
    }
}

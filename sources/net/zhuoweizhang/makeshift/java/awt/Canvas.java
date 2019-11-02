package net.zhuoweizhang.makeshift.java.awt;

import org.lwjgl.opengl.GL11;

public class Canvas extends Component {
    public Canvas() {
    }

    public Graphics getGraphics() {
        return null;
    }

    public int getHeight() {
        return 800;
    }

    public int getWidth() {
        return GL11.GL_INVALID_ENUM;
    }

    public void setPreferredSize(Dimension dimension) {
    }
}

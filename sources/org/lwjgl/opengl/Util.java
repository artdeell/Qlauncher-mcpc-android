package org.lwjgl.opengl;

public final class Util {
    private Util() {
    }

    public static void checkGLError() throws OpenGLException {
        OpenGLException openGLException;
        int glGetError = GL11.glGetError();
        if (glGetError != 0) {
            OpenGLException openGLException2 = openGLException;
            OpenGLException openGLException3 = new OpenGLException(glGetError);
            throw openGLException2;
        }
    }

    public static String translateGLErrorString(int i) {
        switch (i) {
            case 0:
                return "No error";
            case GL11.GL_INVALID_ENUM /*1280*/:
                return "Invalid enum";
            case GL11.GL_INVALID_VALUE /*1281*/:
                return "Invalid value";
            case GL11.GL_INVALID_OPERATION /*1282*/:
                return "Invalid operation";
            case 1283:
                return "Stack overflow";
            case 1284:
                return "Stack underflow";
            case GL11.GL_OUT_OF_MEMORY /*1285*/:
                return "Out of memory";
            case 1286:
                return "Invalid framebuffer operation";
            case ARBImaging.GL_TABLE_TOO_LARGE /*32817*/:
                return "Table too large";
            default:
                return null;
        }
    }
}

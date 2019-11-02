package org.lwjgl.openal;

public final class Util {
    private Util() {
    }

    public static void checkALCError(ALCdevice aLCdevice) {
        OpenALException openALException;
        int alcGetError = ALC10.alcGetError(aLCdevice);
        if (alcGetError != 0) {
            OpenALException openALException2 = openALException;
            OpenALException openALException3 = new OpenALException(ALC10.alcGetString(C0758AL.getDevice(), alcGetError));
            throw openALException2;
        }
    }

    public static void checkALCValidContext(ALCcontext aLCcontext) {
        OpenALException openALException;
        StringBuilder sb;
        ALCcontext aLCcontext2 = aLCcontext;
        if (!aLCcontext2.isValid()) {
            OpenALException openALException2 = openALException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            OpenALException openALException3 = new OpenALException(sb2.append("Invalid context: ").append(aLCcontext2).toString());
            throw openALException2;
        }
    }

    public static void checkALCValidDevice(ALCdevice aLCdevice) {
        OpenALException openALException;
        StringBuilder sb;
        ALCdevice aLCdevice2 = aLCdevice;
        if (!aLCdevice2.isValid()) {
            OpenALException openALException2 = openALException;
            StringBuilder sb2 = sb;
            StringBuilder sb3 = new StringBuilder();
            OpenALException openALException3 = new OpenALException(sb2.append("Invalid device: ").append(aLCdevice2).toString());
            throw openALException2;
        }
    }

    public static void checkALError() {
        OpenALException openALException;
        int alGetError = AL10.alGetError();
        if (alGetError != 0) {
            OpenALException openALException2 = openALException;
            OpenALException openALException3 = new OpenALException(alGetError);
            throw openALException2;
        }
    }
}

package org.lwjgl.test.openal;

import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.AL11;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;
import org.lwjgl.openal.C0758AL;
import org.lwjgl.openal.EFX10;
import org.lwjgl.openal.EFXUtil;
import org.lwjgl.util.WaveData;

public final class EFX10Test {
    public EFX10Test() {
    }

    private static void efxUtilTest() throws Exception {
        setupEfx();
        System.out.println();
        System.out.println("Checking supported effects ...");
        if (EFXUtil.isEffectSupported(0)) {
            System.out.println("AL_EFFECT_NULL is supported.");
        } else {
            System.out.println("AL_EFFECT_NULL is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(32768)) {
            System.out.println("AL_EFFECT_EAXREVERB is supported.");
        } else {
            System.out.println("AL_EFFECT_EAXREVERB is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(1)) {
            System.out.println("AL_EFFECT_REVERB is supported.");
        } else {
            System.out.println("AL_EFFECT_REVERB is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(2)) {
            System.out.println("AL_EFFECT_CHORUS is supported.");
        } else {
            System.out.println("AL_EFFECT_CHORUS is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(3)) {
            System.out.println("AL_EFFECT_DISTORTION is supported.");
        } else {
            System.out.println("AL_EFFECT_DISTORTION is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(4)) {
            System.out.println("AL_EFFECT_ECHO is supported.");
        } else {
            System.out.println("AL_EFFECT_ECHO is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(5)) {
            System.out.println("AL_EFFECT_FLANGER is supported.");
        } else {
            System.out.println("AL_EFFECT_FLANGER is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(6)) {
            System.out.println("AL_EFFECT_FREQUENCY_SHIFTER is supported.");
        } else {
            System.out.println("AL_EFFECT_FREQUENCY_SHIFTER is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(7)) {
            System.out.println("AL_EFFECT_VOCAL_MORPHER is supported.");
        } else {
            System.out.println("AL_EFFECT_VOCAL_MORPHER is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(8)) {
            System.out.println("AL_EFFECT_PITCH_SHIFTER is supported.");
        } else {
            System.out.println("AL_EFFECT_PITCH_SHIFTER is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(9)) {
            System.out.println("AL_EFFECT_RING_MODULATOR is supported.");
        } else {
            System.out.println("AL_EFFECT_RING_MODULATOR is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(10)) {
            System.out.println("AL_EFFECT_AUTOWAH is supported.");
        } else {
            System.out.println("AL_EFFECT_AUTOWAH is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(11)) {
            System.out.println("AL_EFFECT_COMPRESSOR is supported.");
        } else {
            System.out.println("AL_EFFECT_COMPRESSOR is NOT supported.");
        }
        if (EFXUtil.isEffectSupported(12)) {
            System.out.println("AL_EFFECT_EQUALIZER is supported.");
        } else {
            System.out.println("AL_EFFECT_EQUALIZER is NOT supported.");
        }
        System.out.println();
        System.out.println("Checking supported filters ...");
        if (EFXUtil.isFilterSupported(0)) {
            System.out.println("AL_FILTER_NULL is supported.");
        } else {
            System.out.println("AL_FILTER_NULL is NOT supported.");
        }
        if (EFXUtil.isFilterSupported(1)) {
            System.out.println("AL_FILTER_LOWPASS is supported.");
        } else {
            System.out.println("AL_FILTER_LOWPASS is NOT supported.");
        }
        if (EFXUtil.isFilterSupported(2)) {
            System.out.println("AL_FILTER_HIGHPASS is supported.");
        } else {
            System.out.println("AL_FILTER_HIGHPASS is NOT supported.");
        }
        if (EFXUtil.isFilterSupported(3)) {
            System.out.println("AL_FILTER_BANDPASS is supported.");
        } else {
            System.out.println("AL_FILTER_BANDPASS is NOT supported.");
        }
    }

    public static void main(String[] strArr) throws Exception {
        silentTests();
        playbackTest();
        efxUtilTest();
    }

    private static void playbackTest() throws Exception {
        setupEfx();
        int alGenSources = AL10.alGenSources();
        int alGenBuffers = AL10.alGenBuffers();
        WaveData create = WaveData.create("Footsteps.wav");
        if (create == null) {
            System.out.println("Failed to load Footsteps.wav! Skipping playback test.");
            C0758AL.destroy();
            return;
        }
        AL10.alBufferData(alGenBuffers, create.format, create.data, create.samplerate);
        create.dispose();
        AL10.alSourcei(alGenSources, 4105, alGenBuffers);
        AL10.alSourcei(alGenSources, 4103, 1);
        System.out.println("Playing sound unaffected by EFX ...");
        AL10.alSourcePlay(alGenSources);
        Thread.sleep(7500);
        int alGenAuxiliaryEffectSlots = EFX10.alGenAuxiliaryEffectSlots();
        int alGenEffects = EFX10.alGenEffects();
        EFX10.alEffecti(alGenEffects, 32769, 1);
        EFX10.alEffectf(alGenEffects, 5, 5.0f);
        EFX10.alAuxiliaryEffectSloti(alGenAuxiliaryEffectSlots, 1, alGenEffects);
        AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, alGenAuxiliaryEffectSlots, 0, 0);
        System.out.println("Playing sound with reverb ...");
        AL10.alSourcePlay(alGenSources);
        Thread.sleep(7500);
        int alGenFilters = EFX10.alGenFilters();
        EFX10.alFilteri(alGenFilters, 32769, 1);
        EFX10.alFilterf(alGenFilters, 1, 0.5f);
        EFX10.alFilterf(alGenFilters, 2, 0.5f);
        AL10.alSourcei(alGenSources, EFX10.AL_DIRECT_FILTER, alGenFilters);
        System.out.println("Playing sound with reverb and direct low pass filter ...");
        AL10.alSourcePlay(alGenSources);
        Thread.sleep(7500);
        AL10.alSourcei(alGenSources, EFX10.AL_DIRECT_FILTER, 0);
        AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, 0, 0, 0);
        EFX10.alAuxiliaryEffectSloti(alGenAuxiliaryEffectSlots, 1, 0);
        EFX10.alDeleteEffects(alGenEffects);
        EFX10.alDeleteFilters(alGenFilters);
        int alGenEffects2 = EFX10.alGenEffects();
        EFX10.alEffecti(alGenEffects2, 32769, 4);
        EFX10.alAuxiliaryEffectSloti(alGenAuxiliaryEffectSlots, 1, alGenEffects2);
        AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, alGenAuxiliaryEffectSlots, 0, 0);
        System.out.println("Playing sound with echo effect ...");
        AL10.alSourcePlay(alGenSources);
        Thread.sleep(7500);
        C0758AL.destroy();
    }

    private static void setupEfx() throws Exception {
        Exception exc;
        if (!C0758AL.isCreated()) {
            C0758AL.create();
        }
        if (!ALC10.alcIsExtensionPresent(C0758AL.getDevice(), EFX10.ALC_EXT_EFX_NAME)) {
            Exception exc2 = exc;
            Exception exc3 = new Exception("No ALC_EXT_EFX supported by driver.");
            throw exc2;
        }
        System.out.println("ALC_EXT_EFX found.");
    }

    private static void silentTests() throws Exception {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        Exception exc;
        Exception exc2;
        Exception exc3;
        Exception exc4;
        Exception exc5;
        Exception exc6;
        Exception exc7;
        Exception exc8;
        Exception exc9;
        Exception exc10;
        setupEfx();
        ALCdevice device = C0758AL.getDevice();
        IntBuffer createIntBuffer = BufferUtils.createIntBuffer(8);
        IntBuffer put = createIntBuffer.put(4103);
        IntBuffer put2 = createIntBuffer.put(44100);
        IntBuffer put3 = createIntBuffer.put(4104);
        IntBuffer put4 = createIntBuffer.put(60);
        IntBuffer put5 = createIntBuffer.put(4105);
        IntBuffer put6 = createIntBuffer.put(0);
        Buffer rewind = createIntBuffer.rewind();
        IntBuffer put7 = createIntBuffer.put(EFX10.ALC_MAX_AUXILIARY_SENDS);
        IntBuffer put8 = createIntBuffer.put(2);
        ALCcontext alcCreateContext = ALC10.alcCreateContext(device, createIntBuffer);
        if (alcCreateContext == null) {
            Exception exc11 = exc10;
            Exception exc12 = new Exception("Failed to create context.");
            throw exc11;
        } else if (ALC10.alcMakeContextCurrent(alcCreateContext) == 0) {
            Exception exc13 = exc9;
            Exception exc14 = new Exception("Failed to make context current.");
            throw exc13;
        } else {
            PrintStream printStream = System.out;
            StringBuilder sb7 = sb;
            StringBuilder sb8 = new StringBuilder();
            printStream.println(sb7.append("AL_VERSION: ").append(AL10.alGetString(AL10.AL_VERSION)).toString());
            IntBuffer createIntBuffer2 = BufferUtils.createIntBuffer(1);
            ALC10.alcGetInteger(device, EFX10.ALC_EFX_MAJOR_VERSION, createIntBuffer2);
            PrintStream printStream2 = System.out;
            StringBuilder sb9 = sb2;
            StringBuilder sb10 = new StringBuilder();
            printStream2.println(sb9.append("ALC_EFX_MAJOR_VERSION: ").append(createIntBuffer2.get(0)).toString());
            ALC10.alcGetInteger(device, EFX10.ALC_EFX_MINOR_VERSION, createIntBuffer2);
            PrintStream printStream3 = System.out;
            StringBuilder sb11 = sb3;
            StringBuilder sb12 = new StringBuilder();
            printStream3.println(sb11.append("ALC_EFX_MINOR_VERSION: ").append(createIntBuffer2.get(0)).toString());
            ALC10.alcGetInteger(device, EFX10.ALC_MAX_AUXILIARY_SENDS, createIntBuffer2);
            int i = createIntBuffer2.get(0);
            PrintStream printStream4 = System.out;
            StringBuilder sb13 = sb4;
            StringBuilder sb14 = new StringBuilder();
            printStream4.println(sb13.append("ALC_MAX_AUXILIARY_SENDS: ").append(i).toString());
            int[] iArr = new int[4];
            int alGetError = AL10.alGetError();
            int i2 = 0;
            while (i2 < 4) {
                iArr[i2] = EFX10.alGenAuxiliaryEffectSlots();
                if (AL10.alGetError() != 0) {
                    break;
                }
                i2++;
            }
            PrintStream printStream5 = System.out;
            StringBuilder sb15 = sb5;
            StringBuilder sb16 = new StringBuilder();
            printStream5.println(sb15.append("Created ").append(i2).append(" aux effect slots.").toString());
            int[] iArr2 = new int[2];
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = EFX10.alGenEffects();
                if (AL10.alGetError() != 0) {
                    break;
                }
                i3++;
            }
            PrintStream printStream6 = System.out;
            StringBuilder sb17 = sb6;
            StringBuilder sb18 = new StringBuilder();
            printStream6.println(sb17.append("Created ").append(i3).append(" effects.").toString());
            int alGetError2 = AL10.alGetError();
            if (EFX10.alIsEffect(iArr2[0])) {
                EFX10.alEffecti(iArr2[0], 32769, 1);
                if (AL10.alGetError() != 0) {
                    System.out.println("Reverb effect not supported.");
                } else {
                    EFX10.alEffectf(iArr2[0], 5, 5.0f);
                    System.out.println("Reverb effect created.");
                }
                int alGetError3 = AL10.alGetError();
                if (EFX10.alIsEffect(iArr2[1])) {
                    EFX10.alEffecti(iArr2[1], 32769, 5);
                    if (AL10.alGetError() != 0) {
                        System.out.println("Flanger effect not support.");
                    } else {
                        EFX10.alEffecti(iArr2[1], 2, 180);
                        System.out.println("Flanger effect created.");
                    }
                    int alGetError4 = AL10.alGetError();
                    int alGenFilters = EFX10.alGenFilters();
                    if (AL10.alGetError() != 0) {
                        Exception exc15 = exc8;
                        Exception exc16 = new Exception("Failed to create filter.");
                        throw exc15;
                    }
                    System.out.println("Generated a filter.");
                    if (EFX10.alIsFilter(alGenFilters)) {
                        EFX10.alFilteri(alGenFilters, 32769, 1);
                        if (AL10.alGetError() != 0) {
                            System.out.println("Low pass filter not supported.");
                        } else {
                            EFX10.alFilterf(alGenFilters, 1, 0.5f);
                            EFX10.alFilterf(alGenFilters, 2, 0.5f);
                            System.out.println("Low pass filter created.");
                        }
                    }
                    int alGetError5 = AL10.alGetError();
                    EFX10.alAuxiliaryEffectSloti(iArr[0], 1, iArr2[0]);
                    if (AL10.alGetError() != 0) {
                        Exception exc17 = exc7;
                        Exception exc18 = new Exception("Failed to attach effect to aux effect slot.");
                        throw exc17;
                    }
                    System.out.println("Successfully loaded effect into effect slot.");
                    int alGenSources = AL10.alGenSources();
                    AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, iArr[0], 0, 0);
                    if (AL10.alGetError() != 0) {
                        Exception exc19 = exc6;
                        Exception exc20 = new Exception("Failed to configure Source Send 0");
                        throw exc19;
                    }
                    System.out.println("Linked aux effect slot to soutce slot 0");
                    AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, iArr[1], 1, alGenFilters);
                    if (AL10.alGetError() != 0) {
                        Exception exc21 = exc5;
                        Exception exc22 = new Exception("Failed to configure Source Send 1");
                        throw exc21;
                    }
                    System.out.println("Linked aux effect slot to soutce slot 1");
                    AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, 0, 0, 0);
                    if (AL10.alGetError() != 0) {
                        Exception exc23 = exc4;
                        Exception exc24 = new Exception("Failed to disable Source Send 0");
                        throw exc23;
                    }
                    System.out.println("Disabled source send 0");
                    AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, 0, 1, 0);
                    if (AL10.alGetError() != 0) {
                        Exception exc25 = exc3;
                        Exception exc26 = new Exception("Failed to disable Source Send 1");
                        throw exc25;
                    }
                    System.out.println("Disabled source send 1");
                    AL10.alSourcei(alGenSources, EFX10.AL_DIRECT_FILTER, alGenFilters);
                    if (AL10.alGetError() == 0) {
                        System.out.println("Successfully applied a direct path filter");
                        AL10.alSourcei(alGenSources, EFX10.AL_DIRECT_FILTER, 0);
                        if (AL10.alGetError() == 0) {
                            System.out.println("Successfully removed direct filter");
                        }
                        AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, iArr[0], 0, alGenFilters);
                        if (AL10.alGetError() == 0) {
                            System.out.println("Successfully applied aux send filter");
                            AL11.alSource3i(alGenSources, EFX10.AL_AUXILIARY_SEND_FILTER, iArr[0], 0, 0);
                            if (AL10.alGetError() == 0) {
                                System.out.println("Successfully removed filter");
                            }
                        }
                    }
                    AL10.alSourcef(alGenSources, EFX10.AL_CONE_OUTER_GAINHF, 0.5f);
                    if (AL10.alGetError() == 0) {
                        System.out.println("Successfully set cone outside gain filter");
                    }
                    AL10.alListenerf(EFX10.AL_METERS_PER_UNIT, 0.3f);
                    if (AL10.alGetError() == 0) {
                        System.out.println("Successfully set distance units");
                    }
                    EFX10.alDeleteAuxiliaryEffectSlots((IntBuffer) BufferUtils.createIntBuffer(iArr.length).put(iArr).rewind());
                    EFX10.alDeleteEffects((IntBuffer) BufferUtils.createIntBuffer(iArr2.length).put(iArr2).rewind());
                    EFX10.alDeleteFilters(alGenFilters);
                    C0758AL.destroy();
                    return;
                }
                Exception exc27 = exc2;
                Exception exc28 = new Exception("Second effect not a valid effect.");
                throw exc27;
            }
            Exception exc29 = exc;
            Exception exc30 = new Exception("First effect not a valid effect.");
            throw exc29;
        }
    }
}

package org.lwjgl.opencl;

import java.nio.IntBuffer;
import java.util.List;
import org.lwjgl.LWJGLException;
import org.lwjgl.opencl.api.CLImageFormat;
import org.lwjgl.opencl.api.Filter;
import org.lwjgl.opengl.Drawable;

public final class CLContext extends CLObjectChild<CLPlatform> {
    private static final CLContextUtil util = ((CLContextUtil) CLPlatform.getInfoUtilInstance(CLContext.class, "CL_CONTEXT_UTIL"));
    private final CLObjectRegistry<CLCommandQueue> clCommandQueues;
    private final CLObjectRegistry<CLEvent> clEvents;
    private final CLObjectRegistry<CLMem> clMems;
    private final CLObjectRegistry<CLProgram> clPrograms;
    private final CLObjectRegistry<CLSampler> clSamplers;
    private long contextCallback;
    private long printfCallback;

    interface CLContextUtil extends InfoUtil<CLContext> {
        CLContext create(CLPlatform cLPlatform, List<CLDevice> list, CLContextCallback cLContextCallback, Drawable drawable, IntBuffer intBuffer) throws LWJGLException;

        CLContext createFromType(CLPlatform cLPlatform, long j, CLContextCallback cLContextCallback, Drawable drawable, IntBuffer intBuffer) throws LWJGLException;

        List<CLDevice> getInfoDevices(CLContext cLContext);

        List<CLImageFormat> getSupportedImageFormats(CLContext cLContext, long j, int i, Filter<CLImageFormat> filter);
    }

    CLContext(long j, CLPlatform cLPlatform) {
        CLObjectRegistry<CLCommandQueue> cLObjectRegistry;
        CLObjectRegistry<CLMem> cLObjectRegistry2;
        CLObjectRegistry<CLSampler> cLObjectRegistry3;
        CLObjectRegistry<CLProgram> cLObjectRegistry4;
        CLObjectRegistry<CLEvent> cLObjectRegistry5;
        super(j, cLPlatform);
        if (isValid()) {
            CLObjectRegistry<CLCommandQueue> cLObjectRegistry6 = cLObjectRegistry;
            CLObjectRegistry<CLCommandQueue> cLObjectRegistry7 = new CLObjectRegistry<>();
            this.clCommandQueues = cLObjectRegistry6;
            CLObjectRegistry<CLMem> cLObjectRegistry8 = cLObjectRegistry2;
            CLObjectRegistry<CLMem> cLObjectRegistry9 = new CLObjectRegistry<>();
            this.clMems = cLObjectRegistry8;
            CLObjectRegistry<CLSampler> cLObjectRegistry10 = cLObjectRegistry3;
            CLObjectRegistry<CLSampler> cLObjectRegistry11 = new CLObjectRegistry<>();
            this.clSamplers = cLObjectRegistry10;
            CLObjectRegistry<CLProgram> cLObjectRegistry12 = cLObjectRegistry4;
            CLObjectRegistry<CLProgram> cLObjectRegistry13 = new CLObjectRegistry<>();
            this.clPrograms = cLObjectRegistry12;
            CLObjectRegistry<CLEvent> cLObjectRegistry14 = cLObjectRegistry5;
            CLObjectRegistry<CLEvent> cLObjectRegistry15 = new CLObjectRegistry<>();
            this.clEvents = cLObjectRegistry14;
            return;
        }
        this.clCommandQueues = null;
        this.clMems = null;
        this.clSamplers = null;
        this.clPrograms = null;
        this.clEvents = null;
    }

    private boolean checkCallback(long j, int i) {
        long j2 = j;
        if (i == 0 && (j2 == 0 || isValid())) {
            return true;
        }
        if (j2 != 0) {
            CallbackUtil.deleteGlobalRef(j2);
        }
        return false;
    }

    public static CLContext create(CLPlatform cLPlatform, List<CLDevice> list, IntBuffer intBuffer) throws LWJGLException {
        return create(cLPlatform, list, null, null, intBuffer);
    }

    public static CLContext create(CLPlatform cLPlatform, List<CLDevice> list, CLContextCallback cLContextCallback, IntBuffer intBuffer) throws LWJGLException {
        return create(cLPlatform, list, cLContextCallback, null, intBuffer);
    }

    public static CLContext create(CLPlatform cLPlatform, List<CLDevice> list, CLContextCallback cLContextCallback, Drawable drawable, IntBuffer intBuffer) throws LWJGLException {
        return util.create(cLPlatform, list, cLContextCallback, drawable, intBuffer);
    }

    public static CLContext createFromType(CLPlatform cLPlatform, long j, IntBuffer intBuffer) throws LWJGLException {
        return util.createFromType(cLPlatform, j, null, null, intBuffer);
    }

    public static CLContext createFromType(CLPlatform cLPlatform, long j, CLContextCallback cLContextCallback, IntBuffer intBuffer) throws LWJGLException {
        return util.createFromType(cLPlatform, j, cLContextCallback, null, intBuffer);
    }

    public static CLContext createFromType(CLPlatform cLPlatform, long j, CLContextCallback cLContextCallback, Drawable drawable, IntBuffer intBuffer) throws LWJGLException {
        return util.createFromType(cLPlatform, j, cLContextCallback, drawable, intBuffer);
    }

    public CLCommandQueue getCLCommandQueue(long j) {
        return (CLCommandQueue) this.clCommandQueues.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLCommandQueue> getCLCommandQueueRegistry() {
        return this.clCommandQueues;
    }

    public CLEvent getCLEvent(long j) {
        return (CLEvent) this.clEvents.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLEvent> getCLEventRegistry() {
        return this.clEvents;
    }

    public CLMem getCLMem(long j) {
        return (CLMem) this.clMems.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLMem> getCLMemRegistry() {
        return this.clMems;
    }

    public CLProgram getCLProgram(long j) {
        return (CLProgram) this.clPrograms.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLProgram> getCLProgramRegistry() {
        return this.clPrograms;
    }

    public CLSampler getCLSampler(long j) {
        return (CLSampler) this.clSamplers.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLSampler> getCLSamplerRegistry() {
        return this.clSamplers;
    }

    public List<CLDevice> getInfoDevices() {
        return util.getInfoDevices(this);
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    public List<CLImageFormat> getSupportedImageFormats(long j, int i) {
        return getSupportedImageFormats(j, i, null);
    }

    public List<CLImageFormat> getSupportedImageFormats(long j, int i, Filter<CLImageFormat> filter) {
        return util.getSupportedImageFormats(this, j, i, filter);
    }

    /* access modifiers changed from: 0000 */
    public void releaseImpl() {
        if (release() <= 0) {
            if (this.contextCallback != 0) {
                CallbackUtil.deleteGlobalRef(this.contextCallback);
            }
            if (this.printfCallback != 0) {
                CallbackUtil.deleteGlobalRef(this.printfCallback);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setContextCallback(long j) {
        long j2 = j;
        if (checkCallback(j2, 0)) {
            this.contextCallback = j2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void setPrintfCallback(long j, int i) {
        long j2 = j;
        if (checkCallback(j2, i)) {
            this.printfCallback = j2;
        }
    }
}

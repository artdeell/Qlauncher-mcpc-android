package org.lwjgl.opencl;

import org.lwjgl.PointerBuffer;

public final class CLDevice extends CLObjectChild<CLDevice> {
    private static final InfoUtil<CLDevice> util = CLPlatform.getInfoUtilInstance(CLDevice.class, "CL_DEVICE_UTIL");
    private Object caps;
    private final CLPlatform platform;
    private final CLObjectRegistry<CLDevice> subCLDevices;

    CLDevice(long j, CLDevice cLDevice) {
        CLDevice cLDevice2 = cLDevice;
        this(j, cLDevice2, cLDevice2.getPlatform());
    }

    CLDevice(long j, CLDevice cLDevice, CLPlatform cLPlatform) {
        CLObjectRegistry<CLDevice> cLObjectRegistry;
        CLDevice cLDevice2 = cLDevice;
        CLPlatform cLPlatform2 = cLPlatform;
        super(j, cLDevice2);
        if (isValid()) {
            this.platform = cLPlatform2;
            cLPlatform2.getCLDeviceRegistry().registerObject(this);
            CLObjectRegistry<CLDevice> cLObjectRegistry2 = cLObjectRegistry;
            CLObjectRegistry<CLDevice> cLObjectRegistry3 = new CLObjectRegistry<>();
            this.subCLDevices = cLObjectRegistry2;
            if (cLDevice2 != null) {
                cLDevice2.subCLDevices.registerObject(this);
                return;
            }
            return;
        }
        this.platform = null;
        this.subCLDevices = null;
    }

    CLDevice(long j, CLPlatform cLPlatform) {
        this(j, null, cLPlatform);
    }

    /* access modifiers changed from: 0000 */
    public Object getCapabilities() {
        return this.caps;
    }

    public boolean getInfoBoolean(int i) {
        return util.getInfoInt(this, i) != 0;
    }

    public int getInfoInt(int i) {
        return util.getInfoInt(this, i);
    }

    public long getInfoLong(int i) {
        return util.getInfoLong(this, i);
    }

    public long getInfoSize(int i) {
        return util.getInfoSize(this, i);
    }

    public long[] getInfoSizeArray(int i) {
        return util.getInfoSizeArray(this, i);
    }

    public String getInfoString(int i) {
        return util.getInfoString(this, i);
    }

    public CLPlatform getPlatform() {
        return this.platform;
    }

    public CLDevice getSubCLDevice(long j) {
        return (CLDevice) this.subCLDevices.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLDevice> getSubCLDeviceRegistry() {
        return this.subCLDevices;
    }

    /* access modifiers changed from: 0000 */
    public void registerSubCLDevices(PointerBuffer pointerBuffer) {
        CLDevice cLDevice;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        for (int position = pointerBuffer2.position(); position < pointerBuffer2.limit(); position++) {
            long j = pointerBuffer2.get(position);
            if (j != 0) {
                CLDevice cLDevice2 = cLDevice;
                CLDevice cLDevice3 = new CLDevice(j, this);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public int release() {
        if (getParent() == null) {
            return getReferenceCount();
        }
        try {
            int release = super.release();
            if (!isValid()) {
                ((CLDevice) getParent()).subCLDevices.unregisterObject(this);
            }
            return release;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!isValid()) {
                ((CLDevice) getParent()).subCLDevices.unregisterObject(this);
            }
            throw th2;
        }
    }

    /* access modifiers changed from: 0000 */
    public int retain() {
        return getParent() == null ? getReferenceCount() : super.retain();
    }

    /* access modifiers changed from: 0000 */
    public void setCapabilities(Object obj) {
        Object obj2 = obj;
        this.caps = obj2;
    }
}

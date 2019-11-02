package org.lwjgl.opencl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.api.Filter;

public final class CLPlatform extends CLObject {
    private static final FastLongMap<CLPlatform> clPlatforms;
    private static final CLPlatformUtil util = ((CLPlatformUtil) getInfoUtilInstance(CLPlatform.class, "CL_PLATFORM_UTIL"));
    private Object caps;
    private final CLObjectRegistry<CLDevice> clDevices;

    interface CLPlatformUtil extends InfoUtil<CLPlatform> {
        List<CLDevice> getDevices(CLPlatform cLPlatform, int i, Filter<CLDevice> filter);

        List<CLPlatform> getPlatforms(Filter<CLPlatform> filter);
    }

    static {
        FastLongMap<CLPlatform> fastLongMap;
        FastLongMap<CLPlatform> fastLongMap2 = fastLongMap;
        FastLongMap<CLPlatform> fastLongMap3 = new FastLongMap<>();
        clPlatforms = fastLongMap2;
    }

    CLPlatform(long j) {
        CLObjectRegistry<CLDevice> cLObjectRegistry;
        long j2 = j;
        super(j2);
        if (isValid()) {
            Object put = clPlatforms.put(j2, this);
            CLObjectRegistry<CLDevice> cLObjectRegistry2 = cLObjectRegistry;
            CLObjectRegistry<CLDevice> cLObjectRegistry3 = new CLObjectRegistry<>();
            this.clDevices = cLObjectRegistry2;
            return;
        }
        this.clDevices = null;
    }

    public static CLPlatform getCLPlatform(long j) {
        return (CLPlatform) clPlatforms.get(j);
    }

    static <T extends CLObject> InfoUtil<T> getInfoUtilInstance(Class<T> cls, String str) {
        Class<T> cls2 = cls;
        try {
            return (InfoUtil) Class.forName("org.lwjgl.opencl.InfoUtilFactory").getDeclaredField(str).get(null);
        } catch (Exception e) {
            Exception exc = e;
            return null;
        }
    }

    public static List<CLPlatform> getPlatforms() {
        return getPlatforms(null);
    }

    public static List<CLPlatform> getPlatforms(Filter<CLPlatform> filter) {
        return util.getPlatforms(filter);
    }

    static void registerCLPlatforms(PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        CLPlatform cLPlatform;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        if (pointerBuffer2 != null) {
            int position = pointerBuffer2.position();
            int min = Math.min(intBuffer2.get(0), pointerBuffer2.remaining());
            for (int i = 0; i < min; i++) {
                long j = pointerBuffer2.get(position + i);
                if (!clPlatforms.containsKey(j)) {
                    CLPlatform cLPlatform2 = cLPlatform;
                    CLPlatform cLPlatform3 = new CLPlatform(j);
                }
            }
        }
    }

    public CLDevice getCLDevice(long j) {
        return (CLDevice) this.clDevices.getObject(j);
    }

    /* access modifiers changed from: 0000 */
    public CLObjectRegistry<CLDevice> getCLDeviceRegistry() {
        return this.clDevices;
    }

    /* access modifiers changed from: 0000 */
    public Object getCapabilities() {
        return this.caps;
    }

    public List<CLDevice> getDevices(int i) {
        return getDevices(i, null);
    }

    public List<CLDevice> getDevices(int i, Filter<CLDevice> filter) {
        return util.getDevices(this, i, filter);
    }

    public String getInfoString(int i) {
        return util.getInfoString(this, i);
    }

    /* access modifiers changed from: 0000 */
    public void registerCLDevices(ByteBuffer byteBuffer, PointerBuffer pointerBuffer) {
        CLDevice cLDevice;
        ByteBuffer byteBuffer2 = byteBuffer;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        int position = byteBuffer2.position();
        int min = Math.min((int) pointerBuffer2.get(pointerBuffer2.position()), byteBuffer2.remaining()) / PointerBuffer.getPointerSize();
        for (int i = 0; i < min; i++) {
            int pointerSize = position + (i * PointerBuffer.getPointerSize());
            long j = PointerBuffer.is64Bit() ? byteBuffer2.getLong(pointerSize) : (long) byteBuffer2.getInt(pointerSize);
            if (!this.clDevices.hasObject(j)) {
                CLDevice cLDevice2 = cLDevice;
                CLDevice cLDevice3 = new CLDevice(j, this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void registerCLDevices(PointerBuffer pointerBuffer, IntBuffer intBuffer) {
        CLDevice cLDevice;
        PointerBuffer pointerBuffer2 = pointerBuffer;
        IntBuffer intBuffer2 = intBuffer;
        int position = pointerBuffer2.position();
        int min = Math.min(intBuffer2.get(intBuffer2.position()), pointerBuffer2.remaining());
        for (int i = 0; i < min; i++) {
            long j = pointerBuffer2.get(position + i);
            if (!this.clDevices.hasObject(j)) {
                CLDevice cLDevice2 = cLDevice;
                CLDevice cLDevice3 = new CLDevice(j, this);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setCapabilities(Object obj) {
        Object obj2 = obj;
        this.caps = obj2;
    }
}
